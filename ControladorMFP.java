import java.util.*;

public class ControladorMFP {
	private MFP alg;
	private Entrada e;
	private Salida s;
	private Recorrido r;
	private FuncionesCoste fc;
	private boolean FuncionElegida;
	private boolean AlgoritmoElegido;
	private Iterator<Integer> itCB;
	private Iterator<String> itF;
	private Iterator<String> itC;
	
	//CREADORA
	public ControladorMFP()
	{
            FuncionElegida = false;
            AlgoritmoElegido = false;
            s = new Salida();
	}
	
	public void AnadirEntrada(Entrada e1)
	{
            e = e1;
	}
	
	//Seleccion/Ejecucion del algoritmo
	public void SeleccionarAlgoritmo(int i, ControladorNave cn, ControladorRuta cr, ControladorPlaneta cp) throws Exception
	{
            if(!FuncionElegida) {
                throw new Exception("Error: Es necesario seleccionar una funcion de coste antes de elegir algoritmo");
            }
            if(i==1||i==2) {
                alg = new FordFulkerson(e);
                AlgoritmoElegido = true;
                if(i==1){
                        if(!(fc instanceof FuncionFlujo)){
                                throw new Exception("Error: Ford Fulkerson bfs se ejecuta para función de coste: Flujo");
                        }
                        r = new BFS();
                }
                else if(i==2) {
                        if(fc instanceof FuncionFlujo){
                                throw new Exception("Error: Ford Fulkerson dijkstra se ejecuta para funciones de coste: Distancia, Precio");
                        }
                        r = new Dijkstra();
                }
            }
            if(i==3) {
                alg = new PushRelabel(e);
                AlgoritmoElegido = true;
            }
	}
        
    public Grafo consultarGrafoResidual()
    {
        return alg.g_residual;
    }
	
	public void Executa(ControladorNave cn, ControladorRuta cr, ControladorPlaneta cp) throws Exception 
	{   
            if(!AlgoritmoElegido) throw new Exception("Error: Es necesario seleccionar un algoritmo antes de ejecutarlo");
            if(!FuncionElegida) throw new Exception("Error: Es necesario seleccionar una funcion de coste antes de elegir algoritmo");

            s.EliminarCambios();
            s.EliminarCaminos();
            s.EliminarCuellos();

            alg.Ejecutar(r, s);
            
            if(fc instanceof FuncionPrecio || fc instanceof FuncionDistancia) r = new Dijkstra(); // en caso de coste hacer que el recorrido sea un DIJKSTRA
            else r = new BFS();
            
            ArrayList<String> pla = cp.consultarPlanetas();

            Grafo g_res = alg.consultaResidual();
            
            ArrayList<Pair<Integer,Pair<String,String>>> paor = cn.consultaPAOR();

            ArrayList<Conexion> con = cr.Consultar_Conexiones();

            int tam = g_res.sizeGrafo();
            
            if(alg instanceof FordFulkerson) transformaSalida(pla,tam);
            if(alg instanceof PushRelabel) SalidaParcialPushRelabel(pla, tam);
            
            String way = "";
            String parcial = "";
            //int a[] = new int[tam+1];
            boolean hay_final = false;
            boolean ha [] = new boolean[1];
            
            for(int in = 0; in < paor.size(); ++in) {
                String orig = paor.get(in).consultarSegundo().consultarPrimero();
                String dest = paor.get(in).consultarSegundo().consultarSegundo();
                int naves = paor.get(in).consultarPrimero();
                int a[] = s.Caminos(g_res,naves, orig, dest,r, pla, ha);
                if(ha[0]) hay_final = true;
                while(a[tam] != 0 && paor.get(in).consultarPrimero() > 0) { // mientras haya naves disponibles y capacidad
                    int num = paor.get(in).consultarPrimero();
                    int n_final = num;
                    if(a[tam] > num) paor.get(in).ponPrimero(0); // tenemos mas capacidad que naves, pasan todas
                    else { // tenemos mas naves que capacidad, sobran algunas
                        num = num - a[tam];
                        n_final = a[tam];
                        paor.get(in).ponPrimero(num);
                    }
                    // restar la capacidad del camino + consultar si capacidad es 0 = cuello de botella
                    int o1 = pla.indexOf(orig);
                    int d1 = pla.indexOf(dest);
                    int v, u;
                    way += "Por el camino ";
                    parcial += d1;
                    for(v = d1; v != o1; v = a[v]) {
                        u = a[v];
                        parcial += "<=" + u;
                    }
                    parcial = toPlanetes(parcial,pla);
                    way += parcial +  " pasan " + n_final + " nave/s";
                    s.AnadirCamino(way);
                    parcial = "";
                    way = "";
                    int naus = paor.get(in).consultarPrimero();
                    a = s.Caminos(g_res, naus, orig, dest, r, pla, ha);
                    if(ha[0]) hay_final = true;
                }
            }
            
            boolean alguno = false;
            for(int j = 0; j < paor.size(); ++j) {
                if(paor.get(j).consultarPrimero() > 0) {
                    alguno = true;
                    break;
                }
            }	
            // calcular los cuellos de botella si queda alguna nave
            if(alguno && hay_final) {
                int V = g_res.sizeGrafo();
                int origen = V-2;

                boolean[] visitados = new boolean[V];
                Arrays.fill(visitados,false);
                visitados[origen] = true;

                Queue<Integer> q1 = new LinkedList<Integer>();
                q1.add(origen);
                
                while(!q1.isEmpty()) {
                    int actual = q1.poll();
                    int size = g_res.sizeGrafo(actual);
                    for(int i = 0; i < size; ++i) {
                        int adj = g_res.consultarSeg(actual, i);
                        int cap = g_res.consultarPrim(actual, i).ConsultarCapacidad();
                        if(cap > 0 && !visitados[adj]) {
                            visitados[adj] = true;
                            q1.add(adj);
                        }
                        else if(cap == 0 && !visitados[adj]) {
                            visitados[adj] = true;
                            q1.add(adj);
                            if((actual != V-2) && (actual != V-1) && (adj != V-2) && (adj != V-1)) {
                                String pa = pla.get(actual);
                                String pb = pla.get(adj);
                                int idr = 0;
                                boolean trobat = false;
                                for(int k = 0; k < con.size() && !trobat; ++k) {
                                    if((con.get(k).consultar_planetaA().compareTo(pa) == 0) && (con.get(k).consultar_planetaB().compareTo(pb) == 0)) {
                                        trobat = true;
                                        idr = con.get(k).consultar_id();
                                    }
                                }
                                if(trobat) s.AnadirCuello(idr);
                            }
                        }
                    }
                }
            }
	}
	
	/**
	 * Metodo para transformar el camino de nodos a planetas
	 * @param res
	 * @param pl
	 * @return
	 */
	public String toPlanetes(String res, ArrayList<String> pl)
	{
        String planetes = "";
        Scanner sca = new Scanner(res);
        sca.useDelimiter("<=");
        String a;
        int pos;
        Stack<String> tmp = new Stack<String>();
        while(sca.hasNext()) {
            pos = Integer.parseInt(sca.next());
            a = pl.get(pos);
            tmp.add(a);
        }
        sca.close();
        while(tmp.size() > 1) {
            planetes += tmp.pop() + " => ";
        }
        planetes += tmp.pop();
        return planetes;
	}
	
	//Funciones de coste
	public void SeleccionarFC(int x, ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) throws Exception
	{
        if(x==1) fc = new FuncionFlujo();
        if(x==2) fc = new FuncionDistancia();
        if(x==3) fc = new FuncionPrecio();
        FuncionElegida = true;
        e = cg.transformaGrafo(cr,cp,cn,fc);
	}
	
//OPERACIONES SALIDA
	public void Inicializar1()
	{
            itF = (s.ConsultarCaminos()).iterator();
            itCB = (s.ConsultarCuellos()).iterator();
	}
	
	public void Inicializar2()
	{
        itC = (s.ConsultarCambios()).iterator();
	}
	
    public String aPlanetas(String res, ArrayList<String> pl, int tam)
    {
        String planetes = "";
        Scanner sca1 = new Scanner(res);
        sca1.useDelimiter("<=");
        String a;
        int pos;
        Stack<String> tmp = new Stack<String>();
        while(sca1.hasNext()) {
            pos = Integer.parseInt(sca1.next());
            if(pos == (tam-2)) a = "Origen Fantasma";
            else if(pos == (tam-1)) a = "Destino Fantasma";
            else a = pl.get(pos);
            tmp.add(a);
        }
        sca1.close();
        while(tmp.size() > 1) {
            planetes += tmp.pop() + " => ";
        }
        planetes += tmp.pop();
        return planetes;
    }
    
    public void SalidaParcialPushRelabel(ArrayList<String> pla, int tam) 
    {
        ArrayList<String> t = s.ConsultarCambios();
        ArrayList<String> f = new ArrayList<String>();
        for(int i = 0; i < t.size(); ++i) {
            String temp = t.get(i);
            temp = temp.replaceAll(String.valueOf(tam-1), "Destino Fantasma");
            temp = temp.replaceAll(String.valueOf(tam-2), "Origen Fantasma");
            for(int j = 0; j < tam-2; ++j) {
                temp = temp.replaceAll(String.valueOf(j), pla.get(j));
            }
            String temp1 = "Iteracion " + i + ":\n" + temp;
            f.add(temp1);
        }
        s.EliminarCambios();
        for(int h = 0; h < f.size(); ++h) {
            String New = f.get(h);
            s.AnadirCambio(New);
        }
    }
        
    public void transformaSalida(ArrayList<String> pl, int tam)
    {
        ArrayList<String> t = s.ConsultarCambios();
        ArrayList<String> f = new ArrayList<String>();
        for(int i = 0; i < t.size(); ++i) {
            String tmp = t.get(i);
            String tmp1 = aPlanetas(tmp,pl,tam);
            String al = "Iteracion " + i + ":\n" + tmp1;
            f.add(al);
        }
        s.EliminarCambios();
        for(int j = 0; j < f.size(); ++j) {
            String b = f.get(j);
            s.AnadirCambio(b);
        }
    }
	//Pre:cierto
	//Post: devuelve el numero de elementos que conforman la salida incluyendo numero de rutas, numero de cuellos de botella y el coste
	//Pre:cierto
	//Post: devuelve un string que contiene: flujos de cada ruta, los cuellos de botella y el coste
	public String ConsultarSalida(int i)
	{            
            String res = "";
            int j=0;
            if(i==0){
                Inicializar1();
                res += s.consultarAlgoritmo() + "\n";
                res += "Caminos disponibles:\n";
            }
            while(itF.hasNext() && j<100){
                String aux = itF.next();
                res += aux+"\n";
            }
            res += "Cuellos de botella en las rutas:\n";
            while(itCB.hasNext() && j<100){
                res += itCB.next()+"\n";
                ++j;
            }
            res += "Maximo flujo de naves = " + s.ConsultarMax_flow() + "\n";
            res += "Tiempo ejecucion del algoritmo = " + s.consultarTiempo() + " milisegundos\n";
            return res;
	}
	
	public int size()
	{
            return s.size();
	}
	
	public int sizeCambios()
	{
            return s.sizeCambios();
	}
        
	//Pre:cierto
	//Post:devuelve un string que contiene los cambios que se han ido produciendo en el grafo durante la ejecución del algoritmo.
	public String ConsultarCambios(int i)
	{
            String res = "";
            int j=0;
            if(i==0){
                Inicializar2();
                res += s.consultarAlgoritmo() + "\n";
                res += "Pasos realizados en el algoritmo:\n";
            }
            while(itC.hasNext() && j<100){
                res += itC.next()+"\n";
                ++j;
            }
            return res;
	}
}

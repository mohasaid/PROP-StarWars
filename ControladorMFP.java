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
			//alg.Ejecutar(r,s);
			//System.out.println("DESPUES DE EJECUTARLO, max flow = " + s.ConsultarMax_flow());
		}
		if(i==3) {
			alg = new PushRelabel(e);
			AlgoritmoElegido = true;
			//alg.Ejecutar(r, s);
		}
	}
	
	public void Executa(ControladorNave cn, ControladorRuta cr, ControladorPlaneta cp) throws Exception 
	{
		if(!AlgoritmoElegido) throw new Exception("Error: Es necesario seleccionar un algoritmo antes de ejecutarlo");
		if(!FuncionElegida) throw new Exception("Error: Es necesario seleccionar una funcion de coste antes de elegir algoritmo");
		
		alg.Ejecutar(r, s);
		
		r = new BFS();
		
		if(fc instanceof FuncionPrecio || fc instanceof FuncionDistancia) r = new Dijkstra(); // en caso de coste hacer que el recorrido sea un DIJKSTRA

		ArrayList<String> pla = cp.consultarPlanetas();
		
		Grafo g_res = alg.consultaResidual();
		
		ArrayList<Pair<Integer,Pair<String,String>>> paor = cn.consultaPAOR();
		ArrayList<Conexion> con = new ArrayList<Conexion>();
		
		int camino[] = new int[g_res.sizeGrafo()];
		String way = "";
		for(int in = 0; in < paor.size(); ++in) {
			int a = s.Caminos(g_res, paor.get(in).consultarSegundo().consultarPrimero(), paor.get(in).consultarSegundo().consultarSegundo(), (fc instanceof FuncionPrecio), r, pla,camino);
			while(a != 0) {
				int num = paor.get(in).consultarPrimero();
				if(num >= a) num = a;
				// restar el numero de naves, quitar las naves con origen y destino del arraylist aux
				paor.get(in).ponPrimero(num-a); // actualizo el numero de naves que quedan por pasar
				// restar la capacidad del camino + consultar si capacidad es 0 = cuello de botella
				int o1 = pla.indexOf(paor.get(in).consultarSegundo().consultarPrimero());
				int d1 = pla.indexOf(paor.get(in).consultarSegundo().consultarSegundo());
				int v, u;
				way += "Por el camino ";
				way += d1;
				for(v = d1; v != o1; v = camino[v]) {
					u = camino[v];
					way += "<=" + u;
					int cap = g_res.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad();
					cap = cap - num;
					// cuello de botella entre u-v
					if(cap == 0) {
						String a1 = pla.get(v);
						String a2 = pla.get(u);
						boolean trobat = false;
						int idr = 0;
						for(int k = 0; k < con.size() && !trobat; ++k) {
							if(((con.get(k).consultar_planetaA().compareTo(a2) == 0) && (con.get(k).consultar_planetaB().compareTo(a1) == 0))) {
								trobat = true;
								idr = con.get(k).consultar_id();
							}
						}
						if(trobat) s.AnadirCuello(idr);
					}
					g_res.consultaPairUn(u, v).consultarPrimero().ModificarCapacidad(cap);
				}
				way += " pueden pasar " + a + " naves";
				s.AnadirCamino(way);
				way = "";
				a = s.Caminos(g_res, paor.get(in).consultarSegundo().consultarPrimero(), paor.get(in).consultarSegundo().consultarSegundo(), (fc instanceof FuncionPrecio), r, pla,camino);
			}
		}
		// calcular los cuellos de botella
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
				else if(cap == 0) {
					if(actual != V-1 && actual != V-2) {
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
			res += "Camino que ha de recorrer cada nave:\n";
		}
		while(itF.hasNext() && j<100){
			String aux = itF.next();
			res += aux+"\n";
			if(!itF.hasNext() && itCB.hasNext()) res += "Cuellos de botella:\n";
		}
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
			res += "Pasos realizados en el algoritmo:\n";
		}
		while(itC.hasNext() && j<100){
			res += itC.next()+"\n";
			++j;
		}
		return res;
	}
}

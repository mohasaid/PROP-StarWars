import java.util.*;

public class ControladorMFP {
	private MFP alg;
	private Entrada e;
	private Salida s;
	private Recorrido r;
	private FuncionesCoste fc;
	private boolean FuncionElegida;
	private Iterator<Integer> itCB;
	private Iterator<String> itF;
	private Iterator<String> itC;
	
	//CREADORA
	public ControladorMFP()
	{
		FuncionElegida = false;
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
			alg.Ejecutar(r,s);
		}
		if(i==3) {
			alg = new PushRelabel(e);
			alg.Ejecutar(r, s);
		}
		//Calculo del camino de nada nave 
		ArrayList<Nave> aux = cn.CNaves();
		Iterator<Nave> it = aux.iterator();
		while(it.hasNext()){
			Nave n = it.next();
			int cons = cn.ConsultarConsumo(n.consultar_id());
			alg.Caminos(n,cons,(fc instanceof FuncionPrecio),r,cp,s);
		}
		//Calculo de los cuellos de botella
		alg.Calcular_cuellos_botellas(s,cp,cr);
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

import java.util.*;

public class ControladorMFP{
	private Entrada e;
	private MFP alg;
	private FuncionesCoste fc;
	private boolean FuncionElegida;
	private Iterator<Integer> itCB;
	private int coste;
	private Iterator<Pair<Arco,Integer>> itF;
	private Iterator<String> itC;
	//CREADORA
	public ControladorMFP(){
		e = new Entrada();
		FuncionElegida = false;
		
	}
	//Seleccion/Ejecucion del algoritmo
	public void SeleccionarAlgoritmo(int i) throws Exception{
		if(!FuncionElegida){
			throw new Exception("Error: Es necesario seleccionar una funcion de coste antes de elegir algoritmo");
		}
		if(i==1){
			alg = new FordFulkersonBFS(e);
			alg.Ejecutar();
		}
		if(i==2){
			alg = new FordFulkerson_Dijkstra(e);
			alg.Ejecutar();
		}
		if(i==3){
			//alg = new PushRelabel(e);
			//s = alg.Ejecutar();
		}
	}
	
	//Entrada
	public void InitEntrada(ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp) throws Exception{
		e = new Entrada(cg.convierteRutasYPlanetas(cr,cp));
	}
	//Funciones de coste
	public void SeleccionarFC(int i, ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp) throws Exception{
		if(i==1){
			fc = new FuncionFlujo();
			e = fc.Calcular(cg.convierteRutasYPlanetas(cr,cp),e);
		}
		if(i==2){
			fc = new FuncionDistancia();
			e = fc.Calcular(cg.convierteRutasYPlanetas(cr,cp),e);
		}
		if(i==3){
			fc = new FuncionPrecio();
			e = fc.Calcular(cg.convierteRutasYPlanetas(cr,cp),e);
		}
		FuncionElegida=true;
	}
/*
//OPERACIONES SALIDA
	//Pre:cierto
	//Post: devuelve el numero de elementos que conforman la salida incluyendo numero de rutas, numero de cuellos de botella y el coste
	//Pre:cierto
	//Post: devuelve un string que contiene: flujos de cada ruta, los cuellos de botella y el coste
	public String ConsultarSalida(int i){
		ArrayList<Integer> CuellosB = new ArrayList<Integer>();
		int coste = 0;
		ArrayList<Pair<Arco,Integer>> Flujos = new ArrayList<Pair<Arco,Integer>>();
		if(i==0){
			++i;
			//Inicializar1();
			ArrayList<Integer> CuellosB = alg.ConsultarCuellos();
			int coste = alg.ConsularCoste();
			ArrayList<Pair<Arco,Integer>> Flujos = alg.ConsultarFlujos();
		}
		//HACER
	}
	//Pre:cierto
	//Post:devuelve un string que contiene los cambios que se han ido produciendo en el grafo durante la ejecución del algoritmo.
	public String ConsultarCambios(int i){
		if(i==0){
			++i;
			//Inicializar2();
			ArrayList<String> Cambios = alg.ConsultarCambios();
		}
		//HACER
		
	}
	*/
}

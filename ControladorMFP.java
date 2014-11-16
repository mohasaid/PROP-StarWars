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
	public void InitEntrada(ControladorGalaxia cg) throws Exception{
		e = new Entrada(cg);
	}
	//Funciones de coste
	public void SeleccionarFC(int x, ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp) throws Exception{
		if(x==1){
			fc = new FuncionFlujo();
			for(int i=0; i < e.Consultar_grafo().sizeGrafo();++i){
				for(int j=0; j<e.Consultar_grafo().sizeGrafo(i);++j){
					e.Consultar_grafo().consultarPrim(i,j).ModificarCoste(fc.CalcularCoste());
				}
			}
		}
		if(x==2){
			fc = new FuncionDistancia();
			for(int i=0; i < e.Consultar_grafo().sizeGrafo();++i){
				for(int j=0; j<e.Consultar_grafo().sizeGrafo(i);++j){
					Arco aux = e.Consultar_grafo().consultarPrim(i,j);
					Ruta r = cr.BuscarRuta(aux.ConsultarIdRuta());
					fc.ModificarRuta(r);
					e.Consultar_grafo().consultarPrim(i,j).ModificarCoste(fc.CalcularCoste());
				}
			}
		}
		if(x==3){
			fc = new FuncionPrecio();
			for(int i=0; i < e.Consultar_grafo().sizeGrafo();++i){
				for(int j=0; j<e.Consultar_grafo().sizeGrafo(i);++j){
					Arco aux = e.Consultar_grafo().consultarPrim(i,j);
					Ruta r = cr.BuscarRuta(aux.ConsultarIdRuta());
					Planeta p = cp.Consultar_PlanetaX(e.Consultar_grafo().consultarSeg(i,j));
					fc.ModificarRuta(r);
					fc.ModificarPlaneta(p);
					e.Consultar_grafo().consultarPrim(i,j).ModificarCoste(fc.CalcularCoste());
				}
			}
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

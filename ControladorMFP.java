import java.util.*;

public class ControladorMFP{
	private Entrada e;
	private MFP alg;
	private FuncionesCoste fc;
	private boolean FuncionElegida;
	private Iterator<Integer> itCB;
	private Iterator<String> itF;
	private Iterator<String> itC;
	
	//CREADORA
	public ControladorMFP(){
		e = new Entrada();
		FuncionElegida = false;
		
	}
	//Seleccion/Ejecucion del algoritmo
	public void SeleccionarAlgoritmo(int i,ControladorRuta cr,ControladorPlaneta cp,ControladorNave cn) throws Exception{
		if(!FuncionElegida){
			throw new Exception("Error: Es necesario seleccionar una funcion de coste antes de elegir algoritmo");
		}
		if(i==1){
			alg = new FordFulkersonBFS(e);
		}
		if(i==2){
			alg = new FordFulkerson_Dijkstra(e);
		}
		if(i==3){
			//alg = new PushRelabel(e);
		}

		alg.Ejecutar();
		ArrayList<Integer> aux = cn.IdNaves();
		Iterator<Integer> it = aux.iterator();
		while(it.hasNext()){
			int id = it.next();
			int cons =  cn.ConsultarConsumo(id);
			alg.Caminos(id,cons);
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

//OPERACIONES SALIDA
	public void Inicializar1(){
		itF = (alg.ConsultarCaminos()).iterator();
		itCB = (alg.ConsultarCuellos()).iterator();
	}
	public void Inicializar2(){
		itC = (alg.ConsultarCambios()).iterator();
	}
	//Pre:cierto
	//Post: devuelve el numero de elementos que conforman la salida incluyendo numero de rutas, numero de cuellos de botella y el coste
	//Pre:cierto
	//Post: devuelve un string que contiene: flujos de cada ruta, los cuellos de botella y el coste
	public String ConsultarSalida(int i){
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
	public int size(){
		return alg.size();
	}
	public int sizeCambios(){
		return alg.sizeCambios();
	}
	
	//Pre:cierto
	//Post:devuelve un string que contiene los cambios que se han ido produciendo en el grafo durante la ejecución del algoritmo.
	public String ConsultarCambios(int i){
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

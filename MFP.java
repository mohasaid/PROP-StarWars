import java.util.*;


public abstract class MFP{
	protected Salida s;
	protected Grafo g_residual;
	protected Grafo g;
	
	public ArrayList<Integer> ConsultarCuellos(){
		return s.ConsultarCuellos();
	}
	public ArrayList<Pair<Arco,Integer>> ConsultarFlujos(){
		return s.ConsultarFlujos();
	}
	public int size(){
		return s.size();
	}
	public int sizeCambios(){
		return s.size();
	}
	public void GenerarFlujos(Entrada e, ControladorRuta cr){
		s.GenerarFlujos(e,cr);
	}
	//Cambiar:
	public ArrayList<String> ConsultarCambios(){
		return s.ConsultarCambios();
	}
	public abstract int Ejecutar(int origen, int destino);
	public abstract void Recorrido(int origen,int destino);
	public void Caminos(int idNave, int consumo){
		//Codigo caminos
	}
	
	}

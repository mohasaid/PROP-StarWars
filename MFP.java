import java.util.*;


public abstract class MFP{
	protected Salida s;
	protected Grafo g_residual;
	protected Grafo g;
	
	public ArrayList<Integer> ConsultarCuellos(){
		return s.ConsultarCuellos();
	}
	public ArrayList<String> ConsultarCaminos(){
		return s.ConsultarCaminos();
	}
	public int size(){
		return s.size();
	}
	public int sizeCambios(){
		return s.size();
	}
	//Cambiar:
	public ArrayList<String> ConsultarCambios(){
		return s.ConsultarCambios();
	}
	public abstract void Ejecutar();
	public abstract boolean Recorrido(int origen,int destino);
	public void Caminos(int idNave, int consumo){
		//Codigo caminos
	}
	
	}


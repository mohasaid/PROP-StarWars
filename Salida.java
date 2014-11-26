import java.util.*;

public class Salida{
	private ArrayList<Integer> CuellosB; 
	private ArrayList<String> Caminos;
	private ArrayList<String> Cambios;
	private long tiempo;
	private int max_flow;
	
	//CREADORA

	public Salida(){
		CuellosB = new ArrayList<Integer>();
		Caminos = new ArrayList<String>();
		Cambios = new ArrayList<String>();
		max_flow = 0;
		tiempo = 0;
	}

	// CONSULTORAS
	public ArrayList<Integer> ConsultarCuellos(){
		return CuellosB;
	}
	public ArrayList<String> ConsultarCaminos(){
		return Caminos;
	}
	public ArrayList<String> ConsultarCambios(){
		return Cambios;
	}
	public int ConsultarMax_flow(){
		return max_flow;
	}
	public long consultarTiempo()
	{
		return tiempo;
	}
	
	//Pre:cierto
	//Post: devuelve la suma del numero de elementos en Flujos, y cuellosB
	public int size(){
		return Caminos.size()+CuellosB.size();
	}
	//Pre:cierto
	//Post: devuelve el numero de elementos en Cambios
	public int sizeCambios(){
		return Cambios.size();
	}
	//MODIFICADORAS
	public void AnadirCuello(int  idr){
		if(!CuellosB.contains(idr)) CuellosB.add(idr);
	}
	public void AnadirCamino(String s){
		if(!Caminos.contains(s))Caminos.add(s);
	}
	public void AnadirCambio(String s){
		if(!Cambios.contains(s))Cambios.add(s);
	}
	public void AnadirMax_flow(int x){
		max_flow = x;
	}
	public void AnadirTiempo(long t)
	{
		tiempo = t;
	}
	
	public void EliminarCuellos(){
		CuellosB.clear();
	}
	public void EliminarCaminos(){
		Caminos.clear();
	}
	public void EliminarCambios(){
		Cambios.clear();
	}
}

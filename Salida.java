import java.util.*;

public class Salida{
	private ArrayList<Integer> CuellosB; 
	private ArrayList<String> Caminos;
	private ArrayList<String> Cambios;
	private long tiempo;
	private int max_flow;
	
	//CREADORA

	public Salida() 
	{
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
	
	/**
	 * Metodo para consultar la capacidad que hay en el camino entre origen y destino
	 * @param g
	 * @param origen
	 * @param destino
	 * @param b
	 * @param r
	 * @param cp
	 * @param tipo
	 * @return
	 * @throws Exception
	 */
	public int Caminos(Grafo g, String origen, String destino, boolean b, Recorrido r, ArrayList<String> pl,/* int tipo,*/ int[] camino) throws Exception
	{
		int o1 = pl.indexOf(origen); // nodo origen
		int d1 = pl.indexOf(destino); // nodo destino
		
		int tam = g.sizeGrafo();
		int path[] = new int[tam];
		Arrays.fill(path, -1);
		int u,v, min = 0;
		boolean hay;
		/*if(tipo == 1) {
			hay = r.Recorrido(g, d1, o1, path); // ff orden inverso
			if(hay) {
				for(v = o1; v != d1; v = path[v]) {
					u = path[v];
					min = Math.min(Integer.MAX_VALUE, g.consultaPairUn(v, u).consultarPrimero().ConsultarCapacidad());
				}
			}
		}
		if(tipo == 2) {*/
			hay = r.Recorrido(g, o1, d1, path); // push relabel orden correcto
			if(hay) {
				for(v = d1; v != o1; v = path[v]) {
					u = path[v];
					min = Math.min(Integer.MAX_VALUE, g.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad());
				}
			}
		//}
		camino = path;
		return min;
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
	public void AnadirCuello(int idr){
		if(!CuellosB.contains(idr)) CuellosB.add(idr);
	}
	public void AnadirCamino(String s){
		if(!Caminos.contains(s))Caminos.add(s);
	}
	public void AnadirCambio(String s){
		if(!Cambios.contains(s))Cambios.add(s);
	}
	public void AnadirMax_flow(int x)
	{
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

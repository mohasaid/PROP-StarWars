/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prop;

/**
 *
 * @author Moha
 */
import java.util.*;

public class Salida {
	private ArrayList<Integer> CuellosB; 
	private ArrayList<String> Caminos;
	private ArrayList<String> Cambios;
	private long tiempo;
	private int max_flow;
        private String algoritmo;
	
	//CREADORA

	public Salida() 
	{
            CuellosB = new ArrayList<Integer>();
            Caminos = new ArrayList<String>();
            Cambios = new ArrayList<String>();
            max_flow = 0;
            tiempo = 0;
            algoritmo = "";
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
        public String consultarAlgoritmo()
        {
            return algoritmo;
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
	public int[] Caminos(Grafo g, int naves, String origen, String destino, Recorrido r, ArrayList<String> pl, boolean[] hay_s) throws Exception
	{
            int o1 = pl.indexOf(origen); // nodo origen
            int d1 = pl.indexOf(destino); // nodo destino

            int tam = g.sizeGrafo();

            int path[] = new int[tam+1]; // en la posicion tam estara la capacidad minima
            Arrays.fill(path,-1);

            path[tam] = 0;
            int u,v;

            boolean hay;
            hay = r.Recorrido(g, o1, d1, path);
            hay_s[0] = hay;
            
            if(hay) {
                for(v = d1; v != o1; v = path[v]) {
                        u = path[v];
                        path[tam] = Math.min(Integer.MAX_VALUE, g.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad());
                }
                if(naves >= path[tam]) naves = path[tam];
                // paso las naves
                for(v = d1; v != o1; v = path[v]) {
                        u = path[v];
                        int tmp = g.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad();
                        tmp = tmp - naves;
                        g.consultaPairUn(u, v).consultarPrimero().ModificarCapacidad(tmp);
                }
            }
            return path;
	}
	
	//Pre:cierto
	//Post: devuelve la suma del numero de elementos en Flujos, y cuellosB
	public int size(){
            return Caminos.size() + CuellosB.size() + 1;
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
        public void AnadirAlgoritmo(String a)
        {
            algoritmo = a;
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

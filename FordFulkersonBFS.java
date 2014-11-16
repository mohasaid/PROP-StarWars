import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkersonBFS extends FordFulkerson {
	private int path[]; // path como privado o la paso por la funcion
	/*
	    int path[] = new int[size];
		Arrays.fill(path, -1);
	 */
	
	public FordFulkersonBFS(){
		g = new Grafo();
		g_residual = new Grafo();
		s = new Salida();
	}
	public FordFulkersonBFS(Entrada e){
		g = e.Consultar_grafo();
		g_residual = e.Consultar_grafo();
		s = new Salida();
	}
	
	public void Recorrido(int origen, int destino){
		int V = g_residual.sizeGrafo();
		
		boolean[] visitados = new boolean[V];
		Arrays.fill(visitados,false);
		
		visitados[origen] = true;
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(origen);
		
		while(!q1.isEmpty()) {
			int actual = q1.poll().intValue();
			int size = g_residual.sizeGrafo(actual);
			for(int i = 0; i < size; ++i) {
				int adj = g_residual.consultarSeg(actual, i);
				int cap = g_residual.consultarPrim(actual, i).ConsultarCapacidad();
				if(cap != 0 && !visitados[adj]) {
					path[adj] = actual;
					visitados[adj] = true;
					q1.add(adj);
				}
			}
		}
	}
	
}

/*
public static boolean bfs_Grafo(ArrayList<ArrayList<Pair<Arco, Integer> > > g, int or, int dest, int path[])
{
	int V = g.size();
	boolean[] visitados = new boolean[V];
	Arrays.fill(visitados,false);
	visitados[or] = true; // Primero lo visitamos
	Queue<Integer> q1 = new LinkedList<Integer>(); // id nodos a visitar
	q1.add(or);
	while(!q1.isEmpty()) {
		int actual = q1.poll().intValue(); // nodo actual
		int size = g.get(actual).size();
		for(int i = 0; i < size; ++i) {
			int v = g.get(actual).get(i).consultarSegundo(); // nodo destino
			int c = g.get(actual).get(i).consultarPrimero().ConsultarCapacidad();
			if(c != 0 && !visitados[v]) {
				path[v] = actual;
				visitados[v] = true;
				q1.add(v);
			}
		}
	}
	return visitados[dest];
}
*/

import java.util.*;

public class FordFulkersonBFS extends FordFulkerson{
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
	public void Recorrido(){
		//Codigo BFS
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

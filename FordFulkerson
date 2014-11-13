import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FordFulkerson {
	private Grafo g;
	private Grafo g_residual;
	
	
	private boolean bfs(int origen1, int destino1, int path[])
	{
		int V = g_residual.getNodes().size();
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visitados = new boolean[V];
		path = new int[V];
		q.add(Integer.valueOf(origen1));
		path[origen1] = -1;
		visitados[origen1] = true;
		while(!q.isEmpty()) {
			Integer actual = q.poll();
			Nodo ac = g_residual.consultarNodo(actual.intValue());
			for(int v = 0; v < V; ++v) {
				Nodo n1 = g_residual.consultarNodo(v);
				ArrayList<Arco> ara =  g_residual.getArcoEntreNodos(ac,n1);
				for(int i = 0; i < ara.size(); ++i) {
					if(visitados[v] == false && ara.get(i).ConsultarCapacidad() > 0)  {
						q.add(Integer.valueOf(v));
						path[v] = actual.intValue();
						visitados[v] = true;
					}	
				}
			}
		}
		return (visitados[destino1] == true);
	}
	
	private boolean djikstra(int origen, int destino, int path[], int dist[])
	{
		int V = g_residual.getNodes().size();
		PriorityQueue<Pair<Integer, Integer> > pq = new PriorityQueue<Pair<Integer, Integer> >(1, new PriorityQueueComparator());
		dist = new int[V];
		for(int i = 0; i < V; ++i) dist[i] = Integer.MAX_VALUE;
		path = new int[V];
		for(int i = 0; i < V; ++i) path[i] = -1;
		Pair<Integer, Integer> pa = new Pair<Integer, Integer>(null, null);
		boolean visitados[] = new boolean[V];
		dist[origen] = 0;
		// FALTA POR HACER
				
	}		
}

class PriorityQueueComparator implements Comparator<Pair<Integer, Integer>> 
{
	public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
		return (int) (p2.consultarPrimero() - p1.consultarPrimero());
	}
}

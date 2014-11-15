import java.util.*;

public class FordFulkerson_Dijkstra extends FordFulkerson{
	public FordFulkerson_Dijkstra(){
		g = new Grafo();
		g_residual = new Grafo();
		s = new Salida();
	}
	public FordFulkerson_Dijkstra(Entrada e){
		g = e.Consultar_grafo();
		g_residual = e.Consultar_grafo();
		s = new Salida();
	}
	public void Recorrido(){
		//Codigo dijkstra
	}
}

import java.util.*;

public class FordFulkerson_Dijkstra extends FordFulkerson {
	
	public FordFulkerson_Dijkstra(){
		g = new Grafo();
		g_residual = new Grafo();
		s = new Salida();
	}
	public FordFulkerson_Dijkstra(Entrada e){
		g = e.Consultar_grafo();
		g_residual = e.Consultar_grafo();
		s = new Salida();
	}
	public void Recorrido(){
		//Codigo dijkstra
	}
}

/*
public static boolean dijkstra(ArrayList<ArrayList<Pair<Arco, Integer> > > g, int or, int dest, int path[], int dist[])
{
	int V = g.size();
	boolean visitados[] = new boolean[V];
	Arrays.fill(visitados,false);
	dist[or] = 0;
	
	PriorityQueue<Pair<Integer, Integer> > pq = new PriorityQueue<Pair<Integer, Integer> >(1, new PriorityQueueComparator()); // coste, nodo
	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(0, or);
	pq.add(pa);
	
	while(!pq.isEmpty()) {
		Pair<Integer, Integer> p = pq.poll();
		int actual = p.consultarSegundo();
		int size = g.get(actual).size();
		if(!visitados[actual]) {
			visitados[actual] = true;
			for(int i = 0; i < size; ++i) {
				int adj = g.get(actual).get(i).consultarSegundo();
				int coste = g.get(actual).get(i).consultarPrimero().ConsultarCoste();
				if(dist[adj] > dist[actual] + coste) {
					dist[adj] = dist[actual] + coste;
					path[adj] = actual;
					pq.add(new Pair<Integer,Integer>(dist[adj],adj));
				}
			}
		}
	}
	if(dist[dest] != Integer.MAX_VALUE) return true;
	else return false;
}
*/

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
		public void Caminos(int idNave, int consumo){
			super.Caminos(idNave, consumo);
		}
		public void Ejecutar(){
			super.Ejecutar();
		}
		public boolean Recorrido(int origen, int destino){
			
			int V = g_residual.sizeGrafo();
			boolean[] visitados = new boolean[V];
			Arrays.fill(visitados, false);
					
			dist[origen] = 0;
			
			PriorityQueue<Pair<Integer, Integer> > pq = new PriorityQueue<Pair<Integer, Integer> >(1, new PriorityQueueComparator()); // coste, nodo
			Pair<Integer, Integer> pa = new Pair<Integer, Integer>(0, origen);
			pq.add(pa);
			while(!pq.isEmpty()) {
				Pair<Integer, Integer> p = pq.poll();
				int actual = p.consultarSegundo();
				int size = g_residual.sizeGrafo(actual);
				if(!visitados[actual]) {
					visitados[actual] = true;
					for(int i = 0; i < size; ++i) {
						int adj = g_residual.consultarSeg(actual, i);
						int coste = g_residual.consultarPrim(actual, i).ConsultarCoste();
						if(dist[adj] > dist[actual] + coste) {
							dist[adj] = dist[actual] + coste;
							path[adj] = actual;
							pq.add(new Pair<Integer,Integer>(dist[adj],adj));
						}
					}
				}
			}
			if(dist[destino] != Integer.MAX_VALUE) return true;
			else return false;
		}
}

class PriorityQueueComparator implements Comparator<Pair<Integer, Integer>> 
{
	public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
		return (int) (p2.consultarPrimero() - p1.consultarPrimero());
	}
}

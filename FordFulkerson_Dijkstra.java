import java.util.*;

	public class FordFulkerson_Dijkstra extends FordFulkerson {
		private int path[]; // PASARLAS COMO PARAMETRO O COMO ATRIBUTOS PRIVADOS
		private int dist[];
		/*
	int path[] = new int[size];
	Arrays.fill(path, -1);
	int dist[] = new int[size];
	Arrays.fill(dist, Integer.MAX_VALUE);
		 */
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
			return super.Ejecutar();
		}
		public void Recorrido(int origen, int destino){
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


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FordFulkerson {
	private Grafo g;
	private Grafo g_residual;

	
	public int MaxFlowBFS(int origen, int destino)
	{
		int size = g_residual.sizeGrafo();
		int path[] = new int[size];
		Arrays.fill(path,-1);
		int max_flow = 0;
		while(bfs(origen,destino,path)) {
			int min = Integer.MAX_VALUE;
			int val = destino;
			while(val != origen) {
				int u = path[val];
				if(g_residual.consultaPair(u, val).consultarSegundo() < min) {
					min = g_residual.consultaPair(u, val).consultarSegundo();
				}
				val = path[val];
			}
			val = destino;
			max_flow += min;
			while(val != origen) {
				int u = path[val];
				int tmp = g_residual.consultaPair(u, val).consultarSegundo();
				tmp = tmp - min;
				g_residual.consultaPair(u, val).ponSegundo(tmp);
				int tmp1 = g_residual.consultaPair(val,u).consultarSegundo();
				tmp1 = tmp1 + min;
				g_residual.consultaPair(u,val).ponSegundo(tmp1);
				val = path[val];
			}
		}
		return max_flow;
	}
	
	// Todas las distancias estan a 1?
	public boolean bfs(int or1, int dest1, int path[])
	{
		int V = g_residual.sizeGrafo();
		
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(or1);
		
		boolean[] visitados = new boolean[V];
		Arrays.fill(visitados,false);
		
		visitados[or1] = true;
		
		while(!q1.isEmpty()) {
			int u = q1.poll().intValue();
			int size = g_residual.sizeGrafo(u);
				for(int i = 0; i < size; ++i) {
					int v = g_residual.consultarSeg(u, i);
					int c = g_residual.consultarPrim(u, i); // capacidad-coste
					if(c != 0 && !visitados[v]) {
						path[v] = u;
						visitados[v] = true;
						q1.add(Integer.valueOf(v));
					}
				}
		}
		return (visitados[dest1] == true);
	}

	
	// vector<vector<ARCP> > grafo 
	// pair<coste,destino> arcp
	public void djikstra(int origen, int path[], int dist[])
	{
		int V = g_residual.sizeGrafo();
	
		dist = new int[V];
		Arrays.fill(dist,Integer.MAX_VALUE);
		//for(int i = 0; i < V; ++i) dist[i] = Integer.MAX_VALUE; // inicializar path a infinito
		path = new int[V];
		Arrays.fill(path,-1);
		//for(int i = 0; i < V; ++i) path[i] = -1; // inicializar path a -1
		boolean visitados[] = new boolean[V];
		Arrays.fill(visitados,false);
		
		dist[origen] = 0;
		PriorityQueue<Pair<Integer, Integer> > pq = new PriorityQueue<Pair<Integer, Integer> >(1, new PriorityQueueComparator());
		
		Pair<Integer, Integer> pa = new Pair<Integer, Integer>(0, origen);
		pq.add(pa);
		
		while(!pq.isEmpty()) {
			Pair<Integer, Integer> pa1 = pq.poll();
			int u = pa1.consultarSegundo();
			int size = g_residual.sizeGrafo(u);
			if(!visitados[u]) {
				visitados[u] = true;
				for(int i = 0; i < size; ++i) {
					int v = g_residual.consultarSeg(u, i);
					int c = g_residual.consultarPrim(u, i); // capacidad - coste
					if(dist[v] > dist[u] + c) {
						dist[v] = dist[u] + c;
						path[v] = u;
						pq.add(new Pair<Integer,Integer>(dist[v],v));
					}
				}
			}
		}
	}
	/* consultar path:
	if(dist[DESTINO] != Integer.MAX_VALUE) { // si hay path
		Stack<Integer> st = new Stack<Integer>();
		while(destino != -1) {
			st.push(destino);
			destino = path[destino];
		}
		// escribir path:
		 while(st.size() > 1) {
              cout << st.top() << " ";
              st.pop();
         }
         cout << s.top() << endl;
	}
	
	else NO HAY PATH
	*/
	
}

class PriorityQueueComparator implements Comparator<Pair<Integer, Integer>> 
{
	public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
		return (int) (p2.consultarPrimero() - p1.consultarPrimero());
	}
}

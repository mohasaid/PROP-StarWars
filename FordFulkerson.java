import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FordFulkerson {
	private Grafo g;
	private Grafo g_residual;
	private double[] d; //eso es solo para el algoritmo dijkstra
	private double infinit = Double.POSITIVE_INFINITY;
	 
	private void posar_vector_doubles_infinit( double[] v )
	{
		for (int i=0; i < v.length; ++i) d[i]=infinit;
	}
	
	private void posar_vetor_bools_false( boolean[] v )
	{
		for (int i=0; i < v.length; ++i) v[i]=false;
	}
	
	/*private void dijkstra(int s)
	{
		int n = g.getNodes().size();
		
		d = new double[n];
		posar_vector_doubles_infinit(d); //inicializamos todo a infinito
		d[s] = 0;// la distancia al nodo fuente es 0 (ya que partimo de aqui)
		
		boolean S[] = new boolean[n];
		posar_vetor_bools_false(S); //inicializamos el vector de visitados a false
		
		PriorityQueue() Q = new PriorityQueue(); //se tiene qe crear bien!
		
		//a partir de aqui es codigo c++
		priority_queue<ArcP, vector<ArcP>, greater<ArcP> > Q; //perque aquesta cua de prioritat ????
		Q.push( ArcP(0, s) );
		
		while (not Q.empty()) {
			int u = Q.top().second; 
			Q.pop();

			if (not S[u]) {
				S[u] = true;
				int siz = G[u].size();
				for (int i = 0; i < siz ; ++i) {
					int v = G[u][i].second;
					int c = G[u][i].first;
					if (d[v] > d[u] + c) {
						d[v] = d[u] + c;
						Q.push(ArcP(d[v], v));
					}
				}
			}
		}
	}*/
	
	
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

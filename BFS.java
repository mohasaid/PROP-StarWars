import java.util.*;

public class BFS extends Recorrido {

	public BFS(){}
	
	public boolean Recorrido(Grafo g_residual, int origen, int destino, int path[]) {
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
				if(cap > 0 && !visitados[adj]) {
					path[adj] = actual;
					visitados[adj] = true;
					q1.add(adj);
				}
			}
		}
		return visitados[destino];
	}
}

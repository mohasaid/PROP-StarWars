import java.util.*;

public /*abstract*/ class FordFulkerson extends MFP{
	protected Grafo g;
	protected Grafo g_residual;
	
	public FordFulkerson(){
		g = new Grafo();
		g_residual = new Grafo();
		s = new Salida();
	}
	public int Ejecutar(int origen, int destino){
		int size = g.sizeGrafo();
		
		// g_residual = g;
		
		int path[] = new int[size];
		Arrays.fill(path, -1);
		int dist[] = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int u,v;
		int max_flow = 0;
		
		while(BFS O DIJKSTRA) {
		
		int pathflow = Integer.MAX_VALUE;
		for(v = destino; v != origen; v = path[v]) {
			u = path[v];
			pathflow = Math.min(pathflow, g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad());
		}
		for(v = destino; v != origen; v = path[v]) {
			u = path[v];
			int tmp = g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad();
			tmp -= pathflow;
			g_residual.ponEnVerAr(u, v, tmp);
			
			int tmp1 = g_residual.consultaPairUn(v, u).consultarPrimero().ConsultarCapacidad();
			tmp1 += pathflow;
			
			g_residual.ponEnVerAr(v, u, tmp1); // poner solo una capacidad
		}
		max_flow += pathflow;
	}
	return max_flow;
	}

}


/*public static int MaxFflowDjik(ArrayList<ArrayList<Pair<Integer, Integer> > > g, int origen, int destino)
{
	
	int size = g.size();
	ArrayList<ArrayList<Pair<Integer, Integer> > > g_residual = g;
	
	int path[] = new int[size];
	Arrays.fill(path, -1);
	int dist[] = new int[size];
	Arrays.fill(dist, Integer.MAX_VALUE);
	
	int u,v;
	int max_flow = 0;
	
	// -> ESTO CAMBIA EL RESTO ES LO MISMO while(djikstra1(g_residual,origen,destino,path,dist)) {
		int pathflow = Integer.MAX_VALUE;
		for(v = destino; v != origen; v = path[v]) {
			u = path[v];
			pathflow = Math.min(pathflow, g_residual.get(u).get(v).consultarPrimero());
		}
		for(v = destino; v != origen; v = path[v]) {
			u = path[v];
			int tmp = g_residual.get(u).get(v).consultarPrimero();
			tmp -= pathflow;
			g_residual.get(u).get(v).ponPrimero(tmp);
			
			int tmp1 = g_residual.get(v).get(u).consultarPrimero();
			tmp1 += pathflow;
			g_residual.get(v).get(u).ponPrimero(tmp1);
		}
		max_flow += pathflow;
	}
	return max_flow;
}*/

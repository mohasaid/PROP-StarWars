import java.util.*;

public class FordFulkerson extends MFP {
	
	public FordFulkerson(Entrada e)
	{
		G = e.Consultar_grafo();
		g_residual();
	}
	
	public void g_residual() 
	{
		ArrayList<ArrayList<Pair<Arco,Integer> > > ar = new ArrayList<ArrayList<Pair<Arco,Integer> > > ();
		for(int i = 0; i < G.sizeGrafo(); ++i) {
			ArrayList<Pair<Arco,Integer> >  ad = G.consultarCosteDestinos(i);
			ar.add(ad);
		}
		g_residual = new Grafo(ar);
		int v;
		for(int i = 0; i < G.sizeGrafo(); ++i) {
			for(int j = 0; j < G.sizeGrafo(i); ++j) {
				v = G.consultarSeg(i, j);
				if(!G.ExisteV(v, i)) {
					Arco a = new Arco();
					Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,i);
					g_residual.consultarCosteDestinos(v).add(p);
				}
			}
		}
		System.out.println("GRAFO residual:");
		for(int i = 0; i < g_residual.sizeGrafo(); ++i) {
			System.out.println("Del vertice " + i + " sale lo siguiente:");
			for(int j = 0; j < g_residual.sizeGrafo(i); ++j) {
				System.out.println("Arista de capacidad = " + g_residual.consultarPrim(i, j).ConsultarCapacidad()
								 + " y con coste = " + g_residual.consultarPrim(i, j).ConsultarCoste()
								 + " hacia el vertice "+ g_residual.consultarSeg(i, j));
			}
		}
	}
	
	public void Ejecutar(Recorrido r, Salida s)
	{
		// CONSULTAR TIEMPO
		long timeMillis = System.currentTimeMillis();
		
		int size = G.sizeGrafo();
		
		int origen = size-2; // nodo origen
		int destino = size-1; // nodo destino
		
		int path[] = new int[size];
		Arrays.fill(path, -1);

		int u,v;
		int max_flow = 0;
		String camino = ""; // Contiene el camino en orden inverso
		
		while(r.Recorrido(g_residual,origen,destino,path)) {
			int pathflow = Integer.MAX_VALUE;
			camino += destino;

			for(v = destino; v != origen; v = path[v]) {
				u = path[v];
				camino += "," + u;
				pathflow = Math.min(pathflow, g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad());
			}
			
			camino += ", " + origen;
			for(v = destino; v != origen; v = path[v]) {
				u = path[v];
				int tmp = g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad();
				tmp -= pathflow;
				g_residual.ponEnVerAr(u, v, tmp);
				int tmp1 = g_residual.consultaPairUn(v, u).consultarPrimero().ConsultarCapacidad();
				tmp1 += pathflow;
				g_residual.ponEnVerAr(v, u, tmp1);
			}
			max_flow += pathflow;
			s.AnadirCambio(camino);
			camino = "";
		}
		System.out.println("MAXFLOW = " + max_flow);
		s.AnadirMax_flow(max_flow);
		
		long timeMillis1 = System.currentTimeMillis();
		long f1 = timeMillis1 - timeMillis;
		s.AnadirTiempo(f1);
	}	
}

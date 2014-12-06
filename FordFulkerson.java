import java.util.*;

public class FordFulkerson extends MFP {
	
	public FordFulkerson(Entrada e) throws CloneNotSupportedException
	{
		G = e.Consultar_grafo();
		g_residual(G.sizeGrafo());
	}
	
	public void g_residual(int size) {
	    ArrayList<ArrayList<Pair<Arco,Integer> > > ar = new ArrayList<ArrayList<Pair<Arco,Integer> > > ();
	    for(int i = 0; i < size; ++i) {
	            ArrayList<Pair<Arco,Integer> >  ad = new ArrayList<Pair<Arco,Integer> >();
	            ar.add(ad);
	    }
	    g_residual = new Grafo(ar);
	    int v;
	    boolean insert = false;
	    for(int i = 0; i < G.sizeGrafo(); ++i) {
	            for (int j = 0; j < G.sizeGrafo(i); ++j) {
	                    v = G.consultarSeg(i, j);
	                    Arco a = new Arco();
	                    a.ModificarCoste(G.consultaPairUn(i, v).consultarPrimero().ConsultarCoste());
	                    a.ModificarCapacidad(G.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad());
	                    Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,v);
	                    if (g_residual.consultarCosteDestinos(i).isEmpty()) g_residual.consultarCosteDestinos(i).add(p);
	                    else {
	                            for(int h = 0; h < g_residual.consultarCosteDestinos(i).size() && !insert; ++h) {
	                                    if (g_residual.consultarCosteDestinos(i).get(h).consultarPrimero().ConsultarCoste() >= a.ConsultarCoste()) {
	                                            g_residual.consultarCosteDestinos(i).add(h, p);
	                                            insert = true;
	                                    }
	                            }
	                            if(!insert) g_residual.consultarCosteDestinos(i).add(p);
	                            insert = false;
	                    }
	            }
	    }
	    for(int i = 0; i < G.sizeGrafo(); ++i) {
	            for (int j = 0; j < G.sizeGrafo(i); ++j) {
	                    v = G.consultarSeg(i, j);
	                    if(!g_residual.ExisteV(v, i)) {
	                            Arco a = new Arco();
	                            Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,i);
	                            g_residual.consultarCosteDestinos(v).add(p);
	                    }
	            }
	    }
	}
	
	/*public void escribeGrafoResidual()
	{
		System.out.println("GRAFO RESIDUAL");
		for(int i = 0; i < g_residual.sizeGrafo(); ++i) {
			System.out.println("Del vertice " + i + " sale lo siguiente:");
			for(int j = 0; j < g_residual.sizeGrafo(i); ++j) {
				System.out.println("Arista de capacidad = " + g_residual.consultarPrim(i, j).ConsultarCapacidad()
								 + " y con coste = " + g_residual.consultarPrim(i, j).ConsultarCoste()
								 + " hacia el vertice "+ g_residual.consultarSeg(i, j));
			}
		}
		System.out.println();
		System.out.println();
	}
	
	public void escribeGrafoOriginal()
	{
		System.out.println("GRAFO ORIGINAL");
		for(int i = 0; i < G.sizeGrafo(); ++i) {
			System.out.println("Del vertice " + i + " sale lo siguiente:");
			for(int j = 0; j < G.sizeGrafo(i); ++j) {
				System.out.println("Arista de capacidad = " + G.consultarPrim(i, j).ConsultarCapacidad()
								 + " y con coste = " + G.consultarPrim(i, j).ConsultarCoste()
								 + " hacia el vertice "+ G.consultarSeg(i, j));
			}
		}
		System.out.println();
		System.out.println();
	}*/
	
	public void updateGraph(int size) // quito las retroactivas pero no los virtuales
	{
		ArrayList<ArrayList<Pair<Arco,Integer> > > ar = new ArrayList<ArrayList<Pair<Arco,Integer> > > ();
	    for(int i = 0; i < size; ++i) {
	            ArrayList<Pair<Arco,Integer> >  ad = new ArrayList<Pair<Arco,Integer> >();
	            ar.add(ad);
	    }
		Grafo parcial = new Grafo(ar);
		int v;
		for(int i = 0; i < g_residual.sizeGrafo(); ++i) {
			for(int j = 0; j < g_residual.sizeGrafo(i); ++j) {
				v = g_residual.consultarSeg(i, j);
				if(G.ExisteV(i, v)) {
					Arco a = new Arco();
	                a.ModificarCoste(g_residual.consultaPairUn(i, v).consultarPrimero().ConsultarCoste());
	                a.ModificarCapacidad(g_residual.consultaPairUn(v, i).consultarPrimero().ConsultarCapacidad());
	                Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,v);
	                parcial.consultarCosteDestinos(i).add(p);
				}
			}
		}
		g_residual = parcial;
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
				camino += "<=" + u;
				pathflow = Math.min(pathflow, g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad());
			}
			for(v = destino; v != origen; v = path[v]) {
				u = path[v];
				int tmp = g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad();
				tmp = tmp - pathflow;
				g_residual.consultaPairUn(u, v).consultarPrimero().ModificarCapacidad(tmp);
				int tmp1 = g_residual.consultaPairUn(v, u).consultarPrimero().ConsultarCapacidad();
				tmp1 = tmp1 + pathflow;
				g_residual.consultaPairUn(v, u).consultarPrimero().ModificarCapacidad(tmp1);
			}
			if(pathflow != Integer.MAX_VALUE) max_flow = max_flow + pathflow;
			System.out.println("camino = " + camino);
			s.AnadirCambio(camino);
			camino = "";
		}
		System.out.println("MAXFLOW = " + max_flow);
		s.AnadirMax_flow(max_flow);
		
		// actualizamos grafo residual quitando las retroactivas y actualizando el valor de la capacidad
		updateGraph(g_residual.sizeGrafo());
		
		long timeMillis1 = System.currentTimeMillis();
		long f1 = timeMillis1 - timeMillis;
		s.AnadirTiempo(f1);
	}
}

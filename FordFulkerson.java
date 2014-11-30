import java.util.*;

public class FordFulkerson extends MFP {
	//protected int path[]; // con -1
	
	public FordFulkerson(Entrada e)
	{
		g_residual = e.Consultar_grafo();
	}
	public void Ejecutar(Recorrido r,Salida s)
	{
		// CONSULTAR TIEMPO
		long t = System.currentTimeMillis();
		
		int size = g_residual.sizeGrafo();
		
		int origen = size-2; // nodo origen
		int destino = size-1; // nodo destinoW
		
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
				camino += ", " + u;
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
		s.AnadirMax_flow(max_flow);
		
		long tiempo = System.currentTimeMillis() - t;
		s.AnadirTiempo(tiempo);
	}
	
	public void Caminos(Nave n, int consumo, boolean b, Recorrido r, ControladorPlaneta cp, Salida s) throws Exception
	{
		super.Caminos(n, consumo,b,r,cp,s);
	}
}

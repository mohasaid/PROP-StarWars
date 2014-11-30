import java.util.*;

public class FordFulkerson extends MFP {
	protected int path[];
	
	public FordFulkerson(Entrada e)
	{
		g_residual = e.Consultar_grafo();
	}
	public void Ejecutar(Recorrido r,Salida s)
	{
		// CONSULTAR TIEMPO
		long t = System.currentTimeMillis();
		
		int size = g_residual.sizeGrafo();
		
		int origen = size-1; // nodo origen
		int destino = size-2; // nodo destino
		
		int path[] = new int[size];
		Arrays.fill(path, -1);

		int u,v;
		int max_flow = 0;
		String camino = ""; // Contiene el camino en orden inverso
		// String res = "Buscamos camino de " + origen + " hacia " + destino + " para poder aumentar flujo";
		while(r.Recorrido(g_residual,origen,destino,path)) {
			int pathflow = Integer.MAX_VALUE;
			// res += "Empezamos en nodo " + destino + " y mientras sea diferente de " + origen + ".";
			camino += destino;
			for(v = destino; v != origen; v = path[v]) {
				u = path[v];
				camino += ", " + u;
				// res += "Buscamos menor capacidad residual valor entre los nodos del camino. ";
				pathflow = Math.min(pathflow, g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad());
				// res += "La menor capacidad residual ha resultado ser " + pathflow + ".";
			}
			camino += ", " + origen;
			// res += "Actualizamos la capacidad residual entre los arcos del camino: ";
			for(v = destino; v != origen; v = path[v]) {
				u = path[v];
				// res += "Actualizamos la capacidad residual entre los arcos " + u + " y " + v + ".";
				int tmp = g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad();
				tmp -= pathflow;
				g_residual.ponEnVerAr(u, v, tmp);
				int tmp1 = g_residual.consultaPairUn(v, u).consultarPrimero().ConsultarCapacidad();
				tmp1 += pathflow;
				g_residual.ponEnVerAr(v, u, tmp1);
			}
			// res += " Actualizamos flujo de ruta al flujo general.";
			max_flow += pathflow;
			// s.AnadirCambio(res); // salida[i] = iteracion i
			// res = "";
			s.AnadirCambio(camino);
			camino = "";
		}
		// res = "Llegados a este punto hemos encontrado el flujo maximo, cuyo valor es " + max_flow + ".";
		// s.AnadirCambio(res); // size -1 tenemos el valor de max_flow
		s.AnadirMax_flow(max_flow);
		// ANADIR TIEMPO EN LA SALIDA
		long tiempo = System.currentTimeMillis() - t;
		s.AnadirTiempo(tiempo);
	}
	
	public void Caminos(Nave n, int consumo, boolean b){
		super.Caminos(n, consumo,b);
	}
}

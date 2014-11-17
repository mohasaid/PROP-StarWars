import java.util.*;

public abstract class FordFulkerson extends MFP{
	protected int path[];
	protected int dist[];

	public void Ejecutar(){
		int size = g.sizeGrafo();
		g_residual = g;
		
		int origen = size-1;
		int destino = size-2;
		
		int path[] = new int[size];
		Arrays.fill(path, -1);
		
		int dist[] = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int u,v;
		int max_flow = 0;
		String res = "Buscamos camino de " + origen + " hacia " + destino + " para poder aumentar flujo";
		s.AnadirCambio(res); // en salida[0] = buscar camino
		while(Recorrido(origen,destino)) {
			int pathflow = Integer.MAX_VALUE;
			res = "Empezamos en nodo " + destino + " y mientras sea diferente de " + origen + ".";
			for(v = destino; v != origen; v = path[v]) {
				u = path[v];
				res += "Buscamos menor capacidad residual valor entre los nodos del camino. ";
				pathflow = Math.min(pathflow, g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad());
				res += "La menor capacidad residual ha resultado ser " + pathflow + ".";
			}
			res += "Actualizamos la capacidad residual entre los arcos del camino. ";
			for(v = destino; v != origen; v = path[v]) {
				u = path[v];
				res += "Actualizamos la capacidad residual entre los arcos " + u + " y " + v + ".";
				int tmp = g_residual.consultaPairUn(u, v).consultarPrimero().ConsultarCapacidad();
				tmp -= pathflow;
				g_residual.ponEnVerAr(u, v, tmp);
				int tmp1 = g_residual.consultaPairUn(v, u).consultarPrimero().ConsultarCapacidad();
				tmp1 += pathflow;
				g_residual.ponEnVerAr(v, u, tmp1);
			}
			res += " Actualizamos flujo de ruta al flujo general.";
			max_flow += pathflow;
			s.AnadirCambio(res); // salida[i] = iteracion i-1
		}
		res = "Llegados a este punto hemos encontrado el flujo maximo, cuyo valor es " + max_flow + ".";
		s.AnadirCambio(res);
		s.AnadirMax_flow(max_flow);
	}
	
	public void Caminos(int idNave, int consumo){
		super.Caminos(idNave, consumo);
	}
	public abstract boolean Recorrido(int origen, int destino);
	
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class FordFulkersonBFS extends FordFulkerson {
		
		public FordFulkersonBFS(){
			g = new Grafo();
			g_residual = new Grafo();
			s = new Salida();
		}
		public FordFulkersonBFS(Entrada e){
			g = e.Consultar_grafo();
			g_residual = e.Consultar_grafo();
			s = new Salida();
		}
		public void Caminos(int idNave, int consumo){
			super.Caminos(idNave, consumo);
		}
		public void Ejecutar(){
			super.Ejecutar();
		}
		public boolean Recorrido(int origen, int destino){
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
					if(cap != 0 && !visitados[adj]) {
						path[adj] = actual;
						visitados[adj] = true;
						q1.add(adj);
					}
				}
			}
			return visitados[destino];
		}
	}

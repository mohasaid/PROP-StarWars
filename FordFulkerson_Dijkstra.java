import java.util.*;

public class FordFulkerson_Dijkstra extends FordFulkerson{
	public FordFulkerson_Dijkstra(){
		g = new Grafo();
		g_residual = new Grafo();
		s = new Salida();
	}
	public FordFulkerson_Dijkstra(Entrada e){
		g = e.Consultar_grafo();
		g_residual = e.Consultar_grafo();
		s = new Salida();
	}
	public void Recorrido(){
		//Codigo dijkstra
	}
}

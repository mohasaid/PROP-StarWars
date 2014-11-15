import java.util.*;

public class FordFulkersonBFS extends FordFulkerson{
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
	public void Recorrido(){
		//Codigo BFS
	}
	
}

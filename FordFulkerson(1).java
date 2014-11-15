import java.util.*;

public /*abstract*/ class FordFulkerson extends MFP{
	protected Grafo g;
	protected Grafo g_residual;
	
	public FordFulkerson(){
		g = new Grafo();
		g_residual = new Grafo();
		s = new Salida();
	}
	public void Ejecutar(){
		//Codigo Parte comun
	}
}

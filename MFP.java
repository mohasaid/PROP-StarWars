public abstract class MFP {
	protected Grafo g_residual;
	protected Grafo G;
	
	/*
	 * GRAFO ENTRADA, GRAFO RESIDUAL EN SALIDA
	 */

	public abstract void Ejecutar(Recorrido r, Salida s);
	
	public Grafo consultaResidual()
	{
		return g_residual;
	}
}

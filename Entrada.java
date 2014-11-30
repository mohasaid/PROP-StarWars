public class Entrada {
	private Grafo g;
	
	/**
	 * Metodo para crear un grafo en entrada
	 * @param f1
	 * @throws Exception
	 */
    public Entrada(Grafo f1) throws Exception
    {
    	g = f1;
    }
    
    /**
     * Metodo para consultar el grafo que contiene entrada
     * @return
     */
    public Grafo Consultar_grafo()
    {
    	return g;
    }
    
}

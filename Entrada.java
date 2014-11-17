public class Entrada {
	private Grafo g;
	
    //Pre: Cierto
    //Post: Crea una entrada vacia
    public Entrada()
    {
    	g = new Grafo();
    }
    
    //Pre: Cierto
    //Post: Crea una entrada con el grafo inicializado a partir de de la lista de nodos y otra de arcos
    public Entrada(ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp) throws Exception
    {
    	g = new Grafo(cg.convierteRutasYPlanetas(cr, cp));
    }
    
    //Pre: Cierto
    //Post: Retorna el grafo g
    public Grafo Consultar_grafo()
    {
    	return g;
    }
}

public class Entrada {
	private Grafo g;

	//Pre: Cierto
    //Post: Crea una entrada con el grafo inicializado a partir de de la lista de nodos y otra de arcos
    public Entrada(ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) throws Exception
    {
    	g = new Grafo(cg.convierteRutasYPlanetas(cr, cp,cn));
    }
    
    //Pre: Cierto
    //Post: Retorna el grafo g
    public Grafo Consultar_grafo()
    {
    	return g;
    }
}

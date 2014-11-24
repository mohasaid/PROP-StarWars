import java.util.ArrayList;

public class Entrada {
	private Grafo g;
	
    //Pre: Cierto
    //Post: Crea una entrada con el grafo inicializado a partir de de la lista de nodos y otra de arcos
    public Entrada(ArrayList<ArrayList<Pair<Arco, Integer>>> aap) throws Exception
    {
    	g = new Grafo(aap);
    }
    
    //Pre: Cierto
    //Post: Retorna el grafo g
    public Grafo Consultar_grafo()
    {
    	return g;
    }
}

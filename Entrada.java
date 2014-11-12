import java.util.*;

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
    public Entrada(Pair<List<Arco>, List<Nodo> > gr)
    {
    	g = new Grafo(gr.consultarSegundo() , gr.consultarPrimero());
    }
    
    
}

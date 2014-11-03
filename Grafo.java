import java.util.ArrayList;
import java.util.Iterator;

public class Grafo {
    private ArrayList<Nodo> nodos;
    private ArrayList<Arco> arcos;
    
    public Grafo(ArrayList<Nodo> n, ArrayList<Arco> a) {
    	nodos = n;
    	arcos = a;
    }

    public Arco acroEntreNodos(Nodo origin, Nodo destination)
    {
    	Iterator<Arco> it = arcos.iterator();
    	while(it.hasNext()) {
    		Arco actual = it.next();
    		if(actual.ConsultarOrigen().consultar_id() == origin.consultar_id() && actual.ConsultarDestino().consultar_id() == destination.consultar_id()) return actual;
    	}
    	return null;
    }
    
    public ArrayList<Nodo> getNodes() {
        return nodos;
    }

    public void setNodes(ArrayList<Nodo> nodes) {
        this.nodos = nodes;
    }

    public ArrayList<Arco> getEdges() {
        return arcos;
    }

    public void setEdges(ArrayList<Arco> edges) {
        this.arcos = edges;
    }

}

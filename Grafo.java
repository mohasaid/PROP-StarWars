import java.util.ArrayList;
import java.util.Iterator;

public class Grafo {
    private ArrayList<Nodo> nodos;
    private ArrayList<Arco> arcos;
    
    
    public Grafo()
    {
    	nodos = new ArrayList<Nodo>();
    	arcos = new ArrayList<Arco>();
    }
    
    public Grafo(ArrayList<Nodo> n, ArrayList<Arco> a) 
    {
    	nodos = new ArrayList<Nodo>(n);
    	arcos = new ArrayList<Arco>(a);
    }

    public ArrayList<Arco> getArcosEntreNodos(Nodo origin, Nodo destination)
    {
    	Iterator<Arco> it = arcos.iterator();
    	ArrayList<Arco> ar = new ArrayList<Arco>();
    	while(it.hasNext()) {
    		Arco actual = it.next();
    		if(actual.ConsultarOrigen().consultar_id() == origin.consultar_id() && actual.ConsultarDestino().consultar_id() == destination.consultar_id()) ar.add(actual);
    	}
    	return ar;
    }
    
    public void setArcoEntreNodos(Nodo origin, Nodo destination, Arco a)
    {
    	a.ModificarOrigen(origin);
    	a.ModificarDestino(destination);
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
    
    public void addNodo(Nodo n)
    {
    	nodos.add(n);
    }
    
    public void addArco(Arco a)
    {
    	arcos.add(a);
    }
}

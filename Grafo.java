import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grafo {
    private ArrayList<Nodo> nodos;
    private ArrayList<Arco> arcos;
    
    public Grafo()
    {
    	nodos = new ArrayList<Nodo>();
    	arcos = new ArrayList<Arco>();
    }
    
    public Grafo(List<Nodo> list, List<Arco> list2) 
    {
    	nodos = new ArrayList<Nodo>(list);
    	arcos = new ArrayList<Arco>(list2);
    }
    
    public ArrayList<Arco> getArcoEntreNodos(Nodo origin, Nodo destination)
    {
    	Iterator<Arco> it = arcos.iterator();
    	ArrayList<Arco> arcs = new ArrayList<Arco>();
    	Arco actual;
    	while(it.hasNext()) {
    		actual = it.next();
    		if(actual.ConsultarOrigen().consultar_id() == origin.consultar_id() && actual.ConsultarDestino().consultar_id() == destination.consultar_id()) {
    			arcs.add(actual);
    		}
    	}
    	return arcs;
    }
    
    public void setArcoEntreNodos(Nodo origin, Nodo destination, Arco a)
    {
    	a.ModificarOrigen(origin);
    	a.ModificarDestino(destination);
    }
    
    public Nodo consultarNodo(int id)
    {
    	for(int i = 0; i < nodos.size(); ++i) {
    		if(nodos.get(i).consultar_id() == id) return nodos.get(i);
    	}
    	return null;
    }
    
    public Arco consultarArco(int id)
    {
    	for(int i = 0; i < arcos.size(); ++i) {
    		if(arcos.get(i).ConsultarId() == id) return arcos.get(i);
    	}
    	return null;
    }
    
    public ArrayList<Nodo> getNodes() {
        return nodos;
    }
    
    public void ponNodes(ArrayList<Nodo> nodes) {
        nodos = nodes;
    }
    
    public ArrayList<Arco> getEdges() {
        return arcos;
    }
    
    public void ponEdges(ArrayList<Arco> edges) {
        arcos = edges;
    }
    
    public void addNodo(Nodo n)
    {
    	nodos.add(n);
    }
    
    public void addArco(Arco a)
    {
    	arcos.add(a);
    }
    
    public ArrayList<Nodo> consultarNodos()
    {
    	return nodos;
    }
    
    public ArrayList<Arco> consultarArcos()
    {
    	return arcos;
    }
}

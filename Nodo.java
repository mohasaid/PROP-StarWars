import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	private List<Pair<Arco, Integer> > a;
     
    //CREADORA
     
    /**
     * Metodo para crear un nodo vacio
     */
    public Nodo()
    {
        a = new ArrayList<Pair<Arco,Integer> >();
    }
     
    /**
     * Metodo para crear un nodo con una lista de adyacencia "p"
     * @param p
     */
    public Nodo(List<Pair<Arco,Integer> > p)
    {
        a = p;
    }
    
    // CONSULTORAS
    
    /**
     * Metodo para consultar el arco que une el nodo actual con el i-esimo de la lista de adyacencia
     * @param i
     * @return El arco que une el nodo con el i-esimo de su lista de adyacencia
     */
    public Arco consultarArco(int i)
    {
    	return a.get(i).consultarPrimero();
    }
    
    /**
     * Metodo para consultar el identificador del i-esimo nodo al que esta conectado
     * @param i
     * @return Identificador del i-esimo nodo al que esta conectado
     */
    public int consultarDestino(int i)
    {
    	return a.get(i).consultarSegundo();
    }
    
    /**
     * Metodo para consultar el arco que une el nodo actual con el nodo "u"
     * @param u
     * @return El arco que une al nodo "u"
     */
    public Arco consultarArcoDet(int u)
    {
    	for(int i = 0; i < a.size(); ++i) {
    		if(a.get(i).consultarSegundo() == u) return a.get(i).consultarPrimero();
    	}
		return null;
    }
    
    /**
     * Metodo para consultar la adyacencia i-esima
     * @param i
     * @return Pair i-esimo
     */
    public Pair<Arco, Integer> consultarI(int i)
    {
    	return a.get(i);
    }
    
    /**
     * Metodo para consultar la adyacencia con el nodo u
     * @param u
     * @return Pair que une con el nodo u
     */
    public Pair<Arco, Integer> consultarIU(int u)
    {
    	for(int i = 0; i < a.size(); ++i) {
    		if(a.get(i).consultarSegundo() == u) return a.get(i);
    	}
    	return null;
    }
    
    /**
     * Metodo para consultar el numero de adyacencias del nodo
     * @return Numero de adyacencias del nodo
     */
    public int size()
    {
    	return a.size();
    }
    
    /**
     * Metodo para consultar el conjunto de adyacencias
     * @return Conjunto de adyacencias
     */
    public List<Pair<Arco, Integer> > consultarNodo()
    {
    	return a;
    }
    
    // MODIFICADORAS
    
    /**
     * Metodo para modificar el arco de la i-esima adyacencia
     * @param i
     * @param p
     */
    public void anadirArcoI(int i, Arco p)
    {
    	a.get(i).ponPrimero(p);
    }
    
    /**
     * Metodo para modificar el destino de la i-esima adyacencia
     * @param i
     * @param u
     */
    public void anadirDestinoI(int i, int u)
    {
    	a.get(i).ponSegundo(u);
    }
    
    /**
     * Metodo para modificar el arco de la adyacencia con el nodo u
     * @param u
     * @param p
     */
    public void anadirArco(int u, Arco p)
    {
    	for(int i = 0; i < a.size(); ++i) {
    		if(a.get(i).consultarSegundo() == u) a.get(i).ponPrimero(p);
    	}
    }
    
    /**
     * Metodo para anadir una adyacencia
     * @param p
     */
    public void anadirPair(Pair<Arco, Integer> p)
    {
    	a.add(p);
    }
    
}

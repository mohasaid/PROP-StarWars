import java.util.ArrayList;

public class Grafo {
	
	// i = id nodo origen , [i][j].second = destino nodo i, [i][j].first.first = capacidad , [i][j].first.second = coste
	private ArrayList<ArrayList<Pair<Arco,Integer> > > g;
	
	/**
	 * Creadora vacia de un grafo
	 */
    public Grafo()
    {
    	g = new ArrayList<ArrayList<Pair<Arco,Integer> > >(); 
    }
    
    /**
     * Creadora por defecto de un grafo
     * @param ar
     */
    public Grafo(ArrayList<ArrayList<Pair<Arco,Integer> > > ar) 
    {
    	g = ar;
    }
    
    /**
     * Metodo para consultar la lista de adyacencia del nodo u
     * @param u
     * @return Lista de adyacencia del nodo u
     */
    public ArrayList<Pair<Arco,Integer> > consultarCosteDestinos(int u)
    {
    	return g.get(u);
    }
    
    /**
     * Mmetodo para consultar la arista que une el nodo u con su i-esima adyacencia
     * @param u
     * @param i
     * @return Arista que une el nodo u con su i-esima adyacencia
     */
    public Arco consultarPrim(int u, int i)
    {
    	return g.get(u).get(i).consultarPrimero();
    }
    
    /**
     * Metodo para anadir una arista entre el nodo u y su i-esima adyacencia
     * @param u
     * @param i
     * @param p
     */
    public void ponPrim(int u, int i, Arco p)
    {
    	g.get(u).get(i).ponPrimero(p);
    }
    
    /**
     * Metodo para anadir una arista entre el nodo u y el nodo v
     * @param u
     * @param v
     * @param p
     */
    public void ponEnVer(int u, int v, Arco p)
    {
    	int tmp = 0;
    	boolean trobat = false;
    	for(int i = 0; i < g.get(u).size() && !trobat; ++i) {
    		if(g.get(u).get(i).consultarSegundo() == v) {
    			tmp = i;
    			trobat = true;
    		}
    	}
    	g.get(u).get(tmp).ponPrimero(p);
    }
    
    /**
     * Metodo para poner una modificar la capacidad de la arista que une el nodo u y el nodo v
     * @param u
     * @param v
     * @param cap
     */
    public void ponEnVerAr(int u, int v, int cap)
    {
    	int tmp = 0;
    	boolean trobat = false;
    	for(int i = 0; i < g.get(u).size() && !trobat; ++i) {
    		if(g.get(u).get(i).consultarSegundo() == v) {
    			tmp = i;
    			trobat = true;
    		}
    	}
    	Arco c = g.get(u).get(tmp).consultarPrimero();
    	c.ModificarCapacidad(cap);
    	g.get(u).get(tmp).ponPrimero(c); // modifico capacidad del arco
    }
    
    /**
     * Metodo para modificar el nodo destino i-esimo del nodo u
     * @param u
     * @param i
     * @param val
     */
    public void ponSeg(int u, int i, int val)
    {
    	g.get(u).get(i).ponSegundo(val);
    }
    
    /**
     * Metodo para anadir una arista y un destino del nodo u en su i-esima adyacencia
     * @param u
     * @param i
     * @param p
     */
    public void ponGeneral(int u, int i, Pair<Arco,Integer> p) {
    	g.get(u).get(i).ponPrimero(p.consultarPrimero());
    	g.get(u).get(i).ponSegundo(p.consultarSegundo());
    }
    
    /**
     * Metodo para consultar el nodo adyacente i-esimo del nodo u
     * @param u
     * @param i
     * @return Nodo i-esimo adyacente al nodo u
     */
    public Integer consultarSeg(int u, int i)
    {
    	return g.get(u).get(i).consultarSegundo();
    }
    
    /**
     * Metodo para consultar la adyacencia i-esima del nodo u
     * @param u
     * @param i
     * @return Adyacencia i-esima del nodo u
     */
    public Pair<Arco,Integer> consultaPair(int u, int i)
    {
    	return g.get(u).get(i);
    }
    
    /**
     * Metodo para consultar la adyacencia que conecta los nodos u y v
     * @param u
     * @param v
     * @return La adyacencia entre nodos u y v
     */
    public Pair<Arco,Integer> consultaPairUn(int u, int v)
    {
    	int tmp = 0;
    	boolean trobat = false;
    	for(int i = 0; i < g.get(u).size() && !trobat; ++i) {
    		if(g.get(u).get(i).consultarSegundo() == v) {
    			tmp = i;
    			trobat = true;
    		}
    	}
    	return g.get(u).get(tmp);
    }
    
    /**
     * Metodo para consultar el grafo
     * @return El grafo
     */
    public ArrayList<ArrayList<Pair<Arco, Integer> > > consultarGrafo()
    {
    	return g;
    }
    
    /**
     * Metodo para consultar el tamaño del grafo
     * @return El tamaño del grafo
     */
    public int sizeGrafo() 
    {
    	return g.size();
    }
    
    /**
     * Metodo para consultar el numero de adyacencias del nodo u
     * @param u
     * @return Numero de adyacencias del nodo u
     */
    public int sizeGrafo(int u)
    {
    	return g.get(u).size();
    }
    
}

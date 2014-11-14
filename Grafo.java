import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grafo {
	
	private ArrayList<ArrayList<Pair<Integer, Integer> > > g; // Nodo u -> g[u][i].first = coste para ir a g[u][i].second = destino
    
    public Grafo()
    {
    	g = new ArrayList<ArrayList<Pair<Integer,Integer> > >(); 
    }
    
    public Grafo(ArrayList<ArrayList<Pair<Integer,Integer> > > ar) 
    {
    	g = ar;
    }
    
    public ArrayList<Pair<Integer, Integer>> consultarCosteDestinos(int u)
    {
    	return g.get(u);
    }
    
    public Integer consultarPrim(int u, int i)
    {
    	return g.get(u).get(i).consultarPrimero();
    }
    
    public void ponPrim(int u, int i, int val)
    {
    	g.get(u).get(i).ponPrimero(val);
    }
    
    public void ponSeg(int u, int i, int val)
    {
    	g.get(u).get(i).ponSegundo(val);
    }
    
    public Integer consultarSeg(int u, int i)
    {
    	return g.get(u).get(i).consultarSegundo();
    }
    
    public Pair<Integer, Integer> consultaPair(int u, int i)
    {
    	return g.get(u).get(i);
    }
    
    public ArrayList<ArrayList<Pair<Integer, Integer> > > consultarGrafo()
    {
    	return g;
    }
    
    public int sizeGrafo() 
    {
    	return g.size();
    }
    
    public int sizeGrafo(int u)
    {
    	return g.get(u).size();
    }
}

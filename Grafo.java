import java.util.ArrayList;

public class Grafo {
	
	// i = id nodo origen , [i][j].second = destino nodo i, [i][j].first.first = capacidad , [i][j].first.second = coste
	private ArrayList<ArrayList<Pair<Arco,Integer> > > g;
	
    public Grafo()
    {
    	g = new ArrayList<ArrayList<Pair<Arco,Integer> > >(); 
    }
    
    public Grafo(ArrayList<ArrayList<Pair<Arco,Integer> > > ar) 
    {
    	g = ar;
    }
    
    public ArrayList<Pair<Arco,Integer> > consultarCosteDestinos(int u)
    {
    	return g.get(u);
    }
    
    public Arco consultarPrim(int u, int i)
    {
    	return g.get(u).get(i).consultarPrimero();
    }
    
    public void ponPrim(int u, int i, Arco p)
    {
    	g.get(u).get(i).ponPrimero(p);
    }
    
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
    
    public void ponSeg(int u, int i, int val)
    {
    	g.get(u).get(i).ponSegundo(val);
    }
    
    public void ponGeneral(int u, int i, Pair<Arco,Integer> p) {
    	g.get(u).get(i).ponPrimero(p.consultarPrimero());
    	g.get(u).get(i).ponSegundo(p.consultarSegundo());
    }
    
    public Integer consultarSeg(int u, int i)
    {
    	return g.get(u).get(i).consultarSegundo();
    }
    
    public Pair<Arco,Integer> consultaPair(int u, int i)
    {
    	return g.get(u).get(i);
    }
    
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
    
    public ArrayList<ArrayList<Pair<Arco, Integer> > > consultarGrafo()
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

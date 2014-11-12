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
    public Entrada(ArrayList<Nodo> nodos, ArrayList<Arco> arcos)
    {
    	g = new Grafo(nodos, arcos);
    }
    
    
    /*                       ******************EN PRINCIPIO ESO LO TIENE MOHA*************************
    //Pre: Cierto
    //Post: Retorna un nodo que representa el planeta p	
	public Nodo transformar_PlanetaaNodo(Planeta p)
	{
		Nodo n = new Nodo(p.Consultar_id(), p.Consultar_Fuente, p.Consultar_Sumidero); //on els dos ultims paramentres son booleans
		return n;
	}
	
    //Pre: El planeta p existe en la galaxia
    //Post: El nodo n, que representa el planeta p, se ha aÃ±adido en el grafo g
	public  void afegir_planeta(Planeta p)
	{
		Nodo n = transformar_PlanetaaNodo(p);
		g.addNodo(n);
	}
	
    //Pre: La ruta r existe en la galaxia
    //Post: El arco a, que representa la ruta r, se ha aÃ±adido en el grafo g
	public void afegir_ruta(Ruta r, ControladorPlaneta cp)
	{
		Planeta origen = cp.BuscarPlaneta( r.consultar_planetaA() );
		Planeta desti = cp.BuscarPlaneta( r.consultar_planetaB() );
		Nodo o = transformar_PlanetaaNodo(origen);
		Nodo d = transformar_PlanetaaNodo(desti);
		Arco a = new Arco(, o, d, r.consultar_capacidad(), r.consultar_id());
		g.addArco(a);		
	}*/
}

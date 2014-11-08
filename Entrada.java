import java.util.*;

public class Entrada {
	public Nodo transformar_PlanetaaNodo(Planeta p)
	{
		Nodo n = new Nodo(p.Consultar_id(), p.Consultar_Fuente, p.Consultar_Sumidero); //on els dos ultims paramentres son bools
		return n;
	}
	
	public  void afegir_planeta(Planeta p, Graf g)
	{
		Nodo n = transformar_PlanetaaNodo(p);
		g.afegir_node(n);
	}
	
	public void afegir_ruta(Ruta r, Graf g, ControladorPlaneta cp)
	{
		Planeta origen = cp.BuscarPlaneta( r.consultar_planetaA() );
		Planeta desti = cp.BuscarPlaneta( r.consultar_planetaB() );
		Nodo o = transformar_PlanetaaNodo(origen);
		Nodo d = transformar_PlanetaaNodo(desti);
		Arco a = new Arco(r.consultar_id(), o, d, r.consultar_capacidad());
		g.afegir_arc(a);		
	}
}

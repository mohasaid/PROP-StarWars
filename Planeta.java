import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
  
public class Planeta
{
    private int idPlaneta; //Identificador del planeta
    private int Coste; //Precio del combustible del planeta.
    private Pair<Integer,Integer> Coordenadas; //Coordenadas del planeta en la galaxia
     
    // Pre: Cierto.
    // Post: Crea un planeta vacio.
    public Planeta() 
    {
        idPlaneta = -1; //No se le ha asignado un identificador 
        Coste = -1;
        Coordenadas = new Pair<Integer,Integer>(-1, -1); //No se le han asignado coordenadas
    }
    // Pre: Cierto.
    // Post: Crea un planeta con idPlaneta = id, Coste = k, Coordenadas = Coo, F indica si es Fuente y S si es Sumidero.
    public Planeta(int id, int k, Pair<Integer,Integer> Coo) throws Exception
    {
        if (k < 0) throw new Exception ("Error: El Coste no puede ser negativo\n");
        idPlaneta = id;
        Coste = k;
        Coordenadas = new Pair<Integer, Integer> (Coo.consultarPrimero(), Coo.consultarSegundo());
    }
    //Pre: Cierto.
    //Post: Retorna la id del planeta
    public int Consultar_id() throws Exception
    {
        if(idPlaneta == -1) throw new Exception ("Error: El planeta no tiene una id asignada\n");
        else return idPlaneta;
    }
    //Pre: Cierto.
    //Post: Retorna el Coste del planeta.
    public int Consultar_Coste() throws Exception
    {
        if(Coste == -1) throw new Exception ("Error: Al Planeta no se le ha asignado ningun Coste\n");
        return Coste;
    }
    //Pre: Cierto.
    //Post: Retorna las Coordenadas del planeta.
    public Pair<Integer,Integer> consultar_coordenades() //No se como funciona en pairs
    {
        return Coordenadas;
    }
    //Pre: Cierto.
    //Post: Retorna la primera coordenada del planeta.
    public int consultar_X() 
    {
        return Coordenadas.consultarPrimero();
    }
    
    //Pre: Cierto.
    //Post: Retorna la segunda coordenada del planeta.
    public int consultar_Y() 
    {
        return Coordenadas.consultarSegundo();
    }
    //Pre: Cierto.
    //Post: Modifica el coste Coste, Coste = k.
    public void Modificar_Coste(int k) throws Exception
    {
        if (k < 0) throw new Exception("Error: El Coste del Planeta no puede ser negativo\n");
        else Coste = k;
    }
    //Pre: Cierto.
    //Post: Modifica las Coordenadas. 
    public void modificarCoordenades(int rndX, int rndY) throws Exception
    {
    	if(rndX < -1 || rndY < -1) throw new Exception ("Error: Las Coordenadas no pueden ser negativas\n");
    	else {
    		Coordenadas.ponPrimero(rndX);
    		Coordenadas.ponSegundo(rndY);
    	}
    }
    //Pre: Cierto.
    //Post: Se elimina el planeta.
    public void Borrar() throws Exception
    {
        idPlaneta = -1;
        Coste = -1;
    }
}

class OrdenPlaneta implements Comparator<Planeta>{
    public int compare(Planeta p1, Planeta p2) {
        try {
			if(p2.Consultar_id() < (p1.Consultar_id())) return 1;
			else return -1;
		} 
        catch (Exception e) {
        	System.out.print(e);
		}
		return 0;
    }
} 

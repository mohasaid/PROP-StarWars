import java.util.Comparator;
  
public class Planeta
{
    private String nombrePlaneta; //Identificador del planeta
    private int Coste; //Precio del combustible del planeta.
    private Pair<Integer,Integer> Coordenadas; //Coordenadas del planeta en la galaxia
    
    private boolean alfa_numeric(String nom)
    {
        if(nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for(int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if(!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
    
    // Pre: Cierto.
    // Post: Crea un planeta con nombrePlaneta = n , Coste = k, Coordenadas = Coo, F indica si es Fuente y S si es Sumidero.
    public Planeta(String n, int k, Pair<Integer,Integer> Coo) throws Exception
    {
        if(!alfa_numeric(n)) throw new Exception ("Error: El nombre de un Planeta tiene que ser alfanumerico\n");
    	if (k < 0) throw new Exception ("Error: El Coste no puede ser negativo\n");
        nombrePlaneta = n;
        Coste = k;
        Coordenadas = new Pair<Integer, Integer> (Coo.consultarPrimero(), Coo.consultarSegundo());
    }
    //Pre: Cierto.
    //Post: Retorna la id del planeta
    public String Consultar_nombre()
    {
        return nombrePlaneta;
    }
    //Pre: Cierto.
    //Post: Retorna el Coste del planeta.
    public int Consultar_Coste() 
    {
        return Coste;
    }
    //Pre: Cierto.
    //Post: Retorna las Coordenadas del planeta.
    public Pair<Integer,Integer> consultar_coordenades()
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
        Coste = k;
    }
    
    //Pre: Cierto.
    //Post: Modifica las Coordenadas. 
    public void modificarCoordenades(int rndX, int rndY) throws Exception
    {
    	if(rndX < 0 || rndY < 0) throw new Exception ("Error: Las Coordenadas no pueden ser negativas\n");
    		Coordenadas.ponPrimero(rndX);
    		Coordenadas.ponSegundo(rndY);
    }
}

class OrdenPlaneta implements Comparator<Planeta>{
	 public int compare(Planeta a, Planeta b) {
	     String s1, s2;
	     s1 = a.Consultar_nombre();
	     s2 = b.Consultar_nombre();
		 return s1.compareTo(s2);
	 }
} 

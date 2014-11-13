import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
  
public class Planeta
{
    private int idPlaneta; //Identificador del planeta
    private int Capacidad; //No. de naves que pueden repostar
    private int Coste; //Precio del combustible del planeta.
    private boolean Fuente; //Los booleanos se inicializan a false. 
    private boolean Sumidero; //Los booleanos se inicializan a false. 
    private Pair<Integer,Integer> Coordenadas; //Coordenadas del planeta en la galaxia
    private TreeSet<Integer> LRS; //Lista de rutas que salen del planeta.
    private TreeSet<Integer> LRE; //Lista de rutas que entran en el planeta.
     
    //Pre: Cierto.
    //Post: Retorna la fusion entre A y B.
    private static TreeSet<Integer> TreeSetFusion (TreeSet<Integer> A, TreeSet<Integer> B) {
        TreeSet<Integer> Final = new TreeSet<Integer>();
        Iterator<Integer> it = A.iterator();
        while(it.hasNext()) {
            Final.add(it.next());
        }
        it = B.iterator();
        while(it.hasNext()) {
            Final.add(it.next());
        }
        return Final;
    }
    // Pre: Cierto.
    // Post: Crea un planeta vacio.
    public Planeta() 
    {
        idPlaneta = -1; //No se le ha asignado un identificador 
        Capacidad = -1; //No se le han asignado rutas ha este planeta por lo tanto no tiene capacidad
        Coste = -1;
        Coordenadas = new Pair<Integer,Integer>(-1, -1); //No se le han asignado coordenadas
        LRS = new TreeSet<Integer>(); //No hay rutas que salgan del planeta
        LRE = new TreeSet<Integer>(); //No hay rutas que entren al planeta
    }
    // Pre: Cierto.
    // Post: Crea un planeta con idPlaneta = id, Coste = k, Coordenadas = Coo, F indica si es Fuente y S si es Sumidero.
    public Planeta(int id, int k, Pair<Integer,Integer> Coo, boolean F, boolean S) throws Exception
    {
        if (k < 0) throw new Exception ("Error: El Coste no puede ser negativo\n");
        idPlaneta = id;
        Capacidad = 0; // Viene definida por las rutas por lo tanto no puede haber error
        Coste = k;
        Fuente = F;
        if(F) Capacidad = Integer.MAX_VALUE; //El Planeta  Fuente no puede tener rutas que entren a el por definicion por lo tanto tendria capacidad 0, nosotros consideramos que tiene capacidad "infinita" para que sea coherente
        Sumidero = S;
        Coordenadas = new Pair<Integer, Integer> (Coo.consultarPrimero(), Coo.consultarSegundo());
        if(!S) LRS = new TreeSet<Integer>(); //Un Planeta Sumidero no puede tener rutas que salgan de el por lo tanto no tendra lista de rutas de salida
        if(!F)LRE = new TreeSet<Integer>(); //Un Planeta Fuetne no puede tener rutas que entren a el por lo tanto no tendra lista de rutas de entrada
    }
    //Pre: Cierto.
    //Post: Retorna la id del planeta
    public int Consultar_id() throws Exception
    {
        if(idPlaneta == -1) throw new Exception ("Error: El planeta no tiene una id asignada\n");
        else return idPlaneta;
    }
    //Pre: Cierto.
    //Post: Retorna la Capacidad del planeta.
    public int Consultar_Capacidad() throws Exception
    {
        if(Capacidad == -1) throw new Exception ("Error: El Planeta no tiene una Capacidad asignada\n"); 
        return Capacidad;
    }
    //Pre: Cierto.
    //Post: Retorna el Coste del planeta.
    public int Consultar_Coste() throws Exception
    {
        if(Coste == -1) throw new Exception ("Error: Al Planeta no se le ha asignado ningun Coste\n");
        return Coste;
    }
    //Pre: Cierto.
    //Post: Retorna true si el planeta es Fuente.
    public boolean Consultar_Fuente(){
    	return Fuente;
    }
    //Pre: Cierto.
    //Post: Retorna true si el planeta es Sumidero.
    public boolean Consultar_Sumidero(){
    	return Sumidero;
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
    //Post: Retorna las rutas que salen del planeta.
    public TreeSet<Integer> Consultar_RutasSalida() throws Exception {
    	if(Sumidero) throw new Exception ("Error: El Planeta es Sumidero y no tiene Rutas de Salida\n");
    	else return LRS;
    }
    //Pre: Cierto.
    //Post: Retorna las rutas que salen del planeta.
    public TreeSet<Integer> Consultar_RutasEntrada() throws Exception {
        if(Fuente) throw new Exception ("Error: El Planeta es Fuente y no tiene Rutas de Entrada\n");
        else return LRE;
    }
    //Pre: Cierto.
    //Post: Retorna las rutas que conecta este planeta
    public TreeSet<Integer> consultarRutasConecta() throws Exception {
    	if(Fuente && !Sumidero) return LRS;
    	else if(Sumidero && !Fuente) return LRE;
    	else if(!Fuente && !Sumidero){
    		TreeSet<Integer> rutes_conecto = new TreeSet<Integer>();
    		rutes_conecto = TreeSetFusion(LRE, LRS);
    		return rutes_conecto;
    	}
    	else throw new Exception ("El Planeta no tiene Rutas porque es Fuente y Sumidero\n");
    }
    //Pre: Cierto.
    //Post: Modifica la id del planeta, idPlaneta = id.
    public void Modificar_id(int id) throws Exception {
    	if(id < 0) throw new Exception ("Error: Un identificador de un Planeta debe ser un entero positivo\n");
    	else idPlaneta = id;
    }
    //Pre: Cierto.
    //Post: Modifica el coste Coste, Coste = k.
    public void Modificar_Coste(int k) throws Exception
    {
        if (k < 0) throw new Exception("Error: El Coste del Planeta no puede ser negativo\n");
        else Coste = k;
    }
    //Pre: Cierto.
    //Post: Modifica la Capacidad, Capacidad = c.
    public void modificarCapacidad(int c) throws Exception 
    {
    	if(c < 0) throw new Exception("Error: La capacidad no puede ser negativa\n");
    	else if(Fuente) throw new Exception ("Error: La Capacidad de un Planeta Fuente no se puede modificar\n");
    	else Capacidad = c;
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
    //Pre: fu = 1 o 0.
    //Post: Modifica Fuente, si fu = 1 Fuente = true, si fu = 0 Fuetne = false.
    public void Modificar_Fuente(int fu) throws Exception {
    	if(fu == 0) Fuente = false;
    	else if (fu == 1) Fuente = true;
    	else throw new Exception("Error: Si es Fuente se indica con un 1 y si no lo es con un 0\n");
    }
    //Pre: su = 1 o 0.
    //Post: Modifica Sumidero, si su = 1 Sumidero = true, si su = 0 Sumidero = false. 
    public void Modificar_Sumidero(int su) throws Exception {
    	if(su == 0) Sumidero = false;
    	else if (su == 1) Sumidero = true;
    	else throw new Exception("Error: Si es Sumidero se indica con un 1 y si no lo es con un 0\n");
    }
    //Pre: Cierto
    //Post: Anade la id de una ruta que sale del planeta a la lista de rutas que salen del planeta.
    public void Anadir_Salida(int id) throws Exception
    {
    	if(Sumidero) throw new Exception("Error: El Planeta es Sumidero y no puede tener Rutas que salgan de el\n");
    	else LRS.add(id);
    }  
    //Pre: Cierto
    //Post: Anade la id de una ruta que entra en el planeta a la lista de rutas que entran en el planeta.
    public void Anadir_Entrada(int id) throws Exception
    {
    	if(Fuente) throw new Exception("Error: El Planeta es Fuente y no puede tener Rutas que entren a el\n");
    	else LRE.add(id);
    }    
    //Pre: Cierto
    //Post: Borra la id de la ruta "id" que sale del planeta de la lista de rutas que salen del planeta.
    public void Borrar_Salida(int id) throws Exception
    {
    	if(Sumidero) throw new Exception("Error: El Planeta es Sumiedro y no tiene Rutas que salgan de el\n");
    	if(LRS.isEmpty()) throw new Exception("Error: El Planeta no tiene Rutas que salen de el\n");
    	else LRS.remove(id);
    }
    //Pre: Cierto.
    //Post: Borra la id de la ruta "id" que entra en el planeta de la lista de rutas que entran del planeta.
    public void Borrar_Entrada(int id) throws Exception
    {
    	if(Fuente) throw new Exception("Error: El Planeta es Fuente y no tiene Rutas que entren a el\n");
    	if(LRE.isEmpty()) throw new Exception("Error: El Planeta no tiene Rutas que entren a el\n");
    	else LRE.remove(id);
    }  
    //Pre: Cierto.
    //Post: Se elimina el planeta.
    public void Borrar() throws Exception
    {
        idPlaneta = -1;
        Capacidad = -1;
        Coste = -1;
        LRS.clear();
        LRE.clear();
        Fuente = false;
        Sumidero = false;
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

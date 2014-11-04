import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
  
public class Planeta
{
    private int idPlaneta; //Identificador del planeta
    private int Capacidad; //No. de naves que pueden repostar
    private int Coste; //Precio del combustible del planeta.
    //private boolean Fuente; //Los booleanos se inicializan a false. 
    //private boolean Sumidero; //Los booleanos se inicializan a false. 
    private Pair<Integer,Integer> Coordenadas; //Coordenadas del planeta en la galaxia
    private TreeSet<Integer> LRS; //Lista de rutas que salen del planeta.
    private TreeSet<Integer> LRE; //Lista de rutas que entran en el planeta.
    private TreeSet<Integer> LNaves; //Lista de naves que estan en el planeta.
     
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
    // Post: Crea un planeta con idPlaneta = id, Capacidad = c, Coste = k y Coordenadas = Coo.
    public Planeta(int id, int k, Pair<Integer,Integer> Coo, boolean F, boolean S) throws Exception
    {
        if (k < 0) throw new Exception ("Error: El Coste no puede ser negativo");
        idPlaneta = id;
        Capacidad = 0; // Viene definida por las rutas por lo tanto no puede haber error
        Coste = k;
        Fuente = F;
        Sumidero = S;
        Coordenadas.setFirst(Coo.getFirst());
        Coordenadas.setSecond(Coo.getSecond());
        LRS = new TreeSet<Integer>();
        LRE = new TreeSet<Integer>();
    }
     
    //Pre: Cierto.
    //Post: Retorna la id del planeta
    public int Consultar_id() throws Exception
    {
        if(idPlaneta == -1) throw new Exception ("Error: El planeta no tiene una id asignada");
        return idPlaneta;
    }
     
    //Pre: Cierto.
    //Post: Retorna la Capacidad del planeta.
    public int Consultar_Capacidad() throws Exception
    {
        if(Capacidad == -1) throw new Exception ("Error: El Planeta no tiene una Capacidad asignada"); 
        return Capacidad;
    }
 
    //Pre: Cierto.
    //Post: Retorna el Coste del planeta.
    public int Consultar_Coste() throws Exception
    {
        if(Coste == -1) throw new Exception ("Error: Al Planeta no se le ha asignado ningun Coste");
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
        return Coordenadas.getFirst();
    }
     
    //Pre: Cierto.
    //Post: Retorna la segunda coordenada del planeta.
    public int consultar_Y() 
    {
        return Coordenadas.getSecond();
    }
    //Pre: Cierto.
    //Post: Retorna las rutas que salen del planeta.
    public TreeSet<Integer> Consultar_RutasSalida() {
        return LRS;
    }
    //Pre: Cierto.
    //Post: Retorna las rutas que salen del planeta.
    public TreeSet<Integer> Consultar_RutasE() {
        return LRE;
    }
    //Pre: Cierto.
    //Post: Retorna las rutas que conecta este planeta
    public TreeSet<Integer> consultarRutasConecta() {
        TreeSet<Integer> rutes_conecto = new TreeSet<Integer>();
        rutes_conecto = TreeSetFusion(LRE, LRS);
        return rutes_conecto;
    }
    //Pre: Cierto.
    //Post: Retorna la lista de las naves que estan en el planeta.
    public TreeSet<Integer> ConsultarLNaves() {
        return LNaves;
    }
    //Pre: Cierto.
    //Post: Modifica la id del planeta, idPlaneta = id.
    public void Modificar_id(int id) {
        idPlaneta = id;
    }
    //Pre: Cierto.
    //Post: Modifica el coste Coste, Coste = k.
    public void Modificar_Coste(int k) throws Exception
    {
        if (k < 0) throw new Exception("Error: El Coste del Planeta no puede ser negativo");
        Coste = k;
    }
    
    public void modificarCapacidad(int c) throws Exception
    {
    	if(c < 0) throw new Exception("Error: La capacidad no puede ser negativa");
    	Capacidad = c;
    }
    //Pre: Cierto.
    //Post: Modifica las Coordenadas. 
    public void modificarCoordenades(int rndX, int rndY)
    {
        Coordenadas.setFirst(rndX);
        Coordenadas.setSecond(rndY);
    }
    //Pre: Cierto
    //Post: AÃ±ade la id de una ruta que sale del planeta a la lista de rutas que salen del planeta.
    public void Anadir_Salida(int id)
    {
        LRS.add(id);
    }
     
    //Pre: Cierto
    //Post: AÃ±ade la id de una ruta que entra en el planeta a la lista de rutas que entran en el planeta.
    public void Anadir_Entrada(int id)
    {
        LRE.add(id);
    }
 
    //Pre: Cierto
    //Post: Borra la id de la ruta "id" que sale del planeta de la lista de rutas que salen del planeta.
    public void Borrar_Salida(int id)
    {
        LRS.remove(id);
    }
 
    //Pre: Cierto.
    //Post: Borra la id de la ruta "id" que entra en el planeta de la lista de rutas que entran del planeta.
    public void Borrar_Entrada(int id)
    {
        LRE.remove(id);
    }
    
    //Pre: Cierto.
    //Post: Borra la id de la nave "id" que estaba en el planeta de la lista de naves que estan en el planeta.
    public void Borrar_Nave(int id) {
    	LNaves.remove(id);
    }
    //Pre: Cierto.
    //Post: Se elimina el planeta.
    public void Borrar()
    {
        idPlaneta = -1;
        Capacidad = -1;
        Coste = -1;
        LRS.clear();
        LRE.clear();
        LNaves.clear();
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

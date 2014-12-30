import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ControladorRuta {
    //PARTE PRIVADA
    private TST<Ruta> ArbolRutas;
    private TST<Conexion> Conexiones;
    private ControladorDadesRuta Cdr;
    private Iterator<Ruta> itc;
    private ArrayList<Ruta> lr;
    
    //Pre: Entra como parametro un numero entero
    //Post: Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
	/**
	 * Metodo para consultar si un entero es mayor o igual que 0
	 * @param i
	 * @return Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
	 */
    private static boolean ErrorTipografico(int i) {
    	return (i<0);
    }
    
    //Pre: Entra como parametro un string
    //Post: Rtorna un valor booleano. Es true en el caso que el string nom sea alfanumerico, en caso contrario, devuelve fasle
    /**
     * Metodo para consultar si string es alfanumerico
     * @param nom
     * @return Retorna un valor booleano. Es true en el caso que el string nom sea alfanumerico, en caso contrario, devuelve fasle
     */
    private static boolean alfa_numeric(String nom)
    {
        if(nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for(int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if(!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
    
    private int randInt(int min, int max)
    {
    	Random rand = new Random();
    	int randomNum = rand.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
    
    //Pre: Entra como parametros dos strings
    //Post: Te devuelve true en caso que se pueda crear una ruta del planeta idA al planeta idB, en caso contrario, devuelve false ya que no es posible crearla
    /**
     * Metodo para consultar si se puede crar una ruta del planeta idA al idB
     * @param idA
     * @param idB
     * @return Te devuelve true en caso que se pueda crear una ruta del planeta idA al planeta idB, en caso contrario, devuelve false ya que no es posible crearla
     * @throws Exception
     */
    private boolean Disponibilidad_crear_ruta (String idA, String idB) throws Exception
    {
    	if (idA.equals(idB)) return false;
    	ArrayList<Conexion> c = Conexiones.MostrarElementos();
		Iterator<Conexion> it = c.iterator();
		Conexion aux;
		while( it.hasNext() ){
			aux = it.next();
			if (aux.consultar_planetaA().equals(idA) && aux.consultar_planetaB().equals(idB)) return false; // ya existe esta ruta entre los dos planetas
			if (aux.consultar_planetaA().equals(idB) && aux.consultar_planetaB().equals(idA)) return false; // ya existe esta ruta entre los dos planetas
		}
		return true; 
    }
    
    //Pre: Cierto
    //Post: La conexion con id = "id" ha sido borrada del arbol de conexiones
    /**
     * Metodo para borrar una conexion determinada por un id
     * @param id
     * @throws Exception
     */
    private void Borrar_Conexion (int id) throws Exception
    {
    	String id2 = Integer.toString(id);
		Conexiones.eliminar(id2);
    }
    
    //Pre: Cierto
    //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
    /**
     * Metodo para borrar una ruta determinada por un id
     * @param id
     * @throws Exception
     */
    private void Borrar_Ruta (int id) throws Exception
    {
    	String id2 = Integer.toString(id);
		ArbolRutas.eliminar(id2);
    }
    
    //Pre: existe una ruta que va de planetaA a plaentaB
    //Post: retorna la id de la ruta que une planetaA a planetaB si no existe retorna un -1
    /**
     * Metodo para saber cual es la id de la ruta que va del planetaA al planetaB
     * @param planetaA
     * @param planetaB
     * @return  retorna la id de la ruta que une planetaA a planetaB, si no existe retorna un -1
     */
    public int Consultar_id_ruta(String planetaA, String planetaB)
    {
    	ArrayList<Conexion> c = Conexiones.MostrarElementos();
		Iterator<Conexion> it = c.iterator();
		Conexion aux;
		while( it.hasNext() ){
			aux = it.next();
			if (aux.consultar_planetaA().equals(planetaA) && aux.consultar_planetaB().equals(planetaB)) 
				return aux.consultar_id();
		}
		return -1; //quiere decir que no existe ruta que conecta esos dos planetas
    }

    //Pre: entra como parametro un entero
    //Post: retorna un booleano true si la ruta existe con id="id", en caso contrario retorna false
    /**
     * Metodo para sabes si una ruta existe
     * @param id
     * @return retorna un booleano true si la ruta existe con id="id", en caso contrario retorna false
     * @throws Exception
     */
    public boolean ExisteRuta(int id) throws Exception
    {
    	String id2 = Integer.toString(id);
    	return ArbolRutas.contains(id2);
    }
    
    //Pre: entra como parametro un entero
    //Post: retorna un booleano true si la conexion con id="id" existe, en caso contrario retorna false
    /**
     * Metodo para sabes si una conexion existe
     * @param id
     * @return retorna un booleano true si la conexion existe con id="id", en caso contrario retorna false
     * @throws Exception
     */
    public boolean ExisteConexion(int id) throws Exception
    {
    	String id2 = Integer.toString(id);
    	return Conexiones.contains(id2);
    }
    
    //pre: entra como parametro un entero
    //post: retorna la conexion que tiene identificador=id
    /**
     * Metodo para buscar una conexion
     * @param id
     * @return retorna la conexion que tiene identificador=id
     * @throws Exception
     */
    public Conexion BuscarConexion(int id) throws Exception
    {
    	String id2 = Integer.toString(id);
		return Conexiones.buscar(id2);
    }
      
    //pre: entra como parametro un entero
    //post: retorna la ruta que tiene identificador=id
    /**
     * Metodo para buscar una ruta
     * @param id
     * @return retorna la ruta que tiene identificador=id
     * @throws Exception
     */
    public Ruta BuscarRuta(int id) throws Exception
    {
    	String id2 = Integer.toString(id);
		return ArbolRutas.buscar(id2);
    }
      
    //CREADORAS
    
    //Pre: Cierto
    //Post: Retorna un controlador de ruta vacio
    /**
     * Metodo para crear un controlador de ruta vacio
     */
    public ControladorRuta()
    {
        ArbolRutas = new TST<Ruta>();
        Conexiones = new TST<Conexion>();
        Cdr = new ControladorDadesRuta();
    }
      
    //Pre: entran como parametros res enteros, dos strings, un booleano un controlador de Planeta
    //Post: Crea una ruta con id = "id", capacidad = "capacidad", distancia = "distancia", planetaA = "planetaA", planetaB = "planetaB", bidireccional = "bidireccional", y la aÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â±ade al sistema    
    /**
     * Metodo para crear una ruta de forma manual
     * @param id
     * @param capacidad
     * @param distancia
     * @param planetaA
     * @param planetaB
     * @param bidireccional
     * @param cp
     * @throws Exception
     */
    public void CrearRuta(int id, int capacidad, int distancia, String planetaA, String planetaB, ControladorPlaneta cp) throws Exception
    { 
        if(ExisteRuta(id)){
            throw new Exception("Error: Ya existe una ruta con el mismo identificador\n");       
        }
        if ( !cp.ExistePlaneta(planetaA) ) { 
            throw new Exception("Error: El Planeta con id = " + planetaA + " no existe\n");
        }
        if ( !cp.ExistePlaneta(planetaB) ) { 
            throw new Exception("Error: El Planeta con id = " + planetaB + " no existe\n");
        }
        if ( !Disponibilidad_crear_ruta(planetaA , planetaB) ) {
        	throw new Exception("La Ruta de " + planetaA + " a " + planetaB + " ja existeix \n");
        }
        if ( capacidad>100000 ) {
        	throw new Exception("La capacidad de la ruta tiene que ser menor o igual a 100.000 \n");
        }
        Ruta r = new Ruta(id,capacidad,distancia);
        Conexion c = new Conexion(id, planetaA, planetaB);
        
		ArbolRutas.add(Integer.toString(r.consultar_id()),r);
		Conexiones.add(Integer.toString(c.consultar_id()),c);
    }
      
    //Pre: entra como parametro un Controlador de planeta
    //Post: Crea una ruta de forma automatica y la anade al arbol de rutas
    /**
     * Metodo para crear una ruta de forma automatica
     * @param cp
     * @throws Exception
     */
    public void CrearRuta_automatica(ControladorPlaneta cp) throws Exception
    {
        Random aleatorio = new Random();
        int id = 0;
        while(ExisteRuta(id)) ++id; 
        int capacidad = randInt(1,1000);
        int distancia = randInt(1,1000);

        int aux;
    	aux = randInt(0,1000);
        aux = aux%cp.Consultar_Size();
        Planeta planetaA = cp.Consultar_PlanetaX(aux);
        
    	aux = randInt(0,1000);
        aux = aux%cp.Consultar_Size();
        Planeta planetaB = cp.Consultar_PlanetaX(aux);
	        
        while ( !Disponibilidad_crear_ruta(planetaA.Consultar_nombre() , planetaB.Consultar_nombre()) || planetaA.Consultar_nombre().equals(planetaB.Consultar_nombre()) )
        {
            aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
            planetaA = cp.Consultar_PlanetaX(aux);

            
            aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
            planetaB = cp.Consultar_PlanetaX(aux);
        }

        
        Ruta r = new Ruta(id,capacidad,distancia);
        Conexion c = new Conexion(id, planetaA.Consultar_nombre(), planetaB.Consultar_nombre());
		ArbolRutas.add(Integer.toString(r.consultar_id()),r);
		Conexiones.add(Integer.toString(c.consultar_id()),c);
    }
    
    //Pre: entran como parametros un controlador planeta y un entero
    //Post: Crea una ruta de forma automatica y la anade al arbol de rutas
    /**
     * Metodo para crear una ruta de forma automatica y un id concreto
     * @param cp
     * @param id
     * @throws Exception
     */
    public void CrearRuta_automatica(ControladorPlaneta cp, int id) throws Exception
    {
    	if (ExisteRuta(id)) {
    		throw new Exception("Error: Ya existe una ruta con el mismo identificador\n");
    	}
        Random aleatorio = new Random();
    	int capacidad = randInt(1,1000);
        int distancia = randInt(1,1000);

        int aux;
    	aux = randInt(0,1000);
        aux = aux%cp.Consultar_Size();
        Planeta planetaA = cp.Consultar_PlanetaX(aux);
        
    	aux = randInt(0,1000);
        aux = aux%cp.Consultar_Size();
        Planeta planetaB = cp.Consultar_PlanetaX(aux);
        
        while ( !Disponibilidad_crear_ruta(planetaA.Consultar_nombre() , planetaB.Consultar_nombre()) || planetaA.Consultar_nombre().equals(planetaB.Consultar_nombre()) )
        {
            aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
            planetaA = cp.Consultar_PlanetaX(aux);
            
            aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
            planetaB = cp.Consultar_PlanetaX(aux);
        }
        
        Ruta r = new Ruta(id,capacidad, distancia);
        Conexion c = new Conexion(id, planetaA.Consultar_nombre(), planetaB.Consultar_nombre());
        ArbolRutas.add(Integer.toString(r.consultar_id()),r);
        Conexiones.add(Integer.toString(c.consultar_id()),c);
    }
      
    //CONSULTORAS   
    
    //Pre: entra como parametro un entero
    //Post: Retorna la capacidad que tiene la ruta con id = "id"
    /**
     * 	Metodo para consultar la capacidad de una ruta determinada
     * @param id
     * @return Retorna la capacidad que tiene la ruta con id = "id"
     * @throws Exception
     */
    public int ConsultarCapacidadRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_capacidad();
    }
    
    //Pre: entra como parametro un entero
    //Post: Retorna la distancia que tiene la ruta con id = "id"
    /**
     * Metodo para consultar la distancia de una ruta determinada
     * @param id
     * @return Retorna la distancia que tiene la ruta con id = "id"
     * @throws Exception
     */
    public int ConsultarDistanciaRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_distancia();
    }
    
    //Pre: entra como parametro un entero
    //Post: Retorna el nombre del planetaA de la ruta con id = "id"
    /**
     * Metodo para consultar el planetaA de una ruta determinada
     * @param id
     * @return Retorna el nombre del planetaA de la ruta con id = "id"
     * @throws Exception
     */
    public String ConsultarPlanetaARuta(int id) throws Exception
    {
    	Conexion c = BuscarConexion(id);
        return c.consultar_planetaA();
    }
      
    //Pre: entra como parametro un entero
    //Post: Retorna el nombre del planetaB de la ruta con id = "id"
    /**
     * Metodo para consultar el planetaB de una ruta determinada
     * @param id
     * @return Retorna el nombre del planetaB de la ruta con id = "id"
     * @throws Exception
     */
    public String ConsultarPlanetaBRuta(int id) throws Exception
    {
    	Conexion c = BuscarConexion(id);
        return c.consultar_planetaB();
    }
           
    //Pre: Cierto
    //Post: Retorna el tamano del arbol de rutas
    /**
     * Metodo para consultar el numero de rutas hay
     * @return Retorna el tamano del arbol de rutas
     */
    public int Consultar_numero_rutes()
    {
    	return ArbolRutas.size();
    }
    
    
    //Pre: Cierto
    //Post: Retorna el arbol de conexiones
    /**
     * Metodo para consultar el arbol de conexiones
     * @return Retorna el arbol de conexiones
     */
    public TST<Conexion> Consultar_arbre_conexions()
    {
    	return Conexiones;
    }
    
    //Pre: Cierto
    //Post: Retorna un arraylist que contiene todos los ids de las rutas presentes
    /**
     * Metodo para consultar los id's de todas las rutas 
     * @return Retorna un arraylist que contiene todos los ids de las rutas presentes
     */
    public ArrayList<Integer> Consultar_ids_rutas()
    {
    	ArrayList<String> aux = ArbolRutas.ConsultarIdentificadores();
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	
    	Iterator<String> it = aux.iterator();
		
    	while (it.hasNext()) {
    		res.add( Integer.parseInt( it.next() ) );
    	}
    	
    	return res;
    }
    
    public void Inicializar()
    {
        lr = ArbolRutas.MostrarElementos();
        itc = lr.iterator();
    }
    
    //Pre: Cierto
    //Post: Retorna un String que contiene todos los ids de las rutas presentes separadas por '#'
    /**
     * Metodo para consultar los id's de todas las rutas 
     * @param i
     * @return Retorna un String que contiene todos los ids de las rutas presentes separadas por '#'
     */
    public String Consultar_ids_rutas_string(int i)
    {
        if(i==0) Inicializar();
        int j=0;
        String res = "";
        while(itc.hasNext() && j<100){
                Ruta aux = itc.next();
                int id = aux.consultar_id();
                res += id+"#";
                ++j;
        }
        if(i+100 >= ArbolRutas.size()) lr.clear();
        return res; 
    }
      
    //Pre: Entra como parametro un string
    //Post: Retorna un arraylist que contiene todos los ids de las rutas que le entran al planeta con id = "id_planeta"
    /**
     * Metodo para consultar las entradas de un planeta determinado
     * @param id_planeta
     * @return Retorna un arraylist que contiene todos los ids de las rutas que le entran al planeta con id = "id_planeta"
     */
    public ArrayList<Integer> Consultar_entrades_planeta(String id_planeta)
    {
    	ArrayList<Conexion> c = Conexiones.MostrarElementos();
    	ArrayList<Integer> ids_rutas = new ArrayList<Integer>();
		Iterator<Conexion> it = c.iterator();
		Conexion aux;
		while(it.hasNext()){
			aux = it.next();
			if ( id_planeta.equals( aux.consultar_planetaB() ) ) ids_rutas.add( aux.consultar_id() );
		}
    	return ids_rutas;
    }
    
    //Pre: Entra como parametro un string
    //Post: Retorna un arraylist que contiene todos los ids de las rutas que le salen al planeta con id = "id_planeta"
    /**
     * Metodo para consultar las salidas de un planeta determinado
     * @param id_planeta
     * @return Retorna un arraylist que contiene todos los ids de las rutas que le salen al planeta con id = "id_planeta"
     */
    public ArrayList<Integer> Consultar_sortides_planeta(String id_planeta)
    {
    	ArrayList<Conexion> c = Conexiones.MostrarElementos();

    	ArrayList<Integer> ids_rutas = new ArrayList<Integer>();
    	
		Iterator<Conexion> it = c.iterator();
		Conexion aux;
		while(it.hasNext()){
			aux = it.next();
			if (id_planeta.equals(aux.consultar_planetaA())) ids_rutas.add( aux.consultar_id() );
		}
    	return ids_rutas;
    }
    
    //Pre: Cierto
    //Post: Retorna el arbol de conexiones transformado a ArrayList<Conexiones>
	/**
	 * Metodo para consultar los elementos del arbol de conexiones
	 * @return Retorna el arbol de conexiones transformado a ArrayList<Conexiones>
	 */
    public ArrayList<Conexion> Consultar_Conexiones()
	{
		return Conexiones.MostrarElementos();

	}
    
    //MODIFICADORAS    
    
    //Pre: Existe una ruta con id = "id"
    //Post: La capacidad de la ruta con id = "id" ha sido modificada por capacidad = "capacidad_nueva"
    /**
     * Metodo para modificar la capacidad de una ruta determinada por un id
     * @param id
     * @param capacidad_nueva
     * @throws Exception
     */
    public void ModificarCapacidadRuta(int id, int capacidad_nueva) throws Exception
    {
        if(ErrorTipografico(capacidad_nueva)){
            throw new Exception("Error : La capacidad debe ser mayor o igual que 0\n");
        }
        if ( capacidad_nueva > 100000 ) {
        	throw new Exception("La capacidad de la ruta tiene que ser menor o igual a 100.000 \n");
        }
        BuscarRuta(id).modificar_capacidad(capacidad_nueva);
        
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: La distancia de la ruta con id = "id" ha sido modificada por distancia = "distancia_nueva"ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§
    /**
     * Metodo para modificar la distancia de una ruta determinada por un id
     * @param id
     * @param distancia_nueva
     * @throws Exception
     */
    public void ModificarDistanciaRuta(int id, int distancia_nueva)throws Exception
    {
        if(ErrorTipografico(distancia_nueva) || distancia_nueva == 0){
            throw new Exception("Error : La distancia entre planetas debe ser mayor que 0\n");
        }
        if ( distancia_nueva > 100000 ) {
        	throw new Exception("La distancia de la ruta tiene que ser menor o igual a 100.000 \n");
        }
        BuscarRuta(id).modificar_distancia(distancia_nueva);
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: EL id del planetaA de la ruta con id = "id" ha sido modificado por id_planetaA = "id_planetaA_nuevo"
    /**
     * Metodo para modificar el planetaA de una ruta determinada por un id
     * @param id
     * @param id_planetaA_nuevo
     * @param cp
     * @throws Exception
     */
    public void ModificarPlanetaARuta(int id, String id_planetaA_nuevo, ControladorPlaneta cp)throws Exception
    {
        if(!alfa_numeric(id_planetaA_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0\n");
        }
        if (!cp.ExistePlaneta(id_planetaA_nuevo)) {
            throw new Exception("Error : El planeta con id = " + id_planetaA_nuevo + " no existe \n");

        }
        Conexion c = BuscarConexion(id);
        
        if ( !Disponibilidad_crear_ruta( id_planetaA_nuevo, c.consultar_planetaB() ) ) {
            throw new Exception("No se puede modificar la id ya que ya existe una ruta que conecta el planeta " + id_planetaA_nuevo + " y el planeta " + c.consultar_planetaB() + "\n");
        }
        BuscarConexion(id).modificar_planetaA(id_planetaA_nuevo);
    }
    
    //Pre: Existe una ruta con id = "id"
    //Post: EL id del planetaB de la ruta con id = "id" ha sido modificado por id_planetaB = "id_planetaB_nuevo"
    /**
     * Metodo para modificar el planetaB de una ruta determinada por un id
     * @param id
     * @param id_planetaB_nuevo
     * @param cp
     * @throws Exception
     */
    public void ModificarPlanetaBRuta(int id, String id_planetaB_nuevo, ControladorPlaneta cp)throws Exception
    {
        if(!alfa_numeric(id_planetaB_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0\n");
        }
        if (!cp.ExistePlaneta(id_planetaB_nuevo)) {
            throw new Exception("Error : El planeta con id = " + id_planetaB_nuevo + " no existe \n");

        }
        Conexion c = BuscarConexion(id);
        if ( !Disponibilidad_crear_ruta( c.consultar_planetaA(), id_planetaB_nuevo ) ) {
            throw new Exception("No se puede modificar la id ya que ya existe una ruta que conecta el planeta " + c.consultar_planetaA() + " y el planeta " + id_planetaB_nuevo + "\n");
        }
        BuscarConexion(id).modificar_planetaB(id_planetaB_nuevo);
    }
    
  //Pre: Existe una ruta con id = "id_planeta"
  //Post: Las rutas que tienen planetaA = "id_planeta" o planetaB = "id_planeta" han sido borrada del arbol de rutas y de conexiones
    /**
     * Borrar las rutas que tiene como origen o destino el planeta "id_planeta"
     * @param id_planeta
     * @throws Exception
     */
  public void BorrarRutaConexions(String id_planeta) throws Exception
  {
	  if (!alfa_numeric(id_planeta)) {
		  throw new Exception("El id del planeta tiene que ser alfanumerico \n");
	  }
  	  ArrayList<Conexion> c = Conexiones.MostrarElementos();
	  Iterator<Conexion> it = c.iterator();
	  Conexion aux;
	  while( it.hasNext() ) {
		  aux = it.next();
		  if(aux.consultar_planetaA().equals(id_planeta) || aux.consultar_planetaB().equals(id_planeta)){
			  Borrar_Conexion (aux.consultar_id() );
			  Borrar_Ruta( aux.consultar_id() );
		  }
	  }
  }
    
  //Pre: Existe una ruta con id = "id"
  //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
  /**
   * Metodo para borrar una ruta
   * @param id
   * @throws Exception
   */
  public void BorrarRuta(int id) throws Exception
  {
	  Borrar_Ruta(id);
  	  Borrar_Conexion(id);
  }
  
  //Pre: Cierto
  //Post: Borra todas las rutas del ArbolRutas y todas las conexiones de Conexiones
  /**
   * Metodo para borrar todas las rutas
   */
  void BorrarRutas()
  {
	  ArbolRutas.clear();
	  Conexiones.clear();
  }
  
  //Pre: Cierto.
  //Post: retorna un string que contiene todas las rutas y conexiones, separados por '#'
  /**
   * Metodo para consultar todas las rutas
   * @return retorna un string que contiene todas las rutas y conexiones, separados por '#'
   * @throws Exception
   */
  public String consultarTODO() throws Exception 
  {
	  String res = "";
	  	//Guardamos todas la rutas
	    if(!ArbolRutas.isEmpty()){
	        res = "";
	    	ArrayList<Ruta> ar = ArbolRutas.MostrarElementos();
	        for (Ruta r : ar){  
	            res += 0 + ":"; //quiere decir que se trata de una ruta
	            res += r.consultar_id() + ":";
	            res += r.consultar_capacidad() + ":";
	            res += r.consultar_distancia();
	            res += "#";
	            }
	        }
	    
	    //Guardamos toadas las conexiones
	    if(!Conexiones.isEmpty()){
	    	ArrayList<Conexion> ac = Conexiones.MostrarElementos();
	        for (Conexion c : ac){  
	            res += 1 + ":"; //quiere decir que se trata de una conexion
	            res += c.consultar_id() + ":";
	            res += c.consultar_planetaA() + ":";
	            res += c.consultar_planetaB() + ":";
	            res += "#";
	        }
	    }
	    return res;
  }
  
  public boolean Array_conte(int id, ArrayList<Integer>l)
  {
      boolean b = false;
      for (int i = 0; i<l.size();++i)
      {
          if (l.get(i)==id) return true;
      }
      return b;
  }
  
  //Pre: Cierto.
  //Post: Carga todas las rutas y conexiones existentes en el sistema en el fichero indicado en el path
  /**
   * Metodo para cargar un conjunto de rutas desde un fichero determinado
   * @param path
   * @throws Exception
   */
  public void CargarRutas (String path, ControladorPlaneta cp) throws Exception 
  {
      ArrayList<Integer> Rutes_afegides = new ArrayList<Integer>();
      String res;
      Cdr.AbrirLectura(path);
      FileReader fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      while( !(res = Cdr.cargar(path,100,br) ).equals("")){
          Scanner sc = new Scanner(res);
          sc.useDelimiter("#|:");
          String s="";
          if(sc.hasNext()) s = sc.next();
          while (!s.equals("") && sc.hasNext()) {
        	  if ( Integer.parseInt(s) == 0 ) { //anadimos ruta
        	      s = sc.next();
        	      int id = Integer.parseInt(s);
        	      s = sc.next();
        	      int capacidad = Integer.parseInt(s);
        	      s = sc.next();
        	      int distancia = Integer.parseInt(s);
                      if (Array_conte(id, Rutes_afegides)) { //si hemos aÃ±adido la conexion, anadimos tambien la ruta
                         Ruta r = new Ruta(id,capacidad,distancia);
                         ArbolRutas.add(Integer.toString(r.consultar_id()),r);
                      }
    	      } else { //anadimos conexion
    		      s = sc.next();
                      int id = Integer.parseInt(s);
        	      s = sc.next();
        	      String ida = s;
        	      s = sc.next();
        	      String idb = s;
                      if (!ExisteRuta(id) && cp.ExistePlaneta(ida) && Disponibilidad_crear_ruta(ida , idb) )
                      {
                          Conexion c = new Conexion(id,ida,idb);
                          Rutes_afegides.add(id);
                          Conexiones.add(Integer.toString(c.consultar_id()),c);
                      }
    	      }
    	      s= sc.next();

          }
      }
      Cdr.CerrarLectura();
  }    
  
  
  //Pre: Cierto.
  //Post: Guarda todas las rutas y conexiones existentes en el sistema en el fichero indicado en el path
  /**
   * Metodo para guardar el conjunto de rutas que existen a un fichero determinado
   * @param path
   * @throws Exception
   */
  public void GuardarRutas (String path) throws Exception {
    String res = "";
    //Guardamos toadas las conexiones
    if(!Conexiones.isEmpty()){
        int iteracions = 0;
    	ArrayList<Conexion> ac = Conexiones.MostrarElementos();
        for (Conexion c : ac){ 
            res += 1 + ":"; //quiere decir que se trata de una conexion
            res += c.consultar_id() + ":";
            res += c.consultar_planetaA() + ":";
            res += c.consultar_planetaB();
            res += "#";
            ++iteracions;
            if(iteracions == 100){
                Cdr.guardar(path,res);
                iteracions = 0;
                res = "";
            }
        }
    }
    //Guardamos todas la rutas
    if(!ArbolRutas.isEmpty()){
        Cdr.AbrirEscritura(path);        
        int iteracions = 0;
    	ArrayList<Ruta> ar = ArbolRutas.MostrarElementos();
        for (Ruta r : ar){  
            res += 0 + ":"; //quiere decir que se trata de una ruta
            res += r.consultar_id() + ":";
            res += r.consultar_capacidad() + ":";
            res += r.consultar_distancia();
            res += "#";
            ++iteracions;
            if(iteracions == 100){
                Cdr.guardar(path,res);
                iteracions = 0;
                res = "";
            }
        }
    }
    if(res != ""){
    	Cdr.guardar(path,res);
    	Cdr.CerrarEscritura();
    }
  }
}

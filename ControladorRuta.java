import java.util.*;

public class ControladorRuta {
    //PARTE PRIVADA
    private TreeSet<Ruta> ArbolRutas;
    private TreeSet<Conexion> Conexiones;
    private ControladorDadesRuta Cdr;
    
     //Pre: Cierto
    //Post: Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
    private static boolean ErrorTipografico(int i) {
    	return (i<0);
    }
    
    //Pre: Cierto
    //Post: Te devuelve true en caso que se pueda crear una ruta del planeta idA al planeta idB, en caso contrario, devuelve false ya que no es posible crearla
    private boolean Disponibilidad_crear_ruta (int idA, int idB) throws Exception
    {
    	if (idA == idB) return false;
		Iterator<Conexion> it = Conexiones.iterator();
		Conexion aux = new Conexion();
		while( it.hasNext() ){
			aux = it.next();
			if (aux.consultar_planetaA() == idA && aux.consultar_planetaB() == idB) return false; // ya existe esta ruta
			if (aux.consultar_planetaA() == idB && aux.consultar_planetaB() == idA && aux.consultar_bidireccional()) return false; //hay una ruta de b->a que es bidireccional, eso implica que ya existe la ruta
		}
		return true; 
    }
    
    //Pre: Cierto
    //Post: Retorna el numero de rutas que hay el arbol de conexiones, donde las que son bidireccionales cuentan como dos
    private int Numero_rutes_sumant_bidireccional() throws Exception
    {
    	int ret = 0;
    	ret = Consultar_numero_rutes();
		Iterator<Conexion> it = Conexiones.iterator();
		Conexion aux = new Conexion();
		while( it.hasNext() ){
			aux = it.next();
			if ( aux.consultar_bidireccional() ) ++ret;
		}
		return ret;
    }
    
    //Pre: Cierto
    //Post: La conexion con id = "id" ha sido borrada del arbol de conexiones
    public void Borrar_Conexion (int id) throws Exception
    {
    	boolean found = false;
		Iterator<Conexion> it = Conexiones.iterator();
		Conexion aux = new Conexion();
		while(!found && it.hasNext()){
			aux = it.next();
			if(aux.consultar_id() == id){
				it.remove();
				found = true;
			}
		}
    }
    
    //Pre: Cierto
    //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
    public void Borrar_Ruta (int id) throws Exception
    {
    	boolean found = false;
		Iterator<Ruta> it = ArbolRutas.iterator();
		Ruta aux = new Ruta();
		while(!found && it.hasNext()){
			aux = it.next();
			if(aux.consultar_id() == id){
				it.remove();
				found = true;
			}
		}
    }
    
    //PARTE PUBLICA
      
    //ALGORITMOS
      
    //Pre:cierto
    //Post: comprueva si existe la ruta con identificador "id"
    public boolean ExisteRuta(int id) throws Exception
    {
    	if (id < 0) {
    		throw new Exception("Error: El identificador de una ruta tiene que ser mayor o igual que 0\n");

    	}
    	Iterator<Ruta> it = ArbolRutas.iterator();
    	while (it.hasNext()){
    		if (it.next().consultar_id() == id) return true;
    	}
    	return false;
    }
    
    //Pre:cierto
    //Post: comprueva si existe la conexion con identificador "id"
    public boolean ExisteConexion(int id) throws Exception
    {
    	if (id < 0) {
    		throw new Exception("Error: El identificador de una conexion tiene que ser mayor o igual que 0\n");

    	}
    	Iterator<Conexion> it = Conexiones.iterator();
    	while (it.hasNext()){
    		if (it.next().consultar_id() == id) return true;
    	}
    	return false;
    }
    
    //pre: cierto
    //post: retorna la conexion que tiene identificador=id
    public Conexion BuscarConexion(int id) throws Exception
    {
    	if ( !ExisteConexion(id) ) {
    		throw new Exception("Error: No existe ninguna conexion con el identificador introducido\n");
    	}
    	Iterator<Conexion> it = Conexiones.iterator();
    	boolean trobat = false;
    	Conexion res = null;
    	Conexion aux;
    	while (it.hasNext() && !trobat){
    		aux = it.next();
    		if (aux.consultar_id() == id) {
    			res = aux;
    			trobat = true;
    		}
    	}
		return res;
    }
      
    //pre: cierto
    //post: retorna la ruta que tiene identificador=id
    public Ruta BuscarRuta(int id) throws Exception
    {
    	if ( !ExisteRuta(id) ) throw new Exception("Error: No existe ninguna ruta con el identificador introducido\n");
    	Iterator<Ruta> it = ArbolRutas.iterator();
    	boolean trobat = false;
    	Ruta res = null;
    	Ruta aux;
    	while (it.hasNext() && !trobat){
    		aux = it.next();
    		if (aux.consultar_id() == id) {
    			res = aux;
    			trobat = true;
    		}
    	}
		return res;
    }
      
    //CREADORAS
    
    //Pre: Cierto
    //Post: Retorna un controlador de ruta vacio
    public ControladorRuta()
    {
        ArbolRutas = new TreeSet<Ruta>(new OrdenRuta());
        Conexiones = new TreeSet<Conexion>(new OrdenConexion());
        Cdr = new ControladorDadesRuta();
    }
      
    //Pre: Cierto
    //Post: Crea una ruta con id = "id", capacidad = "capacidad", distancia = "distancia", planetaA = "planetaA", planetaB = "planetaB", bidireccional = "bidireccional", y la aÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Â ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â±ade al arbol de rutas
    public void CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional, ControladorPlaneta cp) throws Exception
    { 
    	int numero_planetas = cp.Consultar_Size();
    	if ( 2*(numero_planetas*(numero_planetas-1)/2) <= Numero_rutes_sumant_bidireccional() ) {
    		throw new Exception("Error: se ha alcanzado el numero maximo de rutas que puede haber \n");
    	}
        if(ExisteRuta(id)){
            throw new Exception("Error: Ya existe una ruta con el mismo identificador\n");       
        }
        if (!cp.ExistePlaneta(planetaA) ) { 
            throw new Exception("Error: El Planeta con id = " + planetaA + " no existe\n");
        }
        if (!cp.ExistePlaneta(planetaB) ) { 
            throw new Exception("Error: El Planeta con id = " + planetaB + " no existe\n");
        }
        if ( !Disponibilidad_crear_ruta(planetaA , planetaB) ) {
        	throw new Exception("La Ruta de " + planetaA + " a " + planetaB + " ja existeix \n");
        }
        Ruta r = new Ruta(id,capacidad,distancia);
        Conexion c = new Conexion(id, planetaA, planetaB, bidireccional);
        ArbolRutas.add(r); 
        Conexiones.add(c);
    }
      
    //Pre: Cierto
    //Post: Crea una ruta de forma automatica y la anade al arbol de rutas
    public void CrearRuta_automatica(ControladorPlaneta cp) throws Exception
    {
    	int numero_planetas = cp.Consultar_Size();
    	if ( 2*(numero_planetas*(numero_planetas-1)/2) <= Numero_rutes_sumant_bidireccional() ) {
    		throw new Exception("Error: se ha alcanzado el numero maximo de rutas que puede haber \n");
    	}
        Random aleatorio = new Random();
        int id = 0;
        while(ExisteRuta(id)) ++id; 
        int capacidad = aleatorio.nextInt(2147483647);
        int distancia = aleatorio.nextInt(2147483647);
        while (distancia == 0) {
            distancia = aleatorio.nextInt(2147483647);
        }
        int aux;
    	aux = aleatorio.nextInt(2147483647);
        aux = aux%cp.Consultar_Size();
        Planeta planetaA = cp.Consultar_PlanetaX(aux);
        
    	aux = aleatorio.nextInt(2147483647);
        aux = aux%cp.Consultar_Size();
        Planeta planetaB = cp.Consultar_PlanetaX(aux);
	        
        while ( !Disponibilidad_crear_ruta(planetaA.Consultar_id() , planetaB.Consultar_id()) || planetaA.Consultar_id() == planetaB.Consultar_id() )
        {
        	aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
            planetaA = cp.Consultar_PlanetaX(aux);
            
        	aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
            planetaB = cp.Consultar_PlanetaX(aux);
        }
        
        boolean bidireccional;
        bidireccional = aleatorio.nextBoolean();
        
        Ruta r = new Ruta(id,capacidad,distancia);
        Conexion c = new Conexion(id, planetaA.Consultar_id(), planetaB.Consultar_id(), bidireccional);
        ArbolRutas.add(r); 
        Conexiones.add(c);
    }
    
    //Pre: Cierto
    //Post: Crea una ruta de forma automatica y la anade al arbol de rutas
    public void CrearRuta_automatica(ControladorPlaneta cp, int id) throws Exception
    {
    	int numero_planetas = cp.Consultar_Size();
    	if ( 2*(numero_planetas*(numero_planetas-1)/2) <= Numero_rutes_sumant_bidireccional() ) {
    		throw new Exception("Error: se ha alcanzado el numero maximo de rutas que puede haber \n");
    	}
    	if (ExisteRuta(id)) {
    		throw new Exception("Error: Ya existe una ruta con el mismo identificador\n");
    	}
        Random aleatorio = new Random();
    	int capacidad = aleatorio.nextInt(2147483647);
        int distancia = aleatorio.nextInt(2147483647);
        while (distancia == 0) {
            distancia = aleatorio.nextInt(2147483647);
        }
        int aux;
    	aux = aleatorio.nextInt(2147483647);
        aux = aux%cp.Consultar_Size();
        Planeta planetaA = cp.Consultar_PlanetaX(aux);
        
    	aux = aleatorio.nextInt(2147483647);
        aux = aux%cp.Consultar_Size();
        Planeta planetaB = cp.Consultar_PlanetaX(aux);
        
        while ( !Disponibilidad_crear_ruta(planetaA.Consultar_id() , planetaB.Consultar_id()) || planetaA.Consultar_id() == planetaB.Consultar_id() )
        {
        	aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
            planetaA = cp.Consultar_PlanetaX(aux);
            
        	aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
            planetaB = cp.Consultar_PlanetaX(aux);
        }
        
        boolean bidireccional;
        bidireccional = aleatorio.nextBoolean();
        Ruta r = new Ruta(id,capacidad,distancia);
        Conexion c = new Conexion(id, planetaA.Consultar_id(), planetaB.Consultar_id(), bidireccional);
        ArbolRutas.add(r); 
        Conexiones.add(c);
    }
      
    //CONSULTORAS   
    
    //Pre: Cierto
    //Post: Retorna la capacidad que tiene la ruta con id = "id"
    public int ConsultarCapacidadRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_capacidad();
    }
    
    //Pre: Cierto
    //Post: Retorna la distancia que tiene la ruta con id = "id"
    public int ConsultarDistanciaRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_distancia();
    }
    
    //Pre: Cierto
    //Post: Retorna la id del planetaA de la ruta con id = "id"
    public int ConsultarPlanetaARuta(int id) throws Exception
    {
    	Conexion c = BuscarConexion(id);
        return c.consultar_planetaA();
    }
      
    //Pre: Cierto
    //Post: Retorna la id del planetaB de la ruta con id = "id"
    public int ConsultarPlanetaBRuta(int id) throws Exception
    {
    	Conexion c = BuscarConexion(id);
        return c.consultar_planetaB();
    }
      
    //Pre: Cierto
    //Post: Retorna un valor booleano de si la ruta con id = "id" es bidireccional o no
    public boolean ConsultarBidireccionalidadRuta(int id) throws Exception
    {
    	Conexion c = BuscarConexion(id);
        return c.consultar_bidireccional();
    }
      
    //Pre: Cierto
    //Post: Retorna el tamano del arbol de rutas
    public int Consultar_numero_rutes()
    {
    	return Conexiones.size();
    }
    
    
    //Pre: Cierto
    //Post: Retorna el arbol de conexiones
    public TreeSet<Conexion> Consultar_arbre_conexions()
    {
    	return Conexiones;
    }
    
    //Pre: Cierto
    //Post: Retorna un arraylist que contiene todos los ids de las rutas presentes
    public ArrayList<Integer> Consultar_ids_rutas() throws Exception
    {
    	ArrayList<Integer> ids_rutas = new ArrayList<Integer>();
    	
		Iterator<Conexion> it = Conexiones.iterator();
		Conexion aux = new Conexion();
		while(it.hasNext()){
			aux = it.next();
			ids_rutas.add( aux.consultar_id() );
		}
    	
    	return ids_rutas;
    }
      
    //Pre: Cierto
    //Post: Retorna un arraylist que contiene todos los ids de las rutas que le entran al planeta con id = "id_planeta"
    public ArrayList<Integer> Consultar_entrades_planeta(int id_planeta) throws Exception
    {
    	ArrayList<Integer> ids_rutas = new ArrayList<Integer>();
    	
		Iterator<Conexion> it = Conexiones.iterator();
		Conexion aux = new Conexion();
		while(it.hasNext()){
			aux = it.next();
			if (id_planeta == aux.consultar_planetaB()) ids_rutas.add( aux.consultar_id() );
		}
    	
    	return ids_rutas;
    }
    
    //Pre: Cierto
    //Post: Retorna un arraylist que contiene todos los ids de las rutas que le salen al planeta con id = "id_planeta"
    public ArrayList<Integer> Consultar_sortides_planeta(int id_planeta) throws Exception
    {
    	ArrayList<Integer> ids_rutas = new ArrayList<Integer>();
    	
		Iterator<Conexion> it = Conexiones.iterator();
		Conexion aux = new Conexion();
		while(it.hasNext()){
			aux = it.next();
			if (id_planeta == aux.consultar_planetaA()) ids_rutas.add( aux.consultar_id() );
		}
    	
    	return ids_rutas;
    }
    
    //Pre: Cierto
    //Post: Retorna el arbol de conexiones transformado a ArrayList<Conexiones>
	public ArrayList<Conexion> Consultar_Conexiones()
	{
		ArrayList<Conexion> ai = new ArrayList<Conexion>();
		Iterator<Conexion> it = Conexiones.iterator();
		while(it.hasNext()) {
			ai.add(it.next());
		}
		return ai;
	}
    
    //MODIFICADORAS    
    
    //Pre: Existe una ruta con id = "id_original"
    //Post: La ruta con id = "id_original" se le ha modificado por id = "id_nuevo"
    public void ModificarIddRuta(int id_original, int id_nuevo, ControladorPlaneta cp) throws Exception
    {
        if(ErrorTipografico(id_nuevo)){
            throw new Exception("Error : El identificador de una ruta debe ser mayor o igual que 0\n");
        }
        if (ExisteRuta(id_nuevo)) {
        	throw new Exception("Ja existeix una ruta amb id = " + id_nuevo + " \n");
        }
        Ruta solicitada = BuscarRuta(id_original);
        solicitada.modificar_id(id_nuevo);
        Conexion c = BuscarConexion(id_original);
        c.modificar_id(id_nuevo);
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: La capacidad de la ruta con id = "id" ha sido modificada por capacidad = "capacidad_nueva"
    public void ModificarCapacidadRuta(int id, int capacidad_nueva) throws Exception
    {
        if(ErrorTipografico(capacidad_nueva)){
            throw new Exception("Error : La capacidad debe ser mayor o igual que 0\n");
        }
        
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_capacidad(capacidad_nueva);
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: La distancia de la ruta con id = "id" ha sido modificada por distancia = "distancia_nueva"
    public void ModificarDistanciaRuta(int id, int distancia_nueva)throws Exception
    {
        if(ErrorTipografico(distancia_nueva) || distancia_nueva == 0){
            throw new Exception("Error : La distancia entre planeas debe ser mayor que 0\n");
        }
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_distancia(distancia_nueva);
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: EL id del planetaA de la ruta con id = "id" ha sido modificado por id_planetaA = "id_planetaA_nuevo"
    public void ModificarPlanetaARuta(int id, int id_planetaA_nuevo, ControladorPlaneta cp)throws Exception
    {
        if(ErrorTipografico(id_planetaA_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0\n");
        }
        if (!cp.ExistePlaneta(id_planetaA_nuevo)) {
            throw new Exception("Error : El planeta con id = " + id_planetaA_nuevo + " no existe \n");

        }
        Conexion c = BuscarConexion(id);
        
        if ( !Disponibilidad_crear_ruta( id_planetaA_nuevo, c.consultar_planetaB() ) ) {
            throw new Exception("No se puede modificar la id ya que ya existe una ruta que conecta el planeta " + id_planetaA_nuevo + " y el planeta " + c.consultar_planetaB() + "\n");
        }
        c.modificar_planetaA(id_planetaA_nuevo);
    }
    
    //Pre: Existe una ruta con id = "id"
    //Post: EL id del planetaB de la ruta con id = "id" ha sido modificado por id_planetaB = "id_planetaB_nuevo"
    public void ModificarPlanetaBRuta(int id, int id_planetaB_nuevo, ControladorPlaneta cp)throws Exception
    {
        if(ErrorTipografico(id_planetaB_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0\n");
        }
        if (!cp.ExistePlaneta(id_planetaB_nuevo)) {
            throw new Exception("Error : El planeta con id = " + id_planetaB_nuevo + " no existe \n");

        }
        Conexion c = BuscarConexion(id);
        if ( !Disponibilidad_crear_ruta( c.consultar_planetaA(), id_planetaB_nuevo ) ) {
            throw new Exception("No se puede modificar la id ya que ya existe una ruta que conecta el planeta " + c.consultar_planetaA() + " y el planeta " + id_planetaB_nuevo + "\n");
        }
        c.modificar_planetaB(id_planetaB_nuevo);
    }
    
    //Pre: La ruta con id = "id" tiene los atributos planetaA y planetaB inicializados
    //Post: Los planetas que conecta la ruta con id = "id" se modifican por planetaA = planetaB y planetaB = planetaB
    public void Invertir_planetaA_planetaB(int id, ControladorPlaneta cp) throws Exception
    {
    	Conexion c = BuscarConexion(id);
    	Borrar_Conexion(id);//esta para que no vea esta ruta al momento de buscar
        if ( !Disponibilidad_crear_ruta( c.consultar_planetaB(), c.consultar_planetaA() ) ) {
        	Conexiones.add(c); //anadimos otra vez la conexion
            throw new Exception("No se pueden invertir los planetas, ya que existe una ruta que los conecta\n");
        }
    	Conexiones.add(c);//anadimos otra vez la conexion
    	c.invertir_planetas();
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: La bidireccionalidad de la ruta con id = "id" ha sido modificada tal que bidireccional = "bidireccional_nuevo"
    public void ModificarBidireccionalidadRuta(int id, boolean bidireccional_nuevo)throws Exception
    {
        Conexion c = BuscarConexion(id);
        if (bidireccional_nuevo && !c.consultar_bidireccional()) {
            if ( !Disponibilidad_crear_ruta( c.consultar_planetaB(), c.consultar_planetaA() ) ) {
                throw new Exception("No se puede pasar a tener una ruta bidireccional, porque ya existe una ruta que une del planeta" + c.consultar_planetaB() + " a " + c.consultar_planetaA() + "\n");
            }
        }
        c.modificar_bidireccional(bidireccional_nuevo);
    }
    
  //Pre: Existe una ruta con id = "id_planeta"
  //Post: Las rutas que tienen planetaA = "id_planeta" o planetaB = "id_planeta" han sido borrada del arbol de rutas y de conexiones
  public void BorrarRutaConexions(int id_planeta, ControladorPlaneta cp) throws Exception
  {
	  if (id_planeta < 0) {
		  throw new Exception("La id del planeta tiene que ser mayor o igual que 0 \n");
	  }
	  if (!cp.ExistePlaneta(id_planeta)) {
		  throw new Exception("El planeta no existe \n");
	  }
	  Iterator<Conexion> it = Conexiones.iterator();
	  Conexion aux = new Conexion();
	  while( it.hasNext() ) {
		  aux = it.next();
		  if(aux.consultar_planetaA() == id_planeta || aux.consultar_planetaB() == id_planeta){
			  System.out.print("enrrem al borrar");
			  it.remove();
			  Borrar_Ruta( aux.consultar_id() );
			  
		  }
	  }
  }
    
  //Pre: Existe una ruta con id = "id"
  //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
  public void BorrarRuta(int id, ControladorPlaneta cp) throws Exception
  {
	  if (id < 0) {
		  throw new Exception("La id de la ruta tiene que ser mayor o igual que 0 \n");
	  } 
	  Borrar_Ruta(id);
  	  Borrar_Conexion(id);
  }
  
  //Pre: Cierto
  //Post: Borra todas las rutas del ArbolRutas y todas las conexiones de Conexiones
  void BorrarRutas() throws Exception{
	  if(ArbolRutas.size() < 1) throw new Exception("No hay rutas");
	  ArbolRutas.clear();
	  Conexiones.clear();
  }
  
  //Pre: Cierto.
  //Post: Carga todas las rutas y conexiones existentes en el sistema en el fichero indicado en el path
  public void CargarRutas (String path) throws Exception {
	  String res;
      Cdr.AbrirLectura(path);
      res = Cdr.cargar(path);
      Scanner sc = new Scanner(res);
      sc.useDelimiter("#|:");
      String s="";
      if(sc.hasNext()) s = sc.next();
      while (sc.hasNext()) {
    	  if ( Integer.parseInt(s) == 0 ) { //anadimos ruta
    	      s = sc.next();
    	      int id = Integer.parseInt(s);
    	      s = sc.next();
    	      int capacidad = Integer.parseInt(s);
    	      s = sc.next();
    	      int distancia = Integer.parseInt(s);
    	      Ruta r = new Ruta(id,capacidad,distancia);
    	      ArbolRutas.add(r);
	      } else { //anadimos conexion
		      s = sc.next();
	    	  int id = Integer.parseInt(s);
    	      s = sc.next();
    	      int ida = Integer.parseInt(s);
    	      s = sc.next();
    	      int idb = Integer.parseInt(s);
    	      s = sc.next();
    	      Boolean b = Boolean.parseBoolean(s);
    	      System.out.print("ida = " + ida + "idb = " + idb + "\n");
    	      Conexion c = new Conexion(id,ida,idb,b);
    	      Conexiones.add(c);
	      }
	      s = sc.next();
      }
      Cdr.CerrarLectura();
  }    
  
  public String consultarTODO() throws Exception {
	  String res = "";
	  	//Guardamos todas la rutas
	    if(!ArbolRutas.isEmpty()){
	        res = "";
	        for (Ruta r : ArbolRutas){  
	            res += 0 + ":"; //quiere decir que se trata de una ruta
	            res += r.consultar_id() + ":";
	            res += r.consultar_capacidad() + ":";
	            res += r.consultar_distancia();
	            res += "#";
	            }
	        }
	    
	    //Guardamos toadas las conexiones
	    if(!Conexiones.isEmpty()){
	        for (Conexion c : Conexiones){  
	            res += 1 + ":"; //quiere decir que se trata de una conexion
	            res += c.consultar_id() + ":";
	            res += c.consultar_planetaA() + ":";
	            res += c.consultar_planetaB() + ":";
	            res += c.consultar_bidireccional();
	            res += "#";
	        }
	    }
	    return res;
  }
  
  //Pre: Cierto.
  //Post: Guarda todas las rutas y conexiones existentes en el sistema en el fichero indicado en el path
  public void GuardarRutas (String path) throws Exception {
  	String res = "";
  	//Guardamos todas la rutas
    if(!ArbolRutas.isEmpty()){
        Cdr.AbrirEscritura(path);        
        res = "";
        int iteracions = 0;
        for (Ruta r : ArbolRutas){  
            res += 0 + ":"; //quiere decir que se trata de una ruta
            res += r.consultar_id() + ":";
            res += r.consultar_capacidad() + ":";
            res += r.consultar_distancia();
            res += "#";
            System.out.println(res);
            ++iteracions;
            if(iteracions == 100){
                Cdr.guardar(path,res);
                iteracions = 0;
                res = "";
            }
        }
    }
    
    //res += "@"; //Le anadimo este separador para diferenciar entre ruas y conexiones
    
    //Guardamos toadas las conexiones
    if(!Conexiones.isEmpty()){
        int iteracions = 0;
        for (Conexion c : Conexiones){  
            res += 1 + ":"; //quiere decir que se trata de una conexion
            res += c.consultar_id() + ":";
            res += c.consultar_planetaA() + ":";
            res += c.consultar_planetaB() + ":";
            res += c.consultar_bidireccional();
            res += "#";
            System.out.println(res);
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

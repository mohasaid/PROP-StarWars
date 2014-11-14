import java.util.*;

  
public class ControladorRuta {
    //PARTE PRIVADA
    private TreeSet<Ruta> ArbolRutas;
    private TreeSet<Conexion> Conexiones;
      
    //PARTE PUBLICA
      
    //ALGORITMOS
      
    //Pre: Cierto
    //Post: Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
    private static boolean ErrorTipografico(int i) {
    	return (i<0);
    }
      
    //Pre:cierto
    //Post: comprueva si existe la ruta con identificador "id"
    public boolean ExisteRuta(int id) throws Exception
    {
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
    	if ( !ExisteConexion(id) ) throw new Exception("Error: No existe ninguna conexion con el identificador introducido");
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
    	if ( !ExisteRuta(id) ) throw new Exception("Error: No existe ninguna ruta con el identificador introducido");
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
    }
      
    //Pre: Cierto
    //Post: Crea una ruta con id = "id", capacidad = "capacidad", distancia = "distancia", planetaA = "planetaA", planetaB = "planetaB", bidireccional = "bidireccional", y la aÃƒÆ’Ã‚Â±ade al arbol de rutas
    public void CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional, ControladorPlaneta cp, ControladorGalaxia cg) throws Exception
    { 
        if(ExisteRuta(id)){
            throw new Exception("Error: Ya existe una ruta con el mismo identificador");       
        }
        if (!cp.ExistePlaneta(planetaA) ) { 
            throw new Exception("Error: El Planeta con id = " + planetaA + " no existe");
        }
        if (!cp.ExistePlaneta(planetaB) ) { 
            throw new Exception("Error: El Planeta con id = " + planetaB + " no existe");
        }
        if(cp.Consultar_Sumidero(planetaA)){
            throw new Exception("Error: El Planeta con id = " + planetaA + " es el planeta sumidero, por lo que no puede salirle ninguna ruta a otro planeta");
        }
        if(cp.Consultar_Fuente(planetaB)){
            throw new Exception("Error: El Planeta con id = " + planetaB + " es el planeta fuente, por lo que no puede entrarle ninguna ruta de otro planeta");
        }
        Ruta r = new Ruta(id,capacidad,distancia);
        Conexion c = new Conexion(id, planetaA, planetaB, bidireccional);
        ArbolRutas.add(r); 
        Conexiones.add(c);
        //posar funcio per afegir a moha
    }
      
    //Pre: Cierto
    //Post: Crea una ruta de forma automatica y la anade‚Â±ade al arbol de rutas
    public void CrearRuta_automatica(ControladorPlaneta cp) throws Exception
    {
        Random aleatorio = new Random();
        int id = aleatorio.nextInt(2147483647); // 0 <= id < 2147483648
        while (ExisteRuta(id)){
            id = aleatorio.nextInt(2147483647); // 0 <= id < 2147483648
        }
        int capacidad = aleatorio.nextInt(2147483647);
        int distancia = aleatorio.nextInt(2147483647);
        while (distancia == 0) {
            distancia = aleatorio.nextInt(2147483647);
        }
        int aux;
        do {
        	aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
        } while (cp.Consultar_Sumidero( cp.Consultar_PlanetaX(aux).Consultar_id() ));
        Planeta planetaA = cp.Consultar_PlanetaX(aux);
        
        do {
        	aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
        } while (cp.Consultar_Fuente( cp.Consultar_PlanetaX(aux).Consultar_id() ));
        Planeta planetaB = cp.Consultar_PlanetaX(aux);
        
        boolean bidireccional;
        if (cp.Consultar_Fuente( planetaA.Consultar_id() ) || cp.Consultar_Sumidero( planetaB.Consultar_id() ) ) bidireccional = false;
        else bidireccional = aleatorio.nextBoolean();
        Ruta r = new Ruta(id,capacidad,distancia);
        Conexion c = new Conexion(id, planetaA.Consultar_id(), planetaB.Consultar_id(), bidireccional);
        ArbolRutas.add(r); 
        Conexiones.add(c);
    }
    
    //Pre: Cierto
    //Post: Crea una ruta de forma automatica y la anade al arbol de rutas
    public void CrearRuta_automatica(ControladorPlaneta cp, int id) throws Exception
    {
    	if (ExisteRuta(id)) throw new Exception("Error: Ya existe una ruta con el mismo identificador");
        Random aleatorio = new Random();
    	int capacidad = aleatorio.nextInt(2147483647);
        int distancia = aleatorio.nextInt(2147483647);
        while (distancia == 0) {
            distancia = aleatorio.nextInt(2147483647);
        }
        int aux;
        do {
        	aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
        } while (cp.Consultar_Sumidero( cp.Consultar_PlanetaX(aux).Consultar_id() ));
        Planeta planetaA = cp.Consultar_PlanetaX(aux);
        
        do {
        	aux = aleatorio.nextInt(2147483647);
            aux = aux%cp.Consultar_Size();
        } while (cp.Consultar_Fuente( cp.Consultar_PlanetaX(aux).Consultar_id() ));
        Planeta planetaB = cp.Consultar_PlanetaX(aux);
        
        boolean bidireccional;
        if (cp.Consultar_Fuente( planetaA.Consultar_id() ) || cp.Consultar_Sumidero( planetaB.Consultar_id() ) ) bidireccional = false;
        else bidireccional = aleatorio.nextBoolean();
        Ruta r = new Ruta(id,capacidad,distancia);
        Conexion c = new Conexion(id, planetaA.Consultar_id(), planetaB.Consultar_id(), bidireccional);
        ArbolRutas.add(r); 
        Conexiones.add(c);
    }
      
    //CONSULTORAS   
    
    //Pre: Cierto
    //Post: Retorna la distancia que tiene la ruta con id = "id"
    public int ConsultarDistanciaRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_distancia();
    }
    
    //Pre: Cierto
    //Post: Retorna la capacidad que tiene la ruta con id = "id"
    public int ConsultarCapacidadRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_capacidad();
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
      
      
    //MODIFICADORAS    
    
    //Pre: Existe una ruta con id = "id_original"
    //Post: La ruta con id = "id_original" se le ha modificado por id = "id_nuevo"
    public void ModificarIddRuta(int id_original, int id_nuevo, ControladorPlaneta cp) throws Exception
    {
        if(ErrorTipografico(id_nuevo)){
            throw new Exception("Error : El identificador de una ruta debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id_original);
        solicitada.modificar_id(id_nuevo);
        Conexion c = BuscarConexion(id_original);
        c.modificar_id(id_nuevo);
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: La capacidad de la ruta con id = "id" ha sido modificada por capacidad = "capacidad_nueva"
    public void ModificarCapacidadRuta(int id, int capacidad_nueva, ControladorPlaneta cp) throws Exception
    {
        if(ErrorTipografico(capacidad_nueva)){
            throw new Exception("Error : La capacidad debe ser mayor o igual que 0");
        }
        int idb = ConsultarPlanetaBRuta(id); 
        int vp = cp.Consultar_Capacidad(idb);
        int vr = ConsultarCapacidadRuta(id); 
        
        cp.Modificar_Capacidad(idb, vp-vr+capacidad_nueva);
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_capacidad(capacidad_nueva);
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: La distancia de la ruta con id = "id" ha sido modificada por distancia = "distancia_nueva"
    public void ModificarDistanciaRuta(int id, int distancia_nueva)throws Exception
    {
        if(ErrorTipografico(distancia_nueva) || distancia_nueva == 0){
            throw new Exception("Error : La distancia entre planeas debe ser mayor que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_distancia(distancia_nueva);
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: EL id del planetaA de la ruta con id = "id" ha sido modificado por id_planetaA = "id_planetaA_nuevo"
    public void ModificarPlanetaARuta(int id, int id_planetaA_nuevo, ControladorPlaneta cp)throws Exception
    {
        if(ErrorTipografico(id_planetaA_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        if (cp.Consultar_Sumidero(id_planetaA_nuevo)){
            throw new Exception("Error: El Planeta con id = " + id_planetaA_nuevo + " es el planeta sumidero, por lo que no puede salirle ninguna ruta a otro planeta");
        }
        Conexion solicitada = BuscarConexion(id);
        int idA = ConsultarPlanetaARuta(id);
        if(ConsultarBidireccionalidadRuta(id)) {
        	Planeta aux = cp.BuscarPlaneta(id);
        	cp.Borrar_Entrada(idA, id, aux.Consultar_Capacidad());
        }
        cp.Borrar_Salida(idA, id); 
        solicitada.modificar_planetaA(id_planetaA_nuevo); //NO BORRAR!
        cp.Anadir_Salida(id_planetaA_nuevo, id);
        if(ConsultarBidireccionalidadRuta(id)) {
        	Planeta aux = cp.BuscarPlaneta(id);
        	cp.Anadir_Entrada(id_planetaA_nuevo, id, aux.Consultar_Capacidad());
        }
    }
    
    //Pre: Existe una ruta con id = "id"
    //Post: EL id del planetaB de la ruta con id = "id" ha sido modificado por id_planetaB = "id_planetaB_nuevo"
    public void ModificarPlanetaBRuta(int id, int id_planetaB_nuevo, ControladorPlaneta cp)throws Exception
    {
        if(ErrorTipografico(id_planetaB_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        if (cp.Consultar_Fuente(id_planetaB_nuevo)){
            throw new Exception("Error: El Planeta con id = " + id_planetaB_nuevo + "  es el planeta fuente, por lo que no puede entrarle ninguna ruta de otro planeta");
        }
        Conexion solicitada = BuscarConexion(id);
        int idB = ConsultarPlanetaBRuta(id);
        if(ConsultarBidireccionalidadRuta(id)) cp.Borrar_Salida(idB, id); 
        Planeta aux = cp.BuscarPlaneta(id);
        cp.Borrar_Entrada(idB, id, aux.Consultar_Capacidad());
        solicitada.modificar_planetaB(id_planetaB_nuevo); //NO BORRAR!
        cp.Anadir_Entrada(id_planetaB_nuevo, id, aux.Consultar_Capacidad());
        if(ConsultarBidireccionalidadRuta(id)) {
        	aux = cp.BuscarPlaneta(id);
        	cp.Anadir_Entrada(id_planetaB_nuevo, id, aux.Consultar_Capacidad());
        }
    }
    
    //Pre: La ruta con id = "id" tiene los atributos planetaA y planetaB inicializados
    //Post: Los planetas que conecta la ruta con id = "id" se modifican por planetaA = planetaB y planetaB = planetaB
    public void invertir_planetaA_planetaB(int id, ControladorPlaneta cp) throws Exception
    {
    	Conexion c = BuscarConexion(id);
    	if (cp.Consultar_Fuente( c.consultar_planetaA() )) {
    		throw new Exception("No se puede invertir la ruta, ya que el planetaA es el planeta fuente, y no puede entrarle ninguna ruta");
    	}
    	if (cp.Consultar_Sumidero( c.consultar_planetaB() )) {
    		throw new Exception("No se puede invertir la ruta, ya que el planetaB es el planeta sumidero, y no puede salirle ninguna ruta");
    	}
    	c.invertir_planetas();
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: La bidireccionalidad de la ruta con id = "id" ha sido modificada tal que bidireccional = "bidireccional_nuevo"
    public void ModificarBidireccionalidadRuta(int id, boolean bidireccional_nuevo, ControladorPlaneta cp)throws Exception
    {
        Conexion solicitada = BuscarConexion(id);
        
        int idA = ConsultarPlanetaARuta(id);
    	int idB = ConsultarPlanetaBRuta(id);
    	if (bidireccional_nuevo && !solicitada.consultar_bidireccional()) { //en el caso que pase a ser bidireccinal se tiene que mirar que el planetaA no sea el planeta fuente ni que el planetaB sea el planeta sumidero
        	if (cp.Consultar_Fuente( solicitada.consultar_planetaA() ) && cp.Consultar_Sumidero( solicitada.consultar_planetaB() )) {
        		throw new Exception("La ruta no puede ser bidireccional, ya que el planetaA es el planeta fuente, y no puede entrarle ninguna ruta, y el planetaB es el planeta sumidero, y no puede salirle ninguna ruta");
        	}
    		
    		if (cp.Consultar_Fuente( solicitada.consultar_planetaA() )) {
        		throw new Exception("La ruta no puede ser bidireccional, ya que el planetaA es el planeta fuente, y no puede entrarle ninguna ruta");
        	}
        	if (cp.Consultar_Sumidero( solicitada.consultar_planetaB() )) {
        		throw new Exception("La ruta no puede ser bidireccional, ya que el planetaB es el planeta sumidero, y no puede salirle ninguna ruta");
        	}
    	}
        if(!bidireccional_nuevo && ConsultarBidireccionalidadRuta(id)) {
  		  	Planeta aux = cp.BuscarPlaneta(id);
        	cp.Borrar_Entrada(idA, id, aux.Consultar_Capacidad());
        	cp.Borrar_Salida(idB, id);
        }
        else if(bidireccional_nuevo && !ConsultarBidireccionalidadRuta(id)) { 
        	Planeta aux = cp.BuscarPlaneta(id);
        	cp.Anadir_Entrada(idA, id, aux.Consultar_Capacidad());
        	cp.Anadir_Salida(idA, id);
        }
        
        solicitada.modificar_bidireccional(bidireccional_nuevo);
    }
    
    //Pre: Cierto
    //Post: La conexion con id = "id" ha sido borrada del arbol de conexiones
    private void Borrar_Conexion (int id) throws Exception
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
    private void Borrar_Ruta (int id) throws Exception
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
    
    //Pre: Existe una ruta con id = "id"
    //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
    public void BorrarRuta_desdePlaneta(int id) throws Exception
    {
    	Borrar_Ruta(id);
    	Borrar_Conexion(id);
	}
    
  //Pre: Existe una ruta con id = "id"
  //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
  public void BorrarRuta(int id, ControladorPlaneta cp) throws Exception
  {
	  int idA = ConsultarPlanetaARuta(id);
	  int idB = ConsultarPlanetaBRuta(id); 
	  if(ConsultarBidireccionalidadRuta(id)) { 
		  Planeta aux = cp.BuscarPlaneta(id);
		  cp.Borrar_Entrada(idA, id, aux.Consultar_Capacidad()); 
		  cp.Borrar_Salida(idB, id); 
	  }
	  Planeta aux = cp.BuscarPlaneta(id);
	  cp.Borrar_Entrada(idB, id, aux.Consultar_Capacidad()); 
	  cp.Borrar_Salida(idA, id);
	  Borrar_Ruta(id);
  	  Borrar_Conexion(id);

  }
}

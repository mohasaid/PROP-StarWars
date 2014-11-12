import java.util.*;

  
public class ControladorRuta {
    //PARTE PRIVADA
    private TreeSet<Ruta> ArbolRutas;
      
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
    }
      
    //Pre: Cierto
    //Post: Crea una ruta con id = "id", capacidad = "capacidad", distancia = "distancia", planetaA = "planetaA", planetaB = "planetaB", bidireccional = "bidireccional", y la aÃ±ade al arbol de rutas
    public void CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional, ControladorPlaneta cp) throws Exception
    { 
        if(ExisteRuta(id)){
            throw new Exception("Error: Ya existe una ruta con el mismo identificador");       
        }
        if (!cp.ExistePlaneta(planetaA) ) { 
            throw new Exception("Error: El Planeta con id= " + planetaA + "no existe");
        }
        if (!cp.ExistePlaneta(planetaB) ) { 
            throw new Exception("Error: El Planeta con id= " + planetaB + "no existe");
        }
        Ruta r = new Ruta(id,capacidad,distancia,planetaA,planetaB,bidireccional);
        ArbolRutas.add(r); 
    }
      
    //Pre: Cierto
    //Post: Crea una ruta de forma automatica y la aÃ±ade al arbol de rutas
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
      //MODIFICAR LA PART AUTOMATICA I FER-LA MÃ‰S EFICIENT!!
        int aux = aleatorio.nextInt(2147483647);
        //cp.numero_planetas retorna el numero de planetas total
        aux = aux%cp.Consultar_Size();
        //planeta posicio retorna la id del planeta que en l'arbre te la posicio aux
        planetaA = cp.Consultar_PlanetaX(aux);
        
        aux = aleatorio.nextInt(2147483647);
        //cp.numero_planetas retorna el numero de planetas total
        aux = aux%cp.Consultar_Size();
        //planeta posicio retorna la id del planeta que en l'arbre te la posicio aux
        planetaB = cp.Consultar_PlanetaX(aux);
        
        boolean bidireccional = aleatorio.nextBoolean();
	    Ruta r = new Ruta(id, capacidad, distancia, planetaA, planetaB, bidireccional);
	    ArbolRutas.add(r);
    }
    //Pre: Cierto
    //Post: Crea una ruta de forma automatica y la aÃ±ade al arbol de rutas
    public void CrearRuta_automatica(ControladorPlaneta cp, int id) throws Exception
    {
    	if (ExisteRuta(id)) throw new Exception("Error: Ya existe una ruta con el mismo identificador");
        Random aleatorio = new Random();
    	int capacidad = aleatorio.nextInt(2147483647);
        int distancia = aleatorio.nextInt(2147483647);
        while (distancia == 0) {
            distancia = aleatorio.nextInt(2147483647);
        }
        //MODIFICAR LA PART AUTOMATICA I FER-LA MÃ‰S EFICIENT!!
        int aux = aleatorio.nextInt(2147483647);
        //cp.numero_planetas retorna el numero de planetas total
        aux = aux%cp.Consultar_Size();
        //planeta posicio retorna la id del planeta que en l'arbre te la posicio aux
        planetaA = cp.Consultar_PlanetaX(aux);
        
        aux = aleatorio.nextInt(2147483647);
        //cp.numero_planetas retorna el numero de planetas total
        aux = aux%cp.Consultar_Size();
        //planeta posicio retorna la id del planeta que en l'arbre te la posicio aux
        planetaB = cp.Consultar_PlanetaX(aux);
        
        boolean bidireccional = aleatorio.nextBoolean();
	    Ruta r = new Ruta(id, capacidad, distancia, planetaA, planetaB, bidireccional);
	    ArbolRutas.add(r);
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
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_planetaA();
    }
      
    //Pre: Cierto
    //Post: Retorna la id del planetaB de la ruta con id = "id"
    public int ConsultarPlanetaBRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_planetaB();
    }
      
    //Pre: Cierto
    //Post: Retorna un valor booleano de si la ruta con id = "id" es bidireccional o no
    public boolean ConsultarBidireccionalidadRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_bidireccional();
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
        int idA = ConsultarPlanetaARuta(id_original);
        int idB = ConsultarPlanetaBRuta(id_original);
        cp.Borrar_Salida(idA, id_original);
        cp.Borrar_Entrada(idB, id_original);
        cp.Anadir_Entrada(idB, id_nuevo);
        cp.Anadir_Salida(idA, id_nuevo);
        if(ConsultarBidireccionalidadRuta(id_original)) {
        	cp.Borrar_Salida(idB, id_original);
            cp.Borrar_Entrada(idA, id_original);
            cp.Anadir_Entrada(idA, id_nuevo);
            cp.Anadir_Salida(idB, id_nuevo);
        }
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
        Ruta solicitada = BuscarRuta(id);
        int idA = ConsultarPlanetaARuta(id);
        if(ConsultarBidireccionalidadRuta(id)) cp.Borrar_Entrada(idA, id);
        cp.Borrar_Salida(idA, id); 
        solicitada.modificar_planetaA(id_planetaA_nuevo); 
        cp.Anadir_Salida(id_planetaA_nuevo, id);
        if(ConsultarBidireccionalidadRuta(id)) cp.Anadir_Entrada(id_planetaA_nuevo, id);
    }
    
    //Pre: Existe una ruta con id = "id"
    //Post: EL id del planetaB de la ruta con id = "id" ha sido modificado por id_planetaB = "id_planetaB_nuevo"
    public void ModificarPlanetaBRuta(int id, int id_planetaB_nuevo, ControladorPlaneta cp)throws Exception
    {
        if(ErrorTipografico(id_planetaB_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        int idB = ConsultarPlanetaBRuta(id);
        if(ConsultarBidireccionalidadRuta(id)) cp.Borrar_Salida(idB, id); 
        cp.Borrar_Entrada(idB, id);
        solicitada.modificar_planetaB(id_planetaB_nuevo);
        cp.Anadir_Entrada(id_planetaB_nuevo, id);
        if(ConsultarBidireccionalidadRuta(id)) cp.Anadir_Entrada(id_planetaB_nuevo, id);
    }
    
    public void invertir_planetaA_planetaB(int id, ControladorPlaneta cp) throws Exception
    {
    	Ruta r = BuscarRuta(id);
    	r.invertir_planetas();
    	BorrarRuta(id, cp);
    	CrearRuta(id, r.consultar_capacidad(), r.consultar_distancia(), r.consultar_planetaA(), r.consultar_planetaB(), r.consultar_bidireccional(), cp );
    }
      
    //Pre: Existe una ruta con id = "id"
    //Post: La bidireccionalidad de la ruta con id = "id" ha sido modificada tal que bidireccional = "bidireccional_nuevo"
    public void ModificarBidireccionalidadRuta(int id, boolean bidireccional_nuevo, ControladorPlaneta cp)throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        int idA = ConsultarPlanetaARuta(id);
    	int idB = ConsultarPlanetaBRuta(id);
        if(!bidireccional_nuevo && ConsultarBidireccionalidadRuta(id)) {
        	cp.Borrar_Entrada(idA, id);
        	cp.Borrar_Salida(idB, id);
        }
        else if(bidireccional_nuevo && !ConsultarBidireccionalidadRuta(id)) { 
        	cp.Anadir_Entrada(idA, id);
        	cp.Anadir_Salida(idA, id);
        }
        solicitada.modificar_bidireccional(bidireccional_nuevo);
    }
    
    //Pre: Existe una ruta con id = "id"
    //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
    public void BorrarRuta_desdePlaneta(int id) throws Exception
    {
    	Ruta r = BuscarRuta(id);
    	ArbolRutas.remove(r);
    	}
    
  //Pre: Existe una ruta con id = "id"
  //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
  public void BorrarRuta(int id, ControladorPlaneta cp) throws Exception
  {
	  Ruta r = BuscarRuta(id);
	  int idA = ConsultarPlanetaARuta(id);
	  int idB = ConsultarPlanetaBRuta(id); 
	  if(ConsultarBidireccionalidadRuta(id)) { 
		  cp.Borrar_Entrada(idA, id); 
		  cp.Borrar_Salida(idB, id); 
	  }
	  cp.Borrar_Entrada(idB, id); 
	  cp.Borrar_Salida(idA, id);
	  ArbolRutas.remove(r);
  }
}

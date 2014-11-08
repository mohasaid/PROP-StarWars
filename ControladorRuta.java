import java.util.*;

  
public class ControladorRuta {
    //PARTE PRIVADA
    private TreeSet<Ruta> ArbolRutas;
      
    //PARTE PUBLICA
      
    //ALGORITMOS
      
    public static boolean ErrorTipografico(int i) { 
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
      
    public ControladorRuta()
    {
        ArbolRutas = new TreeSet<Ruta>(new MyIdPComp1());
    }
      
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
        int planetaA = aleatorio.nextInt(2147483647);
        while (!cp.ExistePlaneta(planetaA) ) { 
            planetaA = aleatorio.nextInt(2147483647);
        }
        int planetaB = aleatorio.nextInt(2147483647);
        if (!cp.ExistePlaneta(planetaB) ) {
            planetaB = aleatorio.nextInt(2147483647);
        }
        boolean bidireccional = aleatorio.nextBoolean();
    	
        Ruta r = new Ruta(id, capacidad, distancia, planetaA, planetaB, bidireccional);
        ArbolRutas.add(r);
    }
      
    //CONSULTORAS   
    
    public int ConsultarDistanciaRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_distancia();
    }
    
    public int ConsultarCapacidadRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_capacidad();
    }
      
    public int ConsultarPlanetaARuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_planetaA();
    }
      
    public int ConsultarPlanetaBRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_planetaB();
    }
      
    public boolean ConsultarBidireccionalidadRuta(int id) throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        return solicitada.consultar_bidireccional();
    }
      
      
    //MODIFICADORAS    
    public void ModificarIddRuta(int id_original, int id_nuevo) throws Exception
    {
        if(ErrorTipografico(id_nuevo)){
            throw new Exception("Error : El identificador de una ruta debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id_original);
        solicitada.modificar_id(id_nuevo);
    }
      
      
    public void ModificarCapacidadRuta(int id, int capacidad_nueva) throws Exception
    {
        if(ErrorTipografico(capacidad_nueva)){
            throw new Exception("Error : La capacidad debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_capacidad(capacidad_nueva);
    }
      
    public void ModificarDistanciaRuta(int id, int distancia_nueva)throws Exception
    {
        if(ErrorTipografico(distancia_nueva) || distancia_nueva == 0){
            throw new Exception("Error : La distancia entre planeas debe ser mayor que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_distancia(distancia_nueva);
    }
      
    public void ModificarPlanetaARuta(int id, int id_planetaA_nuevo)throws Exception
    {
        if(ErrorTipografico(id_planetaA_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_planetaA(id_planetaA_nuevo);
    }
      
    public void ModificarPlanetaBRuta(int id, int id_planetaB_nuevo)throws Exception
    {
        if(ErrorTipografico(id_planetaB_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_planetaB(id_planetaB_nuevo);
    }
      
    public void ModificarBidireccionalidadRuta(int id, boolean bidireccional_nuevo)throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        solicitada.modificar_bidireccional(bidireccional_nuevo);
    }
    
    public void BorrarRuta(int id) throws Exception
    {
    	Ruta r = BuscarRuta(id);
    	ArbolRutas.remove(r);
    }
}


class  MyIdPComp1 implements Comparator<Ruta>{
	public int compare(Ruta r1, Ruta r2) { 
		try { 
			if(r2.consultar_id() < r1.consultar_id()) return 1; 
			else return -1; 
			} 
		catch (Exception e) { 
			System.out.print(e); 
			} 
		return 0; 
	} 
}

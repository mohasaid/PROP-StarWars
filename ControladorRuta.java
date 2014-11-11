import java.util.*;
   
public class ControladorRuta {
    //PARTE PRIVADA
    private TreeSet<Ruta> ArbolRutas;
       
    //PARTE PUBLICA
       
    //ALGORITMOS
       
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
        Ruta aux = new Ruta();;
        while (it.hasNext() && !trobat){
        	aux = it.next();
            if (aux.consultar_id() == id) trobat = true;
        }
        return aux;
    }
       
    //CREADORAS
    //Pre: Cierto
    //Post: Retorna un controlador de ruta vacio
    public ControladorRuta()
    {
        ArbolRutas = new TreeSet<Ruta>(new MyIdPComp1());
    }
    //Pre: Cierto
    //Post: Crea una ruta con id = "id", capacidad = "capacidad", distancia = "distancia", planetaA = "planetaA", planetaB = "planetaB", bidireccional = "bidireccional", y la añade al arbol de rutas   
    public void CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional, ControladorPlaneta cp) throws Exception
    {
        if(ExisteRuta(id)){
            throw new Exception("Error: Ya existe una ruta con el mismo identificador");      
        }
        if (!cp.ExistePlaneta(planetaA) ) {
            throw new Exception("Error: El Planeta con id = " + planetaA + "no existe");
        }
        if (!cp.ExistePlaneta(planetaB) ) {
            throw new Exception("Error: El Planeta con id = " + planetaB + "no existe");
        }
        Ruta r = new Ruta(id,capacidad,distancia,planetaA,planetaB,bidireccional);
        ArbolRutas.add(r);
        //added
        cp.Anadir_Entrada(planetaB);
        cp.Anadir_Salida(planetaA);
        if(bidireccional) {
        	cp.Anadir_Entrada(planetaA);
        	cp.Anadir_Salida(PlanetaB);
        }
    }
    //Pre: Cierto
    //Post: Crea una ruta de forma automatica y la añade al arbol de rutas
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
        //Added
        cp.Anadir_Entrada(planetaB);
        cp.Anadir_Salida(planetaA);
        if(bidireccional) {
        	cp.Anadir_Entrada(planetaA);
        	cp.Anadir_Salida(PlanetaB);
        }
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
    public void ModificarIddRuta(int id_original, int id_nuevo) throws Exception
    {
        if(ErrorTipografico(id_nuevo)){
            throw new Exception("Error : El identificador de una ruta debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id_original);
        solicitada.modificar_id(id_nuevo);
        //Added
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
    public void ModificarCapacidadRuta(int id, int capacidad_nueva) throws Exception
    {
        if(ErrorTipografico(capacidad_nueva)){
            throw new Exception("Error : La capacidad debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        int idB = ConsultarPlanetaBRuta(id); //Added
        cp.Borrar_Entrada(idB);//Added
        if(ConsultarBidireccionalidadRuta(id)) { //Added
        	int idA = ConsultarPlanetaARuta(id);//Added
        	cp.Borrar_Entrada(idA);//Added
        }
        solicitada.modificar_capacidad(capacidad_nueva);
        //Added
        cp.Anadir_Entrada(idB, id);
        if(ConsultarBidireccionalidadRuta(id)) cp.Anadir_Entrada(idA, id);
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
    public void ModificarPlanetaARuta(int id, int id_planetaA_nuevo)throws Exception
    {
        if(ErrorTipografico(id_planetaA_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        int idA = ConsultarPlanetaARuta(id); //Added
        if(ConsultarBidireccionalidadRuta(id)) cp.Borrar_Entrada(idA, id); //Added
        cp.Borrar_Salida(idA, id); //Added
        solicitada.modificar_planetaA(id_planetaA_nuevo);
        //Added
        cp.Anadir_Salida(id_planetaA_nuevo, id);
        if(ConsultarBidireccionalidadRuta(id)) cp.Anadir_Entrada(id_planetA_nuevo, id);
    }
    //Pre: Existe una ruta con id = "id"
    //Post: EL id del planetaB de la ruta con id = "id" ha sido modificado por id_planetaB = "id_planetaB_nuevo"   
    public void ModificarPlanetaBRuta(int id, int id_planetaB_nuevo)throws Exception
    {
        if(ErrorTipografico(id_planetaB_nuevo)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        Ruta solicitada = BuscarRuta(id);
        int idB = ConsultarPlanetaBRuta(id); //Added
        if(ConsultarBidireccionalidadRuta(id)) cp.Borrar_Salida(idB, id); //Added
        cp.Borrar_Entrada(idB, id); //Added
        solicitada.modificar_planetaB(id_planetaB_nuevo);
        //Added
        cp.Anadir_Entrada(id_planetaB_nuevo, id);
        if(ConsultarBidireccionalidadRuta(id)) cp.Anadir_Entrada(id_planetB_nuevo, id);
    }
    //Pre: Existe una ruta con id = "id"
    //Post: La bidireccionalidad de la ruta con id = "id" ha sido modificada tal que bidireccional = "bidireccional_nuevo"   
    public void ModificarBidireccionalidadRuta(int id, boolean bidireccional_nuevo)throws Exception
    {
        Ruta solicitada = BuscarRuta(id);
        int idA = ConsultarPlanetaARuta(id); //Added
    	int idB = ConsultarPlanetaBRuta(id); //Added
        if(!bidireccional_nuevo && ConsultarBidireccionalidadRuta(id)) { //Added
        	cp.Borrar_Entrada(idA, id);//Added
        	cp.Borrar_Salida(idB, id);//Added
        }
        else if(bidireccional_nuevo && !ConsultarBidireccionalidadRuta(id)) { //Added
        	cp.Anadir_Entrada(idA, id);//Added
        	cp.Anadir_Salida(idA, id);//Added
        }
        solicitada.modificar_bidireccional(bidireccional_nuevo);
    }
    //Pre: Existe una ruta con id = "id"
    //Post: La ruta con id = "id" ha sido borrada del arbol de rutas
    public void BorrarRuta(int id) throws Exception
    {
        Ruta r = BuscarRuta(id);
        int idA = ConsultarPlanetaARuta(id); //Added
    	int idB = ConsultarPlanetaBRuta(id); //Added
        if(ConsultarBidireccionalidadRuta(id)) { //Added
        	cp.Borrar_Entrada(idA, id); //Added
        	cp.Borrar_Salida(idB, id); //Added
        }
        cp.Borrar_Entrada(idB, id); //Added
    	cp.Borrar_Salida(idA, id); //Added
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

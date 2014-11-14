public class Conexion {
	private int idruta;
	private int planetaA;
	private int planetaB;
	
    //Pre: Cierto
    //Post: Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
    public static boolean ErrorTipografico(int i) {
        return (i<0);
    }
	
    //Pre: Cierto
    //Post: Retorna una conexion vacia
    public Conexion()
    {
        idruta = -1;
        planetaA = -1;
        planetaB = -1;
    }
    
    //Pre: Cierto
    //Post: Crea una conexion con idruta = "i", planetaA = "pA", planetaB = "pB"
    public Conexion(int i, int pA, int pB) throws Exception
    {
        if(ErrorTipografico(i)){
            throw new Exception("Error: El identificador de una ruta debe ser mayor o igual que 0\n");
        }
        if(ErrorTipografico(pA) || ErrorTipografico(pB)){
            throw new Exception("Error: El identificador de un planeta debe ser mayor o igual que 0\n");
        }
        if (pA == pB) {
            throw new Exception("Error: El identificador del planetaA no puede ser igual al del planetaB\n");
        }
        idruta = i;
        planetaA = pA;
        planetaB = pB;
    }
    
    //Pre: Cierto
    //Post: Retorna un entero que representa el identificador de la conexion
    public int consultar_id() throws Exception
    {
        if(idruta == -1) throw new Exception("Error: La ruta no tiene un id asignado");
        return idruta;
    }
    
    //Pre: Cierto
    //Post: Retorna un entero que representa el identificador del planetaA de la conexion  
    public int consultar_planetaA() throws Exception
    {
        if(planetaA == -1) throw new Exception("Error: La ruta no tiene un planeta origen asignado");
        return planetaA;
    }
       
    //Pre: Cierto
    //Post: Retorna un entero que representa el identificador del planetaB de la conexion
    public int consultar_planetaB() throws Exception
    {
        if(planetaB == -1) throw new Exception("Error: La ruta no tiene un planeta destino asignado");
        return planetaB;
    }
    
    //Pre: La conexion esta inicializada
    //Post: se hace un swap entre planeta A i planeta B tal que planetaA = planetaB y planetaB = planetaA
    public void invertir_planetas() throws Exception
    {
    	int aux = planetaA;
    	planetaA = planetaB;
    	planetaB = aux;
    }
    
    //Pre: Cierto
    //Post: El id de la conexion se ha modificado por id = "id_nuevo"
    public void modificar_id(int id_nuevo) throws Exception
    {
        if(ErrorTipografico(id_nuevo)){
            throw new Exception("Error: El identificador de una ruta debe ser mayor o igual que 0\n");
        }
        idruta = id_nuevo;
    }
    
    
    //Pre: Cierto
    //Post: El id del planetaA de la conexion se ha modificado por planetaA = "idA"
    public void modificar_planetaA(int idA) throws Exception
    {
        if( ErrorTipografico(idA) ){
            throw new Exception("Error: El identificador de un planeta debe ser mayor o igual que 0\n");
        }
        if (idA == planetaB) {
            throw new Exception("Error: El identificador del planetaA no puede ser igual al del planetaB\n");
        }
        planetaA = idA;
    }
       
    //Pre: Cierto
    //Post: El id del planetaB de la conexion se ha modificado por planetaB = "idB"
    public void modificar_planetaB(int idB) throws Exception
    {
        if( ErrorTipografico(idB) ){
            throw new Exception("Error: El identificador de un planeta debe ser mayor o igual que 0\n");
        }
        if (idB == planetaA) {
            throw new Exception("Error: El identificador del planetaA no puede ser igual al del planetaB\n");
        }
        planetaB = idB;
    }
}

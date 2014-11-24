import java.util.Comparator;

public class Conexion {
    //PARTE PRIVADA
	private int idruta;
	private String planetaA;
	private String planetaB;
	
    //PARTE PUBLICA
	
    //Pre: Cierto
    //Post: Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
    private static boolean ErrorTipografico(int i) {
        return (i<0);
    }
    
    private static boolean alfa_numeric(String nom)
    {
        if(nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for(int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if(!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
	
    //CONSTRUCTORAS
    
    //Pre: Cierto
    //Post: Crea una conexion con idruta = "i", planetaA = "pA" y planetaB = "pB"
    public Conexion(int i, String pA, String pB) throws Exception
    {
        if(ErrorTipografico(i)){
            throw new Exception("Error: El identificador de una ruta debe ser mayor o igual que 0\n");
        }
        if(!alfa_numeric(pA) || !alfa_numeric(pB)){
            throw new Exception("Error: El nombre del planeta no es alfanumerico\n");
        }
        if (pA == pB) {
            throw new Exception("Error: El identificador del planetaA no puede ser igual al del planetaB\n");
        }
        idruta = i;
        planetaA = pA;
        planetaB = pB;
    }
    
    //CONSULTORAS
    
    //Pre: Cierto
    //Post: Retorna un entero que representa el identificador de la conexion
    public int consultar_id()
    {
        return idruta;
    }
    
    //Pre: Cierto
    //Post: Retorna un string que representa el identificador del planetaA de la conexion  
    public String consultar_planetaA()
    {
        return planetaA;
    }
       
    //Pre: Cierto
    //Post: Retorna un string que representa el identificador del planetaB de la conexion
    public String consultar_planetaB()
    {
        return planetaB;
    }
    
    //MODIFICADORAS
    
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
    public void modificar_planetaA(String idA) throws Exception
    {
        if( !alfa_numeric(idA) ){
            throw new Exception("Error: El nombre del planeta no es alfanumerico\n");
        }
        if (idA == planetaB) {
            throw new Exception("Error: El identificador del planetaA no puede ser igual al del planetaB\n");
        }
        planetaA = idA;
    }
       
    //Pre: Cierto
    //Post: El id del planetaB de la conexion se ha modificado por planetaB = "idB"
    public void modificar_planetaB(String idB) throws Exception
    {
        if( !alfa_numeric(idB) ){
            throw new Exception("Error: El nombre del planeta no es alfanumerico\n");
        }
        if (idB == planetaA) {
            throw new Exception("Error: El identificador del planetaA no puede ser igual al del planetaB\n");
        }
        planetaB = idB;
    }
}


class OrdenConexion implements Comparator<Conexion>{
    public int compare(Conexion c1, Conexion c2) { 
            if(c2.consultar_id() < c1.consultar_id()) return 1; 
            else return -1; 
    } 
}

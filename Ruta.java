import java.util.*;
   
public class Ruta {
    //PARTE PRIVADA
    private int id;
    private int capacidad;
    private int distancia;
    private int planetaA;
    private int planetaB;
    private boolean bidireccional;
       
    //PARTE PUBLICA
       
    //Pre: Cierto
    //Post: Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
    public static boolean ErrorTipografico(int i) {
        return (i<0);
    }
       
    //CONSTRUCTORAS
    
    //Pre: Cierto
    //Post: Retorna una ruta vacia
    public Ruta()
    {
        id = -1;
        capacidad = -1;
        distancia = -1;
        planetaA = -1;
        planetaB = -1;
        bidireccional = false; //Por defecto una ruta es dirigida, no bidireccional
    }
       
    
  //Pre: Cierto
    //Post: Crea una ruta con id = "i", capacidad = "c", distancia = "d", planetaA = "pA", planetaB = "pB", bidireccional = "b"
    public Ruta(int i, int c, int d, int pA, int pB, boolean b) throws Exception
    {
        if(ErrorTipografico(i)){
            throw new Exception("Error : El identificador de una ruta debe ser mayor o igual que 0");
        }
        if(ErrorTipografico(c)){
            throw new Exception("Error : La capacidad debe ser mayor o igual que 0");
        }
        if(ErrorTipografico(d) || d == 0){
            throw new Exception("Error : La distancia entre planeas debe ser mayor que 0");
        }
        if(ErrorTipografico(pA) || ErrorTipografico(pB)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        id = i;
        capacidad = c;
        distancia = d;
        planetaA = pA;
        planetaB = pB;
        bidireccional = b;
    }
            
    //CONSULTORAS
       
    //Pre: Cierto
    //Post: Retorna un entero que representa el identificador de la ruta
    public int consultar_id() throws Exception
    {
        if(id == -1) throw new Exception("Error: La ruta no tiene un id asignado");
        return id;
    }
       
    //Pre: Cierto
    //Post: Retorna un entero que representa la capacidad de la ruta
    public int consultar_capacidad() throws Exception
    {
        if(capacidad == -1) throw new Exception("Error: La ruta no tiene una capacidad asignada");
        return capacidad;
    }
       
    //Pre: Cierto
    //Post: Retorna un entero que representa la distancia de la ruta
    public int consultar_distancia() throws Exception
    {
        if(distancia == -1) throw new Exception("Error: La ruta no tiene una asignado");
        return distancia;
    }
       
    //Pre: Cierto
    //Post: Retorna un entero que representa el identificador del planetaA de la ruta  
    public int consultar_planetaA() throws Exception
    {
        if(planetaA == -1) throw new Exception("Error: La ruta no tiene un planeta origen asignado");
        return planetaA;
    }
       
    //Pre: Cierto
    //Post: Retorna un entero que representa el identificador del planetaB de la ruta
    public int consultar_planetaB() throws Exception
    {
        if(planetaB == -1) throw new Exception("Error: La ruta no tiene un planeta destino asignado");
        return planetaB;
    }
       
    //Pre: Cierto
    //Post: Retorna un valor booleano, el cual es cierto en el caso que la ruta sea bidireccional, en caso contrario, la ruta es solo del planetaA al planetaB
    public boolean consultar_bidireccional() throws Exception
    {
        //if(bidireccional == (Boolean) null) throw new Exception("Error: La ruta no tiene una direccion asignada");
        return bidireccional;
    }
       
    //MODIFICDORAS
       
    //Pre: Cierto
    //Post: El id de la ruta se ha modificado por id = "id_nuevo"
    public void modificar_id(int id_nuevo) throws Exception
    {
        id = id_nuevo;
    }
       
    //Pre: Cierto
    //Post: La capacidad de la ruta se ha modificado por capacidad = "c"
    public void modificar_capacidad(int c) throws Exception
    {
        capacidad = c;
    }
       
    //Pre: Cierto
    //Post: La distancia de la ruta se ha modificado por distancia = "d"
    public void modificar_distancia(int d) throws Exception
    {
        distancia = d;
    }
       
    //Pre: Cierto
    //Post: El id del planetaA de la ruta se ha modificado por planetaA = "idA"
    public void modificar_planetaA(int idA) throws Exception
    {
        planetaA = idA;
    }
       
    //Pre: Cierto
    //Post: El id del planetaB de la ruta se ha modificado por planetaB = "idB"
    public void modificar_planetaB(int idB) throws Exception
    {
        planetaB = idB;
    }
       
    //Pre: Cierto
    //Post: La bidireccionalidad de la ruta ha sido modificada tal que bidireccional = "b"
    public void modificar_bidireccional(boolean b) throws Exception
    {
        bidireccional = b;
    } 
  
}

class OrdenRuta implements Comparator<Ruta>{
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

import java.util.*;
   
public class Ruta {
    //PARTE PRIVADA
    private int id;
    private int capacidad;
    private int distancia;
       
    //PARTE PUBLICA
       
    //Pre: Cierto
    //Post: Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
    private static boolean ErrorTipografico(int i) {
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
    }
       
    //Pre: Cierto
    //Post: Crea una ruta con id = "i", capacidad = "c", distancia = "d"
    public Ruta(int i, int c, int d) throws Exception
    {
        if(ErrorTipografico(i)){
            throw new Exception("Error: El identificador de una ruta debe ser mayor o igual que 0\n");
        }
        if(ErrorTipografico(c)){
            throw new Exception("Error: La capacidad debe ser mayor o igual que 0\n");
        }
        if(ErrorTipografico(d) || d == 0){
            throw new Exception("Error: La distancia entre planeas debe ser mayor que 0\n");
        }
        id = i;
        capacidad = c;
        distancia = d;
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
             
    //MODIFICDORAS
          
    //Pre: Cierto
    //Post: El id de la ruta se ha modificado por id = "id_nuevo"
    public void modificar_id(int id_nuevo) throws Exception
    {
        if(ErrorTipografico(id_nuevo)){
            throw new Exception("Error: El identificador de una ruta debe ser mayor o igual que 0\n");
        }
        id = id_nuevo;
    }
       
    //Pre: Cierto
    //Post: La capacidad de la ruta se ha modificado por capacidad = "c"
    public void modificar_capacidad(int c) throws Exception
    {
        if(ErrorTipografico(c)){
            throw new Exception("Error: La capacidad debe ser mayor o igual que 0\n");
        }
        capacidad = c;
    }
       
    //Pre: Cierto
    //Post: La distancia de la ruta se ha modificado por distancia = "d"
    public void modificar_distancia(int d) throws Exception
    {
        if(ErrorTipografico(d) || d == 0){
            throw new Exception("Error: La distancia entre planeas debe ser mayor que 0\n");
        }
        distancia = d;
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

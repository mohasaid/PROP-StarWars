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
       
    public static boolean ErrorTipografico(int i) {
        return (i<0);
    }
       
    //CONSTRUCTORAS
    public Ruta()
    {
        id = -1;
        capacidad = -1;
        distancia = -1;
        planetaA = -1;
        planetaB = -1;
        bidireccional = false; //Por defecto una ruta es dirigida, no bidireccional
    }
       
       
    public Ruta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional) throws Exception
    {
        if(ErrorTipografico(id)){
            throw new Exception("Error : El identificador de una ruta debe ser mayor o igual que 0");
        }
        if(ErrorTipografico(capacidad)){
            throw new Exception("Error : La capacidad debe ser mayor o igual que 0");
        }
        if(ErrorTipografico(distancia) || distancia == 0){
            throw new Exception("Error : La distancia entre planeas debe ser mayor que 0");
        }
        if(ErrorTipografico(planetaA) || ErrorTipografico(planetaB)){
            throw new Exception("Error : El identificador de un planeta debe ser mayor o igual que 0");
        }
        this.id = id;
        this.capacidad = capacidad;
        this.distancia = distancia;
        this.planetaA = planetaA;
        this.planetaB = planetaB;
        this.bidireccional = bidireccional;
    }
            
    //CONSULTORAS
       
    public int consultar_id() throws Exception
    {
        if(id == -1) throw new Exception("Error: La ruta no tiene un id asignado");
        return id;
    }
       
    public int consultar_capacidad() throws Exception
    {
        if(capacidad == -1) throw new Exception("Error: La ruta no tiene una capacidad asignada");
        return capacidad;
    }
       
       
    public int consultar_distancia() throws Exception
    {
        if(distancia == -1) throw new Exception("Error: La ruta no tiene una asignado");
        return distancia;
    }
       
       
    public int consultar_planetaA() throws Exception
    {
        if(planetaA == -1) throw new Exception("Error: La ruta no tiene un planeta origen asignado");
        return planetaA;
    }
       
       
    public int consultar_planetaB() throws Exception
    {
        if(planetaB == -1) throw new Exception("Error: La ruta no tiene un planeta destino asignado");
        return planetaB;
    }
       
       
    public boolean consultar_bidireccional() throws Exception
    {
        //if(bidireccional == (Boolean) null) throw new Exception("Error: La ruta no tiene una direccion asignada");
        return bidireccional;
    }
       
    //MODIFICDORAS
       
    public void modificar_id(int id_nuevo) throws Exception
    {
        id = id_nuevo;
    }
       
    public void modificar_capacidad(int k) throws Exception
    {
        capacidad = k;
    }
       
       
    public void modificar_distancia(int d) throws Exception
    {
        distancia = d;
    }
       
       
    public void modificar_planetaA(int idA) throws Exception
    {
        planetaA = idA;
    }
       
       
    public void modificar_planetaB(int idB) throws Exception
    {
        planetaB = idB;
    }
       
       
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

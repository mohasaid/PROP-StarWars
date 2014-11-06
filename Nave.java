import java.util.*;

public class Nave {

	private int ident;
	private TipoNave tipo;
	private int destino;
	private boolean tt;
 
	public static boolean ErrorTipografico(int i) {  
        	return (i<0);
	} 

	//pre: cierto
	//post: El resultado es una nave vacía
	public Nave(){
		ident = -1;
		destino = -1;
		tipo = new TipoNave();
		tt = false;
	}

	
	//pre: El planeta destino d existe en la galaxia y el identificador id no está un uso
	//post: El resultado es una Nave sin tipo
	public Nave(int id, int d) throws Exception {
		if(ErrorTipografico(id)){
		        throw new Exception("Error : El identificador de una nave debe ser mayor o igual que 0\n"); 
		}	
		ident = id;
		destino = d;
		tt = false;
		tipo = new TipoNave();	
	}

	//pre: El planeta destino d existe en la galaxia
	//post: El resultado es una Nave inicializada
	public Nave(int id, TipoNave t, int d) throws Exception {
		if(ErrorTipografico(id)){
		        throw new Exception("Error : El identificador de una nave debe ser mayor que 0\n"); 
		}		
		ident = id;
		tipo = t;
		destino = d;
		tt = true;
	}

	//pre: cierto
	//post: Asigna un tipo a la nave.
	public void asignar_tipo(TipoNave t) throws Exception{
		if(t.consultar_tipo() == -1){
			throw new Exception("Error: No se puede asociar un tipo sin inicializar a una nave.\n");
		}
		tipo = t;
		tt =true;
	}
	//pre: cierto
	//post: retorna el tipo de la nave
	public TipoNave consultar_tipo() throws Exception{
		if(tipo.consultar_tipo() == -1){
			throw new Exception("Error: La nave no tiene un tipo asignado\n");
		}
		return tipo;
	}
	//pre: cierto
	//post: retorna un entero que representa el identificador de la nave
	public int consultar_id() throws Exception{
		if(ident == -1){
			throw new Exception("Error: La nave no tiene un id asignado\n");
		}
		return ident;
	}

	//pre: cierto
	//post: retorna un entero que representa el consumo de la nave
	public int consultar_consumo() throws Exception {
		if(!tt){
			throw new Exception("Error : La nave no tiene un tipo asignado\n"); 
		}
		 return tipo.consultar_consumo();
	}

	//pre: cierto
	//post: retorna un entero que representa identif del planeta al que la nave se dirige
	public int consultar_destino() throws Exception{
		if(destino == -1){
			throw new Exception("Error: la nave no tiene destino asignado\n");	
		}	
		return destino;
	
	}

	//pre: cierto
	//post: la id se ha modificado por el entero id
	public void modificar_id(int id) throws Exception{
		if(ErrorTipografico(id)) {  
		        throw new Exception("Error : El identificador de una nave debe ser mayor o igual que 0\n"); 
        	}  	
		ident = id;
	}
	//pre: t no es un tipo vacío
	//post: el tipo de la nave pasa a ser t
	public void modificar_tipo(TipoNave t) throws Exception{
		tipo = t;
		tt = true;
	}

	//pre: El planeta destino idD existe en la galaxia
	//post: se ha modificado el destino de la nave por idD
	public void modificar_destino(int idD) throws Exception {
		if(ErrorTipografico(idD)){
			throw new Exception("Error: El identificador del planeta destino ha de ser mayor o igual que 0\n");	
	}
		destino = idD;
	}
	//Pre:cierto
	//post: se ha eliminado el tipo de la nave;
	public void eliminar_tipo(){
		tipo = new TipoNave();
		tt = false;
	}
}

class OrdenNave implements Comparator<Nave>{
    public int compare(Nave n1, Nave n2){
        try{
            if(n2.consultar_id() < n1.consultar_id()) return 1;
            else return -1;
        }
        catch(Exception e){
            System.out.print(e);
        }
        return 0;
    }
}


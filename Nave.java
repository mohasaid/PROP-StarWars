import java.util.*;

public class Nave {

	protected int ident;
	protected int destino;
 
	protected static boolean ErrorTipograficoID(int i) {  
        	return (i<0);
	} 

	//pre: cierto
	//post: El resultado es una nave vacía
	public Nave(){
		ident = -1;
		destino = -1;
	}

	
	//pre: El planeta destino d existe en la galaxia y el identificador id no está un uso
	//post: El resultado es una Nave sin tipo
	public Nave(int id, int d) throws Exception {
		if(ErrorTipograficoID(id)){
		        throw new Exception("Error : El identificador de una nave debe ser mayor o igual que 0\n"); 
		}	
		ident = id;
		destino = d;
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
		if(ErrorTipograficoID(id)) {  
		        throw new Exception("Error : El identificador de una nave debe ser mayor o igual que 0\n"); 
        	}  	
		ident = id;
	}
	//pre: El planeta destino idD existe en la galaxia
	//post: se ha modificado el destino de la nave por idD
	public void modificar_destino(int idD) throws Exception {
		if(ErrorTipograficoID(idD)){
			throw new Exception("Error: El identificador del planeta destino ha de ser mayor o igual que 0\n");	
	}
		destino = idD;
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


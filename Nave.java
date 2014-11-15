import java.util.*;

public class Nave {

	protected int ident;
	protected int destino;
	protected int origen;
 
	protected static boolean ErrorTipograficoID(int i) {  
        	return (i<0);
	} 

	//pre: cierto
	//post: El resultado es una nave vacía
	/**
	 * metodo que crea una nave vacía
	 */
	public Nave(){
		ident = -1;
		destino = -1;
		origen = -1;
	}

	
	//pre: El planeta destino d existe en la galaxia y el identificador id no está un uso
	//post: El resultado es una Nave sin tipo
	/**
	 * metodo que crea una nave con identificador, destino y origen.
	 * @param id
	 * @param d
	 * @param o
	 * @throws Exception
	 */
	public Nave(int id, int d, int o) throws Exception {
		if(ErrorTipograficoID(id)){
		        throw new Exception("Error : El identificador de una nave debe ser mayor o igual que 0\n"); 
		}
		if(ErrorTipograficoID(d)){
	        throw new Exception("Error : El identificador del planeta destino debe ser mayor o igual que 0\n"); 
	}	
		if(ErrorTipograficoID(o)){
	        throw new Exception("Error : El identificador del planeta origen debe ser mayor o igual que 0\n"); 
	}	
		ident = id;
		destino = d;
		origen= o;
	}

	//pre: cierto
	//post: retorna un entero que representa el identificador de la nave
	/**
	 * metodo que consulta el identificador de una nave
	 * @throws Exception
	 */
	public int consultar_id() throws Exception{
		if(ident == -1){
			throw new Exception("Error: La nave no tiene un id asignado\n");
		}
		return ident;
	}

	//pre: cierto
	//post: retorna un entero que representa el identificador del planeta al que la nave se dirige
	 /** metodo que consulta el destino de una nave
	 * @throws Exception
	 */
	public int consultar_destino(){

		return destino;
	
	}
	//pre:cieto
	//post: retorna un entero que representa el identificador del planeta en el que se encuentra la nave inicialmente
	/** metodo que consulta el origen de una nave
	 * @throws Exception
	 */
	public int consultar_origen(){
		return origen;
	}
	//pre: cierto
	//post: la id se ha modificado por el entero id
	/** metodo que modifica el identificador de una nave
	 * @param id
	 * @throws Exception
	 */
	public void modificar_id(int id) throws Exception{
		if(ErrorTipograficoID(id)) {  
		        throw new Exception("Error : El identificador de una nave debe ser mayor o igual que 0\n"); 
        	}  	
		ident = id;
	}
	//pre: El planeta destino idD existe en la galaxia
	//post: se ha modificado el destino de la nave por idD
	/** metodo que modifica el destino de una nave
	 * @param idD
	 * @throws Exception
	 */
	public void modificar_destino(int idD) throws Exception {
		if(ErrorTipograficoID(idD)){
			throw new Exception("Error: El identificador del planeta destino ha de ser mayor o igual que 0\n");	
	}
		destino = idD;
	}
	//pre: El planeta origen idO existe en la galaxia
	//post: se ha modificado el origen por el planeta con identificador idO
	/** metodo que modifica el origen de una nave
	 * @param idO
	 * @throws Exception
	 */
	public void modificar_origen(int idO) throws Exception {
		if(ErrorTipograficoID(idO)){
			throw new Exception("Error: El identificador del planeta origen ha de ser mayor o igual que 0\n");	
	}
		origen = idO;
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


import java.util.Comparator;

//TIPO2

public class TipoNave2 extends Nave{
	public static int consumo;
	public static boolean definido = false;

	public static boolean ErrorTipografico(int i) {  
        	return (i<=0);
	} 
	
	public static void DefinirTipo(int c) throws Exception{
		if(ErrorTipografico(c)){
			throw new Exception("Error: el consumo debe ser mayor que 0\n");
		}
			consumo = c;
			definido = true;
	}
	//pre: cierto
	//post: crea una nave de tipo 2 vacía
	public TipoNave2(){
		ident = -1;
		destino =-1;
	}
	//pre:cierto;
	//Post: Crea una nave de tipo 2 a partir de una nave vacía
	public TipoNave2(Nave n) throws Exception{
		ident = n.consultar_id();
		destino = n.consultar_destino();
	}

	//pre: el nombre de tipo t no existe ya
	//post: crea una nave de tipo 1 inicializada
	public TipoNave2(int id,int d) throws Exception{
		if(ErrorTipograficoID(id)){
			throw new Exception("Error: El identificador del tipo debe ser mayor o igual que 0\n");
		}
		if(ErrorTipograficoID(d)){
			throw new Exception("Error: El identificador del planeta destino tiene que ser mayor o igual que 0\n");
		}
		if(!definido){
			throw new Exception("Error: el tipo de nave 2 no ha sido definido\n");
		}
		ident = id;
		destino = d;
	}
	
	//Pre:cierto
		//Post devuelve el estado del tipo de nave.
		public boolean EstaDefinido(){
			return definido;
		}
		
	//pre: cierto
	//post: retorna el nombre que identifica al tipo
	public int consultar_tipo() throws Exception{
		return 2;
	}
	
	//pre: cierto
	//post: retorna el consumo asociado al tipo
	public int consultar_consumo() throws Exception{
		if(consumo == 0){
		throw new Exception("Error: El tipo de nave no tiene un consumo asociado\n");	
	}
		return consumo;
	}

	//pre: cierto
	//post: modifica el consumo asociado al tipo de nave
	public static void modificar_consumo(int c) throws Exception{
		if(ErrorTipografico(c)){
			throw new Exception("Error: El consumo debe de ser superior a 0\n");	
		}
		consumo = c;
	}
}
class OrdenTipoNave2 implements Comparator<TipoNave2>{
    public int compare(TipoNave2 n1, TipoNave2 n2){
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

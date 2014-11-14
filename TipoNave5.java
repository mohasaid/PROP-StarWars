
public class TipoNave5 extends Nave{
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
	//post: crea una nave de tipo 5 vacía
	public TipoNave5(){
		ident = -1;
		destino =-1;
		origen = -1;
	}
	//pre:cierto;
	//Post: Crea una nave de tipo 5 a partir de una nave vacía
	public TipoNave5(Nave n) throws Exception{
		ident = n.consultar_id();
		destino = n.consultar_destino();
		origen = n.consultar_origen();
	}

	//pre:cierto
	//post: crea una nave de tipo 5 inicializada
	public TipoNave5(int id,int d,int o) throws Exception{
		if(ErrorTipograficoID(id)){
			throw new Exception("Error: El identificador del tipo debe ser mayor o igual que 0\n");
		}
		if(ErrorTipograficoID(d)){
			throw new Exception("Error: El identificador del planeta destino debe ser mayor o igual que 0\n");
		}
		if(ErrorTipograficoID(o)){
			throw new Exception("Error: El identificador del planeta origen debe ser mayor o igual que 0\n");
		}
		if(!definido){
			throw new Exception("Error: el tipo de nave 1 no ha sido definido\n");
		}
		ident = id;
		destino = d;
		origen = o;
	}
	
	//Pre:cierto
		//Post devuelve el estado del tipo de nave.
		public boolean EstaDefinido(){
			return definido;
		}
		
	//pre: cierto
	//post: retorna el numero que identifica al tipo
	public int consultar_tipo() throws Exception{
		return 5;
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
class OrdenTipoNave5 implements Comparator<TipoNave5>{
    public int compare(TipoNave5 n1, TipoNave5 n2){
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

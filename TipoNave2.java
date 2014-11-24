import java.util.Comparator;


//TIPO 2:

public class TipoNave2 extends Nave{
	private static int consumo=0;
	private static boolean definido = false;

	//pre:cierto
	//post: el tipo de nave 2 queda definido pasando a tener consumo c asignado
	/**
	 * metodo que define el tipo de nave 2 asignandole un consumo
	 * @param c
	 * @throws Exception
	 */
	public static void DefinirTipo(int c) throws Exception{
		if(ErrorTipografico(c)){
			throw new Exception("Error: el consumo debe ser mayor que 0\n");
		}
			consumo = c;
			definido = true;
	}
	//pre: cierto
	//post: crea una nave de tipo 2 inicializada
	/**
	 * metodo que crea una nave de tipo 2 con identificador, destino y origen
	 * @param id
	 * @param d
	 * @param o
	 * @throws Exception
	 */
	public TipoNave2(int id,String d,String o) throws Exception{
		if(ErrorTipograficoID(id)){
			throw new Exception("Error: El identificador del tipo debe ser mayor o igual que 0\n");
		}
		if(!alfa_numeric(d)){
			throw new Exception("Error: El identificador del planeta destino ha de ser alfa numerico\n");	
		}
		if(!alfa_numeric(o)){
			throw new Exception("Error: El identificador del planeta destino ha de ser alfa numerico\n");	
		}
		if(!definido){
			throw new Exception("Error: el tipo de nave 2 no ha sido definido\n");
		}
		ident = id;
		destino = d;
		origen = o;
	}
	//Pre:cierto
	//Post devuelve el estado del tipo de nave.
	/**
	 * metodo que crea consulta si el tipo 2 está definido
	 */
	public static boolean EstaDefinido(){
		return definido;
	}
	//pre: cierto
	//post: retorna el nombre que identifica al tipo
	/**
	 * metodo que consulta el tipo de una nave
	 * @throws Exception
	 */
	public int consultar_tipo(){
		return 2;
	}

	//pre: cierto
	//post: retorna el consumo asociado al tipo
	/**
	 * metodo que consulta el consumo asociado al tipo de nave 2
	 * @throws Exception
	 */
	public static int consultar_consumo(){
		return consumo;
	}

	//pre: cierto
	//post: modifica el consumo asociado al tipo de nave
	/**
	 * metodo que modifica el consumo asociado al tipo de nave 2
	 * @param c
	 * @throws Exception
	 */
	public static void modificar_consumo(int c) throws Exception{
		if(ErrorTipografico(c)){
			throw new Exception("Error: El consumo debe de ser superior a 0\n");	
		}
		consumo = c;
	}
}



import java.util.*;



	public class Arco {
		private int id;
		private Nodo origen;
		private Nodo destino;
		private int capacidad;
		private int coste; //Contiene la distancia/precio del arco según la función de coste escogida
		private int idRuta;
		
		//CREADORAS
		//Pre: cierto
		//Post: crea un arco vacío
		/**
		 * Metodo para crear un Arco vacío.
		 */
		public Arco(){
			id = -1;
			origen = new Nodo();
			destino = new Nodo();
			capacidad = 0;
			coste = -1;
			idRuta=-1;
		}
		
		//Pre: existe una ruta con identificador idr y indent,c y idr son enteros mayores que 0 y los nodos no son vacíos.
		//Post: Crea un Arco inicializado
		/**
		* Metodo para crear un Arco con nombre, nodo origen, nodo destino, capacidad e identificador de la ruta original.
		* @param ident
		* @param o
		* @param d
		* @param c
		* @param idr
		*/
		public Arco(int ident, Nodo o, Nodo d, int c,int idr){
			id = ident;
			origen = o;
			destino = d;
			capacidad = c;
			coste = -1;
			idRuta= idr;
		}
		//CONSULTORAS	
		//Pre: Cierto
		//Post: Devuelve el identificador del arco
		 /**
		* Metodo para consultar el identificador de un Arco
		*/
		public int ConsultarId(){
			return id;
		}
		//Pre: Cierto
		//Post: Devuelve el nodo origen del arco
		/**
		 * metodo para con sultar el nodo origen de un Arco
		 */
		public Nodo ConsultarOrigen(){
				return origen;
		}
		//Pre: Cierto
		//Post: Devuelve el nodo oestino del arco
		/**
		 * metodo para consultar el nodo destino de un Arco
		 */
		public Nodo ConsultarDestino(){
			return destino;
		}
		//Pre: Cierto
		//Post: Devuelve la capacidad del arco
		/** 
		* metodo para consultar la capacidad asociada a un arco
		 */
		public int ConsultarCapacidad(){
			return capacidad;
		}
		
		//Pre: Cierto
		//Post: Devuelve el coste del arco
		/** 
		* metodo para consultar el coste asociado a un arco
		 */
		public int ConsultarCoste(){
			return coste;
		}
		
		//pre:cierto
		//post: Devuelve el identificador de la ruta original
		/**
		 * metodo para consultar el identificador de la ruta original en base a la cual se ha creado el arco
		 */
			public int ConsultarIdRuta(){
				return idRuta;
		}
		//MODIFICADORAS
	
		//Pre: Cierto
		//Post: el identificador del arco pasa a ser idn
			/**
			 * @param idn
			 * metodo para modificar el identificador de un arco
			 */
		public void ModificarId(int idn){
				id = idn;
		}
		
		//Pre:Cierto
		//Post: el nodo origen del arco pasa a ser on
		/** 
		* @param on
		 * metodo para modificar el nodo origen de un arco
		 */
		public void ModificarOrigen(Nodo on){
			origen = on;
		}
		
		//Pre: El nodo on no está vacío
		//Post: el nodo destino del arco pasa a ser dn
		/** 
		* @param dn
		 * metodo para modificar el nodo destino de un arco
		 */
		public void ModificarDestino(Nodo dn){
			destino = dn;
		}
		
		//Pre: el nodo dn no está vacío
		//Post: la capacidad del arco pasa a valer cn
		/**
		* @param cn
		 * metodo para modificar la capacidad asignada a un arco
		 */
		public void ModificarCapacidad(int cn){
			capacidad = cn;
		}
		
		
		//Pre: el coste cn es un entero mayor que 0
		//Post el coste del arco pasa valer cn
		/** 
		* @param cn
		 * metodo para modificar el coste asociado a una arco
		 */
		public void ModificarCoste(int cn){
			coste = cn;
		}
		
		//Pre: la ruta idrn existe en la galaxia
		//Post: el id de la ruta original del arco para a ser idrn
		/** 
		* @param idrn
		 * metodo para modificar el id de la ruta original del arco
		 */
		public void ModificarIdRuta(int idrn){
			idRuta = idrn;
		}
	}

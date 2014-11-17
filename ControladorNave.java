import java.util.*;

public class ControladorNave{
	private TreeSet<TipoNave1> listaNaves1;
	private TreeSet<TipoNave2> listaNaves2;
	private TreeSet<TipoNave3> listaNaves3;
	private TreeSet<TipoNave4> listaNaves4;
	private TreeSet<TipoNave5> listaNaves5;
	private static int idn=0;
	private Iterator<TipoNave1> itc1;
	private Iterator<TipoNave2> itc2;
	private Iterator<TipoNave3> itc3;
	private Iterator<TipoNave4> itc4;
	private Iterator<TipoNave5> itc5;
	ControladorDadesNave Cdn;
		//Pre: cierto
		//Post: Crea un ControladorNave
	/**
	 * metodo que crea un controlador de nave
	 */
		public ControladorNave(){
			listaNaves1 = new TreeSet<TipoNave1>(new OrdenTipoNave1());
			listaNaves2 = new TreeSet<TipoNave2>(new OrdenTipoNave2());
			listaNaves3 = new TreeSet<TipoNave3>(new OrdenTipoNave3());
			listaNaves4 = new TreeSet<TipoNave4>(new OrdenTipoNave4());
			listaNaves5 = new TreeSet<TipoNave5>(new OrdenTipoNave5());
			Cdn = new ControladorDadesNave();
		}
		
			public ArrayList<Integer> IdNaves() throws Exception{
				ArrayList<Integer> res = new ArrayList<Integer>();
				Iterator<TipoNave1> it = listaNaves1.iterator();
				while(it.hasNext()){
						res.add(it.next().consultar_id());
					}
				Iterator<TipoNave2> it2 = listaNaves2.iterator();
				while(it2.hasNext()){
						res.add(it2.next().consultar_id());
					}
				Iterator<TipoNave3> it3 = listaNaves3.iterator();
				while(it3.hasNext()){
						res.add(it3.next().consultar_id());
					}
				Iterator<TipoNave4> it4 = listaNaves4.iterator();
				while(it4.hasNext()){
						res.add(it4.next().consultar_id());
					}
				Iterator<TipoNave5> it5 = listaNaves5.iterator();
				while(it5.hasNext()){
						res.add(it5.next().consultar_id());
					}
			}
			
				//Pre: cierto
				//Post: devuelve la nave con identificador "id"
		/**
		 * metodo que devuelve la nave con identificador id 
		 * @param id
		 * @throws Exception
		 */
				public Nave BuscarNave(int id) throws Exception{
						Iterator<TipoNave1> it = listaNaves1.iterator();
						boolean found = false;
						while(it.hasNext() && !found){
							Nave aux = it.next();
							if(aux.consultar_id() == id){
								found = true;
								return aux;
							}
						}
						Iterator<TipoNave2> it2 = listaNaves2.iterator();
						while(it2.hasNext() && !found){
							Nave aux = it2.next();
							if(aux.consultar_id() == id){
								found = true;
								return aux;
							}
						}
						Iterator<TipoNave3> it3 = listaNaves3.iterator();
						while(it3.hasNext() && !found){
							Nave aux = it3.next();
							if(aux.consultar_id() == id){
								found = true;
								return aux;
							}
						}
						Iterator<TipoNave4> it4 = listaNaves4.iterator();
						while(it4.hasNext() && !found){
							Nave aux = it4.next();
							if(aux.consultar_id() == id){
								found = true;
								return aux;
							}
						}
						Iterator<TipoNave5> it5 = listaNaves5.iterator();
						while(it5.hasNext() && !found){
							Nave aux = it5.next();
							if(aux.consultar_id() == id){
								found = true;
								return aux;
							}
						}
						if(!found){
							throw new Exception("Error: No existe ninguna nave con el identificador introducido\n");
						}
						return null;
				}
				public ArrayList<Integer> PlanetasOrigen() throws Exception{
					ArrayList<Integer> planetas = new ArrayList<Integer>();
					Iterator<TipoNave1> it = listaNaves1.iterator();
					while(it.hasNext()){
							TipoNave1 aux = it.next();
							Integer p = new Integer(aux.consultar_origen());
							if(!planetas.contains(p)) planetas.add(p);
						}
					Iterator<TipoNave2> it2 = listaNaves2.iterator();
					while(it2.hasNext()){
							TipoNave2 aux = it2.next();
							Integer p = new Integer(aux.consultar_origen());
							if(!planetas.contains(p))planetas.add(p);
						}
					Iterator<TipoNave3> it3 = listaNaves3.iterator();
					while(it3.hasNext()){
							TipoNave3 aux = it3.next();
							Integer p = new Integer(aux.consultar_origen());
							if(!planetas.contains(p))planetas.add(p);
						}
					Iterator<TipoNave4> it4 = listaNaves4.iterator();
					while(it4.hasNext()){
							TipoNave4 aux = it4.next();
							Integer p = new Integer(aux.consultar_origen());
							if(!planetas.contains(p))planetas.add(p);
						}
					Iterator<TipoNave5> it5 = listaNaves5.iterator();
					while(it5.hasNext()){
							TipoNave5 aux = it5.next();
							Integer p = new Integer(aux.consultar_origen());
							if(!planetas.contains(p))planetas.add(p);
						}
					return planetas;				
			}
				public ArrayList<Integer> PlanetasDestino() throws Exception{
					ArrayList<Integer> planetas = new ArrayList<Integer>();
					Iterator<TipoNave1> it = listaNaves1.iterator();
					while(it.hasNext()){
							TipoNave1 aux = it.next();
							Integer p = new Integer(aux.consultar_destino());
							if(!planetas.contains(p))planetas.add(p);
						}
					Iterator<TipoNave2> it2 = listaNaves2.iterator();
					while(it2.hasNext()){
							TipoNave2 aux = it2.next();
							Integer p = new Integer(aux.consultar_destino());
							if(!planetas.contains(p))planetas.add(p);
						}
					Iterator<TipoNave3> it3 = listaNaves3.iterator();
					while(it3.hasNext()){
							TipoNave3 aux = it3.next();
							Integer p = new Integer(aux.consultar_destino());
							if(!planetas.contains(p))planetas.add(p);
						}
					Iterator<TipoNave4> it4 = listaNaves4.iterator();
					while(it4.hasNext()){
							TipoNave4 aux = it4.next();
							Integer p = new Integer(aux.consultar_destino());
							if(!planetas.contains(p))planetas.add(p);
						}
					Iterator<TipoNave5> it5 = listaNaves5.iterator();
					while(it5.hasNext()){
							TipoNave5 aux = it5.next();
							Integer p = new Integer(aux.consultar_destino());
							if(!planetas.contains(p))planetas.add(p);
						}
					return planetas;				
			}


		//Pre: cierto
		//Post: comprueva si existe el tipo de nave ocn identificador "id"
				/**
				 * metodo que retorna un booleano indicando si el tipo id ha sido definido
				 * @param id
				 * @throws Exception
				 */
		public boolean ExisteTipo(int id) throws Exception{
			if (id==1){
				return TipoNave1.definido;
			}
			if (id==2){
				return TipoNave2.definido;
			}
			if (id==3){
				return TipoNave3.definido;
			}
			if (id==4){
				return TipoNave4.definido;
			}
			if (id==5){
				return TipoNave5.definido;
			}
			else throw new Exception("Error; el identificador del tipo tiene que estar entre 1 y 5\n");
		} 
		/**
		 * metodo para comprovar si existe una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		//Pre:cierto
		//Post: comprueva si existe la nave con identificador "id"
		public boolean ExisteNave(int id) throws Exception{
			Iterator<TipoNave1> it = listaNaves1.iterator();
			while(it.hasNext()){
				if(it.next().consultar_id() == id) return true;
			}
			Iterator<TipoNave2> it2 = listaNaves2.iterator();
			while(it2.hasNext()){
				if(it2.next().consultar_id() == id) return true;
			}
			Iterator<TipoNave3> it3 = listaNaves3.iterator();
			while(it3.hasNext()){
				if(it3.next().consultar_id() == id) return true;
			}
			Iterator<TipoNave4> it4 = listaNaves4.iterator();
			while(it4.hasNext()){
				if(it4.next().consultar_id() == id) return true;
			}
			Iterator<TipoNave5> it5 = listaNaves5.iterator();
			while(it5.hasNext()){
				if(it5.next().consultar_id() == id) return true;
			}
			return false;
		}
		
		//Pre:cierto
		//Post: Devuelve el menor identificador de tipo que no haya sido definido, y -1 en caso de que tidos esten definidos
		/**
		 * metodo que devulve el identificador de un tipo que no haya sido aún definido
		 */
		private int TipoNoDefinido(){
					if(!TipoNave1.definido)return 1;
					if(!TipoNave2.definido)return 2;
					if(!TipoNave3.definido)return 3;
					if(!TipoNave4.definido)return 4;
					if(!TipoNave5.definido)return 5;
					return -1;
		}
		//Pre:cierto
		//Post: devuelve un boleean indicando si hay algÃºn tipo definido
		/**
		 * metodo que indica si queda algún tipo por definir
		 */
		public boolean NingunTipo(){
			if(TipoNave1.definido) return false;
			if(TipoNave2.definido) return false;
			if(TipoNave3.definido) return false;
			if(TipoNave4.definido) return false;
			if(TipoNave5.definido) return false;
			return true;
		}
		//Pre: existe algun tipo definido
		//Post: devuelve un tipo aleatorio que estÃ© definido
		/**
		 * metodo que devuelve el identificador de un tipo de nave que haya sido definido aleatoriamente.
		 */
		public int TipoRandom(){
			ArrayList<Integer> def = new ArrayList<Integer>();
			if(TipoNave1.definido) def.add(1);
			if(TipoNave2.definido) def.add(2);
			if(TipoNave3.definido) def.add(3);
			if(TipoNave4.definido) def.add(4);
			if(TipoNave5.definido) def.add(5);
			int s = def.size();
			int t = (int)(Math.random()*s)+0;

			return (int)def.get(t);
		}
		//CREADORAS NAVE
		
		//Pre: cierto
		//Post: Crea una Nave manualmente y la aÃ±ade a la lista
		/**
		 * metodo que crea una nave de un tipo, con identificador, destino y origen
		 * @param id
		 * @param t
		 * @param d
		 * @param o
		 * @throws Exception
		 */
		public void CrearNave(int id, int t, int d,int o) throws Exception{
			if(ExisteNave(id)){
				throw new Exception("Error: Ya existe una nave con el mismo identificador\n");		
			}
			if(!ExisteTipo(t)){
				throw new Exception("Error: No existe ningun tipo de nave con el identificador introducido\n");
			}
				if(t<1 || t>5) throw new Exception("Error: El identificador del tipo debe estar entre 1 y 5\n");
				if(t==1){
					TipoNave1 n = new TipoNave1(id,d,o);
					listaNaves1.add(n);
				}
				if(t==2){
					TipoNave2 n = new TipoNave2(id,d,o);
					listaNaves2.add(n);
				}
				if(t==3){
					TipoNave3 n = new TipoNave3(id,d,o);
					listaNaves3.add(n);
				}
				if(t==4){
					TipoNave4 n = new TipoNave4(id,d,o);
					listaNaves4.add(n);
				}
				if(t==5){
					TipoNave5 n = new TipoNave5(id,d,o);
					listaNaves5.add(n);
				}
				
		}
		//Pre: cierto
		//Post: Crea una Nave de forma automatica
		/**
		 * metodo que crea i naves de forma automatica
		 * @param lp
		 * @throws Exception
		 */
		public void CrearNaveAuto(int i,ArrayList<Integer> lp) throws Exception{
			while(i>0){
				while(ExisteNave(idn)) ++idn;
				if(NingunTipo()){
					throw new Exception("Error: No existe ningun tipo de nave\n");
				}
				int t = TipoRandom();
				int d = (int)(Math.random()*lp.size())+0;
				int dest = lp.get(d);
				int or = (int)(Math.random()*lp.size())+0;
				int o = lp.get(or);
				if(t==1){
					TipoNave1 n = new TipoNave1(idn,dest,o);
					listaNaves1.add(n);	
				}
				if(t==2){
					TipoNave2 n = new TipoNave2(idn,dest,o);
					listaNaves2.add(n);	
				}
				if(t==3){
					TipoNave3 n = new TipoNave3(idn,dest,o);
					listaNaves3.add(n);	
				}
				if(t==4){
					TipoNave4 n = new TipoNave4(idn,dest,o);
					listaNaves4.add(n);	
				}
				if(t==5){
					TipoNave5 n = new TipoNave5(idn,dest,o);
					listaNaves5.add(n);	
				}
				--i;
			}
			
		}
		
		//CREADORAS TIPO DE NAVE
		/**
		 * metodo que crea un tipo de nave
		 * @param id
		 * @param c
		 * @throws Exception
		 */
		//Pre: cierto
		//Post: Crea un tipo de nave y lo anade a la lista
		
		public void CrearTipoNave(int id, int c) throws Exception{
			if((id<1) || (id>5)){
				throw new Exception("Error: El identificador de un tipo debe estar entre 1 y 5\n");
			}
			if(ExisteTipo(id)){
				throw new Exception("Error: Ya existe un tipo con el mismo nombre\n");		
			}
			if(id==1){
				TipoNave1 n = new TipoNave1();
				n.DefinirTipo(c);
			}
			if(id==2){
				TipoNave2 n = new TipoNave2();
				n.DefinirTipo(c);
			}
			if(id==3){
				TipoNave3 n = new TipoNave3();
				n.DefinirTipo(c);
			}
			if(id==4){
				TipoNave4 n = new TipoNave4();
				n.DefinirTipo(c);
			}
			if(id==5){
				TipoNave5 n = new TipoNave5();
				n.DefinirTipo(c);
			}
			
		}
		//Pre: cierto
		//Post: crea un tipo de nave de forma automatica y lo anade a la lista
		/**
		 * metodo que crea un tipod e nave de forma automatica
		 * @throws Exception
		 */
		public void CrearTipoNaveAuto() throws Exception{
			int t = TipoNoDefinido();
			if(t==-1){
				throw new Exception("Error: Ya se han definido 5 tipos\n");
			}
			int c = (int)Math.random()*Integer.MAX_VALUE+1;
			if(t==1){
				TipoNave1 n = new TipoNave1();
				n.DefinirTipo(c);
			}
			if(t==2){
				TipoNave2 n = new TipoNave2();
				n.DefinirTipo(c);
			}
			if(t==3){
				TipoNave3 n = new TipoNave3();
				n.DefinirTipo(c);
			}
			if(t==4){
				TipoNave4 n = new TipoNave4();
				n.DefinirTipo(c);
			}
			if(t==5){
				TipoNave5 n = new TipoNave5();
				n.DefinirTipo(c);
			}
			
		}
		
		//CONSULTORAS ATRIBUTOS NAVE
		//Pre: cierto
		//Post: retorna el identificador del planeta destino de la nave con identificador id
		/**
		 * metodo que consulta el planeta destino de una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public int ConsultarPlanetaDestino(int id)throws Exception{
			return BuscarNave(id).consultar_destino();
		}
		//Pre: cierto
		//Post: retorna el identificador del planeta origen de la nave con identificador id
		/**
		 * metodo que consulta el planeta origen de una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public int ConsultarPlanetaOrigen(int id) throws Exception{
			return BuscarNave(id).consultar_origen();
		}
		//Pre: cierto
		//Post: retorna el tipo de una nave
		/**
		 * metodo que consulta el tipo de una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public int ConsultarTipo(int id) throws Exception{
			Iterator<TipoNave1> it = listaNaves1.iterator();
			boolean found = false;
			while(it.hasNext() && !found){
				Nave aux = it.next();
				if(aux.consultar_id() == id){
					found = true;
					return 1;
					}
			}
			Iterator<TipoNave2> it2 = listaNaves2.iterator();
			while(it2.hasNext() && !found){
				Nave aux = it2.next();
				if(aux.consultar_id() == id){
					found = true;
					return 2;
				}
			}
			Iterator<TipoNave3> it3 = listaNaves3.iterator();
			while(it3.hasNext() && !found){
				Nave aux = it3.next();
				if(aux.consultar_id() == id){
					found = true;
					return 3;
				}
			}
			Iterator<TipoNave4> it4 = listaNaves4.iterator();
			while(it4.hasNext() && !found){
				Nave aux = it4.next();
				if(aux.consultar_id() == id){
					found = true;
					return 4;
				}
			}
			Iterator<TipoNave5> it5 = listaNaves5.iterator();
			while(it5.hasNext() && !found){
				Nave aux = it5.next();
				if(aux.consultar_id() == id){
					found = true;
					return 5;
				}
			}
			if(!found){
				throw new Exception("Error: No existe ninguna nave con el identificador introducido\n");
			}
			return 0;
		}
		//Pre: cierto
		//Post: retorna el consumo asociado a una nave
		/**
		 * metodo que consulta el consumo de una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public int ConsultarConsumo(int id) throws Exception{
			int t = ConsultarTipo(id);
			if(t==1){
				if(!TipoNave1.definido)throw new Exception("Error: El tipo de nave " +id+ "no esta definido\n");
				return TipoNave1.consumo;
			}
			if(t==2){
				if(!TipoNave2.definido)throw new Exception("Error: El tipo de nave " +id+ "no esta definido\n");
				return TipoNave2.consumo;
			}
			if(t==3){
				if(!TipoNave3.definido)throw new Exception("Error: El tipo de nave " +id+ "no esta definido\n");
				return TipoNave3.consumo;
			}
			if(t==4){
				if(!TipoNave4.definido)throw new Exception("Error: El tipo de nave " +id+ "no esta definido\n");
				return TipoNave4.consumo;
			}
			if(t==5){
				if(!TipoNave5.definido)throw new Exception("Error: El tipo de nave " +id+ "no esta definido\n");
				return TipoNave5.consumo;
			}
			return 0;	
		}
		//CONSULTORAS TIPO NAVE
		//Pre: cierto
		//Post: retorna el consumo asociado a un tipo de nave
		/**
		 * metodo que consulta el consumo asociado a un tipo de nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public int ConsultarConsumoTipo(int t) throws Exception{
			if(t<1 || t>5) throw new Exception("Error: El identificador del tipo debe estar entre 1 y 5\n");
			if(t==1){
				return TipoNave1.consumo;
			}
			if(t==2){
				return TipoNave2.consumo;
			}
			if(t==3){
				return TipoNave3.consumo;
			}
			if(t==4){
				return TipoNave4.consumo;
			}
			if(t==5){
				return TipoNave5.consumo;
			}
			return 0;
		}

		//MODIFICADORAS NAVE
		//Pre: cierto
		//Post: modifica el identificador de una nave "id" por "id2"
		/**
		 * metodo que modifica el identificador de una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public void ModificaID(int id, int id2) throws Exception{
			 BuscarNave(id).modificar_id(id2);
		}
		//Pre: cierto
		//Post: modifica el tipo de la nave con identificador "id" por "tn"
		/**
		 * metodo que modifica el tipo de una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public void ModificaTipo(int id, int idtipo) throws Exception{
			Nave aux = BuscarNave(id);
			EliminarNave(id);
			if(idtipo==1){
				TipoNave1 n = new TipoNave1(aux);
				listaNaves1.add(n);
			}
			if(idtipo==2){
				TipoNave2 n = new TipoNave2(aux);
				listaNaves2.add(n);
			}
			if(idtipo==3){
				TipoNave3 n = new TipoNave3(aux);
				listaNaves3.add(n);
			}
			if(idtipo==4){
				TipoNave4 n = new TipoNave4(aux);
				listaNaves4.add(n);
			}
			if(idtipo==5){
				TipoNave5 n = new TipoNave5(aux);
				listaNaves5.add(n);
			}
			
			
		}
		//Pre: el nuevo destino es un planeta existente
		//Post: modifica el destino de la nave con identificador "id" por "dn"
		/**
		 * metodo que modifica el destino de una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public void ModificaDestino(int id, int dn) throws Exception{
			BuscarNave(id).modificar_destino(dn);
		}
		//Pre: el nuevo destino es un planeta existente
				//Post: modifica el origen de la nave con identificador "id" por "dn"
		/**
		 * metodo que modifica el origen de una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
				public void ModificaOrigen(int id, int on) throws Exception{
					BuscarNave(id).modificar_destino(on);
				}

		//MODIFICADORAS TIPO NAVE
		
		//Pre: cierto
		//Post: modifica el consumo del tipo de nave con identificador "id" por "cn"
				/**
				 * metodo modifica que el consumo de un tipo de nave dado su identificador
				 * @param id
				 * @throws Exception
				 */
		public void ModificaConsumo(int id,int cn) throws Exception{
			if(id==1){
				TipoNave1.modificar_consumo(cn);
			}
			if(id==2){
				TipoNave2.modificar_consumo(cn);
			}
			if(id==3){
				TipoNave3.modificar_consumo(cn);
			}
			if(id==4){
				TipoNave4.modificar_consumo(cn);
			}
			if(id==5){
				TipoNave5.modificar_consumo(cn);
			}
		}
		//DESTRUCTORAS
		//Pre: cierto
		//Post: elimina la nave con identificador "id"
		/**
		 * metodo que elimina una nave dado su identificador
		 * @param id
		 * @throws Exception
		 */
		public void EliminarNave(int id) throws Exception{
			boolean found = false;
			Iterator<TipoNave1> it = listaNaves1.iterator();
			TipoNave1 aux = new TipoNave1();
			while(!found && it.hasNext()){
				aux = it.next();
				if(aux.consultar_id()==id){
					it.remove();
					found = true;
				}
			}
			Iterator<TipoNave2> it2 = listaNaves2.iterator();
			TipoNave2 aux2 = new TipoNave2();
			while(!found && it2.hasNext()){
				aux2 = it2.next();
				if(aux2.consultar_id()==id){
					it2.remove();
					found = true;
				}
			}
			Iterator<TipoNave3> it3 = listaNaves3.iterator();
			TipoNave3 aux3 = new TipoNave3();
			while(!found && it3.hasNext()){
				aux3 = it3.next();
				if(aux3.consultar_id()==id){
					it3.remove();
					found = true;
				}
			}
			Iterator<TipoNave4> it4 = listaNaves4.iterator();
			TipoNave4 aux4 = new TipoNave4();
			while(!found && it4.hasNext()){
				aux4 = it4.next();
				if(aux4.consultar_id()==id){
					it4.remove();
					found = true;
				}
			}
			Iterator<TipoNave5> it5 = listaNaves5.iterator();
			TipoNave5 aux5 = new TipoNave5();
			while(!found && it5.hasNext()){
				aux5 = it5.next();
				if(aux5.consultar_id()==id){
					it5.remove();
					found = true;
				}
			}
					if(!found){
					throw new Exception("Error: No existe ningun tipo de nave con el identificador introducido\n");
				}
				
			
			}
		//Pre:cierto
		//Post: elimina todas las naves
		/**
		 * metodo que elimina todas las naves del sistema
		 */
		public void EliminarNaves(){
			listaNaves1.clear();
			listaNaves2.clear();
			listaNaves3.clear();
			listaNaves4.clear();
			listaNaves5.clear();
		}
		//Pre:cierto
		//Post: devulve un string conteniendo los identificadores de los tipos de naves que han sido definidos
		/**
		 * metodo que retorna un string conteniendo todos los tipos de naves que han sido definidos
		 */
		public String ConsultarTipos(){
			String s = "";
			if(TipoNave1.definido) s+= "1,";
			if(TipoNave2.definido) s+= "2,";
			if(TipoNave3.definido) s+= "3,";
			if(TipoNave4.definido) s+= "4,";
			if(TipoNave5.definido) s+= "5";
			return s;
		}
		//Pre:cierto
		//Post: devuelve el numero de naves que existen en la galaxia
		/**
		 * metodo que retorna el numero de naves existentes en la galaxia
		 */
		public int size(){
			int s1 =listaNaves1.size();
			int s2 = listaNaves2.size();
			int s3 = listaNaves3.size();
			int s4 = listaNaves4.size();
			int s5 = listaNaves5.size();
			int s = s1+s2+s3+s4+s5;
			return s;
		}
		private void Inicializar(){

			itc1 = listaNaves1.iterator();
			itc2 = listaNaves2.iterator();
			itc3 = listaNaves3.iterator();
			itc4 = listaNaves4.iterator();
			itc5 = listaNaves5.iterator();
		}
		//Pre: cierto
		//Post: Devuelve parte de las naves que se encuentran en el sistema
		/**
		 * metodo que retorna un string conteniendo parte de las naves del sistema
		 * @param i
		 * @throws Exception
		 */
		public String ConsultarNaves(int i) throws Exception{
			if(i==0){
				Inicializar();
			}
			int j=0;
			String res="";
			if(i==0 && itc1.hasNext()){
				++i;
				res += "Naves tipo 1: \n";
			}
			while(itc1.hasNext() && j<100){
				res += itc1.next().consultar_id();
				++j;
				if(itc1.hasNext()) res += ",";
				if(!itc1.hasNext()){
					if(itc2.hasNext()) res += "\nNaves tipo 2: \n";
					else if(itc3.hasNext()) res += "\nNaves tipo 3: \n";
					else if(itc4.hasNext()) res += "\nNaves tipo 4: \n";
					else if(itc5.hasNext()) res += "\nNaves tipo 5: \n";
				}
			}
			if(i==0 && itc2.hasNext()){
				++i;
				res += "Naves tipo 2: \n";
			}
			while(itc2.hasNext() && j<100){
				res += itc2.next().consultar_id();
				++j;
				if(itc2.hasNext()) res += ",";
				if(!itc2.hasNext()){
					if(itc3.hasNext()) res += "\nNaves tipo 3: \n";
					else if(itc4.hasNext()) res += "\nNaves tipo 4: \n";
					else if(itc5.hasNext()) res += "\nNaves tipo 5: \n";
				}
			}
			if(i==0 && itc3.hasNext()){
				++i;
				res += "Naves tipo 3: \n";
			}
			while(itc3.hasNext() && j<100){
				res += itc3.next().consultar_id();
				++j;
				if(itc3.hasNext()) res += ",";
				if(!itc3.hasNext()){
					if(itc4.hasNext()) res += "\nNaves tipo 4: \n";
					else if(itc5.hasNext()) res += "\nNaves tipo 5: \n";
				}
			}
			if(i==0 && itc4.hasNext()){
				++i;
				res += "Naves tipo 4: \n";
			}
			while(itc4.hasNext() && j<100){
				res += itc4.next().consultar_id();
				++j;
				if(itc4.hasNext()) res += ",";
				if(!itc4.hasNext()){
					if(itc5.hasNext()) res += "\nNaves tipo 5: \n";
				}
			}
			if(i==0 && itc5.hasNext()){
				++i;
				res += "Naves tipo 5: \n";
			}
			while(itc5.hasNext() && j<100){
				res += itc5.next().consultar_id();
				++j;
				if(itc5.hasNext()) res += ",";
				if(!itc5.hasNext()) res += "\n";
			}
			return res; 
		}
		//Pre: cierto
		//Post: Carga al sistema todas aquellas naves que se encuentren en el archivo que indica path siempre que no exista ya en el sistema una nave con el mismo identificador
		/**
		 * metodo que carga todas las naves existenetes en el archivo indicado en "path" siemrpe que no exista en la galaxia, ya, una con el mismo identificador
		 * @param path
		 * @throws Exception
		 */
		public void CargarNaves(String path) throws Exception {
	        String res; 
	        Cdn.AbrirLectura(path);
	        	res = Cdn.cargar(path);
	            Scanner sc = new Scanner(res);
	            sc.useDelimiter("#|:");
	            String s="";
	            if(sc.hasNext()) s = sc.next();
	            while (sc.hasNext()) {
	                    int id = Integer.parseInt(s);
	                    s = sc.next();
	                    int origen = Integer.parseInt(s);
	                    s = sc.next();
	                    int destino = Integer.parseInt(s);
	                    s = sc.next();
	                    int tipo = Integer.parseInt(s);
	                    s = sc.next();
	                    int consumo = Integer.parseInt(s);
	                    if(ExisteNave(id)){
	                    	System.out.println("Ya existe una nave con identificador: "+id+". Esta, no se cargará");
	                    }
	                    else{
	                    if(tipo == 1){
	                    	if(!TipoNave1.definido){
	                    		TipoNave1.DefinirTipo(consumo);
	                    	}
	                    	TipoNave1 aux = new TipoNave1(id,destino,origen);
	                    	listaNaves1.add(aux);
	                    }
	                    
	                    if(tipo == 2){
	                    	if(!TipoNave2.definido){
	                    		TipoNave2.DefinirTipo(consumo);
	                    	}
	                    	TipoNave2 aux = new TipoNave2(id,destino,origen);
	                    	listaNaves2.add(aux);
	                    }
	                    if(tipo == 3){
	                    	if(!TipoNave3.definido){
	                    		TipoNave3.DefinirTipo(consumo);
	                    	}
	                    	TipoNave3 aux = new TipoNave3(id,destino,origen);
	                    	listaNaves3.add(aux);
	                    }
	                    if(tipo == 4){
	                    	if(!TipoNave4.definido){
	                    		TipoNave4.DefinirTipo(consumo);
	                    	}
	                    	TipoNave4 aux = new TipoNave4(id,destino,origen);
	                    	listaNaves4.add(aux);
	                    }
	                    if(tipo == 5){
	                    	if(!TipoNave5.definido){
	                    		TipoNave5.DefinirTipo(consumo);
	                    	}
	                    	TipoNave5 aux = new TipoNave5(id,destino,origen);
	                    	listaNaves5.add(aux);
	                    }
	                    }
	            s = sc.next();
	            }
	        Cdn.CerrarLectura();
	    }    
	     /**
	      * metodo que guarda todas las naves de la galaxia en el archivo indicado en "path"
	      * @param path
	      * @throws Exception
	      */
	    //Pre: Cierto
	    //Post: Guarda todas las naves existentes en el sistema en el fichero indicado en el path
	    public void GuardarNaves(String path) throws Exception {
	    	String res = "";
	        if(!listaNaves1.isEmpty()){
	            Cdn.AbrirEscritura(path);        
	            res = "";
	            int iteracions = 0;
	            for (TipoNave1 r : listaNaves1){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_origen() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    Cdn.guardar(path,res);
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        
	        if(!listaNaves2.isEmpty()){
	            int iteracions = 0;
	            for (TipoNave2 r : listaNaves2){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    Cdn.guardar(path,res);
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        if(!listaNaves3.isEmpty()){
	            int iteracions = 0;
	            for (TipoNave3 r : listaNaves3){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    Cdn.guardar(path,res);
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        if(!listaNaves4.isEmpty()){
	            int iteracions = 0;
	            for (TipoNave4 r : listaNaves4){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    Cdn.guardar(path,res);
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        if(!listaNaves5.isEmpty()){       
	            int iteracions = 0;
	            for (TipoNave5 r : listaNaves5){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    Cdn.guardar(path,res);
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        
	        if(res != ""){
	        	Cdn.guardar(path,res);
	        	Cdn.CerrarEscritura();
	        }
	    }
	    
	    public String consultarTODO() throws Exception {
	    	String res = "";
	        if(!listaNaves1.isEmpty()){    
	            res = "";
	            int iteracions = 0;
	            for (TipoNave1 r : listaNaves1){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_origen() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        
	        if(!listaNaves2.isEmpty()){
	            int iteracions = 0;
	            for (TipoNave2 r : listaNaves2){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        if(!listaNaves3.isEmpty()){
	            int iteracions = 0;
	            for (TipoNave3 r : listaNaves3){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        if(!listaNaves4.isEmpty()){
	            int iteracions = 0;
	            for (TipoNave4 r : listaNaves4){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        if(!listaNaves5.isEmpty()){       
	            int iteracions = 0;
	            for (TipoNave5 r : listaNaves5){  
	                res += r.consultar_id() + ":";
	                res += r.consultar_destino() + ":";
	                res += r.consultar_tipo() + ":";
	                res += r.consultar_consumo();
	                res += "#";
	                ++iteracions;
	                if(iteracions == 100){
	                    iteracions = 0;
	                    res = "";
	                }
	            }
	        }
	        return res;
	    }
	    
	    public void BorraNavesDestinoOrigen(int id) throws Exception{
	    	Iterator<TipoNave1> it = listaNaves1.iterator();
	    		while(it.hasNext()){
	    			TipoNave1 aux = it.next();
	    			if(aux.consultar_destino() == id || aux.consultar_origen() == id){
	    				it.remove();
	    			}
	    		}
	    		Iterator<TipoNave2> it2 = listaNaves2.iterator();
	    		while(it2.hasNext()){
	    			TipoNave2 aux = it2.next();
	    			if(aux.consultar_destino()==id || aux.consultar_origen() == id){
	    				it.remove();
	    			}
	    		}
	    		Iterator<TipoNave3> it3 = listaNaves3.iterator();
	    		while(it3.hasNext()){
	    			TipoNave3 aux = it3.next();
	    			if(aux.consultar_destino()==id || aux.consultar_origen() == id){
	    				it.remove();
	    			}
	    		}
	    		Iterator<TipoNave4> it4 = listaNaves4.iterator();
	    		while(it4.hasNext()){
	    			TipoNave4 aux = it4.next();
	    			if(aux.consultar_destino()==id || aux.consultar_origen() == id){
	    				it.remove();
	    			}
	    		}
	    		Iterator<TipoNave5> it5 = listaNaves5.iterator();
	    		while(it5.hasNext()){
	    			TipoNave5 aux = it5.next();
	    			if(aux.consultar_destino()==id || aux.consultar_origen() == id){
	    				it.remove();
	    			}
	    		}
	    	}
	    
}

import java.util.*;

public class ControladorNave{
	private TreeSet<TipoNave1> listaNaves1;
	private TreeSet<TipoNave2> listaNaves2;
	private TreeSet<TipoNave3> listaNaves3;
	private TreeSet<TipoNave4> listaNaves4;
	private TreeSet<TipoNave5> listaNaves5;
	private static int idn=0;
	
		//Pre: cierto
		//Post: Crea un ControladorNave
		public ControladorNave(){
			listaNaves1 = new TreeSet<TipoNave1>(new OrdenTipoNave1());
			listaNaves2 = new TreeSet<TipoNave2>(new OrdenTipoNave2());
			listaNaves3 = new TreeSet<TipoNave3>(new OrdenTipoNave3());
			listaNaves4 = new TreeSet<TipoNave4>(new OrdenTipoNave4());
			listaNaves5 = new TreeSet<TipoNave5>(new OrdenTipoNave5());
		}
		
		//Pre: cierto
				//Post: devuelve la nave con identificador "id"
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
						found = false;
						while(it2.hasNext() && !found){
							Nave aux = it2.next();
							if(aux.consultar_id() == id){
								found = true;
								return aux;
							}
						}
						Iterator<TipoNave3> it3 = listaNaves3.iterator();
						found = false;
						while(it3.hasNext() && !found){
							Nave aux = it3.next();
							if(aux.consultar_id() == id){
								found = true;
								return aux;
							}
						}
						Iterator<TipoNave4> it4 = listaNaves4.iterator();
						found = false;
						while(it4.hasNext() && !found){
							Nave aux = it4.next();
							if(aux.consultar_id() == id){
								found = true;
								return aux;
							}
						}
						Iterator<TipoNave5> it5 = listaNaves5.iterator();
						found = false;
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


		//Pre: cierto
		//Post: comprueva si existe el tipo de nave ocn identificador "id"
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
		public int TipoNoDefinido(){
					if(!TipoNave1.definido)return 1;
					if(!TipoNave2.definido)return 2;
					if(!TipoNave3.definido)return 3;
					if(!TipoNave4.definido)return 4;
					if(!TipoNave5.definido)return 5;
					return -1;
		}
		//Pre:cierto
		//Post: devuelve un boleean indicando si hay algún tipo definido
		public boolean NingunTipo(){
			if(TipoNave1.definido) return false;
			if(TipoNave2.definido) return false;
			if(TipoNave3.definido) return false;
			if(TipoNave4.definido) return false;
			if(TipoNave5.definido) return false;
			return true;
		}
		//Pre: existe algún tipo definido
		//Post: devuelve un tipo aleatorio que esté definido
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
		//Post: Crea una Nave manualmente y la añade a la lista
		public void CrearNave(int id, int t, int d /*ControladorGalaxia cg*/) throws Exception{
			if(ExisteNave(id)){
				throw new Exception("Error: Ya existe una nave con el mismo identificador\n");		
			}
			if(!ExisteTipo(t)){
				throw new Exception("Error: No existe ningún tipo de nave con el identificador introducido\n");
			}
				if(t<1 || t>5) throw new Exception("Error: El identificador del tipo debe estar entre 1 y 5\n");
				if(t==1){
					TipoNave1 n = new TipoNave1(id,d);
					listaNaves1.add(n);
					//cg.afegirNau(id);
				}
				if(t==2){
					TipoNave2 n = new TipoNave2(id,d);
					listaNaves2.add(n);
					//cg.afegirNau(id);
				}
				if(t==3){
					TipoNave3 n = new TipoNave3(id,d);
					listaNaves3.add(n);
					//cg.afegirNau(id);
				}
				if(t==4){
					TipoNave4 n = new TipoNave4(id,d);
					listaNaves4.add(n);
					//cg.afegirNau(id);
				}
				if(t==5){
					TipoNave5 n = new TipoNave5(id,d);
					listaNaves5.add(n);
					//cg.afegirNau(id);
				}
				
		}
		//Pre: cierto
		//Post: Crea una Nave de forma automatica
		public void CrearNaveAuto(int dest/*ArrayList<int> lp ControladorGalaxia cg*/) throws Exception{
			while(ExisteNave(idn)) ++idn;
			if(NingunTipo()){
				throw new Exception("Error: No existe ningún tipo de nave\n");
			}
			int t = TipoRandom();
			//int d = (int)(Math.random()*lp.size())+0;
			//int dest = lp.get(d)/*.Consultar_id()*/;
			if(t==1){
				TipoNave1 n = new TipoNave1(idn,dest);
				listaNaves1.add(n);	
				//cg.afegirNau(n);
			}
			if(t==2){
				TipoNave2 n = new TipoNave2(idn,dest);
				listaNaves2.add(n);	
				//cg.afegirNau(n);
			}
			if(t==3){
				TipoNave3 n = new TipoNave3(idn,dest);
				listaNaves3.add(n);	
				//cg.afegirNau(n);
			}
			if(t==4){
				TipoNave4 n = new TipoNave4(idn,dest);
				listaNaves4.add(n);	
				//cg.afegirNau(n);
			}
			if(t==5){
				TipoNave5 n = new TipoNave5(idn,dest);
				listaNaves5.add(n);	
				//cg.afegirNau(n);
			}
			
		}
		
		//CREADORAS TIPO DE NAVE

		//Pre: cierto
		//Post: Crea un tipo de nave y lo añade a la lista
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
		//Post: crea un tipo de nave de forma automatica y lo añade a la lista
		public void CrearTipoNaveAuto() throws Exception{
			int t = TipoNoDefinido();
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
		public int ConsultarPlanetaDestino(int id) throws Exception{
			return BuscarNave(id).consultar_destino();
		}
		//Pre: cierto
		//Post: retorna el tipo de una nave
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
			found = false;
			while(it2.hasNext() && !found){
				Nave aux = it2.next();
				if(aux.consultar_id() == id){
					found = true;
					return 2;
				}
			}
			Iterator<TipoNave3> it3 = listaNaves3.iterator();
			found = false;
			while(it3.hasNext() && !found){
				Nave aux = it3.next();
				if(aux.consultar_id() == id){
					found = true;
					return 3;
				}
			}
			Iterator<TipoNave4> it4 = listaNaves4.iterator();
			found = false;
			while(it4.hasNext() && !found){
				Nave aux = it4.next();
				if(aux.consultar_id() == id){
					found = true;
					return 4;
				}
			}
			Iterator<TipoNave5> it5 = listaNaves5.iterator();
			found = false;
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
		public void ModificaID(int id, int id2) throws Exception{
			 BuscarNave(id).modificar_id(id2);
		}
		//Pre: cierto
		//Post: modifica el tipo de la nave con identificador "id" por "tn"
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
		public void ModificaDestino(int id, int dn) throws Exception{
			BuscarNave(id).modificar_destino(dn);
		}

		//MODIFICADORAS TIPO NAVE
		
		//Pre: cierto
		//Post: modifica el consumo del tipo de nave con identificador "id" por "cn"
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
		public void EliminarNave(int id/*, ControladorGalaxia cg*/) throws Exception{
			boolean found = false;
			Iterator<TipoNave1> it = listaNaves1.iterator();
			TipoNave1 aux = new TipoNave1();
			while(!found && it.hasNext()){
				aux = it.next();
				if(aux.consultar_id()==id){
					listaNaves1.remove(aux);
					found = true;
					//cg.eliminarNau(aux);
				}
			}
			Iterator<TipoNave2> it2 = listaNaves2.iterator();
			TipoNave2 aux2 = new TipoNave2();
			while(!found && it2.hasNext()){
				aux2 = it2.next();
				if(aux2.consultar_id()==id){
					listaNaves2.remove(aux2);
					found = true;
					//cg.eliminarNau(aux);
				}
			}
			Iterator<TipoNave3> it3 = listaNaves3.iterator();
			TipoNave3 aux3 = new TipoNave3();
			while(!found && it3.hasNext()){
				aux3 = it3.next();
				if(aux3.consultar_id()==id){
					listaNaves3.remove(aux3);
					found = true;
					//cg.eliminarNau(aux);
				}
			}
			Iterator<TipoNave4> it4 = listaNaves4.iterator();
			TipoNave4 aux4 = new TipoNave4();
			while(!found && it4.hasNext()){
				aux4 = it4.next();
				if(aux4.consultar_id()==id){
					listaNaves4.remove(aux4);
					found = true;
					//cg.eliminarNau(aux);
				}
			}
			Iterator<TipoNave5> it5 = listaNaves5.iterator();
			TipoNave5 aux5 = new TipoNave5();
			while(!found && it5.hasNext()){
				aux5 = it5.next();
				if(aux5.consultar_id()==id){
					listaNaves5.remove(aux5);
					found = true;
					//cg.eliminarNau(aux);
				}
			}
				if(!found){
					throw new Exception("Error: No existe ningún tipo de nave con el identificador introducido\n");
				}
			}
		//Pre:cierto
		//Post: elimina todas las naves
		public void EliminarNaves(){
			listaNaves1.clear();
			listaNaves2.clear();
			listaNaves3.clear();
			listaNaves4.clear();
			listaNaves5.clear();
		}
}

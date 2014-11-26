import java.util.*;
import java.io.*;

public class ControladorNave{
	private TreeSet<Nave> listaNaves;
	private static int idn=0;
	private Iterator<Nave> itc;
	ControladorDadesNave Cdn;
	
	public ControladorNave(){
		listaNaves = new TreeSet<Nave>(new OrdenTipoNave());
		Cdn = new ControladorDadesNave();
	}
	public ArrayList<Nave> CNaves() throws Exception{
		ArrayList<Nave> res = new ArrayList<Nave>();
		Iterator<Nave> it = listaNaves.iterator();
		while(it.hasNext()){
				res.add(it.next());
			}
		return res;
	}
	public Nave BuscarNave(int id) throws Exception{
		Iterator<Nave> it = listaNaves.iterator();
		boolean found = false;
		while(it.hasNext() && !found){
			Nave aux = it.next();
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
	public ArrayList<String> PlanetasOrigen() throws Exception{
		ArrayList<String> planetas = new ArrayList<String>();
		Iterator<Nave> it = listaNaves.iterator();
		while(it.hasNext()){
				Nave aux = it.next();
				String p = aux.consultar_origen();
				if(!planetas.contains(p)) planetas.add(p);
			}
		return planetas;				
	}
	public ArrayList<String> PlanetasDestino() throws Exception{
		ArrayList<String> planetas = new ArrayList<String>();
		Iterator<Nave> it = listaNaves.iterator();
		while(it.hasNext()){
				Nave aux = it.next();
				String p = aux.consultar_destino();
				if(!planetas.contains(p)) planetas.add(p);
			}
		return planetas;				
	}
	public boolean ExisteTipo(int id) throws Exception{
		if (id==1){
			return TipoNave1.EstaDefinido();
		}
		else if (id==2){
			return TipoNave2.EstaDefinido();
		}
		else if (id==3){
			return TipoNave3.EstaDefinido();
		}
		else if (id==4){
			return TipoNave4.EstaDefinido();
		}
		else if (id==5){
			return TipoNave5.EstaDefinido();
		}
		else throw new Exception("Error; el identificador del tipo tiene que estar entre 1 y 5\n");
	} 
	public boolean ExisteNave(int id) throws Exception{
		Iterator<Nave> it = listaNaves.iterator();
		while(it.hasNext()){
			if(it.next().consultar_id() == id) return true;
		}
		return false;
	}
	private int TipoNoDefinido(){
		if(!TipoNave1.EstaDefinido())return 1;
		if(!TipoNave2.EstaDefinido())return 2;
		if(!TipoNave3.EstaDefinido())return 3;
		if(!TipoNave4.EstaDefinido())return 4;
		if(!TipoNave5.EstaDefinido())return 5;
		return -1;
	}
	public boolean NingunTipo(){
		if(TipoNave1.EstaDefinido()) return false;
		if(TipoNave2.EstaDefinido()) return false;
		if(TipoNave3.EstaDefinido()) return false;
		if(TipoNave4.EstaDefinido()) return false;
		if(TipoNave5.EstaDefinido()) return false;
		return true;
	}
	public int TipoRandom(){
		ArrayList<Integer> def = new ArrayList<Integer>();
		if(TipoNave1.EstaDefinido()) def.add(1);
		if(TipoNave2.EstaDefinido()) def.add(2);
		if(TipoNave3.EstaDefinido()) def.add(3);
		if(TipoNave4.EstaDefinido()) def.add(4);
		if(TipoNave5.EstaDefinido()) def.add(5);
		int s = def.size();
		int t = (int)(Math.random()*s)+0;

		return (int)def.get(t);
	}
	//CREADORAS NAVE
			
			//Pre: cierto
			//Post: Crea una Nave manualmente y la anade a la lista
			/**
			 * metodo que crea una nave de un tipo, con identificador, destino y origen
			 * @param id
			 * @param t
			 * @param d
			 * @param o
			 * @throws Exception
			 */
			public void CrearNave(int t, String d,String o) throws Exception{
				if(!ExisteTipo(t)){
					throw new Exception("Error: No existe ningun tipo de nave con el identificador introducido\n");
				}
					if(t<1 || t>5) throw new Exception("Error: El identificador del tipo debe estar entre 1 y 5\n");
					while(ExisteNave(idn)) ++idn;
					Nave n;
					if(t==1){
					 n = new TipoNave1(idn,d,o);
					 listaNaves.add(n);
					}
					else if(t==2){
						n = new TipoNave2(idn,d,o);
						listaNaves.add(n);
					}
					else if(t==3){
						n = new TipoNave3(idn,d,o);
						listaNaves.add(n);
					}
					else if(t==4){
						n = new TipoNave4(idn,d,o);
						listaNaves.add(n);
					}
					else if(t==5){
						n = new TipoNave5(idn,d,o);
						listaNaves.add(n);
					}
					
					
			}
			//Pre: cierto
			//Post: Crea una Nave de forma automatica
			/**
			 * metodo que crea i naves de forma automatica
			 * @param lp
			 * @throws Exception
			 */
			public void CrearNaveAuto(int i,ArrayList<String> lp) throws Exception{
				while(i>0){
					int t = TipoRandom();
					while(ExisteNave(idn)) ++idn;
					if(NingunTipo()){
						throw new Exception("Error: No existe ningun tipo de nave\n");
					}
					int d = (int)(Math.random()*lp.size())+0;
					String dest = lp.get(d);
					int or = (int)(Math.random()*lp.size())+0;
					String o = lp.get(or);
					Nave n;
					if(t==1){
					 n = new TipoNave1(idn,dest,o);
					 listaNaves.add(n);
					}
					else if(t==2){
						n = new TipoNave2(idn,dest,o);
						listaNaves.add(n);
					}
					else if(t==3){
						n = new TipoNave3(idn,dest,o);
						listaNaves.add(n);
					}
					else if(t==4){
						n = new TipoNave4(idn,dest,o);
						listaNaves.add(n);
					}
					else if(t==5){
						n = new TipoNave5(idn,dest,o);
						listaNaves.add(n);
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
					TipoNave1.DefinirTipo(c);
				}
				if(id==2){
					TipoNave2.DefinirTipo(c);
				}
				if(id==3){
					TipoNave3.DefinirTipo(c);
				}
				if(id==4){
					TipoNave4.DefinirTipo(c);
				}
				if(id==5){
					TipoNave5.DefinirTipo(c);
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
					TipoNave1.DefinirTipo(c);
				}
				if(t==2){
					TipoNave2.DefinirTipo(c);
				}
				if(t==3){
					TipoNave3.DefinirTipo(c);
				}
				if(t==4){
					TipoNave4.DefinirTipo(c);
				}
				if(t==5){
					TipoNave5.DefinirTipo(c);
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
			public String ConsultarPlanetaDestino(int id)throws Exception{
				return BuscarNave(id).consultar_destino();
			}
			//Pre: cierto
			//Post: retorna el identificador del planeta origen de la nave con identificador id
			/**
			 * metodo que consulta el planeta origen de una nave dado su identificador
			 * @param id
			 * @throws Exception
			 */
			public String ConsultarPlanetaOrigen(int id) throws Exception{
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
				Iterator<Nave> it = listaNaves.iterator();
				boolean found = false;
				while(it.hasNext() && !found){
					Nave aux = it.next();
					if(aux.consultar_id() == id){
						found = true;
						return aux.consultar_tipo();
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
					if(!TipoNave1.EstaDefinido())throw new Exception("Error: El tipo de nave de " +id+ "no esta definido\n");
					return TipoNave1.consultar_consumo();
				}
				if(t==2){
					if(!TipoNave2.EstaDefinido())throw new Exception("Error: El tipo de nave de " +id+ "no esta definido\n");
					return TipoNave2.consultar_consumo();
				}
				if(t==3){
					if(!TipoNave3.EstaDefinido())throw new Exception("Error: El tipo de nave de " +id+ "no esta definido\n");
					return TipoNave3.consultar_consumo();
				}
				if(t==4){
					if(!TipoNave4.EstaDefinido())throw new Exception("Error: El tipo de nave de " +id+ "no esta definido\n");
					return TipoNave4.consultar_consumo();
				}
				if(t==5){
					if(!TipoNave5.EstaDefinido())throw new Exception("Error: El tipo de nave de " +id+ "no esta definido\n");
					return TipoNave5.consultar_consumo();
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
						if(!TipoNave1.EstaDefinido())throw new Exception("Error: El tipo de nave " +t+ "no esta definido\n");
						return TipoNave1.consultar_consumo();
					}
					if(t==2){
						if(!TipoNave2.EstaDefinido())throw new Exception("Error: El tipo de nave " +t+ "no esta definido\n");
						return TipoNave2.consultar_consumo();
					}
					if(t==3){
						if(!TipoNave3.EstaDefinido())throw new Exception("Error: El tipo de nave " +t+ "no esta definido\n");
						return TipoNave3.consultar_consumo();
					}
					if(t==4){
						if(!TipoNave4.EstaDefinido())throw new Exception("Error: El tipo de nave " +t+ "no esta definido\n");
						return TipoNave4.consultar_consumo();
					}
					if(t==5){
						if(!TipoNave5.EstaDefinido())throw new Exception("Error: El tipo de nave " +t+ "no esta definido\n");
						return TipoNave5.consultar_consumo();
					}
					return 0;
				}
				
				//MODIFICADORAS NAVE

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
					Nave n;
					if(idtipo==1){
						n = new TipoNave1(id, aux.consultar_destino(), aux.consultar_origen());
						listaNaves.add(n);
					}
					if(idtipo==2){
						n = new TipoNave2(id, aux.consultar_destino(), aux.consultar_origen());
						listaNaves.add(n);
					}
					if(idtipo==3){
						n = new TipoNave3(id, aux.consultar_destino(), aux.consultar_origen());
						listaNaves.add(n);
					}
					if(idtipo==4){
						n = new TipoNave4(id, aux.consultar_destino(), aux.consultar_origen());
						listaNaves.add(n);
					}
					if(idtipo==5){
						n = new TipoNave5(id, aux.consultar_destino(), aux.consultar_origen());
						listaNaves.add(n);
					}
					
					
				}
				public void ModificaDestino(int id, String dn) throws Exception{
					BuscarNave(id).modificar_destino(dn);
				}
				//Pre: el nuevo destino es un planeta existente
						//Post: modifica el origen de la nave con identificador "id" por "dn"
				/**
				 * metodo que modifica el origen de una nave dado su identificador
				 * @param id
				 * @throws Exception
				 */
						public void ModificaOrigen(int id, String on) throws Exception{
							BuscarNave(id).modificar_origen(on);
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
					Iterator<Nave> it = listaNaves.iterator();
					Nave aux;
					while(!found && it.hasNext()){
						aux = it.next();
						if(aux.consultar_id()==id){
							it.remove();
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
					listaNaves.clear();
				}
				//Pre:cierto
				//Post: devulve un string conteniendo los identificadores de los tipos de naves que han sido definidos
				/**
				 * metodo que retorna un string conteniendo todos los tipos de naves que han sido definidos
				 */
				public String ConsultarTipos(){
					String s = "";
					if(TipoNave1.EstaDefinido()) s+= "1,";
					if(TipoNave2.EstaDefinido()) s+= "2,";
					if(TipoNave3.EstaDefinido()) s+= "3,";
					if(TipoNave4.EstaDefinido()) s+= "4,";
					if(TipoNave5.EstaDefinido()) s+= "5";
					return s;
				}
				//Pre:cierto
				//Post: devuelve el numero de naves que existen en la galaxia
				/**
				 * metodo que retorna el numero de naves existentes en la galaxia
				 */
				public int size(){
					return listaNaves.size();
				}
				private void Inicializar(){
					itc = listaNaves.iterator();
				}
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
					while(itc.hasNext() && j<100){
						Nave n = itc.next();
						int id = n.consultar_id();
						int t = ConsultarTipo(id);
						res += t+"."+id;
						++j;
						if(itc.hasNext()) res += " ";
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
				EliminarNaves();			        
				String res; 
			        Cdn.AbrirLectura(path);
					FileReader fr = new FileReader(path);
        				BufferedReader br = new BufferedReader(fr);
					while((res=Cdn.cargar(path,100,br))!=""){
			            Scanner sc = new Scanner(res);
			            sc.useDelimiter("#|:");
			            String s="";
				    if(sc.hasNext()) s = sc.next();
			            while (sc.hasNext()) {
			                    int id = Integer.parseInt(s);
			                    String origen = sc.next();
			                    String destino = sc.next();
			                    s = sc.next();
			                    int tipo = Integer.parseInt(s);
			                    s = sc.next();
			                    int consumo = Integer.parseInt(s);
			                    	Nave aux;
			                    if(tipo == 1){
			                    	if(!TipoNave1.EstaDefinido()){
			                    		TipoNave1.DefinirTipo(consumo);
			                    	}
			                    	aux = new TipoNave1(id,destino,origen);
			                    	listaNaves.add(aux);
			                    }
			                    
			                    else if(tipo == 2){
			                    	if(!TipoNave2.EstaDefinido()){
			                    		TipoNave2.DefinirTipo(consumo);
			                    	}
			                    	aux = new TipoNave2(id,destino,origen);
			                    	listaNaves.add(aux);
			                    }
			                    else if(tipo == 3){
			                    	if(!TipoNave3.EstaDefinido()){
			                    		TipoNave3.DefinirTipo(consumo);
			                    	}
			                    	aux = new TipoNave3(id,destino,origen);
			                    	listaNaves.add(aux);
			                    }
			                    else if(tipo == 4){
			                    	if(!TipoNave4.EstaDefinido()){
			                    		TipoNave4.DefinirTipo(consumo);
			                    	}
			                    	aux = new TipoNave4(id,destino,origen);
			                    	listaNaves.add(aux);
			                    }
			                    else if(tipo == 5){
			                    	if(!TipoNave5.EstaDefinido()){
			                    		TipoNave5.DefinirTipo(consumo);
			                    	}
			                    	aux = new TipoNave5(id,destino,origen);
			                    	listaNaves.add(aux);
			               		}
					 s = sc.next();
			            }
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
			        if(!listaNaves.isEmpty()){
			            Cdn.AbrirEscritura(path);        
			            res = "";
			            int iteracions = 0;
			            for (Nave r : listaNaves){  
			            	int id = r.consultar_id();
			                res +=  id + ":";
			                res += r.consultar_origen() + ":";
			                res += r.consultar_destino() + ":";
			                res += r.consultar_tipo() + ":";
			                res += ConsultarConsumo(id);
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
			        if(!listaNaves.isEmpty()){    
			            int iteracions = 0;
			            for (Nave r : listaNaves){
			            	int id = r.consultar_id();
			                res +=  id + ":";
			                res += r.consultar_origen() + ":";
			                res += r.consultar_destino() + ":";
			                res += r.consultar_tipo() + ":";
			                res += ConsultarConsumo(id);
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
			    public void BorraNavesDestinoOrigen(String id) throws Exception{
			    	Iterator<Nave> it = listaNaves.iterator();
			    		while(it.hasNext()){
			    			Nave aux = it.next();
			    			if(aux.consultar_destino().compareTo(id) == 0 || aux.consultar_origen().compareTo(id) == 0){
			    				it.remove();
			    			}
			    		}
			    	}
			    
}

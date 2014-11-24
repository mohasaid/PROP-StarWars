import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class ControladorGalaxia
{
    private Galaxia g;
    private ControladorDadesGalaxia cdg;
 
    //CONSTRUCTORAS
 
    /**
     * Metodo para crear el controlador de la galaxia, un controlador de datos y una galaxia con nombre y limite
     * @throws Exception 
     */
    public ControladorGalaxia(String nom,int n) throws Exception 
    {
    	cdg = new ControladorDadesGalaxia();
    	g = new Galaxia(nom,n); 
    }
    
    /**
     * Metodo para crear el controlador de la galaxia, un controlador de datos y una galaxia con nombre, limite y forma
     * @param nom
     * @param n
     * @param l
     * @throws Exception
     */
    public ControladorGalaxia(String nom, int n, List<Pair<Integer, Integer> > l) throws Exception
    {
    	cdg = new ControladorDadesGalaxia();
    	g = new Galaxia(nom,n,l);
    }
   
    //CONSULTORES
    
    /**
     * Metodo para consultar el nombre de la galaxia
     * @return El nombre de la galaxia
     */
    public String consultar_nom()
    {
    	return g.consultarNomGalaxia();
    }
    
    /**
     * Metodo para consultar los elementos de la galaxia
     * @return El nombre de la galaxia, el presupuesto, el limite maximo y el conjunto de coordenadas que dan forma a esta
     * @throws Exception
     */
    public String consultarElementsGalaxia() throws Exception
    {
    	String res = "";
    	res = g.consultarNomGalaxia() + ":" + g.consultarLimitGalaxia();
    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
    	if(lp.size() > 0) {
    		Iterator<Pair<Integer, Integer> > it = lp.iterator();
    		while(it.hasNext()) {
    			Pair<Integer, Integer> a = it.next();
    			res += ":" + a.consultarPrimero() + "," + a.consultarSegundo();
    		}
    	}
    	else res += ""; // anado null
    	
    	return res;
    }
    
    /**
     * Metodo para consultar las coordenadas que dan forma a la galaxia
     * @return
     * @throws Exception
     */
    public String consultarLimitsGalaxia() throws Exception
    {
    	String res = "";
    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
    	Iterator<Pair<Integer, Integer> > it = lp.iterator();
    	while(it.hasNext()) {
    		Pair<Integer, Integer> a = it.next();
    		res += ":" + a.consultarPrimero() + "," + a.consultarSegundo();
    	}
    	return res;
    }
    
    /**
     * Metodo para consultar el limite maximo de la galaxia
     * @return Limite maximo de la galaxia
     * @throws Exception
     */
    public int consultarLimit() throws Exception
    {
        return g.consultarLimitGalaxia();
    }
 
    /**
     * Metodo para consultar si la galaxia tiene algun planeta
     * @return Cierto si existe algun planeta en la galaxia, falso en caso contrario
     */
    public boolean algunPlaneta() 
    {
    	return g.algunPlaneta();
    }
    
    /**
     * Metodo para consultar si existe algun planeta en las coordenadas "x" y "y"
     * @param x
     * @param y
     * @return Cierto si existe algun planeta en las coordenadas "x" y "y", falso en caso contrario
     * @throws Exception
     */
    public boolean existeixPlanetaCoordenades(int x, int y) throws Exception
    {
    	return g.existeixPlanetaCoordenades(x, y);
    }
    
    /**
     * Metodo para consultar si las coordenadas estan dentro de la galaxia
     * @param x
     * @param y
     * @return Cierto si las coordenadas estan dentro de la galaxia, falso en caso contrario
     * @throws Exception
     */
    public boolean dintreLimitUsuari(int x, int y) throws Exception
    {
    	return g.dintreLimitUsuari(x, y);
    }
 
    // MODIFICADORES
    
    /**
     * Metodo para modificar el nombre de la galaxia
     * @param nomNou
     * @throws Exception 
     */
    public void modificarNom(String nomNou) throws Exception
    {
    	g.modificar_nomGalaxia(nomNou);
    }
    
    /**
     * Metodo para modificar el limite maximo de la galaxia
     * @param limitNou
     * @throws Exception 
     */
    public void modificarLimit(int limitNou) throws Exception
    {
    	g.modificarN(limitNou);
    }
    
    /**
     * Metodo para modificar la forma de la galaxia
     * @param lp
     * @throws Exception 
     */
    public void modificarLimits(List<Pair<Integer, Integer> > lp) throws Exception
    {
    	g.modificarLimitsUsuari(lp);
    }

    /**
     * Metodo para modificar las coordenadas de un planeta
     * @param cp
     * @param idPlaneta
     * @param x
     * @param y
     * @throws Exception
     */
    // ya no esta, comprobar en controlador
    public void modificarCoordenadas(ControladorPlaneta cp, String idPlaneta, int x, int y) throws Exception
    {
    	if(!cp.ExistePlaneta(idPlaneta)) throw new Exception("No existe ningun planeta con este identificador");
    	Planeta a = cp.BuscarPlaneta(idPlaneta);
    	//if(!g.dintreLimitUsuari(x, y)) throw new Exception("Las coordenadas no estan dentro del limite que da forma a la galaxia");
    	//if(g.existeixPlanetaCoordenades(x, y)) throw new Exception("Ya existe un planeta en estas coordenadas");
    	afegirPlaneta(x, y); // comprueba lo de arriba
    	eliminarPlaneta(x, y);
    	a.modificarCoordenades(x, y);
    	cp.BorraPla(idPlaneta);
    	cp.anadirPlaneta(a);
    }
    
    /**
     * Metodo para añadir un planeta en la galaxia en las coordenadas "x" y "y"
     * @param cp
     * @param idPlaneta
     * @param x
     * @param y
     * @throws Exception
     */
    // meter en controlador del planeta
    public void afegirPlaneta(int x, int y) throws Exception
    {
    	g.afegirPlaneta(x,y);
    }
    
    /**
     * Metodo para añadir un planeta creado automaticamente
     * @param cp
     * @param idPlaneta
     * @returnDevuelve las coordenadas con las que se ha introducido en la galaxia
     * @throws Exception
     */
    // meter en controlador del planeta
    public String afegirPlanetaAutomatic() throws Exception
    {
    	String res = "";
    	Pair<Integer, Integer> p = g.afegirPlanetaAutomatic();
    	res = p.consultarPrimero() + "," + p.consultarSegundo();
    	return res;
    }
    
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param idPlaneta
     * @param cp
     * @throws Exception
     */
    public void eliminarPlaneta(int x, int y) throws Exception
    {
	    g.eliminarPlaneta(x,y);
    }
    
    /**
     * Metodo para eliminar todos los plaentas de una galaxia
     * @throws Exception
     */
    public void eliminarPlanetes() throws Exception 
    {
    	g.eliminarTotsPlanetes();
    }
    
    /**
     * Metodo para transformar los elementos de la galaxia en un grafo
     * @throws Exception
     */
    // CAMBIAR A ENTRADA - Y STRING DE PLANETA
    /*public Entrada convierteRutasYPlanetas(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) throws Exception 
    {
    	ArrayList<ArrayList<Pair<Arco,Integer> > > resultado = new ArrayList<ArrayList<Pair<Arco,Integer> > >();
    	
    	ArrayList<Pair<Arco, Integer> > ap = new ArrayList<Pair<Arco, Integer> >();
    	
    	ArrayList<String> pl = cp.consultarPlanetas();
    	ArrayList<Conexion> ac = cr.Consultar_Conexiones();
    	
    	for(int i = 0; i < ac.size(); ++i) { // anado las conexiones bidireccionales
    		if(ac.get(i).consultar_id()) {
    			int idRuta = ac.get(i).consultar_id();
    			int Pa = ac.get(i).consultar_planetaA();
    			int Pb = ac.get(i).consultar_planetaB();
    			Conexion c = new Conexion(idRuta,Pb,Pa,true);
    			ac.add(c);
    		}
    	}
    	
    	for(int i = 0; i < pl.size(); ++i) { // planetas
    		String id = pl.get(i);
    		for(int j = 0; j < ac.size(); ++j) {
    			if(ac.get(j).consultar_planetaA() == id) {
    				int ru = ac.get(j).consultar_id();
    				Ruta r = cr.BuscarRuta(ru);
    				int idRuta = r.consultar_id();
    				int cap = r.consultar_capacidad();
    				Arco arc = new Arco(cap,idRuta);
    				ap.get(i).ponPrimero(arc);
    				ap.get(i).ponSegundo(ac.get(j).consultar_planetaB());
    			}
    		}
    		resultado.add(ap);
    	}
    	
    	ArrayList<Integer> destinos = cn.PlanetasDestino(); // PENULTIMO NODO - ORIGEN GENERAL
		ArrayList<Pair<Arco, Integer> > tmp = new ArrayList<Pair<Arco, Integer> >();
    	for(int i = 0; i < destinos.size(); ++i) {
    		Arco c = new Arco(Integer.MAX_VALUE,-1);
    		int t = destinos.get(i);
    		Pair<Arco, Integer> pac = new Pair<Arco,Integer>(c,t);
    		tmp.add(pac);
    	}
    	
    	resultado.add(tmp); // ULTIMO NODO VIRTUAL - DESTINO GENERAL
    	ArrayList<Pair<Arco, Integer> > tmp1 = new ArrayList<Pair<Arco, Integer> >();
    	ArrayList<Integer> origenes = cn.PlanetasOrigen();
    	for(int i = 0; i < origenes.size(); ++i) {
    		Arco c = new Arco(Integer.MAX_VALUE,-2);
    		int t = origenes.get(i);
    		Pair<Arco, Integer> pac = new Pair<Arco,Integer>(c,t);
    		tmp.add(pac);
    	}
    	
    	resultado.add(tmp1); // ULTIMO NODO VIRTUAL - ORIGEN
    	Entrada ent = new Entrada(resultado);
    	// return new Entrada(resultado); 
    	return ent;
    }*/
    	
    
    /**
     * Metodo para cargar los elementos que forman la galaxia
     * @param directori
     * @param cp
     * @param cn
     * @param cr
     * @throws Exception
     */
    /*public void carregarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorNave cn, ControladorRuta cr) throws Exception
    {
		g.eliminarContingutGalaxia(); // Empiezo borrando el contenido de la galaxia
		
		String result = "";
		cdg.AbrirLectura(directori);
		
		while(!(result = cdg.carregar(directori)).isEmpty()) {
			
			Scanner cin = new Scanner(result);
			cin.useDelimiter(":|,");
			String info;
			while(cin.hasNext()) {
				info = cin.next();
					String nomG = info; // nombre
					info = cin.next(); // limite siempre tendra
					Integer N = Integer.parseInt(info);
					info = cin.next();
					if(info.contentEquals("null")) {
						g = new Galaxia(nomG,N);
						break; // no tiene limites
					}
					else {
						List<Pair<Integer, Integer> > lpa = new ArrayList<Pair<Integer,Integer> >();
						while(cin.hasNext()) {
							String a1 = cin.next();
							if(a1.contentEquals("@#")) break; // ya hemos leido todos los pairs
							Integer a = Integer.parseInt(info);
							info = cin.next();
							Integer b = Integer.parseInt(info);
							Pair<Integer,Integer> paird = new Pair<Integer,Integer>(a,b);
							lpa.add(paird);
						}
						g = new Galaxia(nomG,N,lpa);
					}
				info = cin.next();
				while(!(info.contentEquals("#@"))) {
					Integer id = Integer.parseInt(info);
					info = cin.next();
					Integer coste = Integer.parseInt(info);
					info = cin.next();
					Integer c1 = Integer.parseInt(info);
					info = cin.next();
					Integer c2 = Integer.parseInt(info);
					Pair<Integer, Integer> co = new Pair<Integer, Integer>(c1,c2);
					Planeta a = new Planeta(id,coste,co);
					cp.anadirPlaneta(a);
					g.afegirPlaneta(id, c1, c2);
					info = cin.next();
				}
				info = cin.next();
				while(!(info.contentEquals("#@"))) {
					if (Integer.parseInt(info) == 0) { //anadimos ruta
			    	      info = cin.next();
			    	      int id = Integer.parseInt(info);
			    	      info = cin.next();
			    	      int capacidad = Integer.parseInt(info);
			    	      info = cin.next();
			    	      int distancia = Integer.parseInt(info);
			    	      Ruta r = new Ruta(id,capacidad,distancia);
			    	      
				    } 
					else { //anadimos conexion
						  info  = cin.next();
				    	  int id = Integer.parseInt(info);
				    	  info = cin.next();
			    	      int ida = Integer.parseInt(info);
			    	      info = cin.next();
			    	      int idb = Integer.parseInt(info);
			    	      info = cin.next();
			    	      Boolean b = Boolean.parseBoolean(s);
			    	      System.out.print("ida = " + ida + "idb = " + idb + "\n");
			    	      Conexion c = new Conexion(id,ida,idb,b);
			    	      cn.
			    	      Conexiones.add(c);
				     }
				      s = sc.next();
				}
				// EN DRIVER, CARGO GALAXIA, Y LUEGO CADA CONTROLADOR CARGA LO SUYO
					
			}
			while(cin.hasNext()) {
				info = cin.next();
				if(info.contentEquals("#@")) break;
				cr.CargarRutas(directori);
			}
				
				//cp.CargarPlanetas(path);
				cr.CargarRutas(directori);
				cn.CargarNaves(directori);
				cin.close();
			}
			cdg.CerrarEscritura();
    }*/
    
    /**
     * Metodo para guardar los elementos que forman la galaxia
     * @param directori
     * @param cp
     * @param cr
     * @param cn
     * @throws Exception
     */
    public void guardarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn) throws Exception
    {
    	cdg.AbrirEscritura(directori);

    	String result = "";
    	result += g.consultarNomGalaxia() + ":" + g.consultarLimitGalaxia() + ":" + consultarLimitsGalaxia();
    	cdg.guardar(directori,result);
    	
    	System.out.println(result);
    	
    	result = "#@";
    	if(cp.Consultar_Size() > 0) {
    		String GP = cp.consultarTODO();
    		result += GP;
    		cdg.guardar(directori,result);
    		System.out.println(result);
    	}
    	
    	result = "#@";
    	if(cr.Consultar_numero_rutes() > 0) {
    		String GP1 = cr.consultarTODO();
    		result += GP1;
    		cdg.guardar(directori,result);
    		System.out.println(result);
    	}
    	
    	result = "#@";
    	if(cn.size() > 0) {
    		String GP2 = cn.consultarTODO();
    		result += GP2;
    		cdg.guardar(directori,result);
    		System.out.println(result);
    	}
    	cdg.CerrarEscritura();
   	}
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
 
public class ControladorGalaxia
{
    private Galaxia g;
    private ControladorDadesGalaxia cdg;
 
    //CONSTRUCTORAS
 
    /**
     * Metodo para crear el controlador de la galaxia
     */
    public ControladorGalaxia() {
    	cdg = new ControladorDadesGalaxia();
    }
 
    /**
     * Metodo para crear una galaxia con nombre y limite maximo
     * @param nom
     * @param n
     * @throws Exception
     */
    public void creaGalaxia(String nom,int n) throws Exception
    {
        g = new Galaxia(nom,n); 
    }
    
    /**
     * Metodo para crear una galaxia con nombre, limite maximo, y una forma determinada
     * @param nom
     * @param n
     * @param l
     * @throws Exception
     */
    public void creaGalaxia2(String nom, int n, List<Pair<Integer, Integer> > l) throws Exception
    {
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
    	res = g.consultarNomGalaxia() + ":" + g.consultarPresupost() + ":" + g.consultarLimitGalaxia();
    	if(g.consulta_nombreLimits() > 0) {
	    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
	    	Iterator<Pair<Integer, Integer> > it = lp.iterator();
	    	res = res + ":(";
	    	while(it.hasNext()) {
	    		res += it.next().consultarPrimero() + "," + it.next().consultarSegundo();
	    	}
	    	res = res + ")";
    	}
    	return res;
    }
    
    /**
     * Metodo para consultar las coordenadas que dan forma a la galaxia
     * @return
     * @throws Exception
     */
    public String consultarLimitsGalaxia() throws Exception
    {
    	if(g.consulta_nombreLimits() > 0) {
	    	String res = "";
	    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
	    	Iterator<Pair<Integer, Integer> > it = lp.iterator();
	    	while(it.hasNext()) {
	    		res += ":(" + it.next().consultarPrimero() + "," + it.next().consultarSegundo() + ")";
	    	}
	    	return res;
    	}
    	else throw new Exception("La galaxia no tiene forma");
    }
    
    public Integer consultarPresupost() throws Exception
    {
    	return g.consultarPresupost();
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
     * Metodo para consultar si existe un planeta con un identificador determinado en la galaxia
     * @param idplaneta
     * @return Cierto si existe un planeta en la galaxia con identificador "idplaneta", falso en caso contrario
     * @throws Exception
     */
    public boolean existeixPlaneta(int idplaneta) throws Exception
    {
        return g.existeixPlaneta(idplaneta);
    }
    
    /**
     * Metodo para consultar si la galaxia tiene algun planeta
     * @return Cierto si existe algun planeta en la galaxia, falso en caso contrario
     */
    public boolean algunPlaneta() 
    {
    	return g.algunPlaneta();
    }
    
    
    public int consultaIdplaneta(int x, int y) throws Exception
    {
    	return g.consultarIDplaneta(x, y);
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
    
    public void modificarLimits(List<Pair<Integer, Integer> > lp) throws Exception
    {
    	g.modificarLimitsUsuari(lp);
    }
   /**
    * Metodo para modificar el el identificador del planeta con las coordenadas "x" y "y"
    * @param x
    * @param y
    * @param idPlaneta
 * @throws Exception 
    */
   public void modificarIDPlaneta(int x, int y, int idPlaneta) throws Exception 
   {
		  g.modificarIDplaneta(x, y, idPlaneta);
   }
   
   public void modificarPresupost(int p) throws Exception
   {
	   g.modificarPresupost(p);
   }
   
    /**
     * Metodo para añadir un planeta en la galaxia en las coordenadas "x" y "y"
     * @param cp
     * @param idPlaneta
     * @param x
     * @param y
     * @throws Exception
     */
    public void afegirPlaneta(int idPlaneta, int x, int y) throws Exception
    {
    	g.afegirPlaneta(idPlaneta,x,y);
    }
    
    /**
     * Metodo para añadir un planeta creado automaticamente
     * @param cp
     * @param idPlaneta
     * @returnDevuelve las coordenadas con las que se ha introducido en la galaxia
     * @throws Exception
     */
    public /*String*/ Pair<Integer, Integer> afegirPlanetaAutomatic(int idPlaneta) throws Exception
    {
    	/*String res = "";
    	Pair<Integer, Integer> p = g.afegirPlanetaAutomatic(idPlaneta);
    	res = "(" + p.consultarPrimero() + "," + p.consultarSegundo() + ")";
    	return res;*/
    	return g.afegirPlanetaAutomatic(idPlaneta);
    }
    
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param idPlaneta
     * @param cp
     * @throws Exception
     */
    public void eliminarPlaneta(int idPlaneta) throws Exception
    {
	    g.eliminarPlaneta(idPlaneta);
    }
    
    public void eliminarPlanetes() throws Exception 
    {
    	g.eliminarTotsPlanetes();
    }

    /**
     * Metodo para eliminar el contenido de la galaxia
     * @throws Exception
     */
    public void eliminarContingutGalaxia() throws Exception
    {
    	g.eliminarContingutGalaxia();
    }
    
    /**
     * Metodo para transformar los elementos de la galaxia en un grafo
     * @throws Exception
     */
    public ArrayList<ArrayList<Pair<Arco,Integer> > > convierteRutasYPlanetas(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) throws Exception 
    {
    	ArrayList<ArrayList<Pair<Arco,Integer> > > resultado = new ArrayList<ArrayList<Pair<Arco,Integer> > >();
    	ArrayList<Pair<Arco, Integer> > ap = new ArrayList<Pair<Arco, Integer> >();
    	ArrayList<Integer> pl = cp.consultarPlanetas();
    	ArrayList<Conexion> ac = cr.consultar_Conexiones();
    	for(int i = 0; i < ac.size(); ++i) { // anado las conexiones bidireccionales
    		if(ac.get(i).consultar_bidireccional()) {
    			int idRuta = ac.get(i).consultar_id();
    			int Pa = ac.get(i).consultar_planetaA();
    			int Pb = ac.get(i).consultar_planetaB();
    			Conexion c = new Conexion(idRuta,Pb,Pa,false);
    			ac.add(c);
    		}
    	}
    	for(int i = 0; i < pl.size(); ++i) { // planetas
    		int id = pl.get(i);
    		for(int j = 0; j < ac.size(); ++j) {
    			if(ac.get(j).consultar_planetaA() == id) {
    				int ru = ac.get(j).consultar_id();
    				Ruta r = cr.BuscarRuta(ru);
    				// int idRuta = r.consultar_id()
    				int cap = r.consultar_capacidad();
    				int cost = r.consultar_distancia();
    				Arco arc = new Arco(cap,cost);
    				ap.get(i).ponPrimero(arc);
    				ap.get(i).ponSegundo(ac.get(j).consultar_planetaB());
    			}
    		}
    		resultado.add(ap);
    	}
    	ArrayList<Integer> destinos = cn.PlanetasDestino();
		ArrayList<Pair<Arco, Integer> > tmp = new ArrayList<Pair<Arco, Integer> >();
    	for(int i = 0; i < destinos.size(); ++i) {
    		Arco c = new Arco(Integer.MAX_VALUE,0);
    		int t = destinos.get(i);
    		Pair<Arco, Integer> pac = new Pair<Arco,Integer>(c,t);
    		tmp.add(pac);
    	}
    	resultado.add(tmp); // ULTIMO NODO VIRTUAL
    	return resultado;
    }
    	
    
    /**
     * Metodo para cargar los elementos que forman la galaxia
     * @param directori
     * @param cp
     * @param cn
     * @param cr
     * @throws Exception
     */
    public void carregarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorNave cn, ControladorRuta cr) throws Exception
    {
		g.eliminarContingutGalaxia(); // Empiezo borrando el contenido de la galaxia
		
		String result = "";
		cdg.AbrirLectura(directori);
		
		while(!(result = cdg.cargar()).isEmpty()) {
			
			Scanner cin = new Scanner(result);
			cin.useDelimiter(":|,");
			String info;
			while(cin.hasNext()) {
				info = cin.next();
					String nomG = info; // nombre
					info = cin.next(); // limite siempre tendra
					Integer N = Integer.parseInt(info);
					info = cin.next();
					Integer presu = Integer.parseInt(info);
					info = cin.next();
					if(info.contentEquals("null")) {
						g = new Galaxia(nomG,N);
						g.modificarPresupost(presu);
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
						g.modificarPresupost(presu);
					}
				}
				//cp.CargarPlanetas(path);
				cr.CargarRutas(directori);
				cn.CargarNaves(directori);
				cin.close();
			}
			cdg.CerrarEscritura();
    }
    
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
    	// int iteracions = 0;
    	String result = "";
    	result += g.consultarNomGalaxia() + ":" + g.consultarLimitGalaxia() + ":" + g.consultarPresupost();
    	if(g.consulta_nombreLimits() > 0 ) result += ":" + g.consultarValorLimits();
    	cdg.guardar(result);
    	
    	result = "#@";
    	if(cp.Consultar_Size() > 0) { // PLANETAS
    		cp.GuardarPlanetas(directori);
    		cdg.guardar(result);
    	}
    	result = "#@";
    	if(cr.Consultar_numero_rutes() > 0) { // RUTAS
    		cr.GuardarRutas(directori);
    		cdg.guardar(result);
    	}
    	result = "#@";
    	if(cn.size() > 0) { // NAVES -> ARREGLAR ESTO
    		cn.GuardarNaves(directori);
    		cdg.guardar(result);
    	}
    	cdg.CerrarEscritura();
   	}
}

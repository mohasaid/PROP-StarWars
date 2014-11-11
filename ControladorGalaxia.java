import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
 
public class ControladorGalaxia
{
    private Galaxia g;
    private ControladorDades CDades;
 
    //CONSTRUCTORAS
 
    // Pre: Cierto
    // Post: Se crea un nuevo controlador de galaxia
    /**
     * Metodo para crear el controlador de la galaxia
     */
    public ControladorGalaxia() {
    	CDades = new ControladorDades();
    }
 
    // Pre: Cierto
    // Post: Es crea una galaxia amb nom "nom" i amb N "n"
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
    
    // nombre, presupuesto, limite, (limites impuestos por el usuario)
    /**
     * Metodo para consultar los elementos de la galaxia
     * @return El nombre de la galaxia, el presupuesto, el limite maximo y el conjunto de coordenadas que dan forma a esta
     * @throws Exception
     */
    public String consultarElementsGalaxia() throws Exception
    {
    	String res = "";
    	res = g.consultarNomGalaxia() + ":" + g.consultarPresupost() + ":" + g.consultarLimitGalaxia();
    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
    	Iterator<Pair<Integer, Integer> > it = lp.iterator();
    	res = res + "@"; // para separar lo de arriba de los limites
    	while(it.hasNext()) {
    		res += it.next().consultarPrimero() + "," + it.next().consultarSegundo();
    	}
    	return res;
    }
    // Pre: Cierto
    // Post: Lista el contenido de la galaxia: los planetas, las rutas y las naves, en caso de que existan
    /**
     * Metodo para consultar la lista de planetas, rutas y naves de la galaxia
     * @return Los planetas, las rutas y las naves de la galaxia
     * @throws Exception
     */
    public String llista_galaxia() throws Exception
    {
    	String res = "";
    	if(g.consulta_nombrePlanetes() > 0) { // listar planetas
    		ArrayList<Integer> np = g.consultarPlanetes();
    		for(Integer a : np) {
    			res += a + ",";
    		}
    	}
    	res += "@";
    	if(g.consulta_nombreRutes() > 0) { // listar rutas
    		ArrayList<Integer> nr = g.consultarRutes();
    		for(Integer b : nr) {
    			res += b + ",";
    		}
    	}
    	res += "@";
    	if(g.consulta_nombreNaus() > 0 ) { // listar naves
    		ArrayList<Integer> nn = g.consultarNaus();
    		for(Integer c : nn) {
    			res += c + ",";
    		}
    	}
    	return res;
    }
    
    // Pre: Cierto
    // Post: Lista los planetas de la galaxia junto con sus coordenadas
    /**
     * Metodo para consultar el listado de planetas de la galaxia
     * @return Los identificadores de los planetas
     * @throws Exception
     */
    public String llista_planetes() throws Exception
    {
    	String res = null;
    	if(g.consulta_nombrePlanetes() > 0) { // listar planetas
    		ArrayList<Integer> np = g.consultarPlanetes();
    		for(Integer a : np) {
    			res += a;
    			/*p = g.consultarPlaneta(a);
    			res += p.Consultar_id() + "(" + p.consultar_X() + "," + p.consultar_Y() + ")";*/
    		}
    	}
    	return res;
    }
    
    // Pre: Cierto
    // Post: Devuelve el numero de planetas que hay en la galaxia
    /**
     * Metodo para consultar el numero de planetas en la galaxia
     * @return Numero de planetas en la galaxia
     * @throws Exception
     */
    public int consultarNumPlanetes() throws Exception
    {
        return g.consulta_nombrePlanetes();
    }
    
    // Pre: Cierto
    // Post: Devuelve el valor limite de la galaxia
    /**
     * Metodo para consultar el limite maximo de la galaxia
     * @return Limite maximo de la galaxia
     * @throws Exception
     */
    public Integer consultarLimit() throws Exception
    {
        return g.consultarLimitGalaxia();
    }
 
    // Pre: Cierto
    // Post: Devuelve cierto si el planeta con id "idplaneta" existe en la galaxia, falso en caso contrario
    /**
     * Metodo para consultar si existe un planeta determinado en la galaxia
     * @param idplaneta
     * @return Cierto si existe un planeta en la galaxia con identificador "idplaneta", falso en caso contrario
     * @throws Exception
     */
    public boolean existeixPlaneta(int idplaneta) throws Exception
    {
        return g.existeixPlaneta(idplaneta);
    }
 
    // MODIFICADORES
    
    // Pre: Cierto
    // Post: Devuelve la galaxia con nuevo nombre "nomNou"
    /**
     * Metodo para modificar el nombre de la galaxia
     * @param nomNou
     */
    public void modificarNom(String nomNou)
    {
    	try{
    		g.modificar_nomGalaxia(nomNou);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    // Pre: Cierto
    // Post: Devuelve el nuevo valor del limite de galaxia
    /**
     * Metodo para modificar el limite maximo de la galaxia
     * @param limitNou
     */
    public void modificarLimit(int limitNou)
    {
    	try{
    		g.modificarN(limitNou);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    // Pre: Cierto
    // Post: 
   /*public void modificarCoordenadesPlaneta(int x, int y, Planeta p)
    {
    	try{
	    	if(g.existeixPlaneta(idPlaneta)) {
	    		Planeta p = g.consultarPlaneta(idPlaneta);
	    		g.existeixPlanetaCoordenades(x, y);
	    		p.modificarCoordenades(x, y);
	    		g.eliminarPLaneta(idPlaneta);
	    		g.afegirPlaneta(p);
	    	}
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }*/
    
    // Pre: Cierto
    // Post: 
    /**
     * Metodo para añadir un planeta en la galaxia
     * @param p
     * @throws Exception
     */
    public void afegirPlaneta(ControladorPlaneta cp, int idPlaneta, int x, int y) throws Exception
    {
    	// AÑADIR LO DE ABAJO SI SE CREA UNA CONSTRUCTORA VACIA CON LIMITE 0
    	//if(g.consultarLimitGalaxia() < 1) throw new Exception("Error: no es pot afegir un planeta a una galaxia sense limit");
    	Planeta p = cp.BuscarPlaneta(idPlaneta);
    	g.afegirPlaneta(p,x,y);
    }
    
    // Pre: Cierto
    // Post: // COORDENADAS ALEATORIAS
    /**
     * Metodo para añadir un planeta creado automaticamente
     * @param p
     * @return Devuelve las coordenadas con las que se ha introducido en la galaxia
     * @throws Exception 
     */
    public Pair<Integer, Integer> afegirPlanetaAutomatic(ControladorPlaneta cp, int idPlaneta) throws Exception
    {
    	// AÑADIR LO DE ABAJO SI SE CREA UNA CONSTRUCTORA VACIA CON LIMITE 0
    	//if(g.consultarLimitGalaxia() < 1) throw new Exception("Error: no es pot afegir un planeta a una galaxia sense limit");
    	Planeta p = cp.BuscarPlaneta(idPlaneta);
    	return g.afegirPlanetaAutomatic(p);
    }
    
    // Pre: Cierto
    // Post:
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param p
     * @throws Exception
     */
    public void eliminarPlaneta(int idPlaneta, ControladorPlaneta cp) throws Exception
    {
    	if(g.consulta_nombrePlanetes() > 0) {
    		Planeta p = cp.BuscarPlaneta(idPlaneta);
    		g.eliminarPLaneta(p);
    	}
    }

    // Pre: Cierto
    // Post:
    /**
     * Metodo para añadir una ruta en la galaxia
     * @param r
     * @throws Exception
     */
    public void afegirRuta(int idRuta) throws Exception
    {
    	g.afegirRuta(idRuta);
    }
    
    // Pre: Cierto
    // Post:
    /**
     * Metodo para eliminar una ruta de la galaxia
     * @param idRuta
     * @throws Exception
     */
    public void eliminarRuta(int idRuta) throws Exception
    {
    	g.eliminarRuta(idRuta);
    }
    
    // Pre: Cierto
    // Post:
    /**
     * Metodo para añadir una nave en la galaxia
     * @param n
     * @throws Exception
     */
    public void afegirNau(int idn) throws Exception
    {
    	g.afegirNau(idn);
    }
        
    // Pre: Cierto
    // Post:
    /**
     * Metodo para eliminar una nave de la galaxia
     * @param idNau
     * @throws Exception
     */
    public void eliminarNau(int idNau) throws Exception
    {
    	g.eliminarNau(idNau);
    }
    
    // Pre: Cierto
    // Post:
    /**
     * Metodo para eliminar el contenido de la galaxia
     * @throws Exception
     */
    public void eliminarContingutGalaxia() throws Exception
    {
    	g.eliminarContingutGalaxia();
    }
    
    /** HACER ESTO **/
    
    /*// Pre: Cierto
    // Post:
    public String carregarConjuntGalaxia(String directori) throws Exception
    {
    	
    }

    // Pre: Cierto
    // Post:
    public void guardarConjuntGalaxia()
    {
    	
    }*/
}


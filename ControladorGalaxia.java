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
    	res = res + ":";
    	while(it.hasNext()) {
    		res += it.next().consultarPrimero() + "," + it.next().consultarSegundo();
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
    	//String res = "";
    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
    	/*Iterator<Pair<Integer, Integer> > it = lp.iterator();
    	while(it.hasNext()) {
    		res += it.next().consultarPrimero() + "," + it.next().consultarSegundo() + ":";
    	}*/
    	return lp.toString();
    	//return res;
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
    	String res = "";
    	if(g.consulta_nombrePlanetes() > 0) { // listar planetas
    		ArrayList<Integer> np = g.consultarPlanetes();
    		for(Integer a : np) {
    			res += a.toString() + ":";
    		}
    	}
    	return res;
    }
    
    /**
     * Metodo para consultar el listado de rutas de la galaxia
     * @return Los identificadores de las rutas
     * @throws Exception
     */
    public String llista_rutes() throws Exception
    {
    	String res = "";
    	if(g.consulta_nombreRutes() > 0) { // listar planetas
    		ArrayList<Integer> nr = g.consultarRutes();
    		for(Integer a : nr) {
    			res += a.toString() + ":";
    		}
    	}
    	return res;
    }
    
    /**
     * Metodo para consultar el listado de naves en la galaxia
     * @return Los identificadores de las naves
     * @throws Exception
     */
    public String llista_naus() throws Exception
    {
    	String res = "";
    	if(g.consulta_nombreNaus() > 0) { // listar planetas
    		ArrayList<Integer> nn = g.consultarNaus();
    		for(Integer a : nn) {
    			res += a.toString() + ":";
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
    public int consultarLimit() throws Exception
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
     * @param cp
     * @param idPlaneta
     * @param x
     * @param y
     * @throws Exception
     */
    public void afegirPlaneta(ControladorPlaneta cp, int idPlaneta, int x, int y) throws Exception
    {
    	// AÃ‘ADIR LO DE ABAJO SI SE CREA UNA CONSTRUCTORA VACIA CON LIMITE 0
    	//if(g.consultarLimitGalaxia() < 1) throw new Exception("Error: no es pot afegir un planeta a una galaxia sense limit");
    	try {
	    	Planeta p = cp.BuscarPlaneta(idPlaneta);
	    	g.afegirPlaneta(p,x,y);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    // Pre: Cierto
    // Post: // COORDENADAS ALEATORIAS
    /**
     * Metodo para añadir un planeta creado automaticamente
     * @param cp
     * @param idPlaneta
     * @returnDevuelve las coordenadas con las que se ha introducido en la galaxia
     * @throws Exception
     */
    public String afegirPlanetaAutomatic(ControladorPlaneta cp, int idPlaneta) throws Exception
    {
    	// AÃ‘ADIR LO DE ABAJO SI SE CREA UNA CONSTRUCTORA VACIA CON LIMITE 0
    	//if(g.consultarLimitGalaxia() < 1) throw new Exception("Error: no es pot afegir un planeta a una galaxia sense limit");
	    try {  	
    		Planeta p = cp.BuscarPlaneta(idPlaneta);
	      	Pair<Integer, Integer> pa = g.afegirPlanetaAutomatic(p);
	      	String res = "";
	      	res = pa.consultarPrimero() + "," + pa.consultarSegundo();
	    	return res;
	    }
	    catch(Exception e){
    		System.out.println(e);
    	}
		return null;
    }
    
    // Pre: Cierto
    // Post:
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param idPlaneta
     * @param cp
     * @throws Exception
     */
    public void eliminarPlaneta(int idPlaneta, ControladorPlaneta cp) throws Exception
    {
    	try {
	    	if(g.consulta_nombrePlanetes() > 0) {
	    		Planeta p = cp.BuscarPlaneta(idPlaneta);
	    		g.eliminarPLaneta(p);
	    	}
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }

    // Pre: Cierto
    // Post:
    /**
     * Metodo para añadir una ruta en la galaxia
     * @param idRuta
     * @throws Exception
     */
    public void afegirRuta(int idRuta) throws Exception
    {
    	try{
    		g.afegirRuta(idRuta);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
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
    	try {
    		g.eliminarRuta(idRuta);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    // Pre: Cierto
    // Post:
    /**
     * Metodo para añadir una nave en la galaxia
     * @param idn
     * @throws Exception
     */
    public void afegirNau(int idn) throws Exception
    {
    	try {
    		g.afegirNau(idn);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
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
    	try {
    		g.eliminarNau(idNau);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    /**
     * Metodo para transformar los planetas a nodos y las rutas a vertices
     * @throws Exception
     */
    public Pair<List<Arco>, List<Nodo> > convierteRutasYPlanetas(ControladorRuta cr, ControladorPlaneta cp) throws Exception 
    {
    	List<Arco> laa = new ArrayList<Arco>();
    	List<Nodo> lnn = new ArrayList<Nodo>();
		ArrayList<Integer> ai = g.consultarRutes();
		int idRuta, origen, destino, capac, idGeneral;
		boolean bi;
		Nodo o, d;
		idGeneral = 0;
		Ruta r = null;
		Arco a = null;
		Arco b = null;
		Planeta p1, p2;
		for(int i = 0; i < ai.size(); ++i) {
			r = cr.BuscarRuta(ai.get(i));
			idRuta = r.consultar_id();
			origen = r.consultar_planetaA();
			destino = r.consultar_planetaB();
			capac = r.consultar_capacidad();
			bi = r.consultar_bidireccional();
			p1 = cp.BuscarPlaneta(origen);
			p2 = cp.BuscarPlaneta(destino);
			o = transformar_PlanetaANodo(p1);
			d = transformar_PlanetaANodo(p2);
			if(!lnn.contains(o)) lnn.add(o);
			if(!lnn.contains(d)) lnn.add(d);
			if(!bi) {
				a = new Arco(idGeneral,o,d,capac,idRuta);
				++idGeneral;
				laa.add(a);
			}
			else {
				a = new Arco(idGeneral,o,d,capac,idRuta);
				++idGeneral;
				b = new Arco(idGeneral,d,o,capac,idRuta);
				++idGeneral;
				laa.add(a);
				laa.add(b);
			}
		}
		return new Pair<List<Arco>, List<Nodo> >(laa,lnn);
    }
    
    /**
     * Metodo para transformar de planeta a nodo
     * @throws Exception
     */
    public Nodo transformar_PlanetaANodo(Planeta p) throws Exception
    {
    	return new Nodo(p.Consultar_id(),p.Consultar_Fuente(),p.Consultar_Sumidero());
    }
    
    // Pre: Cierto
    // Post:
    /**
     * Metodo para eliminar el contenido de la galaxia
     * @throws Exception
     */
    public void eliminarContingutGalaxia() throws Exception
    {
    	try {
    		g.eliminarContingutGalaxia();
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
        
    // Pre: Cierto
    // Post:
    public String carregarConjuntGalaxia(String directori)
    {
		return null;
    	
    }

    // Pre: Cierto
    // Post:
    public void guardarConjuntGalaxia(String directori)
    {
   	
   	}
}

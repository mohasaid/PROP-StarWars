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
    	if(g.consulta_nombreLimits() > 0) { // Solo si tiene limites lo pongo
	    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
	    	Iterator<Pair<Integer, Integer> > it = lp.iterator();
	    	res = res + ":";
	    	while(it.hasNext()) {
	    		res += it.next().consultarPrimero() + "," + it.next().consultarSegundo();
	    	}
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
	    		res += it.next().consultarPrimero() + "," + it.next().consultarSegundo(); // revisar + ","
	    	}
	    	return res;
    	}
    	else throw new Exception("La galaxia no tiene forma");
    }
    
    /**
     * Metodo para consultar el listado de planetas de la galaxia
     * @return Los identificadores de los planetas
     * @throws Exception
     */
    public String llista_planetes(ControladorPlaneta cp) throws Exception
    {
    	String res = "";
    	if(cp.Consultar_Size() > 0) {
    		ArrayList<Integer> np = cp.consultarPlanetas();
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
    public String llista_rutes(ControladorRuta cr) throws Exception
    {
    	String res = "";
    	if(cr.Consultar_numero_rutes() > 0) {
    		ArrayList<Integer> nr = cr.Consultar_ids_rutas();
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
    public String llista_naus(ControladorNave cn) throws Exception
    {
    	String res = "";
    	int i=0;
        int n = cn.size();
        while(i < n) {
        	res += cn.ConsultarNaves(i);
        	++i;
        }
    	return res;
    }
    
    /**
     * Metodo para consultar el numero de planetas en la galaxia
     * @return Numero de planetas en la galaxia
     * @throws Exception
     */
    public int consultarNumPlanetes(ControladorPlaneta cp) throws Exception
    {
        return cp.Consultar_Size();
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
    
   /**
    * Metodo para modificar las coordenadas del planeta con identificador "idPlaneta" 
    * @param x
    * @param y
    * @param idPlaneta
    * @param cp
    */
   public void modificarCoordenadesPlaneta(int x, int y, int idPlaneta, ControladorPlaneta cp)
    {
    	try{
	    	if(g.existeixPlaneta(idPlaneta)) {
	    		Planeta p = cp.BuscarPlaneta(idPlaneta);
	    		g.existeixPlanetaCoordenades(x, y);
	    		if(g.dintreLimitUsuari(x, y)) {
	    			g.eliminarPLaneta(p);
	    			p.modificarCoordenades(x, y);
	    			g.afegirPlaneta(idPlaneta, x, y);
	    		}
	    		else throw new Exception("las coordenadas se encuentran fuera de la galaxia");
	    	}
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
   
   /**
    * Metodo para modificar el el identificador del planeta con las coordenadas "x" y "y"
    * @param x
    * @param y
    * @param idPlaneta
    */
   public void modificarIDPlaneta(int x, int y, int idPlaneta) 
   {
	   try{
		   g.modificarIDplaneta(x, y, idPlaneta);
	   }
	   catch(Exception e){
   		System.out.println(e);
   	   }
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
    	if(g.consultarLimitGalaxia() < 1) throw new Exception("Error: no es pot afegir un planeta a una galaxia sense limit");
    	try {
    			g.afegirPlaneta(idPlaneta,x,y);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    /**
     * Metodo para añadir un planeta creado automaticamente
     * @param cp
     * @param idPlaneta
     * @returnDevuelve las coordenadas con las que se ha introducido en la galaxia
     * @throws Exception
     */
    public void afegirPlanetaAutomatic(ControladorPlaneta cp, int idPlaneta) throws Exception
    {
    	if(g.consultarLimitGalaxia() < 1) throw new Exception("Error: no es pot afegir un planeta a una galaxia sense limit");
	    try {  	
    		Planeta p = cp.BuscarPlaneta(idPlaneta);
	      	Pair<Integer, Integer> pa = g.afegirPlanetaAutomatic(idPlaneta);
	      	p.modificarCoordenades(pa.consultarPrimero(), pa.consultarSegundo());
	      	// quitar del controlador y ponerlo
	    }
	    catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param idPlaneta
     * @param cp
     * @throws Exception
     */
    public void eliminarPlaneta(int idPlaneta) throws Exception
    {
    	try {
	    	g.eliminarPlaneta(idPlaneta);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    public void CrearNau(ControladorNave cn, int id, int t, int d, int o)
    {
    	try {
    		cn.CrearNave(id, t, d, o);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    public void eliminarNau(int idNau, ControladorNave cn)
    {
    	try{
	    	cn.EliminarNave(idNau);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void eliminarTotesNaus(ControladorNave cn)
    {
    	try{
    		cn.EliminarNaves();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    // CONSULTAR NAVE, PLANETA, RUTAS INDIVIDUALMENTE EN GALAXIA?
    public String consultaNave(int id, ControladorNave cn) throws Exception
    {
    	String res = "";
    	Nave a = cn.BuscarNave(id);
    	res += a.consultar_id() + ":" + a.consultar_origen() + ":" + a.consultar_destino();
    	return res;
    }
    
    public void crearRuta(ControladorRuta cr, int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional, ControladorPlaneta cp) 
    {
    	try{
    		cr.CrearRuta(id, capacidad, distancia, planetaA, planetaB, bidireccional, cp);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void eliminarRuta(ControladorRuta cr, int idRuta)
    {
    	try {
    		cr.Borrar_Ruta(idRuta);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void eliminarRutes(ControladorRuta cr)
    {
    	try {
    		cr.BorrarRutas();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public String consultarRuta(int idRuta, ControladorRuta cr)
    {
    	try {
	    	String res = "";
	    	Ruta r = cr.BuscarRuta(idRuta);
	    	res += r.consultar_id() + ":" + r.consultar_capacidad() + ":" + r.consultar_distancia();
	    	Conexion c = cr.BuscarConexion(idRuta);
	    	res += c.consultar_planetaA() + ":" + c.consultar_planetaB() + c.consultar_bidireccional();
	    	return res;
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
		return null;
    }
    

    /**
     * Metodo para transformar los elementos de la galaxia en un grafo
     * @throws Exception
     */
    public ArrayList<ArrayList<Pair<Arco,Integer> > > convierteRutasYPlanetas(ControladorRuta cr, ControladorPlaneta cp) throws Exception 
    {
    	ArrayList<ArrayList<Pair<Arco,Integer> > > resultado = new ArrayList<ArrayList<Pair<Arco,Integer> > >();
    	ArrayList<Pair<Arco, Integer> > ap = new ArrayList<Pair<Arco, Integer> >();
    	ArrayList<Integer> pl = cp.consultarPlanetas();
    	int tam = pl.size();
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
    				int cap = r.consultar_capacidad();
    				int cost = r.consultar_distancia();
    				Arco arc = new Arco(cap,cost);
    				ap.get(i).ponPrimero(arc);
    				ap.get(i).ponSegundo(ac.get(j).consultar_planetaB());
    			}
    		}
    		resultado.add(ap);
    	}
    	// FALTA CONSULTAR TODAS LAS DESTINACIONES, PARA CREAR EL NODO VIRTUAL QUE LE ENTREN ESTAS
    	return resultado;
    }
    	
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
			cin.useDelimiter("#"); // esto no esta bien
			String info;
			while(cin.hasNext()) {
				info = cin.next();
				if(!(info.contentEquals("@"))) {
					String nomG = info; // nombre
					info = cin.next(); // limite siempre tendra
					Integer N = Integer.parseInt(info);
					info = cin.next();
					// Integer pres = Integer.parseInt(info); debo de crear una constructora con presupuesto
					if(info.contentEquals("null")) {
						g = new Galaxia(nomG,N);
						break; // no tiene limites
					}
					// String lim = cin.next();
					// CONVERTIR LIM EN LIMITES
					if(info.contentEquals("null")) {
						g = new Galaxia(nomG,N/*, falta LIMITES*/);
						break; // no tiene limites
					}
					while(cin.hasNext() && info != "X") { // LEER PLANETAS
						info = cin.next();
						if (info.contentEquals("@")) break; 
						if(cp.ExistePlaneta(Integer.parseInt(info))) { // existe ese planeta
							Planeta p = cp.BuscarPlaneta(Integer.parseInt(info));
							String x = cin.next();
							String y = cin.next();
							int x1 = Integer.parseInt(x);
							int y1 = Integer.parseInt(y);
							g.afegirPlaneta(p.Consultar_id(), x1, y1); // cp.afegirPlaneta
						}
					}
					while(cin.hasNext() && info != "Y") { 	// LEER RUTAS
						info = cin.next();
						if (info.contentEquals("@")) break; 
						if(cr.ExisteRuta(Integer.parseInt(info))) { // existe la ruta
							throw new Exception("Ya existe una ruta con ese identificador");
						}
						else {
							//cr.afegirRuta(info);
						}
					}
					while(cin.hasNext()) { 	// LEER NAVES
						info = cin.next();
						if (info.contentEquals("@")) break; 
						if(cn.ExisteNave(Integer.parseInt(info))) { // existe la nave
							throw new Exception("Ya existe una nave con ese identificador");
						}
						else {
							//cn.afegirNau(info);
						}
					}
				}	
			}
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
    	result += g.consultarNomGalaxia() + ":" + g.consultarLimitGalaxia();
    	if(g.consulta_nombreLimits() > 0 ) result += ":" + g.consultarValorLimits();
    	result += "#@";
    	if(cp.Consultar_Size() > 0) { // PLANETAS
    		ArrayList<Integer> pla = cp.consultarPlanetas();
    		for(int i = 0; i < pla.size(); ++i) {
    			Planeta p = cp.BuscarPlaneta(pla.get(i));
    			result += p.Consultar_id() + ":" + p.consultar_X() + ":" + p.consultar_Y(); // ID:X:Y
    		}
    	}
    	result += "#@";
    	if(cr.Consultar_numero_rutes() > 0) { // RUTAS
    		ArrayList<Integer> rut = cr.Consultar_ids_rutas();
    		for(int i = 0; i < rut.size(); ++i) {
    			result += ":" + rut.get(i);  // ID:ID
    		}
    	}
    	result += "#@";
    	if(cn.size() > 0) { // NAVES -> ARREGLAR ESTO
    		ArrayList<Integer> nau = null;
    		for(int i = 0; i < nau.size(); ++i) {
    			result += ":" + nau.get(i);  // ID:ID
    		}
    	}
    	cdg.guardar(result);
    	cdg.CerrarEscritura();
   	}
}

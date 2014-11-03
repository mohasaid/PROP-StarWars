import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
 
public class ControladorGalaxia
{
    private Galaxia g;
    private ControladorDades CDades;
 
    //CONSTRUCTORES
 
    // Pre: Cierto
    // Post: Se crea un nuevo controlador de galaxia
    public ControladorGalaxia() {
    	g = new Galaxia();
    	CDades = new ControladorDades();
    }
 
    // Pre: Cierto
    // Post: Es crea una galaxia amb nom "nom" i amb N "n"
    public void creaGalaxia(String nom,int n) throws Exception
    {
        g = new Galaxia(nom,n);
    }
    
    public void creaGalaxia2(String nom, int n, List<Pair<Integer, Integer> > l, int p) throws Exception
    {
    	g = new Galaxia(nom,n,l,p);
    }
 
    //CONSULTORES
    
    public String consultar_nom()
    {
    	return g.consultarNomGalaxia();
    }
    
    // nombre, presupuesto, limite, (limites impuestos por el usuario)
    public String consultarElementsGalaxia() throws Exception
    {
    	String res = "";
    	res = g.consultarNomGalaxia() + ", " + g.consultarPresupost() + ", " + g.consultarLimitGalaxia();
    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
    	Iterator<Pair<Integer, Integer> > it = lp.iterator();
    	res = res + "@"; // para separar lo de arriba de los limites
    	while(it.hasNext()) {
    		res += it.next().getFirst() + ", " + it.next().getSecond();
    	}
    	return res;
    }
    // Pre: Cierto
    // Post: Lista el contenido de la galaxia: los planetas, las rutas y las naves, en caso de que existan
    public String llista_galaxia() throws Exception
    {
    	String res = null;
    	/*res += g.consultarNomGalaxia();
    	res += "@";*/
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
    public String llista_planetes() throws Exception
    {
    	String res = null;
    	/*res += g.consultarNomGalaxia();
    	res += "@"; */
    	Planeta p;
    	if(g.consulta_nombrePlanetes() > 0) { // listar planetas
    		ArrayList<Integer> np = g.consultarPlanetes();
    		for(Integer a : np) {
    			p = g.consultarPlaneta(a);
    			res += p.Consultar_id() + "(" + p.consultar_X() + "," + p.consultar_Y() + ")";
    		}
    	}
    	return res;
    }
    
    // Pre: Cierto
    // Post: Devuelve el numero de planetas que hay en la galaxia
    public int consultarNumPlanetes() throws Exception
    {
        return g.consulta_nombrePlanetes();
    }
    
    // Pre: Cierto
    // Post: Devuelve el valor limite de la galaxia
    public Integer consultarLimit() throws Exception
    {
        return g.consultarLimitGalaxia();
    }
 
    // Pre: Cierto
    // Post: Devuelve cierto si el planeta con id "idplaneta" existe en la galaxia, falso en caso contrario
    public boolean existeixPlaneta(int idplaneta) throws Exception
    {
        return g.existeixPlaneta(idplaneta);
    }
 
    // MODIFICADORES
    
    // Pre: Cierto
    // Post: Devuelve la galaxia con nuevo nombre "nomNou"
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
    public void modificarCoordenadesPlaneta(int x, int y, int idPlaneta)
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
    }
    
    // Pre: Cierto
    // Post: 
    public void afegirPlaneta(Planeta p) throws Exception
    {
    	if(g.consultarLimitGalaxia() < 1) throw new Exception("Error: no es pot afegir un planeta a una galaxia sense limit");
    	g.afegirPlaneta(p);
    }
    
    /** ARREGLAR ESTO **/
    // Pre: Cierto
    // Post: // COORDENADAS ALEATORIAS
    public void afegirPlanetaAutomatic(int idPlaneta) throws Exception
    {
    	if(g.consultarLimitGalaxia() < 1) throw new Exception("Error: no es pot afegir un planeta a una galaxia sense limit");
    	g.afegirPlanetaAutomaticID(idPlaneta);
    }
    
    // Pre: Cierto
    // Post:
    public void eliminarPlaneta(int idPlaneta) throws Exception
    {
    	if(g.existeixPlaneta(idPlaneta)) g.eliminarPLaneta(idPlaneta);
    }

    // Pre: Cierto
    // Post:
    public void afegirRuta(Ruta r) throws Exception
    {
    	g.afegirRuta(r);
    }
    
    // Pre: Cierto
    // Post:
    public void eliminarRuta(int idRuta) throws Exception
    {
    	if(g.existeixRuta(idRuta)) g.eliminarRuta(idRuta);
    }
    
    // Pre: Cierto
    // Post:
    public void afegirNau(Nave n) throws Exception
    {
    	g.afegirNau(n);
    }
        
    // Pre: Cierto
    // Post:
    public void eliminarNau(int idNau) throws Exception
    {
    	if(g.existeixNau(idNau)) g.eliminarNau(idNau);
    }
    
    // Pre: Cierto
    // Post:
    public void eliminarContingutGalaxia() throws Exception
    {
    	g.eliminarContingutGalaxia();
    }
    
    /** HACER ESTO **/
    
    /*// Pre: Cierto
    // Post:
    public String carregarConjuntGalaxia(String directori) throws Exception
    {
    	// Per evitar conflictes, esborrem el que tenim actualment
    	g.eliminarContingutGalaxia();
    	String res;
    	CDades.OpenRead(directori);
    	while(!(res = CDades.carregar()).isEmpty()) {
    		Scanner in = new Scanner(res);
    	       in.useDelimiter("\\@");
    	       String s;
    	       while (in.hasNext()) {
    	            s = in.next(); 
    	            if (!s.contentEquals("#")) {
    	                String nomG = s;
    	                s = in.next();                
    	                Integer lim = Integer.parseInt(s);
    	                Galaxia g = new Galaxia(nomG,lim);
    	                if (s.contentEquals("null")) break;
    	                while (in.hasNext()) { //recollim els planetes de la galaxia
    	                    s = in.next();
    	                    if (s.contentEquals("#")) break; 
    	                    if (cPlaneta.existeixPlaneta(s)) {
    	                        Planeta p = cPlaneta.consultarUnPlaneta(s);
    	                        String x = in.next();
    	                        String y = in.next();
    	                        String z = in.next();
    	                        double dx, dy, dz;
    	                        dx = Double.parseDouble(x);
    	                        dy = Double.parseDouble(y);
    	                        dz = Double.parseDouble(z);
    	                        g.agregarPlanetaMan(s, p, dx, dy, dz); 
    	                        p.assignarGalaxia(g);                        
    	                    }                     
    	                    
    	                }
    	                conjuntGalaxia.posar(nomG, g);
    	            }
    	        }   
    	       in.close();
    	}
    }

    // Pre: Cierto
    // Post:
    public void guardarConjuntGalaxia()
    {
    	
    }*/
}


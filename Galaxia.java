import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
 
 
public class Galaxia {
	
    private String nomGalaxia;
    private static int[][] gal; // N*N
    private Integer presupost;
    private TreeSet<Planeta> planetes; 
    private TreeSet<Ruta> rutes; 
    private TreeSet<Nave> naus; 
    private static Integer N; // valor del limit de la galaxia, posem algun limit com 15 (matriu 15x15)
    private static List<Pair<Integer,Integer> > limits; // private list<pairs> con coordenadas de la galaxia impuestas por el usuario
  
    private static boolean alfa_numeric(String nom) // NOM ALFANUMERIC I < 20 CARACTERS
    {
        if(nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for(int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if(!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
     
    // Pre: No hi han coordenades repetides
    // Post: Retorna cert si totes les coordenades son confrontants entre elles, fals altrament
    /*private boolean consultarConfrontantsTotes(List<Pair<Integer, Integer> > pai) throws Exception
    {
    	System.out.println("Empeiza el programa");
        boolean res = true;
        if(!pai.isEmpty()) {
        	System.out.println("estoy dentro");
            boolean trobat;
            boolean[] trobats = new boolean[pai.size()];
            Pair<Integer, Integer> pa = new Pair<Integer, Integer>(null, null);
            for(int i = 0; i < pai.size(); ++i) {
            	System.out.println("Estoy dentro del bucle");
                trobat = false;
                Integer a = pai.get(i).getFirst();
                Integer b = pai.get(i).getSecond();
                System.out.println("He asignado valores al pair");
                pa.setFirst(a); pa.setSecond(b);
                System.out.println("He asignado valores al pair segundo");
                if(pa.getFirst() > N || pa.getSecond() > N ) throw new Exception("Error: les coordenades del planeta no poden ser majors que el limit de la galaxia");
                if(pa.getFirst() < 0 || pa.getSecond() < 0) throw new Exception("Error: les coordenades del planeta no poden ser menors que 0");
                System.out.println("Voy a comprobar las primeras coordenadas");
                System.out.println("Primera coordenada: " + pa.getFirst());
                System.out.println("Segunda coordenada: " + pa.getSecond());
                for(int j = 0; j < pai.size() && !trobat; ++j) {
                    if(i != j) {
                        if((((pa.getFirst().intValue() + 1) == pai.get(j).getFirst().intValue()) || ((pa.getFirst().intValue() - 1) == pai.get(j).getFirst().intValue()) || (pa.getFirst().intValue() == pai.get(j).getFirst().intValue())) && ((pa.getSecond().intValue() + 1 == pai.get(j).getSecond().intValue()) || (pa.getSecond().intValue() - 1 == pai.get(j).getSecond().intValue()) || (pa.getSecond().intValue() == pai.get(j).getSecond().intValue()))) {
                        trobat = true;
                        trobats[i] = true;
                    }
                }
            }
         }
         for(int i = 0; i < trobats.length; ++i) {
            if(trobats[i] == false) {
                res = false;
                break;
            }
         }
        }
        return res;
    }*/
    
    // Pre: No hi han coordenades repetides
    // Post: Retorna cert si totes les coordenades son confrontants entre elles, fals altrament
    private boolean consultarConfrontantsTotes(List<Pair<Integer, Integer> > pai) throws Exception
    {
        boolean res = true;
        if(!pai.isEmpty()) {
            List<Pair<Boolean, Boolean>> tr = new ArrayList<Pair<Boolean, Boolean> >();
            //Pair<Integer, Integer> pa = new Pair<Integer, Integer>(null, null);
            int tmp;
            for(int i = 0; i < pai.size(); ++i) {
                Integer a = pai.get(i).getFirst();
                Integer b = pai.get(i).getSecond();
                Pair<Integer, Integer> pa = new Pair<Integer, Integer>(a, b);
                //pa.setFirst(a); pa.setSecond(b);
                if(pa.getFirst() > N || pa.getSecond() > N ) throw new Exception("Error: les coordenades del planeta no poden ser majors que el limit de la galaxia");
                if(pa.getFirst() < 0 || pa.getSecond() < 0) throw new Exception("Error: les coordenades del planeta no poden ser menors que 0");
                tmp = i;
                for(int j = 0; (j < pai.size() && !tr.get(i).getFirst().booleanValue() && !tr.get(i).getSecond().booleanValue()) || (j < pai.size() && tr.get(i).getFirst().booleanValue() && !tr.get(i).getSecond().booleanValue()) || (j < pai.size() && !tr.get(i).getFirst().booleanValue() && tr.get(i).getSecond().booleanValue()); ++j) {
                    if(i != j && j != tmp) {
                        if((((pa.getFirst().intValue() + 1) == pai.get(j).getFirst().intValue()) || ((pa.getFirst().intValue() - 1) == pai.get(j).getFirst().intValue()) || (pa.getFirst().intValue() == pai.get(j).getFirst().intValue())) && ((pa.getSecond().intValue() + 1 == pai.get(j).getSecond().intValue()) || (pa.getSecond().intValue() - 1 == pai.get(j).getSecond().intValue()) || (pa.getSecond().intValue() == pai.get(j).getSecond().intValue()))) {
    	                    tmp = j;
    	                    if(tr.get(i).getFirst().booleanValue() == true) {
    	                    	tr.get(i).setSecond(true);
    	                    }
    	                    else {
    	                    	tr.get(i).setFirst(true);
    	                    }
                    }
                }
            }
         }
         for(int i = 0; i < tr.size(); ++i) {
        	if(tr.get(i).getFirst().booleanValue() == false || tr.get(i).getSecond().booleanValue() == false) {
                res = false;
                break;
            }
         }
        }
        return res;
    }

    
	 // Pre: Cert
	 // Post: Retorna cert si les coordenades es troben dins del limit imposat per l'usuari, fals altrament
	 private boolean dintreLimitUsuari(int x, int y) throws Exception
	 {
	     if(x > N || y > N) throw new Exception("Error: les coordenades del planeta no poden ser majors que el limit de la galaxia");
	         int max_first, max_second, max_x, max_y;
	         max_first = max_second = max_x = max_y = 0;
	         for(int i = 0; i < N; ++i) {
	         	if(gal[x][i] == -1 && i != x) {
	         		max_first = i;
	         		break;
	         	}
	         }
	         for(int i = max_first + 1; i < N; ++i) {
	         	if(gal[x][i] == -1 && i != x) max_second = i;
	         }
	         for(int i = 0; i < N; ++i) {
	         	if(gal[i][y] == -1 && i != y) {
	         		max_x = i;
	             	break;
	         	}
	         }
	         for(int i = max_x + 1; i < N; ++i) {
	         	if(gal[i][y] == -1 && i != y) max_y = i;
	         }
	         
	         if((max_first < x && x < max_second) && (max_x < y && y < max_y)) return true;
	         else return false;
	 }
    
    // Pre: No hi ha coordenades repetides a limits
    // Post: A les posicions indicades per l'usuari s'hi fica un -1
    private static void inicialitzaMatriu()
    {
    	for(int i = 0; i < limits.size(); ++i) {
    		int a = limits.get(i).getFirst().intValue();
    		int b = limits.get(i).getSecond().intValue();
    		gal[a][b] = -1;
    	}
    }
    
    private static boolean comprovaRepetits(List<Pair<Integer, Integer> > l)
    {
    	for(int i = 0; i < l.size(); ++i) {
    		for(int j = i+1; j < l.size(); ++j) {
    			if((l.get(j).getFirst().equals(l.get(i).getFirst())) && (l.get(j).getSecond().equals(l.get(i).getSecond()))) return true;
    		}
    	}
    	return false;
    }
    
    private static Pair<Integer, Integer> menorXY()
    {
    	Integer first = limits.get(0).getFirst();
    	Integer second = limits.get(0).getSecond();
    	for(int i = 1; i < limits.size(); ++i) {
    		if(limits.get(i).getFirst() < first) first = limits.get(i).getFirst();
    		if(limits.get(i).getSecond() < second) second = limits.get(i).getSecond();
    	}
    	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(first,second);
    	return pa;
    }
    
    private static Pair<Integer, Integer> majorXY()
    {
    	Integer first = limits.get(0).getFirst();
    	Integer second = limits.get(0).getSecond();
    	for(int i = 1; i < limits.size(); ++i) {
    		if(limits.get(i).getFirst() > first) first = limits.get(i).getFirst();
    		if(limits.get(i).getSecond() > second) second = limits.get(i).getSecond();
    	}
    	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(first,second);
    	return pa;
    }
    
    private int randInt(int min, int max)
    {
    	Random rand = new Random();
    	int randomNum = rand.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
    
    // CONSTRUCTORES
  
    // Pre: Cert
    // Post: Es crea una galaxia buida
    public Galaxia()
    {
        nomGalaxia = "";
        //gal = new int[N][]; 
        presupost = new Integer(-1); 
        planetes = new TreeSet<Planeta>(new OrdenPlaneta()); 
        rutes = new TreeSet<Ruta>(new OrdenRuta());
        naus = new TreeSet<Nave>(new OrdenNave());
        //N = 0;
        limits = new ArrayList<Pair<Integer,Integer> >();
    }
    // Pre: Cert
    // Post: Es crea una galaxia amb nomGalaxia "nom" i N "n"
    public Galaxia(String nom, int n) throws Exception
    {
        if(!alfa_numeric(nom)) throw new Exception("Error: el nom ha d'estar format per lletres o numeros i amb menys de 20 caracters.");
        if(n < 15) throw new Exception("Error: el limit d'una galaxia ha de ser major o igual que 15");
        nomGalaxia = nom;
        presupost = new Integer(-1);
        planetes = new TreeSet<Planeta>(new OrdenPlaneta());
        rutes = new TreeSet<Ruta>(new OrdenRuta());
        naus = new TreeSet<Nave>(new OrdenNave());
        N = new Integer(n);
        limits = new ArrayList<Pair<Integer,Integer> >();
        gal = new int[n][n];
    }
    // Pre: Cert
    // Post: Es crea una galaxia amb nomGalaxia "nom" i N "n" i limits "l" i pressupost "p"
    public Galaxia(String nom, int n, List<Pair<Integer, Integer> > l, int p) throws Exception
    {
        if(!alfa_numeric(nom)) throw new Exception("Error: el nom ha d'estar format per lletres o numeros i amb menys de 20 caracters.");
        if(n < 15) throw new Exception("Error: el limit d'una galaxia ha de ser major o igual que 15");
        if(p < 0) throw new Exception("Error: el presupost no pot ser negatiu");
        if(l.size() < 6) throw new Exception("Error: com a minim s'ha de tenir 6 coordenades per delimitar un limit en la galaxia");
        nomGalaxia = nom;
        N = new Integer(n);
        if(comprovaRepetits(l)) throw new Exception("Error: les coordenades que formen el limit no poden tenir coordenades repetides");
        if(!consultarConfrontantsTotes(l)) throw new Exception("Error: les coordenades no son confrontants");
        limits = l;
        presupost = new Integer(p);
        gal = new int[n][n];
        planetes = new TreeSet<Planeta>(new OrdenPlaneta());
        rutes = new TreeSet<Ruta>(new OrdenRuta());
        naus = new TreeSet<Nave>(new OrdenNave());
        inicialitzaMatriu();
    }
  
    // CONSULTORAS
  
    // Pre: Cert
    // Post: Retorna el nom de la galaxia
    public String consultarNomGalaxia()
    {
        return nomGalaxia;
    }
    // Pre: Cert
    // Post: Retorna el presupost de la galaxia
    public Integer consultarPresupost() throws Exception
    {
    	if(presupost == -1) throw new Exception("Error: La galaxia no tiene un presupuesto asignado");
        return presupost;
    }
    // Pre: Cert
    // Post: Retorna el conjunt de noms dels planetes de la galaxia
    public ArrayList<Integer> consultarPlanetes() throws Exception  // Devuelva nombres o planetas
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Iterator<Planeta> it = planetes.iterator();
        while(it.hasNext()) {
        	res.add(it.next().Consultar_id());
        }
        return res;
    }
    // Pre: Cert
    // Post: Retorna el numero de planetes que hi ha en la galaxia
    public int consulta_nombrePlanetes()
    {
        return planetes.size();
    }
    // Pre: Cert
    // Post: Retorna el numero de coordenades que formen els limits de la galaxia
    public int consulta_nombreLimits()
    {
        return limits.size();
    }
    
    public List<Pair<Integer, Integer> > consultarValorLimits()
    {
    	return limits;
    }
    
    // Pre: Cert
    // Post: Retorna el conjunt de noms de les rutes de la galaxia
    public ArrayList<Integer> consultarRutes() throws Exception
    {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	Iterator<Ruta> it = rutes.iterator();
        while(it.hasNext()) {
        	res.add(it.next().consultar_id());
        }
        return res;
  
    }
    // Pre: Cert
    // Post: Retorna el numero de rutes que hi ha en la galaxia
    public int consulta_nombreRutes()
    {
        return rutes.size();
    }
    // Pre: Cert
    // Post: Retorna el conjunt de noms de les naus de la galaxia
    public ArrayList<Integer> consultarNaus() throws Exception
    {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	Iterator<Nave> it = naus.iterator();
        while(it.hasNext()) {
        	res.add(it.next().consultar_id());
        }
        return res;
    }
    // Pre: Cert
    // Post: Retorna el numero de naus que hi ha en la galaxia
    public int consulta_nombreNaus()
    {
        return naus.size();
    }
    // Pre: Cert
    // Post: Retorna el valor del limit de la galaxia
    public Integer consultarLimitGalaxia()
    {
        return N;
    }
     
    // Pre: Cert
    // Post: Retorna cert si existeix un planeta en les coordenades indicades, fals altrament
    public boolean existeixPlanetaCoordenades(int x, int y) throws Exception
    {
        if(x > N || y > N) throw new Exception("Error: les coordenades del planeta no poden ser majors que el limit de la galaxia");
        if(x < 0 || y < 0) throw new Exception("Error: les coordenades del planeta no poden ser menors que 0");
        if(!dintreLimitUsuari(x,y)) throw new Exception("Error: les coordenades no poden estar fora del limit imposat");
        Pair<Integer, Integer> pa;
        Iterator<Planeta> it = planetes.iterator();
        while(it.hasNext()) {
        	pa = it.next().consultar_coordenades();
        	if(pa.getFirst().intValue() == x && pa.getSecond().intValue() == y) return true;
        }
         return false;
    }
    // Pre: Existeix un planeta amb nom "nomplaneta"
    // Post: Retorna el planeta que te de nom "nomplaneta"
    public Planeta consultarPlaneta(int idplaneta) throws Exception
    {
        Planeta a = null;
        Iterator<Planeta> it = planetes.iterator();
        boolean trobat = false;
        while(it.hasNext() && !trobat) {
        	a = it.next();
        	if(a.Consultar_id() == idplaneta) trobat = true;
        }
        return a;
    }
    // Pre: Cert
    // Post: Retorna cert si existeix un planeta amb nom "nomplaneta" en la galaxia
    public boolean existeixPlaneta(int idplaneta) throws Exception
    {
    	Iterator<Planeta> it = planetes.iterator();
    	while(it.hasNext()) {
    		if(it.next().Consultar_id() == idplaneta) return true;
    	}
        return false;
    }
    // Pre: Existeix una ruta amb nom "nomruta"
    // Post: Retorna la ruta que te de nom "nomplaneta"
    public Ruta consultarRuta(int idruta) throws Exception
    {
        Ruta r = null;
        Iterator<Ruta> it = rutes.iterator();
        boolean trobat = false;
        while(it.hasNext() && !trobat) {
        	r = it.next();
        	if(r.consultar_id() == idruta) trobat = true;
        }
        return r;
    }
    // Pre: Cert
    // Post: Retorna cert si existeix una ruta amb nom "nomruta" en la galaxia
    public boolean existeixRuta(int idruta) throws Exception
    {
        Iterator<Ruta> it = rutes.iterator();
        while(it.hasNext()) {
        	if(it.next().consultar_id() == idruta) return true;
        }
        return false;
    }
  
    // Pre: Existeix una nau amb nom "nomnau"
    // Post: Retorna la nau que te de nom "nomnau"
    public Nave consultarNau(int idnau) throws Exception
    {
        Nave n = null;
        Iterator<Nave> it = naus.iterator();
        boolean trobat = false;
        while(it.hasNext() && !trobat) {
        	n = it.next();
        	if(n.consultar_id() == idnau) trobat = true;
        }
        return n;
    }
    // Pre: Cert
    // Post: Retorna cert si existeix una ruta amb nom "nomruta" en la galaxia
    public boolean existeixNau(int idnau) throws Exception
    {
    	Iterator<Nave> it = naus.iterator();
        while(it.hasNext()) {
        	if(it.next().consultar_id() == idnau) return true;
        }
        return false;
    }
  
    // MODIFICADORAS
  
    // Pre: Cert
    // Post: La galaxia a modificar te de nomGalaxia "nom"
    public void modificar_nomGalaxia(String nom) throws Exception
    {
        if(!alfa_numeric(nom)) throw new Exception("Error: el nom ha d'estar format per lletres o numeros i amb menys de 20 caracters.");
        nomGalaxia = nom;
    }
    // Pre: Cert
    // Post: La galaxia a modificar te de presupost "p"
    public void modificarPresupost(int p) throws Exception
    {
        if(p < 0) throw new Exception("Error: el presupost no pot ser negatiu");
        presupost = Integer.valueOf(p);
    }
    // Pre: Cert
    // Post: La galaxia a modificar te de limit nou N "n"
    public void modificarN(int n) throws Exception
    {
        if(!planetes.isEmpty()) throw new Exception("Error: no es pot modificar el limit d'una galaxia que conte planetes");
        if(n < 15) throw new Exception("Error: el limit d'una galaxia ha de ser major que 15");
        N = Integer.valueOf(n);
    }
    // Pre: Cert
    // Post: La galaxia te uns nous limits indicats per p
    public void modificarLimitsUsuari(List<Pair<Integer, Integer> > p) throws Exception
    {
    	if(p.size() < 6) throw new Exception("Error: com a minim s'ha de tenir 6 coordenades per delimitar un limit en la galaxia");
    	if(comprovaRepetits(p)) throw new Exception("Error: les coordenades que formen el limit no poden tenir coordenades repetides");
    	limits = p;
    	inicialitzaMatriu();
    }
    /** COMPROBAR TODOS LOS AFEGIR PLANETES**/
    // Pre: Cert
    // Post: S'afegeix a la llista de planetes el planeta p
    public void afegirPlaneta(Planeta p) throws Exception // MANUAL
    {
        if(existeixPlaneta(p.Consultar_id())) throw new Exception("Error: ja existeix un planeta amb aquest nom");
        // if(contains(p)) throw new Exception("Error: ja existeix un planeta amb aquest nom");
        Pair<Integer, Integer> pa = p.consultar_coordenades();
        boolean b = existeixPlanetaCoordenades(pa.getFirst().intValue(),pa.getSecond().intValue());
        boolean c = dintreLimitUsuari(pa.getFirst().intValue(),pa.getSecond().intValue());
        if(!c) throw new Exception("Error: les coordenades del planeta no estan dintre del limit imposat");
        if(!b) planetes.add(p);
        else throw new Exception("Error: les coordenades del planeta estan ocupades per un altre planeta");
    }
    /** MODIFICAR ESTA ENTRA CON IDPLANETA**/

    // Pre: Cert
    // Post: S'afegeix a la llista de planetes un nou planeta amb id "idPlaneta" y uns atributs random
    public void afegirPlanetaAutomaticID(int idPlaneta) throws Exception // Viene con unos valores random, aqui compruebo su validez
    {
        if(existeixPlaneta(idPlaneta)) throw new Exception("Error: ja existeix un planeta amb aquest nom");
	    Pair<Integer, Integer> pa = menorXY();
	    Pair<Integer, Integer> pa1 = majorXY();
	    int rndX = randInt(pa.getFirst().intValue(), pa1.getFirst().intValue());
	    int rndY = randInt(pa.getSecond().intValue(), pa1.getSecond().intValue());
	    int coste = randInt(1,Integer.MAX_VALUE);
	    boolean b = existeixPlanetaCoordenades(rndX, rndY);
	    boolean c = dintreLimitUsuari(rndX, rndY);
	    if(!c) throw new Exception("Error: les coordenades del planeta no estan dintre del limit imposat");
	    if(!b && c) {
	    	Pair<Integer, Integer> par = new Pair<Integer, Integer>(rndX, rndY);
	    	Planeta p = new Planeta(idPlaneta,coste,par);
	        planetes.add(p);
	    }
        else throw new Exception("Error: les coordenades estan ocupades per un altre planeta");
    }
    
    // Pre: Cert
    // Post: S'afegeix a la llista de planetes el planeta p - MAL
    public void afegirPlanetaAutomatic(Planeta p) throws Exception
    {
       if(existeixPlaneta(p.Consultar_id())) throw new Exception("Error: ja existeix un planeta amb aquest nom");
       if(!existeixPlanetaCoordenades(p.consultar_X(), p.consultar_Y()) && dintreLimitUsuari(p.consultar_X(), p.consultar_Y())) { // No hay ningun planeta en las coordenadas que hemos puesto y estan dentro del limite
            planetes.add(p);
       }
       else {
            Random rnd = new Random();
            int rndX = rnd.nextInt(N);
            int rndY = rnd.nextInt(N);
            boolean b = existeixPlanetaCoordenades(rndX, rndY);
            boolean c = dintreLimitUsuari(rndX, rndY);
            if(!c) throw new Exception("Error: les coordenades del planeta no estan dintre del limit imposat");
            if(!b && c) {
                p.modificarCoordenades(rndX, rndY); // modifico coordenadas del planeta
                planetes.add(p);
            }
            else throw new Exception("Error: les coordenades estan ocupades per un altre planeta");
       }
    }
 
  
    // Pre: Cert
    // Post: La galaxia conte tots els planetes incials menys el planeta amb nom "nomplaneta" i les rutes que el conectaven juntament amb les naus que hi estaven albergades
    public void eliminarPLaneta(int idplaneta) throws Exception
    {
    	if(!existeixPlaneta(idplaneta)) throw new Exception("El planeta introduit no existeix");
        Planeta p = consultarPlaneta(idplaneta);

        Iterator<Integer> it;
        TreeSet<Integer> rutas_a_borrar = p.consultarRutasConecta();
        it = rutas_a_borrar.iterator();
        while(it.hasNext()) {
        	eliminarRuta(it.next());
        }
        TreeSet<Integer> naus_a_borrar = p.ConsultarLNaves();
        it = naus_a_borrar.iterator();
        while(it.hasNext()) {
        	eliminarNau(it.next());
        }
        
        Iterator<Planeta> it1 = planetes.iterator();
        Planeta a;
        while(it1.hasNext()) {
        	a = it1.next();
        	if(a.Consultar_id() == idplaneta) planetes.remove(a);
        }

    }
    // Pre: Cert
    // Post: S'eborren tots els planetes del parametre implicit/galaxia
    public void eliminarTotsPlanetes() throws Exception
    {
    	if(planetes.isEmpty()) throw new Exception("No hi ha planetes en la galaxia");
        planetes.clear();
    }
  
    // Pre: Cert
    // Post: S'afegeix a la llista de naus la nau n
    public void afegirNau(Nave n) throws Exception
    {
        if(existeixNau(n.consultar_id())) throw new Exception("Error: ja existeix una nau amb aquest nom");
        naus.add(n);
    }
  
    // Pre: Cert
    // Post: La galaxia conte totes les naus inicials menys la nau amb nom "nomnau"
    public void eliminarNau(int idnau) throws Exception
    {
    	if(!existeixNau(idnau)) throw new Exception("La nau introduida no existeix");
    	Iterator<Nave> it = naus.iterator();
    	Nave n;
    	while(it.hasNext()) {
    		n = it.next();
    		if(n.consultar_id() == idnau) naus.remove(n);
    	}
    }
    // Pre: Cert
    // Post: S'eborren totes les naus del parametre implicit/galaxia
    public void eliminarTotesNaus() throws Exception
    {
    	if(naus.isEmpty()) throw new Exception("No hi ha naus en la galaxia");
        naus.clear();
    }
  
    // Pre: Cert
    // Post: S'afegeix a la llista de rutes la ruta r
    public void afegirRuta(Ruta r) throws Exception
    {
        if(existeixRuta(r.consultar_id())) throw new Exception("Error: ja existeix una ruta amb aquest nom");
        rutes.add(r);
    }
    // Pre: Cert
    // Post: La galaxia conte totes les rutes inicials menys la ruta amb nom "nomruta"
    public void eliminarRuta(int idruta) throws Exception
    {
    	if(!existeixRuta(idruta)) throw new Exception("La ruta introduida no existeix");
    	Iterator<Ruta> it = rutes.iterator();
    	Ruta r;
    	while(it.hasNext()) {
    		r = it.next();
    		if(r.consultar_id() == idruta) rutes.remove(r);
    	}
    }
    // Pre: Cert
    // Post: S'eborren totes les rutes del parametre implicit/galaxia
    public void eliminarTotesRutes() throws Exception
    {
    	if(rutes.isEmpty()) throw new Exception("No hi ha rutes en la galaxia");
        rutes.clear();
    }
    // Pre: Cert
    // Post: S'eborren totes les rutes, les naus, els planetes i el presupost del parametre implicit/galaxia
	public void eliminarContingutGalaxia() throws Exception
    {
        eliminarTotsPlanetes();
        eliminarTotesNaus();
        eliminarTotesRutes();
        presupost = Integer.valueOf(-1);
    }
}

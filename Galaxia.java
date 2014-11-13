import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/** EN CASO DE QUE QUIERA QUE QUITE LO DE REPETIDOS:  HashSet hs = new HashSet(); hs.addAll(array); array.clear(); array.addAll(hs); */
 
public class Galaxia {
	
    private String nomGalaxia;
    private int[][] gal; // N*N
    private Integer presupost;
    private TreeSet<Integer> planetes; 
    private TreeSet<Integer> rutes;
    private TreeSet<Integer> naus;
    private Integer N; // valor del limit de la galaxia, posem algun limit com 10 (matriu 10x10)
    private List<Pair<Integer,Integer> > limits; // private list<pairs> con coordenadas de la galaxia impuestas por el usuario
    
    // Pre: Cierto
    // Post: Devuelve cierto si "nom" contiene caracteres alfanumericos y un tamaÃ±o menor a 20 caracteres, falso en caso contrario
    /**
     * Metodo que dice si el nombre es alfanumerico
     * @param nom
     * @return Cierto si "nom" contiene caracteres alfanumericos y un tamaÃ±o menor a 20 caracteres, falso en caso contrario
     */
    private boolean alfa_numeric(String nom) // NOM ALFANUMERIC I < 20 CARACTERS
    {
        if(nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for(int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if(!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
    
    // Pre: No hay coordenades repetidas
    // Post: Devuelve cierto si todas las coordenadas son colindantes entre ellas, falso en caso contrario
    /**
     * Metodo que indica si las coordenadas que forman el limite de la galaxia son colindantes o no
     * @param pai
     * @return Cierto si "pai" no contiene coordenadas colindantes, falso en caso contrario 
     * @throws Exception
     */
    private boolean consultarConfrontantsTotes(List<Pair<Integer, Integer> > pai) throws Exception
    {
		int Size = pai.size();
        boolean res = true;
        if(!pai.isEmpty()) {
            List<Pair<Boolean, Boolean> > tr = new ArrayList<Pair<Boolean, Boolean> >();
            for(int i = 0; i < Size; ++i) {
            	Pair<Boolean, Boolean> b = new Pair<Boolean, Boolean>(false, false);
            	tr.add(b);     	
            }
            int tmp;
            for(int i = 0; i < Size; ++i) {
                Integer a = pai.get(i).consultarPrimero();
                Integer b = pai.get(i).consultarSegundo();
                Pair<Integer, Integer> pa = new Pair<Integer, Integer>(a, b);
                if(pa.consultarPrimero() > N || pa.consultarSegundo() > N ) throw new Exception("Error: las coordenadas que dan forma a la galaxia no pueden ser mayores que el limite de la galaxia");
                if(pa.consultarPrimero() < 0 || pa.consultarSegundo() < 0) throw new Exception("Error: las coordenades que dan forma a la galaxia no pueden ser menores que 0");
                tmp = i;
                for(int j = 0; (j < Size && (!tr.get(i).consultarPrimero() || !tr.get(i).consultarSegundo())); ++j) {
                	if(i != j && j != tmp) {
                        if((((pa.consultarPrimero().intValue() + 1) == pai.get(j).consultarPrimero().intValue()) || ((pa.consultarPrimero().intValue() - 1) == pai.get(j).consultarPrimero().intValue()) || (pa.consultarPrimero().intValue() == pai.get(j).consultarPrimero().intValue())) && ((pa.consultarSegundo().intValue() + 1 == pai.get(j).consultarSegundo().intValue()) || (pa.consultarSegundo().intValue() - 1 == pai.get(j).consultarSegundo().intValue()) || (pa.consultarSegundo().intValue() == pai.get(j).consultarSegundo().intValue()))) {
                        	tmp = j;
    	                    if(tr.get(i).consultarPrimero().booleanValue() == true) {
    	                    	tr.get(i).ponSegundo(true);
    	                    }
    	                    else {
    	                    	tr.get(i).ponPrimero(true);
    	                    }
                    }
                }
            }
         }
         for(int i = 0; i < tr.size(); ++i) { 
        	if(tr.get(i).consultarPrimero().booleanValue() == false || tr.get(i).consultarSegundo().booleanValue() == false) {
                res = false;
                break;
            }
         }
        }
        return res;
    }

    // Pre: Cierto
	// Post: Devuelve cierto si las coordenadas "x" y "y" se encuentran dentro del limite impuesto por el usuario, falso en caso contrario
    /**
     * Metodo que indica si unas ciertas coordenadas estan dentro del limite formado en la galaxia
     * @param x
     * @param y
     * @return Cierto si "x" y "y" estan dentro del limite formado en la galaxia, falso en caso contrario
     * @throws Exception
     */
	private boolean dintreLimitUsuari(int x, int y) throws Exception
	{
	     if(x > N || y > N) throw new Exception("Error: las coordenadas no pueden ser mayores que el limite de la galaxia");
	         int max_first, max_second, max_x, max_y;
	         max_first = max_second = max_x = max_y = 0;
	         for(int i = 0; i < N; ++i) {
	         	if(gal[x][i] == -1 && i != x) { // Primero que encuentre paro
	         		max_first = i;
	         		break;
	         	}
	         }
	         for(int i = max_first + 1; i < N; ++i) {
	         	if(gal[x][i] == -1 && i != x) max_second = i; // Tengo que consultar hasta el ultimo, no break
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
	 
	// Pre: Cierto
	// Post: En las posiciones en las que habia un planeta, desaparecen (se pone a 0)
	/**
	 * Metodo para reiniciar los valores de la matriz, en aquellas posiciones en las que habia un planeta, este desaparece
	 */
	private void reiniciaMatriu()
	{
		 for(int i = 0; i < N; ++i) {
			 for(int j = 0; j < N; ++j) {
				 if(gal[i][j] > 0) gal[i][j] = 0;
			 }
		 }
	 }
    
    // Pre: Cierto
    // Post: Inicia las posiciones indicadas por el usuario con -1
	/**
	 * Metodo para marcar el limite que forma la galaxia
	 */
    private void inicialitzaMatriu()
    {
    	for(int i = 0; i < limits.size(); ++i) {
    		int a = limits.get(i).consultarPrimero().intValue();
    		int b = limits.get(i).consultarSegundo().intValue();
    		gal[a][b] = -1;
    	}
    }
    
    // Pre: Cierto
    // Post: Devuelve cierto si "l" no tiene elementos repetidos, falso en caso contrario
    /**
     * Metodo que comprueba que no haya coordenadas repetidas
     * @param l
     * @return Cierto si no hay coordenadas repetidas, falso en caso contrario
     */
    private static boolean comprovaRepetits(List<Pair<Integer, Integer> > l)
    {
    	for(int i = 0; i < l.size(); ++i) {
    		for(int j = i+1; j < l.size(); ++j) {
    			if((l.get(j).consultarPrimero().equals(l.get(i).consultarPrimero())) && (l.get(j).consultarSegundo().equals(l.get(i).consultarSegundo()))) return true;
    		}
    	}
    	return false;
    }
    
    // Pre: Cierto
    // Post: Devuelve el valor minimo de la coordenada x y tambien de la coordenada y, del limite impuesto por el usuario
    /**
     * Metodo para consultar las coordenadas menores del limite que forma la galaxia
     * @return La minima "x" y la minima "y" de las coordenadas que forman el limite de la galaxia
     */
    private Pair<Integer, Integer> menorXY()
    {
    	Integer first = limits.get(0).consultarPrimero();
    	Integer second = limits.get(0).consultarSegundo();
    	for(int i = 1; i < limits.size(); ++i) {
    		if(limits.get(i).consultarPrimero() < first) first = limits.get(i).consultarPrimero();
    		if(limits.get(i).consultarSegundo() < second) second = limits.get(i).consultarSegundo();
    	}
    	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(first,second);
    	return pa;
    }
    
    // Pre: Cierto
    // Post: Devuelve el valor maximo de la coordenada x y tambien de la coordenada y, del limite impuesto por el usuario
    /**
     * Metodo para consultar las coordenadas maximas del limite que forma la galaxia
     * @return La maxima "x" y la maxima "y" de las coordenadas que forman el limite de la galaxia
     */
    private Pair<Integer, Integer> majorXY()
    {
    	Integer first = limits.get(0).consultarPrimero();
    	Integer second = limits.get(0).consultarSegundo();
    	for(int i = 1; i < limits.size(); ++i) {
    		if(limits.get(i).consultarPrimero() > first) first = limits.get(i).consultarPrimero();
    		if(limits.get(i).consultarSegundo() > second) second = limits.get(i).consultarSegundo();
    	}
    	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(first,second);
    	return pa;
    }
    
    // Pre: Cierto
    // Post: Devuelve un numero aleatorio entre "min" y "max"
    /**
     * Metodo para devolver un numero aleatorio en un rango delimitado por [min..max]
     * @param min
     * @param max
     * @return Un valor aleatorio entre "min" y "max"
     */
    private int randInt(int min, int max)
    {
    	Random rand = new Random();
    	int randomNum = rand.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
    
    // CONSTRUCTORAS
  
    // Pre: Cierto
    // Post: Se crea una galaxia vacia
    /*public Galaxia()
    {
        nomGalaxia = "";
        //gal = new int[N][]; 
        presupost = new Integer(-1); 
        planetes = new TreeSet<Planeta>(new OrdenPlaneta()); 
        rutes = new TreeSet<Ruta>(new OrdenRuta());
        naus = new TreeSet<Nave>(new OrdenNave());
        //N = 0;
        limits = new ArrayList<Pair<Integer,Integer> >();
    }*/
    
    // Pre: Cierto
    // Post: Se crea una galaxia con nomGalaxia "nom" i N "n"
    /**
     * Metodo para construir una galaxia sin ningun tipo de limite/forma con un determinado nombre y limite maximo
     * @param nom
     * @param n
     * @throws Exception
     */
    public Galaxia(String nom, int n) throws Exception // no tendra limites por el usuario
    {
        if(!alfa_numeric(nom)) throw new Exception("Error: el nombre de la galaxia tiene que estar formado por letras o numeros y con menos de 20 caracteres");
        if(n < 10) throw new Exception("Error: el limite de la galaxia tiene que ser mayor o igual que 10");
        nomGalaxia = nom;
        presupost = new Integer(-1);
        planetes = new TreeSet<Integer>();
        rutes = new TreeSet<Integer>();
        naus = new TreeSet<Integer>();
        N = new Integer(n);
        limits = new ArrayList<Pair<Integer,Integer> >();
        gal = new int[n][n]; // inicializo a 0
    }
    
    // Pre: Cierto
    // Post: Se crea una galaxia con nomGalaxia "nom", N "n" y limits "l"
    /**
     * Metodo para construir una galaxia con una forma, un nombre y un limite determinado
     * @param nom
     * @param n
     * @param l
     * @throws Exception
     */
    public Galaxia(String nom, int n, List<Pair<Integer, Integer> > l) throws Exception // tendra limites por el usuario
    {
        if(!alfa_numeric(nom)) throw new Exception("Error: el nombre de la galaxia tiene que estar formado por letras o numeros y con menos de 20 caracteres");
        if(n < 10) throw new Exception("Error: el limite de la galaxia tiene que ser mayor o igual que 10");
        if(l.size() < 4) throw new Exception("Error: como minimo se tiene que tener 4 coordenadas para dar forma a la galaxia");
        nomGalaxia = nom;
        N = new Integer(n);
        if(comprovaRepetits(l)) throw new Exception("Error: las coordenadas que dan forma a la galaxia no pueden tener coordenadas repetidas");
        if(!consultarConfrontantsTotes(l)) throw new Exception("Error: las coordenadas dan forma a la galaxia no son colindantes");
        limits = l;
        presupost = new Integer(-1);
        planetes = new TreeSet<Integer>();
        rutes = new TreeSet<Integer>();
        naus = new TreeSet<Integer>();
        gal = new int[n][n]; // inicializo a 0
        inicialitzaMatriu(); // inicializo los limites del usuario en la matriz
    }
  
    // CONSULTORAS
  
    // Pre: Cierto
    // Post: Devuelve el nombre de la galaxia
    /**
     * Metodo para consultar el nombre de la galaxia
     * @return El nombre de la galaxia
     */
    public String consultarNomGalaxia()
    {
        return nomGalaxia;
    }
    
    // Pre: Cierto
    // Post: Devuelve el presupuesto de la galaxia
    /**
     * Metodo para consultar el presupuesto de la galaxia
     * @return El presupuesto de la galaxia
     * @throws Exception
     */
    public Integer consultarPresupost() throws Exception
    {
    	if(presupost == -1) throw new Exception("Error: la galaxia no tiene un presupuesto asignado");
        return presupost;
    }
    
    // Pre: Cierto
    // Post: Devuelve el conjunto de identificadores de los planetas existentes en la galaxia
    /**
     * Metodo para consultar el conjunto de planetas existentes en la galaxia
     * @return Conjunto de identificadores de planetas en la galaxia
     * @throws Exception
     */
    public ArrayList<Integer> consultarPlanetes() throws Exception
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Iterator<Integer> it = planetes.iterator();
        while(it.hasNext()) {
        	res.add(it.next());
        }
        return res;
    }
    
    // Pre: Cierto
    // Post: Devuelve el numero de planetas que hay en la galaxia
    /**
     * Metodo para consultar el numero de planetas que hay en la galaxia
     * @return El numero de planetas en la galaxia
     */
    public int consulta_nombrePlanetes()
    {
        return planetes.size();
    }
    
    // Pre: Cierto
    // Post: Devuelve el numero de coordenadas que forman el limite de la galaxia
    /**
     * Metodo para consultar el numero de coordenadas que dan forma a la galaxia
     * @return Numero de coordenadas que dan forma a la galaxia
     */
    public int consulta_nombreLimits()
    {
        return limits.size();
    }
    
    // Pre: Cierto
    // Post: Devuelve las coordenadas que forman el limite de la galaxia
    /**
     * Metodo para consultar las coordenadas que dan forma a la galaxia
     * @return Coordenadas que dan forma a la galaxia
     * @throws Exception 
     */
    public List<Pair<Integer, Integer> > consultarValorLimits() throws Exception
    {
    	if(limits.size() < 1) throw new Exception("La galaxia no tiene coordenadas que le den forma");
    	return limits;
    }
    
    // Pre: Cierto
    // Post: Devuelve el conjunto de identificadores de rutas de la galaxia
    /**
     * Metodo para consultar el conjunto de rutas existentes en la galaxia
     * @return Conjunto de identificadores de rutas en la galaxia
     * @throws Exception
     */
    public ArrayList<Integer> consultarRutes() throws Exception
    {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	Iterator<Integer> it = rutes.iterator();
        while(it.hasNext()) {
        	res.add(it.next());
        }
        return res;
  
    }
    
    // Pre: Cierto
    // Post: Devuelve el numero de rutas que hay en la galaxia
    /**
     * Metodo para consultar el numero de rutas existentes en la galaxia
     * @return Numero de rutas que hay en la galaxia
     */
    public int consulta_nombreRutes()
    {
        return rutes.size();
    }
    
    // Pre: Cierto
    // Post: Devuelve el conjunto de identificadores de naves de la galaxia
    /**
     * Metodo para consultar el conjunto de naves existentes en la galaxia
     * @return Conjunto de identificadores de naves en la galaxia
     * @throws Exception
     */
    public ArrayList<Integer> consultarNaus() throws Exception
    {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	Iterator<Integer> it = naus.iterator();
        while(it.hasNext()) {
        	res.add(it.next());
        }
        return res;
    }
    
    // Pre: Cierto
    // Post: Devuelve el numero de naves que hay en la galaxia
    /**
     * Metodo para consultar el numero de naves existentes en la galaxia
     * @return Numero de naves en la galaxia
     */
    public int consulta_nombreNaus()
    {
        return naus.size();
    }
    
    // Pre: Cierto
    // Post: Devuelve el valor del limite de la galaxia
    /**
     * Metodo para consultar el limite maximo de la galaxia
     * @return Limite maximo de la galaxia
     */
    public Integer consultarLimitGalaxia()
    {
        return N;
    }
     
    // Pre: Cierto
    // Post: Devuelve cierto si existe un planeta en las coordenadas "x" y "y", falso en caso contrario
    /**
     * Metodo para consultar si existe un planeta en unas determinadas coordenadas
     * @param x
     * @param y
     * @return Cierto si hay un planeta en las coordenadas "x" y "y", falso en caso contrario
     * @throws Exception
     */
    public boolean existeixPlanetaCoordenades(int x, int y) throws Exception
    {
        if(x > N || y > N) throw new Exception("Error: las coordenadas no pueden ser mayores que el limite de la galaxia");
        if(x < 0 || y < 0) throw new Exception("Error: las coordenadas no pueden ser menores que 0");
        if(!dintreLimitUsuari(x,y)) throw new Exception("Error: las coordenadas no pueden estar fuera del limite que da forma a la galaxia");
        
        return (gal[x][y] > 0);
    }
        
    // Pre: Cierto
    // Post: Devuelve cierto si existe un planeta con identificador "idplaneta" en la galaxia
    /**
     * Metodo para consultar si existe un planeta en la galaxia
     * @param idplaneta
     * @return Cierto si existe el planeta con identificador "idplaneta" en la galaxia, falso en caso contrario
     * @throws Exception
     */
    public boolean existeixPlaneta(int idplaneta) throws Exception
    {
    	return planetes.contains(idplaneta);
    }
        
    // Pre: Cierto
    // Post: Devuelve cierto si existe una ruta con identificador "idruta" en la galaxia
    /**
     * Metodo para consultar si existe una ruta en la galaxia
     * @param idruta
     * @return Cierto si existe la ruta con identificador "idruta" en la galaxia, falso en caso contrario
     * @throws Exception
     */
    public boolean existeixRuta(int idruta) throws Exception
    {
    	return rutes.contains(idruta);
    }
    
    // Pre: Cierto
    // Post: Devuelve cierto si existe una nave con identificador "idnau" en la galaxia
    /**
     * Metodo para consultar si existe una nave en la galaxia
     * @param idnau
     * @return Cierto si existe la nave con identificador "idnau" en la galaxia, falso en caso contrario
     * @throws Exception
     */
    public boolean existeixNau(int idnau) throws Exception
    {
    	return naus.contains(idnau);
    }
  
    // MODIFICADORAS
  
    // Pre: Cierto
    // Post: La galaxia tiene de nombre "nom"
    /**
     * Metodo para modificar el nombre de la galaxia
     * @param nom
     * @throws Exception
     */
    public void modificar_nomGalaxia(String nom) throws Exception
    {
        if(!alfa_numeric(nom)) throw new Exception("Error: el nombre de la galaxia tiene que estar formado por letras o numeros y con menos de 20 caracteres");
        nomGalaxia = nom;
    }
    
    // Pre: Cierto
    // Post: La galaxia tiene de presupuesto "p"
    /**
     * Metodo para modificar el presupuesto de la galaxia
     * @param p
     * @throws Exception
     */
    public void modificarPresupost(int p) throws Exception
    {
        if(p < 0) throw new Exception("Error: el presupuesto no puede ser negativo");
        presupost = Integer.valueOf(p);
    }
    
    // Pre: Cierto
    // Post: La galaxia tiene de limite N "n", sin ningun tipo de limite impuesto por el usuario
    /**
     * Metodo para modificar el limite maximo de la galaxia borrando la antigua forma que tenia esta
     * @param n
     * @throws Exception
     */
    public void modificarN(int n) throws Exception
    {
        if(!planetes.isEmpty()) throw new Exception("Error: no se puede modificar el limite de una galaxia que contiene planetas");
        if(n < 10) throw new Exception("Error: el limite de una galaxia tiene que ser mayor que 10");
        
        N = Integer.valueOf(n);
        gal = new int[N][N];
        limits = new ArrayList<Pair<Integer,Integer> >(); // Pierde los limites que tenia
    }
    
    // Pre: Cierto
    // Post: La galaxia te uns nous limits indicats per p
    /**
     * Metodo para modificar el limite que da forma a la galaxia
     * @param p
     * @throws Exception
     */
    public void modificarLimitsUsuari(List<Pair<Integer, Integer> > p) throws Exception
    {
    	if(p.size() < 4) throw new Exception("Error: como minimo se tiene que tener 4 coordenadas para dar forma a la galaxia");
    	if(comprovaRepetits(p)) throw new Exception("Error: las coordenadas que forman dan forma a la galaxia no pueden tener coordenadas repetidas");
    	if(!consultarConfrontantsTotes(p)) throw new Exception("Error: las coordenadas que dan forma a la galaxia no son colindantes");
    	limits = p;
    	gal = new int[N][N]; // Para reiniciar los valores que tenia, lo pongo a 0
    	inicialitzaMatriu();
    }
    
    // Pre: Cierto
    // Post: Se anade en lista de identificadores de planetas de la galaxia el identificador del planeta "p"
    /**
     * Metodo para aÃ±adir un planeta en la galaxia en unas determinadas coordenadas
     * @param p
     * @throws Exception
     */
    public void afegirPlaneta(Planeta p, int x, int y) throws Exception
    {
    	if(existeixPlaneta(p.Consultar_id())) throw new Exception("Error: ya existe un planeta con este identificador");
    	boolean b = existeixPlanetaCoordenades(x,y); // true si hay uno
    	if(b) throw new Exception("Error: las coordenades del planeta ya estan ocupadas por otro planeta");
    	if(limits.size() > 0) { 	// tiene forma
    		boolean c = dintreLimitUsuari(x,y); // true si esta
    		if(!c) throw new Exception("Error: las coordenades del planeta no estan dentro del limite impuesto que da forma a la galaxia");
    	}
    	p.modificarCoordenades(x, y);
    	planetes.add(p.Consultar_id());
    	gal[x][y] = p.Consultar_id();
    }	
   
    // Pre: Cierto
    // Post: Se aÃ±ade en lista de identificadores de planetas de la galaxia el identificador del planeta "p" y devuelve las coordenadas del planeta
    /**
     * Metodo para aÃ±adir un planeta en la galaxia
     * @param p
     * @return Las coordenadas del planeta 
     * @throws Exception
     */
    public Pair<Integer, Integer> afegirPlanetaAutomatic(Planeta p) throws Exception // Viene con unos valores random, aqui compruebo su validez
    {
    	if(existeixPlaneta(p.Consultar_id())) throw new Exception("Error: ya existe un planeta con este identificador");
    	
    	if(limits.size() > 0) { // Galaxia con limites impuestos
		    Pair<Integer, Integer> pa = menorXY();
		    Pair<Integer, Integer> pa1 = majorXY();
		    int rndX = randInt(pa.consultarPrimero().intValue(), pa1.consultarPrimero().intValue());
		    int rndY = randInt(pa.consultarSegundo().intValue(), pa1.consultarSegundo().intValue());
		    boolean b = existeixPlanetaCoordenades(rndX, rndY);
		    boolean c = dintreLimitUsuari(rndX, rndY);
		    if(!c) throw new Exception("Error: las coordenades del planeta no estan dentro del limite impuesto que da forma a la galaxia");
		    if(b) throw new Exception("Error: las coordenades del planeta ya estan ocupadas por otro planeta");
		    Pair<Integer, Integer> par = new Pair<Integer, Integer>(rndX, rndY);
    		planetes.add(p.Consultar_id());
    		gal[rndX][rndY] = p.Consultar_id();
    		return par;
    	}
    	else { // Galaxia sin limites
    		int rndX = randInt(0,N);
    		int rndY = randInt(0,N);
    		boolean b = existeixPlanetaCoordenades(rndX, rndY);
    		if(b) throw new Exception("Error: las coordenades del planeta ya estan ocupadas por otro planeta");
    		Pair<Integer, Integer> par = new Pair<Integer, Integer>(rndX, rndY);
    		planetes.add(p.Consultar_id());
    		gal[rndX][rndY] = p.Consultar_id();
    		return par;
    	}
    }
     
    // Pre: Cierto
    // Post: La galaxia contiene los identificadores de los planetas iniciales menos el identificador del planeta "p", los identificadores de las rutas que conecta y de las naves que contiene este
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param p
     * @throws Exception
     */
    public void eliminarPLaneta(Planeta p) throws Exception
    {
    	if(!existeixPlaneta(p.Consultar_id())) throw new Exception("El planeta introducido no existe en la galaxia");
    	
        TreeSet<Integer> rutas_a_borrar = p.consultarRutasConecta();
        Iterator<Integer> it = rutas_a_borrar.iterator();
        while(it.hasNext()) {
        	eliminarRuta(it.next());
        }
        /*TreeSet<Integer> naus_a_borrar = p.ConsultarLNaves();
        it = naus_a_borrar.iterator();
        while(it.hasNext()) {
        	eliminarNau(it.next());
        }*/
        Pair<Integer, Integer> co = p.consultar_coordenades();
        gal[co.consultarPrimero()][co.consultarSegundo()] = 0;
        planetes.remove(p.Consultar_id());
    }
    
    // Pre: Cierto
    // Post: Se borran todos los planetas de la galaxia
    /**
     * Metodo para eliminar todos los planetas de la galaxia
     * @throws Exception
     */
    public void eliminarTotsPlanetes() throws Exception
    {
    	if(planetes.isEmpty()) throw new Exception("No hay planetas en la galaxia");
        planetes.clear();
        reiniciaMatriu(); // borra planetas pero no la forma
    }
  
    // Pre: Cierto
    // Post: Se anade el identificador de la nave "idnave" en la lista de naves
    /**
     * Metodo para anadir una nave en la galaxia
     * @param idNave
     * @throws Exception
     */
    public void afegirNau(int idNave) throws Exception
    {
        if(existeixNau(idNave)) throw new Exception("Error: ya existe una nave con este identificador");
        naus.add(idNave);
    }
  
    // Pre: Cierto
    // Post: La galaxia contiene las anves iniciales menos la que tiene como identificador "idnau"
    /**
     * Metodo para eliminar una nave de la galaxia
     * @param idnau
     * @throws Exception
     */
    public void eliminarNau(int idnau) throws Exception
    {
    	if(!existeixNau(idnau)) throw new Exception("La nave introducida no existe");
    	naus.remove(idnau);
    }
    
    // Pre: Cierto
    // Post: Se borran todas las naves de la galaxia
    /**
     * Metodo para eliminar todas las naves de la galaxia
     * @throws Exception
     */
    public void eliminarTotesNaus() throws Exception
    {
    	if(naus.isEmpty()) throw new Exception("No hay naves en la galaxia");
        naus.clear();
    }
  
    // Pre: Cierto
    // Post: Se anade el identificador de la la ruta con identificador "idRuta" en la lista de rutas
    /**
     * Metodo para anadir una ruta en la galaxia
     * @param idRuta
     * @throws Exception
     */
    public void afegirRuta(int idRuta) throws Exception
    {
        if(existeixRuta(idRuta)) throw new Exception("Error: ya existe una ruta con este identificador");
        rutes.add(idRuta);
    }
    
    // Pre: Cierto
    // Post: La galaxia contiene todas las rutas iniciales menos la ruta con identificador "idruta"
    /**
     * Metodo para eliminar una ruta de la galaxia
     * @param idruta
     * @throws Exception
     */
    public void eliminarRuta(int idruta) throws Exception
    {
    	if(!existeixRuta(idruta)) throw new Exception("Error: no existe ninguna ruta con este identificador");
    	rutes.remove(idruta);
    }
    
    // Pre: Cierto
    // Post: Se borran todas las rutas de la galaxia
    /**
     * Metodo para eliminar todas las rutas de la galaxia
     * @throws Exception
     */
    public void eliminarTotesRutes() throws Exception
    {
    	if(rutes.isEmpty()) throw new Exception("No hay rutas en la galaxia");
        rutes.clear();
    }
    
    // Pre: Cierto
    // Post: Se borra el contenido de la galaxia: los planetas, las naves, los planetas y el presupuesto
    /**
     * Metodo para eliminar todo el contenido de la galaxia menos el limite maximo
     * @throws Exception
     */
	public void eliminarContingutGalaxia() throws Exception
    {
        eliminarTotsPlanetes();
        eliminarTotesNaus();
        eliminarTotesRutes();
        presupost = Integer.valueOf(-1);
        // Pierde los planetas y los limites
        limits = new ArrayList<Pair<Integer,Integer> >();
        N = 0;
        gal = new int[N][N];
    }
}

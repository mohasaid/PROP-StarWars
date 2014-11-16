import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Galaxia {
	
    private String nomGalaxia;
    private int[][] gal;
    private Integer presupost;
    private Integer N;
    private List<Pair<Integer,Integer> > limits;
    
    /**
     * Metodo que dice si el nombre es alfanumerico
     * @param nom
     * @return Cierto si "nom" contiene caracteres alfanumericos y un tamano menor a 20 caracteres, falso en caso contrario
     */
    private boolean alfa_numeric(String nom)
    {
        if(nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for(int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if(!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
     
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
    
    /**
     * Metodo para construir una galaxia sin ningun tipo de limite/forma con un determinado nombre y limite maximo
     * @param nom
     * @param n
     * @throws Exception
     */
    public Galaxia(String nom, int n) throws Exception 
    {
        if(!alfa_numeric(nom)) throw new Exception("Error: el nombre de la galaxia tiene que estar formado por letras o numeros y con menos de 20 caracteres");
        if(n < 10) throw new Exception("Error: el limite de la galaxia tiene que ser mayor o igual que 10");
        nomGalaxia = nom;
        presupost = new Integer(-1);
        N = new Integer(n);
        limits = new ArrayList<Pair<Integer,Integer> >();
        gal = new int[n][n];
    }
    
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
        limits = l;
        presupost = new Integer(-1);
        gal = new int[n][n]; 
        inicialitzaMatriu();
    }
  
    // CONSULTORAS
  
    /**
     * Metodo para consultar el nombre de la galaxia
     * @return El nombre de la galaxia
     */
    public String consultarNomGalaxia()
    {
        return nomGalaxia;
    }
    
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
    
    
    /**
     * Metodo para consultar el numero de coordenadas que dan forma a la galaxia
     * @return Numero de coordenadas que dan forma a la galaxia
     */
    public int consulta_nombreLimits()
    {
        return limits.size();
    }
    
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

    /**
     * Metodo para consultar el limite maximo de la galaxia
     * @return Limite maximo de la galaxia
     */
    public Integer consultarLimitGalaxia()
    {
        return N;
    }
     
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
        
    /**
     * Metodo para consultar si existe un planeta en la galaxia con identificador "idplaneta"
     * @param idplaneta
     * @return Cierto si existe el planeta con identificador "idplaneta" en la galaxia, falso en caso contrario
     * @throws Exception
     */
    public boolean existeixPlaneta(int idplaneta) throws Exception
    {
    	for(int i = 0; i < N; ++i) {
    		for(int j = 0; j < N; ++j) {
    			if(gal[i][j] == idplaneta) return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Metodo para consultar si existe algun planeta en la galaxia
     * @return
     */
    public boolean algunPlaneta() {
    	for(int i = 0; i < N; ++i) {
    		for(int j = 0; j < N; ++j) {
    			if(gal[i][j] > 0) return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Metodo que indica si unas ciertas coordenadas estan dentro del limite formado en la galaxia
     * @param x
     * @param y
     * @return Cierto si "x" y "y" estan dentro del limite formado en la galaxia, falso en caso contrario
     * @throws Exception
     */
    public boolean dintreLimitUsuari(int x, int y) throws Exception
	{
	     if(x > N || y > N) throw new Exception("Error: las coordenadas no pueden ser mayores que el limite de la galaxia");
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

  
    // MODIFICADORAS
  
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
    
    /**
     * Metodo para modificar el limite maximo de la galaxia borrando la antigua forma que tenia esta
     * @param n
     * @throws Exception
     */
    public void modificarN(int n) throws Exception
    {
        if(algunPlaneta()) throw new Exception("Error: no se puede modificar el limite de una galaxia que contiene planetas");
        if(n < 10) throw new Exception("Error: el limite de una galaxia tiene que ser mayor que 10");
        
        N = Integer.valueOf(n);
        gal = new int[N][N];
        limits = new ArrayList<Pair<Integer,Integer> >(); // Pierde la forma que tenia
    }
    
    /**
     * Metodo para modificar el limite que da forma a la galaxia
     * @param p
     * @throws Exception
     */
    public void modificarLimitsUsuari(List<Pair<Integer, Integer> > p) throws Exception
    {
    	if(p.size() < 4) throw new Exception("Error: como minimo se tiene que tener 4 coordenadas para dar forma a la galaxia");
    	limits = p;
    	gal = new int[N][N];
    	inicialitzaMatriu();
    }
    
    public void modificarIDplaneta(int x, int y, int idnova) throws Exception
    {
    	if(existeixPlaneta(idnova)) throw new Exception("Error: ya existe un planeta con este identificador");
    	gal[x][y] = idnova;
    }
    
    /**
     * Metodo para anadir un planeta en la galaxia en unas determinadas coordenadas
     * @param p
     * @throws Exception
     */
    public void afegirPlaneta(int idPlaneta, int x, int y) throws Exception
    {
    	if(existeixPlaneta(idPlaneta)) throw new Exception("Error: ya existe un planeta con este identificador");
    	boolean b = existeixPlanetaCoordenades(x,y);
    	if(b) throw new Exception("Error: las coordenades del planeta ya estan ocupadas por otro planeta");
    	if(limits.size() > 0) {
    		boolean c = dintreLimitUsuari(x,y);
    		if(!c) throw new Exception("Error: las coordenades del planeta no estan dentro del limite impuesto que da forma a la galaxia");
    	}
    	gal[x][y] = idPlaneta;
    }	
   
    /**
     * Metodo para anadir un planeta en la galaxia
     * @param p
     * @return Las coordenadas del planeta 
     * @throws Exception
     */
    public Pair<Integer, Integer> afegirPlanetaAutomatic(int idPlaneta) throws Exception
    {
    	if(existeixPlaneta(idPlaneta)) throw new Exception("Error: ya existe un planeta con este identificador");
    	
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
    		gal[rndX][rndY] = idPlaneta;
    		return par;
    	}
    	else { // Galaxia sin limites
    		int rndX = randInt(0,N);
    		int rndY = randInt(0,N);
    		boolean b = existeixPlanetaCoordenades(rndX, rndY);
    		if(b) throw new Exception("Error: las coordenades del planeta ya estan ocupadas por otro planeta");
    		Pair<Integer, Integer> par = new Pair<Integer, Integer>(rndX, rndY);
    		gal[rndX][rndY] = idPlaneta;
    		return par;
    	}
    }
     
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param p
     * @throws Exception
     */
    public void eliminarPLaneta(Planeta p) throws Exception
    {
    	if(!existeixPlaneta(p.Consultar_id())) throw new Exception("El planeta introducido no existe en la galaxia");
        Pair<Integer, Integer> co = p.consultar_coordenades();
        gal[co.consultarPrimero()][co.consultarSegundo()] = 0;
    }
    
    /**
     * Metodo para eliminar un paneta de la galaxia con el identificador "idPlaneta"
     * @param idPlaneta
     * @throws Exception 
     */
    public void eliminarPlaneta(int idPlaneta) throws Exception
    {
    	boolean esta = false;
    	for(int i = 0; i < N; ++i) {
    		for(int j = 0; j < N; ++j) {
    			if(gal[i][j] == idPlaneta) {
    				gal[i][j] = 0;
    				esta = true;
    			}
    		}
    	}
    	if(!esta) throw new Exception("El planeta introducido no existe en la galaxia");
    }
    
    /**
     * Metodo para eliminar todos los planetas de la galaxia
     * @throws Exception
     */
    public void eliminarTotsPlanetes() throws Exception
    {
    	if(!algunPlaneta()) throw new Exception("No hay planetas en la galaxia");
        reiniciaMatriu(); // borra planetas pero no la forma
    }
  
    /**
     * Metodo para eliminar todo el contenido de la galaxia menos el limite maximo
     * @throws Exception
     */
	public void eliminarContingutGalaxia() throws Exception
    {
        presupost = Integer.valueOf(-1);
        limits = new ArrayList<Pair<Integer,Integer> >();
        gal = new int[N][N];
    }
}

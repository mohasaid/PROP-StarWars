import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ControladorPlaneta {
    private TST<Planeta> listaPlanetas;
    private ControladorDadesPlaneta cdp;
    private static int id = 0;
    private static final String nomG = "Planeta";
    
    /**
     * Metodo para conseguir un numero aleatorio
     * @param min
     * @param max
     */
    private int randInt(int min, int max)
    {
    	Random rand = new Random();
    	int randomNum = rand.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
    /**
     * Metodo para comprobar si un string contiene caracteres alfanumericos
     * @param nom
     */
    
    /**
     * Metodo para crear un controlador de planeta
     */
    public ControladorPlaneta()
    {
        listaPlanetas = new TST<Planeta>();
    }
    /**
     * Metodo para anadir un planeta a la listaPlanetas
     * @param p
     * @throws Exception
     */
    public void anadirPlaneta(Planeta p) throws Exception
    {
    	listaPlanetas.add(p.Consultar_nombre(),p);
    }
    /**
     * Metodo para comprobar la existencia de un planeta
     * @param idP
     * @throws Exception
     */
    public boolean ExistePlaneta(String idP) throws Exception 
    {
    	return listaPlanetas.contains(idP);
    }
    /**
     * Metodo que retorna un Planeta dedo el nombre del planeta.
     * @param id
     * @throws Exception
     */
    public Planeta BuscarPlaneta(String id) throws Exception
    {
		return listaPlanetas.buscar(id);   
    }
    /**
     * Metodo para crear un Planeta automatico.
     * @param cg
     * @throws Exception
     */
    public void PlanetaAuto(ControladorGalaxia cg) throws Exception 
    {
    	int r1 = randInt(0,Integer.MAX_VALUE-1);
    	
		String seg = Integer.toString(id);
		String f = nomG + seg;
		while(listaPlanetas.contains(f)) {
			++id;
			seg = Integer.toString(id);
			f = nomG + seg;
		}
		
        String a11 = cg.afegirPlanetaAutomatic();

        Scanner scan = new Scanner(a11);
		scan.useDelimiter(",");
		Integer a1 = scan.nextInt();
		Integer a2 = scan.nextInt();
		Pair<Integer, Integer> co_nuevas = new Pair<Integer, Integer>(a1,a2);
		
        Planeta p = new Planeta(f, r1, co_nuevas);
        listaPlanetas.add(f,p);
        scan.close();
    }
    /**
     * Metodo para crear un Planeta aleatorio con nombre
     * @param id
     * @param cg
     * @throws Exception
     */
    public void PlanetaAuto(String id, ControladorGalaxia cg) throws Exception 
    {
    	if(ExistePlaneta(id)) throw new Exception("Ya existe un planeta co este identificador");
    	
    	int r1 = randInt(0,Integer.MAX_VALUE-1);
    	
    	String a11 = cg.afegirPlanetaAutomatic();
		Scanner scan = new Scanner(a11);
		scan.useDelimiter(",");
		Integer a1 = scan.nextInt();
		Integer a2 = scan.nextInt();
		Pair<Integer, Integer> co_nuevas = new Pair<Integer, Integer>(a1,a2);
		
        Planeta p = new Planeta(id, r1, co_nuevas);
        listaPlanetas.add(id,p);
        scan.close();
    }
    
    /**
     * Metodo para crear un Planeta
     * @param id
     * @param k
     * @param Coo
     * @param cg
     * @throws Exception
     */
    public void Planeta(String id, int k, Pair<Integer,Integer> Coo, ControladorGalaxia cg) throws Exception 
    {
        if(ExistePlaneta(id)) throw new Exception("Ya existe un planeta co este identificador");
        
        //cg.afegirPlaneta(Coo.consultarPrimero(), Coo.consultarSegundo());
        Planeta p = new Planeta (id, k, Coo);
        listaPlanetas.add(id, p);
        
    }
    /**
     * Metodo para consultar el coste de un Planeta
     * @param id
     * @throws Exception
     */
    public int Consultar_Coste(String id) throws Exception 
    {
        return BuscarPlaneta(id).Consultar_Coste();
    }
    
    /**
     * Metodo para consultar las coordenadas de un planeta
     * @param id
     * @throws Exception
     */
    public Pair<Integer,Integer> Consultar_Coordenadas(String id) throws Exception
    {
        return BuscarPlaneta(id).consultar_coordenades();
    }
    
    /**
     * Metodo para consultar la coordenada X de un planeta
     * @param id
     * @throws Exception
     */
    public int consultar_X(String id) throws Exception
    {
        return BuscarPlaneta(id).consultar_X();
    }
    
    /**
     * Metodo para consultar la coordenada Y de un planeta
     * @param id
     * @throws Exception
     */
    public int consultar_Y(String id) throws Exception
    {
        return BuscarPlaneta(id).consultar_Y();
    }
    /**
     * Metodo para cosnultar el size de listaPlanetas
     * @throws Exception
     */
    public int Consultar_Size() 
    {
        return listaPlanetas.size();
    }
    /**
     * Metodo para consultar listaPlanetas
     * @throws Exception
     */
    public String Consultar_listaPlanetas() throws Exception
    {
    	String res = ""	;
    	ArrayList<String> lp = listaPlanetas.ConsultarIdentificadores();
    	for(int i = 0; i < listaPlanetas.size(); ++i) res += lp.get(i)+"-";
    	res +="\n";
    	return res;
    }
    /**
     * Metodo para consultar listaPlanetas
     * @throws Exception
     */
    public ArrayList<String> consultarPlanetas() throws Exception
    {
    	return listaPlanetas.ConsultarIdentificadores();
    }
    /**
     * Metodo para consultar el planeta en la posicion x
     * @param x
     * @throws Exception
     */
    public Planeta Consultar_PlanetaX(int x) throws Exception {
        return listaPlanetas.MostrarElementos().get(x);
    }
    /**
     * Metodo para modificar el coste de un Planeta
     * @param id
     * @param k
     * @throws Exception
     */
    public void Modificar_Coste(String id, int k) throws Exception 
    {
        BuscarPlaneta(id).Modificar_Coste(k);
    }
    
    /**
     * Metodo para modificar las coordenadas de un planeta
     * @param id
     * @param x
     * @param y
     * @param cg
     * @throws Exception
     */
    public void modificar_coordenadas(String id, int x, int y, ControladorGalaxia cg) throws Exception
    {
    	Planeta a = BuscarPlaneta(id);
    	int c1 = a.consultar_X();
    	int c2 = a.consultar_Y();
    	cg.afegirPlaneta(x, y);
    	cg.eliminarPlaneta(c1, c2);
    	a.modificarCoordenades(x, y);
    }
    /**
     * Metodo para borrar listaPlanetas
     * @throws Exception
     */
    public void BorrarTodos() throws Exception 
    {
    	listaPlanetas.clear();
    }
    /**
     * Metodo para cargar Planetas
     * @param path
     * @param cg
     * @throws Exception
     */
    public void CargarPlanetas (String path, ControladorGalaxia cg) throws Exception 
    {
    	BorrarTodos();
    	
    	String res, s, id;
    	cdp.AbrirLectura(path);
    	FileReader file = new FileReader(path);
    	BufferedReader buffer = new BufferedReader(file);
    	Scanner sc;
    	int k, x, y;
    	while((res = cdp.cargar(path,100,buffer))!= "") {
    		sc = new Scanner(res);
    		sc.useDelimiter("#|:");
    		s = "";
    		if(sc.hasNext()) s = sc.next();
    		while(sc.hasNext()){
				id = sc.next();
				s = sc.next();
				k = Integer.parseInt(s);
				s = sc.next();
				x = Integer.parseInt(s);
				s = sc.next();
				y = Integer.parseInt(s);
				sc.next();
				Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(x,y);
				cg.afegirPlaneta(x, y);
				Planeta p = new Planeta(id,k,Coo);
				listaPlanetas.add(id,p);
    		}
    	}
    	cdp.CerrarLectura();
    }
    
    /**
     * Metodo para guardar Planetas
     * @param path
     * @throws Exception
     */
    public void GuardarPlanetas (String path) throws Exception 
    {
    	String res ="";
    	int iter = 0;
    	if(!listaPlanetas.isEmpty()){
    		cdp.AbrirEscritura(path);
    		res = "";
    		for(Planeta p : listaPlanetas.MostrarElementos()) {
    			res +=p.Consultar_nombre()+":";
    			res +=p.Consultar_Coste()+":";
    			res +=p.consultar_X()+":";
    			res +=p.consultar_Y();
    			res +="#";
    			++iter;
    			if(iter == 100){
    				cdp.guardar(path, res);
    				iter = 0;
    				res ="";
    			}
    		}
    	}
    	if(res != ""){
    		cdp.guardar(path, res);
    		cdp.CerrarEscritura();
    	}
    }
    /**
     * Metodo para consultar todos los planetas con su configuracion
     * @throws Exception
     */
    
    public String consultarTODO() throws Exception {
    	String res ="";
    	for(Planeta p : listaPlanetas.MostrarElementos()) {
			res +=p.Consultar_nombre()+":";
			res +=p.Consultar_Coste()+":";
			res +=p.consultar_X()+":";
			res +=p.consultar_Y();
			res +="#";
		}
    	return res;
    }
}

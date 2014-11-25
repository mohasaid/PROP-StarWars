import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ControladorPlaneta {
	
    private TreeSet<Planeta> listaPlanetas;
    private ControladorDadesPlaneta cdp;
    private static int id = 0;
    private static final String nomG = "Planeta";
    
    private int randInt(int min, int max)
    {
    	Random rand = new Random();
    	int randomNum = rand.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
    
    private boolean alfa_numeric(String nom)
    {
        if(nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for(int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if(!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
    
    //Pre: Cierto.
    //Post: Crea un ControladorPlaneta.
    public ControladorPlaneta()
    {
        listaPlanetas = new TreeSet<Planeta>(new OrdenPlaneta());
    }
    
    public void anadirPlaneta(Planeta p) throws Exception
    {
    	if(ExistePlaneta(p.Consultar_nombre())) throw new Exception("Ya hay un planeta con este identificador");
    	listaPlanetas.add(p);
    }
    //Pre: Cierto.
    //Post: Retorna true si el planeta existe y false si no.
    public boolean ExistePlaneta(String idP) throws Exception 
    {
        Iterator<Planeta> it = listaPlanetas.iterator();
        while(it.hasNext()) {
            if(it.next().Consultar_nombre().compareTo(idP) == 0) return true;
        }
        return false;
    }
    
    public void BorraPla(String idPlaneta) throws Exception
    {
    	Iterator<Planeta> it = listaPlanetas.iterator();
    	Planeta p = null;
    	while(it.hasNext()) {
    		p = it.next();
    		if(p.Consultar_nombre().compareTo(idPlaneta) == 0) it.remove();
    	}
    }
    
    //Pre: Cierto.
    //Post: Retorna un Planeta con idedentificador "id".
    public Planeta BuscarPlaneta(String id) throws Exception
    {
        Iterator<Planeta> it = listaPlanetas.iterator();
        Planeta p;
        while(it.hasNext()) {
        	p = it.next();
            if (p.Consultar_nombre().compareTo(id) == 0) return p;
        }
		return null;   
    }
    //Pre: Cierto.
    //Post: Crea un planeta automaticamente con atributos aleatorios incluida la id
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
        
		Scanner sc = new Scanner(a11);
		sc.useDelimiter(",");
		Integer a1 = sc.nextInt();
		Integer a2 = sc.nextInt();
		Pair<Integer, Integer> co_nuevas = new Pair<Integer, Integer>(a1,a2);
		
        Planeta p = new Planeta(f, r1, co_nuevas);
        listaPlanetas.add(p);
        sc.close();
    }
    
    public void PlanetaAuto(String id, ControladorGalaxia cg) throws Exception 
    {
    	if(ExistePlaneta(id)) throw new Exception("Error: Existe un planeta con ese nombre");
    	
    	int r1 = randInt(0,Integer.MAX_VALUE-1);
    	
    	String a11 = cg.afegirPlanetaAutomatic();
		Scanner sc = new Scanner(a11);
		sc.useDelimiter(",");
		Integer a1 = sc.nextInt();
		Integer a2 = sc.nextInt();
		Pair<Integer, Integer> co_nuevas = new Pair<Integer, Integer>(a1,a2);
		
        Planeta p = new Planeta(id, r1, co_nuevas);
        listaPlanetas.add(p);
        sc.close();
    }
    
    //Pre: Cierto.
    //Post: Crea un planeta con idPlaneta = id, Capacidad = c, Coste = k, Coordenadas = Coo, Fuente = F y Sumidero = S.
    public void Planeta(String id, int k, Pair<Integer,Integer> Coo, ControladorGalaxia cg) throws Exception 
    {
        if(ExistePlaneta(id)) throw new Exception ("Error: La id del planeta ya existe");
        if(!alfa_numeric(id)) throw new Exception("Error: El nombre de un Planeta tiene que ser alfanumerico");
        
        Planeta p = new Planeta (id, k, Coo);
        listaPlanetas.add(p);
        cg.afegirPlaneta(Coo.consultarPrimero(), Coo.consultarSegundo());
    }
    
    //Pre: Cierto.
    //Post: Retorna el Coste del planeta.
    public int Consultar_Coste(String id) throws Exception 
    {
        return BuscarPlaneta(id).Consultar_Coste();
    }
    
    //Pre: Cierto.
    //Post: Retorna las Coordenadas del planeta.
    public Pair<Integer,Integer> Consultar_Coordenadas(String id) throws Exception
    {
        return BuscarPlaneta(id).consultar_coordenades();
    }
    
    //Pre: Cierto.
    //Post: Retorna la coordenada X del planeta.
    public int consultar_X(String id) throws Exception
    {
        return BuscarPlaneta(id).consultar_X();
    }
    
    //Pre: Cierto.
    //Post: Retorna la coordenada Y del planeta.
    public int consultar_Y(String id) throws Exception
    {
        return BuscarPlaneta(id).consultar_Y();
    }
    
    //Pre: Cierto.
    //Post: Retorna el tamanio de listaPlanetas.
    public int Consultar_Size() 
    {
        return listaPlanetas.size();
    }
    
    //Pre: Cierto.
    //Post: Retorna listaPlanetas.
    public String Consultar_listaPlanetas() throws Exception
    {
    	String res;
    	Iterator<Planeta> it = listaPlanetas.iterator();
    	res = "";
    	while (it.hasNext()) {
    			res += "-" + it.next().Consultar_nombre();
    	}
    	res += "\n";
        return res;
    }
    
    public ArrayList<String> consultarPlanetas() throws Exception
    {
    	ArrayList<String> pl = new ArrayList<String>();
    	Iterator<Planeta> it = listaPlanetas.iterator();
    	while(it.hasNext()) {
    		pl.add(it.next().Consultar_nombre());
    	}
    	return pl;
    }
    
    //Pre: 0 <= X < listaPlanetas.size().
    //Post: Consulta el elemento X de la listaPlanetas en caso de que exista
    public Planeta Consultar_PlanetaX(int x) throws Exception {
        if (listaPlanetas.isEmpty()) throw new Exception("Error: No existe ningun planeta");
        
        Iterator<Planeta> it = listaPlanetas.iterator();
        int n = 0;
        Planeta a = null;
        while(n != x) {
                a = it.next();
                ++n;
        }
        a = it.next();
        return a;
    }
    
    //Pre: Cierto.
    //Post: Modifica el coste del planeta.
    public void Modificar_Coste(String id, int k) throws Exception 
    {
        BuscarPlaneta(id).Modificar_Coste(k);
    }
    
    //Pre: Cierto.
    //Post: Borra el planeta.
    public void Borrar(String id, ControladorRuta cr) throws Exception 
    {
        Planeta p = BuscarPlaneta(id);
        listaPlanetas.remove(p);
        cr.BorrarRutaConexions(id);
    }
    
    public void BorrarTodos() throws Exception 
    {
    	listaPlanetas.clear();
    }
    
  //Pre: Cierto.
    //Post: 
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
    			if(Integer.parseInt(s)==0) {
    				id = sc.next();
    				s = sc.next();
    				k = Integer.parseInt(s);
    				s = sc.next();
    				x = Integer.parseInt(s);
    				s = sc.next();
    				y = Integer.parseInt(s);
    				sc.next();
					Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(x,y);
					Planeta p = new Planeta(id,k,Coo);
					listaPlanetas.add(p);
					cg.afegirPlaneta(x, y);
    			}
    		}
    	}
    	cdp.CerrarLectura();
    }
    
    //Pre: Cierto.
    //Post: 
    public void GuardarPlanetas (String path) throws Exception 
    {
    	String res ="";
    	int iter = 0;
    	if(!listaPlanetas.isEmpty()){
    		cdp.AbrirEscritura(path);
    		res = "";
    		for(Planeta p : listaPlanetas) {
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
    
    
    public String consultarTODO() throws Exception {
    	String res ="";
    	for(Planeta p : listaPlanetas) {
			res +=p.Consultar_nombre()+":";
			res +=p.Consultar_Coste()+":";
			res +=p.consultar_X()+":";
			res +=p.consultar_Y();
			res +="#";
		}
    	return res;
    }
}

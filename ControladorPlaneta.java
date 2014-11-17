import java.util.*;


public class ControladorPlaneta {
    private TreeSet<Planeta> listaPlanetas;
    private ControladorDadesPlaneta cdp;
    
    private int randInt(int min, int max)
    {
    	Random rand = new Random();
    	int randomNum = rand.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
    
    //Pre: Cierto.
    //Post: Crea un ControladorPlaneta.
    public ControladorPlaneta()
    {
        listaPlanetas = new TreeSet<Planeta>(new OrdenPlaneta());
    }
    
    public void anadirPlaneta(Planeta p) throws Exception
    {
    	if(ExistePlaneta(p.Consultar_id())) throw new Exception("Ya hay un planeta con este identificador");
    	listaPlanetas.add(p);
    }
    //Pre: Cierto.
    //Post: Retorna true si el planeta existe y false si no.
    public boolean ExistePlaneta(int idP) throws Exception 
    {
        Iterator<Planeta> it = listaPlanetas.iterator();
        while(it.hasNext()) {
            if (it.next().Consultar_id() == idP) return true;
        }
        return false;
    }
    
    public void BorraPla(int idPlaneta) throws Exception
    {
    	Iterator<Planeta> it = listaPlanetas.iterator();
    	Planeta p = null;
    	while(it.hasNext()) {
    		p = it.next();
    		if(p.Consultar_id() == idPlaneta) it.remove();
    	}
    }
    //Pre: Cierto.
    //Post: Retorna un Planeta con idedentificador "id".
    public Planeta BuscarPlaneta(int id) throws Exception
    {
    	if(!ExistePlaneta(id)) throw new Exception ("Error: No existe ningun Planeta con esta id");
        Iterator<Planeta> it = listaPlanetas.iterator();
        Planeta p = new Planeta();
        while(it.hasNext()) {
        	p = it.next();
            if (p.Consultar_id() == id) return p;
        }
		return null;   
    }
    //Pre: Cierto.
    //Post: Crea un planeta automaticamente con atributos aleatorios incluida la id
    public void PlanetaAuto(ControladorGalaxia cg) throws Exception 
    {
    	int r1 = randInt(0,Integer.MAX_VALUE-1);
        int idP = 1;
        while(ExistePlaneta(idP)) ++idP;
        Pair<Integer, Integer> co_nuevas = cg.afegirPlanetaAutomatic(idP);
        Planeta p = new Planeta(idP, r1, co_nuevas);
        p.modificarCoordenades(co_nuevas.consultarPrimero(), co_nuevas.consultarSegundo());
        listaPlanetas.add(p);
    }
    
    public void PlanetaAuto(int id, ControladorGalaxia cg) throws Exception 
    {
    	if(ExistePlaneta(id)) throw new Exception("Existe un planeta con ese identificador");
    	int r1 = randInt(0,Integer.MAX_VALUE-1);
        Pair<Integer, Integer> co_nuevas = cg.afegirPlanetaAutomatic(id);
        Planeta p = new Planeta(id, r1, co_nuevas);
        listaPlanetas.add(p);
    }
    //Pre: Cierto.
    //Post: Crea un planeta con idPlaneta = id, Capacidad = c, Coste = k, Coordenadas = Coo, Fuente = F y Sumidero = S.
    public void Planeta(int id, int k, Pair<Integer,Integer> Coo, ControladorGalaxia cg) throws Exception {
        if(ExistePlaneta(id)) throw new Exception ("Error: La id del planeta ya existe");
        if(id < 1) throw new Exception("El identificador ha de ser mayor que 0");
        Planeta p = new Planeta (id, k, Coo);
        listaPlanetas.add(p);
        cg.afegirPlaneta(id, Coo.consultarPrimero(), Coo.consultarSegundo());
    }
    //Pre: Cierto.
    //Post: Retorna el Coste del planeta.
    public int Consultar_Coste(int id) throws Exception 
    {
        return BuscarPlaneta(id).Consultar_Coste();
    }
    //Pre: Cierto.
    //Post: Retorna las Coordenadas del planeta.
    public Pair<Integer,Integer> Consultar_Coordenadas(int id) throws Exception
    {
        return BuscarPlaneta(id).consultar_coordenades();
    }
    //Pre: Cierto.
    //Post: Retorna la coordenada X del planeta.
    public int consultar_X(int id) throws Exception
    {
        return BuscarPlaneta(id).consultar_X();
    }
    //Pre: Cierto.
    //Post: Retorna la coordenada Y del planeta.
    public int consultar_Y(int id) throws Exception
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
    			res += " - " + it.next().Consultar_id();
    	}
    	res += "\n";
        return res;
    }
    
    public ArrayList<Integer> consultarPlanetas() throws Exception
    {
    	ArrayList<Integer> pl = new ArrayList<Integer>();
    	Iterator<Planeta> it = listaPlanetas.iterator();
    	while(it.hasNext()) {
    		pl.add(it.next().Consultar_id());
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
    //Post: Retorna todas las rutas que conectan con el Planeta id.
    public void consultarRutasConecta(int id, ControladorRuta cr) throws Exception{
    	System.out.println("Las Rutas que entran en el Planeta son: " + cr.Consultar_entrades_planeta(id));
    	System.out.println("Las Rutas que salen del Planeta son: " + cr.Consultar_sortides_planeta(id));
    }
    //Pre: Cierto.
    //Post: Modifica el coste del planeta.
    public void Modificar_Coste(int id, int k) throws Exception 
    {
        BuscarPlaneta(id).Modificar_Coste(k);
    }
    //Pre: Cierto.
    //Post: Modifica las coordenadas del planeta.
    public void modificarCoordenades(int id, int x, int y, ControladorGalaxia cg) throws Exception 
    {
    	Planeta p = BuscarPlaneta(id);
    	cg.eliminarPlaneta(id);
        p.modificarCoordenades(x,y);
        cg.afegirPlaneta(id, x, y);
    }
    //Pre: Cierto.
    //Post: Borra el planeta.
    public void Borrar(int id, ControladorGalaxia cg, ControladorRuta cr) throws Exception {
        Planeta p = BuscarPlaneta(id);
        listaPlanetas.remove(p);
        cr.BorrarRutaConexions(id);
        cg.eliminarPlaneta(p.Consultar_id());
        // p.Borrar();
    }
    
    public void BorrarTodos() throws Exception {
    	if(listaPlanetas.size() < 1) throw new Exception("No hay planetas");
    	listaPlanetas.clear();
    }
    
    //Pre: Cierto.
    //Post: 
    public void CargarPlanetas (String path, ControladorGalaxia cg) throws Exception {
    	String res;
    	cdp.AbrirLectura(path);
    	res = cdp.cargar(path);
    	Scanner sc = new Scanner(res);
    	sc.useDelimiter("#|:");
    	String s = "";
    	if(sc.hasNext()) s = sc.next();
    	int id, k, x, y; 
    	while(sc.hasNext()){
    		id = Integer.parseInt(s);
    		s = sc.next();
    		k = Integer.parseInt(s);
    		s = sc.next();
    		x = Integer.parseInt(s);
    		s = sc.next();
    		y = Integer.parseInt(s);
    		if(ExistePlaneta(id)) throw new Exception ("Error: El Planeta con identificador: " + id + " ya existe y no se cargara");
    		else {
    			Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(x,y);
    			Planeta p = new Planeta(id,k,Coo);
    			listaPlanetas.add(p);
    			cg.afegirPlaneta(id, x, y);
    		}
    		sc.next();
    	}
    	cdp.CerrarLectura();
    }
    
    //Pre: Cierto.
    //Post: 
    public void GuardarPlanetas (String path) throws Exception {
    	String res ="";
    	int iter = 0;
    	if(!listaPlanetas.isEmpty()){
    		cdp.AbrirEscritura(path);
    		res = "";
    		for(Planeta p : listaPlanetas) {
    			res +=p.Consultar_id()+":";
    			res +=p.Consultar_Coste()+":";
    			res +=p.consultar_X()+":";
    			res +=p.consultar_Y();
    			res +="#";
    			System.out.println(res);
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
}

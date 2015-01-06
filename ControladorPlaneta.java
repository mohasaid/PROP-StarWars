/**
 *
 * @author Moha
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ControladorPlaneta {
    private TST<Planeta> listaPlanetas;
    private ControladorDadesPlaneta cdp;
    private static int idp = 0;
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
        listaPlanetas = new TST<Planeta>();
        cdp = new ControladorDadesPlaneta();
    }
    
    public void anadirPlaneta(Planeta p) throws Exception
    {
    	listaPlanetas.add(p.Consultar_nombre(),p);
    }
    
    public int consultarIDTOTALES()
    {
        return idp;
    }
    
    //Pre: Cierto.
    //Post: Retorna true si el planeta existe y false si no.
    public boolean ExistePlaneta(String idP) throws Exception 
    {
    	return listaPlanetas.contains(idP);
    }
    
    public void BorraPla(String idPlaneta) throws Exception
    {
    	listaPlanetas.eliminar(idPlaneta);
    }
    
    //Pre: Cierto.
    //Post: Retorna un Planeta con idedentificador "id".
    public Planeta BuscarPlaneta(String id) throws Exception
    {
	return listaPlanetas.buscar(id);   
    }
    
    //Pre: Cierto.
    //Post: Crea un planeta automaticamente con atributos aleatorios incluida la id
    public String PlanetaAuto(ControladorGalaxia cg) throws Exception 
    {
    	int r1 = randInt(0,1000);
    	
        String seg = Integer.toString(idp);
        String f = nomG + seg;
        while(listaPlanetas.contains(f)) {
            ++idp;
            seg = Integer.toString(idp);
            f = nomG + seg;
        }
		
        String a11 = cg.afegirPlanetaAutomatic();

        Scanner scan = new Scanner(a11);
        scan.useDelimiter(",");
        Integer a1 = scan.nextInt();
        Integer a2 = scan.nextInt();
        Pair<Integer, Integer> co_nuevas = new Pair<Integer, Integer>(a1,a2);
	scan.close();
        
        Planeta p = new Planeta(f, r1, co_nuevas);
        listaPlanetas.add(f,p);
        scan.close();
        return a11;
    }
    
    public String PlanetaAuto(String id, ControladorGalaxia cg) throws Exception 
    {
    	if(!alfa_numeric(id)) throw new Exception("Error: El nombre de un Planeta tiene que ser alfanumerico");
    	if(ExistePlaneta(id)) throw new Exception("Ya existe un planeta co este identificador");
    	
    	int r1 = randInt(0,1000);
    	
    	String a11 = cg.afegirPlanetaAutomatic();
        
        Scanner scan = new Scanner(a11);
        scan.useDelimiter(",");
        Integer a1 = scan.nextInt();
        Integer a2 = scan.nextInt();
        Pair<Integer, Integer> co_nuevas = new Pair<Integer, Integer>(a1,a2);
	scan.close();
        
        Planeta p = new Planeta(id, r1, co_nuevas);
        listaPlanetas.add(id,p);
        scan.close();
        return a11;
    }
    
    //Pre: Cierto.
    //Post: Crea un planeta con idPlaneta = id, Capacidad = c, Coste = k, Coordenadas = Coo, Asiganado = A.
    public void Planeta(String id, int k, Pair<Integer,Integer> Coo, ControladorGalaxia cg) throws Exception 
    {
        if(!alfa_numeric(id)) throw new Exception("El nombre de un Planeta tiene que ser alfanumerico");
        if(ExistePlaneta(id)) throw new Exception("Ya existe un planeta co este identificador");
        if(k > 2000000000) throw new Exception("Coste demasiado elevado");
        
        cg.afegirPlaneta(Coo.consultarPrimero(), Coo.consultarSegundo());
        Planeta p = new Planeta (id, k, Coo);
        listaPlanetas.add(id, p);
        
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
    	String res = ""	;
    	ArrayList<String> lp = listaPlanetas.ConsultarIdentificadores();
    	for(int i = 0; i < listaPlanetas.size(); ++i) {
            res += lp.get(i)+ "-";
        }
    	res +="\n";
    	return res;
    }
    
    public ArrayList<String> consultarPlanetas() throws Exception
    {
    	return listaPlanetas.ConsultarIdentificadores();
    }
    
    //Pre: 0 <= X < listaPlanetas.size().
    //Post: Consulta el elemento X de la listaPlanetas en caso de que exista
    public Planeta Consultar_PlanetaX(int x) throws Exception {
        return listaPlanetas.MostrarElementos().get(x);
    }
    
    //Pre: Cierto.
    //Post: Modifica el coste del planeta.
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
    //Pre: Cierto.
    //Post: Borra el planeta.
    public void Borrar(String id, ControladorRuta cr, ControladorNave cn, ControladorGalaxia cg) throws Exception 
    {
    	Planeta p = listaPlanetas.buscar(id);
    	cg.eliminarPlaneta(p.consultar_X(), p.consultar_Y());
        cr.BorrarRutaConexions(id);
        cn.BorraNavesDestinoOrigen(id);
    	listaPlanetas.eliminar(id);
    }
    
    public void BorrarTodos(ControladorGalaxia cg) 
    {
        cg.eliminarPlanetes();
    	listaPlanetas.clear();
        idp = 0;
    }
    
  //Pre: Cierto.
    //Post: 
    public void CargarPlanetas(String path, ControladorGalaxia cg) throws Exception 
    {
    	BorrarTodos(cg);
        idp = 0;
        
    	String res = "";
    	cdp.AbrirLectura(path);
    	FileReader file = new FileReader(path);
    	BufferedReader buffer = new BufferedReader(file);
    	while((res = cdp.cargar(path,100,buffer))!= "") {
            Scanner cin = new Scanner(res);
            cin.useDelimiter(":|#");
            String s = "";
            while(cin.hasNext()){
                String id = cin.next();
                s = cin.next();
                Integer k = Integer.parseInt(s);
                s = cin.next();
                Integer x = Integer.parseInt(s);
                s = cin.next();
                Integer y = Integer.parseInt(s);
                Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(x,y);
                cg.afegirPlaneta(x, y);
                Planeta p = new Planeta(id,k,Coo);
                listaPlanetas.add(id,p);
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
        boolean primer = true;
    	if(!listaPlanetas.isEmpty()){
            cdp.AbrirEscritura(path);
            res = "";            
            for(Planeta p : listaPlanetas.MostrarElementos()) {
                if(primer) {
                    res += p.Consultar_nombre();
                    res += ":" + p.Consultar_Coste();
                    res += ":" + p.consultar_X();
                    res += ":" + p.consultar_Y();
                    primer = false;
                }
                else {
                    res += ":" + p.Consultar_nombre();
                    res += ":" + p.Consultar_Coste();
                    res += ":" + p.consultar_X();
                    res += ":" + p.consultar_Y();
                }
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

import java.util.*;

public class ControladorPlaneta{
    private TreeSet<Planeta> listaPlanetas;
    private ControladorRuta cr;
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
        cr = new ControladorRuta();
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
    public void PlanetaAuto() throws Exception 
    {
    	int r1 = randInt(0,Integer.MAX_VALUE);
    	int c1 = randInt(0,Integer.MAX_VALUE);
    	int c2 = randInt(0,Integer.MAX_VALUE);
        int idP = 0;
        while(ExistePlaneta(idP)) ++idP;
        Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(null, null);
        Coo.ponPrimero(c1);
        Coo.ponSegundo(c2);
        Random rb = new Random();
        boolean F;
        boolean S;
        F = rb.nextBoolean();
        S = rb.nextBoolean();
        Planeta p = new Planeta(idP, r1, Coo, F, S);
        listaPlanetas.add(p);
    }
    // Necesito una con un id por defecto y que solo cree sus atributos random
    public void PlanetaAuto(int id) throws Exception 
    {
    	int r1 = randInt(0,Integer.MAX_VALUE);
    	int c1 = randInt(0,Integer.MAX_VALUE);
    	int c2 = randInt(0,Integer.MAX_VALUE);
        Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(null, null);
        Coo.ponPrimero(c1);
        Coo.ponSegundo(c2);
        Random rb = new Random();
        boolean F;
        boolean S;
        F = rb.nextBoolean();
        S = rb.nextBoolean();
        Planeta p = new Planeta(id, r1, Coo, F, S);
        listaPlanetas.add(p);
    }
    //Pre: Cierto.
    //Post: Crea un planeta con idPlaneta = id, Capacidad = c, Coste = k, Coordenadas = Coo, Fuente = F y Sumidero = S.
    public void Planeta(int id, int k, Pair<Integer,Integer> Coo, boolean F, boolean S) throws Exception {
        if(ExistePlaneta(id)) throw new Exception ("Error: La id del planeta ya existe");
        Planeta p = new Planeta (id, k, Coo, F, S);
        listaPlanetas.add(p);
    }
    //Pre: Cierto.
    //Post: Retorna la Capacidad del planeta.
    public int Consultar_Capacidad(int id) throws Exception 
    {
        return BuscarPlaneta(id).Consultar_Capacidad();
    }
    //Pre: Cierto.
    //Post: Retorna el Coste del planeta.
    public int Consultar_Coste(int id) throws Exception 
    {
        return BuscarPlaneta(id).Consultar_Coste();
    }
    //Pre: Cierto.
    //Post: Retorna true si el planeta es fuente.
    public boolean Consultar_Fuente(int id) throws Exception
    {
    	return BuscarPlaneta(id).Consultar_Fuente();
    }
    //Pre: Cierto.
    //Post: Retorna true si el planeta es sumidero.
    public boolean Consultar_Sumidero(int id) throws Exception
    {
    	return BuscarPlaneta(id).Consultar_Sumidero();
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
    //Post: Retorna todas las rutas que salen y entran al planeta
    public TreeSet<Integer> consultarRutasConecta(int id) throws Exception 
    {
        return BuscarPlaneta(id).consultarRutasConecta();
    }
    //Pre: Cierto.
    //Post: Retorna la lista de rutas que salen del planeta.
    public TreeSet<Integer> Consultar_RutasSalida(int id) throws Exception 
    {
        return BuscarPlaneta(id).Consultar_RutasSalida();
    }
    //Pre: Cierto.
        //Post: Retorna la lista de rutas que entran en planeta.
    public TreeSet<Integer> Consultar_RutasEntrada(int id) throws Exception 
    {
        return BuscarPlaneta(id).Consultar_RutasEntrada();
    }
    //Pre: Cierto.
    //Post: Retorna el tamaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â±o de listaPlanetas.
    public int Consultar_Size() 
    {
        return listaPlanetas.size();
    }
    //Pre: Cierto.
    //Post: Retorna listaPlanetas.
    public TreeSet<Planeta> Consultar_listaPlanetas() 
    {
        return listaPlanetas;
    }
    //Pre: 0 <= X < listaPlanetas.size().
    //Post: Consulta el elemento X de la listaPlanetas en caso de que exista
    public Planeta Consultar_PlanetaX(int x) {
    	Iterator<Planeta> it = listaPlanetas.iterator();
        int n = 0;
        Planeta a = null;
    	while(n != x) {
    		a = it.next();
    		++n;
    	}
    	return a;
    }
    //Pre: Cierto.
    //Post: Modifica la id del planeta.
    public void Modificar_id (int idold, int idnew) throws Exception 
    {
        Planeta p = BuscarPlaneta(idold);
        listaPlanetas.remove(p);
        p.Modificar_id(idnew);
        listaPlanetas.add(p);
    }
    //Pre: Cierto.
    //Post: Modifica la capacidad del planeta.
    public void Modificar_Capacidad(int id, int c) throws Exception 
    {
        BuscarPlaneta(id).modificarCapacidad(c);
    }
    //Pre: Cierto.
    //Post: Modifica el coste del planeta.
    public void Modificar_Coste(int id, int k) throws Exception 
    {
        BuscarPlaneta(id).Modificar_Coste(k);
    }
    //Pre: Cierto.
    //Post: Modifica las coordenadas del planeta.
    public void modificarCoordenades(int id, int x, int y) throws Exception 
    {
        BuscarPlaneta(id).modificarCoordenades(x,y);
    }
    //Pre: Cierto.
    //Post: Anade la id de una ruta que sale del planeta a la lista de rutas que salen del planeta.
    public void Anadir_Salida(int idp, int id) throws Exception 
    {
        BuscarPlaneta(idp).Anadir_Salida(id);
    }
    //Pre: Cierto.
    //Post: Anande la id de una ruta que entra en el planeta a la lista de rutas que entran en el planeta.
    public void Anadir_Entrada(int idp, int id, ControladorRuta cr) throws Exception 
    {
        BuscarPlaneta(idp).Anadir_Entrada(id);
        int c = Consultar_Capacidad(idp);
        c = c + cr.ConsultarCapacidadRuta(id);
        Modificar_Capacidad(idp, c);
    }
    //Pre: Cierto.
    //Post: Borra una id de una ruta que sale del planeta  de la lista de rutas que salen del planeta.
    public void Borrar_Salida(int idp, int id) throws Exception 
    {
        BuscarPlaneta(idp).Borrar_Salida(id);
    }
    //Pre: Cierto.
    //Post: Borra una id de una ruta que entra en el planeta de la lista de rutas que entran en el planeta.
    public void Borrar_Entrada(int idp, int id, ControladorRuta cr) throws Exception 
    {
        BuscarPlaneta(idp).Borrar_Entrada(id);
        int c = Consultar_Capacidad(idp);
        c = c - cr.ConsultarCapacidadRuta(id);
        Modificar_Capacidad(idp, c);
    }
    //Pre: Cierto.
    //Post: Borra el planeta.
    public void Borrar(int id, ControladorRuta cr) throws Exception {
        Planeta p = BuscarPlaneta(id);
        if(!p.Consultar_Sumidero()) {
        	Iterator<Integer> it = p.Consultar_RutasSalida().iterator();
        	int idr;
        	while(it.hasNext()) {
        		idr = it.next();
        		if(cr.ConsultarBidireccionalidadRuta(idr)) p.Borrar_Entrada(idr);
        		cr.BorrarRuta_desdePlaneta(it.next());
        		p.Borrar_Salida(idr);
        	}
        }
        if(!p.Consultar_Sumidero()) {
        	Iterator<Integer> it1 = p.Consultar_RutasEntrada().iterator();
        	int idr;
        	while(it1.hasNext()) {
        		idr = it1.next();
        		cr.BorrarRuta_desdePlaneta(it1.next());
        		p.Borrar_Entrada(idr);
        	}
        }
        p.Borrar();
        listaPlanetas.remove(p);
    }
}

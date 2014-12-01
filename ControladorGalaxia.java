import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
 
public class ControladorGalaxia
{
    private Galaxia g;
    private ControladorDadesGalaxia cdg;
    private Iterator<Pair<Integer, Integer> > itp;
 
    //CONSTRUCTORAS
 
    /**
     * Metodo para crear el controlador de la galaxia, un controlador de datos y una galaxia con nombre y limite
     * @throws Exception 
     */
    public ControladorGalaxia() throws Exception 
    {
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
    
    /**
     * Metodo para consultar las coordenadas que dan forma a la galaxia
     * @return Las coordenadas que dan forma a la galaxia
     * @throws Exception
     */
    public String consultarLimitsGalaxia(int i) throws Exception
    {
    	String res = "";
    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
    	if(i == 0) itp = lp.iterator();
    	int j = 0;
    	while(itp.hasNext() && j < 100) {
    		Pair<Integer, Integer> a = itp.next();
    		res += "#" + a.consultarPrimero() + "," + a.consultarSegundo();
    		++j;
    	}
    	return res;
    }
    
    /**
     * Metodo para consultar el numero de coordenadas que dan forma a la galaxia
     * @return Numero de coordenadas que dan forma a la galxia
     */
    public int consultarNombreLimits()
    {
    	return g.consulta_nombreLimits();
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
     * @throws Exception 
     */
    public void modificarNom(String nomNou) throws Exception
    {
    	g.modificar_nomGalaxia(nomNou);
    }
    
    /**
     * Metodo para modificar el limite maximo de la galaxia
     * @param limitNou
     * @throws Exception 
     */
    public void modificarLimit(int limitNou) throws Exception
    {
    	g.modificarN(limitNou);
    }
    
    /**
     * Metodo para modificar la forma de la galaxia
     * @param lp
     * @throws Exception 
     */
    public void modificarLimits(List<Pair<Integer, Integer> > lp) throws Exception
    {
    	g.modificarLimitsUsuari(lp);
    }

    /**
     * Metodo para anadir un planeta en la galaxia en las coordenadas "x" y "y"
     * @param cp
     * @param idPlaneta
     * @param x
     * @param y
     * @throws Exception
     */
    public void afegirPlaneta(int x, int y) throws Exception
    {
    	g.afegirPlaneta(x,y);
    }
    
    /**
     * Metodo para anadir un planeta creado automaticamente
     * @param cp
     * @param idPlaneta
     * @returnDevuelve las coordenadas con las que se ha introducido en la galaxia
     * @throws Exception
     */
    public String afegirPlanetaAutomatic() throws Exception
    {
    	String res = "";
    	Pair<Integer, Integer> p = g.afegirPlanetaAutomatic();
    	res = p.consultarPrimero() + "," + p.consultarSegundo();
    	return res;
    }
    
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param idPlaneta
     * @param cp
     * @throws Exception
     */
    public void eliminarPlaneta(int x, int y) throws Exception
    {
	    g.eliminarPlaneta(x,y);
    }
    
    /**
     * Metodo para eliminar todos los plaentas de una galaxia
     * @throws Exception
     */
    public void eliminarPlanetes()
    {
    	g.eliminarTotsPlanetes();
    }
    
    /**
     * Metodo para transformar los elementos de la galaxia en un grafo
     * @throws Exception
     */
    public Entrada transformaGrafo(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn,  FuncionesCoste fc) throws Exception 
    {
    	Grafo g = new Grafo();
    	ArrayList<String> pl = cp.consultarPlanetas();
    	ArrayList<Conexion> ac = cr.Consultar_Conexiones();
    	
    	ArrayList<Conexion> ac1 = ac;
    	
    	int tam = ac.size();
    	for(int i = 0; i < tam; i++) {
    		Ruta r = cr.BuscarRuta(ac.get(i).consultar_id());
    		if(r.consultar_bidireccional()) {
    			String pA = ac.get(i).consultar_planetaA();
    			String pB = ac.get(i).consultar_planetaB();
    			Conexion c = new Conexion(r.consultar_id(),pB,pA);
    			ac1.add(c);
    		}
    	}
    	
    	int tam1 = ac1.size();
    	for(int i = 0; i < pl.size(); ++i) {
    		String idPlaneta = pl.get(i);
    		ArrayList<Pair<Arco, Integer> > ara = new ArrayList<Pair<Arco, Integer> >();
    		for(int j = 0; j < tam1; ++j) {
    			if(ac1.get(j).consultar_planetaA().compareTo(idPlaneta) == 0) {
    				int rut = ac1.get(j).consultar_id();
    				String pb = ac1.get(j).consultar_planetaB();
    				int tmp = pl.indexOf(pb);
    				Ruta r = cr.BuscarRuta(rut);
    				int cap = r.consultar_capacidad();
    				Arco arc = new Arco(cap);
    				if(fc instanceof FuncionFlujo) {
    					arc.ModificarCoste(fc.CalcularCoste());
    				}
    				else if(fc instanceof FuncionDistancia) {
    					fc.ModificarRuta(r);
    					arc.ModificarCoste(fc.CalcularCoste());
    				}
    				else if(fc instanceof FuncionPrecio) {
    					fc.ModificarRuta(r);
    					Planeta a = cp.BuscarPlaneta(pb);
    					fc.ModificarPlaneta(a);
    					arc.ModificarCoste(fc.CalcularCoste());
    				}
    				Pair<Arco, Integer> paira = new Pair<Arco, Integer>(arc,tmp);
    				int tama1 = ara.size();
    				int va = 0;
    				boolean anadido = false;
	    			for(int l = 0; l < tama1 && !anadido; l++) {
	    				if(ara.get(l).consultarPrimero().ConsultarCoste() > paira.consultarPrimero().ConsultarCoste()) {
	    					va = l;
	    					anadido = true;
	    				}
	    			}
	    			if(!anadido) va = ara.size();
	    			ara.add(va,paira);
    			}
    		}
    		g.ponG(ara);
    	}
    	
    	ArrayList<String> origenes = cn.PlanetasOrigen(); // Penultimo Nodo = nodo virtual -> origen general, size - 2
    	ArrayList<Pair<Arco, Integer> > apai = new ArrayList<Pair<Arco, Integer> >();
    	
    	for(int i = 0; i < origenes.size(); ++i) {
    		String o = origenes.get(i);
    		int tmp2 = pl.indexOf(o);
    		Arco c = new Arco(Integer.MAX_VALUE);
    		c.ModificarCoste(0);
    		Pair<Arco, Integer> pac = new Pair<Arco,Integer>(c,tmp2);
    		apai.add(pac);
    	}
    	g.ponG(apai);
    	
    	ArrayList<String> destinos = cn.PlanetasDestino(); // Ultimo nodo = nodo virtual -> destino general, size - 1
    	ArrayList<Pair<Arco,Integer>> nulo = new ArrayList<Pair<Arco, Integer> >();
    	g.ponG(nulo);
    	
    	int size_g = g.sizeGrafo();
    	
    	for(int i = 0; i < destinos.size(); ++i) {
    		String d = destinos.get(i);
    		int tmp3 = pl.indexOf(d);
    		Arco c = new Arco(Integer.MAX_VALUE);
    		c.ModificarCoste(0);
    		Pair<Arco, Integer> pac1 = new Pair<Arco,Integer>(c,size_g-1);
    		g.consultarCosteDestinos(tmp3).add(0, pac1);
    	}

    	Entrada ent = new Entrada(g);
    	return ent;
    }
    	
    /**
     * Metodo para cargar los elementos que forman la galaxia
     * @param directori
     * @param cp
     * @param cn
     * @param cr
     * @throws Exception
     */
    public void carregarConjuntGalaxia(String directori) throws Exception
    {
		g.eliminarTotsPlanetes(); // borro los planetas, el resto lo sobreescribo
		
		String result;
		cdg.AbrirLectura(directori);
		FileReader fr = new FileReader(directori);
		BufferedReader br = new BufferedReader(fr);
		boolean first = true;
		boolean tiene = false;
		String nomG = "";
		int N = 0;
		List<Pair<Integer, Integer> > lpa = new ArrayList<Pair<Integer,Integer> >();
		while((result = cdg.cargar(directori,100,br))!= "") {
			Scanner cin = new Scanner(result);
			cin.useDelimiter("#|,");
			String info = "";
			if(cin.hasNext()) info = cin.next();
			while(cin.hasNext()) {
				if(first) {
					nomG = info;
					info = cin.next();
					N = Integer.parseInt(info);
					first = false;
				}
				if(!cin.hasNext()) break;
				tiene = true;
				while(cin.hasNext()) {
					info = cin.next();
					Integer a = Integer.parseInt(info);
					info = cin.next();
					Integer b = Integer.parseInt(info);
					Pair<Integer,Integer> paird = new Pair<Integer,Integer>(a,b);
					lpa.add(paird);
				}
			}
			cin.close();
		}
		if(tiene) g = new Galaxia(nomG,N,lpa);
		else g = new Galaxia(nomG,N);
		
		cdg.CerrarLectura();
    }
    
    /**
     * Metodo para guardar los elementos que forman la galaxia
     * @param directori
     * @param cp
     * @param cr
     * @param cn
     * @throws Exception
     */
    public void guardarConjuntGalaxia(String directori) throws Exception
    {
    	cdg.AbrirEscritura(directori);
    	String result = "";
    	result += g.consultarNomGalaxia();
    	result += "#" + g.consultarLimitGalaxia();
    	int i = 0;
    	int n = g.consulta_nombreLimits();
    	if(n != 0) {
	    	while(i < n) {
	    		result += consultarLimitsGalaxia(i);
	    		i += 100;
	        	cdg.guardar(directori,result);
	        	result = "";
	    	}
    	}
    	else {
    		cdg.guardar(directori,result);
    	}
    	cdg.CerrarEscritura();
   	}
}

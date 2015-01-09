/**
 *
 * @author Moha
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
 
public class ControladorGalaxia
{
    private Galaxia g;
    private final ControladorDadesGalaxia cdg;
    private Iterator<Pair<Integer, Integer> > itp;
    private static final int arist = 2000000000;
 
    //CONSTRUCTORAS
 
    /**
     *  Metodo para crear el controlador de la galaxia, un controlador de datos
     */
    public ControladorGalaxia()
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
     * Metodo para consultar las coordenadas que dan forma a la galaxia, de 100 en 100
     * @param i
     * @return Las coordenadas que dan forma a la galaxia
     */
    public String consultarLimitsGalaxia(int i)
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
     */
    public int consultarLimit()
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
     * @param x
     * @param y
     * @throws Exception 
     */
    public void afegirPlaneta(int x, int y) throws Exception
    {
    	g.afegirPlaneta(x,y);
    }
    
    /**
     * Metodo para anadir un planeta automaticamente
     * @return Las coordenadas donde se ha situado, en caso de que haya sido posible
     * @throws Exception 
     */
    public String afegirPlanetaAutomatic() throws Exception
    {
    	String res;
    	Pair<Integer, Integer> p = g.afegirPlanetaAutomatic();
    	res = p.consultarPrimero() + "," + p.consultarSegundo();
    	return res;
    }
    
    /**
     * Metodo para eliminar un planeta de la galaxia
     * @param x
     * @param y
     * @throws Exception 
     */
    public void eliminarPlaneta(int x, int y) throws Exception
    {
	    g.eliminarPlaneta(x,y);
    }

    /**
     * Metodo para eliminar todos los planetas de una galaxia
     */
    public void eliminarPlanetes()
    {
    	g.eliminarTotsPlanetes();
    }
    
    /**
     * Metodo para transformar los elementos de una galaxia en un grafo
     * @param cr
     * @param cp
     * @param cn
     * @param fc
     * @return Grafo formado por los elementos de una galaxia
     * @throws Exception 
     */
    public Entrada transformaGrafo(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn,  FuncionesCoste fc) throws Exception 
    {
    	Grafo g = new Grafo();
    	ArrayList<String> pl = cp.consultarPlanetas();
    	ArrayList<Conexion> ac = cr.Consultar_Conexiones();
    	
    	ArrayList<Conexion> ac1 = ac;
    	int tam1 = ac1.size();
    	for(int i = 0; i < pl.size(); ++i) {
    		String idPlaneta = pl.get(i);
    		ArrayList<Pair<Arco, Integer> > ara = new ArrayList<>();
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
    				Pair<Arco, Integer> paira = new Pair<>(arc,tmp);
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
    	ArrayList<Pair<Arco, Integer> > apai = new ArrayList<>();
    	
    	for(int i = 0; i < origenes.size(); ++i) {
    		String o = origenes.get(i);
    		int tmp2 = pl.indexOf(o);
    		Arco c = new Arco(arist);
    		c.ModificarCoste(0);
    		Pair<Arco, Integer> pac = new Pair<>(c,tmp2);
    		apai.add(pac);
    	}
    	g.ponG(apai);
    	
    	ArrayList<String> destinos = cn.PlanetasDestino(); // Ultimo nodo = nodo virtual -> destino general, size - 1
    	ArrayList<Pair<Arco,Integer>> nulo = new ArrayList<>();
    	g.ponG(nulo);
    	
    	int size_g = g.sizeGrafo();
    	
    	for(int i = 0; i < destinos.size(); ++i) {
    		String d = destinos.get(i);
    		int tmp3 = pl.indexOf(d);
    		Arco c = new Arco(arist);
    		c.ModificarCoste(0);
    		Pair<Arco, Integer> pac1 = new Pair<>(c,size_g-1);
    		g.consultarCosteDestinos(tmp3).add(0, pac1);
    	}
        
    	Entrada ent = new Entrada(g);
    	return ent;
    }
    	

    /**
     * Metodo para cargar los elementos que forman la galaxia
     * @param directori
     * @throws Exception 
     */
    public void carregarConjuntGalaxia(String directori) throws Exception
    {		
        String result;
        cdg.AbrirLectura(directori);
        FileReader fr = new FileReader(directori);
        BufferedReader br = new BufferedReader(fr);
        boolean first = true;
        boolean tiene = false;
        String nomG = "";
        int N = 0;
        List<Pair<Integer, Integer> > lpa = new ArrayList<Pair<Integer,Integer> >();
        while(!(result = cdg.cargar(directori,100,br)).equals("")) {
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
                            Pair<Integer,Integer> paird = new Pair<>(a,b);
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

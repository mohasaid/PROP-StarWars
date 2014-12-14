package prop;
/**
 *
 * @author Moha
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorVistaGalaxia {
	private ControladorGalaxia cGalaxia;
	private VistaGalaxia vg;
	// private ControladorVistaMFP cVMFP;

	/*public void inicialitza(ControladorVistaMFP cvmp) 
	{
		cVMFP = cvmp;
	}*/
	
	ControladorVistaGalaxia()
	{
            cGalaxia = new ControladorGalaxia();
            vg = new VistaGalaxia(this); // paso el actual controladorvistagalaxia
	}
        
        public ControladorGalaxia consultarControladorGalaxia()
        {
            return cGalaxia;
        }
        
        public VistaGalaxia consultarVistaGalaxia()
        {
            return vg;
        }
	
	public void creaGalaxia(String nom, String n) throws Exception
	{
            int limit = Integer.parseInt(n);
            cGalaxia.creaGalaxia(nom, limit);
	}
	
	public void creaGalaxia2(String nom, String n, String limits) throws Exception // Entra un String
	{
            int limit = Integer.parseInt(n);

            List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            Scanner sca = new Scanner(limits);
            sca.useDelimiter(",");
            String info = "";

            info = sca.next();
            int pa_1 = Integer.parseInt(info);
            if(pa_1 > cGalaxia.consultarLimit() || pa_1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            info = sca.next();
            int pa_2 = Integer.parseInt(info);
            if(pa_2 > cGalaxia.consultarLimit() || pa_2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_1,pa_2);
            pa1.add(primero);  
                
            info = sca.next();
            int l1 = Integer.parseInt(info);
            if(l1 > cGalaxia.consultarLimit() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            info = sca.next();
            int l2 = Integer.parseInt(info);
            if(l2 > cGalaxia.consultarLimit() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");

            int limite1 = primero.consultarPrimero();
            int limite2 = primero.consultarSegundo();
            boolean trobat = false;
            while(sca.hasNext() && !trobat) {
                int size = pa1.size();
                int prim = pa1.get(size-1).consultarPrimero();
                int seg = pa1.get(size-1).consultarSegundo();

                if((((l1+1) == prim) || ((l1-1) == prim) || (l1 == prim)) && (((l2+1) == seg) || ((l2-1) == seg) || (l2 == seg))) {
                Pair<Integer, Integer> pa = new Pair<Integer, Integer>(l1, l2);
                pa1.add(pa);
                }
                else throw new Exception("Las coordenadas no son secuenciales");
                
                info = sca.next();
                l1 = Integer.parseInt(info);
                if(l1 > cGalaxia.consultarLimit() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                info = sca.next();
                l2 = Integer.parseInt(info);
                if(l2 > cGalaxia.consultarLimit() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
            sca.close();
            if(!trobat) throw new Exception("Las coordenadas no se cierran adecuadamente");
            cGalaxia.creaGalaxia2(nom, limit, pa1);
	}
		
	public String consultarNomGalaxia()
	{
		return cGalaxia.consultar_nom();
	}
	
	public boolean esPotModificarLimit()
	{
		return cGalaxia.algunPlaneta();
	}
	
	public int consultarLimit()
	{
		return cGalaxia.consultarLimit();
	}
	
	public String consultarLimits() throws Exception // devolver de 100 en 100 
	{
            int n = cGalaxia.consultarNombreLimits();
            String res = "";
            if(n > 0) {
                    int i = 0;
                    res += cGalaxia.consultarLimitsGalaxia(i);
                    i += 100;
            }
            else throw new Exception("La galaxia no tiene forma");
            String resultat = "";
            Scanner sca = new Scanner(res);
            sca.useDelimiter("#|,");
            String info = "";
            if(sca.hasNext()) resultat += sca.next();
            while(sca.hasNext()) {
                    info = sca.next();
                    resultat += "," + info;
            }
            sca.close();
            return resultat;
	}
	
	public int consultarNombreLimits()
	{
            return cGalaxia.consultarNombreLimits();
	}
	
	public boolean algunPlaneta()
	{
            return cGalaxia.algunPlaneta();
	}
	
	public boolean existeixPlanetaCoordenades(String x, String y) throws Exception
	{
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            return cGalaxia.existeixPlanetaCoordenades(x1, y1);
	}
	
	public boolean dintreLimitUsuari(String x, String y) throws Exception
	{
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            boolean b;
            if(cGalaxia.consultarNombreLimits() > 0) {
                    b = cGalaxia.dintreLimitUsuari(x1, y1);
            }
            else {
                    if((cGalaxia.consultarLimit() > x1 && x1 > 0) && (cGalaxia.consultarLimit() > y1 && y1 > 0)) b = true;
                    else b = false;
            }
            return b;
	}
	
	public void modificarNom(String nomNou) throws Exception
	{
            cGalaxia.modificarNom(nomNou);
	}
	
	public void modificarLimit(String n) throws Exception
	{
            int limit = Integer.parseInt(n);
            cGalaxia.modificarLimit(limit);
	}
	
	public void modificarLimits(String limits) throws Exception
	{
            List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            Scanner sca = new Scanner(limits);
            sca.useDelimiter(",");
            String info = "";

            info = sca.next();
            int pa_1 = Integer.parseInt(info);
            if(pa_1 > cGalaxia.consultarLimit() || pa_1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            info = sca.next();
            int pa_2 = Integer.parseInt(info);
            if(pa_2 > cGalaxia.consultarLimit() || pa_2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_1,pa_2);
            pa1.add(primero);

            info = sca.next();
            int l1 = Integer.parseInt(info);
            if(l1 > cGalaxia.consultarLimit() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            info = sca.next();
            int l2 = Integer.parseInt(info);
            if(l2 > cGalaxia.consultarLimit() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");

            int limite1 = primero.consultarPrimero();
            int limite2 = primero.consultarSegundo();
            boolean trobat = false;
            while(sca.hasNext() && !trobat) {
                int size = pa1.size();
                int prim = pa1.get(size-1).consultarPrimero();
                int seg = pa1.get(size-1).consultarSegundo();

                if((((l1+1) == prim) || ((l1-1) == prim) || (l1 == prim)) && (((l2+1) == seg) || ((l2-1) == seg) || (l2 == seg))){
                Pair<Integer, Integer> pa = new Pair<Integer, Integer>(l1, l2);
                pa1.add(pa);
                }
                else throw new Exception("Las coordenadas no son secuenciales");

                info = sca.next();
                l1 = Integer.parseInt(info);
                if(l1 > cGalaxia.consultarLimit() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                info = sca.next();
                l2 = Integer.parseInt(info);
                if(l2 > cGalaxia.consultarLimit() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
            sca.close();
            if(!trobat) throw new Exception("Las coordenadas no se cierran adecuadamente");
            cGalaxia.modificarLimits(pa1);
	}
 	
	public void afegirPlaneta(String x, String y) throws Exception
	{
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            cGalaxia.afegirPlaneta(x1, y1);
	}
	
	public String afegirPlanetaAutomatic() throws Exception
	{
            return cGalaxia.afegirPlanetaAutomatic();
	}
	
	public void eliminarPlaneta(String x, String y) throws Exception
	{
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            cGalaxia.eliminarPlaneta(x1, y1);
	}
	
	public void eliminarTotsPlanetes()
	{
            cGalaxia.eliminarPlanetes();
	}
	
	public void guardarGalaxia(String path) throws Exception
	{
            cGalaxia.guardarConjuntGalaxia(path);
	}
	
	public void carregarGalaxia(String path) throws Exception
	{
            cGalaxia.carregarConjuntGalaxia(path);
	}
}

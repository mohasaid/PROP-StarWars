
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gerard
 */
public class ControladorVistaRuta {
    private ControladorRuta CR;
    private VistaRuta VR;

    private ControladorGalaxia CG;
    private ControladorNave CN;
    private ControladorPlaneta CP;

    private ControladorVistaGalaxia CVG;
    private ControladorVistaPlaneta CVP;
    private ControladorVistaNave CVN;

    
    ControladorVistaRuta() {
        CR = new ControladorRuta();
        VR = new VistaRuta(this);
    }
    
    public ControladorRuta obtenerControladorRuta() {
        return CR;
    }
	
    public void inicialitza(ControladorVistaGalaxia cVG, ControladorVistaPNave cVN, ControladorVistaPlaneta cVP) {
        CG = cVG.obtenerControladorGalaxia();
        CVG = cVG;
        CN = cVN.obtenerControladorNave();
        CVN = cVN;
        CP = cVP.obtenerControladorPlaneta();
        CVP = cVP;
    }
	
    public VistaRuta obterVistaRuta() {
        return VR;
    }
    
    public  ArrayList<String> obtenerIdRutas() throws Exception 
    {
        ArrayList<String> llistat = new ArrayList<String>();		
        /* recollim els planetes del controlador de domini*/
        int i = 0;
        int n = CR.Consultar_numero_rutes();
        String s = "";
        while (i < n)
        {
            s += (CR.Consultar_ids_rutas_string(i));
            i += 100;
        }
        Scanner scan = new Scanner(s);
        scan.useDelimiter("#");
        while (scan.hasNext()) {
            llistat.add(scan.next());
        }
        scan.close();		
        return llistat;
    }
    public void creaRuta(String _id, String _capacidad, String _distancia, String planetaA, String planetaB)  throws Exception
    {
        int id = Integer.parseInt(_id);
        int capacidad = Integer.parseInt(_capacidad);
        int distancia = Integer.parseInt(_distancia);
        CR.CrearRuta(id, capacidad, distancia, planetaA, planetaB, CP);
        CVG.actualitzaRuta();
        CVN.actualitzaRuta();
        CVP.actualitzaRuta();
    }

    public void creaRutaAut() throws Exception	{
        CR.CrearRuta_automatica(CP);
        CVG.actualitzaRuta();
        CVN.actualitzaRuta();
        CVP.actualitzaRuta();
    }
    
    public void creaRutaAut_id( String _id ) throws Exception	{
        int id = Integer.parseInt(_id);
        CR.CrearRuta_automatica(CP, id);
        CVG.actualitzaRuta();
        CVN.actualitzaRuta();
        CVP.actualitzaRuta();
    }
    
    public String ConsultarCapacidadRuta(String id) throws Exception
    {
        int i = Integer.parseInt(id);
        return Integer.toString(CR.ConsultarCapacidadRuta(i));
    }

    public String ConsultarDistanciaRuta(String id) throws Exception
    {
        int i = Integer.parseInt(id);
        return Integer.toString(CR.ConsultarDistanciaRuta(i));
    }
    
    public int ConsultarNumeroRutes() {
        return CR.Consultar_numero_rutes();
    }
    
    public String ConsultarPlanetaARuta(String id) throws Exception
    {
        int i = Integer.parseInt(id);
        return CR.ConsultarPlanetaARuta(i);
    }
      

    public String ConsultarPlanetaBRuta(String id) throws Exception
    {
        int i = Integer.parseInt(id);
        return CR.ConsultarPlanetaBRuta(i);
    }
    
    public void ModificarCapacidadRuta(String id, String capacidad_nueva) throws Exception
    {
        int i = Integer.parseInt(id);
        int c = Integer.parseInt(capacidad_nueva);
        CR.ModificarCapacidadRuta(i, c);
        CVG.actualitzaRuta();
        CVN.actualitzaRuta();
        CVP.actualitzaRuta();
    }
      
    public void ModificarDistanciaRuta(String id, String distancia_nueva)throws Exception
    {
        int i = Integer.parseInt(id);
        int d = Integer.parseInt(distancia_nueva);
        CR.ModificarDistanciaRuta(i, d);
        CVG.actualitzaRuta();
        CVN.actualitzaRuta();
        CVP.actualitzaRuta();
    }

    public void ModificarPlanetaARuta(String id, String id_planetaA_nuevo)throws Exception
    {
        int i = Integer.parseInt(id);
        CR.ModificarPlanetaARuta(i, id_planetaA_nuevo, CP);
        CVG.actualitzaRuta();
        CVN.actualitzaRuta();
        CVP.actualitzaRuta();
    }
    
    public void ModificarPlanetaBRuta(String id, String id_planetaB_nuevo, ControladorPlaneta cp)throws Exception
    {
        int i = Integer.parseInt(id);
        CR.ModificarPlanetaARuta(i, id_planetaB_nuevo, CP);
        CVG.actualitzaRuta();
        CVN.actualitzaRuta();
        CVP.actualitzaRuta();
    }

    public void eliminarRuta(String id) throws Exception 
    {
        int i = Integer.parseInt(id);
        CR.BorrarRuta(i);
        CVG.actualitzaRuta();
        CVN.actualitzaRuta();
        CVP.actualitzaRuta();
    }
    
}

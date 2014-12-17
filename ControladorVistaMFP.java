package prop;
/**
 *
 * @author Moha
 */
import java.util.*;

public class ControladorVistaMFP {
    private VistaMFP vMFP;
    private Entrada E;
    private ControladorGalaxia cg;
    private ControladorPlaneta cp;
    private ControladorRuta cr;
    private ControladorNave cn;
    private ControladorMFP cmfp;
    
    public void Importar(ControladorVistaGalaxia g, ControladorVistaPlaneta p, ControladorVistaRuta r, ControladorVistaNave n) 
    {
        cg = g.consultarControladorGalaxia();
        cp = p.ConsultarControladorPlaneta();
        cn = n.ConsultarControladorNave();
        cr = r.consultarControladorRuta();
    }
    
    public VistaMFP ConsultarVistaMFP() 
    {
        return vMFP;
    }
    
    public ControladorVistaMFP() 
    {
        vMFP = new VistaMFP(this);
        cmfp = new ControladorMFP();        
    }
    
    public void SeleccionarAlgoritmo(int i) throws Exception 
    {
        cmfp.SeleccionarAlgoritmo(i, cn, cr, cp);
    }
    
    public void SeleccionarFuncionCoste(int i) throws Exception 
    {
        cmfp.SeleccionarFC(i, cg, cr, cp, cn);
    }
    
    public void Ejecutar() throws Exception 
    {
        cmfp.Executa(cn, cr, cp);
    }
    
    public String ConsultarSalida() 
    {
        int i=0;
        int n = cmfp.size();
        String s = "";
        while(i < n){
            s += cmfp.ConsultarSalida(i);
            i += 100;
        }
        return s;
    }
    
    public String ConsultarSalidaParcial() 
    {
        int i=0;
        int n = cmfp.sizeCambios();
        String s = "";
        while(i < n){
            s += cmfp.ConsultarCambios(i);
            i += 100;
        }
        return s;
    }
}

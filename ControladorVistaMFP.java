import java.util.*;

public class ControladorVistaMFP {
    private VistaMFP vMFP;
    private Entrada E;
    private ControladorGalaxia cg;
    private ControladorPlaneta cp;
    private ControladorRuta cr;
    private COntroladorNave cn;
    private ControladorMFP cmfp;
            
    public void actualiza() {
        vMFP.actualiza();
    }
    
    public void Importar(ControladorGalaxia g, ControladorPlaneta p, ControladorRuta r, ControladorNave n) {
        cg = g;
        cp = p;
        cn = n;
        cr = r;
                
    }
    public VistaMFP ConsultarVistaMFP() {
        return vMFP;
    }
    
    public ControladorVistaMFP() {
        vMFP = new VistaMFP(this);
        E = new Entrada();
        cmfp = new ControladorMFP();
        cmfp.AnadirEntrada(E);
        
    }
    
    public void SeleccionarAlgoritmo(int i) {
        cmfp.SeleccionarAlgoritmo(i, cn, cr, cp);
    }
    
    public void SeleccionarFuncionCoste(int i) {
        cmfp.SeleccionarFC(i, cg, cr, cp, cn);
    }
    
    public void Ejecutar() {
        cmfp.Executa(cn, cr, cp);
    }
    public String ConsultarSalida() {
        int i=0;
        int n = cmfp.size();
        String s = "";
        while(i < n){
            s += cmfp.ConsultarSalida(i);
            i += 100;
        }
        return s;
    }
    
    public String ConsultarSalidaParcial() {
        int i=0;
        int n = cmfp.size();
        String s = "";
        while(i < n){
            s += cmfp.ConsultarCambios(i);
            i += 100;
        }
        return s;
    }
}

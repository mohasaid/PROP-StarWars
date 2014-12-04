
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gerard
 */
public class Main_vistes extends JFrame{

    private JPanel panel;

    /** Controladors Vistes **/
    private ControladorVistaGalaxia CVG;
    private ControladorVistaPlaneta CVP;
    private ControladorVistaNave CVN;
    private ControladorVistaRuta CVR;

    /** Vistes **/
    private VistaGalaxia VG;
    private VistaPlaneta VP;
    private VistaNave VN;
    private VistaRuta VR;

    private void obtenerVistas() {		
        VG = CVG.obtenerVistaGalaxia(); 
        VP = CVP.obtenerVistaPlaneta();
        VN = CVN.obtenerVistaNave();
        VR = CVR.obtenerVistaRuta();
    }
    
    public VistaPrincipal(ControladorVistaGalaxia CVG, ControladorVistaPlaneta CVP, ControladorVistaNave CVN, ControladorVistaRuta CVR) 
    {
        
    } 
}

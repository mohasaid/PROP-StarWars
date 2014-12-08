
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import static sun.security.ssl.Debug.Help;
import static sun.security.util.Debug.Help;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gerard
 */
public class Main_vistes extends JFrame {

    private JPanel panel;
    private Help help;


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
    
    public Main_vistes(ControladorVistaGalaxia cVG, ControladorVistaPlaneta cVP, ControladorVistaNave cVN, ControladorVistaRuta cVR) 
    {
        CVG = cVG;
        CVP = cVP;
        CVN = cVN;
        CVR = cVR;
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1035, 648);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);
        
        /** Obtenim els objectes de les diferents vistes
         * que han creat els controladors de vistes **/
        obtenerVistas();

        final JLabel fons = new JLabel("");


        /** Panel Gran Dreta **/
        final JPanel panelGrande = new JPanel();
        panelGrande.setOpaque(false);
        panelGrande.setBounds(213, 95, 750, 547);
        panel.add(panelGrande);
        panelGrande.setLayout(new GridLayout(1, 0, 0, 0));



        help = new Help();
		
				
        
        /** Boton Galaxies **/
        JButton btnGalaxia = new JButton("Galaxia");
        btnGalaxia.setBounds(34, 145, 109, 40);
        panel.add(btnGalaxia);
        btnGalaxia.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // col�loquem el de galaxia					
                        panelGrande.add(VG);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        btnGalaxia.setToolTipText("Gestione la Galaxia");
        
        /** Boto Planetes **/
        JButton btnPlanetes = new JButton("Planetas");
        btnPlanetes.setBounds(34, 224, 109, 40);
        panel.add(btnPlanetes);
        btnPlanetes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        panelGrande.add(VP);
                        panelGrande.repaint();
                        panelGrande.revalidate();


                }
        });
        btnPlanetes.setToolTipText("Gestione los Planetas");


        /** Boto Paquets **/
        JButton btnPaquets = new JButton("Rutas");
        btnPaquets.setBounds(34, 307, 109, 40);
        panel.add(btnPaquets);
        btnPaquets.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();				
                        panelGrande.add(VR);
                        panelGrande.repaint();
                        panelGrande.revalidate();


                }
        });
        btnPaquets.setToolTipText("Gestione las Rutas");

        /** Boto Recursos **/
        JButton btnRecursos = new JButton("Naves");
        btnRecursos.setBounds(34, 388, 109, 40);
        panel.add(btnRecursos);
        btnRecursos.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {


                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();				
                        panelGrande.add(VN);
                        panelGrande.repaint();
                        panelGrande.revalidate();


                }
        });
        btnRecursos.setToolTipText("Gestione las Naves");



        /** Boto Terraformacio **/
        JButton btnTerraformacio = new JButton("Salida");
        btnTerraformacio.setBounds(34, 466, 109, 40);
        panel.add(btnTerraformacio);
        btnTerraformacio.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();				
                        panelGrande.add(VS);
                        panelGrande.repaint();
                        panelGrande.revalidate();
                }
        });
        btnTerraformacio.setToolTipText("Salida del algoritmo");
        
    } 
}

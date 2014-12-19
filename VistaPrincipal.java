
/**
 *
 * @author Moha
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import static sun.security.ssl.Debug.Help;
import static sun.security.util.Debug.Help;
/**
 *
 * @author Gerard
 */
public class VistaPrincipal extends JFrame {

    private JPanel panel;

    /** Controladors Vistes **/
    private ControladorVistaGalaxia CVG;
    private ControladorVistaPlaneta CVP;
    private ControladorVistaNave CVN;
    private ControladorVistaRuta CVR;
    private ControladorVistaMFP CVMFP;

    /** Vistes **/
    private VistaGalaxia VG;
    private VistaPlaneta VP;
    private VistaNave VN;
    private VistaRuta VR;
    private VistaMFP vMFP;
    
    private VistaHelp help;
 
    private void obtenerVistas() {		
        VG = CVG.consultarVistaGalaxia();
        VP = CVP.ConsultarVistaPlaneta();
        VN = CVN.ConsultarVistaNave();
        VR = CVR.ConsultarVistaRuta();
        vMFP = CVMFP.ConsultarVistaMFP();
    }
    
    public VistaPrincipal(ControladorVistaGalaxia cVG, ControladorVistaPlaneta cVP, ControladorVistaNave cVN, ControladorVistaRuta cVR, ControladorVistaMFP cMFP) throws InterruptedException 
    {
        CVG = cVG;
        CVP = cVP;
        CVN = cVN;
        CVR = cVR;
        CVMFP = cMFP;

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1035, 648);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);
        
        final JPanel panelGrande = new JPanel();
        panelGrande.setOpaque(false);
        panelGrande.setBounds(50,100,900,500);
        panel.add(panelGrande);
        panelGrande.setLayout(new GridLayout(1,0,0,0));
                
        JButton Btn_MFP = new javax.swing.JButton("Maximo Flujo");
        JButton Btn_Naves = new javax.swing.JButton("Nave");
        JButton Btn_Planetas = new javax.swing.JButton("Planetas");
        JButton Btn_Galaxia = new javax.swing.JButton("Galaxia");
        JButton Btn_Rutas = new javax.swing.JButton("Rutas");
        
             
        /** Obtenim els objectes de les diferents vistes
         * que han creat els controladors de vistes **/
        obtenerVistas();

        //help = new Help();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Btn_Galaxia.setBounds(50,50,120,40);        
        Btn_Planetas.setBounds(244,50,120,40);
        Btn_Rutas.setBounds(441,50,120,40);
        Btn_Naves.setBounds(628,50,120,40);
        Btn_MFP.setBounds(834,50,120,40);
        
        panel.add(Btn_Galaxia);
        panel.add(Btn_Planetas);
        panel.add(Btn_Rutas);
        panel.add(Btn_Naves);
        panel.add(Btn_MFP);
        
        /** Boton Galaxia **/
        Btn_Galaxia.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        panelGrande.add(VG);
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_Galaxia.setToolTipText("Gestiona la Gal\u00E0xia del sistema");
        
        /** Boton Rutas **/
        Btn_Rutas.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                   if(VG.consultarCreada()) {
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        //colocamos las rutas				
                        panelGrande.add(VR);			
                        panelGrande.repaint();
                        panelGrande.revalidate();
                   }
                }
        });		
        Btn_Rutas.setToolTipText("Gestiona las Rutas del sistema");
        
        /** Boton Naves **/
        Btn_Naves.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                    if(VG.consultarCreada()) {
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // colocamos naves
                        panelGrande.add(VN);			
                        panelGrande.repaint();
                        panelGrande.revalidate();
                    }
                }
        });		
        Btn_Naves.setToolTipText("Gestiona las Naves del sistema");
        
        /** Boton Planetas **/
        Btn_Planetas.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                    if(VG.consultarCreada()) {
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // coloquem planetas					
                        panelGrande.add(VP);			
                        panelGrande.repaint();
                        panelGrande.revalidate();
                    }
                }
        });		
        Btn_Planetas.setToolTipText("Gestiona los Planetas del sistema");
        
        /** Boton MF **/
        Btn_MFP.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                    if(VG.consultarCreada()) {
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // col�loquem el de galaxia					
                        panelGrande.add(vMFP);
                        panelGrande.repaint();
                        panelGrande.revalidate();
                    }
                }
        });		
        Btn_MFP.setToolTipText("Gestiona Flujo Maximo del sistema");
        
        JToolBar jtb = new JToolBar();
        jtb.setBackground(SystemColor.control);
        jtb.setBounds(0, 0, 1035, 30);
        panel.add(jtb);
        
        final JLabel fons = new JLabel("");
        fons.setIcon(new ImageIcon(VistaPrincipal.class.getResource("sw.jpg")));
        fons.setBounds(0, 0, 1035, 648);
        panel.add(fons);
        
        JButton hp = new JButton("Ajuda");
        hp.setBorder(null);
        jtb.add(hp);
        
        help = new VistaHelp();
           
        hp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        
                        panelGrande.add(help);
                        panelGrande.repaint();
                        panelGrande.revalidate();
                }
        }); 
    
    JButton Clear = new JButton("   Clear");
    Clear.setBorder(null);
    jtb.add(Clear);
    
    Clear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0){
                       CVN.clear();
                       VN.actualiza();
                       VN.actualizaT();
                       CVR.clear();
                       VR.actualiza();
                    try {
                        CVP.clear();
                    } catch (Exception ex) {
                        //Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       VP.actualiza();
                }
        });
    
    
    }
    
}

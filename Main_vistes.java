
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    
    //private Help help;
    private JPanel panel;

    /** Controladors Vistes **/
    //private ControladorVistaGalaxia CVG;
    //private ControladorVistaPlaneta CVP;
    //private ControladorVistaNave CVN;
    private ControladorVistaRuta CVR;

    /** Vistes **/
    //private VistaGalaxia VG;
    //private VistaPlaneta VP;
    //private VistaNave VN;
    private VistaRuta VR;

    /*
    private void obtenerVistas() {		
        VG = CVG.consultarVistaGalaxia();
        VP = CVP.ConsultarVistaPlaneta();
        //VN = CVN.obtenerVistaNave();
        VR = CVR.ConsultarVistaRuta();
    }*/
    

    public Main_vistes(/*ControladorVistaGalaxia cVG, ControladorVistaPlaneta cVP, ControladorVistaNave cVN,*/ ControladorVistaRuta cVR/*, ControladrMFP cMFP*/) throws InterruptedException 
    {
        //CVG = cVG;
        //CVP = cVP;
        //CVN = cVN;
        CVR = cVR;

        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1035, 648);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);
        
        final JPanel panelGrande = new JPanel();
        panelGrande.setOpaque(false);
        panelGrande.setBounds(50,100,700,500);
        panel.add(panelGrande);
        panelGrande.setLayout(new GridLayout(1,0,0,0));

        
        
        JLabel jLabel2 = new javax.swing.JLabel();
        jLabel2.setVisible(true);
        jLabel2.setIcon( new ImageIcon(Main_vistes.class.getResource("/Imagenes/SW.jpg")));
        jLabel2.setBounds(0,0,1035,648);
        add(jLabel2);
        
        JButton Btn_MFP = new javax.swing.JButton("Maximo Flujo");
        JButton Btn_Naves = new javax.swing.JButton("Nave");
        JButton Btn_Planetas = new javax.swing.JButton("Planetas");
        JButton Btn_Galaxia = new javax.swing.JButton("Galaxia");
        JButton Btn_Rutas = new javax.swing.JButton("Rutas");
        
             
        /** Obtenim els objectes de les diferents vistes
         * que han creat els controladors de vistes **/
        //obtenerVistas();

       //help = new Help();

        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Btn_Galaxia.setBounds(50,50,120,40);
        
        int aux = 120+67;
        int aux2 = 120+70;
        
        Btn_Planetas.setBounds(aux+67-10,50,120,40);
        Btn_Rutas.setBounds(2*aux+67,50,120,40);
        Btn_Naves.setBounds(3*aux+67,50,120,40);
        Btn_MFP.setBounds(4*aux2+74,50,120,40);

        
        panel.add(Btn_Galaxia);
        panel.add(Btn_Planetas);
        panel.add(Btn_Rutas);
        panel.add(Btn_Naves);
        panel.add(Btn_MFP);
        
        
        //final JPanel panelGrande = new JPanel();
        JPanel panel_aux =  new SW_Panel();
        panel_aux.setBounds(50,100,700,500);
        panel.add(panel_aux);
        
        /** Boton Galaxia **/
        Btn_Galaxia.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // col�loquem el de galaxia					
                        //panelGrande.add(VG);
                        panelGrande.add(panel_aux);
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_Galaxia.setToolTipText("Gestiona la Gal\u00E0xia del sistema");
        
        /** Boton Rutas **/
        Btn_Rutas.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        //colocamos las rutas				
                        panelGrande.add(VR);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_Rutas.setToolTipText("Gestiona las Rutas del sistema");
        
        /** Boton Naves **/
        Btn_Naves.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // colocamos naves
                       // panelGrande.add(VN);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_Naves.setToolTipText("Gestiona las Naves del sistema");
        
        /** Boton Planetas **/
        Btn_Planetas.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // coloquem planetas					
                        //panelGrande.add(VP);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_Planetas.setToolTipText("Gestiona los Planetas del sistema");
        
        /** Boton MF **/
        Btn_MFP.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // col�loquem el de galaxia					
                        //panelGrande.add(VMFP);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_MFP.setToolTipText("Gestiona Flujo Maximo del sistema");
        

        
        /*JToolBar jToolBar1 = new javax.swing.JToolBar();
        JButton jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jToolBar1.setRollover(true);

        jButton1.setText("Ayuda");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 575, Short.MAX_VALUE))
        );

        pack();
        
        
        /** Boton Help **//*
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // col�loquem el de galaxia					
                        //panelGrande.add(VMFP);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });
        */
    }
}

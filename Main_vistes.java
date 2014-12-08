
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
    //private Help help;


    /** Controladors Vistes **/
    private ControladorVistaGalaxia CVG;
    private ControladorVistaPlaneta CVP;
    //private ControladorVistaNave CVN;
    private ControladorVistaRuta CVR;

    /** Vistes **/
    private VistaGalaxia VG;
    //private VistaPlaneta VP;
    //private VistaNave VN;
    private VistaRuta VR;

    private void obtenerVistas() {		
        VG = CVG.consultarVistaGalaxia();
        //VP = CVP.
        //VN = CVN.obtenerVistaNave();
        //VR = CVR.obtenerVistaRuta();
    }
    

    public Main_vistes(/*ControladorVistaGalaxia cVG, ControladorVistaPlaneta cVP, ControladorVistaNave cVN, ControladorVistaRuta cVR*/) throws InterruptedException 
    {
        //CVG = cVG;
        //CVP = cVP;
        //CVN = cVN;
        //CVR = cVR;
        
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1035, 648);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel jLabel2 = new javax.swing.JLabel();
        jLabel2.setIcon( new ImageIcon(Main_vistes.class.getResource("/Imagenes/galax.jpg")));
        setContentPane(panel);
        setContentPane(jLabel2);
        panel.removeAll();
        panel.repaint();
        panel.revalidate();

        
        /** Obtenim els objectes de les diferents vistes
         * que han creat els controladors de vistes **/
        //obtenerVistas();

       //help = new Help();
		
		

        JButton Btn_MFP = new javax.swing.JButton();
        JButton Btn_Naves = new javax.swing.JButton();
        JButton Btn_Planetas = new javax.swing.JButton();
        JButton Btn_Galaxia = new javax.swing.JButton();
        JButton Btn_Rutas = new javax.swing.JButton();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_MFP.setText("Maximo Flujo");

        Btn_Naves.setText("Naves");

        Btn_Planetas.setText("Planetas");

        Btn_Galaxia.setText("Galaxia");

        Btn_Rutas.setText("Rutas");

        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Btn_Galaxia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Btn_Planetas, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(Btn_Rutas, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Btn_Naves, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(Btn_MFP, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_MFP, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Naves, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Planetas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Galaxia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Rutas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(435, Short.MAX_VALUE))
        );
        pack();
        
        final JPanel panelGrande = new JPanel();
        
        /** Boton Galaxia **/
        Btn_Galaxia.addActionListener(new ActionListener() {
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
        Btn_Galaxia.setToolTipText("Gestiona las Rutas del sistema");
        
        /** Boton Naves **/
        Btn_Naves.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // colocamos naves
                        panelGrande.add(VN);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_Galaxia.setToolTipText("Gestiona las Naves del sistema");
        
        /** Boton Planetas **/
        Btn_Planetas.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // coloquem planetas					
                        panelGrande.add(VP);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_Galaxia.setToolTipText("Gestiona los Planetas del sistema");
        
        /** Boton MF **/
        Btn_MFP.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {				
                        // eliminem el panel actual
                        panelGrande.removeAll();
                        panelGrande.repaint();
                        panelGrande.revalidate();
                        // col�loquem el de galaxia					
                        panelGrande.add(VMFP);			
                        panelGrande.repaint();
                        panelGrande.revalidate();

                }
        });		
        Btn_Galaxia.setToolTipText("Gestiona Flujo Maximo del sistema");
        
        JLabel lblAjuda = new JLabel("Ajuda");
		lblAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				// eliminem el panel actual
				panelGrande.removeAll();
				panelGrande.repaint();
				panelGrande.revalidate();
				// col�loquem el de galaxia				
				panelGrande.add(help);
				panelGrande.repaint();
				panelGrande.revalidate();
			}
		});
		lblAjuda.setBounds(223, 0, 57, 24);
		panel.add(lblAjuda);
    }
}

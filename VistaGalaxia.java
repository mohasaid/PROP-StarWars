import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.lang.reflect.Method;

public class VistaGalaxia /*extends PrimerNivell */ extends JFrame {
	/* VARIABLES */
	private ControladorVistaGalaxia cvg;
	private String path;
	
	private String nomActual;
	private String LimitActual;
	private String limitsActual; // GUARDAR ARRAY O STRING
	
	private String NomNou;
	private String LimitNou;
	private String limitsNous;
	/* JLABELS */ // mostrar texto
	/* JTextField */
	private JTextField txtNomGalaxia;
	private JTextField txtLimit;
	private JTextField txtLimitsUsuari;
	private JTextField txtError;
	
	private JTextField txtField1; // nombre galaxia - crear
	private JTextField txtField2; // limite galaxia - crear
	private JTextField txtField3; // forma galaxia - crear
	
	private JTextField txtField4; // nombre actual galaxia - modificar
	private JTextField txtField5; // limite actual galaxia - modificar
	private JTextField txtField6; // forma actual galaxia - modificar
	
	private JTextField txtField7; // nombre nuevo galaxia - modificar
	private JTextField txtField8; // limite nuevo galaxia - modificar
	private JTextField txtField9; // forma nueva galaxia - modificar
	
	/* JRadioButton */ // -> te deja escoger entre distintas opciones
	private JRadioButton SenseForma;
	private JRadioButton AmbForma;
	// https://docs.oracle.com/javase/tutorial/uiswing/components/button.html -> DESACTIVAR BOTONES
	/* JPanel */ // crear paneles
	private JPanel panel;
	private JPanel panelForma;
	private JPanel panelSense;
	/* JComboBox */ // lista que permite bajar
	/* JButton */ // botones
	private JButton btnModificarGalaxia;
    private JButton btnMissatge;
    private JButton btnCrearNovaGalaxia;
    /* Altres */
    // FileChooser
    private JFileChooser fileChooser1; // cargar
    private JFileChooser fileChooser2; // guardar
    // ButtonGroup
    private ButtonGroup group1; // buttongroup te permite solo pillar 1 no mas, si no lo pones puedes pillar mas
    private ButtonGroup group2;
    // Llista
    private DefaultListModel<String> forma; // mirar, para la forma
    
    public VistaGalaxia consultaVistaGalaxia()
    {
    	return this;
    }
    
    // no hay nada que actualizar en la lista
    public VistaGalaxia(ControladorVistaGalaxia cVG)
    {
    	cvg = cVG;
    	/* INICIALIZACIONES */
    	JTabbedPane PanelTab1 = new JTabbedPane(JTabbedPane.TOP); // panel de arriba con crear guardar etc
    	// CREAR
    	JLabel label1 = new JLabel("Crear una nova gal\u00E0xia");
    	JLabel label2 = new JLabel("Nom :");
    	JTextField textField2 = new JTextField();
    	JLabel label3 = new JLabel("Limit :");
    	JTextField textField3 = new JTextField();
    	JLabel label4 = new JLabel("Forma :");
    	JTextField textField4 = new JTextField();
    	ButtonGroup teForma = new ButtonGroup();  // ELEGIR TIENE FORMA O NO
        btnCrearNovaGalaxia = new JButton("Crear");
        
    	// separadarores
        JSeparator separator1 = new JSeparator(); // linea que separa
        JSeparator separator2 = new JSeparator();
        
        // MODIFICAR
        JLabel label5 = new JLabel("Modificar la gal\u00E0xia");
        JLabel label6 = new JLabel("Nom :");
        JLabel label7 = new JLabel("Nom :");
        //JpaNel pane2 = new RoundedPanel();
        JTextField textField5 = new JTextField();
        JLabel label8 = new JLabel("Limit :");
        JTextField textField6 = new JTextField();
        JLabel label9 = new JLabel("Limit :");
        JLabel label10 = new JLabel("Configuraci\u00F3 actual");
        JLabel label11 = new JLabel("Nova configuraci\u00F3");
        JLabel label12 = new JLabel("Forma :");
        JLabel label13 = new JLabel("Forma :");
        txtField7 = new JTextField();
        txtField8 = new JTextField();
        txtField9 = new JTextField();
        btnModificarGalaxia = new JButton("Modificar");
        
    	/* CONFIGURACIONES */
        setLayout(null); // no le dejo que elija donde poner las cosas, lo elijo todo yo
        setBackground(Color.GRAY); // -> ESCOGER COLOR
        // setOpaque(false); -> no funciona
        
        // COMPOUNDBORDER -> LINEA QUE RODEA EL BOTON CON UN COLOR DETERMINADO
        
    	// Panel de arriba
        PanelTab1.setBackground(SystemColor.control);
        PanelTab1.setBounds(0, 11, 543, 430); // -> mirar valores
        add(PanelTab1);
    	PanelTab1.addTab("Crear", null,/* pane1,*/ null); // nombre, icono, panel, mensaje cuando pones el raton encima
    	PanelTab1.addTab("Modificar", null,/* pane2,*/ null);
    	PanelTab1.addTab("Consultar", null,/* pane4, */ null);
    	PanelTab1.addTab("", new ImageIcon(VistaGalaxia.class.getResource("/resources/openmall.png")),/* pane5,*/ null); // imagen de cargar
    	PanelTab1.addTab("", new ImageIcon(VistaGalaxia.class.getResource("/resources/save.png")),/* pane6,*/ null); // imagen de guardar
    	// BOTON PARA SACAR MENSAJE
    	btnMissatge = new JButton("");
    	txtError = new JTextField();
    	// FILECHOOSERS
    	fileChooser1 = new JFileChooser();
    	fileChooser1.setAutoscrolls(true);
    	fileChooser1.setBounds(22, 11, 495, 366); // -> mirar valores
        fileChooser1.setMinimumSize(new Dimension(200, 245)); // -> mirar valores
        fileChooser1.setPreferredSize(new Dimension(365, 225)); // -> mirar valores
        // panel debe añadirlo
        fileChooser2 = new JFileChooser();
        fileChooser2.setAutoscrolls(true);
        fileChooser2.setBounds(22, 11, 495, 366); // -> mirar valores
        fileChooser2.setMinimumSize(new Dimension(365, 225)); // -> mirar valores
        fileChooser2.setPreferredSize(new Dimension(365, 225)); // -> mirar valores
        // panel debe añadirlo
    	
        // BOTON PARA ESCOGER SI TIENE FORMA O NO
        AmbForma = new JRadioButton("Amb forma");
        SenseForma = new JRadioButton("Sense forma");
        
        AmbForma.setSelected(true); // comenco amb forma marcat
        AmbForma.setBounds(146, 164, 109, 23); // -> mirar valores
        // pane3.add(AmbForma); // panel que lo anade
        group1.add(AmbForma);
        
        SenseForma.setSelected(false);        
        SenseForma.setBounds(146, 164, 109, 23); // -> mirar valores
        // pane3.add(AmbForma); // panel que lo anade
        group1.add(SenseForma);
        
        
    	/* LISTENERS */
        // CREA GALAXIA
        btnCrearNovaGalaxia.addActionListener
        (
		    new ActionListener() {
		        public void actionPerformed(ActionEvent ae) {
		        	String nom = txtField1.getText();
		            String limit = txtField2.getText();
		            try {
		            	// si selecciona amb forma
		            	if(AmbForma.isSelected()) {
		            		String forma = txtField3.getText();
		            		cvg.creaGalaxia22(nom, limit, forma); // mirar esto
		            	}
		            	else if(SenseForma.isSelected()) {
		            		cvg.creaGalaxia(nom, limit);
		            	}
		            }
		            catch (Exception ex) {
		            	txtError.setText(ex.getMessage());
		            }
		            txtField1.setText(""); // quitamos lo que habia en el recuadro
		            txtField2.setText("");
		        }
		    });
        
        // MODIFICA GALAXIA
        btnModificarGalaxia.addActionListener
        (
        	new ActionListener() {
        		public void actionPerformed(ActionEvent ae) {
        			nomActual = txtField4.getText();
        			LimitActual = txtField5.getText();
        			limitsActual = txtField6.getText();
        			
        			NomNou = txtField7.getText();
        			LimitNou = txtField8.getText();
        			limitsNous = txtField9.getText();
        			// Puede modificar el nombre, trim quita los espacios en blanco
        			try {
        				if(!NomNou.trim().isEmpty() && !NomNou.equals(nomActual)) {
        					cvg.modificarNom(NomNou);
        				}
        			}
        			catch (Exception e) { 
        				txtError.setText(e.getMessage()); 
        			}
        			// Puede modificar el limite
        			try {
        				if(!LimitNou.trim().isEmpty() && !LimitNou.equals(LimitActual)) {
        					cvg.modificarLimit(LimitNou);
        				}
        			}
        			catch (Exception e) { 
        				txtError.setText(e.getMessage()); 
        			}
        			// Puede modificar la forma
        			try {
        				if(!limitsNous.trim().isEmpty() && !limitsNous.equals(limitsActual)) {
        					cvg.modificarLimits(limitsNous);
        				}
        			}
        			catch (Exception e) { 
        				txtError.setText(e.getMessage()); 
        			}
        			txtField4.setText("");
        			txtField5.setText("");
        			txtField6.setText("");
        			txtField7.setText("");
        			txtField8.setText("");
        			txtField9.setText("");
        		}
        	});
        
        fileChooser1.addActionListener
        (
        		new ActionListener() {
		            public void actionPerformed(ActionEvent e) { 
		                path = fileChooser1.getSelectedFile().getAbsolutePath();
		                try {
		                	cvg.carregarGalaxia(path);
		                } 
		                catch (Exception e1) {
		                	txtError.setText(e1.getMessage());
		                }
		                finally {
		                    txtError.setText("Ha finalitzat el procés de carregar l'arxiu " + path);                    
		                }               
            }
        });
        
        fileChooser2.addActionListener
        (
        		new ActionListener() {
		            public void actionPerformed(ActionEvent e) { 
		                path = fileChooser2.getSelectedFile().getAbsolutePath();
		                try {
		                	cvg.guardarGalaxia(path);
		                } 
		                catch (Exception e1) {
		                	txtError.setText(e1.getMessage());
		                }
		                finally {
		                    txtError.setText("Ha finalitzat el procés de guardar l'arxiu " + path);                    
		                }               
            }
        });
        
        // VACIAR MENSAJE ERROR
        btnMissatge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtError.setText("");
            }
        });
        
    	
    }
}

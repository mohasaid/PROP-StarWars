import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGalaxia extends PrimerNivel {
	/* VARIABLES */
    private boolean CREADA = false;
    private boolean teForma = false;
    private ControladorVistaGalaxia cvg;
    private String path;
	
    private String nomActual;
    private String LimitActual;
    private String limitsActual;
   
    private String NomNou;
    private String LimitNou;
    private String limitsNous;

    private JRadioButton SenseForma;
    private JRadioButton AmbForma;
    private JRadioButton SenseForma1;
    private JRadioButton AmbForma1;

    private JButton btnModificarGalaxia;
    private JButton btnMissatge;
    private JButton btnCrearNovaGalaxia;
    
    private ButtonGroup group1;
    private ButtonGroup group2;

    private JScrollPane dibujo;
    private JScrollPane dibujo1;
    
    private Grid forma; // limites + planetas
    private Grid forma1; // solo limites
    
    public VistaGalaxia consultaVistaGalaxia()
    {
    	return this;
    }
    
    public void pintaPlaneta(int x, int y)
    {
        forma1.planetaCell(x, y);
    }
    
    public void borraPlaneta(int x, int y)
    {
        forma1.borraPlaneta(x, y);
    }
    
    public void borra()
    {
        forma.borraLimites();
        forma1.borraLimites();
        forma1.borraPlanetas();
    }
    
    public void borraPlanetas()
    {
        forma1.borraPlanetas();
    }
    
    public boolean consultarCreada()
    {
        return CREADA;
    }
    
    public void setCreada(boolean b)
    {
        CREADA = b;
    }
    
    public void actualitza(boolean teforma) // ya se ha creado
    {
        textfield4.setText(cvg.consultarNomGalaxia()); // nombre actual modificar
        textfield6.setText(String.valueOf(cvg.consultarLimit())); // limite actual modificar
        
        textfield10.setText(cvg.consultarNomGalaxia()); // nombre actual consulta
        textfield11.setText(String.valueOf(cvg.consultarLimit())); // limite actual consulta
        
        forma.setN(String.valueOf(cvg.consultarLimit())); // dibujo modificar
        forma1.setN(String.valueOf(cvg.consultarLimit())); // dibujo consultar
                
        dibujo = new JScrollPane(forma);
        dibujo.setBounds(420, 30, 250, 250);
        Modificar.add(dibujo);
        
        dibujo1 = new JScrollPane(forma1);
        dibujo1.setBounds(225,170,250,250);
        Consultar.add(dibujo1);
        
        if(teforma) {
            forma.PonTodos(cvg.consultarLimits()); // forma modificar
            forma1.PonTodos(cvg.consultarLimits()); // forma consultar
        }   
    }
    
    public void actualitza2(boolean teforma)
    {
        textfield4.setText(cvg.consultarNomGalaxia()); // nombre actual modificar
        textfield6.setText(String.valueOf(cvg.consultarLimit())); // limite actual modificar
        
        textfield10.setText(cvg.consultarNomGalaxia()); // nombre actual consulta
        textfield11.setText(String.valueOf(cvg.consultarLimit())); // limite actual consulta
        
        forma.setN(String.valueOf(cvg.consultarLimit())); // dibujo modificar
        forma1.setN(String.valueOf(cvg.consultarLimit())); // dibujo consultar
                
        Modificar.add(dibujo);
        Consultar.add(dibujo1);
        
        if(teforma) {
            forma.PonTodos(cvg.consultarLimits()); // forma modificar
            forma1.PonTodos(cvg.consultarLimits()); // forma consultar
        }   
    }

    public VistaGalaxia(ControladorVistaGalaxia cVG)
    {    	
    	cvg = cVG;
    	/* INICIALIZACIONES */
    	Central = new JTabbedPane(JTabbedPane.TOP); // panel de arriba con crear guardar etc
    	
    	// CARGAR - GUARDAR
    	FrameGuardar = new JInternalFrame();
    	FrameCargar = new JInternalFrame();
    	Cargar = new JFileChooser();
    	Guardar = new JFileChooser();
    	
    	// CREAR
    	Crear = new JPanel();
    	btnCrearNovaGalaxia = new JButton("Crear galaxia");
    	AmbForma = new JRadioButton("Amb forma");
        SenseForma = new JRadioButton("Sense forma");
    	label2 = new JLabel("Nom :");
    	textfield1 = new JTextField();
    	label3 = new JLabel("Limit :");
    	textfield2 = new JTextField();
    	label4 = new JLabel("Forma :");
    	textfield3 = new JTextField();
        group1 = new ButtonGroup();
    	
        // MODIFICAR
    	Modificar = new JPanel();
        btnModificarGalaxia = new JButton("Modificar galaxia");
        
        AmbForma1 = new JRadioButton("Amb forma");
        SenseForma1 = new JRadioButton("Sense forma");
        group2 = new ButtonGroup();
        
        label10 = new JLabel("Configuraci\u00F3 actual");
        label6 = new JLabel("Nom :");
        textfield4 = new JTextField();
        label8 = new JLabel("Limit :");
        textfield6 = new JTextField();
        label12 = new JLabel("Forma :");
        textfield8 = new JTextField();
        
        label11 = new JLabel("Nova configuraci\u00F3");
        label7 = new JLabel("Nom :");
        textfield5 = new JTextField();
        label9 = new JLabel("Limit :");
        textfield7 = new JTextField();
        label13 = new JLabel("Forma :");
        textfield9 = new JTextField();
        
        // CONSULTAR
        Consultar = new JPanel();
        label14 = new JLabel("Nom :");
        textfield10 = new JTextField(); // nombre
        label15 = new JLabel("Limit :");
        textfield11 = new JTextField(); // limite
        
        forma = new Grid();
        forma1 = new Grid();
        label16 = new JLabel("Forma :"); // forma
        
    	/* CONFIGURACIONES */
        setOpaque(false);
        setLayout(null);
        setBackground(Color.WHITE);
        
    	// Panel de arriba
        Central.setBackground(SystemColor.control);
        Central.setBounds(0, 0, 700, 460);
        add(Central);
    	Central.addTab("Crear", Crear);
    	Central.addTab("Modificar", Modificar);
    	Central.addTab("Consultar", Consultar);
    	
    	// BOTON PARA SACAR MENSAJE
    	btnMissatge = new JButton("Error");
        btnMissatge.setBounds(0,475,75,25);
        btnMissatge.setBackground(SystemColor.activeCaption);
        add(btnMissatge);
        
    	Errores = new JTextField();
    	Errores.setEditable(false);
        Errores.setBackground(SystemColor.white);
        Errores.setBounds(75,475,625,25);
        Errores.setVisible(true);
        Errores.setForeground(Color.red);
    	add(Errores);
        
    	// FILECHOOSERS
        FrameCargar.setBackground(SystemColor.activeCaption); 
        Central.addTab("Cargar", FrameCargar); 
        FrameCargar.setLayout(null);
        Cargar.setBounds(0, 0, 690, 390); 
        Cargar.setAutoscrolls(true); 
        Cargar.setMinimumSize(new Dimension(200, 245)); 
        Cargar.setPreferredSize(new Dimension(365, 200)); 
        FrameCargar.add(Cargar);
    	
        FrameGuardar.setBackground(SystemColor.activeCaption); 
        Central.addTab("Guardar", FrameGuardar); 
        FrameGuardar.setLayout(null);
        Guardar.setBounds(0, 0, 690, 390); 
        Guardar.setAutoscrolls(true); 
        Guardar.setMinimumSize(new Dimension(200, 245)); 
        Guardar.setPreferredSize(new Dimension(365, 200)); 
        FrameGuardar.add(Guardar); 
        
        // CREAR
        Crear.setBorder(null);
        Crear.setBackground(SystemColor.activeCaption);
        Crear.setLayout(null);
        
        AmbForma.setSelected(true);
        AmbForma.setBounds(200, 25, 200, 50);
        AmbForma.setBackground(SystemColor.activeCaption);
        group1.add(AmbForma);
        
        SenseForma.setSelected(false);        
        SenseForma.setBounds(400, 25, 200, 50);
        SenseForma.setBackground(SystemColor.activeCaption);
        group1.add(SenseForma);
        
        Crear.add(AmbForma);
        Crear.add(SenseForma);
        
        label2.setBorder(new CompoundBorder()); // nombre
        label2.setBounds(100, 75, 100, 100); 
        Crear.add(label2);
        textfield1.setBounds(200, 113, 200, 25);
        Crear.add(textfield1);
        label3.setBorder(new CompoundBorder()); // limite
        label3.setBounds(100, 175, 100, 100);
        Crear.add(label3);
        textfield2.setBounds(200, 213, 200, 25);
        Crear.add(textfield2);
        label4.setBorder(new CompoundBorder()); // forma
        label4.setBounds(100, 275, 100, 100);
        Crear.add(label4);
        textfield3.setBounds(200, 313, 200, 25);
        Crear.add(textfield3);
        
        btnCrearNovaGalaxia.setIcon(null);
        btnCrearNovaGalaxia.setBounds(500, 350, 150, 50);
        Crear.add(btnCrearNovaGalaxia);
        // -crear done
        // MODIFICAR
        Modificar.setBorder(null);
        Modificar.setBackground(SystemColor.activeCaption);
        Modificar.setLayout(null);
        
        label10.setForeground(SystemColor.activeCaptionText); // configuracio actual
        label10.setBounds(75, -10, 200, 100);
        Modificar.add(label10);
        label11.setForeground(SystemColor.activeCaptionText); // configuracio nova
        label11.setBounds(75, 155, 200, 100);
        Modificar.add(label11);
        
        AmbForma1.setSelected(true); // comenco amb forma marcat
        AmbForma1.setBounds(200, 180, 100, 50);
        AmbForma1.setBackground(SystemColor.activeCaption);
        group2.add(AmbForma1);
        
        SenseForma1.setSelected(false);        
        SenseForma1.setBounds(295, 180, 100, 50);
        SenseForma1.setBackground(SystemColor.activeCaption);
        group2.add(SenseForma1);
        
        Modificar.add(AmbForma1);
        Modificar.add(SenseForma1);
        
        label6.setForeground(SystemColor.activeCaptionText); // nombre actual
        label6.setBounds(75, 30, 100, 100);
        Modificar.add(label6);
        textfield4.setDisabledTextColor(SystemColor.desktop);
        textfield4.setEnabled(false);
        textfield4.setForeground(Color.BLACK);
        textfield4.setBounds(125, 70, 200, 25);
             
        Modificar.add(textfield4);

        label7.setForeground(SystemColor.activeCaptionText); // nombre nuevo
        label7.setBounds(75, 200, 100, 100);
        Modificar.add(label7);
        textfield5.setDisabledTextColor(SystemColor.desktop);
        textfield5.setEnabled(true);
        textfield5.setForeground(Color.BLACK);
        textfield5.setBounds(125, 240, 200, 25);
        Modificar.add(textfield5);

        label8.setForeground(SystemColor.activeCaptionText); // limite actual
        label8.setBounds(75, 100, 100, 100);
        Modificar.add(label8);
        textfield6.setDisabledTextColor(SystemColor.desktop);
        textfield6.setEnabled(false);
        textfield6.setForeground(Color.BLACK);
        textfield6.setBounds(125, 140, 200, 25);
        
        Modificar.add(textfield6);
        label9.setForeground(SystemColor.activeCaptionText); // limite nuevo
        label9.setBounds(75, 270, 100, 100);
        Modificar.add(label9);
        textfield7.setDisabledTextColor(SystemColor.desktop);
        textfield7.setEnabled(true);
        textfield7.setForeground(Color.BLACK);
        textfield7.setBounds(125, 310, 200, 25);
        Modificar.add(textfield7);
        
        label12.setForeground(SystemColor.activeCaptionText); // forma actual
        label12.setBounds(360, 30, 100, 100);
        Modificar.add(label12);

        label13.setForeground(SystemColor.activeCaptionText); // forma nuevo
        label13.setBounds(75, 345, 100, 100);
        Modificar.add(label13);
        textfield9.setDisabledTextColor(SystemColor.desktop);
        textfield9.setEnabled(true);
        textfield9.setForeground(Color.BLACK);
        textfield9.setBounds(125, 380, 200, 25);
        Modificar.add(textfield9);
        
        btnModificarGalaxia.setIcon(null);
        btnModificarGalaxia.setBounds(500, 350, 150, 50);
        Modificar.add(btnModificarGalaxia);
        
        // BOTON PARA CONSULTA
        Consultar.setBorder(null);
        Consultar.setBackground(SystemColor.activeCaption);
        Consultar.setLayout(null);
        
        label14.setForeground(SystemColor.activeCaptionText);
        label14.setBounds(75, 30, 100, 100);
        Consultar.add(label14);
        label15.setForeground(SystemColor.activeCaptionText);
        label15.setBounds(75, 100, 100, 100);
        Consultar.add(label15);
        label16.setForeground(SystemColor.activeCaptionText); // forma, mirar como ponerlo si no tiene
        label16.setBounds(75, 170, 100, 100);
        Consultar.add(label16);
        
        textfield10.setDisabledTextColor(SystemColor.desktop); // NOMBRE
        textfield10.setEnabled(false);
        textfield10.setForeground(Color.BLACK);
        textfield10.setBounds(125, 70, 200, 25);
        Consultar.add(textfield10);
              
        textfield11.setDisabledTextColor(SystemColor.desktop); // LIMITE
        textfield11.setEnabled(false);
        textfield11.setForeground(Color.BLACK);
        textfield11.setBounds(125, 140, 200, 25);
        Consultar.add(textfield11);
                        
    	/* LISTENERS */
        // ACTIVAR O DESACTIVAR CAMPO FORMA
        AmbForma.addActionListener
        (
            new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                            if(!textfield3.isEditable()) {
                                    textfield3.setText("");
                                    textfield3.setEditable(true);
                            }
                    }
	});
        
        SenseForma.addActionListener
        (
            new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                            if(textfield3.isEditable()) {
                                    textfield3.setText("");
                                    textfield3.setEditable(false);
                            }
                    }
	});
        
        AmbForma1.addActionListener
        (
    		new ActionListener() {
		        public void actionPerformed(ActionEvent ae) {
		        	if(!textfield9.isEditable()) {
		        		textfield9.setText("");
		        		textfield9.setEditable(true);
		        	}
		        }
	});
        
        SenseForma1.addActionListener
        (
            new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                            if(textfield9.isEditable()) {
                                    textfield9.setText("");
                                    textfield9.setEditable(false);
                    }
            }
	});
        
        // CREA GALAXIA
        btnCrearNovaGalaxia.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    nomActual = textfield1.getText();
                    LimitActual = textfield2.getText();
                    limitsActual = textfield3.getText();
                    try {
                        if(AmbForma.isSelected()) {
                                cvg.creaGalaxia2(nomActual, LimitActual, limitsActual); // mirar esto
                                CREADA = true;
                                actualitza(true);
                                teForma = true;
                        }
                        else if(SenseForma.isSelected()) {
                                cvg.creaGalaxia(nomActual, LimitActual);
                                CREADA = true;
                                actualitza(false);
                        }
                    }
                    catch (Exception ex) {
                        Errores.setText(ex.getMessage());
                }
                textfield1.setText(""); // quitamos lo que habia en el recuadro
                textfield2.setText("");
                textfield3.setText("");
            }
	});
        
        // MODIFICA GALAXIA
        btnModificarGalaxia.addActionListener
        (
            new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        nomActual = textfield4.getText();
                        LimitActual = textfield5.getText();

                        NomNou = textfield5.getText();
                        LimitNou = textfield7.getText();
                        limitsNous = textfield9.getText();

                        try {
                            if(!NomNou.trim().isEmpty() && !NomNou.equals(cvg.consultarNomGalaxia())) {
                                cvg.modificarNom(NomNou);
                            }
                            if(!LimitNou.trim().isEmpty() && !LimitNou.equals(String.valueOf(cvg.consultarLimit()))) {
                                cvg.modificarLimit(LimitNou);
                                borra();
                            }
                            if(AmbForma1.isSelected()) {
                                 if(!limitsNous.trim().isEmpty() && !limitsNous.equals(cvg.consultarLimits())) {
                                     cvg.modificarLimits(limitsNous);
                                     borra();
                                     teForma = true;
                                 }
                            }
                            if(SenseForma1.isSelected()) {
                                borra();
                                teForma = false;
                            }
                            actualitza2(teForma);
                        }
                        catch (Exception e) { 
                            Errores.setText(e.getMessage()); 
                        }
                        textfield5.setText(""); // quitamos lo que habia en el recuadro
                        textfield7.setText("");
                        textfield9.setText("");
                    }
        });
        
        Cargar.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                    path = Cargar.getSelectedFile().getAbsolutePath();
                    try {
                        cvg.carregarGalaxia(path);
                        borra();
                        teForma = (cvg.consultarNombreLimits() > 0);
                        CREADA = true;
                        actualitza(teForma);
                        Errores.setText("Se ha cargado el archivo " + path);
                    } 
                    catch (Exception e1) {
                        Errores.setText(e1.getMessage());
                    }
                }
        });
        
        Guardar.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                    path = Guardar.getSelectedFile().getAbsolutePath();
                    try {
                        cvg.guardarGalaxia(path);
                        Errores.setText("Se ha guardado el archivo en " + path); 
                    } 
                    catch (Exception e1) {
                        Errores.setText(e1.getMessage());
                    }            
                }
        });
        
        btnMissatge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Errores.setText("");
            }
        });        
    }
}

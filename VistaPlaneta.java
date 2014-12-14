
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
 
 
public class VistaPlaneta extends PrimerNivel {
    
    //Componentes vista
    private ControladorVistaPlaneta CVP;
    private ArrayList<String> listado;
    private DefaultListModel<String> mlistado;
    private DefaultListModel<String> mlistadoPlanetas;
    
    //Paneles
    private JScrollPane ScrollPlanetasConsulta;
    
    
    //Botones
    private JButton CrearPlaneta;
    private JButton ModificarPlaneta;
    
    //Casillas
    private JRadioButton Manual;
    private JRadioButton Automatico;
    private JRadioButton AutomaticoCN;
    
    //Listas
    private JList<String> listaScroll1;
    public void actualiza() {
        try {
            mlistado.removeAllElements();
            listado = CVP.ConsultarNombresPlanetas();
            CB.removeAllItems();
            CB.setEditable(false);
            if (listado.size() != 0) {  
                CB.setEditable(true);
                for (String s : listado) CB.addItem(s);
                for (String p : listado) mlistado.addElement(p);
                CB.revalidate();
                CB.repaint();
                listaScroll1.setModel(mlistado);
                listaScroll1.revalidate();
                listaScroll1.repaint();
            }        
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
    public VistaPlaneta(ControladorVistaPlaneta ControladorVP) {
        CVP = ControladorVP;
        setOpaque(false);          
        setBackground(Color.WHITE); //Marco
        setLayout(null);
        
        listado = new ArrayList<String>();
        mlistado = new DefaultListModel<String>();
        // list 1
        //scrollPanel
        
        CB = new JComboBox<String>();
        CB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String n = CB.getSelectedItem().toString();
                    if(!n.equals("")){
                        Errores.setText("");
                        textfield1.setText(n);
                        textfield2.setText(CVP.ConsultarCoste(n));
                        textfield3.setText(CVP.ConsultarCoordenadaX(n));
                        textfield4.setText(CVP.ConsultarCoordenadaY(n));
                        actualiza();
                    }   
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        Central = new JTabbedPane(JTabbedPane.TOP);
        Central.setBackground(SystemColor.activeCaption);
        Central.setBounds(50, 50, 700, 500); //A la espera de consenso
        add(Central);
        
        Crear = new JPanel();
        Crear.setBackground(SystemColor.activeCaption);
        Crear.setBounds(0, 0, 700, 500);
        Central.addTab("Crear",null,Crear,null);
        Crear.setLayout(null);
        
        Manual = new JRadioButton("Manual");
        Manual.setSelected(false); 
        Manual.setBounds(400, 115, 120, 20);
        Crear.add(Manual);
        
        Automatico = new JRadioButton("Automatico");
        Automatico.setSelected(false);
        Automatico.setBounds(400, 165, 120, 20);
        Crear.add(Automatico);
        
        AutomaticoCN = new JRadioButton("Automatico con Nombre");
        AutomaticoCN.setSelected(false);
        AutomaticoCN.setBounds(400, 215, 120, 20);
        Crear.add(AutomaticoCN);
        
        
        label1 = new JLabel("Nombre :");
        label1.setBounds(50, 115, 50, 35); //Esperando
        Crear.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setBounds(180, 115, 120, 35); //Esperando
        Crear.add(textfield1);
        textfield1.setColumns(10);  //??????
        textfield1.setEnabled(false);
        
        label2 = new JLabel ("Coste :");
        label2.setBounds(50, 165, 50, 3); //Esperar
        Crear.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setBounds(180, 165, 120, 35); //Esperar
        Crear.add(textfield2);
        textfield2.setColumns(10);
        textfield2.setEnabled(false);
        
        label3 = new JLabel("X :");
        label3.setBounds(50, 215, 50, 35); //Esperar
        Crear.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setBounds(180, 215, 120, 35); //Esperar
        Crear.add(textfield3);
        textfield3.setColumns(10);
        textfield3.setEnabled(false);
                
        label4 = new JLabel("Y :");
        label4.setBounds(50, 265, 50, 35); //Esperar
        Crear.add(label3);
        
        textfield4 = new JTextField();
        textfield4.setBounds(180, 265, 120, 35); //Esperar
        Crear.add(textfield4);
        textfield4.setColumns(10);
        textfield4.setEnabled(false);
        
        Manual.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()) {
                        textfield1.setEnabled(true);
                        textfield2.setEnabled(true);
                        textfield3.setEnabled(true);
                        textfield4.setEnabled(true);
                        Automatico.setSelected(false);
                        AutomaticoCN.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        Automatico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Automatico.isSelected()) {
                        textfield1.setEnabled(false);
                        textfield2.setEnabled(false);
                        textfield3.setEnabled(false);
                        textfield4.setEnabled(false);
                        Manual.setSelected(false);
                        AutomaticoCN.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        AutomaticoCN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(AutomaticoCN.isSelected()) {
                        textfield1.setEnabled(true);
                        textfield2.setEnabled(false);
                        textfield3.setEnabled(false);
                        textfield4.setEnabled(false);
                        Manual.setSelected(false);
                        Automatico.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        CrearPlaneta = new JButton("Crear");
        CrearPlaneta.setIcon(null);
        CrearPlaneta.setBounds(50, 385, 120, 50);
        Crear.add(CrearPlaneta);
        /*
        HelpNombre = new JLabel("");
        HelpNombre.setToolTipText("El Nombre tiene que estar compuesto por caracteres alfanumericos.");
        HelpNombre.setIcon(null);
        */
        
        CrearPlaneta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()){
                        String n = textfield1.getText();
                        String c = textfield2.getText();
                        String x = textfield3.getText();
                        String y = textfield4.getText();
                        CVP.CrearPlaneta(n, c, x, y);
                        actualiza();
                    }
                    if(Automatico.isSelected()) {
                        CVP.CrearPlaneta();
                        actualiza();
                    }
                    else {
                        String n = textfield1.getText();
                        CVP.CrearPlaneta(n);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                textfield1.setText("");
                textfield2.setText("");
                textfield3.setText("");
                textfield4.setText("");
            }
        });
        
        Modificar = new JPanel();
        Modificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Modificar", null,Modificar,null);
        Modificar.setBounds(0, 0, 700, 500);
        Modificar.setLayout(null);
        
        label1 = new JLabel("Nombre :");
        label1.setBounds(50, 115, 50, 35); //Esperando
        Modificar.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setBounds(180, 115, 120, 35); //Esperando
        Modificar.add(textfield1);
        textfield1.setColumns(10);  //??????
        
        label2 = new JLabel ("Coste :");
        label2.setBounds(50, 165, 50, 3); //Esperar
        Modificar.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setBounds(180, 165, 120, 35); //Esperar
        Modificar.add(textfield2);
        textfield2.setColumns(10);
        textfield2.setEnabled(false);
        
        label3 = new JLabel("X :");
        label3.setBounds(50, 215, 50, 35); //Esperar
        Modificar.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setBounds(180, 215, 120, 35); //Esperar
        Modificar.add(textfield3);
        textfield3.setColumns(10);
        textfield3.setEnabled(false);
                
        label4 = new JLabel("Y :");
        label4.setBounds(50, 265, 50, 35); //Esperar
        Modificar.add(label3);
        
        textfield4 = new JTextField();
        textfield4.setBounds(180, 265, 120, 35); //Esperar
        Modificar.add(textfield4);
        textfield4.setColumns(10);
        textfield4.setEnabled(false);
        
        
        label5 = new JLabel ("Coste :");
        label5.setBounds(350, 165, 50, 3); //Esperar
        Modificar.add(label5);
        
        textfield5 = new JTextField();
        textfield5.setBounds(530, 165, 120, 35); //Esperar
        Modificar.add(textfield5);
        textfield5.setColumns(10);
        
        
        label6 = new JLabel("X :");
        label6.setBounds(350, 215, 50, 35); //Esperar
        Modificar.add(label6);
        
        textfield6 = new JTextField();
        textfield6.setBounds(530, 215, 120, 35); //Esperar
        Modificar.add(textfield6);
        textfield6.setColumns(10);
                
        label7 = new JLabel("Y :");
        label7.setBounds(350, 265, 50, 35); //Esperar
        Modificar.add(label7);
        
        textfield7 = new JTextField();
        textfield7.setBounds(530, 265, 120, 35); //Esperar
        Modificar.add(textfield7);
        textfield7.setColumns(10);
        
        ModificarPlaneta = new JButton("Modificar");
        ModificarPlaneta.setIcon(null);
        ModificarPlaneta.setBounds(290, 270, 120, 50);
        Modificar.add(ModificarPlaneta);
        ModificarPlaneta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String nac = textfield1.getText();
                    String c = textfield5.getText();
                    String x = textfield6.getText();
                    String y = textfield7.getText();
                    if(!c.isEmpty()) CVP.ModificarCoste(nac, c);
                    if(!x.isEmpty() && !y.isEmpty()) CVP.ModificarCoordenadas(nac, x, y);
                    else if(x.isEmpty() && !y.isEmpty()) CVP.ModificarCoordenadas(nac, CVP.ConsultarCoordenadaX(nac), y);
                    else if(y.isEmpty() && !x.isEmpty()) CVP.ModificarCoordenadas(nac, x, CVP.ConsultarCoordenadaY(nac));
                    
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                textfield1.setText("");
                textfield2.setText("");
                textfield3.setText("");
                textfield4.setText("");
                textfield5.setText("");
                textfield6.setText("");
                textfield7.setText("");
            }
        });
        
        Consultar = new JPanel();
        Consultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Consultar",null,Consultar,null);
        Consultar.setLayout(null);
        
        label1 = new JLabel("Nombre :");
        label1.setBounds(200, 115, 50, 35);
        Consultar.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setColumns(10);
        textfield1.setBounds(380, 115, 120, 35);
        Consultar.add(textfield1);
        
        label2 = new JLabel("Coste :");
        label2.setBounds(200, 165, 50, 35);
        Consultar.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setColumns(10);
        textfield2.setBounds(380, 165, 120, 35);
        Consultar.add(textfield2);
        
        label3 = new JLabel("X :");
        label3.setBounds(200, 215, 50, 35);
        Consultar.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setColumns(10);
        textfield3.setBounds(380, 215, 120, 35);
        Consultar.add(textfield3);
        
        label3 = new JLabel("Y :");
        label3.setBounds(200, 265, 50, 35);
        Consultar.add(label3);
        
        textfield4 = new JTextField();
        textfield4.setColumns(10);
        textfield4.setBounds(380, 265, 120, 35);
        Consultar.add(textfield4);
        
        FrameGuardar = new JInternalFrame();
        FrameGuardar.setBackground(SystemColor.activeCaption);
        Central.addTab("Guardar", null, FrameGuardar, null);
        FrameGuardar.setLayout(null);
        
        Guardar = new JFileChooser();
        Guardar.setBounds(0, 0, 700, 500);
        Guardar.setAutoscrolls(true);
        Guardar.setPreferredSize(new Dimension(WIDTH,WIDTH));
        FrameGuardar.add(Guardar);
        Guardar.setDialogTitle("Guardar");
        
        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    String path = Guardar.getSelectedFile().getAbsolutePath();
                    CVP.GuardarPlanetas(path);
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        FrameCargar = new JInternalFrame();
        FrameCargar.setBackground(SystemColor.activeCaption);
        Central.addTab("Cargar", null, FrameCargar, null);
        FrameCargar.setLayout(null);
        
        Cargar = new JFileChooser();
        Cargar.setBounds(0, 0, 700, 500);
        Cargar.setAutoscrolls(true);
        Cargar.setPreferredSize(new Dimension(WIDTH,WIDTH));
        FrameCargar.add(Cargar);
        Cargar.setDialogTitle("Cargr");
        
        Cargar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try{
                    String path = Cargar.getSelectedFile().getAbsolutePath();
                    CVP.CargarPlanetas(path);
                    actualiza();
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
    }
}

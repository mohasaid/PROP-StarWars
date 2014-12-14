
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gerard
 */
public class VistaRuta extends PrimerNivel{
    
    public VistaRuta ObtenerVista() {
        return this;
    }
    //Componentes vista
    private ControladorVistaRuta CVR;
    private ArrayList<String> listado;
    private DefaultListModel<String> mlistado;
    private DefaultListModel<String> mlistadoPlanetas;
    private JComboBox<String> CBRutas;
    
    /*
    //Cajas Atributos
    private JTextField textfield1;
    private JTextField textfield2;
    private JTextField textfield3;
    private JTextField textfield4;
    private JTextField textfield5;
    private JTextField textfield6;
    private JTextField textfield7;
    private JTextField textfield8;
    private JTextField textfield9;
  
    
    //Paneles
    private Panel Crear;
    private Panel Modificar;
    private Panel Consultar;
    private Panel Guardar;
    private Panel Cargar;
   

    //Etiquetas
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    */
    
    //Botones
    private JButton CrearRuta;
    private JButton CrearRutaAuto;
    private JButton CrearRutaAutoId;
    private JButton Modificar_btn;
    
    //Casillas
    private JRadioButton Manual;
    private JRadioButton Automatico;
    private JRadioButton AutomaticoCId;
    
    //Listas
    private JList<String> listaScroll1;
    private JList<String> listaScroll2;
    private JComboBox <String> CBRConsulta;
    
    
    public void actualiza() {
        try {
            mlistado.removeAllElements();
            listado = CVR.obtenerIdRutas();
            CBRutas.removeAllItems();
            CBRutas.setEditable(false);
            if (listado.size() != 0) {  
                CBRutas.setEditable(true);
                for (String s : listado) CBRutas.addItem(s);
                for (String p : listado) mlistado.addElement(p);
                CBRutas.revalidate();
                CBRutas.repaint();
                listaScroll1.setModel(mlistado);
                listaScroll1.revalidate();
                listaScroll1.repaint();
            }        
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
    public VistaRuta(ControladorVistaRuta ControladorVR) {
        CVR = ControladorVR;
        //setOpaque(false);          
        setBackground(Color.WHITE); //Marco
        setLayout(null);
        
        listado = new ArrayList<String>();
        mlistado = new DefaultListModel<String>();
        mlistadoPlanetas = new DefaultListModel<String>();
        // list 1
        //scrollPanel
        
        CBRutas = new JComboBox<String>();
        CBRutas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String n = CBRutas.getSelectedItem().toString();
                    if(!n.equals("")){
                        Errores.setText("");
                        textfield1.setText(n);
                        textfield2.setText(CVR.ConsultarCapacidadRuta(n));
                        textfield3.setText(CVR.ConsultarDistanciaRuta(n));
                        textfield4.setText(CVR.ConsultarPlanetaARuta(n));
                        textfield5.setText(CVR.ConsultarPlanetaBRuta(n));
                    }   
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        Central = new JTabbedPane(JTabbedPane.TOP);
        Central.setBackground(SystemColor.activeCaption);
        Central.setBounds(50,100,700,500);
        add(Central);
        
        Crear = new JPanel();
        Crear.setBackground(SystemColor.activeCaption);
        Central.addTab("Crear",null,Crear,null);
        Crear.setLayout(null);
        
        
        Manual = new JRadioButton("Manual");
        Manual.setSelected(false); 
        Manual.setBounds(400, 100, 50, 100);
        Crear.add(Manual);
        
        int aux = 150;
        
        Automatico = new JRadioButton("Automatico");
        Automatico.setSelected(false);
        Automatico.setBounds(400, 250, 50, 100);
        Crear.add(Automatico);
        
        AutomaticoCId = new JRadioButton("Automatico con Id");
        AutomaticoCId.setSelected(false);
        AutomaticoCId.setBounds(400, 350, 50, 100);
        Crear.add(AutomaticoCId);
        
        int aux1 = 75;
        int aux2 = 75;
        int aux3 = 30;
        int aux3_2 = aux3+35;
        int aux4 = 50;
        label1 = new JLabel("Id :");
        label1.setBounds(aux1, aux2, aux3, aux4); //Esperando
        Crear.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setBounds(aux1, aux2, aux3_2, aux4); //Esperando
        Crear.add(textfield1);
        textfield1.setColumns(10);  //??????
        textfield1.setEnabled(false);
        
        aux2+=80;
        label2 = new JLabel ("Capacidad :");
        label2.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setBounds(aux1, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield2);
        textfield2.setColumns(10);
        textfield2.setEnabled(false);
        
        aux2+=80;
        label3 = new JLabel ("Distancia :");
        label3.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setBounds(aux1, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield3);
        textfield3.setColumns(10);
        textfield3.setEnabled(false);
        
        aux2+=80;
        label4 = new JLabel("Planeta A :");
        label4.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label4);
        
        textfield4 = new JTextField();
        textfield4.setBounds(aux1, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield4);
        textfield4.setColumns(10);
        textfield4.setEnabled(false);
             
        aux2+=80;
        label5 = new JLabel("Planeta B :");
        label5.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label4);
        
        textfield5 = new JTextField();
        textfield5.setBounds(aux1, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield5);
        textfield5.setColumns(10);
        textfield5.setEnabled(false);
        
        Manual.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()) {
                        textfield1.setEnabled(true);
                        textfield2.setEnabled(true);
                        textfield4.setEnabled(true);
                        textfield5.setEnabled(true);
                        Automatico.setSelected(false);
                        AutomaticoCId.setSelected(false);
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
                        textfield4.setEnabled(false);
                        textfield5.setEnabled(false);
                        Manual.setSelected(false);
                        AutomaticoCId.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        AutomaticoCId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(AutomaticoCId.isSelected()) {
                        textfield1.setEnabled(true);
                        textfield2.setEnabled(false);
                        textfield4.setEnabled(false);
                        textfield5.setEnabled(false);
                        Manual.setSelected(false);
                        Automatico.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        CrearRuta = new JButton("Crear");
        CrearRuta.setIcon(null);
        /*
        HelpNombre = new JLabel("");
        HelpNombre.setToolTipText("El Nombre tiene que estar compuesto por caracteres alfanumericos.");
        HelpNombre.setIcon(null);
        */
        
        CrearRuta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()){
                        String n = textfield1.getText();
                        String c = textfield2.getText();
                        String d = textfield3.getText();
                        String x = textfield4.getText();
                        String y = textfield5.getText();
                        CVR.creaRuta(n,c,d,x,y);
                        actualiza();
                    }
                    if(Automatico.isSelected()) {
                        CVR.creaRutaAut();
                        actualiza();
                    }
                    else {
                        String n = textfield1.getText();
                        CVR.creaRutaAut_id(n);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                textfield1.setText("");
                textfield2.setText("");
                textfield3.setText("");
                textfield4.setText("");
                textfield5.setText("");
            }
        });
     
        CrearRuta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Crear.add(CrearRuta);
        
        Modificar = new JPanel();
        Modificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Modificar", null,Modificar,null);
        Modificar.setLayout(null);
        
        label1 = new JLabel("Id :");
        label1.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        Modificar.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        Modificar.add(textfield1);
        textfield1.setColumns(10);  //??????
        
        label2 = new JLabel ("Capacidad :");
        label2.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        textfield2.setEnabled(false);
        Modificar.add(textfield2);
        textfield2.setColumns(10);
        
        label3 = new JLabel ("Distancia :");
        label3.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        textfield3.setEnabled(false);
        Modificar.add(textfield3);
        textfield3.setColumns(10);
        
        label4 = new JLabel("Planeta A :");
        label4.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(label4);
        
        textfield4 = new JTextField();
        textfield4.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        textfield4.setEnabled(false);
        Modificar.add(textfield4);
        textfield4.setColumns(10);
        
        label5 = new JLabel("Planeta B :");
        label5.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(label4);
        
        textfield5 = new JTextField();
        textfield5.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        textfield5.setEnabled(false);
        Modificar.add(textfield5);
        textfield5.setColumns(10);
        
        label6 = new JLabel ("Capacidad nueva :");
        label6.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(label6);
        
        textfield6 = new JTextField();
        textfield6.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(textfield6);
        textfield6.setColumns(10);
        
        label7 = new JLabel ("Distancia nueva :");
        label7.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(label7);
        
        textfield7 = new JTextField();
        textfield7.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(textfield7);
        textfield7.setColumns(10);
        
        label8 = new JLabel("Planeta A nuevo :");
        label8.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(label8);
        
        textfield8 = new JTextField();
        textfield8.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(textfield8);
        textfield8.setColumns(10);
        
        label9 = new JLabel("Planeta B nuevo :");
        label9.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(label8);
        
        textfield9 = new JTextField();
        textfield9.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Modificar.add(textfield9);
        textfield9.setColumns(10);
        
        Modificar_btn = new JButton("Modificar");
        Modificar_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String nac = textfield1.getText();
                    String c = textfield6.getText();
                    String d = textfield7.getText();
                    String x = textfield8.getText();
                    String y = textfield9.getText();
                    if(!c.isEmpty()) CVR.ModificarCapacidadRuta(nac,c);
                    if(!d.isEmpty()) CVR.ModificarDistanciaRuta(nac,d);
                    if(!x.isEmpty()) CVR.ModificarPlanetaARuta(nac,x);
                    if(!y.isEmpty()) CVR.ModificarPlanetaBRuta(nac,y);
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
                textfield8.setText("");
                textfield9.setText("");
            }
        });
        
        Consultar = new JPanel();
        Consultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Consultar",null,Consultar,null);
        Consultar.setLayout(null);
        
        CBRConsulta = new JComboBox<String>();
        CBRConsulta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(CBRConsulta);
        
        label1 = new JLabel("Id :");
        label1.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setColumns(10);
        textfield1.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(textfield1);
        
        label2 = new JLabel("Capacidad :");
        label2.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setColumns(10);
        textfield2.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(textfield2);
        
        label3 = new JLabel("Distancia :");
        label3.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setColumns(10);
        textfield3.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(textfield3);
        
        label4 = new JLabel("Planeta A :");
        label4.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(label4);
        
        textfield4 = new JTextField();
        textfield4.setColumns(10);
        textfield4.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(textfield4);
        
        label4 = new JLabel("Planeta B :");
        label4.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(label4);
        
        textfield5 = new JTextField();
        textfield5.setColumns(10);
        textfield5.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(textfield5);
        
        Guardar = new JFileChooser();
        Guardar.setBackground(SystemColor.activeCaption);
        Central.addTab("Guardar", null, Guardar, null);
        Guardar.setLayout(null);
        
        Guardar = new JFileChooser();
        Guardar.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Guardar.setAutoscrolls(true);
        Guardar.setPreferredSize(new Dimension(WIDTH,WIDTH));
        Guardar.add(Guardar);
        Guardar.setDialogTitle("Guardar");
        
        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    String path = Guardar.getSelectedFile().getAbsolutePath();
                    CVR.GuardarRutas(path);
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        Cargar = new JFileChooser();
        Cargar.setBackground(SystemColor.activeCaption);
        Central.addTab("Cargar", null, Cargar, null);
        Cargar.setLayout(null);
        
        Cargar = new JFileChooser();
        Cargar.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Cargar.setAutoscrolls(true);
        Cargar.setPreferredSize(new Dimension(WIDTH,WIDTH));
        Cargar.add(Cargar);
        Cargar.setDialogTitle("Cargr");
        
        Cargar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try{
                    String path = Cargar.getSelectedFile().getAbsolutePath();
                    CVR.CargarRutas(path);
                    actualiza();
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
    }
}

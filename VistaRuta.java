
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
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
    private ArrayList<String> listado1;
    private ArrayList<String> listado2;
    private DefaultListModel<String> mlistado;
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
    private JButton Modificar_btn;
    
    //Casillas
    private JRadioButton Manual;
    private JRadioButton Automatico;
    private JRadioButton AutomaticoCId;
    
    //Listas
    private JList<String> listaScroll1;
    private JList<String> listaScroll2;
    private JScrollPane Scroll;
    
    private int i;
    private int j;
    
    
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
    
    public void actualizaListaUP(){
        try{
            if(i-100>=0){
                j=i;
                i-=100;
                mlistado.removeAllElements();
                listado2.clear();
                for(String e : listado1) listado2.add(e);
                listado1 = CVR.obtenerIdRutas();
                for(String e : listado1) mlistado.addElement(e);
                for(String e : listado2) mlistado.addElement(e);
                listaScroll2.setModel(mlistado);
                listaScroll2.revalidate();
                listaScroll2.repaint();
            }
        }    
        catch (Exception e) {
            Errores.setText(e.getMessage());
        }
    }
    
     public void actualizaListaDown(){
        try{
            if(j+100<CVR.ConsultarNumeroRutes()){
                i=j;
                j+=100;
                mlistado.removeAllElements();
                listado1.clear();
                for(String e : listado2) listado1.add(e);
                listado2 = CVR.obtenerIdRutas();
                for(String e : listado1) mlistado.addElement(e);
                for(String e : listado2) mlistado.addElement(e);
                listaScroll2.setModel(mlistado);
                listaScroll2.revalidate();
                listaScroll2.repaint();
            }
        }
        catch (Exception e) {
            Errores.setText(e.getMessage());
        }
    }
    
    public VistaRuta(ControladorVistaRuta ControladorVR) {
        CVR = ControladorVR;
        //setOpaque(false);          
        setBackground(Color.WHITE); //Marco
        setLayout(null);
        
        listaScroll1 = new JList<String>();
        listaScroll2 = new JList<String>();
        
        listado = new ArrayList<String>();
        listado1 = new ArrayList<String>();
        listado2 = new ArrayList<String>();
        mlistado = new DefaultListModel<String>();
        
        textfield1 = new JTextField();
        textfield2 = new JTextField();
        textfield3 = new JTextField();
        textfield4 = new JTextField();
        textfield5 = new JTextField();
        textfield6 = new JTextField();
        textfield7 = new JTextField();
        textfield8 = new JTextField();
        textfield9 = new JTextField();
        
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();

        label20 = new JLabel("   Error");
        label20.setBounds(50,620,75,30);
        label20.setOpaque(true);
        label20.setBackground(SystemColor.activeCaption);
        add(label20);
        Errores = new JTextField();
        Errores.setEditable(false);
        Errores.setBackground(SystemColor.activeCaption);
        Errores.setBounds(125, 620, 780, 30);
        add(Errores);
        Errores.setVisible(true);
        
        Scroll = new JScrollPane();
        listaScroll2 = new JList(mlistado);
        listaScroll2.setVisibleRowCount(10);
        listaScroll2.setValueIsAdjusting(true);
        listaScroll2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaScroll2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null));
        listaScroll2.setBackground(SystemColor.inactiveCaptionBorder);
        Scroll.setViewportView(listaScroll2);
        Scroll = new JScrollPane(listaScroll2);
        Scroll.setBounds(780,180,120,420);
        Scroll.setPreferredSize(new Dimension(152,217));
        add(Scroll);
        AdjustmentListener adjustmentListener = new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
                if(Scroll.getVerticalScrollBar().getValue()== Scroll.getVerticalScrollBar().getMaximum()-Scroll.getVerticalScrollBar().getVisibleAmount()){
                    actualizaListaDown();
                }
               
                if(Scroll.getVerticalScrollBar().getValue()==Scroll.getVerticalScrollBar().getMinimum()){
                    actualizaListaUP();
                }
                       
            }
        };
               
        Scroll.getVerticalScrollBar().addAdjustmentListener(adjustmentListener);
        
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
        Manual.setBounds(400, 50, 200, 100);
        Manual.setOpaque(false);
        Crear.add(Manual);
        
        Automatico = new JRadioButton("Automatico");
        Automatico.setSelected(false);
        Automatico.setBounds(400, 150, 200, 100);
        Automatico.setOpaque(false);
        Crear.add(Automatico);
        
        AutomaticoCId = new JRadioButton("Automatico con Id");
        AutomaticoCId.setSelected(false);
        AutomaticoCId.setBounds(400, 250, 200, 100);
        AutomaticoCId.setOpaque(false);
        Crear.add(AutomaticoCId);
        
        int aux1 = 75;
        int aux1_2 = aux1+35+50;
        int aux2 = 75;
        int aux3 = 70;
        int aux3_2 = 120;
        int aux4 = 30;
        
        label1 = new JLabel("Id :");
        label1.setBounds(aux1, aux2, aux3, aux4); //Esperando
        Crear.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperando
        Crear.add(textfield1);
        textfield1.setColumns(10);  //??????
        textfield1.setEnabled(false);
        
        aux2+=80;
        label2 = new JLabel ("Capacidad :");
        label2.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield2);
        textfield2.setColumns(10);
        textfield2.setEnabled(false);
        
        aux2+=80;
        label3 = new JLabel ("Distancia :");
        label3.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield3);
        textfield3.setColumns(10);
        textfield3.setEnabled(false);
        
        aux2+=80;
        label4 = new JLabel("Planeta A :");
        label4.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label4);
        
        textfield4 = new JTextField();
        textfield4.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield4);
        textfield4.setColumns(10);
        textfield4.setEnabled(false);
             
        aux2+=80;
        label5 = new JLabel("Planeta B :");
        label5.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label5);
        
        textfield5 = new JTextField();
        textfield5.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield5);
        textfield5.setColumns(10);
        textfield5.setEnabled(false);
        
        Manual.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()) {
                        if (!textfield3.isEditable()) textfield3.setEnabled(true);
                        textfield2.setEnabled(true);
                        textfield4.setEnabled(true);
                        textfield5.setEnabled(true);
                        textfield2.setText("");
                        textfield3.setText("");
                        textfield4.setText("");
                        textfield5.setText("");
                        textfield2.setEditable(true);
                        textfield3.setEditable(true); 
                        textfield4.setEditable(true);
                        textfield5.setEditable(true);   
                        Automatico.setSelected(false);
                        Manual.setSelected(true);
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
                        Automatico.setSelected(true);
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
                        AutomaticoCId.setSelected(true);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        CrearRuta = new JButton("Crear");

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
                        //CVR.creaRuta(n,c,d,x,y);
                        actualiza();
                    }
                    if(Automatico.isSelected()) {
                        //CVR.creaRutaAut();
                        actualiza();
                    }
                    else {
                        String n = textfield1.getText();
                        //CVR.creaRutaAut_id(n);
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
     
        CrearRuta.setBounds(400, 400, 200, 50);
        Crear.add(CrearRuta);
        
        
        
        aux1 = 75;
        aux1_2 = aux1+35+50;
        aux2 = 20;
        aux3 = 70;
        aux3_2 = 120;
        aux4 = 30;
        
        Modificar = new JPanel();
        Modificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Modificar", null,Modificar,null);
        Modificar.setLayout(null);
        
        label1 = new JLabel("Id :");
        label1.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        Modificar.add(textfield1);
        textfield1.setColumns(10);  //??????
        
        aux2+=80;
        label2 = new JLabel ("Capacidad :");
        label2.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield2.setEnabled(false);
        Modificar.add(textfield2);
        textfield2.setColumns(10);
        
        aux2+=80;
        label3 = new JLabel ("Distancia :");
        label3.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield3.setEnabled(false);
        Modificar.add(textfield3);
        textfield3.setColumns(10);
        
        aux2+=80;
        label4 = new JLabel("Planeta A :");
        label4.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label4);
        
        textfield4 = new JTextField();
        textfield4.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield4.setEnabled(false);
        Modificar.add(textfield4);
        textfield4.setColumns(10);
        
        aux2+=80;
        label5 = new JLabel("Planeta B :");
        label5.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label5);
        
        textfield5 = new JTextField();
        textfield5.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield5.setEnabled(false);
        Modificar.add(textfield5);
        textfield5.setColumns(10);
        
        
        aux1 = 350;
        aux1_2 = aux1+35+120;
        aux2 = 100;
        aux3 = 120;
        aux4 = 30;
        
        label6 = new JLabel ("Capacidad nueva :");
        label6.setBounds(aux1,aux2,aux3,aux4); //Esperar
        Modificar.add(label6);
        
        textfield6 = new JTextField();
        textfield6.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperar
        Modificar.add(textfield6);
        textfield6.setColumns(10);
        
        aux2+=80;
        label7 = new JLabel ("Distancia nueva :");
        label7.setBounds(aux1,aux2,aux3,aux4); //Esperar
        Modificar.add(label7);
        
        textfield7 = new JTextField();
        textfield7.setBounds(aux1_2,aux2,aux3_2,aux4);
        Modificar.add(textfield7);
        textfield7.setColumns(10);
        
        aux2+=80;
        label8 = new JLabel("Planeta A nuevo :");
        label8.setBounds(aux1,aux2,aux3,aux4);
        Modificar.add(label8);
        
        textfield8 = new JTextField();
        textfield8.setBounds(aux1_2,aux2,aux3_2,aux4);
        Modificar.add(textfield8);
        textfield8.setColumns(10);
        
        aux2+=80;
        label9 = new JLabel("Planeta B nuevo :");
        label9.setBounds(aux1,aux2,aux3,aux4);
        Modificar.add(label9);
        
        textfield9 = new JTextField();
        textfield9.setBounds(aux1_2,aux2,aux3_2,aux4);
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
                   //if(!c.isEmpty()) CVR.ModificarCapacidadRuta(nac,c);
                    //if(!d.isEmpty()) CVR.ModificarDistanciaRuta(nac,d);
                   // if(!x.isEmpty()) CVR.ModificarPlanetaARuta(nac,x);
                   // if(!y.isEmpty()) CVR.ModificarPlanetaBRuta(nac,y);
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
        Modificar_btn.setBounds(220, 400, 200, 50);
        Modificar.add(Modificar_btn);
        
        aux1 = 200;
        aux1_2 = aux1+50+35;
        aux2 = 75;
        aux3 = 100;
        aux3_2 = 120;
        aux4 = 30;
        
        Consultar = new JPanel();
        Consultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Consultar",null,Consultar,null);
        Consultar.setLayout(null);
        
        CB = new JComboBox<String>();
        CB.setBounds(780,120,120,30);
        add(CB);
        
        label1 = new JLabel("Id :");
        label1.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setColumns(10);
        textfield1.setBounds(aux1_2,aux2,aux3_2,aux4);
        Consultar.add(textfield1);
        

        aux2+=80;
        label2 = new JLabel("Capacidad :");
        label2.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setColumns(10);
        textfield2.setBounds(aux1_2,aux2,aux3_2,aux4);
        Consultar.add(textfield2);
        
        aux2+=80;
        label3 = new JLabel("Distancia :");
        label3.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setColumns(10);
        textfield3.setBounds(aux1_2,aux2,aux3_2,aux4);;
        Consultar.add(textfield3);
        
        aux2+=80;
        label4 = new JLabel("Planeta A :");
        label4.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label4);
        
        textfield4 = new JTextField();
        textfield4.setColumns(10);
        textfield4.setBounds(aux1_2,aux2,aux3_2,aux4);
        Consultar.add(textfield4);
        
        aux2+=80;
        label4 = new JLabel("Planeta B :");
        label4.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label4);
        
        textfield5 = new JTextField();
        textfield5.setColumns(10);
        textfield5.setBounds(aux1_2,aux2,aux3_2,aux4);
        Consultar.add(textfield5);
        
        
        //Guardar y Cargar
        FrameGuardar = new JInternalFrame();
        Guardar = new JFileChooser();
        FrameGuardar.setBackground(SystemColor.activeCaption); 
        Central.addTab("Guardar", FrameGuardar); 
        FrameGuardar.setLayout(null); 
           
        Guardar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {                  
                   
                String path = Guardar.getSelectedFile().getAbsolutePath(); 
                try { 
                   // CVR.GuardarRutas(path);
                    actualiza();   
                } catch (Exception e1) {
                    Errores.setText(e1.getMessage());
                } 
            } 
        }); 
        Guardar.setBounds(0, 0, 670,450); 
        Guardar.setAutoscrolls(true); 
        Guardar.setMinimumSize(new Dimension(200, 245)); 
        Guardar.setPreferredSize(new Dimension(365, 225)); 
        FrameGuardar.add(Guardar); 
        
        //CARGAR
        FrameCargar = new JInternalFrame();
        Cargar = new JFileChooser();
        FrameCargar.setBackground(SystemColor.activeCaption); 
        Central.addTab("Cargar", FrameCargar); 
        FrameCargar.setLayout(null); 
           
        Cargar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {                  
                   
                String path = Cargar.getSelectedFile().getAbsolutePath(); 
                try { 
                 //   CVR.CargarRutas(path);
                    actualiza();                    
                } catch (Exception e1) {
                    Errores.setText(e1.getMessage());
                } 
            } 
        }); 
        Cargar.setBounds(0, 0, 670,450); 
        Cargar.setAutoscrolls(true); 
        Cargar.setMinimumSize(new Dimension(200, 245)); 
        Cargar.setPreferredSize(new Dimension(365, 225)); 
        FrameCargar.add(Cargar); 
           
    }
}

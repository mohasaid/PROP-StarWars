
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JButton Eliminar;
    
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
            listado1 = CVR.ConsultarIdsRutas(i);
            listado2 = CVR.ConsultarIdsRutas(j);
            listado = CVR.ConsultarIdsRutas_string();
            CB.removeAllItems();
            listaScroll1.removeAll();
            if (listado.size() != 0) {  
                CB.setEditable(true);
                for (String s : listado) CB.addItem(s);
                for (String p : listado1) mlistado.addElement(p);
                for (String p : listado2) mlistado.addElement(p);
                System.out.println("listado1: "+listado1);
                System.out.println("listado2: "+listado2);
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
    public void actualizaListaUP(){
        try{
            if(i-100>=0){
                j=i;
                i-=100;
                mlistado.removeAllElements();
                listado2.clear();
                for(String e : listado1) listado2.add(e);
                listado1 = CVR.ConsultarIdsRutas(i);
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
                listado2 = CVR.ConsultarIdsRutas(j);
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
        setOpaque(false);      
        setBackground(Color.WHITE); //Marco
        setBounds(0,0,1000,450);
        setLayout(null);
        i=0;
        j=100;
        
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
        textfield10 = new JTextField();
        textfield11 = new JTextField();
        textfield12 = new JTextField();
        textfield13 = new JTextField();
        textfield14 = new JTextField();
        textfield15 = new JTextField();
        textfield16 = new JTextField();
        textfield17 = new JTextField();
        textfield18 = new JTextField();
        textfield19 = new JTextField();
        textfield20 = new JTextField();
        textfield21 = new JTextField();
        textfield22 = new JTextField();
        textfield23 = new JTextField();
        
        
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
        label20.setBounds(0,475,75,25);
        label20.setOpaque(true);
        label20.setBackground(SystemColor.activeCaption);
        add(label20);
        Errores = new JTextField();
        Errores.setEditable(false);
        Errores.setBackground(SystemColor.white);
        Errores.setBounds(75,475,625,25);
        Errores.setVisible(true);
        Errores.setForeground(Color.red);
        add(Errores);
        
        Scroll = new JScrollPane();
        listaScroll2 = new JList(mlistado);
        listaScroll2.setVisibleRowCount(10);
        listaScroll2.setValueIsAdjusting(true);
        listaScroll2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaScroll2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null)); 
        listaScroll2.setBackground(SystemColor.inactiveCaptionBorder); 
        Scroll.setViewportView(listaScroll2); 
        Scroll = new JScrollPane(listaScroll2);
        Scroll.setBounds(720,65,120,350);
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
   
           
        listaScroll2.addMouseListener(new MouseAdapter () 
        {        
            public void mouseClicked(MouseEvent mouseEvent) {           
              int index = listaScroll1.locationToIndex(mouseEvent.getPoint()); 
              if (index >= 0) { 
                String n = listaScroll1.getModel().getElementAt(index);
                try { 
                        textfield1.setText(n);
                        textfield2.setText(CVR.ConsultarCapacidadRuta(n));
                        textfield3.setText(CVR.ConsultarDistanciaRuta(n));
                        textfield4.setText(CVR.ConsultarPlanetaARuta(n));
                        textfield5.setText(CVR.ConsultarPlanetaBRuta(n));
                        textfield14.setText(n);
                        textfield15.setText(CVR.ConsultarCapacidadRuta(n));
                        textfield16.setText(CVR.ConsultarDistanciaRuta(n));
                        textfield17.setText(CVR.ConsultarPlanetaARuta(n));
                        textfield18.setText(CVR.ConsultarPlanetaBRuta(n));
                } 
                catch (Exception e) { 
                    Errores.setText(e.getMessage()); 
                } 
              } 
            } 
        });
        
        Eliminar = new JButton("Eliminar");
        Eliminar.setBounds(720,65+350+10,120,30);
        add(Eliminar);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            try{
                int selectedIndex = listaScroll2.getSelectedIndex(); 
                if (selectedIndex != -1) { 
                    String n = listaScroll2.getSelectedValue(); 
                    mlistado.removeElement(n);
                    CVR.eliminarRuta(n);
                    actualiza();
                }
            }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        CB = new JComboBox<String>();
        CB.setBounds(720, 15, 120, 30);
        add(CB);
        CB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String n = CB.getSelectedItem().toString();
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
        Central.setBounds(0,0,700,450);
        add(Central);
        
        Crear = new JPanel();
        Crear.setBackground(SystemColor.activeCaption);
        Central.addTab("Crear",null,Crear,null);
        Crear.setLayout(null);
        
        
        Manual = new JRadioButton("Manual");
        Manual.setSelected(false); 
        Manual.setBounds(400, 0, 200, 100);
        Manual.setOpaque(false);
        Crear.add(Manual);
        
        Automatico = new JRadioButton("Automatico");
        Automatico.setSelected(false);
        Automatico.setBounds(400, 100, 200, 100);
        Automatico.setOpaque(false);
        Crear.add(Automatico);
        
        AutomaticoCId = new JRadioButton("Automatico con Identificador");
        AutomaticoCId.setSelected(false);
        AutomaticoCId.setBounds(400, 200, 200, 100);
        AutomaticoCId.setOpaque(false);
        Crear.add(AutomaticoCId);
        
        ButtonGroup gb = new ButtonGroup();
        gb.add(Manual);
        gb.add(Automatico);
        gb.add(AutomaticoCId);
        
        int aux1 = 40;
        int aux1_2 = aux1+35+50+20;
        int aux2 = 25;
        int aux3 = 120;
        int aux3_2 = 120;
        int aux4 = 30;
        
        label1 = new JLabel("Identificador :");
        label1.setBounds(aux1, aux2, aux3, aux4); //Esperando
        Crear.add(label1);
        
        textfield19 = new JTextField();
        textfield19.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperando
        Crear.add(textfield19);
        textfield19.setColumns(10);  //??????
        textfield19.setEnabled(false);
        
        aux2+=80;
        label2 = new JLabel ("Capacidad :");
        label2.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label2);
        
        textfield20 = new JTextField();
        textfield20.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield20);
        textfield20.setColumns(10);
        textfield20.setEnabled(false);
        
        aux2+=80;
        label3 = new JLabel ("Distancia :");
        label3.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label3);
        
        textfield21 = new JTextField();
        textfield21.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield21);
        textfield21.setColumns(10);
        textfield21.setEnabled(false);
        
        aux2+=80;
        label4 = new JLabel("Planeta Origen :");
        label4.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label4);
        
        textfield22 = new JTextField();
        textfield22.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield22);
        textfield22.setColumns(10);
        textfield22.setEnabled(false);
             
        aux2+=80;
        label5 = new JLabel("Planeta Destino :");
        label5.setBounds(aux1, aux2, aux3, aux4); //Esperar
        Crear.add(label5);
        
        textfield23 = new JTextField();
        textfield23.setBounds(aux1_2, aux2, aux3_2, aux4); //Esperar
        Crear.add(textfield23);
        textfield23.setColumns(10);
        textfield23.setEnabled(false);
        
        Manual.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()) {
                        textfield19.setEnabled(true);
                        textfield20.setEnabled(true);
                        textfield21.setEnabled(true);
                        textfield22.setEnabled(true);
                        textfield23.setEnabled(true);
                        textfield19.setText("");
                        textfield20.setText("");
                        textfield21.setText("");
                        textfield22.setText("");
                        textfield23.setText("");  
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
                        textfield19.setEnabled(false);
                        textfield20.setEnabled(false);
                        textfield21.setEnabled(false);
                        textfield22.setEnabled(false);
                        textfield23.setEnabled(false);
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
                        textfield19.setEnabled(true);
                        textfield20.setEnabled(false);
                        textfield21.setEnabled(false);
                        textfield22.setEnabled(false);
                        textfield23.setEnabled(false);
                        textfield19.setText("");
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
                        String n = textfield19.getText();
                        String c = textfield20.getText();
                        String d = textfield21.getText();
                        String x = textfield22.getText();
                        String y = textfield23.getText();
                        CVR.creaRuta(n,c,d,x,y);
                    }
                    if(Automatico.isSelected()) {
                        CVR.creaRutaAut();
                    }
                    else {
                        String n = textfield19.getText();
                        CVR.creaRutaAut_id(n);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                actualiza();
                textfield19.setText("");
                textfield20.setText("");
                textfield21.setText("");
                textfield22.setText("");
                textfield23.setText("");
            }
        });
        CrearRuta.setBounds(400, 350, 200, 50);
        Crear.add(CrearRuta);
        
        
        aux1 = 25;
        aux1_2 = aux1+35+50+20;
        aux2 = 20;
        aux3 = 100;
        aux3_2 = 120;
        aux4 = 30;
        
        Modificar = new JPanel();
        Modificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Modificar", null,Modificar,null);
        Modificar.setLayout(null);
        
        label1 = new JLabel("Identificador :");
        label1.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label1);
        
        textfield14 = new JTextField();
        textfield14.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield14.setEditable(false);
        Modificar.add(textfield14);
        textfield14.setColumns(10);  //??????
        
        aux2+=50;
        label2 = new JLabel ("Capacidad :");
        label2.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label2);
        
        textfield15 = new JTextField();
        textfield15.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield15.setEditable(false);
        Modificar.add(textfield15);
        textfield15.setColumns(10);
        
        aux2+=50;
        label3 = new JLabel ("Distancia :");
        label3.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label3);
        
        textfield16 = new JTextField();
        textfield16.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield16.setEditable(false);
        Modificar.add(textfield16);
        textfield16.setColumns(10);
        
        aux2+=50;
        label4 = new JLabel("Planeta Origen :");
        label4.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label4);
        
        textfield17 = new JTextField();
        textfield17.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield17.setEditable(false);
        Modificar.add(textfield17);
        textfield17.setColumns(10);
        
        aux2+=50;
        label5 = new JLabel("Planeta Destino :");
        label5.setBounds(aux1,aux2,aux3,aux4); //Esperando
        Modificar.add(label5);
        
        textfield18 = new JTextField();
        textfield18.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperando
        textfield18.setEditable(false);
        Modificar.add(textfield18);
        textfield18.setColumns(10);
        
        
        aux1 = 350;
        aux1_2 = aux1+35+120;
        aux2 = 75;
        aux3 = 150;
        aux4 = 30;
        
        label6 = new JLabel ("Capacidad nueva :");
        label6.setBounds(aux1,aux2,aux3,aux4); //Esperar
        Modificar.add(label6);
        
        textfield6 = new JTextField();
        textfield6.setBounds(aux1_2,aux2,aux3_2,aux4); //Esperar
        textfield6.setEnabled(true);
        Modificar.add(textfield6);
        textfield6.setColumns(10);
        
        aux2+=50;
        label7 = new JLabel ("Distancia nueva :");
        label7.setBounds(aux1,aux2,aux3,aux4); //Esperar
        Modificar.add(label7);
        
        textfield7 = new JTextField();
        textfield7.setBounds(aux1_2,aux2,aux3_2,aux4);
        textfield7.setEnabled(true);
        Modificar.add(textfield7);
        textfield7.setColumns(10);
        
        aux2+=50;
        label8 = new JLabel("Planeta Origen nuevo :");
        label8.setBounds(aux1,aux2,aux3,aux4);
        Modificar.add(label8);
        textfield8.setEnabled(true);
        textfield8 = new JTextField();
        textfield8.setBounds(aux1_2,aux2,aux3_2,aux4);
        
        Modificar.add(textfield8);
        textfield8.setColumns(10);
        
        aux2+=50;
        label9 = new JLabel("Planeta Destino nuevo :");
        label9.setBounds(aux1,aux2,aux3,aux4);
        Modificar.add(label9);
        
        textfield9 = new JTextField();
        textfield9.setBounds(aux1_2,aux2,aux3_2,aux4);
        textfield9.setEnabled(true);
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
                actualiza();
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
        Modificar_btn.setBounds(220, 300, 200, 50);
        Modificar.add(Modificar_btn);
        
        aux1 = 180;
        aux1_2 = aux1+80+35;
        aux2 = 25;
        aux3 = 150;
        aux3_2 = 120;
        aux4 = 30;
        
        Consultar = new JPanel();
        Consultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Consultar",null,Consultar,null);
        Consultar.setLayout(null);
        
        label1 = new JLabel("Identificador :");
        label1.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setColumns(10);
        textfield1.setEditable(false);
        textfield1.setBounds(aux1_2,aux2,aux3_2,aux4);
        Consultar.add(textfield1);
        

        aux2+=80;
        label2 = new JLabel("Capacidad :");
        label2.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setColumns(10);
        textfield2.setEditable(false);
        textfield2.setBounds(aux1_2,aux2,aux3_2,aux4);
        Consultar.add(textfield2);
        
        aux2+=80;
        label3 = new JLabel("Distancia :");
        label3.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setColumns(10);
        textfield3.setEditable(false);
        textfield3.setBounds(aux1_2,aux2,aux3_2,aux4);;
        Consultar.add(textfield3);
        
        aux2+=80;
        label4 = new JLabel("Planeta Origen :");
        label4.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label4);
        
        textfield4 = new JTextField();
        textfield4.setColumns(10);
        textfield4.setEditable(false);
        textfield4.setBounds(aux1_2,aux2,aux3_2,aux4);
        Consultar.add(textfield4);
        
        aux2+=80;
        label4 = new JLabel("Planeta Destino :");
        label4.setBounds(aux1,aux2,aux3,aux4);
        Consultar.add(label4);
        
        textfield5 = new JTextField();
        textfield5.setColumns(10);
        textfield5.setEditable(false);
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
                   CVR.GuardarRutas(path);
                } catch (Exception e1) {
                    Errores.setText(e1.getMessage());
                }
                actualiza();
            } 
        }); 
        Guardar.setBounds(0, 0, 690, 390); 
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
                    CVR.CargarRutas(path);                   
                } catch (Exception e1) {
                    Errores.setText(e1.getMessage());
                } 
                actualiza(); 
            } 
        }); 
        Cargar.setBounds(0, 0, 690, 390); 
        Cargar.setAutoscrolls(true); 
        Cargar.setMinimumSize(new Dimension(200, 245)); 
        Cargar.setPreferredSize(new Dimension(365, 225)); 
        FrameCargar.add(Cargar);   
    }
}

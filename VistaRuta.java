

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
import javax.swing.border.EmptyBorder;
 
 
public class VistaNave extends PrimerNivel{

    
    //Componentes vista
    private int i;
    private int j;
    private ControladorVistaNave cvn;
    private ArrayList<String> listado1;
    private ArrayList<String> listado2;
    private ArrayList<String> listadoT;
    private ArrayList<String> listadoTotal;
    private ArrayList<String> listaPlanetas;
    private DefaultListModel<String> mlistado;
    private DefaultListModel<String> mlistadoT;
    private JComboBox<String> CB;
    private JComboBox<String> CBTipo;



    
    //Paneles
    private JTabbedPane PanelCreacion;
    private JTabbedPane PanelModificar;
    private JTabbedPane PanelConsultar;
    private JPanel PanelCrearNave;
    private JPanel PanelCrearTipo;
    private JPanel PanelConsultarNave;
    private JPanel PanelConsultarTipo;
    private JPanel PanelModificarNave;
    private JPanel PanelModificarTipo;
    private JScrollPane Scroll;
    private JScrollPane ScrollT;
    
    //Etiquetas
    private JLabel AntiguosTipo;
    private JLabel NuevosTipo;
    private JLabel AntiguosNave;
    private JLabel NuevosNave;
    /*
    private JLabel HelpNombre;
    private JLabel HelpCoste;
    private JLabel HelpCoordenadas;
    */
    
    //Botones
    private JButton CrearNave;
    private JButton CrearTipo;
    private JButton ModificarNave;
    private JButton ModificarTipo;
    private JButton GuardarNaves;
    private JButton CargarNaves;
    private JButton ConsultarNave;
    private JButton ConsultarTipo;
        
    
    //Listas
    private JList<String> listaScroll1;
    private JList<String> listaScroll2;
    private JList<String> listaScroll3;
    
    
    //RadioButton
    private JRadioButton T1;
    private JRadioButton T10;
    private JRadioButton T2;
    private JRadioButton T3;
    private JRadioButton T4;
    private JRadioButton T5;
    private JRadioButton T6;
    private JRadioButton T7;
    private JRadioButton T8;
    private JRadioButton T9;
    private JRadioButton TT1;
    private JRadioButton TT2;
    private JRadioButton TT3;
    private JRadioButton TT4;
    private JRadioButton TT5;
    private JRadioButton AutoNave;
    private JRadioButton AutoTipo;
    private JRadioButton ManNave;
    private JRadioButton ManTipo;
    private JTextField numNaves;
    private ButtonGroup ManAuto;
    private ButtonGroup ManAutoTipo;
    private ButtonGroup Tipos;
    private ButtonGroup TiposNave;
    private JButton Eliminar;
    //Frames
    private JInternalFrame FrameCargar ;
    private JInternalFrame FrameGuardar;
    
    public void actualiza() { //Para cuando se anaden naves
        try {
            mlistado.removeAllElements();
            listado1 = cvn.Consulta100Naves(i);
            listado2 = cvn.Consulta100Naves(j);
            listadoTotal = cvn.ConsultarNaves();
            Errores.setText(String.valueOf(listado1.size()));
            CB.removeAllItems();
            listaScroll2.removeAll();
            if (listadoTotal.size() != 0) {  
                CB.setEditable(true);
                    for (String s : listadoTotal) CB.addItem(s);
                    for (String p : listado1) mlistado.addElement(p);
                    for (String p : listado2) mlistado.addElement(p);
                CB.revalidate();
                CB.repaint();
                listaScroll2.setModel(mlistado);
                listaScroll2.revalidate();
                listaScroll2.repaint();
            }   
        }
        catch (Exception e) {
            Errores.setText(e.getMessage());
        }
    }
     public void actualizaT() { //Para cuando se anaden tipos
        try {
            mlistadoT.removeAllElements(); 
            listadoT = cvn.ConsultarTipos();
            CBTipo.removeAllItems();
            CBTipo.setEditable(false);
            if (listadoT.size() != 0) {  
                CBTipo.setEditable(true);
                for (String s : listadoT) CBTipo.addItem(s);
                for (String p : listadoT) mlistadoT.addElement(p);
                CBTipo.revalidate();
                CBTipo.repaint();
                listaScroll1.setModel(mlistadoT); 
                listaScroll1.revalidate(); 
                listaScroll1.repaint();
            }       
        }
        catch (Exception e) {
            Errores.setText(e.getMessage());
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
                listado1 = cvn.Consulta100Naves(i);
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
                if(j+100<Integer.parseInt(cvn.size())){
                    i=j;
                    j+=100;
                    mlistado.removeAllElements();
                    listado1.clear();
                    for(String e : listado2) listado1.add(e);
                    listado2 = cvn.Consulta100Naves(i);
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
    public VistaNave(ControladorVistaNave ControladorVN) {
   
    Central = new JTabbedPane();

        i=0;
        j=100;
        cvn = ControladorVN;
        setOpaque(false);          
        setBackground(Color.WHITE); 
        setLayout(null);
        
        
        listado1 = new ArrayList<String>();
        mlistado = new DefaultListModel<String>();
        listadoT = new ArrayList<String>();
        mlistadoT = new DefaultListModel<String>();
        // list 1
        //scrollPanel
        Errores = new JTextField();
        Errores.setEditable(false);

        Errores.setBounds(80,550,700,25);
        
        
        CB = new JComboBox<String>();
        CB.setBounds(830,260,150,20);
        CB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String n = CB.getSelectedItem().toString();
                    if(!n.equals("")){
                        Errores.setText("");
                        textfield18.setText(n);
                        textfield20.setText(cvn.ConsultarPlanetaOrigen(n));
                        textfield19.setText(cvn.ConsultarPlanetaDestino(n));
                        textfield21.setText(cvn.ConsultarTipo(n));
                        textfield12.setText(n);
                        textfield14.setText(cvn.ConsultarPlanetaOrigen(n));
                        textfield13.setText(cvn.ConsultarPlanetaDestino(n));
                        textfield15.setText(cvn.ConsultarTipo(n));
                    }   
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        CBTipo = new JComboBox<String>();
        CBTipo.setBounds(830,20,150,20);
        CBTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String n = CBTipo.getSelectedItem().toString();
                    if(!n.equals("")){
                        Errores.setText("");
                        textfield22.setText(n);
                        textfield23.setText(cvn.ConsultarConsumoTipo(n));
                        textfield16.setText(n);
                        textfield17.setText(cvn.ConsultarConsumoTipo(n));
                    }   
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        }); 
        
        Central = new JTabbedPane(JTabbedPane.TOP);
        Central.setBackground(SystemColor.activeCaption);
        Central.setBounds(50,50,750,450);
        
        
        
    //CREACION
        PanelCreacion = new JTabbedPane();
        PanelCreacion.setBackground(SystemColor.activeCaption);
        Central.addTab("Crear",PanelCreacion);
    
    //CREACION TIPO
        PanelCrearTipo = new JPanel();
        PanelCrearTipo.setLayout(null);
        PanelCreacion.addTab("TipoNave",PanelCrearTipo);
        
        
        
    //TIPO MANUAL    
        ManAutoTipo = new ButtonGroup();
        ManTipo = new JRadioButton();
        ManTipo.setText("Crear tipo de nave manualmente:");
        ManTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManTipoActionPerformed(evt);
            }
        });
        ManTipo.setBounds(225,50,300,25);
        ManTipo.setText("Crear tipo de nave de forma manual: ");
        AutoTipo = new JRadioButton();
        AutoTipo.setBounds(225, 250, 300, 25);
        AutoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoTipoActionPerformed(evt);
            }
        });
        
        AutoTipo.setText("Crear tipo de nave de forma automatica");
        ManAutoTipo.add(AutoTipo);
        ManAutoTipo.add(ManTipo);
        Tipos = new ButtonGroup();
        PanelCrearTipo.add(AutoTipo);
        PanelCrearTipo.add(ManTipo);
        
        label6 = new JLabel("Consumo: ");
        label6.setBounds(250,125,200,25);
        PanelCrearTipo.add(label6);
        
        textfield6 = new JTextField();
        textfield6.setBounds(350,125,150,25);
        textfield6.setEditable(true);
        textfield6.setEnabled(false);
        PanelCrearTipo.add(textfield6);
             
        label2 = new JLabel("Tipo de nave: ");
        label2.setBounds(250, 175, 200, 25);
        PanelCrearTipo.add(label2);
        
        
        
        //RadioButtons Tipo:
        T1 = new JRadioButton();
        T1.setBounds(350, 175, 50, 25);
        T1.setText("1");
        T1.setEnabled(false);
        PanelCrearTipo.add(T1);
        Tipos.add(T1);

        
        T2 = new JRadioButton();
        T2.setBounds(405, 175, 50, 25);
        T2.setText("2");
        T2.setEnabled(false);
        PanelCrearTipo.add(T2);
        Tipos.add(T2);
        
        T3 = new JRadioButton();
        T3.setBounds(460, 175, 50, 25);
        T3.setText("3");
        T3.setEnabled(false);
        PanelCrearTipo.add(T3);
        Tipos.add(T3);
        
        
        T4 = new JRadioButton();
        T4.setBounds(515, 175, 50, 25);
        T4.setText("4");
        T4.setEnabled(false);
        PanelCrearTipo.add(T4);
        Tipos.add(T4);

        
        T5 = new JRadioButton();
        T5.setBounds(570, 175, 50, 25);
        T5.setText("5");
        T5.setEnabled(false);
        PanelCrearTipo.add(T5);
        Tipos.add(T5);
        
        
     
        //Manual!
                
        PanelCrearNave = new JPanel();
        PanelCrearNave.setLayout(null);
        PanelCreacion.addTab("Nave",PanelCrearNave);
        

        ManAuto = new ButtonGroup();
        ManNave = new JRadioButton();
        ManNave.setBounds(225,50,300,25);
        ManNave.setText("Crear una nave manualmente: "); 
        ManNave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManNaveActionPerformed(evt);
            }
        });
        
        AutoNave = new JRadioButton();
        AutoNave.setBounds(225, 250, 300,25);
        AutoNave.setText("Crear naves de forma automatica: ");
        AutoNave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoNaveActionPerformed(evt);
            }
        });
        ManAuto.add(ManNave);
        ManAuto.add(AutoNave);
        PanelCrearNave.add(AutoNave);
        PanelCrearNave.add(ManNave);
        
        label4 = new JLabel("Planeta origen: ");
        label4.setBounds(250,100,200,25);
        PanelCrearNave.add(label4);
        
        label3 = new JLabel("Planeta destino: ");
        label3.setBounds(250, 150, 200, 25);
        PanelCrearNave.add(label3);
        
        label5 = new JLabel("Tipo de nave: ");
        label5.setBounds(250, 200, 200, 25);
        PanelCrearNave.add(label5);
        
        TiposNave = new ButtonGroup();
        
        TT1 = new JRadioButton();
        TT1.setBounds(350, 200, 50, 25);
        TT1.setText("1");
        TT1.setEnabled(false);
        PanelCrearNave.add(TT1);
        TiposNave.add(TT1);

        
        TT2 = new JRadioButton();
        TT2.setBounds(405, 200, 50, 25);
        TT2.setText("2");
        TT2.setEnabled(false);
        PanelCrearNave.add(TT2);
        TiposNave.add(TT2);
        
        TT3 = new JRadioButton();
        TT3.setBounds(460, 200, 50, 25);
        TT3.setText("3");
        TT3.setEnabled(false);
        PanelCrearNave.add(TT3);
        TiposNave.add(TT3);
        
        
        TT4 = new JRadioButton();
        TT4.setBounds(515, 200, 50, 25);
        TT4.setText("4");
        TT4.setEnabled(false);
        PanelCrearNave.add(TT4);
        TiposNave.add(TT4);

        
        TT5 = new JRadioButton();
        TT5.setBounds(570, 200, 50, 25);
        TT5.setText("5");
        TT5.setEnabled(false);
        PanelCrearNave.add(TT5);
        TiposNave.add(TT5);

        
        textfield4 = new JTextField();
        textfield4.setBounds(350,100,150,25); 
        textfield4.setEnabled(false);
        PanelCrearNave.add(textfield4);
        
        textfield3 = new JTextField();
        textfield3.setBounds(350, 150, 150, 25); 
        textfield3.setEnabled(false);
        PanelCrearNave.add(textfield3);
        
    //Nave Automatica
        numNaves = new JTextField();
        numNaves.setBounds(350, 300, 100,25);
        numNaves.setEnabled(false);
        PanelCrearNave.add(numNaves);
        
        label19 = new JLabel("Numero de naves: ");
        label19.setBounds(225, 300, 150,25);
        PanelCrearNave.add(label19);

            
        CrearNave = new JButton("Crear");
        CrearNave.setIcon(null);
        CrearNave.setBounds(600,350,100,25);
        PanelCrearNave.add(CrearNave);
        
        CrearNave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
        try{
        if(ManNave.isSelected()){
            String d = textfield3.getText();
            String o = textfield4.getText();
            String t="";
                if(TT1.isSelected()) t="1";
                else if(TT2.isSelected()) t="2";
                else if(TT3.isSelected()) t="3";
                else if(TT4.isSelected()) t="4";
                else if(TT5.isSelected()) t="5";
                cvn.CrearNave(t, d, o);
        }
        else if(AutoNave.isSelected()){
            String num = numNaves.getText();
            cvn.CrearNaveAuto(num);
        }
            actualiza();
        }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
    }
        });
        
        CrearTipo = new JButton("Crear");
        CrearTipo.setIcon(null);
        CrearTipo.setBounds(600,350,100,25);
        PanelCrearTipo.add(CrearTipo);
        
        CrearTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        try{
        if(ManTipo.isSelected()){
                String c = textfield6.getText();
                 String t="";
                     if(T1.isSelected()) t=T1.getText();
                     else if(T2.isSelected()) t=T2.getText();
                     else if(T3.isSelected()) t=T3.getText();
                     else if(T4.isSelected()) t=T4.getText();
                     else if(T5.isSelected()) t=T5.getText();
                     cvn.CrearTipo(t,c);
             }
             else if(AutoTipo.isSelected()){
                 cvn.CrearTipoAuto();
             }
        actualizaT();
        }
        catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
    }
        });
        
        
       
    //MODIFICAR!
        
        PanelModificar = new JTabbedPane();
        PanelModificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Modificar",PanelModificar);
        
        
    //Modificar tipo nave
        
        PanelModificarTipo = new JPanel();
        PanelModificar.addTab("TipoNave", null,PanelModificarTipo,null);
        PanelModificarTipo.setLayout(null);
        
        AntiguosTipo = new JLabel("Configuración actual: ");
        AntiguosTipo.setBounds(150,40,300,25);
        PanelModificarTipo.add(AntiguosTipo);
        
        NuevosTipo = new JLabel("Nueva configuración: ");
        NuevosTipo.setBounds(450,40,300,25);
        PanelModificarTipo.add(NuevosTipo);
        
        label8 = new JLabel("Identificador :");
        label8.setBounds(50, 100, 150, 25); //Esperando
        PanelModificarTipo.add(label8);
        
        textfield16 = new JTextField();
        textfield16.setBounds(150, 100, 100, 25);
        textfield16.setEnabled(false);
        PanelModificarTipo.add(textfield16);
        
        label12 = new JLabel("Consumo :");
        label12.setBounds(50, 160, 150, 25); //Esperando
        PanelModificarTipo.add(label12);
        
        textfield17 = new JTextField();
        textfield17.setBounds(150, 160, 100, 25);
        textfield17.setEnabled(false);
        PanelModificarTipo.add(textfield17);
        
        
        textfield11 = new JTextField();
        textfield11.setBounds(450, 160, 100, 25);
        PanelModificarTipo.add(textfield11);
        
        ModificarTipo = new JButton("Modificar");
        ModificarTipo.setIcon(null);
        ModificarTipo.setBounds(600,350,100,25);
        PanelModificarTipo.add(ModificarTipo);
                ModificarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            try{
                    if(textfield11.getText()!="") cvn.ModificaConsumo(textfield16.getText(),textfield11.getText());
                    textfield11.setText("");
                        Errores.setText("");
                        String n = textfield16.getText();
                        textfield22.setText(n);
                        textfield23.setText(cvn.ConsultarConsumoTipo(n));
                        textfield17.setText(cvn.ConsultarConsumoTipo(n));

            }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
    }
        });
        
    //Modificar Nave
        PanelModificarNave = new JPanel();
        PanelModificar.addTab("Nave", null,PanelModificarNave,null);
        PanelModificarNave.setLayout(null);
        
        AntiguosNave = new JLabel("Configuración actual: ");
        AntiguosNave.setBounds(150,40,300,25);
        PanelModificarNave.add(AntiguosNave);
        
        NuevosNave = new JLabel("Configuración actual: ");
        NuevosNave.setBounds(450,40,300,25);
        PanelModificarNave.add(NuevosNave);
        
        label7 = new JLabel("Identificador :");
        label7.setBounds(50, 100, 150, 25); //Esperando
        PanelModificarNave.add(label7);
        
        textfield12 = new JTextField();
        textfield12.setBounds(150, 100, 100, 25);
        textfield12.setEnabled(false);
        PanelModificarNave.add(textfield12);
        
        label10 = new JLabel("Planeta Origen :");
        
        label10.setBounds(50,160,150,25); //Esperando
        PanelModificarNave.add(label10);
        
        textfield14 = new JTextField();
        textfield14.setBounds(150,160,100,25);
        textfield14.setEnabled(false);
        PanelModificarNave.add(textfield14);
        
        
        textfield8 = new JTextField();
        textfield8.setBounds(450,160,100,25);
        PanelModificarNave.add(textfield8);
        
        label11 = new JLabel("Planeta Destino :");
        label11.setBounds(50, 220, 150, 25); //Esperando
        PanelModificarNave.add(label11);
        
        textfield13 = new JTextField();
        textfield13.setBounds(150, 220, 100, 25);
        textfield13.setEnabled(false);
        //textfield13.setEditable(false);
        PanelModificarNave.add(textfield13);
        
        
        textfield7 = new JTextField();
        textfield7.setBounds(450, 220, 100, 25);
        PanelModificarNave.add(textfield7);
        

        label8 = new JLabel("Tipo de nave :");
        label8.setBounds(50,280,150,25); //Esperando
        PanelModificarNave.add(label8);
        
        textfield15 = new JTextField();
        textfield15.setBounds(150,280,100,25);
        textfield15.setEnabled(false);
        PanelModificarNave.add(textfield15);
        
        
        textfield10 = new JTextField();
        textfield10.setBounds(450,280,100,25);
        PanelModificarNave.add(textfield10);
        
        ModificarNave = new JButton("Modificar");
        ModificarNave.setIcon(null);
        ModificarNave.setBounds(600,350,100,25);
        PanelModificarNave.add(ModificarNave);
                ModificarNave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            try{
                    if(textfield8.getText()!="") cvn.ModificaOrigen(textfield12.getText(),textfield8.getText());
                    if(textfield7.getText()!="") cvn.ModificaDestino(textfield12.getText(), textfield7.getText());
                    if(textfield9.getText()!="") cvn.ModificaTipo(textfield12.getText(), textfield9.getText());
                    textfield8.setText("");
                    textfield7.setText("");
                    textfield9.setText("");
            }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
    }
        });
        
        
        PanelConsultar = new JTabbedPane();
        PanelConsultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Consultar",PanelConsultar);
        
        PanelConsultarTipo = new JPanel();
        PanelConsultar.addTab("TipoNave",PanelConsultarTipo);
        PanelConsultarTipo.setLayout(null);
        
        label14 = new JLabel("Identificador: ");
        label14.setBounds(200, 100, 150, 25); //Esperando
        PanelConsultarTipo.add(label14);
        
        textfield22 = new JTextField();
        textfield22.setBounds(350,100, 150, 25);
        textfield22.setEnabled(false);
        textfield22.setEditable(true);
        PanelConsultarTipo.add(textfield22);
        
        label18 = new JLabel("Consumo: ");
        label18.setBounds(200, 160, 150, 25); //Esperando
        PanelConsultarTipo.add(label18);
        
        textfield23 = new JTextField();
        textfield23.setBounds(350, 160, 150, 25);
        textfield23.setEnabled(false);
        PanelConsultarTipo.add(textfield23);

        
//Consultar Nave
        PanelConsultarNave = new JPanel();
        PanelConsultar.addTab("Nave",PanelConsultarNave);
        PanelConsultarNave.setLayout(null);
        
        label13 = new JLabel("Identificador: ");
        label13.setBounds(200,100,150,25); 
        PanelConsultarNave.add(label13);
        
        
        textfield18 = new JTextField();
        textfield18.setBounds(350,100,150,25);
        textfield18.setEnabled(false);
        PanelConsultarNave.add(textfield18);
        
        label16 = new JLabel("Planeta Origen: ");
        
        label16.setBounds(200,160,150,25); 
        PanelConsultarNave.add(label16);
        
        textfield20 = new JTextField();
        textfield20.setBounds(350,160,150,25);
        textfield20.setEnabled(false);
        textfield20.setEditable(true);
        PanelConsultarNave.add(textfield20);
        
        label17 = new JLabel("Planeta Destino: ");
        label17.setBounds(200,220,150,25); //Esperando
        PanelConsultarNave.add(label17);
        
        textfield19 = new JTextField();
        textfield19.setBounds(350,220,150,25);
        textfield19.setEnabled(false);
        textfield19.setEditable(true);
        PanelConsultarNave.add(textfield19);

        label14 = new JLabel("Tipo de nave: ");
        label14.setBounds(200,280,150,25); //Esperando
        PanelConsultarNave.add(label14);
        
        textfield21 = new JTextField();
        textfield21.setBounds(350,290,150,25);
        textfield21.setEnabled(false);
        PanelConsultarNave.add(textfield21);

       
    //ListaNaves
       
        Scroll = new JScrollPane();
        listaScroll2 = new JList(mlistado);
        listaScroll2.setVisibleRowCount(10);
        listaScroll2.setValueIsAdjusting(true);
        listaScroll2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaScroll2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null)); 
        listaScroll2.setBackground(SystemColor.inactiveCaptionBorder); 
        Scroll.setViewportView(listaScroll2); 
        Scroll = new JScrollPane(listaScroll2);
        Scroll.setBounds(830,290,150,275);
        Scroll.setPreferredSize(new Dimension(152,217));
        
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
              int index = listaScroll2.locationToIndex(mouseEvent.getPoint()); 
              if (index >= 0) { 
                String n = listaScroll2.getModel().getElementAt(index);
                
                try { 
                     Errores.setText(n);
                        textfield20.setText(cvn.ConsultarPlanetaOrigen(n));
                        textfield19.setText(cvn.ConsultarPlanetaDestino(n));
                        textfield21.setText(cvn.ConsultarTipo(n));
                        textfield12.setText(n);
                        textfield18.setText(n);
                        textfield14.setText(cvn.ConsultarPlanetaOrigen(n));
                        textfield13.setText(cvn.ConsultarPlanetaDestino(n));
                        textfield15.setText(cvn.ConsultarTipo(n));
                } 
                catch (Exception e) { 
                    Errores.setText(e.getMessage()); 
                } 
              } 
            } 
        }); 
        
    //MiniLista Tipos            
        listaScroll1 = new JList<String>(mlistadoT);
        listaScroll1.setVisibleRowCount(10);
        listaScroll1.setValueIsAdjusting(true);
        listaScroll1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaScroll1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null)); 
        listaScroll1.setBackground(SystemColor.inactiveCaptionBorder); 
        ScrollT = new JScrollPane(listaScroll1);
        ScrollT.setBounds(830,50,150,200);
        ScrollT.setPreferredSize(new Dimension(86,153));
        listaScroll1.addMouseListener(new MouseAdapter () 
        {        
            public void mouseClicked(MouseEvent mouseEvent) {           
              int index = listaScroll1.locationToIndex(mouseEvent.getPoint()); 
              if (index >= 0) { 
                String n = listaScroll1.getModel().getElementAt(index);
                
                try { 
                        Errores.setText("");
                        textfield22.setText(n);
                        textfield23.setText(cvn.ConsultarConsumoTipo(n));
                        textfield16.setText(n);
                        textfield17.setText(cvn.ConsultarConsumoTipo(n));
                } 
                catch (Exception e) { 
                    Errores.setText(e.getMessage()); 
                } 
              } 
            } 
        }); 
                Eliminar = new JButton("Eliminar");
                Eliminar.setBounds(830,570,150,25);
                add(Eliminar);
                 Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            try{
                int selectedIndex = listaScroll2.getSelectedIndex(); 
                if (selectedIndex != -1) { 
                    String n = listaScroll2.getSelectedValue(); 
                    mlistado.removeElement(n);
                    cvn.EliminarNave(n);
                    actualiza();
                }
            }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
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
                    cvn.CargarNaves(path);
                    actualiza();                    
                } catch (Exception e1) {
                    Errores.setText(e1.getMessage());
                } 
            } 
        }); 
        Cargar.setBounds(0, 0, 725, 395); 
        Cargar.setAutoscrolls(true); 
        Cargar.setMinimumSize(new Dimension(200, 245)); 
        Cargar.setPreferredSize(new Dimension(365, 225)); 
        FrameCargar.add(Cargar); 
           

           
   
        
//GUARDAR
        FrameGuardar = new JInternalFrame();
        Guardar = new JFileChooser();
        FrameGuardar.setBackground(SystemColor.activeCaption); 
        Central.addTab("Guardar", FrameGuardar); 
        FrameGuardar.setLayout(null); 
           
        Guardar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {                  
                   
                String path = Guardar.getSelectedFile().getAbsolutePath(); 
                try { 
                    cvn.GuardarNaves(path);
                    actualiza();   
                    actualizaT();
                } catch (Exception e1) {
                    Errores.setText(e1.getMessage());
                } 
            } 
        }); 
        Guardar.setBounds(0, 0, 725, 395); 
        Guardar.setAutoscrolls(true); 
        Guardar.setMinimumSize(new Dimension(200, 245)); 
        Guardar.setPreferredSize(new Dimension(365, 225)); 
        FrameGuardar.add(Guardar); 
        
        add(Central);
        add(CB);
        add(CBTipo);
        add(Scroll);
        add(ScrollT);
        add(Errores);
        setVisible(true);
        Central.setVisible(true);
        Errores.setVisible(true);
    }
    private void AutoNaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
        numNaves.setEnabled(true);
        textfield3.setEnabled(false);
        textfield4.setEnabled(false);
        TT1.setEnabled(false);
        TT2.setEnabled(false);
        TT3.setEnabled(false);
        TT4.setEnabled(false);
        TT5.setEnabled(false);
        }
        catch (Exception e) {
            Errores.setText(e.getMessage());
        }
    }                                        
        //Acciones Botones Crear Nave:
    private void ManNaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try{
        textfield3.setEnabled(true);
        textfield4.setEnabled(true);
        TT1.setEnabled(true);
        TT2.setEnabled(true);
        TT3.setEnabled(true);
        TT4.setEnabled(true);
        TT5.setEnabled(true);
        numNaves.setEnabled(false);
                        }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
    }                                                                    
    private void ManTipoActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try{
        textfield6.setEnabled(true);
        T1.setEnabled(true);
        T2.setEnabled(true);
        T3.setEnabled(true);
        T4.setEnabled(true);
        T5.setEnabled(true);
                        }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
    }
    private void AutoTipoActionPerformed(java.awt.event.ActionEvent evt) {                                        
       try{
        textfield6.setEnabled(false);
        T1.setEnabled(false);
        T2.setEnabled(false);
        T3.setEnabled(false);
        T4.setEnabled(false);
        T5.setEnabled(false);
                        }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
    }    





}

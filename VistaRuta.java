
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
public class VistaRuta extends /*PrimerNivel*/ JFrame{
    
    public VistaRuta ObtenerVista() {
        return this;
    }
    //Componentes vista
    private ControladorVistaRuta CVR;
    private ArrayList<String> listado;
    private DefaultListModel<String> mlistado;
    private DefaultListModel<String> mlistadoPlanetas;
    private JComboBox<String> CBRutas;
   
    //Cajas Atributos
    private JTextField IdAc;
    private JTextField CapacidadAc;
    private JTextField DistanciaAc;
    private JTextField PlanetaAAc;
    private JTextField PlanetaBAc;
    private JTextField CapacidadNew;
    private JTextField DistanciaNew;
    private JTextField PlanetaANew;
    private JTextField PlanetaBNew;
    
    //Errores
    private JTextField Errores;
    
    //Cargar y Guardar
    private JFileChooser Cargar;
    private JFileChooser Guardar;
    
    //PRIMER NIVEL???
    private JTabbedPane Central;
    
    //Paneles
    private Panel PanelCreacion;
    private Panel PanelModificar;
    private Panel PanelConsultar;
    private Panel PanelGuardar;
    private Panel PanelCargar;
    private JScrollPane ScrollPlanetasConsulta;
    
    //Etiquetas
    private JLabel EId;
    private JLabel ECapacidad;
    private JLabel EDistancia;
    private JLabel EPlanetaA;
    private JLabel EPlanetaB;
    private JLabel ECapacidadNew;
    private JLabel EDistanciaNew;
    private JLabel EPlanetaANew;
    private JLabel EPlanetaBNew;
    private JLabel HelpNombre;
    private JLabel HelpCoste;
    private JLabel HelpCoordenadas;
    
    //Botones
    private JButton CrearPlaneta;
    private JButton CrearPlanetaAutoSN;
    private JButton CrearPlanetaAutoCN;
    private JButton Modificar;
    
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
        setOpaque(false);          
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
                        IdAc.setText(n);
                        CapacidadAc.setText(CVR.ConsultarCapacidadRuta(n));
                        DistanciaAc.setText(CVR.ConsultarDistanciaRuta(n));
                        PlanetaAAc.setText(CVR.ConsultarPlanetaARuta(n));
                        PlanetaBAc.setText(CVR.ConsultarPlanetaBRuta(n));
                    }   
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        Central = new JTabbedPane(JTabbedPane.TOP);
        Central.setBackground(SystemColor.activeCaption);
        Central.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //A la espera de consenso
        add(Central);
        
        PanelCreacion = new Panel();
        PanelCreacion.setBackground(SystemColor.activeCaption);
        Central.addTab("Crear",null,PanelCreacion,null);
        PanelCreacion.setLayout(null);
        
        Manual = new JRadioButton("Manual");
        Manual.setSelected(false); 
        Manual.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(Manual);
        
        Automatico = new JRadioButton("Automatico");
        Automatico.setSelected(false);
        Automatico.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(Automatico);
        
        AutomaticoCId = new JRadioButton("Automatico con Nombre");
        AutomaticoCId.setSelected(false);
        AutomaticoCId.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(AutomaticoCId);
        
        
        EId = new JLabel("Id :");
        EId.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelCreacion.add(EId);
        
        IdAc = new JTextField();
        IdAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelCreacion.add(IdAc);
        IdAc.setColumns(10);  //??????
        IdAc.setEnabled(false);
        
        ECapacidad = new JLabel ("Capacidad :");
        ECapacidad.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(ECapacidad);
        
        CapacidadAc = new JTextField();
        CapacidadAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(CapacidadAc);
        CapacidadAc.setColumns(10);
        CapacidadAc.setEnabled(false);
        
        EDistancia = new JLabel ("Distancia :");
        EDistancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(EDistancia);
        
        DistanciaAc = new JTextField();
        DistanciaAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(DistanciaAc);
        DistanciaAc.setColumns(10);
        DistanciaAc.setEnabled(false);
        
        EPlanetaA = new JLabel("Planeta A :");
        EPlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(EPlanetaA);
        
        PlanetaAAc = new JTextField();
        PlanetaAAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(PlanetaAAc);
        PlanetaAAc.setColumns(10);
        PlanetaAAc.setEnabled(false);
                
        EPlanetaB = new JLabel("Planeta B :");
        EPlanetaB.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(EPlanetaA);
        
        PlanetaBAc = new JTextField();
        PlanetaBAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(PlanetaBAc);
        PlanetaBAc.setColumns(10);
        PlanetaBAc.setEnabled(false);
        
        Manual.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()) {
                        IdAc.setEnabled(true);
                        CapacidadAc.setEnabled(true);
                        PlanetaAAc.setEnabled(true);
                        PlanetaBAc.setEnabled(true);
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
                        IdAc.setEnabled(false);
                        CapacidadAc.setEnabled(false);
                        PlanetaAAc.setEnabled(false);
                        PlanetaBAc.setEnabled(false);
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
                        IdAc.setEnabled(true);
                        CapacidadAc.setEnabled(false);
                        PlanetaAAc.setEnabled(false);
                        PlanetaBAc.setEnabled(false);
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
        /*
        HelpNombre = new JLabel("");
        HelpNombre.setToolTipText("El Nombre tiene que estar compuesto por caracteres alfanumericos.");
        HelpNombre.setIcon(null);
        */
        
        CrearPlaneta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()){
                        String n = IdAc.getText();
                        String c = CapacidadAc.getText();
                        String d = DistanciaAc.getText();
                        String x = PlanetaAAc.getText();
                        String y = PlanetaBAc.getText();
                        CVR.creaRuta(n,c,d,x,y);
                        actualiza();
                    }
                    if(Automatico.isSelected()) {
                        CVR.creaRutaAut();
                        actualiza();
                    }
                    else {
                        String n = IdAc.getText();
                        CVR.creaRutaAut_id(n);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                IdAc.setText("");
                CapacidadAc.setText("");
                DistanciaAc.setText("");
                PlanetaAAc.setText("");
                PlanetaBAc.setText("");
            }
        });
     
        CrearPlaneta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(CrearPlaneta);
        
        PanelModificar = new Panel();
        PanelModificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Modificar", null,PanelModificar,null);
        PanelModificar.setLayout(null);
        
        EId = new JLabel("Id :");
        EId.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelModificar.add(EId);
        
        IdAc = new JTextField();
        IdAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelModificar.add(IdAc);
        IdAc.setColumns(10);  //??????
        
        ECapacidad = new JLabel ("Capacidad :");
        ECapacidad.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(ECapacidad);
        
        CapacidadAc = new JTextField();
        CapacidadAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        CapacidadAc.setEnabled(false);
        PanelModificar.add(CapacidadAc);
        CapacidadAc.setColumns(10);
        
        EDistancia = new JLabel ("Distancia :");
        EDistancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EDistancia);
        
        DistanciaAc = new JTextField();
        DistanciaAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        DistanciaAc.setEnabled(false);
        PanelModificar.add(DistanciaAc);
        DistanciaAc.setColumns(10);
        
        EPlanetaA = new JLabel("Planeta A :");
        EPlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EPlanetaA);
        
        PlanetaAAc = new JTextField();
        PlanetaAAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PlanetaAAc.setEnabled(false);
        PanelModificar.add(PlanetaAAc);
        PlanetaAAc.setColumns(10);
        
        EPlanetaB = new JLabel("Planeta B :");
        EPlanetaB.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EPlanetaA);
        
        PlanetaBAc = new JTextField();
        PlanetaBAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PlanetaBAc.setEnabled(false);
        PanelModificar.add(PlanetaBAc);
        PlanetaBAc.setColumns(10);
        
        ECapacidadNew = new JLabel ("Capacidad nueva :");
        ECapacidadNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(ECapacidadNew);
        
        CapacidadNew = new JTextField();
        CapacidadNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(CapacidadNew);
        CapacidadNew.setColumns(10);
        
        EDistanciaNew = new JLabel ("Distancia nueva :");
        EDistanciaNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EDistanciaNew);
        
        DistanciaNew = new JTextField();
        DistanciaNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(DistanciaNew);
        DistanciaNew.setColumns(10);
        
        EPlanetaANew = new JLabel("Planeta A nuevo :");
        EPlanetaANew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EPlanetaANew);
        
        PlanetaANew = new JTextField();
        PlanetaANew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(PlanetaANew);
        PlanetaANew.setColumns(10);
        
        EPlanetaBNew = new JLabel("Planeta B nuevo :");
        EPlanetaBNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EPlanetaANew);
        
        PlanetaBNew = new JTextField();
        PlanetaBNew.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(PlanetaBNew);
        PlanetaBNew.setColumns(10);
        
        Modificar = new JButton("Modificar");
        Modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String nac = IdAc.getText();
                    String c = CapacidadNew.getText();
                    String d = DistanciaNew.getText();
                    String x = PlanetaANew.getText();
                    String y = PlanetaBNew.getText();
                    if(!c.isEmpty()) CVR.ModificarCapacidadRuta(nac,c);
                    if(!d.isEmpty()) CVR.ModificarDistanciaRuta(nac,d);
                    if(!x.isEmpty()) CVR.ModificarPlanetaARuta(nac,x);
                    if(!y.isEmpty()) CVR.ModificarPlanetaBRuta(nac,y);
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                IdAc.setText("");
                CapacidadAc.setText("");
                DistanciaAc.setText("");
                PlanetaAAc.setText("");
                PlanetaBAc.setText("");
                CapacidadNew.setText("");
                DistanciaNew.setText("");
                PlanetaANew.setText("");
                PlanetaBNew.setText("");
            }
        });
        
        PanelConsultar = new Panel();
        PanelConsultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Consultar",null,PanelConsultar,null);
        PanelConsultar.setLayout(null);
        
        CBRConsulta = new JComboBox<String>();
        CBRConsulta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(CBRConsulta);
        
        EId = new JLabel("Id :");
        EId.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(EId);
        
        IdAc = new JTextField();
        IdAc.setColumns(10);
        IdAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(IdAc);
        
        ECapacidad = new JLabel("Capacidad :");
        ECapacidad.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(ECapacidad);
        
        CapacidadAc = new JTextField();
        CapacidadAc.setColumns(10);
        CapacidadAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(CapacidadAc);
        
        EDistancia = new JLabel("Distancia :");
        EDistancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(EDistancia);
        
        DistanciaAc = new JTextField();
        DistanciaAc.setColumns(10);
        DistanciaAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(DistanciaAc);
        
        EPlanetaA = new JLabel("Planeta A :");
        EPlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(EPlanetaA);
        
        PlanetaAAc = new JTextField();
        PlanetaAAc.setColumns(10);
        PlanetaAAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(PlanetaAAc);
        
        EPlanetaA = new JLabel("Planeta B :");
        EPlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(EPlanetaA);
        
        PlanetaBAc = new JTextField();
        PlanetaBAc.setColumns(10);
        PlanetaBAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(PlanetaBAc);
        
        PanelGuardar = new Panel();
        PanelGuardar.setBackground(SystemColor.activeCaption);
        Central.addTab("Guardar", null, PanelGuardar, null);
        PanelGuardar.setLayout(null);
        
        Guardar = new JFileChooser();
        Guardar.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Guardar.setAutoscrolls(true);
        Guardar.setPreferredSize(new Dimension(WIDTH,WIDTH));
        PanelGuardar.add(Guardar);
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
        
        PanelCargar = new Panel();
        PanelCargar.setBackground(SystemColor.activeCaption);
        Central.addTab("Cargar", null, PanelCargar, null);
        PanelCargar.setLayout(null);
        
        Cargar = new JFileChooser();
        Cargar.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Cargar.setAutoscrolls(true);
        Cargar.setPreferredSize(new Dimension(WIDTH,WIDTH));
        PanelCargar.add(Cargar);
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

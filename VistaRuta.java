
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
    private DefaultListModel<String> mlistadoRutas;
    private JComboBox<String> CBRutas;
   
    //Cajas Atributos
    private JTextField IdAc;
    private JTextField Capacidad;
    private JTextField Distancia;
    private JTextField PlanetaA;
    private JTextField PlanetaB;
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
    private JLabel HelpCapacidad;
    private JLabel HelpDistancia;
    private JLabel HelpPlanetaAB;
    
    //Botones
    private JButton CrearRuta;
    private JButton CrearRutaAuto;
    private JButton CrearRutaAutoId;
    private JButton Modificar;
    
    //Listas
    private JList<String> listaScroll1;
    private JList<String> listaScroll2;
    private JComboBox <String> CBPConsulta;
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
                /*
                 *
                 * A espera de Primer nivel
                 *
                 */
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
        mlistadoRutas = new DefaultListModel<String>();
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
                        Capacidad.setText(CVR.ConsultarCapacidadRuta(n));
                        Distancia.setText(CVR.ConsultarDistanciaRuta(n));
                        PlanetaA.setText(CVR.ConsultarPlanetaARuta(n));
                        PlanetaB.setText(CVR.ConsultarPlanetaBRuta(n));
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
        
        EId = new JLabel("Id :");
        EId.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelCreacion.add(EId);
        
        IdAc = new JTextField();
        IdAc.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperando
        PanelCreacion.add(IdAc);
        IdAc.setColumns(10);  //??????
        
        ECapacidad = new JLabel ("Capacidad :");
        ECapacidad.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(ECapacidad);
        
        Capacidad = new JTextField();
        Capacidad.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(Capacidad);
        Capacidad.setColumns(10);
        
        EDistancia = new JLabel ("Distancia :");
        EDistancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(EDistancia);
        
        Distancia = new JTextField();
        Distancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(Distancia);
        Distancia.setColumns(10);
        
        EPlanetaA = new JLabel("Planeta A :");
        EPlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(EPlanetaA);
        
        PlanetaA = new JTextField();
        PlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(PlanetaA);
        PlanetaA.setColumns(10);
        
        EPlanetaB = new JLabel("Planeta B :");
        EPlanetaB.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(EPlanetaA);
        
        PlanetaB = new JTextField();
        PlanetaB.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelCreacion.add(PlanetaB);
        PlanetaB.setColumns(10);
        
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
                    String n = IdAc.getText();
                    String c = Capacidad.getText();
                    String d = Distancia.getText();
                    String x = PlanetaA.getText();
                    String y = PlanetaB.getText();
                    CVR.creaRuta(n, c, d, x, y);
                    actualiza();
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                IdAc.setText("");
                Capacidad.setText("");
                Distancia.setText("");
                PlanetaA.setText("");
                PlanetaB.setText("");
            }
        });
     
        CrearRuta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelCreacion.add(CrearRuta);
        
        CrearRutaAuto = new JButton("Automatico con Id");
        CrearRutaAutoId.setIcon(null);
        
        CrearRutaAutoId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String n = IdAc.getText();
                    CVR.creaRutaAut_id(n);
                    actualiza();
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                IdAc.setText("");
            }
        });
        
        CrearRutaAuto = new JButton("Automatico");
        CrearRutaAuto.setIcon(null);
        
        CrearRutaAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    CVR.creaRutaAut();
                    actualiza();
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
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
        
        Capacidad = new JTextField();
        Capacidad.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Capacidad.setEditable(false);
        Capacidad.setEnabled(false);
        PanelModificar.add(Capacidad);
        Capacidad.setColumns(10);
        
        EDistancia = new JLabel ("Distancia :");
        EDistancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EDistancia);
        
        Distancia = new JTextField();
        Distancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        Distancia.setEditable(false);
        Distancia.setEnabled(false);
        PanelModificar.add(Distancia);
        Distancia.setColumns(10);
        
        EPlanetaA = new JLabel("Planeta A :");
        EPlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EPlanetaA);
        
        PlanetaA = new JTextField();
        PlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PlanetaA.setEditable(false);
        PlanetaA.setEnabled(false);
        PanelModificar.add(PlanetaA);
        PlanetaA.setColumns(10);
        
        EPlanetaB = new JLabel("Planeta B :");
        EPlanetaB.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PanelModificar.add(EPlanetaA);
        
        PlanetaB = new JTextField();
        PlanetaB.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); //Esperar
        PlanetaB.setEditable(false);
        PlanetaB.setEnabled(false);
        PanelModificar.add(PlanetaB);
        PlanetaB.setColumns(10);
        
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
                    if(!y.isEmpty()) CVR.ModificarPlanetaARuta(nac,y);
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                IdAc.setText("");
                Capacidad.setText("");
                PlanetaA.setText("");
                PlanetaB.setText("");
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
        
        ScrollPlanetasConsulta = new JScrollPane((Component) null);
        ScrollPlanetasConsulta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        ScrollPlanetasConsulta.setPreferredSize(new Dimension(152,217));
        PanelConsultar.add(ScrollPlanetasConsulta);
        
        listaScroll2 = new JList<String>();
        listaScroll2.setVisibleRowCount(10);
        listaScroll2.setValueIsAdjusting(true);
        listaScroll2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaScroll2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null)); 
        listaScroll2.setBackground(SystemColor.inactiveCaptionBorder); 
        ScrollPlanetasConsulta.setViewportView(listaScroll2); 
        
        CBPConsulta = new JComboBox<String>();
        CBPConsulta.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(CBPConsulta);
        
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
        
        Capacidad = new JTextField();
        Capacidad.setColumns(10);
        Capacidad.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(Capacidad);
        
        EDistancia = new JLabel("Distancia :");
        EDistancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(EDistancia);
        
        Distancia = new JTextField();
        Distancia.setColumns(10);
        Distancia.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(Distancia);
        
        EPlanetaA = new JLabel("Planeta A :");
        EPlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(EPlanetaA);
        
        PlanetaA = new JTextField();
        PlanetaA.setColumns(10);
        PlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(PlanetaA);
        
        EPlanetaA = new JLabel("Planeta B :");
        EPlanetaA.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(EPlanetaA);
        
        PlanetaB = new JTextField();
        PlanetaB.setColumns(10);
        PlanetaB.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        PanelConsultar.add(PlanetaB);
    }
}



import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

    
public class VistaPlaneta extends PrimerNivel {
    private ControladorVistaPlaneta CVP;
    private DefaultListModel<String> mlistado;
    private ArrayList<String> listado;
    private ArrayList<String> listado1;
    private ArrayList<String> listado2;
    private JList<String> listaScroll1;
    private JList<String> listaScroll2;
    private int i;
    private int j;
    private JScrollPane Scroll;
    
    //Botones
    private JButton CrearPlaneta;
    private JButton ModificarPlaneta;
    private JButton btnMissatge;
    //Casillas
    private JRadioButton Manual;
    private JRadioButton Automatico;
    private JRadioButton AutomaticoCN;

    
    public void actualiza() {
        try {
            mlistado.removeAllElements();
            listado1 = CVP.ConsultarNombresPlanetas(i);
            listado2 = CVP.ConsultarNombresPlanetas(j);
            listado = CVP.ConsultarNombresPlanetas();
            Errores.setText(String.valueOf(listado1.size()));
            CB.removeAllItems();
            listaScroll1.removeAll();
            if (listado.size() != 0) {  
                CB.setEditable(true);
                for (String s : listado) CB.addItem(s);
                for (String p : listado1) mlistado.addElement(p);
                for (String p : listado2) mlistado.addElement(p);
                CB.revalidate();
                CB.repaint();
                listaScroll1.setModel(mlistado);
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
                listado1 = CVP.ConsultarNombresPlanetas(i);
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
                if(j+100<CVP.size()){
                    i=j;
                    j+=100;
                    mlistado.removeAllElements();
                    listado1.clear();
                    for(String e : listado2) listado1.add(e);
                    listado2 = CVP.ConsultarNombresPlanetas(j);
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
    public VistaPlaneta(ControladorVistaPlaneta ControladorVP) {
        CVP = ControladorVP;
        setOpaque(false);          
        setBackground(Color.WHITE); //Marco
        setLayout(null);
        j = 100;
        listado = new ArrayList<String>();
        mlistado = new DefaultListModel<String>();
        listado1 = new ArrayList<String>();
        listado2 = new ArrayList<String>();
        listaScroll1 = new JList<String>();
        listaScroll2 = new JList<String>();
        
        btnMissatge = new JButton("Error");
        btnMissatge.setBounds(0,475,75,25);
        btnMissatge.setBackground(SystemColor.activeCaption);
        add(btnMissatge);
    	Errores = new JTextField();
    	Errores.setEditable(false);
        Errores.setBackground(SystemColor.white);
        Errores.setBounds(75,475,700,25);
        Errores.setVisible(true);
    	add(Errores);
        
        btnMissatge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Errores.setText("");
            }
        }); 
        
        Scroll = new JScrollPane();
        listaScroll2 = new JList(mlistado);
        listaScroll2.setVisibleRowCount(10);
        listaScroll2.setValueIsAdjusting(true);
        listaScroll2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaScroll2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null)); 
        listaScroll2.setBackground(SystemColor.inactiveCaptionBorder); 
        Scroll.setViewportView(listaScroll2); 
        Scroll = new JScrollPane(listaScroll2);
        Scroll.setBounds(720,65,120,390);
        Scroll.setPreferredSize(new Dimension(152,217));
        add(Scroll);
        
        AdjustmentListener adjustmentListener = new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
                if(CVP.size() > 200) {  
                    if(Scroll.getVerticalScrollBar().getValue()== Scroll.getVerticalScrollBar().getMaximum()-Scroll.getVerticalScrollBar().getVisibleAmount()){
                        actualizaListaDown();
                    }
                    if(Scroll.getVerticalScrollBar().getValue()==Scroll.getVerticalScrollBar().getMinimum()){
                        actualizaListaUP();
                    }
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
                    textfield1.setText(n);
                    textfield2.setText(CVP.ConsultarCoste(n));
                    textfield3.setText(CVP.ConsultarCoordenadaX(n));
                    textfield4.setText(CVP.ConsultarCoordenadaY(n));
                    textfield17.setText(n);
                    textfield18.setText(CVP.ConsultarCoste(n));
                    textfield19.setText(CVP.ConsultarCoordenadaX(n));
                    textfield20.setText(CVP.ConsultarCoordenadaY(n));
                } 
                catch (Exception e) { 
                    Errores.setText(e.getMessage()); 
                } 
              } 
            } 
        });
        
        CB = new JComboBox<String>();
        CB.setBounds(720,15 , 120, 30);
        add(CB);
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
                        textfield17.setText(n);
                        textfield18.setText(CVP.ConsultarCoste(n));
                        textfield19.setText(CVP.ConsultarCoordenadaX(n));
                        textfield20.setText(CVP.ConsultarCoordenadaY(n));
                    }   
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        
        Central = new JTabbedPane(JTabbedPane.TOP);
        Central.setBorder(null);
        Central.setBackground(SystemColor.activeCaption);
        Central.setBounds(0, 0, 700, 450); //A la espera de consenso
        add(Central);
        
        Crear = new JPanel();
        Crear.setBackground(SystemColor.activeCaption);
        Crear.setBounds(0, 0, 700, 500);
        Central.addTab("Crear",null,Crear,null);
        Crear.setLayout(null);
        
        Manual = new JRadioButton("Manual");
        Manual.setSelected(false); 
        Manual.setBounds(400, 115, 120, 20);
        Manual.setOpaque(false);
        Crear.add(Manual);
        
        Automatico = new JRadioButton("Automatico");
        Automatico.setSelected(false);
        Automatico.setBounds(400, 165, 120, 20);
        Automatico.setOpaque(false);
        Crear.add(Automatico);
        
        AutomaticoCN = new JRadioButton("Automatico con Nombre");
        AutomaticoCN.setSelected(false);
        AutomaticoCN.setBounds(400, 215, 200, 20);
        AutomaticoCN.setOpaque(false);
        Crear.add(AutomaticoCN);
        
        ButtonGroup gb = new ButtonGroup();
        gb.add(Manual);
        gb.add(Automatico);
        gb.add(AutomaticoCN);
        
        label1 = new JLabel("Nombre :");
        label1.setBounds(50, 115, 60, 30); //Esperando
        Crear.add(label1);
        
        textfield8 = new JTextField();
        textfield8.setBounds(130, 115, 120, 30); //Esperando
        Crear.add(textfield8);
        textfield8.setColumns(10);  //??????
        textfield8.setEnabled(false);
        
        label2 = new JLabel ("Coste :");
        label2.setBounds(50, 165, 60, 30); //Esperar
        Crear.add(label2);
        
        textfield9 = new JTextField();
        textfield9.setBounds(130, 165, 120, 30); //Esperar
        Crear.add(textfield9);
        textfield9.setColumns(10);
        textfield9.setEnabled(false);
        
        label3 = new JLabel("X :");
        label3.setBounds(50, 215, 60, 30); //Esperar
        Crear.add(label3);
        
        textfield10 = new JTextField();
        textfield10.setBounds(130, 215, 120, 30); //Esperar
        Crear.add(textfield10);
        textfield10.setColumns(10);
        textfield10.setEnabled(false);
                
        label4 = new JLabel("Y :");
        label4.setBounds(50, 265, 60, 30); //Esperar
        Crear.add(label4);
        
        textfield11 = new JTextField();
        textfield11.setBounds(130, 265, 120, 30); //Esperar
        Crear.add(textfield11);
        textfield11.setColumns(10);
        textfield11.setEnabled(false);
        
        /*Manual.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()) {
                        textfield8.setEnabled(true);
                        textfield9.setEnabled(true);
                        textfield10.setEnabled(true);
                        textfield11.setEnabled(true);
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
                        textfield8.setEnabled(false);
                        textfield9.setEnabled(false);
                        textfield10.setEnabled(false);
                        textfield11.setEnabled(false);
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
                        textfield8.setEnabled(true);
                        textfield9.setEnabled(false);
                        textfield10.setEnabled(false);
                        textfield11.setEnabled(false);
                        Manual.setSelected(false);
                        Automatico.setSelected(false);
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });*/
        
        CrearPlaneta = new JButton("Crear");
        CrearPlaneta.setIcon(null);
        CrearPlaneta.setBounds(250, 365, 200, 50);
        Crear.add(CrearPlaneta);
        
        
        CrearPlaneta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(Manual.isSelected()){
                        String n = textfield8.getText();
                        String c = textfield9.getText();
                        String x = textfield10.getText();
                        String y = textfield11.getText();
                        CVP.CrearPlaneta(n, c, x, y);
                        actualiza();
                    }
                    if(Automatico.isSelected()) {
                        CVP.CrearPlaneta();
                        actualiza();
                    }
                    if(AutomaticoCN.isSelected()){
                        String n = textfield1.getText();
                        CVP.CrearPlaneta(n);
                        actualiza();
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
                textfield8.setText("");
                textfield9.setText("");
                textfield10.setText("");
                textfield11.setText("");
            }
        });
        
        Modificar = new JPanel();
        Modificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Modificar", null,Modificar,null);
        Modificar.setBounds(0, 0, 700, 500);
        Modificar.setLayout(null);
        
        label11 = new JLabel("Configuracion Actual");
        label11.setBounds(50, 50, 120, 30);
        Modificar.add(label11);
        
        label12 = new JLabel("Configuracion Nueva");
        label12.setBounds(400, 50, 120, 30);
        Modificar.add(label12);
        
        label1 = new JLabel("Nombre :");
        label1.setBounds(50, 115, 60, 30); //Esperando
        Modificar.add(label1);
        
        textfield17= new JTextField();
        textfield17.setBounds(130, 115, 120, 30); //Esperando
        Modificar.add(textfield17);
        textfield17.setColumns(10);  //??????
        textfield17.setEnabled(false);
        
        label2 = new JLabel ("Coste :");
        label2.setBounds(50, 165, 60, 30); //Esperar
        Modificar.add(label2);
        
        textfield18 = new JTextField();
        textfield18.setBounds(130, 165, 120, 30); //Esperar
        Modificar.add(textfield18);
        textfield18.setColumns(10);
        textfield18.setEnabled(false);
        
        label3 = new JLabel("X :");
        label3.setBounds(50, 215, 60, 30); //Esperar
        Modificar.add(label3);
        
        textfield19 = new JTextField();
        textfield19.setBounds(130, 215, 120, 30); //Esperar
        Modificar.add(textfield19);
        textfield19.setColumns(10);
        textfield19.setEnabled(false);
                
        label4 = new JLabel("Y :");
        label4.setBounds(50, 265, 60, 30); //Esperar
        Modificar.add(label4);
        
        textfield20 = new JTextField();
        textfield20.setBounds(130, 265, 120, 30); //Esperar
        Modificar.add(textfield20);
        textfield20.setColumns(10);
        textfield20.setEnabled(false);
        
        label5 = new JLabel ("Coste :");
        label5.setBounds(400, 165, 50, 30); //Esperar
        Modificar.add(label5);
        
        textfield5 = new JTextField();
        textfield5.setBounds(480, 165, 120, 30); //Esperar
        Modificar.add(textfield5);
        textfield5.setColumns(10);
        
        
        label6 = new JLabel("X :");
        label6.setBounds(400, 215, 50, 30); //Esperar
        Modificar.add(label6);
        
        textfield6 = new JTextField();
        textfield6.setBounds(480, 215, 120, 30); //Esperar
        Modificar.add(textfield6);
        textfield6.setColumns(10);
                
        label7 = new JLabel("Y :");
        label7.setBounds(400, 265, 50, 30); //Esperar
        Modificar.add(label7);
        
        textfield7 = new JTextField();
        textfield7.setBounds(480, 265, 120, 30); //Esperar
        Modificar.add(textfield7);
        textfield7.setColumns(10);
        
        ModificarPlaneta = new JButton("Modificar");
        ModificarPlaneta.setIcon(null);
        ModificarPlaneta.setBounds(250, 365, 200, 50);
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
        label1.setBounds(200, 115, 60, 30);
        Consultar.add(label1);
        
        textfield1 = new JTextField();
        textfield1.setColumns(10);
        textfield1.setBounds(380, 115, 120, 30);
        textfield1.setEnabled(false);
        Consultar.add(textfield1);
        
        label2 = new JLabel("Coste :");
        label2.setBounds(200, 165, 50, 30);
        Consultar.add(label2);
        
        textfield2 = new JTextField();
        textfield2.setColumns(10);
        textfield2.setBounds(380, 165, 120, 30);
        textfield2.setEnabled(false);
        Consultar.add(textfield2);
        
        label3 = new JLabel("X :");
        label3.setBounds(200, 215, 50, 30);
        Consultar.add(label3);
        
        textfield3 = new JTextField();
        textfield3.setColumns(10);
        textfield3.setBounds(380, 215, 120, 30);
        Consultar.add(textfield3);
        textfield3.setEnabled(false);
        
        label3 = new JLabel("Y :");
        label3.setBounds(200, 265, 50, 30);
        Consultar.add(label3);
        
        textfield4 = new JTextField();
        textfield4.setColumns(10);
        textfield4.setBounds(380, 265, 120, 30);
        Consultar.add(textfield4);
        textfield4.setEnabled(false);
        
        FrameGuardar = new JInternalFrame();
        FrameGuardar.setBackground(SystemColor.activeCaption);
        Central.addTab("Guardar", null, FrameGuardar, null);
        FrameGuardar.setLayout(null);
        
        Guardar = new JFileChooser();
        Guardar.setBounds(0, 0, 690, 390);
        Guardar.setAutoscrolls(true);
        Guardar.setMinimumSize(new Dimension(200, 245)); 
        Guardar.setPreferredSize(new Dimension(365, 200));
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
        Cargar.setBounds(0, 0, 690, 390);
        Cargar.setAutoscrolls(true);
        Cargar.setMinimumSize(new Dimension(200, 245)); 
        Cargar.setPreferredSize(new Dimension(365, 200));
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

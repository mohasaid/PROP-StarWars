
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class VistaMFP extends PrimerNivel {
    private ControladorVistaMFP cvMFP;
    
    private JButton Ejecutar;
    private JButton Mostrar;
    
    private JRadioButton FCF;
    private JRadioButton FCC;
    private JRadioButton FCD;
    private JRadioButton FFBFS;
    private JRadioButton FFD;
    private JRadioButton PR;
    private JRadioButton STotal;
    private JRadioButton SParcial;
    private JButton btnMissatge;
    public VistaMFP (ControladorVistaMFP cv){
        cvMFP = cv;
        setOpaque(false);
        setBackground(Color.WHITE);
        setLayout(null);
        
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
        
        Central = new JTabbedPane(JTabbedPane.TOP);
        Central.setBackground(SystemColor.activeCaption);
        Central.setBounds(0, 0, 700, 450);
        add(Central);
        
        Crear = new JPanel();
        Crear.setBackground(SystemColor.activeCaption);
        Crear.setBounds(0, 0, 700, 500);
        Central.addTab("Opciones",null,Crear,null);
        Crear.setLayout(null);
        
        FCF = new JRadioButton("Flujo");
        FCF.setSelected(false);
        FCF.setOpaque(false);
        FCF.setBounds(100, 115, 120, 20);
        Crear.add(FCF);
        
        FCC = new JRadioButton("Coste");
        FCC.setSelected(false);
        FCC.setOpaque(false);
        FCC.setBounds(100, 165, 120, 20);
        Crear.add(FCC);
        
        FCD = new JRadioButton("Distancia");
        FCD.setSelected(false);
        FCD.setOpaque(false);
        FCD.setBounds(100, 215, 120, 20);
        Crear.add(FCD);
        
        label1 = new JLabel("Funciones de Coste");
        label1.setBounds(100, 50, 120, 20);
        Crear.add(label1);
        
        FCF.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    if(FCF.isSelected()) {
                        FCC.setSelected(false);
                        FCD.setSelected(false);
                    }
                }
                catch (Exception e){
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        FCC.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    if(FCC.isSelected()) {
                        FCF.setSelected(false);
                        FCD.setSelected(false);
                    }
                }
                catch (Exception e){
                    Errores.setText(e.getMessage());
                }
            }
        });
        FCD.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    if(FCD.isSelected()) {
                        FCF.setSelected(false);
                        FCC.setSelected(false);
                    }
                }
                catch (Exception e){
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        FFBFS = new JRadioButton("Ford-Fulkerson + BFS");
        FFBFS.setBounds(400, 115, 180, 20);
        FFBFS.setOpaque(false);
        FFBFS.setSelected(false);
        Crear.add(FFBFS);
        
        FFD = new JRadioButton("Ford-Fulkerson + Dijkstra");
        FFD.setSelected(false);
        FFD.setOpaque(false);
        FFD.setBounds(400, 165, 180, 20);
        Crear.add(FFD);
        
        PR = new JRadioButton("Push-Relabel");
        PR.setSelected(false);
        PR.setOpaque(false);
        PR.setBounds(400, 215, 180, 20);
        Crear.add(PR);
        
        label2 = new JLabel("Algoritmos");
        label2.setBounds(400, 50, 120, 20);
        Crear.add(label2);
        
        FFBFS.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    if(FFBFS.isSelected()) {
                        FFD.setSelected(false);
                        PR.setSelected(false);
                    }
                }
                catch (Exception e){
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        FFD.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    if(FFD.isSelected()) {
                        FFBFS.setSelected(false);
                        PR.setSelected(false);
                    }
                }
                catch (Exception e){
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        PR.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    if(PR.isSelected()) {
                        FFBFS.setSelected(false);
                        FFD.setSelected(false);
                    }
                }
                catch (Exception e){
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        Ejecutar = new JButton("Ejecutar");
        Ejecutar.setIcon(null);
        Ejecutar.setBounds(250, 360, 200, 50);
        Crear.add(Ejecutar);
        
        Ejecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(FCF.isSelected()) cvMFP.SeleccionarFuncionCoste(1);
                    if(FCC.isSelected()) cvMFP.SeleccionarFuncionCoste(2);
                    if(FCD.isSelected()) cvMFP.SeleccionarFuncionCoste(3);
                    if(FFBFS.isSelected()) cvMFP.SeleccionarAlgoritmo(1);
                    if(FFD.isSelected()) cvMFP.SeleccionarAlgoritmo(2);
                    if(PR.isSelected()) cvMFP.SeleccionarAlgoritmo(3);
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
            
        });
        
        Consultar = new JPanel();
        Consultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Salida", null,Consultar,null);
        Consultar.setLayout(null);
        Consultar.setBounds(0, 0, 700, 500);
        
        STotal = new JRadioButton("Salida Total");
        STotal.setSelected(false);
        STotal.setOpaque(false);
        STotal.setBounds(100, 25, 120, 20);
        Consultar.add(STotal);
        
        SParcial = new JRadioButton("Salida Parcial");
        SParcial.setSelected(false);
        SParcial.setOpaque(false);
        SParcial.setBounds(230, 25, 120, 20);
        Consultar.add(SParcial);
        ButtonGroup gb = new ButtonGroup();
        gb.add(STotal);
        gb.add(SParcial);
        
        /*STotal.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    if(STotal.isSelected()) SParcial.setSelected(false);
                }
                catch (Exception e){
                    Errores.setText(e.getMessage());
                }
            }
        });
        
        SParcial.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent a) {
                try {
                    if(SParcial.isSelected()) STotal.setSelected(false);
                }
                catch (Exception e){
                    Errores.setText(e.getMessage());
                }
            }
        });*/
        
        Mostrar = new JButton("Mostrar");
        Mostrar.setIcon(null);
        Mostrar.setBounds(250, 360, 200, 50);
        Consultar.add(Mostrar);
       
        JTextArea TA = new JTextArea(); 
        TA.setEnabled(true);
        TA.setEditable(true);
        TA.setBounds(50, 50, 600, 370);
        JScrollPane Sal = new JScrollPane(TA);
        Sal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        Sal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Sal.setBounds(50, 50, 600, 300);
        Consultar.add(Sal);
        
        Mostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(STotal.isSelected()) textfield1.setText(cvMFP.ConsultarSalida());
                    if(SParcial.isSelected()) textfield1.setText(cvMFP.ConsultarSalidaParcial());
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
    }
    
}

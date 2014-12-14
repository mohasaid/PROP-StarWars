
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
    
    public VistaMFP (ControladorVistaMFP cv){
        cvMFP = cv;
        setOpaque(false);
        setBackground(Color.WHITE);
        setLayout(null);
        
        Central = new JTabbedPane(JTabbedPane.TOP);
        Central.setBackground(SystemColor.activeCaption);
        Central.setBounds(50, 50, 700, 500);
        
        Crear = new JPanel();
        Crear.setBackground(SystemColor.activeCaption);
        Central.add("Opciones", Crear);
        
        FCF = new JRadioButton("Flujo");
        FCF.setSelected(false);
        FCF.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Crear.add(FCF);
        
        FCC = new JRadioButton("Coste");
        FCC.setSelected(false);
        FCC.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Crear.add(FCC);
        
        FCD = new JRadioButton("Distancia");
        FCD.setSelected(false);
        FCD.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Crear.add(FCD);
        
        label1 = new JLabel("Funciones de Coste");
        label1.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
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
        FFBFS.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        FFBFS.setSelected(false);
        Crear.add(FFBFS);
        
        FFD = new JRadioButton("Ford-Fulkerson + Dijkstra");
        FFD.setSelected(false);
        FFD.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Crear.add(FFD);
        
        PR = new JRadioButton("Push-Relabel");
        PR.setSelected(false);
        PR.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Crear.add(PR);
        
        label2 = new JLabel("Algoritmos");
        label2.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
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
        Ejecutar.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
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
        
        STotal = new JRadioButton("Salida Total");
        STotal.setSelected(false);
        STotal.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(STotal);
        
        SParcial = new JRadioButton("Salida Parcial");
        SParcial.setSelected(false);
        SParcial.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(SParcial);
        
        STotal.addActionListener(new ActionListener() {
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
        });
        
        Mostrar = new JButton("Mostrar");
        Mostrar.setIcon(null);
        Mostrar.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        Consultar.add(Mostrar);
       
        textfield1 = new JTextField();
        textfield1.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); 
        Consultar.add(textfield1);
        textfield1.setColumns(10);  //??????
        textfield1.setEditable(false);
        
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

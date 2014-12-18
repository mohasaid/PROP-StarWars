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
    private ButtonGroup group;
    private ButtonGroup group1;
    
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
        Errores.setBounds(75,475,625,25);
        Errores.setVisible(true);
        Errores.setForeground(Color.red);
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
        
        group1 = new ButtonGroup();
        group = new ButtonGroup();
        
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
        
        group.add(FCF);
        group.add(FCC);
        group.add(FCD);
        
        label1 = new JLabel("Funciones de Coste");
        label1.setBounds(100, 50, 120, 20);
        Crear.add(label1);
        
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
        
        group1.add(FFBFS);
        group1.add(FFD);
        group1.add(PR);
        
        label2 = new JLabel("Algoritmos");
        label2.setBounds(400, 50, 120, 20);
        Crear.add(label2);
        
        Ejecutar = new JButton("Ejecutar");
        Ejecutar.setIcon(null);
        Ejecutar.setBounds(250, 360, 200, 50);
        Crear.add(Ejecutar);
        
        Ejecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    if(FCF.isSelected()) {
                        cvMFP.SeleccionarFuncionCoste(1);
                    }
                    if(FCC.isSelected()) {
                        cvMFP.SeleccionarFuncionCoste(2);
                    }
                    if(FCD.isSelected()) {
                        cvMFP.SeleccionarFuncionCoste(3);
                    }
                    if(FFBFS.isSelected()) {
                        cvMFP.SeleccionarAlgoritmo(1);
                    }
                    if(FFD.isSelected()) {
                        cvMFP.SeleccionarAlgoritmo(2);
                    }
                    if(PR.isSelected()) {
                        cvMFP.SeleccionarAlgoritmo(3);
                    }
                    cvMFP.Ejecutar();
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
                
        Mostrar = new JButton("Mostrar");
        Mostrar.setIcon(null);
        Mostrar.setBounds(250, 360, 200, 50);
        Consultar.add(Mostrar);
       
        JTextArea TA = new JTextArea(); 
        TA.setEnabled(true);
        TA.setEditable(true);
        TA.setBounds(50, 50, 600, 370);
        JScrollPane Sal = new JScrollPane(TA);
        Sal.setBounds(50, 50, 600, 300);
        Consultar.add(Sal);
        
        Mostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    TA.setText("");
                    if(STotal.isSelected()) {
                        TA.setText(cvMFP.ConsultarSalida());
                    }
                    if(SParcial.isSelected()) {
                        TA.setText(cvMFP.ConsultarSalidaParcial());
                    }
                }
                catch (Exception e) {
                    Errores.setText(e.getMessage());
                }
            }
        });
    }
}

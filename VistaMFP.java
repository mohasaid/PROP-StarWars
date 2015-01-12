/**
 *
 * @author Moha
 */
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.apache.commons.collections15.Transformer;

public class VistaMFP extends PrimerNivel {
    private ControladorVistaMFP cvMFP;
    boolean EJECUTADO = false;
    
    private JButton Ejecutar;
    private JButton Mostrar;
    private JButton MGrafo;
        
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
    
    private DibujoGrafo dg;
    
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
        Central.setBounds(0, 0, 700, 450);
        add(Central);
        
        Crear = new JPanel();
        Crear.setBackground(SystemColor.activeCaption);
        Crear.setBounds(0, 0, 700, 500);
        Central.addTab("Opciones",Crear);
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
            Thread worker = new Thread(){
            public void run(){  
                try{
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
                    setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    Errores.setText("Ejecutando algoritmo ...");
                    cvMFP.Ejecutar();
                    EJECUTADO = true;
                    Errores.setText("-- ALGORITMO EJECUTADO --");
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                catch(Exception e){
                    Errores.setText(e.getMessage());
                }
            }
            };
            worker.start(); 
            } 
        });
        
        Consultar = new JPanel();
        Consultar.setBackground(SystemColor.activeCaption);
        Central.addTab("Salida",Consultar);
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
        Mostrar.setBounds(250, 360, 200, 50);
        Consultar.add(Mostrar);
       
        final JTextArea TA = new JTextArea(); 
        TA.setEnabled(true);
        TA.setEditable(false);
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
        
        Modificar = new JPanel();
        Modificar.setBackground(SystemColor.activeCaption);
        Central.addTab("Grafo",Modificar);
        Modificar.setLayout(null);
        Modificar.setBounds(0, 0, 700, 500);
        
        MGrafo = new JButton("Mostrar Grafo");
        MGrafo.setBounds(250, 360, 200, 50);
        Modificar.add(MGrafo);
        
        MGrafo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
            	if(EJECUTADO) {
	                Grafo residual = cvMFP.consultarGrafoResidual();
	                dg = new DibujoGrafo(residual);
	
	                Graph<String, String> g = dg.consultaGrafo();
                        Layout<String, String> layout = new CircleLayout(g);
	                layout.setSize(new Dimension(700,360)); 
	
	                BasicVisualizationServer<String,String> vv = new BasicVisualizationServer<String,String>(layout);
	                vv.setPreferredSize(new Dimension(700,360));
	                
	                vv.getRenderContext().setVertexLabelTransformer
	                (
	                    new Transformer<String, String>() {
	                        @Override
	                        public String transform(String nom) {
	                            return nom;
	                        }
	                });
	                
         
	                vv.getRenderContext().setVertexFillPaintTransformer
	                (
	                    new Transformer<String,Paint>() {
	                        @Override
	                        public Paint transform(String i) {
	                            if((i.equals("OF") || (i.equals("DF")))) return Color.GREEN;
	                            return Color.RED;
	                        }
	                    }
	                );
	                
                        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
                        vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
                        
	                vv.getRenderContext().setVertexFontTransformer
	                (
	                    new Transformer<String,Font>() {
	                        @Override
	                        public Font transform(String i) {
	                            if((i.equals("OF") || (i.equals("DF")))) return new Font("Helvetica", Font.PLAIN, 12);
	                            return new Font("Helvetica", Font.PLAIN, 9);
	                        }
	                    }
	                );
	                
	                vv.setBackground(SystemColor.activeCaption);
	                vv.setBounds(0, 0, 700, 360);
	                Modificar.add(vv);
            	}
            }
        });
    }
}

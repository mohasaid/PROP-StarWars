/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elena
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.ComboBox;


public class VistaHelp extends PrimerNivel{

    private String Galaxia = "Opciones de galaxia:";
    private String Naves = "Opciones de naves:";
    private String Planetas = "Opciones de planetas:";
    private String Rutas = "Opciones de Rutas:"; 
    private String MFlow = "Opciones de Max Flow:";
    private String CrearG = "Creacion de galaxia";
    private String ModifG = "Modificación de galaxia";
    private String ConsultaG = "Consulta de galaxia";
    private String GuardaG = "Guardar galaxia";
    private String CargaG = "Cargar galaxia";
    private String CrearR ="Creacion de ruta";
    private String ModifR = "Modificacion de ruta";
    private String ConsultaR = "Consulta de ruta";
    private String GuardaR = "Guardar rutas";
    private String CargaR = "Cargar rutas";
    private String EliminaR = "Eliminar rutas";
    private String CrearN = "Creacion de nave";
    private String ModifN = "Modificacion de nave";
    private String ConsultaN = "Consulta de nave";
    private String GuardaN = "Guardar naves";
    private String CargaN = "Cargar naves";
    private String EliminaN = "Eliminar naves";
    private String CrearTN = "Creacion de Tipo de Nave";
    private String ModifTN = "Modificacion tipo de nave";
    private String ConsultaTN = "Consulta tipo de nave";
    private String CrearP = "Creacion de planeta";
    private String ModifP = "Modificacion de planeta";
    private String ConsultaP = "Consulta de planeta";
    private String GuardaP = "Guardar planetas";
    private String CargaP = "cargar planetas";
    
    private JTextArea textfield1;
    private JLabel Clip;
    
    public VistaHelp(){
        setLayout(null);
        textfield1 = new JTextArea();
        textfield1.setEnabled(false);
        textfield1.setBounds(150,70,600,350);
        
        Clip = new JLabel();
        //Clip.setIcon(new ImageIcon(VistaHelp.class.getResource("/WordClip.png")));
        Clip.setBounds(320,200,50,50);
        
        CB = new JComboBox<String>();
        CB.setBounds(150,50,600,20);
        
        CB.addItem(MFlow);
        CB.addItem(Galaxia);
        CB.addItem(CrearG);
        CB.addItem(ModifG);
        CB.addItem(ConsultaG);
        CB.addItem(GuardaG);
        CB.addItem(CargaG);
        CB.addItem(Rutas);
        CB.addItem(CrearR);
        CB.addItem(ModifR);
        CB.addItem(ConsultaR);
        CB.addItem(GuardaR);
        CB.addItem(CargaR);
        CB.addItem(EliminaR);
        CB.addItem(CrearN);
        CB.addItem(ModifN);
        CB.addItem(Naves);
        CB.addItem(ConsultaN);
        CB.addItem(GuardaN);
        CB.addItem(CargaN);
        CB.addItem(EliminaN);
        CB.addItem(CrearTN);
        CB.addItem(ModifTN);
        CB.addItem(ConsultaTN);
        CB.addItem(Planetas);
        CB.addItem(CrearP);
        CB.addItem(ModifP);
        CB.addItem(ConsultaP);
        CB.addItem(GuardaP);
        CB.addItem(CargaP);
        
        CB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                    String n = CB.getSelectedItem().toString();
                    if(!n.equals("")){
                        if(n==CrearN) textfield1.setText("Crear:\n\n"
                                + "Haga clic en el boton \"Nave\". "
                                + "Se abrira un panel con pestañas"
                                + "Seleccione la pestaña \"Crear\".\n"
                                + "Seleccione la pestaña \"Nave\"\n"
                                + "Elija el modo en el que quiere crear la nave, manual o automatico."
                                + "en el primer caso introduzca el nombre del planeta origen y el planeta destino"
                                + "en los campos indicados, estos planetas deben de haber sido creados previamente. "
                                + "Después introduzca el tipo de nave, que, una vez mas, debe haber sido"
                                + "definido con anterioridad."
                                + "Si desea crear naves de forma automatica solo debe indicar el numero de naves a crear.\n"
                                + "Por último haga clic en el boton \"Crear\".\n");
                        
                        else if(n==ModifP) textfield1.setText("Modificar:\n\n"
                                + "Haga clic en el boton \"Nave\". "
                                + "Se abrira un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Modificar\"\n"
                                + "Seleccione la pestaña \"Nave\"\n"
                                + "Seleccione en el menú desplegable de la derecha o en la lista que se encuentra bajo este nua nave,"
                                + "una vez selecionada se mostrarán los atributos actuales de la nave seleccionada.\n"
                                + "escriba los nuevos valores de los atributos de la nave que desee modificar y haga clic en el botón \"modificar\" "
                                + "que se encuentra en la esquina inferior derecha del panel\n");
                        else if(n==ConsultaN) textfield1.setText("Consultar:\n\n"
                                + "Haga clic en el boton \"Nave\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Consultar\".\n"
                                + "Seleccione la pestaña \"Nave\".\n"
                                + "Seleccione en el menu desplegable de la derecha o en la lista que se encuentra bajo este una nave,"
                                + "una vez hecho esto se mostraran los atributos actuales de la nave seleccionada.\n");
                        
                        else if(n==GuardaN) textfield1.setText("Guardar: \n\n"
                                + "Haga clic en el boton \"Nave\"."
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Guardar\".\n"
                                + "Busque utilizando el navegador de ficheros el path hacia el archivo donde desea guardar las naves existentes\n"
                                + "Haga clic en \"Abrir\".\n"
                                + "Sus naves habrán sido guardadas en el archivo indicado\n");
                        else if(n==CargaN) textfield1.setText("Cargar: \n\n"
                                + "Haga clic en el boton \"Nave\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Cargar\".\n"
                                + "Busque utilizando el navegador de ficheros el path hacia el archivo de donde desea cargar las naves existentes\n"
                                + "Haga clic en \"Abrir\".\n"
                                + "Sus naves habrán sido cargadas desde el archivo indicado al sistema\n");
                        else if(n==EliminaN) textfield1.setText("Eliminar:\n\n"
                                + "Haga clic en el boton \"Nave\". "
                                + "Seleccione en el menu desplegable que aparecerá a la derecha o en la lista que se encuentra bajo este la nave que desea eliminar, "
                                + "una vez seleccionada haga clic en el botón \"Eliminar\" para eliminar dicha nave.\n");
                        
                        
                        
                        if(n==CrearTN) textfield1.setText("Crear:\n\n"
                                + "Haga clic en el boton \"Nave\". "
                                + "Se abrira un panel con pestañas"
                                + "Seleccione la pestaña \"Crear\".\n"
                                + "Seleccione la pestaña \"TipoNave\"\n"
                                + "Elija el modo en el que quiere crear el tipo de nave, manual o automatico."
                                + "en el primer caso seleccione el identificador del tipo que desea definir e introduzca el coste que tendrá asociado.\n"
                                + "Este coste debe ser un valor numerico superior a 0.\n"
                                + "Si desea crear un tipo de nave de forma automatica solo debe seleccionar esta opción"
                                + "Por último haga clic en el boton \"Crear\".\n");
                        else if(n==ModifTN) textfield1.setText("Modificar:\n\n"
                                + "Haga clic en el boton \"Nave\". "
                                + "Se abrira un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Modficar\"\n"
                                + "Seleccione la pestaña \"TipoNave\"\n"
                                + "Seleccione en el menú desplegable de la derecha o en la lista que se encuentra bajo este un tipo de nave,"
                                + "una vez selecionado se mostrarán los atributos actuales del tipo de nave.\n"
                                + "escriba los nuevos valores de los atributos que desee modificar y haga clic en el botón \"modificar\" "
                                + "que se encuentra en la esquina inferior derecha del panel\n");
                        else if(n==ConsultaTN) textfield1.setText("Consultar:\n\n"
                                + "Haga clic en el boton \"Nave\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Consutar\"\n"
                                + "Seleccione la pestaña \"TipoNave\".\n"
                                + "Seleccione en el menu desplegable de la derecha o en la lista que se encuentra bajo este un tipo de nave,"
                                + "una vez hecho esto se mostraran los atributos actuales del tipo de nave seeccionado.\n");

                        
                         if(n==CrearP) textfield1.setText("Crear:\n\n"
                                + "Haga clic en el boton \"Planeta\". "
                                + "Se abrira un panel con pestañas"
                                + "Seleccione la pestaña \"Crear\".\n"
                                + "Elija el modo en el que quiere crear el planeta, manual o automatico."
                                + "en el primer caso introduzca el Nombre que le quiere dar al planeta, el coste que tendrá asociado y las coordenadas en las que se encuentra.\n"
                                + "las coordenadas deben estar dentro de los limites de la galaxia.\n"
                                + "Si desea crear un planeta de forma automatico simplemente seleccione esta opcion.\n"
                                + "Por último haga clic en el boton \"Crear\".\n");
                         else if(n==ModifP) textfield1.setText("Modificar:\n\n"
                                + "Haga clic en el boton \"Planeta\". "
                                + "Se abrira un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Modificar\"\n"
                                + "Seleccione en el menú desplegable de la derecha o en la lista que se encuentra bajo este un planeta,"
                                + "una vez hacho esto se mostrarán los atributos actuales del planeta seleccionado.\n"
                                + "escriba los nuevos valores de los atributos que desee modificar y haga clic en el botón \"Modificar\" "
                                + "que se encuentra en la esquina inferior derecha del panel\n");
                        else if(n==ConsultaP) textfield1.setText("Consultar:\n\n"
                                + "Haga clic en el boton \"Planeta\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Consultar\".\n"
                                + "Seleccione en el menu desplegable de la derecha o en la lista que se encuentra bajo este un planeta,"
                                + "una vez hecho esto se mostraran los atributos actuales del planeta seleccionada.\n");                        
                        else if(n==GuardaP) textfield1.setText("Guardar: \n\n"
                                + "Haga clic en el boton \"Planeta\"."
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Guardar\".\n"
                                + "Busque utilizando el navegador de ficheros el path hacia el archivo donde desea guardar los planetas existentes\n"
                                + "Haga clic en \"Abrir\".\n"
                                + "Sus planetas habrán sido guardadas en el archivo indicado\n");
                        else if(n==CargaP) textfield1.setText("Cargar: \n\n"
                                + "Haga clic en el boton \"Planeta\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Cargar\".\n"
                                + "Busque utilizando el navegador de ficheros el path hacia el archivo de donde desea cargar los planetas existentes\n"
                                + "Haga clic en \"Abrir\".\n"
                                + "Sus plantetas habrán sido cargados desde el archivo indicado al sistema\n");
                         
                         
                         
                          if(n==CrearR) textfield1.setText("Crear:\n\n"
                                + "Haga clic en el boton \"Ruta\". "
                                + "Se abrira un panel con pestañas"
                                + "Seleccione la pestaña \"Crear\".\n"
                                + "Elija el modo en el que quiere crear la ruta, manual, automatico o automatico con id."
                                + "en el primer caso introduzca el identificador, la distancia, la capacidad, y el identificador de los planetas que conecta.\n"
                                + "El identificador de la ruta dbe ser numerico mayor que 0, los planetas deben de existir en la galaxia y no se debe de haber alcanzado el máximo de rutas permitidas entre estos.\n"
                                + "Si desea crear una ruta de forma automatica con identificador seleccione dicha opción e introduzca un identificador.\n"
                                + "Si desea crear una ruta de forma automatica sin identificador simplemente seleccione esta opcion.\n"
                                + "Por último haga clic en el boton \"Crear\".\n");
                         else if(n==ModifR) textfield1.setText("Modificar:\n\n"
                                + "Haga clic en el boton \"Ruta\". "
                                + "Se abrira un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Modificar\"\n"
                                + "Seleccione en el menú desplegable de la derecha o en la lista que se encuentra bajo este una ruta,"
                                + "una vez hecho esto se mostrarán los atributos actuales del planeta seleccionado.\n"
                                + "escriba los nuevos valores de los atributos que desee modificar y haga clic en el botón \"Modificar\" "
                                + "que se encuentra en la esquina inferior derecha del panel\n");
                        else if(n==ConsultaR) textfield1.setText("Consultar:\n\n"
                                + "Haga clic en el boton \"Ruta\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Consultar\".\n"
                                + "Seleccione en el menu desplegable de la derecha o en la lista que se encuentra bajo este una ruta,"
                                + "una vez hecho esto se mostraran los atributos actuales de la ruta seleccionada.\n");                        
                        else if(n==GuardaR) textfield1.setText("Guardar: \n\n"
                                + "Haga clic en el boton \"Ruta\"."
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Guardar\".\n"
                                + "Busque utilizando el navegador de ficheros el path hacia el archivo donde desea guardar las rutas existentes\n"
                                + "Haga clic en \"Abrir\".\n"
                                + "Sus ruatas habrán sido guardadas en el archivo indicado\n");
                        else if(n==CargaR) textfield1.setText("Cargar: \n\n"
                                + "Haga clic en el boton \"Planeta\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Cargar\".\n"
                                + "Busque utilizando el navegador de ficheros el path hacia el archivo de donde desea cargar las rutas existentes\n"
                                + "Haga clic en \"Abrir\".\n"
                                + "Sus rutas habrán sido cargados desde el archivo indicado al sistema\n");
                        else if(n==EliminaR) textfield1.setText("Eliminar:\n\n"
                                + "Haga clic en el boton \"Ruta\". "
                                + "Seleccione en el menu desplegable que aparecerá a la derecha o en la lista que se encuentra bajo este la ruta que desea eliminar, "
                                + "una vez seleccionada haga clic en el botón \"Eliminar\" para eliminar dicha ruta.\n");
                        
                          
                          
                           if(n==CrearG) textfield1.setText("Crear:\n\n"
                                + "Haga clic en el boton \"Galaxia\". "
                                + "Se abrira un panel con pestañas"
                                + "Seleccione la pestaña \"Crear\".\n"
                                + "Elija el modo en el que quiere crear, con forma o sin ella."
                                + "en el primer caso introduzca el nombre de la galaxia, el límite y las coordenadas que dan forma a la galaxia de forma secuencial y coincidiendo la primera y a última.\n"
                                + "Si desea crear una galaxia sin forma simplemente introduzca su nombre y límite.\n"
                                + "El limite se corresponde con el tamaño de la galaxia."
                                + "Por último haga clic en el boton \"Crear\".\n");
                         else if(n==ModifG) textfield1.setText("Modificar:\n\n"
                                + "Haga clic en el boton \"Galaxia\". "
                                + "Se abrira un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Modificar\"\n"
                                + "Se mostrarán los atributos actuales de la galaxia.\n"
                                + "escriba los nuevos valores de los atributos que desee modificar y haga clic en el botón \"Modificar\" "
                                + "que se encuentra en la esquina inferior derecha del panel\n");
                        else if(n==ConsultaG) textfield1.setText("Consultar:\n\n"
                                + "Haga clic en el boton \"Galaxia\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Consultar\".\n"
                                + "Se mostraran los atributos actuales de la nave seleccionada.\n");                        
                        else if(n==GuardaG) textfield1.setText("Guardar: \n\n"
                                + "Haga clic en el boton \"Galaxia\"."
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Guardar\".\n"
                                + "Busque utilizando el navegador de ficheros el path hacia el archivo donde desea guardar la galaxia existente\n"
                                + "Haga clic en \"Abrir\".\n"
                                + "Su galaxia habrá sido guardada en el archivo indicado\n");
                        else if(n==CargaG) textfield1.setText("Cargar: \n\n"
                                + "Haga clic en el boton \"Galaxia\". "
                                + "Se abrirá un panel con pestañas.\n"
                                + "Seleccione la pestaña \"Cargar\".\n"
                                + "Busque utilizando el navegador de ficheros el path hacia el archivo de donde desea cargar los planetas existentes\n"
                                + "Haga clic en \"Abrir\".\n"
                                + "Su galaxia habrá sido cargada desde el archivo indicado al sistema\n");
                    }   
            }
        });
        add(Clip);
        add(textfield1);
        add(CB);
        setVisible(true);
        
    }
     
    
}

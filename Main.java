/**
 *
 * @author Moha
 */
import javax.swing.UIManager;
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
            new Runnable() {
                    public void run() {
                    try {
                         try {
                           UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
                         }
                         catch (Exception e) {}

                        ControladorVistaGalaxia cVistaGalaxia = new ControladorVistaGalaxia();
                        ControladorVistaNave cVistaNave = new ControladorVistaNave();
                        ControladorVistaRuta cVistaRuta = new ControladorVistaRuta();
                        ControladorVistaPlaneta cVistaPlaneta = new ControladorVistaPlaneta();
                        ControladorVistaMFP cVistaMFP = new  ControladorVistaMFP();

                        cVistaPlaneta.ImportarVistas(cVistaGalaxia,cVistaRuta,cVistaNave);
                        cVistaRuta.inicialitza(cVistaPlaneta);
                        cVistaNave.start(cVistaPlaneta);
                        cVistaMFP.Importar(cVistaGalaxia, cVistaPlaneta, cVistaRuta, cVistaNave);

                        VistaPrincipal frame = new VistaPrincipal(cVistaGalaxia,cVistaPlaneta,cVistaNave,cVistaRuta,cVistaMFP);
                        frame.setVisible(true);                                
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        });
    }
}

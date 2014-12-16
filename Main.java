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
		                    VistaPrincipal frame = new VistaPrincipal(cVistaGalaxia);
		                    frame.setVisible(true);                                
		                }
		                catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
        	    });
    }
}

import javax.swing.UIManager;
 
public class Main {
    /**
     * Launch the application.
     */
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
		                    //ControladorVistaPlaneta cVistaPlaneta = new ControladorVistaPlaneta();
		                    //ControladorVistaRuta cVistaRuta = new ControladorVistaRuta();
		                    //ControladorVistaNave cVistaNave = new ControladorVistaNave();
		                    ControladorVistaMFP cVistaMFP = new ControladorVistaMFP();
		                    
		                    //cVistaGalaxia.inicialitza(cVistaPlaneta,cVistaTerraformacio);                   
		                    //cVistaPlaneta.inicialitza(cVistaGalaxia, cVistaPaquet, cVistaRecurs);
		                    //cVistaRuta.inicialitza(cVistaPlaneta, cVista);
		                    //cVistaNave.inicialitza(cVistaPlaneta, cVistaPaquet, cVistaTerraformacio);
		                    //cVistaMFP.inicialitza(cVistaGalaxia,cVistaPlaneta);                       
		                     
		                    //VistaPrincipal frame = new VistaPrincipal(cVistaGalaxia,/*cVistaPlaneta,cVistaRuta,cVistaNave,*/cVistaMFP);
		                    //frame.setVisible(true);                                
		                }
		                catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
        	    });
    }
     
}

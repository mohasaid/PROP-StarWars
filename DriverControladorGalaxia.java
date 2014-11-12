import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DriverControladorGalaxia {
	private ControladorGalaxia cGalaxia;
	private Scanner cin = new Scanner(System.in);
	
	public void Executa(ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn)
	{
        int n;
        System.out.print(
	              "---------------------------------------------------------------------------------------- \n"
	            + "                               DRIVER CONTROLADOR GALAXIA                                \n"
	            + "---------------------------------------------------------------------------------------- \n"
	            + "- Opcion 0: Salir de la gestion del driver                                        	    \n"
	            + "- Opcion 1: ControladorGalaxia()                                           				\n"       
	            + "- Opcion 2: creaGalaxia(String nom,int n)   												\n"      
	            + "- Opcion 3: creaGalaxia2(String nom, int n, List<Pair<Integer, Integer> > l) 			\n"       
	            + "- Opcion 4: consultar_nom()										   						\n"     
	            + "- Opcion 5: consultarElementsGalaxia() 							   						\n"     
	            + "- Opcion 6: llista_galaxia() 									    					\n"
	            + "- Opcion 7: llista_planetes() 										    				\n"
	            + "- Opcion 8: llista_rutes() 								    							\n"
	            + "- Opcion 9: llista_naus()										    					\n"
	            + "- Opcion 10: consultarNumPlanetes() 								    					\n"
	            + "- Opcion 11: consultarLimit() 										    				\n"
	            + "- Opcion 12: existeixPlaneta(int idplaneta) 										    	\n"
	            + "- Opcion 13: modificarNom(String nomNou) 				    							\n"
	            + "- Opcion 14: modificarLimit(int limitNou) 						        				\n"
	            + "- Opcion 15: afegirPlaneta(ControladorPlaneta cp, int idPlaneta, int x, int y) 			\n"
	            + "- Opcion 16: afegirPlanetaAutomatic(ControladorPlaneta cp, int idPlaneta)   			    \n"
	            + "- Opcion 17: eliminarPlaneta(int idPlaneta, ControladorPlaneta cp) 					 	\n"
	            + "- Opcion 18: afegirRuta(int idRuta) 									    				\n"
	            + "- Opcion 19: eliminarRuta(int idRuta) 											    	\n"
	            + "- Opcion 20: afegirNau(int idn) 									    					\n"
	            + "- Opcion 21: eliminarNau(int idNau) 							    						\n"
	            + "- Opcion 22: eliminarContingutGalaxia()  						    					\n"
	            + "- Opcion 23: carregarConjuntGalaxia(String directori) 									\n"
	            + "- Opcion 24: guardarConjuntGalaxia(string directori)    									\n");
      n = cin.nextInt();
      while(n != 0) {
    	  switch(n) {
    	  	case 1: TestCrearControladorGalaxia(); break;
    	  	case 2: TestCrearGalaxia(); break;
    	  	case 3: TestCrearGalaxia2(); break;
    	  	case 4: TestCrearGalaxia2(); break;
    	  	case 5: TestConsultarNom(); break;
    	  	case 6: TestConsultarElementsGalaxia(); break;
    	  	case 7: TestLListaPlanetes(); break;
    	  	case 8: TestLListaRutes(); break;
    	  	case 9: TestLListaNaus(); break;
    	  	case 10: TestconsultarNumPlanetes(); break;
    	  	case 11: TestconsultarLimit(); break;
    	  	case 12: TestexisteixPlaneta(); break;
    	  	case 13: TestmodificarNom(); break;
    	  	case 14: TestmodificarLimit(); break;
    	  	case 15: TestafegirPlaneta(cp); break;
    	  	case 16: TestafegirPlanetaAutomatic(cp); break;
    	  	case 17: TesteliminarPlaneta(cp); break;
    	  	case 18: TestafegirRuta(); break;
    	  	case 19: TesteliminarRuta(); break;
    	  	case 20: TestafegirNau(); break;
    	  	case 21: TesteliminarNau(); break;
    	  	case 22: TesteliminarContingutGalaxia(); break;
    	  	case 23: TestcarregarConjuntGalaxia(); break;
    	  	case 24: TestguardarConjuntGalaxia(); break;
    	  	default: System.out.println("Opcion incorrecta");
    	  }
    	  n = cin.nextInt();
      }
	}
	
	public void TestCrearControladorGalaxia()
	{
		cGalaxia = new ControladorGalaxia();
	}
	
	public void TestCrearGalaxia()
	{
		try {
			String n = cin.next();
			int l = cin.nextInt();
			cGalaxia.creaGalaxia(n, l);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestCrearGalaxia2()
	{
		try {
			String n = cin.next();
			int l = cin.nextInt();
			List<Pair<Integer, Integer> > lm = new ArrayList<Pair<Integer, Integer> >();
			cGalaxia.creaGalaxia2(n, l,lm);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarNom()
	{
		try {
			System.out.println(cGalaxia.consultar_nom());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	// ESTA NO CREO QUE VALGA LA PENA
	public void TestConsultarElementsGalaxia()
	{
		try {
			String res = cGalaxia.consultarElementsGalaxia();
			Scanner scan = new Scanner(res);
			scan.useDelimiter(":");
			while(scan.hasNext()) {
				System.out.println(scan.next());
			}
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestLListaPlanetes()
	{
		try {
			String res = cGalaxia.llista_planetes();
			Scanner scan = new Scanner(res);
			scan.useDelimiter(":");
			while(scan.hasNext()) {
				System.out.println(scan.next());
			}
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestLListaRutes()
	{
		try {
			String res = cGalaxia.llista_rutes();
			Scanner scan = new Scanner(res);
			scan.useDelimiter(":");
			while(scan.hasNext()) {
				System.out.println(scan.next());
			}
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestLListaNaus()
	{
		try {
			String res = cGalaxia.llista_naus();
			Scanner scan = new Scanner(res);
			scan.useDelimiter(":");
			while(scan.hasNext()) {
				System.out.println(scan.next());
			}
		}
		catch(Exception e) {
            System.out.println(e);
        }	
	}
	
	public void TestconsultarNumPlanetes()
	{
		try {
			System.out.println(cGalaxia.consultarNumPlanetes());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestconsultarLimit()
	{
		try {
			System.out.println(cGalaxia.consultarLimit());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarLimitsGalaxia()
	{
		try {
			String res = cGalaxia.consultarLimitsGalaxia();
			System.out.println(res);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestexisteixPlaneta()
	{
		try {
			int idPlaneta = cin.nextInt();
			String res = cGalaxia.existeixPlaneta(idPlaneta) ? "Existeix el planeta amb id " + idPlaneta : "No existeix el planeta amb id " + idPlaneta;
			System.out.println(res);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarNom()
	{
		try {
			String n = cin.next();
			cGalaxia.modificarNom(n);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarLimit()
	{
		try {
			int l = cin.nextInt();
			cGalaxia.modificarLimit(l);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestafegirPlaneta(ControladorPlaneta cp)
	{
		try {
			int idPlaneta = cin.nextInt();
			int x = cin.nextInt();
			int y = cin.nextInt();
			cGalaxia.afegirPlaneta(cp, idPlaneta, x, y);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestafegirPlanetaAutomatic(ControladorPlaneta cp)
	{
		try {
			int idPlaneta = cin.nextInt();
			cGalaxia.afegirPlanetaAutomatic(cp, idPlaneta);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarPlaneta(ControladorPlaneta cp)
	{
		try {
			int idPlaneta = cin.nextInt();
			cGalaxia.eliminarPlaneta(idPlaneta, cp);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestafegirRuta()
	{
		try {
			int idRuta = cin.nextInt();
			cGalaxia.afegirRuta(idRuta);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarRuta()
	{
		try {
			int idRuta = cin.nextInt();
			cGalaxia.eliminarRuta(idRuta);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestafegirNau()
	{
		try {
			int idNau = cin.nextInt();
			cGalaxia.afegirNau(idNau);
			
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarNau()
	{
		try {
			int idNau = cin.nextInt();
			cGalaxia.eliminarNau(idNau);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarContingutGalaxia()
	{
		try {
			cGalaxia.eliminarContingutGalaxia();
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestcarregarConjuntGalaxia()
	{
		try {
			String directori = cin.next();
			cGalaxia.carregarConjuntGalaxia(directori);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestguardarConjuntGalaxia()
	{
		try {
			String directori = cin.next();
			cGalaxia.guardarConjuntGalaxia(directori);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
}

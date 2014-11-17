import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
	            + "- Opcion 6: consultarLimitsGalaxia()                                                     \n"
	            + "- Opcion 7: consultarLimit()                                                             \n"
	            + "- Opcion 8: ConsultarPresupost()                                                         \n"
	            + "- Opcion 9: dintreLimitUsuari(int x, int y)                                              \n"
	            
				+ "- Opcion 10: modificarNom(String nomNou)                                                 \n"
				+ "- Opcion 11: modificarLimit(int limitNou)                                                \n"
				+ "- Opcion 12: modificarPresupost(int p)                                                   \n"
				+ "- Opcion 13: modificarLimits(List<Pair<Integer, Integer> > lp)                           \n"
				
				+ "- Opcion 14: Consultar_Size()                                                    		\n"
				+ "- Opcion 15: consultarPlanetas()                                                         \n"
				+ "- Opcion 16: ConsultarPlaneta(int idPlaneta, ControladorPlaneta cp)            			\n"
				+ "- Opcion 17: existeixPlaneta(idPlaneta)                                                  \n"
				+ "- Opcion 18: existeixPlanetaCoordenades(int x, int y)                                    \n"
				+ "- Opcion 19: algunPlaneta()                                                              \n"
				+ "- Opcion 20: consultaIdplaneta(int x, int y)                                             \n"
				+ "- Opcion 21: modificarIDPlaneta(int x, int y, int idNueva)                               \n"
				+ "- Opcion 22: afegirPlaneta(int idPlaneta, int x, int y)                                  \n"
				+ "- Opcion 23: afegirPlanetaAutomatic(int idPlaneta)                                       \n"
				+ "- Opcion 24: afegirPlanetaIDAutomatic(int idP)                                           \n"
				+ "- Opcion 25: eliminarPlaneta(int idPlaneta)                                              \n"
				+ "- Opcion 26: eliminarPlanetes()                                                          \n"
				
				+ "- Opcion 27: Consultar_numero_rutes()                                                    \n"
				+ "- Opcion 28: Consultar_ids_rutas()                                                       \n"
				+ "- Opcion 29: ConsultarRuta(int idRuta, ControladorRuta cr)                               \n"
				+ "- Opcion 30: ExisteRuta(int idRuta)                                                      \n"
				+ "- Opcion 31: CrearRuta(int idRuta, int capacidad, int distancia, int planetaA, int planetaB, "
				+ "boolean bidireccional, ControladorPlaneta cp)                                            \n"
				+ "- Opcion 32: CrearRuta_automatica(ControladorPlaneta cp)                                 \n"
				+ "- Opcion 33: CrearRuta_automatica(ControladorPlaneta cp, int idRuta)                     \n"
				+ "- Opcion 34: Borrar_Ruta(int idRuta)                                                     \n"
				+ "- Opcion 35: BorrarRutas()                                                               \n"
				
				+ "- Opcion 36: cn.size()                                                                   \n"
				+ "- Opcion 37: ConsultarNaves()                                                            \n"
				+ "- Opcion 38: CrearTipoNave(int tipo, int consumo)                                        \n"
				+ "- Opcion 39: CrearTipoNaveAuto()                                                         \n"
				+ "- Opcion 40: ConsultarTipos()                                                            \n"
				+ "- Opcion 41: ConsultarConsumoTipo(int tipo)                                              \n"
				+ "- Opcion 42: CrearNave(int id, int t, int d, int o)                                      \n"
				+ "- Opcion 43: CrearNaveAuto(int num_naves, ArrayList<Integer> ai)                         \n"
				+ "- Opcion 44: EliminarNave(int idNave)                                                    \n"
				+ "- Opcion 45: EliminarNaves()                                                             \n"
				
				+ "- Opcion 46: eliminarContingutGalaxia()                                                  \n"
				
				+ "- Opcion 47: carregarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorNave cn,"
				+ " ControladorRuta cr)                                                                     \n"
				+ "- Opcion 48: guardarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorRuta cr,"
				+ " ControladorNave cn)                                                                     \n");
      n = cin.nextInt();
      while(n != 0) {
    	  switch(n) {
    	  	case 1: TestCrearControladorGalaxia(); break; // HECHA
    	  	
    	  	case 2: TestCrearGalaxia(); break; // HECHA
    	  	case 3: TestCrearGalaxia2(); break; // HECHA
    	  	
    	  	case 4: TestConsultarNom(); break; // HECHA
    	  	case 5: TestConsultarElementsGalaxia(); break; // HECHA
    	  	case 6: TestConsultarLimitsGalaxia(); break; // HECHA
    	  	case 7: TestConsultarLimit(); break; // HECHA
    	  	case 8: TestConsultarPresupost(); break; // HECHA
    	  	case 9: TestdintreLimitUsuari(cin); break;  // HECHA
    	  	
    	  	case 10: TestmodificarNom(cin); break; // HECHA
    	  	case 11: TestmodificarLimit(cin); break; // HECHA
    	  	case 12: TestmodificarPresupost(cin); break; // HECHA
    	  	case 13: TestmodificarLimits(cin); break;  // HECHA
    	  	
    	  	case 14: TestconsultarNumPlanetes(cp); break; // HECHA
    	  	case 15: TestLlistaPlanetes(cp); break; // HECHA
    	  	case 16: TestConsultarPlaneta(cin,cp); break; // HECHA
    	  	case 17: TestexisteixPlaneta(cin); break; // HECHA
    	  	case 18: TestexisteixPlanetaCoordenades(cin); break; // HECHA
    	  	case 19: TestAlgunPlaneta(); break; // HECHA
    	  	case 20: TestconsultaIDplaneta(cin); break; // HECHA
    	  	case 21: TestmodificarIDplaneta(cin,cp); break; // HECHA
    	  	case 22: TestafegirPlaneta(cp,cin); break; // HECHA
    	  	case 23: TestafegirPlanetaAutomatic(cp,cin); break; // HECHA
    	  	case 24: TestAfegirPlanetaNIDAuto(cp); break; // HECHA
    	  	case 25: TesteliminarPlaneta(cp,cr,cn); break; // HECHA
    	  	case 26: TesteliminarPlanetes(cp,cr,cn); break; // HECHA
    	  	
    	  	case 27: TestconsultarNumRutes(cr); break; // HECHA
    	  	case 28: TestLlistaRutes(cr); break; // HECHA
    	  	case 29: TestconsultarRuta(cr,cin); break; // HECHA
    	  	case 30: TestexisteixRuta(cr,cin); break; // HECHA
    	  	case 31: TestCrearRuta(cr,cp,cin); break; // HECHA
    	  	case 32: TestCrearRutaAuto(cr,cp); break; // HECHA
    	  	case 33: TestCrearRutaAutoID(cin,cr,cp); break; // HECHA
    	  	case 34: TestEliminarRuta(cr,cin); break; // HECHA
    	  	case 35: TestEliminarRutes(cr); break; // HECHA
    	  	
    	  	case 36: TestConsultaNumNau(cn); break; // HECHA
    	  	case 37: TestLListaNaus(cn); break; // HECHA
    	  	case 38: TestCrearTipoNave(cin,cn); break; // HECHA
    	  	case 39: TestCrearTipoNaveAuto(cin,cn); break; // HECHA
    	  	case 40: TestConsultarTiposNave(cn); break; // HECHA
    	  	case 41: TestConsultarConsumoTipoNave(cin,cn); break; // HECHA
    	  	case 42: TestcrearNau(cin,cn); break; // HECHA
    	  	case 43: TestCrearNaveAuto(cn,cin,cp); break; // HECHA
    	  	case 44: TesteliminarNau(cin,cn); break; // HECHA
    	  	case 45: TesteliminarTotesNaus(cn); break; // HECHA
    	  	
    	  	case 46: TesteliminarContingutGalaxia(cr,cp,cn); break; // HECHA
    	  	
    	  	case 47: TestcarregarConjuntGalaxia(cr,cp,cn); break;
    	  	case 48: TestguardarConjuntGalaxia(cr,cp,cn); break;
    	  	
    	  	default: System.out.println("Opcion incorrecta");
    	  }
    	  n = cin.nextInt();
      }
	}
	
	public void TestCrearControladorGalaxia()  // HECHA
	{
		cGalaxia = new ControladorGalaxia();
	}
	
	public void TestCrearGalaxia() // HECHA
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
	
	public void TestCrearGalaxia2() // HECHA
	{
		try {
			System.out.println("Introduce nombre");
            String n = cin.next();
            System.out.println("Introduce limite");
            int n1 = cin.nextInt();
            
            List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            int pa_f, pa_s;
            
            System.out.println("Introduce primera coordenada");
            pa_f = cin.nextInt();
            System.out.println("Introduce segunda coordenada");
            pa_s = cin.nextInt();
            
            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_f,pa_s);
            pa1.add(primero);
            
            System.out.println("Introduce primera coordenada");
            int l1 = cin.nextInt();
            System.out.println("Introduce segunda coordenada");
            int l2 = cin.nextInt();
            
            int limite1 = primero.consultarPrimero().intValue();
            int limite2 = primero.consultarSegundo().intValue();
            boolean trobat = false;
            while(!trobat) {
            	int size = pa1.size();
            	int prim = pa1.get(size-1).consultarPrimero();
            	int seg = pa1.get(size-1).consultarSegundo();
            	if((((l1+1) == prim) || ((l1-1) == prim) || (l1 == prim)) && (((l2+1) == seg) || ((l2-1) == seg) || (l2 == seg))){
	            	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(l1, l2);
	            	pa1.add(pa);
	            	
	            	System.out.println(pa1);
            	}
            	else throw new Exception("Las coordenadas no son secuenciales");
            	System.out.println("Introduce primera coordenada");
            	l1 = cin.nextInt();
            	System.out.println("Introduce segunda coordenada");
                l2 = cin.nextInt();
                if((l1 == limite1 && l2 == limite2)) trobat = true;
                System.out.println(trobat);
            }
            System.out.println("FUERA DEL WHILE");
			cGalaxia.creaGalaxia2(n,n1,pa1);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarNom() // HECHA
	{
		try {
			System.out.println(cGalaxia.consultar_nom());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarElementsGalaxia() // HECHA
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
	
	public void TestConsultarPresupost() // HECHA
	{
		try {
			System.out.println(cGalaxia.consultarPresupost());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestdintreLimitUsuari(Scanner cin) // HECHA
	{
		try {
			int x = cin.nextInt();
			int y = cin.nextInt();
			if(cGalaxia.dintreLimitUsuari(x, y)) System.out.println("Si que estan dintre del limit de l'usuari");
			else System.out.println("No estan dintre del limit de l'usuari");
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestLlistaPlanetes(ControladorPlaneta cp) // HECHA
	{
		try {
			ArrayList<Integer> ar = cp.consultarPlanetas();
            System.out.print("Planetas existentes: ");
            System.out.println(ar);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestLlistaRutes(ControladorRuta cr) // HECHA
	{
		try {
			 ArrayList<Integer> ar = cr.Consultar_ids_rutas();
	         System.out.print("Rutas existentes: ");
	         System.out.println(ar);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestLListaNaus(ControladorNave cn) // HECHA
	{
		try{
        	String res = "";
            int i=0;
            int n = cn.size();
            while(i < n) {
            	res += cn.ConsultarNaves(i);
            	++i;
            }
            System.out.println(res);
        }
        catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestconsultarNumPlanetes(ControladorPlaneta cp) // HECHA
	{
		try {
			int n = cp.Consultar_Size();
			System.out.println(n);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarLimit() // HECHA
	{
		try {
			System.out.println(cGalaxia.consultarLimit());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarLimitsGalaxia() // HECHA
	{
		try {
			String res = cGalaxia.consultarLimitsGalaxia();
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
	
	public void TestexisteixPlaneta(Scanner cin) // HECHA
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
	
	public void TestmodificarNom(Scanner cin) // HECHA
	{
		try {
			String n = cin.next();
			cGalaxia.modificarNom(n);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarLimit(Scanner cin) // HECHA
	{
		try {
			int l = cin.nextInt();
			cGalaxia.modificarLimit(l);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarPresupost(Scanner cin) // HECHA
	{
		try {
			int p = cin.nextInt();
			cGalaxia.modificarPresupost(p);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarLimits(Scanner cin)  // HECHA
	{
		try {
			List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            int pa_f, pa_s;
            
            System.out.println("Introduce primera coordenada");
            pa_f = cin.nextInt();
            System.out.println("Introduce segunda coordenada");
            pa_s = cin.nextInt();
            
            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_f,pa_s);
            pa1.add(primero);
            
            System.out.println("Introduce primera coordenada");
            int l1 = cin.nextInt();
            System.out.println("Introduce segunda coordenada");
            int l2 = cin.nextInt();
            
            int limite1 = primero.consultarPrimero().intValue();
            int limite2 = primero.consultarSegundo().intValue();
            boolean trobat = false;
            while(!trobat) {
            	int size = pa1.size();
            	int prim = pa1.get(size-1).consultarPrimero();
            	int seg = pa1.get(size-1).consultarSegundo();
            	if((((l1+1) == prim) || ((l1-1) == prim) || (l1 == prim)) && (((l2+1) == seg) || ((l2-1) == seg) || (l2 == seg))){
	            	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(l1, l2);
	            	pa1.add(pa);
	            	
	            	System.out.println(pa1);
            	}
            	else throw new Exception("Las coordenadas no son secuenciales");
            	System.out.println("Introduce primera coordenada");
            	l1 = cin.nextInt();
            	System.out.println("Introduce segunda coordenada");
                l2 = cin.nextInt();
                if((l1 == limite1 && l2 == limite2)) trobat = true;
                System.out.println(trobat);
            }
            System.out.println("FUERA DEL WHILE");
            cGalaxia.modificarLimits(pa1);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestafegirPlaneta(ControladorPlaneta cp, Scanner cin) // HECHA
	{
		try {
			int idPlaneta = cin.nextInt();
			int coste = cin.nextInt();
			int x = cin.nextInt();
			int y = cin.nextInt();
			Pair<Integer, Integer> co = new Pair<Integer, Integer>(x,y);
			Planeta a = new Planeta(idPlaneta,coste,co);
			cGalaxia.afegirPlaneta(idPlaneta, x, y);
			cp.anadirPlaneta(a);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestafegirPlanetaAutomatic(ControladorPlaneta cp, Scanner cin) // HECHA
	{
		try {
			int idPlaneta = cin.nextInt();
			Random rand = new Random();
	    	int coste = rand.nextInt((Integer.MAX_VALUE - 0) + 1); 
			Pair<Integer, Integer> pa = cGalaxia.afegirPlanetaAutomatic(idPlaneta);
			Planeta a = new Planeta(idPlaneta, coste, pa);
			cp.anadirPlaneta(a);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestAfegirPlanetaNIDAuto(ControladorPlaneta cp) // HECHA
	{
		try {
			Random rand = new Random();
	    	int capacidad = rand.nextInt(Integer.MAX_VALUE-1);
	        int idP = 1;
	        while(cp.ExistePlaneta(idP)) ++idP;
	        Pair<Integer, Integer> co_nuevas = cGalaxia.afegirPlanetaAutomatic(idP);
	        Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(co_nuevas.consultarPrimero(),co_nuevas.consultarSegundo());
	        Planeta p = new Planeta(idP, capacidad, Coo);
	        cp.anadirPlaneta(p);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarPlaneta(Scanner cin, ControladorPlaneta cp) // HECHA
	{
		try {
			int idPlaneta = cin.nextInt();
			if(!cGalaxia.existeixPlaneta(idPlaneta)) System.out.println("No existe ningun planeta con ese identificador");
	    	Planeta a = cp.BuscarPlaneta(idPlaneta);
	    	System.out.println("El planeta con id: " + idPlaneta + " tiene como atributos: \n"
	    						+ "- Capacidad: " + a.Consultar_Capacidad() + "\n"
	    						+ "- Coste: " + a.Consultar_Coste() + "\n"
	    						+ "- Coordenadas: (" + a.consultar_X() + ", " + a.consultar_Y() + ")\n");
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestexisteixPlanetaCoordenades(Scanner cin)  // HECHA
	{
		try {
			int x = cin.nextInt();
			int y = cin.nextInt();
			if(cGalaxia.existeixPlanetaCoordenades(x, y)) System.out.println("Existe un planeta en esas coordenadas");
			else System.out.println("No existe ningun planeta en esas coordenadas");
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestAlgunPlaneta() // HECHA
	{
		try {
			if(cGalaxia.algunPlaneta()) System.out.println("Si que hay algun planeta");
			else System.out.println("No hay ningun planeta");
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestconsultaIDplaneta(Scanner cin) // HECHA
	{
		try {
			int x = cin.nextInt();
			int y = cin.nextInt();
			int id = cGalaxia.consultaIdplaneta(x, y);
			System.out.println("El planeta con coordenadas (" + x + "," + y + ") tiene como id " +id);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarIDplaneta(Scanner cin, ControladorPlaneta cp) // HECHA
	{
		try {
			int x = cin.nextInt();
			int y = cin.nextInt();
			int idNueva = cin.nextInt();
			int id = cGalaxia.consultaIdplaneta(x, y);
    		cGalaxia.modificarIDPlaneta(x, y, idNueva);
    		Planeta a = cp.BuscarPlaneta(id);
    		cp.BorraPla(id);
    		a.Modificar_id(idNueva);
    		cp.anadirPlaneta(a);
    		// BORRAR O MODIFICAR RUTAS-NAVES
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarPlaneta(ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn) // HECHA
	{
		try {
			int idPlaneta = cin.nextInt();
			cGalaxia.eliminarPlaneta(idPlaneta);
			cp.BorraPla(idPlaneta);
			cr.BorrarRutaConexions(idPlaneta);
			cn.BorraNavesDestinoOrigen(idPlaneta);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarPlanetes(ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn) // HECHA
	{
		try{
	    	cGalaxia.eliminarPlanetes();
	    	cp.BorrarTodos();
	    	cr.BorrarRutas();
	    	cn.EliminarNaves();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestconsultarNumRutes(ControladorRuta cr) // HECHA
	{
		 int p = cr.Consultar_numero_rutes();
	     System.out.println("Numero de rutas en la galaxia es: " + p);
	}
	
	public void TestconsultarRuta(ControladorRuta cr, Scanner cin) // HECHA
	{
		try {
    		System.out.println("Introduce el identificador de la ruta");
	    	int idRuta = cin.nextInt();
	    	if(!cr.ExisteRuta(idRuta)) System.out.println("No existe ninguna ruta con ese identificador");
	    	Ruta r = cr.BuscarRuta(idRuta);
	    	Conexion c = cr.BuscarConexion(idRuta);
	    	System.out.println("La ruta con id: " + idRuta 
	    						+ "\n tiene como capacidad: " + r.consultar_capacidad()
	    						+ "\n tiene como distancia: " + r.consultar_distancia()
	    						+ "\n conecta los planetas: " + c.consultar_planetaA() + " y " + c.consultar_planetaB()
	    						+ "\n y bidireccional = " + c.consultar_bidireccional());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestexisteixRuta(ControladorRuta cr, Scanner cin) // HECHA
	{
		try{
    		System.out.println("Introduce el identificador de la ruta");
	    	int idRuta = cin.nextInt();
	    	boolean b = cr.ExisteRuta(idRuta);
	    	if(b) System.out.println("La ruta con id: " + idRuta + " existe en la galaxia");
	    	else System.out.println("La ruta con id: " + idRuta + " no existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestCrearRuta(ControladorRuta cr, ControladorPlaneta cp, Scanner cin) // HECHA
	{
		try {
			int idRuta = cin.nextInt();
			int capacidad = cin.nextInt();
			int distancia = cin.nextInt();
			int planetaA = cin.nextInt();
			int planetaB = cin.nextInt();
			boolean bidireccional = cin.nextBoolean();
			cr.CrearRuta(idRuta, capacidad, distancia, planetaA, planetaB, bidireccional, cp);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestCrearRutaAuto(ControladorRuta cr, ControladorPlaneta cp) // HECHA
	{
		try {
        	cr.CrearRuta_automatica(cp);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	public void TestCrearRutaAutoID(Scanner cin, ControladorRuta cr, ControladorPlaneta cp) // HECHA
	{
		try {
    		System.out.print("Introduce el identificador de la ruta");
    		int id = cin.nextInt();
    		cr.CrearRuta_automatica(cp, id);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestEliminarRuta(ControladorRuta cr, Scanner cin) // HECHA
	{
		try {
			int idRuta = cin.nextInt();
			cr.Borrar_Ruta(idRuta);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestEliminarRutes(ControladorRuta cr) // HECHA
	{
		try{
    		cr.BorrarRutas();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultaNumNau(ControladorNave cn) // HECHA
	{
		int p = cn.size();
        System.out.println("Numero de naves en la galaxia: " + p);
	}
	
	public void TestafegirNau(ControladorNave cn) // HECHA
	{
		try {
			int idNau = cin.nextInt();
			int t = cin.nextInt();
			int d = cin.nextInt();
			int o = cin.nextInt();
			cn.CrearNave(idNau, t, d, o);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestCrearTipoNave(Scanner cin, ControladorNave cn) // HECHA
    {
    	try {
    		System.out.println("Introduce tipo");
    		int tipo = cin.nextInt();
    		System.out.println("Introduce consumo");
    		int consumo = cin.nextInt();
    		cn.CrearTipoNave(tipo, consumo);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
	
	public void TestCrearTipoNaveAuto(Scanner cin, ControladorNave cn) // HECHA
    {
    	try {
    		cn.CrearTipoNaveAuto();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
	
	public void TestConsultarTiposNave(ControladorNave cn) // HECHA
    {
    	try {
    		System.out.println(cn.ConsultarTipos());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
	
	 public void TestConsultarConsumoTipoNave(Scanner cin, ControladorNave cn) // HECHA
	 {
    	try {
    		System.out.println("Introduce tipo");
    		int tipo = cin.nextInt();
    		System.out.println(cn.ConsultarConsumoTipo(tipo));
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	 }
	 
	public void TestcrearNau(Scanner cin, ControladorNave cn)
	{
    	try{
    		System.out.println("Introduce id");
    		int id = cin.nextInt();
    		System.out.println("Introduce tipo");
    		int t = cin.nextInt();
    		System.out.println("Introduce destino");
    		int d = cin.nextInt();
    		System.out.println("Introduce origen");
    		int o = cin.nextInt();
    		cn.CrearNave(id, t, d, o);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	    
	public void TestCrearNaveAuto(ControladorNave cn, Scanner cin, ControladorPlaneta cp)
	{
    	try {
    		System.out.println("Introduce numero naves");
    		int num_naves = cin.nextInt();
    		ArrayList<Integer> ai = cp.consultarPlanetas();
    		cn.CrearNaveAuto(num_naves, ai);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
    public void TesteliminarNau(Scanner cin, ControladorNave cn)
    {
    	try{
    		System.out.print("Introduce el identificador de la nave a borrar");
	    	int idNave = cin.nextInt();
	    	cn.EliminarNave(idNave);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void TesteliminarTotesNaus(ControladorNave cn)
    {
    	try{
    		cn.EliminarNaves();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
	
	public void TesteliminarContingutGalaxia(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) // HECHA
	{
		try {
			cGalaxia.eliminarContingutGalaxia();
			cp.BorrarTodos();
			cr.BorrarRutas();
			cn.EliminarNaves();
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestcarregarConjuntGalaxia(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn)
	{
		try {
			String directori = cin.next();
			cGalaxia.carregarConjuntGalaxia(directori, cp, cn, cr);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestguardarConjuntGalaxia(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn)
	{
		try {
			String directori = cin.next();
			cGalaxia.guardarConjuntGalaxia(directori,cp,cr,cn);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
}

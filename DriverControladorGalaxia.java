import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class DriverControladorGalaxia {
	
	public void Executa(Scanner cin, ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn, ControladorGalaxia cGalaxia)
	{
        int n;
        System.out.print(
	              "---------------------------------------------------------------------------------------- \n"
	            + "                               DRIVER CONTROLADOR GALAXIA                                \n"
	            + "---------------------------------------------------------------------------------------- \n"
	            + "- Opcion 0: Salir de la gestion del driver                                        	    \n"
	            
	            + "- Opcion 1: creaGalaxia(String nom,int n)   												\n"      
	            + "- Opcion 2: creaGalaxia2(String nom, int n, List<Pair<Integer, Integer> > l) 			\n"
	            
	            + "- Opcion 3: consultar_nom()										   						\n"     
	            + "- Opcion 4: consultarElementsGalaxia() 							   						\n"
	            + "- Opcion 5: consultarLimitsGalaxia()                                                     \n"
	            + "- Opcion 6: consultarLimit()                                                             \n"
	            + "- Opcion 7: dintreLimitUsuari(int x, int y)                                              \n"
	            
				+ "- Opcion 8: modificarNom(String nomNou)                                                 \n"
				+ "- Opcion 9: modificarLimit(int limitNou)                                                \n"
				+ "- Opcion 10: modificarLimits(List<Pair<Integer, Integer> > lp)                           \n"
				
				+ "- Opcion 11: Consultar_Size()                                                    		\n"
				+ "- Opcion 12: consultarPlanetas()                                                         \n"
				+ "- Opcion 13: ConsultarPlaneta(int idPlaneta, ControladorPlaneta cp)            			\n"
				+ "- Opcion 14: existeixPlaneta(idPlaneta)                                                  \n"
				+ "- Opcion 15: existeixPlanetaCoordenades(int x, int y)                                    \n"
				+ "- Opcion 16: algunPlaneta()                                                              \n"
				+ "- Opcion 17: consultaIdplaneta(int x, int y)                                             \n"
				+ "- Opcion 18: afegirPlaneta(int idPlaneta, int x, int y)                                  \n"
				+ "- Opcion 19: afegirPlanetaAutomatic(int idPlaneta)                                       \n"
				+ "- Opcion 20: afegirPlanetaIDAutomatic(int idP)                                           \n"
				+ "- Opcion 21: eliminarPlaneta(int idPlaneta)                                              \n"
				+ "- Opcion 22: eliminarPlanetes()                                                          \n"
				
				+ "- Opcion 23: Consultar_numero_rutes()                                                    \n"
				+ "- Opcion 24: Consultar_ids_rutas()                                                       \n"
				+ "- Opcion 25: ConsultarRuta(int idRuta, ControladorRuta cr)                               \n"
				+ "- Opcion 26: ExisteRuta(int idRuta)                                                      \n"
				+ "- Opcion 27: CrearRuta(int idRuta, int capacidad, int distancia, int planetaA, int planetaB, "
				+ "boolean bidireccional, ControladorPlaneta cp)                                            \n"
				+ "- Opcion 28: CrearRuta_automatica(ControladorPlaneta cp)                                 \n"
				+ "- Opcion 29: CrearRuta_automatica(ControladorPlaneta cp, int idRuta)                     \n"
				+ "- Opcion 30: Borrar_Ruta(int idRuta)                                                     \n"
				+ "- Opcion 31: BorrarRutas()                                                               \n"
				
				+ "- Opcion 32: cn.size()                                                                   \n"
				+ "- Opcion 33: ConsultarNaves()                                                            \n"
				+ "- Opcion 34: CrearTipoNave(int tipo, int consumo)                                        \n"
				+ "- Opcion 35: CrearTipoNaveAuto()                                                         \n"
				+ "- Opcion 36: ConsultarTipos()                                                            \n"
				+ "- Opcion 37: ConsultarConsumoTipo(int tipo)                                              \n"
				+ "- Opcion 38: CrearNave(int id, int t, int d, int o)                                      \n"
				+ "- Opcion 39: CrearNaveAuto(int num_naves, ArrayList<Integer> ai)                         \n"
				+ "- Opcion 40: EliminarNave(int idNave)                                                    \n"
				+ "- Opcion 41: EliminarNaves()                                                             \n"
				
				+ "- Opcion 42: eliminarContingutGalaxia()                                                  \n"
				
				+ "/*- Opcion 43: carregarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorNave cn,"
				+ " ControladorRuta cr)*/                                                                     \n"
				+ "- Opcion 44: guardarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorRuta cr,"
				+ " ControladorNave cn)                                                                     \n");
      n = cin.nextInt();
      while(n != 0) {
    	  switch(n) {
    	  	
    	  	case 1: TestCrearGalaxia(cin,cGalaxia); break; 
    	  	case 2: TestCrearGalaxia2(cin,cGalaxia); break; 
    	  	
    	  	case 3: TestConsultarNom(cGalaxia); break; 
    	  	case 4: TestConsultarElementsGalaxia(cGalaxia); break; 
    	  	case 5: TestConsultarLimitsGalaxia(cGalaxia); break; 
    	  	case 6: TestConsultarLimit(cGalaxia); break; 
    	  	case 7: TestdintreLimitUsuari(cin,cGalaxia); break;  
    	  	
    	  	case 8: TestmodificarNom(cin,cGalaxia); break; 
    	  	case 9: TestmodificarLimit(cin,cGalaxia); break; 
    	  	case 10: TestmodificarLimits(cin,cGalaxia); break;  
    	  	
    	  	case 11: TestconsultarNumPlanetes(cp); break; 
    	  	case 12: TestLlistaPlanetes(cp); break; 
    	  	case 13: TestConsultarPlaneta(cin,cp,cGalaxia); break; 
    	  	case 14: TestexisteixPlaneta(cin,cGalaxia); break; 
    	  	case 15: TestexisteixPlanetaCoordenades(cin,cGalaxia); break; 
    	  	case 16: TestAlgunPlaneta(cGalaxia); break; 
    	  	case 17: TestconsultaIDplaneta(cin,cGalaxia); break; 
    	  	case 18: TestafegirPlaneta(cp,cin,cGalaxia); break; 
    	  	case 19: TestafegirPlanetaAutomatic(cp,cin,cGalaxia); break; 
    	  	case 20: TestAfegirPlanetaNIDAuto(cp,cGalaxia); break; 
    	  	case 21: TesteliminarPlaneta(cp,cr,cn,cGalaxia,cin); break; 
    	  	case 22: TesteliminarPlanetes(cp,cr,cn,cGalaxia); break; 
    	  	
    	  	case 23: TestconsultarNumRutes(cr); break; 
    	  	case 24: TestLlistaRutes(cr); break; 
    	  	case 25: TestconsultarRuta(cr,cin); break; 
    	  	case 26: TestexisteixRuta(cr,cin); break; 
    	  	case 27: TestCrearRuta(cr,cp,cin); break; 
    	  	case 28: TestCrearRutaAuto(cr,cp); break; 
    	  	case 29: TestCrearRutaAutoID(cin,cr,cp); break; 
    	  	case 30: TestEliminarRuta(cr,cin); break; 
    	  	case 31: TestEliminarRutes(cr); break; 
    	  	
    	  	case 32: TestConsultaNumNau(cn); break; 
    	  	case 33: TestLListaNaus(cn); break; 
    	  	case 34: TestCrearTipoNave(cin,cn); break; 
    	  	case 35: TestCrearTipoNaveAuto(cin,cn); break; 
    	  	case 36: TestConsultarTiposNave(cn); break; 
    	  	case 37: TestConsultarConsumoTipoNave(cin,cn); break; 
    	  	case 38: TestcrearNau(cin,cn); break; 
    	  	case 39: TestCrearNaveAuto(cn,cin,cp); break; 
    	  	case 40: TesteliminarNau(cin,cn); break; 
    	  	case 41: TesteliminarTotesNaus(cn); break; 
    	  	
    	  	case 42: TesteliminarContingutGalaxia(cr,cp,cn,cGalaxia); break; 
    	  	
    	  	/*case 43: TestcarregarConjuntGalaxia(cr,cp,cn,cGalaxia,cin); break;*/
    	  	case 44: TestguardarConjuntGalaxia(cr,cp,cn,cGalaxia,cin); break;
    	  	
    	  	default: System.out.println("Opcion incorrecta");
    	  }
    	  n = cin.nextInt();
      }
	}
	
	
	public void TestCrearGalaxia(Scanner cin, ControladorGalaxia cGalaxia) 
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
	
	public void TestCrearGalaxia2(Scanner cin, ControladorGalaxia cGalaxia) 
	{
		try {
            String n = cin.next();
            int n1 = cin.nextInt();
            
            List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            int pa_f, pa_s;
            
            pa_f = cin.nextInt();
            pa_s = cin.nextInt();
            
            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_f,pa_s);
            pa1.add(primero);
            
            int l1 = cin.nextInt();
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
            	l1 = cin.nextInt();
                l2 = cin.nextInt();
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
			cGalaxia.creaGalaxia2(n,n1,pa1);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarNom(ControladorGalaxia cGalaxia) 
	{
		try {
			System.out.println(cGalaxia.consultar_nom());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarElementsGalaxia(ControladorGalaxia cGalaxia)
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
	
	public void TestdintreLimitUsuari(Scanner cin, ControladorGalaxia cGalaxia) 
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
	
	public void TestLlistaPlanetes(ControladorPlaneta cp) 
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
	
	public void TestLlistaRutes(ControladorRuta cr) 
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
	
	public void TestLListaNaus(ControladorNave cn) 
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
	
	public void TestconsultarNumPlanetes(ControladorPlaneta cp) 
	{
		try {
			int n = cp.Consultar_Size();
			System.out.println(n);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarLimit(ControladorGalaxia cGalaxia) 
	{
		try {
			System.out.println(cGalaxia.consultarLimit());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarLimitsGalaxia(ControladorGalaxia cGalaxia) 
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
	
	public void TestexisteixPlaneta(Scanner cin, ControladorGalaxia cGalaxia)
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
	
	public void TestmodificarNom(Scanner cin, ControladorGalaxia cGalaxia)
	{
		try {
			String n = cin.next();
			cGalaxia.modificarNom(n);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarLimit(Scanner cin, ControladorGalaxia cGalaxia) 
	{
		try {
			int l = cin.nextInt();
			cGalaxia.modificarLimit(l);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarLimits(Scanner cin, ControladorGalaxia cGalaxia)  
	{
		try {
			List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            int pa_f, pa_s;
            
            pa_f = cin.nextInt();
            pa_s = cin.nextInt();
            
            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_f,pa_s);
            pa1.add(primero);
            
            int l1 = cin.nextInt();
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
            	l1 = cin.nextInt();
                l2 = cin.nextInt();
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
            cGalaxia.modificarLimits(pa1);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestafegirPlaneta(ControladorPlaneta cp, Scanner cin, ControladorGalaxia cGalaxia) 
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
	
	public void TestafegirPlanetaAutomatic(ControladorPlaneta cp, Scanner cin, ControladorGalaxia cGalaxia) 
	{
		try {
			int idPlaneta = cin.nextInt();
			Random rand = new Random();
	    	int coste = rand.nextInt((Integer.MAX_VALUE - 0) + 1); 
			String a11 = cGalaxia.afegirPlanetaAutomatic(idPlaneta);
			Scanner sc = new Scanner(a11);
			sc.useDelimiter(",");
			Integer a1 = sc.nextInt();
			Integer a2 = sc.nextInt();
			Pair<Integer, Integer> pa = new Pair<Integer, Integer>(a1,a2);
			Planeta a = new Planeta(idPlaneta, coste, pa);
			cp.anadirPlaneta(a);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestAfegirPlanetaNIDAuto(ControladorPlaneta cp, ControladorGalaxia cGalaxia) 
	{
		try {
			Random rand = new Random();
	    	int capacidad = rand.nextInt(Integer.MAX_VALUE-1);
	        int idP = 1;
	        while(cp.ExistePlaneta(idP)) ++idP;
	        String a11 = cGalaxia.afegirPlanetaAutomatic(idP);
	        Scanner sc = new Scanner(a11);
			sc.useDelimiter(",");
			Integer a1 = sc.nextInt();
			Integer a2 = sc.nextInt();
			Pair<Integer, Integer> pa = new Pair<Integer, Integer>(a1,a2);
	        Planeta p = new Planeta(idP, capacidad, pa);
	        cp.anadirPlaneta(p);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarPlaneta(Scanner cin, ControladorPlaneta cp, ControladorGalaxia cGalaxia) 
	{
		try {
			int idPlaneta = cin.nextInt();
			if(!cGalaxia.existeixPlaneta(idPlaneta)) System.out.println("No existe ningun planeta con ese identificador");
	    	Planeta a = cp.BuscarPlaneta(idPlaneta);
	    	System.out.println(idPlaneta + " " + a.Consultar_Coste() + " (" + a.consultar_X() + ", " + a.consultar_Y() + ")");
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestexisteixPlanetaCoordenades(Scanner cin, ControladorGalaxia cGalaxia)  
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
	
	public void TestAlgunPlaneta(ControladorGalaxia cGalaxia) 
	{
		try {
			if(cGalaxia.algunPlaneta()) System.out.println("Si que hay algun planeta");
			else System.out.println("No hay ningun planeta");
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestconsultaIDplaneta(Scanner cin, ControladorGalaxia cGalaxia) 
	{
		try {
			int x = cin.nextInt();
			int y = cin.nextInt();
			int id = cGalaxia.consultaIdplaneta(x, y);
			System.out.println(id);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarPlaneta(ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn, ControladorGalaxia cGalaxia, Scanner cin) 
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
	
	public void TesteliminarPlanetes(ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn, ControladorGalaxia cGalaxia) 
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
	
	public void TestconsultarNumRutes(ControladorRuta cr) 
	{
		 int p = cr.Consultar_numero_rutes();
	     System.out.println(p);
	}
	
	public void TestconsultarRuta(ControladorRuta cr, Scanner cin) 
	{
		try {
	    	int idRuta = cin.nextInt();
	    	if(!cr.ExisteRuta(idRuta)) System.out.println("No existe ninguna ruta con ese identificador");
	    	Ruta r = cr.BuscarRuta(idRuta);
	    	Conexion c = cr.BuscarConexion(idRuta);
	    	System.out.println(idRuta + " " + r.consultar_capacidad() + " " + r.consultar_distancia()
	    						+ " " + c.consultar_planetaA() + " " + c.consultar_planetaB()
	    						+ " " + c.consultar_bidireccional());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestexisteixRuta(ControladorRuta cr, Scanner cin) 
	{
		try{
	    	int idRuta = cin.nextInt();
	    	boolean b = cr.ExisteRuta(idRuta);
	    	if(b) System.out.println("La ruta con id: " + idRuta + " existe en la galaxia");
	    	else System.out.println("La ruta con id: " + idRuta + " no existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestCrearRuta(ControladorRuta cr, ControladorPlaneta cp, Scanner cin) 
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
	
	public void TestCrearRutaAuto(ControladorRuta cr, ControladorPlaneta cp) 
	{
		try {
        	cr.CrearRuta_automatica(cp);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	public void TestCrearRutaAutoID(Scanner cin, ControladorRuta cr, ControladorPlaneta cp) 
	{
		try {
    		int id = cin.nextInt();
    		cr.CrearRuta_automatica(cp, id);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestEliminarRuta(ControladorRuta cr, Scanner cin) 
	{
		try {
			int idRuta = cin.nextInt();
			cr.Borrar_Ruta(idRuta);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestEliminarRutes(ControladorRuta cr) 
	{
		try{
    		cr.BorrarRutas();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultaNumNau(ControladorNave cn) 
	{
		int p = cn.size();
        System.out.println(p);
	}
	
	public void TestafegirNau(ControladorNave cn, Scanner cin) 
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
	
	public void TestCrearTipoNave(Scanner cin, ControladorNave cn) 
    {
    	try {
    		int tipo = cin.nextInt();
    		int consumo = cin.nextInt();
    		cn.CrearTipoNave(tipo, consumo);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
	
	public void TestCrearTipoNaveAuto(Scanner cin, ControladorNave cn) 
    {
    	try {
    		cn.CrearTipoNaveAuto();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
	
	public void TestConsultarTiposNave(ControladorNave cn) 
    {
    	try {
    		System.out.println(cn.ConsultarTipos());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
	
	 public void TestConsultarConsumoTipoNave(Scanner cin, ControladorNave cn) 
	 {
    	try {
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
    		int id = cin.nextInt();
    		int t = cin.nextInt();
    		int d = cin.nextInt();
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
	
	public void TesteliminarContingutGalaxia(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn, ControladorGalaxia cGalaxia) 
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
	
	/*public void TestcarregarConjuntGalaxia(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn, ControladorGalaxia cGalaxia, Scanner cin)
	{
		try {
			System.out.println("Introduce directorio");
			String directori = cin.next();
			//cGalaxia.carregarConjuntGalaxia(directori, cp, cn, cr);
			// FALTA TEMPS
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}*/
	
	public void TestguardarConjuntGalaxia(ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn, ControladorGalaxia cGalaxia, Scanner cin)
	{
		try {
			System.out.println("Introduce directorio");
			String directori = cin.next();
			cGalaxia.guardarConjuntGalaxia(directori,cp,cr,cn);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
}

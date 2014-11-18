import java.util.*;

public class DriverGalaxia {
    
	public DriverGalaxia() {};
	
    public static void main(String args[])
    {
    	 opcions();
    	 Scanner cin = new Scanner(System.in);
    	 Galaxia g = new Galaxia();
    	 ControladorPlaneta cp = new ControladorPlaneta();
    	 ControladorRuta cr = new ControladorRuta();
    	 ControladorNave cn = new ControladorNave();
    	 
    	 int opcion = cin.nextInt();
    	 while(opcion != 0) {
             switch(opcion) {
             	case 1: g = TestCrearGalaxia0(); break;
 	            case 2: g = TestCrearGalaxia(cin); break;
 	            case 3: g = TestCrearGalaxia1(cin); break;
 	            
 	            case 4: TestConsultarNomGalaxia(g); break;
 	            case 5: Testconsulta_nombreLimits(g); break;
 	            case 6: TestconsultaLimitsUsuari(g); break; 
 	            case 7: TestconsultarLimitGalaxia(g); break;
 	            case 8: TestdintreLimitUsuari(g,cin); break;
 	            
 	            case 9: Testmodificar_nomGalaxia(g, cin); break;
 	            case 10: TestmodificarN(g, cin); break;
 	            case 11: TestmodificarLimits(g,cin); break;
 	            
 	            case 12: TestexisteixPlanetaCoordenades(g,cin); break;
 	            case 13: TestconsultarPlaneta(g,cin,cp); break;
 	            case 14: TestexisteixPlaneta(g, cin); break;
 	          
 	            case 15: TestLlistarPlanetes(cp); break;
 	            case 16: Testconsulta_nombrePlanetes(cp);break;
 	            case 17: TestconsultarIDplaneta(g,cin); break;
 	            case 18: TestalgunPlaneta(g); break;
 	            
 	            case 19: TestCrearafegirPlaneta(g,cin,cp);break;
 	            case 20: TestCrearPlanetaAutomaticID(g,cin,cp);break;
 	            case 21: TestPlanetaAuto(g,cp); break;
 	            
 	            case 22: TesteliminarPLaneta(g,cin,cp,cr,cn); break;
 	            case 23: TesteliminarTotsPlanetes(g,cp,cr,cn); break;
 	            
 	            case 24: TestLlistarNaus(cn); break;
	            case 25: Testconsulta_nombreNaus(cn); break;
	            case 26: TestexisteixNau(cin, cn);
	            case 27: TestconsultarNau(cin, cn);
	            
 	            case 28: TestcrearNau(cin,cn); break;
 	            case 29: TestCrearNaveAuto(cn,cin,cp); break;
 	            
 	            case 30: TesteliminarNau(cin,cn); break;
 	            case 31: TesteliminarTotesNaus(cn); break;
 	            
 	            case 32: TestLlistarRutes(cr); break;
 	            case 33: Testconsulta_nombreRutes(cr); break;
 	            case 34: TestexisteixRuta(cin, cr);
 	            case 35: TestconsultarRuta(cin,cr); break;
 	           
 	            case 36: TestcrearRuta(cin,cr,cp); break;
 	            case 37: TestCrearRutaAutoID(cin,cr,cp); break;
 	            case 38: TestcrearRutaAuto(cp,cr); break;
 	            
 	            case 39: TesteliminarRuta(cin,cr); break;
 	            case 40: TesteliminarTotesRutes(cr); break;
 	           
 	            case 41: TestCrearTipoNave(cin,cn); break;
 	            case 42: TestCrearTipoNaveAuto(cin,cn); break;
 	            case 43: TestConsultarTiposNave(cn); break;
 	            case 44: TestConsultarConsumoTipoNave(cin,cn); break;
 	            
 	            default: System.out.println("Opcion incorrecta");
             }
             opcion = cin.nextInt();
         }
     }
    
	private static void opcions()
    {
    	 System.out.print(
	              "---------------------------------------------------------------------------------------- \n"
	            + "                               DRIVER GALAXIA                                    	    \n"
	            + "---------------------------------------------------------------------------------------- \n"
	            
	            + "- Opcion 0: Salir de la gestion del driver                                        	    \n"
	            
	            + "- Opcion 1: Galaxia()																	\n"
	            + "- Opcion 2: Galaxia(String nom, int n)                                           		\n"       
	            + "- Opcion 3: Galaxia(String nom, int n, List<Pair<Integer, Integer> > l)   				\n"
	            
	            + "- Opcion 4: consultarNomGalaxia() 									    				\n"       
	            + "- Opcion 5: consulta_nombreLimits() 										    			\n"
	            + "- Opcion 6: consultarValorLimits() 					    								\n"
	            + "- Opcion 7: consultarLimitGalaxia() 										    			\n"
	            + "- Opcion 8: dintreLimitUsuari(int x, int y) 												\n"
				
 				+ "- Opcion 9: modificar_nomGalaxia(String nom) 							    			\n"
 				+ "- Opcion 10: modificarN(int n) 											    			\n"
 				+ "- Opcion 11: modificarLimitsUsuari(List<Pair<Integer, Integer> > p) 						\n"
 				
				+ "- Opcion 12: existeixPlanetaCoordenades(int x, int y) 				    				\n"
				+ "- Opcion 13: consultarPlaneta(int idPlaneta)                    							\n"
				+ "- Opcion 14: existeixPlaneta(int idPlaneta) 						        				\n"
				
				+ "- Opcion 15: consultarPlanetas() 							 							\n" 
				+ "- Opcion 16: Consultar_Size()_Planetas 													\n"
				+ "- Opcion 17: consultarIDplaneta(int x, int y) 											\n"
	            + "- Opcion 18: algunPlaneta()																\n"
				
				+ "- Opcion 19: CrearPlaneta(idPlaneta, x, y)  												\n"
				+ "- Opcion 20: CrearPlanetaAutomatic(int idPlaneta) 							    		\n"
				+ "- Opcion 21: PlanetaAuto()  																\n"
				
            	+ "- Opcion 22: eliminarPLaneta(int idPlaneta)  						    				\n"
            	+ "- Opcion 23: eliminarTotsPlanetes() 										    			\n"
            	
 				+ "- Opcion 24: ConsultarNaves() 													    	\n"
	            + "- Opcion 25: Naves.size() 																\n"
	            + "- Opcion 26: existeixNau(int idNave)  								    				\n" 				
				+ "- Opcion 27: consultarNau(int idNau)														\n"
	            
	            + "- Opcion 28: CrearNave(int id, int t, int d, int o)  									\n"
	            + "- Opcion 29: CrearNaveAuto(int num_naves, ArrayList<Integer> ai)   						\n"
	            
	            + "- Opcion 30: EliminarNave(int idNave) 													\n"
	            + "- Opcion 31: EliminarNaves() 					    									\n"
	            
	            + "- Opcion 32: Consultar_ids_rutas() 								    					\n"
	            + "- Opcion 33: Consultar_numero_rutes()													\n"
	            + "- Opcion 34: existeixRuta(int idRuta) 							        				\n"
	            + "- Opcion 35: consultarRuta(int idRuta)													\n"

	            + "- Opcion 36: CrearRuta(id, capacidad, distancia, planetaA, planetaB, bidireccional, cp) 	\n"
	            + "- Opcion 37: CrearRuta_automatica(ControladorPlaneta cp, int id) 						\n"
	            + "- Opcion 38: CrearRuta_automatica(ContrladorPlaneta cp)     								\n"
	            
	            + "- Opcion 39: Borrar_Ruta(int idRuta)		    											\n"
	            + "- Opcion 40: BorrarRutas() 					    										\n"
	           
	            + "- Opcion 41: CrearTipoNave(int tipo, int consumo) 										\n"
	            + "- Opcion 42: CrearTipoNaveAuto()  														\n"
	            + "- Opcion 43: ConsultarTipos()  															\n"
	            + "- Opcion 44: ConsultarConsumoTipo(int tipo) 												\n"
	            );
    }
    
    private static Galaxia TestCrearGalaxia0()
    {
    	return new Galaxia();
    }
    
    private static Galaxia TestCrearGalaxia(Scanner cin)
    {
        try{
            String n = cin.next();
            int n1 = cin.nextInt();
            return new Galaxia(n,n1);
        }
        catch(Exception e) {
            System.out.println(e);
        }
		return null;
    }
     
    private static Galaxia TestCrearGalaxia1(Scanner cin)
    {
        try{
            String n = cin.next();
            int n1 = cin.nextInt();
            
            List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            int pa_f, pa_s;
            
            pa_f = cin.nextInt();
            if(pa_f > n1 || pa_f < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            pa_s = cin.nextInt();
            if(pa_s > n1 || pa_s < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            
            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_f,pa_s);
            pa1.add(primero);
            
            int l1 = cin.nextInt();
            if(l1 > n1 || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            int l2 = cin.nextInt();
            if(l2 > n1 || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            
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
            	if(l1 > n1 || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                l2 = cin.nextInt();
                if(l2 > n1 || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
            return new Galaxia(n,n1,pa1);
        }
        catch(Exception e) {
            System.out.println(e);
        }
		return null;
    }
     
    private static void TestConsultarNomGalaxia(Galaxia g) 
    {
            String s = g.consultarNomGalaxia();
            System.out.println(s);
    }
     
     
    private static void TestLlistarPlanetes(ControladorPlaneta cp)
    {
        try{
            ArrayList<Integer> ar = cp.consultarPlanetas();
            System.out.print("Planetas existentes: ");
            System.out.println(ar);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestalgunPlaneta(Galaxia g)
    {
    	boolean b = g.algunPlaneta();
    	if(b) System.out.println("Hay algun planeta en la galaxia");
    	else System.out.println("No hay ningun planeta en la galaxia");
    }
     
    private static void Testconsulta_nombrePlanetes(ControladorPlaneta cp)
    {
        int p = cp.Consultar_Size();
        System.out.println(p);
    }
     
    private static void Testconsulta_nombreLimits(Galaxia g)
    {
        int p = g.consulta_nombreLimits();
        System.out.println(p);
    }
     
    private static void TestLlistarRutes(ControladorRuta cr)
    {
        try{
            ArrayList<Integer> ar = cr.Consultar_ids_rutas();
            System.out.print("Rutas existentes: ");
            System.out.println(ar);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void Testconsulta_nombreRutes(ControladorRuta cr)
    {
        int p = cr.Consultar_numero_rutes();
        System.out.println(p);
    }
     
    private static void TestLlistarNaus(ControladorNave cn)
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
     
    private static void Testconsulta_nombreNaus(ControladorNave cn)
    {
        int p = cn.size();
        System.out.println(p);
    }
     
    private static void TestconsultarLimitGalaxia(Galaxia g)
    {
        int p = g.consultarLimitGalaxia().intValue();
        System.out.println(p);
    }
    
    private static void TestdintreLimitUsuari(Galaxia g, Scanner cin)
    {
    	boolean b;
		try {
			int x = cin.nextInt();
			int y = cin.nextInt();
			if(g.consulta_nombreLimits() > 0) {
				b = g.dintreLimitUsuari(x, y);
				if(b) System.out.println("Si que esta dins el limit");
				else System.out.println("No esta dins el limit");
			}
			else {
				if(g.consultarLimitGalaxia() > x && g.consultarLimitGalaxia() > y) System.out.println("Si que esta dins el limit");
				else System.out.println("No esta dins el limit");
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
    }
     
    private static void TestexisteixPlanetaCoordenades(Galaxia g, Scanner cin)
    {  
    	try{
	    	int cX = cin.nextInt();
	    	int cY = cin.nextInt();
	    	boolean exist = g.existeixPlanetaCoordenades(cX, cY);
	    	if(exist) System.out.println("Existe un planeta en la galaxia con esas coordenadas");
	    	else System.out.println("No existe ningun planeta en la galaxia con esas coordenadas");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
   
    private static void TestconsultarPlaneta(Galaxia g, Scanner cin, ControladorPlaneta cp)
    {
    	try{
	    	int idPlaneta = cin.nextInt();
	    	if(!g.existeixPlaneta(idPlaneta)) System.out.println("No existe ningun planeta con ese identificador");
	    	Planeta a = cp.BuscarPlaneta(idPlaneta);
	    	System.out.println(idPlaneta + " " + a.Consultar_Coste() + " (" + a.consultar_X() + ", " + a.consultar_Y() + ")");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TestexisteixPlaneta(Galaxia g, Scanner cin)
    {
    	try{
	    	int idPlaneta = cin.nextInt();
	    	boolean b = g.existeixPlaneta(idPlaneta);
	    	if(b) System.out.println("El planeta con id: " + idPlaneta + " existe en la galaxia");
	    	else System.out.println("El planeta con id: " + idPlaneta + " no existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestconsultarRuta(Scanner cin, ControladorRuta cr)
    {
    	try {
    		System.out.println("Introduce el identificador de la ruta");
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
     
    private static void TestexisteixRuta(Scanner cin, ControladorRuta cr)
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
   
    private static void TestconsultarNau(Scanner cin, ControladorNave cn)
    {
	    try{
    		int idNave = cin.nextInt();
    		if(!cn.ExisteNave(idNave)) throw new Exception("No existe ninguna nave con ese identificador");
	    	Nave n = cn.BuscarNave(idNave);
	    	int tipo = cn.ConsultarTipo(idNave);
	    	int consumo = cn.ConsultarConsumo(idNave);
	    	System.out.println(idNave + " " + tipo + " " + consumo + " " + n.consultar_origen() + " " + n.consultar_destino());
	    }
	    catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TestexisteixNau(Scanner cin, ControladorNave cn)
    {
    	try{
	    	int idNave = cin.nextInt();
	    	boolean b = cn.ExisteNave(idNave);
	    	if(b) System.out.print("La nave con id: " + idNave + " existe en la galaxia");
	    	else System.out.print("La nave con id: " + idNave + " no existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void Testmodificar_nomGalaxia(Galaxia g, Scanner cin)
    {
    	try	{
	    	String nouNom = cin.next();
	    	g.modificar_nomGalaxia(nouNom);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TestmodificarN(Galaxia g, Scanner cin)
    {
    	try{
	    	int n1 = cin.nextInt();
	    	g.modificarN(n1);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestCrearafegirPlaneta(Galaxia g, Scanner cin, ControladorPlaneta cp)
    { 	
    	try {
	    	int idPlaneta = cin.nextInt();
	    	int x = cin.nextInt();
	    	int y = cin.nextInt();
	    	int coste = cin.nextInt();
	    	Pair<Integer, Integer> co = new Pair<Integer, Integer>(x,y);
	    	Planeta a = new Planeta(idPlaneta,coste, co);
	    	g.afegirPlaneta(idPlaneta, x, y);
	    	cp.anadirPlaneta(a);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestPlanetaAuto(Galaxia g, ControladorPlaneta cp)
    {
    	try {
	    	Random rand = new Random();
	    	int capacidad = rand.nextInt(Integer.MAX_VALUE-1);
	        int idP = 1;
	        while(cp.ExistePlaneta(idP)) ++idP;
	        Pair<Integer, Integer> co_nuevas = g.afegirPlanetaAutomatic(idP);
	        Planeta p = new Planeta(idP, capacidad, co_nuevas);
	        cp.anadirPlaneta(p);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestCrearPlanetaAutomaticID(Galaxia g, Scanner cin, ControladorPlaneta cp)
    {	
    	try{
	    	int idPlaneta = cin.nextInt();
	    	Random rand = new Random();
	    	int randomNum = rand.nextInt(Integer.MAX_VALUE);
	    	Pair<Integer, Integer> par = g.afegirPlanetaAutomatic(idPlaneta);
	    	Planeta p = new Planeta(idPlaneta, randomNum, par);
	    	cp.anadirPlaneta(p);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TesteliminarPLaneta(Galaxia g, Scanner cin, ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn)
    {
    	try{
	    	int idPlaneta = cin.nextInt();
	    	g.eliminarPlaneta(idPlaneta);
	    	cr.BorrarRutaConexions(idPlaneta);
	    	cp.BorraPla(idPlaneta);
	    	cn.BorraNavesDestinoOrigen(idPlaneta);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TesteliminarTotsPlanetes(Galaxia g, ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn)
    {
    	try{
	    	g.eliminarTotsPlanetes();
	    	cp.BorrarTodos();
	    	cr.BorrarRutas();
	    	cn.EliminarNaves();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestCrearTipoNave(Scanner cin, ControladorNave cn)
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
    
    private static void TestCrearTipoNaveAuto(Scanner cin, ControladorNave cn)
    {
    	try {
    		cn.CrearTipoNaveAuto();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestConsultarTiposNave(ControladorNave cn)
    {
    	try {
    		System.out.println(cn.ConsultarTipos());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestConsultarConsumoTipoNave(Scanner cin, ControladorNave cn)
    {
    	try {
    		int tipo = cin.nextInt();
    		System.out.println(cn.ConsultarConsumoTipo(tipo));
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestcrearNau(Scanner cin, ControladorNave cn)
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
    
    // 1 1 1 2 1 3 2 3 3 3 3 2 3 1 2 1 1 1
    
    private static void TestCrearNaveAuto(ControladorNave cn, Scanner cin, ControladorPlaneta cp)
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
     
    private static void TesteliminarNau(Scanner cin, ControladorNave cn)
    {
    	try{
	    	int idNave = cin.nextInt();
	    	cn.EliminarNave(idNave);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TesteliminarTotesNaus(ControladorNave cn)
    {
    	try{
    		cn.EliminarNaves();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TestcrearRuta(Scanner cin, ControladorRuta cr, ControladorPlaneta cp)
    {
    	try{
    		int id = cin.nextInt();
    		int capacidad = cin.nextInt();
    		int distancia = cin.nextInt();
    		int planetaA = cin.nextInt();
    		int planetaB = cin.nextInt();
    		boolean bidireccional = cin.nextBoolean();
    		cr.CrearRuta(id, capacidad, distancia, planetaA, planetaB, bidireccional, cp);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestCrearRutaAutoID(Scanner cin, ControladorRuta cr, ControladorPlaneta cp)
    {
    	try {
    		int id = cin.nextInt();
    		cr.CrearRuta_automatica(cp, id);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestcrearRutaAuto(ControladorPlaneta cp, ControladorRuta cr)
    {
    	try {
        	cr.CrearRuta_automatica(cp);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TesteliminarRuta(Scanner cin, ControladorRuta cr)
    {
    	try{
    		int idRuta = cin.nextInt();
    		cr.Borrar_Ruta(idRuta);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TesteliminarTotesRutes(ControladorRuta cr)
    {
    	try{
    		cr.BorrarRutas();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }

    
    private static void TestconsultaLimitsUsuari(Galaxia g) 
    {
    	try {
	    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits();
	    	if(lp.size() < 1) throw new Exception("La galaxia no tiene forma");
	    	System.out.print("Coordenadas que dan forma a la galaxia:");
	    	System.out.print(lp);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
    
    private static void TestmodificarLimits(Galaxia g, Scanner cin)
    {
    	try {
    		List<Pair<Integer, Integer> > pa1 = new ArrayList<Pair<Integer, Integer> >();
            int pa_f, pa_s;
            
            pa_f = cin.nextInt();
            if(pa_f > g.consultarLimitGalaxia() || pa_f < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            pa_s = cin.nextInt();
            if(pa_s > g.consultarLimitGalaxia() || pa_s < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            
            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_f,pa_s);
            pa1.add(primero);
            
            int l1 = cin.nextInt();
            if(l1 > g.consultarLimitGalaxia() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            int l2 = cin.nextInt();
            if(l2 > g.consultarLimitGalaxia() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
            
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
            	if(l1 > g.consultarLimitGalaxia() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                l2 = cin.nextInt();
                if(l2 > g.consultarLimitGalaxia() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
            g.modificarLimitsUsuari(pa1);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestconsultarIDplaneta(Galaxia g, Scanner cin)
    {
    	try {
    		int x = cin.nextInt();
    		int y = cin.nextInt();
    		System.out.println(g.consultarIDplaneta(x, y));
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }

    	
}

import java.util.*;

public class DriverGalaxia {
     private Galaxia g;
     
     public void Executa(Scanner cin, ControladorNave cn, ControladorPlaneta cp, ControladorRuta cr) throws Exception {
        int n;
        System.out.print(
	              "---------------------------------------------------------------------------------------- \n"
	            + "                               DRIVER GALAXIA                                    	    \n"
	            + "---------------------------------------------------------------------------------------- \n"
	            
	            + "- Opcion 0: Salir de la gestion del driver                                        	    \n"
	            
	            + "- Opcion 1: Galaxia(String nom, int n)                                           		\n"       
	            + "- Opcion 2: Galaxia(String nom, int n, List<Pair<Integer, Integer> > l)   				\n"
	            
	            + "- Opcion 3: consultarNomGalaxia() 									    				\n"       
	            + "- Opcion 4: consulta_nombreLimits() 										    			\n"
	            + "- Opcion 5: consultarValorLimits() 					    								\n"
	            
 				+ "- Opcion 6: consultarPlanetas() 							 								\n"     
 				+ "- Opcion 7: Consultar_Size()_Planetas 													\n"
	            
	            + "- Opcion 8: Consultar_ids_rutas() 								    					\n"
	            + "- Opcion 9: Consultar_numero_rutes()														\n"
	            
	            + "- Opcion 10: ConsultarNaves() 													    	\n"
	            + "- Opcion 11: cn.size() 																	\n"
	            
	            + "- Opcion 12: consultarLimitGalaxia() 										    		\n"
	            
	            + "- Opcion 13: existeixPlanetaCoordenades(int x, int y) 				    				\n"
	            + "- Opcion 14: consultarPlaneta(int idPlaneta)                    							\n"
	            + "- Opcion 15: existeixPlaneta(int idPlaneta) 						        				\n"
	            
	            + "- Opcion 16: consultarRuta(int idRuta)													\n"
	            + "- Opcion 17: existeixRuta(int idRuta) 							        				\n"
	            
 				+ "- Opcion 18: consultarNau(int idNau)														\n"
	            + "- Opcion 19: existeixNau(int idNave)  								    				\n"
	            
	            + "- Opcion 20: modificar_nomGalaxia(String nom) 							    			\n"
	            + "- Opcion 21: modificarN(int n) 											    			\n"
	            
	            + "- Opcion 22: afegirPlaneta(idPlaneta, x, y)  											\n"		
	            + "- Opcion 23: afegirPlanetaAutomatic(int idPlaneta) 							    		\n"
	            + "- Opcion 24: eliminarPLaneta(int idPlaneta)  						    				\n"
	            + "- Opcion 25: eliminarTotsPlanetes() 										    			\n"
	            
	            + "- Opcion 26: CrearNave(int id, int t, int d, int o)  									\n"
	            + "- Opcion 27: CrearNaveAuto(int num_naves, ArrayList<Integer> ai)   						\n"
	            + "- Opcion 28: EliminarNave(int idNave) 													\n"
	            + "- Opcion 29: EliminarNaves() 					    									\n"
	            
	            + "- Opcion 30: CrearRuta(id, capacidad, distancia, planetaA, planetaB, bidireccional, cp) 	\n"
	            + "- Opcion 31: CrearRuta_automatica(ControladorPlaneta cp, int id) 						\n"
	            + "- Opcion 32: CrearRuta_automatica(ContrladorPlaneta cp)     								\n"
	            + "- Opcion 33: Borrar_Ruta(int idRuta)		    											\n"
	            + "- Opcion 34: BorrarRutas() 					    										\n"
	           
	            + "- Opcion 35: eliminarContingutGalaxia() 									    			\n"
	            + "- Opcion 36: dintreLimitUsuari(int x, int y) 											\n"
	            + "- Opcion 37: algunPlaneta()																\n"
	            + "- Opcion 38: CrearTipoNave(int tipo, int consumo) 										\n"
	            + "- Opcion 39: CrearTipoNaveAuto()  														\n"
	            + "- Opcion 40: ConsultarTipos()  															\n"
	            + "- Opcion 41: ConsultarConsumoTipo(int tipo) 												\n"
	            + "- Opcion 42: PlanetaAuto()  																\n"
	            + "- Opcion 43: modificarLimitsUsuari(List<Pair<Integer, Integer> > p) 						\n"
	            + "- Opcion 44: consultarIDplaneta(int x, int y) 											\n");
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
	            case 1: TestCrearGalaxia(cin);break;
	            case 2: TestCrearGalaxia1(cin);break;
	            
	            case 3: TestConsultarNomGalaxia();break;
	            case 4: Testconsulta_nombreLimits();break;
	            case 5: TestconsultaLimitsUsuari(); break; 
	            
	            case 6: TestconsultarPlanetes(cp);break;
	            case 7: Testconsulta_nombrePlanetes(cp);break;
	            
	            case 8: TestconsultarRutes(cr);break;
	            case 9: Testconsulta_nombreRutes(cr);break;
	            
	            case 10: TestconsultarNaus(cn);break;
	            case 11: Testconsulta_nombreNaus(cn);break;
	            
	            case 12: TestconsultarLimitGalaxia();break;
	            
	            case 13: TestexisteixPlanetaCoordenades(cin);break;
	            case 14: TestconsultarPlaneta(cin,cp); break;
	            case 15: TestexisteixPlaneta(cin);break;
	           
	            case 16: TestconsultarRuta(cin,cr); break;
	            case 17: TestexisteixRuta(cin,cr);break;
	            
	            case 18: TestconsultarNau(cin,cn); break;
	            case 19: TestexisteixNau(cin,cn);break;
	            
	            case 20: Testmodificar_nomGalaxia(cin);break;
	            case 21: TestmodificarN(cin);break;
	            
	            case 22: TestCrearafegirPlaneta(cin,cp);break;
	            case 23: TestafegirPlanetaAutomaticID(cin,cp);break;
	            case 24: TesteliminarPLaneta(cin,cp,cr,cn);break;
	            case 25: TesteliminarTotsPlanetes(cp,cr,cn);break;
	            
	            case 26: TestcrearNau(cin,cn);break;
	            case 27: TestCrearNaveAuto(cn,cin,cp); break;
	            case 28: TesteliminarNau(cin,cn);break;
	            case 29: TesteliminarTotesNaus(cn);break;
	            
	            case 30: TestcrearRuta(cin,cr,cp);break;
	            case 31: TestCrearRutaAutoID(cin,cr,cp);break;
	            case 32: TestcrearRutaAuto(cp,cr);break;
	            case 33: TesteliminarRuta(cin,cr);break;
	            case 34: TesteliminarTotesRutes(cr);break;
	            
	            case 35: TesteliminarContingutGalaxia(cp,cr,cn);break;
	           
	            case 36: TestdintreLimitUsuari(cin); break;
	            case 37: TestalgunPlaneta(); break;
	            
	            case 38: TestCrearTipoNave(cin,cn); break;
	            case 39: TestCrearTipoNaveAuto(cin,cn); break;
	            case 40: TestConsultarTiposNave(cn); break;
	            case 41: TestConsultarConsumoTipoNave(cin,cn); break;
	            case 42: TestPlanetaAuto(cp); break;
	            
	            case 43: TestmodificarLimits(cin);break;
	            case 44: TestconsultarIDplaneta(cin); break;
	            
	            default: System.out.println("Opcion incorrecta");
            }
            n = cin.nextInt();
        }
    }
     
    public void TestCrearGalaxia(Scanner cin) throws Exception
    {
        try{
            String n = cin.next();
            int n1 = cin.nextInt();
            g = new Galaxia(n,n1);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestCrearGalaxia1(Scanner cin)
    {
        try{
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
            g = new Galaxia(n,n1,pa1);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestConsultarNomGalaxia() 
    {
            String s = g.consultarNomGalaxia();
            System.out.println(s);
    }
     
     
    public void TestconsultarPlanetes(ControladorPlaneta cp)
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
    
    public void TestalgunPlaneta()
    {
    	boolean b = g.algunPlaneta();
    	if(b) System.out.println("Hay algun planeta en la galaxia");
    	else System.out.println("No hay ningun planeta en la galaxia");
    }
     
    public void Testconsulta_nombrePlanetes(ControladorPlaneta cp)
    {
        int p = cp.Consultar_Size();
        System.out.println(p);
    }
     
    public void Testconsulta_nombreLimits()
    {
        int p = g.consulta_nombreLimits();
        System.out.println(p);
    }
     
    public void TestconsultarRutes(ControladorRuta cr)
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
     
    public void Testconsulta_nombreRutes(ControladorRuta cr)
    {
        int p = cr.Consultar_numero_rutes();
        System.out.println(p);
    }
     
    public void TestconsultarNaus(ControladorNave cn)
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
     
    public void Testconsulta_nombreNaus(ControladorNave cn)
    {
        int p = cn.size();
        System.out.println(p);
    }
     
    public void TestconsultarLimitGalaxia()
    {
        int p = g.consultarLimitGalaxia().intValue();
        System.out.println(p);
    }
    
    public void TestdintreLimitUsuari(Scanner cin)
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
     
    public void TestexisteixPlanetaCoordenades(Scanner cin)
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
   
   public void TestconsultarPlaneta(Scanner cin, ControladorPlaneta cp)
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
     
    public void TestexisteixPlaneta(Scanner cin)
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
    
    public void TestconsultarRuta(Scanner cin, ControladorRuta cr)
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
     
    public void TestexisteixRuta(Scanner cin, ControladorRuta cr)
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
   
   // -> limites 1 1 1 2 1 3 1 4 1 5 1 6 2 6 3 6 4 6 5 6 5 5 5 4 5 3 5 2 5 1 4 1 3 1 2 1 1 1
   public void TestconsultarNau(Scanner cin, ControladorNave cn)
    {
	    try{
    		int idNave = cin.nextInt();
    		if(!cn.ExisteNave(idNave)) throw new Exception("No existe ninguna nave con ese identificador");
	    	Nave n = cn.BuscarNave(idNave);
	    	int tipo = cn.ConsultarTipo(idNave);
	    	int consumo = cn.ConsultarConsumo(idNave);
	    	System.out.println(idNave + " " + tipo + " " + consumo + " " + n.consultar_destino());
	    }
	    catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestexisteixNau(Scanner cin, ControladorNave cn)
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
     
    public void Testmodificar_nomGalaxia(Scanner cin)
    {
    	try	{
	    	String nouNom = cin.next();
	    	g.modificar_nomGalaxia(nouNom);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestmodificarN(Scanner cin)
    {
    	try{
	    	int n1 = cin.nextInt();
	    	g.modificarN(n1);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void TestCrearafegirPlaneta(Scanner cin, ControladorPlaneta cp)
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
    
    public void TestPlanetaAuto(ControladorPlaneta cp)
    {
    	try {
	    	Random rand = new Random();
	    	int capacidad = rand.nextInt(Integer.MAX_VALUE-1);
	        int idP = 1;
	        while(cp.ExistePlaneta(idP)) ++idP;
	        Pair<Integer, Integer> co_nuevas = g.afegirPlanetaAutomatic(idP);
	        Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(co_nuevas.consultarPrimero(),co_nuevas.consultarSegundo());
	        Planeta p = new Planeta(idP, capacidad, Coo);
	        cp.anadirPlaneta(p);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void TestafegirPlanetaAutomaticID(Scanner cin, ControladorPlaneta cp)
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
    
    public void TesteliminarPLaneta(Scanner cin, ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn)
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
     
    public void TesteliminarTotsPlanetes(ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn)
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
    
    // 1 1 1 2 1 3 2 3 3 3 3 2 3 1 2 1 1 1
    
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
     
    public void TestcrearRuta(Scanner cin, ControladorRuta cr, ControladorPlaneta cp)
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
    
    public void TestcrearRutaAuto(ControladorPlaneta cp, ControladorRuta cr)
    {
    	try {
        	cr.CrearRuta_automatica(cp);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarRuta(Scanner cin, ControladorRuta cr)
    {
    	try{
    		int idRuta = cin.nextInt();
    		cr.Borrar_Ruta(idRuta);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarTotesRutes(ControladorRuta cr)
    {
    	try{
    		cr.BorrarRutas();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarContingutGalaxia(ControladorPlaneta cp, ControladorRuta cr, ControladorNave cn)
    {
    	try{
	    	g.eliminarContingutGalaxia();
	    	if(cp.Consultar_Size() > 0) cp.BorrarTodos();
	    	if(cr.Consultar_numero_rutes() > 0) cr.BorrarRutas();
	    	if(cn.size()> 0) cn.EliminarNaves();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void TestconsultaLimitsUsuari() 
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
    
    public void TestmodificarLimits(Scanner cin)
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
            g.modificarLimitsUsuari(pa1);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void TestconsultarIDplaneta(Scanner cin)
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

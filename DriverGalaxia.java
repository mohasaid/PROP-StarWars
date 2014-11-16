import java.util.*;

public class DriverGalaxia {
     private Galaxia g;
     
     public void Executa(ControladorNave cn, ControladorPlaneta cp, ControladorRuta cr) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n;
        System.out.print(
	              "---------------------------------------------------------------------------------------- \n"
	            + "                               DRIVER GALAXIA                                    	    \n"
	            + "---------------------------------------------------------------------------------------- \n"
	            
	            + "- Opcion 0: Salir de la gestion del driver                                        	    \n"
	            
	            + "- Opcion 1: Galaxia(String nom, int n)                                           		\n"       
	            + "- Opcion 2: Galaxia(String nom, int n, List<Pair<Integer, Integer> > l)   				\n"
	            
	            + "- Opcion 3: consultarNomGalaxia() 									    				\n"       
	            + "- Opcion 4: consultarPresupost() 										    			\n"     
	            + "- Opcion 5: consulta_nombreLimits() 										    			\n"
	            + "- Opcion 6: consultarValorLimits() 					    								\n"
	            
 				+ "- Opcion 7: TestconsultarPlanetes(ControladorPlaneta cp) 							 	\n"     
 				+ "- Opcion 8: Testconsulta_nombrePlanetes(ControladorPlaneta cp) 							\n"
	            
	            + "- Opcion 9: TestconsultarRutes(ControladorRuta cr); 								    	\n"
	            + "- Opcion 10: Testconsulta_nombreRutes(ControladorRuta cr);								\n"
	            
	            + "- Opcion 11: TestconsultarNaus(ControladorNave cn) 								    	\n"
	            + "- Opcion 12: Testconsulta_nombreNaus(ControladorNave cn) 								\n"
	            
	            + "- Opcion 13: consultarLimitGalaxia() 										    		\n"
	            
	            + "- Opcion 14: existeixPlanetaCoordenades(int x, int y) 				    				\n"
	            + "- Opcion 15: TestconsultarPlaneta(Scanner cin, ControladorPlaneta cp)                    \n"
	            + "- Opcion 16: existeixPlaneta(int idPlaneta) 						        				\n"
	            
	            + "- Opcion 17: TestconsultarRuta(Scanner cin,ControladorRruta cr) 							\n"
	            + "- Opcion 18: existeixRuta(int idRuta) 							        				\n"
	            
 				+ "- Opcion 19: TestconsultarNau(Scanner cin,ControladorNave cn)							\n"
	            + "- Opcion 20: existeixNau(int idNave)  								    				\n"
	            
	            + "- Opcion 21: modificar_nomGalaxia(String nom) 							    			\n"
	            + "- Opcion 22: modificarPresupost(int p) 									    			\n"
	            + "- Opcion 23: modificarN(int n) 											    			\n"
	            
	            + "- Opcion 24: TestCrearafegirPlaneta(Scanner cin,ControladorPlaneta cp)  					\n"		
	            + "- Opcion 25: afegirPlanetaAutomatic(int idPlaneta) 							    		\n"
	            + "- Opcion 26: eliminarPLaneta(int idPlaneta)  						    				\n"
	            + "- Opcion 27: eliminarTotsPlanetes() 										    			\n"
	            
	            + "- Opcion 28: TestcrearNau(Scanner cin, ControladorNave cn)  								\n"
	            + "- Opcion 29: TestCrearNaveAuto(ControladorNave cn,Scanner cin, ControladorPlaneta cp)    \n"
	            + "- Opcion 30: TesteliminarNau(Scanner cin, ControladorNave cn) 							\n"
	            + "- Opcion 31: TesteliminarTotesNaus(ControladorNave cn) 					    			\n"
	            
	            + "- Opcion 32: TestcrearRuta(Scanner cin,ControladorRuta cr,ControladorPlaneta cp) 		\n"
	            + "- Opcion 33: TestCrearRutaAutoID(Scanner cin,ControlaorRuta cr, ControladorPlaneta cp) 	\n"
	            + "- Opcion 34: TestcrearRutaAuto(Scanner cin,ControladorPlaneta cp,ControladorRuta cr)     \n"
	            + "- Opcion 35: TesteliminarRuta(Scanner cin,ControladorRuta cr)		    				\n"
	            + "- Opcion 36: TesteliminarTotesRutes(ControladorRuta cr) 					    			\n"
	            
	            + "- Opcion 37: eliminarContingutGalaxia() 									    			\n"
	            + "- Opcion 38: dintreLimitUsuari(int x, int y) 											\n"
	            + "- Opcion 39: algunPlaneta()																\n"
	            + "- Opcion 40: TestCrearTipoNave(Scanner cin, ControladorNave cn) 							\n"
	            + "- Opcion 41: TestCrearTipoNaveAuto(Scanner cin, ControladorNave cn)  					\n"
	            + "- Opcion 42: TestConsultarTiposNave(ControladorNave cn)  								\n"
	            + "- Opcion 43: TestConsultarConsumoTipoNave(Scanner cin, ControladorNave cn)  				\n"
	            + "- Opcion 44: TestPlanetaAuto(ControladorPlaneta cp)  									\n");
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
	            case 1: TestCrearGalaxia(cin);break;
	            case 2: TestCrearGalaxia1(cin);break;
	            
	            case 3: TestConsultarNomGalaxia();break;
	            case 4: TestConsultarPresupuesto();break;
	            case 5: Testconsulta_nombreLimits();break;
	            case 6: TestconsultaLimitsUsuari(); break; 
	            
	            case 7: TestconsultarPlanetes(cp);break;
	            case 8: Testconsulta_nombrePlanetes(cp);break;
	            
	            case 9: TestconsultarRutes(cr);break;
	            case 10: Testconsulta_nombreRutes(cr);break;
	            
	            case 11: TestconsultarNaus(cn);break;
	            case 12: Testconsulta_nombreNaus(cn);break;
	            
	            case 13: TestconsultarLimitGalaxia();break;
	            
	            case 14: TestexisteixPlanetaCoordenades(cin);break;
	            case 15: TestconsultarPlaneta(cin,cp); break;
	            case 16: TestexisteixPlaneta(cin);break;
	            
	            case 17: TestconsultarRuta(cin,cr); break;
	            case 18: TestexisteixRuta(cin,cr);break;
	            
	            case 19: TestconsultarNau(cin,cn); break;
	            case 20: TestexisteixNau(cin,cn);break;
	            
	            case 21: Testmodificar_nomGalaxia(cin);break;
	            case 22: TestmodificarPresupost(cin);break;
	            case 23: TestmodificarN(cin);break;
	            
	            case 24: TestCrearafegirPlaneta(cin,cp);break;
	            case 25: TestafegirPlanetaAutomaticID(cin,cp);break;
	            case 26: TesteliminarPLaneta(cin,cp,cr,cn);break;
	            case 27: TesteliminarTotsPlanetes(cp,cr,cn);break;
	            
	            case 28: TestcrearNau(cin,cn);break;
	            case 29: TestCrearNaveAuto(cn,cin,cp); break;
	            case 30: TesteliminarNau(cin,cn);break;
	            case 31: TesteliminarTotesNaus(cn);break;
	            
	            case 32: TestcrearRuta(cin,cr,cp);break;
	            case 33: TestCrearRutaAutoID(cin,cr,cp);break;
	            case 34: TestcrearRutaAuto(cin,cp,cr);break;
	            case 35: TesteliminarRuta(cin,cr);break;
	            case 36: TesteliminarTotesRutes(cr);break;
	            
	            case 37: TesteliminarContingutGalaxia(cp,cr,cn);break;
	            
	            case 38: TestdintreLimitUsuari(cin); break;
	            case 39: TestalgunPlaneta(); break;
	            
	            case 40: TestCrearTipoNave(cin,cn); break;
	            case 41: TestCrearTipoNaveAuto(cin,cn); break;
	            case 42: TestConsultarTiposNave(cn); break;
	            case 43: TestConsultarConsumoTipoNave(cin,cn); break;
	            case 44: TestPlanetaAuto(cp); break;
	            
	            default: System.out.println("Opcion incorrecta");
            }
            n = cin.nextInt();
        }
    }
     
    public void TestCrearGalaxia(Scanner cin) throws Exception
    {
        try{
        	System.out.println("Introduce nombre");
            String n = cin.next();
            System.out.println("Introduce limite");
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
            g = new Galaxia(n,n1,pa1);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestConsultarNomGalaxia() 
    {
            String s = g.consultarNomGalaxia();
            System.out.println("El nombre de la galaxia es: " + s);
    }
     
    public void TestConsultarPresupuesto() 
    {
    	try{
            int s = g.consultarPresupost().intValue();
            System.out.println("El presupuesto de la galaxia es: " + s);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestconsultarPlanetes(ControladorPlaneta cp)
    {
        try{
            ArrayList<Integer> ar = cp.consultarPlanetas();
            System.out.print("Planetas existentes: ");
            /*for(Integer pl : ar) {
                System.out.print(pl + ",");
            }*/
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
        System.out.println("El numero de planetas en la galaxia es: " + p);
    }
     
    public void Testconsulta_nombreLimits()
    {
        int p = g.consulta_nombreLimits();
        System.out.println("Numero de coordenadas introducidas por el usuario: " + p);
    }
     
    public void TestconsultarRutes(ControladorRuta cr)
    {
        try{
            ArrayList<Integer> ar = cr.Consultar_ids_rutas();
            System.out.print("Rutas existentes: ");
            /*for(Integer rl : ar) {
                System.out.print(rl + ",");
            }*/
            System.out.println(ar);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void Testconsulta_nombreRutes(ControladorRuta cr)
    {
        int p = cr.Consultar_numero_rutes();
        System.out.println("Numero de rutas en la galaxia es: " + p);
    }
     
    // ARREGLAR
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
            System.out.println("Naves existentes: ");
            
            /*for(Integer nl : ar) {
                System.out.println(nl + ",");
            }*/
            System.out.println(res);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void Testconsulta_nombreNaus(ControladorNave cn)
    {
        int p = cn.size();
        System.out.println("Numero de naves en la galaxia: " + p);
    }
     
    public void TestconsultarLimitGalaxia()
    {
        int p = g.consultarLimitGalaxia().intValue();
        System.out.println("El limit de la galaxia es: " + p);
    }
    
    public void TestdintreLimitUsuari(Scanner cin)
    {
    	boolean b;
		try {
			System.out.print("Introduce primera coordenada");
			int x = cin.nextInt();
			System.out.print("Introduce primera coordenada");
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
    		System.out.println("Introduce primera coordenada");
	    	int cX = cin.nextInt();
	    	System.out.println("Introduce segunda coordenada");
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
    		System.out.println("Introduce el identificador del planeta");
	    	int idPlaneta = cin.nextInt();
	    	if(!g.existeixPlaneta(idPlaneta)) System.out.println("No existe ningun planeta con ese identificador");
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
     
    public void TestexisteixPlaneta(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el identificador del planeta");
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
     
    public void TestexisteixRuta(Scanner cin, ControladorRuta cr)
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
   
   // -> limites 1 1 1 2 1 3 1 4 1 5 1 6 2 6 3 6 4 6 5 6 5 5 5 4 5 3 5 2 5 1 4 1 3 1 2 1 1 1
   public void TestconsultarNau(Scanner cin, ControladorNave cn)
    {
	    try{
	    	System.out.println("Introduce el identificador de la nave");
    		int idNave = cin.nextInt();
    		if(!cn.ExisteNave(idNave)) throw new Exception("No existe ninguna nave con ese identificador");
	    	Nave n = cn.BuscarNave(idNave);
	    	int tipo = cn.ConsultarTipo(idNave);
	    	int consumo = cn.ConsultarConsumo(idNave);
	    	System.out.println("La nave con id: " + idNave
	    						+ "\n tiene como Tipo: " + tipo
	    						+ "\n tiene como consumo: " + consumo
	    						+ "\n tiene como destino: " + n.consultar_destino());
	    }
	    catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestexisteixNau(Scanner cin, ControladorNave cn)
    {
    	try{
    		System.out.println("Introduce el identificador de la ruta");
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
    	try{
    		System.out.println("Introduce nombre");
	    	String nouNom = cin.next();
	    	g.modificar_nomGalaxia(nouNom);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestmodificarPresupost(Scanner cin)
    {
	    try{
	    	System.out.println("Introduce el valor del presupuesto");
    		int pr = cin.nextInt();
	    	g.modificarPresupost(pr);
	    }
	    catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestmodificarN(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el nuevo limite");
	    	int n1 = cin.nextInt();
	    	g.modificarN(n1);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void TestCrearafegirPlaneta(Scanner cin, ControladorPlaneta cp)
    { 	
    	try{
    		System.out.println("Introduce el identificador del planeta");
	    	int idPlaneta = cin.nextInt();
	    	System.out.println("Introduce primera coordenada");
	    	int x = cin.nextInt();
	    	System.out.println("Introduce segunda coordenada");
	    	int y = cin.nextInt();
	    	System.out.println("Introduce coste");
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
	        System.out.println("Antes for");
	        while(cp.ExistePlaneta(idP)) ++idP;
	        System.out.println("Despues for, idp = " + idP);
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
    		System.out.println("Introduce el identificador del planeta");
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
    		System.out.println("Introduce el identificador del planeta a borrar");
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
    
    // 1 1 1 2 1 3 2 3 3 3 3 2 3 1 2 1 1 1
    
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
     
    public void TestcrearRuta(Scanner cin, ControladorRuta cr, ControladorPlaneta cp)
    {
    	try{
    		System.out.print("Introduce el identificador de la ruta");
    		int id = cin.nextInt();
    		System.out.print("Introduce la capacidad");
    		int capacidad = cin.nextInt();
    		System.out.print("Introduce la distancia");
    		int distancia = cin.nextInt();
    		System.out.print("Introduce el planeta origen");
    		int planetaA = cin.nextInt();
    		System.out.print("Introduce el planeta destino");
    		int planetaB = cin.nextInt();
    		System.out.print("Introduce si es bidireccional");
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
    		System.out.print("Introduce el identificador de la ruta");
    		int id = cin.nextInt();
    		cr.CrearRuta_automatica(cp, id);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void TestcrearRutaAuto(Scanner cin, ControladorPlaneta cp, ControladorRuta cr)
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
    		System.out.print("Introduce el identificador de la ruta a borrar");
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
	    	System.out.print("Coordenadas que dan forma a la galaxia:");
	    	/*for(int i = 0; i < lp.size()-1; ++i) {
				System.out.print("(" + lp.get(i).consultarPrimero() + ", " + lp.get(i).consultarSegundo() + "), ");
			}
			System.out.print("(" + lp.get(lp.size()-1).consultarPrimero() + ", " + lp.get(lp.size()-1).consultarSegundo() + ")");*/
	    	System.out.print(lp);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
}

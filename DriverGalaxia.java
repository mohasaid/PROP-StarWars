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
	            + "- Opcion 2: Galaxia(String nom, int n, List<Pair<Integer, Integer> > l, int p)   		\n"      
	            + "- Opcion 3: consultarNomGalaxia() 									    				\n"       
	            + "- Opcion 4: consultarPresupost() 										    			\n"     
	            + "- Opcion 5: consultarPlanetes() 							    							\n"     
	            + "- Opcion 6  consulta_nombrePlanetes() 									    			\n"
	            + "- Opcion 7: consulta_nombreLimits() 										    			\n"
	            + "- Opcion 8: consultarRutes() 								    						\n"
	            + "- Opcion 9: consulta_nombreRutes() 										    			\n"
	            + "- Opcion 10: consultarNaus() 								    						\n"
	            + "- Opcion 11: consulta_nombreNaus() 										    			\n"
	            + "- Opcion 12: consultarLimitGalaxia() 										    		\n"
	            + "- Opcion 13: existeixPlanetaCoordenades(int x, int y) 				    				\n"
	            + "- Opcion 14: existeixPlaneta(int idPlaneta) 						        				\n"
	            + "- Opcion 15: existeixRuta(int idRuta) 							        				\n"
	            + "- Opcion 16: existeixNau(int idNave)  								    				\n"
	            + "- Opcion 17: modificar_nomGalaxia(String nom) 							    			\n"
	            + "- Opcion 18: modificarPresupost(int p) 									    			\n"
	            + "- Opcion 19: modificarN(int n) 											    			\n"
	            + "- Opcion 20: afegirPlaneta(Planeta p) 									    			\n"
	            + "- Opcion 21: afegirPlanetaAutomatic(Planeta p) 							    			\n"
	            + "- Opcion 22: eliminarPLaneta(String nomplaneta)  						    			\n"
	            + "- Opcion 23: eliminarTotsPlanetes() 										    			\n"
	            + "- Opcion 24: afegirNau(Nau n)    										    			\n"
	            + "- Opcion 25: eliminarNau(String nomnau) 									    			\n"
	            + "- Opcion 26: eliminarTotesNaus() 										    			\n"
	            + "- Opcion 27: afegirRuta(Ruta r) 											    			\n"
	            + "- Opcion 28: eliminarRuta(String nomruta) 								    			\n"
	            + "- Opcion 29: eliminarTotesRutes() 										    			\n"
	            + "- Opcion 30: eliminarContingutGalaxia() 									    			\n"
	            + "- Opcion 31: consultarValorLimits() 					    								\n"
	            + "- Opcion 32: TestCrearPlanetaYafegirlo(Scanner cin)                                      \n");
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
	            case 1: TestCrearGalaxia(cin);break;
	            case 2: TestCrearGalaxia1(cin);break;
	            case 3: TestConsultarNomGalaxia();break;
	            case 4: TestConsultarPresupuesto();break;
	            case 5: TestconsultarPlanetes();break;
	            case 6: Testconsulta_nombrePlanetes();break;
	            case 7: Testconsulta_nombreLimits();break;
	            case 8: TestconsultarRutes();break;
	            case 9: Testconsulta_nombreRutes();break;
	            case 10: TestconsultarNaus();break;
	            case 11: Testconsulta_nombreNaus();break;
	            case 12: TestconsultarLimitGalaxia();break;
	            case 13: TestexisteixPlanetaCoordenades(cin);break;
	            case 14: TestexisteixPlaneta(cin);break;
	            case 15: TestexisteixRuta(cin);break;
	            case 16: TestexisteixNau(cin);break;
	            case 17: Testmodificar_nomGalaxia(cin);break;
	            case 18: TestmodificarPresupost(cin);break;
	            case 19: TestmodificarN(cin);break;
	            case 20: TestafegirPlaneta(cin,cp);break;
	            case 21: TestafegirPlanetaAutomatic(cin,cp);break;
	            case 22: TesteliminarPLaneta(cin,cp);break;
	            case 23: TesteliminarTotsPlanetes();break;
	            case 24: TestafegirNau(cin,cn);break;
	            case 25: TesteliminarNau(cin,cn);break;
	            case 26: TesteliminarTotesNaus();break;
	            case 27: TestafegirRuta(cin,cr, cp);break;
	            case 28: TesteliminarRuta(cin,cr);break;
	            case 29: TesteliminarTotesRutes();break;
	            case 30: TesteliminarContingutGalaxia();break;
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
            Integer a, b;
            int pa_f, pa_s;
            System.out.println("Introduce primera coordenada");
            pa_f = cin.nextInt();
            System.out.println("Introduce segunda coordenada");
            pa_s = cin.nextInt();
            while(pa_f != -1 && pa_s != -1) { // Si lee -1,-1 de coordenadas deja de leer
            	a = new Integer(pa_f);
            	b = new Integer(pa_s);
            	Pair<Integer, Integer> pa = new Pair<Integer, Integer>(a, b);
            	pa1.add(pa);
            	System.out.println("Introduce primera coordenada");
                pa_f = cin.nextInt();
                System.out.println("Introduce segunda coordenada");
                pa_s = cin.nextInt();	
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
     
    public void TestconsultarPlanetes()
    {
        try{
            ArrayList<Integer> ar = g.consultarPlanetes();
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
     
    public void Testconsulta_nombrePlanetes()
    {
        int p = g.consulta_nombrePlanetes();
        System.out.println("El numero de planetas en la galaxia es: " + p);
    }
     
    public void Testconsulta_nombreLimits()
    {
        int p = g.consulta_nombreLimits();
        System.out.println("Numero de coordenadas introducidas por el usuario: " + p);
    }
     
    public void TestconsultarRutes()
    {
        try{
            ArrayList<Integer> ar = g.consultarRutes();
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
     
    public void Testconsulta_nombreRutes()
    {
        int p = g.consulta_nombreRutes();
        System.out.println("Numero de rutas en la galaxia es: " + p);
    }
     
    public void TestconsultarNaus()
    {
        try{
            ArrayList<Integer> ar = g.consultarNaus();
            System.out.print("Naves existentes: ");
            /*for(Integer nl : ar) {
                System.out.println(nl + ",");
            }*/
            System.out.println(ar);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void Testconsulta_nombreNaus()
    {
        int p = g.consulta_nombreNaus();
        System.out.println("Numero de naves en la galaxia: " + p);
    }
     
    public void TestconsultarLimitGalaxia()
    {
        int p = g.consultarLimitGalaxia().intValue();
        System.out.println("El limit de la galaxia es: " + p);
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
   
    
   /// !!!! ///
   public void TestconsultarPlaneta(Scanner cin, ControladorPlaneta cp)
    {
    	try{
    		System.out.println("Introduce el identificador del planeta");
	    	int idPlaneta = cin.nextInt();
	    	if(!g.existeixPlaneta(idPlaneta)) System.out.println("No existe ningun planeta con ese identificador");
	    	Planeta a = cp.BuscarPlaneta(idPlaneta);
	    	System.out.println("El planeta con id: " + idPlaneta + "tiene como atributos: "
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
    /// !!! ///
    public void TestconsultarRuta(Scanner cin, ControladorRuta cr)
    {
    	try {
    		System.out.println("Introduce el identificador de la ruta");
	    	int idRuta = cin.nextInt();
	    	if(!g.existeixRuta(idRuta)) System.out.println("No existe ninguna ruta con ese identificador");
	    	Ruta r = cr.BuscarRuta(idRuta);
	    	System.out.println("La ruta con id: " + idRuta 
	    						+ "\n tiene como capacidad: " + r.consultar_capacidad()
	    						+ "\n tiene como distancia: " + r.consultar_distancia()
	    						+ "\n conecta los planetas: " + r.consultar_planetaA() + " y " + r.consultar_planetaB());
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestexisteixRuta(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el identificador de la ruta");
	    	int idRuta = cin.nextInt();
	    	boolean b = g.existeixRuta(idRuta);
	    	if(b) System.out.print("La ruta con id: " + idRuta + " existe en la galaxia");
	    	else System.out.print("La ruta con id: " + idRuta + " no existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    /// !!! ///
    public void TestconsultarNau(Scanner cin, ControladorNave cn)
    {
	    try{
	    	System.out.println("Introduce el identificador de la nave");
    		int idNave = cin.nextInt();
    		if(g.existeixNau(idNave)) throw new Exception("No existe ninguna nave con ese identificador");
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
     
    public void TestexisteixNau(Scanner cin)
    {
    	try{
    		System.out.println("Introduce el identificador de la ruta");
	    	int idNave = cin.nextInt();
	    	boolean b = g.existeixNau(idNave);
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
    
    
    public void TestafegirPlaneta(Scanner cin, ControladorPlaneta cp)
    { 	
    	try{
    		System.out.print("Introduce el identificador del planeta");
	    	int idPlaneta = cin.nextInt();
	    	if(!cp.ExistePlaneta(idPlaneta)) cp.PlanetaAuto(idPlaneta); // Si no existe lo creo
	    	Planeta p = cp.BuscarPlaneta(idPlaneta);
	    	int x = cin.nextInt();
	    	int y = cin.nextInt();
	    	g.afegirPlaneta(p,x,y);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestafegirPlanetaAutomatic(Scanner cin, ControladorPlaneta cp)
    {	
    	try{
    		System.out.print("Introduce el identificador del planeta");
	    	int idPlaneta = cin.nextInt();
	    	if(!cp.ExistePlaneta(idPlaneta)) cp.PlanetaAuto(idPlaneta); // Si no existe lo creo
	    	Planeta p = cp.BuscarPlaneta(idPlaneta);
	    	g.afegirPlanetaAutomatic(p);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarPLaneta(Scanner cin, ControladorPlaneta cp)
    {
    	try{
    		System.out.print("Introduce el identificador del planeta a borrar");
	    	int idPlaneta = cin.nextInt();
	    	Planeta a = cp.BuscarPlaneta(idPlaneta);
	    	g.eliminarPLaneta(a);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarTotsPlanetes()
    {
    	try{
	    	g.eliminarTotsPlanetes();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestafegirNau(Scanner cin, ControladorNave cn)
    {
    	try{
    		System.out.print("Introduce el identificador de la nave");
	    	int idNave = cin.nextInt();
	    	if(!cn.ExisteNave(idNave)) cn.CrearNaveAuto(idNave);
	    	Nave n = cn.BuscarNave(idNave);
	    	g.afegirNau(n.consultar_id());
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
	    	g.eliminarNau(idNave);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarTotesNaus()
    {
    	try{
	    	g.eliminarTotesNaus();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TestafegirRuta(Scanner cin, ControladorRuta cr, ControladorPlaneta cp)
    {
    	try{
    		System.out.print("Introduce el identificador de la ruta");
	    	int idRuta = cin.nextInt();
	    	if(!cr.ExisteRuta(idRuta)) cr.CrearRuta_automatica(cp,idRuta);
	    	g.afegirRuta(idRuta);
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
	    	if(!g.existeixRuta(idRuta)) System.out.println("La ruta no existe");
	    	g.eliminarRuta(idRuta);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarTotesRutes()
    {
    	try{
	    	g.eliminarTotesRutes();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    public void TesteliminarContingutGalaxia()
    {
    	try{
	    	g.eliminarContingutGalaxia();
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

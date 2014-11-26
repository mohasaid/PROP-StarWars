import java.util.*;

/*
 * En realidad galaxia no tiene que añadir nada en controlador de planeta, pero para probar de manera correcta el funcionamiento 
 * de galaxia es necesario usarlo. Aclarar que es el controlador de planeta el que añade las cosas a galaxia. Esto es asi porque
 * galaxia no guarda informacion respecto los planetas, solo donde estan situados en ella. Consecuencia de esto es la 
 * redefinicion de los metodos de crear planeta.
 * 
 */

public class DriverGalaxia {
	private static boolean creado = false;
    
	public DriverGalaxia() {};
	
    public static void Executa(Scanner cin)
    {
    	 opcions();
    	 Galaxia g = null;
    	 ControladorPlaneta cp = new ControladorPlaneta();
    	 
    	 int opcion = cin.nextInt();
    	 while(opcion != 0) {
             switch(opcion) {
 	            case 1: g = TestCrearGalaxia(cin); break;
 	            case 2: g = TestCrearGalaxia1(cin); break;
 	            
 	            case 3: TestConsultarNomGalaxia(g); break;
 	            case 4: Testconsulta_nombreLimits(g); break;
 	            case 5: TestconsultaLimitsUsuari(g); break; 
 	            case 6: TestconsultarLimitGalaxia(g); break;
 	            case 7: TestdintreLimitUsuari(g,cin); break;
 	            
 	            case 8: Testmodificar_nomGalaxia(g, cin); break;
 	            case 9: TestmodificarN(g, cin); break;
 	            case 10: TestmodificarLimits(g,cin); break;
 	            
 	            case 11: TestexisteixPlanetaCoordenades(g,cin); break;
 	            case 12: TestconsultarPlaneta(g,cin,cp); break;
 	            case 13: TestalgunPlaneta(g); break;
 	           
 	            case 14: TestCrearafegirPlaneta(g,cin,cp);break;
 	            case 15: TestCrearPlanetaAutomaticID(g,cin,cp);break;
 	            case 16: TestPlanetaAuto(g,cp); break;
 	            
 	            case 17: TesteliminarPLaneta(g,cin,cp); break;
 	            case 18: TesteliminarTotsPlanetes(g,cp); break;
 	            
 	            default: System.out.println("Opcion incorrecta");
             }
             opcion = cin.nextInt();
         }
     }
    
	private static void opcions()
    {
    	 System.out.print(
	              "----------------------------------------------------------------------------- 			\n"
	            + "                               DRIVER GALAXIA                                    	    \n"
	            + "----------------------------------------------------------------------------- 			\n"
	            
	            + "- Opcion 0: Salir de la gestion del driver                                        	    \n"
	            
	            + "- Opcion 1: Galaxia(String nom, int n)                                           		\n"       
	            + "- Opcion 2: Galaxia(String nom, int n, List<Pair<Integer, Integer> > l)   				\n"
	            
	            + "- Opcion 3: consultarNomGalaxia() 									    				\n"       
	            + "- Opcion 4: consulta_nombreLimits() 										    			\n"
	            + "- Opcion 5: consultarValorLimits() 					    								\n"
	            + "- Opcion 6: consultarLimitGalaxia() 										    			\n"
	            + "- Opcion 7: dintreLimitUsuari(int x, int y) 												\n"
				
 				+ "- Opcion 8: modificar_nomGalaxia(String nom) 							    			\n"
 				+ "- Opcion 9: modificarN(int n) 											    			\n"
 				+ "- Opcion 10: modificarLimitsUsuari(List<Pair<Integer, Integer> > p) 						\n"
 				
				+ "- Opcion 11: existeixPlanetaCoordenades(int x, int y) 				    				\n"
				+ "- Opcion 12: consultarPlaneta(String idPlaneta)                    						\n"
	            + "- Opcion 13: algunPlaneta()																\n"
				
				+ "- Opcion 14: CrearPlaneta(String, x, y)  												\n"
				+ "- Opcion 15: CrearPlanetaAutomatic(String idPlaneta) 							    	\n"
				+ "- Opcion 16: PlanetaAuto()  																\n"
				
            	+ "- Opcion 17: eliminarPLaneta(String idPlaneta)  						    				\n"
            	+ "- Opcion 18: eliminarTotsPlanetes() 										    			\n"
	            );
    }
    
    private static Galaxia TestCrearGalaxia(Scanner cin)
    {
        try{
            String n = cin.next();
            int n1 = cin.nextInt();
            Galaxia g1 = new Galaxia(n,n1);
            creado = true;
            return g1;
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
            	}
            	else throw new Exception("Las coordenadas no son secuenciales");
            	l1 = cin.nextInt();
            	if(l1 > n1 || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                l2 = cin.nextInt();
                if(l2 > n1 || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
            Galaxia g1 = new Galaxia(n,n1,pa1);
            creado = true;
            return g1;
        }
        catch(Exception e) {
            System.out.println(e);
        }
		return null;
    }
     
    private static void TestConsultarNomGalaxia(Galaxia g) 
    {
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
            String s = g.consultarNomGalaxia(); // no saca excepcion
            System.out.println(s);
    	}
    	 catch(Exception e) {
             System.out.println(e);
         }
    }
     
    private static void TestalgunPlaneta(Galaxia g)
    {
    	try {
	    	if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	boolean b = g.algunPlaneta(); // no saca excepcion
	    	if(b) System.out.println("Hay algun planeta en la galaxia");
	    	else System.out.println("No hay ningun planeta en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void Testconsulta_nombreLimits(Galaxia g)
    {
    	try {
	    	if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	        int p = g.consulta_nombreLimits(); // devuelve numero
	        System.out.println(p);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TestconsultarLimitGalaxia(Galaxia g)
    {
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	        int p = g.consultarLimitGalaxia(); // devuelve numero 
	        System.out.println(p);
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestdintreLimitUsuari(Galaxia g, Scanner cin)
    {
    	boolean b;
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			int x = cin.nextInt();
			int y = cin.nextInt();
			
			if(g.consulta_nombreLimits() > 0) {
				b = g.dintreLimitUsuari(x, y); // saca excepcion si es mayor que N o menor que 0
				if(b) System.out.println("Si que esta dins el limit");
				else System.out.println("No esta dins el limit");
			}
			
			else {
				if((g.consultarLimitGalaxia() > x && x > 0) && (g.consultarLimitGalaxia() > y && y > 0)) System.out.println("Si que esta dins el limit");
				else System.out.println("No esta dins el limit");
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
    }
     
    private static void TestexisteixPlanetaCoordenades(Galaxia g, Scanner cin)
    {  
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	int cX = cin.nextInt();
	    	int cY = cin.nextInt();
	    	boolean exist = g.existeixPlanetaCoordenades(cX, cY); // saca excepcion por las coordenadas (>N <0, no dintre limit)
	    	if(exist) System.out.println("Existe un planeta en la galaxia con esas coordenadas");
	    	else System.out.println("No existe ningun planeta en la galaxia con esas coordenadas");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
   
    private static void TestconsultarPlaneta(Galaxia g, Scanner cin, ControladorPlaneta cp)
    {
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	String idPlaneta = cin.next();
	    	if(!cp.ExistePlaneta(idPlaneta)) throw new Exception("No existe ningun planeta con ese identificador");
	    	Planeta a = cp.BuscarPlaneta(idPlaneta); // no saca excecpion
	    	System.out.println(idPlaneta + " " + a.Consultar_Coste() + " (" + a.consultar_X() + ", " + a.consultar_Y() + ")");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void Testmodificar_nomGalaxia(Galaxia g, Scanner cin)
    {
    	try	{
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	String nouNom = cin.next();
	    	g.modificar_nomGalaxia(nouNom); // saca excepcion si no es alfanumerico
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TestmodificarN(Galaxia g, Scanner cin)
    {
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	int n1 = cin.nextInt();
	    	g.modificarN(n1); // saca excepcion si hay planetas o es menor que 10
	    	System.out.println("HE MODIFICADO EL LIMTIE");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestCrearafegirPlaneta(Galaxia g, Scanner cin, ControladorPlaneta cp)
    { 	
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	String idPlaneta = cin.next();
	    	int x = cin.nextInt();
	    	int y = cin.nextInt();
	    	int coste = cin.nextInt();
	    	
	    	Pair<Integer, Integer> co = new Pair<Integer, Integer>(x,y);
	    	
	    	Planeta a = new Planeta(idPlaneta,coste, co);
	    	if(cp.ExistePlaneta(idPlaneta)) throw new Exception("Ya hay un planeta con este identificador");
	    	
	    	g.afegirPlaneta(x, y); // saca excepcion si existe uno en esas coordenadas o si no hay limite en galaxia
	    	cp.anadirPlaneta(a); // saca excepcion si existe
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestPlanetaAuto(Galaxia g, ControladorPlaneta cp)
    {
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	Random rand = new Random();
	    	int capacidad = rand.nextInt(Integer.MAX_VALUE-1);
	    	
	        String nom = "Planeta";
			int id = 0;
			String seg = Integer.toString(id);
			String f = nom+seg;
			while(cp.ExistePlaneta(f)) {
				++id;
				seg = Integer.toString(id);
				f = nom+seg;
			}
			
	        Pair<Integer, Integer> co_nuevas = g.afegirPlanetaAutomatic(); // saca excepcion si no se puede crear
	        Planeta p = new Planeta(f, capacidad, co_nuevas);
	        cp.anadirPlaneta(p); // saca excepcion si existe
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestCrearPlanetaAutomaticID(Galaxia g, Scanner cin, ControladorPlaneta cp)
    {	
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	String idPlaneta = cin.next();
	    	Random rand = new Random();
	    	int randomNum = rand.nextInt(Integer.MAX_VALUE);
	    	
	    	if(cp.ExistePlaneta(idPlaneta)) throw new Exception("Ya hay un planeta con este identificador");
	    	
	    	Pair<Integer, Integer> par = g.afegirPlanetaAutomatic(); // saca excepcion si no se puede crear
	    	Planeta p = new Planeta(idPlaneta, randomNum, par); 
	    	cp.anadirPlaneta(p); // saca excepcion si existe
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TesteliminarPLaneta(Galaxia g, Scanner cin, ControladorPlaneta cp)
    {
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	String idPlaneta = cin.next();
	    	
	    	if(!cp.ExistePlaneta(idPlaneta)) throw new Exception("El planeta introducido no existe");
	    	
	    	Planeta p = cp.BuscarPlaneta(idPlaneta);
	    	int x = p.consultar_X();
	    	int y = p.consultar_Y();
	    	g.eliminarPlaneta(x,y); // saca excepcion si no esta
	    	cp.BorraPla(idPlaneta); // no saca excepcion
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TesteliminarTotsPlanetes(Galaxia g, ControladorPlaneta cp)
    {
    	try{
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
    		if(g.algunPlaneta()) {
		    	g.eliminarTotsPlanetes();
		    	cp.BorrarTodos(); // no saca excepcion si no hay planetas
    		}
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestconsultaLimitsUsuari(Galaxia g) 
    {
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
    		if(g.consulta_nombreLimits() > 0) {
    			List<Pair<Integer, Integer> > lp = g.consultarValorLimits(); // no saca excepcion
    			System.out.print("Coordenadas que dan forma a la galaxia: ");
    			System.out.println(lp);
    		}
    		else throw new Exception("La galaxia no tiene forma");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
    
    private static void TestmodificarLimits(Galaxia g, Scanner cin)
    {
    	try {
    		if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
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
            	}
            	else throw new Exception("Las coordenadas no son secuenciales");
            	l1 = cin.nextInt();
            	if(l1 > g.consultarLimitGalaxia() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                l2 = cin.nextInt();
                if(l2 > g.consultarLimitGalaxia() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
            g.modificarLimitsUsuari(pa1); // saca execpcion si es menor que 4 o hay planetas
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
}

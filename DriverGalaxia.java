import java.util.*;

public class DriverGalaxia {
    
	public DriverGalaxia() {};
	
    public static void main(String args[])
    {
    	 opcions();
    	 Scanner cin = new Scanner(System.in);
    	 Galaxia g = new Galaxia();
    	 ControladorPlaneta cp = new ControladorPlaneta();
    	 
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
 	          
 	            case 15: TestconsultarIDplaneta(g,cin); break;
 	            case 16: TestalgunPlaneta(g); break;
 	            
 	            case 17: TestCrearafegirPlaneta(g,cin,cp);break;
 	            case 18: TestCrearPlanetaAutomaticID(g,cin,cp);break;
 	            case 19: TestPlanetaAuto(g,cp); break;
 	            
 	            case 20: TesteliminarPLaneta(g,cin,cp); break;
 	            case 21: TesteliminarTotsPlanetes(g,cp); break;
 	            
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
				
				+ "- Opcion 15: consultarIDplaneta(int x, int y) 											\n"
	            + "- Opcion 16: algunPlaneta()																\n"
				
				+ "- Opcion 17: CrearPlaneta(idPlaneta, x, y)  												\n"
				+ "- Opcion 18: CrearPlanetaAutomatic(int idPlaneta) 							    		\n"
				+ "- Opcion 19: PlanetaAuto()  																\n"
				
            	+ "- Opcion 20: eliminarPLaneta(int idPlaneta)  						    				\n"
            	+ "- Opcion 21: eliminarTotsPlanetes() 										    			\n"
	            );
    }
    
    private static Galaxia TestCrearGalaxia0()
    {
    	return new Galaxia();
    }
    
    private static Galaxia TestCrearGalaxia(Scanner cin)
    {
        try{
        	System.out.println("Introduce nombre");
            String n = cin.next();
            System.out.println("Introduce limite");
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
        	System.out.println("Introduce nombre");
            String n = cin.next();
            System.out.println("Introduce limite");
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
            System.out.println("coordenadas leidas");
            return new Galaxia(n,n1,pa1);
        }
        catch(Exception e) {
            System.out.println(e);
        }
		return null;
    }
     
    private static void TestConsultarNomGalaxia(Galaxia g) 
    {
            String s = g.consultarNomGalaxia(); // no saca excepcion
            System.out.println(s);
    }
     
    private static void TestalgunPlaneta(Galaxia g)
    {
    	boolean b = g.algunPlaneta(); // no saca excepcion
    	if(b) System.out.println("Hay algun planeta en la galaxia");
    	else System.out.println("No hay ningun planeta en la galaxia");
    }
     
    private static void Testconsulta_nombreLimits(Galaxia g)
    {
        int p = g.consulta_nombreLimits(); // devuelve numero
        System.out.println(p);
    }
     
    private static void TestconsultarLimitGalaxia(Galaxia g)
    {
        int p = g.consultarLimitGalaxia().intValue(); // devuelve numero 
        System.out.println(p);
    }
    
    private static void TestdintreLimitUsuari(Galaxia g, Scanner cin)
    {
    	boolean b;
		try {
			System.out.println("Introduce primera coordenada");
			int x = cin.nextInt();
			System.out.println("Introduce segunda coordenada");
			int y = cin.nextInt();
			if(g.consulta_nombreLimits() > 0) {
				b = g.dintreLimitUsuari(x, y); // saca excepcion si es mayor que N
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
    	try {
    		System.out.println("Introduce primera coordenada");
	    	int cX = cin.nextInt();
	    	System.out.println("Introduce segunda coordenada");
	    	int cY = cin.nextInt();
	    	boolean exist = g.existeixPlanetaCoordenades(cX, cY); // saca excepcion por las coordenadas
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
    		System.out.println("Introduce identificador planeta");
	    	int idPlaneta = cin.nextInt();
	    	if(!g.existeixPlaneta(idPlaneta)) System.out.println("No existe ningun planeta con ese identificador");
	    	Planeta a = cp.BuscarPlaneta(idPlaneta); // no saca excecpion
	    	System.out.println(idPlaneta + " " + a.Consultar_Coste() + " (" + a.consultar_X() + ", " + a.consultar_Y() + ")");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TestexisteixPlaneta(Galaxia g, Scanner cin)
    {
    	try{
    		System.out.println("Introduce identificador planeta");
	    	int idPlaneta = cin.nextInt();
	    	boolean b = g.existeixPlaneta(idPlaneta); // no saca excepcion
	    	if(b) System.out.println("El planeta con id: " + idPlaneta + " existe en la galaxia");
	    	else System.out.println("El planeta con id: " + idPlaneta + " no existe en la galaxia");
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void Testmodificar_nomGalaxia(Galaxia g, Scanner cin)
    {
    	try	{
    		System.out.println("Introduce el nombre de la galaxia");
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
    		System.out.println("Introduce el limite de la galaxia");
	    	int n1 = cin.nextInt();
	    	g.modificarN(n1); // saca excepcion si hay planetas o es menor que 10
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestCrearafegirPlaneta(Galaxia g, Scanner cin, ControladorPlaneta cp)
    { 	
    	try {
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
	    	g.afegirPlaneta(idPlaneta, x, y); // saca excepcion si existe o si no hay limite en galaxia
	    	cp.anadirPlaneta(a); // saca excepcion si existe
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
	        Pair<Integer, Integer> co_nuevas = g.afegirPlanetaAutomatic(idP); // saca excepcion si existe o N = 0
	        Planeta p = new Planeta(idP, capacidad, co_nuevas);
	        cp.anadirPlaneta(p); // saca excepcion si existe
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestCrearPlanetaAutomaticID(Galaxia g, Scanner cin, ControladorPlaneta cp)
    {	
    	try {
    		System.out.println("Introduce identificador planeta");
	    	int idPlaneta = cin.nextInt();
	    	Random rand = new Random();
	    	int randomNum = rand.nextInt(Integer.MAX_VALUE);
	    	Pair<Integer, Integer> par = g.afegirPlanetaAutomatic(idPlaneta); // saca excepcion si existe
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
    		System.out.println("Introduce identificador planeta");
	    	int idPlaneta = cin.nextInt();
	    	g.eliminarPlaneta(idPlaneta); // saca excepcion si no esta
	    	cp.BorraPla(idPlaneta); // no saca excepcion
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
     
    private static void TesteliminarTotsPlanetes(Galaxia g, ControladorPlaneta cp)
    {
    	try{
	    	g.eliminarTotsPlanetes(); // saca excepcion si no hay planetas
	    	cp.BorrarTodos(); // no saca excepcion si no hay planetas
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestconsultaLimitsUsuari(Galaxia g) 
    {
    	try {
	    	List<Pair<Integer, Integer> > lp = g.consultarValorLimits(); // no saca excepcion
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
            System.out.println("Coordenadas leidas");
            g.modificarLimitsUsuari(pa1); // saca execpcion si es menor que 4
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void TestconsultarIDplaneta(Galaxia g, Scanner cin)
    {
    	try {
    		System.out.println("Introduce primera coordenada");
    		int x = cin.nextInt();
    		System.out.println("Introduce segunda coordenada");
    		int y = cin.nextInt();
    		System.out.println(g.consultarIDplaneta(x, y)); // saca execpcion si coordenadas mayores que limite o no hay ningun planeta alli
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
    }
}

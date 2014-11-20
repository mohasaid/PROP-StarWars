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
	            
				+ "- Opcion 8: modificarNom(String nomNou)                                                  \n"
				+ "- Opcion 9: modificarLimit(int limitNou)                                                 \n"
				+ "- Opcion 10: modificarLimits(List<Pair<Integer, Integer> > lp)                           \n"
				
				+ "- Opcion 11: existeixPlaneta(idPlaneta)                                                  \n"
				+ "- Opcion 12: existeixPlanetaCoordenades(int x, int y)                                    \n"
				+ "- Opcion 13: modificarCoordenadas(int idPlaneta, int x, int y)							\n"		
				+ "- Opcion 14: algunPlaneta()                                                              \n"
				+ "- Opcion 15: consultaIdplaneta(int x, int y)                                             \n"
				
				+ "- Opcion 16: ConsultarPlaneta(idPlaneta)													\n"	
				
				+ "- Opcion 17: CrearPlaneta(int idPlaneta, int x, int y)                                   \n"
				+ "- Opcion 18: CrearPlanetaAutomatic(int idPlaneta)                                        \n"
				+ "- Opcion 19: CrearPlanetaIDAutomatic(int idP)                                            \n"
				+ "- Opcion 20: eliminarPlaneta(int idPlaneta)                                              \n"
				+ "- Opcion 21: eliminarPlanetes()                                                          \n"
				
				+ "/*- Opcion 22: carregarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorNave cn,"
				+ " ControladorRuta cr)*/                                                                     \n"
				+ "- Opcion 23: guardarConjuntGalaxia(String directori, ControladorPlaneta cp, ControladorRuta cr,"
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
    	  	
    	  	case 11: TestexisteixPlaneta(cin,cGalaxia); break; 
    	  	case 12: TestexisteixPlanetaCoordenades(cin,cGalaxia); break;
    	  	case 13: TestmodificarCoordenadas(cin, cp, cGalaxia); break;
    	  	case 14: TestAlgunPlaneta(cGalaxia); break; 
    	  	case 15: TestconsultaIDplaneta(cin,cGalaxia); break; 
    	  	
    	  	case 16: TestConsultarPlaneta(cin,cp,cGalaxia); break;
    	  	
    	  	case 17: TestafegirPlaneta(cp,cin,cGalaxia); break; 
    	  	case 18: TestafegirPlanetaAutomatic(cp,cin,cGalaxia); break; 
    	  	case 19: TestAfegirPlanetaNIDAuto(cp,cGalaxia); break; 
    	  	case 20: TesteliminarPlaneta(cp,cGalaxia,cin); break; 
    	  	case 21: TesteliminarPlanetes(cp,cGalaxia); break; 
    	  	
    	  	/*case 22: TestcarregarConjuntGalaxia(cr,cp,cn,cGalaxia,cin); break;*/
    	  	case 23: TestguardarConjuntGalaxia(cr,cp,cn,cGalaxia,cin); break;
    	  	
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
	            if(pa_f > cGalaxia.consultarLimit() || pa_f < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
	            pa_s = cin.nextInt();
	            if(pa_s > cGalaxia.consultarLimit() || pa_s < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
	            
	            Pair<Integer, Integer> primero = new Pair<Integer,Integer>(pa_f,pa_s);
	            pa1.add(primero);
	            
	            int l1 = cin.nextInt();
	            if(l1 > cGalaxia.consultarLimit() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
	            int l2 = cin.nextInt();
	            if(l2 > cGalaxia.consultarLimit() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
	            
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
	            	if(l1 > cGalaxia.consultarLimit() || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
	                l2 = cin.nextInt();
	                if(l2 > cGalaxia.consultarLimit() || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
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
			if(!cGalaxia.existeixPlaneta(idPlaneta)) throw new Exception("No existe ningun planeta con ese identificador");
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
	
	public void TestmodificarCoordenadas(Scanner cin, ControladorPlaneta cp, ControladorGalaxia cGalaxia)
	{
		try {
			int idPlaneta = cin.nextInt();
			int x = cin.nextInt();
			int y = cin.nextInt();
			cGalaxia.modificarCoordenadas(cp, idPlaneta, x, y);
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
	
	public void TesteliminarPlaneta(ControladorPlaneta cp, ControladorGalaxia cGalaxia, Scanner cin) 
	{
		try {
			int idPlaneta = cin.nextInt();
			cGalaxia.eliminarPlaneta(idPlaneta);
			cp.BorraPla(idPlaneta);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarPlanetes(ControladorPlaneta cp, ControladorGalaxia cGalaxia) 
	{
		try{
	    	cGalaxia.eliminarPlanetes();
	    	cp.BorrarTodos();
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
			cGalaxia.carregarConjuntGalaxia(directori, cp, cn, cr);
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Para no tener que ir a controlador de planeta a crear el planeta y luego volver a galaxia, se le da la posibilidad de crear
 * aqui los planetas.
 */

public class DriverControladorGalaxia {
	private static boolean creado = false;
	
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
	            + "- Opcion 4: consultarLimitsGalaxia()                                                     \n"
	            + "- Opcion 5: consultarLimit()                                                             \n"
	            + "- Opcion 6: dintreLimitUsuari(int x, int y)                                              \n"
	            
				+ "- Opcion 7: modificarNom(String nomNou)                                                  \n"
				+ "- Opcion 8: modificarLimit(int limitNou)                                                 \n"
				+ "- Opcion 9: modificarLimits(List<Pair<Integer, Integer> > lp)                           	\n"
				
				+ "- Opcion 10: existeixPlanetaCoordenades(int x, int y)                                    \n"
				+ "- Opcion 11: modificarCoordenadas(String idPlaneta, int x, int y)						\n"		
				+ "- Opcion 12: algunPlaneta()                                                              \n"
				
				+ "- Opcion 13: ConsultarPlaneta(idPlaneta)													\n"	
				
				+ "- Opcion 14: CrearPlaneta(String idPlaneta, int x, int y)                                \n"
				+ "- Opcion 15: CrearPlanetaAutomatic(String idPlaneta)                                     \n"
				+ "- Opcion 16: CrearPlanetaIDAutomatic(String idP)                                         \n"
				+ "- Opcion 17: eliminarPlaneta(String idPlaneta)                                           \n"
				+ "- Opcion 18: eliminarPlanetes()                                                          \n"
				
				+ "- Opcion 21: carregarConjuntGalaxia(String directori)                                    \n"
				+ "- Opcion 22: guardarConjuntGalaxia(String directori)                                     \n");
      n = cin.nextInt();
      while(n != 0) {
    	  switch(n) {
    	  	
    	  	case 1: TestCrearGalaxia(cin,cGalaxia); break; 
    	  	case 2: TestCrearGalaxia2(cin,cGalaxia); break; 
    	  	
    	  	case 3: TestConsultarNom(cGalaxia); break; 
    	  	case 4: TestConsultarLimitsGalaxia(cGalaxia); break; 
    	  	case 5: TestConsultarLimit(cGalaxia); break; 
    	  	case 6: TestdintreLimitUsuari(cin,cGalaxia); break;  
    	  	
    	  	case 7: TestmodificarNom(cin,cGalaxia); break; 
    	  	case 8: TestmodificarLimit(cin,cGalaxia); break; 
    	  	case 9: TestmodificarLimits(cin,cGalaxia); break;  
    	  	
    	  	case 10: TestexisteixPlanetaCoordenades(cin,cGalaxia); break;
    	  	case 11: TestmodificarCoordenadas(cin, cp, cGalaxia); break;
    	  	case 12: TestAlgunPlaneta(cGalaxia); break; 
    	  	
    	  	case 13: TestConsultarPlaneta(cin,cp,cGalaxia); break;
    	  	
    	  	case 14: TestafegirPlaneta(cp,cin,cGalaxia); break; 
    	  	case 15: TestafegirPlanetaAutomatic(cp,cin,cGalaxia); break; 
    	  	case 16: TestAfegirPlanetaNIDAuto(cp,cGalaxia); break; 
    	  	case 17: TesteliminarPlaneta(cp,cGalaxia,cin); break; 
    	  	case 18: TesteliminarPlanetes(cp,cGalaxia); break; 
    	  	
    	  	case 19: TestcarregarConjuntGalaxia(cGalaxia,cp,cin); break;
    	  	case 20: TestguardarConjuntGalaxia(cGalaxia,cin); break;
    	  	
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
			creado = true;
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
            	}
            	else throw new Exception("Las coordenadas no son secuenciales");
            	l1 = cin.nextInt();
            	if(l1 > n1 || l1 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                l2 = cin.nextInt();
                if(l2 > n1 || l2 < 0) throw new Exception("Las coordenadas no pueden ser ni mayores que el limite maximo de la galaxia ni menores que 0");
                if((l1 == limite1 && l2 == limite2)) trobat = true;
            }
			cGalaxia.creaGalaxia2(n,n1,pa1);
			creado = true;
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarNom(ControladorGalaxia cGalaxia) 
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			System.out.println(cGalaxia.consultar_nom());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestdintreLimitUsuari(Scanner cin, ControladorGalaxia cGalaxia) 
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
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
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			System.out.println(cGalaxia.consultarLimit());
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarLimitsGalaxia(ControladorGalaxia cGalaxia) 
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			int n = cGalaxia.consultarNombreLimits();
			int i = 0;
			while(i < n) {
				String res = cGalaxia.consultarLimitsGalaxia(i);
				System.out.print(res);
				i += 100;
			}
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestmodificarNom(Scanner cin, ControladorGalaxia cGalaxia)
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
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
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
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
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
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
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			String idPlaneta = cin.next();
			int coste = cin.nextInt();
			int x = cin.nextInt();
			int y = cin.nextInt();
			Pair<Integer, Integer> co = new Pair<Integer, Integer>(x,y);
			Planeta a = new Planeta(idPlaneta,coste,co);
			cGalaxia.afegirPlaneta(x, y);
			cp.anadirPlaneta(a);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestafegirPlanetaAutomatic(ControladorPlaneta cp, Scanner cin, ControladorGalaxia cGalaxia) 
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			String idPlaneta = cin.next();
			Random rand = new Random();
	    	int coste = rand.nextInt((Integer.MAX_VALUE - 0) + 1); 
	    	
	    	String a11 = cGalaxia.afegirPlanetaAutomatic();
			Scanner sc = new Scanner(a11);
			sc.useDelimiter(",");
			Integer a1 = sc.nextInt();
			Integer a2 = sc.nextInt();
			Pair<Integer, Integer> pa = new Pair<Integer, Integer>(a1,a2);
			Planeta a = new Planeta(idPlaneta, coste, pa);
			
			cp.anadirPlaneta(a);
			sc.close();
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestAfegirPlanetaNIDAuto(ControladorPlaneta cp, ControladorGalaxia cGalaxia) 
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
	        String a11 = cGalaxia.afegirPlanetaAutomatic();
	        Scanner sc = new Scanner(a11);
			sc.useDelimiter(",");
			Integer a1 = sc.nextInt();
			Integer a2 = sc.nextInt();
			Pair<Integer, Integer> pa = new Pair<Integer, Integer>(a1,a2);
	        Planeta p = new Planeta(f, capacidad, pa);
	        
	        cp.anadirPlaneta(p);
	        sc.close();
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarPlaneta(Scanner cin, ControladorPlaneta cp, ControladorGalaxia cGalaxia) 
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			String idPlaneta = cin.next();
			if(!cp.ExistePlaneta(idPlaneta)) throw new Exception("No existe ningun planeta con ese identificador");
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
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
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
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			String idPlaneta = cin.next();
			int x = cin.nextInt();
			int y = cin.nextInt();
			cp.modificar_coordenadas(idPlaneta, x, y, cGalaxia);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestAlgunPlaneta(ControladorGalaxia cGalaxia) 
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			if(cGalaxia.algunPlaneta()) System.out.println("Si que hay algun planeta");
			else System.out.println("No hay ningun planeta");
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarPlaneta(ControladorPlaneta cp, ControladorGalaxia cGalaxia, Scanner cin) 
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			String idPlaneta = cin.next();
			if(!cp.ExistePlaneta(idPlaneta)) throw new Exception("El planeta introducido no existe");
			Planeta a = cp.BuscarPlaneta(idPlaneta);
			cGalaxia.eliminarPlaneta(a.consultar_X(), a.consultar_Y());
			cp.BorraPla(idPlaneta);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TesteliminarPlanetes(ControladorPlaneta cp, ControladorGalaxia cGalaxia) 
	{
		try{
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
	    	cGalaxia.eliminarPlanetes();
	    	cp.BorrarTodos();
    	}
    	catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestcarregarConjuntGalaxia(ControladorGalaxia cGalaxia, ControladorPlaneta cp, Scanner cin)
	{
		try {
			String directori = cin.next();
			cGalaxia.carregarConjuntGalaxia(directori);
			//cp.CargarPlanetas(directori, cGalaxia);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestguardarConjuntGalaxia(ControladorGalaxia cGalaxia, Scanner cin)
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			String directori = cin.next();
			cGalaxia.guardarConjuntGalaxia(directori);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
}

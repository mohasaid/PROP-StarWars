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
	              "---------------------------------------------------------------------------------\n"
	            + "-                               DRIVER CONTROLADOR GALAXIA                      -\n"
	            + "---------------------------------------------------------------------------------\n"
	            + "- Opcion 0: Salir de la gestion del driver                                       \n"
	            
	            + "- Opcion 1: creaGalaxia(String nom,int n)   								   	    \n"      
	            + "- Opcion 2: creaGalaxia2(String nom, int n, List<Pair<Integer, Integer> > l)     \n"
	            
	            + "- Opcion 3: consultar_nom()										   			 	\n"     
	            + "- Opcion 4: consultarLimitsGalaxia()                                             \n"
	            + "- Opcion 5: consultarNombreLimits() 											    \n"	
	            + "- Opcion 6: consultarLimit()                                                     \n"
	            + "- Opcion 7: dintreLimitUsuari(int x, int y)                                      \n"
	            
				+ "- Opcion 8: modificarNom(String nomNou)                                          \n"
				+ "- Opcion 9: modificarLimit(int limitNou)                                         \n"
				+ "- Opcion 10: modificarLimits(List<Pair<Integer, Integer> > lp)                   \n"
				
				+ "- Opcion 11: existeixPlanetaCoordenades(int x, int y)                            \n"
				+ "- Opcion 12: modificarCoordenadas(String idPlaneta, int x, int y)				\n"		
				+ "- Opcion 13: algunPlaneta()                                                      \n"
				
				+ "- Opcion 14: ConsultarPlaneta(idPlaneta)											\n"	
				
				+ "- Opcion 15: CrearPlaneta(String idPlaneta, int capacidad, int x, int y)         \n"
				+ "- Opcion 16: CrearPlanetaAutomatic(String idPlaneta)                             \n"
				+ "- Opcion 17: CrearPlanetaIDAutomatic()                                         	\n"
				+ "- Opcion 18: eliminarPlaneta(String idPlaneta)                                   \n"
				+ "- Opcion 19: eliminarPlanetes()                                                  \n"
				
				+ "- Opcion 20: carregarConjuntGalaxia(String directori)                            \n"
				+ "- Opcion 21: guardarConjuntGalaxia(String directori)                             \n"
				+ "- Opcion 22: transformarGrafo(int idFuncionCoste)  								\n"	
				+ "---------------------------------------------------------------------------------\n");
      n = cin.nextInt();
      while(n != 0) {
    	  switch(n) {
    	  	
    	  	case 1: TestCrearGalaxia(cin,cGalaxia); break; 
    	  	case 2: TestCrearGalaxia2(cin,cGalaxia); break; 
    	  	
    	  	case 3: TestConsultarNom(cGalaxia); break; 
    	  	case 4: TestConsultarLimitsGalaxia(cGalaxia); break;
    	  	case 5: TestConsultarNombreLimits(cGalaxia); break;
    	  	case 6: TestConsultarLimit(cGalaxia); break;
    	  	case 7: TestdintreLimitUsuari(cin,cGalaxia); break;  
    	  	
    	  	case 8: TestmodificarNom(cin,cGalaxia); break; 
    	  	case 9: TestmodificarLimit(cin,cGalaxia); break; 
    	  	case 10: TestmodificarLimits(cin,cGalaxia); break;  
    	  	
    	  	case 11: TestexisteixPlanetaCoordenades(cin,cGalaxia); break;
    	  	case 12: TestmodificarCoordenadas(cin, cp, cGalaxia); break;
    	  	case 13: TestAlgunPlaneta(cGalaxia); break; 
    	  	
    	  	case 14: TestConsultarPlaneta(cin,cp,cGalaxia); break;
    	  	
    	  	case 15: TestafegirPlaneta(cp,cin,cGalaxia); break; 
    	  	case 16: TestafegirPlanetaAutomatic(cp,cin,cGalaxia); break; 
    	  	case 17: TestAfegirPlanetaNIDAuto(cp,cGalaxia); break; 
    	  	case 18: TesteliminarPlaneta(cp,cGalaxia,cin); break; 
    	  	case 19: TesteliminarPlanetes(cp,cGalaxia); break; 
    	  	
    	  	case 20: TestcarregarConjuntGalaxia(cGalaxia,cp,cin); break;
    	  	case 21: TestguardarConjuntGalaxia(cGalaxia,cin); break;
    	  	
    	  	case 22: TestconsultarGrafo(cin,cGalaxia,cr,cp,cn); break;
    	  	
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
			boolean b;
			if(cGalaxia.consultarNombreLimits() > 0) {
				b = cGalaxia.dintreLimitUsuari(x, y);
				if(b) System.out.println("Si que esta dins el limit");
				else System.out.println("No esta dins el limit");
			}
			else {
				if((cGalaxia.consultarLimit() > x && x > 0) && (cGalaxia.consultarLimit() > y && y > 0)) System.out.println("Si que esta dins el limit");
				else System.out.println("No esta dins el limit");
			}
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarNombreLimits(ControladorGalaxia cGalaxia)
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			int p = cGalaxia.consultarNombreLimits();
			System.out.println(p);
		}
		catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public void TestConsultarLimit(ControladorGalaxia cGalaxia) 
	{
		try {
			if(!creado) throw new Exception("Error: todavia no se ha creado ninguna galaxia");
			int p = cGalaxia.consultarLimit();
			System.out.println(p);
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
			if(n > 0) {
				int i = 0;
				while(i < n) {
					String res = cGalaxia.consultarLimitsGalaxia(i);
					Scanner t = new Scanner(res);
					t.useDelimiter("#");
					String info;
					while(t.hasNext()) {
						info = t.next();
						System.out.print("(" + info + ") ");
					}
					i += 100;
					t.close();
				}
			}
			else throw new Exception("La galaxia no tiene forma");
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
			boolean existe = cGalaxia.existeixPlanetaCoordenades(x, y);
			if(existe) System.out.println("Existe un planeta en esas coordenadas");
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
			boolean alguno = cGalaxia.algunPlaneta();
			if(alguno) System.out.println("Si que hay algun planeta");
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
			creado = true;
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
	
	public void TestconsultarGrafo(Scanner cin, ControladorGalaxia cGalaxia, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn)
	{
		try {
			FuncionesCoste fc = null;
			int x = cin.nextInt();
			if(x < 1 || x > 3) throw new Exception("No existe esa funcion de optimizacion");
			if(x == 1) fc = new FuncionFlujo();
			if(x == 2) fc = new FuncionDistancia();
			if(x == 3) fc = new FuncionPrecio();
			Entrada e = cGalaxia.transformaGrafo(cr, cp, cn, fc);
			Grafo g = e.Consultar_grafo();
			for(int i = 0; i < g.sizeGrafo(); ++i) {
				System.out.println("Del vertice " + i + " sale lo siguiente:");
				for(int j = 0; j < g.sizeGrafo(i); ++j) {
					System.out.println("Arista de capacidad = " + g.consultarPrim(i, j).ConsultarCapacidad()
									 + " y con coste = " + g.consultarPrim(i, j).ConsultarCoste()
									 + " hacia el vertice "+ g.consultarSeg(i, j));
				}
			}
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}

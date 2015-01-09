import java.util.*;
 
public class DriverControladorPlaneta {
	
	public void Ejecuta(Scanner sc, ControladorPlaneta cp, ControladorRuta cr, ControladorGalaxia cg) {
        int n;
            System.out.print(
            "----------------------------------------------------------------------------------- \n"
            +   "                    DRIVER CONTROLADOR PLANETA                                     \n"
            +   "-----------------------------------------------------------------------------------\n"
            + "Opciones \n"
            + " 1: Planeta(String id, int k, Pair<Integer,Integer> Coo)\n"
            + " 2: PlanetaAuto()\n"
            + " 3: PlanetaAuto2(String id)\n"
            + " 4: Consultar_Coste(String id)\n"
            + " 5: Consultar_Coordenadas(String id)\n"
            + " 6: consultar_X(String id)\n"
            + " 7: consultar_Y(String id)\n"
            + " 8: Consultar_listaPlanetas()\n"
            + " 9: Modificar_Coste(String id, int k)\n"
            + " 10: modificarCoordenades(String id, int x, int y)\n"
            + " 11: Borrar(String id)\n"
            + " 12: CargarPlanetas()\n"
            + " 13: GuardarPlanetas()\n");
        n = sc.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearPlaneta(sc,cp,cg);break;
                case 2: TestCrearPlanetaAuto(cp, cg);break;
                case 3: TestCrearPlanetaAuto2(sc, cp, cg);break; 
                case 4: TestConsultarCoste(sc, cp);break;
                case 5: TestConsultarCoordenadas(sc, cp);break;
                case 6: TestConsultarCoordenadaX(sc, cp);break;
                case 7: TestConsultarCoordenadaY(sc, cp);break;
                case 8: TestConsultarlistaPlaneta(cp);break;
                case 9: TestModificarCoste(sc, cp);break;
                case 10: TestModificarCoordenadas(sc,cp,cg);break;
                case 11: TestBorrar(sc, cp, cr, cg);break;
                case 12: TestCargar(sc,cp, cg);break;
                case 13: TestGuardar(sc,cp);break;
                default: System.out.println("Opcion incorrecta");
            }
            
            n = sc.nextInt();
        }
    }
	
    public static void TestCrearPlaneta(Scanner sc, ControladorPlaneta cp, ControladorGalaxia cg) {
        try {
            String s;
            String id = sc.next();
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El Coste tiene que ser un entero\n");
            }
            int k = sc.nextInt();
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: La Coordenada X tiene que ser un entero\n");
            }
            int x = sc.nextInt();
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: La Coordenada Y tiene que ser un entero\n");
            }
            int y = sc.nextInt();
            Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(x,y);
            cp.Planeta(id,k,Coo, cg);
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
    public static void TestCrearPlanetaAuto(ControladorPlaneta cp, ControladorGalaxia cg) {
        try{
            cp.PlanetaAuto(cg); 
        }  
        catch (Exception e) {
            System.out.print(e);       
        }
    }
    public static void TestCrearPlanetaAuto2(Scanner sc, ControladorPlaneta cp, ControladorGalaxia cg) {
        try{
            String id = sc.next();
            cp.PlanetaAuto(id,cg);
        }  
        catch (Exception e) {
            System.out.print(e);       
        }
    } 
    public static void TestConsultarCoste(Scanner sc, ControladorPlaneta cp) {
        try {
            String id = sc.next();
            System.out.print("El Coste del Planeta es: " + cp.Consultar_Coste(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadas(Scanner sc, ControladorPlaneta cp) {
        try {
            String id = sc.next();
            Pair<Integer,Integer> Coo = cp.Consultar_Coordenadas(id);
            System.out.print(Coo);     
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadaX(Scanner sc, ControladorPlaneta cp) {
        try {
            String id = sc.next();
            System.out.print("La Coordenada X del Planeta es: " + cp.consultar_X(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadaY(Scanner sc, ControladorPlaneta cp) {
        try {
            String id = sc.next();
            System.out.print("La Coordenada Y del Planeta es: " + cp.consultar_Y(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarlistaPlaneta(ControladorPlaneta cp) {
        try {
        	String lp = cp.Consultar_listaPlanetas();
        	System.out.print(lp);
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestModificarCoste(Scanner sc, ControladorPlaneta cp){
    	try {
    		String s;
    		String id = sc.next();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el Coste de un Planeta tiene es un entero\n");
    		}
    		int k = sc.nextInt();
    		cp.Modificar_Coste(id,k);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestModificarCoordenadas(Scanner sc, ControladorPlaneta cp, ControladorGalaxia cg) {
    	try{
    		String s;
    		String id = sc.next();
    		while(!sc.hasNextInt()){
    			s = sc.nextLine();
    			throw new Exception("Error: La Coordenada X de un Planeta tiene que ser un entero\n");
    		}
    		int x = sc.nextInt();
    		while(!sc.hasNextInt()){
    			s = sc.nextLine();
    			throw new Exception("Error: La Coordenada Y de un Planeta tiene que ser un entero\n");
    		}
    		int y = sc.nextInt();
    		cp.modificar_coordenadas(id, x, y, cg);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestBorrar(Scanner sc, ControladorPlaneta cp, ControladorRuta cr, ControladorGalaxia cg) {
    	try {
    		String s;
    		String id = sc.next();
    		cp.BorraPla(id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestGuardar(Scanner sc, ControladorPlaneta cp){
    	try{
    	String s = sc.next();
    	cp.GuardarPlanetas(s);
    	}
    	   catch (Exception e){
               System.out.print(e);
           }
    }
    public static void TestCargar(Scanner sc, ControladorPlaneta cp, ControladorGalaxia cg){
    	try{
    		String s = sc.next();
    		cp.CargarPlanetas(s,cg);
    	}
    	catch(Exception e){
    		System.out.print(e);
    	}
    }
}

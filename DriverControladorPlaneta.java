import java.util.*;
 
public class DriverControladorPlaneta {
	
	public void Ejecuta(Scanner sc, ControladorPlaneta contp, ControladorRuta contr, ControladorGalaxia cg) {
        int n;
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                    DRIVER CONTROLADOR PLANETA                                     "
            +   "-----------------------------------------------------------------------------------"
            + "Opciones \n"
            + " 1: Planeta(String id, int k, Pair<Integer,Integer> Coo)\n"
            + " 2: PlanetaAuto()\n"
            + " 3: PlanetaAuto2(String id)\n"
            + " 4: Consultar_Coste(String id)\n"
            + " 5: Consultar_Coordenadas(String id)\n"
            + " 6: consultar_X(String id)\n"
            + " 7: consultar_Y(String id)\n"
            + " 8: Consultar_Asignado(String id)\n"
            + " 9: Consultar_listaPlanetas()\n"
            + " 9: Modificar_Coste(String id, int k)\n"
            + " 11: modificarCoordenades(String id, int x, int y)\n"
            + " 12: Modificar_Asignado(String id, boolean A)\n"
            + " 13: Borrar(String id)\n"
            + " 14: CargarPlanetas()\n"
            + " 15: GuardarPlanetas()\n");
        n = sc.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearPlaneta(sc, contp, cg);break;
                case 2: TestCrearPlanetaAuto(sc, contp, cg);break;
                case 3: TestCrearPlanetaAuto2(sc, contp, cg);break; 
                case 4: TestConsultarCoste(sc, contp);break;
                case 5: TestConsultarCoordenadas(sc, contp);break;
                case 6: TestConsultarCoordenadaX(sc, contp);break;
                case 7: TestConsultarCoordenadaY(sc, contp);break;
                case 8: TestConsultarAsignado(sc,contp);break;
                case 9: TestConsultarlistaPlaneta(contp);break;
                case 10: TestModificarCoste(sc, contp);break;
                case 11: TestModificarCoordenadas(sc,contp,cg);break;
                case 12: TestModificarAsignado(sc,contp,cg);break;
                case 13: TestBorrar(sc, contp, contr, cg);break;
                case 14: TestCargar(sc,contp, cg);break;
                case 15: TestGuardar(sc,contp);break;
                default: System.out.println("Opcion incorrecta");
            }
            
            n = sc.nextInt();
        }
    }
    public static void TestCrearPlaneta(Scanner sc, ControladorPlaneta contp, ControladorGalaxia cg) {
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
            contp.Planeta(id,k,Coo);
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
    public static void TestCrearPlanetaAuto(Scanner sc, ControladorPlaneta contp, ControladorGalaxia cg) {
        try{
            contp.PlanetaAuto(cg);       
        }  
        catch (Exception e) {
            System.out.print(e);       
        }
    }
    public static void TestCrearPlanetaAuto2(Scanner sc, ControladorPlaneta contp, ControladorGalaxia cg) {
        try{
            String id = sc.next();
            contp.PlanetaAuto(id,cg);       
        }  
        catch (Exception e) {
            System.out.print(e);       
        }
    } 
    public static void TestConsultarCoste(Scanner sc, ControladorPlaneta contp) {
        try {
            String id = sc.next();
            System.out.print("El Coste del Planeta es: " + contp.Consultar_Coste(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadas(Scanner sc, ControladorPlaneta contp) {
        try {
            String id = sc.next();
            Pair<Integer,Integer> Coo = contp.Consultar_Coordenadas(id);
            System.out.print(Coo);     
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadaX(Scanner sc, ControladorPlaneta contp) {
        try {
            String id = sc.next();
            System.out.print("La Coordenada X del Planeta es: " + contp.consultar_X(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadaY(Scanner sc, ControladorPlaneta contp) {
        try {
            String id = sc.next();
            System.out.print("La Coordenada Y del Planeta es: " + contp.consultar_Y(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarAsignado(Scanner sc, ControladorPlaneta contp) {
    	try {
    		String id = sc.next();
    		if(contp.Consultar_Asiganado(id)) System.out.print("El Planeta esta Asignado");
    		else System.out.print("El Planeta NO esta asignado");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestConsultarlistaPlaneta(ControladorPlaneta contp) {
        try {
        	String lp = contp.Consultar_listaPlanetas();
        	System.out.print(lp);
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestModificarCoste(Scanner sc, ControladorPlaneta contp){
    	try {
    		String s;
    		String id = sc.next();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el Coste de un Planeta tiene es un entero\n");
    		}
    		int k = sc.nextInt();
    		contp.Modificar_Coste(id,k);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestModificarCoordenadas(Scanner sc, ControladorPlaneta contp, ControladorGalaxia cg) {
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
    		contp.modificar_coordenadas(id, x, y, cg);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestModificarAsignado(Scanner sc, ControladorPlaneta contp, ControladorGalaxia cg) {
    	try{
    		String s;
    		String id = sc.next();
    		while(!sc.hasNextBoolean()) {
    			s = sc.nextLine();
    			throw new Exception("Error: Para indicar si un Planeta esta asignado o no a la Galaxia se utiliza un boolean\n");
    		}
    		boolean A = sc.nextBoolean();
    		contp.Modificar_Asignado(id, A, cg);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestBorrar(Scanner sc, ControladorPlaneta contp, ControladorRuta contr, ControladorGalaxia cg) {
    	try {
    		String s;
    		String id = sc.next();
    		contp.Borrar(id, contr, cg);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestGuardar(Scanner sc, ControladorPlaneta contp){
    	try{
    	String s = sc.next();
    	contp.GuardarPlanetas(s);
    	}
    	   catch (Exception e){
               System.out.print(e);
           }
    }
    public static void TestCargar(Scanner sc, ControladorPlaneta contp, ControladorGalaxia cg){
    	try{
    		String s = sc.next();
    		contp.CargarPlanetas(s,cg);
    	}
    	catch(Exception e){
    		System.out.print(e);
    	}
    }
}

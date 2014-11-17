import java.util.*;
 
public class DriverControladorPlaneta {
	private ControladorPlaneta contp;
    public void Ejecuta(ControladorRuta contr, ControladorGalaxia cg) {
        Scanner sc = new Scanner(System.in);
        contp = new ControladorPlaneta();
        int n;
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                    DRIVER CONTROLADOR PLANETA                                     "
            +   "-----------------------------------------------------------------------------------"
            + "Opciones \n"
            + " 1: Planeta(int id, int k, Pair<Integer,Integer> Coo)\n"
            + " 2: PlanetaAuto()\n"
            + " 3: PlanetaAuto2(int id)\n"
            + " 4: Consultar_Coste(int id)\n"
            + " 5: Consultar_Coordenadas(int id)\n"
            + " 6: consultar_X(int id)\n"
            + " 7: consultar_Y(int id)\n"
            + " 8: consultarRutasConecta(int id)\n"
            + " 9: Consultar_listaPlanetas()\n"
            + " 10: Modificar_Coste(int id, int k)\n"
            + " 11: modificarCoordenades(int id, int x, int y)\n"
            + " 12: Borrar(Planeta p)\n"
            + " 13: CargarPlanetas()\n"
            + " 14: GuardarPlanetas()\n");
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
                case 8: TestConsultarRutasConecta(sc, contp, contr);break;
                case 9: TestConsultarlistaPlaneta(contp);break;
                case 10: TestModificarCoste(sc, contp);break;
                case 11: TestBorrar(sc, contp, contr, cg);break;
                case 12: TestCargar(sc,contp, cg);break;
                case 13: TestGuardar(sc,contp);break;
            }
            n = sc.nextInt();
        }
    }
    public static void TestCrearPlaneta(Scanner sc, ControladorPlaneta contp, ControladorGalaxia cg) {
        try {
            String s;
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identifcador del Planeta debe ser un entero\n");
            }
            int id = sc.nextInt();
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
            contp.Planeta(id,k,Coo, cg);
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
        	String s;
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identifcador del Planeta debe ser un entero\n");
            }
            int id = sc.nextInt();
            contp.PlanetaAuto(id,cg);       
        }  
        catch (Exception e) {
            System.out.print(e);       
        }
    } 
    public static void TestConsultarCoste(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            System.out.print("El Coste del Planeta es: " + contp.Consultar_Coste(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadas(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            Pair<Integer,Integer> Coo = contp.Consultar_Coordenadas(id);
            System.out.print(Coo);     
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadaX(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            System.out.print("La Coordenada X del Planeta es: " + contp.consultar_X(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarCoordenadaY(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            System.out.print("La Coordenada Y del Planeta es: " + contp.consultar_Y(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarRutasConecta(Scanner sc, ControladorPlaneta contp, ControladorRuta cr) {
        try {
        	String s;
        	while (!sc.hasNextInt()) {
        		s = sc.nextLine();
        		throw new Exception ("Error: El identificador de un Planeta es un entero\n");
        	}
        	int id = sc.nextInt();
        	contp.consultarRutasConecta(id,cr);
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
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero\n");
    		}
    		int id = sc.nextInt();
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
    public static void TestBorrar(Scanner sc, ControladorPlaneta contp, ControladorRuta contr, ControladorGalaxia cg) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero\n");
    		}
    		int id = sc.nextInt();
    		contp.Borrar(id, contr);
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

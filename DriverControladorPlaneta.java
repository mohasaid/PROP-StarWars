import java.util.*;
 
public class DriverControladorPlaneta {
	private ControladorPlaneta contp;
    public void Ejecuta(ControladorRuta contr) {
        Scanner sc = new Scanner(System.in);
        contp = new ControladorPlaneta();
        int n;
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                    DRIVER CONTROLADOR PLANETA                                     "
            +   "-----------------------------------------------------------------------------------"
            + "Opciones \n"
            + " 1: Planeta(int id, int k, Pair<Integer,Integer> Coo, boolean F, boolean S)\n"
            + " 2: PlanetaAuto()\n"
            + " 3: PlanetaAuto2(int id)\n"
            + " 4: Consultar_Capacidad(int id)\n"
            + " 5: Consultar_Coste(int id)\n"
            + " 6: Consultar_Coordenadas(int id)\n"
            + " 7: consultar_X(int id)\n"
            + " 8: consultar_Y(int id)\n"
            + " 9: consultarRutasConecta(int id)\n"
            + " 10: Consultar_listaPlanetas()\n"
            + " 11: Modificar_id(int idold, int idnew)\n"
            + " 12: Modificar_Coste(int id, int k)\n"
            + " 13: modificarCoordenades(int id, int x, int y)\n"
            + " 14: Borrar(Planeta p)\n"
            + " 15: CargarPlanetas()\n"
            + " 16: GuardarPlanetas()\n");
        n = sc.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearPlaneta(sc, contp);break;
                case 2: TestCrearPlanetaAuto(sc, contp);break;
                case 3: TestCrearPlanetaAuto2(sc, contp);break; 
                case 4: TestConsultarCapacidad(sc, contp);break;
                case 5: TestConsultarCoste(sc, contp);break;
                case 6: TestConsultarCoordenadas(sc, contp);break;
                case 7: TestConsultarCoordenadaX(sc, contp);break;
                case 8: TestConsultarCoordenadaY(sc, contp);break;
                case 9: TestConsultarRutasConecta(sc, contp);break;
                case 10: TestConsultarlistaPlaneta(contp);break;
                case 11: TestModificarId(sc, contp);break;
                case 12: TestModificarCoste(sc, contp);break;
                case 13: TestModificarCoordenadas(sc, contp);break;
                case 14: TestBorrar(sc, contp, contr);break;
                case 15: TestCargar(sc,contp);break;
                case 16: TestGuardar(sc,contp);break;
            }
            n = sc.nextInt();
        }
    }
    public static void TestCrearPlaneta(Scanner sc, ControladorPlaneta contp) {
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
            contp.Planeta(id,k,Coo);
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
    public static void TestCrearPlanetaAuto(Scanner sc, ControladorPlaneta contp) {
        try{
            contp.PlanetaAuto();       
        }  
        catch (Exception e) {
            System.out.print(e);       
        }
    }
    public static void TestCrearPlanetaAuto2(Scanner sc, ControladorPlaneta contp) {
        try{
        	String s;
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identifcador del Planeta debe ser un entero\n");
            }
            int id = sc.nextInt();
            contp.PlanetaAuto(id);       
        }  
        catch (Exception e) {
            System.out.print(e);       
        }
    } 
    public static void TestConsultarCapacidad(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            System.out.print("La Capacidad del Planeta es: " + contp.Consultar_Capacidad(id) + "\n");    
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
    public static void TestConsultarRutasConecta(Scanner sc, ControladorPlaneta contp) {
        try {
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarlistaPlaneta(ControladorPlaneta contp) {
        try {
        	ArrayList<String> lp = contp.Consultar_listaPlanetas();
        	System.out.print(lp);
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestModificarId(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int idact = sc.nextInt();
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta tiene que ser un entero\n");
            }
            int idnew = sc.nextInt();
            contp.Modificar_id(idact,idnew);
        }
        catch (Exception e){
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
    public static void TestModificarCoordenadas(Scanner sc, ControladorPlaneta contp){
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero\n");
    		}
    		int id = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: la coordenada X de un Planeta tiene que ser un entero\n");
    		}
    		int x = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: la coordenada Y de un Planeta tiene que ser un entero\n");
    		}
    		int y = sc.nextInt();
    		contp.modificarCoordenades(id,x,y);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestBorrar(Scanner sc, ControladorPlaneta contp, ControladorRuta contr) {
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
    public static void TestCargar(Scanner sc, ControladorPlaneta contp){
    	try{
    		String s = sc.next();
    		contp.CargarPlanetas(s);
    	}
    	catch(Exception e){
    		System.out.print(e);
    	}
    }
}

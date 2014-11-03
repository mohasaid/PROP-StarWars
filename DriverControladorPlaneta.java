import java.util.*;
 
public class DriverControladorPlaneta {
    public void Ejecuta(ControladorPlaneta contp) {
        Scanner sc = new Scanner(System.in);
        int n;
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                    DRIVER CONTROLADOR PLANETA                                     "
            +   "-----------------------------------------------------------------------------------"
            + "Opciones \n"
            + " 1: Crear Planeta -> public void Planeta(int id, int k, Pair<Integer,Integer> Coo)\n"
            + " 2: Crear Planeta Automatico -> public void PlanetaAuto()\n"         
            + " 3: Consultar id -> public int Consultar_id(int id)\n"
            + " 4: Consultar Capacidad -> public int Consultar_Capacidad(int id)\n"
            + " 5: Consultar Coste -> public int Consultar_Coste(int id)\n"
            + " 6: Consultar Coordenadas -> public Pair<Integer,Integer> Consultar_Coordenadas(int id)\n"
            + " 7: Consultar Coordenada X -> public int consultar_X(int id)\n"
            + " 8: Consultar Coordenada Y -> public int consultar_Y(int id)\n"
            + " 9: Consultar las Rutas que entrar y salen del Planeta -> public TreeSet<Integer> consultarRutasConecta(int id)\n"
            + " 10: Consultar las Rutas que salen del Planeta -> public TreeSet<Integer> Consultar_RutasSalida(int id)\n"
            + " 11: Consultar las Rutas que etran al Planeta -> public TreeSet<Integer> Consultar_RutasEntrada(int id)\n"
            + " 12: Consultar las Naves que estan en el Planeta -> public TreeSet<Integer> Consultar_LNaves(int id)\n"
            + " 13: Modificar id -> public void Modificar_id(Planeta p, int id)\n"
            + " 14: Modificar Capacidad -> public void Modificar_Capacidad(Planeta p, int c)\n"
            + " 15: Modificar Coste -> public void Modificar_Coste(Planeta p, int k)\n"
            + " 16: Modificar Coordenadas -> public void modificarCoordenades(Planeta p, int x, int y)\n"
            + " 17: Añadir una Ruta que sale del Planeta -> public void Anadir_Salida(Planeta p, int id)\n"
            + " 18: Añadir una Ruta que entra al Planeta -> public void Anadir_Salida(Planeta p, int id)\n"
            + " 19: Borrar una Ruta que sale del Planeta -> public void Borrar_Salida(Planeta p, int id)\n"
            + " 20: Borrar una Ruta que entra al Planeta -> public void Borrar_Entrada(Planeta p, int id)\n"
            + " 21: Borrar el Planeta -> public void Borrar(Planeta p)");
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearPlaneta(sc, contp);break;
                case 2: TestCrearPlanetaAutor(sc, contp);break;            
                case 3: TestConsultarId(sc, contp);break;
                case 4: TestConsultarCapacidad(sc, contp);break;
                case 5: TestConsultarCoste(sc, contp);break;
                case 6: TestConsultarCoordenadas(sc, contp);break;
                case 7: TestConsultarCoordenadaX(sc, contp);break;
                case 8: TestConsultarCoordenadaY(sc, contp);break;
                case 9: TestConsultarRutasConecta(sc, contp);break;
                case 10: TestConsultarRutasSalida(sc, contp);break;
                case 11: TestConsultarRutasEntrada(sc, contp);break;
                case 12: TestConsultarLNaves(sc, contp);break;
                case 13: TestModificarId(sc, contp);break;
                case 14: TestModificarCapacidad(sc, contp);break;
                case 15: TestModificarCoste(sc, contp);break;
                case 16: TestModificarCoordenadas(sc, contp);break;
                case 17: TestAnadirSalida(sc, contp);break;
                case 18: TestAnadirEntrada(sc, contp);break;
                case 19: TestBorrarSalida(sc, contp);break;
                case 20: TestBorrarEntrada(sc, contp);break;
                case 21: TestBorrar(sc, contp);break;
            }
            n = sc.nextInt();
    }
    public static void TestCrearPlaneta(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identifcador del Planeta debe ser un entero\n")
            }
            int id = sc.nextInt();
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El Coste tiene que ser un entero\n")
            }
            int k = sc.nextInt();
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: La Coordenada X tiene que ser un entero\n")
            }
            int x = sc.nextInt();
            while(!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: La Coordenada Y tiene que ser un entero\n")
            }
            int y = sc.nextInt();
            Pair<Integer,Integer> Coo;
            Coo.setFirst(x);
            Coo.setSecond(y);
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
    /*public static void TestConsultarId(Scanner sc, ControladorPlaneta contp) {
        try {
             
        }
    }*/
    public static void TestConsultarCapacidad(Scanner sc, ContrladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            System.out.print(contp.Consultar_Capacidad(id) + "\n");    
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
            System.out.print(contp.Consultar_Coste(id) + "\n");    
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
            Pair<Integer,Integer> Coor = contp.Consultar_Coordenadas(id);
            System.out.print(Coo.getFirst() + "   " + Coo.getSecond() + "\n");     
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
            System.out.print(contp.consultar_X(id) + "\n");    
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
            System.out.print(contp.consultar_Y(id) + "\n");    
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarRutasConecta(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            TreeSet<Integer> rutas = contp.consultarRutasConecta(id);
            Iterator<Integer> it = rutas.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());           
            }
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarRutasSalida(Scanner sc, ControladrPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            TreeSet<Integer> rutas = contp.Consultar_RutasSalida(id);
            Iterator<Integer> it = rutas.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());           
            }
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarRutasEntrada(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            TreeSet<Integer> rutas = contp.Consultar_RutasEntrada(id);
            Iterator<Integer> it = rutas.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());           
            }
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarLNaves(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            TreeSet<Integer> naves = contp.Consultar_LNaves(id);
            Iterator<Integer> it = naves.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());           
            }
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestModificarId(Scanner sc, ControladrPlaneta contp) {
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
            cont
        }
}

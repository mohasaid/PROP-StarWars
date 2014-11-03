import java.util.Scanner;
 
public class DriverPlaneta {
    public void Ejecuta() {
        Scanner sc = new Scanner(System.in);
        int n;
        Planeta p = new Planeta();
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                    DRIVER CONTROLADOR PLANETA                                     "
            +   "-----------------------------------------------------------------------------------"
            + "Opciones \n"
            + " 1: Crear Planeta -> public void Planeta(int id, int k, Pair<Integer,Integer> Coo)\n"
            + " 2: Consultar id -> public int Consultar_id()\n"
            + " 3: Consultar Capacidad -> public int Consultar_Capacidad()\n"
            + " 4: Consultar Coste -> public int Consultar_Coste()\n"
            + " 5: Consultar Coordenadas -> public Pair<Integer,Integer> Consultar_Coordenadas()\n"
            + " 6: Consultar Coordenada X -> public int consultar_X(Planeta p)\n"
            + " 7: Consultar Coordenada Y -> public int consultar_Y(Planeta p)\n"
            + " 8: Consultar las Rutas que entrar y salen del Planeta -> public TreeSet<Integer> consultarRutasConecta()\n"
            + " 9: Consultar las Rutas que salen del Planeta -> public TreeSet<Integer> Consultar_RutasSalida()\n"
            + " 10: Consultar las Rutas que etran al Planeta -> public TreeSet<Integer> Consultar_RutasEntrada()\n"
            + " 11: Consultar las Naves que estan en el Planeta -> public TreeSet<Integer> Consultar_LNaves()\n"
            + " 12: Modificar id -> public void Modificar_id(int id)\n"
            + " 13: Modificar Capacidad -> public void Modificar_Capacidad(int c)\n"
            + " 14: Modificar Coste -> public void Modificar_Coste(int k)\n"
            + " 15: Modificar Coordenadas -> public void modificarCoordenades(int x, int y)\n"
            + " 16: Añadir una Ruta que sale del Planeta -> public void Anadir_Salida(int id)\n"
            + " 17: Añadir una Ruta que entra al Planeta -> public void Anadir_Salida(int id)\n"
            + " 18: Borrar una Ruta que sale del Planeta -> public void Borrar_Salida(int id)\n"
            + " 19: Borrar una Ruta que entra al Planeta -> public void Borrar_Entrada(int id)\n"
            + " 20: Borrar el Planeta -> public void Borrar()");
        n = cin.nextInt();
        while(n != 0) {
            switch(n) ´
                case 1: TestCrearP(sc);break;
                case 2: TestCId(p);break;
                case 3: TestCCapacidad(p);break;
                case 4: TestCCoste(p);break;
                case 5: TestCCoordenadas(p);break;
                case 6: TestCCoordenadaX(p);break;
                case 7: TestCCoordenadaY(p);break;
                case 8: TestCRutasConecta(p);break;
                case 9: TestCRutasSalida(p);break;
                case 10: TestCRutasEntrada(sc, contp);break;
                case 11: TestCLNaves(p);break;
                case 12: TestMId(p);break;
                case 13: TestMCapacidad(p);break;
                case 14: TestMCoste(p);break;
                case 15: TestMCoordenadas(p);break;
                case 16: TestASalida(p);break;
                case 17: TestAEntrada(p);break;
                case 18: TestBSalida(p);break;
                case 19: TestBEntrada(p);break;
                case 20: TestB(p);break;
            }
            n = sc.nextInt();
    }
}

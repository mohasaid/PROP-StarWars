import java.util.Scanner;

// Se pone como ejemplo el pair de tipo integer, integer

public class DriverPair {
    private Pair<Integer, Integer> p;

    public void Executa(Scanner sc) {
        int op;
        System.out.print(
                "------------------------------------------------\n"
                        + "                  DRIVER PAIR     	       -\n"
                        + "------------------------------------------------\n"
                        + "- Opcion 0: Salir de la gestion del driver      \n"
                        + "- Opcion 1: Pair(int a, int b)				  \n"
                        + "- Opcion 2: ponPrimero(int elemento) 			  \n"
                        + "- Opcion 3: ponSegundo(int elemento) 			  \n"
                        + "- Opcion 4: consultaPrimero()  				  \n"
                        + "- Opcion 5: consultaSegundo() 				  \n"
                        + "- Opcion 6: toString()						  \n"
                        + "------------------------------------------------\n");
        op = sc.nextInt();
        while (op != 0) {
            switch (op) {
                case 1:
                    TestCreaPair(sc);
                    break;
                case 2:
                    TestponPrimero(sc);
                    break;
                case 3:
                    TestponSegundo(sc);
                    break;
                case 4:
                    TestconsultaPrimero();
                    break;
                case 5:
                    TestconsultaSegundo();
                    break;
                case 6:
                    TestConsultaPintar();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
            op = sc.nextInt();
        }
    }

    public void TestCreaPair(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        p = new Pair<Integer, Integer>(a, b);
    }

    public void TestponPrimero(Scanner sc) {
        int elemento = sc.nextInt();
        p.ponPrimero(elemento);
    }

    public void TestponSegundo(Scanner sc) {
        int elemento = sc.nextInt();
        p.ponSegundo(elemento);
    }

    public void TestconsultaPrimero() {
        System.out.println(p.consultarPrimero());
    }

    public void TestconsultaSegundo() {
        System.out.println(p.consultarSegundo());
    }

    public void TestConsultaPintar() {
        System.out.println(p.toString());
    }
}	

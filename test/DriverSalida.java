public class DriverSalida {
    private static Salida s;
    private static Entrada e;

    public void Executa(Scanner sc, ControladorRuta cr, ControladorGalaxia cg) {
        int op;


        System.out.print("Opciones: \n\n"
                + "--------------------------------------------------------------------\n"
                + "-                    OPCIONES                                      -\n"
                + "-           [opcion   Operacion(Atributos)                         -\n"
                + "--------------------------------------------------------------------\n"
                + "-                                                                  -\n"
                + "-   0   Salir del DriverSalida                                     -\n"
                + "-   1   TestConsultarCuellos()                                     -\n"
                + "-   2   TestConsultarCaminos()                                     -\n"
                + "-   3   TestconsultarCambios()                                     -\n"
                + "-   4   TestAnadirCuellos(int idRuta)                              -\n"
                + "-   5   TestAnadirCamino(String s)                                 -\n"
                + "-   6   TestAnadirCambio(String cambio)                            -\n"
                + "-   7   TestEliminarCuellos()                                      -\n"
                + "-   8   TestEliminarCaminos()                                      -\n"
                + "-   9   TestEliminarCambios()                                      -\n"
                + "-                                                                  -\n"
                + "--------------------------------------------------------------------\n");

        op = sc.nextInt();

        while (op != 0) {
            switch (op) {
                case 1:
                    TestConsultarCuellos();
                    break;
                case 2:
                    TestConsultarCaminos();
                    break;
                case 3:
                    TestConsultarCambios();
                    break;
                case 4:
                    TestAnadirCuello(sc);
                    break;
                case 5:
                    TestAnadirCamino(sc);
                    break;
                case 6:
                    TestAnadirCambio(sc);
                    break;
                case 7:
                    TestEliminarCuellos();
                    break;
                case 8:
                    TestEliminarCambios();
                    break;
                case 9:
                    TestEliminarCambios();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
            op = sc.nextInt();
        }
    }

    public static void TestConsultarCuellos() {
        try {
            ArrayList<Integer> C = s.ConsultarCuellos();
            Iterator<Integer> it = C.iterator();
            if (it.hasNext()) System.out.print(it.next());
            while (it.hasNext()) {
                System.out.print("," + it.next());
            }
            System.out.print("\n");
        } catch (Exception e) {
            System.out.print(e);
        }

    }

    public static void TestConsultarCaminos() {
        try {
            ArrayList<String> C = s.ConsultarCaminos();
            Iterator<String> it = C.iterator();
            while (it.hasNext()) {
                String aux = it.next();
                System.out.println(aux);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void TestConsultarCambios() {
        try {
            ArrayList<String> Cambio = s.ConsultarCambios();
            Iterator<String> it = Cambio.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void TestAnadirCuello(Scanner sc) {
        try {
            while (!sc.hasNextInt()) {
                String s = sc.nextLine();
                throw new Exception("Error: El identificador debe ser un entero\n");
            }
            int id = sc.nextInt();
            s.AnadirCuello(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void TestAnadirCamino(Scanner sc) {
        try {
            String st = sc.next();
            s.AnadirCamino(st);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void TestAnadirCambio(Scanner sc) {
        try {
            String st = sc.next();
            s.AnadirCambio(st);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void TestEliminarCuellos() {
        try {
            s.EliminarCuellos();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void TestEliminarCaminos() {
        try {
            s.EliminarCaminos();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void TestEliminarCambios() {
        try {
            s.EliminarCambios();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
    
  

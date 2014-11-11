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
            + " 1: Crear Planeta -> public void Planeta(int id, int k, Pair<Integer,Integer> Coo, bool F, bool S)\n"
            + " 2: Consultar id -> public int Consultar_id()\n"
            + " 3: Consultar Capacidad -> public int Consultar_Capacidad()\n"
            + " 4: Consultar Coste -> public int Consultar_Coste()\n"
            + " 5: Consultar Fuente -> public boolean Consultar_Fuente()\n"
            + " 6: Consultar Sumidero -> public boolean Consultar_Sumidero()\n"
            + " 7: Consultar Coordenadas -> public Pair<Integer,Integer> Consultar_Coordenadas()\n"
            + " 8: Consultar Coordenada X -> public int consultar_X(Planeta p)\n"
            + " 9: Consultar Coordenada Y -> public int consultar_Y(Planeta p)\n"
            + " 10: Consultar las Rutas que entrar y salen del Planeta -> public TreeSet<Integer> consultarRutasConecta()\n"
            + " 11: Consultar las Rutas que salen del Planeta -> public TreeSet<Integer> Consultar_RutasSalida()\n"
            + " 12: Consultar las Rutas que etran al Planeta -> public TreeSet<Integer> Consultar_RutasEntrada()\n"
            + " 13: Consultar las Naves que estan en el Planeta -> public TreeSet<Integer> Consultar_LNaves()\n"
            + " 14: Modificar id -> public void Modificar_id(int id)\n"
            + " 15: Modificar Capacidad -> public void Modificar_Capacidad(int c)\n"
            + " 16: Modificar Coste -> public void Modificar_Coste(int k)\n"
            + " 17: Modificar Coordenadas -> public void modificarCoordenades(int x, int y)\n"
            + " 18: Anadir una Ruta que sale del Planeta -> public void Anadir_Salida(int id)\n"
            + " 19: Anadir una Ruta que entra al Planeta -> public void Anadir_Salida(int id)\n"
            + " 20: Anadir una Nave que esta en el Planeta -> public void ANadir_Nave(int id)\n"
            + " 21: Borrar una Ruta que sale del Planeta -> public void Borrar_Salida(int id)\n"
            + " 22: Borrar una Ruta que entra al Planeta -> public void Borrar_Entrada(int id)\n"
            + " 23: Borrar una Nave que esta en el Planeta -> public void Borrar_Nave(int id)\n"
            + " 24: Borrar el Planeta -> public void Borrar()");
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearP(sc, p);break;
                case 2: TestCId(p);break;
                case 3: TestCCapacidad(p);break;
                case 4: TestCCoste(p);break;
                case 5: TestCFuente(p);break;
                case 6: TestCSumiedor(p);break;
                case 7: TestCCoordenadas(p);break;
                case 8: TestCCoordenadaX(p);break;
                case 9: TestCCoordenadaY(p);break;
                case 10: TestCRutasConecta(p);break;
                case 11: TestCRutasSalida(p);break;
                case 12: TestCRutasEntrada(p);break;
                case 13: TestCLNaves(p);break;
                case 14: TestMId(sc, p);break;
                case 15: TestMCapacidad(sc,p);break;
                case 16: TestMCoste(sc, p);break;
                case 17: TestMCoordenadas(sc, p);break;
                case 18: TestASalida(sc, p);break;
                case 19: TestAEntrada(sc, p);break;
                case 20: TestANave(sc, p);break;
                case 21: TestBSalida(sc, p);break;
                case 22: TestBEntrada(sc, p);break;
                case 23: TestBNave(sc, p);break;
                case 24: TestB(p);break;
            }
            n = sc.nextInt();
        }
    }
    public static void TestCrearP(Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()){
    			s = sc.nextLine();
    			throw new Exception ("Error: El identificador de un Planeta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		while(!sc.hasNextInt()){
    			s = sc.nextLine();
    			throw new Exception ("Error: El Coste de un Planeta tiene que ser un entero\n");
    		}
    		int k = sc.nextInt();
    		while(!sc.hasNextInt()){
    			s = sc.nextLine();
    			throw new Exception("Error: La Coordenada X tiene que ser un entero\n");
    		}
    		int x = sc.nextInt();
    		while(!sc.hasNextInt()){
    			s = sc.nextLine();
    			throw new Exception("Error: La Coordenada Y tiene que ser un entero\n");
    		}
    		int y = sc.nextInt();
    		Pair<Integer,Integer> Coo;
    		Coo.ponPrimero(x);
    		Coo.ponSegundo(y);
    		while(!sc.hasNextBoolean()) {
    			s = sc.nextLine();
    			throw new Exception("Error: Fuente tiene que ser un booleano\n");
    		}
    		boolean F = sc.nextBoolean();
    		while(!sc.hasNextBoolean()) {
    			s = sc.nextLine();
    			throw new Exception("Error: Sumidero tiene que ser un booleano\n");
    		}
    		boolean S = sc.nextBoolean();
    		p = Planeta(id,k,Coo,F,S);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestCId(Planeta p) {
    	try {
    		int id = p.Consultar_id();
    		System.out.print("El identificador del Planeta es: " + id + "\n");
    	}
    	catch (Excetpion e) {
    		System.out.print(e);
    	}
    }
    public static void TestCCoste(Planeta p) {
    	try {
    		int k = p.Consultar_Coste();
    		System.out.print("El Coste del Planeta es: " + k + "\n");
    	}
    	catch (Excetpion e) {
    		System.out.print(e);
    	}
    }
    public static void TestCCapacidad(Planeta p) {
    	try {
    		int c = p.Consultar_Capacidad();
    		System.out.print("La Capacidad del Planeta es: " + c + "\n");
    	}
    	catch (Excetpion e) {
    		System.out.print(e);
    	}
    }
    public static void TestCFuente(Planeta p) {
    	try {
    		boolean F = p.Consultar_Fuente();
    		if(F) System.out.print("El Planeta es Fuente\n");
    		else System.out.print("El Planeta NO es Fuente\n");
    	}
    	catch (Excetpion e) {
    		System.out.print(e);
    	}
    }
    public static void TestCSumidero(Planeta p) {
    	try {
    		boolean S = p.Consultar_Sumidero();
    		if(S) System.out.print("El Planeta es Sumidero\n");
    		else System.out.print("El Planeta NO es Sumidero\n");
    	}
    	catch (Excetpion e) {
    		System.out.print(e);
    	}
    }
    public static void TestCCoordenadas(Planeta p) {
    	try {
    		Pair<Integer,Integer> Coo= p.Consultar_Coordenadas();
    		System.out.print("X: " + Coo.consultarPrimero() + " Y: " + Coo.consultarSegundo() + "\n");
    	}
    	catch (Excetpion e) {
    		System.out.print(e);
    	}
    }
    public static void TestCCoordenadaX(Planeta p) {
    	try {
    		int x = p.consultar_X();
    		System.out.print("La Coordenada X del Planeta es: " + x + "\n");
    	}
    	catch (Excetpion e) {
    		System.out.print(e);
    	}
    }
    public static void TestCCoordenadaY(Planeta p) {
    	try {
    		int x = p.consultar_X();
    		System.out.print("La Coordenada X del Planeta es: " + x + "\n");
    	}
    	catch (Excetpion e) {
    		System.out.print(e);
    	}
    }
    public static void TestCRutasConecta(Planeta p) {
        try {
            TreeSet<Integer> rutas = p.consultarRutasConecta();
            Iterator<Integer> it = rutas.iterator();
            System.out.print("Las rutas que conectan con el Planeta son: ");
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");           
            }
            System.out.print("\n");
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestCRutasSalida(Planeta p) {
        try {
            TreeSet<Integer> rutas = p.Consultar_Salida();
            Iterator<Integer> it = rutas.iterator();
            System.out.print("Las rutas que salen del Planeta son: ");
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");           
            }
            System.out.print("\n");
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestCRutasEntrada(Planeta p) {
        try {
            TreeSet<Integer> rutas = p.Consultar_Entrada();
            Iterator<Integer> it = rutas.iterator();
            System.out.print("Las rutas que entran en el Planeta son: ");
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");           
            }
            System.out.print("\n");
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestCLNaves(Planeta p) {
        try {
            TreeSet<Integer> naves = p.Consultar_LNaves();
            Iterator<Integer> it = naves.iterator();
            System.out.print("Las naves que estan en el Planeta son: ");
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");           
            }
            System.out.print("\n");
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestMId (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: El identificador de un Planeta tiene que ser un entero\n");
    		}
    		int idnew = s.nextInt();
    		p.Modificar_id(idnew);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestMCapacidad (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: La Capacidad de un Planeta tiene que ser un entero\n");
    		}
    		int cnew = s.nextInt();
    		p.Modificar_id(cnew);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestMCoste (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: El Coste de un Planeta tiene que ser un entero\n");
    		}
    		int knew = s.nextInt();
    		p.Modificar_id(knew);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestMCoordenadas (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: La Coordenada X de un Planeta tiene que ser un entero\n");
    		}
    		int xnew = s.nextInt();
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: La Coordenada Y de un Planeta tiene que ser un entero\n");
    		}
    		int ynew = s.nextInt();
    		p.modificarCoordenadas(xnew,ynew);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestAEntrada (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: El identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Anadir_Entrada(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestASalida (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: El identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Anadir_Salida(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestANave (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: El identificador de una Nave tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Anadir_Nave(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestBEntrada (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: El identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Borrar_Entrada(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestBSalida (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: El identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Borrar_Salida(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestBNave (Scanner sc, Planeta p) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = s.nextLine();
    			throw new Exception ("Error: El identificador de una Nave tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Borrar_Nave(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestB(Planeta p) {
    	try {
    		p.Borrar();
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
}

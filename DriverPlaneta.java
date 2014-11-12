import java.util.*;
 
public class DriverPlaneta {
	private Planeta p;
	
	public void Ejecuta() {
        int n;
        Scanner sc = new Scanner(System.in);
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                    DRIVER CONTROLADOR PLANETA                                     "
            +   "-----------------------------------------------------------------------------------"
            + "Opciones \n"
            + " 1: Planeta(int id, int k, Pair<Integer,Integer> Coo, bool F, bool S)\n"
            + " 2: Consultar_id()\n"
            + " 3: Consultar_Capacidad()\n"
            + " 4: Consultar_Coste()\n"
            + " 5: Consultar_Fuente()\n"
            + " 6: Consultar_Sumidero()\n"
            + " 7: Consultar_Coordenadas()\n"
            + " 8: consultar_X( )\n"
            + " 9: consultar_Y( )\n"
            + " 10: consultarRutasConecta()\n"
            + " 11: Consultar_RutasSalida()\n"
            + " 12: Consultar_RutasEntrada()\n"
            + " 13: Modificar_id(int id)\n"
            + " 14: Modificar_Capacidad(int c)\n"
            + " 15: Modificar_Coste(int k)\n"
            + " 16: modificarCoordenades(int x, int y)\n"
            + " 17: Anadir_Salida(int id)\n"
            + " 18: Anadir_Salida(int id)\n"
            + " 19: Borrar_Salida(int id)\n"
            + " 20: Borrar_Entrada(int id)\n"
            + " 21: Borrar()\n");
        n = sc.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearP(sc);break;
                case 2: TestCId();break;
                case 3: TestCCapacidad();break;
                case 4: TestCCoste();break;
                case 5: TestCFuente();break;
                case 6: TestCSumidero();break;
                case 7: TestCCoordenadas();break;
                case 8: TestCCoordenadaX();break;
                case 9: TestCCoordenadaY();break;
                case 10: TestCRutasConecta();break;
                case 11: TestCRutasSalida();break;
                case 12: TestCRutasEntrada();break;
                case 13: TestMId(sc);break;
                case 14: TestMCapacidad(sc);break;
                case 15: TestMCoste(sc);break;
                case 16: TestMCoordenadas(sc);break;
                case 17: TestASalida(sc);break;
                case 18: TestAEntrada(sc);break;
                case 19: TestBSalida(sc);break;
                case 20: TestBEntrada(sc);break;
                case 21: TestB();break;
            }
            n = sc.nextInt();
        }
    }
    public void TestCrearP(Scanner sc) {
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
    		Pair<Integer,Integer> Coo = new Pair<Integer,Integer>(x,y);
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: Fuente tiene que ser un booleano\n");
    		}
    		int fu = sc.nextInt();
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: Sumidero tiene que ser un booleano\n");
    		}
    		int su = sc.nextInt();
    		boolean F = false;
    		boolean S = false;
    		if(fu == 1) F = true;
    		if(su == 1) S = true; 
    		p = new Planeta(id,k,Coo,F,S);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    
    public void TestCId( ) {
    	try {
    		int id = p.Consultar_id();
    		System.out.print("El identificador del Planeta es: " + id + "\n");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestCCoste( ) {
    	try {
    		int k = p.Consultar_Coste();
    		System.out.print("El Coste del Planeta es: " + k + "\n");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestCCapacidad( ) {
    	try {
    		int c = p.Consultar_Capacidad();
    		System.out.print("La Capacidad del Planeta es: " + c + "\n");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestCFuente( ) {
    	try {
    		boolean F = p.Consultar_Fuente();
    		if(F) System.out.print("El Planeta es Fuente\n");
    		else System.out.print("El Planeta NO es Fuente\n");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestCSumidero( ) {
    	try {
    		boolean S = p.Consultar_Sumidero();
    		if(S) System.out.print("El Planeta es Sumidero\n");
    		else System.out.print("El Planeta NO es Sumidero\n");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestCCoordenadas( ) {
    	try {
    		Pair<Integer,Integer> Coo = p.consultar_coordenades();
    		System.out.println(Coo);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestCCoordenadaX( ) {
    	try {
    		int x = p.consultar_X();
    		System.out.print("La Coordenada X del Planeta es: " + x + "\n");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestCCoordenadaY( ) {
    	try {
    		int x = p.consultar_X();
    		System.out.print("La Coordenada X del Planeta es: " + x + "\n");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestCRutasConecta( ) {
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
    public void TestCRutasSalida( ) {
        try {
            TreeSet<Integer> rutas = p.Consultar_RutasSalida();
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
    public void TestCRutasEntrada( ) {
        try {
            TreeSet<Integer> rutas = p.Consultar_RutasEntrada();
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
    public void TestMId (Scanner sc  ) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: El identificador de un Planeta tiene que ser un entero\n");
    		}
    		int idnew = sc.nextInt();
    		p.Modificar_id(idnew);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestMCapacidad (Scanner sc  ) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: La Capacidad de un Planeta tiene que ser un entero\n");
    		}
    		int cnew = sc.nextInt();
    		p.Modificar_id(cnew);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestMCoste (Scanner sc  ) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: El Coste de un Planeta tiene que ser un entero\n");
    		}
    		int knew = sc.nextInt();
    		p.Modificar_id(knew);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestMCoordenadas (Scanner sc  ) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: La Coordenada X de un Planeta tiene que ser un entero\n");
    		}
    		int xnew = sc.nextInt();
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: La Coordenada Y de un Planeta tiene que ser un entero\n");
    		}
    		int ynew = sc.nextInt();
    		p.modificarCoordenades(xnew,ynew);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestAEntrada (Scanner sc  ) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: El identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Anadir_Entrada(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestASalida (Scanner sc  ) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: El identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Anadir_Salida(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestBEntrada (Scanner sc  ) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: El identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Borrar_Entrada(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestBSalida (Scanner sc  ) {
    	try {
    		String s;
    		while(!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: El identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		p.Borrar_Salida(id);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public void TestB( ) {
    	try {
    		p.Borrar();
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
}

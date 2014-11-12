import java.util.*;
 
public class DriverControladorPlaneta {
    public void Ejecuta(ControladorPlaneta contp, ControladorRuta contr) {
        Scanner sc = new Scanner(System.in);
        int n;
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                    DRIVER CONTROLADOR PLANETA                                     "
            +   "-----------------------------------------------------------------------------------"
            + "Opciones \n"
            + " 1: Planeta(int id, int k, Pair<Integer,Integer> Coo)\n"
            + " 2: PlanetaAuto()\n"         
            + " 3: Consultar_Capacidad(int id)\n"
            + " 4: Consultar_Coste(int id)\n"
            + " 5: Consultar_Coordenadas(int id)\n"
            + " 6: consultar_X(int id)\n"
            + " 7: consultar_Y(int id)\n"
            + " 8: consultarRutasConecta(int id)\n"
            + " 9: Consultar_RutasSalida(int id)\n"
            + " 10: Consultar_RutasEntrada(int id)\n"
            + " 11: BuscarPlaneta(int id)\n"
            + " 12: Consultar_listaPlanetas()\n"
            + " 13: Consultar_Size()"
            + " 14: Consultar_PlanetaX(int x)\n"
            + " 15: Modificar_id(int idold, int idnew)\n"
            + " 16: Modificar_Capacidad(int id, int c)\n"
            + " 17: Modificar_Coste(int id, int k)\n"
            + " 18: modificarCoordenades(int id, int x, int y)\n"
            + " 19: Anadir_Salida(int idp, int id)\n"
            + " 20: Anadir_Salida(int idp, int id)\n"
            + " 21: Borrar_Salida(int idp, int id)\n"
            + " 22: Borrar_Entrada(int idp, int id)\n"
            + " 23: Borrar(Planeta p)");
        n = sc.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearPlaneta(sc, contp);break;
                case 2: TestCrearPlanetaAuto(sc, contp);break;            
                case 3: TestConsultarCapacidad(sc, contp);break;
                case 4: TestConsultarCoste(sc, contp);break;
                case 5: TestConsultarCoordenadas(sc, contp);break;
                case 6: TestConsultarCoordenadaX(sc, contp);break;
                case 7: TestConsultarCoordenadaY(sc, contp);break;
                case 8: TestConsultarRutasConecta(sc, contp);break;
                case 9: TestConsultarRutasSalida(sc, contp);break;
                case 10: TestConsultarRutasEntrada(sc, contp);break;
                case 11: TestBuscarPlaneta(sc, contp);break;
                case 12: TestConsultarlistaPlaneta(contp);break;
                case 13: TestConsultarSize(contp);break;
                case 14: TestConsultarPlanetaX(sc, contp);break;
                case 15: TestModificarId(sc, contp);break;
                case 16: TestModificarCapacidad(sc, contp);break;
                case 17: TestModificarCoste(sc, contp);break;
                case 18: TestModificarCoordenadas(sc, contp);break;
                case 19: TestAnadirSalida(sc, contp);break;
                case 20: TestAnadirEntrada(sc, contp, contr);break;
                case 21: TestBorrarSalida(sc, contp);break;
                case 22: TestBorrarEntrada(sc, contp, contr);break;
                case 23: TestBorrar(sc, contp, contr);break;
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
            contp.Planeta(id,k,Coo,F,S);
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
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            TreeSet<Integer> rutas = contp.consultarRutasConecta(id);
            Iterator<Integer> it = rutas.iterator();
            System.out.print("Las Rutas que conectan con el Planeta son: ");
            while (it.hasNext()) {
                System.out.print(it.next()+ "  ");           
            }
            System.out.print("\n");
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarRutasSalida(Scanner sc, ControladorPlaneta contp) {
        try {
            String s;
            while (!sc.hasNextInt()) {
                s = sc.nextLine();
                throw new Exception("Error: El identificador de un Planeta es un entero\n");
            }
            int id = sc.nextInt();
            TreeSet<Integer> rutas = contp.Consultar_RutasSalida(id);
            Iterator<Integer> it = rutas.iterator();
            System.out.print("Las Rutas que salen del Planeta son: ");
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");           
            }
            System.out.print("\n");
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
            System.out.print("Las Rutas que entran del Planeta son: ");
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");           
            }
            System.out.print("\n");
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestBuscarPlaneta(Scanner sc, ControladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: El identificador de un Planeta es un entero\n");
    		}
    		int id = sc.nextInt();
    		Planeta p = contp.BuscarPlaneta(id);
    		if (p != null) System.out.print("El Planeta existe");
    		else System.out.print("El Planeta no existe");
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestConsultarlistaPlaneta(ControladorPlaneta contp) {
        try {
        	TreeSet<Planeta> lp = contp.Consultar_listaPlanetas();
        	Iterator<Planeta> it = lp.iterator();
        	System.out.print("Los Planetas existentes hasta ahora son: ");
            while (it.hasNext()) {
                System.out.print(it.next().Consultar_id() + "  ");           
            }
        	System.out.print("\n");
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarSize(ControladorPlaneta contp){
    	try {
    		System.out.print("El el numero de Planetas es: " + contp.Consultar_Size() + "\n");
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestConsultarPlanetaX(Scanner sc, ControladorPlaneta contp) {
    	try {	
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: El identificador de un Planeta es un entero\n");
    		}
    		int x = sc.nextInt();
    		System.out.print("El Planeta" + " X es: " + contp.Consultar_PlanetaX(x) + "\n");
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
    public static void TestModificarCapacidad(Scanner sc, ControladorPlaneta contp){
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero\n");
    		}
    		int id = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: la Capacidad de un Planeta tiene que ser un entero\n");
    		}
    		int c = sc.nextInt();
    		contp.Modificar_Capacidad(id,c);
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
    public static void TestAnadirSalida(Scanner sc, ControladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero\n");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		contp.Anadir_Salida(idp, id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestAnadirEntrada(Scanner sc, ControladorPlaneta contp, ControladorRuta contr) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero\n");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		contp.Anadir_Entrada(idp, id, contr);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestBorrarSalida(Scanner sc, ControladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero\n");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		contp.Borrar_Salida(idp, id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestBorrarEntrada(Scanner sc, ControladorPlaneta contp, ControladorRuta contr) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero\n");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Ruta tiene que ser un entero\n");
    		}
    		int id = sc.nextInt();
    		contp.Borrar_Entrada(idp, id, contr);
    	}
    	catch (Exception e){
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
}

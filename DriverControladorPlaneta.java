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
            + " 13: Consultar si una id pertenece a un Planeta -> public Planeta BuscarPlaneta(int id)\n"
            + " 14: Consultar la list de Planetas -> public TreeSet<Planeta> Consultar_listaPlanetas()\n"
            + " 15: Consultar el size de la listaPlanetas -> public int Consultar_Size()"
            + " 16: Modificar id -> public void Modificar_id(int idold, int idnew)\n"
            + " 17: Modificar Capacidad -> public void Modificar_Capacidad(int id, int c)\n"
            + " 18: Modificar Coste -> public void Modificar_Coste(int id, int k)\n"
            + " 19: Modificar Coordenadas -> public void modificarCoordenades(int id, int x, int y)\n"
            + " 20: Anadir una Ruta que sale del Planeta -> public void Anadir_Salida(int idp, int id)\n"
            + " 21: Anadir una Ruta que entra al Planeta -> public void Anadir_Salida(int idp, int id)\n"
            + " 22: Anadir una Nave que esta en el Planeta -> public void Anadir_Nave(int idp, int id)\n"
            + " 23: Borrar una Ruta que sale del Planeta -> public void Borrar_Salida(int idp, int id)\n"
            + " 24: Borrar una Ruta que entra al Planeta -> public void Borrar_Entrada(int idp, int id)\n"
            + " 25: Borrar una Nave que estaba en el Planeta -> public void Borrar_Nave(int idp, int id)\n"
            + " 26: Borrar el Planeta -> public void Borrar(Planeta p)");
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
                case 13: TestBuscarPlaneta(sc, contp);break;
                case 14: TestConsultarlistaPlanetas(contp);break;
                case 15: TestConsultarSize(contp);break;
                case 16: TestModificarId(sc, contp);break;
                case 17: TestModificarCapacidad(sc, contp);break;
                case 18: TestModificarCoste(sc, contp);break;
                case 19: TestModificarCoordenadas(sc, contp);break;
                case 20: TestAnadirSalida(sc, contp);break;
                case 21: TestAnadirEntrada(sc, contp);break;
                case 22: TestAnadirNave(sc, contp);break;
                case 23: TestBorrarSalida(sc, contp);break;
                case 24: TestBorrarEntrada(sc, contp);break;
                case 25: TestBorrarNave(sc, contp);break;
                case 26: TestBorrar(sc, contp);break;
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
    public static void TestBuscarPlaneta(Scanner sc, ControladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc,hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: El identificador de un Planeta es un entero\n")
    		}
    		int id = sc.nextInt();
    		Planeta p = contp.BuscarPlaneta(id);
    		if (p != null) System.out.print("El Planeta existe");
    		else System.out.print("El Planeta no existe");
    	}
    	catch (Exception e){
    		Sytem.out.print(e)
    	}
    }
    public static void TestConsultarlistaPlaneta(ControladorPlaneta contp) {
        try {
        	TreeSet<Planeta> lp = contp.Consultar_listaPlanetas();
        	Iterator<Planeta> it = lp.iterator();
            while (it.hasNext()) {
                System.out.print(it.next().Consultar_id();           
            }
        }
        catch (Exception e) {
            System.out.print(e);
        }          
    }
    public static void TestConsultarSize(ControladorPlaneta contp){
    	try {
    		System.out.print(contp.Consultar_Size());
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
            cont.Modificar_id(idact,idnew);
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
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int id = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: la Capacidad de un Planeta tiene que ser un entero");
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
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int id = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el Coste de un Planeta tiene es un entero");
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
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int id = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: la coordenada X de un Planeta tiene que ser un entero");
    		}
    		int x = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: la coordenada Y de un Planeta tiene que ser un entero");
    		}
    		int y = sc.nextInt();
    		contp.modificarCoordenadas(id,x,y);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    public static void TestAnadirSalida(Scanner sc, COntroladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Ruta tiene que ser un entero");
    		}
    		int id = sc.nextInt();
    		contp.Anadir_Salida(idp, id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestAnadirEntrada(Scanner sc, COntroladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Ruta tiene que ser un entero");
    		}
    		int id = sc.nextInt();
    		contp.Anadir_Entrada(idp, id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestAnadirNave(Scanner sc, COntroladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Nave tiene que ser un entero");
    		}
    		int id = sc.nextInt();
    		contp.Anadir_Nave(idp, id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestBorrarSalida(Scanner sc, COntroladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Ruta tiene que ser un entero");
    		}
    		int id = sc.nextInt();
    		contp.Borrar_Salida(idp, id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestBorrarEntrada(Scanner sc, COntroladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Ruta tiene que ser un entero");
    		}
    		int id = sc.nextInt();
    		contp.Borrar_Entrada(idp, id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestBorrarNave(Scanner sc, COntroladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int idp = sc.nextInt();
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de una Nave tiene que ser un entero");
    		}
    		int id = sc.nextInt();
    		contp.Borrar_Nave(idp, id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
    public static void TestBorrar(Scanner sc, COntroladorPlaneta contp) {
    	try {
    		String s;
    		while (!sc.hasNextInt()) {
    			s = sc.nextLine();
    			throw new Exception("Error: el identificador de un Planeta es un entero");
    		}
    		int id = sc.nextInt();
    		contp.Borrar(id);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
}

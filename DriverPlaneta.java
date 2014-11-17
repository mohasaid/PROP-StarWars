import java.util.*;
 
public class DriverPlaneta {
	private Planeta p;
	
	public void Ejecuta(Scanner sc) {
        int n;
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                    DRIVER PLANETA                                     "
            +   "-----------------------------------------------------------------------------------"
            + "Opciones \n"
            + " 1: Planeta(int id, int k, Pair<Integer,Integer> Coo, bool F, bool S)\n"
            + " 2: Consultar_id()\n"
            + " 4: Consultar_Coste()\n"
            + " 5: Consultar_Coordenadas()\n"
            + " 6: consultar_X( )\n"
            + " 7: consultar_Y( )\n"
            + " 8: Modificar_Coste(int k)\n"
            + " 9: modificarCoordenades(int x, int y)\n"
            + " 10: Borrar()\n");
        n = sc.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearP(sc);break;
                case 2: TestCId();break;
                case 4: TestCCoste();break;
                case 5: TestCCoordenadas();break;
                case 6: TestCCoordenadaX();break;
                case 7: TestCCoordenadaY();break;
                case 8: TestMCoste(sc);break;
                case 9: TestMCoordenadas(sc);break;
                case 10: TestB();break;
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
    		p = new Planeta(id,k,Coo);
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
    		int y = p.consultar_Y();
    		System.out.print("La Coordenada Y del Planeta es: " + y + "\n");
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
    		p.Modificar_Coste(knew);
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
    public void TestB( ) {
    	try {
    		p.Borrar();
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
}


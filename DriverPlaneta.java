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
            + " 1: Planeta(int id, int k, Pair<Integer,Integer> Coo)\n"
            + " 2: Consultar_nombre()\n"
            + " 3: Consultar_Coste()\n"
            + " 4: Consultar_Coordenadas()\n"
            + " 5: consultar_X( )\n"
            + " 6: consultar_Y( )\n"
            + " 7: Modificar_Coste(int k)\n"
            + " 8: modificarCoordenades(int x, int y)\n");
        n = sc.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearP(sc);break;
                case 2: TestCId();break;
                case 3: TestCCoste();break;
                case 4: TestCCoordenadas();break;
                case 5: TestCCoordenadaX();break;
                case 6: TestCCoordenadaY();break;
                case 7: TestMCoste(sc);break;
                case 8: TestMCoordenadas(sc);break;
            }
            n = sc.nextInt();
        }
    }
    public void TestCrearP(Scanner sc) {
    	try {
    		String s;
    		String id = sc.next();
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
    		p = new Planeta(id,k,Coo);
    	}
    	catch (Exception e) {
    		System.out.print(e);
    	}
    }
    
    public void TestCId( ) {
    	try {
    		String id = p.Consultar_nombre();
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
}

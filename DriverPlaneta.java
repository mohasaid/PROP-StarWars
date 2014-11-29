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
            + " 8: Consultar_Asignado()\n"
            + " 9: Modificar_Coste(int k)\n"
            + " 10: modificarCoordenades(int x, int y)\n"
            + " 11: Modificar_Asignado(boolean A)\n");
        n = sc.nextInt();
        while(n != 0) {
            switch(n) {
                case 1: TestCrearP(sc);break;
                case 2: TestCId();break;
                case 4: TestCCoste();break;
                case 5: TestCCoordenadas();break;
                case 6: TestCCoordenadaX();break;
                case 7: TestCCoordenadaY();break;
                case 8: TestCAsignado();break;
                case 9: TestMCoste(sc);break;
                case 10: TestMCoordenadas(sc);break;
                case 11: TestMAsignado(sc);break;
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
    public void TestCAsignado() {
    	try{
    		boolean b = p.Consultar_Asignado();
    		if(b) System.out.print("El Planeta esta Asignado a la Galaxia\n");
    		else System.out.print("El Planeta NO esta Asignado a la Galaxia\n");
    	}
    	catch (Exception e){
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
    public void TestMAsignado(Scanner sc) {
    	try {
    		String s;
    		while(!sc.hasNextBoolean()) {
    			s = sc.nextLine();
    			throw new Exception ("Error: Un Planeta se indica se esta asginado a la Galaxia a traves de un boolean\n");
    		}
    		boolean A = sc.nextBoolean();
    		p.Modificar_Asignado(A);
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    }
}

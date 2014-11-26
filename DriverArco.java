import java.util.Scanner;

public class DriverArco{
	private static Arco a;
    public void Executa(Scanner sc) {
        int op;
        
        		System.out.print("Opciones: \n\n"
		     +"--------------------------------------------------------------------\n"
      	     +"-                    OPCIONES                                      -\n"
   	         +"-           [opcion   Operacion(Atributos)                         -\n"
             +"--------------------------------------------------------------------\n"
             +"-                                                                  -\n"
             +"-   0   Salir del DriverArco                                       -\n"
             +"-   1   TestArco(int capacidad)                                    -\n"
             +"-   2   TestConsultarCapacidad()                                   -\n"
             +"-   3   TestConsultarCoste()                                       -\n"
             +"-   4  TestModificarCapacidad(int NuevaCapacidad)                  -\n"
             +"-   5  TestModificarCoste(int NuevoCoste)                          -\n"
             +"-                                                                  -\n"
             +"--------------------------------------------------------------------\n");

        op = sc.nextInt(); 
                
        while(op != 0){
            switch (op) {
            case 1: TestArco(sc);break;
            case 2: TestConsultarCapacidad();break;
            case 3: TestConsultarCoste();break;
            case 4: TestModificarCapacidad(sc);break;
            case 5: TestModificarCoste(sc);break;
            default: System.out.println("Opción incorrecta");
            }
    op = sc.nextInt(); 
    }
   }
	public static void TestArco(Scanner sc){
		try{
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: La capacidad debe ser un entero mayor que 0\n");
	        }
	    	int c = sc.nextInt();
	    	a = new Arco(c);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
	}
	//CONSULTORAS

	public static void TestConsultarCapacidad(){
		try{
	    	System.out.println(a.ConsultarCapacidad());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
	}
	
	public static void TestConsultarCoste(){
		try{
	    	System.out.println(a.ConsultarCoste());
    	}
    	 catch (Exception e){
             System.out.print(e);
    	 }
	}

	//MODIFICADORAS
	public static void TestModificarCapacidad(Scanner sc){
		try{
			while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: La capacidad debe ser un entero mayor que 0\n");
	        }
	    	int c = sc.nextInt();
	    	a.ModificarCapacidad(c);
    	}
    	 catch (Exception e){
             System.out.print(e);
    	 }
	}

	public static void TestModificarCoste(Scanner sc){
		try{
			while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El coste debe ser un entero\n");
	        }
	    	int c = sc.nextInt();
	    	a.ModificarCoste(c);
    	}
    	 catch (Exception e){
             System.out.print(e);
    	 }
	}
}
    

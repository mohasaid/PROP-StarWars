import java.util.Scanner;



public class DriverArco{
    public void Executa(Scanner sc) {
        int op;
        Arco a = new Arco();

        
                		System.out.print("Opciones: \n\n"
		     +"--------------------------------------------------------------------\n"
      	     +"-                    OPCIONES                                      -\n"
   	         +"-           [opcion   Operacion(Atributos)                         -\n"
             +"--------------------------------------------------------------------\n"
             +"-                                                                  -\n"
             +"-   0   Salir del DriverArco                                       -\n"
             +"-   1   TestArco(int id, int capacidad,int idRuta)                 -\n"
             +"-   2   TestConsultarCapacidad()                                   -\n"
             +"-   3   TestConsultarCoste()                                       -\n"
             +"-   4   TestConsultarIdRuta()                                      -\n"
             +"-   5  TestModificarCapacidad(int NuevaCapacidad)                 -\n"
             +"-   6  TestModificarCoste(int NuevoCoste)                         -\n"
             +"-   7  TestModificarIdRuta(int NuevoIDRuta)                       -\n"
             +"-                                                                  -\n"
             +"--------------------------------------------------------------------\n");

        op = sc.nextInt(); 
                
        while(op != 0){
            switch (op) {
            case 1: TestArco(sc,a);break;
            case 2: TestConsultarCapacidad(a);break;
            case 3: TestConsultarCoste(a);break;
            case 4: TestConsultarIdRuta(a);break;
            case 5: TestModificarCapacidad(sc,a);break;
            case 6: TestModificarCoste(sc,a);break;
            case 7: TestModificarIdRuta(sc,a);break;
            default: System.out.println("Opción incorrecta");
            }
    op = sc.nextInt(); 
    }
   }
	public static void TestArco(Scanner sc, Arco a){
		try{
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: La capacidad debe ser un entero mayor que 0\n");
	        }
	    	int c = sc.nextInt();
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador de la ruta original debe ser un entero\n");
	        }
	    	int idr = sc.nextInt();
	    	a = new Arco(c,idr);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
	}
	//CONSULTORAS

	public static void TestConsultarCapacidad(Arco a){
		try{
	    	System.out.println(a.ConsultarCapacidad());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
	}
	
	public static void TestConsultarCoste(Arco a){
		try{
	    	System.out.println(a.ConsultarCoste());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
	}
	public static void TestConsultarIdRuta(Arco a){
			try{
		    	System.out.println(a.ConsultarIdRuta());
	    	}
	    	 catch (Exception e){
	             System.out.print(e);
	     }
	}
	//MODIFICADORAS
	public static void TestModificarCapacidad(Scanner sc, Arco a){
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

	public static void TestModificarCoste(Scanner sc, Arco a){
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
	public static void TestModificarIdRuta(Scanner sc, Arco a){
		try{
			while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador de la ruta original debe ser un entero mayor que 0\n");
	        }
	    	int idr = sc.nextInt();
	    	a.ModificarIdRuta(idr);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
	}
}
    

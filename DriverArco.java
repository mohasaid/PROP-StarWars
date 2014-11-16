import java.util.Scanner;



public class DriverArco{
    public void Executa(Scanner sc) {
        int op;
        Arco a = new Arco();
        Nodo aux1 = new Nodo(1,false,false);
        Nodo aux2 = new Nodo(2,false,false);

        
                		System.out.print("Opciones: \n\n"
		         +"--------------------------------------------------------------------\n"
      	     +"-                    OPCIONES                                      -\n"
   	         +"-           [opcion   Operacion(Atributos)                         -\n"
             +"--------------------------------------------------------------------\n"
             +"-                                                                  -\n"
             +"-   0   Salir del DriverArco                                       -\n"
             +"-   1   TestArco(int id, int capacidad,int idRuta)                 -\n"
             +"-   2   TestConsultarId()                                          -\n"
             +"-   3   TestConsultarOrigen()                                      -\n"
             +"-   4   TestConsultarDestino()                                     -\n"
             +"-   5   TestConsultarCapacidad()                                   -\n"
             +"-   6   TestConsultarCoste()                                       -\n"
             +"-   7   TestConsultarIdRuta()                                      -\n"
             +"-   8   TestModificarId(int NuevoId)                               -\n"
             +"-   9   TestModificarOrigen()                                      -\n"
             +"-   10  TestModificarDestino()                                     -\n"
             +"-   11  TestModificarCapacidad(int NuevaCapacidad)                 -\n"
             +"-   12  TestModificarCoste(int NuevoCoste)                         -\n"
             +"-   13  TestModificarIdRuta(int NuevoIDRuta)                       -\n"
             +"-                                                                  -\n"
             +"--------------------------------------------------------------------\n");

        op = sc.nextInt(); 
                
        while(op != 0){
            switch (op) {
            case 1: TestArco(sc,a,aux1,aux2);break;
            case 2: TestConsultarId(a);break;
            case 3: TestConsultarOrigen(a);break;
            case 4: TestConsultarDestino(a);break;
            case 5: TestConsultarCapacidad(a);break;
            case 6: TestConsultarCoste(a);break;
            case 7: TestConsultarIdRuta(a);break;
            case 8: TestModificarId(sc,a);break;
            case 9: TestModificarOrigen(a,aux1,aux2);break;
            case 10: TestModificarDestino(a,aux1,aux2);break;
            case 11: TestModificarCapacidad(sc,a);break;
            case 12: TestModificarCoste(sc,a);break;
            case 13: TestModificarIdRuta(sc,a);break;
            default: System.out.println("Opción incorrecta");
            }
    op = sc.nextInt(); 
    }
   }
	public static void TestArco(Scanner sc, Arco a, Nodo aux1, Nodo aux2){
		try{
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador debe ser un entero\n");
	        }
	    	int id = sc.nextInt();
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
	    	a = new Arco(id,aux1,aux2,c,idr);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
	}
	//CONSULTORAS
	public static void TestConsultarId(Arco a){
		try{
	    	System.out.println(a.ConsultarId());
    	}
    	 catch (Exception e){
             System.out.print(e);
    	 }
	}
	
	public static void TestConsultarOrigen(Arco a){
		try{
	    	System.out.println(a.ConsultarOrigen().consultar_id());
    	}
    	 catch (Exception e){
             System.out.print(e);
	}
	}
	public static void TestConsultarDestino(Arco a){
		try{
	    	System.out.println(a.ConsultarDestino().consultar_id());
    	}
    	 catch (Exception e){
             System.out.print(e);
	}
	}
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
	public static void TestModificarId(Scanner sc, Arco a){
		try{
			while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador debe ser un entero\n");
	        }
	    	int idn = sc.nextInt();
	    	a.ModificarId(idn);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
	}

	public static void TestModificarOrigen(Arco a, Nodo aux1, Nodo aux2){
		try{
			if(a.ConsultarOrigen().consultar_id()==1) a.ModificarOrigen(aux2);
			else a.ModificarOrigen(aux1);
    	}
    	 catch (Exception e){
             System.out.print(e);
    	 }
	}
	public static void TestModificarDestino(Arco a,Nodo aux1, Nodo aux2){
		try{
			if(a.ConsultarDestino().consultar_id()==1) a.ModificarDestino(aux2);
			else a.ModificarDestino(aux1);
    	}
    	 catch (Exception e){
             System.out.print(e);
    	 }
	}
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
    

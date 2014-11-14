import java.util.Scanner;



public class DriverNave{
    public void Executa() {
        Scanner sc = new Scanner(System.in);
        int op;
        TipoNave1 n = new TipoNave1();

        
                		System.out.print("Opciones: \n\n"
 +"!!) Ya que la implementación de las clases TipoNave es identica y para reducir el codigo se prueba TipoNave1\n\n"
		     +"---------------------------------------------------------------------------------\n"
      	     +"-                                 OPCIONES                                      -\n"
   	         +"-                     [opcion   Operacion(Atributos)]                           -\n"
             +"---------------------------------------------------------------------------------\n"
             +"-                                                                               -\n"
             +"-   0   Salir del DriverNave                                                    -\n"
             +"-   1   TestDefinirTipo1(int consumo)                                            -\n"
             +"-   2   TestCrearNaveTipo1(int idNave, int idDestino, int idOrigen)             -\n" 
             +"-   3   TestConsultarID()                                                       -\n" 
             +"-   5   TestConsultarDestino()                                                  -\n" 
             +"-   6   TestConsultarOrigen()                                                   -\n" 
             +"-   7   TestConsultarIDTipo()                                                   -\n"
             +"-   7   TestConsultarConsumo()                                                  -\n"
             +"-   8   TestConsultarNave()                                                     -\n" 
             +"-   9   TestModificarID(int NuevoID)                                            -\n" 
             +"-   10  TestModificarDestino(int NuevoDestino)                                  -\n" 
             +"-   11  TestModificarOrigen(int NuevoOrigen)                                    -\n" 
             +"-   12  TestModificarConsumo(int NuevoConsumo)                                  -\n" 
             +"---------------------------------------------------------------------------------\n");

        op = sc.nextInt(); 
                
        while(op != 0){
            switch (op) {
            case 1: TestDefinirTipo1(sc,n);break;
            case 2: TestCrearNaveTipo1(sc,n);break;
            case 3: TestConsultarID(n);break;
            case 4: TestConsultarDestino(n);break;
            case 5: TestConsultarOrigen(n);break;
            case 6: TestConsultarIDTipo(n);break;
            case 7: TestConsultarConsumo(n);break;
            case 8: TestConsultarNave(n);break;
            case 9: TestModificarID(sc,n);break;
            case 10: TestModificarDestino(sc,n);break;
            case 11: TestModificarOrigen(sc,n);break;
            case 12: TestModificarConsumo(sc,n);break;
            default: System.out.println("Opción incorrecta");
            }
    op = sc.nextInt(); 
    }
   }
    //Creadoras
    public static void TestDefinirTipo1(Scanner sc, TipoNave1 n){
    	try{
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador debe ser un entero\n");
	        }
	    	int cons = sc.nextInt();
	    	n.DefinirTipo(cons);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    
    public static void TestCrearNaveTipo1(Scanner sc, TipoNave1 n){
    	try{
	    	if(n.consultar_id()!=-1){
	    		throw new Exception("Error: Ya se ha creado una nave\n");
	    	}
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador debe ser un entero\n");
	        }
	        int id = sc.nextInt();
	        while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador del planeta destino debe ser un entero\n");
	        }
	        int dest = sc.nextInt();
	        while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador del planeta origen debe ser un entero\n");
	        }
	        int orig = sc.nextInt();
	        n = new TipoNave1(id,dest,orig);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    //Consultoras
    public static void TestConsultarID(TipoNave1 n){
    	try{
    		System.out.println(n.consultar_id());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestConsultarDestino(TipoNave1 n){
    	try{
    		System.out.println(n.consultar_destino());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestConsultarOrigen(TipoNave1 n){
    	try{
    		System.out.println(n.consultar_origen());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestConsultarIDTipo(TipoNave1 n){
    	try{
    		System.out.println(n.consultar_tipo());
    	}
    	 catch (Exception e){
             System.out.print(e);
    	 }
    }
    public static void TestConsultarConsumo(TipoNave1 n){
    	try{
    		System.out.println(n.consultar_consumo());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestConsultarNave(TipoNave1 n){
    	try{
    		int id = n.consultar_id();
	    	int dest = n.consultar_id();
	    	int orig = n.consultar_origen();
	    	int tipo = n.consultar_tipo();
	    	int consumo = n.consultar_consumo();
	    	System.out.println("id: "+id+" origen:"+orig+" destino:"+dest+" tipo:"+tipo+" consumo:"+consumo);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    //Modificadoras
    public static void TestModificarID(Scanner sc, TipoNave1 n){
    	try{
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador debe ser un entero\n");
	        }
	    	int idn = sc.nextInt();
	    	n.modificar_id(idn);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestModificarDestino(Scanner sc,TipoNave1 n){
	    try{
    		while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador del planeta destino debe ser un entero\n");
	        }
	    	int idn = sc.nextInt();
	    	n.modificar_destino(idn);
	    }
	    catch (Exception e){
            System.out.print(e);
	    }
    }
    public static void TestModificarOrigen(Scanner sc, TipoNave1 n){
    	try{
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador del planeta origen debe ser un entero\n");
	        }
	    	int idn = sc.nextInt();
	    	n.modificar_origen(idn);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestModificarConsumo(Scanner sc,TipoNave1 n){
	    try{	
    		while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El consumo debe ser un entero\n");
	        }
	    	int cons = sc.nextInt();
	    	n.modificar_consumo(cons);
	    }
	    catch (Exception e){
            System.out.print(e);
	    }
    }
}

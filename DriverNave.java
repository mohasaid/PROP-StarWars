import java.util.Scanner;



public class DriverNave{
	 private static boolean creado = false;
	 private static TipoNave1 n;
    public void Executa(Scanner sc) {
        int op;
       

        
                		System.out.print("Opciones: \n\n"
 +"!!) Ya que la implementación de las clases TipoNave es identica y para reducir el codigo se prueba TipoNave1\n\n"
		     +"---------------------------------------------------------------------------------\n"
      	     +"-                                 OPCIONES                                      -\n"
   	         +"-                     [opcion   Operacion(Atributos)]                           -\n"
             +"---------------------------------------------------------------------------------\n"
             +"-                                                                               -\n"
             +"-   0   Salir del DriverNave                                                    -\n"
             +"-   1   TestDefinirTipo1(int consumo)                                            -\n"
             +"-   2   TestCrearNaveTipo1(int idDestino, int idOrigen)                          -\n" 
             +"-   3   TestConsultarID()                                                       -\n" 
             +"-   4   TestConsultarDestino()                                                  -\n" 
             +"-   5   TestConsultarOrigen()                                                   -\n" 
             +"-   6   TestConsultarIDTipo()                                                   -\n"
             +"-   7   TestConsultarConsumo()                                                  -\n"
             +"-   8   TestConsultarNave()                                                     -\n"  
             +"-   9  TestModificarDestino(int NuevoDestino)                                  -\n" 
             +"-   10  TestModificarOrigen(int NuevoOrigen)                                    -\n" 
             +"-   11  TestModificarConsumo(int NuevoConsumo)                                  -\n" 
             +"---------------------------------------------------------------------------------\n");

        op = sc.nextInt(); 
                
        while(op != 0){
            switch (op) {
            case 1: TestDefinirTipo1(sc);break;
            case 2: TestCrearNaveTipo1(sc);break;
            case 3: TestConsultarID();break;
            case 4: TestConsultarDestino();break;
            case 5: TestConsultarOrigen();break;
            case 6: TestConsultarIDTipo();break;
            case 7: TestConsultarConsumo();break;
            case 8: TestConsultarNave();break;
            case 9: TestModificarDestino(sc);break;
            case 10: TestModificarOrigen(sc);break;
            case 11: TestModificarConsumo(sc);break;
            default: System.out.println("Opción incorrecta");
            }
    op = sc.nextInt(); 
    }
   }
    //Creadoras
    public static void TestDefinirTipo1(Scanner sc){
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
    
    public static void TestCrearNaveTipo1(Scanner sc){
    	try{
	        int id = sc.nextInt();
	        String dest = sc.next();
	        String orig = sc.next();
    		if(creado){
    			throw new Exception("Error: ya se ha creado una nave");
    		}
	    	while(!sc.hasNextInt()){
	            String s = sc.nextLine();
	            throw new Exception("Error: El identificador debe ser un entero\n");
	        }
	        creado = true;
	        n = new TipoNave1(id,dest,orig);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    //Consultoras
    public static void TestConsultarID(){
    	try{
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
    		System.out.println(n.consultar_id());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestConsultarDestino(){
    	try{
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
    		System.out.println(n.consultar_destino());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestConsultarOrigen(){
    	try{	
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
    		System.out.println(n.consultar_origen());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestConsultarIDTipo(){
    	try{
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
    		System.out.println(n.consultar_tipo());
    	}
    	 catch (Exception e){
             System.out.print(e);
    	 }
    }
    public static void TestConsultarConsumo(){
    	try{
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
    		System.out.println(n.consultar_consumo());
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestConsultarNave(){
    	try{
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
    		int id = n.consultar_id();
	    	String dest = n.consultar_destino();
	    	String orig = n.consultar_origen();
	    	int tipo = n.consultar_tipo();
	    	int consumo = n.consultar_consumo();
	    	System.out.println("id: "+id+" origen:"+orig+" destino:"+dest+" tipo:"+tipo+" consumo:"+consumo);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }

    public static void TestModificarDestino(Scanner sc){
	    try{
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
	    	String idn = sc.next();
	    	n.modificar_destino(idn);
	    }
	    catch (Exception e){
            System.out.print(e);
	    }
    }
    public static void TestModificarOrigen(Scanner sc){
    	try{
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
	    	String idn = sc.next();
	    	n.modificar_origen(idn);
    	}
    	 catch (Exception e){
             System.out.print(e);
     }
    }
    public static void TestModificarConsumo(Scanner sc){
	    try{	
    		if(!creado){
    			throw new Exception("Error: No se ha creado ninguna nave\n");
    		}
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

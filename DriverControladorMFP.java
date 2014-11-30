import java.util.Scanner;

public class DriverControladorMFP{
    public void Executa(Scanner sc,/* Entrada e,*/ ControladorMFP cMFP,ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) {
        int op;
        // cMFP.AnadirEntrada(e);

        
                		System.out.print("Opciones: \n\n"
		     +"---------------------------------------------------------------------------------\n"
      	     +"-                                 OPCIONES                                      -\n"
   	         +"-                     [opcion   Operacion(Atributos)]                           -\n"
             +"---------------------------------------------------------------------------------\n"
             +"-                                                                               -\n"
             +"-   0   Salir del DriverControladorMFP                                          -\n"
             +"-   1   TestSeleccionarFC(int i)                                                -\n"
             +"-   2   TestSeleccionarAlgoritmo(int i)                                         -\n"
             +"-   3   Mostrar solucion                                                        -\n"
             +"-   4   Mostrar solucion parcial                                                -\n"
             +"-                                                                               -\n"
             +"---------------------------------------------------------------------------------\n");

        op = sc.nextInt(); 
                
        while(op != 0){
            switch (op) {
            case 1: TestSeleccionarFC(sc,cMFP,cg,cr,cp,cn);break;
            case 2: TestSeleccionarAlgoritmo(sc,cMFP,cn,cr,cp);break;
            case 3: TestConsultarSalida(cMFP);break;
            case 4: TestConsultarCambios(cMFP);break;
            default: System.out.println("Opcion incorrecta");
            }
    op = sc.nextInt(); 
    }
   }
    public static void TestSeleccionarFC(Scanner sc, ControladorMFP cMFP, ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp,ControladorNave cn){
    	try{
	    	System.out.print("Opciones:\n\n"
	    			+"-----------------------------------------------\n"
	         	    +"-             OPCIONES                        -\n"
	      	        +"-     [opcion   Operacion(Atributos)]         -\n"
	                +"-----------------------------------------------\n"
	                +"-                                             -\n"
	                +"-   1   Flujo                                 -\n"
	                +"-   2   Distancia                             -\n"
	                +"-   3   Precio                                -\n"
	                +"-                                             -\n"
	                +"-----------------------------------------------\n");
	    	int i = sc.nextInt();
	    	if(i<1 || i>3) throw new Exception("Error: Opcion incorrecta");
	    	cMFP.SeleccionarFC(i,cg,cr,cp,cn);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    public static void TestSeleccionarAlgoritmo(Scanner sc, ControladorMFP cMFP, ControladorNave cn, ControladorRuta cr, ControladorPlaneta cp){
    	try{
	    	System.out.print("Opciones:\n\n"
	    			+"-----------------------------------------------\n"
	         	    +"-             OPCIONES                        -\n"
	      	        +"-     [opcion   Operacion(Atributos)]         -\n"
	                +"-----------------------------------------------\n"
	                +"-                                             -\n"
	                +"-   1   FordFulkerson con BFS                 -\n"
	                +"-   2   FordFulkerson con Dijkstra            -\n"
	                +"-   3   PushRelabel                           -\n"
	                +"-                                             -\n"
	                +"-----------------------------------------------\n");
	    	int i = sc.nextInt();
	    	if(i<1 || i>3) throw new Exception("Error: Opcion incorrecta");
	    	cMFP.SeleccionarAlgoritmo(i,cn,cr,cp); // aqui calculamos entrada
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    public static void TestConsultarSalida(ControladorMFP cMFP){
    	try{
            int i=0;
            int n = cMFP.size();
            while(i < n){
         	   String s = cMFP.ConsultarSalida(i);
         	   System.out.print(s);
         	   i += 100;
             }
         }
         catch (Exception e){
             System.out.print(e);
         }
    }
    public static void TestConsultarCambios(ControladorMFP cMFP){
    	try{
            int i=0;
            int n = cMFP.size();
            while(i < n){
         	   String s = cMFP.ConsultarCambios(i);
         	   System.out.print(s);
         	   i += 100;
             }
         }
         catch (Exception e){
             System.out.print(e);
         }
    }
}

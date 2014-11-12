import java.util.*;
 
 
 
public class DriverControladorNave{
    public void Executa(Scanner sc, ControladorNave cn) {
        int n;
                System.out.print(
                 "-----------------------------------------------------------------------------------\n"
                +"-                                  OPCIONES                                       -\n"
                +"-                       [opcion   Operacion(Atributos)]                           -\n"
                +"-----------------------------------------------------------------------------------\n"
                +"-                                                                                 -\n"
                +"-   1   TestCrearNave(int idNave, int idTipo, int idDestino)                      -\n"
                +"-   2   TestCrearNaveAuto()                                                       -\n"
                +"-   3   TestCrearTipo(int idtipo, int consumo)                                    -\n"
                +"-   4   TestCrearTipoAuto()                                                       -\n"
                +"-   5   TestConsultarNaves()                                                      -\n"
                +"-   6   TestConsutarNave(int idNave)                                              -\n"
                +"-   7   TestConsultarTipo(int idNave)                                             -\n"
                +"-   8   TestConsultarPlanetaDestino(int idNave)                                   -\n"
                +"-   9   TestConsultarConsumo(int idNave)                                          -\n"
                +"-   10  TestConsultarTipos()                                                      -\n"
                +"-   11  TestConsultarTipoNave(int idTipo)                                         -\n"
                +"-   12  TestConsultarConsumoTipo(int idTipo)                                      -\n"
                +"-   13  TestModificaID(int idNave, int Nuevoid)                                   -\n"
                +"-   14  TestModificaTipo(int idNave, int NuevoidTipo)                             -\n"
                +"-   15  TestModificaDestino(int idNave,int NuevoDestino)                          -\n"
                +"-   16  TestModificaConsumo(int idTipoNave, int NuevoConsumo) 					-\n"
                +"-   17  TestEliminarNave(int idNave)                                              -\n"
                +"-----------------------------------------------------------------------------------\n");

        n = sc.nextInt();
                 
        while(n != 0){
            switch (n) {
            case 1: TestCrearNave(sc,cn);break;
            case 2: TestCrearNaveAuto(sc,cn);break;
            case 3: TestCrearTipo(sc,cn);break;
            case 4: TestCrearTipoAuto(cn);break;
            case 5: TestConsultarNaves(cn);break;
            case 6: TestConsultarNave(sc,cn);break;
            case 7: TestConsultarTipo(sc,cn);break;
            case 8: TestConsultarPlanetaDestino(sc,cn);break;
            case 9: TestConsultarConsumo(sc,cn);break;
            case 10: TestConsultarTipos(cn);break;
            case 11: TestConsultarTipoNave(sc,cn);break;
            case 12: TestConsultarConsumoTipo(sc,cn);break;
            case 13: TestModificaID(sc,cn);break;
            case 14: TestModificaTipo(sc,cn);break;
            case 15: TestModificaDestino(sc,cn);break;
            case 16: TestModificaConsumo(sc,cn);break;
            case 17: TestEliminarNave(sc,cn);break;
            case 18: TestGuardarNaves(sc,cn);break;
            default: System.out.println("Opcion incorrecta");
            }
    n = sc.nextInt();
    }
   }
            public static void TestCrearNave(Scanner sc, ControladorNave cn){
                try{
                	//TestConsultarNaves(cn);
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador del tipo de nave debe ser un entero\n");
                    }
                    int tipoID = sc.nextInt();
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador del planeta destino debe ser un entero\n");
                    }
                    int destID = sc.nextInt();
                    cn.CrearNave(id,tipoID,destID);
                }  
                catch (Exception e){
                        System.out.print(e);
                }
            }

            public static void TestCrearNaveAuto(Scanner sc, ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int destID = sc.nextInt();
                    cn.CrearNaveAuto(destID);
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
             
            public static void TestCrearTipo(Scanner sc, ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El consumo debe ser un entero\n");
                    }
                    int consumo = sc.nextInt();
                    cn.CrearTipoNave(id,consumo);
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestCrearTipoAuto(ControladorNave cn){
                try{
                    cn.CrearTipoNaveAuto();
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            
            public static void TestConsultarNave(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    int dest = cn.ConsultarPlanetaDestino(id);
                    int tipo = cn.ConsultarTipo(id);
                    int cons = cn.ConsultarConsumo(id);
                    System.out.print("id: " + id + ", tipo: " + tipo + ", consumo:  "+ cons +", destino: " + dest + "\n");
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestConsultarTipoNave(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int idtipo = sc.nextInt();
                    
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestConsultarPlanetaDestino(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    System.out.print(cn.ConsultarPlanetaDestino(id) + "\n");
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            
            public static void TestConsultarTipo(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int idnave = sc.nextInt();
                    System.out.print(cn.ConsultarTipo(idnave));
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            
            public static void TestConsultarConsumo(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int idnave = sc.nextInt();
                    System.out.print(cn.ConsultarConsumo(idnave) + "\n");
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestConsultarConsumoTipo(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int idtipo = sc.nextInt();
                    System.out.print(cn.ConsultarConsumoTipo(idtipo) + "\n");
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestModificaID(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El nuevo identificador debe ser un entero\n");
                    }
                    int id2 = sc.nextInt();
                    cn.ModificaID( id, id2);
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestModificaTipo(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador de la nave debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador del tipo de nave debe ser un entero\n");
                    }
                    int idtipo = sc.nextInt();
                    cn.ModificaTipo(id,idtipo);
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestModificaDestino(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El nuevo identificador debe ser un entero\n");
                    }
                    int destID = sc.nextInt();
                    cn.ModificaDestino(id, destID);
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestModificaConsumo(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El consumo debe ser un entero\n");
                    }
                    int c = sc.nextInt();
                    cn.ModificaConsumo(id, c);
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestEliminarNave(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador de la navedebe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    cn.EliminarNave(id);
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            /*
            public static void TestEliminarTipoNave(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador del tipo de nave debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    cn.EliminarTipoNave(id);
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            */
            
            public static void TestConsultarNaves(ControladorNave cn){
                try{
                   int i=0;
                   int n = cn.size();
                   while(i < n){
                	   String s = cn.ConsultarNaves(i);
                	   System.out.print(s);
                	   i += 100;
                    }
                   System.out.print("\n");
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            
            public static void TestConsultarTipos(ControladorNave cn){
                try{
                   String s = cn.ConsultarTipos();
                   Scanner sc = new Scanner(s);
                   sc.useDelimiter(",");
                   while(sc.hasNext()){
                	   System.out.print(sc.next());
                   }
                   System.out.print("\n");
                    }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestGuardarNaves(Scanner sc, ControladorNave cn){
            	try{
            	String s = sc.next();
            	cn.GuardarNaves(s);
            	}
            	   catch (Exception e){
                       System.out.print(e);
                   }
            }
            public static void TestCargarNaves(){
            }
            
    }
             

import java.util.*;
 
 
 
public class DriverControladorNave{
    public void Executa(ControladorNave cn) {
        Scanner sc = new Scanner(System.in);
        int n;
                System.out.print("Opciones \n"
                +"--------------------------------------------------------------------------------------------\n"
                +"-                                        OPCIONES                                          -\n"
                +"-                            [opción   Descripción(Atributos)]                             -\n"
                +"--------------------------------------------------------------------------------------------\n"
                +"-                                                                                          -\n"
                +"-   2   Crear una Nave (int idNave, int idTipo, int idDestino)                             -\n"
                +"-   3   Crear una nave de forma automática()                                               -\n"
                +"-   4   Crear un tipo de nave (int idtipo, int consumo)                                    -\n"
                +"-   5   Crear un tipo de nave de forma automática()                                        -\n"
                +"-   6   Mostrar listado de las naves existentes()                                          -\n"
                +"-   7   Consultar los atributos de una nave (int idNave)                                   -\n"
                +"-   8   Consultar el tipo asociado a una nave (int idNave)                                 -\n"
                +"-   9   Consultar el planeta destino de una nave (int idNave)                              -\n"
                +"-   10  Consultar el consumo asociado a una nave (int idNave)                              -\n"
                +"-   11  Mostrar listado de los tipos de nave existentes()                                  -\n"
                +"-   12  Consultar los atributos de un tipo de nave (int idNave)                            -\n"
                +"-   13  Consultar el consumo asociado a un tipo de nave (int idNave)                       -\n"
                +"-   14  Modificar el identificador de una nave (int idNave, int Nuevoid)                   -\n"
                +"-   15  Modificar el tipo asociado a una nave (int idNave, int NuevoidTipo)                -\n"
                +"-   16  Modificar el planeta destino asociado a una nave (int idNave,int NuevoDestino)     -\n"
                +"-   17  Modificar el identificador de un tipo de nave (int idTipoNave, int Nuevoid)        -\n"
                +"-   18  Modificar el consumo asociado a un tipo de nave (int idTipoNave, int NuevoConsumo) -\n"
                +"-   19  Eliminar una nave (int idNave)                                                     -\n"
                +"-   20  Eliminar un tipo de nave (int idTipoNave)                                          -\n"
                +"-------------------------------------------------------------------------------------------\n");
                 
        n = sc.nextInt();
                 
        while(n != 0){
            switch (n) {
            case 1: TestCrearNave(sc,cn);break;
            case 2: TestCrearNave2(sc,cn);break;
            case 3: TestCrearNaveAuto(sc,cn);break;
            case 4: TestCrearTipo(sc,cn);break;
            case 5: TestCrearTipoAuto(cn);break;
            case 6: TestConsultarNaves(cn);break;
            case 7: TestConsultarNave(sc,cn);break;
            case 8: TestConsultarTipo(sc,cn);break;
            case 9: TestConsultarPlanetaDestino(sc,cn);break;
            case 10: TestConsultarConsumo(sc,cn);break;
            case 11: TestConsultarTipos(cn);break;
            case 12: TestConsultarTipoNave(sc,cn);break;
            case 13: TestConsultarConsumoTipo(sc,cn);break;
            case 14: TestModificaID(sc,cn);break;
            case 15: TestModificaTipo(sc,cn);break;
            case 16: TestModificaDestino(sc,cn);break;
            case 17: TestModificaIDTipo(sc,cn);break;
            case 18: TestModificaConsumo(sc,cn);break;
            case 19: TestEliminarNave(sc,cn);break;
            case 20: TestEliminarTipoNave(sc,cn);break;
            default: System.out.println("Opción incorrecta");
            }
    n = sc.nextInt();
    }
   }
 
            public static void TestCrearNave(Scanner sc, ControladorNave cn){
                try{
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
            public static void TestCrearNave2(Scanner sc,ControladorNave cn){
                try{
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador debe ser un entero\n");
                    }
                    int id = sc.nextInt();
                    while(!sc.hasNextInt()){
                        String s = sc.nextLine();
                        throw new Exception("Error: El identificador del tipo de nave debe ser un entero\n");
                    }
                    int destID = sc.nextInt();
                    cn.CrearNave(id, destID);
                     
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
                    Nave n = cn.ConsultarNave(id);
                    int idd = n.consultar_id();
                    int dest = n.consultar_destino();
                    TipoNave tn = n.consultar_tipo();
                    int tipo = tn.consultar_tipo();
                    int cons = tn.consultar_consumo();
                    System.out.print("id: " + idd + ", tipo: " + tipo + ", consumo:  "+ cons +", destino: " + dest + "\n");
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
                    TipoNave tn = cn.ConsultarTipo(idtipo);
                    int id = tn.consultar_tipo();
                    int consumo = tn.consultar_consumo();
                    System.out.print("id: " + id + ", consumo: " + consumo + "\n");
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
                    TipoNave tn = cn.ConsultarTipo(idnave);
                    System.out.print(tn.consultar_tipo() + "\n");
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
            public static void TestModificaIDTipo(Scanner sc,ControladorNave cn){
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
                    cn.ModificaIDTipo(id, id2);
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
            public static void TestConsultarNaves(ControladorNave cn){
                try{
                    ArrayList<Nave> ln = cn.ConsultarNaves();
                    for(int i = 0; i < ln.size(); ++i){
                        System.out.print(ln.get(i).consultar_id() + "\n");
                    }
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
            public static void TestConsultarTipos(ControladorNave cn){
                try{
                    ArrayList<TipoNave> ltn = cn.ConsultarTipos();
                    for(int i = 0; i < ltn.size(); ++i){
                        System.out.print(ltn.get(i).consultar_tipo() + "\n");
                    }
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
             
    }
             
            

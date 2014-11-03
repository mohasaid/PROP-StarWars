import java.util.Scanner;
 
public class DriverNave{
    public void Executa() {
        Scanner sc = new Scanner(System.in);
        int op;
        Nave n = new Nave();
        TipoNave tn = new TipoNave();
         
                        System.out.print("Opciones: \n\n"
                                    +"-----------------------------------------------------------------------------------\n"
                                    +"-                                 OPCIONES                                        -\n"
                                    +"-                     [opción   Descripción(Atributos)]                           -\n"
                                    +"-----------------------------------------------------------------------------------\n"
                                    +"-                                                                                 -\n"
                                    +"-   1   Crear una Nave sin tipo (int idNave, int idDestino)                       -\n"
                                    +"-   2   Crear una Nave (int idNave, int idTipo, int consumo, int idDestino)       -\n"
                                    +"-   3   Crear un tipo de nave (int idtipo, int consumo)                           -\n"
                                    +"-   4   Eliminar el tipo asociado a una nave ()                                   -\n"
                                    +"-   5   Consultar los atributos de una nave ()                                    -\n"
                                    +"-   6   Consultar el tipo asociado a una nave ()                                  -\n"
                                    +"-   7   Consultar el planeta destino de una nave ()                               -\n"
                                    +"-   8   Consultar el consumo asociado a una nave ()                               -\n"
                                    +"-   9   Consultar los atributos de un tipo de nave ()                             -\n"
                                    +"-   10  Consultar el consumo asociado a un tipo de nave ()                        -\n"
                                    +"-   11  Modificar el identificador de una nave (int Nuevoid)                      -\n"
                                    +"-   12  Modificar el tipo asociado a una nave (int NuevoidTipo, int Nuevoconsumo) -\n"
                                    +"-   13  Modificar el planeta destino asociado a una nave (int NuevoDestino)       -\n"
                                    +"-   14  Modificar el identificador de un tipo de nave (int Nuevoid)               -\n"
                                    +"-   15  Modificar el consumo asociado a un tipo de nave (int NuevoConsumo)        -\n"
                                    +"-----------------------------------------------------------------------------------\n");
 
        op = sc.nextInt();
                 
        while(op != 0){
            switch (op) {
            case 1: TestCrearNave(sc,n);break;
            case 2: TestCrearNave2(sc,n);break;
            case 3: TestCrearTipo(sc,tn);break;
            case 4: EliminarTipo(n);break;
            case 5: TestConsultarNave(n);break;
            case 6: TestConsultarTipo(n);break;
            case 7: TestConsultarPlanetaDestino(n);break;
            case 8: TestConsultarConsumo(n);break;
            case 9: TestConsultarIDTipo(tn);break;
            case 10: TestConsultarConsumoTipo(tn);break;
            case 11: TestModificaID(sc,n);break;
            case 12: TestModificaTipo(sc,n);break;
            case 13: TestModificaDestino(sc,n);break;
            case 14: TestModificaIDTipo(sc,tn);break;
            case 15: TestModificaConsumo(sc,tn);break;
            default: System.out.println("Opción incorrecta");
            }
    op = sc.nextInt();
    }
   }
    public void TestCrearNave(Scanner sc, Nave n){
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
            int dest = sc.nextInt();
            n = new Nave(id,dest);
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
     public void TestCrearNave2(Scanner sc,Nave n){
         try{
             while(!sc.hasNextInt()){
                String s = sc.nextLine();
                throw new Exception("Error: El identificador debe ser un entero\n");
            }
             int id = sc.nextInt();
             while(!sc.hasNextInt()){
                String s = sc.nextLine();
                throw new Exception("Error: El identificador del tipo debe ser un entero\n");
            }
             int idtipo = sc.nextInt();
             while(!sc.hasNextInt()){
                    String s = sc.nextLine();
                    throw new Exception("Error: El identificador debe ser un entero\n");
                }
             int cons = sc.nextInt();
             TipoNave aux = new TipoNave(idtipo,cons);
             while(!sc.hasNextInt()){
                String s = sc.nextLine();
                throw new Exception("Error: El consumo debe ser un entero\n");
            }
             int dest = sc.nextInt();
             n = new Nave(id,aux,dest);
            }  
            catch (Exception e){
                    System.out.print(e);
            }
     }
    public void TestCrearTipo(Scanner sc, TipoNave tn){
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
        tn = new TipoNave(id,consumo);
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void EliminarTipo(Nave n){
            n.eliminar_tipo();
    }
    public void TestConsultarNave(Nave n){
    try{
        int id = n.consultar_id();
        TipoNave tn = n.consultar_tipo();
        int tipo = tn.consultar_tipo();
        int cons = n.consultar_consumo();
        int dest = n.consultar_destino();
        System.out.print("id: " + id + ", tipo: " + tipo + ", consumo:  "+ cons +", destino: " + dest + "\n");
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestConsultarTipo(Nave n){
    try{
            TipoNave tn = n.consultar_tipo();
            int tipo = tn.consultar_tipo();
            System.out.print(tipo + "\n");
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestConsultarPlanetaDestino( Nave n){
    try{
            System.out.print(n.consultar_destino() + "\n");
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestConsultarConsumo(Nave n){
    try{
            System.out.print(n.consultar_consumo() + "\n");
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestConsultarIDTipo(TipoNave tn){
    try{
            System.out.print(tn.consultar_tipo() + "\n");
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestConsultarConsumoTipo(TipoNave tn){
    try{
            System.out.print(tn.consultar_consumo()+ "\n");
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestModificaID(Scanner sc, Nave n){
    try{
        while(!sc.hasNextInt()){
            String s = sc.nextLine();
            throw new Exception("Error: El identificador debe ser un entero\n");
        }
        int id = sc.nextInt();
        n.modificar_id(id);
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestModificaTipo(Scanner sc, Nave n){
    try{
        while(!sc.hasNextInt()){
            String s = sc.nextLine();
            throw new Exception("Error: El identificador debe ser un entero\n");
        }
        int idTipo = sc.nextInt();
        while(!sc.hasNextInt()){
            String s = sc.nextLine();
            throw new Exception("Error: El consumo debe ser un entero\n");
        }
        int cons = sc.nextInt();
        TipoNave aux = new TipoNave(idTipo,cons);
         n.modificar_tipo(aux);
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestModificaDestino(Scanner sc, Nave n){
    try{
        while(!sc.hasNextInt()){
            String s = sc.nextLine();
            throw new Exception("Error: El identificador del planeta destino debe ser un entero\n");
        }
        int d = sc.nextInt();
        n.modificar_destino(d);
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestModificaIDTipo(Scanner sc, TipoNave tn){
    try{
        while(!sc.hasNextInt()){
            String s = sc.nextLine();
            throw new Exception("Error: El identificador debe ser un entero\n");
        }
        int id = sc.nextInt();
        tn.modificar_tipo(id);
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
    public void TestModificaConsumo(Scanner sc, TipoNave tn){
    try{
        while(!sc.hasNextInt()){
            String s = sc.nextLine();
            throw new Exception("Error: El identificador debe ser un entero\n");
        }
        int c = sc.nextInt();
        tn.modificar_consumo(c);
        }  
        catch (Exception e){
                System.out.print(e);
        }
    }
}

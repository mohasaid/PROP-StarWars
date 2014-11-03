import java.util.*;
 
public class DriverRuta {
    private Ruta r;
    private Scanner cin = new Scanner(System.in);
 
    public void opciones()
    {
        System.out.print(
                "-----------------------------------------------------------------------------------"
                +   "                               DRIVER RUTA                                      "
                +   "-----------------------------------------------------------------------------------"
                + "\n\nCREACIÓ Ruta\n"
                + " 0: Sortir de la gestio del driver \n"
                + " 1: Crear una Ruta buida -> public Ruta() \n"
                + " 2: Crear una Ruta amb un identificador, una capacitat, una distancia, un planetaA, un planetaB i un valor boolea -> public CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional) \n"
                 
                + "\n\nOPERACIONS DE CONSULTA DE RUTA\n"
                + " 3: Consultar l'identificador de la ruta -> public int consultar_id() \n"   
                + " 4: Consultar la capacitat de la ruta -> public int consultar_capacidad() \n"      
                + " 5: Consultar la distancia de la ruta -> public int consultar_distancia() \n"      
                + " 6: Consultar l'identificador del planetaA de la ruta -> public int consultar_planetaA() \n"      
                + " 7: Consultar l'identificador del planetaB de la ruta -> public int consultar_planetaB() \n"      
                + " 8: Consultar si la ruta es bidireccional -> public boolean consultar_bidireccional() \n"
                 
                + "\n\nOPERACIONS MODIFICADORES DE RUTA\n"
                + " 9: Modificar l'identificador de la ruta -> public int modificar_id() \n"   
                + " 10: Modificar la capacitat de la ruta -> public int modificar_capacidad() \n"      
                + " 11: Modificar la distancia de la ruta -> public int modificar_distancia() \n"      
                + " 12: Modificar l'identificador del planetaA de la ruta -> public int modificar_planetaA() \n"      
                + " 13: Modificar l'identificador del planetaB de la ruta -> public int modificar_planetaB() \n"      
                + " 14: Modificar si la ruta es bidireccional -> public boolean modificar_bidireccional() \n");
    }
     
    public void Executa(Ruta r) throws Exception {
        int n;
        this.r = r;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearRutaBuida();break;
            case 2:  TestCrearRuta2(cin);break;
            case 3:  TestConsultarIdRuta();break;
            case 4:  TestConsultarCpacitatRuta();break;
            case 5:  TestConsultarDistanciaRuta();break;
            case 6:  TestConsultarPlanetaARuta();break;
            case 7:  TestConsultarPlanetaBRuta();break;
            case 8:  TestConsultarBidireccionalRuta();break;
            case 9:  TestModificarIdRuta(cin);break;
            case 10: TestModificarCpacitatRuta(cin);break;
            case 11: TestModificarDistanciaRuta(cin);break;
            case 12: TestModificarPlanetaARuta(cin);break;
            case 13: TestModificarPlanetaBRuta(cin);break;
            case 14: TestModificarBidireccionalRuta(cin);break;
            default: System.out.println("Opcio incorrecte");
            }
        opciones();
        n = cin.nextInt();
        }
    }
      
    public void TestCrearRutaBuida()
    {
        r = new Ruta();
    }
     
    public void  TestCrearRuta2(Scanner cin) throws Exception
    {
        int id = cin.nextInt();
        int capacidad = cin.nextInt();
        int distancia = cin.nextInt();
        int planetaA = cin.nextInt();
        int planetaB = cin.nextInt();
        boolean bidireccional;
        if ( cin.nextInt()==1 ) bidireccional = true;
        else bidireccional = false;
        r =  new Ruta(id, capacidad, distancia, planetaA, planetaB, bidireccional);
    }
     
    public void TestConsultarIdRuta() throws Exception
    {
        System.out.println(r.consultar_id());
    }
     
    public void TestConsultarCpacitatRuta() throws Exception
    {
        System.out.println(r.consultar_capacidad());
    }
     
    public void TestConsultarDistanciaRuta() throws Exception
    {
        System.out.println(r.consultar_distancia());
    }
     
    public void TestConsultarPlanetaARuta() throws Exception
    {
        System.out.println(r.consultar_planetaA());
    }
     
    public void TestConsultarPlanetaBRuta() throws Exception
    {
        System.out.println(r.consultar_planetaB());
    }
         
    public void TestConsultarBidireccionalRuta() throws Exception
    {
        if (r.consultar_bidireccional()) System.out.println("La ruta es bidireccional");
        else System.out.println("La ruta no es bidireccional");
    }
     
    public void TestModificarIdRuta(Scanner cin) throws Exception
    {
         
        r.modificar_id(cin.nextInt());
    }
     
    public void TestModificarCpacitatRuta(Scanner cin) throws Exception
    {
        r.modificar_capacidad(cin.nextInt());
    }
     
    public void TestModificarDistanciaRuta(Scanner cin) throws Exception
    {
        r.modificar_distancia(cin.nextInt());
    }
     
    public void TestModificarPlanetaARuta(Scanner cin) throws Exception
    {
        r.modificar_planetaA(cin.nextInt());
    }
     
    public void TestModificarPlanetaBRuta(Scanner cin) throws Exception
    {
        r.modificar_planetaB(cin.nextInt());
    }
         
    public void TestModificarBidireccionalRuta(Scanner cin) throws Exception
    {
        boolean bid;
        if (cin.nextInt() == 0) bid = false;
        else bid = true;
        r.modificar_bidireccional(bid);
    }
}

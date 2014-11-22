import java.util.*;

public class DriverRuta {

    public void opciones()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------\n"
                +   "                               DRIVER RUTA                                      \n"
                +   "-----------------------------------------------------------------------------------\n"
                + "\n\nCREACION RUTA\n"
                + " 0: Salir de la gestion del driver \n"
                + " 1: CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional) \n"
                
                + "\n\nOPERACIONES DE CONSULTA DE RUTA\n"
                + " 2: consultar_id() \n"    
                + " 3: consultar_capacidad() \n"       
                + " 4: consultar_distancia() \n"       
                + " 5: consultar_bidireccional() \n"       

                
                + "\n\nOPERACIONES MODIFICADORAS DE RUTA\n"
                + " 6: modificar_id() \n"    
                + " 7: modificar_capacidad() \n"       
                + " 8: modificar_distancia() \n" 
                + " 9: modificar_bidireccional() \n"       


    			);
    }
    
    public void Executa(Scanner cin, Ruta r) throws Exception {
        int n;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearRuta2(cin,r);break;
            case 2:  TestConsultarIdRuta(r);break;
            case 3:  TestConsultarCpacitatRuta(r);break;
            case 4:  TestConsultarDistanciaRuta(r);break;
            case 5:  TestConsultarBidireccionalitatRuta(cin,r);break;
            case 6:  TestModificarIdRuta(cin,r);break;
            case 7:  TestModificarCpacitatRuta(cin,r);break;
            case 8:  TestModificarDistanciaRuta(cin,r);break;
            case 9:  TestModificarBidireccionalitatRuta(cin,r);break;
            default: System.out.println("Opcion incorrecta");
            }
        opciones();
        n = cin.nextInt();
        }
    }
	
    
	public void TestConsultarBidireccionalitatRuta(Scanner cin, Ruta r) throws Exception 
	{
		try {
			if (r.consultar_bidireccional()) System.out.print("La ruta es bidireccional \n");
			else System.out.print("La ruta no es bidireccional \n");

		}
		catch (Exception e){
            System.out.print(e);
		}
	}

	
	public void TestModificarBidireccionalitatRuta(Scanner cin, Ruta r) throws Exception
	{
		try {
			boolean b = cin.nextBoolean();
			r.modificar_bidireccional(b);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestCrearRuta2(Scanner cin, Ruta r) throws Exception
	{
		try {
			int id = cin.nextInt();
			int capacidad = cin.nextInt();
			int distancia = cin.nextInt();
			boolean b = cin.nextBoolean();
			r =  new Ruta(id, capacidad, distancia, b);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarIdRuta( Ruta r ) throws Exception
	{
		try {
			System.out.println(r.consultar_id());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarCpacitatRuta( Ruta r ) throws Exception
	{
		try {
			System.out.println(r.consultar_capacidad());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarDistanciaRuta( Ruta r ) throws Exception
	{
		try {
			System.out.println(r.consultar_distancia());
		} 
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarIdRuta(Scanner cin, Ruta r) throws Exception 
	{
		try {
			r.modificar_id(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarCpacitatRuta(Scanner cin, Ruta r) throws Exception 
	{
		try {
			r.modificar_capacidad(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarDistanciaRuta(Scanner cin, Ruta r) throws Exception 
	{
		try{ 
			r.modificar_distancia(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}

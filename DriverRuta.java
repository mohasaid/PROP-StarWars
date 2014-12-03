import java.util.*;

public class DriverRuta {
	private Ruta r;
    public void opciones()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------	\n"
                +   "                               DRIVER RUTA                                      	\n"
                +   "-----------------------------------------------------------------------------------\n"
                
                + " 0: Salir de la gestion del driver 													\n"
                + " 1: CrearRuta(int id, int capacidad, int distancia) 			\n"
                
                + " 2: consultar_id() 																	\n"    
                + " 3: consultar_capacidad() 															\n"       
                + " 4: consultar_distancia() 															\n"       

                + " 5: modificar_id() 																	\n"    
                + " 6: modificar_capacidad() 															\n"       
                + " 7: modificar_distancia() 															\n" 
    			);
    }
    
    public void Executa(Scanner cin ) throws Exception {
        int n;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearRuta2(cin);break;
            case 2:  TestConsultarIdRuta();break;
            case 3:  TestConsultarCpacitatRuta();break;
            case 4:  TestConsultarDistanciaRuta();break;
            case 5:  TestModificarIdRuta(cin);break;
            case 6:  TestModificarCpacitatRuta(cin);break;
            case 7:  TestModificarDistanciaRuta(cin);break;
            default: System.out.println("Opcion incorrecta");
            }
        n = cin.nextInt();
        }
    }

	
	public void TestCrearRuta2(Scanner cin) throws Exception
	{
		try {
			int id = cin.nextInt();
			int capacidad = cin.nextInt();
			int distancia = cin.nextInt();
			System.out.print("creo ruta");
			r =  new Ruta(id, capacidad, distancia);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarIdRuta( ) throws Exception
	{
		try {
			System.out.println(r.consultar_id());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarCpacitatRuta( ) throws Exception
	{
		try {
			System.out.println(r.consultar_capacidad());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarDistanciaRuta(  ) throws Exception
	{
		try {
			System.out.println(r.consultar_distancia());
		} 
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarIdRuta(Scanner cin) throws Exception 
	{
		try {
			r.modificar_id(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarCpacitatRuta(Scanner cin) throws Exception 
	{
		try {
			r.modificar_capacidad(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarDistanciaRuta(Scanner cin) throws Exception 
	{
		try{ 
			r.modificar_distancia(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}

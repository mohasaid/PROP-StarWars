import java.util.*;
	
public class DriverConexion {
	private Conexion c;
    public void opciones()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------\n"
                +   "                               DRIVER CONEXION                                     \n"
                +   "-----------------------------------------------------------------------------------\n"
                + " 0: Salir de la gestion del driver \n"
                + " 1: Conexion(int i, String pA, String pB) \n"
                
                + " 2: consultar_id() \n"
                + " 3: consultar_planetaA() \n"       
                + " 4: consultar_planetaB() \n"       
                
                + " 5:  modificar_id(int id_nuevo) \n"    
                + " 6:  modificar_planetaA(String idA) \n"       
                + " 7:  modificar_planetaB(String idB) \n"       
    			);
    }
    
    public void Executa( Scanner cin ) throws Exception {
        int n;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearConnexio2(cin);break;
            case 2:  TestConsultarIdConnexio();break;
            case 3:  TestConsultarPlanetaAConnexio();break;
            case 4:  TestConsultarPlanetaBConnexio();break;
            case 5:  TestModificarIdConnexio(cin);break;
            case 6:  TestModificarPlanetaAConnexio(cin);break;
            case 7: TestModificarPlanetaBConnexio(cin);break;
            default: System.out.println("Opcion incorrecta");
            }
        opciones();
        n = cin.nextInt();
        }
    }
    
	public void  TestCrearConnexio2(Scanner cin) throws Exception
	{
		try {
			int id = cin.nextInt();
			String planetaA = cin.next();
			String planetaB = cin.next();
			c =  new Conexion(id, planetaA, planetaB);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarIdConnexio() throws Exception
	{
		try {
			System.out.println(c.consultar_id());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	
	public void TestConsultarPlanetaAConnexio() throws Exception
	{
		try {
			System.out.println(c.consultar_planetaA());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarPlanetaBConnexio() throws Exception
	{
		try {
			System.out.println(c.consultar_planetaB());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestModificarIdConnexio(Scanner cin) throws Exception 
	{
		try {
			c.modificar_id(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarPlanetaAConnexio(Scanner cin) throws Exception 
	{
		try {
			c.modificar_planetaA(cin.next());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarPlanetaBConnexio(Scanner cin) throws Exception 
	{
		try {
			c.modificar_planetaB(cin.next());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
}

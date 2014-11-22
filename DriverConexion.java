import java.util.*;
	
public class DriverConexion {
    public void opciones()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------\n"
                +   "                               DRIVER CONEXION                                     \n"
                +   "-----------------------------------------------------------------------------------\n"
                + "\n\nCREACION CONEXION\n"
                + " 0: Salir de la gestion del driver \n"
                + " 1: Conexion(int i, int pA, int pB, boolean b) \n"
                
                + "\n\nOPERACIONES DE CONSULTA DE CONEXION\n"
                + " 2: consultar_id() \n"
                + " 3: consultar_planetaA() \n"       
                + " 4: consultar_planetaB() \n"       
                
                + "\n\nOPERACIONES MODIFICADORAS DE CONEXION\n"
                + " 5:  modificar_id() \n"    
                + " 6:  modificar_planetaA() \n"       
                + " 7:  modificar_planetaB() \n"       
    			);
    }
    
    public void Executa(Conexion c, Scanner cin) throws Exception {
        int n;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearConnexio2(cin, c);break;
            case 2:  TestConsultarIdConnexio(c);break;
            case 3:  TestConsultarPlanetaAConnexio(c);break;
            case 4:  TestConsultarPlanetaBConnexio(c);break;
            case 5:  TestModificarIdConnexio(cin,c);break;
            case 6:  TestModificarPlanetaAConnexio(cin,c);break;
            case 7: TestModificarPlanetaBConnexio(cin,c);break;
            default: System.out.println("Opcion incorrecta");
            }
        opciones();
        n = cin.nextInt();
        }
    }
    
	public void  TestCrearConnexio2(Scanner cin, Conexion c) throws Exception
	{
		try {
			int id = cin.nextInt();
			int planetaA = cin.nextInt();
			int planetaB = cin.nextInt();
			c =  new Conexion(id, planetaA, planetaB);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarIdConnexio(Conexion c) throws Exception
	{
		try {
			System.out.println(c.consultar_id());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	
	public void TestConsultarPlanetaAConnexio(Conexion c) throws Exception
	{
		try {
			System.out.println(c.consultar_planetaA());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarPlanetaBConnexio(Conexion c) throws Exception
	{
		try {
			System.out.println(c.consultar_planetaB());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	
	public void TestModificarIdConnexio(Scanner cin, Conexion c) throws Exception 
	{
		try {
			c.modificar_id(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	
	public void TestModificarPlanetaAConnexio(Scanner cin, Conexion c) throws Exception 
	{
		try {
			c.modificar_planetaA(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarPlanetaBConnexio(Scanner cin, Conexion c) throws Exception 
	{
		try {
			c.modificar_planetaB(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
}


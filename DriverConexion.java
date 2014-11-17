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
                + " 1: Conexion() \n"
                + " 2: Conexion(int i, int pA, int pB, boolean b) \n"
                
                + "\n\nOPERACIONES DE CONSULTA DE CONEXION\n"
                + " 3: consultar_id() \n"
                + " 4: consultar_planetaA() \n"       
                + " 5: consultar_planetaB() \n"       
                + " 6: consultar_bidireccional() \n"
                
                + "\n\nOPERACIONES MODIFICADORAS DE CONEXION\n"
                + " 7:  modificar_id() \n"    
                + " 8:  modificar_planetaA() \n"       
                + " 9:  modificar_planetaB() \n"       
                + " 10: modificar_bidireccional() \n"
    			);
    }
    
    public void Executa(Conexion c, Scanner cin) throws Exception {
        int n;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearConnexioBuida(c);break;
            case 2:  TestCrearConnexio2(cin, c);break;
            case 3:  TestConsultarIdConnexio(c);break;
            case 4:  TestConsultarPlanetaAConnexio(c);break;
            case 5:  TestConsultarPlanetaBConnexio(c);break;
            case 6:  TestConsultarBidireccionalConnexio(c);break;
            case 7:  TestModificarIdConnexio(cin,c);break;
            case 8:  TestModificarPlanetaAConnexio(cin,c);break;
            case 9: TestModificarPlanetaBConnexio(cin,c);break;
            case 10: TestModificarBidireccionalConnexio(cin,c);break;
            default: System.out.println("Opcion incorrecta");
            }
        opciones();
        n = cin.nextInt();
        }
    }
    
	public void TestCrearConnexioBuida(Conexion c)
	{
		try {
			c = new Conexion();
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestCrearConnexio2(Scanner cin, Conexion c) throws Exception
	{
		try {
			int id = cin.nextInt();
			int planetaA = cin.nextInt();
			int planetaB = cin.nextInt();
			boolean bidireccional = cin.nextBoolean();
			c =  new Conexion(id, planetaA, planetaB, bidireccional);
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
		
	public void TestConsultarBidireccionalConnexio(Conexion c) throws Exception
	{
		try {
			if (c.consultar_bidireccional()) System.out.println("La Connexio es bidireccional");
			else System.out.println("La Connexio no es bidireccional");
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
		
	public void TestModificarBidireccionalConnexio(Scanner cin, Conexion c) throws Exception 
	{
		try {
			c.modificar_bidireccional(cin.nextBoolean());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}


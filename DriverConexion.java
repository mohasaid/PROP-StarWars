import java.util.*;
	
public class DriverConexion {
	private Conexion c;
    private Scanner cin = new Scanner(System.in);

    public void opciones()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------"
                +   "                               DRIVER CONEXION                                     "
                +   "-----------------------------------------------------------------------------------"
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
                + " 7: invertir_planetas() \n"
                + " 8: modificar_id() \n"    
                + " 9: modificar_planetaA() \n"       
                + " 10: modificar_planetaB() \n"       
                + " 11: modificar_bidireccional() \n"
    			);
    }
    
    public void Executa(Conexion con) throws Exception {
        int n;
        c = con;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearConnexioBuida();break;
            case 2:  TestCrearConnexio2(cin);break;
            case 3:  TestConsultarIdConnexio();break;
            case 4:  TestConsultarPlanetaAConnexio();break;
            case 5:  TestConsultarPlanetaBConnexio();break;
            case 6:  TestConsultarBidireccionalConnexio();break;
            case 7:  TestInvertirPlanetasConnexio();
            case 8:  TestModificarIdConnexio(cin);break;
            case 9:  TestModificarPlanetaAConnexio(cin);break;
            case 10: TestModificarPlanetaBConnexio(cin);break;
            case 11: TestModificarBidireccionalConnexio(cin);break;
            default: System.out.println("Opcion incorrecta");
            }
        opciones();
        n = cin.nextInt();
        }
    }
    
    public void TestInvertirPlanetasConnexio() throws Exception {
    	try{
    		c.invertir_planetas();
    	}
		catch (Exception e){
	        System.out.print(e);
		}
    }
    
	public void TestCrearConnexioBuida()
	{
		try {
			c = new Conexion();
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestCrearConnexio2(Scanner cin) throws Exception
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
		
	public void TestConsultarBidireccionalConnexio() throws Exception
	{
		try {
			if (c.consultar_bidireccional()) System.out.println("La Connexio es bidireccional");
			else System.out.println("La Connexio no es bidireccional");
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
			c.modificar_planetaA(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarPlanetaBConnexio(Scanner cin) throws Exception 
	{
		try {
			c.modificar_planetaB(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestModificarBidireccionalConnexio(Scanner cin) throws Exception 
	{
		try {
			c.modificar_bidireccional(cin.nextBoolean());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}


import java.util.*;

public class DriverControladorRuta {
	private ControladorRuta c;
	private ControladorPlaneta cp;
    private Scanner cin = new Scanner(System.in);

    public void Executa(ControladorRuta c, ControladorPlaneta cp) throws Exception {
    	this.c = c;
    	this.cp = cp;
        int n;
            System.out.print(
            "-----------------------------------------------------------------------------------"
            +   "                               DRIVER RUTA                                      "
            +   "-----------------------------------------------------------------------------------"
            + "CREACIÓ RUTA \n\n "
            + " 0: Sortir de la gestio del driver"
            + " 1: Crear un Controlador de Ruta buit -> public ControladorRuta() \n "
            + " 2: Crear una Ruta amb un identificador, una capacitat, una distancia, un planetaA, un planetaB i un valor boolea i l'afageig en l'arbre de rutes-> public CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional) \n"
            + " 3: Crear una ruta de forma automàtica i l'afageix en l'arbre de rutes-> public CrearRuta_automatica()"
            
            + "OPERACIONS DE CONSULTA DE RUTA \n\n"
            + " 4: Consultar la capacitat de la ruta amb l'dentificador donat -> public int ConsultarCapacidadRuta(int id) \n"       
            + " 5: Consultar la distancia de la ruta amb l'identificador donat -> public int ConsultarDistanciaRuta(int id) \n"       
            + " 6: Consultar l'identificador del planetaA de la ruta amb l'identificador donat -> public int ConsultarPlanetaARuta(int id) \n"       
            + " 7: Consultar l'identificador del planetaB de la ruta amb l'identificador donat -> public int ConsultarPlanetaBRuta(int id) \n"       
            + " 8: Consultar si la ruta amb l'identificador donat es bidireccional -> public boolean ConsultarBidireccionalidadRuta(int id) \n"
            + " 9: Consultar si existeis una ruta amb l'identificador donat -> public boolen ExisteRuta(int id)"
            
            + "OPERACIONS MODIFICADORES DE RUTA \n\n"
            + " 10: Modificar l'identificador de la ruta amb l'identificador donat -> public void ModificarIddRuta(int id_original, int id_nuevo) \n"    
            + " 11: Modificar la capacitat de la ruta amb l'identificador donat  -> public void ModificarCapacidadRuta(int id, int capacidad nueva) \n"       
            + " 12: Modificar la distancia de la ruta amb l'identificador donat -> public void ModificarDistanciaRuta(int id, int distancia_nueva) \n"       
            + " 13: Modificar l'identificador del planetaA de la ruta amb l'identificador donat -> public void ModificarPlanetaARuta(int id, int id_planetaA_nuevo) \n"       
            + " 14: Modificar l'identificador del planetaB de la ruta amb l'identificador donat -> public void ModificarPlanetaBRuta(int id, int id_planetaB_nuevo) \n"       
            + " 15: Modificar la bidireccionalitat de la ruta amb l'identificador donat -> public void ModificarBidireccionalidadRuta(int id, boolean bidireccional) \n"
            
            + " OPERACIONS PER BORRAR RUTES \n\n "
            + " 16: Borra la ruta amb l'identificador donat -> public void BorrarRuta(int id) \n"
            
 			+ " ALTRES OPERACIONS QUE CONTÉ EL CONTROLADOR \n\n "
 			+ " 17: Busca la ruta amb l'identificador donat a l'arbre de Rutes i l'ha retorna -> public BuscarRuta(int id) \n"
    		);
            
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestControladorCrearRuta(cin);break;
            case 2:  TestControladorCrearRutaAutomatica();break;
            
            case 3:  TestControladorConsultarCpacitatRuta(cin);break;
            case 4:  TestControladorConsultarDistanciaRuta(cin);break;
            case 5:  TestControladorConsultarPlanetaARuta(cin);break;
            case 6:  TestControladorConsultarPlanetaBRuta(cin);break;
            case 7:  TestControladorConsultarBidireccionalRuta(cin);break;
            case 8:  TestControladorConsultarExisteRuta(cin);break;
            
            case 9:  TestControladorModificarIdRuta(cin);break;
            case 10: TestControladorModificarCpacitatRuta(cin);break;
            case 11: TestControladorModificarDistanciaRuta(cin);break;
            case 12: TestControladorModificarPlanetaARuta(cin);break;
            case 13: TestControladorModificarPlanetaBRuta(cin);break;
            case 14: TestControladorModificarBidireccionalRuta(cin);break;
            
            case 15: TestControladorBorrarRuta(cin);break;
            
            //case 16: TestControladorBuscarRuta(cin);break;
            	
            default: System.out.println("Opcio incorrecte");
            }
        }
        n = cin.nextInt();
    }
    
    public void mirar_entero(Scanner sc) throws Exception
    {
    	while(!sc.hasNextInt()){
			String s = sc.nextLine();
			throw new Exception("Error: Tiene que entrar un entero\n");
		}
    }
    
    public void mirar_booleano(Scanner sc) throws Exception
    {
    	while(!sc.hasNextBoolean()){
			String s = sc.nextLine();
			throw new Exception("Error: Tiene que entrar un string\n");
		}
    }
       
	public void  TestControladorCrearRuta(Scanner cin) throws Exception
	{
		try {
			mirar_entero(cin);
			int id = cin.nextInt();
			
			mirar_entero(cin);
			int capacidad = cin.nextInt();
			
			mirar_entero(cin);
			int distancia = cin.nextInt();
			
			mirar_entero(cin);
			int planetaA = cin.nextInt();
			
			mirar_entero(cin);
			int planetaB = cin.nextInt();
			
			mirar_booleano(cin);
			boolean bidireccional = cin.nextBoolean();
			
			c.CrearRuta(id, capacidad, distancia, planetaA, planetaB, bidireccional, cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorCrearRutaAutomatica() throws Exception
	{
		try {
			c.CrearRuta_automatica(cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}

		
	public void TestControladorConsultarCpacitatRuta(Scanner cin) throws Exception
	{
		try {
			System.out.println(c.ConsultarCapacidadRuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarDistanciaRuta(Scanner cin) throws Exception
	{
		try {
			System.out.println(c.ConsultarDistanciaRuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarPlanetaARuta(Scanner cin) throws Exception
	{
		try {
			System.out.println(c.ConsultarPlanetaARuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarPlanetaBRuta(Scanner cin) throws Exception
	{
		try {
			System.out.println(c.ConsultarPlanetaBRuta(cin.nextInt()));
		} 
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestControladorConsultarBidireccionalRuta(Scanner cin) throws Exception
	{
		try {
			if (c.ConsultarBidireccionalidadRuta(cin.nextInt())) System.out.println("La ruta es bidireccional");
			else System.out.println("La ruta no es bidireccional");
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarExisteRuta(Scanner cin) throws Exception
	{
		try {
			if ( c.ExisteRuta(cin.nextInt()) ) System.out.println("La ruta si existe");
			else System.out.println("La ruta no existe");
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarIdRuta(Scanner cin) throws Exception 
	{
		try {
			int id_original = cin.nextInt();
			int id_modificado = cin.nextInt();
			c.ModificarIddRuta(id_original, id_modificado);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarCpacitatRuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			c.ModificarCapacidadRuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarDistanciaRuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			c.ModificarDistanciaRuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaARuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			c.ModificarPlanetaARuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaBRuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			c.ModificarPlanetaBRuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestControladorModificarBidireccionalRuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			c.ModificarBidireccionalidadRuta(id, cin.nextBoolean());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	

	public void TestControladorBorrarRuta(Scanner cin) throws Exception
	{
		try {
			int id = cin.nextInt();
			c.BorrarRuta(id);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	/* NO SE SI DEBERIA PONER ESA CLASE!!
	public void TestControladorBuscarRuta(Scanner  cin)
	{
		try {
			int id = cin.nextInt();
			
		}
		catch (Exception e){
            System.out.print(e);
		}
		
	}
	*/
	
}

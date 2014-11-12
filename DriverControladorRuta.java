import java.util.*;

public class DriverControladorRuta {
	private ControladorRuta cr;
	private ControladorPlaneta cp;
    private Scanner cin = new Scanner(System.in);

    public void Executa(ControladorRuta c, ControladorPlaneta cplaneta) throws Exception {
    	cr = c;
    	cp = cplaneta;
        int n;
            System.out.print(
              "-----------------------------------------------------------------------------------"
            + "                               DRIVER RUTA                                         "
            + "-----------------------------------------------------------------------------------"
            + "\n\nCREACIO RUTA \n"
            + " 0: Sortir de la gestio del driver\n"
            + " 1: CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional) \n"
            + " 2: CrearRuta_automatica(ControladorPlaneta cp)"
            
            + "\n\nOPERACIONS DE CONSULTA DE RUTA \n"
            + " 3: ConsultarCapacidadRuta(int id) \n"       
            + " 4: ConsultarDistanciaRuta(int id) \n"       
            + " 5: ConsultarPlanetaARuta(int id) \n"       
            + " 6: ConsultarPlanetaBRuta(int id) \n"       
            + " 7: ConsultarBidireccionalidadRuta(int id) \n"
            + " 8: ExisteRuta(int id)\n"
            
            + "\n\nOPERACIONS MODIFICADORES DE RUTA \n"
            + " 9: ModificarIddRuta(int id_original, int id_nuevo, ControladorPlaneta cp) \n"    
            + " 10: ModificarCapacidadRuta(int id, int capacidad nueva, ControladorPlaneta cp) \n"       
            + " 11: ModificarDistanciaRuta(int id, int distancia_nueva) \n"       
            + " 12: ModificarPlanetaARuta(int id, int id_planetaA_nuevo, ControladorPlaneta cp) \n"       
            + " 13: ModificarPlanetaBRuta(int id, int id_planetaB_nuevo, ControladorPlaneta cp) \n"       
            + " 14: ModificarBidireccionalidadRuta(int id, boolean bidireccional, ControladorPlaneta cp) \n"
            
            + " \nOPERACIONS PER BORRAR RUTES \n"
            + " 15: BorrarRuta(int id, ControladorPlaneta cp) \n"
            + " 16: BorrarRuta_desdePlaneta(ind id) \n"
            
 			+ " \nALTRES OPERACIONS QUE CONTIENE EL CONTROLADOR \n"
 			+ " 17: BuscarRuta(int id) \n"
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
            case 16: TestControladorBorrarRutaDesdePlaneta(cin);break;
            
            case 17: TestControladorBuscarRuta(cin);break;
            	
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
    
    public boolean leer_booleano(Scanner cin) throws Exception 
    {	
    	mirar_entero(cin);
    	if (cin.nextInt() == 1) return true;
    	else return false;
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
			
			leer_booleano(cin);
			boolean bidireccional = leer_booleano(cin);
			
			cr.CrearRuta(id, capacidad, distancia, planetaA, planetaB, bidireccional, cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorCrearRutaAutomatica() throws Exception
	{
		try {
			cr.CrearRuta_automatica(cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}

		
	public void TestControladorConsultarCpacitatRuta(Scanner cin) throws Exception
	{
		try {
			System.out.println(cr.ConsultarCapacidadRuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarDistanciaRuta(Scanner cin) throws Exception
	{
		try {
			System.out.println(cr.ConsultarDistanciaRuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarPlanetaARuta(Scanner cin) throws Exception
	{
		try {
			System.out.println(cr.ConsultarPlanetaARuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarPlanetaBRuta(Scanner cin) throws Exception
	{
		try {
			System.out.println(cr.ConsultarPlanetaBRuta(cin.nextInt()));
		} 
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestControladorConsultarBidireccionalRuta(Scanner cin) throws Exception
	{
		try {
			if (cr.ConsultarBidireccionalidadRuta(cin.nextInt())) System.out.println("La ruta es bidireccional");
			else System.out.println("La ruta no es bidireccional");
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarExisteRuta(Scanner cin) throws Exception
	{
		try {
			if ( cr.ExisteRuta(cin.nextInt()) ) System.out.println("La ruta si existe");
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
			cr.ModificarIddRuta(id_original, id_modificado, cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarCpacitatRuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarCapacidadRuta(id, cin.nextInt(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarDistanciaRuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarDistanciaRuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaARuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarPlanetaARuta(id, cin.nextInt(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaBRuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarPlanetaBRuta(id, cin.nextInt(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestControladorModificarBidireccionalRuta(Scanner cin) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarBidireccionalidadRuta(id, cin.nextBoolean(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorBorrarRuta(Scanner cin) throws Exception
	{
		try {
			int id = cin.nextInt();
			cr.BorrarRuta(id, cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorBorrarRutaDesdePlaneta(Scanner cin) throws Exception{
		try {
			int id = cin.nextInt();
			cr.BorrarRuta_desdePlaneta(id);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorBuscarRuta(Scanner  cin)
	{
		try {
			int id = cin.nextInt();
			
		}
		catch (Exception e){
            System.out.print(e);
		}
		
	}	
}

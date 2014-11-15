import java.util.*;

public class DriverControladorRuta {
	private ControladorRuta cr;
	private ControladorPlaneta cp;
    private Scanner cin = new Scanner(System.in);

    public void opcions()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------"
              + "                               DRIVER CONTROLADOR RUTA                                         "
              + "-----------------------------------------------------------------------------------"
              + "\n\nCREACION RUTA \n"
              + " 0:  Salir de la gestion del driver\n"
              + " 1:  CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional, ControladorPlaneta cp) \n"
              + " 2:  CrearRuta_automatica(ControladorPlaneta cp)\n"
              + " 3:  CrearRuta_automatica(ControladorPlaneta cp, int id)\n"
              
              + "\n\nOPERACIONES DE CONSULTA DE RUTA \n"
              + " 4:  ConsultarCapacidadRuta(int id) \n"       
              + " 5:  ConsultarDistanciaRuta(int id) \n"       
              + " 6:  ConsultarPlanetaARuta(int id) \n"       
              + " 7:  ConsultarPlanetaBRuta(int id) \n"       
              + " 8:  ConsultarBidireccionalidadRuta(int id) \n"
              + " 9:  Consultar_numero_rutes()\n" 
              + " 10: Consultar_arbre_conexions()\n"
              + " 11: Consultar_entrades_planeta(int id_planeta)\n"
              + " 12: Consultar_sortides_planeta(int id_planeta)\n"
              + " 13: Consultar_ids_rutas()\n"
              + " 14: ExisteConexion(int id)\n"
              + " 15: ExisteRuta(int id)\n"
              + " 16: BuscarConexion(int id)\n"
              + " 17: BuscarRuta(int id)\n"
              
              + "\n\nOPERACIONES MODIFICADORAS DE RUTA \n"
              + " 18: ModificarIddRuta(int id_original, int id_nuevo, ControladorPlaneta cp) \n"    
              + " 19: ModificarCapacidadRuta(int id, int capacidad nueva, ControladorPlaneta cp) \n"       
              + " 20: ModificarDistanciaRuta(int id, int distancia_nueva) \n"       
              + " 21: ModificarPlanetaARuta(int id, int id_planetaA_nuevo) \n"       
              + " 22: ModificarPlanetaBRuta(int id, int id_planetaB_nuevo) \n"    
              + " 23: Invertir_planetaA_planetaB(int id)"
              + " 24: ModificarBidireccionalidadRuta(int id, boolean bidireccional) \n"
              
              + " \nOPERACIONES PERA BORRAR RUTAS \n"
              + " 25: BorrarRutaConexions_desdePlaneta(int id_planeta)"
              + " 26: BorrarRuta(int id, ControladorPlaneta cp) \n"
      		);
    }
    
    public void Executa(ControladorRuta c, ControladorPlaneta cplaneta) throws Exception {
    	cr = c;
    	cp = cplaneta;
        int n;
        opcions();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
	            case 1:   TestControladorCrearRuta();break;
	            case 2:   TestControladorCrearRutaAutomatica1();break;
	            case 3:   TestControladorCrearRutaAutomatica2();break;
	
	            case 4:   TestControladorConsultarCpacitatRuta();break;
	            case 5:   TestControladorConsultarDistanciaRuta();break;
	            case 6:   TestControladorConsultarPlanetaARuta();break;
	            case 7:   TestControladorConsultarPlanetaBRuta();break;
	            case 8:   TestControladorConsultarBidireccionalRuta();break;
	            case 9:   TestControladorConsultar_numero_rutes();break;
	            case 10:  TestConsultar_arbre_conexions();break;
	            case 11:  TestControladorConsultar_entrades_planeta();break;
	            case 12:  TestControladorConsultar_sortides_planeta();break;
	            case 13:  TestControladorExisteConexion();break;
	            case 14:  TestControladorConsultarExisteRuta();break;
	            case 15:  TestControladorBuscarConexion();break;
	            case 16:  TestControladorBuscarRuta();break;
	            
	            case 17: TestControladorModificarIdRuta();break;
	            case 18: TestControladorModificarCpacitatRuta();break;
	            case 19: TestControladorModificarDistanciaRuta();break;
	            case 20: TestControladorModificarPlanetaARuta();break;
	            case 21: TestControladorModificarPlanetaBRuta();break;
	            case 22: TestControladorInvertir_planetaA_planetaB();break;
	            case 23: TestControladorModificarBidireccionalRuta();break;
	            
	            case 24: TestControladorBorrarRutaConexions_desdePlaneta();break;
	            case 25: TestControladorBorrarRuta();break;
	            	
	            default: System.out.println("Opcion incorrecta");
            }
            opcions();
            n = cin.nextInt();
        }
    }
    
    public void escriu_arraylist(ArrayList<Integer> e)
    {
    	for( int i = 0 ; i < e.size() ; i++ ){
    		  System.out.println( e.get(i) );
		}
    }
    
    public void escriu_id_conexions(TreeSet<Conexion> C) throws Exception 
    {
		Iterator<Conexion> it = C.iterator();
		Conexion aux = new Conexion();
		while(it.hasNext()){
			aux = it.next();
			System.out.println( aux.consultar_id() );
		}
    }
    
    public boolean leer_booleano() throws Exception 
    {	
    	if (cin.nextInt() == 1) return true;
    	else return false;
    }
    
	public void  TestControladorCrearRuta() throws Exception
	{
		try {
			int id = cin.nextInt();
			
			int capacidad = cin.nextInt();
			
			int distancia = cin.nextInt();
			
			int planetaA = cin.nextInt();
			
			int planetaB = cin.nextInt();
			
			boolean bidireccional = leer_booleano();
			
			cr.CrearRuta(id, capacidad, distancia, planetaA, planetaB, bidireccional, cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorCrearRutaAutomatica1() throws Exception
	{
		try {
			cr.CrearRuta_automatica(cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorCrearRutaAutomatica2() throws Exception
	{
		try {
			cr.CrearRuta_automatica(cp, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}

		
	public void TestControladorConsultarCpacitatRuta() throws Exception
	{
		try {
			System.out.println(cr.ConsultarCapacidadRuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarDistanciaRuta() throws Exception
	{
		try {
			System.out.println(cr.ConsultarDistanciaRuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarPlanetaARuta() throws Exception
	{
		try {
			System.out.println(cr.ConsultarPlanetaARuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarPlanetaBRuta() throws Exception
	{
		try {
			System.out.println(cr.ConsultarPlanetaBRuta(cin.nextInt()));
		} 
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestControladorConsultarBidireccionalRuta() throws Exception
	{
		try {
			if (cr.ConsultarBidireccionalidadRuta(cin.nextInt())) System.out.println("La ruta es bidireccional");
			else System.out.println("La ruta no es bidireccional");
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
    public void TestControladorConsultar_numero_rutes()
    {
		try {
			System.out.println(cr.Consultar_numero_rutes());
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestConsultar_arbre_conexions()
    {
		try {
			TreeSet<Conexion> C = cr.Consultar_arbre_conexions();
			escriu_id_conexions(C);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    
    public void TestControladorConsultar_entrades_planeta()
    {
		try {
			ArrayList<Integer> entrades = cr.Consultar_entrades_planeta(cin.nextInt());
			escriu_arraylist(entrades);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestControladorConsultar_sortides_planeta()
    {
		try {
			ArrayList<Integer> sortides = cr.Consultar_sortides_planeta(cin.nextInt());
			escriu_arraylist(sortides);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    
	public void  TestControladorExisteConexion() throws Exception
	{
		try {
			if ( cr.ExisteConexion(cin.nextInt()) ) System.out.println("La conexion si existe");
			else System.out.println("La conexion no existe");
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorBuscarConexion() throws Exception
	{
		try {
			Conexion c = cr.BuscarConexion(cin.nextInt());
			System.out.println("La conexion que ha devuelto la funcion tiene la id = " + c.consultar_id());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorBuscarRuta()
	{
		try {
			Ruta r = cr.BuscarRuta(cin.nextInt());
			System.out.println("La ruta que ha devuelto la funcion tiene la id = " + r.consultar_id());

		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarExisteRuta() throws Exception
	{
		try {
			if ( cr.ExisteRuta(cin.nextInt()) ) System.out.println("La ruta si existe");
			else System.out.println("La ruta no existe");
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarIdRuta() throws Exception 
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
	
	public void TestControladorModificarCpacitatRuta() throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarCapacidadRuta(id, cin.nextInt(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarDistanciaRuta() throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarDistanciaRuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaARuta() throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarPlanetaARuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaBRuta() throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarPlanetaBRuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestControladorModificarBidireccionalRuta() throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarBidireccionalidadRuta(id, cin.nextBoolean());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
    public void TestControladorInvertir_planetaA_planetaB()
    {
		try {
			cr.Invertir_planetaA_planetaB(cin.nextInt(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestControladorBorrarRutaConexions_desdePlaneta()
    {
		try {
			cr.BorrarRutaConexions_desdePlaneta( cin.nextInt() );
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
	
	public void TestControladorBorrarRuta() throws Exception
	{
		try {
			cr.BorrarRuta(cin.nextInt(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorBorrarRutaDesdePlaneta() throws Exception{
		try {
			cr.BorrarRutaConexions_desdePlaneta( cin.nextInt() );
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}

import java.util.*;

public class DriverControladorRuta {
    public void opcions()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------\n"
              + "                               DRIVER CONTROLADOR RUTA                                         \n"
              + "-----------------------------------------------------------------------------------\n"
              + " 0:  Salir de la gestion del driver\n"
              + " 1:  CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional, ControladorPlaneta cp) \n"
              + " 2:  CrearRuta_automatica(ControladorPlaneta cp)\n"
              + " 3:  CrearRuta_automatica(ControladorPlaneta cp, int id)\n"
              
              + " 4:  ConsultarCapacidadRuta(int id) \n"       
              + " 5:  ConsultarDistanciaRuta(int id) \n"       
              + " 6:  ConsultarPlanetaARuta(int id) \n"       
              + " 7:  ConsultarPlanetaBRuta(int id) \n"       
              + " 8:  Consultar_numero_rutes()\n" 
              + " 9: Consultar_arbre_conexions()\n"
              + " 10: Consultar_entrades_planeta(int id_planeta)\n"
              + " 11: Consultar_sortides_planeta(int id_planeta)\n"
              + " 12: Consultar_ids_rutas()\n"
              + " 13: ExisteConexion(int id)\n"
              + " 14: ExisteRuta(int id)\n"
              + " 15: BuscarConexion(int id)\n"
              + " 16: BuscarRuta(int id)\n"
              + " 17: Consultar_Conexiones()\n"
              + " 18: Consultar_id_ruta(String planetaA, String planetaB) \n"
              
              + " 19: ModificarCapacidadRuta(int id, int capacidad nueva, ControladorPlaneta cp) \n"       
              + " 20: ModificarDistanciaRuta(int id, int distancia_nueva) \n"       
              + " 21: ModificarPlanetaARuta(int id, int id_planetaA_nuevo) \n"       
              + " 22: ModificarPlanetaBRuta(int id, int id_planetaB_nuevo) \n"    
              
              + " 23: BorrarRutaConexions(int id_planeta)\n"
              + " 24: BorrarRuta(int id) \n"
              + " 25: Borrar_Rutas() \n"
              
              + " 26: Cargar_Rutas() \n"
              + " 27: Guardar_Rutas() \n"

      		);
    }
    
    public void Executa(ControladorRuta cr, ControladorPlaneta cp, Scanner cin) throws Exception {
        int n;
        opcions();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
	            case 1:   TestControladorCrearRuta(cin, cr, cp);break;
	            case 2:   TestControladorCrearRutaAutomatica1(cr,cp);break;
	            case 3:   TestControladorCrearRutaAutomatica2(cin,cr,cp);break;
	
	            case 4:   TestControladorConsultarCpacitatRuta(cin, cr);break;
	            case 5:   TestControladorConsultarDistanciaRuta(cin, cr);break;
	            case 6:   TestControladorConsultarPlanetaARuta(cin,cr);break;
	            case 7:   TestControladorConsultarPlanetaBRuta(cin,cr);break;
	            case 8:   TestControladorConsultar_numero_rutes(cr);break;
	            case 9:  TestConsultar_arbre_conexions(cr);break;
	            case 10:  TestControladorConsultar_entrades_planeta(cin,cr);break;
	            case 11:  TestControladorConsultar_sortides_planeta(cin,cr);break;
	            case 12:  TestControladorConsultar_ids_rutas(cr);break;
	            case 13:  TestControladorExisteConexion(cin,cr);break;
	            case 14:  TestControladorConsultarExisteRuta(cin,cr);break;
	            case 15:  TestControladorBuscarConexion(cin,cr);break;
	            case 16:  TestControladorBuscarRuta(cin,cr);break;
	            case 17:  TestControladorConsultarConexiones(cr);break;
	            case 18:  TestConsultaridruta(cin, cr);break;
	            
	            case 19: TestControladorModificarCpacitatRuta(cin,cr);break;
	            case 20: TestControladorModificarDistanciaRuta(cin,cr);break;
	            case 21: TestControladorModificarPlanetaARuta(cin,cr,cp);break;
	            case 22: TestControladorModificarPlanetaBRuta(cin,cr,cp);break;
	            
	              
	            case 23: TestControladorBorrarRutaConexions_desdePlaneta(cin,cr);break;
	            case 24: TestControladorBorrarRuta(cin,cr,cp);break;
	            case 25: TestControladorBorrarTodasRutas(cin,cr);break;
	              
	            case 26: TestControladorCargarRutas(cin,cr,cp);break;
	            case 27: TestControladorGuardarRutas(cin,cr);break;
	            default: System.out.println("Opcion incorrecta");
            }
            n = cin.nextInt();
        }
    }
    
    
    public void TestConsultaridruta(Scanner cin, ControladorRuta cr)
    {
    	try {
    		String a = cin.next();
    		String b = cin.next();
    		if (cr.Consultar_id_ruta(a,b) == -1) System.out.println( "No existe ruta que conecte esos dos planetas" );
    		else System.out.println(cr.Consultar_id_ruta(a,b) );
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void  TestControladorGuardarRutas(Scanner cin, ControladorRuta cr)
    {
    	try {
    		cr.GuardarRutas( cin.next() );
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void  TestControladorCargarRutas(Scanner cin, ControladorRuta cr, ControladorPlaneta cp)
    {
    	try {
    		cr.CargarRutas( cin.next(),cp );
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void  TestControladorBorrarTodasRutas(Scanner cin, ControladorRuta cr)
    {
    	try {
    		cr.BorrarRutas();
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    
    public void escriu_arraylist_conexions (ArrayList<Conexion> c) throws Exception
    {
		Iterator<Conexion> it = c.iterator();
		Conexion aux;
		while( it.hasNext() ){
			aux = it.next();
            System.out.println(aux.consultar_id()+" ");
		}
    }
    
    public void  TestControladorConsultarConexiones(ControladorRuta cr)
    {
    	try {
    		ArrayList<Conexion> c = new ArrayList<Conexion>();
    		c = cr.Consultar_Conexiones();
    		escriu_arraylist_conexions(c);    		
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    
    public void TestControladorConsultar_ids_rutas(ControladorRuta cr)
    {
    	try {
    		ArrayList<Integer> c = new ArrayList<Integer>();
    		c = cr.Consultar_ids_rutas();
    		escriu_arraylist(c);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void escriu_arraylist(ArrayList<Integer> e)
    {
    	for( int i = 0 ; i < e.size() ; i++ ){
    		  System.out.println( e.get(i)+" " );
		}
    }
    
    public void escriu_id_conexions(TST<Conexion> C) throws Exception 
    {
    	ArrayList<Conexion> c = C.MostrarElementos();

		Iterator<Conexion> it = c.iterator();
		Conexion aux;
		while(it.hasNext()){
			aux = it.next();
			System.out.println( aux.consultar_id() + " ");
		}
    }
    
    public boolean leer_booleano(Scanner cin) throws Exception 
    {	
    	if (cin.nextInt() == 1) return true;
    	else return false;
    }
    
	public void  TestControladorCrearRuta(Scanner cin, ControladorRuta cr, ControladorPlaneta cp) throws Exception
	{
		try {
			int id = cin.nextInt();
			int capacidad = cin.nextInt();
			int distancia = cin.nextInt();
			String planetaA = cin.next();
			String planetaB = cin.next();
			cr.CrearRuta(id, capacidad, distancia, planetaA, planetaB, cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorCrearRutaAutomatica1(ControladorRuta cr, ControladorPlaneta cp) throws Exception
	{
		try {
			cr.CrearRuta_automatica(cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorCrearRutaAutomatica2(Scanner cin,ControladorRuta cr, ControladorPlaneta cp) throws Exception
	{
		try {
			cr.CrearRuta_automatica(cp, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}

		
	public void TestControladorConsultarCpacitatRuta(Scanner cin, ControladorRuta cr) throws Exception
	{
		try {
			System.out.println(cr.ConsultarCapacidadRuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarDistanciaRuta(Scanner cin, ControladorRuta cr) throws Exception
	{
		try {
			System.out.println(cr.ConsultarDistanciaRuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarPlanetaARuta(Scanner cin, ControladorRuta cr) throws Exception
	{
		try {
			System.out.println(cr.ConsultarPlanetaARuta(cin.nextInt()));
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarPlanetaBRuta(Scanner cin, ControladorRuta cr) throws Exception
	{
		try {
			System.out.println(cr.ConsultarPlanetaBRuta(cin.nextInt()));
		} 
		catch (Exception e){
            System.out.print(e);
		}
	}
		
    public void TestControladorConsultar_numero_rutes(ControladorRuta cr)
    {
		try {
			System.out.println(cr.Consultar_numero_rutes());
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestConsultar_arbre_conexions(ControladorRuta cr)
    {
		try {
			TST<Conexion> C = cr.Consultar_arbre_conexions();
			escriu_id_conexions(C);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    
    public void TestControladorConsultar_entrades_planeta(Scanner cin, ControladorRuta cr)
    {
		try {
			ArrayList<Integer> entrades = cr.Consultar_entrades_planeta(cin.next());
			escriu_arraylist(entrades);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestControladorConsultar_sortides_planeta(Scanner cin, ControladorRuta cr)
    {
		try {
			ArrayList<Integer> sortides = cr.Consultar_sortides_planeta(cin.next());
			escriu_arraylist(sortides);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    
	public void  TestControladorExisteConexion(Scanner cin, ControladorRuta cr) throws Exception
	{
		try {
			if ( cr.ExisteConexion(cin.nextInt()) ) System.out.println("La conexion si existe");
			else System.out.println("La conexion no existe");
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorBuscarConexion(Scanner cin, ControladorRuta cr) throws Exception
	{
		try {
			Conexion c = cr.BuscarConexion(cin.nextInt());
			System.out.println("La conexion que ha devuelto la funcion tiene la id = " + c.consultar_id());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorBuscarRuta(Scanner cin, ControladorRuta cr)
	{
		try {
			Ruta r = cr.BuscarRuta(cin.nextInt());
			System.out.println("La ruta que ha devuelto la funcion tiene la id = " + r.consultar_id());

		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorConsultarExisteRuta(Scanner cin, ControladorRuta cr) throws Exception
	{
		try {
			if ( cr.ExisteRuta(cin.nextInt()) ) System.out.println("La ruta si existe");
			else System.out.println("La ruta no existe");
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarCpacitatRuta(Scanner cin, ControladorRuta cr) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarCapacidadRuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarDistanciaRuta(Scanner cin, ControladorRuta cr) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarDistanciaRuta(id, cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaARuta(Scanner cin, ControladorRuta cr, ControladorPlaneta cp) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarPlanetaARuta(id, cin.next(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaBRuta(Scanner cin, ControladorRuta cr, ControladorPlaneta cp) throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarPlanetaBRuta(id, cin.next(),cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
    public void TestControladorBorrarRutaConexions_desdePlaneta(Scanner cin, ControladorRuta cr)
    {
		try {
			cr.BorrarRutaConexions( cin.next() );
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
	
	public void TestControladorBorrarRuta(Scanner cin, ControladorRuta cr, ControladorPlaneta cp) throws Exception
	{
		try {
			cr.BorrarRuta(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestControladorBorrarRutaDesdePlaneta(Scanner cin, ControladorRuta cr) throws Exception{
		try {
			cr.BorrarRutaConexions( cin.next());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}

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
              + " 18: Consultar_Conexiones()\n"

              + "\n\nOPERACIONES MODIFICADORAS DE RUTA \n"
              + " 19: ModificarIddRuta(int id_original, int id_nuevo, ControladorPlaneta cp) \n"    
              + " 20: ModificarCapacidadRuta(int id, int capacidad nueva, ControladorPlaneta cp) \n"       
              + " 21: ModificarDistanciaRuta(int id, int distancia_nueva) \n"       
              + " 22: ModificarPlanetaARuta(int id, int id_planetaA_nuevo) \n"       
              + " 23: ModificarPlanetaBRuta(int id, int id_planetaB_nuevo) \n"    
              + " 24: Invertir_planetaA_planetaB(int id)\n"
              + " 25: ModificarBidireccionalidadRuta(int id, boolean bidireccional) \n"
              
              + " \nOPERACIONES PERA BORRAR RUTAS \n"
              + " 26: BorrarRutaConexions(int id_planeta)\n"
              + " 27: BorrarRuta(int id, ControladorPlaneta cp) \n"
              + " 28: Borrar_Conexion(int id) \n"
              + " 29: Borrar_Rutas() \n"
              
              + " \nOPERACIONES CARGAR/GUARDAR \n"
              + " 30: Cargar_Rutas() \n"
              + " 31: Guardar_Rutas() \n"

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
	            case 13:  TestControladorConsultar_ids_rutas();break;
	            case 14:  TestControladorExisteConexion();break;
	            case 15:  TestControladorConsultarExisteRuta();break;
	            case 16:  TestControladorBuscarConexion();break;
	            case 17:  TestControladorBuscarRuta();break;
	            case 18:  TestControladorConsultarConexiones();break;
	            
	            case 19: TestControladorModificarIdRuta();break;
	            case 20: TestControladorModificarCpacitatRuta();break;
	            case 21: TestControladorModificarDistanciaRuta();break;
	            case 22: TestControladorModificarPlanetaARuta();break;
	            case 23: TestControladorModificarPlanetaBRuta();break;
	            case 24: TestControladorInvertir_planetaA_planetaB();break;
	            case 25: TestControladorModificarBidireccionalRuta();break;
	            
	              
	            case 26: TestControladorBorrarRutaConexions_desdePlaneta();break;
	            case 27: TestControladorBorrarRuta();break;
	            case 28: TestControladorBorrarConexion();break;
	            case 29: TestControladorBorrarTodasRutas();break;
	              
	            case 30: TestControladorCargarRutas();break;
	            case 31: TestControladorGuardarRutas();break;
	            default: System.out.println("Opcion incorrecta");
            }
            opcions();
            n = cin.nextInt();
        }
    }
    
    public void  TestControladorGuardarRutas()
    {
    	try {
    		cr.GuardarRutas( cin.next() );
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void  TestControladorCargarRutas()
    {
    	try {
    		cr.CargarRutas( cin.next() );
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void  TestControladorBorrarTodasRutas()
    {
    	try {
    		cr.BorrarRutas();
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void  TestControladorBorrarConexion()
    {
    	try {
    		cr.Borrar_Conexion( cin.nextInt() );   		
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void escriu_arraylist_conexions (ArrayList<Conexion> c) throws Exception
    {
    	for( Conexion con : c ){
    		con.consultar_id();
		}
    }
    
    public void  TestControladorConsultarConexiones()
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
    
    
    public void TestControladorConsultar_ids_rutas()
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
			
			//boolean bidireccional = leer_booleano();
			
			boolean bidireccional = cin.nextBoolean();
			
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
			cr.ModificarPlanetaARuta(id, cin.nextInt(), cp);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestControladorModificarPlanetaBRuta() throws Exception 
	{
		try {
			int id = cin.nextInt();
			cr.ModificarPlanetaBRuta(id, cin.nextInt(),cp);
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
			cr.BorrarRutaConexions( cin.nextInt() );
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
			cr.BorrarRutaConexions( cin.nextInt() );
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}

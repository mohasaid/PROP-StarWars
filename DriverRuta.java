import java.util.*;

public class DriverRuta {
	private Ruta r;
    private Scanner cin = new Scanner(System.in);

    public void opciones()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------"
                +   "                               DRIVER RUTA                                      "
                +   "-----------------------------------------------------------------------------------"
                + "\n\nCREACION RUTA\n"
                + " 0: Salir de la gestion del driver \n"
                + " 1: Ruta() \n"
                + " 2: CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional) \n"
                
                + "\n\nOPERACIONES DE CONSULTA DE RUTA\n"
                + " 3: consultar_id() \n"    
                + " 4: consultar_capacidad() \n"       
                + " 5: consultar_distancia() \n"       
                
                + "\n\nOPERACIONES MODIFICADORAS DE RUTA\n"
                + " 6: modificar_id() \n"    
                + " 7: modificar_capacidad() \n"       
                + " 8: modificar_distancia() \n"       

    			);
    }
    
    public void Executa(Ruta r1) throws Exception {
        int n;
        r = r1;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearRutaBuida();break;
            case 2:  TestCrearRuta2(cin);break;
            case 3:  TestConsultarIdRuta();break;
            case 4:  TestConsultarCpacitatRuta();break;
            case 5:  TestConsultarDistanciaRuta();break;
            case 6:  TestModificarIdRuta(cin);break;
            case 7: TestModificarCpacitatRuta(cin);break;
            case 8: TestModificarDistanciaRuta(cin);break;
            default: System.out.println("Opcion incorrecta");
            }
        opciones();
        n = cin.nextInt();
        }
    }
    
	public void TestCrearRutaBuida()
	{
		try {
			r = new Ruta();
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void  TestCrearRuta2(Scanner cin) throws Exception
	{
		try {
			int id = cin.nextInt();
			int capacidad = cin.nextInt();
			int distancia = cin.nextInt();
			r =  new Ruta(id, capacidad, distancia);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarIdRuta() throws Exception
	{
		try {
			System.out.println(r.consultar_id());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarCpacitatRuta() throws Exception
	{
		try {
			System.out.println(r.consultar_capacidad());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarDistanciaRuta() throws Exception
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

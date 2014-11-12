import java.util.*;
import java.text.NumberFormat;

public class DriverRuta {
	private Ruta r;
    private Scanner cin = new Scanner(System.in);

    public void opciones()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------"
                +   "                               DRIVER RUTA                                      "
                +   "-----------------------------------------------------------------------------------"
                + "\n\nCREACIO RUTA\n"
                + " 0: Sortir de la gestio del driver \n"
                + " 1: Ruta() \n"
                + " 2: CrearRuta(int id, int capacidad, int distancia, int planetaA, int planetaB, boolean bidireccional) \n"
                
                + "\n\nOPERACIONS DE CONSULTA DE RUTA\n"
                + " 3: consultar_id() \n"    
                + " 4: consultar_capacidad() \n"       
                + " 5: consultar_distancia() \n"       
                + " 6: consultar_planetaA() \n"       
                + " 7: consultar_planetaB() \n"       
                + " 8: consultar_bidireccional() \n"
                
                + "\n\nOPERACIONS MODIFICADORES DE RUTA\n"
                + " 9:  modificar_id() \n"    
                + " 10: modificar_capacidad() \n"       
                + " 11: modificar_distancia() \n"       
                + " 12: modificar_planetaA() \n"       
                + " 13: modificar_planetaB() \n"       
                + " 14: modificar_bidireccional() \n"
                + " 15: invertir_planetas() \n"

    			);
    }
    
    public void Executa(Ruta r) throws Exception {
        int n;
        this.r = r;
        opciones();
        n = cin.nextInt();
        while(n != 0) {
            switch(n) {
            case 1:  TestCrearRutaBuida();break;
            case 2:  TestCrearRuta2(cin);break;
            case 3:  TestConsultarIdRuta();break;
            case 4:  TestConsultarCpacitatRuta();break;
            case 5:  TestConsultarDistanciaRuta();break;
            case 6:  TestConsultarPlanetaARuta();break;
            case 7:  TestConsultarPlanetaBRuta();break;
            case 8:  TestConsultarBidireccionalRuta();break;
            case 9:  TestModificarIdRuta(cin);break;
            case 10: TestModificarCpacitatRuta(cin);break;
            case 11: TestModificarDistanciaRuta(cin);break;
            case 12: TestModificarPlanetaARuta(cin);break;
            case 13: TestModificarPlanetaBRuta(cin);break;
            case 14: TestModificarBidireccionalRuta(cin);break;
            case 15: TestInvertirPlanetasRuta();
            default: System.out.println("Opcio incorrecte");
            }
        opciones();
        n = cin.nextInt();
        }
    }
    
    public void TestInvertirPlanetasRuta() throws Exception {
    	try{
    		r.invertir_planetas();
    	}
		catch (Exception e){
	        System.out.print(e);
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
			int planetaA = cin.nextInt();
			int planetaB = cin.nextInt();
			boolean bidireccional;
			if ( cin.nextInt()==1 ) bidireccional = true;
			else bidireccional = false;
			r =  new Ruta(id, capacidad, distancia, planetaA, planetaB, bidireccional);
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
	
	public void TestConsultarPlanetaARuta() throws Exception
	{
		try {
			System.out.println(r.consultar_planetaA());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestConsultarPlanetaBRuta() throws Exception
	{
		try {
			System.out.println(r.consultar_planetaB());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestConsultarBidireccionalRuta() throws Exception
	{
		try {
			if (r.consultar_bidireccional()) System.out.println("La ruta es bidireccional");
			else System.out.println("La ruta no es bidireccional");
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
	
	public void TestModificarPlanetaARuta(Scanner cin) throws Exception 
	{
		try {
			r.modificar_planetaA(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
	
	public void TestModificarPlanetaBRuta(Scanner cin) throws Exception 
	{
		try {
			r.modificar_planetaB(cin.nextInt());
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
		
	public void TestModificarBidireccionalRuta(Scanner cin) throws Exception 
	{
		try {
			boolean bid;
			if (cin.nextInt() == 0) bid = false;
			else bid = true;
			r.modificar_bidireccional(bid);
		}
		catch (Exception e){
            System.out.print(e);
		}
	}
}

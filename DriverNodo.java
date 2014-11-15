import java.util.*;

public class DriverNodo {

	private Nodo n;
    private Scanner cin = new Scanner(System.in);

    public void opciones()
    {
    	System.out.print(
                "-----------------------------------------------------------------------------------"
                +   "                               DRIVER RUTA                                      "
                +   "-----------------------------------------------------------------------------------"
                + "\n\nCREACIO RUTA\n"
                + " 0: Sortir de la gestio del driver \n"
                + " 1: Nodo() \n"
                + " 2: Nodo (int ident, boolean es_Yavin, boolean es_Hoth) \n"
                
                + "\n\nOPERACIONS DE CONSULTA DE RUTA\n"
                + " 3: consultar_id() \n"    
                + " 4: consultar_es_Yavin() \n"       
                + " 5: consultar_es_Hoth() \n"       
    			);
    }
    
    public void Executa(Nodo nod) throws Exception {
        n = nod;
        opciones();
        int op = cin.nextInt();
        while(op != 0) {
            switch(op) {
            case 1:  TestCrearNodeBuit();break;
            case 2:  TestCrearNode2(cin);break;
            case 3:  TestConsultarIdNode();break;
            case 4:  TestConsultaresYavin();break;
            case 5:  TestConsultaresHoth();break;
            default: System.out.println("Opcio incorrecte");
            }
        opciones();
        op = cin.nextInt();
        }
    }
    
    public void TestCrearNodeBuit()
    {
		try {
			n = new Nodo();
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestCrearNode2(Scanner cin)
    {
		try {
			int i = cin.nextInt();
			boolean Yavin = cin.nextBoolean();
			boolean Hoth = cin.nextBoolean();
			n = new Nodo( i, Yavin, Hoth );
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestConsultarIdNode()
    {
		try {
			System.out.println(n.consultar_id());
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestConsultaresYavin()
    {
		try {
			System.out.println(n.consultar_es_Yavin());
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestConsultaresHoth()
    {
		try {
			System.out.println(n.consultar_es_Hoth());
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
}

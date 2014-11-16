import java.util.*;

public class DriverEntrada {
	private Entrada e;
    private Scanner cin = new Scanner(System.in);

    public void opciones()
    {
    	System.out.print(
    				"-----------------------------------------------------------------------------------"
                +   "                               DRIVER ENTRADA                                      "
                +   "-----------------------------------------------------------------------------------"
                +   "\n\nCREACIO ENTRADA\n"
                +   " 0: Salir de la gestion del driver \n"
                +   " 1: Entrada() \n"
                +   " 2: Entrada(ControladorGalaxia cg) \n"
                
                +   "\n\nOPERACIONES DE CONSULTA DE ENTRADA\n"
                +   " 3: Consultar_grafo() \n"    
    			);
    }
    
    public void Executa(Entrada en, ControladorGalaxia cg) throws Exception {
        e = en;
        opciones();
        int op = cin.nextInt();
        while(op != 0) {
            switch(op) {
            case 1:  TestCrearEntradaVacia();break;
            case 2:  TestCrearEntrada2(cg);break;
            case 3:  TestConsultarGrafo();break;
            default: System.out.println("Opcio incorrecte");
            }
        opciones();
        op = cin.nextInt();
        }
    }
    
    public void TestCrearEntradaVacia()
    {
		try {
			e = new Entrada();
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestCrearEntrada2(ControladorGalaxia cg)
    {
		try {
			e = new Entrada(cg);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestConsultarGrafo()
    {
		try {
			Grafo g = e.Consultar_grafo();
			//posar alguna cosa per veure que s'ha passat correctament el graf
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
}

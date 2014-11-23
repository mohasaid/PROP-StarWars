import java.util.*;

public class DriverEntrada {
	private Entrada e;
    public void opciones()
    {
    	System.out.print(
    				"-----------------------------------------------------------------------------------\n"
                +   "                               DRIVER ENTRADA                                      \n"
                +   "-----------------------------------------------------------------------------------\n"
                +   "\n\nCREACIO ENTRADA\n"
                +   " 0: Salir de la gestion del driver \n"
                +   " 1: Entrada(ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) \n"
                
                +   "\n\nOPERACIONES DE CONSULTA DE ENTRADA\n"
                +   " 2: Consultar_grafo() \n"    
    			);
    }
    
    public void Executa(ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn, Scanner cin) throws Exception {
        opciones();
        int op = cin.nextInt();
        while(op != 0) {
            switch(op) {
            case 1:  TestCrearEntrada2(cg, cr, cp, cn);break;
            case 2:  TestConsultarGrafo();break;
            default: System.out.println("Opcio incorrecte");
            }
        opciones();
        op = cin.nextInt();
        }
    }

    
    public void TestCrearEntrada2(ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn)
    {
		try {
			e = new Entrada(cg, cr, cp, cn);
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestConsultarGrafo()
    {
		try {
			Grafo g = e.Consultar_grafo();
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
}

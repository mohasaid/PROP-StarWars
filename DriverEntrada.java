import java.util.*;

public class DriverEntrada {
	private Entrada e;
    private Scanner cin = new Scanner(System.in);

    public void opciones()
    {
    	System.out.print(
    				"-----------------------------------------------------------------------------------\n"
                +   "                               DRIVER ENTRADA                                      \n"
                +   "-----------------------------------------------------------------------------------\n"
                +   " 0: Salir de la gestion del driver \n"
                
                +   " 1: Entrada(ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) \n"
                
                +   " 2: Consultar_grafo() \n"    
    			);
    }
    
    public void Executa(Entrada en, ControladorGalaxia cg, ControladorRuta cr, ControladorPlaneta cp, ControladorNave cn) throws Exception {
        e = en;
        opciones();
        int op = cin.nextInt();
        while(op != 0) {
            switch(op) {
            case 1:  TestCrearEntrada2(cin);break;
            case 2:  TestConsultarGrafo();break;
            default: System.out.println("Opcio incorrecte");
            }
        opciones();
        op = cin.nextInt();
        }
    }
    
    public void TestCrearEntrada2(Scanner cin)
    {
		try {
			ArrayList<ArrayList<Pair<Arco, Integer>>> aap = new ArrayList<ArrayList<Pair<Arco, Integer>>>();
			int n_planetes = cin.nextInt();
			int c1, c2, c3;
			for(int i = 0; i < n_planetes; ++i) {
				System.out.println("LEYENDO " + i);
				System.out.println("Introduce numero de vertices que se conectan con el vertice " + i);
				int si = cin.nextInt();
				ArrayList<Pair<Arco, Integer> > rp = new ArrayList<Pair<Arco, Integer> >();
				for(int j = 0; j < si; ++j) {
					System.out.println("Introduce capacidad:");
					c1 = cin.nextInt(); // capacidad
					System.out.println("Introduce coste:");
					c2 = cin.nextInt(); // coste
					System.out.println("Introduce destino:");
					c3 = cin.nextInt();
					Arco c = new Arco(c1,c2);
					Pair<Arco, Integer> pa = new Pair<Arco, Integer>(c,c3);
					rp.add(pa);
				}
				aap.add(rp);
			}
			e = new Entrada(aap);
			cin.close();
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
    
    public void TestConsultarGrafo()
    {
		try {
			Grafo g = e.Consultar_grafo();
			for(int i = 0; i < g.sizeGrafo(); ++i) {
				System.out.println("Del vertice " + i + " sale lo siguiente:");
				for(int j = 0; j < g.sizeGrafo(i); ++j) {
					System.out.println("Arista de capacidad = " + g.consultarPrim(i, j).ConsultarCapacidad()
									 + " y con coste = " + g.consultarPrim(i, j).ConsultarCoste()
									 + " hacia el vertice "+ g.consultarSeg(i, j));
				}
			}
		}
		catch (Exception e){
            System.out.print(e);
		}
    }
}

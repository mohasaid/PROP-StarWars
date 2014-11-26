import java.util.*;

public class DriverEntrada {
	private Entrada e;

	public void opciones()
    {
    	System.out.print(
    				"-----------------------------------------------------------------------------------\n"
                +   "                               DRIVER ENTRADA                                      \n"
                +   "-----------------------------------------------------------------------------------\n"
                +   " 0: Salir de la gestion del driver 												\n"
                
                +   " 1: Entrada() 																		\n"
                
                +   " 2: Consultar_grafo() 																\n"    
    			);
    }
    
    public void Executa() 
    {
    	Scanner cin = new Scanner(System.in);
        opciones();
        int op = cin.nextInt();
        while(op != 0) {
            switch(op) {
	            case 1:  TestCrearEntrada2(cin);break;
	            case 2:  TestConsultarGrafo();break;
	            default: System.out.println("Opcion incorrecta");
            }
        opciones();
        op = cin.nextInt();
        }
    }
    
    // 6 2 16 0 1 13 0 2 2 10 0 2 12 0 3 2 4 0 1 14 0 4 2 9 0 2 20 0 5 2 7 0 3 4 0 5 0
    
    // 4 2 10 2 2 5 3 3 1 10 2 4 1 5 3 4 0
    
    public void TestCrearEntrada2(Scanner cin)
    {
		try {
			Grafo g1 = new Grafo();
			int n_planetes = cin.nextInt();
			int c1, c2, c3;
			for(int i = 0; i < n_planetes; ++i) {
				int si = cin.nextInt();
				ArrayList<Pair<Arco, Integer> > res = new ArrayList<Pair<Arco, Integer>>();
				for(int j = 0; j < si; ++j) {
					c1 = cin.nextInt(); // capacidad
					c2 = cin.nextInt(); // coste
					c3 = cin.nextInt();
					Arco c = new Arco(c1);
					c.ModificarCoste(c2);
					Pair<Arco, Integer> pa = new Pair<Arco, Integer>(c,c3);
					res.add(pa);
				}
				g1.ponG(res);
			}
			e = new Entrada(g1);
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

import java.util.*;

public abstract class MFP {
	protected Grafo g_residual;

	public abstract void Ejecutar(Recorrido r, Salida s);

	public void Calcular_cuellos_botellas (Salida s, ControladorPlaneta cp, ControladorRuta cr) throws Exception
	{
		int V = g_residual.sizeGrafo();
		int origen = V-2;
		
		boolean[] visitados = new boolean[V];
		Arrays.fill(visitados,false);
		visitados[origen] = true;
		
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(origen);
		
		ArrayList<String> pl = cp.consultarPlanetas();
		ArrayList<Conexion> con = cr.Consultar_Conexiones();
		
		while(!q1.isEmpty()) {
			int actual = q1.poll();
			int size = g_residual.sizeGrafo(actual);
			for(int i = 0; i < size; ++i) {
				int adj = g_residual.consultarSeg(actual, i);
				int cap = g_residual.consultarPrim(actual, i).ConsultarCapacidad();
				if(cap != 0 && !visitados[adj]) {
					visitados[adj] = true;
					q1.add(adj);
				}
				if (cap == 0) //tenemos cuello de botella
				{
					String pa = pl.get(actual);
					String pb = pl.get(adj);
					int idr = 0;
					boolean trobat = false;
					for(int k = 0; k < con.size() && !trobat; ++k) {
						if((con.get(k).consultar_planetaA().compareTo(pa) == 0) && (con.get(k).consultar_planetaB().compareTo(pb) == 0)) {
							trobat = true;
							idr = con.get(k).consultar_id();
						}
					}
					s.AnadirCuello(idr);
				}
			}
		}
	}

	public void Caminos(Nave n, int consumo, boolean b, Recorrido r, ControladorPlaneta cp, Salida s) throws Exception
	{
		String origen = n.consultar_origen();
		String destino = n.consultar_destino();
		ArrayList<String> pl = cp.consultarPlanetas();
		int o1 = pl.indexOf(origen);
		int d1 = pl.indexOf(destino);
		
		int path[] = new int[g_residual.sizeGrafo()];
		Arrays.fill(path, -1);
		
		boolean hay = r.Recorrido(g_residual, o1, d1, path);
		
		String res = ""; // contiene camino con nodos
		String planetes = ""; // contiene camino con planetas
		int cTotal = 0;
		if(hay) {
			// guardo el camino de nodos
			Stack<Integer> st = new Stack<Integer>();
			while(d1 != -1) {
				st.push(d1);
				d1 = path[d1];
			}
			while(st.size() > 1) {
				res += st.pop() + ",";
			}
			res += st.pop();
			// Paso de nodos a planetas
			Scanner scan = new Scanner(res);
			scan.useDelimiter(",");
			while(scan.hasNext()) {
				String pa = scan.next();
				Integer pai = Integer.parseInt(pa);
				String pla1 = pl.get(pai);
				planetes += pla1 + ",";
			}
			scan.close();
			// calculo consumo general
			if(b) {
				int a1, a2, tmp = 0; // nodos
				Scanner scan1 = new Scanner(res);
				scan1.useDelimiter(",");
				boolean first = true;
				while(scan1.hasNext()) {
					if(first) {
						String a_1 = scan1.next();
						a1 = Integer.parseInt(a_1);
						String a_2 = scan1.next();
						a2 = Integer.parseInt(a_2);
						int cst = g_residual.consultaPairUn(a1, a2).consultarPrimero().ConsultarCoste();
						cTotal += (cst*consumo);
						tmp = a2;
						first = false;
					}
					else {
						String a_11 = scan1.next();
						int a3 = Integer.parseInt(a_11);
						int cst1 = g_residual.consultaPairUn(tmp, a3).consultarPrimero().ConsultarCoste();
						cTotal += (cst1*consumo);
						tmp = a3;
					}
				}
				scan1.close();
				planetes += "#" + cTotal;
			}
		}
		else planetes = "Esta nave no puede desplazarse ya que no existe un camino posible entre su origen y destino";
		s.AnadirCamino(planetes);
	}
}

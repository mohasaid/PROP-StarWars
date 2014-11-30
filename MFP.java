import java.util.*;

public abstract class MFP{
	protected Grafo g_residual;

	public abstract void Ejecutar(Recorrido r, Salida s);

	public void Calcular_cuellos_botellas (Salida s, ControladorPlaneta cp, ControladorRuta cr) throws Exception
	{
		int V = g_residual.sizeGrafo();
		
		int path[] = new int[V];
		
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
					path[adj] = actual;
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

	public void Caminos(Nave n, int consumo, boolean b){
		
		//Codigo caminos
		/*
		int origen = n.consultar_origen();
		int destino = n.consultar_destino();
		int path[] = new int[g.sizeGrafo()];
		Arrays.fill(path,-1);
		bfs(origen,destino,path);
		
		Stack<Integer> st = new Stack<Integer>();
		while(destino != -1) {
			st.push(destino);
			destino = path[destino];
		}
		
		String res = "";
		if (st.size() >= 0) res = "" + st.pop();
		while (st.size() >= 0) // el cami es separa per una ','
		{
			res = ", " + st.pop();
		}
		
		if (b)
		{
			res = "#"; //marca cuando hay el consumo
			consumo = 0;
			while(destino != -1) {
				st.push(destino);
				destino = path[destino];
			}
			int act = origen;
			int sig = st.pop();
			boolean trobat = false;
			
			while (!trobat){
				consumo += g.consultaPairUn(act, sig).consultarPrimero().ConsultarCapacidad()*g.consultaPairUn(act, sig).consultarPrimero().ConsultarCoste();
				if (sig == destino) trobat = false;
				if (!trobat) {
					act = sig;
					sig = st.pop();
				}
				
			}
			res = "" + consumo;
		}
		return res;
		*/
	}
	
}

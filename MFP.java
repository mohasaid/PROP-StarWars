import java.util.*;


public abstract class MFP{
	protected Salida s;
	protected Grafo g_residual;
	
	public ArrayList<Integer> ConsultarCuellos(){
		return s.ConsultarCuellos();
	}
	public ArrayList<String> ConsultarCaminos(){
		return s.ConsultarCaminos();
	}
	public int size(){
		return s.size();
	}
	public int sizeCambios(){
		return s.size();
	}
	
	//Cambiar:
	public ArrayList<String> ConsultarCambios(){
		return s.ConsultarCambios();
	}
	public abstract void Ejecutar(Recorrido r);
	

	public void bfs (int origen, int destino, int path[])
	{
		int V = g_residual.sizeGrafo();
		boolean[] visitados = new boolean[V];
		Arrays.fill(visitados,false);
		visitados[origen] = true;
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(origen);
		while(!q1.isEmpty()) {
			int actual = q1.poll().intValue();
			int size = g_residual.sizeGrafo(actual);
			for(int i = 0; i < size; ++i) {
				int adj = g_residual.consultarSeg(actual, i);
				int cap = g_residual.consultarPrim(actual, i).ConsultarCapacidad();
				if(cap != 0 && !visitados[adj]) {
					path[adj] = actual;
					visitados[adj] = true;
					q1.add(adj);
				}
			}
		}		
	}
	
	public void Calcular_cuellos_botellas ()
	{
		int path[] = new int[g_residual.sizeGrafo()];
		int V = g_residual.sizeGrafo();
		int origen = V-1;
		boolean[] visitados = new boolean[V];
		Arrays.fill(visitados,false);
		visitados[ origen ] = true;
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(origen);
		while(!q1.isEmpty()) {
			int actual = q1.poll().intValue();
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
					Arco c = g_residual.consultarPrim(actual, adj);
					s.AnadirCuello(c);
				}
			}
		}
	}
	
	private String nodo_a_planeta(int i, ControladorPlaneta cp) throws Exception
	{
		ArrayList<String> lp = cp.consultarPlanetas();
		Iterator<String> it = lp.iterator();
		for (int aux=0; aux < i; ++i) it.next();
		return it.next();
	}
	
	public void Caminos(Nave n, int consumo, boolean b, ControladorPlaneta cp) throws Exception{
		
		//Codigo caminos
		String ori = n.consultar_origen();
		String dest = n.consultar_destino();
		
		ArrayList<String> lp = cp.consultarPlanetas();
		
		int origen, destino, i_ori=0, i_dest=0;
		boolean trobat_dest = false;
		boolean trobat_ori = false;
		Iterator<String> it = lp.iterator();
		while( it.hasNext() ){
			it.next();
			
			if (it.equals(ori)) trobat_ori = true;
			if (it.equals(dest)) trobat_dest = true;
			
			if (!trobat_dest) ++i_dest;
			if (!trobat_ori) ++i_ori;
		}
		
		origen = i_ori;
		destino = i_dest;
		
		int path[] = new int[g_residual.sizeGrafo()];
		Arrays.fill(path,-1);
		bfs(origen,destino,path);
		
		//buscamos el camino que recorremos
		
		String res = "";
		
		Stack<Integer> st = new Stack<Integer>();
		while(destino != -1) {
			st.push(destino);
			destino = path[destino];
		}
		
		boolean primero = true;
		while (st.size() >= 0)
		{
			String nombre = nodo_a_planeta(st.pop(),cp);
			if (primero) {
				primero=false;
				res += nombre;
			}
			 res += ":" + nombre;
		}
		
		
		if (b)
		{
			consumo = 0;
			//Volvemos a llenar la pila
			while(destino != -1) {
				st.push(destino);
				destino = path[destino];
			}
			
			int act = origen;
			int sig = st.pop();
			boolean trobat = false;
			
			while (!trobat){
				consumo += g_residual.consultaPairUn(act, sig).consultarPrimero().ConsultarCapacidad()*g_residual.consultaPairUn(act, sig).consultarPrimero().ConsultarCoste();
				if (sig == destino) trobat = false;
				if (!trobat) {
					act = sig;
					sig = st.pop();
				}
				
			}
			res += ":" + consumo;
		}
		s.AnadirCambio(res);
	}
	
}

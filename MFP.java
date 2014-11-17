import java.util.*;


public abstract class MFP{
	protected Salida s;
	protected Grafo g_residual;
	protected Grafo g;
	
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
	public abstract void Ejecutar();
	public abstract boolean Recorrido(int origen,int destino);
	public void Caminos(int idNave, int consumo){
		//Codigo caminos
	}
	
	public void bfs (int origen, int destino, 	int path[])
	{
		int V = g.sizeGrafo();
		boolean[] visitados = new boolean[V];
		Arrays.fill(visitados,false);
		visitados[origen] = true;
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(origen);
		while(!q1.isEmpty()) {
			int actual = q1.poll().intValue();
			int size = g.sizeGrafo(actual);
			for(int i = 0; i < size; ++i) {
				int adj = g.consultarSeg(actual, i);
				int cap = g.consultarPrim(actual, i).ConsultarCapacidad();
				if(cap != 0 && !visitados[adj]) {
					path[adj] = actual;
					visitados[adj] = true;
					q1.add(adj);
				}
			}
		}		
	}
	
	public String Caminos(Nave n, int consumo, boolean b){
		//Codigo caminos
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
	}
}

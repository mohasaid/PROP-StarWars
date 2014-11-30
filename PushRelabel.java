import java.util.ArrayList;
import java.util.Iterator;


public class PushRelabel extends MFP{

private Grafo G;

private void g_residual() {
	ArrayList<ArrayList<Pair<Arco,Integer> > > ar = new ArrayList<ArrayList<Pair<Arco,Integer> > > ();
	for(int i = 0; i < G.sizeGrafo(); ++i) {
		ArrayList<Pair<Arco,Integer> >  ad = new ArrayList<Pair<Arco,Integer> >();
		ar.add(ad);
	}
	g_residual = new Grafo(ar);
	int v;
	for(int i = 0; i < G.sizeGrafo(); ++i) {
		for (int j = 0; j < G.sizeGrafo(i); ++j) {
			v = G.consultarSeg(i, j);
			Arco a = new Arco();
			a.ModificarCoste(G.consultaPairUn(i, v).consultarPrimero().ConsultarCoste());
			Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,v);
			g_residual.consultarCosteDestinos(i).add(p);
		}
	}
	for(int i = 0; i < G.sizeGrafo(); ++i) {
		for (int j = 0; j < G.sizeGrafo(i); ++j) {
			v = G.consultarSeg(i, j);
			if(!g_residual.ExisteV(v, i)) {
				Arco a = new Arco();
				Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,i);
				g_residual.consultarCosteDestinos(v).add(p);
			}
		}
	}
}
	public PushRelabel(Entrada e) {
		G = e.Consultar_grafo();
		g_residual();
	}
	
	private void Inicializar(int altura[], int exceso[], int s) {
		int n = G.sizeGrafo(); //Inicializar
		altura[s] = n-1;
		int aux,v;
		for (int i = 0; i < G.sizeGrafo(s); ++i) {
			v = G.consultarSeg(s, i);
			aux = G.consultaPairUn(s, v).consultarPrimero().ConsultarCapacidad();
			g_residual.consultaPairUn(s, v).consultarPrimero().ModificarCapacidad(aux);//flujo[s][i] = aux;
			g_residual.consultaPairUn(v, s).consultarPrimero().ModificarCapacidad(-aux);//flujo[i][s] = -flujo[s][i];			//EVITA BUCLE INFINITO (ESTUDIAR A FONDO)
			exceso[v] = aux;					//Inicializar
		}
	}
	private void Push(int exceso[], int aux, int aux1, int i, int j){
		int df = Math.min((aux - aux1), exceso[i]); //push
		aux1 += df;
		g_residual.consultaPairUn(i, j).consultarPrimero().ModificarCapacidad(aux1);//flujo[i][j] += df;
		aux1 = g_residual.consultaPairUn(j, i).consultarPrimero().ConsultarCapacidad();
		aux1-= df;
		g_residual.consultaPairUn(j, i).consultarPrimero().ModificarCapacidad(aux1);//flujo[j][i] -= df;
		exceso[i] -= df;
		exceso[j] += df;
	}
	private void Relabel(ArrayList<Integer> LNP, int altura[],int i) {
		altura[i] = Integer.MAX_VALUE; //relabel
      	int aux,aux1,v;
		for (int j = 0; j < g_residual.sizeGrafo(i); ++j){
			v = g_residual.consultarSeg(i, j);
			if(G.ExisteV(i, v)) aux = G.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			else aux = 0;	
			aux1 = g_residual.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
      			if (altura[i] > altura[v] + 1 && (aux - aux1)> 0 && i != v) {
      				altura[i] = altura[v] + 1;
      			}
		}
      	if (altura[i] > altura[LNP.get(LNP.size()-1)]) LNP.clear();
	}
	
	public void Ejecutar(Recorrido r, Salida s) {
		
		long tiempo = System.currentTimeMillis();
		int size = G.sizeGrafo();
		int origen = size-1;
		int destino = size-2;
		String camino = "";
		
		int n = G.sizeGrafo(); 
		int altura[] = new int[n];  
		ArrayList<Integer> LNP = new ArrayList<Integer>();
		int exceso[] = new int[n];
		Inicializar(altura, exceso, origen);
		int aux, aux1, v;
		boolean ENA = true; 														//Existen Nodos Activos
		boolean pushed;
		while (ENA) {
			if (LNP.isEmpty()) {													//Poner en la lista de nodos a tratar
				for (int i = 0; i < G.sizeGrafo(); ++i){
					if (i != origen && i != destino && exceso[i] > 0) {
						if (!LNP.isEmpty() && altura[i] > altura[LNP.get(LNP.size()-1)]) ENA = false;
				        LNP.add(i);
				        ENA = true;
					}
				}
			}																		//Poner en la ista de nodos a tratar
		    if (LNP.isEmpty()) ENA = false;
		    pushed = false;
		    while (!LNP.isEmpty()) {
		        	int i = LNP.get(0);
		        	camino += i;
			        pushed = false;
			        for (int j = 0; j < g_residual.sizeGrafo(i) && exceso[i] != 0; ++j) {
			        	v = g_residual.consultarSeg(i, j);
			        	if(G.ExisteV(i, v)) aux = G.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			        	else aux = 0;
			        	aux1 = g_residual.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			        	if (altura[i] == altura[v] + 1 && ((aux - aux1) > 0) && i != v) {
			        		Push(exceso, aux, aux1, i, v);									//push
		            		camino += ", " + v;
			        		if (exceso[i] == 0) LNP.remove(0);
		            		pushed = true;
			        	}
			        	camino += ", " + i;
			        }
			        s.AnadirCambio(camino);
			        camino = "";
			        if (!pushed) {
			        	Relabel(LNP, altura,i);							  //relabel
			        }
		      	}
	    	}
		s.AnadirMax_flow(exceso[destino]);
		long tiempo1 = System.currentTimeMillis() - tiempo;
		s.AnadirTiempo(tiempo1);
	}
}

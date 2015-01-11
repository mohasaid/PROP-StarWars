import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PushRelabel extends MFP {
	private int destino;
	
	public void Residual(int size) {
		ArrayList<ArrayList<Pair<Arco,Integer> > > ar = new ArrayList<ArrayList<Pair<Arco,Integer> > > ();
		for(int i = 0; i < size; ++i) {
			ArrayList<Pair<Arco,Integer> >  ad = new ArrayList<Pair<Arco,Integer> >();
			ar.add(ad);
		}
		g_residual = new Grafo(ar);
		int v;
		boolean insert = false;
		for(int i = 0; i < G.sizeGrafo(); ++i) {
			for (int j = 0; j < G.sizeGrafo(i); ++j) {
				v = G.consultarSeg(i, j);
				Arco a = new Arco();
				a.ModificarCoste(G.consultaPairUn(i, v).consultarPrimero().ConsultarCoste());
				Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,v);
				if (g_residual.consultarCosteDestinos(i).isEmpty()) g_residual.consultarCosteDestinos(i).add(p);
				else {
					for(int h = 0; h < g_residual.consultarCosteDestinos(i).size() && !insert; ++h) {
						if (g_residual.consultarCosteDestinos(i).get(h).consultarPrimero().ConsultarCoste() >= a.ConsultarCoste()) {
							g_residual.consultarCosteDestinos(i).add(h, p);
							insert = true;
						}
					}
					if(!insert) g_residual.consultarCosteDestinos(i).add(p);
					insert = false;
				}
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
		Residual(G.sizeGrafo());
	}
	
	private void Inicializar(int altura[], int exceso[], int s) {
		int n = G.sizeGrafo();
		altura[s] = n-1;
		int aux,v;
		for (int i = 0; i < G.sizeGrafo(s); ++i) {
			v = G.consultarSeg(s, i);
			aux = G.consultaPairUn(s, v).consultarPrimero().ConsultarCapacidad();
			g_residual.consultaPairUn(s, v).consultarPrimero().ModificarCapacidad(aux);
			g_residual.consultaPairUn(v, s).consultarPrimero().ModificarCapacidad(-aux);
			exceso[v] = aux;
		}
	}
	
	private void Push(int exceso[], int aux, int aux1, int i, int j){
		int df = Math.min((aux-aux1), exceso[i]);
		if(df < 0) {
			df += Integer.MAX_VALUE;
			exceso[i] += Integer.MAX_VALUE;
			aux1 += df;
			g_residual.consultaPairUn(i, j).consultarPrimero().ModificarCapacidad(aux1);
			aux1 = g_residual.consultaPairUn(j, i).consultarPrimero().ConsultarCapacidad();
			aux1-= df;
			g_residual.consultaPairUn(j, i).consultarPrimero().ModificarCapacidad(aux1);
			if(j != destino) exceso[j] += df;
			if(j == destino && G.sizeGrafo(i) == 1) exceso[j] += df;
		}	
		else {	
			aux1 += df;
			g_residual.consultaPairUn(i, j).consultarPrimero().ModificarCapacidad(aux1);
			aux1 = g_residual.consultaPairUn(j, i).consultarPrimero().ConsultarCapacidad();
			aux1-= df;
			g_residual.consultaPairUn(j, i).consultarPrimero().ModificarCapacidad(aux1);
			exceso[i] -= df;
			if(j != destino) exceso[j] += df;
			if(j == destino && G.sizeGrafo(i) == 1) exceso[j] += df;
		}
	}
	
        private void Relabel(int altura[],int i, boolean camino) {
		altura[i] = Integer.MAX_VALUE;
      	int aux,aux1,v;
		for (int j = 0; j < g_residual.sizeGrafo(i); ++j){
			v = g_residual.consultarSeg(i, j);
			if(G.ExisteV(i, v)) aux = G.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			else aux = 0;	
			aux1 = g_residual.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
      			if (altura[i] > altura[v] + 1 && (aux - aux1)> 0 && i != v) {
      				altura[i] = altura[v] + 1;
                                camino = true;
      			}
		}
	}
	
	public void Ejecutar(Recorrido r, Salida s) 
	{
		long tiempo = System.currentTimeMillis();
		
		String t = "-- PUSH RELABEL --";    
		s.AnadirAlgoritmo(t);
		
		int size = G.sizeGrafo();
		int origen = size-2;
		int destino = size-1;
		String camino = "";
		
		int n = G.sizeGrafo(); 
		int altura[] = new int[n];  
		Queue<Integer> LNP = new LinkedList<Integer>();
		int exceso[] = new int[n];
		Inicializar(altura, exceso, origen);
		int aux, aux1, v;
		boolean pushed;
                boolean relabelcamino = false;
			for (int i = 0; i < G.sizeGrafo(); ++i){
				if (i != origen && i != destino && exceso[i] > 0) {
			        LNP.add(i);
				}
			}
		    while (!LNP.isEmpty()) {
		        	int i = LNP.poll();
		        	camino += " --- Tratamos " + i + " ---\n";
			        pushed = false;
			        for (int j = 0; j < g_residual.sizeGrafo(i) && exceso[i] != 0; ++j) {
			        	v = g_residual.consultarSeg(i, j);
			        	if(G.ExisteV(i, v)) aux = G.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			        	else aux = 0;
			        	aux1 = g_residual.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			        	if (altura[i] == altura[v] + 1 && (aux - aux1) > 0 && i != v) {
			        		Push(exceso, aux, aux1, i, v);
		            		if(exceso[v] != 0 && v != destino && v != origen) LNP.add(v);
			        		camino += " Push hacia " + v + "\n";
		            		pushed = true;
			        	}
			        	if (!pushed) {
				        	Relabel(altura,i,relabelcamino);
                            if(relabelcamino) camino += " Relabel de " + v +"\n";
				        	LNP.add(i);
				        	
				        }
			        	pushed = false;
			        }
			        s.AnadirCambio(camino);
			        camino = "";
		      	}
		    
		s.AnadirMax_flow(exceso[destino]);
		long tiempo1 = System.currentTimeMillis() - tiempo;
		s.AnadirTiempo(tiempo1);
		
	}

}

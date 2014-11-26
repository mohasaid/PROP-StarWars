import java.util.ArrayList;

public class PushRelabel extends MFP{

private Grafo G;
private Grafo Residual;

public void Residual(int size) {
	ArrayList<ArrayList<Pair<Arco,Integer> > > ar = new ArrayList<ArrayList<Pair<Arco,Integer> > > ();
	for(int i = 0; i < size; ++i) {
		ArrayList<Pair<Arco,Integer> >  ad = new ArrayList<Pair<Arco,Integer> >();
		ar.add(ad);
	}
	Residual = new Grafo(ar);
	int v;
	for(int i = 0; i < G.sizeGrafo(); ++i) {
		for (int j = 0; j < G.sizeGrafo(i); ++j) {
			v = G.consultarSeg(i, j);
			Arco a = new Arco(0,0);
			Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,v);
			Residual.consultarCosteDestinos(i).add(p);
		}
	}
	for(int i = 0; i < G.sizeGrafo(); ++i) {
		for (int j = 0; j < G.sizeGrafo(i); ++j) {
			v = G.consultarSeg(i, j);
			if(!Residual.ExisteV(v, i)) {
				Arco a = new Arco(0,0);
				Pair<Arco,Integer> p = new Pair<Arco,Integer>(a,i);
				Residual.consultarCosteDestinos(v).add(p);
			}
		}
	}
}
	public void Grafo(Grafo f) {
		ArrayList<ArrayList<Pair<Arco,Integer> > > ar = f.consultarGrafo();
		G = new Grafo(ar);
	}
	public Grafo ConsultarResidual() {
		return Residual;
	}
	public void Inicializar(int altura[], int exceso[], int s) {
		int n = G.sizeGrafo(); //Inicializar
		altura[s] = n-1;
		int aux,v;
		for (int i = 0; i < G.sizeGrafo(s); ++i) {
			v = G.consultarSeg(s, i);
			aux = G.consultaPairUn(s, v).consultarPrimero().ConsultarCapacidad();
			Residual.consultaPairUn(s, v).consultarPrimero().ModificarCapacidad(aux);//flujo[s][i] = aux;
			Residual.consultaPairUn(v, s).consultarPrimero().ModificarCapacidad(-aux);//flujo[i][s] = -flujo[s][i];			//EVITA BUCLE INFINITO (ESTUDIAR A FONDO)
			exceso[v] = aux;					//Inicializar
		}
	}
	public void Push(int exceso[], int aux, int aux1, int i, int j){
		int df = Math.min((aux - aux1), exceso[i]); //push
		aux1 += df;
		Residual.consultaPairUn(i, j).consultarPrimero().ModificarCapacidad(aux1);//flujo[i][j] += df;
		aux1 = Residual.consultaPairUn(j, i).consultarPrimero().ConsultarCapacidad();
		aux1-= df;
		Residual.consultaPairUn(j, i).consultarPrimero().ModificarCapacidad(aux1);//flujo[j][i] -= df;
		exceso[i] -= df;
		exceso[j] += df;
	}
	public void Relabel(ArrayList<Integer> LNP, int altura[],int i) {
		altura[i] = Integer.MAX_VALUE; //relabel
      	int aux,aux1,v;
		for (int j = 0; j < Residual.sizeGrafo(i); ++j){
			v = Residual.consultarSeg(i, j);
			if(G.ExisteV(i, v)) aux = G.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			else aux = 0;	
			aux1 = Residual.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
      			if (altura[i] > altura[v] + 1 && (aux - aux1)> 0 && i != v) {
      				altura[i] = altura[v] + 1;
      			}
		}
      	if (altura[i] > altura[LNP.get(0)]) LNP.clear();
	}
	
	public int Push_Relabel(int s, int t) {
		int n = G.sizeGrafo(); 
		int altura[] = new int[n];  
		ArrayList<Integer> LNP = new ArrayList<Integer>();
		int exceso[] = new int[n];
		Inicializar(altura, exceso, s);
		int aux, aux1, v;
		boolean ENA = true; 														//Existen Nodos Activos
		boolean pushed;
		while (ENA) {
			if (LNP.isEmpty()) {													//Poner en la lista de nodos a tratar
				for (int i = 0; i < G.sizeGrafo(); ++i){
					if (i != s && i != t && exceso[i] > 0) {
						if (!LNP.isEmpty() && altura[i] > altura[LNP.get(0)]) ENA = false;
				        LNP.add(i);
				        ENA = true;
					}
				}
			}																		//Poner en la ista de nodos a tratar
		    if (LNP.isEmpty()) ENA = false;
		    pushed = false;
		    while (!LNP.isEmpty()) {
		        	int i = LNP.get(LNP.size() - 1);
			        pushed = false;
			        for (int j = 0; j < Residual.sizeGrafo(i) && exceso[i] != 0; ++j) {
			        	v = Residual.consultarSeg(i, j);
			        	if(G.ExisteV(i, v)) aux = G.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			        	else aux = 0;
			        	aux1 = Residual.consultaPairUn(i, v).consultarPrimero().ConsultarCapacidad();
			        	if (altura[i] == altura[v] + 1 && ((aux - aux1) > 0) && i != v) {
			        		Push(exceso, aux, aux1, i, v);									//push
		            		if (exceso[i] == 0) LNP.remove(LNP.size()-1);
		            		pushed = true;
			        	}
			        }
			        if (!pushed) {
			        	Relabel(LNP, altura,i);							  //relabel
			        }
		      	}
	    	}
		return exceso[t];
	}
}

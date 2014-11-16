import java.util.*;
public class Salida{
private ArrayList<Integer> CuellosB;
private int coste;
private ArrayList<Pair<Arco,Integer>> Flujos;
private ArrayList<String> Cambios;
	//CREADORA
	public Salida(){
		CuellosB = new ArrayList<Integer>();
		coste = 0;
		Flujos = new ArrayList<Pair<Arco,Integer>>();
		Cambios = new ArrayList<String>();
	}
	public Salida(ArrayList<Integer> cb, int c, ArrayList<Pair<Arco,Integer>> f, ArrayList<String> ca){
		coste = c;
		for(int i=0; i < cb.size();++i){
			CuellosB.add(cb.get(i));
		}
		for(int i=0; i < f.size();++i){
			Pair<Arco,Integer> p = new Pair<Arco,Integer>(f.get(i).consultarPrimero(),f.get(i).consultarSegundo());
			Flujos.add(p);
		}
		for(int i=0; i < ca.size();++i){
			Cambios.add(ca.get(i));
		}
	}
	// CONSULTORAS
	public ArrayList<Integer> ConsultarCuellos(){
		return CuellosB;
	}
	public ArrayList<Pair<Arco,Integer>> ConsultarFlujos(){
		return Flujos;
	}
	public int ConsultarCost(){
		return coste;
	}
	public ArrayList<String> ConsultarCambios(){
		return Cambios;
	}
	//Pre:cierto
	//Post: devuelve la suma del numero de elementos en Flujos, y cuellosB
	public int size(){
		return Flujos.size()+CuellosB.size();
	}
	//Pre:cierto
	//Post: devuelve el numero de elementos en Cambios
	public int sizeCambios(){
		return Cambios.size();
	}
	
	public int FlujoArco(int idArco) {
		for(int i=0; i<Flujos.size();++i){
			Pair<Arco,Integer> aux = Flujos.get(i);
			if(aux.consultarPrimero().ConsultarId()==idArco){
				return (int)aux.consultarSegundo();
			}
		}
		return -1;
	}
	//MODIFICADORAS
	public void AnadirCuello(Arco c){
		CuellosB.add(c.ConsultarIdRuta());
	}
	public void AnadirFlujo(Arco c, int f){
		Pair<Arco,Integer> p = new Pair<Arco,Integer>(c,f);
		Flujos.add(p);
	}
	public void AnadirCambio(String s){
		Cambios.add(s);
	}
	public void ModificarCoste(int cn){
		coste = cn;
	}
	public void IncrementarCoste(int i){
		coste += i;
	}
	/*
	public void ModificarFlujo(int idArco, int fn){
		for(int i = 0; i < Flujos.size();++i){
			if(Flujos.get(i).consultarPrimero().ConsultarId() == idArco){
				Flujos.get(i).ponSegundo(fn);
			}
		}
	}
	public void IncrementarFlujo(Arco c,int f){
		for(int i = 0; i < Flujos.size();++i){
			if(Flujos.get(i).consultarPrimero().ConsultarId() == idArco){
				Flujos.get(i).ponSegundo(Flujos.get(i).consultarSegundo+f);
			}
		}
	}
	*/
	public void GenerarFlujos(Entrada e, ControladorRuta cr) throws Exception{
		for(int i=0; i < e.Consultar_grafo().sizeGrafo();++i){
			for(int j=0; j<e.Consultar_grafo().sizeGrafo(i);++j){
				Arco aux = e.Consultar_grafo().consultarPrim(i,j);
				int f = (cr.BuscarRuta(aux.ConsultarIdRuta()).consultar_capacidad())-(aux.ConsultarCapacidad());
				Pair<Arco,Integer> p = new Pair<Arco,Integer>(aux,f);
			}
		}
	}
	public void EliminarCuellos(){
		CuellosB.clear();
	}
	public void EliminarFlujos(){
		Flujos.clear();
	}
	public void EliminarCambios(){
		Cambios.clear();
	}
}

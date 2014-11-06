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
			Pair<Arco,Integer> p = new Pair<Arco,Integer>(f.get(i).getFirst(),f.get(i).getSecond());
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
	/*
	public boolean EsCuello(int id){
		for(int i=0; i < CuellosB.size(); ++i){
			if(CuellosB.get(i)==id) return true;
		}
		return false;
	}
	*/
	public int FlujoArco(int idArco) {

		for(int i=0; i<Flujos.size();++i){
			Pair<Arco,Integer> aux = Flujos.get(i);
			if(aux.getFirst().ConsultarId()==idArco){
				return (int)aux.getSecond();
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
	}
	public void AnadirCambio(String s){
		Cambios.add(s);
	}
	public void ModificarCoste(int cn){
		coste = cn;
	}
	public void ModificarFlujo(int idArco, int fn){
		for(int i = 0; i < Flujos.size();++i){
			if(Flujos.get(i).getFirst().ConsultarId() == idArco){
				Flujos.get(i).setSecond(fn);
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

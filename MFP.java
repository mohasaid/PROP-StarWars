import java.util.*;

public abstract class MFP{
	protected Salida s;
	public ArrayList<Integer> ConsultarCuellos(){
		return s.ConsultarCuellos();
		}
		public ArrayList<Pair<Arco,Integer>> ConsultarFlujos(){
		return s.ConsultarFlujos();
		}
		public int size(){
			return s.size();
		}
		public int sizeCambios(){
			return s.size();
		}
		public void GenerarFlujos(Entrada e, ControladorRuta cr){
			s.GenerarFlujos(e,cr);
		}
		//Cambiar:
		public ArrayList<String> ConsultarCambios(){
		return s.ConsultarCambios();
		}
		public abstract void Ejecutar();
}

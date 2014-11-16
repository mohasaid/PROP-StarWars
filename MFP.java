import java.util.*;

public abstract class MFP{
	protected Salida s;
	public MFP(){
		s = new Salida();
	}
	public ArrayList<Integer> ConsultarCuellos(){
		return s.ConsultarCuellos();
		}
		public ArrayList<Pair<Arco,Integer>> ConsultarFlujos(){
		return s.ConsultarFlujos();
		}
		public int ConsultarCoste(){
		return s.ConsultarCost();
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

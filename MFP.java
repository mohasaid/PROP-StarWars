import java.util.*;

public abstract class MFP{
	//protected Salida s;
	
	public abstract ArrayList<Integer> ConsultarCuellos();
	public abstract ArrayList<Pair<Arco,Integer>> ConsultarFlujos();
	public abstract int size();
	public abstract int sizeCambios();
	public abstract void GenerarFlujos(Entrada e, ControladorRuta cr);
		//Cambiar:
		public abstract ArrayList<String> ConsultarCambios();
		public abstract void Ejecutar();
		
}

import java.util.*;

public class FuncionPrecio extends FuncionesCoste{
	public FuncionPrecio(){
		r = new Ruta();
		p = new Planeta();
	}
	public int CalcularCoste() throws Exception{
		return r.consultar_distancia()*p.Consultar_Coste();
	}
}

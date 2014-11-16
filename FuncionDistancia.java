import java.util.*;

public class FuncionDistancia extends FuncionesCoste{
	public FuncionDistancia(){
		r = new Ruta();
	}
	public int CalcularCoste() throws Exception{
		return r.consultar_distancia();
	}
}

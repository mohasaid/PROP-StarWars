import java.util.*;

public class FuncionPrecio extends FuncionesCoste{
	public void FuncionPrecio(){}
	public void CalcularCoste(Arco a, int distancia, int precio){
		a.ModificarCoste(distancia*precio);
	}
}

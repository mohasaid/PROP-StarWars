public class FuncionPrecio extends FuncionesCoste {
    public FuncionPrecio() {
    }

    public int CalcularCoste() throws Exception {
        return r.consultar_distancia() * p.Consultar_Coste();
    }
}

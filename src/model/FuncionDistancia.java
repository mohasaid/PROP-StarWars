public class FuncionDistancia extends FuncionesCoste {
    public FuncionDistancia() {
    }

    public int CalcularCoste() throws Exception {
        return r.consultar_distancia();
    }
}

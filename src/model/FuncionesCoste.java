public abstract class FuncionesCoste {
    protected Ruta r;
    protected Planeta p;

    public void ModificarRuta(Ruta r1) {
        r = r1;
    }

    public void ModificarPlaneta(Planeta p1) {
        p = p1;
    }

    public abstract int CalcularCoste() throws Exception;
}

public abstract class MFP {
    protected Grafo g_residual;
    protected Grafo G;

    public abstract void Ejecutar(Recorrido r, Salida s);

    public Grafo consultaResidual() {
        return g_residual;
    }

}

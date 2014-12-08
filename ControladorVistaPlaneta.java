
import java.util.*;

class ControladorVistaPlaneta {
    private ControladorPlaneta cp;
    private VistaPlaneta vp;
    private VistaNave vn;
    private VistaRuta vr;
    private VistaGalaxia vg;
    private ControladorGalaxia cg;
    ControladorVistaPlaneta() {
        cp = new ControladorPlaneta();
        vp = new VistaPlaneta(this);    
    }
    
    public void ImportarVistas(ControladorVistaNave n, ControladorVistaRuta r, ControladorVistaGalaxia g) {
        vn = n.ConsultarVistaNave();
        vr = r.ConsultarVistaRuta();
        vg = g.COnsultarVistaGalaxia();
        cg = g;
    }
    
    public ControladorPlaneta ConsultarControladorPlaneta() {
        return cp;
    }
    
    public VistaPlaneta ConsultarVistaPlaneta() {
        return vp;
    }
    
    public void CrearPlaneta(String Nombre, String Coste, String X, String Y) throws Exception{
        int c = Integer.parseInt(Coste);
        int x = Integer.parseInt(X);
        int y = Integer.parseInt(Y);
        Pair<Integer,Integer> p = new Pair(x,y);
        cp.Planeta(Nombre,c,p);
        vg.ActualizarPlanetas();
        vn.ActualizarPlanetas();
        vr.ActualizarPlanetas();
    }
    
    public void CrearPlaneta() throws Exception {
       cp.PlanetaAuto();
       vg.ActualizarPlanetas();
       vn.ActualizarPlanetas();
       vr.ActualizarPlanetas();
    }
    
    public void CrearPlaneta(String Nombre) throws Exception {
        cp.PlanetaAuto(Nombre);
        vg.ActualizarPlanetas();
        vn.ActualizarPlanetas();
        vr.ActualizarPlanetas();
    }
    
    public String ConsultarCoste(String Nombre) throws Exception {
        return Integer.toString(cp.Consultar_Coste(Nombre));
    }
    
    public String ConsultarCoordenadaX(String Nombre) throws Exception {
        return Integer.toString(cp.consultar_X(Nombre));
    }
    
    public String ConsultarCoordenadaY(String Nombre) throws Exception {
        return Integer.toString(cp.consultar_Y(Nombre));
    }
    public ArrayList<String> ConsultarNombresPlanetas() throws Exception {
        return cp.consultarPlanetas();
    }
    
    public void ModificarCoste(String Nombre, String Coste) {
        int c = Integer.parseInt(Coste);
        cp.Modificar_Coste(Nombre,c);
    }
    public void ModificarCoordenadas(String Nombre, String X, String Y) {
        int x = Integer.parseInt(X);
        int y = Integer.parseInt(Y);
        cp.Modificar_Coordenadas(Nombre, cp.consultar_X(Nombre), cp.consultar_Y(Nombre), x, y);
    }
    public void CargarPlanetas(String path) throws Exception {
        cp.CargarPlanetas(path, cg);
    }
    
    public void GuardarPlanetas(String path) throws Exception{
        cp.GuardarPLanetas(path);
    }
}


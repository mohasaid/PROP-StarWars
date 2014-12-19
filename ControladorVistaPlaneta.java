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
    
    public void ImportarVistas(ControladorVistaGalaxia g) 
    {
        vg = g.consultarVistaGalaxia();
        cg = g.consultarControladorGalaxia();
    }
    
    public ControladorPlaneta ConsultarControladorPlaneta() 
    {
        return cp;
    }
    
    public VistaPlaneta ConsultarVistaPlaneta() 
    {
        return vp;
    }
    
    public void CrearPlaneta(String Nombre, String Coste, String X, String Y) throws Exception
    {
        int c = Integer.parseInt(Coste);
        int x = Integer.parseInt(X);
        int y = Integer.parseInt(Y);
        Pair<Integer,Integer> p = new Pair(x,y);
        cp.Planeta(Nombre,c,p,cg);
        vg.pintaPlaneta(x, y);
    }
    
    public void CrearPlaneta() throws Exception 
    {
       String a = cp.PlanetaAuto(cg);
       Scanner scan = new Scanner(a);
       scan.useDelimiter(",");
       Integer a1 = scan.nextInt();
       Integer a2 = scan.nextInt();
       vg.pintaPlaneta(a1, a2);
    }
    
    public void CrearPlaneta(String Nombre) throws Exception 
    {
        String a = cp.PlanetaAuto(Nombre,cg);
        Scanner scan = new Scanner(a);
        scan.useDelimiter(",");
        Integer a1 = scan.nextInt();
        Integer a2 = scan.nextInt();
        vg.pintaPlaneta(a1, a2);
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
    public int size() {
        return cp.Consultar_Size();
    }
    public ArrayList<String> ConsultarNombresPlanetas() throws Exception {
        return cp.consultarPlanetas();
    }
    public ArrayList<String> ConsultarNombresPlanetas(int i) throws Exception{
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> aux = cp.consultarPlanetas();
        int j=0;
        while(i<aux.size() && j<100){
            String a = aux.get(i);
            res.add(a);
            ++j;
            ++i;
        }
        return res;
    }
    
    public void ModificarCoste(String Nombre, String Coste) throws Exception {
        int c = Integer.parseInt(Coste);
        cp.Modificar_Coste(Nombre,c);
    }
    public void ModificarCoordenadas(String Nombre, String X, String Y) throws Exception {
        int x = Integer.parseInt(X);
        int y = Integer.parseInt(Y);
        cp.modificar_coordenadas(Nombre, x,y,cg);
    }
    public void CargarPlanetas(String path) throws Exception {
        cp.CargarPlanetas(path, cg);
    }
    
    public void GuardarPlanetas(String path) throws Exception{
        cp.GuardarPlanetas(path);
    }
        public void clear() throws Exception{
        cp.BorrarTodos();
    }
}

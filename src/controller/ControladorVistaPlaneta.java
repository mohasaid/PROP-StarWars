class ControladorVistaPlaneta {
    private ControladorPlaneta cp;
    private VistaPlaneta vp;
    private VistaNave vn;
    private VistaRuta vr;
    private VistaGalaxia vg;
    private ControladorGalaxia cg;
    private ControladorNave cn;
    private ControladorRuta cr;

    ControladorVistaPlaneta() {
        cp = new ControladorPlaneta();
        vp = new VistaPlaneta(this);
    }

    public void ImportarVistas(ControladorVistaGalaxia g, ControladorVistaRuta r, ControladorVistaNave n) {
        vg = g.consultarVistaGalaxia();
        cg = g.consultarControladorGalaxia();
        cn = n.ConsultarControladorNave();
        vn = n.ConsultarVistaNave();
        cr = r.consultarControladorRuta();
        vr = r.obterVistaRuta();
    }

    public ControladorPlaneta ConsultarControladorPlaneta() {
        return cp;
    }

    public VistaPlaneta ConsultarVistaPlaneta() {
        return vp;
    }

    public void CrearPlaneta(String Nombre, String Coste, String X, String Y) throws Exception {
        int c = Integer.parseInt(Coste);
        int x = Integer.parseInt(X);
        int y = Integer.parseInt(Y);
        Pair<Integer, Integer> p = new Pair<Integer, Integer>(x, y);
        cp.Planeta(Nombre, c, p, cg);
        vg.pintaPlaneta(x, y);
    }

    public void CrearPlaneta() throws Exception {
        String a = cp.PlanetaAuto(cg);
        Scanner scan = new Scanner(a);
        scan.useDelimiter(",");
        Integer a1 = scan.nextInt();
        Integer a2 = scan.nextInt();
        scan.close();
        vg.pintaPlaneta(a1, a2);
    }

    public void CrearPlaneta(String Nombre) throws Exception {
        String a = cp.PlanetaAuto(Nombre, cg);
        Scanner scan = new Scanner(a);
        scan.useDelimiter(",");
        Integer a1 = scan.nextInt();
        Integer a2 = scan.nextInt();
        scan.close();
        vg.pintaPlaneta(a1, a2);
    }

    public String ConsultarCoste(String Nombre) throws Exception {
        String id = "";
        for (int i = 0; i < Nombre.length(); ++i) {
            char c = Nombre.charAt(i);
            if (!Character.isWhitespace(c)) id += c;
            else i = Nombre.length();
        }
        return Integer.toString(cp.Consultar_Coste(id));
    }

    public String ConsultarCoordenadaX(String Nombre) throws Exception {
        String id = "";
        for (int i = 0; i < Nombre.length(); ++i) {
            char c = Nombre.charAt(i);
            if (!Character.isWhitespace(c)) id += c;
            else i = Nombre.length();
        }
        return Integer.toString(cp.consultar_X(id));
    }

    public String ConsultarCoordenadaY(String Nombre) throws Exception {
        String id = "";
        for (int i = 0; i < Nombre.length(); ++i) {
            char c = Nombre.charAt(i);
            if (!Character.isWhitespace(c)) id += c;
            else i = Nombre.length();
        }
        return Integer.toString(cp.consultar_Y(Nombre));
    }

    public int size() {
        return cp.Consultar_Size();
    }

    public ArrayList<String> ConsultarNombresPlanetas() throws Exception {
        return cp.consultarPlanetas();
    }

    public ArrayList<String> ConsultarNombresPlanetas(int i) throws Exception {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> aux = cp.consultarPlanetas();
        int j = 0;
        while (i < aux.size() && j < 100) {
            String a = aux.get(i);
            String ad = a + "  (" + Integer.toString(cp.consultar_X(a)) + "," + Integer.toString(cp.consultar_Y(a)) + ")";
            res.add(ad);
            ++j;
            ++i;
        }
        return res;
    }

    public void ModificarCoste(String Nombre, String Coste) throws Exception {
        int c = Integer.parseInt(Coste);
        cp.Modificar_Coste(Nombre, c);
    }

    public void ModificarCoordenadas(String Nombre, String X, String Y) throws Exception {
        int x = Integer.parseInt(X);
        int y = Integer.parseInt(Y);
        int x1 = cp.consultar_X(Nombre);
        int y1 = cp.consultar_Y(Nombre);
        cp.modificar_coordenadas(Nombre, x, y, cg);
        vg.borraPlaneta(x1, y1);
        vg.pintaPlaneta(x, y);
    }

    public void CargarPlanetas(String path) throws Exception {
        cp.CargarPlanetas(path, cg);
        String s = cp.Consultar_listaPlanetas();
        Scanner sca = new Scanner(s);
        sca.useDelimiter("-");
        while (sca.hasNext()) {
            String info = sca.next();
            int x = cp.consultar_X(info);
            int y = cp.consultar_Y(info);
            vg.pintaPlaneta(x, y);
        }
        sca.close();
    }

    public void GuardarPlanetas(String path) throws Exception {
        cp.GuardarPlanetas(path);
    }

    public void clear() {
        cp.BorrarTodos(cg);
        vg.borraPlanetas();
    }

    public void eliminarPlaneta(String nom) throws Exception {
        String id = "";
        for (int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if (!Character.isWhitespace(c)) id += c;
            else i = nom.length();
        }
        int x = cp.consultar_X(id);
        int y = cp.consultar_Y(id);
        vg.borraPlaneta(x, y);
        cp.Borrar(id, cr, cn, cg);
        vn.actualiza();
        vr.actualiza();
    }
}

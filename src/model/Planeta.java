public class Planeta {
    private String nombrePlaneta; //Identificador del planeta
    private int Coste; //Precio del combustible del planeta.
    private Pair<Integer, Integer> Coordenadas; //Coordenadas del planeta en la galaxia

    /**
     * Metodo para comprobar que un string es alfanumerico
     *
     * @param nom
     * @throws Exception
     */
    private boolean alfa_numeric(String nom) {
        if (nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for (int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }

    /**
     * Metodo para crear un planeta
     *
     * @param n
     * @param k
     * @param Coo
     * @throws Exception
     */
    public Planeta(String n, int k, Pair<Integer, Integer> Coo) throws Exception {
        if (!alfa_numeric(n))
            throw new Exception("Error: El nombre de un Planeta tiene que ser alfanumerico y contener menos de 20 caracteres");
        if (k < 0) throw new Exception("Error: El Coste no puede ser negativo");
        nombrePlaneta = n;
        Coste = k;
        Coordenadas = new Pair<Integer, Integer>(Coo.consultarPrimero(), Coo.consultarSegundo());
    }

    /**
     * Metodo para consultar el nombre de un planeta.
     *
     * @throws Exception
     */
    public String Consultar_nombre() {
        return nombrePlaneta;
    }

    /**
     * Metodo para consultar el coste de un planeta
     *
     * @throws Exception
     */
    public int Consultar_Coste() {
        return Coste;
    }

    /**
     * Metodo para consultar las coordenadas de un planeta
     *
     * @throws Exception
     */
    public Pair<Integer, Integer> consultar_coordenades() {
        return Coordenadas;
    }

    /**
     * Metodo para consultar la coordenada X de un planeta
     *
     * @throws Exception
     */
    public int consultar_X() {
        return Coordenadas.consultarPrimero();
    }

    /**
     * Metodo para consultar la coordenada Y de un planeta
     *
     * @throws Exception
     */
    public int consultar_Y() {
        return Coordenadas.consultarSegundo();
    }

    /**
     * Metodo para modificar el coste de un planeta
     *
     * @param k
     * @throws Exception
     */
    public void Modificar_Coste(int k) throws Exception {
        if (k < 0) throw new Exception("Error: El Coste del Planeta no puede ser negativo");
        Coste = k;
    }

    /**
     * Metodo para modificar las coordenadas de un planeta
     *
     * @param randX
     * @param randY
     * @throws Exception
     */
    public void modificarCoordenades(int rndX, int rndY) throws Exception {
        if (rndX < 0 || rndY < 0) throw new Exception("Error: Las Coordenadas no pueden ser negativas");
        Coordenadas.ponPrimero(rndX);
        Coordenadas.ponSegundo(rndY);
    }
}

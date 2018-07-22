public abstract class Nave {

    protected int ident;
    protected String destino;
    protected String origen;

    protected static boolean ErrorTipograficoID(int i) {
        return (i < 0);
    }

    protected static boolean ErrorTipografico(int i) {
        return (i <= 0);
    }

    protected boolean alfa_numeric(String nom) {
        if (nom.isEmpty() || nom == null || nom.length() > 20) return false;
        for (int i = 0; i < nom.length(); ++i) {
            char c = nom.charAt(i);
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
    //pre: cierto
    //post: retorna un entero que representa el identificador de la nave

    /**
     * metodo que consulta el identificador de una nave
     *
     * @throws Exception
     */
    public int consultar_id() {
        return ident;
    }

    //pre: cierto
    //post: retorna un entero que representa el identificador del planeta al que la nave se dirige

    /**
     * metodo que consulta el destino de una nave
     *
     * @throws Exception
     */
    public String consultar_destino() {

        return destino;

    }
    //pre:cieto
    //post: retorna un entero que representa el identificador del planeta en el que se encuentra la nave inicialmente

    /**
     * metodo que consulta el origen de una nave
     *
     * @throws Exception
     */
    public String consultar_origen() {
        return origen;
    }

    //pre: El planeta destino idD existe en la galaxia
    //post: se ha modificado el destino de la nave por idD

    /**
     * metodo que modifica el destino de una nave
     *
     * @param idD
     * @throws Exception
     */
    public void modificar_destino(String idD) throws Exception {
        if (!alfa_numeric(idD)) {
            throw new Exception("Error: El identificador del planeta origen ha de ser alfa numerico\n");
        }
        destino = idD;
    }
    //pre: El planeta origen idO existe en la galaxia
    //post: se ha modificado el origen por el planeta con identificador idO

    /**
     * metodo que modifica el origen de una nave
     *
     * @param idO
     * @throws Exception
     */
    public void modificar_origen(String idO) throws Exception {
        if (!alfa_numeric(idO)) {
            throw new Exception("Error: El identificador del planeta destino ha de ser alfa numerico\n");
        }
        origen = idO;
    }

    public abstract int consultar_tipo();

}



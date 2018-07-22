public class Ruta {
    //PARTE PRIVADA
    private int id;
    private int capacidad;
    private int distancia;

    //PARTE PUBLICA

    //Pre: Entra como parametro un numero entero
    //Post: Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso

    /**
     * Metodo para consultar si un entero es mayor o igual que 0
     *
     * @param i
     * @return Retorna cierto en el caso que el entero i sea menor que 0, en caso contrario, retorna falso
     */
    private static boolean ErrorTipografico(int i) {
        return (i < 0);
    }

    //CONSTRUCTORAS

    //Pre: Cierto
    //Post: Crea una ruta con id = "i", capacidad = "c", distancia = "d"

    /**
     * Metodo para crear una ruta
     *
     * @param i
     * @param c
     * @param d
     * @param b
     * @throws Exception
     */
    public Ruta(int i, int c, int d) throws Exception {
        if (ErrorTipografico(i)) {
            throw new Exception("Error: El identificador de una ruta debe ser mayor o igual que 0\n");
        }
        if (ErrorTipografico(c)) {
            throw new Exception("Error: La capacidad debe ser mayor o igual que 0\n");
        }
        if (ErrorTipografico(d) || d == 0) {
            throw new Exception("Error: La distancia entre planeas debe ser mayor que 0\n");
        }
        id = i;
        capacidad = c;
        distancia = d;
    }

    //CONSULTORAS

    //Pre: Cierto
    //Post: Retorna un entero que representa el identificador de la ruta

    /**
     * Metodo para consultar el id de la ruta
     *
     * @return Retorna un entero que representa el identificador de la ruta
     */
    public int consultar_id() {
        return id;
    }

    //Pre: Cierto
    //Post: Retorna un entero que representa la capacidad de la ruta

    /**
     * Metodo para consultar la capacidad de la ruta
     *
     * @return Retorna un entero que representa la capacidad de la ruta
     */
    public int consultar_capacidad() {
        return capacidad;
    }

    //Pre: Cierto
    //Post: Retorna un entero que representa la distancia de la ruta

    /**
     * Metodo para consultar la distancia de la ruta
     *
     * @return Retorna un entero que representa la distancia de la ruta
     */
    public int consultar_distancia() {
        return distancia;
    }

    //MODIFICDORAS

    //Pre: Entra como parametro un entero
    //Post: El id de la ruta se ha modificado por id = "id_nuevo"

    /**
     * Metodo para modificar el id de la ruta
     *
     * @param id_nuevo
     * @throws Exception
     */
    public void modificar_id(int id_nuevo) throws Exception {
        if (ErrorTipografico(id_nuevo)) {
            throw new Exception("Error: El identificador de una ruta debe ser mayor o igual que 0\n");
        }
        id = id_nuevo;
    }

    //Pre: Entra como parametro un entero
    //Post: La capacidad de la ruta se ha modificado por capacidad = "c"

    /**
     * Metodo para modificar la capacidad de la ruta
     *
     * @param c
     * @throws Exception
     */
    public void modificar_capacidad(int c) throws Exception {
        if (ErrorTipografico(c)) {
            throw new Exception("Error: La capacidad debe ser mayor o igual que 0\n");
        }
        capacidad = c;
    }

    //Pre: Entra como parametro un entero
    //Post: La distancia de la ruta se ha modificado por distancia = "d"

    /**
     * Metodo para modificar la distnaica de la ruta
     *
     * @param d
     * @throws Exception
     */
    public void modificar_distancia(int d) throws Exception {
        if (ErrorTipografico(d) || d == 0) {
            throw new Exception("Error: La distancia entre planeas debe ser mayor que 0\n");
        }
        distancia = d;
    }
}

class OrdenRuta implements Comparator<Ruta> {
    public int compare(Ruta r1, Ruta r2) {
        if (r2.consultar_id() < r1.consultar_id()) return 1;
        else return -1;
    }
}

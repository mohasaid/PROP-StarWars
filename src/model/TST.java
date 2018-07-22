import java.util.ArrayList;

public class TST<T> {

    private static char Final = '!';
    private Nodo<T> raiz;
    private int N;

    private class Nodo<T> {
        private char c;
        private Nodo<T> izq, m, der;
        private T info;

        // pre: cierto
        // post: Crea un nodo vacío
        public Nodo() {
        }

        //pre: cierto
        // post: Crea un nodo que que contiene x
        public Nodo(T x, char ch) {
            c = ch;
            izq = m = der = null;
            info = x;
        }

        //pre: cierto
        //post: crea un nodo que no contiene información
        public Nodo(char ch) {
            c = ch;
            izq = m = der = null;
            info = null;
        }

        // pre: cierto
        // post: devuelve la información almacenada en el nodo
        public Nodo<T> consultarNodo() {
            return this;
        }

        // pre: cierto
        // post: Elimina la información almacenada por el nodo
        public void EliminarInfo() {
            info = null;
        }
    }

    //FUNCIONS PRIVADES
    // pre: cierto
    // post: Devuelve el nodo resultante de añadir un elemento al tst
    private Nodo<T> add(Nodo<T> n, String s, T elem, int i) throws Exception {
        boolean b = false;
        if (n == null) {
            n = new Nodo<T>(s.charAt(i));
            b = true;
        }
        if (s.charAt(i) < n.c) n.izq = add(n.izq, s, elem, i);
        else if (s.charAt(i) > n.c) n.der = add(n.der, s, elem, i);
        else {
            if (i + 1 < s.length())
                n.m = add(n.m, s, elem, i + 1);
            else {
                if (n.c == Final && !b) {
                    throw new Exception("Error: El elemento que se pretende insertar ya se encuentra en el sistema");
                } else {
                    n = new Nodo<T>(elem, s.charAt(i));
                    ++N;
                }
            }
        }
        return n;
    }

    // pre: cierto 
    // post: Elimina el elemento 's' 
    private void eliminar(Nodo<T> n, String s, int i) throws Exception {
        if (n != null) {
            if (s.charAt(i) < n.c)
                eliminar(n.izq, s, i);
            else if (s.charAt(i) > n.c)
                eliminar(n.der, s, i);
            else {
                if (i + 1 < s.length())
                    eliminar(n.m, s, i + 1);
                else if (n.c == Final && i == (s.length() - 1)) {
                    n.EliminarInfo();
                    n.c = '-';
                    --N;
                } else {
                    throw new Exception("Error: El objeto que se pretende eliminar no se encuentra en el sistema");
                }
            }
        } else {
            throw new Exception("Error: El objeto que se pretende eliminar no se encuentra en el sistema");
        }
    }

    // pre: cierto
    // post: Indica si existe un elemento en el TST
    private boolean contains(Nodo<T> n, String s, int i) {
        if (n == null)
            return false;
        if (s.charAt(i) < n.c)
            return contains(n.izq, s, i);
        else if (s.charAt(i) > n.c)
            return contains(n.der, s, i);
        else {
            if (n.c == Final && i == (s.length() - 1))
                return true;
            else if (i == s.length() - 1)
                return false;
            else
                return contains(n.m, s, i + 1);
        }
    }


    // pre: cierto
    // post: retorna el elemento s
    private Nodo<T> buscar(Nodo<T> n, String s, int i) throws Exception {
        if (n != null) {
            if (s.charAt(i) < n.c)
                return buscar(n.izq, s, i);
            else if (s.charAt(i) > n.c)
                return buscar(n.der, s, i);
            else {
                if (n.c == Final && i == (s.length() - 1)) {
                    return n.consultarNodo();
                } else if (i == (s.length() - 1)) {
                    throw new Exception("Error: El objeto buscado no se encuenta en el sistema");
                } else
                    return buscar(n.m, s, i + 1);
            }
        } else {
            throw new Exception("Error: El objeto buscado no se encuentra en el sistema");
        }
    }


    // pre: cierto
    // post: Almacena en l todos los identificadores de elementos hasta el nodo n 
    private void ConsultarIdentificadores(Nodo<T> n, String s, ArrayList<String> l) {
        if (n != null) {
            ConsultarIdentificadores(n.izq, s, l);
            s = s + n.c;
            if (n.c == Final)
                l.add(s.substring(0, s.length() - 1));
            ConsultarIdentificadores(n.m, s, l);
            s = s.substring(0, s.length() - 1);
            ConsultarIdentificadores(n.der, s, l);
        }
    }


    public TST() {
        raiz = null;
        N = 0;
    }

    //pre: cierto
    //post: Almacena en l todos los elementos almacenados en el TST
    private void MostrarElementos(Nodo<T> n, ArrayList<T> l) {
        if (n != null) {
            MostrarElementos(n.izq, l);
            if (n.info != null) l.add(n.info);
            MostrarElementos(n.m, l);
            MostrarElementos(n.der, l);


        }
    }

    // pre: cierto
    // post: Indica si el TST está vacío
    public boolean isEmpty() {
        if (N == 0) return true;
        return false;
    }

    // pre: cierto
    // post: Retorna el numero de elementos que contiene el TST
    public int size() {
        return N;
    }

    // pre: cierto
    // post: Indica si un elemento con identificador s existe en el TST
    public boolean contains(String s) {
        return contains(raiz, s + Final, 0);
    }

    // pre: 's' ha de ser una clau d'un objecte del parametre implicit 
    // post: Retonra l'objecte del parametre implicit amb clau 's' 
    public T buscar(String s) throws Exception {
        return buscar(raiz, s + Final, 0).info;
    }

    // pre: cierto
    // post: Devuelve los identificadores de todos los elementos existentes en el TST
    public ArrayList<String> ConsultarIdentificadores() {
        ArrayList<String> l = new ArrayList<String>();
        ConsultarIdentificadores(raiz, "", l);
        return l;
    }

    //pre:cierto
    //post: devuelve todos los elementos almacenados en el TST
    public ArrayList<T> MostrarElementos() {
        ArrayList<T> l = new ArrayList<T>();
        MostrarElementos(raiz, l);
        return l;
    }

    // pre: cierto
    // post: Elimina todos los elementos del TST
    public void clear() {
        raiz = null;
        N = 0;
    }

    // pre: cierto
    // post: Anade un elemento elem con identificador s al TST
    public void add(String s, T elem) throws Exception {
        raiz = add(raiz, s + Final, elem, 0);
    }

    // pre: cierto
    // post: Elimina el elemento con identificador s del TST
    public void eliminar(String s) throws Exception {
        eliminar(raiz, s + Final, 0);
    }
}

public class Pair<L, R> {
    private L first; // Left
    private R second; // Right

    public Pair(L first1, R second1) {
        first = first1;
        second = second1;
    }

    public L consultarPrimero() {
        return first;
    }

    public R consultarSegundo() {
        return second;
    }

    public void ponPrimero(L first1) {
        first = first1;
    }

    public void ponSegundo(R second1) {
        second = second1;
    }

    public String toString() {
        return "(" + consultarPrimero() + ", " + consultarSegundo() + ")";
    }
}

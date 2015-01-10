import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
/**
 *
 * @author Moha
 */
public class DibujoGrafo {
    private Graph<String, String> g;
    private static final String nodo = "N";
    private static final String orf = "OF";
    private static final String def = "DF";
    
    public DibujoGrafo(Grafo g1)
    {
        g = new DirectedSparseGraph<String, String>();
        int tam = g1.sizeGrafo();
        int of = tam - 2;
        int df = tam - 1;
        
        g.addVertex(orf);
        for(int i = 0; i < of; ++i) {
            String res = nodo + i;
            g.addVertex(res);
        }
        g.addVertex(def);
        
        for(int i = 0; i < tam; ++i) {
            for(int j = 0; j < g1.sizeGrafo(i); ++j) {
                int v = g1.consultarSeg(i, j);
                if(i == of) {
                    g.addEdge("f"+i, orf, nodo+v);
                }
                else if(i == df) {
                	g.addEdge("f"+i, def, nodo+v);
                }
                else if(v == of) {
                	g.addEdge("f"+i, nodo+i,orf);
                }
                else if(v == df){
                    g.addEdge("f"+i, nodo+i, def);
                }
                else if(v != df) {
                    String a = i +""+ v;
                    g.addEdge(a, nodo+i, nodo+v);
                }
            }
        }
    }
   
    public Graph<String, String> consultaGrafo()
    {
        return g;
    }
                        
}

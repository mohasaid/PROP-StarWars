import java.io.File;

public class ControladorDades {

    FileReader fr;
    PrintWriter pw;

    public ControladorDades() {
    }

    public void AbrirLectura(String path) throws FileNotFoundException {
        fr = new FileReader(new File(path));
    }

    public void AbrirEscritura(String path) throws FileNotFoundException {
        pw = new PrintWriter(new File(path));
    }

    public void CerrarEscritura() throws IOException {
        pw.close();
    }

    public void CerrarLectura() throws IOException {
        fr.close();
    }
}

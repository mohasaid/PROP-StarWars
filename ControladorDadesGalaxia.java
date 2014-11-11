import java.io.*;
import java.util.Scanner;
 
/** HACER**/

public class ControladorDadesGalaxia {
 
    private boolean inicial;
 
    //CONSTRUCTORA 
    public ControladorDadesGalaxia() {}
 
    //MODIFICADORA
    public void Inicial(boolean b) {
        inicial = b;
    }
    //METODES
    public String carregar(String path) throws FileNotFoundException 
    {     
        String sep = File.separator; // separador de paths = \
        String filename = "Galaxia.txt";
        String res = "";
        FileReader fr = new FileReader(path + sep + filename);
        Scanner in = new Scanner(fr);
        while (in.hasNextLine()) {
            res += in.nextLine();
            res += "@";
        }
        in.close();
        return res;
    }
     
    public void guardar(String path, String res)throws IOException  
    {        
        String sep = File.separator; 
        String filename = "Galaxia.txt";
         
        PrintWriter out;
         
        if (inicial) {
            // si comencem a guardar matxaquem el que hi havia
            out = new PrintWriter(path + sep + filename);
        }
        else {
            // si hi ha mes blocs per guardar afegim el contingut
            out = new PrintWriter(new BufferedWriter(new FileWriter(path + sep + filename, true)));
        }
         
        Scanner scan = new Scanner(res);
        scan.useDelimiter("\\@");
        String s;
        while(scan.hasNext()) {
            s = scan.next();
            out.println(s);            
        }
        scan.close();
        out.close();        
    }    
}

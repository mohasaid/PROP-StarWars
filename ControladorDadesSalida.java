import java.io.*;
import java.util.Scanner;


public class ControladorDadesSalida extends ControladorDades{
 
    private boolean inicial;
 
    //CONSTRUCTORA 
    public ControladorDadesNave() {}
 
    //MODIFICADORA
    public void Inicial(boolean b) {
        inicial = b;
    }
    //METODES
   public String cargar(String path) throws FileNotFoundException 
    {     
        String res = "";
        FileReader fr = new FileReader(path);
        Scanner in = new Scanner(fr);
        while (in.hasNextLine()) {
            res += in.nextLine();
            res += "#";
        }
        in.close();
        return res;
    }
     
    public void guardar(String path, String res)throws IOException  
    {        
         
        PrintWriter out;
         
        if (inicial) {
            out = new PrintWriter(path);
        }
        else {
            out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
        }
        Scanner scan = new Scanner(res);
        scan.useDelimiter("#");
        String s;
        while(scan.hasNext()) {
            s = scan.next();
            out.println(s);            
        }
        scan.close();
        out.close();        
    }    
}

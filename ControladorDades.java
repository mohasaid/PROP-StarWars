import java.io.*; 
import java.util.Scanner; 
import java.io.File;

public class ControladorDades {

    FileReader fr;
    PrintWriter pw;
   
    // CONSTRUCTOR  
    public ControladorDades() {} 
   
    // FUNCIONES 
    public void AbrirLectura(String path) throws FileNotFoundException
    {
        fr = new FileReader(new File(path));
    }
     
    public void AbrirEscritura(String path) throws FileNotFoundException
    {
        pw = new PrintWriter(new File(path));
    }
     
    public void CerrarEscritura() throws IOException 
    {
        pw.close();
    }
     
    public void CerrarLectura() throws IOException 
    {
        fr.close();
    }
     
    public String cargar() 
    {      
        Scanner in = new Scanner(fr); 
        in.useDelimiter("\\$"); 
        String res;
        try{
	        res = in.nextLine(); 
	        return res;
        }
        catch(Exception e){
        	return "";
        }
    } 
       
    public void guardar(String res)throws IOException   
    {   
        if (!res.isEmpty()) {
            String r = res + "$";
            pw.println(r); 
        }
    }
}

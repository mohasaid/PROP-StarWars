import java.io.*; 
import java.util.Scanner; 
import java.io.File;

/** HACER**/

public class ControladorDades {
     
    //CAMPS
    FileReader fr;
    PrintWriter out;
   
    //CONSTRUCTORA  
    public ControladorDades() {} 
   
    //METODES 
    public void OpenRead(String path) throws FileNotFoundException
    {
        fr = new FileReader(new File(path));
    }
     
    public void OpenWrite(String path) throws FileNotFoundException
    {
        out = new PrintWriter(new File(path));
    }
     
    public void CloseWrite()throws IOException 
    {
        out.close();
    }
     
    public void CloseRead() throws IOException 
    {
        fr.close();
    }
     
    public String carregar() 
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
            out.println(r); 
        }
    }
}

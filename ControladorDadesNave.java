import java.io.*;
import java.util.Scanner;


public class ControladorDadesNave extends ControladorDades{
 
    //CONSTRUCTORA 
    public ControladorDadesNave(){}

    //METODES
      public String cargar(String path, int i,BufferedReader br) throws Exception 
    {    
	
        String res = "";
	String aux = "";
	aux = br.readLine();
        while ((aux!=null) && i>0){
		res+=aux+"#";
		--i;
		aux = br.readLine();
	}
        return res;
    }
     
     public void guardar(String path, String res)throws IOException  
    {        
        PrintWriter out;
        out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
        BufferedWriter bw = new BufferedWriter(out);
       
        bw.write(res);
 
        bw.close();
        out.close();        
    }
}

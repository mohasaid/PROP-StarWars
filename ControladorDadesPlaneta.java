import java.io.*;
import java.util.Scanner;

public class ControladorDadesPlaneta extends ControladorDades {
	private boolean inicial;
	
	public ControladorDadesPlaneta(){}
	
	public void Inicial(boolean b){
		inicial = b;
	}
	public String cargar (String path) throws FileNotFoundException {
		String res= "";
		String separator = File.separator;
		String file = "Planeta.txt";
		FileReader f = new FileReader(path+separator+file);
		Scanner sc = new Scanner(f);
		while (sc.hasNext()){
			res += sc.nextLine();
			res += "#";
		}
		sc.close();
		return res;
	}
	public void guardar(String path, String res) throws IOException{
		String separator = File.separator;
		String file = "Planeta.txt";
		PrintWriter out;
		if(inicial) out = new PrintWriter(path+separator+file);
		else out = new PrintWriter(new BufferedWriter (new FileWriter(path+separator+file, true)));
		Scanner sc = new Scanner(res);
		sc.useDelimiter("#");
		String s;
		while(sc.hasNext()) {
			s = sc.next();
			out.println(s);
		}
		sc.close();
		out.close();
	}
}

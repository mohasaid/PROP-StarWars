package prop1;


import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elena
 */
public class ControladorVistaNave {
    private ControladorNave cn;
    private VistaNaveP vn;

    ControladorVistaNave(){
        cn = new ControladorNave();
        vn = new VistaNaveP(this);
    }
    public ControladorNave ConsultarControladorNave(){
        return cn;
    }
    public VistaNaveP ConsultarVistaNave(){
        return vn;
    }
    public void  CrearNave(String t, String d, String o){
        cn.CrearNave(Integer.parseInt(t),d,o);
    }
    public void CrearNaveAuto(String i, ArrayList<String> lp){
        cn.CrearNaveAuto(Integer.parseInt(i),lp);
    }
    public void CrearTipo(String id, String consumo){
        cn.CrearTipoNave(Integer.parseInt(id),Integer.parseInt(consumo));
    }
    public void CrearTipoAuto(){
        cn.CrearTipoAuto();
    }
    public String ConsultarPlanetaDestino(String id){
       return cn.ConsultarPlanetaDestino(Integer.parseInt(id));
    }
    public String ConsultarPlanetaOrigen(String id){
        return cn.ConsultarPlanetaDestino(Integer.parseInt(id));
    }
    public String ConsultarTipo(String id){
        return cn.ConsultarPlanetaDestino(Integer.parseInt(id));
    }
    public String ConsultarConsumo(String id){
        return cn.ConsultarConsumo(Integer.parseInt(id));
    }
    public String ConsultarConsumoTipo(String id){
        return cn.ConsultarConsumoTipo(Integer.parseInt(id));
    }
    public void ModificaTipo(String id, String idtipo){
        cn.ModificaTipo(Integer.parseInt(id),Integer.parseInt(idtipo));
    }
   public void ModificaDestino(String id, String destID){
       cn.ModificarDestino(Integer.parseInt(id), destID);
    }
   public void ModificaOrigen(String id, String origID){
       cn.ModificarOrigen(Integer.parseInt(id),origID);
   }
   public void ModificaConsumo(String id, String c){
       cn.ModificarConsumo(Integer.parseInt(id), Integer.parseInt(c));
   }
   public void EliminarNave(String id){
       cn.EliminarNave(Integer.parseInt(id));
   }
   public ArrayList<String> ConsultarNaves(){
       ArrayList<String> res = new ArrayList<String>();
       int i=0; 
       int n = cn.size();
        while(i < n){
            String s = cn.ConsultarNaves(i);
                if((i+100)>n){
                    if (s.length() > 0 && s.charAt(s.length()-1)==' ') {
                     	s= s.substring(0, s.length()-1);  
                    }
                	}
                Scanner sc = new Scanner(s);
                sc.useDelimiter(" ");
                while(sc.hasNext()){
                    res.add(sc.next());
                }
                sc.close();
                i += 100;   
        }  
        return res;
   }
   public ArrayList<String> ConsultarTipos(){
       ArrayList<String> res = new ArrayList<String>();
       String s = cn.ConsultarTipos();
       Scanner sc = new Scanner(s);
       sc.useDelimiter(",");
       while(sc.hasNext()){
           res.add(sc.next());
       }
       return res;
   }
   public void CargarNaves(String path){
       cn.CargarNaves(path);
   }
   public void GuardarNaves(String path){
       cn.GuardarNaves(path);
   }
   public void EliminarNaves(){
       cn.EliminarNaves();
   }
}
    

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
    private VistaNave vn;

    public ControladorVistaNave(){
        cn = new ControladorNave();
        vn = new VistaNave(this);
    }
    public ControladorNave ConsultarControladorNave(){
        return cn;
    }
    
    public VistaNave ConsultarVistaNave(){
        return vn;
    }
    
    public void  CrearNave(String t, String d, String o)throws Exception{
        cn.CrearNave(Integer.parseInt(t),d,o);
    }
    public void CrearNaveAuto(String i, ArrayList<String> lp)throws Exception{
        cn.CrearNaveAuto(Integer.parseInt(i),lp);
    }
    public void CrearTipo(String id, String consumo)throws Exception{
        cn.CrearTipoNave(Integer.parseInt(id),Integer.parseInt(consumo));
    }
    public void CrearTipoAuto()throws Exception{
        cn.CrearTipoNaveAuto();
    }
    public String ConsultarPlanetaDestino(String id)throws Exception{
       return cn.ConsultarPlanetaDestino(Integer.parseInt(id));
    }
    public String ConsultarPlanetaOrigen(String id)throws Exception{
        return cn.ConsultarPlanetaDestino(Integer.parseInt(id));
    }
    public String ConsultarTipo(String id)throws Exception{
        return String.valueOf(cn.ConsultarTipo(Integer.parseInt(id)));
    }
    public String ConsultarConsumo(String id)throws Exception{
        return String.valueOf(cn.ConsultarConsumo(Integer.parseInt(id)));
    }
    public String ConsultarConsumoTipo(String id)throws Exception{
        return String.valueOf(cn.ConsultarConsumoTipo(Integer.parseInt(id)));
    }
    public void ModificaTipo(String id, String idtipo)throws Exception{
        cn.ModificaTipo(Integer.parseInt(id),Integer.parseInt(idtipo));
    }
   public void ModificaDestino(String id, String destID)throws Exception{
       cn.ModificaDestino(Integer.parseInt(id), destID);
    }
   public void ModificaOrigen(String id, String origID)throws Exception{
       cn.ModificaOrigen(Integer.parseInt(id),origID);
   }
   public void ModificaConsumo(String id, String c)throws Exception{
       cn.ModificaConsumo(Integer.parseInt(id), Integer.parseInt(c));
   }
   public void EliminarNave(String id)throws Exception{
       cn.EliminarNave(Integer.parseInt(id));
   }
   public ArrayList<String> ConsultarNaves()throws Exception{
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
   public void CargarNaves(String path)throws Exception{
       cn.CargarNaves(path);
   }
   public void GuardarNaves(String path)throws Exception{
       cn.GuardarNaves(path);
   }
   public void EliminarNaves(){
       cn.EliminarNaves();
   }
}
    

import java.util.Comparator;

public class TipoNave{
    private int tipo;
    private int consumo;
 
    private static boolean ErrorTipografico(int i) {  
            return (i<=0);
    } 
    private static boolean ErrorTipograficoID(int i) {  
            return (i<0);
    } 
 
    //pre: cierto
    //post: crea un tipo de nave vacío
    public TipoNave(){
        tipo = -1;
        consumo = 0;
    }
 
    //pre: el nombre de tipo t no existe ya
    //post: crea un tipo de nave inicializado
    public TipoNave(int t,int c) throws Exception{
        if(ErrorTipograficoID(t)){
            throw new Exception("Error: El identificador del tipo debe ser mayor o igual que 0\n");
        }
        if(ErrorTipografico(c)){
            throw new Exception("Error: El consumo ha de ser superior a 0\n");
        }
        tipo = t;
        consumo = c;
    }
     
    //pre: cierto
    //post: retorna el nombre que identifica al tipo
    public int consultar_tipo() throws Exception{
        if(tipo == -1){
        throw new Exception("Error: El tipo de nave no tiene un nombre asignado\n");
    }
        return tipo;
     
    }
 
    //pre: cierto
    //post: retorna el consumo asociado al tipo
    public int consultar_consumo() throws Exception{
        if(consumo == 0){
        throw new Exception("Error: El tipo de nave no tiene un consumo asociado\n");   
    }
        return consumo;
    }
 
    //pre: el nombre de tipo t no existe ya
    //post: modifica el identificador del tipo que pasa a ser t
    public void modificar_tipo(int t) throws Exception{
        if(ErrorTipografico(t)){
            throw new Exception("Error: El identificador del tipo debe ser mayor o igual que 0\n");
        }
        tipo = t;
    }
 
    //pre: cierto
    //post: modifica el consumo asociado al tipo de nave
    public void modificar_consumo(int c) throws Exception{
        if(ErrorTipografico(c)){
            throw new Exception("Error: El consumo debe de ser superior a 0\n");    
        }
        consumo = c;
    }
}

class OrdenTipoNave implements Comparator<TipoNave>{
    public int compare(TipoNave tn1, TipoNave tn2){
        try{
            if(tn2.consultar_tipo() < tn1.consultar_tipo()) return 1;
            else return -1;
        }
        catch(Exception e){
            System.out.print(e);
        }
        return 0;
    }
}

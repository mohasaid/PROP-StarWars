import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


public class ControladorNave{
    private TreeSet<Nave> listaNaves;
    private TreeSet<TipoNave> listaTipos;
    private static int idn=0;
    private static int idt=0;
     
    //Pre: cierto
    //Post: Crea un ControladorNave
    public ControladorNave(){
        listaNaves = new TreeSet<Nave>(new OrdenNave());
        listaTipos = new TreeSet<TipoNave>(new OrdenTipoNave());
    }
     
    //Pre: cierto
    //Post: devuelve el tipo de nave con identificador "id"
    public TipoNave BuscarTipo(int id) throws Exception{
        boolean found = false;
        Iterator<TipoNave> it = listaTipos.iterator();
        TipoNave aux = new TipoNave();
        while(it.hasNext() && !found){
            aux = it.next();
            if(aux.consultar_tipo() == id){
                found = true;
                return aux;
            }
        }   
            if(!found){
                throw new Exception("Error: No existe ninguna nave con el identificador introducido\n");
            }
            return null;
    } 
     
    //Pre: cierto
    //Post: devuelve la nave con identificador "id"
    public Nave BuscarNave(int id) throws Exception{
            Iterator<Nave> it = listaNaves.iterator();
            boolean found = false;
            Nave aux = new Nave();
            while(it.hasNext() && !found){
                aux = it.next();
                if(aux.consultar_id() == id){
                    found = true;
                    return aux;
                }
            }
            if(!found){
                throw new Exception("Error: No existe ningún tipo de nave con el identificador introducido\n");
            }
            return null;
    }
 
    //Pre: cierto
    //Post: comprueva si existe el tipo de nave ocn identificador "id"
    public boolean ExisteTipo(int id) throws Exception{
        Iterator<TipoNave> it = listaTipos.iterator();
        while(it.hasNext()){
            if(it.next().consultar_tipo() == id) return true;
        }
        return false;
    } 
     
    //Pre:cierto
    //Post: comprueva si existe la nave con identificador "id"
    public boolean ExisteNave(int id) throws Exception{
        Iterator<Nave> it = listaNaves.iterator();
        while(it.hasNext()){
            if(it.next().consultar_id() == id) return true;
        }
        return false;
    }
     
    //Pre: cierto
    //Post: Busca todas las naves de tipo id y se lo designa
    public void BuscarNavesTipo(int id) throws Exception{
        Iterator<Nave> it = listaNaves.iterator();
        Nave n = new Nave();
        while(it.hasNext()){
        	n = it.next();
            if(n.consultar_tipo().consultar_tipo() == id){
                n.eliminar_tipo();
            }
        }
    }
 
//CREADORAS NAVE
 
    //Pre: cierto
    //Post: Crea una Nave sin tipo manualmente y la añade a la lista
    public void CrearNave(int id, int d) throws Exception{
        if(ExisteNave(id)){
            throw new Exception("Error: Ya existe una nave con el mismo identificador\n");      
        }
        Nave n = new Nave(id,d);
        listaNaves.add(n);  
    }
     
    //Pre: cierto
    //Post: Crea una Nave manualmente y la añade a la lista
    public void CrearNave(int id, int t, int d) throws Exception{
        if(ExisteNave(id)){
            throw new Exception("Error: Ya existe una nave con el mismo identificador\n");      
        }
        if(!ExisteTipo(t)){
            throw new Exception("Error: No existe ningún tipo de nave con el identificador introducido\n");
        }
        Nave n = new Nave(id,BuscarTipo(t),d);
        listaNaves.add(n);  
    }
 
    //Pre: cierto
    //Post: Crea una Nave de forma automatica
    public void CrearNaveAuto(int dest) throws Exception{
        while(ExisteNave(idn)) ++idn;
        if(listaTipos.size()<1){
            throw new Exception("Error: No existe ningún tipo de nave\n");
        }
        int t = (int)Math.random()*(listaTipos.size()-1)+0;
        TipoNave ti = BuscarTipo(t);
        Nave n = new Nave(idn,ti,dest);
        listaNaves.add(n);  
    }
 
//CREADORAS TIPO DE NAVE
 
    //Pre: cierto
    //Post: Crea un tipo de nave y lo añade a la lista
    public void CrearTipoNave(int id, int c) throws Exception{
        if(ExisteTipo(id)){
            throw new Exception("Error: Ya existe un tipo con el mismo nombre\n");      
        }
        TipoNave tn = new TipoNave(id,c);
        listaTipos.add(tn);
    }
    //Pre: cierto
    //Post: crea un tipo de nave de forma automatica y lo añade a la lista
    public void CrearTipoNaveAuto() throws Exception{
        while(ExisteTipo(idt)) ++idt;
        int c = (int)Math.random()*1000000+1;
        TipoNave tn = new TipoNave(idt,c);
        listaTipos.add(tn);
    }
//CONSULTORAS DE NAVE Y TIPO NAVE EN GENERAL
    //Pre: cierto
    //Post: Retorna la nave con identificador id en caso de que exista
    public Nave ConsultarNave(int id) throws Exception{
        return BuscarNave(id);
    }
    //Pre: cierto
    //Post: Retorna el tipo de nave con identificador id en caso de que exista
    public TipoNave ConsultarTipoNave(int id) throws Exception{ 
        return BuscarTipo(id);
    }
    
    public ArrayList<Nave> ConsultarNaves() throws Exception{
        if(listaNaves.isEmpty()){
            throw new Exception("Error: No existe ninguna nave\n");
        }
        ArrayList<Nave> res = new ArrayList<Nave>();
        Iterator<Nave> it = listaNaves.iterator();
        while(it.hasNext()){
            res.add(it.next());
        }
        return res;
    }
    
    public ArrayList<TipoNave> ConsultarTipos() throws Exception{
        if(listaTipos.isEmpty()){
            throw new Exception("Error: No existe ningún tipo de nave\n");
        }
        ArrayList<TipoNave> res = new ArrayList<TipoNave>();
        Iterator<TipoNave> it = listaTipos.iterator();
        while(it.hasNext()){
            res.add(it.next());
        }
        return res;
    }
//CONSULTORAS ATRIBUTOS NAVE
    //Pre: cierto
    //Post: retorna el identificador del planeta destino de la nave con identificador id
    public int ConsultarPlanetaDestino(int id) throws Exception{
        return BuscarNave(id).consultar_destino();
    }
    //Pre: cierto
    //Post: retorna el tipo de una nave
    public TipoNave ConsultarTipo(int id) throws Exception{
        return BuscarNave(id).consultar_tipo();
    }
    //Pre: cierto
    //Post: retorna el consumo asociado a una nave
    public int ConsultarConsumo(int id) throws Exception{
        return BuscarNave(id).consultar_consumo();
             
    }
     
//CONSULTORAS TIPO NAVE
    //Pre: cierto
    //Post: retorna el consumo asociado a un tipo de nave
    public int ConsultarConsumoTipo(int id) throws Exception{
        return BuscarTipo(id).consultar_consumo();
    }
     
//MODIFICADORAS NAVE
    //Pre: cierto
    //Post: modifica el identificador de una nave "id" por "id2"
    public void ModificaID(int id, int id2) throws Exception{
         BuscarNave(id).modificar_id(id2);
    }
    //Pre: cierto
    //Post: modifica el tipo de la nave con identificador "id" por "tn"
    public void ModificaTipo(int id, int idtipo) throws Exception{
        BuscarNave(id).modificar_tipo(BuscarTipo(idtipo));
    }
    //Pre: el nuevo destino es un planeta existente
    //Post: modifica el destino de la nave con identificador "id" por "dn"
    public void ModificaDestino(int id, int dn) throws Exception{
        BuscarNave(id).modificar_destino(dn);
    }
     
//MODIFICADORAS TIPO NAVE
    //Pre: cierto
    //Post: modifica el identificador del tipo de nave "id" por "id2"
    public void ModificaIDTipo(int id, int id2) throws Exception{
        BuscarTipo(id).modificar_tipo(id2);
    }
    //Pre: cierto
    //Post: modifica el consumo del tipo de nave con identificador "id" por "cn"
    public void ModificaConsumo(int id,int cn) throws Exception{
        BuscarTipo(id).modificar_consumo(cn);
    }
     
//DESTRUCTORAS
    //Pre: cierto
    //Post: elimina la nave con identificador "id"
    public void EliminarNave(int id) throws Exception{
        boolean found = false;
        Iterator<Nave> it = listaNaves.iterator();
        Nave aux = new Nave();
        while(!found && it.hasNext()){
            aux = it.next();
            if(aux.consultar_id()==id){
                listaNaves.remove(aux);
                found = true;
            }
        }
        if(!found){
            throw new Exception("Error: No existe ningún tipo de nave con el identificador introducido\n");
        }
    }
    //Pre: cierto
    //Post: elimina el tipo de nave con identificador "id"
    public void EliminarTipoNave(int id) throws Exception{
        boolean found = false;
        TipoNave aux = new TipoNave();
        Iterator<TipoNave> it = listaTipos.iterator();
        while(!found && it.hasNext()){
            aux = it.next();
            if(aux.consultar_tipo()==id){
                found = true;
                listaTipos.remove(aux);
                BuscarNavesTipo(id);
            }
        }
        if(!found){
        throw new Exception("Error: No existe ningún tipo de nave con el identificador introducido\n");
        }
    }
}

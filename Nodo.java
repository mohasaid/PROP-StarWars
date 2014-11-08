
public class Nodo {
    private int id;
    private boolean Yavin_IV;
    private boolean Hoth;
     
    //CREADORA
     
    //Pre: Cierto
    //Post: Retorna un Nodo vacio
    public Nodo()
    {
        id = -1;
    }
     
    //Pre: Cierto
    //Post: Retorna un Nodo con id = "ident", Yavin_IV = "es_Yavin" y Hoth = "es_Hoth"
    public Nodo (int ident, boolean es_Yavin, boolean es_Hoth)
    {
        id = ident;
        Yavin_IV = es_Yavin;
        Hoth = es_Hoth;
    }
     
    //Consultoras
    
    //Pre: Cierto
    //Post: Retorna un entero que contiene la id del Nodo
    public int consultar_id ()
    {
        return id;
    }
     
    //Pre: Cierto
    //Post: Retorna un valor booleano. Si retorna cierto, este Nodo representa el planeta Yavin, en caso contrario, representa cualquier otro planeta
    public boolean consultar_es_Yavin()
    {
        return Yavin_IV;
    }
     
    //Pre: Cierto
    //Post: Retorna un valor booleano. Si retorna cierto, este Nodo representa el planeta Hoth, en caso contrario, representa cualquier otro planeta
    public boolean consultar_es_Hoth()
    {
        return Hoth;
    }
}

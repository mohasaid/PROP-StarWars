public class Nodo {
    private int id;
    private boolean Yavin_IV;
    private boolean Hoth;
     
    //CREADORA
     
    //Pre:
    //Post:
    public Nodo()
    {
        id = -1;
    }
     
    public Nodo (int id, boolean es_Yavin, boolean es_Hoth)
    {
        this.id = id;
        this.Yavin_IV = es_Yavin;
        this.Hoth = es_Hoth;
    }
     
    //Consultoras
    public int consultar_id ()
    {
        return id;
    }
     
    public boolean consultar_es_Yavin()
    {
        return Yavin_IV;
    }
     
    public boolean consultar_es_Hoth()
    {
        return Hoth;
    }
}

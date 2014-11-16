public class Arco {
    private int capacidad;
    private int coste; //Contiene la distancia/precio del arco según la función de coste escogida
     private int idRuta;
//CREADORAS
     
    //Pre: cierto
    //Post: crea un arco vacío
    public Arco()
    {
        capacidad = 0;
        coste = -1;
        idRuta = -1;
    }
    //Pre:cierto
    //Post: Crea un Arco inicializado
    public Arco(int c,int idr)
    {
        capacidad = c;
        coste = -1;    }
 
//CONSULTORAS
     
    //Pre: Cierto
    //Post: Devuelve la capacidad del arco
    public int ConsultarCapacidad()
    {
        return capacidad;
    }
    //Pre: Cierto
    //Post: Devuelve el coste del arco
    public int ConsultarCoste()
    {
        return coste;
    }
    public int ConsultarIdRuta(){
     return idRuta;
    }
//MODIFICADORAS
     
    //Pre: Cierto
    //Post: la capacidad del arco pasa a valer cn
    public void ModificarCapacidad(int cn)
    {
        capacidad = cn;
    }
    //Pre: Cierto
    //Post el coste del arco pasa valer cn
    public void ModificarCoste(int cn)
    {
        coste = cn;
    }
    public void ModificarIdRuta(int idRn){
     idRuta = idRn;
    }
}

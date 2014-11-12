import java.util.*;
 
public class Arco {
    private int id;
    private Nodo origen;
    private Nodo destino;
    private int capacidad;
    private int coste; //Contiene la distancia/precio del arco según la función de coste escogida
    private int idRuta;
     
//CREADORAS
     
    //Pre: cierto
    //Post: crea un arco vacío
    public Arco(){
        id = -1;
        origen = new Nodo();
        destino = new Nodo();
        capacidad = 0;
        coste = -1;
        idRuta=-1;
    }
    //Pre:cierto
    //Post: Crea un Arco inicializado
    public Arco(int ident, Nodo o, Nodo d, int c,int idr){
        id = ident;
        origen = o;
        destino = d;
        capacidad = c;
        coste = -1;
        idRuta= idr;
    }
 
//CONSULTORAS
     
    //Pre: Cierto
    //Post: Devuelve el identificador del arco
    public int ConsultarId(){
        return id;
    }
    //Pre: Cierto
    //Post: Devuelve el nodo origen del arco
    public Nodo ConsultarOrigen(){
        return origen;
    }
    //Pre: Cierto
    //Post: Devuelve el nodo oestino del arco
    public Nodo ConsultarDestino(){
        return destino;
    }
    //Pre: Cierto
    //Post: Devuelve la capacidad del arco
    public int ConsultarCapacidad(){
        return capacidad;
    }
    //Pre: Cierto
    //Post: Devuelve el coste del arco
    public int ConsultarCoste(){
        return coste;
    }
    //pre:cierto
    //post: Devuelve el identificador de la ruta original
    public int CinsultarIdRuta(){
    	return idRuta;
    }
//MODIFICADORAS
     
    //Pre: Cierto
    //Post: el identificador del arco pasa a ser idn
    public void ModificarId(int idn){
        id = idn;
    }
    //Pre:Cierto
    //Post: el nodo origen del arco pasa a ser on
    public void ModificarOrigen(Nodo on){
        origen = on;
    }
    //Pre: Cierto
    //Post: el nodo destino del arco pasa a ser dn
    public void ModificarDestino(Nodo dn){
        destino = dn;
    }
    //Pre: Cierto
    //Post: la capacidad del arco pasa a valer cn
    public void ModificarCapacidad(int cn){
        capacidad = cn;
    }
    //Pre: Cierto
    //Post el coste del arco pasa valer cn
    public void ModificarCoste(int cn){
        coste = cn;
    }
    public void ModificarIdRuta(int idrn){
    	idRuta = idrn;
    }
}

package clasePalabras;

/*
 * PalabraText.java
 * Esta clase instancia objetos a partir de las palabras que hay en un texto y la cantidad de veces que aparecen
 * @author Cristina Delgado Muñoz
 * @CrisDelgado99
 */
public class PalabraText {
    //Atributo de clase
    private static int mayorCantidad = 0;

    //Atributos de instancia
    private String palabra;
    private int cantidad;

    //Constructor
    public PalabraText(String palabra, int cantidad){
        this.palabra = palabra;
        this.cantidad = cantidad;
        if(this.cantidad > mayorCantidad){
            mayorCantidad = this.cantidad;
        }
    }

    //getters
    public String getPalabra(){
        return this.palabra;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public static int getMayorCantidad(){
        return mayorCantidad;
    }

    //setters
    public void setPalabra(String p){
        this.palabra = p;
    }

    public void setCantidad(int c){
        this.cantidad = c;
    }

    public void setMayorCantidad(int mc){
        mayorCantidad = mc;
    }
}

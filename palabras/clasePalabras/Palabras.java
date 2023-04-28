package clasePalabras;

public class Palabras {
    private int cantidad;
    private int posicion;
    private String palabra;

    public Palabras(String palabra, int indice){
        this.palabra = palabra;
        this.posicion = indice + 1;
        this.cantidad = 1;
    }

    //getters

    //setters
    public void setPalabra(String p){
        this.palabra = p;
    }

    public void setPosicion(int indice){
        this.posicion = indice + 1;
    }

    public void setCantidad(int c){
        this.cantidad = c;
    }
}

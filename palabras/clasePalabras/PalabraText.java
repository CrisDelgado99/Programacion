package clasePalabras;

public class PalabraText {
    private String palabra;
    private int cantidad;
    private int posicion;
    private int linea;

    public PalabraText(String palabra, int posicion, int linea, int cantidad){
        this.palabra = palabra;
        this.posicion = posicion;
        this.cantidad = cantidad;
        this.linea = linea;
    }

    //getters
    public String getPalabra(){
        return this.palabra;
    }

    public int getPosicion(){
        return this.posicion;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public int getLinea(){
        return this.linea;
    }


    //setters
    public void setPalabra(String p){
        this.palabra = p;
    }

    public void setPosicion(int posicion){
        this.posicion = posicion;
    }

    public void setCantidad(){
        this.cantidad = this.cantidad + 1;
    }

    public void setLinea(int linea){
        this.linea = linea;
    }
}

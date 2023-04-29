package clasePalabras;

public class PalabraText {
    private static int mayorCantidad = 0;
    private String palabra;
    private int cantidad;
    private int posicion;
    private int linea;

    public PalabraText(String palabra, int posicion, int linea, int cantidad){
        this.palabra = palabra;
        this.posicion = posicion;
        this.cantidad = cantidad;
        this.linea = linea;
        if(this.cantidad > mayorCantidad){
            mayorCantidad = this.cantidad;
        }
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

    public static int getMayorCantidad(){
        return mayorCantidad;
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

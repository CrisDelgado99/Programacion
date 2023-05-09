package articulo;

public class Articulo {
    private String codigo;
    private int stock;

    private double precioCompra;
    private double precioVenta;

    private String descripcion;

    public Articulo(String cod, int stock, double pCompra, double pVenta, String descripcion){
        this.codigo = cod;
        this.stock = stock;
        this.precioCompra = pCompra;
        this.precioVenta = pVenta;
        this.descripcion = descripcion;
    }

    //toString
    public String toString(){
        String codigo;
        String stock;
        String pVenta;
        String pCompra;
        String desc;

        desc = this.descripcion.toUpperCase() + "\n--------------------------------------";
        codigo = "\nEl código del artículo es: " + this.codigo;
        stock = "\nQuedan " + this.stock + " unidades";
        pCompra = "\nSu precio de compra es: " + this.precioCompra + "euros";
        pVenta = "\nSu precio de venta es: " + this.precioVenta + "euros";

        return "\n" + desc + codigo + stock + pVenta + pCompra + "\n";
    }

    //setters
    public void setStock(int s){
        this.stock = s;
    }

    public void setDescripcion(String d){
        this.descripcion = d;
    }

    public void setPrecioCompra(double p){
        this.precioCompra = p;
    }

    public void setPrecioVenta(double p){
        this.precioVenta = p;
    }

    //getters

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getCodigo(){
        return this.codigo;
    }

    //otros metodos
    public void recibirMercancia(int n){
        this.stock += n; 
        System.out.println("Ahora el stock es:" + this.stock);
    }

    public void enviarMercancia(int n){
        if(this.stock < n){
            System.out.println("Lo siento, no tenemos tantas unidades de este artículo.");
        } else {
            this.stock -=n;
            System.out.println("Productos enviados. Ahora el stock es de " + this.stock);
        }
    }

}

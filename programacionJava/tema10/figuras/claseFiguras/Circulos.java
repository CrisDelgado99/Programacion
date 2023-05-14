package figuras.claseFiguras;

/*
 * Circulos.java
 * Esta clase es una subclase de la clase figuras, que calcula y muestra
 * el área y perímetro de unas figuras, además de escalarlas.
 * @author Cristina Delgado Muñoz, @CrisDelgado99
 */
public class Circulos extends Figuras{
    private double r; //radio

    //Constructor
    public Circulos(double r){
        super(0);
        this.r = r;
    }

    public double perimetro(){
        return Math.PI*r*2;
    }

    public double area(){
        return Math.PI*r*r;
    }

    @Override
    public void escalar(double escala){
        this.r = r*escala;
    }

    @Override
    public void imprimir(){
        System.out.println("CIRCULO");
        System.out.println("-------------");
        System.out.println("Radio: " + this.r + "cm.");
        System.out.println("Perímetro: " + this.perimetro() + "cm.");
        System.out.println("Área: " + this.area() + "cm2.\n");
    }
}

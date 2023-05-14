package figuras.claseFiguras;
/*
 * Cuadrados.java
 * Esta clase es una subclase de la clase figuras, que calcula y muestra
 * el área y perímetro de unas figuras, además de escalarlas.
 * @author Cristina Delgado Muñoz, @CrisDelgado99
 */

public class Cuadrados extends Figuras{
    private int lados;

    private double l; //medida de los lados

    //Constructor
    public Cuadrados(double l){
        super(4);
        this.l = l;
    }

    /*
     * Esta función sirve para calcular el perímetro de los cuadrados
     * @return perimetro
     */
    public double perimetro(){
        return l*2;
    }

    /*
     * Esta función sirve para calcular el area de los cuadrados
     * @return perimetro
     */
    public double area(){
        return l*l;
    }

    @Override
    public void escalar(double escala){
        this.l = l*escala;
    }

    /*
     * Esta función sirve para imprimir los cuadrados
     */
    @Override
    public void imprimir(){
        System.out.println("CUADRADO");
        System.out.println("-------------");
        System.out.println("Lado: " + this.l + "cm.");
        System.out.println("Perímetro: " + this.perimetro() + "cm.");
        System.out.println("Área: " + this.area() + "cm2.");
    }

    
}

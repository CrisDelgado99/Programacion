package figuras.claseFiguras;
/*
 * Triangulos.java
 * Esta clase es una subclase de la clase figuras, que calcula y muestra
 * el área y perímetro de unas figuras, además de escalarlas.
 * @author Cristina Delgado Muñoz, @CrisDelgado99
 */

public class Triangulos extends Figuras{
    private double h; //alto
    private double a; //ancho

    //Constructor
    public Triangulos(double h, double a){
        super(3);
        this.h = h;
        this.a = a;
    }

    /*
     * Esta función sirve para calcular el perímetro de los triángulos
     * @return perimetro
     */
    public double perimetro(){
        return 2*a + Math.sqrt(2*h*h + a*a); //Teorema de pitágoras para encontrar el perímetro
    }
    /*
     * Esta función sirve para calcular el área de los triángulos
     * @return area
     */
    public double area(){
        return (h*a)/2;
    }

    /*
     * Esta función sirve para escalar los triángulos
     * @param escala
     */
    @Override
    public void escalar(double escala){
        this.h = h*escala;
        this.h = a*escala;
    }

    /*
     * Esta función sirve para imprimir los triangulos
     */
    @Override
    public void imprimir(){
        System.out.println("TRIÁNGULO");
        System.out.println("-------------");
        System.out.println("Alto: " + this.h + "cm.");
        System.out.println("Ancho: " + this.a + "cm.");
        System.out.println("Perímetro: " + this.perimetro() + "cm.");
        System.out.println("Área: " + this.area() + "cm2.");
    }
}

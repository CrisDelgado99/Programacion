package figuras.claseFiguras;

/*
 * Rectangulos.java
 * Esta clase es una subclase de la clase figuras, que calcula y muestra
 * el área y perímetro de unas figuras, además de escalarlas.
 * @author Cristina Delgado Muñoz, @CrisDelgado99
 */
public class Rectangulos extends Figuras{

    private double h; //alto
    private double a; //ancho

    //Constructor
    public Rectangulos(double h, double a){
        super(4);
        this.h = h;
        this.a = a;
    }

    /*
     * Esta función sirve para calcular el perímetro de los rectangulos
     * @return perimetro
     */
    public double perimetro(){
        return h+a;
    }

    /*
     * Esta función sirve para calcular el area de los rectangulos
     * @return perimetro
     */
    public double area(){
        return h*a;
    }

    /*
     * Esta función sirve para escalar los rectangulos
     * @param escala
     */
    @Override
    public void escalar(double escala){
        this.h = h*escala;
        this.h = a*escala;
    }


    /*
     * Esta función sirve para imprimir los rectangulos
     */
    @Override
    public void imprimir(){
        System.out.println("RECTÁNGULO");
        System.out.println("-------------");
        System.out.println("Alto: " + this.h + "cm.");
        System.out.println("Ancho: " + this.a + "cm.");
        System.out.println("Perímetro: " + this.perimetro() + "cm.");
        System.out.println("Área: " + this.area() + "cm2.");
    }
}

package figuras;
import figuras.claseFiguras.Circulos;
import figuras.claseFiguras.Cuadrados;
import figuras.claseFiguras.Triangulos;
import figuras.claseFiguras.Rectangulos;
import figuras.claseFiguras.Figuras;
import java.util.ArrayList;
/*
 * MainFiguras.java
 * Esta clase sirve para probar la clase figuras y sus subclases
 * @author Cristina Delgado Muñoz, @CrisDelgado99
 */

public class MainFiguras {
    public static void main(String[]args){
        //Creamos el arrayList y añadimos una figura de cada tipo
        ArrayList<Figuras> figuras= new ArrayList<>();
        figuras.add(new Circulos(2.5));
        figuras.add(new Cuadrados(2.5));
        figuras.add(new Rectangulos(3.5,4.5));
        figuras.add(new Triangulos(4.5, 5.5));
    
        //Imprimimos la información de las figuras
        for(Figuras f: figuras){
            f.imprimir();
        }

        //Realizamos la escala = 2 e imprimimos la información de las figuras escaladas
        System.out.println("Se va a realizar una escala *2: ");

        for(Figuras f: figuras){
            f.escalar(2);
            f.imprimir();
        }

        //Realizamos la escala = 2 e imprimimos la información de las figuras escaladas
        System.out.println("Se va a realizar una escala *0.1: ");

        for(Figuras f: figuras){
            f.escalar(0.1);
            f.imprimir();
        }
    
    }

    
}

import claseGato.Gato;
import bibliotecaExcepFunciones.FuncionesExcepciones;
import bibliotecaExcepFunciones.ExcepcionApareamientoImposible;

public class Ejercicio2 {
    public static void main(String[]args){
        String nombre;
        String raza;
        int genero;

        System.out.println("Vamos a crear un gato.");
        System.out.print("¿Cómo se llamará?: ");
        nombre = System.console().readLine();

        System.out.print("¿De qué raza será?: ");
        raza = System.console().readLine();

        System.out.println("Seleccione su género:");
        System.out.println("1. Macho");
        System.out.println("2. Hembra");
        System.out.print("Género ==> ");
        genero = FuncionesExcepciones.comprobarGenero(System.console().readLine());
        while(genero < 1){
            System.out.println("El género debe ser un número entero (1, 2): ");
            genero = FuncionesExcepciones.comprobarGenero(System.console().readLine());
        }

        Gato gato1 = new Gato(raza, nombre, genero);

        System.out.println("Vamos a crear un segundo gato.");
        System.out.print("¿Cómo se llamará?: ");
        nombre = System.console().readLine();

        System.out.print("¿De qué raza será?: ");
        raza = System.console().readLine();

        System.out.println("Seleccione su género:");
        System.out.println("1. Macho");
        System.out.println("2. Hembra");
        System.out.print("Género ==> ");
        genero = FuncionesExcepciones.comprobarGenero(System.console().readLine());
        while(genero < 1){
            System.out.println("El género debe ser un número entero (1, 2): ");
            genero = FuncionesExcepciones.comprobarGenero(System.console().readLine());
        }

        Gato gato2 = new Gato(raza, nombre, genero);

        System.out.println("Gatos creados: ");
        System.out.println("Primer gato:");
        gato1.imprimirGato();
        System.out.println("Segundo gato:");
        gato2.imprimirGato();

        System.out.println("Oh, espera, ¡están intentando procrear!");
        try{
            Gato cria = gato1.apareaCon(gato2);
            System.out.println("¡Qué gatito más bonito, mira!");
            cria.imprimirGato();
        } catch (ExcepcionApareamientoImposible eai){
            System.out.println(eai.getMessage());
        }
        

    }
}

import java.util.ArrayList;
import funcionesPalabras.FuncionesBusqueda;
import funcionesPalabras.FuncTratamientoFicheros;


/* Palabras.java
 * La clase "Palabras" utiliza los argumentos especificados al llamarla para realizar diferentes acciones
 * sobre un fichero.
 * @author Cristina Delgado Muñoz
*/

public class Palabras{
    public static void main(String[] args){
        //Creamos las variables necesarias para el programa
        String nombreFichero;
        nombreFichero = "";

        String palabra;
        palabra = "";

        String ficheroCompletoGuardado;
        ficheroCompletoGuardado = "";

        String ficheroBackUp;
        ficheroBackUp = "";

        boolean fEsta;
        fEsta = false;

        int posicionF;
        posicionF = 0;

        int posicion;
        posicion = -1;

        int lineaPosicion;
        lineaPosicion = -1;

        int contador;
        contador = 0;


        //Creamos la arrayList principal
        ArrayList<String> partes = new ArrayList<>();

        //Buscamos primero el nombre del fichero, para que el programa sepa sobre qué fichero ha de actuar 
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-f") ){
                fEsta = true;
                posicionF = i;
            }
        }

        //Dependiendo de si está o no el argumento "-f", se realizará una acción diferente:
        if(fEsta){
            //Encontrar y leer el fichero; guardar en un arrayList las palabras;
            if(args[++posicionF] != null){
                nombreFichero = args[posicionF++];
                partes = FuncTratamientoFicheros.leerFicheroCompleto(nombreFichero);
                ficheroCompletoGuardado = FuncTratamientoFicheros.guardarFichero(partes);
                ficheroBackUp = ficheroCompletoGuardado;
                System.out.println("El archivo seleccionado es el siguiente: ");
                System.out.println(ficheroCompletoGuardado + "\n");
            } else {
                
            }

            
        } else {
            //Mensaje de error
            System.out.println("No es posible realizar acciones debido a que no se ha introducido");
            System.out.println("ningún argumento que indique el nombre del fichero.");
        }

        for(int i = 0; i < args.length; i++){
            switch(args[i]){        
                //ARGS DE BÚSQUEDA DE 1 PALABRA: -----------------------------------------------------------------------
                //Buscar en el archivo la palabra que se encuentra junto a -c y contar su número de apariciones
                case "-c":
                    palabra = args[++i];
                    contador = FuncionesBusqueda.contadorPalabra(partes, palabra);
                    FuncionesBusqueda.imprimirApariciones(contador, palabra);
                    break;
                //Buscar en el archivo la palabra que aparece junto -p, contar cuántas veces está y
                //decir la posición de la primera aparición de la palabra 
                case "-p":
                    palabra = args[i + 1];
                    posicion = FuncionesBusqueda.posicionPalabra(palabra, partes);
                    if(posicion > 0){
                        System.out.println("La palabra " + palabra + " aparece por primera vez en la posición " + posicion + ".");    
                    } else {
                        System.out.println("La palabra " + palabra + " no se encuentra en el fichero.");
                    }
                    break;
                //Buscar en el archivo la palabra que aparece junto -L, contar cuántas veces está y
                //decir la línea de la primera aparición de la palabra 
                case "-l":
                    palabra = args[i + 1];
                    lineaPosicion = FuncionesBusqueda.lineaPalabra(palabra, partes);
                    if(lineaPosicion >= 0){
                        System.out.println("La palabra " + palabra + " aparece por primera vez en la línea " + lineaPosicion + ".");    
                    } else {
                        System.out.println("La palabra " + palabra + " no se encuentra en el fichero.");
                    }
                    break;

                //ARGS QUE REALIZAN ACCIONES CON TODAS LAS PALABRAS: --------------------------------------------------
                //Contar las palabras que aparecen en el archivo (todas), mostrarlas ordenadas por la cantidad de apariciones
                case "-a":
                    break;
                //Contar las palabras que aparecen en el archivo (todas), mostrarlas ordenadas alfabéticamente
                case "-A":
                    break;

                //ARGS DE ORDEN ALEATORIO DE PALABRAS: ------------------------------------------------------------------ 
                //Ordena aleatoriamente las palabras de cada línea
                case "-r":
                    break;
                //Ordena aleatoriamente todas las palabras del fichero
                case "-R":
                    break;
                
                //ARGS DE MAYÚSCULAS Y MINÚSCULAS
                //Convierte todo el texto a minúscula
                case "-m":
                    break;
                //Convierte todo el texto a mayúscula
                case "-M":
                    break;

                //ARGS DE BORRADO DE PALABRAS: ------------------------------------------------------------------------
                //Borra la palabra que se encuentra al lado de -b
                case "-b":
                //Borra la aparición n de la palabra que se encuentra al lado de -b
                //Borra todas las apariciones de la palabra que se encuentra al lado de -b
                    //Comprobar si hay -n
                    break;

                //ARGS RELACIONADOS CON ARCHIVOS: -----------------------------------------------------------------------
                //Restaura el archivo
                case "-o":
                //Lee lo que se encuentra en el archivo y lo escribe en otro archivo cuyo nombre está al lado de -w
                case "-w":
            }
        }

    }
}
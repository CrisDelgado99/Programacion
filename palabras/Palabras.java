import java.util.ArrayList;
import funcionesPalabras.FuncionesBusqueda;
import funcionesPalabras.OtrasFunciones;
import funcionesPalabras.FuncTratamientoFicheros;
import funcionesPalabras.FuncOrdenRandom;
import clasePalabras.PalabraText;



/* Palabras.java
 * La clase "Palabras" utiliza los argumentos especificados al llamarla para realizar diferentes acciones
 * sobre un fichero.
 * @author Cristina Delgado Muñoz
*/

public class Palabras{
    public static void main(String[] args){
        //Creamos las variables y ArrayLists necesarias para el programa------------------------------------

        //Variables que reciben los nombres de los ficheros
        String nombreFichero;
        nombreFichero = "";

        String nombreFicheroRecibeTexto;
        nombreFicheroRecibeTexto = "";

        //Variables que reciben las palabras sobre las que se hacen cambios o búsquedas
        String palabra;
        palabra = "";

        String palabraBorrar;
        palabraBorrar = "";

        //Variables que sirven para guardar lo que hay en el fichero, los cambios sobre él y el backup
        String ficheroCompletoGuardado;
        ficheroCompletoGuardado = "";

        String ficheroBackUp;
        ficheroBackUp = "";

        //Booleanos para saber si ciertos parámetros se han pasado
        boolean fEsta;
        fEsta = false;

        boolean nEsta;
        nEsta = false;

        //Variables que sirven para conocer la posición de alguna palabra o línea
        int posicionF;
        posicionF = 0;

        int posicion;
        posicion = -1;

        int lineaPosicion;
        lineaPosicion = -1;

        //Otras variables
        int contador;
        contador = 0;

        int n; //n recoge el número que se encuentra junto a -n en los parámetros
        n = 0;


        //Creamos las arraylists necesarias
        ArrayList<String> partes = new ArrayList<>();
        ArrayList<String> palabrasNoRep = new ArrayList<>();
        ArrayList<Integer> indiceN = new ArrayList<>(); 
        ArrayList<Integer> indice = new ArrayList<>(); 
        ArrayList<PalabraText> palabraArr = new ArrayList<>();
        ArrayList<String> partesDesorden = new ArrayList<>();

        //ArrayLists y variables creadas, comienza el programa:---------------------------------------------

        //Buscamos primero el nombre del fichero, para que el programa sepa sobre qué fichero ha de actuar 
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-f") ){
                fEsta = true;
                posicionF = i;
                //Comprobamos que, además de estar -f, va seguido de algo (para que no salte una OutOfBoundsException)
                if(i == (args.length -1)){
                    fEsta = false;
                }
            }
        }

        //Dependiendo de si está o no el argumento "-f", se realizará una acción diferente:
        if(fEsta){
            //Encontrar y leer el fichero; guardar datos necesarios en las ArrayLists
            nombreFichero = args[++posicionF];
            partes = FuncTratamientoFicheros.leerFicheroCompleto(nombreFichero);
            palabrasNoRep = OtrasFunciones.buscarNoRepetidas(partes);
            palabraArr = OtrasFunciones.crearArrayPalabraText(palabrasNoRep, partes);
            indiceN = OtrasFunciones.buscarIndiceN(partes);
            //Guardar el contenido del fichero en dos variables distintas
            ficheroCompletoGuardado = FuncTratamientoFicheros.guardarFichero(partes);
            ficheroBackUp = ficheroCompletoGuardado;
            //Mostrar al usuario el fichero seleccionado
            System.out.println("El archivo seleccionado es el siguiente: \n");
            System.out.println(ficheroCompletoGuardado + "\n");

        
        } else {
            //Mensaje de error
            System.out.println("No es posible realizar acciones debido a que no se ha introducido");
            System.out.println("ningún argumento que indique el nombre del fichero.");
        }

        //Una vez manejado el nombre del fichero a utilizar, podemos manejar el resto de argumentos introducidos:------------------------
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
                    //Comprobamos si la palabra está o no en el fichero para dar respuestas diferentes
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
                    //Comprobamos si la palabra está o no en el fichero para dar respuestas diferentes
                    if(lineaPosicion >= 0){
                        System.out.println("La palabra " + palabra + " aparece por primera vez en la línea " + lineaPosicion + ".");    
                    } else {
                        System.out.println("La palabra " + palabra + " no se encuentra en el fichero.");
                    }
                    break;

                //ARGS QUE REALIZAN ACCIONES CON TODAS LAS PALABRAS: --------------------------------------------------
                //Contar las palabras que aparecen en el archivo (todas), mostrarlas ordenadas por la cantidad de apariciones
                case "-a":
                    System.out.println("Estas son todas las palabras del fichero ordenadas por cantidad de apariciones:");
                    FuncionesBusqueda.imprimirEnOrdenNumerico(palabraArr);
                    break;
                //Contar las palabras que aparecen en el archivo (todas), mostrarlas ordenadas alfabéticamente
                case "-A":
                    System.out.println("Estas son todas las palabras del fichero ordenadas alfabéticamente:");
                    FuncionesBusqueda.ordenarAlfabeticamente(palabrasNoRep, palabraArr);
                    break;    
                //ARGS DE ORDEN ALEATORIO DE PALABRAS: ------------------------------------------------------------------ 
                //Ordena aleatoriamente las palabras de cada línea
                case "-r":
                    ficheroCompletoGuardado = FuncOrdenRandom.ordenRandomLineas(ficheroCompletoGuardado);
                    System.out.println("\nEl fichero con orden aleatorio de palabras en cada línea es el siguiente: \n" + ficheroCompletoGuardado);
                    break;
                //Ordena aleatoriamente todas las palabras del fichero
                case "-R":
                    ficheroCompletoGuardado = FuncOrdenRandom.ordenRandomTextComplMejorada(ficheroCompletoGuardado, indiceN);
                    System.out.println("\nEl fichero con orden aleatorio es el siguiente:\n" + ficheroCompletoGuardado);
                    break;
                //Primera versión de ordenar aleatoriamente las palabras del fichero
                case "-R1":
                    partesDesorden = FuncOrdenRandom.ordenRandomTextCompl(partes, indiceN);
                    ficheroCompletoGuardado = FuncTratamientoFicheros.guardarFichero(partesDesorden);
                    System.out.println("\nEl fichero con orden aleatorio es el siguiente:\n" + ficheroCompletoGuardado);
                    break;
                //ARGS DE MAYÚSCULAS Y MINÚSCULAS
                //Convierte todo el texto a minúscula
                case "-m":
                    ficheroCompletoGuardado = ficheroCompletoGuardado.toLowerCase();
                    System.out.println("El texto se ha convertido a minúscula: \n" + ficheroCompletoGuardado);
                    break;
                //Convierte todo el texto a mayúscula
                case "-M":
                    ficheroCompletoGuardado = ficheroCompletoGuardado.toUpperCase();
                    System.out.println("El texto se ha convertido a mayúscula: \n" + ficheroCompletoGuardado);
                    break;

                //ARGS DE BORRADO DE PALABRAS: ------------------------------------------------------------------------
                //Borra la palabra que se encuentra al lado de -b
                case "-b":
                    palabraBorrar = args[++i];
                
                    //Comprobar si hay -n para saber si debemos borrar todas las apariciones o la aparición número introducido por usuario
                    for(int i2 = 0; i2 < args.length; i2++ ){
                        if(args[i2].equals("-n")){
                            nEsta = true;
                            //De nuevo, comprobamos si -n es el último argumento para controlar OutOfBoundsException
                            if(i2 == (args.length -1)){
                                nEsta = false;
                            }

                            if(nEsta){
                                try{
                                    n = Integer.parseInt(args[++i]);
                                } catch(ArithmeticException ae){
                                    System.out.println("Al lado de -n se tiene que escribir un número.");
                                    System.out.println(ae.getMessage());
                                } catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            
                        }
                    }

                    if(nEsta){
                        //Borra la aparición n de la palabra que se encuentra al lado de -b
                        
                        
                        
                    } else {
                        //Borra todas las apariciones de la palabra que se encuentra al lado de -b
                        for(int i2 = 0; i2 < partes.size(); i2++){
                            if(partes.get(i2).toLowerCase().contains(palabraBorrar.toLowerCase())){
                                partes.remove(i2); //remove all solo me deja borrar utilizando un ArrayList,
                                                   //por lo que he decidido hacer partes.remove(i2) en su lugar.
                                i2--; //Como hemos borrado i2, el resto del ArrayList se ha desplazado, así que
                                      //he restado una unidad a i2 para que recorra la palabra correcta.
                            }
                        }
                        //Guardo los cambios en el String que guarda el fichero.
                        ficheroCompletoGuardado = FuncTratamientoFicheros.guardarFichero(partes);
                        System.out.println("El fichero sin la palabra " + palabraBorrar + " queda así:\n" + ficheroCompletoGuardado);

                    }
                    break;

                //ARGS RELACIONADOS CON ARCHIVOS: -----------------------------------------------------------------------
                //Restaura el archivo
                case "-o":
                    ficheroCompletoGuardado = ficheroBackUp;
                    break;
                //Lee lo que se encuentra en el archivo y lo escribe en otro archivo cuyo nombre está al lado de -w
                case "-w":
                    if(i < (args.length -1)){
                        nombreFicheroRecibeTexto = args[++i];
                        FuncTratamientoFicheros.escribirEnFichero(nombreFicheroRecibeTexto, ficheroCompletoGuardado);
                    } else {
                        System.out.println("Lo siento, pero para usar el parámetro -w se necesita");
                        System.out.println("introducir también el nombre del archivo donde se quiere escribir.");
                    }
                    
                    
                    break;
            }
        }

    }
}
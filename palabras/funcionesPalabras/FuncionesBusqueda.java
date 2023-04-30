package funcionesPalabras;

import java.util.ArrayList;
import java.util.Collections;

import clasePalabras.PalabraText;

/*
 * FuncionesBusqueda.java
 * En esta clase, creamos las funciones necesarias para buscar palabras en el texto y realizar acciones con ellas
 * @author Cristina Delgado Muñoz
 * @CrisDelgado99
 */

public class FuncionesBusqueda {
    /*
     * Esta función cuenta las veces que una palabra aparece en un ArrayList tipo String
     * @param ArrayList<String> partes
     * @param String Palabra
     * @return int
     */
    public static int contadorPalabra(ArrayList<String> partes, String palabra){
        int contador = 0;
        for(String p: partes){
            if(p.toLowerCase().contains(palabra.toLowerCase())){
                contador++;
            }
        }

        return contador;
    }

    /*
     * Esta función imprime el número de apariciones de una palabra
     * @param int contador
     * @param String Palabra
     */

    public static void imprimirApariciones(int contador, String palabra){
        if(contador == 1){
            System.out.println("La palabra " + palabra + " aparece " + contador + " vez.");
        }else if(contador != 0){
            System.out.println("La palabra " + palabra + " aparece " + contador + " veces.");
        }else {
            System.out.println("La palabra " + palabra + " no aparece.");
        }
        
    }

    /*
     * Esta función indica la posición en que aparece una palabra en un ArrayList tipo String
     * @param ArrayList<String> partes
     * @param String Palabra
     * @return int
     */

    public static int posicionPalabra(String palabra, ArrayList<String> partes){
        int posicion = -1;
        for(int i = 0; i < partes.size(); i++){
            if(partes.get(i).toLowerCase().contains(palabra.toLowerCase())){
                return i+1;
            }
        }
        return posicion;
    }

    /*
     * Esta función cuenta la línea en la que una palabra aparece en un texto
     * @param ArrayList<String> partes
     * @param String Palabra
     * @return int
     */

    public static int lineaPalabra(String palabra, ArrayList<String> partes){
        int linea = 1;
        for(int i = 0; i < partes.size(); i++){
            if(partes.get(i).equals("\n")){
                linea++;
            }
            if(partes.get(i).toLowerCase().contains(palabra.toLowerCase())){
                return linea;
            }
        }
        return -1;
    }

    /*
     * Esta función imprime las palabras de un arrayList por cantidad de apariciones
     * @param ArrayList<PalabraText> palabraArr
     */

    public static void imprimirEnOrdenNumerico(ArrayList<PalabraText> palabraArr){
        for(int i = PalabraText.getMayorCantidad(); i > 0; i--){
            for(PalabraText pal: palabraArr)
            if(pal.getCantidad() == i && pal.getPalabra().matches("^[^A-Z]*$") && !pal.getPalabra().equals("")){
                if(pal.getCantidad() == 1){
                    System.out.println(pal.getPalabra() + ": " + pal.getCantidad() + " vez.");
                } else {
                    System.out.println(pal.getPalabra() + ": " + pal.getCantidad() + " veces.");
                }
            }
        }
    }

    /*
     * Esta función ordena alfabéticamente las palabras (sin repetir) de un ArrayList
     * @param ArrayList<String> palabrasNoRep
     * @param ArrayList<PalabraText> palabraArr
     */

    public static void ordenarAlfabeticamente(ArrayList<String> palabrasNoRep, ArrayList<PalabraText> palabraArr){
        Collections.sort(palabrasNoRep);

        for(String p: palabrasNoRep){
            for(PalabraText pal: palabraArr){
                if(p.equals(pal.getPalabra()) && !p.equals("")){
                    System.out.println(p + ": " + pal.getCantidad());
                }
            }
            
        }
    }
}
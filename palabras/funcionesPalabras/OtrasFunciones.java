package funcionesPalabras;

import java.util.ArrayList;
import clasePalabras.PalabraText;

/*
 * OtrasFunciones.java
 * Estas funciones son aquellas que me han servido para realizar este programa pero que no entran
 * en ninguna categoría de las anteriores.
 * @author Cristina Delgado Muñoz 
 * @CrisDelgado99
 */

public class OtrasFunciones {
    /*
     * Esta función devuelve un ArrayList tipo entero con los índices de la aparición de "\n" en un ArrayList tipo String
     * @param ArrayList<String> partes
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> buscarIndiceN(ArrayList<String> partes){
        ArrayList<Integer> indiceN = new ArrayList<>();

        for(int i = 0; i < partes.size(); i++){
            if(partes.get(i).equals("\n")){
                indiceN.add(i);
            }
        }

        return indiceN;
    }
    /*
     * Esta función devuelve un ArrayList tipo entero con los índices de la aparición de una palabra en un ArrayList tipo String
     * @param ArrayList<String> partes
     * @param String palabra
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> buscarIndice(ArrayList<String> partes, String palabra){
        ArrayList<Integer> indice = new ArrayList<>();

        for(int i = 0; i < partes.size(); i++){
            if(partes.get(i).contains(palabra)){
                indice.add(i);
            }
        }

        return indice;
    }
    
    /*
     * Esta función devuelve un ArrayList tipo String con las palabras que aparecen en otro ArrayList pero sin repetirlas.
     * @param ArrayList<String> partes
     * @return ArrayList<String>
     */
    public static ArrayList<String> buscarNoRepetidas(ArrayList<String> partes){
        ArrayList<String> palabrasNoRep = new ArrayList<>();
        for(String p: partes){
            if(!palabrasNoRep.contains(p.toLowerCase()) && !p.contains("\n")){
                palabrasNoRep.add(p.toLowerCase());
            }
        }
        return palabrasNoRep;
    }

    /*
     * Esta función devuelve un ArrayList tipo PalabraText a partir de unos ArrayLists tipo String
     * @param ArrayList<String> partes
     * @param ArrayList<String> palabrasNoRep
     * @return ArrayList<PalabraText>
     */
    public static ArrayList<PalabraText> crearArrayPalabraText(ArrayList<String> palabrasNoRep, ArrayList<String> partes){
        ArrayList<PalabraText> palabraArr = new ArrayList<>();

        for(String p: palabrasNoRep){
            palabraArr.add(new PalabraText(p, FuncionesBusqueda.contadorPalabra(partes, p)));
        }
        return palabraArr;
    }
}



package funcionesPalabras;

import java.util.ArrayList;

/*
 * FuncOrdenRandom.java
 * Esta clase contiene funciones que ordenan de forma aleatoria líneas o textos completos
 * @author Cristina Delgado Muñoz
 * @CrisDelgado99
 */
public class FuncOrdenRandom {
    /*
     * Esta función ordena de forma aleatoria las palabras de un texto completo
     * @param ArrayList<String> partes
     * @param ArrayList<int> indiceN
     * @return ArrayList<String>
     */
    //Esta función no es la definitiva, pero es la primera versión y, si quieres probarla, puedes hacerlo con el comando -R1
    public static ArrayList<String> ordenRandomTextCompl(ArrayList<String> partes, ArrayList<Integer> indiceN){
        ArrayList<String> partesDesorden = new ArrayList<>();

        for(int i = 0; i < partes.size(); i++){
            partesDesorden.add(" ");
        }

        for(int i = 0; i < partes.size(); i++){
            if(!partes.get(i).equals("\n")){
                partesDesorden.set((int)(Math.random()*partes.size()), partes.get(i));
            }
        }

        for(Integer indice: indiceN){
            partesDesorden.add(indice, "\n");
        }

        for(int i = 0; i < partesDesorden.size(); i++){
            if (partesDesorden.get(i).equals("")){
                partesDesorden.remove(partesDesorden.get(i));
                i--;
            }
        }

        return partesDesorden;
    }

    /*
     * Esta función ordena de forma aleatoria las palabras de un texto completo (Segunda versión de la anterior)
     * @param String ficheroCompleto
     * @param ArrayList<int> indiceN
     * @return String
     */
    public static String ordenRandomTextComplMejorada(String ficheroCompleto, ArrayList<Integer> indiceN){
        String textoDesordenado = "";
        String [] palabras = ficheroCompleto.split(" ");
        ArrayList<String> desorden = new ArrayList<>();
        for(String pal: palabras){
            if(!pal.equals("\n")){
                desorden.add(" ");
            }

            if(!pal.equals("\n")){
                desorden.add((int)(Math.random()*desorden.size()), pal);
            }

            for(int i = 0; i < desorden.size(); i++){
                if(desorden.get(i).equals(" ")){
                    desorden.remove(desorden.get(i));
                    i--;
                }
            }
        }

        for(Integer ind: indiceN){
            if(ind < desorden.size()){
                desorden.add(ind, "\n");
            }
            
        }
        textoDesordenado = FuncOrdenRandom.devolverArrayListEnString(desorden);
        return textoDesordenado;
    }

    /*
     * Esta función devuelve cada un ArrayList en forma de String (Sin saltos de línea)
     * @param ArrayList<String> linea
     * @return String
     */
    public static String devolverArrayListEnString(ArrayList<String> linea){
        String lineaSt = "";
        for(String lin: linea){
            lineaSt = lineaSt + lin + " ";
        }

        return lineaSt;
    }

    /*
     * Esta función ordena de forma aleatoria las palabras de cada línea de un texto
     * @param String textoGuardado
     * @return String
     */
    public static String ordenRandomLineas(String textoGuardado){
        String textoDesordenLinea = "";
        ArrayList<String> linea = new ArrayList<>();

        String[] lineas = textoGuardado.split("\n");

        for(String l: lineas){
            String[] lineaPrep = l.split(" ");
            for(String lin: lineaPrep){
                linea.add(" ");
            }
            for(String lin: lineaPrep){
                linea.add((int)(Math.random()*lineaPrep.length), lin);
            }

            for(int i = 0; i < linea.size(); i++){
                if(linea.get(i).equals(" ")){
                    linea.remove(linea.get(i));
                    i--;
                }
            }
            textoDesordenLinea = textoDesordenLinea + "\n" + devolverArrayListEnString(linea);
            linea.clear();
        }
        return textoDesordenLinea;
        
    }
}

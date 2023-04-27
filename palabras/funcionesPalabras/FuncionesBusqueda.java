package funcionesPalabras;

import java.util.ArrayList;

public class FuncionesBusqueda {
    public static int contadorPalabra(ArrayList<String> partes, String palabra){
        int contador = 0;
        for(String p: partes){
            if(p.toLowerCase().contains(palabra.toLowerCase())){
                contador++;
            }
        }

        return contador;
    }

    public static void imprimirApariciones(int contador, String palabra){
        if(contador == 1){
            System.out.println("La palabra " + palabra + " aparece " + contador + " vez.");
        }else if(contador != 0){
            System.out.println("La palabra " + palabra + " aparece " + contador + " veces.");
        }else {
            System.out.println("La palabra " + palabra + " no aparece.");
        }
        
    }

    public static int posicionPalabra(String palabra, ArrayList<String> partes){
        int posicion = -1;
        for(int i = 0; i < partes.size(); i++){
            if(partes.get(i).toLowerCase().contains(palabra.toLowerCase())){
                return i+1;
            }
        }
        return posicion;
    }

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
}
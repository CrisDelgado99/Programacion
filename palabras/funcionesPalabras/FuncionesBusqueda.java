package funcionesPalabras;

import java.util.ArrayList;
import java.util.Collections;

import clasePalabras.PalabraText;

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
package funcionesPalabras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * FuncTratamientoFicheros.java
 * En esta clase, creamos las funciones y los procedimientos necesarios para leer de ficheros y escribir en ellos.
 * @author Cristina Delgado Muñoz
 */
public class FuncTratamientoFicheros {

    /* 
     * Esta función lee el fichero completo y guarda las palabras en un arrayList llamado partes
     * ATENCIÓN: Las palabras no se encuentran separadas por espacios en el arrayList, pero las
     * líneas sí estan separadas por espacios de línea ("\n")
     * @param String nombreFichero
     * @return ArrayList <String> partes
     */
    public static ArrayList<String> leerFicheroCompleto(String nombreFichero){
        //Creamos el arrayList fuera del try para poder devolverlo al final, funcione o no el fichero
        ArrayList<String> partes = new ArrayList<>();

        //Try-catch para que, si el fichero no se puede leer o no se encuentra, ocurra un error.
        try{
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            String linea = "";

            linea = br.readLine();
            while(linea != null){
                String[]palabras = linea.split(" ");
                for(String p: palabras){
                    partes.add(p);
                    
                }
                partes.add("\n");
                linea = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return partes;
        
    }

}
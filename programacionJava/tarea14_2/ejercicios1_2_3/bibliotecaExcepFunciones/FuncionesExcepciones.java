package bibliotecaExcepFunciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FuncionesExcepciones {
    
    public static int comprobarOpcion(String numSt){
        if(numSt.matches("[1-9]+") && numSt != null){
            return Integer.parseInt(numSt);
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static int comprobarGenero(String numSt){
        if(numSt.matches("[1-2]") && numSt != null){
            return Integer.parseInt(numSt);
        } else {
            return -40;
        }
    }

    public static void excepcionStackOverFlow() throws StackOverflowError{
        excepcionStackOverFlow();
    }

    public static void excepcionNumberFormat() throws NumberFormatException{
        Integer.parseInt("error");
    }

    public static void excepcionArrayOutOfIndex() throws ArrayIndexOutOfBoundsException{
        int[] num = new int[4]; 
        for(int i = 0; i <= 4; i++){
            num[i] = 1;
        }
    }

    public static void excepcionFileNotFound() throws FileNotFoundException{
        File archivo = new File("hooola.txt");
        Scanner sc = new Scanner(archivo);    
        
    }

    public static void excepcionArithmetic() throws ArithmeticException{
        int num;
        num = 5/0;
    }

    public static void excepcionIO() throws IOException{
        File archivo = new File("hola.txt");
        archivo.createNewFile();
        archivo.delete();
        FileWriter writer = new FileWriter(archivo);  
        writer.write("Hola");
        writer.close();
    }
}

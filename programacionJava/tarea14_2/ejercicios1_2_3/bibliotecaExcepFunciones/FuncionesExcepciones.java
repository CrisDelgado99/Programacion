package bibliotecaExcepFunciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FuncionesExcepciones {
    
    public static int comprobarOpcion(String numSt){
        int num = 0;
        try{
            num = Integer.parseInt(numSt);
        } catch (NumberFormatException nfe){
            System.out.println("Error: " + nfe.getClass().getName() + " ==> " + nfe.getMessage());
            num = Integer.MIN_VALUE;
        } catch (Exception e){
            System.out.println("Error: " + e.getClass().getName() + " ==> " + e.getMessage());
            num = Integer.MIN_VALUE;
        }
        return num;
    }

    public static int comprobarGenero(String numSt){
        if(numSt.matches("[1-2]") && numSt != null){
            return Integer.parseInt(numSt);
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static void excepcionStackOverFlow() throws StackOverflowError{
        throw new StackOverflowError();
    }

    public static void excepcionNumberFormat() throws NumberFormatException{
        throw new NumberFormatException();
    }

    public static void excepcionArrayOutOfIndex() throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void excepcionFileNotFound() throws FileNotFoundException{
        throw new FileNotFoundException(); 
    }

    public static void excepcionArithmetic() throws ArithmeticException{
        throw new ArithmeticException();
    }

    public static void excepcionIO() throws IOException{
        throw new IOException();
    }
}

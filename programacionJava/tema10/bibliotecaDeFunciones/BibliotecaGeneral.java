package bibliotecaDeFunciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaGeneral {
    public static int leerIntComprobarExcep(){
        Scanner sc = new Scanner(System.in);
        
        int num;
        
        try{
            num = sc.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Excepción: " + e.getClass());
            System.out.println("Error: " + e.getMessage());
            num = -1;
        }

        return num;
    }

    public static double leerDoubleComprobarExcep(){
        Scanner sc = new Scanner(System.in);
        
        double num;
        
        try{
            num = sc.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Excepción: " + e.getClass());
            System.out.println("Error: " + e.getMessage());
            num = -1;
        }

        return num;
    }
}

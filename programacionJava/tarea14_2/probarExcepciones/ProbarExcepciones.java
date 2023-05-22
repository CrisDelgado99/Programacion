import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ProbarExcepciones {
    public static void main(String[] args){
        try{
            int opcion;
            opcion = 0;

            System.out.println("Seleccione una excepción para lanzar:");
            System.out.println("1. StackOverFlowError.");
            System.out.println("2. NumberFormatException.");
            System.out.println("3. ArrayIndexOutOfBoundsException.");
            System.out.println("4. FileNotFoundException.");
            System.out.println("5. ArithmeticException.");
            System.out.println("6. Salir.");
            System.out.print("Opcion (1-6) ==> ");
            opcion = comprobarOpcion(System.console().readLine());
            while(opcion < 1 || opcion > 6){
                System.out.print("Lo siento, la opción debe ser un número entero entre 1 y 6: ");
                opcion = comprobarOpcion(System.console().readLine());
            }

            switch(opcion){
                case 1:
                    excepcionStackOverFlow();
                    break;
                case 2:
                    excepcionNumberFormat();;
                    break;
                case 3:
                    excepcionArrayOutOfIndex();
                    break;
                case 4:
                    excepcionFileNotFound();
                    break;
                case 5:
                    excepcionArithmetic();
                    break;
                default:
                    System.out.println("Saliendo del programa. Gracias por utilizarlo.");
            }
            
        }catch(StackOverflowError sofe){
            System.out.println("Error ==> " + sofe.getClass().getName() + ": " + sofe.getMessage());
        }catch(NumberFormatException nfe){
            System.out.println("Error ==> " + nfe.getClass().getName() + ": " + nfe.getMessage());
        }catch(ArrayIndexOutOfBoundsException aiobe){
            System.out.println("Error ==> " + aiobe.getClass().getName() + ": " + aiobe.getMessage());
        }catch(FileNotFoundException fnfe){
            System.out.println("Error ==> " + fnfe.getClass().getName() + ": " + fnfe.getMessage());
        }catch (ArithmeticException ae){
            System.out.println("Error ==> " + ae.getClass().getName() + ": " + ae.getMessage());
        }
    }

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

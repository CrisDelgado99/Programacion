import bibliotecaExcepFunciones.FuncionesExcepciones;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[]args){
        try{
            int opcion;
            opcion = (int)(Math.random()*6+1);

            switch(opcion){
                case 1:
                    FuncionesExcepciones.excepcionStackOverFlow();
                    break;
                case 2:
                    FuncionesExcepciones.excepcionNumberFormat();;
                    break;
                case 3:
                    FuncionesExcepciones.excepcionArrayOutOfIndex();
                    break;
                case 4:
                    FuncionesExcepciones.excepcionFileNotFound();
                    break;
                case 5:
                    FuncionesExcepciones.excepcionArithmetic();
                    break;
                case 6:
                    FuncionesExcepciones.excepcionIO();
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
        } catch (IOException ioe){
            System.out.println("Error ==> " + ioe.getClass().getName() + ": " + ioe.getMessage());
        }
    }
}

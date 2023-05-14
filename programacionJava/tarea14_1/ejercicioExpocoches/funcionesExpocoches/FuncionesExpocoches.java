package funcionesExpocoches;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionesExpocoches {
    public static int excepcionOpcion(){
        int num;
        Scanner sc = new Scanner(System.in);
        try{
            num = sc.nextInt();
            return num;
        } catch (InputMismatchException ime){
            System.out.println("Error ==> " + ime.getClass().getName() + ": " + ime.getMessage());
            return 0;
        }
    }
}

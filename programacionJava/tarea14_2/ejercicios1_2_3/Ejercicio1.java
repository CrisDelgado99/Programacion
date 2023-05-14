import bibliotecaExcepFunciones.FuncionesExcepciones;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] num = new int[6];
        int numMayor;
        numMayor = Integer.MIN_VALUE;

        String resultado;
        resultado = "Los números introducidos son: ";

        for(int i = 0; i < 6; i++){
            System.out.print(i+1 + "º número: por favor, introduzca un número: ");
            num[i] =FuncionesExcepciones.comprobarOpcion(System.console().readLine());
            while(num[i] == Integer.MIN_VALUE){
                System.out.print("Se debe introducir un número entero: ");
                num[i] =FuncionesExcepciones.comprobarOpcion(System.console().readLine());
            }

            if(num[i] > numMayor){
                numMayor = num[i];
            }

            if(i == 5){
                resultado = resultado + num[i] + ".";
            } else {
                resultado = resultado + num[i] + ", ";
            }

        }

        resultado = resultado + "\nEl mayor de los números introducidos es: " + numMayor;
        System.out.println(resultado);
    }


}

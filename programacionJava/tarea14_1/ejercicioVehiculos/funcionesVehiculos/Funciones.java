package funcionesVehiculos;

public class Funciones {
    public static int comprobarNum(String numSt){
        if(numSt.matches("[0-9]*") && numSt != null){
            return Integer.parseInt(numSt);
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static double comprobarDouble(String numSt){
        if(numSt.matches("[0-9.]*") && numSt != null){
            return Double.parseDouble(numSt);
        } else {
            return Double.MIN_VALUE;
        }
    }
}

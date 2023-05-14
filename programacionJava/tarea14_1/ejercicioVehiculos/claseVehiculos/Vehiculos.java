package claseVehiculos;

public class Vehiculos {

    //Variables numerales necesarias
    private static int vehiculosCreados = 0;
    private static double kilometrosTotales = 0;

    public Vehiculos(){
        vehiculosCreados++;
    }

    //Getters de las variables estáticas
    public static int getVehiculosCreados(){
        return Vehiculos.vehiculosCreados;
    }

    public static double getKilometrosTotales(){
        return Vehiculos.kilometrosTotales;
    }

    //setters
    public static void setKilometrosTotales(double km){
        Vehiculos.kilometrosTotales = kilometrosTotales + km;
    }


}

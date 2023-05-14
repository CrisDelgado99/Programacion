package claseVehiculos;

public class Coche extends Vehiculos {
    //Strings necesarias
    private String tipoVehiculo = "Coche";
    private String nombreVehiculo;

    //Variables numerales necesarias
    private double kilometrosRecorridos = 0;


    public Coche(String nombre){
        super();
        this.nombreVehiculo = nombre;
    }

    //getters
    public double getKilometrosRecorridos(){
        return this.kilometrosRecorridos;
    }

    public void anda(double km){
        this.kilometrosRecorridos += km;
        setKilometrosTotales(km);
    }

    public String quemaRueda(){
        return "      ____________________\n     /                    \\__\n====(                        |*\n==== ------------------------|\n      (   )            (   ) ";
    }

}
package claseVehiculos;

public class Bicicleta extends Vehiculos{
    //Strings necesarias
    private String tipoVehiculo = "Bicicleta";
    private String nombreVehiculo;

    //Variables numerales necesarias
    private double kilometrosRecorridos = 0;


    public Bicicleta(String nombre){
        super();
        this.nombreVehiculo = nombre;
    }

    public double getKilometrosRecorridos(){
        return this.kilometrosRecorridos;
    }

    public void anda(double km){
        this.kilometrosRecorridos += km;
        setKilometrosTotales(km);
    }

    public String hazCaballito(){
        return "\n   |---[__(   )\n      /\n     /\n    /\n    \\\n      (   )";
    }
}

import claseVehiculos.Coche;
import claseVehiculos.Bicicleta;
import claseVehiculos.Vehiculos;
import funcionesVehiculos.Funciones;

public class MainVehiculos {
    public static void main(String[]args){
        Coche coche = new Coche("Seat 1");

        Bicicleta bici = new Bicicleta("Rayo");

        double kmAndados;
        int opcion;
        //MENÚ
        do{
            System.out.println("VEHÍCULOS");
            System.out.println("==========");
            System.out.println("1. Anda con la bicicleta");
            System.out.println("2. Haz el caballito con la bicicleta");
            System.out.println("3. Anda con el coche");
            System.out.println("4. Quema rueda con el coche");
            System.out.println("5. Ver kilometraje de la bicicleta");
            System.out.println("6. Ver kilometraje del coche");
            System.out.println("7. Ver kilometraje total");
            System.out.println("8. Salir");
            System.out.print("Elige una opción (1-8): ");
    
            
            opcion = Funciones.comprobarNum(System.console().readLine());
    
            while(opcion < 0 || opcion > 8){
                System.out.println("Esa no es una opción válida.");
                System.out.print("Elige una opción (1-8): ");
                opcion = Funciones.comprobarNum(System.console().readLine());
            }
    
            
    
            switch(opcion){
                case 1:
                    System.out.print("¿Cuántos kilómetros quieres que ande tu bicicleta?: ");
                    kmAndados = Funciones.comprobarDouble(System.console().readLine());
                    while(kmAndados < 0){
                        System.out.print("Se debe introducir un número entero positivo: ");
                        kmAndados = Funciones.comprobarDouble(System.console().readLine());
                    }
                    bici.anda(kmAndados);
                    break;
                case 2:
                    System.out.println(bici.hazCaballito()); 
                    break;
                case 3:
                    System.out.print("¿Cuántos kilómetros quieres que ande tu coche?: ");
                    kmAndados = Funciones.comprobarDouble(System.console().readLine());
                    while(kmAndados < 0){
                        System.out.print("Se debe introducir un número entero positivo: ");
                        kmAndados = Funciones.comprobarDouble(System.console().readLine());
                    }
                    coche.anda(kmAndados);
                    break;
                case 4:
                    System.out.println(coche.quemaRueda()); 
                    break;
                case 5:
                    System.out.println("La bicicleta ha andado " + bici.getKilometrosRecorridos() + " kilómetros.");
                    break;
                case 6:
                    System.out.println("El coche ha andado " + coche.getKilometrosRecorridos() + " kilómetros.");
                    break;
                case 7:
                System.out.println("Se han recorrido " + Vehiculos.getKilometrosTotales() + " kilómetros en total.");
                    break;
                default:
                    System.out.println("Saliendo. Gracias por usar el programa.");
            }
        }while(opcion != 8);

    }
}

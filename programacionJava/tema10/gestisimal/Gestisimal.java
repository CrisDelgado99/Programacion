package gestisimal;

import java.io.Console;
import java.util.ArrayList;

import gestisimal.bibliotecaDeFunciones.BibliotecaGeneral;
import gestisimal.articulo.Articulo;

public class Gestisimal {
    public static void main(String[]args){
        System.out.println("¡Bienvenido a la página del servicio Gestisimal!");

        //Variables necesarias
        String nombre;
        nombre = "";

        int cod;
        cod = 1;

        int opModif;
        opModif = 0;

        String codSt;
        codSt = "";

        int stock;
        stock = 1;

        double pVenta;
        pVenta = 1;

        double pCompra;
        pCompra = 1;

        boolean igual;
        igual = false;

        boolean esta;
        esta = false;

        //ArrayList y 2 primeros elementos
        ArrayList <Articulo> articulo = new ArrayList<Articulo>();

        articulo.add(0, new Articulo("0001", 10, 20, 45, "Jarrón de flores"));
        articulo.add(1, new Articulo("0002", 25, 18, 40, "Jarrón verde"));

        int opcion;

        do{
            //Mostrar menú
            System.out.println("¿Qué operación desea realizar?: (1-7)");
            System.out.println("1. Listado");
            System.out.println("2. Alta");
            System.out.println("3. Baja");
            System.out.println("4. Modificación");
            System.out.println("5. Entrada de mercancía");
            System.out.println("6. Salida de mercancía");
            System.out.println("7. Salir");
            do{
                System.out.print("Introduzca la opción que desee: ");
                opcion = BibliotecaGeneral.leerIntComprobarExcep();
    
                if(opcion == -1){
                    System.out.println("Se debe introducir un número entero.");
                } else if(opcion < 1 || opcion > 7){
                    System.out.println("El número introducido ha de estar entre 1 y 7.");
                } 
    
            } while(opcion < 1 || opcion > 7);
    
            switch(opcion){
                case 1: //Mostrar lista de artículos-------------------------------------------------------------------------
                    if(articulo.isEmpty()){
                        System.out.println("En este momento no contamos con ningún artículo.");
                    } else {
                        System.out.println("Los artículos con los que contamos ahora mismo son:");
                        for(int i = 0; i < articulo.size(); i++){
                            System.out.println(articulo.get(i));
                        }
                    }

                    break;
                case 2: //Dar de alta un artículo----------------------------------------------------------------------------
                    System.out.println("Vamos a dar de alta un artículo.");

                    System.out.println("Introduzca el nombre del artículo: ");
                    nombre = System.console().readLine();

                    do{
                        igual = false;
                        do{
                            System.out.println("Introduzca el código del artículo: ");
                            cod = BibliotecaGeneral.leerIntComprobarExcep();
    
                            if(cod < 0 || cod > 9999){
                                System.out.println("El código debe ser un número entero de entre 1 y 4 cifras.");
                            }
                        } while (cod < 0 || cod > 9999);
    
                        //Convertimos el número entero en un string con 4 cifras, completando con 0s los espacios sobrantes
                        if(cod < 10){
                            codSt = "000" + cod;
                        } else if (cod < 100){
                            codSt = "00" + cod;
                        } else if (cod < 1000){
                            codSt = "0" + cod;
                        } else {
                            codSt = "" + cod;
                        }

                        //Comprobamos que el código no esté cogido para que sea un código único
                        for(int i = 0; i < articulo.size(); i++){
                            if(codSt.equals(articulo.get(i).getCodigo())){
                                igual = true;
                                System.out.println("Lo siento, ese código ya existe.");
                            }
                        } 
                    } while (igual);

                    do{
                        System.out.println("Introduzca el precio de venta del artículo: ");
                        pVenta = BibliotecaGeneral.leerDoubleComprobarExcep();

                        if(pVenta < 0){
                            System.out.println("El precio de venta debe ser un número positivo.");
                        }
                    } while(pVenta < 0);

                    do{
                        System.out.println("Introduzca el precio de compra del artículo: ");
                        pCompra = BibliotecaGeneral.leerDoubleComprobarExcep();

                        if(pCompra < 0){
                            System.out.println("El precio de compra debe ser un número positivo.");
                        }
                    } while(pCompra < 0);

                    do{
                        System.out.println("Introduzca el stock del artículo: ");
                        cod = BibliotecaGeneral.leerIntComprobarExcep();

                        if(stock < 0){
                            System.out.println("El stock debe ser un número entero positivo.");
                        }
                    } while (stock < 0);

                    articulo.add(new Articulo(codSt, stock, pCompra, pVenta, nombre));

                    break;

                case 3: //Dar de baja un artículo--------------------------------------------------------------------------
                    if(articulo.isEmpty()){
                        System.out.println("No hay ningún artículo, por lo que no pueden ser borrados.");
                    } else {
                        System.out.println("Vamos a dar de baja un artículo:");
                        System.out.println("Los códigos de los artículos que hay disponibles son los siguientes:");
                        for(Articulo a: articulo){
                            System.out.println(a.getDescripcion() + ": " + a.getCodigo() + ".");
                        }
                        System.out.println("Escoja uno de los códigos existentes para dar de baja el artículo: ");
                        codSt = System.console().readLine();

                        for(int i = 0; i < articulo.size(); i++){
                            if(articulo.get(i).getCodigo().equals(codSt)){
                                esta = true;
                                articulo.remove(i);
                            }
                        }

                        if(esta){
                            System.out.println("El artículo se ha borrado.");
                        } else {
                            System.out.println("No existe ningún artículo con ese código.");
                            System.out.println("El código debe tener esta forma: 0003, 0011, 0256, etc.");
                        }
                    }
                    break;
                case 4: //Modificar un artículo----------------------------------------------------------------------------
                    if(articulo.isEmpty()){
                        System.out.println("No hay ningún artículo, por lo que no pueden ser modificados.");
                    } else {
                        System.out.println("Vamos a dar de modificar un artículo.");
                        System.out.println("Los códigos de los artículos que hay disponibles son los siguientes:");
                        for(Articulo a: articulo){
                            System.out.println(a.getDescripcion() + ": " + a.getCodigo() + ".");
                        }
                        System.out.println("Escoja uno de los códigos existentes para modificar el artículo: ");
                        codSt = System.console().readLine();

                        for(int i = 0; i < articulo.size(); i++){
                            if(articulo.get(i).getCodigo().equals(codSt)){ //Aquí seleccionamos el artículo
                                esta = true;
                                while(opModif != 6){
                                    System.out.println("¿Qué desea modificar?");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Código");
                                    System.out.println("3. Stock");
                                    System.out.println("4. Precio de compra");
                                    System.out.println("5. Precio de venta");
                                    System.out.println("6. Salir");
                                    opModif = BibliotecaGeneral.leerIntComprobarExcep();
                                    while(opModif < 1 || opModif > 6){
                                        System.out.println("Debe introducir un número entero entre 1 y 6:");
                                        opModif = BibliotecaGeneral.leerIntComprobarExcep();
                                    }

                                    switch(opModif){
                                        case 1:
                                            System.out.print("Introduzca el nuevo nombre del producto: ");
                                            nombre = System.console().readLine();
                                            articulo.get(i).setDescripcion(nombre);
                                            break;
                                        case 2:
                                            do{
                                                igual = false;
                                                do{
                                                    System.out.println("Introduzca el nuevo código del artículo: ");
                                                    cod = BibliotecaGeneral.leerIntComprobarExcep();
                        
                                                    if(cod < 0 || cod > 9999){
                                                        System.out.println("El código debe ser un número entero de entre 1 y 4 cifras.");
                                                    }
                                                } while (cod < 0 || cod > 9999);
                        
                                                if(cod < 10){
                                                    codSt = "000" + cod;
                                                } else if (cod < 100){
                                                    codSt = "00" + cod;
                                                } else if (cod < 1000){
                                                    codSt = "0" + cod;
                                                } else {
                                                    codSt = "" + cod;
                                                }
                    
                                                for(int i2 = 0; i2 < articulo.size(); i2++){
                                                    if(codSt.equals(articulo.get(i2).getCodigo())){
                                                        igual = true;
                                                        System.out.println("Lo siento, ese código ya existe.");
                                                    }
                                                } 
                                            } while (igual);
                                            articulo.get(i).setDescripcion(codSt);
                                            break;
                                        case 3:
                                            do{
                                                System.out.println("Introduzca el nuevo stock del artículo: ");
                                                cod = BibliotecaGeneral.leerIntComprobarExcep();
                    
                                                if(stock < 0){
                                                    System.out.println("El stock debe ser un número entero positivo.");
                                                }
                                            } while (stock < 0);
                                                articulo.get(i).setStock(stock);
                                            break;
                                        case 4: 
                                            do{
                                                System.out.println("Introduzca el precio de compra del artículo: ");
                                                pCompra = BibliotecaGeneral.leerDoubleComprobarExcep();
                    
                                                if(pCompra < 0){
                                                    System.out.println("El precio de compra debe ser un número positivo.");
                                                }
                                            } while(pCompra < 0);
                                            articulo.get(i).setPrecioCompra(pCompra);
                                            break;
                                        case 5:
                                            do{
                                                System.out.println("Introduzca el nuevo precio de venta del artículo: ");
                                                pVenta = BibliotecaGeneral.leerDoubleComprobarExcep();
                
                                                if(pVenta < 0){
                                                    System.out.println("El precio de compra debe ser un número positivo.");
                                                }
                                            } while(pVenta < 0);
                                                articulo.get(i).setPrecioVenta(pVenta);
                                            break;
                                    }
                                }
                            }
                        }

                        } if(esta == false) {
                            System.out.println("No existe ningún artículo con ese código.");
                            System.out.println("El código debe tener esta forma: 0003, 0011, 0256, etc.");
                        }
                    break;
                case 5: //Recibir mercancía-------------------------------------------------------------------------------
                    if(articulo.isEmpty()){
                        System.out.println("No hay ningún artículo.");
                    } else {
                        System.out.println("Vamos aumentar el stock de un artículo:");
                        System.out.println("Los códigos de los artículos que hay disponibles son los siguientes:");
                        for(Articulo a: articulo){
                            System.out.println(a.getDescripcion() + ": " + a.getCodigo() + ".");
                        }
                        System.out.println("Escoja uno de los códigos existentes para aumentar el stock del artículo: ");
                        codSt = System.console().readLine();

                        for(Articulo a: articulo){
                            if(a.getCodigo().equals(codSt)){
                                esta = true;
                                System.out.print("¿Qué cantidad quieres que se reciba?");
                                do{
                                    stock = BibliotecaGeneral.leerIntComprobarExcep();
                                    if(stock < 0){
                                        System.out.println("El stock debe ser un número positivo.");
                                    }
                                } while (stock < 0);
                                a.recibirMercancia(stock);
                            }
                        }
                    }
    
                    if(esta == false){
                        System.out.println("No existe ningún artículo con ese código.");
                        System.out.println("El código debe tener esta forma: 0003, 0011, 0256, etc.");
                    }
                    break;
                case 6: //Enviar mercancía--------------------------------------------------------------------------
                    if(articulo.isEmpty()){
                        System.out.println("No hay ningún artículo.");
                    } else {
                        System.out.println("Vamos disminuir el stock de un artículo:");
                    System.out.println("Los códigos de los artículos que hay disponibles son los siguientes:");
                        for(Articulo a: articulo){
                            System.out.println(a.getDescripcion() + ": " + a.getCodigo() + ".");
                        }
                        System.out.println("Escoja uno de los códigos existentes para disminuir el stock del artículo: ");
                        codSt = System.console().readLine();

                        for(Articulo a: articulo){
                            if(a.getCodigo().equals(codSt)){
                                esta = true;
                                System.out.print("¿Qué cantidad quieres que se envíe?");
                                do{
                                    stock = BibliotecaGeneral.leerIntComprobarExcep();
                                    if(stock < 0){
                                        System.out.println("El stock debe ser un número positivo.");
                                    }
                                } while (stock < 0);
                            a.enviarMercancia(stock);
                            }
                        }
                    }

                    if(esta == false){
                        System.out.println("No existe ningún artículo con ese código.");
                        System.out.println("El código debe tener esta forma: 0003, 0011, 0256, etc.");
                    }
                    break;
                case 7:
                    System.out.println("Gracias por utilizar Gestisimal, ¡Tenga un buen día!");
                    break;
            }
        } while(opcion != 7);

        
        
    }
    
}

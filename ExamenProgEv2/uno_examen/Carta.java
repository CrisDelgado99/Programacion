/*
 * Carta.java
 * La clase carta sirve para crear cartas del juego Uno, teniendo en cuenta los colores y
 * números posibles de estas y controlando si se pueden jugar, si son comodines...
 * @author Cristina Delgado Muñoz @CrisDelgado99
 */

public class Carta {
    //Atributos de instancia--------------------------------------------------------------------
    private int numero;
    private String color;

    //Atributos estáticos-----------------------------------------------------------------------
    private static Carta cartaEnJuego;

    private static final String ROJO = "\033[1;101m";
    private static final String VERDE = "\033[42m";           
    private static final String AMARILLO = "\033[1;103m";
    private static final String AZUL = "\033[0;104m";
    private static final String PURPURA = "\033[1;105m";
    private static final String GRIS = "\033[1;100m";
    private static final String RESET = "\033[0m";

    //Constructor---------------------------------------------------------------------------
    public Carta(int numero, String color){
        this.numero = numero;
        this.color = color;
    }

    //setters------------------------------------------------------------------------------
    /*
     * setCartaEnJuego, que permite saber con qué carta se deben comparar las cartas que tiene
     * el jugador.
     * @param Carta
     */
    public static void setCartaEnJuego(Carta carta){
        cartaEnJuego = carta;
    }

    //getters----------------------------------------------------------------------------
    /*
     * getNumero, permite obtener el número de una carta
     * @return int
     */
    public int getNumero(){
        return this.numero;
    }

    /*
     * getColor, permite obtener el color de una carta
     * @return String
     */
    public String getColor(){
        return this.color;
    }

    /*
     * getCartaEnJuego, permite obtener la carta con la que se comparan las cartas de los jugadores
     * @return Carta
     */
    public static Carta getCartaEnJuego(){
        return cartaEnJuego;
    }

    //Otros métodos-----------------------------------------------------------------------------------
    /*
     * esComodin, permite saber si una carta es comodín o no
     * @return boolean
     */
    public boolean esComodin(){
        return(this.numero == 0);
    }

    /*
     * esJugable, permite saber si una carta se puede jugar, comparándola con la carta en juego
     * @return boolean
     */
    public boolean esJugable(){
        if((this.numero == cartaEnJuego.numero) || (this.color.equals(cartaEnJuego.color)) || this.esComodin() || cartaEnJuego.esComodin()){
            return true;
        } else {
            return false;
        }
    }

    /*
     * dibujaFila, dibuja las filas de la carta según su número y color
     * @return String
     */
    public String dibujaFila(int fila){
        if (numero == 0){
            switch (fila) {
                case 1:
                    return ROJO + "/" + PURPURA + " " + VERDE + "\\" + RESET;
                case 2:
                    return PURPURA + " " + numero + " " + RESET;
                case 3:
                    return AZUL + "\\" + PURPURA + " " + AMARILLO + "/" + RESET;
                default: 
                    return "";
            }
        } else {
            switch (fila) {
                case 1:
                    return this.color + "/ \\" + RESET;
                case 2:
                    return this.color + " " + numero + " " + RESET;
                case 3:
                    return this.color + "\\ /" + RESET;
                default: 
                    return "";
            }
        }

    }

    //toString--------------------------------------------------------------------------
    public String toString(){
        return color + numero + RESET;
    }


}

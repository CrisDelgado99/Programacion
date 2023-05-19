

/**
 * Clase Uno: Juego de cartas simulado con jugadas aleatorias.
 * Contiene el programa principal (main) ejecutable para el juego Uno.
 * Dependencias: Clase Carta (instancias y estático), Clase Jugador (instancias).
 *  
 * Examen DAM DAW del 19/05/2023
 * Faltan métodos que debe implementar el/la alumno/a
 * 
 * @Author Pablo Carmona
 * @version 19/05/2023
 */

public class Uno {

  // Atributos de clase. Variables globales. NO TOCAR!
  static final int NUM_CARTAS = 22;                               // 4 colores x 5 números, y 2 comodines
  static Carta[] cartas = crearCartas();                          // Lista de cartas para el mazo. Cada una contiene color y número.
  static Jugador jugador1 = new Jugador("Jugador 1");      // Se crean los 2 jugadores, con su nombre
  static Jugador jugador2 = new Jugador("Jugador 2");
  static Jugador jugadorTurno = jugador1;                         // El jugador que empieza

  // Colores ANSI : Al imprimirse delante del texto lo cambia de color. 
  // Hay que imprimir RESET detrás para volver a normal. NO TOCAR!
  static final String ROJO = "\033[1;101m";
  static final String VERDE = "\033[42m";           
  static final String AMARILLO = "\033[1;103m";
  static final String AZUL = "\033[0;104m";
  static final String PURPURA = "\033[1;105m";
  static final String GRIS = "\033[1;100m";
  static final String RESET = "\033[0m";
  
//=======================================================================================================================================
// MAIN COMPLETO, NO TOCAR!
//=======================================================================================================================================
    public static void main (String[] args) {

    // Intro
    //-----------------------------------------------------------------------------------------------------------------------------------
    System.out.println("\n\n# Juego UNO Demo #\n");
    System.out.println("Cada jugador puede colocar una carta que coincida en color o número con la que hay en juego.");
    System.out.println("Si le quedan cartas, pero no tiene ninguna que pueda colocar, debe robar una del mazo.");
    System.out.println("El 0 es comodín, y puede colocarse sobre cualquiera, y cualquiera sobre él.");
    System.out.println("Gana quien se quede antes sin cartas, o si se acaba el mazo, quien tenga menos.");
    pausa(3);


    // Preparar el juego
    //-----------------------------------------------------------------------------------------------------------------------------------
    barajarCartas();
    for (int i = 0; i < 5; i++) {                   // Se reparten 5 cartas a cada jugador
      jugador1.cogeCarta(robaDelMazo());
      jugador2.cogeCarta(robaDelMazo());
    }
    Carta.setCartaEnJuego(robaDelMazo());           // La siguienteCarta con la que se empieza la partida


    // Ronda de jugadores hasta que no puedan jugar y no queden en el mazo, o hasta que alguno gane
    //-----------------------------------------------------------------------------------------------------------------------------------
    while ((jugador1.puedeJugar() || jugador2.puedeJugar() || hayCartasEnMazo()) // Mientras alguno pueda jugar o queden cartas en el mazo
            && (jugador1.numCartas() > 0) && (jugador2.numCartas() > 0)) {       // Y mientras no haya ganado ninguno (no tenga cartas)

      imprimeMesa();                                                             // Dibuja todas las cartas

      if (jugadorTurno.puedeJugar()) {                                           // Si puede jugar, coloca una carta al azar
        jugadorTurno.juegaCartaAleatoria();
        System.out.println(jugadorTurno.getNombre() + " coloca una carta");

      } else if (hayCartasEnMazo()){                                             // Si no puede jugar, o la carta era un (+) intenta robar del mazo
        System.out.println(jugadorTurno.getNombre() + " no puede jugar, coge carta");
        jugadorTurno.cogeCarta(robaDelMazo());                                   // Dar carta a jugador, si quedan en el mazo

      } else {                                                                   //Si no puede jugar, y no quedan cartas en el mazo, no puede hacer nada        
        System.out.println(jugadorTurno.getNombre() + " no puede jugar, y no quedan cartas");
      }

      pausa(2);
      jugadorTurno = (jugadorTurno == jugador1 ? jugador2 : jugador1);           // Alterna jugadorTurno (jugador1 / jugador2)
    }

    // Fin de la partida, gana quien tenga menos cartas
    //-----------------------------------------------------------------------------------------------------------------------------------
    imprimeMesa();
    mensajeFinal();    // Imprime quién gana

  }
  


//=======================================================================================================================================
// /!\                                            MÉTODOS POR IMPLEMENTAR!!                                                           /!\
//=======================================================================================================================================

  // barajarCartas
  // Recorre la lista de cartas, desordenándolas aleatoriamente
  //-------------------------------------------------------------------------------------------------------------------------------------
  public static void barajarCartas(){
    Carta[] barajada = new Carta[NUM_CARTAS];
    int posicion = 0;
    for(Carta c: cartas){
      posicion = (int)(Math.random()*NUM_CARTAS);
      if(barajada[posicion] == null){
        barajada[posicion] = c;
      } else {
        for(int i = 0; i < barajada.length; i++){
          if(barajada[i] == null){
            barajada[i] = c;
            break; //Estoy saliendo del bucle for para que no se duplique la carta
          }
        }
      }
    }
    cartas = barajada;
  }

  // hayCartasEnMazo
  // Devuelve true si hay alguna carta en la lista que no sea null
  //-------------------------------------------------------------------------------------------------------------------------------------
  public static boolean hayCartasEnMazo(){
    for(Carta c: cartas){
      if(c != null){
        return true;
      } 
    }
    return false;
  }

  // robaDelMazo
  // Devuelve la primera carta del mazo que no es null, y su lugar en el array lo pone a null, para eliminarla del mazo
  // En el array de cartas irán quedando null a la izquierda, y cartas a la derecha
  //-------------------------------------------------------------------------------------------------------------------------------------
  public static Carta robaDelMazo(){
    Carta devuelta = null;
    for(int i = 0; i < cartas.length; i++){
      if(cartas[i] != null){
        devuelta = cartas[i];
        cartas[i] = null;
        break;
      }
    }
    return devuelta;
  }

//=======================================================================================================================================
// /!\                                           MÉTODOS COMPLETOS, NO TOCAR!                                                         /!\
//=======================================================================================================================================

  // crearCartas
  // Crea la baraja de cartas: 5 numeros x 4 colores, y 2 comodines (0 - púrpura)
  //-------------------------------------------------------------------------------------------------------------------------------------
  public static Carta[] crearCartas() {
    Carta[] cartas =  new Carta[NUM_CARTAS];
    for (int i = 0; i <= 4; i++) { 
      cartas[i*4] = new Carta(i+1, ROJO);    
      cartas[i*4+1] = new Carta(i+1, VERDE);   
      cartas[i*4+2] = new Carta(i+1, AMARILLO);
      cartas[i*4+3] = new Carta(i+1, AZUL); 
    }
    cartas[20] = new Carta(0, PURPURA);
    cartas[21] = new Carta(0, PURPURA);
    return cartas;
  }

  // Dibuja la mesa con todas las cartas.
  // Usa métodos Carta.toString(fila) con parámetros
  //-------------------------------------------------------------------------------------------------------------------------------------
  public static void imprimeMesa() {
    System.out.print("\n\n\n\n");                                              // 4  Saltos de línea
    System.out.println(jugador1.getNombre());
    System.out.print(jugador1);                                                  // Imprime las 3 líneas de cartas del jugador 1
    System.out.print("\n\n");                                                  // 2 Saltos de línea
                                                                                 // Imprime el mazo y la carta en juego, en 3 líneas
    System.out.print(hayCartasEnMazo() ? GRIS + "/ \\" + RESET : "   ");         // Sólo dibuja el mazo si quedan cartas
    System.out.print("       " + Carta.getCartaEnJuego().dibujaFila(1));           // Dibuja la carta en juego
    System.out.println(RESET);
    System.out.print(hayCartasEnMazo() ? GRIS + " · " + RESET : "   ");
    System.out.print("       " + Carta.getCartaEnJuego().dibujaFila(2));
    System.out.print(" < Carta en juego");
    System.out.println(RESET);
    System.out.print(hayCartasEnMazo() ? GRIS + "\\ /" + RESET : "   ");
    System.out.print("       " + Carta.getCartaEnJuego().dibujaFila(3));
    System.out.print(RESET + "\n ^ \n ");
    for (Carta c : cartas) {
      if (c != null) {
        System.out.print(c.getColor() + c.getNumero() + RESET);
      }
    }
    System.out.print(" < Cartas en el mazo \n\n\n");                                                  // 2 Saltos de línea
    System.out.print(jugador2);  
    System.out.println(jugador2.getNombre());                                                // Imprime las 3 líneas de cartas del jugador 1
    System.out.print("\n---------------------------------------\n");         // 2 Saltos de línea
  }

  // Mensaje final de partida, muestra quién gana.
  // Usa Jugador.numCartas, Jugador.getNombre
  //-------------------------------------------------------------------------------------------------------------------------------------

  public static void mensajeFinal() {
    System.out.println("****************************");
    if (jugador1.numCartas() == jugador2.numCartas()) {
      System.out.println("¡EMPATE!");
    } else if (jugador1.numCartas() < jugador2.numCartas()) {
      System.out.println("¡Gana " + jugador1.getNombre() + "!");
    } else {
      System.out.println("¡Gana " + jugador2.getNombre() + "!");
    }
    System.out.println("****************************");

  }

  // Pausa
  //-------------------------------------------------------------------------------------------------------------------------------------
  public static void pausa(int segundos) {
    try {
      Thread.sleep(segundos*1000); 
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasePersonaje;

/**
 *
 * @author rhiap
 */
public class Personaje {
    private String personaje;
    private String imagenPersonaje;
    private String imagenPersonajeHappy;
    
    
    private int tipoMano; //Valores de tipoMano: 2 blanca, 1 negra
    private String imagenBocadillo;
    
    public Personaje(String personaje){ 
        this.personaje = personaje;
        this.imagenPersonaje = personaje + ".png";
        this.imagenPersonajeHappy = personaje + "Happy.gif";
        
        if(this.personaje.matches(".*[1-3]")){
            this.tipoMano = 2; //Mano blanca
        } else {
            this.tipoMano = 1; //Mano negra
        }
        
        switch(this.personaje){
            case "nina1":
            case "nina4":
            case "nino1":
            case "nino4":
                this.imagenBocadillo = "bocadilloNaranja.png"; //
                break;
            case "nina2":
            case "nina5":
                this.imagenBocadillo = "bocadilloRosa.png";
                break;
            case "nina3":
            case "nina6":
            case "nino3":
            case "nino6":
                this.imagenBocadillo = "bocadilloMorado.png";
                break;
            case "nino2":
            case "nino5":
                this.imagenBocadillo = "bocadilloVerde.png";
                break;   
        }
        
    }
    
    //getters
        
    /**
     * Color de la mano del personaje
     * @return tipo de mano
    */
    public int getTipoMano(){
        return this.tipoMano;
    }
    
    /**
     * Devuelve la imagen normal del personaje
     * @return imagen
    */
    public String getImagen(){
        return "imgs/" + this.imagenPersonaje;
    }
    
    /**
     * Devuelve la imagen feliz del personaje
     * @return imagen feliz
    */
    public String getImagenHappy(){
        return "imgs/" + this.imagenPersonajeHappy;
    }
    
    /**
     * Devuelve la imagen del bocadillo del personaje
     * @return imagen bocadillo
    */
    public String getImagenBocadillo(){
        return "imgs/" + this.imagenBocadillo;
    }
    
    //Juego
    public int tiraPiedra(int eleccionBeepboop){
        //1: gana jugador, 0: gana BeepBoop, 2: empate.
        int ganador = 0;
        switch(eleccionBeepboop){
            case 0:
                ganador = 2;
                break;
            case 1:
                ganador = 0;
                break;
            case 2:
                ganador = 1;
                break;
        }
        
        return ganador;
    }
    
    public int tiraPapel(int eleccionBeepboop){
        //1: gana jugador, 0: gana BeepBoop, 2: empate.
        int ganador = 0;
        switch(eleccionBeepboop){
            case 0:
                ganador = 1;
                break;
            case 1:
                ganador = 2;
                break;
            case 2:
                ganador = 0;
                break;
        }
        
        return ganador;
    }
    
    public int tiraTijeras(int eleccionBeepboop){
        //1: gana jugador, 0: gana BeepBoop, 2: empate.
        int ganador = 0;
        switch(eleccionBeepboop){
            case 0:
                ganador = 0;
                break;
            case 1:
                ganador = 1;
                break;
            case 2:
                ganador = 2;
                break;
        }
        
        return ganador;
    }
    
    
}

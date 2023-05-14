/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misGatitos;

/**
 *
 * @author rhiap
 */
public class Gato {
    private String nombre;
    private String color;
    private String genero;
    private String imagen;
    private String imagenYoga;
    private String imagenMueble;
    
    public Gato(String nombre, String color, String genero){
        this.nombre = nombre;
        this.color = color;
        this.genero = genero;
        this.imagen = "imgs/gatito" + color + ".png";
        this.imagenYoga = "imgs/gatito" + color + "Yoga.png";
        this.imagenMueble = "imgs/gatito" + color + "Mueble.png";
    }
    
    
    
    public String switchMacho(int num, Gato companiero){
        String dialogo = "";
                switch(num){
            case 0:
                 dialogo = "¡Mi pelaje es mucho más sedoso que el de " + companiero.nombre + "!";   
                 break;
            case 1: 
                dialogo = "¡Hola! digo... Miau.";
                break;
            case 2:
                dialogo = "Quiero irme a comer...";
                break;
            case 3:
                dialogo = "Soy tu rey, humano.";
                break;
            case 4: 
                dialogo = "¿Me rascas la tripita?";
                break;
            case 5:
                dialogo = "No hagas caso a " + companiero.nombre + ". ¡Sólo quiere robarme la comida!";
                break;
            case 6:
                dialogo = "¿Te gusta el atún? A mí me gusta bastante...";
                break;
            case 7: 
                dialogo = "Puede que me caiga bien " + companiero.nombre + ", pero no se lo digas.";
                break;
            case 8:
                dialogo = "¡" + this.nombre + " es mucho mejor nombre que " + companiero.nombre +"!";
                break;
            case 9:
                dialogo = "Menos mal que no hay perros por aquí... aunque " + companiero.nombre + " parece uno.";
                break;
            case 10:
                dialogo = "En realidad " + companiero.nombre + " y yo somos buenos amigos, pero nos encanta hacer el tonto.";
                break;    
        }
        return dialogo;
    
    }
    
    public String switchHembra(int num, Gato companiero){
        String dialogo = "";
                switch(num){
            case 0:
                 dialogo = "¡Mi pelaje es mucho más sedoso que el de " + companiero.nombre + "!";   
                 break;
            case 1: 
                dialogo = "¡Hola! digo... Miau.";
                break;
            case 2:
                dialogo = "Quiero irme a comer...";
                break;
            case 3:
                dialogo = "Soy tu reina, humano.";
                break;
            case 4: 
                dialogo = "¿Me rascas la tripita?";
                break;
            case 5:
                dialogo = "No hagas caso a " + companiero.nombre + ". ¡Sólo quiere robarme la comida!";
                break;
            case 6:
                dialogo = "¿Te gusta el atún? A mí me gusta bastante...";
                break;
            case 7: 
                dialogo = "Puede que me caiga bien " + companiero.nombre + ", pero no se lo digas.";
                break;
            case 8:
                dialogo = "¡" + this.nombre + " es mucho mejor nombre que " + companiero.nombre +"!";
                break;
            case 9:
                dialogo = "Menos mal que no hay perros por aquí... aunque " + companiero.nombre + " parece uno.";
                break;
            case 10:
                if(companiero.genero.matches("Macho")){
                    dialogo = "En realidad " + companiero.nombre + " y yo somos buenos amigos, pero nos encanta hacer el tonto."; 
                } else {
                    dialogo = "En realidad " + companiero.nombre + " y yo somos buenas amigas, pero nos encanta hacer el tonto.";
                }
                break; 
        }
        return dialogo;
    }
    
    public String hablarGatito(Gato companiero){
        int num = (int)(Math.random()*11);
        String dialogo = "";
        
        if(this.genero.matches("Hembra")){
            dialogo = this.switchHembra(num, companiero);
        } else {
            dialogo = this.switchMacho(num, companiero);
        }
        
        return dialogo;
    }
    
    public String presentarse(){
        if (this.genero.matches("Macho")){
            return "Hola, soy " + this.nombre + ". ¡Encantado!";
        }
        return "Hola, soy " + this.nombre + ". ¡Encantada!";
    }
    
    public String imagenGuapo(){
        return "imgs/gatito" + color + "Guapo.png";
    }
    
    //getters
    public String getNombre(){
        return this.nombre;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public String getGenero(){
        return this.genero;
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public String getImagenYoga(){
        return this.imagenYoga;
    }
    
    public String getImagenMueble(){
        return this.imagenMueble;
    }
    
    
}

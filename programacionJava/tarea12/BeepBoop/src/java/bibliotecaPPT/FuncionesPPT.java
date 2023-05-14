/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaPPT;

/**
 *
 * @author rhiap
 */
public class FuncionesPPT {
    public static String elegirImagenManoRobot(int eleccion){
        String img = "";
        switch(eleccion){
            case 0:
                img = "imgs/piedraBeepboop.png";
                break;
            case 1:
                img = "imgs/papelBeepboop.png";
                break;
            case 2:
                img = "imgs/tijerasBeepboop.png";
                break;
        }
        
        return img;
    }
}

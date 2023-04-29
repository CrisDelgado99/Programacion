package funcionesPalabras;

import java.util.ArrayList;
import clasePalabras.PalabraText;
import funcionesPalabras.FuncionesBusqueda;

public class OtrasFunciones {
    public static ArrayList<Integer> buscarIndiceN(ArrayList<String> partes){
        ArrayList<Integer> indiceN = new ArrayList<>();

        for(int i = 0; i < partes.size(); i++){
            if(partes.get(i).equals("\n")){
                indiceN.add(i);
            }
        }

        return indiceN;
    }

    public static ArrayList<String> buscarNoRepetidas(ArrayList<String> partes){
        ArrayList<String> palabrasNoRep = new ArrayList<>();
        for(String p: partes){
            if(!palabrasNoRep.contains(p.toLowerCase()) && !p.contains("\n")){
                palabrasNoRep.add(p.toLowerCase());
            }
        }
        return palabrasNoRep;
    }

    public static ArrayList<PalabraText> crearArrayPalabraText(ArrayList<String> palabrasNoRep, ArrayList<String> partes){
        ArrayList<PalabraText> palabraArr = new ArrayList<>();

        for(String p: palabrasNoRep){
            palabraArr.add(new PalabraText(p, FuncionesBusqueda.posicionPalabra(p, partes), FuncionesBusqueda.lineaPalabra(p, partes), FuncionesBusqueda.contadorPalabra(partes, p)));
        }
        return palabraArr;
    }

    public static void imprimirEnOrdenNumerico(ArrayList<PalabraText> palabraArr){
        for(int i = 1000; i > 0; i--){
            for(PalabraText pal: palabraArr)
            if(pal.getCantidad() == i && pal.getPalabra().matches("^[^A-Z]*$") && !pal.getPalabra().equals("")){
                if(pal.getCantidad() == 1){
                    System.out.println(pal.getPalabra() + ": " + pal.getCantidad() + " vez.");
                } else {
                    System.out.println(pal.getPalabra() + ": " + pal.getCantidad() + " veces.");
                }
            }
        }
    }
}



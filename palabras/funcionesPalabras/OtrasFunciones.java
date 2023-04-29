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

    public static ArrayList<Integer> buscarIndice(ArrayList<String> partes, String palabra){
        ArrayList<Integer> indice = new ArrayList<>();

        for(int i = 0; i < partes.size(); i++){
            if(partes.get(i).contains(palabra)){
                indice.add(i);
            }
        }

        return indice;
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
}



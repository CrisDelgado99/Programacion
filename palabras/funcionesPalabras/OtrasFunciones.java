package funcionesPalabras;

import java.util.ArrayList;

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
}

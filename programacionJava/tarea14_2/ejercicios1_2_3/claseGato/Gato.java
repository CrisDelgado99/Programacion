package claseGato;

import bibliotecaExcepFunciones.ExcepcionApareamientoImposible;

public class Gato{
    private String clasificacion;
    private String raza;
    private String imagen;
    private String nombre;
    
    private int genero;
    private int patas;
    private int ojos;
    
    private boolean cola;
    
    //constructor///////////////////////////////////////////
    public Gato(String r, String n, int g){
        clasificacion = "Mamífero";

        patas = 4;
        ojos = 2;
        cola = true;

        raza = r;
        nombre = n;
        genero = g;

        imagen = "\\    /\\\n )  ( ')\n(  /  )\n \\(__)|";
    }

    //getters//////////////////////////////////////

    public String getClasificacion(){
        return this.clasificacion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getRaza(){
        return this.raza;
    }

    public String getImagen(){
        return this.imagen;
    }

    public int getPatas(){
        return this.patas;
    }

    public int getOjos(){
        return this.ojos;
    }

    public boolean getCola(){
        return this.cola;
    }

    public String getGenero(){
        if(this.genero == 1){
            return "Macho";
        } else {
            return "Hembra";
        }
    }

    //Otros métodos

    public void imprimirGato(){
        System.out.println(this.imagen);
        System.out.printf("%-15s%s\n", "Nombre: ", this.nombre);
        System.out.printf("%-15s%s\n","Clasificación: ", this.clasificacion);
        System.out.printf("%-15s%s\n", "Raza: ", this.raza);
        System.out.printf("%-15s%s\n", "Género: ", this.getGenero());
        System.out.printf("%-15s%d\n", "Patas: ", this.patas);
        System.out.printf("%-15s%d\n", "Ojos: ", this.ojos);

        if(cola){
            System.out.printf("%-15s%s\n","Cola:", "Sí");
        } else {
            System.out.printf("%-15s%s\n","Cola:", "No");
        }
    }

    public void maullar(){
        System.out.println("Miaaaaauu");
    }

    public void trepar(){
        System.out.println(" \\    /\\");
        System.out.println("  )  ( ')");
        System.out.println(" (  /  )");
        System.out.println("  \\(__)|");
        System.out.println("  =======");
        System.out.println("  |__=__|");
        System.out.println("  |__=__|");
        System.out.println("  |__=__|");
    }

    public Gato apareaCon(Gato companiero) throws ExcepcionApareamientoImposible{
        if(this.genero==companiero.genero){
            throw new ExcepcionApareamientoImposible();
        } else {
            int genero;
            genero = (int)(Math.random()*2+1);  //1 macho, 2 hembra
            String raza;
            if(this.raza.toLowerCase().equals(companiero.raza.toLowerCase())){
                raza = this.raza;
            } else {
                raza = "Cruce entre " + this.raza + " y " + companiero.raza + ".";
            }
            
            String nombre;
            System.out.print("Vaya, parece que la cría es ");
            if(genero == 1){
                System.out.println("macho.");
            } else {
                System.out.println("hembra.");
            }
            System.out.print("Póngale nombre a la cría: ");
            nombre = System.console().readLine();
            
            Gato cria = new Gato(raza, nombre, genero);
            return cria;
        }
    }
}

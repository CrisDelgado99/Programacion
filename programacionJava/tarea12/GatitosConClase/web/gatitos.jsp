<%-- 
    Document   : gatitos
    Created on : 12 may 2023, 14:14:24
    Author     : rhiap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="misGatitos.Gato"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            <%--He tenido que utilizar el css en el propio jsp porque cuando lo usaba fuera algunas cosas no funcionaban--%>

            *{
                font-size: 15pt;
            }
            body{
                display: flex;
                flex-direction: row;
                justify-content: center;
                width: 100%;
                height: 100vh;
                top:0;
                background-color: black;
            }

            form{
                background-image: url("imgs/fondo.png");
                top: 0;
                width: 80%;
                height:100%;
                background-size:100%;
                background-repeat: no-repeat;
                background-position:top;
                display: flex;
                align-items: center;
                justify-content: center;
            }

            #espacioGatuno{
                display: flex;
                width: 50%;
                align-items: center;
                justify-content: center;
            }

            .gato{
                margin-top:80px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
            }

            .presentacion{
                margin-right: 20px; 
                background-repeat:no-repeat;
                background-position: center;
                width: 200px;
                height: 150px;
                background-size:100% 100%;
                display:flex;
                align-items:center;
                justify-content: center;
            }
            
            .presentacion p{
                font-size: 15pt;
                text-align:center;
                padding-bottom:10px;
                
            }
            
            .frase p{
                font-size: 16pt;
                text-align:center;
                padding-bottom:10px;
                padding-left: 15px;
                padding-right: 15px;
                
            }
            
            .frase{
                margin-left: 20px; 
                background-repeat:no-repeat;
                background-position: center;
                width: 300px;
                height: 200px;
                background-size:100% 100%;
                display:flex;
                align-items:center;
                justify-content: center;
            }
            
            .contBocadillo{
                display:flex;
            }
            
            .imgGatito{
                width: 300px;
                height: 300px;
            }
            
            .botones{
                display:flex;
                width: 470px;
                justify-content:space-around;
            }
            
            .botones button{
                height:100px;
                width:150px;
                border-radius: 15px;
                background-color: rgba(250, 182, 220, 0.8);
                border: 3px dashed rgba(101, 157, 170, 1);
            }
            
            .botones button:hover{
                background-color: rgba(250, 182, 220, 1);
                cursor: pointer;
            }
        </style>
        
        <%--css en el que se encuentra la fuente utilizada--%>
        <link rel="stylesheet" href="gatitos.css">
        <script>
           function quitarPresentacion(){
               //Encontrar elementos que queremos hacer invisibles usando su id
               let pres1 = document.getElementById("presentacion1");
               let pPres1 = document.getElementById("pPresentacion1");
               let pres2 = document.getElementById("presentacion2");
               let pPres2 = document.getElementById("pPresentacion2");
               
               //Hacer invisibles los elementos
               pres1.style.visibility = "hidden";
               pPres1.style.visibility = "hidden";
               pres2.style.visibility = "hidden";
               pPres2.style.visibility = "hidden";
           } 
            
        </script>
    </head>
    
            <%
        //Encontramos los parámetros que han sido enviados desde la página anterior
        String nombre1 = request.getParameter("nombreGato1");
        String nombre2 = request.getParameter("nombreGato2");
        String color1 = request.getParameter("colorGato1");
        String color2 = request.getParameter("colorGato2");
        String genero1 = request.getParameter("generoGato1");
        String genero2 = request.getParameter("generoGato2");
        
        //creamos los objetos tipo Gato con los parámetros recogidos
        Gato gato1 = new Gato(nombre1, color1, genero1);
        Gato gato2 = new Gato(nombre2, color2, genero2);
        
        //Creamos la variable imagen para que recoja la imagen que debe usarse
        String imagen1;
        String imagen2;
        
        //Si no es nulo uno de los parámetros recogidos de los botones, la imagen
        //se utilizará, si todos son nulos, se enseñará la imagen principal del gato 1
        if(request.getParameter("yoga1") != null){
            imagen1 = gato1.getImagenYoga();
        } else if(request.getParameter("mueble1") != null){
            imagen1 = gato1.getImagenMueble();
        } else if(request.getParameter("guapo1") != null){ 
            imagen1 = gato1.imagenGuapo();
        }else {
            imagen1 = gato1.getImagen();
        }
        
        //Si no es nulo uno de los parámetros recogidos de los botones, la imagen
        //se utilizará, si todos son nulos, se enseñará la imagen principal del gato 2
        if(request.getParameter("yoga2") != null){
            imagen2 = gato2.getImagenYoga();
        } else if(request.getParameter("mueble2") != null){
            imagen2 = gato2.getImagenMueble();
        } else if(request.getParameter("guapo2") != null){ 
            imagen2 = gato2.imagenGuapo();
        } else {
            imagen2 = gato2.getImagen();
        }
        
        //Inicializamos el contador para saber si es la primera vez que el gato aparece,
        //lo que sirve para saber si ha de presentarse o no.
        int contador = -80;
        
        //Si no existe contador, es que es la primera vez, contador 0. Si existe, se
        //recoge;
        if(request.getParameter("contador") == null){
            contador = 0;
        } else {
            contador = Integer.parseInt(request.getParameter("contador"));
        }
        %>
        
        <body style="display: flex; justify-content: center;" <%
        //Utilizando el contador ya definido, si es más de 0, se hace desaparecer
        //el bocadillo de presentación con la función quitarPresentacion()
        if(contador > 0){
            out.print("onload=\"quitarPresentacion()\"");
        }
        
        %>>
        

        <form style="background-color: black;">
            <div id="espacioGatuno">
                <div id="gato1">
                    <div class="gato">
                        <div class="contBocadillo">
                            <div id="presentacion1" class="presentacion" style="background-image: url(<%out.print("imgs/bocadillo" + gato1.getColor() + "Izq.png");%>)">
                                <p id="pPresentacion1"><%out.print(gato1.presentarse());%><p>
                            </div>
                            <div class="frase" style="background-image: url(<%out.print("imgs/bocadillo" + gato1.getColor() + "Der.png");%>)">
                                <p><%out.print(gato1.hablarGatito(gato2));%></p>
                            </div>
                        </div>

                            <img src="<%out.print(imagen1);%>" alt="Gatito" class="imgGatito">
                        
                    </div>
                
                    <div class="botones">
                        <button type="submit" name="yoga1"><%out.print(gato1.getNombre());%>, Haz yoga</button>
                        <button type="submit" name="mueble1"><%out.print(gato1.getNombre());%>, Súbete a un mueble</button>
                        <button type="submit" name="guapo1"><%
                            //Según el género del gato 1, se le dice que se ponga guapo o guapa
                            if(gato1.getGenero().matches("Hembra")){
                                out.print(gato1.getNombre() + ", ponte guapa");
                            } else {
                                out.print(gato1.getNombre() + ", ponte guapo");
                            }
                            
                        %></button>
                    </div>
                </div>
        
                <div id="gato2">
                    <div class="gato">
                        <div class="contBocadillo">
                            <div id="presentacion2" class="presentacion" style="background-image: url(<%out.print("imgs/bocadillo" + gato2.getColor() + "Izq.png");%>)">
                                <p id="pPresentacion2"><%out.print(gato2.presentarse());%><p>
                            </div>
                            <div class="frase" style="background-image: url(<%out.print("imgs/bocadillo" + gato2.getColor() + "Der.png");%>)">
                                <p><%out.print(gato2.hablarGatito(gato1));%></p>
                            </div>
                        </div>
                            
                        <%--
                            transform:scaleX(-1) sirve para que el gato mire a la izquierda 
                            en lugar de a la derecha
                        --%>
                        <img style="transform: scaleX(-1);" src="<%out.print(imagen2);%>" alt="Gatito" class="imgGatito">
                    </div>
                        
                    <div class="botones">
                        <button type="submit" name="yoga2"><%out.print(gato2.getNombre());%>, Haz yoga</button>
                        <button type="submit" name="mueble2"><%out.print(gato2.getNombre());%>, Súbete a un mueble</button>
                        <button type="submit" name="guapo2"><%
                            //Según el género del gato 2, se le dice que se ponga guapo o guapa
                            if(gato2.getGenero().matches("Hembra")){
                                out.print(gato2.getNombre() + ", ponte guapa");
                            } else {
                                out.print(gato2.getNombre() + ", ponte guapo");
                            }
                            
                        %></button>
                    </div>
                </div> 

            </div>
                    <%--
                        Estos inputs no se verán, pero sirven para que cuando la página
                        se recargue al pulsar botones, se envíe la información necesaria
                        para que funcione el programa
                    --%>
                    <input type="text" name="nombreGato1" value="<%out.print(nombre1);%>" style="display: none;">    
                    <input type="text" name="nombreGato2" value="<%out.print(nombre2);%>" style="display: none;">    
                    <input type="text" name="colorGato1" value="<%out.print(color1);%>" style="display: none;">    
                    <input type="text" name="colorGato2" value="<%out.print(color2);%>" style="display: none;">  
                    <input type="text" name="generoGato1" value="<%out.print(genero1);%>" style="display: none;">    
                    <input type="text" name="generoGato2" value="<%out.print(genero2);%>" style="display: none;"> 
                    <input type="text" name="contador" value="<%out.print(++contador);%>" style="display: none;"> 
                    
        </form>
    </body>
</html>

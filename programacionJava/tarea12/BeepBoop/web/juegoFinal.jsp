<%-- 
    Document   : juegoFinal
    Created on : 7 may 2023, 18:21:56
    Author     : rhiap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clasePersonaje.Personaje"%>
<%@page import="bibliotecaPPT.FuncionesPPT"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="indice.css">
        <link rel="stylesheet" href="juego1.css">
        <link rel="stylesheet" href="juego2.css">
        <style>
            main{
                background-image: url(imgs/fondoTotal.png);
                background-size: 100% 100%;
                padding: 60px;
                padding-top: 180px;
                padding-bottom: 90px;
                background-repeat: no-repeat;
            }
            
            #seleccionTirada input{
                height: 80px;
                width: 120px;
                margin: 10px;
                font-size: 17pt;
                background-color: rgba(222, 195, 206,0.5);
                border-radius: 15px;
            }
            
            #seleccionTirada input:hover{
                font-size: 19pt;
                background-color: rgba(222, 195, 206,0.8);
                cursor: pointer;
            }
        </style>

        <%
                    String personajeElegido = request.getParameter("jugador");
                    Personaje jugador = new Personaje(personajeElegido);
                    
                    int contadorBeepboop = Integer.parseInt(request.getParameter("contadorBeepboop"));
                    int contadorJugador = Integer.parseInt(request.getParameter("contadorJugador"));
                    boolean ganaJugador = false;
                    
                    if(contadorJugador > contadorBeepboop){
                        ganaJugador = true;
                    }
   
        %>
    </head>
    <body>
        <header>
           <h1>¿PIEDRA, PAPEL O TIJERAS?</h1> 
        </header>
        <main>
            <div id="espacioDeJuego">
                
                <div id="espJugador" class="espPers">
                    <div class="ayudaAlturaPersonaje">

                        <%
                        String img2 = jugador.getImagenHappy();
                        String img1 = jugador.getImagen();
                        if(ganaJugador){
                            out.print("<img class=\"imgJug\" src=\"" + img2 + "\" alt=\"BeepBoop\" />");
                        } else {
                            out.print("<img class=\"imgJug\" src=\"" + img1 + "\" alt=\"BeepBoop\" />");
                        }
                        
                        %>
                    </div>
                    <div class="ayudaAlturaBocadillo" id="contJug">
                        <div class="bocadilloCont" style="background-image: url(<%out.print(jugador.getImagenBocadillo());%>);">
                            <p><%
                        if(ganaJugador){
                            out.print("¡VIVA!");
                        } else {
                            out.print("BeepBoop ha ganado");
                        }
                                %></p>
                        </div>
                    </div>
                </div>
                
                <div id="espPPT">
                    <div style="background-image: url(imgs/fondoPPT.png)">
                        
                    </div>
                    <div style="background-image: url(imgs/fondoPPT.png)">
                        
                    </div>
                </div>
                
                <div id="espBeepBoop" class="espPers">
                    <div class="ayudaAlturaPersonaje">
                        
                        <%
                        img2 = "imgs/beepboopHappy.gif";
                        img1 = "imgs/beepboop.png";
                        if(ganaJugador == false){
                            out.print("<img class=\"imgBB\" src=\"" + img2 + "\" alt=\"BeepBoop\" />");
                        } else {
                            out.print("<img class=\"imgBB\" src=\"" + img1 + "\" alt=\"BeepBoop\" />");
                        }
                        
                        %>
                    </div>
                    <div class="ayudaAlturaBocadillo" id="contBB">
                        <div class="bocadilloCont" style="background-image: url(imgs/bocadilloBeepboop.png);">
                            <p><%
                        if(ganaJugador == false){
                            out.print("¡VIVA!");
                        } else {
                            out.print("¡Enhorabuena, has ganado!");
                        }
                                %></p>

                        </div>
                    </div>
                </div>
            </div>
                   
        </main>
        <footer>
            <p>Pixel art y desarrollo web:</p>
            <p>&copy; 2023 Cristina Delgado Muñoz. All rights reserved.</p>
        </footer>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 6 may 2023, 12:01:03
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
        <script>
            function cambiarBotones(){
                //encuentro los id de los elementos cuyo display quiero cambiar
                var aEsconder1 = document.getElementById("botones1");
                var aEsconder2 = document.getElementById("botones2");
                var aEsconder3 = document.getElementById("botones3");

                var aMostrar = document.getElementById("boton");
                
                //uso los id para cambiar el display
                aEsconder1.style.display = "none"; // esconder aEsconder
                aEsconder2.style.display = "none"; // esconder aEsconder
                aEsconder3.style.display = "none"; // esconder aEsconder
                
                aMostrar.style.display = "block"; // hacer visible aMostrar
            };       
        </script>

        <%
                    String personajeElegido = request.getParameter("jugador");
                    Personaje jugador = new Personaje(personajeElegido);
                    int eleccionBeepboop = Integer.parseInt(request.getParameter("ultimaEleccionBeepboop"));
                    String manoBeepboop = FuncionesPPT.elegirImagenManoRobot(eleccionBeepboop);
                    
                    String manoJugador = "" + jugador.getTipoMano();
                    int ganador = -4;
                    int contadorBeepboop = Integer.parseInt(request.getParameter("contadorBeepboop"));
                    int contadorJugador = Integer.parseInt(request.getParameter("contadorJugador"));
                    
                    if(request.getParameter("piedra") != null){
                        ganador = jugador.tiraPiedra(eleccionBeepboop);
                        manoJugador ="imgs/piedra" + manoJugador + ".png";
                    } else if (request.getParameter("papel") != null){
                        ganador = jugador.tiraPapel(eleccionBeepboop);
                        manoJugador ="imgs/papel" + manoJugador + ".png";
                    } else if (request.getParameter("tijeras") != null) {
                        ganador = jugador.tiraTijeras(eleccionBeepboop);
                        manoJugador ="imgs/tijeras" + manoJugador + ".png";
                    }
                    
                    //1: gana jugador, 0: gana BeepBoop, 2: empate.
                    if(ganador == 1){
                        ++contadorJugador;
                    } else if (ganador == 0) {
                        ++contadorBeepboop;
                    }
                    
                    int contadorTotal = contadorBeepboop + contadorJugador;
                    
                    //nueva elección de BeepBoop, para la siguiente ronda.
                    eleccionBeepboop = (int)(Math.random()*3);
                    
        %>
    </head>
    <body <%
        
                        if(contadorTotal == 5){
                            out.print("onload=\"cambiarBotones()\"");
                        }
        %>>
        <header>
           <h1>¿PIEDRA, PAPEL O TIJERAS?</h1> 
        </header>
        <main>
            <div id="espacioDeJuego">
                
                <div id="espJugador" class="espPers">
                    <div class="ayudaAlturaPersonaje">
                        <img src="<%out.print(jugador.getImagen());%>" alt="BeepBoop"/> 
                    </div>
                    <div class="ayudaAlturaBocadillo">

                    </div>
                </div>
                
                <div id="espPPT">
                    <div style="background-image: url(imgs/fondoPPT.png)">
                        <img id="manoJugador" height="150" width="150" src="<%out.print(manoJugador);%>" alt="alt"/>
                    </div>
                    <div style="background-image: url(imgs/fondoPPT.png)">
                        <img id="manoBeepboop" height="150" width="150" src="<%out.print(manoBeepboop);%>" alt="alt"/>
                    </div>
                </div>
                
                <div id="espBeepBoop" class="espPers">
                    <div class="ayudaAlturaPersonaje">
                        <img src="imgs/beepboop.png" alt="BeepBoop"/> 
                    </div>
                    <div class="ayudaAlturaBocadillo">
                    </div>
                </div>
            </div>
      
            <div id="seleccionTirada">
                <form action="<%
                      
                    if(contadorTotal < 5){
                        out.print("juego2.jsp");
                    } else {
                        out.print("juegoFinal.jsp");
                    }

                      %>" method="post" target="_self">
                    
                    
                    <div>
                        <input id="botones1" type="submit" name="piedra" value="piedra" >
                        <input id="botones2" type="submit" name="papel" value="papel" >
                        <input id="botones3" type="submit" name="tijeras" value="tijeras" >
                        <input id="boton" type="submit" name="Ver resultado" value="Ver resultado" >   
                    </div>
                    <input type="text" name="jugador" value="<%out.print(personajeElegido);%>" style="display:none;">
                    
                    <input type="text" name="ultimaEleccionBeepboop" style="display:none;" value="<%out.print(eleccionBeepboop);%>">
                    
                     <input type="text" style="display:none;" name="contadorBeepboop" id="contador2" value="<%out.print(contadorBeepboop);%>">
                     <input type="text" style="display:none;" name="contadorJugador" id="contador1" value="<%out.print(contadorJugador);%>">
                     <input type="text" style="display:none;" name="contadorTotal" id="contadorTotal" value="<%out.print(contadorTotal);%>">
                    <p>Puntuación Jugador: <%out.print(contadorJugador);%></p>
                    <p>Puntuación BeepBoop: <%out.print(contadorBeepboop);%></p>
                </form>
            </div>                
        </main>
        <footer>
            <p>Pixel art y desarrollo web:</p>
            <p>&copy; 2023 Cristina Delgado Muñoz. All rights reserved.</p>
        </footer>
    </body>
</html>
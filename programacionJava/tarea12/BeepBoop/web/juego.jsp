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
    </head>
    <body>
        <header>
           <h1>¿PIEDRA, PAPEL O TIJERAS?</h1> 
        </header>
        <main>
            <div id="espacioDeJuego">
                
                <%
                    String personajeElegido = request.getParameter("personajeEleg");
                    Personaje jugador = new Personaje(personajeElegido);
                    
                    
                    int eleccionBeepboop = (int)(Math.random()*3);
                    int ganador = 0;
                    int contadorBeepboop = 0;
                    int contadorJugador = 0;
                    int contadorTotal = contadorBeepboop + contadorJugador;
                    
                %>
                
                <div id="espJugador" class="espPers">
                    <div class="ayudaAlturaPersonaje">
                        <img src="<%out.print(jugador.getImagen());%>" alt="BeepBoop"/> 
                    </div>
                    <div class="ayudaAlturaBocadillo">
                        <div class="bocadilloCont" style="background-image: url(<%out.print(jugador.getImagenBocadillo());%>);">
                            <p>¡Selecciona piedra,</p>
                            <p>papel o tijera, jugador!</p>
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
                        <img src="imgs/beepboop.png" alt="BeepBoop"/> 
                    </div>
                    <div class="ayudaAlturaBocadillo">
                        <div class="bocadilloCont" style="background-image: url(imgs/bocadilloBeepboop.png);">
                            <p>¡Buena suerte!</p>
                        </div>
                    </div>
                </div>
            
            
            </div>

            <div id="seleccionTirada">
                <form action="juego2.jsp" method="post" target="_self">
                    <div id="botones">
                        <input type="submit" name="piedra" value="piedra" onclick="ganadorPiedra">
                        <input type="submit" name="papel" value="papel" >
                        <input type="submit" name="tijeras" value="tijeras" >
                    </div>
                    
                    <input type="text" name="jugador" value="<%out.print(personajeElegido);%>" style="display:none;">
                    
                    <input type="text" name="ultimaEleccionBeepboop" style="display:none;" value="<%out.print(eleccionBeepboop);%>">
                    
                    <input type="text" name="contadorBeepboop" style="display:none;" id="contador2" value="<%out.print(contadorBeepboop);%>">
                    <input type="text" name="contadorJugador" style="display:none;" id="contador1" value="<%out.print(contadorJugador);%>">
                    <input type="text" name="contadorTotal" style="display:none;" id="contadorTotal" value="<%out.print(contadorTotal);%>">
                </form>
            </div>                
        </main>
        <footer>
            <p>Pixel art y desarrollo web:</p>
            <p>&copy; 2023 Cristina Delgado Muñoz. All rights reserved.</p>
        </footer>
    </body>
</html>

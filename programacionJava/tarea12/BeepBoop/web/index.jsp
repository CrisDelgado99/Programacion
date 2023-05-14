<%-- 
    Document   : index
    Created on : 6 may 2023, 12:01:03
    Author     : rhiap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clasePersonaje.Personaje"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="indice.css">
        <style>
            form{
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
            }
        </style>
    </head>
    <body>
        <header>
           <h1>¿PIEDRA, PAPEL O TIJERAS?</h1> 
        </header>
        <main>
            <div class="espPers">
                <div class="ayudaAlturaPersonaje">
                   <img src="imgs/beepboop.png" alt="BeepBoop"/> 
                </div>
                <div class="ayudaAlturaBocadillo">
                    <div class="bocadilloCont" style="background-image: url(imgs/bocadilloBeepboop.png);">
                        <p>¡Hola, soy BeepBoop!</p>
                        <p>¿Quieres jugar conmigo?</p>
                    </div>
                </div>
            </div>
            <div id="seleccionPersonaje">
                <form action="juego.jsp" method="post" target="_self">
                    <h3>Elige tu personaje: </h3>
                    <div id="tablasPersonajes">
                        <table>
                        <tr>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nina1.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nina1">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nina2.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nina2">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nina3.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nina3">
                                </div>                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nina4.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nina4">
                                </div>                                
                            </td>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nina5.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nina5">
                                </div>                                
                            </td>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nina6.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nina6">
                                </div>                                
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nino1.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nino1">  
                                </div>                                
                            </td>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nino2.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nino2">
                                </div>                                
                            </td>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nino3.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nino3">
                                </div>                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nino4.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nino4">
                                </div>                                
                            </td>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nino5.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nino5">                                
                                </div>
                            </td>
                            <td>
                                <div>
                                    <img class="personaje" src="imgs/nino6.png" alt="alt"/>
                                    <input type="radio" name="personajeEleg" value="nino6">
                                </div>
                            </td>
                        </tr>
                    </table>
                    </div>
                    <button type="submit">CONFIRMAR ELECCIÓN</button>
                </form>
            </div>
        </main>
        <footer>
            <p>Pixel art y desarrollo web:</p>
            <p>&copy; 2023 Cristina Delgado Muñoz. All rights reserved.</p>
        </footer>
    </body>
</html>

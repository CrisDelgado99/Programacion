<%-- 
    Document   : ayuda
    Created on : 11 may 2023, 19:28:27
    Author     : rhiap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                font-size: 17pt;
            }
            
            body{
                margin-top: 0px;
                background-image: url(imgs/fondoPatitasRepeat.png);
                background-size: 100px 100px;
                width: 100%;
                height: 100%;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            
            h1{
                font-size: 27pt;
                text-align: center;
            }
            
            h3{
                font-size: 23pt;
            }
            
            p{
                font-size: 17pt;
            }
            
            main{
                margin-top: 0px;
                padding-left: 20px;
                padding-right: 20px;
                width: 60%;
                background-color: rgba(255, 255, 255, 0.80);
                height: 100%;
                padding-bottom: 30px;
                border-radius: 0px 0px 15px 15px;
            }
            
            form{
                display:flex;
                flex-direction: column;
                align-items: center;
            }
            
            #dosForms{
                display: flex;
                justify-content: space-around;
                width: 80%;
                
            }
            
            .preguntas{
                display: flex;
                flex-direction: column;
            }
            
            .preguntas > input, .preguntas > select{
                margin-bottom: 20px;
                background-color: rgba(250, 182, 220, 0.43);
                padding: 10px;
                border-radius: 5px;
                border: 3px dashed rgba(150, 202, 214, 1);
                
            }
            
            button{
                height:100px;
                width:150px;
                border-radius: 15px;
                background-color: rgba(250, 182, 220, 0.8);
                border: 3px dashed rgba(101, 157, 170, 1);
                padding: 20px;
            }
            
            button:hover{
                background-color: rgba(250, 182, 220, 1);
                cursor: pointer;
            }
            
            footer{
                position:fixed;
                bottom: 0;
                left: 0;
                background-color: white;
                padding: 10px;
                border-radius: 0px 15px 0px 0px;
            }
            
            footer p{
                line-height: 80%;
            }
            
        </style>
        <link rel="stylesheet" href="gatitos.css">
    </head>
    <body>
        <header>
            
        </header>
        <main>
            <h1>Adopción de gatitos</h1>
            <p>Nos alegramos mucho de que quieras adoptar un gatito, pero para hacerlo hay que rellenar un formulario. Desgraciadamente, sólo puedes adoptar gatitos si los adoptas de dos en dos. ¡Pero tranquilo, nuestros gatitos están bien enseñados!</p>
            <form action="gatitos.jsp" method="post" target="_self">
                <div  id="dosForms">
                    <div class="preguntas">
                        <h3>Formulario de gato 1:</h3>
                        <label>Nombre:</label> <input type="text" name="nombreGato1" >
                        <label for="colorGato1">Elige el color:</label>

                        <select name="colorGato1" id="colorGato1">
                            <option value="Naranja">Naranja</option>
                            <option value="Marron">Marrón</option>
                            <option value="Negro">Negro</option>
                        </select>

                        <label for="generoGato1">¿Macho o hembra?</label>

                        <select name="generoGato1" id="generoGato1">
                            <option value="Macho">Macho</option>
                            <option value="Hembra">Hembra</option>
                        </select>
                    </div>
           
                    <div class="preguntas">
                        <h3>Formulario de gato 2:</h3>
                
                        <label>Nombre:</label> <input type="text" name="nombreGato2" >
                
                        <label for="colorGato2">Elige el color:</label>

                        <select name="colorGato2" id="colorGato2">
                            <option value="Naranja">Naranja</option>
                            <option value="Marron">Marrón</option>
                            <option value="Negro">Negro</option>
                        </select>
                
                        <label for="generoGato2">¿Macho o hembra?</label>

                        <select name="generoGato2" id="generoGato2">
                            <option value="Macho">Macho</option>
                            <option value="Hembra">Hembra</option>
                        </select>
                    </div>
                </div>

                <button type="submit">Adoptar gatitos</button>
        </form>
        </main>
        <footer>
            <p>Pixel art y desarrollo web:</p>
            <p>&copy; 2023 Cristina Delgado Muñoz. All rights reserved.</p>
        </footer>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 14 may 2023, 18:02:25
    Author     : rhiap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

                        <%
    int contador = 0;
    if(request.getParameter("contador") != null){
        contador = 1;
    }
    
    int chocolatePorcentaje = 0;
    int fresaPorcentaje = 0;
    int vainillaPorcentaje = 0;
    String mensaje = "";
    

        if(request.getParameter("chocolate") != null){
            if(request.getParameter("chocolate").matches("[0-9]+")){
                chocolatePorcentaje = Integer.parseInt(request.getParameter("chocolate"));
            }
        }
        
        if(request.getParameter("fresa") != null){
            if(request.getParameter("fresa").matches("[0-9]+")){
                fresaPorcentaje = Integer.parseInt(request.getParameter("fresa"));
            }
        }
        
        if(request.getParameter("vainilla") != null){
            if(request.getParameter("vainilla").matches("[0-9]+")){
                vainillaPorcentaje = Integer.parseInt(request.getParameter("vainilla"));
            }
        }

        if(contador == 0){
            mensaje = "Introduzca porcentajes entre 0 y 100, por favor";
        } else if(fresaPorcentaje >= 0 && vainillaPorcentaje >= 0 && chocolatePorcentaje >= 0){
             if(fresaPorcentaje + vainillaPorcentaje + chocolatePorcentaje > 100){
                mensaje = "En total, los porcentajes superan el 100%";
                chocolatePorcentaje = 0;
                fresaPorcentaje = 0;
                vainillaPorcentaje = 0;
        }else {
            mensaje = "Aquí tiene su helado, disfrútelo";
        }
    } else {
        mensaje = "Los porcentajes introducidos no son válidos.";
        chocolatePorcentaje = 0;
        fresaPorcentaje = 0;
        vainillaPorcentaje = 0;
    }
    
    %>
   
        
        <style>
            
            body{
                text-align:center;
            }
            form{
                display: flex;
                flex-direction: column;
                justify-content:center;
                align-items:center;
            }
            
            #tarrina{
                margin-top: 10px;
                height: 150px;
                width: 150px;
                border-bottom: 2px solid rgb(136, 178, 186);
                border-left: 2px solid rgb(136, 178, 186);
                border-right: 2px solid rgb(136, 178, 186);
                display:flex;
                flex-direction: column;
                justify-content: flex-end;
            }
            
            #fresa {
                width: 100%;
                height: <%out.print(fresaPorcentaje);%>%;
                background-color:pink;
            }
            
            #chocolate {
                width: 100%;
                height: <%out.print(chocolatePorcentaje);%>%;
                background-color:rgb(125, 111, 72);
            }
            
            #vainilla {
                width: 100%;
                height: <%out.print(vainillaPorcentaje);%>%;
                background-color:rgb(225, 227, 177);
            }
            
            .opciones{
                display:flex;
                justify-content:center
            }
            
            .sabor{
                display:flex;
                flex-direction:column;
                justify-content:center;
                align-items: center;
                padding: 30px;
            }
            
            .sabor img{
                width:150px;
                height: 150px;
            }
            
            button{
                height:100px;
                width: 100px;
            }
        </style>
        <link rel="stylesheet" href="fuente.css">
    </head>
    <body>
        <h1>MÁQUINA DE HELADOS</h1>
        <h2>Opciones:</h2>
        <form>
            <p>Seleccione la cantidad de helado que quiere:</p>
            <div class="opciones">
                
                <div class="sabor">
                    <p>Chocolate</p>
                    <img src="imgs/chocolate.png" alt="">
                    <input name="chocolate" type="text">
                </div>
                
                <div class="sabor">
                    <p>Fresa</p>
                    <img src="imgs/fresa.png" alt="">
                    <input name="fresa" type="text">                  
                </div>

                <div class="sabor">
                    <p>Vainilla</p>
                    <img src="imgs/vainilla.png" alt="">
                    <input name="vainilla" type="text">     
                </div>

            </div>
            
            <input name="contador" type="text" style="display: none;" value="contador">
            <button type="submit">Crear helado</button>
            <p><%out.print(mensaje);%></p>

            <div id="tarrina">
                <div id="chocolate"></div>
                <div id="fresa"></div>
                <div id="vainilla"></div>
            </div>
        </form>

    </body>
</html>

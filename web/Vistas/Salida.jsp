<%-- 
    Document   : Salida
    Created on : 18-dic-2016, 16:58:55
    Author     : pasito
--%>

<%@page import="Modelo.Reloj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilo.css" title="style" />
        
        <title>JSP Page</title>
    </head>
    <body>
        <h2>&nbsp;</h2>
        <form method="post" action="../ServletDispatcher" >
            <table width="350" border="1" align="center" id="tabla2">
                <tr>
                    <th colspan="2">Resultado
                    </th>
                </tr>
                <tr>
                    <td>Usuario: 
                    <%
                        Reloj r = (Reloj)session.getAttribute("reloj");
                        String s = (String)session.getAttribute("dni");
                        out.println(s);
                    %>
                     vota a 
                    </td>
                    <td>
                        <img src="data:image/jpeg;base64,<% out.println(r.getLogo()); %>" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="bot" type="submit" name="boton" id="desc" value="Volver al menu" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

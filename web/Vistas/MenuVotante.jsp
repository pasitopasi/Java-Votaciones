<%-- 
    Document   : MenuVotante
    Created on : 12-dic-2016, 22:59:37
    Author     : pasito
--%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Reloj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilo.css" title="style" />
        <style type="text/css">
        </style>
        <script type="text/javascript" src="../JavaScript/java.js">
        </script>
        <title>Menu</title>
    </head>
    <body>
        <h2>&nbsp;</h2>
        <h1>VOTA A LA MEJOR MARCA DE RELOJES</h1>
        <h2>&nbsp;</h2>
        <form method="post" action="../ServletDispatcher" onsubmit="return validar();">
            <table width="350" border="1" align="center" id="tabla2">
                <tr>
                    <th colspan="2">MARCA
                    </th>
                    <th>VOTAR
                    </th>
                </tr>
        <%
            ArrayList<Reloj> relojes = (ArrayList<Reloj>)session.getAttribute("ArrayRelojes");
            Iterator<Reloj> it = relojes.iterator();
            while(it.hasNext()){
                Reloj r = it.next();%>
                <tr>
                    <td>
                        <img src="data:image/jpeg;base64,<% out.println(r.getLogo()); %>" />
                    </td>
                    <td> 
                <% out.println(r.getMarca()); %>
                    </td>
                    <td>
                        <input type="radio" name="reloj" value="<% out.println(r.getId()); %>"/> Voto
                    </td>
                </tr>
                
                <%
            }
        %>
            
                <tr>
                    <th colspan="3">
                        <input class="bot" type="submit" name="boton" id="desc" value="Votar" />
                    </th>
                </tr>
            </table>
        </form>
        
        <form method="post" action="../ServletDispatcher">
            <div id="header">
                <ul class="nav">
                    <li><a href="">Usuario: 
                            <%
                                String s = (String)session.getAttribute("dni");
                                out.println(s);
                            %>
                        </a>
                        <ul>
                            <li><input class="bot" type="submit" name="boton" id="desc" value="Desconectar"/></li>
                            <li><input class="bot" type="submit" name="boton" id="desc" value="Borrar"/></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </form>
        <h2>&nbsp;</h2>
        <div id="padre"></div>
    </body>
</html>

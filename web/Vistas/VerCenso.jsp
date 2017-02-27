<%-- 
    Document   : VerCenso
    Created on : 16-dic-2016, 13:49:07
    Author     : pasito
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilo.css" title="style" />
        <style type="text/css">
        </style>
        <title>Censo</title>
    </head>
    <body>
        <h2>&nbsp;</h2>
        <form method="post" action="../ServletDispatcher" >
            <table width="350" border="1" align="center" id="tabla2">
                <tr>
                    <th></th>
                    <th>DNI</th>
                    <th>NOMBRE</th>
                    <th>APELLIDOS</th>
                    <th>VOTO</th>
                </tr>   
            <%
                ArrayList<Usuario> usuarios = (ArrayList<Usuario>)session.getAttribute("ArrayUser");
                Iterator<Usuario> it = usuarios.iterator();
                int i = 1;
                while(it.hasNext()){
                    Usuario user = it.next();
            %>
                    <tr>
                        <td><% out.println(i);i++; %>
                        </td>
                        <td><% out.println(user.getDni()); %>
                        </td>
                        <td><% out.println(user.getNombre()); %>
                        </td>
                        <td><% out.println(user.getApellido()); %>
                        </td>
                        <td><% out.println(user.getVoto()); %>
                        </td>
                    </tr>
            <%
                }
            %>
                    <tr>
                        <th colspan="5">
                            <input class="bot" type="submit" name="boton" id="desc" value="Volver al menu" />
                        </th>
                    </tr>
            </table>
        </form>
    </body>
</html>

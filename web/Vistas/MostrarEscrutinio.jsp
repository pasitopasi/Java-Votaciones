<%-- 
    Document   : MostrarCenso
    Created on : 15-dic-2016, 13:47:15
    Author     : pasito
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Reloj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilo.css" title="style" />
        <style type="text/css">
            p{
                color: black;
            }
        </style>
        <title>Ver escrutinio</title>
    </head>
    <body>
        
        <h2>&nbsp;</h2>
        <form method="post" action="../ServletDispatcher" >
             <table width="350" border="1" align="center" id="tabla2">
                <tr>
                    <th colspan="2">MARCA
                    </th>
                    <th>VOTOS
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
                        <p><% out.println(r.getVotos()); %> </p>
                    </td>
                </tr>
                
                <%
            }
        %>
            
                <tr>
                    <th colspan="3">
                        <input class="bot" type="submit" name="boton" id="desc" value="Volver al menu" />
                    </th>
                </tr>
            </table>
        </form>
        <h2>&nbsp;</h2>
        <p>ESCRUTINIO: 
            <%
                String esc = (String)session.getAttribute("escrutinio");
                if(esc.length()>5){
                    out.println(esc.substring(0, 5));
                }else
                    out.println(esc);//asi acortamos y no aparecen tantos
            %>
            %
        </p>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 06-dic-2016, 22:50:47
    Author     : pasito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/estilo.css" title="style" />
        <style type="text/css">
	</style>
        <title>Acceder</title>
    </head>
    <body>
        <h2>&nbsp;</h2>
        <h2>&nbsp;</h2>
        <form method="post" action="./ServletDispatcher">
            <table id="tabla1">
                <tr>
                    <td colspan="2" align="center"><h3><strong>Iniciar sesión</strong></h3></td>
                </tr>
                <tr>
                    <th>DNI</th>
                    <td><label><input name="dni" type="text" id="dni" /></label></td>
                </tr>
                <tr>
                    <th>Contraseña</th>
                    <td><label><input name="contrasena" type="password" id="contrasena" /></label></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <label><input type="submit" name="boton" id="Acceder" value="Acceder"/></label>
                        <label><a href="Vistas/AltaUsuario.jsp"><input type="button" name="boton" id="registrarU" value="Registrar"/></a></label>
                        <label><input type="submit" name="boton" id="verEscrutinio" value="Cierre del Escrutinio"/></label>
                        <label><input type="submit" name="boton" id="verCenso" value="Ver censo"/></label>
                    </td>
                </tr>
            </table>
        </form>
        <% 
                if(!session.isNew()){
                    String s = (String)session.getAttribute("mensaje");
                    if(s!=null){
                    %>
                    <h2>&nbsp;</h2>
                    <p><% out.println(s); %></p>
                    <%
                    }
                }
                session.invalidate();
            %>
    </body>
</html>

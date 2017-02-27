<%-- 
    Document   : AltaUsuario
    Created on : 07-dic-2016, 9:15:52
    Author     : pasito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
table{
    margin: 0 auto;
    width: 310px;
    background-color: white;
    font: normal 12px/150% Arial, Helvetica, sans-serif;
    background: #fff;
    overflow: hidden;
    border: 3px solid #00496B;
    border-radius: 20px;
}
table th{
    color: #00496B; 
    font-size: 15px;
    font-weight: normal;
}
strong{
   font-size: 20px;
}
p{  
    text-align: center;
    color: red;
}
	</style>
        <title>Alta usuario</title>
    </head>
    <body>
        <h2>&nbsp;</h2>
        <form method="post" action="../ServletDispatcher">
            <table>
                <tr>
                    <td colspan="2" align="center"><h3><strong>Darse de alta</strong></h3></td>
                </tr>
                <tr>
                    <th>DNI</th>
                    <td><label><input required="required" name="dni" type="text" id="dni" /></label></td>
                </tr>
                <tr>
                    <th>Nombre</th>
                    <td><label><input required="required" name="nombre" type="text" id="nombre" /></label></td>
                </tr>
                <tr>
                    <th>Apellido</th>
                    <td><label><input required="required" name="apellido" type="text" id="apellido" /></label></td>
                </tr>
                <tr>
                    <th>Contraseña</th>
                    <td><label><input required="required" name="contrasena" type="password" id="contrasena" /></label></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <label><input type="submit" name="boton" id="AltaU" value="Dar de Alta"/></label>
                        <label><a href="../index.jsp"><input type="button" name="CancelarA" id="CancelarA" value="Cancelar"/></a></label>
                    </td>
                </tr>
            </table>
        </form>
            <% 
                if(!session.isNew()){
                    String s = (String)session.getAttribute("men");
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

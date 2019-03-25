
<%@ page import= "conexion.ConexionBD" %>
<%@ page import= "java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Usuario</title>
    </head>
    <body>        

    </body>
</html> 

        <%
   
            String cedula = request.getParameter("cedula");

            ConexionBD conexion = new ConexionBD();
            conexion.conectar();

            conexion.eliminar(cedula);
            response.sendRedirect("Consulta.jsp");
            conexion.desconectar();


        %>











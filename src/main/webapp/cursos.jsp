<%-- 
    Document   : cursos
    Created on : Apr 4, 2026, 7:23:26 PM
    Author     : josue
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.CursoDAO"%>
<%@page import="modelo.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Cursos</title>
</head>
<body>

    <h2>Bienvenido</h2>
    <p>Login exitoso</p>

    <h3>Agregar curso</h3>
    <form action="CursoServlet" method="post">
        Nombre: <input type="text" name="nombre" required><br>
        Descripción: <input type="text" name="descripcion" required><br>
        <button type="submit">Guardar curso</button>
    </form>

    <h3>Lista de cursos</h3>

    <%
        CursoDAO dao = new CursoDAO();
        ArrayList<Curso> lista = dao.listarCursos();

        for (Curso c : lista) {
    %>
        <p>
            <b><%= c.getNombre() %></b> - <%= c.getDescripcion() %>
            <a href="CursoServlet?accion=eliminar&id=<%= c.getId() %>"> Eliminar</a>
        </p>
    <%
        }
    %>

</body>
</html>
<%-- 
    Document   : editarCurso
    Created on : Apr 6, 2026, 5:02:07 PM
    Author     : josue
--%>

<%@page import="modelo.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Curso curso = (Curso) request.getAttribute("curso");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Curso</title>
</head>
<body>

    <h2>Editar Curso</h2>

    <form action="CursoServlet" method="post">
        <input type="hidden" name="accion" value="actualizar">
        <input type="hidden" name="id" value="<%= curso.getId() %>">

        Nombre: <input type="text" name="nombre" value="<%= curso.getNombre() %>" required><br>
        Descripción: <input type="text" name="descripcion" value="<%= curso.getDescripcion() %>" required><br>

        <button type="submit">Actualizar curso</button>
    </form>

</body>
</html>

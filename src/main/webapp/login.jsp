<%-- 
    Document   : login
    Created on : Apr 4, 2026, 7:10:45 PM
    Author     : josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Login Edustream</h2>

<form action="LoginServlet" method="post">
    Correo:<input type="text" name="correo"><br>
    Password: <input type="password" name="password"><br>
    <button type="submit">Ingresar</button>
</form>

<%
String error = (String) request.getAttribute("error");
if(error != null){
%>
<p style="color:red;">Credenciales incorrectas</p>
<%
}
%>
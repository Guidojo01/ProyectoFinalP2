/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;
import dao.UsuarioDAO;
import modelo.Usuario;

import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author josue
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
    String correo = request.getParameter("correo");
    String password = request.getParameter("password");
     //System.out.println("Correo: " + correo);
     //System.out.println("Password: " + password);
    
    UsuarioDAO dao = new UsuarioDAO();
    Usuario user = dao.login(correo, password);
    
    if (user != null){
        System.out.println("Login Correcto");
    HttpSession session = request.getSession();
    session.setAttribute("usuario", user);
    response.sendRedirect("cursos.jsp");
    }else {
        //System.out.println("CREDENCIALES INCORRECTAS");

            request.setAttribute("error", "Credenciales incorrectas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
             // System.out.println("CREDENCIALES INCORRECTAS");
    
}
}
}

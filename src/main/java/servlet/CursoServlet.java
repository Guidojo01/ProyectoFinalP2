/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;
import dao.CursoDAO;
import modelo.Curso;
import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
/**
 *
 * @author josue
 */
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    String nombre = request.getParameter("nombre");
    String description = request.getParameter("descripcion");
    
    Curso curso = new Curso();
    curso.setNombre(nombre);
    curso.setDescricion(description);
    
    CursoDAO dao = new CursoDAO();
    dao.agregarCurso(curso);
    
    response.sendRedirect("cursos.jsp");
    }
}
    


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
    
        HttpSession session = request.getSession(false);
        
        if(session == null || session.getAttribute("usuario") == null){
        response.sendRedirect("login.jsp");
        return;
        }
    String accion = request.getParameter("accion");
   
    CursoDAO dao = new CursoDAO();
   
    if("guardar".equals(accion)){
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    
    Curso curso = new Curso();
    curso.setNombre(nombre);
    curso.setDescripcion(descripcion);
    
    dao.agregarCurso(curso);
    }else if ("actualizar".equals(accion)){
    int id = Integer.parseInt(request.getParameter("id"));
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    
    Curso curso = new Curso();
    curso.setId(id);
    curso.setNombre(nombre);
    curso.setDescripcion(descripcion);
    
    dao.actualizarCurso(curso);
    }
    
    response.sendRedirect("cursos.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        
        if(session == null || session.getAttribute("usuario") == null){
        response.sendRedirect("login.jsp");
        return;
        }
        
    String accion = request.getParameter("accion");
    CursoDAO dao = new CursoDAO();
    
    if("eliminar".equals(accion)){
    int id = Integer.parseInt(request.getParameter("id"));
    dao.eliminarCurso(id);
    response.sendRedirect("cursos.jsp");
    } else if ("editar".equals(accion)){
    int id = Integer.parseInt(request.getParameter("id"));
    Curso curso = dao.obtenerCurso(id);
    
    request.setAttribute("curso" , curso);
    request.getRequestDispatcher("editarCurso.jsp").forward(request, response);
    }
    }
    
}
    


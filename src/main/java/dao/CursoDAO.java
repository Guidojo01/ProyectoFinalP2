/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Curso;
import util.Conexion;
/**
 *
 * @author josue
 */
public class CursoDAO {
    
    public void agregarCurso(Curso curso){
    try{
        Connection conectar = Conexion.conectar();
        String sql = "INSERT INTO cursos(nombre, descripcion)VALUES(?,?)";
        PreparedStatement ps= conectar.prepareStatement(sql);
        ps.setString(1, curso.getNombre());
        ps.setString(2, curso.getDescripcion());
        ps.executeUpdate();
        
        System.out.println("Curso agregado con exito");
    
    }catch (Exception e){
    e.printStackTrace();
    }
    }
    public ArrayList<Curso> listarCursos(){
    ArrayList<Curso> lista = new ArrayList<>();
    
    try{
        Connection conectar = Conexion.conectar();
        String sql = "SELECT * FROM cursos";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
        while(rs.next()){
        Curso c = new Curso();
        c.setId(rs.getInt("id"));
        c.setNombre(rs.getString("Nombre"));
        c.setDescricion(rs.getString("descripcion"));
        lista.add(c);
        }
    
    }catch (Exception e){
    e.printStackTrace();
    }
    return lista;
    }
    public void eliminarCurso(int id){
    try{
    Connection conectar = Conexion.conectar();
    String sql = "DELETE FROM cursos WHERE id=?";
    PreparedStatement ps = conectar.prepareStatement(sql);
    ps.setInt(1, id);
    ps.executeUpdate();
    
    System.out.println("Curso eliminado con exito");
    
    }catch(Exception e){
    e.printStackTrace();
    }
    }
    public Curso obtenerCurso(int id){
    Curso c = null;
    
    try{
        Connection conectar = Conexion.conectar();
        String sql = "SELECT * FROM cursos WHERE id=?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
        c = new Curso();
        c.setId(rs.getInt("id"));
        c.setNombre(rs.getString("nombre"));
        c.setDescricion(rs.getString("descripcion"));
        }
    
    }catch (Exception e){
    e.printStackTrace();
    }
    return c;
    }
    public void actualizarCurso(Curso curso){
        try{
            Connection conectar = Conexion.conectar();
            String sql = "UPDATE cursos SET nombre=?, descripcion=? WHERE id=?";
            PreparedStatement ps= conectar.prepareStatement(sql);
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getId());
            ps.executeUpdate();
            
            System.out.println("Curso actualizado");
        
        }catch (Exception e){
        e.printStackTrace();
        }
       
    } 
}

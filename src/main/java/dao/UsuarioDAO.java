/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import modelo.Usuario;
import modelo.Profesor;
import modelo.Estudiante;
import util.Conexion;

/**
 *
 * @author josue
 */
public class UsuarioDAO {
    
    public void agregarUsuario(Usuario u) {
    try {
        Connection conectar = Conexion.conectar();
        String sql = "INSERT INTO usuarios(nombre, correo, password, tipo) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getCorreo());
        ps.setString(3, u.getPassword());
        ps.setString(4, u.getTipo());
        ps.executeUpdate();

        System.out.println("Usuario agregado correctamente");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public java.util.ArrayList<Usuario> listarUsuarios() {
    java.util.ArrayList<Usuario> lista = new java.util.ArrayList<>();

    try {
        Connection con = Conexion.conectar();
        String sql = "SELECT * FROM usuarios";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario u = null;
            String tipo = rs.getString("tipo");

            if (tipo.equalsIgnoreCase("estudiante")) {
                u = new Estudiante();
            } else if (tipo.equalsIgnoreCase("profesor")) {
                u = new Profesor();
            }

            if (u != null) {
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));
                lista.add(u);
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

public Usuario obtenerUsuarioPorId(int id) {
    Usuario u = null;

    try {
        Connection con = Conexion.conectar();
        String sql = "SELECT * FROM usuarios WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String tipo = rs.getString("tipo");

            if (tipo.equalsIgnoreCase("estudiante")) {
                u = new Estudiante();
            } else if (tipo.equalsIgnoreCase("profesor")) {
                u = new Profesor();
            }

            if (u != null) {
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return u;
}

public void actualizarUsuario(Usuario u) {
    try {
        Connection con = Conexion.conectar();
        String sql = "UPDATE usuarios SET nombre=?, correo=?, password=?, tipo=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getCorreo());
        ps.setString(3, u.getPassword());
        ps.setString(4, u.getTipo());
        ps.setInt(5, u.getId());

        int filas = ps.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void eliminarUsuario(int id) {
    try {
        Connection con = Conexion.conectar();
        String sql = "DELETE FROM usuarios WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Usuario eliminado correctamente");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public Usuario login(String correo, String password){
        
        Usuario u = null;
        System.out.println("Correo: " + correo);
        System.out.println("Password: " + password);
    try{
        Connection conectar= Conexion.conectar();
    
        String sql = "SELECT * FROM usuarios WHERE correo=?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, correo);

        ResultSet rs = ps.executeQuery();

if (rs.next()) {
    System.out.println(" CORREO EXISTE");

    String passBD = rs.getString("password"); 
    String tipo= rs.getString("tipo");
    System.out.println("Password BD: " + passBD);
    //System.out.println("Password ingresado: " + password);

    if (passBD.equals(password)) {
        System.out.println("LOGIN CORRECTO");
        
        
        if (tipo.equalsIgnoreCase("estudiante")){
        u = new Estudiante();
        } else if (tipo.equalsIgnoreCase("profesor")){
        u = new Profesor();
        }
        if (u != null) {
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setCorreo(rs.getString("correo"));
            u.setPassword(passBD);
        }
    
    } else {
        System.out.println("PASSWORD INCORRECTO");
    }

} else {
    System.out.println(" CORREO NO EXISTE");
}
        
    }catch (Exception e){
        e.printStackTrace();
        }
    return u;
    }
   
    
}
// prueba dao
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

    String passBD = rs.getString("password"); // o contraseña
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
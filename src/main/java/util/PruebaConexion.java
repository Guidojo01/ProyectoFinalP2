/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.*;
/**
 *
 * @author josue
 */
public class PruebaConexion {
    public static void main (String[] args){
    Connection conectar = Conexion.conectar();
    
    if (conectar != null){
    System.out.println("Conexion Exitosa");
    } else{
        System.out.println("Error de conexion");
    }
    }
    //Prueba commit 
    
}


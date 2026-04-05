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
public class Conexion {
   static String url = "jdbc:mysql://localhost:3306/edustream?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
   static String user= "root";
   static String pass= "1234";   

    
    public static Connection conectar()
    {
         Connection con= null;
         try 
         { 
             Class.forName("com.mysql.cj.jdbc.Driver");
         
         con=DriverManager.getConnection(url, user, pass);
              System.out.println("Conexion Exitosa");
         }catch(Exception e)
         {
         e.printStackTrace();
         System.out.println("Conexion fallida");
         }
         return con;
    }
}
    


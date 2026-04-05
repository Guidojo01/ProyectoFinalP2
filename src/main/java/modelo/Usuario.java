/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author josue
 */
public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String password;
    
   public Usuario(int id, String nombre, String correo, String password ){
       this.id = id;
       this.nombre = nombre;
       this.correo = correo;
       this.password = password;
   }
    public abstract String getTipo();
}

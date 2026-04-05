/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author josue
 */
public class Estudiante extends Usuario {
    
    public Estudiante(int id, String nombre, String correo, String password ){
    super(id, nombre, correo, password);
    }
    @Override
    public String getTipo(){
    return "estudiante";
    }
}

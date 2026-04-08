/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author josue
 */
public class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    
    public Curso(){
    
    }
    
   public Curso(int id, String nombre, String descripcion){
   this.id = id;
   this.nombre = nombre;
   this.descripcion = descripcion;
   }
   public int getId(){
     return id;
   }
   public String getNombre(){
   return nombre;
   }
   public String getDescripcion(){
   return descripcion;
   }
   public void setId(int id){
   this.id = id;
   }
   public void setNombre(String nombre){
   this.nombre = nombre;
}
   public void setDescripcion(String descripcion){
   this.descripcion = descripcion;
}
}

//Probando como se ve en la Web a la hora de agregar curso
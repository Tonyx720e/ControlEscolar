/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author tonym
 */
public class Carrera {
    private int id;
    private String nombre;
    
    //CONSTRUCTOR VACIO
    public Carrera(){
    
    }
    //CONSTRUCTO LLENO
    public Carrera(int id, String nombre){
    this.id = id;
    this.nombre = nombre;
    }
    
    //SETTER
    public void setId(int id){
        this.id = id;
    }
     public void setNombre(String nombre){
        this.nombre = nombre;
    }
     // GETTER
     public int getId(){
     return this.id;
     }
     public String getNombre(){
     return this.nombre;
     }
     
     // toString
    @Override
      public String toString() {
            return String.format("""
                                  el ID es:
                                  Carrera:
                                  """,
                         this.getId(),
                         this.getNombre());
        }
}

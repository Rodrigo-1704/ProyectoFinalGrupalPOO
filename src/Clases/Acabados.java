/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rod17
 */
public class Acabados {
    
    //atributos
    private String nombre;
    private String descripcion;
    private double precioAdicional;
    
    //constructor
    public Acabados(String nombre, String descripcion, double precioAdicional) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioAdicional = precioAdicional;
    }
    
    //get and set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioAdicional() {
        return precioAdicional;
    }

    public void setPrecioAdicional(double precioAdicional) {
        this.precioAdicional = precioAdicional;
    }
    
}

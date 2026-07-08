/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

 public class Gerente extends Empleado {
     private String area;
     private String bono;

     public Gerente (String dni, String nombres, String apellidos, String Usuario, String contrasena, String area, String bono) {
      super (dni, nombres, apellidos, usuario, contrasena, "Gerente");

      this.area = area;
      this.bono = bono;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    @Override
    public void realizarTrabajo() {
        System.out.println("El gerente supervisa las operaciones.");
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + "\nÁrea: " + area
                + "\nBono: S/ " + bono;
    }
}
 

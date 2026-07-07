/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

 public class Gerente extends Empleado {
     public Gerente(String dni, String nombres, String apellidos, String usuario, String contrasena) {
         super(dni, nombres, apellidos, usuario, contrasena, "Gerente"); 
 }
  @Override
  public void realizarTrabajo() {
      System.out.println("Revisando estadísticas...");
}
 

 @Override 
 public String mostrarInformacion() {
     return super.mostrarInformacion() +
         "\nFunción: Revisar estadísticas y reportes.";
 }
}
 

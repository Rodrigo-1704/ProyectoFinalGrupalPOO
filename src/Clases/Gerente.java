/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

 public class Gerente {
     public Gerente(String dni, String nombres, String apellidos, String usuario, String contrasena) {
         super(dni, nombres, apellidos, usuario, contrasena, "Gerente"); 
 }
  public String revisarEstadisticas(){
      return "El gerente está revisando las estadísticas del sistema.";
 }

 @Override 
 public String mostrarInformacion() {
     return super.mostrarInformacion() +
         "\nFunción: Revisar estadísticas y reportes.";
 }
}
 

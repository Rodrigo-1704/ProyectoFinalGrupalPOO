/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


public class AsesorVenta extends Empleados {

    public AsesorVenta(String dni, String nombres, String apellidos, String usuario, String contrasena) {
        super(dni, nombres, apellidos, usuario, contrasena, "Asesor de Venta");
    }
    public String atenderCliente() {
        return "El asesor de venta está atendiendo al cliente.";
    }
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
               "\nFunción: Atención comercial y registro de ventas.";
    }   
}

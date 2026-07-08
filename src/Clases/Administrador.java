/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Administrador extends Empleado {
    public Administrador(String dni, String nombres, String apellidos, String usuario, String contraseña){
        super(dni, nombres, apellidos, usuario, contraseña, "Administrador");
}
    @Override
    public void realizarTrabajo() {
        System.out.println("Gestionando el sistema...");
}
    public String gestionarUsuarios() {
        return "El administrador puede registrar, modificar y eliminar usuarios.";
}

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nFunción: Gestionar usuarios, clientes, reservas y ventas.";
 }

}

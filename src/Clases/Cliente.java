/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Cliente {

    private String dni;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String estadoCivil;
    private String ocupacion;
    private double ingresos;
    private String telefono;
    private String correo;

    public Cliente(String dni, String nombres, String apellidos, String fechaNacimiento,
                   String estadoCivil, String ocupacion, double ingresos, String telefono, String correo) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.ocupacion = ocupacion;
        this.ingresos = ingresos;
        this.telefono = telefono;
        this.correo = correo;
}
     public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getIngresos() {
        return ingresos;
    }
    public String mostrarInformacion() {
        return "DNI : " + dni +
               "\nCliente: " + nombres + " " + apellidos +
               "\nFecha de nacimiento : " + fechaNacimiento +
               "\nEstado civil: " + estadoCivil +
               "\nOcupación : " + ocupacion +
               "\nIngresos: S/ " + ingresos +
                "\nTeléfono: " + telefono +
                "\nCorreo: " + correo;
    }
}


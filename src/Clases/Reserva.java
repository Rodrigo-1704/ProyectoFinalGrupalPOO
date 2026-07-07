/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Reserva {
    private Cliente cliente;
    private Departamento departamento;
    private double montoPagado;
    private String fechaVigencia;
    
    public Reserva(Cliente cliente, Departamento departamento, double montoPagado, String fechaVigencia) {
        this.cliente = cliente;
        this.departamento = departamento;
        this.montoPagado = montoPagado;
        this.fechaVigencia = fechaVigencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public String mostrarReserva() {
        return "RESERVA DE DEPARTAMENTO" +
                "\nCliente: " + cliente.getNombres() + " " + cliente.getApellidos() +
                "\nDepartamento: " + departamento.getNumDepa() +
                "\nMonto pagado: S/ " + montoPagado +
                "\nFecha de vigencia: " + fechaVigencia;
    }
}

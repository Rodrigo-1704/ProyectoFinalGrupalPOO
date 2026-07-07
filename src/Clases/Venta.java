/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Venta {
    private Cliente cliente;
    private Departamento departamento;
    private String modalidadPago;
    private String fechaVenta;
    private int cantidadCuotas;
   
    public Venta(Cliente cliente, Departamento departamento, String modalidadPago,
                 String fechaVenta, int cantidadCuotas) {
        this.cliente = cliente;
        this.departamento = departamento;
        this.modalidadPago = modalidadPago;
        this.fechaVenta = fechaVenta;
        this.cantidadCuotas = cantidadCuotas;
    }

    public double calcularMontoCuota() {
        if (modalidadPago.equalsIgnoreCase("Cuotas Directas") && cantidadCuotas > 0) {
            return departamento.getPrecioVenta() / cantidadCuotas;
        }
        return 0;   
    }
    public String generarCronogramaCuotas () {
        String texto = "";

        if (modalidadPago.equalsIgnoreCase("Cuotas Directas")) {
            double cuota = calcularMontoCuota();

            for (int i = 1; i <= cantidadCuotas; i++) {
                texto += "Cuota : " + i + "S/." + cuota + "\n";
            }
        } else {
            texto = "Pago al contado. No hay cuotas.";
        }
        return texto;
    }
    public String generarContrato() {
        return "CONTRATO DE COMPRA-VENTA" +
                "\n\nCliente: " + cliente.getNombres() + " " + cliente.getApellidos() +
                "\nDNI: " + cliente.getDni() +
                "\nDepartamento: " + departamento.getNumDepa() +
                "\nUbicación: " + departamento.getUbicacion() +
                "\nPrecio total: S/ " + departamento.getPrecioVenta() +
                "\nModalidad de pago: " + modalidadPago +
                "\nFecha de venta: " + fechaVenta +
                "\nCRONOGRAMA DE PAGO:" +
                "\n" + generarCronogramaCuotas() +
                "\nEl comprador acepta las condiciones establecidas en el presente contrato.";
    }
    
}
    

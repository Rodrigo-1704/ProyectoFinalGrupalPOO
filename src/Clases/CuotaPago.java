/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author LUCAS
 */
public class CuotaPago {
    private int numeroCuota;
    private double montoCuota;
    private String fechaVencimiento;
    private double montoPagado;

    
    public CuotaPago(int numeroCuota, double montoCuota, String fechaVencimiento) {
        this.numeroCuota = numeroCuota;
        this.montoCuota = montoCuota;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPagado = 0;
    }
    
    public boolean registrarPago(double monto) {
        if (monto <= 0) {
            return false;
        }

        if (monto > getSaldoCuota()) {
            return false;
        }

        montoPagado += monto;
        return true;
    }

    public double getSaldoCuota() {
        return montoCuota - montoPagado;
    }
    
    public boolean estaPagada() {
        return getSaldoCuota() == 0;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public double getMontoCuota() {
        return montoCuota;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public void setMontoCuota(double montoCuota) {
        this.montoCuota = montoCuota;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }
    
}

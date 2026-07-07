/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rod17
 */
public class Departamento {
    
    //atributos
    private String codigoUnico;
    private int numPiso;
    private int numDepa;
    private double areaM2;
    private int numDormitorios;
    private int numBanos;
    private String tipo;
    private double precioVenta;
    private String estado;
    private Acabados[] acabados;
    private int contadorAcabados;
    private String ubicacion;
    
    //constructor
    public Departamento(String codigoUnico, int numPiso, int numDepa, double areaM2, int numDormitorios, int numBanos, String tipo, double precioVenta, String estado, Acabados[] acabados, int contadorAcabados, String ubicacion) {
        this.codigoUnico = codigoUnico;
        this.numPiso = numPiso;
        this.numDepa = numDepa;
        this.areaM2 = areaM2;
        this.numDormitorios = numDormitorios;
        this.numBanos = numBanos;
        this.tipo = tipo;
        this.precioVenta = precioVenta;
        this.estado = "Disponible";
        this.acabados = new Acabados[10];
        this.contadorAcabados = contadorAcabados;
        this.ubicacion = ubicacion;
    }
    
    //get and set
    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public int getNumPiso() {
        return numPiso;
    }

    public void setNumPiso(int numPiso) {
        this.numPiso = numPiso;
    }

    public int getNumDepa() {
        return numDepa;
    }

    public void setNumDepa(int numDepa) {
        this.numDepa = numDepa;
    }

    public double getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(double areaM2) {
        this.areaM2 = areaM2;
    }

    public int getNumDormitorios() {
        return numDormitorios;
    }

    public void setNumDormitorios(int numDormitorios) {
        this.numDormitorios = numDormitorios;
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Acabados[] getAcabados() {
        return acabados;
    }

    public void setAcabados(Acabados[] acabados) {
        this.acabados = acabados;
    }

    public int getContadorAcabados() {
        return contadorAcabados;
    }

    public void setContadorAcabados(int contadorAcabados) {
        this.contadorAcabados = contadorAcabados;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    //metodos
    public void agregarAcabado(Acabados nuevoAcabado) {
        if (contadorAcabados < acabados.length) {
            acabados[contadorAcabados] = nuevoAcabado;
            contadorAcabados++;
            return;
        }
        return;
    }
    
    public double calcularPrecioFinal() {
        double precioTotal = this.precioVenta;
        for (int i = 0; i < contadorAcabados; i++) {
            precioTotal += acabados[i].getPrecioAdicional();
        }
        return precioTotal;
    }
    
}

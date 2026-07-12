/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rod17
 */
public class Proyecto implements Reportable{
    
    //atributos
    private String nombreProyecto;
    private String direccion;
    private String distrito;
    private int numeroPisos;
    private String fechaInicioObra;
    private String fechaEstimadaEntrega;
    private String estadoProyecto; 
    private Departamento[] departamentos;
    private int contadorDepartamentos;

    //constructor
    public Proyecto(String nombreProyecto, String direccion, String distrito, int numeroPisos, String fechaInicioObra, String fechaEstimadaEntrega, String estadoProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.direccion = direccion;
        this.distrito = distrito;
        this.numeroPisos = numeroPisos;
        this.fechaInicioObra = fechaInicioObra;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.estadoProyecto = estadoProyecto;
        this.departamentos = new Departamento[100]; 
        this.contadorDepartamentos = 0;
    }
    
    //get and set
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public String getFechaInicioObra() {
        return fechaInicioObra;
    }

    public void setFechaInicioObra(String fechaInicioObra) {
        this.fechaInicioObra = fechaInicioObra;
    }

    public String getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(String fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public Departamento[] getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamento[] departamentos) {
        this.departamentos = departamentos;
    }

    public int getContadorDepartamentos() {
        return contadorDepartamentos;
    }

    public void setContadorDepartamentos(int contadorDepartamentos) {
        this.contadorDepartamentos = contadorDepartamentos;
    }
    

    //metodos
    public void registrarDepartamento(Departamento depa) {
        if (contadorDepartamentos < departamentos.length) {
            departamentos[contadorDepartamentos] = depa;
            contadorDepartamentos++;
            return;
        }
        return;
    }

    public double calcularPorcentajeVentas() {
        if (contadorDepartamentos == 0) return 0.0;
        int vendidos = 0;
        for (int i = 0; i < contadorDepartamentos; i++) {
            if (departamentos[i].getEstado().equalsIgnoreCase("Vendido")) {
                vendidos++;
            }
        }
        return ((double) vendidos / contadorDepartamentos) * 100.0;
    }

    @Override
    public String generarReporte() {
     int disponibles = 0;
     int reservados = 0;
     int vendidos = 0;
    for (int i = 0; i < contadorDepartamentos; i++) {
        String est = departamentos[i].getEstado();
        if (est.equalsIgnoreCase("Disponible")) disponibles++;
        else if (est.equalsIgnoreCase("Reservado")) reservados++;
        else if (est.equalsIgnoreCase("Vendido")) vendidos++;
    }
    return "Reporte del Proyecto: " + nombreProyecto +
           "\nDisponibles: " + disponibles +
           "\nReservados: " + reservados +
           "\nVendidos: " + vendidos +
           "\n% Ventas: " + calcularPorcentajeVentas() + "%";
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rosan
 */
public class AlmacenDatos {
    
    //atributos
    private Empleados[] empleados;
    private Proyecto[] proyectos;
    private Cliente[] clientes;
    private Reserva[] reservas;
    private Venta[] ventas;
    private int contEmpleados;
    private int contProyectos;
    private int contClientes;
    private int contReservas;
    private int contVentas;
    
    //constructor
    public AlmacenDatos() {
        this.empleados = new Empleados[50]; 
        this.proyectos = new Proyecto[20];
        this.clientes = new Cliente[200];
        this.reservas = new Reserva[200];
        this.ventas = new Venta[200];
        this.contEmpleados = 0;
        this.contProyectos = 0;
        this.contClientes = 0;
        this.contReservas = 0;
        this.contVentas = 0;
    }
    
    //get and set
    public Empleados[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados[] empleados) {
        this.empleados = empleados;
    }

    public Proyecto[] getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyecto[] proyectos) {
        this.proyectos = proyectos;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public void setVentas(Venta[] ventas) {
        this.ventas = ventas;
    }

    public int getContEmpleados() {
        return contEmpleados;
    }

    public void setContEmpleados(int contEmpleados) {
        this.contEmpleados = contEmpleados;
    }

    public int getContProyectos() {
        return contProyectos;
    }

    public void setContProyectos(int contProyectos) {
        this.contProyectos = contProyectos;
    }

    public int getContClientes() {
        return contClientes;
    }

    public void setContClientes(int contClientes) {
        this.contClientes = contClientes;
    }

    public int getContReservas() {
        return contReservas;
    }

    public void setContReservas(int contReservas) {
        this.contReservas = contReservas;
    }

    public int getContVentas() {
        return contVentas;
    }

    public void setContVentas(int contVentas) {
        this.contVentas = contVentas;
    }
    
    
    //metodos
    public void agregarEmpleado(Empleados emp) {
        if (contEmpleados < empleados.length) {
            empleados[contEmpleados] = emp;
            contEmpleados++;
            return;
        }
        return;
    }

    public void agregarProyecto(Proyecto proy) {
        if (contProyectos < proyectos.length) {
            proyectos[contProyectos] = proy;
            contProyectos++;
            return;
        }
        return;
    }

    public Proyecto buscarProyecto(String nombre) {
        for (int i = 0; i < contProyectos; i++) {
            if (proyectos[i].getNombreProyecto().equalsIgnoreCase(nombre)) {
                return proyectos[i];
            }
        }
        return null;
    }
    
    public Empleados verificarLogin(String user, String pass) {
        for (int i = 0; i < contEmpleados; i++) {
            if (empleados[i].getUsuario().equals(user) && empleados[i].getContrasena().equals(pass)) {
                return empleados[i]; // Aplica polimorfismo retornando el rol específico
            }
        }
        return null;
    }
    
    public String Reporte(String nombreProy) {
        Proyecto p = buscarProyecto(nombreProy);
        if (p == null) return "Proyecto no encontrado.";
        
        int disponibles = 0, reservados = 0, vendidos = 0;
        Departamento[] depas = p.getDepartamentos();
        
        for (int i = 0; i < p.getContadorDepartamentos(); i++) {
            if (depas[i].getEstado().equalsIgnoreCase("Disponible")) {
                disponibles++;
            }else if (depas[i].getEstado().equalsIgnoreCase("Reservado")) {
                reservados++;
            }else if (depas[i].getEstado().equalsIgnoreCase("Vendido")) {
                vendidos++;
            }
        }
        
        return "Reporte del Proyecto: " + nombreProy + "\n" +
               "-----------------------------------\n" +
               "Disponibles: " + disponibles + "\n" +
               "Reservados: " + reservados + "\n" +
               "Vendidos: " + vendidos;
    }
}

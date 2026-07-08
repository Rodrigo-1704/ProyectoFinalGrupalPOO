
package Clases;

public class Reserva {
    private Cliente cliente;
    private Departamento departamento;
    private double montoPagado;
    private String fechaVigencia;
    private boolean vigente;

    public Reserva(Cliente cliente, Departamento departamento, double montoPagado, String fechaVigencia, boolean vigente) {
        this.cliente = cliente;
        this.departamento = departamento;
        this.montoPagado = montoPagado;
        this.fechaVigencia = fechaVigencia;
        this.vigente = false;
        
    }
    public boolean registrarReserva() {
        if (departamento.getEstado().equalsIgnoreCase("Disponible")) {
            departamento.setEstado("Reservado");
            vigente = true;
            return true;
        }
        return false;
    }
    public String mostrarReserva() {
        return "\nDepartamento: " +
                "RESERVA" +
                "\nCliente: " + cliente.getNombres() + " " + cliente.getApellidos() + departamento.getNumDepa() +
                "\nMonto separación: S/ " + montoPagado +
                "\nFecha vigencia: " + fechaVigencia +
                "\nVigente: " + vigente +
                "\nEstado departamento: " + departamento.getEstado();
                                    
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

    public boolean isVigente() {
        return vigente;
    }
}
                                                

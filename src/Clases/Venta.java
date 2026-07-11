
package Clases;

import Clases.AsesorVenta;
import Clases.Cliente;
import Clases.Departamento;
import Clases.Reserva;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Venta {
    private Reserva reserva;
    private Cliente cliente;
    private Departamento departamento;
    private AsesorVenta asesor;
    private String modalidadPago;
    private String fechaVenta;
    private double cuotaInicial;
    private int numeroCuotas;
    private double montoPagado;
    private CuotaPago[] cronogramaPagos;

    public Venta(Reserva reserva, AsesorVenta asesor, String modalidadPago, String fechaVenta, double cuotaInicial, int numeroCuotas) {
        this.reserva = reserva;
        this.cliente = reserva.getCliente();
        this.departamento = reserva.getDepartamento();
        this.asesor = asesor;
        this.modalidadPago = modalidadPago;
        this.fechaVenta = fechaVenta;
        this.cuotaInicial = cuotaInicial;
        this.numeroCuotas = numeroCuotas;
        this.montoPagado = cuotaInicial;
        generarCronogramaPagos();
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public AsesorVenta getAsesor() {
        return asesor;
    }

    public void setAsesor(AsesorVenta asesor) {
        this.asesor = asesor;
    }

    public String getModalidadPago() {
        return modalidadPago;
    }

    public void setModalidadPago(String modalidadPago) {
        this.modalidadPago = modalidadPago;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getCuotaInicial() {
        return cuotaInicial;
    }

    public void setCuotaInicial(double cuotaInicial) {
        this.cuotaInicial = cuotaInicial;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }
    
    
    public boolean registrarVenta() {
        if (reserva.isVigente()
                && departamento.getEstado().equalsIgnoreCase("Reservado")) {
            departamento.setEstado("Vendido");
            return true;
        }
        return false;
    }
    
    public double calcularMontoCuota() {
        if (modalidadPago.equalsIgnoreCase("Cuotas Directas")&& numeroCuotas > 0){
            double saldo = departamento.calcularPrecioFinal() - cuotaInicial;
            return saldo / numeroCuotas;
        }
        return 0;
    }
    
    public CuotaPago[] getCronogramaPagos() {
        return cronogramaPagos;
    }
    
    private void generarCronogramaPagos() {
        if (!modalidadPago.equalsIgnoreCase("Cuotas Directas") || numeroCuotas <= 0) {
            cronogramaPagos = new CuotaPago[0];
            return;
        }

        cronogramaPagos = new CuotaPago[numeroCuotas];

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);

            Date fecha = formato.parse(fechaVenta);
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fecha);

            double montoCuota = calcularMontoCuota();

            for (int i = 0; i < numeroCuotas; i++) {
                calendario.add(Calendar.MONTH, 1);
                cronogramaPagos[i] = new CuotaPago(i + 1,montoCuota,formato.format(calendario.getTime()));
            }

        } catch (Exception e) {
            cronogramaPagos = new CuotaPago[0];
        }
    }
    
    public boolean registrarPagoParcial(int numeroCuota, double monto) {
        if (!modalidadPago.equalsIgnoreCase("Cuotas Directas")) {
            return false;
        }

        if (cronogramaPagos == null || numeroCuota <= 0 || numeroCuota > cronogramaPagos.length) {
            return false;
        }

        CuotaPago cuota = cronogramaPagos[numeroCuota - 1];

        boolean registrado = cuota.registrarPago(monto);

        if (registrado) {
            montoPagado += monto;
        }

        return registrado;
    }
    
    public double calcularSaldoPendiente() {
        double saldo = departamento.calcularPrecioFinal() - montoPagado;

        if (saldo < 0) {
            return 0;
        }

        return saldo;
    }
    
     public String generarCronogramaCuotas() {
        if (!modalidadPago.equalsIgnoreCase("Cuotas Directas")) {
            return "No hay cronograma de cuotas directas.\n";
        }

        if (cronogramaPagos == null || cronogramaPagos.length == 0) {
            return "No se pudo generar el cronograma. Verifique la fecha de venta.\n";
        }

        String cronograma = "";

        for (CuotaPago cuota : cronogramaPagos) {
            cronograma += "Cuota " + cuota.getNumeroCuota()
                    + " | Monto: S/ " + String.format("%.2f", cuota.getMontoCuota())
                    + " | Pagado: S/ " + String.format("%.2f", cuota.getMontoPagado())
                    + " | Saldo cuota: S/ " + String.format("%.2f", cuota.getSaldoCuota())
                    + " | Vence: " + cuota.getFechaVencimiento()
                    + "\n";
        }

        return cronograma;
    }
    

    public String generarContrato() {
        return "========== CONTRATO DE COMPRA-VENTA ==========" +
                "\nCliente: " + cliente.getNombres() + " " + cliente.getApellidos() +
                "\nDNI: " + cliente.getDni() +
                "\nDepartamento: " + departamento.getNumDepa() +
                "\nPiso: " + departamento.getNumPiso() +
                "\nTipo: " + departamento.getTipo() +
                "\nÁrea: " + departamento.getAreaM2() + " m2" +
                "\nPrecio base: S/ " + departamento.getPrecioVenta() +
                "\nPrecio final con acabados: S/ " + departamento.calcularPrecioFinal() +
                "\nModalidad de pago: " + modalidadPago +
                "\nFecha de venta: " + fechaVenta +
                "\nAsesor: " + asesor.getNombres() + " " + asesor.getApellidos() +
                "\n\nCRONOGRAMA:\n" + generarCronogramaCuotas() +
                "\nSaldo pendiente: S/ " + String.format("%.2f", calcularSaldoPendiente());
    }

    public void mostrarVenta() {
        System.out.println(generarContrato());
    }
}

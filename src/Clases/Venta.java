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

    public Venta(Reserva reserva, Cliente cliente, Departamento departamento, AsesorVenta asesor, String modalidadPago, String fechaVenta, double cuotaInicial, int numeroCuotas, double montoPagado) {
        this.reserva = reserva;
        this.cliente = reserva.getCliente();
        this.departamento = reserva.getDepartamento();
        this.asesor = asesor;
        this.modalidadPago = modalidadPago;
        this.fechaVenta = fechaVenta;
        this.cuotaInicial = cuotaInicial;
        this.numeroCuotas = numeroCuotas;
        this.montoPagado = cuotaInicial;
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
            double saldo = departamento.getPrecioVenta() - cuotaInicial;
            return saldo / numeroCuotas;
        }
        return 0;
    }
    
    public void registrarPagoParcial(double monto) {
        if (monto > 0) {
            montoPagado += monto;
        }
    }
    public double calcularSaldoPendiente() {
        return departamento.getPrecioVenta() - montoPagado;
    }
     public String generarCronogramaCuotas() {
        if (!modalidadPago.equalsIgnoreCase("Cuotas Directas")) {
            return "No hay cronograma de cuotas directas.\n";
        }String cronograma = "";
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formato.parse(fechaVenta);
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fecha);

            double cuota = calcularMontoCuota();

            for (int i = 1; i <= numeroCuotas; i++) {
                calendario.add(Calendar.MONTH, 1);

                cronograma += "Cuota " + i +
                        " | Monto: S/ " + String.format("%.2f", cuota) +
                        " | Vence: " + formato.format(calendario.getTime()) +
                        "\n";
            }
        } catch (Exception e) {
            cronograma = "Error al calcular fechas de vencimiento.\n";
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
                "\nPrecio total: S/ " + departamento.getPrecioVenta() +
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

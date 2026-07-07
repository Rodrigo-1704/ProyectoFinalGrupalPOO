import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
package Clases;

public class Venta {
    private Cliente cliente;
    private Departamento departamento;
    private String modalidadPago;
    private String fechaVenta;
    private int cantidadCuotas;
   
    public Venta(Cliente cliente, Departamento departamento, String modalidadPago,String fechaVenta, int cantidadCuotas) {
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
 public String generarCronogramaCuotas() {
        if (!modalidadPago.equalsIgnoreCase("Cuotas Directas")) {
            return "Pago al contado o crédito bancario.\n";
        }
        String cronograma = "";
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formato.parse(fechaVenta);
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fecha);
            double cuota = calcularMontoCuota();
            for (int i = 1; i <= cantidadCuotas; i++) {
                calendario.add(Calendar.MONTH, 1);
                cronograma += "Cuota " + i
                        + " | Monto: S/ "
                        + String.format("%.2f", cuota)
                        + " | Fecha de vencimiento: "
                        + formato.format(calendario.getTime())
                        + "\n";
            }
        } catch (Exception e) {
            cronograma = "Error al calcular las fechas.";
        }
        return cronograma;
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
        return contrato;
    }
     public void mostrarVenta() {
        System.out.println(generarContrato());

    
}
    

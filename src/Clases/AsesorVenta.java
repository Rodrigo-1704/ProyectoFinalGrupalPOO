package Clases;


public class AsesorVenta extends Empleado {

    public AsesorVenta(String dni, String nombres, String apellidos, String usuario, String contrasena) {
        super(dni, nombres, apellidos, usuario, contrasena, "Asesor de Venta");
    }
   @Override
    public String obtenerPermisos() {
        return "Gestiona clientes, reservas, ventas y pagos.";
    }
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nPermisos: " + obtenerPermisos();
    } 
}

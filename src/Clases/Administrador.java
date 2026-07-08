
package Clases;

public class Administrador extends Empleado {

    public Administrador(String dni, String nombres, String apellidos, String usuario, String contrasena) {
        super(dni, nombres, apellidos, usuario, contrasena, "Administrador");
    }
    @Override
    public String obtenerPermisos(){
        return "Gestiona empleados, proyectos y acabados.";
        
    }
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nPermisos: " + obtenerPermisos();
    }
}

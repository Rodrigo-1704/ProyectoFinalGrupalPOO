package Clases;

public class Gerente extends Empleado {
     private String area;
     private double bono;

    public Gerente(String area, double bono, String dni, String nombres, String apellidos, String usuario, String contrasena, String rol) {
        super(dni, nombres, apellidos, usuario, contrasena, rol);
        this.area = area;
        this.bono = bono;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

     @Override
    public String obtenerPermisos() {
        return "Accede solo a reportes y estadísticas.";
    }
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nPermisos: " + obtenerPermisos();
    }
}

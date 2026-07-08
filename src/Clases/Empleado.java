
package Clases;


public abstract class Empleado {
    protected String dni;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contrasena;
    protected String rol;
   
    public Empleado(String dni, String nombres, String apellidos, String usuario, String contrasena, String rol) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    
    public boolean login(String usuario, String contrasena){
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }
    public abstract String obtenerPermisos ();
    
    
    public String mostrarInformacion() {
        return "DNI: " + dni +
                "\nNombres: " + nombres +
                "\nApellidos: " + apellidos +
                "\nUsuario: " + usuario +
                "\nRol: " + rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
         
}

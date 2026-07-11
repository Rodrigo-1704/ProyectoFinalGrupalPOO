/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaz.Interfaz_Login;

/**
 *
 * @author rosan
 */

public class Main {
    
    public static void main(String[] args) {
        // 1. Instanciamos el almacén global en memoria RAM
        AlmacenDatos ad = new AlmacenDatos();
        Interfaz_Login login = new Interfaz_Login(ad);
        login.setVisible(true);

        //Administrador
        Administrador adminBase = new Administrador("11111111", "Carlos", "Mendoza", "admin", "1234");
        ad.agregarEmpleado(adminBase);
        
        //Asesor de Venta
        AsesorVenta ases = new AsesorVenta("22222222", "Ana", "Gomez", "Ventas", "4321");
        ad.agregarEmpleado(ases);
        
        //Gerente
        Gerente geren = new Gerente("Ventas", 1500.0, "33333333", "Luis", "Ramos","gerente","2468","Gerente");
        ad.agregarEmpleado(geren);


        //Proyecto
        Proyecto proyectoBase = new Proyecto("Torre El Sol", "Av. Javier Prado 1024", "Santiago de Surco", 12, "01/08/2026", "20/12/2027", "En planos");
        
        proyectoBase.registrarDepartamento(new Departamento("DEP-101", 1, 101, 75.5, 2, 2, "Flat", 280000.00, "Vista a la calle"));
        proyectoBase.registrarDepartamento(new Departamento("DEP-1201", 12, 1201, 150.0, 3, 4, "Penthouse", 650000.00, "Piso 12 - Terraza"));
        
        ad.agregarProyecto(proyectoBase);

        
        System.out.println("=============================================");
        System.out.println("=== MOTOR INMOBILIARIO INICIALIZADO EN RAM ===");
        System.out.println("=============================================");
        System.out.println("Administrador cargado: " + adminBase.getNombres() + " " + adminBase.getApellidos());
        System.out.println("Proyecto en catálogo: " + ad.getProyectos()[0].getNombreProyecto() + " (" + ad.getProyectos()[0].getDistrito() + ")");
        
        
        boolean loginCorrecto = (ad.verificarLogin("admin", "1234") != null);
        System.out.println("Verificación de Login Base ('admin'/'1234'): " + (loginCorrecto ? "OPERATIVO" : "ERROR"));
        System.out.println("=============================================");
        

    }
}

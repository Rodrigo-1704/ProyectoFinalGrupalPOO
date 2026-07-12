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
       // Interfaz_Login login = new Interfaz_Login(ad);
        //login.setVisible(true);
        
        //Administrador
        Administrador admin1 = new Administrador("11111111", "Carlos", "Quispe", "cquispe", "1234");
        Administrador admin2 = new Administrador("22222222", "María", "Paredes", "mparedes", "5678");
        ad.agregarEmpleado(admin1);
        ad.agregarEmpleado(admin2);
        
        //Asesor de Venta
        AsesorVenta asesor1 = new AsesorVenta("22222222", "Ana", "Gomez", "agomez", "4321");
        AsesorVenta asesor2 = new AsesorVenta("33333333", "Luis", "Torres", "ltorres", "8765");

        ad.agregarEmpleado(asesor1);
        ad.agregarEmpleado(asesor2);
        
        //Gerente
        Gerente gerente1 = new Gerente("Ventas", 1500.0, "33333333", "Luis", "Ramos","lramos","2468","Gerente");
        Gerente gerente2 = new Gerente("Ventas", 3070.0, "4444444", "Lucia", "Perez","lperez","1357","Gerente");
        ad.agregarEmpleado(gerente1);
        ad.agregarEmpleado(gerente2);


        //Proyecto y departamentos
        Proyecto p1 = new Proyecto("Torre El Sol", "Av. Javier Prado 1024", "Santiago de Surco", 12, "01/08/2026", "20/12/2027", "En planos");
        Proyecto p2 = new Proyecto("Torres del Sol", "Jr. Las Flores 789", "San Borja", 15, "10/06/2024", "10/06/2026", "Terminado");
        Proyecto p3 = new Proyecto("Parque Central", "Av. Central 321", "San Isidro", 12, "05/02/2025", "05/02/2027", "En construcción");
        Proyecto p4 = new Proyecto("Bosque Real", "Calle Los Pinos 654", "La Molina", 6, "20/09/2024", "20/09/2025", "Entregado");
        Proyecto p5 = new Proyecto("Vista Mar", "Av. Costanera 456", "Barranco", 8, "15/03/2025", "15/03/2027", "En planos");
        
        ad.agregarProyecto(p1);
        ad.agregarProyecto(p2);
        ad.agregarProyecto(p3);
        ad.agregarProyecto(p4);
        ad.agregarProyecto(p5);
        
        //Departamentos
        Departamento d11 = new Departamento("TE-101", 1, 101, 75.5, 2, 2, "Flat", 250000, "Piso 1, vista al parque");
        Departamento d12 = new Departamento("TE-102", 1, 102, 70.0, 2, 1, "Flat", 230000, "Piso 1, interior");
        Departamento d21 = new Departamento("TS-201", 2, 201, 90.0, 3, 2, "Dúplex", 320000, "Piso 2, vista al mar");
        Departamento d22 = new Departamento("TS-202", 2, 202, 95.0, 3, 2, "Dúplex", 330000, "Piso 2, interior");
        Departamento d31 = new Departamento("PC-301", 3, 301, 180.0, 4, 3, "Penthouse", 550000, "Piso 3, terraza");
        Departamento d32 = new Departamento("PC-302", 3, 302, 85.0, 2, 2, "Flat", 300000, "Piso 3, vista ciudad");
        Departamento d41 = new Departamento("BR-401", 4, 401, 110.0, 3, 2, "Dúplex", 280000, "Piso 4, vista al bosque");
        Departamento d42 = new Departamento("BR-402", 4, 402, 65.0, 1, 1, "Flat", 190000, "Piso 4, interior");
        Departamento d51 = new Departamento("VM-501", 5, 501, 100.0, 3, 2, "Dúplex", 310000, "Piso 5, vista al mar");
        Departamento d52 = new Departamento("VM-502", 5, 502, 60.0, 1, 1, "Flat", 175000, "Piso 5, interior");
         
        p1.registrarDepartamento(d11);
        p2.registrarDepartamento(d12);
        p3.registrarDepartamento(d21);
        p4.registrarDepartamento(d22);
        p5.registrarDepartamento(d31);
        p1.registrarDepartamento(d32);
        p2.registrarDepartamento(d41);
        p3.registrarDepartamento(d42);
        p4.registrarDepartamento(d51);
        p5.registrarDepartamento(d52);

        //Acabados
        d11.agregarAcabado(new Acabados("Piso laminado", "Piso laminado color roble", 3500));
        d11.agregarAcabado(new Acabados("Cocina equipada", "Cocina con muebles altos y bajos", 8000));
        d12.agregarAcabado(new Acabados("Pintura premium", "Pintura lavable de alta calidad", 2000));
        d21.agregarAcabado(new Acabados("Closets a medida", "Closets en dormitorios principales", 4500));
        d31.agregarAcabado(new Acabados("Grifería importada", "Grifería de baño y cocina importada", 1800));
        d32.agregarAcabado(new Acabados("Piso porcelanato", "Porcelanato rectificado 60x60", 5200));

        //Clientes
        Cliente c1 = new Cliente("4011111", "Pedro", "Ramírez", "12/05/1985", "Casado", "Ingeniero", 6500, "987111111", "pramirez@mail.com");
        Cliente c2 = new Cliente("4022222", "Lucía", "Fernández", "20/08/1990", "Soltera", "Contadora", 4800, "987222222", "lfernandez@mail.com");
        Cliente c3 = new Cliente("4033333", "Jorge", "Salazar", "03/11/1978", "Casado", "Médico", 9000, "987333333", "jsalazar@mail.com");
        Cliente c4 = new Cliente("4044444", "Karina", "Vega", "15/02/1995", "Soltera", "Diseñadora", 3800, "987444444", "kvega@mail.com");
        Cliente c5 = new Cliente("4055555", "Diego", "Huamán", "27/07/1988", "Conviviente", "Abogado", 7200, "987555555", "dhuaman@mail.com");
        Cliente c6 = new Cliente("4066666", "Valeria", "Rojas", "09/01/1992", "Soltera", "Arquitecta", 5100, "987666666", "vrojas@mail.com");
        
        ad.getClientes()[ad.getContClientes()] = c1; ad.setContClientes(ad.getContClientes() + 1);
        ad.getClientes()[ad.getContClientes()] = c2; ad.setContClientes(ad.getContClientes() + 1);
        ad.getClientes()[ad.getContClientes()] = c3; ad.setContClientes(ad.getContClientes() + 1);
        ad.getClientes()[ad.getContClientes()] = c4; ad.setContClientes(ad.getContClientes() + 1);
        ad.getClientes()[ad.getContClientes()] = c5; ad.setContClientes(ad.getContClientes() + 1);
        ad.getClientes()[ad.getContClientes()] = c6; ad.setContClientes(ad.getContClientes() + 1);
        
        //Reservas
        Reserva r1 = new Reserva(c1, d11, 3000, "30/07/2026", false);
        Reserva r2 = new Reserva(c2, d21, 5000, "15/08/2026", false);
        Reserva r3 = new Reserva(c3, d31, 10000, "10/08/2026", false);
        Reserva r4 = new Reserva(c4, d41, 2000, "20/08/2026", false);
        Reserva r5 = new Reserva(c5, d41, 4000, "25/08/2026", false);
        
        r1.registrarReserva();
        r2.registrarReserva();
        r3.registrarReserva();
        r4.registrarReserva();
        r5.registrarReserva();
        
        Reserva[] arregloReservas = ad.getReservas();
        arregloReservas[ad.getContReservas()] = r1; ad.setContReservas(ad.getContReservas() + 1);
        arregloReservas[ad.getContReservas()] = r2; ad.setContReservas(ad.getContReservas() + 1);
        arregloReservas[ad.getContReservas()] = r3; ad.setContReservas(ad.getContReservas() + 1);
        arregloReservas[ad.getContReservas()] = r4; ad.setContReservas(ad.getContReservas() + 1);
        arregloReservas[ad.getContReservas()] = r5; ad.setContReservas(ad.getContReservas() + 1);
        
 
        //Modalidad de pago
        Venta v1 = new Venta(r1, asesor1, "Contado", "12/07/2026", d11.calcularPrecioFinal(), 0);
        Venta v2 = new Venta(r4, asesor2, "Cuotas Directas", "12/07/2026", 20000, 24);
        Venta v3 = new Venta(r2, asesor2, "Financiamiento Bancario", "12/07/2026", 30000, 0);
        
        v1.registrarVenta();
        v2.registrarVenta();
        v3.registrarVenta();
        
        Venta[] arregloVentas = ad.getVentas();
        arregloVentas[ad.getContVentas()] = v1; ad.setContVentas(ad.getContVentas() + 1);
        arregloVentas[ad.getContVentas()] = v2; ad.setContVentas(ad.getContVentas() + 1);
        arregloVentas[ad.getContVentas()] = v3; ad.setContVentas(ad.getContVentas() + 1);
        Interfaz_Login login = new Interfaz_Login(ad);
        login.setVisible(true);


    }
}

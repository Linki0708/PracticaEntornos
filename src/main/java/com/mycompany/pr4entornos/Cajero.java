/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pr4entornos;

import java.util.ArrayList;

/**
 *
 * @author loren
 */
public class Cajero {

    
    
    private String nombre;
    private int contador_ticket;
    private double ganacias_totales;
    private ArrayList<Producto> productos;

    public Cajero(String nombre) {
        this.nombre = nombre;
        this.contador_ticket = 0;
        this.ganacias_totales = 0;
        this.productos = new ArrayList<>();
    }

    public void ANADIRPRODUCTO(Producto producto) {
        getProductos().add(producto);
    }

    public void eliminarProDUCTO(Producto producto) {
        getProductos().remove(producto);
    }

    public void cobrar() {
        double precio_sin_iva = 0;
        for (Producto producto : getProductos()) {
            precio_sin_iva = precio_sin_iva + producto.calcularImporte();
        }
        double iva = precio_sin_iva * porcentaje_iva;
        double total = precio_sin_iva + iva;

        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + getNombre());
        for (Producto p : getProductos()) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", precio_sin_iva) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", total) + " EUR");
        System.out.println("==================");

        setContador_ticket(getContador_ticket() + 1);
        setGanacias_totales(getGanacias_totales() + total);
        getProductos().clear();
    }
    private static final double porcentaje_iva = 0.21;

    public void cierreCaja() {
        double Iva_recaudado = getGanacias_totales() - (getGanacias_totales() / (1 + porcentaje_iva));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + getNombre());
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + getContador_ticket());
        System.out.println("Total facturado:  " + String.format("%.2f", getGanacias_totales()) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", Iva_recaudado) + " EUR");
        System.out.println("==========================");
    }
    /**
     * @return the contador_ticket
     */
    public int getContador_ticket() {
        return contador_ticket;
    }

    /**
     * @param contador_ticket the contador_ticket to set
     */
    public void setContador_ticket(int contador_ticket) {
        this.contador_ticket = contador_ticket;
    }

    /**
     * @return the ganacias_totales
     */
    public double getGanacias_totales() {
        return ganacias_totales;
    }

    /**
     * @param ganacias_totales the ganacias_totales to set
     */
    public void setGanacias_totales(double ganacias_totales) {
        this.ganacias_totales = ganacias_totales;
    }

    /**
     * @return the productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public boolean ticketVacio() {
        return getProductos().isEmpty();
    }

    public int getTicketsEmitidos() {
        return getContador_ticket();
    }

    public double getTotalDia() {
        return getGanacias_totales();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

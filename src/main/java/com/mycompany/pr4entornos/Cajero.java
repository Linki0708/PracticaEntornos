package com.mycompany.pr4entornos;

import java.util.ArrayList;

public class Cajero {

    
    
    private String nombre;
    private int contador_ticket;
    private double ganacias_totales;
    private ArrayList<Producto> productos;

<<<<<<< HEAD
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
=======
    /**
     * Constructor principal para crear cajero
     *
     * @param n Guarda los nombre de los clientes
     *
     */
    public Cajero(String n) {
        this.n = n;
        this.c = 0;
        this.t = 0;
        this.ps = new ArrayList<>();
    }

    /**
     * Metodo que guarda los productos en la lista ps
     *
     * @param p objeto que representa los productos
     */
    public void ANADIRPRODUCTO(Producto p) {
        ps.add(p);
    }

    /**
     * Metodo que elimina los productos de la lista ps
     *
     * @param p objeto que representa los productos
     */

    public void eliminarProDUCTO(Producto p) {
        ps.remove(p);
>>>>>>> 80cd750103213e94fb4b0e96bbae9141d4e31684
    }
/**
 * Metodo cobrar que nos aplica el iva a los productos y va creando los tickets e introduciendolos dentro de la variable t y contando la cantidad de 
 * clientes
 */
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
<<<<<<< HEAD
    private static final double porcentaje_iva = 0.21;

=======
/**
 * Metodo que imprime el nombre del cajero,la cantidad de tickets emitidos, el total facturado y el total de iva recaudado usando un contador
 */
>>>>>>> 80cd750103213e94fb4b0e96bbae9141d4e31684
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
<<<<<<< HEAD
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

=======
/**
 * Funcion que nos devuelve un boolean dependiendo de si la lista de tickets esta vacia
 * @return 
 */
>>>>>>> 80cd750103213e94fb4b0e96bbae9141d4e31684
    public boolean ticketVacio() {
        return getProductos().isEmpty();
    }
/**
 * Funcion que devuelve la cantidad de tickets emitidos
 * @return 
 */
    public int getTicketsEmitidos() {
        return getContador_ticket();
    }
/**
 * Funcion que devuelve el total de dinero recaudado en el dia
 * @return 
 */
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

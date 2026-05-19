package com.mycompany.pr4entornos;

import java.util.ArrayList;

public class Cajero {

    String n;
    int c;
    double t;
    ArrayList<Producto> ps;

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
    }
/**
 * Metodo cobrar que nos aplica el iva a los productos y va creando los tickets e introduciendolos dentro de la variable t y contando la cantidad de 
 * clientes
 */
    public void cobrar() {
        double subt = 0;
        for (Producto p : ps) {
            subt = subt + p.calcularImporte();
        }
        double iva = subt * 0.21;
        double tot = subt + iva;

        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + n);
        for (Producto p : ps) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subt) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", tot) + " EUR");
        System.out.println("==================");

        c = c + 1;
        t = t + tot;
        ps.clear();
    }
/**
 * Metodo que imprime el nombre del cajero,la cantidad de tickets emitidos, el total facturado y el total de iva recaudado usando un contador
 */
    public void cierreCaja() {
        double ivaRec = t - (t / (1 + 0.21));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + n);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + c);
        System.out.println("Total facturado:  " + String.format("%.2f", t) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", ivaRec) + " EUR");
        System.out.println("==========================");
    }
/**
 * Funcion que nos devuelve un boolean dependiendo de si la lista de tickets esta vacia
 * @return 
 */
    public boolean ticketVacio() {
        return ps.isEmpty();
    }
/**
 * Funcion que devuelve la cantidad de tickets emitidos
 * @return 
 */
    public int getTicketsEmitidos() {
        return c;
    }
/**
 * Funcion que devuelve el total de dinero recaudado en el dia
 * @return 
 */
    public double getTotalDia() {
        return t;
    }
}

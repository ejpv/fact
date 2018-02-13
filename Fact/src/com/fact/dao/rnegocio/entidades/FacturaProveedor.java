
package com.fact.dao.rnegocio.entidades;

import java.util.Date;


public class FacturaProveedor {
    private int numero;
    private Date fecha;
    private Proveedor proveedor;
    private double subtotal;
    private double iva;
    private double total;

    public FacturaProveedor() {
    }

    public FacturaProveedor(int numero, Date fecha, Proveedor Proveedor, double subtotal, double iva, double total) {
        this.numero = numero;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor Proveedor) {
        this.proveedor = proveedor;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}

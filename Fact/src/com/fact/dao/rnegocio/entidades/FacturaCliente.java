
package com.fact.dao.rnegocio.entidades;

import java.util.Date;


public class FacturaCliente {
    private int numero;
    private Date fecha;
    private Cliente cliente;
    private double subtotal;
    private double iva;
    private double total;

    public FacturaCliente() {
    }

    public FacturaCliente(int numero, Date fecha, Cliente cliente, double subtotal, double iva, double total) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

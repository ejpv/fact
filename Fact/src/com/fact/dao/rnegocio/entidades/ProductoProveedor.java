/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.entidades;

/**
 *
 * @author Angel-Pc
 */
public class ProductoProveedor {
    private int codigo;
    private Producto producto;
    private Proveedor proveedor;
    private double precio;
    private int cantidad;
    private double iva;
    private double total;
    private String detalle;

    public ProductoProveedor() {
    }

    public ProductoProveedor(int codigo, Producto producto, Proveedor proveedor, double precio, int cantidad, double iva, double total, String detalle) {
        this.codigo = codigo;
        this.producto = producto;
        this.proveedor = proveedor;
        this.precio = precio;
        this.cantidad = cantidad;
        this.iva = iva;
        this.total = total;
        this.detalle = detalle;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}

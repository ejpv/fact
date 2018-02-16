
package com.fact.dao.rnegocio.entidades;


public class DetalleFacturaProveedor {
    private int codigo;
    private Producto producto;
    private int cantidad;
    private double precio;
    private double subtotal;
    private Iva iva;
    private double total;
    private FacturaProveedor factura;

    public DetalleFacturaProveedor() {
    }

    public DetalleFacturaProveedor(int codigo, Producto producto, int cantidad, double precio, double subtotal, Iva iva, double total, FacturaProveedor factura) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.factura = factura;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Iva getIva() {
        return iva;
    }

    public void setIva(Iva iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public FacturaProveedor getFactura() {
        return factura;
    }

    public void setFactura(FacturaProveedor factura) {
        this.factura = factura;
    }

    
    
}

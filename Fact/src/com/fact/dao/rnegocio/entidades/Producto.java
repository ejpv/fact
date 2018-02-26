
package com.fact.dao.rnegocio.entidades;

import java.util.Date;

public class Producto {
    private int codigo;
    private String nombre;
    private Date fechacaducacion;
    private Categoria categoria;
    private double precioventa;
    private double precioventacantidad;
    private double stockcantidad;
    private double stock;
    private double preciototalventa;
    private String detalle;

    public Producto() {
    }

    public Producto(int codigo, String nombre, Date fechacaducacion, Categoria categoria, double precioventa, double precioventacantidad, double stockcantidad, double stock, double preciototalventa, String detalle) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechacaducacion = fechacaducacion;
        this.categoria = categoria;
        this.precioventa = precioventa;
        this.precioventacantidad = precioventacantidad;
        this.stockcantidad = stockcantidad;
        this.stock = stock;
        this.preciototalventa = preciototalventa;
        this.detalle = detalle;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechacaducacion() {
        return fechacaducacion;
    }

    public void setFechacaducacion(Date fechacaducacion) {
        this.fechacaducacion = fechacaducacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public double getPrecioventacantidad() {
        return precioventacantidad;
    }

    public void setPrecioventacantidad(double precioventacantidad) {
        this.precioventacantidad = precioventacantidad;
    }

    public double getStockcantidad() {
        return stockcantidad;
    }

    public void setStockcantidad(double stockcantidad) {
        this.stockcantidad = stockcantidad;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPreciototalventa() {
        return preciototalventa;
    }

    public void setPreciototalventa(double preciototalventa) {
        this.preciototalventa = preciototalventa;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
}

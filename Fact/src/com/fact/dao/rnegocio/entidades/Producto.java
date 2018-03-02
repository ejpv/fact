package com.fact.dao.rnegocio.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Producto {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int codigo;
    private String nombre;
    private Categoria categoria;
    private double precioventa;
    private double stock;
    private double preciototalventa;
    private String detalle;

    public Producto() {
    }

    public Producto(int codigo, String nombre, Categoria categoria, double precioventa, double stock, double preciototalventa, String detalle) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioventa = precioventa;
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

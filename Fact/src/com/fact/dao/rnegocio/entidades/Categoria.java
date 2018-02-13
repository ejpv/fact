
package com.fact.dao.rnegocio.entidades;


public class Categoria {
    private int codigo;
    private String nombre;
    private String detalle;

    public Categoria() {
    }

    public Categoria(int codigo, String nombre, String detalle) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}

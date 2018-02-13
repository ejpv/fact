
package com.fact.accesoadatos;

public class Parametro {

    private int posicion;
    private Object valor;

    public Parametro() {
    }

    public Parametro(int posicion, Object valor) {
        this.posicion = posicion;
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}

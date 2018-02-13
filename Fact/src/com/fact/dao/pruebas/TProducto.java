/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.pruebas;

import com.fact.dao.contrato.*;
import com.fact.dao.impl.*;
import com.fact.dao.rnegocio.entidades.*;
import java.util.Date;

/**
 *
 * @author Angel-Pc
 */
public class TProducto {

    public static void main(String[] args) {
        int codigo = 1000;
        IProducto dao = new ProductoImp();
        //Ingresar
        int ingreso=0;
        Categoria categoria=new Categoria();
        ICategoria daocategoria=new CategoriaImp();
        try {
            categoria=daocategoria.obtener(1);
            Producto producto=new Producto(codigo, "Focos", "Rojo", "Toyota", 2.5, "Ninguna", new Date("2018-02-21"), categoria, 1.5, 3.5, 4.5, 8, 10, 10.5, 9.5, "Ninguno");
            ingreso=dao.insertar(producto);
        } catch (Exception e) {
            System.out.println("No se pudo ingresar producto");
        }
    }
}

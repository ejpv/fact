/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.IProducto;
import com.fact.dao.contrato.IProductoProveedor;
import com.fact.dao.contrato.IProveedor;
import com.fact.dao.impl.ProductoImp;
import com.fact.dao.impl.ProductoProveedorImp;
import com.fact.dao.impl.ProveedorImp;
import com.fact.dao.rnegocio.entidades.Producto;
import com.fact.dao.rnegocio.entidades.ProductoProveedor;
import com.fact.dao.rnegocio.entidades.Proveedor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TProductoProveedor {

    public TProductoProveedor() {
    }

    @Test
    public void hello() throws Exception {
        int codigo = 1000;
        Producto producto = new Producto();
        IProducto daopro = new ProductoImp();
        Proveedor proveedor = new Proveedor();
        IProveedor daoprov = new ProveedorImp();
        IProductoProveedor dao = new ProductoProveedorImp();
        producto = daopro.obtener(1);
        proveedor = daoprov.obtener(1);
        ProductoProveedor proprov = new ProductoProveedor(codigo, producto, proveedor, 1, 1, 1, "Ninguna",new Date());
        //Insertar
        int insertar = 0;
        try {
            insertar = dao.insertar(proprov);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertar > 0);

        //Modificar
        int modificar = 0;
        try {
            proprov.setDetalle("Que hubo mijin");
            modificar = dao.modificar(proprov);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(modificar > 0);

        //Obtener 
        try {
            ProductoProveedor pro1 = new ProductoProveedor();
            pro1 = dao.obtener(codigo);
            System.out.println(pro1.getProducto().getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Listar
        List<ProductoProveedor> lst = new ArrayList<>();
        try {
            lst = dao.obtener();
            for (ProductoProveedor n : lst) {
                System.out.println(n.getProducto().getNombre());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(lst.size() > 0);

        //Elminar
        int eliminar=0;
        try {
            eliminar=dao.eliminar(proprov);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(eliminar>0);

    }
}

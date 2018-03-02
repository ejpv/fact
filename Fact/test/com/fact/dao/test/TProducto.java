/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.ICategoria;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.impl.CategoriaImp;
import com.fact.dao.impl.ProductoImp;
import com.fact.dao.rnegocio.entidades.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer1
 */
public class TProducto {
    
    public TProducto() {
    }
    @Test
    public void test() throws Exception{
        int a=0;
        IProducto sqlProducto= new ProductoImp();
        ICategoria sqlCategoria = new CategoriaImp();
        Producto producto= new Producto(200, "Ojo", sqlCategoria.obtener(1), 1, 1, 1, "Nose");
    //INSERTAR
    int insertado=0;
        try {
            insertado= sqlProducto.insertar(producto);
        } catch (Exception e) {
            System.err.println("insertar: " +  e.getMessage());
        }
        assertTrue(insertado>0);
    //LISTAR UNO
        try {
            Producto pro=sqlProducto.obtener(101);
            System.out.println(producto.getNombre());
        } catch (Exception e) {
            System.err.println("buscar: " +  e.getMessage());
        }
        assertTrue(producto !=null);
    //MODIFICAR
    int modificado=0;
    producto.setNombre("jahsdjahsd");
        try {
            modificado=sqlProducto.modificar(producto);
        } catch (Exception e) {
            System.err.println("modificar: " +  e.getMessage());
        }
        assertTrue(modificado>0);
    //LISTAR TODOS
        List<Producto> lst = new ArrayList();
        try {
            lst=sqlProducto.obtener();
                for (Producto tmp : lst) {
                System.out.println(tmp.getCodigo());
                System.out.println(tmp.getNombre()+ "   " + tmp.getCategoria().getNombre());
            }
        } catch (Exception e) {
             System.err.println("listar: " +  e.getMessage());
        }
        assertTrue(lst.size() > 0);
    //ELIMINAR
    int eliminado=0;
        try {
            eliminado= sqlProducto.eliminar(producto);
        } catch (Exception e) {
             System.err.println("eliminar: " +  e.getMessage());
        }
        assertTrue(eliminado>0);
    }
}

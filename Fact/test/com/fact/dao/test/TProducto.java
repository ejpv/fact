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
        Producto producto= new Producto(2, "Llanta", "Negra :v", "La hora",15, "Nuevo", new Date(2019, 2, 13),sqlCategoria.obtener(2), 1, 1, 1, 1, 1, 1, 1, "sdfgh");
    //INSERTAR
    int insertado=0;
        try {
            insertado= sqlProducto.insertar(producto);
        } catch (Exception e) {
        }
        assertTrue(insertado>0);
    //LISTAR UNO
    Producto obtenido=null;
        try {
            obtenido = sqlProducto.obtener(2);
            System.out.println(obtenido.getCodigo());
            System.out.println(obtenido.getNombre()+ "   " + obtenido.getCategoria().getNombre());
        } catch (Exception e) {
        }
        assertTrue(obtenido !=null);
    //MODIFICAR
    int modificado=0;
    producto.setNombre("jahsdjahsd");
        try {
            modificado=sqlProducto.modificar(producto);
        } catch (Exception e) {
            System.out.println(e.getCause());
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
        }
        assertTrue(lst.size() > 0);
    //ELIMINAR
    int eliminado=0;
        try {
            eliminado= sqlProducto.eliminar(producto);
        } catch (Exception e) {
        }
        assertTrue(eliminado>0);
    }
}

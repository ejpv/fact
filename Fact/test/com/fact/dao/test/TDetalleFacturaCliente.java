/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.IDetalleFacturaCliente;
import com.fact.dao.contrato.IFacturaCliente;
import com.fact.dao.contrato.IIva;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.impl.DetalleFacturaClienteImp;
import com.fact.dao.impl.FacturaClienteImp;
import com.fact.dao.impl.IvaImp;
import com.fact.dao.impl.ProductoImp;
import com.fact.dao.rnegocio.entidades.DetalleFacturaCliente;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer1
 */
public class TDetalleFacturaCliente {
    
    public TDetalleFacturaCliente() {
    }
    @Test
    
    public void test() throws Exception{
        IFacturaCliente sqlFC = new FacturaClienteImp();
        IIva sqlIva = new IvaImp();
        IProducto sqlProducto = new ProductoImp();
        IDetalleFacturaCliente sqlDFC= new DetalleFacturaClienteImp();
        DetalleFacturaCliente fact = new DetalleFacturaCliente(100, sqlProducto.obtener(1), 12, 15.5, 13, sqlIva.obtener(1), 123, sqlFC.obtener(1));
    //INGRESO
    int ingresados=0;
        try {
            ingresados= sqlDFC.insertar(fact);
        } catch (Exception e) {
        }
        assertTrue(ingresados>0);
    //OBTENER
    DetalleFacturaCliente obtenido= null;
        try {
            obtenido=sqlDFC.obtener(100);
        } catch (Exception e) {
        }
        System.out.println(obtenido.getTotal()+"   "+obtenido.getFactura().getCliente().getNombre()+"  "+obtenido.getIva().getNombre()+"  "+obtenido.getProducto().getNombre());
        assertTrue(obtenido!=null);
    //MODIFICAR
    int modificado=0;
        fact.setCantidad(200);
        try {
            modificado=sqlDFC.modificar(fact);
        } catch (Exception e) {
        }
        assertTrue(modificado>0);
    //LISTAR
        List<DetalleFacturaCliente> lst = new ArrayList();
        try {
            lst= sqlDFC.obtener();
            for(DetalleFacturaCliente tmp:lst){
            System.out.println(obtenido.getTotal());
            System.out.println(obtenido.getFactura().getCliente().getNombre()+"  "+obtenido.getIva().getNombre()+"  "+obtenido.getProducto().getNombre());
            }
        } catch (Exception e) {
        }
        assertTrue(lst.size()>0);
    //ELIMINAR
    int eliminado=0;
        try {
            eliminado= sqlDFC.eliminar(fact);
        } catch (Exception e) {
        }
        assertTrue(eliminado>0);
    }
}

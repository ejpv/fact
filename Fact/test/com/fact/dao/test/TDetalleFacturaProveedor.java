/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.IDetalleFacturaProveedor;
import com.fact.dao.contrato.IFacturaProveedor;
import com.fact.dao.contrato.IIva;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.impl.DetalleFacturaProveedorImp;
import com.fact.dao.impl.FacturaProveedorImp;
import com.fact.dao.impl.IvaImp;
import com.fact.dao.impl.ProductoImp;
import com.fact.dao.rnegocio.entidades.DetalleFacturaProveedor;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TDetalleFacturaProveedor {

    public TDetalleFacturaProveedor() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws Exception {
        IFacturaProveedor sqlFC = new FacturaProveedorImp();
        IIva sqlIva = new IvaImp();
        IProducto sqlProducto = new ProductoImp();
        IDetalleFacturaProveedor sqlDFC = new DetalleFacturaProveedorImp();
        DetalleFacturaProveedor fact = new DetalleFacturaProveedor(1000, sqlProducto.obtener(1), 12, 15.5, 13, sqlIva.obtener(1), 123, sqlFC.obtener(1));
        //INGRESO
        int ingresados = 0;
        try {
            ingresados = sqlDFC.insertar(fact);
        } catch (Exception e) {
        }
        assertTrue(ingresados > 0);
        //MODIFICAR
        int modifico=0;
        fact.setCantidad(100);
        try {
            modifico=sqlDFC.modificar(fact);
        } catch (Exception e) {
        }
        assertTrue(modifico > 0);
        //OBTENER
        DetalleFacturaProveedor facP=new DetalleFacturaProveedor();
        try {
            facP=sqlDFC.obtener(1000);
            System.out.println(facP.getProducto().getNombre());
        } catch (Exception e) {
        }
        //Listar
        List<DetalleFacturaProveedor> lst = new ArrayList();
        try {
            lst= sqlDFC.obtener();
            for(DetalleFacturaProveedor tmp:lst){
                System.out.println(tmp.getProducto().getNombre());
            }
        } catch (Exception e) {
        }
        assertTrue(lst.size()>0);
        //Eliminar
        try {
            sqlDFC.eliminar(fact);
        } catch (Exception e) {
        }
    }
}

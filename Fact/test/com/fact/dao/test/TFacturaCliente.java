/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.ICliente;
import com.fact.dao.contrato.IFacturaCliente;
import com.fact.dao.impl.ClienteImp;
import com.fact.dao.impl.FacturaClienteImp;
import com.fact.dao.rnegocio.entidades.FacturaCliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer1
 */
public class TFacturaCliente {
    
    public TFacturaCliente() {
    }
    @Test
    public void test() throws Exception {
        ICliente sqlCliente = new ClienteImp();
        IFacturaCliente sqlFactura = new FacturaClienteImp();
        FacturaCliente fac = new FacturaCliente(100, new Date(), sqlCliente.obtener(1), 1.2, 0.2, 1.4);
//INSERTAR
        int insertados = 0;
        try {
            insertados = sqlFactura.insertar(fac);
        } catch (Exception e) {
        }
        assertTrue(insertados > 0);
//OBTENER
        FacturaCliente obtenido = null;
        try {
            obtenido = sqlFactura.obtener(100);
        } catch (Exception e) {
        }
        System.out.println(obtenido.getSubtotal()+ "   " + obtenido.getCliente().getNombre());
        assertTrue(insertados > 0);
//MODIFICAR
        fac.setCliente(sqlCliente.obtener(2));
       int modificado =0;
        try {
        modificado = sqlFactura.modificar(fac);   
        } catch (Exception e) {
        }
        assertTrue(modificado>0);
//LISTAR TODOS
        List<FacturaCliente> lst = new ArrayList();
        try {
            lst=sqlFactura.obtener();
        } catch (Exception e) {
        }
        for (FacturaCliente tmp : lst) {
            System.out.println(tmp.getSubtotal());
            System.out.println(tmp.getTotal()+ "   " + tmp.getCliente().getNombre());
        }
        assertTrue(lst.size()>0);
//ELIMINAR
        int eliminado=0;
        try {
            eliminado= sqlFactura.eliminar(fac);
        } catch (Exception e) {
        }
        assertTrue(eliminado>0);
    }
}

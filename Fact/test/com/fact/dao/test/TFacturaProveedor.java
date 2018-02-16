/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.IProveedor;
import com.fact.dao.contrato.IFacturaProveedor;
import com.fact.dao.impl.ProveedorImp;
import com.fact.dao.impl.FacturaProveedorImp;
import com.fact.dao.rnegocio.entidades.FacturaCliente;
import com.fact.dao.rnegocio.entidades.FacturaProveedor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TFacturaProveedor {

    public TFacturaProveedor() {
    }

    @Test
    public void hello() throws Exception {
        int codigo = 11;
        IProveedor sqlProveedor = new ProveedorImp();
        IFacturaProveedor sqlFactura = new FacturaProveedorImp();
        FacturaProveedor fac = new FacturaProveedor(11, new Date(), sqlProveedor.obtener(1), 1.2, 0.2, 1.4);
//INSERTAR
        int insertados = 0;
        try {
            insertados = sqlFactura.insertar(fac);
        } catch (Exception e) {
        }
        assertTrue(insertados > 0);

//Modifcar
        int modificado = 0;
        fac.setNumero(codigo);
        fac.setFecha(new Date());
        fac.setSubtotal(12.56);
        try {
            modificado = sqlFactura.modificar(fac);
        } catch (Exception e) {
        }
        assertTrue(modificado > 0);

//Obtener
        fac = sqlFactura.obtener(codigo);
        try {
            System.out.println(fac.getNumero());
            System.out.println(fac.getProveedor().getNombre());
        } catch (Exception e) {
        }
//Listar
        List<FacturaProveedor> lista = new ArrayList<>();
        try {
            lista = sqlFactura.obtener();
            for (FacturaProveedor tmp : lista) {
                System.out.println(tmp.getNumero());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
//Eliminar
        try {
            sqlFactura.eliminar(fac);
        } catch (Exception e) {
        }
    }
}

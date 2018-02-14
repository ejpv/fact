/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.IIva;
import com.fact.dao.impl.IvaImp;
import com.fact.dao.rnegocio.entidades.Iva;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer1
 */
public class TIva {
    
    public TIva() {
    }
    @Test
    public void test() {
        IIva sqlIva = new IvaImp();
        Iva iva = new Iva(100, "clavito", 15);
    //INSERTAR
    int insertados=0;
        try {
            insertados = sqlIva.insertar(iva);
        } catch (Exception e) {
        }
        assertTrue(insertados > 0);
    //LISTAR
        Iva obtenido = null;
        try {
            obtenido = sqlIva.obtener(100);
            System.out.println(obtenido.getCodigo());
            System.out.println(obtenido.getNombre()+ "   " + obtenido.getPrecio());
        } catch (Exception e) {
        }
        assertTrue(obtenido != null);
    //MODIFICAR
        iva.setNombre("Alfredo");
        int modificados = 0;
        try {
            modificados = sqlIva.modificar(iva);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
    //LISTAR TODOS
        List<Iva> lista = new ArrayList();
        try {
            lista = sqlIva.obtener();
            for (Iva tmp : lista) {
                System.out.println(tmp.getCodigo());
                System.out.println(tmp.getNombre()+ "   " + tmp.getPrecio());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
    //ELIMINAR
    int eliminados=0;
        try {
            eliminados=sqlIva.eliminar(iva);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
    }
}

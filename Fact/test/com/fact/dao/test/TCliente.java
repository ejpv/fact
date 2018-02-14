/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import org.junit.Test;
import com.fact.dao.contrato.ICliente;
import com.fact.dao.impl.ClienteImp;
import com.fact.dao.rnegocio.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer1
 */
public class TCliente {
    
    public TCliente() {
    }
@Test
    public void test() {
        ICliente sqlCliente = new ClienteImp();
        Cliente cliente = new Cliente(10000, "080323656-2", "Pablito", "Clavó", "un clavito", "0990587623", "0803236561", "123");
//INSERTAR
        int insertados = 0;
        try {
            insertados = sqlCliente.insertar(cliente);
        } catch (Exception e) {
        }
        assertTrue(insertados > 0);
//OBTENER
        Cliente obtenido = null;
        try {
            obtenido = sqlCliente.obtener(10000);
            System.out.println(obtenido.getCodigo());
            System.out.println(obtenido.getNombre()+ "   " + obtenido.getCedula());
        } catch (Exception e) {
        }
        assertTrue(obtenido != null);
//MODIFICAR
        cliente.setNombre("Pinsh Pablito");
        int modificados = 0;
        try {
            modificados = sqlCliente.modificar(cliente);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
//OBTENER por cedula
        Cliente obtenido2 = null;
        try {
            obtenido2 = sqlCliente.obtenerCedula("080323656-2");
            System.out.println(obtenido2.getCodigo());
            System.out.println(obtenido2.getNombre()+ "   " + obtenido2.getCedula());
        } catch (Exception e) {
        }
        assertTrue(obtenido2 != null);
//LISTAR
        List<Cliente> lista = new ArrayList<>();
        try {
            lista = sqlCliente.obtener();
            for (Cliente tmp : lista) {
                System.out.println(tmp.getCodigo());
                System.out.println(tmp.getNombre()+ "   " + tmp.getCedula());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
//ELIMINAR
        int eliminados = 0;
        try {
            eliminados = sqlCliente.eliminar(cliente);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
    }
}

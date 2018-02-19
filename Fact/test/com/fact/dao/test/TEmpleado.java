/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.IEmpleado;
import com.fact.dao.impl.EmpleadoImp;
import com.fact.dao.rnegocio.entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TEmpleado {

    public TEmpleado() {
    }

    @Test
    public void hello() {
        int codigo = 1000;
        IEmpleado dao = new EmpleadoImp();
        Empleado empleado = new Empleado(codigo, "180492150-8", "Angel", "Sisa", "Nose", "Ambato", "0968759242", "Cajero", "aaaa", "123");
        //Ingresar
        int ingreso = 0;
        try {
            ingreso = dao.insertar(empleado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(ingreso > 0);
        //Modificar
        int modificar = 0;
        empleado.setCodigo(codigo);
        empleado.setApellido("Caiza");
        try {
            modificar = dao.modificar(empleado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(modificar > 0);
        //Obtener
        try {
            Empleado emp=new Empleado();
            emp=dao.obtener(codigo);
            System.out.println(emp.getCedula());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Obtener por Cedula
        try {
            Empleado emp=new Empleado();
            emp=dao.obtenerCedula("180492150-8");
            System.out.println(emp.getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Listar
        List<Empleado> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Empleado tmp : lista) {
                System.out.println(tmp.getCodigo());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //Eliminar
        try {
            dao.eliminar(empleado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

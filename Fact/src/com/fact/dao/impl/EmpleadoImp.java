/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IEmpleado;
import com.fact.dao.rnegocio.entidades.Empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class EmpleadoImp implements IEmpleado {

    @Override
    public int insertar(Empleado empleado) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO public.empleado(\n"
                + "            codigo, cedula, nombre, apellido, especialidad, direccion, telefono, \n"
                + "            tipo, usuario, clave)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, \n"
                + "            ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodigo()));
        lstPar.add(new Parametro(2, empleado.getCedula()));
        lstPar.add(new Parametro(3, empleado.getNombre()));
        lstPar.add(new Parametro(3, empleado.getApellido()));
        lstPar.add(new Parametro(3, empleado.getEspecialidad()));
        lstPar.add(new Parametro(3, empleado.getDireccion()));
        lstPar.add(new Parametro(3, empleado.getTelefono()));
        lstPar.add(new Parametro(3, empleado.getTipo()));
        lstPar.add(new Parametro(3, empleado.getUsuario()));
        lstPar.add(new Parametro(3, empleado.getClave()));
        Conexion con = new Conexion();
        try {
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

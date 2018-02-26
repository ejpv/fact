/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IEmpleado;
import com.fact.dao.rnegocio.entidades.Cliente;
import com.fact.dao.rnegocio.entidades.Empleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
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
        lstPar.add(new Parametro(4, empleado.getApellido()));
        lstPar.add(new Parametro(5, empleado.getEspecialidad()));
        lstPar.add(new Parametro(6, empleado.getDireccion()));
        lstPar.add(new Parametro(7, empleado.getTelefono()));
        lstPar.add(new Parametro(8, empleado.getTipo()));
        lstPar.add(new Parametro(9, empleado.getUsuario()));
        lstPar.add(new Parametro(10, empleado.getClave()));
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
        int numFilasAfectadas = 0;
        String sql = "UPDATE public.empleado\n"
                + "   SET cedula=?, nombre=?, apellido=?, especialidad=?, direccion=?, \n"
                + "       telefono=?, tipo=?, usuario=?, clave=?\n"
                + " WHERE codigo=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCedula()));
        lstPar.add(new Parametro(2, empleado.getNombre()));
        lstPar.add(new Parametro(3, empleado.getApellido()));
        lstPar.add(new Parametro(4, empleado.getEspecialidad()));
        lstPar.add(new Parametro(5, empleado.getDireccion()));
        lstPar.add(new Parametro(6, empleado.getTelefono()));
        lstPar.add(new Parametro(7, empleado.getTipo()));
        lstPar.add(new Parametro(8, empleado.getUsuario()));
        lstPar.add(new Parametro(9, empleado.getClave()));
        lstPar.add(new Parametro(10, empleado.getCodigo()));
        con.conectar();
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
    public int eliminar(Empleado empleado) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM empleado WHERE codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodigo()));
        Conexion con = new Conexion();
        con.conectar();
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
    public Empleado obtener(int id) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT codigo, cedula, nombre, apellido, especialidad, direccion, telefono, \n"
                + "       tipo, usuario, clave\n"
                + "  FROM public.empleado WHERE codigo=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                empleado = new Empleado();
                empleado.setCodigo(rst.getInt(1));
                empleado.setCedula(rst.getString(2));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setEspecialidad(rst.getString(5));
                empleado.setDireccion(rst.getString(6));
                empleado.setTelefono(rst.getString(7));
                empleado.setTipo(rst.getString(8));
                empleado.setUsuario(rst.getString(9));
                empleado.setClave(rst.getString(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public Empleado obtener(String usuario, String contraseña) throws Exception {
        Empleado emp = null;
        String sql = "SELECT codigo, cedula, nombre, apellido, especialidad, direccion, telefono, \n"
                + "       tipo, usuario, clave\n"
                + "  FROM public.empleado WHERE usuario=? AND clave=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario));
        lstPar.add(new Parametro(2, contraseña));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                emp = new Empleado();
                emp.setCodigo(rst.getInt(1));
                emp.setCedula(rst.getString(2));
                emp.setNombre(rst.getString(3));
                emp.setApellido(rst.getString(4));
                emp.setEspecialidad(rst.getString(5));
                emp.setDireccion(rst.getString(6));
                emp.setTelefono(rst.getString(7));
                emp.setTipo(rst.getString(8));
                emp.setUsuario(rst.getString(9));
                emp.setClave(rst.getString(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return emp;
    }

    @Override
    public Empleado obtenerCedula(String cedula) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT codigo, cedula, nombre, apellido, especialidad, direccion, telefono, \n"
                + "       tipo, usuario, clave\n"
                + "  FROM public.empleado WHERE cedula=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cedula));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                empleado = new Empleado();
                empleado.setCodigo(rst.getInt(1));
                empleado.setCedula(rst.getString(2));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setEspecialidad(rst.getString(5));
                empleado.setDireccion(rst.getString(6));
                empleado.setTelefono(rst.getString(7));
                empleado.setTipo(rst.getString(8));
                empleado.setUsuario(rst.getString(9));
                empleado.setClave(rst.getString(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT codigo, cedula, nombre, apellido, especialidad, direccion, telefono, \n"
                + "       tipo, usuario, clave\n"
                + "  FROM public.empleado";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Empleado empleado = new Empleado();
                empleado = new Empleado();
                empleado.setCodigo(rst.getInt(1));
                empleado.setCedula(rst.getString(2));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setEspecialidad(rst.getString(5));
                empleado.setDireccion(rst.getString(6));
                empleado.setTelefono(rst.getString(7));
                empleado.setTipo(rst.getString(8));
                empleado.setUsuario(rst.getString(9));
                empleado.setClave(rst.getString(10));
                lista.add(empleado);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        lista.sort(new Comparator<Empleado>() {
            @Override
            public int compare(Empleado empleado1, Empleado empleado2) {
                return new Integer(empleado1.getCodigo()).compareTo(empleado2.getCodigo());
            }
        });
        return lista;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.ICliente;
import com.fact.dao.contrato.IEmpleado;
import com.fact.dao.contrato.IFacturaCliente;
import com.fact.dao.rnegocio.entidades.FacturaCliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaClienteImp implements IFacturaCliente {

    @Override
    public int insertar(FacturaCliente facturaCliente) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO public.factura_cliente(\n"
                + "            numero, fecha, cliente, subtotal, iva, total,empleado)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?,?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaCliente.getNumero()));
        lstPar.add(new Parametro(2, facturaCliente.getFecha()));
        lstPar.add(new Parametro(3, facturaCliente.getCliente().getCodigo()));
        lstPar.add(new Parametro(4, facturaCliente.getSubtotal()));
        lstPar.add(new Parametro(5, facturaCliente.getIva()));
        lstPar.add(new Parametro(6, facturaCliente.getTotal()));
        lstPar.add(new Parametro(7, facturaCliente.getEmpleado().getCodigo()));
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
    public int modificar(FacturaCliente facturaCliente) {
        int modificado = 0;
        String sql = "UPDATE public.factura_cliente\n"
                + "   SET fecha=?, cliente=?, subtotal=?, iva=?, total=?, empleado=?\n"
                + " WHERE numero=?";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, facturaCliente.getFecha()));
        prts.add(new Parametro(2, facturaCliente.getCliente().getCodigo()));
        prts.add(new Parametro(3, facturaCliente.getSubtotal()));
        prts.add(new Parametro(4, facturaCliente.getIva()));
        prts.add(new Parametro(5, facturaCliente.getTotal()));
        prts.add(new Parametro(6, facturaCliente.getEmpleado().getCodigo()));
        prts.add(new Parametro(7, facturaCliente.getNumero()));
        Conexion con = new Conexion();
        try {
            modificado = con.ejecutaComando(sql, prts);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return modificado;
    }

    @Override
    public int eliminar(FacturaCliente facturaCliente) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM public.factura_cliente\n"
                + " WHERE numero=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaCliente.getNumero()));
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
    public FacturaCliente obtener(int id) throws Exception {
        FacturaCliente fac = null;
        ICliente sqlCliente = new ClienteImp();
        IEmpleado daoemple=new EmpleadoImp();
        String sql = "SELECT numero, fecha, cliente, subtotal, iva, total,empleado FROM public.factura_cliente WHERE numero=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                fac = new FacturaCliente();
                fac.setNumero(rst.getInt(1));
                fac.setFecha(rst.getDate(2));
                fac.setCliente(sqlCliente.obtener(rst.getInt(3)));
                fac.setSubtotal(rst.getDouble(4));
                fac.setIva(rst.getDouble(5));
                fac.setTotal(rst.getDouble(6));
                fac.setEmpleado(daoemple.obtener(rst.getInt(7)));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return fac;
    }

    @Override
    public List<FacturaCliente> obtener() throws Exception {
        List<FacturaCliente> lista = new ArrayList<>();
        ICliente sqlCliente = new ClienteImp();
        IEmpleado daoemple=new EmpleadoImp();
        String sql = "SELECT numero, fecha, cliente, subtotal, iva, total,empleado FROM public.factura_cliente";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                FacturaCliente fac = new FacturaCliente();
                fac.setNumero(rst.getInt(1));
                fac.setFecha(rst.getDate(2));
                fac.setCliente(sqlCliente.obtener(rst.getInt(3)));
                fac.setSubtotal(rst.getDouble(4));
                fac.setIva(rst.getDouble(5));
                fac.setTotal(rst.getDouble(6));
                fac.setEmpleado(daoemple.obtener(rst.getInt(7)));
                lista.add(fac);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}

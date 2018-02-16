package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IFacturaProveedor;
import com.fact.dao.contrato.IProveedor;
import com.fact.dao.rnegocio.entidades.FacturaProveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaProveedorImp implements IFacturaProveedor {

    @Override
    public int insertar(FacturaProveedor facturaProveedor) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO public.factura_proveedor(\n"
                + "            numero, fecha, proveedor, subtotal, iva, total)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaProveedor.getNumero()));
        lstPar.add(new Parametro(2, facturaProveedor.getFecha()));
        lstPar.add(new Parametro(3, facturaProveedor.getProveedor().getCodigo()));
        lstPar.add(new Parametro(4, facturaProveedor.getSubtotal()));
        lstPar.add(new Parametro(5, facturaProveedor.getIva()));
        lstPar.add(new Parametro(6, facturaProveedor.getTotal()));
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
    public int modificar(FacturaProveedor facturaProveedor) {
        int modificado = 0;
        String sql = "UPDATE public.factura_proveedor\n"
                + "   SET fecha=?, proveedor=?, subtotal=?, iva=?, total=?\n"
                + " WHERE numero=?";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, facturaProveedor.getFecha()));
        prts.add(new Parametro(2, facturaProveedor.getProveedor().getCodigo()));
        prts.add(new Parametro(3, facturaProveedor.getSubtotal()));
        prts.add(new Parametro(4, facturaProveedor.getIva()));
        prts.add(new Parametro(5, facturaProveedor.getTotal()));
        prts.add(new Parametro(6, facturaProveedor.getNumero()));
        Conexion con = new Conexion();
        try {
            modificado = con.ejecutaComando(sql, prts);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return modificado;
    }

    @Override
    public int eliminar(FacturaProveedor facturaProveedor) {
       int numFilasAfectadas = 0;
        String sql = "DELETE FROM public.factura_proveedor\n"
                + " WHERE numero=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaProveedor.getNumero()));
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
    public FacturaProveedor obtener(int id) throws Exception {
        FacturaProveedor fac = null;
        IProveedor proveedor = new ProveedorImp();
        String sql = "SELECT numero, fecha, proveedor, subtotal, iva, total FROM public.factura_proveedor WHERE numero=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                fac = new FacturaProveedor();
                fac.setNumero(rst.getInt(1));
                fac.setFecha(rst.getDate(2));
                fac.setProveedor(proveedor.obtener(rst.getInt(3)));
                fac.setSubtotal(rst.getDouble(4));
                fac.setIva(rst.getDouble(5));
                fac.setTotal(rst.getDouble(6));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return fac;
    }

    @Override
    public List<FacturaProveedor> obtener() throws Exception {
        List<FacturaProveedor> lista = new ArrayList<>();
        IProveedor proveedor = new ProveedorImp();
        String sql = "SELECT numero, fecha, proveedor, subtotal, iva, total FROM public.factura_proveedor";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                FacturaProveedor fac = new FacturaProveedor();
                fac.setNumero(rst.getInt(1));
                fac.setFecha(rst.getDate(2));
                fac.setProveedor(proveedor.obtener(rst.getInt(3)));
                fac.setSubtotal(rst.getDouble(4));
                fac.setIva(rst.getDouble(5));
                fac.setTotal(rst.getDouble(6));
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

package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IDetalleFacturaCliente;
import com.fact.dao.contrato.IFacturaCliente;
import com.fact.dao.contrato.IIva;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.rnegocio.entidades.DetalleFacturaCliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer1
 */

public class DetalleFacturaClienteImp implements IDetalleFacturaCliente{

    @Override
    public int insertar(DetalleFacturaCliente detalleFacturaCliente) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO public.detalle_factura_cliente(\n" +
"            codigo_detalle_cliente, producto, cantidad, precio, subtotal, \n" +
"            iva, total, factura)\n" +
"    VALUES (?, ?, ?, ?, ?, \n" +
"            ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleFacturaCliente.getCodigo()));
        lstPar.add(new Parametro(2, detalleFacturaCliente.getProducto().getCodigo()));
        lstPar.add(new Parametro(3, detalleFacturaCliente.getCantidad()));
        lstPar.add(new Parametro(4, detalleFacturaCliente.getPrecio()));
        lstPar.add(new Parametro(5, detalleFacturaCliente.getSubtotal()));
        lstPar.add(new Parametro(6, detalleFacturaCliente.getIva().getCodigo()));
        lstPar.add(new Parametro(7, detalleFacturaCliente.getTotal()));
        lstPar.add(new Parametro(8, detalleFacturaCliente.getFactura().getNumero()));
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
    public int modificar(DetalleFacturaCliente detalleFacturaCliente) {
        int modificado = 0;
        String sql = "UPDATE public.detalle_factura_cliente\n" +
"   SET producto=?, cantidad=?, precio=?, subtotal=?, \n" +
"       iva=?, total=?, factura=?\n" +
" WHERE codigo_detalle_cliente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleFacturaCliente.getProducto().getCodigo()));
        lstPar.add(new Parametro(2, detalleFacturaCliente.getCantidad()));
        lstPar.add(new Parametro(3, detalleFacturaCliente.getPrecio()));
        lstPar.add(new Parametro(4, detalleFacturaCliente.getSubtotal()));
        lstPar.add(new Parametro(5, detalleFacturaCliente.getIva().getCodigo()));
        lstPar.add(new Parametro(6, detalleFacturaCliente.getTotal()));
        lstPar.add(new Parametro(7, detalleFacturaCliente.getFactura().getNumero()));
        lstPar.add(new Parametro(8, detalleFacturaCliente.getCodigo()));
        Conexion con = new Conexion();
        try {
            modificado = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return modificado;
    }

    @Override
    public int eliminar(DetalleFacturaCliente detalleFacturaCliente) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM public.detalle_factura_cliente\n" +
" WHERE codigo_detalle_cliente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleFacturaCliente.getCodigo()));
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
    public DetalleFacturaCliente obtener(int id) throws Exception {
        DetalleFacturaCliente fac = null;
        IFacturaCliente sqlFC = new FacturaClienteImp();
        IProducto sqlP = new ProductoImp();
        IIva sqlIva = new IvaImp();
        String sql = "SELECT codigo_detalle_cliente, producto, cantidad, precio, subtotal, \n" +
"       iva, total, factura\n" +
"  FROM public.detalle_factura_cliente WHERE codigo_detalle_cliente=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                fac = new DetalleFacturaCliente();
                fac.setCodigo(rst.getInt(1));
                fac.setProducto(sqlP.obtener(rst.getInt(2)));
                fac.setCantidad(rst.getInt(3));
                fac.setPrecio(rst.getDouble(4));
                fac.setSubtotal(rst.getDouble(5));
                fac.setIva(sqlIva.obtener(rst.getInt(6)));
                fac.setTotal(rst.getDouble(7));
                fac.setFactura(sqlFC.obtener(rst.getInt(8)));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return fac;
    }

    @Override
    public List<DetalleFacturaCliente> obtener() throws Exception {
       List<DetalleFacturaCliente> lst = new ArrayList<>();
        IFacturaCliente sqlFC = new FacturaClienteImp();
        IProducto sqlP = new ProductoImp();
        IIva sqlIva = new IvaImp();
        String sql = "SELECT codigo_detalle_cliente, producto, cantidad, precio, subtotal, \n" +
"       iva, total, factura\n" +
"  FROM public.detalle_factura_cliente";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                DetalleFacturaCliente fac = new DetalleFacturaCliente();
                fac.setCodigo(rst.getInt(1));
                fac.setProducto(sqlP.obtener(rst.getInt(2)));
                fac.setCantidad(rst.getInt(3));
                fac.setPrecio(rst.getDouble(4));
                fac.setSubtotal(rst.getDouble(5));
                fac.setIva(sqlIva.obtener(rst.getInt(6)));
                fac.setTotal(rst.getDouble(7));
                fac.setFactura(sqlFC.obtener(rst.getInt(8)));
                lst.add(fac);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lst;
    }
    
}
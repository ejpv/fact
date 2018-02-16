package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IDetalleFacturaProveedor;
import com.fact.dao.contrato.IFacturaProveedor;
import com.fact.dao.contrato.IIva;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.rnegocio.entidades.DetalleFacturaProveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleFacturaProveedorImp implements IDetalleFacturaProveedor {

    @Override
    public int insertar(DetalleFacturaProveedor detalleFacturaProveedor) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO public.detalle_factura_proveedor(\n"
                + "            codigo_detalle_proveedor, producto, cantidad, precio, subtotal, \n"
                + "            iva, total, factura)\n"
                + "    VALUES (?, ?, ?, ?, ?, \n"
                + "            ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleFacturaProveedor.getCodigo()));
        lstPar.add(new Parametro(2, detalleFacturaProveedor.getProducto().getCodigo()));
        lstPar.add(new Parametro(3, detalleFacturaProveedor.getCantidad()));
        lstPar.add(new Parametro(4, detalleFacturaProveedor.getPrecio()));
        lstPar.add(new Parametro(5, detalleFacturaProveedor.getSubtotal()));
        lstPar.add(new Parametro(6, detalleFacturaProveedor.getIva().getCodigo()));
        lstPar.add(new Parametro(7, detalleFacturaProveedor.getTotal()));
        lstPar.add(new Parametro(8, detalleFacturaProveedor.getFactura().getNumero()));
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
    public int modificar(DetalleFacturaProveedor detalleFacturaProveedor) {
        int modificado = 0;
        String sql = "UPDATE public.detalle_factura_proveedor\n"
                + "   SET producto=?, cantidad=?, precio=?, subtotal=?, \n"
                + "       iva=?, total=?, factura=?\n"
                + " WHERE codigo_detalle_proveedor=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleFacturaProveedor.getProducto().getCodigo()));
        lstPar.add(new Parametro(2, detalleFacturaProveedor.getCantidad()));
        lstPar.add(new Parametro(3, detalleFacturaProveedor.getPrecio()));
        lstPar.add(new Parametro(4, detalleFacturaProveedor.getSubtotal()));
        lstPar.add(new Parametro(5, detalleFacturaProveedor.getIva().getCodigo()));
        lstPar.add(new Parametro(6, detalleFacturaProveedor.getTotal()));
        lstPar.add(new Parametro(7, detalleFacturaProveedor.getFactura().getNumero()));
        lstPar.add(new Parametro(8, detalleFacturaProveedor.getCodigo()));
        Conexion con = new Conexion();
        try {
            modificado = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return modificado;
    }

    @Override
    public int eliminar(DetalleFacturaProveedor detalleFacturaProveedor) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM public.detalle_factura_proveedor\n"
                + " WHERE codigo_detalle_proveedor=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleFacturaProveedor.getCodigo()));
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
    public DetalleFacturaProveedor obtener(int id) throws Exception {
        DetalleFacturaProveedor fac = null;
        IFacturaProveedor sqlFC = new FacturaProveedorImp();
        IProducto sqlP = new ProductoImp();
        IIva sqlIva = new IvaImp();
        String sql = "SELECT codigo_detalle_proveedor, producto, cantidad, precio, subtotal, \n"
                + "       iva, total, factura\n"
                + "  FROM public.detalle_factura_proveedor WHERE codigo_detalle_proveedor=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                fac = new DetalleFacturaProveedor();
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
    public List<DetalleFacturaProveedor> obtener() throws Exception {
        List<DetalleFacturaProveedor> lst = new ArrayList<>();
        IFacturaProveedor sqlFC = new FacturaProveedorImp();
        IProducto sqlP = new ProductoImp();
        IIva sqlIva = new IvaImp();
        String sql = "SELECT codigo_detalle_proveedor, producto, cantidad, precio, subtotal, \n"
                + "       iva, total, factura\n"
                + "  FROM public.detalle_factura_proveedor";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                DetalleFacturaProveedor fac = new DetalleFacturaProveedor();
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

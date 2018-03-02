/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.contrato.IProductoProveedor;
import com.fact.dao.contrato.IProveedor;
import com.fact.dao.rnegocio.entidades.ProductoProveedor;
import com.fact.dao.rnegocio.entidades.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class ProductoProveedorImp implements IProductoProveedor {

    @Override
    public int insertar(ProductoProveedor productoProveedor) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO public.producto_proveedor(\n"
                + "            codigo, codigo_producto, codigo_proveedor, precio, cantidad, \n"
                + "             total, detalle,fecha)\n"
                + "    VALUES (?, ?, ?, ?, ?, \n"
                + "             ?, ?,?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, productoProveedor.getCodigo()));
        lstPar.add(new Parametro(2, productoProveedor.getProducto().getCodigo()));
        lstPar.add(new Parametro(3, productoProveedor.getProveedor().getCodigo()));
        lstPar.add(new Parametro(4, productoProveedor.getPrecio()));
        lstPar.add(new Parametro(5, productoProveedor.getCantidad()));
        lstPar.add(new Parametro(6, productoProveedor.getTotal()));
        lstPar.add(new Parametro(7, productoProveedor.getDetalle()));
        lstPar.add(new Parametro(8, productoProveedor.getFecha()));
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
    public int modificar(ProductoProveedor productoProveedor) {
        int modificado = 0;
        String sql = "UPDATE public.producto_proveedor\n"
                + "   SET codigo_producto=?, codigo_proveedor=?, precio=?, cantidad=?, \n"
                + "             total=?, detalle=?,fecha=?\n"
                + " WHERE codigo= ?";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, productoProveedor.getProducto().getCodigo()));
        prts.add(new Parametro(2, productoProveedor.getProveedor().getCodigo()));
        prts.add(new Parametro(3, productoProveedor.getPrecio()));
        prts.add(new Parametro(4, productoProveedor.getCantidad()));
        prts.add(new Parametro(5, productoProveedor.getTotal()));
        prts.add(new Parametro(6, productoProveedor.getDetalle()));
        prts.add(new Parametro(7, productoProveedor.getFecha()));
        prts.add(new Parametro(8, productoProveedor.getCodigo()));
        Conexion con = new Conexion();
        try {
            modificado = con.ejecutaComando(sql, prts);
        } catch (Exception e) {
            throw e;
        }
        return modificado;
    }

    @Override
    public int eliminar(ProductoProveedor productoProveedor) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM producto_proveedor WHERE codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, productoProveedor.getCodigo()));
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
    public ProductoProveedor obtener(int id) throws Exception {
        ProductoProveedor fac = null;
        IProducto daopro = new ProductoImp();
        IProveedor daoprov = new ProveedorImp();
        String sql = "SELECT codigo, codigo_producto, codigo_proveedor, precio, cantidad, \n"
                + "       total, detalle, fecha\n"
                + "  FROM public.producto_proveedor WHERE codigo=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                fac = new ProductoProveedor();
                fac.setCodigo(rst.getInt(1));
                fac.setProducto(daopro.obtener(rst.getInt(2)));
                fac.setProveedor(daoprov.obtener(rst.getInt(3)));
                fac.setPrecio(rst.getDouble(4));
                fac.setCantidad(rst.getInt(5));
                fac.setTotal(rst.getDouble(6));
                fac.setDetalle(rst.getString(7));
                fac.setFecha(rst.getDate(8));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return fac;
    }

    @Override
    public List<ProductoProveedor> obtener() throws Exception {
        List<ProductoProveedor> lista = new ArrayList<>();
        IProducto producto = new ProductoImp();
        IProveedor proveedor = new ProveedorImp();
        String sql = "SELECT codigo, codigo_producto, codigo_proveedor, precio, cantidad, \n"
                + "       total, detalle, fecha\n"
                + "  FROM public.producto_proveedor";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                ProductoProveedor fac = new ProductoProveedor();
                fac.setCodigo(rst.getInt(1));
                fac.setProducto(producto.obtener(rst.getInt(2)));
                fac.setProveedor(proveedor.obtener(rst.getInt(3)));
                fac.setPrecio(rst.getDouble(4));
                fac.setCantidad(rst.getInt(5));
                fac.setTotal(rst.getDouble(6));
                fac.setDetalle(rst.getString(7));
                fac.setFecha(rst.getDate(8));
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

package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.rnegocio.entidades.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoImp implements IProducto {

    @Override
    public int insertar(Producto producto) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO public.producto(\n"
                + "            codigo_producto, nombre, color, marca, \"tamaño\", aroma, fecha_caducacion, \n"
                + "            categoria, precio_compra, precio_venta, precio_venta_cantidad, \n"
                + "            stock_cantidad, stock, precio_total_compra, precio_total_venta, \n"
                + "            detalle)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?, \n"
                + "            ?, ?, ?, ?, \n"
                + "            ?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigo()));
        lstPar.add(new Parametro(2, producto.getNombre()));
        lstPar.add(new Parametro(3, producto.getColor()));
        lstPar.add(new Parametro(4, producto.getMarca()));
        lstPar.add(new Parametro(5, producto.getTamaño()));
        lstPar.add(new Parametro(6, producto.getAroma()));
        lstPar.add(new Parametro(7, producto.getFechacaducacion()));
        lstPar.add(new Parametro(8, producto.getCategoria().getCodigo()));
        lstPar.add(new Parametro(9, producto.getPreciocompra()));
        lstPar.add(new Parametro(10, producto.getPrecioventa()));
        lstPar.add(new Parametro(11, producto.getPrecioventacantidad()));
        lstPar.add(new Parametro(12, producto.getStockcantidad()));
        lstPar.add(new Parametro(13, producto.getStock()));
        lstPar.add(new Parametro(14, producto.getPreciototalcompra()));
        lstPar.add(new Parametro(15, producto.getPreciototalventa()));
        lstPar.add(new Parametro(16, producto.getDetalle()));
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
    public int modificar(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> obtener() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

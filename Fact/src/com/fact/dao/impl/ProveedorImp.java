
package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IProveedor;
import com.fact.dao.rnegocio.entidades.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProveedorImp implements IProveedor{

    @Override
    public int insertar(Proveedor proveedor) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO proveedor(codigo_proveedor, nombre, direccion, telefono, \"e-mail\")\n" 
                +"    VALUES (?, ?, ?, ?, ?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getCodigo()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getDireccion()));
        lstPar.add(new Parametro(4, proveedor.getTelefono()));
        lstPar.add(new Parametro(5, proveedor.getEmail()));
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
    public int modificar(Proveedor proveedor) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE proveedor SET nombre=?, direccion=?, telefono=?, \"e-mail\"=? WHERE codigo_proveedor=?";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getNombre()));
        lstPar.add(new Parametro(2, proveedor.getDireccion()));
        lstPar.add(new Parametro(3, proveedor.getTelefono()));
        lstPar.add(new Parametro(4, proveedor.getEmail()));
        lstPar.add(new Parametro(5, proveedor.getCodigo()));
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
    public int eliminar(Proveedor proveedor) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM proveedor WHERE codigo_proveedor=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getCodigo()));
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
    public Proveedor obtener(int id) throws Exception {
        Proveedor proveedor = null;
        String sql = "SELECT codigo_proveedor, nombre, direccion, telefono, \"e-mail\" FROM proveedor WHERE codigo_proveedor=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setCodigo(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setDireccion(rst.getString(3));
                proveedor.setTelefono(rst.getString(4));
                proveedor.setEmail(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return proveedor;
    }

    @Override
    public List<Proveedor> obtener() throws Exception {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT codigo_proveedor, nombre, direccion, telefono, \"e-mail\" FROM proveedor";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor = new Proveedor();
                proveedor.setCodigo(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setDireccion(rst.getString(3));
                proveedor.setTelefono(rst.getString(4));
                proveedor.setEmail(rst.getString(5));
                lista.add(proveedor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }
    
}

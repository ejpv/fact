
package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.IIva;
import com.fact.dao.rnegocio.entidades.Iva;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class IvaImp implements IIva{

    @Override
    public int insertar(Iva iva) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO iva(codigo_iva, nombre, precio)\n" 
                +"    VALUES (?, ?, ?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, iva.getCodigo()));
        lstPar.add(new Parametro(2, iva.getNombre()));
        lstPar.add(new Parametro(3, iva.getPrecio()));
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
    public int modificar(Iva iva) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE iva SET nombre=?, precio=? WHERE codigo_iva=?";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, iva.getNombre()));
        lstPar.add(new Parametro(2, iva.getPrecio()));
        lstPar.add(new Parametro(3, iva.getCodigo()));
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
    public int eliminar(Iva iva) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM iva WHERE codigo_iva=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, iva.getCodigo()));
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
    public Iva obtener(int id) throws Exception {
        Iva iva = null;
        String sql = "SELECT codigo_iva, nombre, precio FROM iva WHERE codigo_iva=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                iva = new Iva();
                iva.setCodigo(rst.getInt(1));
                iva.setNombre(rst.getString(2));
                iva.setPrecio(rst.getDouble(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return iva;
    }

    @Override
    public List<Iva> obtener() throws Exception {
        List<Iva> lista = new ArrayList<>();
        String sql = "SELECT codigo_iva, nombre, precio FROM iva";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Iva iva = new Iva();
                iva = new Iva();
                iva.setCodigo(rst.getInt(1));
                iva.setNombre(rst.getString(2));
                iva.setPrecio(rst.getDouble(3));
                lista.add(iva);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }
    
}

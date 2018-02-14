/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.ICategoria;
import com.fact.dao.rnegocio.entidades.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class CategoriaImp implements ICategoria{

    @Override
    public int insertar(Categoria categoria) {
        int numFilasAfectadas = 0;
         String sql = "INSERT INTO categoria(codigo_categoria, nombre, detalle)\n" +
                "    VALUES (?, ?, ?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getCodigo()));
        lstPar.add(new Parametro(2, categoria.getNombre()));
        lstPar.add(new Parametro(3, categoria.getDetalle()));
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
    public int modificar(Categoria categoria) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE categoria SET nombre=?, detalle=? WHERE codigo_categoria=?";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getNombre()));
        lstPar.add(new Parametro(2, categoria.getDetalle()));
        lstPar.add(new Parametro(3, categoria.getCodigo()));
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
    public int eliminar(Categoria categoria) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM categoria WHERE codigo_categoria=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getCodigo()));
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
    public Categoria obtener(int id) throws Exception {
        Categoria categoria = null;
        String sql = "SELECT codigo_categoria, nombre, detalle"
                + "  FROM categoria WHERE codigo_categoria=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                categoria = new Categoria();
                categoria.setCodigo(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDetalle(rst.getString(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return categoria;
    }

    @Override
    public List<Categoria> obtener() throws Exception {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT codigo_categoria, nombre, detalle"
                + "  FROM categoria";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Categoria categoria = new Categoria();
                categoria = new Categoria();
                categoria.setCodigo(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDetalle(rst.getString(3));
                lista.add(categoria);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

    @Override
    public int eliminar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

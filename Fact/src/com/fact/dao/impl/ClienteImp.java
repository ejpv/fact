
package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.ICliente;
import com.fact.dao.rnegocio.entidades.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteImp implements ICliente{

    @Override
    public int insertar(Cliente cliente) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO cliente(codigo_cliente, cedula, nombre, apellido, direccion, telefono,\"e-mail\", ruc)\n" 
                +"    VALUES (?, ?, ?, ?, ?, ?,?, ?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo()));
        lstPar.add(new Parametro(2, cliente.getCedula()));
        lstPar.add(new Parametro(3, cliente.getNombre()));
        lstPar.add(new Parametro(4, cliente.getApellido()));
        lstPar.add(new Parametro(5, cliente.getDireccion()));
        lstPar.add(new Parametro(6, cliente.getTelefono()));
        lstPar.add(new Parametro(7, cliente.getEmail()));
        lstPar.add(new Parametro(8, cliente.getRuc()));
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
    public int modificar(Cliente cliente) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente SET cedula=?, nombre=?, apellido=?, direccion=?, telefono=?, \"e-mail\"=?, ruc=? WHERE codigo_cliente=?";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getDireccion()));
        lstPar.add(new Parametro(5, cliente.getTelefono()));
        lstPar.add(new Parametro(6, cliente.getEmail()));
        lstPar.add(new Parametro(7, cliente.getRuc()));
        lstPar.add(new Parametro(8, cliente.getCodigo()));
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
    public int eliminar(Cliente cliente) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM cliente WHERE codigo_cliente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo()));
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
    public Cliente obtener(int id) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT codigo_cliente, cedula, nombre, apellido, direccion, telefono, \"e-mail\", ruc"
                + "  FROM cliente WHERE codigo_cliente=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setDireccion(rst.getString(5));
                cliente.setTelefono(rst.getString(6));
                cliente.setEmail(rst.getString(7));
                cliente.setRuc(rst.getString(8));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public Cliente obtenerCedula(String cedula) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT codigo_cliente, cedula, nombre, apellido, direccion, telefono, \"e-mail\", ruc"
                + "  FROM cliente WHERE cedula=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cedula));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setDireccion(rst.getString(5));
                cliente.setTelefono(rst.getString(6));
                cliente.setEmail(rst.getString(7));
                cliente.setRuc(rst.getString(8));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT codigo_cliente, cedula, nombre, apellido, direccion, telefono, \"e-mail\", ruc"
                + "  FROM cliente";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Cliente cliente = new Cliente();
                cliente = new Cliente();
                cliente.setCodigo(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setDireccion(rst.getString(5));
                cliente.setTelefono(rst.getString(6));
                cliente.setEmail(rst.getString(7));
                cliente.setRuc(rst.getString(8));
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        lista.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente cliente1, Cliente cliente2) {
                return new Integer(cliente1.getCodigo()).compareTo(cliente2.getCodigo());
            }
        });
        return lista;
    }
    
}

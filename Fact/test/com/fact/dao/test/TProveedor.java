/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.IProveedor;
import com.fact.dao.impl.ProveedorImp;
import com.fact.dao.rnegocio.entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer1
 */
public class TProveedor {
    
    public TProveedor() {
    }
    @Test
    public void test(){
        IProveedor sqlProovedor= new ProveedorImp();
        Proveedor proveedor= new Proveedor(10, "ASD", "FGH", "0990587623", "asdft@hotmail.com");
    //INSERTAR
    int insertado=0;
        try {
            insertado= sqlProovedor.insertar(proveedor);
        } catch (Exception e) {
        }
        assertTrue(insertado>0);
    //LISTAR UNO
    Proveedor obtenido=null;
        try {
            obtenido= sqlProovedor.obtener(10);
            System.out.println(obtenido.getCodigo());
            System.out.println(obtenido.getNombre()+ "   " + obtenido.getDireccion());
        } catch (Exception e) {
        }
        assertTrue(obtenido !=null);
    //MODIFICAR
    int modificado=0;
    proveedor.setDireccion("jahsdjahsd");
        try {
            modificado=sqlProovedor.modificar(proveedor);
        } catch (Exception e) {
        }
        assertTrue(modificado>0);
    //LISTAR TODOS
        List<Proveedor> lst = new ArrayList<>();
        try {
            lst=sqlProovedor.obtener();
                for (Proveedor tmp : lst) {
                System.out.println(tmp.getCodigo());
                System.out.println(tmp.getNombre()+ "   " + tmp.getDireccion());
            }
        } catch (Exception e) {
        }
        assertTrue(lst.size() > 0);
    //ELIMINAR
    int eliminado=0;
        try {
            eliminado= sqlProovedor.eliminar(proveedor);
        } catch (Exception e) {
        }
        assertTrue(eliminado>0);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.pruebas;

import com.fact.dao.contrato.*;
import com.fact.dao.impl.*;
import com.fact.dao.rnegocio.entidades.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class TProveedor {
    public static void main(String[] args) {
        int codigo=1000;
        IProveedor dao= new ProveedorImp();
        
        //Insertar
//        Proveedor proveedor=new Proveedor(codigo, "Autos", "Quito", "0987986754", "ait@gmail.ec");
//        int insertar=0;
//        try{
//            insertar=dao.insertar(proveedor);
//        }catch(Exception e){
//            System.out.println("Error al Insertar");
//        }
        
        //Modificar
//        int modificar=0;
//        Proveedor proveedor=new Proveedor();
//        proveedor.setCodigo(codigo);
//        proveedor.setNombre("Lujos");
//        proveedor.setDireccion("Ambato");
//        proveedor.setTelefono("0000000000");
//        proveedor.setEmail("Ninguno");
//        try{
//            modificar=dao.modificar(proveedor);
//        }catch(Exception e){
//            System.out.println("Error al modificar");            
//        }
        
        //Eliminar
//        int eliminado=0;
//        Proveedor proveedor=new Proveedor();
//        proveedor.setCodigo(codigo);
//        try{
//            eliminado=dao.eliminar(proveedor);
//        }catch(Exception e){
//            System.out.println("Error al Eliminar");
//        }
        
        //Obtener
//        Proveedor obtenida=null;
//        try{
//            obtenida=dao.obtener(codigo);
//            System.out.println(obtenida.getCodigo());
//            System.out.println(obtenida.getNombre());
//            System.out.println(obtenida.getEmail());
//        }catch(Exception e){
//            System.out.println("Error al Obtener");
//        }
        
        //Obtener Lista
        List<Proveedor> lista=new ArrayList<>();
        try {
            lista=dao.obtener();
            for(Proveedor lst:lista){
                System.out.println(lst.getCodigo());
                System.out.println(lst.getNombre());
                System.out.println(lst.getTelefono());
            }
        } catch (Exception e) {
            System.err.println("Error al obtener lista Categoria");
        }
    }
    
}

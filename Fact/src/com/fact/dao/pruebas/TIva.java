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
public class TIva {
    public static void main(String[] args) {
        int codigo=1000;
        IIva dao= new IvaImp();
        
        //Insertar
//        Iva iva=new Iva(codigo, "12%", 0.12);
//        int insertar=0;
//        try{
//            insertar=dao.insertar(iva);
//        }catch(Exception e){
//            System.out.println("Error al Insertar");
//        }
        
        //Modificar
//        int modificar=0;
//        Iva iva=new Iva();
//        iva.setCodigo(codigo);
//        iva.setNombre("14%");
//        iva.setPrecio(0.14);
//        try{
//            modificar=dao.modificar(iva);
//        }catch(Exception e){
//            System.out.println("Error al modificar");            
//        }
        
        //Eliminar
//        int eliminado=0;
//        Iva iva=new Iva();
//        iva.setCodigo(codigo);
//        try{
//            eliminado=dao.eliminar(iva);
//        }catch(Exception e){
//            System.out.println("Error al Eliminar");
//        }
        
        //Obtener
//        Iva obtenida=null;
//        try{
//            obtenida=dao.obtener(codigo);
//            System.out.println(obtenida.getCodigo());
//            System.out.println(obtenida.getNombre());
//            System.out.println(obtenida.getPrecio());
//        }catch(Exception e){
//            System.out.println("Error al Obtener");
//        }
        
        //Obtener Lista
        List<Iva> lista=new ArrayList<>();
        try {
            lista=dao.obtener();
            for(Iva lst:lista){
                System.out.println(lst.getCodigo());
                System.out.println(lst.getNombre());
                System.out.println(lst.getPrecio());
            }
        } catch (Exception e) {
            System.err.println("Error al obtener lista Categoria");
        }
    }
    
}

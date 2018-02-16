/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.test;

import com.fact.dao.contrato.ICategoria;
import com.fact.dao.impl.CategoriaImp;
import com.fact.dao.rnegocio.entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer1
 */
public class TCategoria {
    
    public TCategoria() {
    }
    @Test
    public void test(){
        ICategoria sqlCategoria = new CategoriaImp();
        Categoria categoria = new Categoria(1000, "Pablito", "Metal");
    //INSERTAR
        int insertado=0;
        try {
            insertado= sqlCategoria.insertar(categoria);
        } catch (Exception e) {
        }
        assertTrue(insertado > 0);
    //LISTAR UNO
    Categoria cat = null;
        try {
            cat=sqlCategoria.obtener(1000);
        } catch (Exception e) {
        }
        assertTrue(cat!=null);
    //MODIFICAR
    int modificado=0;
        try {
            categoria.setNombre("clavito");
            modificado=sqlCategoria.modificar(categoria);
        } catch (Exception e) {
        }
        assertTrue(modificado>0);
    //LISTAR TODOS
        List<Categoria> lst = new ArrayList();
        try {
            lst=sqlCategoria.obtener();
        } catch (Exception e) {
        }
   assertTrue(lst.size() > 0);
    //ELIMINAR
    int eliminado=0;
        try {
            eliminado=sqlCategoria.eliminar(categoria);
        } catch (Exception e) {
        }
        assertTrue(eliminado>0);
    }

}

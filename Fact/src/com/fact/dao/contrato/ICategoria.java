/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.*;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public interface ICategoria {
    int insertar(Categoria categoria);
    int modificar(Categoria categoria);
    int eliminar(Categoria categoria);
    Categoria obtener(int id)throws Exception;
    List<Categoria> obtener()throws Exception;

    public int eliminar(int codigo);
    
}

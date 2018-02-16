/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.ProductoProveedor;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public interface IProductoProveedor {
    int insertar(ProductoProveedor productoProveedor);
    int modificar(ProductoProveedor productoProveedor);
    int eliminar(ProductoProveedor productoProveedor);
    ProductoProveedor obtener(int id)throws Exception;
    List<ProductoProveedor> obtener()throws Exception;
    
}

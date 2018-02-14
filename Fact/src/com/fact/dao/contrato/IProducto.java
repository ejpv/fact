
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.Producto;
import java.util.List;


public interface IProducto {
    int insertar(Producto producto);
    int modificar(Producto producto);
    int eliminar(Producto producto);
    Producto obtener(int id)throws Exception;
    List<Producto> obtener()throws Exception;
    
}

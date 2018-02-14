
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.Proveedor;
import java.util.List;

public interface IProveedor {
    int insertar(Proveedor proveedor);
    int modificar(Proveedor proveedor);
    int eliminar(Proveedor proveedor);
    Proveedor obtener(int id)throws Exception;
    List<Proveedor> obtener()throws Exception;
    
}

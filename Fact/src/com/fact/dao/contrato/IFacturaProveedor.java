
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.FacturaProveedor;
import java.util.List;

public interface IFacturaProveedor {
    int  insertar(FacturaProveedor facturaProveedor);
    int modificar(FacturaProveedor facturaProveedor);
    int eliminar(FacturaProveedor facturaProveedor);
    FacturaProveedor obtener(int id)throws Exception;
    List<FacturaProveedor> obtener()throws Exception;
    
}

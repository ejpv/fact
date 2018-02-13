
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.DetalleFacturaProveedor;
import java.util.List;

public interface IDetalleFacturaProveedor {
    int  insertar(DetalleFacturaProveedor detalleFacturaProveedor);
    int modificar(DetalleFacturaProveedor detalleFacturaProveedor);
    int eliminar(DetalleFacturaProveedor detalleFacturaProveedor);
    DetalleFacturaProveedor obtener(int id)throws Exception;
    List<DetalleFacturaProveedor> obtener()throws Exception;
    
}

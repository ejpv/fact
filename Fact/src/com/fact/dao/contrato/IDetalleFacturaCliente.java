
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.*;
import java.util.List;


public interface IDetalleFacturaCliente {
    int  insertar(DetalleFacturaCliente detalleFacturaCliente);
    int modificar(DetalleFacturaCliente detalleFacturaCliente);
    int eliminar(DetalleFacturaCliente detalleFacturaCliente);
    DetalleFacturaCliente obtener(int id)throws Exception;
    List<DetalleFacturaCliente> obtener()throws Exception;
    
}

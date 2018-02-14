
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.FacturaCliente;
import java.util.List;

public interface IFacturaCliente {
    int insertar(FacturaCliente facturaCliente);
    int modificar(FacturaCliente facturaCliente);
    int eliminar(FacturaCliente facturaCliente);
    FacturaCliente obtener(int id)throws Exception;
    List<FacturaCliente> obtener()throws Exception;
    
}

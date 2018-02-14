
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.*;
import java.util.List;

public interface ICliente {
    int insertar(Cliente cliente);
    int modificar(Cliente cliente);
    int eliminar(Cliente cliente);
    Cliente obtener(int id)throws Exception;
    Cliente obtenerCedula(String cedula)throws Exception;
    List<Cliente> obtener()throws Exception;
    
}

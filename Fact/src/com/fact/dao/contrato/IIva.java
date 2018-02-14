
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.Iva;
import java.util.List;

public interface IIva {
    int insertar(Iva iva);
    int modificar(Iva iva);
    int eliminar(Iva iva);
    Iva obtener(int id)throws Exception;
    List<Iva> obtener()throws Exception;
}

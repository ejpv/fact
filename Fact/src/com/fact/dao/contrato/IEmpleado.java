/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.contrato;

import com.fact.dao.rnegocio.entidades.Empleado;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public interface IEmpleado {
    int insertar(Empleado empleado);
    int modificar(Empleado empleado);
    int eliminar(Empleado empleado);
    Empleado obtener(int id)throws Exception;
    Empleado obtenerCedula(String cedula)throws Exception;
    Empleado obtener(String usuario, String contraseña)throws Exception;
    List<Empleado> obtener()throws Exception;
    
}

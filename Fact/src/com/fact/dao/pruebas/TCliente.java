
package com.fact.dao.pruebas;

import com.fact.dao.contrato.ICliente;
import com.fact.dao.impl.ClienteImp;
import com.fact.dao.rnegocio.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class TCliente {
    public static void main(String[] args) {
        //INSERTAR
        int codigo=1000;
        String cedula = "180492150-8";
//        ICliente dao=new ClienteImp();
//        Cliente cliente=new Cliente(codigo, "185003040-9", "Nancy Noemi", "Sisa Sisa", "Ambato", "0987658753", "nancy@gmail.com",null);
//        int insertar=0;
//        try{
//            insertar=dao.insertar(cliente);
//        }catch(Exception e){
//            System.out.println("Error al Insertar");
//        }
        
        
        //MODIFICAR
//        int modificados = 0;                
//        ICliente dao=new ClienteImp();
//        Cliente cliente=new Cliente();
//        cliente.setCodigo(codigo);
//        cliente.setCedula("060505063-4");
//        cliente.setNombre("Juan");
//        cliente.setApellido("Sisa");
//        cliente.setDireccion("032960750");
//        cliente.setTelefono("0329607507");
//        cliente.setEmail("032960750");
//        cliente.setRuc("032960750");
//        try {
//            modificados = dao.modificar(cliente);
//        } catch (Exception e) {
//            System.out.println("Error al Modificar");
//        }

        //Eliminar
//        int eliminados = 0;
//        ICliente dao=new ClienteImp();
//        Cliente cliente=new Cliente();
//        cliente.setCodigo(codigo);
//        try {
//            eliminados = dao.eliminar(cliente);
//        } catch (Exception e) {
//            System.out.println("Error al eliminar");
//        }
        
        //Obtener
//        Cliente obtenida = null;
//        ICliente dao=new ClienteImp();
//        try {
//            obtenida = dao.obtener(codigo);
//            System.out.println(obtenida.getCodigo());
//            System.out.println(obtenida.getCedula());
//            System.out.println(obtenida.getNombre());
//            System.out.println(obtenida.getApellido());
//        } catch (Exception e) {
//            System.out.println("Error al obtener");
//        }
        
        //Obtener Lista 
//        ICliente dao=new ClienteImp();
//        List<Cliente> lista = new ArrayList<>();
//        try {
//            lista = dao.obtener();
//            for(Cliente est:lista){
//                System.out.println(est.getCedula());
//            }
//        } catch (Exception e) {
//            System.out.println("Error al Listar");
//        }
        
        //Obtener Cedula
        Cliente obtenida = null;
        ICliente dao=new ClienteImp();
        try {
            obtenida = dao.obtenerCedula(cedula);
            System.out.println(obtenida.getCodigo());
            System.out.println(obtenida.getCedula());
            System.out.println(obtenida.getNombre());
            System.out.println(obtenida.getApellido());
        } catch (Exception e) {
            System.out.println("Error al obtener");
        }
    }
    
}

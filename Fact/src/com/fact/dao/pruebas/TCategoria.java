
package com.fact.dao.pruebas;

import com.fact.dao.contrato.ICategoria;
import com.fact.dao.impl.CategoriaImp;
import com.fact.dao.rnegocio.entidades.Categoria;
import java.util.ArrayList;
import java.util.List;

public class TCategoria {
    public static void main(String[] args) {
        int codigo=1000;
        ICategoria dao= new CategoriaImp();
        
        //Insertar
//        Categoria categoria=new Categoria(codigo, "Adorno", "Adorno para autos de diferentes figuras");
//        int insertar=0;
//        try{
//            insertar=dao.insertar(categoria);
//        }catch(Exception e){
//            System.out.println("Error al Insertar");
//        }
        
        //Modificar
//        int modificar=0;
//        Categoria categoria=new Categoria();
//        categoria.setCodigo(codigo);
//        categoria.setNombre("Repuesto");
//        categoria.setDetalle("Metal Inocsidable");
//        try{
//            modificar=dao.modificar(categoria);
//        }catch(Exception e){
//            System.out.println("Error al modificar");            
//        }
        
        //Eliminar
//        int eliminado=0;
//        Categoria categoria=new Categoria();
//        categoria.setCodigo(codigo);
//        try{
//            eliminado=dao.eliminar(categoria);
//        }catch(Exception e){
//            System.out.println("Error al Eliminar");
//        }
        
        //Obtener
//        Categoria obtenida=null;
//        try{
//            obtenida=dao.obtener(codigo);
//            System.out.println(obtenida.getCodigo());
//            System.out.println(obtenida.getNombre());
//            System.out.println(obtenida.getDetalle());
//        }catch(Exception e){
//            System.out.println("Error al Obtener");
//        }
        
        //Obtener Lista
        List<Categoria> lista=new ArrayList<>();
        try {
            lista=dao.obtener();
            for(Categoria lst:lista){
                System.out.println(lst.getCodigo());
                System.out.println(lst.getNombre());
                System.out.println(lst.getDetalle());
            }
        } catch (Exception e) {
            System.err.println("Error al obtener lista Categoria");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.rnegocio.entidades.Empleado;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author acer1
 */
public class frmPrincipal{

    static AnchorPane root;
    static BorderPane contenedor;
    static Notificacion Mensaje = new Notificacion();
    private static Stage stage;
    static frmCliente cliente = new frmCliente();
    

    public void start(Empleado emp) throws Exception {
        contenedor = new BorderPane();
        contenedor.setTop(panelSuperior());
        AnchorPane.setTopAnchor(contenedor, 0.0);
        AnchorPane.setRightAnchor(contenedor, 0.0);
        AnchorPane.setBottomAnchor(contenedor, 0.0);
        AnchorPane.setLeftAnchor(contenedor, 0.0);
        
        root = new AnchorPane();
        Mensaje.successful("Bienvenido "+emp.getNombre());
        Mensaje.getStylesheets().addAll(this.getClass().getResource("estilos/Notificacion.css").toExternalForm());
        Mensaje.toFront();
        root.getChildren().addAll(contenedor,Mensaje);
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().addAll(this.getClass().getResource("estilos/Principal.css").toExternalForm());
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("FACT");
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResource("img/Icono.png").toExternalForm()));
        stage.show();
    }

    private static HBox panelSuperior() {
        HBox panel = new HBox(15);
        {
            JFXButton btnCliente = new JFXButton("Clientes");
            btnCliente.setOnAction(btnClienteActionListener());
            JFXButton btnEmpleado = new JFXButton("Empleados");
            //btnEmpleado.setOnAction(btnEmpleadoActionListener());
            JFXButton btnProducto = new JFXButton("Productos");
            //btnProducto.setOnAction(btnProductoActionListener());
            JFXButton btnFactura = new JFXButton("Factúra");
            //btnFactura.setOnAction(btnfacturaActionListener());
            JFXButton btnCategoria = new JFXButton("Categoría");
            //btnCategoria.setOnAction(btnCategoriaActionListener());
            JFXButton btnReportes = new JFXButton("Reportes");
            //btnReportes.setOnAction(btnReportesActionListener());
            JFXButton btnIva = new JFXButton("Iva");
            JFXButton btnProveedor = new JFXButton("Proveedor");
            Button btnPerfil = new Button();
            btnPerfil.getStyleClass().add("boton");
            panel.getStyleClass().add("panelSuperior");
            panel.getChildren().addAll(btnFactura, btnCliente,btnProducto,btnCategoria,btnIva,btnProveedor,btnReportes,btnEmpleado,btnPerfil);
        }
        return panel;
    }

    /**
     * *************************************************************************
     *                                                                         *
     * IMPLEMENTACION DE LOS EVETOS * *
     * *************************************************************************
     */
    public static EventHandler btnClienteActionListener() {
        EventHandler handler = (t) -> {
            cliente.panelDerecho(root, contenedor);
            cliente.crearTabla(contenedor);
        };
        return handler;
    }

    /*public static EventHandler btnEmpleadoActionListener() {
        EventHandler handler = (t) -> {
            empleado.formDatos(root, contenedor);
            empleado.formTablas(contenedor);
        };
        return handler;
    }

    public static EventHandler btnfacturaActionListener() {
        EventHandler handler = (t) -> {
            IFactura sqlFactura = new FacturaImp();
            factura.formFacturacion(contenedor);
            factura.setEmpleado(cedulaEmpleado);
            try {
                factura.setNumeroFactura(sqlFactura.numero());
            } catch (Exception e) {
            }

            factura.formDatos(root, contenedor);

        };
        return handler;
    }

    public static EventHandler btnCategoriaActionListener() {
        EventHandler handler = (t) -> {
            categoria.formDatos(root, contenedor);
            categoria.formTablas(contenedor);
        };
        return handler;
    }

    public static EventHandler btnProductoActionListener() {
        EventHandler handler = (t) -> {
            producto.formDatos(root, contenedor);
            producto.formTablas(contenedor);
        };
        return handler;
    }
    private static EventHandler<ActionEvent> btnReportesActionListener(){
        EventHandler handler = (t) -> {
            try {
                frmReportes reportes = new frmReportes();
                reportes.formInsertar(root);
            } catch (Exception ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return handler;
    }*/
}
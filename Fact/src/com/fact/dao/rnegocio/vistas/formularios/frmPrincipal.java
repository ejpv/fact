/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas.formularios;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.plaf.synth.ColorType;

/**
 *
 * @author acer1
 */
public class frmPrincipal{

    static AnchorPane root;
    static BorderPane contenedor;
    private static Stage stage;
    static frmCliente cliente = new frmCliente();
    

    public void start() throws Exception {
        contenedor = new BorderPane();
        contenedor.setTop(panelSuperior());
        AnchorPane.setTopAnchor(contenedor, 0.0);
        AnchorPane.setRightAnchor(contenedor, 0.0);
        AnchorPane.setBottomAnchor(contenedor, 0.0);
        AnchorPane.setLeftAnchor(contenedor, 0.0);

        root = new AnchorPane();
        root.getChildren().add(contenedor);
        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().addAll(this.getClass().getResource("estilos/Principal.css").toExternalForm());
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("FACT");
        stage.getIcons().add(new Image(getClass().getResource("../img/Icono.png").toExternalForm()));
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
            panel.getStyleClass().add("panelSuperior");
            panel.getChildren().addAll(btnFactura, btnCliente,btnProducto,btnCategoria,btnReportes,btnEmpleado);
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
            System.out.println("Cliente");
            cliente.panelDerecho(root, contenedor);
//            cliente.formTablas(contenedor);
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
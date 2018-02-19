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
public class frmPrincipal extends Application {

    private BorderPane root;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root(), 950, 650);
        stage.setMinWidth(950);
        stage.setMinHeight(650);

        stage.setTitle("Fact");
        stage.setScene(scene);
        stage.show();
    }

    public BorderPane root() {
        root = new BorderPane();
        root.setTop(menuBar());
        root.setCenter(componentsBar());
//        root.setTop(componentsBar());
//        root.setLeft(componentsBar());
//        root.setRight(menuBar());
//        root.setLeft(menuBar());
        return root;
    }

    public MenuBar menuBar() {
        //MenuBar
        MenuBar MBar = new MenuBar();
        MBar.setStyle("-fx-base:rgb(10,20,25)");
        //Menu
        Menu menuCompra = new Menu("Factura");
        Menu menuVenta = new Menu("Usuarios");
        Menu menuReportes = new Menu("");
        //MenuItem
        MenuItem MIAgregar = new MenuItem("Crear Factura");
        MenuItem MIEliminar = new MenuItem("-Eliminar");
        MenuItem MIModificar = new MenuItem(".-Modificar");
        //Agregar Item al Menu
//        menuCompra.getItems().add(MIAgregar);
//        menuCompra.getItems().add(MIEliminar);
//        menuCompra.getItems().add(MIModificar);
//        menuVenta.getItems().add(MIAgregar);
//        menuVenta.getItems().add(MIEliminar);
//        menuVenta.getItems().add(MIModificar);
//        menuReportes.getItems().add(MIAgregar);
//        menuReportes.getItems().add(MIEliminar);
//        menuReportes.getItems().add(MIModificar);

        //Agregar el Menu al Menu Bar
        MBar.getMenus().add(menuCompra);
        MBar.getMenus().add(menuVenta);
        MBar.getMenus().add(menuReportes);
        return MBar;
    }

    public Pane componentsBar() {
        StackPane componentsPanel = new StackPane();
        componentsPanel.setStyle("-fx-background-color:rgb(10,20,50)");
        JFXButton btnEmployee = new JFXButton("Empleado"); btnEmployee.setStyle("-fx-text-fill:RGB(255,255,255)");
        JFXButton btnFactura = new JFXButton("Factúra"); btnFactura.setStyle("-fx-text-fill:RGB(255,255,255)");
        JFXButton btnProducto = new JFXButton("Productos");btnProducto.setStyle("-fx-text-fill:RGB(255,255,255)");
        JFXButton btnCliente = new JFXButton("Cliente");btnCliente.setStyle("-fx-text-fill:RGB(255,255,255)");
        GridPane panel = new GridPane();
        panel.setMaxWidth(400);
        panel.setMaxHeight(100);
        panel.setStyle("-fx-background-color:Red");
        panel.addRow(1, btnCliente);
        panel.addRow(1, btnEmployee);
        panel.addRow(2, btnFactura);
        panel.addRow(2, btnProducto);
        
        //panel.getChildren().addAll(btnCliente,btnEmployee,btnFactura,btnProducto);
        //panel.setAlignment(Pos.CENTER);
        componentsPanel.getChildren().addAll(panel);
        //StackPane.setAlignment(componentsPanel, Pos.CENTER);

        //btnEmployee.setOnAction(RootController.showEmployee(root));
        /*btnFactura.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!");
                alert.setHeaderText(null);
                alert.initStyle(StageStyle.UNDECORATED);
                alert.setContentText("Algo ha salido mal con los datos de la factura!");

                alert.showAndWait();
            }
        });*/
//        btnCliente.setOnAction(RootController.mostrarCliente(root));
//        btnProducto.setOnAction(RootController.mostrarProducto(root));
        return componentsPanel;
    }
}

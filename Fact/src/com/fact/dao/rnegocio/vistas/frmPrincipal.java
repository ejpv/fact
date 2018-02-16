/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author acer1
 */
public class frmPrincipal extends Application{
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
        root.setRight(menuBar());
        root.setLeft(menuBar());
        return root;
    }
    
      public MenuBar menuBar() {
        MenuBar MBar = new MenuBar();
        Menu menuComponentes = new Menu("MENU BAR");
        MenuItem MIPrueba = new MenuItem("-MENU ITEM");
        MenuItem MIPrueba2 = new MenuItem("-MENU ITEM 2");
        MenuItem MIPrueba3 = new MenuItem("-MENU ITEM 3");
        menuComponentes.getItems().add(MIPrueba);
        menuComponentes.getItems().add(MIPrueba2);
        menuComponentes.getItems().add(MIPrueba3);
        MBar.getMenus().add(menuComponentes);
        return MBar;
    }

    public Pane componentsBar() {
        VBox componentsPanel = new VBox(10);
        componentsPanel.setStyle("-fx-background-color:rgb(0,92,150)");
/*      JFXButton btnCliente = new JFXButton("Cliente");
        JFXButton btnEmployee = new JFXButton("Empleado");
        JFXButton btnFactuta = new JFXButton("Factúra");
        JFXButton btnProducto = new JFXButton("Productos");
         componentsPanel.getChildren().addAll(btnCliente, btnEmployee,btnProducto, btnFactuta);
        VBox.setVgrow(componentsPanel, Priority.ALWAYS);

        btnEmployee.setOnAction(RootController.showEmployee(root));
        btnFactuta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!");
                alert.setHeaderText(null);
                alert.initStyle(StageStyle.UNDECORATED);
                alert.setContentText("Algo ha salido mal con los datos de la factura!");

                alert.showAndWait();
            }
        });
        btnCliente.setOnAction(RootController.mostrarCliente(root));
        btnProducto.setOnAction(RootController.mostrarProducto(root));
*/
        return componentsPanel;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
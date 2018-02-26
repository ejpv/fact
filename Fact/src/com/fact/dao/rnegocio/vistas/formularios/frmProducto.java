/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.IProducto;
import com.fact.dao.impl.ProductoImp;
import com.fact.dao.rnegocio.entidades.Categoria;
import com.fact.dao.rnegocio.entidades.Producto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class frmProducto {
    private static Categoria categoria=new Categoria();
    private static Producto producto = new Producto();
    private static TableView<Producto> tabla;
    private static JFXButton btnModificar = new JFXButton("Modificar");
    private static JFXButton btnEliminar = new JFXButton("Eliminar");
    static frmPrincipal principal = new frmPrincipal();
    private static Label lblITitulo;

    public void panelDerecho(AnchorPane root, BorderPane layout) {
        VBox contenedor = new VBox(10);
        //Titutlo
        Label lblTitle = new Label("PRODUCTOS");//Titulo de la Ventana Label de (javafx.scene.control.Label)
        lblTitle.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
        lblTitle.setAlignment(Pos.BOTTOM_CENTER);
        lblTitle.setMinHeight(50);
        //Imagen
        ImageView ivCheck = new ImageView();
        ivCheck.setFitHeight(25);
        ivCheck.setFitWidth(25);
        ivCheck.setLayoutY(175);
        AnchorPane.setRightAnchor(ivCheck, 25.0);
        //Botones
        VBox boxButtons = new VBox(10);
        JFXButton btnNuevo = new JFXButton("Nuevo");
        btnNuevo.setOnAction((t) -> {
//            formInsertar(root, layout);
        });
        btnModificar.setOnAction((t) -> {
//            formModificar(root, layout);
        });
        btnModificar.setDisable(true);
        btnEliminar.setOnAction((t) -> {
//            formEliminar(root, layout);
        });
        btnEliminar.setDisable(true);
        JFXButton btnBuscar = new JFXButton("Buscar");
        btnBuscar.setOnAction((t) -> {
//            formBuscar(root, layout);
        });

        //Contenedor de Botones
        boxButtons.getChildren().addAll(btnBuscar, btnNuevo, btnModificar, btnEliminar);
        boxButtons.setStyle("-fx-background-color:rgb(0,92,150);-fx-padding:5");
        boxButtons.setAlignment(Pos.CENTER);
        boxButtons.setSpacing(30);
        boxButtons.getStyleClass().add("box");
        VBox.setVgrow(boxButtons, Priority.ALWAYS);
        boxButtons.getStylesheets().addAll(this.getClass().getResource("estilos/Cliente.css").toExternalForm());

        //Contenedor de Botones y Label
        VBox cntTitle = new VBox();
        cntTitle.getChildren().addAll(lblTitle, ivCheck, boxButtons);
        cntTitle.setStyle("-fx-background-color:rgb(0,92,150);-fx-padding:5");
        cntTitle.setAlignment(Pos.CENTER);
        VBox.setVgrow(cntTitle, Priority.ALWAYS);

        //Agregado el de arriba al escenario
        contenedor.setStyle("-fx-background-color:white");
        contenedor.getChildren().addAll(cntTitle);
        contenedor.setMinWidth(200);
        layout.setRight(contenedor);
    }

    public void crearTabla(BorderPane contenedor) {
        contenedor.setCenter(Tabla());
    }

    public void cargarTablas() {
        TableView<Producto> tabla = Tabla();
        AnchorPane root = new AnchorPane(tabla);
        AnchorPane.setTopAnchor(tabla, 0.0);
        AnchorPane.setBottomAnchor(tabla, 0.0);
        AnchorPane.setRightAnchor(tabla, 0.0);
        AnchorPane.setLeftAnchor(tabla, 0.0);

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Productos");
        stage.show();
    }

    private static TableView<Producto> Tabla() {
        tabla = new TableView<Producto>();
        //Coidgo
        TableColumn<Producto, String> colCodigo = new TableColumn<>("Codigo");
        colCodigo.setMinWidth(100);
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        //Nombre
        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setMinWidth(100);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        //Color
        TableColumn<Producto, String> colColor = new TableColumn<>("Color");
        colColor.setMinWidth(100);
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));

        //Marca
        TableColumn<Producto, String> colMarca = new TableColumn<>("Marca");
        colMarca.setMinWidth(100);
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        //Tamaño
        TableColumn<Producto, String> colTamaño = new TableColumn<>("Tamaño");
        colTamaño.setMinWidth(100);
        colTamaño.setCellValueFactory(new PropertyValueFactory<>("tamaño"));

        //Aroma
        TableColumn<Producto, String> colAroma = new TableColumn<>("Aroma");
        colAroma.setMinWidth(100);
        colAroma.setCellValueFactory(new PropertyValueFactory<>("aroma"));

        //Fecha de Caducidad
        TableColumn<Producto, String> colFechaCaducidad = new TableColumn<>("Fecha de Caducidad");
        colFechaCaducidad.setMinWidth(100);
        colFechaCaducidad.setCellValueFactory(new PropertyValueFactory<>("fecha de caducidad"));

        //Categoria
        TableColumn<Producto, String> colCategoria = new TableColumn<>("Categoria");
        colCategoria.setMinWidth(100);
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        //Precio Venta
        TableColumn<Producto, String> colPrecioVenta = new TableColumn<>("Precio Venta");
        colPrecioVenta.setMinWidth(100);
        colPrecioVenta.setCellValueFactory(new PropertyValueFactory<>("precio venta"));

        //Precio Venta Cantidad
        TableColumn<Producto, String> colPrecioVentaCantidad = new TableColumn<>("Precio Venta por Cantidad");
        colPrecioVentaCantidad.setMinWidth(100);
        colPrecioVentaCantidad.setCellValueFactory(new PropertyValueFactory<>("precio venta por cantidad"));

        //Stock Cantidad
        TableColumn<Producto, String> colStockCantidad = new TableColumn<>("Stock Cantidad");
        colStockCantidad.setMinWidth(100);
        colStockCantidad.setCellValueFactory(new PropertyValueFactory<>("stock cantidad"));

        //Stock 
        TableColumn<Producto, String> colStock = new TableColumn<>("Stock");
        colStock.setMinWidth(100);
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        //Precio Total
        TableColumn<Producto, String> colPrecioTotal = new TableColumn<>("Precio Total");
        colPrecioTotal.setMinWidth(100);
        colPrecioTotal.setCellValueFactory(new PropertyValueFactory<>("precio total"));

        //Detalle
        TableColumn<Producto, String> colDetalle = new TableColumn<>("Detalle");
        colDetalle.setMinWidth(100);
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));

        tabla.setItems(getProducto());
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tabla.getColumns().addAll(colCodigo, colNombre, colColor, colMarca, colTamaño, colAroma, colFechaCaducidad, colCategoria, colPrecioVenta, colPrecioVentaCantidad, colStockCantidad, colStock, colPrecioTotal, colDetalle);
        tabla.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event t) {
                producto = tabla.getSelectionModel().getSelectedItem();
                btnModificar.setDisable(false);
                btnEliminar.setDisable(false);
            }
        });
        return tabla;
    }

    private static ObservableList<Producto> getProducto() {
        ObservableList<Producto> lst = FXCollections.observableArrayList();
        IProducto sqlProducto = new ProductoImp();
        try {
            List<Producto> productos = sqlProducto.obtener();
            if (productos.size() > 0) {
                productos.forEach((tmp) -> {
                    lst.add(tmp);
                });
            }
        } catch (Exception e) {
            principal.Mensaje.failed("No se pudo Obtener Productos");

        }
        return lst;
    }
}

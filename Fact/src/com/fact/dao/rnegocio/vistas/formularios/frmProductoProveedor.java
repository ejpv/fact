package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.IProductoProveedor;
import com.fact.dao.impl.ProductoProveedorImp;
import com.fact.dao.rnegocio.entidades.Categoria;
import com.fact.dao.rnegocio.entidades.Producto;
import com.fact.dao.rnegocio.entidades.ProductoProveedor;
import com.fact.dao.rnegocio.entidades.Proveedor;
import com.jfoenix.controls.JFXButton;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class frmProductoProveedor {
    private static ProductoProveedor productoproveedor = new ProductoProveedor();
    private static TableView<ProductoProveedor> tabla;
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
        boxButtons.getStylesheets().addAll(this.getClass().getResource("estilos/Producto.css").toExternalForm());

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
        TableView<ProductoProveedor> tabla = Tabla();
        AnchorPane root = new AnchorPane(tabla);
        AnchorPane.setTopAnchor(tabla, 0.0);
        AnchorPane.setBottomAnchor(tabla, 0.0);
        AnchorPane.setRightAnchor(tabla, 0.0);
        AnchorPane.setLeftAnchor(tabla, 0.0);

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Pedidos");
        stage.show();
    }
    
    private static TableView<ProductoProveedor> Tabla() {
        tabla = new TableView<>();

        //Producto
        TableColumn<ProductoProveedor, Producto> colProducto = new TableColumn<>("Producto");
        colProducto.setMinWidth(100);
        colProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));

        //Proveedor
        TableColumn<ProductoProveedor, Proveedor> colProveedor = new TableColumn<>("Proveedor");
        colProveedor.setMinWidth(100);
        colProveedor.setCellValueFactory(new PropertyValueFactory<>("proveedor"));

        //Precio
        TableColumn<ProductoProveedor, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setMinWidth(100);
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        //Cantidad
        TableColumn<ProductoProveedor, Double> colCantidad = new TableColumn<>("Cantidad");
        colCantidad.setMinWidth(100);
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        //Total
        TableColumn<ProductoProveedor, Double> colTotal = new TableColumn<>("Total");
        colTotal.setMinWidth(100);
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        //Total
        TableColumn<ProductoProveedor, String> colDetalle = new TableColumn<>("Detalle");
        colDetalle.setMinWidth(100);
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));
        
        //Fecha
        TableColumn<ProductoProveedor, String> colFecha = new TableColumn<>("Fecha");
        colFecha.setMinWidth(100);
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        tabla.setItems(getProductoProveedor());
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tabla.getColumns().addAll(colProducto, colProveedor, colPrecio, colCantidad, colTotal, colDetalle, colFecha);
        tabla.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event t) {
                productoproveedor = tabla.getSelectionModel().getSelectedItem();
                btnModificar.setDisable(false);
                btnEliminar.setDisable(false);
            }
        });
        return tabla;
    }
    
    private static ObservableList<ProductoProveedor> getProductoProveedor() {
        ObservableList<ProductoProveedor> lst = FXCollections.observableArrayList();
        IProductoProveedor sqlProductoProveedor = new ProductoProveedorImp();
        try {
            List<ProductoProveedor> productoproveedores = sqlProductoProveedor.obtener();
            if (productoproveedores.size() > 0) {
                productoproveedores.forEach((tmp) -> {
                    lst.add(tmp);
                });
            }
        } catch (Exception e) {
            principal.Mensaje.failed("No se pudo Obtener Productos");

        }
        return lst;
    }

}

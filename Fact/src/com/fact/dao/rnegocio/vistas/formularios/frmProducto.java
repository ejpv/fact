/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.ICategoria;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.impl.CategoriaImp;
import com.fact.dao.impl.ProductoImp;
import com.fact.dao.rnegocio.entidades.Categoria;
import com.fact.dao.rnegocio.entidades.Producto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.Date;
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

    private JFXTextField tfNombre;
    private JFXComboBox<Categoria> cmbCategoria = new JFXComboBox<>();
    private JFXTextField tfPrecioVenta;
    private JFXTextField tfStock;
    private JFXTextField tfPrecioTotal;
    private JFXTextField tfDetalle;
    private static Categoria categoria = new Categoria();
    private static Producto producto = new Producto();
    private static TableView<Producto> tabla;
    private static JFXButton btnModificar = new JFXButton("Modificar");
    private static JFXButton btnEliminar = new JFXButton("Eliminar");
    static frmPrincipal principal = new frmPrincipal();
    private static Label lblITitulo;
    ICategoria DaoCategoria = new CategoriaImp();
    List<Categoria> listCategoria = new ArrayList<>();

    private void formInsertar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("INGRESAR PRODUCTO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfNombre = new JFXTextField();
                tfNombre.setPromptText("Nombre");
                tfNombre.setLabelFloat(true);
                try {
                    listCategoria = DaoCategoria.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbCategoria.setItems(FXCollections.observableArrayList(listCategoria));
                
                tfPrecioVenta = new JFXTextField();
                tfPrecioVenta.setPromptText("Precio Venta");
                tfPrecioVenta.setLabelFloat(true);

                tfStock = new JFXTextField();
                tfStock.setPromptText("Stock");
                tfStock.setLabelFloat(true);

                tfPrecioTotal = new JFXTextField();
                tfPrecioTotal.setPromptText("Precio Total");
                tfPrecioTotal.setLabelFloat(true);

                tfDetalle = new JFXTextField();
                tfDetalle.setPromptText("Detalle");
                tfDetalle.setLabelFloat(true);

                HBox ctnBotones = new HBox(15);
                {
                    JFXButton btnAceptar = new JFXButton("Aceptar");
                    btnAceptar.setDefaultButton(true);
                    btnAceptar.setOnAction(InsertarActionListener(root, fondo, panel));
                    JFXButton btnCancelar = new JFXButton("Cancelar");
                    btnCancelar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                    });
                    JFXButton btnLimpiar = new JFXButton("Limpiar");
                    btnLimpiar.setOnAction((t) -> {
                        tfNombre.setText("");
                        cmbCategoria.setPromptText("");
                        tfPrecioVenta.setText("");
                        tfStock.setText("");
                        tfPrecioTotal.setText("");
                        tfDetalle.setText("");
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnLimpiar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, tfNombre, cmbCategoria, tfPrecioVenta, tfStock, tfPrecioTotal, tfDetalle, ctnBotones);
                Contenedor.getStyleClass().add("panel");
                Contenedor.getStylesheets().addAll(this.getClass().getResource("estilos/Botones.css").toExternalForm());
                Contenedor.setPadding(new Insets(15));
                Contenedor.setStyle("-fx-background-color: rgb(10,20,50)");
                Contenedor.setMaxSize(400, 270);
            }
            fondo.setStyle("-fx-background-color:rgba(25,25,25,0.6)");
            AnchorPane.setBottomAnchor(fondo, 0.0);
            AnchorPane.setLeftAnchor(fondo, 0.0);
            AnchorPane.setTopAnchor(fondo, 0.0);
            AnchorPane.setRightAnchor(fondo, 0.0);
            fondo.getChildren().add(Contenedor);
        }
        root.getChildren().add(fondo);
    }

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
            formInsertar(root, layout);
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
        tabla = new TableView<>();
        //Codigo
        TableColumn<Producto, String> colCodigo = new TableColumn<>("Codigo");
        colCodigo.setMinWidth(100);
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        //Nombre
        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setMinWidth(100);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        //Categoria
        TableColumn<Producto, Categoria> colCategoria = new TableColumn<>("Categoría");
        colCategoria.setMinWidth(100);
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        //Precio Venta
        TableColumn<Producto, Double> colPrecioVenta = new TableColumn<>("Precio Venta");
        colPrecioVenta.setMinWidth(100);
        colPrecioVenta.setCellValueFactory(new PropertyValueFactory<>("precioventa"));

        //Stock 
        TableColumn<Producto, Double> colStock = new TableColumn<>("Stock");
        colStock.setMinWidth(100);
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        //Precio Total
        TableColumn<Producto, Double> colPrecioTotal = new TableColumn<>("Valor total Stock");
        colPrecioTotal.setMinWidth(100);
        colPrecioTotal.setCellValueFactory(new PropertyValueFactory<>("preciototalventa"));

        //Detalle
        TableColumn<Producto, String> colDetalle = new TableColumn<>("Detalle");
        colDetalle.setMinWidth(100);
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));

        tabla.setItems(getProducto());
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tabla.getColumns().addAll(colCodigo, colNombre, colCategoria, colPrecioVenta, colStock, colPrecioTotal, colDetalle);
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

    /**
     * *************************************************************************
     *                                                                         *
     * IMPLEMENTACION DE LOS EVETOS * *
     * *************************************************************************
     */
    
    private EventHandler InsertarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            IProducto sqlProducto = new ProductoImp();

            try {
                List<Producto> lst = new ArrayList<>();
                lst = sqlProducto.obtener();
                producto.setCodigo(lst.get(lst.size() - 1).getCodigo() + 1);
                producto.setNombre(tfNombre.getText());
                producto.setCategoria(cmbCategoria.getSelectionModel().getSelectedItem());
                producto.setPrecioventa(Double.parseDouble(tfPrecioVenta.getText()));
                producto.setStock(Double.parseDouble(tfStock.getText()));
                producto.setPreciototalventa(Double.parseDouble(tfPrecioTotal.getText()));
                producto.setDetalle(tfDetalle.getText());
                if (sqlProducto.insertar(producto) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Nuevo producto Ingresado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("Error al Ingresar Producto!");
            }
        };
        return handler;
    }
}

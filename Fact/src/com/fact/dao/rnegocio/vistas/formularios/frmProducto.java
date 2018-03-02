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

    private JFXTextField tfCategoria;
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
                cmbCategoria.setPromptText("Categoria");
                cmbCategoria.setLabelFloat(true);

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

    public void formModificar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("MODIFICAR PRODUCTO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfNombre = new JFXTextField(producto.getNombre());
                tfNombre.setPromptText("Nombre");
                tfNombre.setLabelFloat(true);

                cmbCategoria = new JFXComboBox<>();
                try {
                    listCategoria = DaoCategoria.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbCategoria.setItems(FXCollections.observableArrayList(listCategoria));
                cmbCategoria.setPromptText("Categoria");
                cmbCategoria.setLabelFloat(true);
                cmbCategoria.getSelectionModel().clearAndSelect(producto.getCategoria().getCodigo() - 1);

                tfPrecioVenta = new JFXTextField(String.valueOf(producto.getPrecioventa()));
                tfPrecioVenta.setPromptText("Precio Venta");
                tfPrecioVenta.setLabelFloat(true);

                tfStock = new JFXTextField(String.valueOf(producto.getStock()));
                tfStock.setPromptText("Stock");
                tfStock.setLabelFloat(true);

                tfPrecioTotal = new JFXTextField(String.valueOf(producto.getPreciototalventa()));
                tfPrecioTotal.setPromptText("Precio Total");
                tfPrecioTotal.setLabelFloat(true);

                tfDetalle = new JFXTextField(producto.getDetalle());
                tfDetalle.setPromptText("Precio Total");
                tfDetalle.setLabelFloat(true);

                HBox ctnBotones = new HBox(15);
                {
                    JFXButton btnAceptar = new JFXButton("Aceptar");
                    btnAceptar.setDefaultButton(true);
                    btnAceptar.setOnAction(ModificarActionListener(root, fondo, panel));
                    JFXButton btnCancelar = new JFXButton("Cancelar");
                    btnCancelar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnCancelar);
                    ctnBotones.setAlignment(Pos.CENTER);
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

    private void formEliminar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("ELIMINAR PRODUCTO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfNombre = new JFXTextField(producto.getNombre());
                tfNombre.setPromptText("Porcentaje");
                tfNombre.setLabelFloat(true);
                tfNombre.setDisable(true);

                cmbCategoria = new JFXComboBox<>();
                try {
                    listCategoria = DaoCategoria.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbCategoria.setItems(FXCollections.observableArrayList(listCategoria));
                cmbCategoria.setPromptText("Categoria");
                cmbCategoria.setLabelFloat(true);
                cmbCategoria.getSelectionModel().clearAndSelect(producto.getCategoria().getCodigo() - 1);

                tfPrecioVenta = new JFXTextField(String.valueOf(producto.getPrecioventa()));
                tfPrecioVenta.setPromptText("Precio Venta");
                tfPrecioVenta.setLabelFloat(true);

                tfStock = new JFXTextField(String.valueOf(producto.getStock()));
                tfStock.setPromptText("Stock");
                tfStock.setLabelFloat(true);

                tfPrecioTotal = new JFXTextField(String.valueOf(producto.getPreciototalventa()));
                tfPrecioTotal.setPromptText("Precio Total");
                tfPrecioTotal.setLabelFloat(true);

                tfDetalle = new JFXTextField(producto.getDetalle());
                tfDetalle.setPromptText("Precio Total");
                tfDetalle.setLabelFloat(true);

                HBox ctnBotones = new HBox(15);
                {
                    JFXButton btnAceptar = new JFXButton("Aceptar");
                    btnAceptar.setDefaultButton(true);
                    btnAceptar.setOnAction(EliminarActionListener(root, fondo, panel));
                    JFXButton btnCancelar = new JFXButton("Cancelar");
                    btnCancelar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnCancelar);
                    ctnBotones.setAlignment(Pos.CENTER);
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

    private void formBuscar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("BUSCAR PRODUCTO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.getChildren().add(lblITitulo);
                titulo.setAlignment(Pos.CENTER);

                HBox Pbuscador = new HBox();
                TextField buscador = new TextField();
                buscador.setPromptText("Escribe un Codigo...");
                buscador.getStyleClass().add("buscador");
                buscador.setMinWidth(260);
                buscador.setMinHeight(30);

                JFXButton btn = new JFXButton("Buscar");
                btn.setDefaultButton(true);
                Pbuscador.getChildren().addAll(buscador, btn);
                Pbuscador.setSpacing(10);

                tfNombre = new JFXTextField();
                tfNombre.setPromptText("Nombre");
                tfNombre.setLabelFloat(true);
                tfNombre.setDisable(true);
                
                tfCategoria = new JFXTextField();
                tfCategoria.setPromptText("Categoria");
                tfCategoria.setLabelFloat(true);
                tfCategoria.setDisable(true);

                tfPrecioVenta = new JFXTextField();
                tfPrecioVenta.setPromptText("Precio Venta");
                tfPrecioVenta.setLabelFloat(true);
                tfPrecioVenta.setDisable(true);

                tfStock = new JFXTextField();
                tfStock.setPromptText("Stock");
                tfStock.setLabelFloat(true);
                tfStock.setDisable(true);

                tfPrecioTotal = new JFXTextField();
                tfPrecioTotal.setPromptText("Precio Total");
                tfPrecioTotal.setLabelFloat(true);
                tfPrecioTotal.setDisable(true);

                tfDetalle = new JFXTextField();
                tfDetalle.setPromptText("Detalle");
                tfDetalle.setLabelFloat(true);
                tfDetalle.setDisable(true);

                HBox ctnBotones = new HBox(15);
                {
                    JFXButton btnModificar = new JFXButton("Modificar");
                    btnModificar.setDisable(true);
                    btnModificar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                        formModificar(root, panel);
                    });
                    JFXButton btnEliminar = new JFXButton("Eliminar");
                    btnEliminar.setDisable(true);
                    btnEliminar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                        eliminarBuscado(root, panel);
                    });
                    JFXButton btnCancelar = new JFXButton("Cancelar");
                    btnCancelar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                    });
                    btn.setOnAction((t) -> {
                        IProducto sqlProducto = new ProductoImp();
                        try {
                            producto = sqlProducto.obtener(Integer.parseInt(buscador.getText()));
                            tfNombre.setText(producto.getNombre());
                            tfCategoria.setText(producto.getCategoria().getNombre());
                            tfPrecioVenta.setText(String.valueOf(producto.getPrecioventa()));
                            tfStock.setText(String.valueOf(producto.getStock()));
                            tfPrecioTotal.setText(String.valueOf(producto.getPreciototalventa()));
                            tfDetalle.setText(producto.getDetalle());
                            btnEliminar.setDisable(false);
                            btnModificar.setDisable(false);
                        } catch (Exception ex) {
                        }
                    });
                    ctnBotones.getChildren().addAll(btnModificar, btnEliminar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, Pbuscador, tfNombre, tfCategoria, tfPrecioVenta, tfStock, tfPrecioTotal, tfDetalle, ctnBotones);
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
            formModificar(root, layout);
        });
        btnModificar.setDisable(true);
        btnEliminar.setOnAction((t) -> {
            formEliminar(root, layout);
        });
        btnEliminar.setDisable(true);
        JFXButton btnBuscar = new JFXButton("Buscar");
        btnBuscar.setOnAction((t) -> {
            formBuscar(root, layout);
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

    private void eliminarBuscado(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            lblITitulo = new Label("¿Está seguro de querer eliminar este Producto?");
            lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
            fondo.setStyle("-fx-background-color:rgba(25,25,25,0.6)");
            VBox Contenedor = new VBox(25);
            HBox Imagen = new HBox(15);
            {
                ImageView advertencia = new ImageView();
                Imagen.getChildren().add(advertencia);
                Imagen.setAlignment(Pos.CENTER);
            }
            HBox ctnBotones = new HBox(15);
            {
                JFXButton btnAceptar = new JFXButton("Aceptar");
                btnAceptar.setDefaultButton(true);
                btnAceptar.setOnAction(EliminarActionListener(root, fondo, panel));
                JFXButton btnCancelar = new JFXButton("Cancelar");
                btnCancelar.setOnAction((t) -> {
                    root.getChildren().remove(fondo);
                });
                ctnBotones.getChildren().addAll(btnAceptar, btnCancelar);
                ctnBotones.setAlignment(Pos.CENTER);
            }
            Contenedor.getChildren().addAll(Imagen, lblITitulo, ctnBotones);
            VBox.setVgrow(Imagen, Priority.ALWAYS);
            Contenedor.getStyleClass().add("panelEliminarBuscado");
            Contenedor.getStylesheets().addAll(this.getClass().getResource("estilos/Botones.css").toExternalForm());
            Contenedor.setPadding(new Insets(15));
            Contenedor.setStyle("-fx-background-color: rgb(10,20,50)");
            Contenedor.setMaxSize(240, 240);
            AnchorPane.setBottomAnchor(fondo, 0.0);
            AnchorPane.setLeftAnchor(fondo, 0.0);
            AnchorPane.setTopAnchor(fondo, 0.0);
            AnchorPane.setRightAnchor(fondo, 0.0);
            fondo.getChildren().add(Contenedor);
        }
        root.getChildren().add(fondo);
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

    private EventHandler ModificarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            try {
                IProducto sqlProducto = new ProductoImp();
                producto.setNombre(tfNombre.getText());
                producto.setCategoria(cmbCategoria.getSelectionModel().getSelectedItem());
                producto.setPrecioventa(Double.parseDouble(tfPrecioVenta.getText()));
                producto.setStock(Double.parseDouble(tfStock.getText()));
                producto.setPreciototalventa(Double.parseDouble(tfPrecioTotal.getText()));
                producto.setDetalle(tfDetalle.getText());
                if (sqlProducto.modificar(producto) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Producto Modificado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Modificar el Producto");
            }
        };
        return handler;
    }

    private EventHandler EliminarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        IProducto sqlProducto = new ProductoImp();
        EventHandler h = (t) -> {
            try {
                if (sqlProducto.eliminar(producto) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Producto " + producto.getNombre() + " eliminado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Eliminar el Producto");
            }
        };
        return h;
    }

}

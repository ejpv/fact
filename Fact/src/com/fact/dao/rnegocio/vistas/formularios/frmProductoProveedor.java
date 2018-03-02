package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.IProducto;
import com.fact.dao.contrato.IProductoProveedor;
import com.fact.dao.contrato.IProveedor;
import com.fact.dao.impl.ProductoImp;
import com.fact.dao.impl.ProductoProveedorImp;
import com.fact.dao.impl.ProveedorImp;
import com.fact.dao.rnegocio.entidades.Categoria;
import com.fact.dao.rnegocio.entidades.Producto;
import com.fact.dao.rnegocio.entidades.ProductoProveedor;
import com.fact.dao.rnegocio.entidades.Proveedor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class frmProductoProveedor {

    private JFXComboBox<Producto> cmbProducto = new JFXComboBox<>();
    private JFXComboBox<Proveedor> cmbProveedor = new JFXComboBox<>();
    private JFXTextField tfPrecio;
    private JFXTextField tfCantidad;
    private JFXTextField tfTotal;
    private JFXTextField tfProducto;
    private JFXTextField tfProveedor;
    private JFXTextField tfDetalle;
    private JFXTextField tfFecha;
    private static ProductoProveedor productoproveedor = new ProductoProveedor();
    private static TableView<ProductoProveedor> tabla;
    private static JFXButton btnModificar = new JFXButton("Modificar");
    private static JFXButton btnEliminar = new JFXButton("Eliminar");
    static frmPrincipal principal = new frmPrincipal();
    private static Label lblITitulo;
    List<Producto> lisProducto = new ArrayList<>();
    List<Proveedor> lisProveedor = new ArrayList<>();
    IProducto iproducto = new ProductoImp();
    IProveedor iproveedor = new ProveedorImp();
    IProductoProveedor iproductoproveedor = new ProductoProveedorImp();

    public void panelDerecho(AnchorPane root, BorderPane layout) {
        VBox contenedor = new VBox(10);
        //Titutlo
        Label lblTitle = new Label("PEDIDO");//Titulo de la Ventana Label de (javafx.scene.control.Label)
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


                tfProducto = new JFXTextField();
                tfProducto.setPromptText("Producto");
                tfProducto.setLabelFloat(true);
                tfProducto.setDisable(true);
                
                tfProveedor = new JFXTextField();
                tfProveedor.setPromptText("Proveedor");
                tfProveedor.setLabelFloat(true);
                tfProveedor.setDisable(true);

                tfPrecio = new JFXTextField();
                tfPrecio.setPromptText("Precio");
                tfPrecio.setLabelFloat(true);
                tfPrecio.setDisable(true);

                tfCantidad = new JFXTextField();
                tfCantidad.setPromptText("Cantidad");
                tfCantidad.setLabelFloat(true);
                tfCantidad.setDisable(true);

                tfTotal = new JFXTextField();
                tfTotal.setPromptText("Total");
                tfTotal.setLabelFloat(true);
                tfTotal.setDisable(true);

                tfDetalle = new JFXTextField();
                tfDetalle.setPromptText("Detalle");
                tfDetalle.setLabelFloat(true);
                tfDetalle.setDisable(true);
                
                tfFecha = new JFXTextField();
                tfFecha.setPromptText("Fecha");
                tfFecha.setLabelFloat(true);
                tfFecha.setDisable(true);

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
                        IProductoProveedor sqlProducto = new ProductoProveedorImp();
                        try {
                            productoproveedor = sqlProducto.obtener(Integer.parseInt(buscador.getText()));
                            tfProducto.setText(productoproveedor.getProducto().getNombre());
                            tfProveedor.setText(productoproveedor.getProveedor().getNombre());
                            tfPrecio.setText(String.valueOf(productoproveedor.getPrecio()));
                            tfCantidad.setText(String.valueOf(productoproveedor.getCantidad()));
                            tfTotal.setText(String.valueOf(productoproveedor.getTotal()));
                            tfDetalle.setText(productoproveedor.getDetalle());
                            tfFecha.setText(productoproveedor.getFecha().toString());
                            btnEliminar.setDisable(false);
                            btnModificar.setDisable(false);
                        } catch (Exception ex) {
                        }
                    });
                    ctnBotones.getChildren().addAll(btnModificar, btnEliminar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, Pbuscador, tfProducto, tfProveedor, tfPrecio, tfCantidad, tfTotal, tfDetalle,tfFecha, ctnBotones);
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
                lblITitulo = new Label("ELIMINAR PEDIDO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                cmbProducto = new JFXComboBox<>();
                try {
                    lisProducto = iproducto.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbProducto.setItems(FXCollections.observableArrayList(lisProducto));
                cmbProducto.setPromptText("Categoria");
                cmbProducto.setLabelFloat(true);
                cmbProducto.getSelectionModel().clearAndSelect(productoproveedor.getProducto().getCodigo() - 1);

                cmbProveedor = new JFXComboBox<>();
                try {
                    lisProveedor = iproveedor.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbProveedor.setItems(FXCollections.observableArrayList(lisProveedor));
                cmbProveedor.setPromptText("Categoria");
                cmbProveedor.setLabelFloat(true);
                cmbProveedor.getSelectionModel().clearAndSelect(productoproveedor.getProveedor().getCodigo() - 1);

                tfPrecio = new JFXTextField(String.valueOf(productoproveedor.getPrecio()));
                tfPrecio.setPromptText("Precio Venta");
                tfPrecio.setLabelFloat(true);

                tfCantidad = new JFXTextField(String.valueOf(productoproveedor.getCantidad()));
                tfCantidad.setPromptText("Precio Venta");
                tfCantidad.setLabelFloat(true);

                tfTotal = new JFXTextField(String.valueOf(productoproveedor.getTotal()));
                tfTotal.setPromptText("Precio Venta");
                tfTotal.setLabelFloat(true);

                tfDetalle = new JFXTextField(productoproveedor.getDetalle());
                tfDetalle.setPromptText("Precio Total");
                tfDetalle.setLabelFloat(true);

                tfFecha = new JFXTextField(productoproveedor.getFecha().toString());
                tfFecha.setPromptText("Precio Total");
                tfFecha.setLabelFloat(true);

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
                Contenedor.getChildren().addAll(titulo, cmbProducto, cmbProveedor, tfPrecio, tfCantidad, tfTotal, tfDetalle, tfFecha, ctnBotones);
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

    public void formModificar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("MODIFICAR PEDIDO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                cmbProducto = new JFXComboBox<>();
                try {
                    lisProducto = iproducto.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbProducto.setItems(FXCollections.observableArrayList(lisProducto));
                cmbProducto.setPromptText("Producto");
                cmbProducto.setLabelFloat(true);
                cmbProducto.getSelectionModel().clearAndSelect(productoproveedor.getProducto().getCodigo() - 1);

                cmbProveedor = new JFXComboBox<>();
                try {
                    lisProveedor = iproveedor.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbProveedor.setItems(FXCollections.observableArrayList(lisProveedor));
                cmbProveedor.setPromptText("Proveedor");
                cmbProveedor.setLabelFloat(true);
                cmbProveedor.getSelectionModel().clearAndSelect(productoproveedor.getProveedor().getCodigo() - 1);

                tfPrecio = new JFXTextField(String.valueOf(productoproveedor.getPrecio()));
                tfPrecio.setPromptText("Precio");
                tfPrecio.setLabelFloat(true);

                tfCantidad = new JFXTextField(String.valueOf(productoproveedor.getCantidad()));
                tfCantidad.setPromptText("Cantidad");
                tfCantidad.setLabelFloat(true);

                tfTotal = new JFXTextField(String.valueOf(productoproveedor.getTotal()));
                tfTotal.setPromptText("Total");
                tfTotal.setLabelFloat(true);

                tfDetalle = new JFXTextField(productoproveedor.getDetalle());
                tfDetalle.setPromptText("Detalle");
                tfDetalle.setLabelFloat(true);

                tfFecha = new JFXTextField(String.valueOf(productoproveedor.getFecha()));
                tfFecha.setPromptText("Fecha");
                tfFecha.setLabelFloat(true);

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
                Contenedor.getChildren().addAll(titulo, cmbProducto, cmbProveedor, tfPrecio, tfCantidad, tfTotal, tfDetalle, tfFecha, ctnBotones);
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

    private void formInsertar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("INGRESAR PEDIDO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                try {
                    lisProducto = iproducto.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbProducto.setItems(FXCollections.observableArrayList(lisProducto));
                cmbProducto.setPromptText("Producto");
                cmbProducto.setLabelFloat(true);

                try {
                    lisProveedor = iproveedor.obtener();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                cmbProveedor.setItems(FXCollections.observableArrayList(lisProveedor));
                cmbProveedor.setPromptText("Proveedor");
                cmbProveedor.setLabelFloat(true);

                tfPrecio = new JFXTextField();
                tfPrecio.setPromptText("Precio");
                tfPrecio.setLabelFloat(true);

                tfCantidad = new JFXTextField();
                tfCantidad.setPromptText("Cantidad");
                tfCantidad.setLabelFloat(true);

                tfTotal = new JFXTextField();
                tfTotal.setPromptText("Total");
                tfTotal.setLabelFloat(true);

                tfDetalle = new JFXTextField();
                tfDetalle.setPromptText("Detalle");
                tfDetalle.setLabelFloat(true);

                tfFecha = new JFXTextField();
                tfFecha.setPromptText("Fecha");
                tfFecha.setLabelFloat(true);

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
                        cmbProducto.setPromptText("");
                        cmbProveedor.setPromptText("");
                        tfPrecio.setText("");
                        tfCantidad.setText("");
                        tfTotal.setText("");
                        tfDetalle.setText("");
                        tfFecha.setText("");
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnLimpiar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, cmbProducto, cmbProveedor, tfPrecio, tfCantidad, tfTotal, tfDetalle, tfFecha, ctnBotones);
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
            principal.Mensaje.failed("No se pudo Obtener Pedido");

        }
        return lst;
    }

    private EventHandler InsertarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            IProducto sqlProducto = new ProductoImp();

            try {
                List<ProductoProveedor> lst = new ArrayList<>();
                lst = iproductoproveedor.obtener();
                productoproveedor.setCodigo(lst.get(lst.size() - 1).getCodigo() + 1);
                productoproveedor.setProducto(cmbProducto.getSelectionModel().getSelectedItem());
                productoproveedor.setProveedor(cmbProveedor.getSelectionModel().getSelectedItem());
                productoproveedor.setPrecio(Double.parseDouble(tfPrecio.getText()));
                productoproveedor.setCantidad(Integer.parseInt(tfCantidad.getText()));
                productoproveedor.setTotal(Double.parseDouble(tfTotal.getText()));
                productoproveedor.setDetalle(tfDetalle.getText());
                DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    productoproveedor.setFecha(formato.parse(tfFecha.getText()));
                } catch (Exception ex) {
                }
                if (iproductoproveedor.insertar(productoproveedor) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Nuevo pedido Ingresado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("Error al Ingresar Pedido!");
            }
        };
        return handler;
    }

    private EventHandler ModificarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            try {
                IProductoProveedor sqlProductoPrveedor = new ProductoProveedorImp();
                productoproveedor.setProducto(cmbProducto.getSelectionModel().getSelectedItem());
                productoproveedor.setProveedor(cmbProveedor.getSelectionModel().getSelectedItem());
                productoproveedor.setPrecio(Double.parseDouble(tfPrecio.getText()));
                productoproveedor.setCantidad(Integer.parseInt(tfCantidad.getText()));
                productoproveedor.setTotal(Double.parseDouble(tfTotal.getText()));
                productoproveedor.setDetalle(tfDetalle.getText());
                DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    productoproveedor.setFecha(formato.parse(tfFecha.getText()));
                } catch (Exception ex) {
                }
                if (sqlProductoPrveedor.modificar(productoproveedor) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Pedido Modificado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Modificar el Pedido");
            }
        };
        return handler;
    }

    private EventHandler EliminarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        IProductoProveedor sqlProductoProveedor = new ProductoProveedorImp();
        EventHandler h = (t) -> {
            try {
                if (sqlProductoProveedor.eliminar(productoproveedor) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Producto " + productoproveedor.getCodigo() + " eliminado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Eliminar el Producto");
            }
        };
        return h;
    }

}

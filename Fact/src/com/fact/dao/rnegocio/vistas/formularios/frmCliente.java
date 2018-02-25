/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.ICliente;
import com.fact.dao.impl.ClienteImp;
import com.fact.dao.rnegocio.entidades.Cliente;
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

/**
 *
 * @author acer1
 */
public class frmCliente {

    private JFXTextField tfCedula;
    private JFXTextField tfNombre;
    private JFXTextField tfApellido;
    private JFXTextField tfTelefono;
    private JFXTextField tfDireccion;
    private JFXTextField tfEmail;
    private JFXTextField tfRuc;
    private static Cliente cliente = new Cliente();
    private static TableView<Cliente> tabla;
    private static JFXButton btnModificar = new JFXButton("Modificar");
    private static JFXButton btnEliminar = new JFXButton("Eliminar");
    static frmPrincipal principal = new frmPrincipal();
    private static Label lblITitulo;

    private void formInsertar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("INGRESAR CLIENTE");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfCedula = new JFXTextField("000000000-0");
                tfCedula.setPromptText("Cédula");
                tfCedula.setLabelFloat(true);

                tfNombre = new JFXTextField();
                tfNombre.setPromptText("Nombres");
                tfNombre.setLabelFloat(true);

                tfApellido = new JFXTextField();
                tfApellido.setPromptText("Apellidos");
                tfApellido.setLabelFloat(true);

                tfDireccion = new JFXTextField();
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);

                tfTelefono = new JFXTextField();
                tfTelefono.setPromptText("Teléfono");
                tfTelefono.setLabelFloat(true);

                tfEmail = new JFXTextField();
                tfEmail.setPromptText("Email");
                tfEmail.setLabelFloat(true);

                tfRuc = new JFXTextField();
                tfRuc.setPromptText("Ruc");
                tfRuc.setLabelFloat(true);

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
                        tfCedula.setText("");
                        tfNombre.setText("");
                        tfApellido.setText("");
                        tfDireccion.setText("");
                        tfTelefono.setText("");
                        tfEmail.setText("");
                        tfRuc.setText("");
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnLimpiar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, tfCedula, tfNombre, tfApellido, tfDireccion, tfTelefono, tfEmail, tfRuc, ctnBotones);
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
        Label lblTitle = new Label("CLIENTES");//Titulo de la Ventana Label de (javafx.scene.control.Label)
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
        TableView<Cliente> tabla = Tabla();
        AnchorPane root = new AnchorPane(tabla);
        AnchorPane.setTopAnchor(tabla, 0.0);
        AnchorPane.setBottomAnchor(tabla, 0.0);
        AnchorPane.setRightAnchor(tabla, 0.0);
        AnchorPane.setLeftAnchor(tabla, 0.0);

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Clientes");
        stage.show();
    }

    private static TableView<Cliente> Tabla() {
        tabla = new TableView<Cliente>();
        //Cedula
        TableColumn<Cliente, String> colCedula = new TableColumn<>("Cédula");
        colCedula.setMinWidth(80);
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));

        //Nombre
        TableColumn<Cliente, Double> colNombre = new TableColumn<>("Nombre");
        colNombre.setMinWidth(100);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        //Apellido
        TableColumn<Cliente, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setMinWidth(100);
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        //Direccion
        TableColumn<Cliente, String> colDireccion = new TableColumn<>("Dirección");
        colDireccion.setMinWidth(100);
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        //Telefono
        TableColumn<Cliente, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setMinWidth(100);
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        //E-mail
        TableColumn<Cliente, String> colEmail = new TableColumn<>("E-Mail");
        colEmail.setMinWidth(100);
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Ruc
        TableColumn<Cliente, String> colRuc = new TableColumn<>("Ruc");
        colRuc.setMinWidth(100);
        colRuc.setCellValueFactory(new PropertyValueFactory<>("ruc"));

        tabla.setItems(getCliente());
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tabla.getColumns().addAll(colCedula, colNombre, colApellido, colDireccion, colTelefono, colEmail, colRuc);
        tabla.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event t) {
                cliente = tabla.getSelectionModel().getSelectedItem();
                btnModificar.setDisable(false);
                btnEliminar.setDisable(false);
            }
        });
        return tabla;
    }

    private static ObservableList<Cliente> getCliente() {
        ObservableList<Cliente> lst = FXCollections.observableArrayList();
        ICliente sqlCliente = new ClienteImp();
        try {
            List<Cliente> clientes = sqlCliente.obtener();
            if (clientes.size() > 0) {
                clientes.forEach((tmp) -> {
                    lst.add(tmp);
                });
            }
        } catch (Exception e) {
            principal.Mensaje.failed("No se pudo Obtener Clientes");

        }
        return lst;
    }

    public void formModificar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("MODIFICAR CLIENTE");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfCedula = new JFXTextField(cliente.getCedula());
                tfCedula.setPromptText("Cédula");
                tfCedula.setLabelFloat(true);

                tfNombre = new JFXTextField(cliente.getNombre());
                tfNombre.setPromptText("Nombres");
                tfNombre.setLabelFloat(true);

                tfApellido = new JFXTextField(cliente.getApellido());
                tfApellido.setPromptText("Apellidos");
                tfApellido.setLabelFloat(true);

                tfDireccion = new JFXTextField(cliente.getDireccion());
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);

                tfTelefono = new JFXTextField(cliente.getTelefono());
                tfTelefono.setPromptText("Teléfono");
                tfTelefono.setLabelFloat(true);

                tfEmail = new JFXTextField(cliente.getEmail());
                tfEmail.setPromptText("Email");
                tfEmail.setLabelFloat(true);

                tfRuc = new JFXTextField(cliente.getRuc());
                tfRuc.setPromptText("Ruc");
                tfRuc.setLabelFloat(true);

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
                Contenedor.getChildren().addAll(titulo, tfCedula, tfNombre, tfApellido, tfDireccion, tfTelefono, tfEmail, tfRuc, ctnBotones);
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
                lblITitulo = new Label("ELIMINAR CLIENTE");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfCedula = new JFXTextField(cliente.getCedula());
                tfCedula.setPromptText("Cédula");
                tfCedula.setLabelFloat(true);
                tfCedula.setDisable(true);

                tfNombre = new JFXTextField(cliente.getNombre());
                tfNombre.setPromptText("Nombres");
                tfNombre.setLabelFloat(true);
                tfNombre.setDisable(true);

                tfApellido = new JFXTextField(cliente.getApellido());
                tfApellido.setPromptText("Apellidos");
                tfApellido.setLabelFloat(true);
                tfApellido.setDisable(true);

                tfDireccion = new JFXTextField(cliente.getDireccion());
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);
                tfDireccion.setDisable(true);

                tfTelefono = new JFXTextField(cliente.getTelefono());
                tfTelefono.setPromptText("Teléfono");
                tfTelefono.setLabelFloat(true);
                tfTelefono.setDisable(true);

                tfEmail = new JFXTextField(cliente.getEmail());
                tfEmail.setPromptText("Email");
                tfEmail.setLabelFloat(true);
                tfEmail.setDisable(true);

                tfRuc = new JFXTextField(cliente.getRuc());
                tfRuc.setPromptText("Ruc");
                tfRuc.setLabelFloat(true);
                tfRuc.setDisable(true);

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
                Contenedor.getChildren().addAll(titulo, tfCedula, tfNombre, tfApellido, tfDireccion, tfTelefono, tfEmail, tfRuc, ctnBotones);
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
                lblITitulo = new Label("BUSCAR CLIENTE");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.getChildren().add(lblITitulo);
                titulo.setAlignment(Pos.CENTER);

                HBox Pbuscador = new HBox();
                TextField buscador = new TextField();
                buscador.setPromptText("Escribe una Cédula...");
                buscador.getStyleClass().add("buscador");
                buscador.setMinWidth(260);
                buscador.setMinHeight(30);

                JFXButton btn = new JFXButton("Buscar");
                btn.setDefaultButton(true);
                Pbuscador.getChildren().addAll(buscador, btn);
                Pbuscador.setSpacing(10);

                tfCedula = new JFXTextField("");
                tfCedula.setPromptText("Cédula");
                tfCedula.setLabelFloat(true);
                tfCedula.setDisable(true);

                tfNombre = new JFXTextField();
                tfNombre.setPromptText("Nombres");
                tfNombre.setLabelFloat(true);
                tfNombre.setDisable(true);

                tfApellido = new JFXTextField();
                tfApellido.setPromptText("Apellidos");
                tfApellido.setLabelFloat(true);
                tfApellido.setDisable(true);

                tfDireccion = new JFXTextField();
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);
                tfDireccion.setDisable(true);

                tfTelefono = new JFXTextField();
                tfTelefono.setPromptText("Teléfono");
                tfTelefono.setLabelFloat(true);
                tfTelefono.setDisable(true);

                tfEmail = new JFXTextField();
                tfEmail.setPromptText("Email");
                tfEmail.setLabelFloat(true);
                tfEmail.setDisable(true);

                tfRuc = new JFXTextField();
                tfRuc.setPromptText("Ruc");
                tfRuc.setLabelFloat(true);
                tfRuc.setDisable(true);

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
                        ICliente sqlcliente = new ClienteImp();
                        try {
                            cliente = sqlcliente.obtenerCedula(buscador.getText());
                            tfCedula.setText(cliente.getCedula());
                            tfNombre.setText(cliente.getNombre());
                            tfApellido.setText(cliente.getApellido());
                            tfDireccion.setText(cliente.getDireccion());
                            tfTelefono.setText(cliente.getTelefono());
                            tfEmail.setText(cliente.getEmail());
                            tfRuc.setText(cliente.getRuc());
                            btnEliminar.setDisable(false);
                            btnModificar.setDisable(false);
                        } catch (Exception ex) {
                        }
                    });
                    ctnBotones.getChildren().addAll(btnModificar, btnEliminar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, Pbuscador, tfCedula, tfNombre, tfApellido, tfDireccion, tfTelefono, tfEmail, tfRuc, ctnBotones);
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
            lblITitulo = new Label("¿Está seguro de querer eliminar este Cliente?");
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
            ICliente sqlCliente = new ClienteImp();

            try {
                List<Cliente> lst = new ArrayList<>();
                lst = sqlCliente.obtener();
                cliente.setCodigo(lst.get(lst.size() - 1).getCodigo() + 1);
                cliente.setCedula(tfCedula.getText());
                cliente.setNombre(tfNombre.getText());
                cliente.setApellido(tfApellido.getText());
                cliente.setDireccion(tfDireccion.getText());
                cliente.setTelefono(tfTelefono.getText());
                cliente.setEmail(tfEmail.getText());
                cliente.setRuc(tfRuc.getText());
                if (sqlCliente.insertar(cliente) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Nuevo cliente Ingresado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("Error al Ingresar Usuario!");
            }
        };
        return handler;
    }

    private EventHandler EliminarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        ICliente sqlCliente = new ClienteImp();
        EventHandler h = (t) -> {
            try {
                if (sqlCliente.eliminar(cliente) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Cliente " + cliente.getNombre() + " eliminado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Eliminar Cliente");
            }
        };
        return h;
    }

    private EventHandler ModificarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            try {
                ICliente sqlCliente = new ClienteImp();
                cliente.setCedula(tfCedula.getText());
                cliente.setApellido(tfApellido.getText());
                cliente.setNombre(tfNombre.getText());
                cliente.setDireccion(tfDireccion.getText());
                cliente.setTelefono(tfTelefono.getText());
                cliente.setEmail(tfEmail.getText());
                cliente.setRuc(tfRuc.getText());
                if (sqlCliente.modificar(cliente) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Cliente Modificado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Modificar Cliente");
            }
        };
        return handler;
    }
}

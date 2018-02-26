
package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.ICliente;
import com.fact.dao.contrato.IEmpleado;
import com.fact.dao.impl.ClienteImp;
import com.fact.dao.impl.EmpleadoImp;
import com.fact.dao.rnegocio.entidades.Cliente;
import com.fact.dao.rnegocio.entidades.Empleado;
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
public class frmEmpleado {

    private JFXTextField tfCedula;
    private JFXTextField tfNombre;
    private JFXTextField tfApellido;
    private JFXTextField tfEspecialidad;
    private JFXTextField tfDireccion;
    private JFXTextField tfTelefono;
    private JFXTextField tfTipo;
    private JFXTextField tfUsuario;
    private JFXTextField tfContraseña;
    private static Empleado empleado = new Empleado();
    private static TableView<Empleado> tabla;
    private static JFXButton btnModificar = new JFXButton("Modificar");
    private static JFXButton btnEliminar = new JFXButton("Eliminar");
    static frmPrincipal principal = new frmPrincipal();
    private static Label lblITitulo;

    private void formInsertar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("INGRESAR EMPLEADO");
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
                
                tfEspecialidad = new JFXTextField();
                tfEspecialidad.setPromptText("Especialidad");
                tfEspecialidad.setLabelFloat(true);
                
                tfDireccion = new JFXTextField();
                tfDireccion.setPromptText("Dirección");
                tfDireccion.setLabelFloat(true);

                tfTelefono = new JFXTextField();
                tfTelefono.setPromptText("Teléfono");
                tfTelefono.setLabelFloat(true);

                tfTipo = new JFXTextField();
                tfTipo.setPromptText("Tipo");
                tfTipo.setLabelFloat(true);

                tfUsuario = new JFXTextField();
                tfUsuario.setPromptText("Usuario");
                tfUsuario.setLabelFloat(true);
                
                tfContraseña= new JFXTextField();
                tfContraseña.setPromptText("Contraseña");
                tfContraseña.setLabelFloat(true);

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
                        tfEspecialidad.setText("");
                        tfDireccion.setText("");
                        tfTelefono.setText("");
                        tfTipo.setText("");
                        tfUsuario.setText("");
                        tfContraseña.setText("");
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnLimpiar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, tfCedula, tfNombre, tfApellido, tfEspecialidad, tfDireccion, tfTelefono, tfTipo, tfUsuario, tfContraseña, ctnBotones);
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
        Label lblTitle = new Label("EMPLEADOS");//Titulo de la Ventana Label de (javafx.scene.control.Label)
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
        boxButtons.getStylesheets().addAll(this.getClass().getResource("estilos/Empleado.css").toExternalForm());

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
        TableView<Empleado> tabla = Tabla();
        AnchorPane root = new AnchorPane(tabla);
        AnchorPane.setTopAnchor(tabla, 0.0);
        AnchorPane.setBottomAnchor(tabla, 0.0);
        AnchorPane.setRightAnchor(tabla, 0.0);
        AnchorPane.setLeftAnchor(tabla, 0.0);

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Empleados");
        stage.show();
    }

    private static TableView<Empleado> Tabla() {
        tabla = new TableView<Empleado>();
        //Cedula
        TableColumn<Empleado, String> colCedula = new TableColumn<>("Cédula");
        colCedula.setMinWidth(80);
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));

        //Nombre
        TableColumn<Empleado, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setMinWidth(100);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        //Apellido
        TableColumn<Empleado, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setMinWidth(100);
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        
        //Especialidad
        TableColumn<Empleado, String> colEspecialidad = new TableColumn<>("Especialidad");
        colEspecialidad.setMinWidth(100);
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));

        //Direccion
        TableColumn<Empleado, String> colDireccion = new TableColumn<>("Dirección");
        colDireccion.setMinWidth(100);
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        //Telefono
        TableColumn<Empleado, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setMinWidth(100);
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        //Tipo
        TableColumn<Empleado, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setMinWidth(100);
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        //Usuario
        TableColumn<Empleado, String> colUsuario = new TableColumn<>("Usuario");
        colUsuario.setMinWidth(100);
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        
        //Contraseña
        TableColumn<Empleado, String> colContraseña = new TableColumn<>("Contraseña");
        colContraseña.setMinWidth(100);
        colContraseña.setCellValueFactory(new PropertyValueFactory<>("clave"));

        tabla.setItems(getEmpleado());
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tabla.getColumns().addAll(colCedula, colNombre, colApellido, colEspecialidad, colDireccion, colTelefono, colTipo, colUsuario, colContraseña);
        tabla.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event t) {
                empleado = tabla.getSelectionModel().getSelectedItem();
                btnModificar.setDisable(false);
                btnEliminar.setDisable(false);
            }
        });
        return tabla;
    }

    private static ObservableList<Empleado> getEmpleado() {
        ObservableList<Empleado> lst = FXCollections.observableArrayList();
        IEmpleado sqlEmpleado = new EmpleadoImp();
        try {
            List<Empleado> empleados = sqlEmpleado.obtener();
            if (empleados.size() > 0) {
                empleados.forEach((tmp) -> {
                    lst.add(tmp);
                });
            }
        } catch (Exception e) {
            principal.Mensaje.failed("No se pudo Obtener Empleados");

        }
        return lst;
    }

    public void formModificar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("MODIFICAR EMPLEADO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfCedula = new JFXTextField(empleado.getCedula());
                tfCedula.setPromptText("Cédula");
                tfCedula.setLabelFloat(true);

                tfNombre = new JFXTextField(empleado.getNombre());
                tfNombre.setPromptText("Nombres");
                tfNombre.setLabelFloat(true);

                tfApellido = new JFXTextField(empleado.getApellido());
                tfApellido.setPromptText("Apellidos");
                tfApellido.setLabelFloat(true);
                
                tfEspecialidad = new JFXTextField(empleado.getEspecialidad());
                tfEspecialidad.setPromptText("Especialidad");
                tfEspecialidad.setLabelFloat(true);

                tfDireccion = new JFXTextField(empleado.getDireccion());
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);

                tfTelefono = new JFXTextField(empleado.getTelefono());
                tfTelefono.setPromptText("Teléfono");
                tfTelefono.setLabelFloat(true);

                tfTipo = new JFXTextField(empleado.getTipo());
                tfTipo.setPromptText("Tipo");
                tfTipo.setLabelFloat(true);

                tfUsuario = new JFXTextField(empleado.getUsuario());
                tfUsuario.setPromptText("Usuario");
                tfUsuario.setLabelFloat(true);
                
                tfContraseña = new JFXTextField(empleado.getClave());
                tfContraseña.setPromptText("Contraseña");
                tfContraseña.setLabelFloat(true);

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
                Contenedor.getChildren().addAll(titulo, tfCedula, tfNombre, tfApellido, tfEspecialidad, tfDireccion, tfTelefono, tfTipo, tfUsuario, tfContraseña, ctnBotones);
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
                lblITitulo = new Label("ELIMINAR EMPLEADO");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfCedula = new JFXTextField(empleado.getCedula());
                tfCedula.setPromptText("Cédula");
                tfCedula.setLabelFloat(true);
                tfCedula.setDisable(true);

                tfNombre = new JFXTextField(empleado.getNombre());
                tfNombre.setPromptText("Nombres");
                tfNombre.setLabelFloat(true);
                tfNombre.setDisable(true);

                tfApellido = new JFXTextField(empleado.getApellido());
                tfApellido.setPromptText("Apellidos");
                tfApellido.setLabelFloat(true);
                tfApellido.setDisable(true);
                
                tfEspecialidad = new JFXTextField(empleado.getEspecialidad());
                tfEspecialidad.setPromptText("Especialidad");
                tfEspecialidad.setLabelFloat(true);
                tfEspecialidad.setDisable(true);

                tfDireccion = new JFXTextField(empleado.getDireccion());
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);
                tfDireccion.setDisable(true);

                tfTelefono = new JFXTextField(empleado.getTelefono());
                tfTelefono.setPromptText("Teléfono");
                tfTelefono.setLabelFloat(true);
                tfTelefono.setDisable(true);

                tfTipo = new JFXTextField(empleado.getTipo());
                tfTipo.setPromptText("Tipo");
                tfTipo.setLabelFloat(true);
                tfTipo.setDisable(true);

                tfUsuario = new JFXTextField(empleado.getUsuario());
                tfUsuario.setPromptText("Usuario");
                tfUsuario.setLabelFloat(true);
                tfUsuario.setDisable(true);
                
                tfContraseña = new JFXTextField(empleado.getClave());
                tfContraseña.setPromptText("Contraseña");
                tfContraseña.setLabelFloat(true);
                tfContraseña.setDisable(true);

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
                Contenedor.getChildren().addAll(titulo, tfCedula, tfNombre, tfApellido, tfEspecialidad, tfDireccion, tfTelefono, tfTipo, tfUsuario, tfContraseña, ctnBotones);
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
                lblITitulo = new Label("BUSCAR EMPLEADO");
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
                
                tfEspecialidad = new JFXTextField();
                tfEspecialidad.setPromptText("Especialidad");
                tfEspecialidad.setLabelFloat(true);
                tfEspecialidad.setDisable(true);

                tfDireccion = new JFXTextField();
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);
                tfDireccion.setDisable(true);

                tfTelefono = new JFXTextField();
                tfTelefono.setPromptText("Teléfono");
                tfTelefono.setLabelFloat(true);
                tfTelefono.setDisable(true);

                tfTipo = new JFXTextField();
                tfTipo.setPromptText("Tipo");
                tfTipo.setLabelFloat(true);
                tfTipo.setDisable(true);

                tfUsuario = new JFXTextField();
                tfUsuario.setPromptText("Usuario");
                tfUsuario.setLabelFloat(true);
                tfUsuario.setDisable(true);
                
                tfContraseña = new JFXTextField();
                tfContraseña.setPromptText("Contraseña");
                tfContraseña.setLabelFloat(true);
                tfContraseña.setDisable(true);

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
                        IEmpleado sqlEmpleado = new EmpleadoImp();
                        try {
                            empleado = sqlEmpleado.obtenerCedula(buscador.getText());
                            tfCedula.setText(empleado.getCedula());
                            tfNombre.setText(empleado.getNombre());
                            tfApellido.setText(empleado.getApellido());
                            tfEspecialidad.setText(empleado.getEspecialidad());
                            tfDireccion.setText(empleado.getDireccion());
                            tfTelefono.setText(empleado.getTelefono());
                            tfTipo.setText(empleado.getTipo());
                            tfUsuario.setText(empleado.getUsuario());
                            tfContraseña.setText(empleado.getClave());
                            btnEliminar.setDisable(false);
                            btnModificar.setDisable(false);
                        } catch (Exception ex) {
                        }
                    });
                    ctnBotones.getChildren().addAll(btnModificar, btnEliminar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, Pbuscador, tfCedula, tfNombre, tfApellido, tfEspecialidad, tfDireccion, tfTelefono, tfTipo, tfUsuario, tfContraseña, ctnBotones);
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
            lblITitulo = new Label("¿Está seguro de querer eliminar este Empleado?");
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
            IEmpleado sqlEmpleado = new EmpleadoImp();

            try {
                List<Empleado> lst = new ArrayList<>();
                lst = sqlEmpleado.obtener();
                empleado.setCodigo(lst.get(lst.size() - 1).getCodigo() + 1);
                empleado.setCedula(tfCedula.getText());
                empleado.setNombre(tfNombre.getText());
                empleado.setApellido(tfApellido.getText());
                empleado.setEspecialidad(tfEspecialidad.getText());
                empleado.setDireccion(tfDireccion.getText());
                empleado.setTelefono(tfTelefono.getText());
                empleado.setTipo(tfTipo.getText());
                empleado.setUsuario(tfUsuario.getText());
                empleado.setClave(tfContraseña.getText());
                if (sqlEmpleado.insertar(empleado) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Nuevo empleado Ingresado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("Error al Ingresar Empleado!");
            }
        };
        return handler;
    }

    private EventHandler EliminarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        IEmpleado sqlEmpleado = new EmpleadoImp();
        EventHandler h = (t) -> {
            try {
                if (sqlEmpleado.eliminar(empleado) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Empleado " + empleado.getNombre() + " eliminado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Eliminar Empleado");
            }
        };
        return h;
    }

    private EventHandler ModificarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            try {
                IEmpleado sqlEmpleado = new EmpleadoImp();
                empleado.setCedula(tfCedula.getText());
                empleado.setNombre(tfNombre.getText());
                empleado.setApellido(tfApellido.getText());
                empleado.setEspecialidad(tfEspecialidad.getText());
                empleado.setDireccion(tfDireccion.getText());
                empleado.setTelefono(tfTelefono.getText());
                empleado.setTipo(tfTipo.getText());
                empleado.setUsuario(tfUsuario.getText());
                empleado.setClave(tfContraseña.getText());
                if (sqlEmpleado.modificar(empleado) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Empleado Modificado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Modificar Empleado");
            }
        };
        return handler;
    }
}

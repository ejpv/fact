package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.IProveedor;
import com.fact.dao.impl.ProveedorImp;
import com.fact.dao.rnegocio.entidades.Proveedor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
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
import javafx.scene.control.ComboBox;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class frmProveedor {

    private JFXTextField tfNombre;
    private JFXTextField tfDireccion;
    private JFXTextField tfTelefono;
    private JFXTextField tfEmail;
    private static Proveedor proveedor = new Proveedor();
    private static TableView<Proveedor> tabla;
    private static JFXButton btnModificar = new JFXButton("Modificar");
    private static JFXButton btnEliminar = new JFXButton("Eliminar");
    static frmPrincipal principal = new frmPrincipal();
    private static Label lblITitulo;

    public void formInsertar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("INGRESAR PROVEEDOR");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfNombre = new JFXTextField();
                tfNombre.setPromptText("Nombre");
                tfNombre.setLabelFloat(true);

                tfDireccion = new JFXTextField();
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);

                tfTelefono = new JFXTextField();
                tfTelefono.setPromptText("Telefono");
                tfTelefono.setLabelFloat(true);

                tfEmail = new JFXTextField();
                tfEmail.setPromptText("Email");
                tfEmail.setLabelFloat(true);

                HBox ctnBotones = new HBox(15);
                {
                    JFXButton btnAceptar = new JFXButton("Aceptar");
                    btnAceptar.setOnAction(InsertarActionListener(root, fondo, panel));
                    btnAceptar.setDefaultButton(true);
                    JFXButton btnCancelar = new JFXButton("Cancelar");
                    btnCancelar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                    });
                    JFXButton btnLimpiar = new JFXButton("Limpiar");
                    btnLimpiar.setOnAction((t) -> {
                        tfNombre.setText("");
                        tfDireccion.setText("");
                        tfTelefono.setText("");
                        tfEmail.setText("");
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnLimpiar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, tfNombre, tfDireccion, tfTelefono, tfEmail, ctnBotones);
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
                lblITitulo = new Label("MODIFICAR PROVEEDOR");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfNombre = new JFXTextField(proveedor.getNombre());
                tfNombre.setPromptText("Nombre");
                tfNombre.setLabelFloat(true);

                tfDireccion = new JFXTextField(proveedor.getDireccion());
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);

                tfTelefono = new JFXTextField(proveedor.getTelefono());
                tfTelefono.setPromptText("Telefono");
                tfTelefono.setLabelFloat(true);

                tfEmail = new JFXTextField(proveedor.getEmail());
                tfEmail.setPromptText("Email");
                tfEmail.setLabelFloat(true);

                HBox ctnBotones = new HBox(15);
                {
                    JFXButton btnAceptar = new JFXButton("Aceptar");
                    btnAceptar.setOnAction(ModificarActionListener(root, fondo, panel));
                    btnAceptar.setDefaultButton(true);
                    JFXButton btnCancelar = new JFXButton("Cancelar");
                    btnCancelar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnCancelar);
                    ctnBotones.setAlignment(Pos.CENTER);
                }
                Contenedor.getChildren().addAll(titulo, tfNombre, tfDireccion, tfTelefono, tfEmail, ctnBotones);
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

    public void formEliminar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("Eliminar Proveedor");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                Label lblPregunta = new Label("¿Está Seguro de querer eliminar esta Proveedor?");
                lblPregunta.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto

                tfNombre = new JFXTextField(proveedor.getNombre());
                tfNombre.setPromptText("Nombre");
                tfNombre.setLabelFloat(true);
                tfNombre.setDisable(true);

                tfDireccion = new JFXTextField(proveedor.getDireccion());
                tfDireccion.setPromptText("Direccion");
                tfDireccion.setLabelFloat(true);
                tfDireccion.setDisable(true);

                tfTelefono = new JFXTextField(proveedor.getTelefono());
                tfTelefono.setPromptText("Telefono");
                tfTelefono.setLabelFloat(true);
                tfTelefono.setDisable(true);

                tfEmail = new JFXTextField(proveedor.getEmail());
                tfEmail.setPromptText("Email");
                tfEmail.setLabelFloat(true);
                tfEmail.setDisable(true);

                HBox ctnBotones = new HBox(15);
                {
                    JFXButton btnAceptar = new JFXButton("Aceptar");
                    btnAceptar.setOnAction(EliminarActionListener(root, fondo, panel));
                    btnAceptar.setDefaultButton(true);
                    JFXButton btnCancelar = new JFXButton("Cancelar");
                    btnCancelar.setOnAction((t) -> {
                        root.getChildren().remove(fondo);
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnCancelar);
                    ctnBotones.setAlignment(Pos.CENTER);
                }
                Contenedor.getChildren().addAll(titulo, lblPregunta, tfNombre, tfDireccion, tfTelefono, tfEmail, ctnBotones);
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
                lblITitulo = new Label("BUSCAR PROVEEDOR");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.getChildren().add(lblITitulo);
                titulo.setAlignment(Pos.CENTER);

                HBox medio = new HBox();
                VBox panelIzquiedo = new VBox(25);
                JFXListView<Proveedor> view = new JFXListView<>();
                view.setMinHeight(180);
                view.setMinWidth(170);
                IProveedor sqlproveedor = new ProveedorImp();
                List<Proveedor> lst = new ArrayList<>();
                try {
                    lst = sqlproveedor.obtener();
                } catch (Exception e) {
                }
                for (Proveedor v : lst) {
                    view.getItems().add(v);
                }
                panelIzquiedo.getChildren().add(view);
                VBox derecho = new VBox(25);
                tfNombre = new JFXTextField();
                tfNombre.setPromptText("Nombres");
                tfNombre.setLabelFloat(true);
                tfNombre.setDisable(true);

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

                derecho.getChildren().addAll(tfNombre, tfDireccion, tfTelefono, tfEmail);
                medio.getChildren().addAll(panelIzquiedo, derecho);
                medio.setSpacing(40);
                VBox.setVgrow(panelIzquiedo, Priority.ALWAYS);
                HBox ctnBotones = new HBox(15);
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
                view.setOnMouseClicked((t) -> {
                    proveedor = view.getSelectionModel().getSelectedItem();
                    tfNombre.setText(proveedor.getNombre());
                    tfDireccion.setText(proveedor.getDireccion());
                    tfTelefono.setText(proveedor.getTelefono());
                    tfEmail.setText(proveedor.getEmail());
                    btnModificar.setDisable(false);
                    btnEliminar.setDisable(false);
                });
                ctnBotones.getChildren().addAll(btnModificar, btnEliminar, btnCancelar);
                Contenedor.getChildren().addAll(titulo, medio, ctnBotones);
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

        root.getChildren()
                .add(fondo);
    }

    private void eliminarBuscado(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            lblITitulo = new Label("¿Está seguro de eliminar este Proveedor?");
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

    public void panelDerecho(AnchorPane root, BorderPane layout) {
        VBox contenedor = new VBox(10);
        //Titutlo
        Label lblTitle = new Label("PROVEEDOR");//Titulo de la Ventana Label de (javafx.scene.control.Label)
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
        boxButtons.getStylesheets().addAll(this.getClass().getResource("estilos/Proveedor.css").toExternalForm());

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

    private static TableView<Proveedor> Tabla() {
        tabla = new TableView<Proveedor>();

        //Nombre
        TableColumn<Proveedor, Double> colNombre = new TableColumn<>("Nombre");
        colNombre.setMinWidth(100);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        //Direccion
        TableColumn<Proveedor, String> colDireccion = new TableColumn<>("Direccion");
        colDireccion.setMinWidth(100);
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        //Telefono
        TableColumn<Proveedor, String> colTelefono = new TableColumn<>("Telefono");
        colTelefono.setMinWidth(100);
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        //Email
        TableColumn<Proveedor, String> colEmail = new TableColumn<>("Email");
        colEmail.setMinWidth(100);
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tabla.setItems(getProveedor());
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tabla.getColumns().addAll(colNombre, colDireccion, colTelefono, colEmail);
        tabla.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event t) {
                proveedor = tabla.getSelectionModel().getSelectedItem();
                btnModificar.setDisable(false);
                btnEliminar.setDisable(false);
            }
        });
        return tabla;

    }

    private static ObservableList<Proveedor> getProveedor() {
        ObservableList<Proveedor> lst = FXCollections.observableArrayList();
        IProveedor sqlProveedor = new ProveedorImp();
        try {
            List<Proveedor> proveedores = sqlProveedor.obtener();
            if (proveedores.size() > 0) {
                proveedores.forEach((tmp) -> {
                    lst.add(tmp);
                });
            }
        } catch (Exception e) {
            principal.Mensaje.failed("No se pudo Obtener el Proveedor");

        }
        return lst;
    }

    public void cargarTablas() {
        TableView<Proveedor> tabla = Tabla();
        AnchorPane root = new AnchorPane(tabla);
        AnchorPane.setTopAnchor(tabla, 0.0);
        AnchorPane.setBottomAnchor(tabla, 0.0);
        AnchorPane.setRightAnchor(tabla, 0.0);
        AnchorPane.setLeftAnchor(tabla, 0.0);

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Proveedor");
        stage.show();
    }

    /**
     * *************************************************************************
     *                                                                         *
     * IMPLEMENTACION DE LOS EVETOS * *
     * *************************************************************************
     */
    private EventHandler InsertarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            IProveedor sqlProveedor = new ProveedorImp();
            try {
                List<Proveedor> lst = new ArrayList<>();
                lst = sqlProveedor.obtener();
                proveedor.setCodigo(lst.get(lst.size() - 1).getCodigo() + 1);
                proveedor.setNombre(tfNombre.getText());
                proveedor.setDireccion(tfDireccion.getText());
                proveedor.setTelefono(tfTelefono.getText());
                proveedor.setEmail(tfEmail.getText());
                if (sqlProveedor.insertar(proveedor) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Nuevo Proveedor Ingresada");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("Error al Ingresar Proveedor!");
            }
        };
        return handler;
    }

    private EventHandler ModificarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            try {
                IProveedor sqlProveedor = new ProveedorImp();
                proveedor.setNombre(tfNombre.getText());
                proveedor.setDireccion(tfDireccion.getText());
                proveedor.setTelefono(tfTelefono.getText());
                proveedor.setEmail(tfEmail.getText());
                if (sqlProveedor.modificar(proveedor) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Proveedor Modificado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Modificar Proveedor");
            }
        };
        return handler;
    }

    private EventHandler EliminarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        IProveedor sqlProveedor = new ProveedorImp();
        EventHandler handler = (t) -> {
            try {
                if (sqlProveedor.eliminar(proveedor) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Proveedor " + proveedor.getNombre() + " eliminado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Eliminar Proveedor");
            }
        };
        return handler;
    }
}

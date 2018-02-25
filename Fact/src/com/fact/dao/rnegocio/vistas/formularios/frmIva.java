
package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.ICliente;
import com.fact.dao.contrato.IIva;
import com.fact.dao.impl.ClienteImp;
import com.fact.dao.impl.IvaImp;
import com.fact.dao.rnegocio.entidades.Cliente;
import com.fact.dao.rnegocio.entidades.Iva;
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

public class frmIva {

    private JFXTextField tfNombre;
    private JFXTextField tfPrecio;
    private static Iva iva = new Iva();
    private static TableView<Iva> tabla;
    private static JFXButton btnModificar = new JFXButton("Modificar");
    private static JFXButton btnEliminar = new JFXButton("Eliminar");
    static frmPrincipal principal = new frmPrincipal();
    private static Label lblITitulo;

    private void formInsertar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("Nuevo Iva");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfNombre = new JFXTextField();
                tfNombre.setPromptText("Porcentaje");
                tfNombre.setLabelFloat(true);

                tfPrecio = new JFXTextField();
                tfPrecio.setPromptText("Precio");
                tfPrecio.setLabelFloat(true);

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
                        tfPrecio.setText("");
                    });
                    ctnBotones.getChildren().addAll(btnAceptar, btnLimpiar, btnCancelar);
                }
                Contenedor.getChildren().addAll(titulo, tfNombre, tfPrecio, ctnBotones);
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
        Label lblTitle = new Label("IVA");//Titulo de la Ventana Label de (javafx.scene.control.Label)
        lblTitle.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
        lblTitle.setAlignment(Pos.BOTTOM_CENTER);
        lblTitle.setMinHeight(50);
        //Imagen
        ImageView ivCheck = new ImageView();
        ivCheck.setFitHeight(100);
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
//        JFXButton btnBuscar = new JFXButton("Buscar");
//        btnBuscar.setOnAction((t) -> {
//            //formBuscar(root, layout);
//        });

        //Contenedor de Botones
        boxButtons.getChildren().addAll(btnNuevo, btnModificar, btnEliminar);
        boxButtons.setStyle("-fx-background-color:rgb(0,92,150);-fx-padding:5");
        boxButtons.setAlignment(Pos.CENTER);
        boxButtons.setSpacing(30);
        boxButtons.getStyleClass().add("box");
        VBox.setVgrow(boxButtons, Priority.ALWAYS);
        boxButtons.getStylesheets().addAll(this.getClass().getResource("estilos/Iva.css").toExternalForm());

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
        TableView<Iva> tabla = Tabla();
        AnchorPane root = new AnchorPane(tabla);
        AnchorPane.setTopAnchor(tabla, 0.0);
        AnchorPane.setBottomAnchor(tabla, 0.0);
        AnchorPane.setRightAnchor(tabla, 0.0);
        AnchorPane.setLeftAnchor(tabla, 0.0);

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Iva");
        stage.show();
    }

    private static TableView<Iva> Tabla() {
        tabla = new TableView<Iva>();
        //Porcentaje
        TableColumn<Iva, String> colNombre = new TableColumn<>("Porcentaje");
        colNombre.setMinWidth(100);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("porcentaje"));

        //Precio
        TableColumn<Iva, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setMinWidth(100);
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tabla.setItems(getIva());
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tabla.getColumns().addAll(colNombre, colPrecio);
        tabla.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event t) {
                iva = tabla.getSelectionModel().getSelectedItem();
                btnModificar.setDisable(false);
                btnEliminar.setDisable(false);
            }
        });
        return tabla;
    }

    private static ObservableList<Iva> getIva() {
        ObservableList<Iva> lst = FXCollections.observableArrayList();
        IIva sqlIva = new IvaImp();
        try {
            List<Iva> iv = sqlIva.obtener();
            if (iv.size() > 0) {
                iv.forEach((tmp) -> {
                    lst.add(tmp);
                });
            }
        } catch (Exception e) {
            principal.Mensaje.failed("No se pudo Obtener el Iva");

        }
        return lst;
    }

    public void formModificar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("MODIFICAR IVA");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfNombre = new JFXTextField(iva.getNombre());
                tfNombre.setPromptText("Porcentaje");
                tfNombre.setLabelFloat(true);

                tfPrecio = new JFXTextField(String.valueOf(iva.getPrecio()));
                tfPrecio.setPromptText("Precio");
                tfPrecio.setLabelFloat(true);

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
                Contenedor.getChildren().addAll(titulo, tfNombre, tfPrecio, ctnBotones);
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
                lblITitulo = new Label("ELIMINAR Iva");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);

                tfNombre = new JFXTextField(iva.getNombre());
                tfNombre.setPromptText("Porcentaje");
                tfNombre.setLabelFloat(true);
                tfNombre.setDisable(true);

                tfPrecio = new JFXTextField(String.valueOf(iva.getPrecio()));
                tfPrecio.setPromptText("Precio");
                tfPrecio.setLabelFloat(true);
                tfPrecio.setDisable(true);

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
                Contenedor.getChildren().addAll(titulo, tfNombre, tfPrecio, ctnBotones);
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

       /**
     * *************************************************************************
     *                                                                         *
     * IMPLEMENTACION DE LOS EVETOS * *
     * *************************************************************************
     */
    private EventHandler InsertarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            IIva sqlIva = new IvaImp();

            try {
                List<Iva> lst = new ArrayList<>();
                lst = sqlIva.obtener();
                iva.setCodigo(lst.get(lst.size() - 1).getCodigo() + 1);
                iva.setNombre(tfNombre.getText());
                iva.setPrecio(Double.parseDouble(tfPrecio.getText()));
                if (sqlIva.insertar(iva) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Nuevo Iva Ingresado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("Error al Ingresar Iva!");
            }
        };
        return handler;
    }

    private EventHandler EliminarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        IIva sqlIva = new IvaImp();
        EventHandler h = (t) -> {
            try {
                if (sqlIva.eliminar(iva) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Iva " + iva.getNombre()+ "% eliminado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Eliminar el Iva");
            }
        };
        return h;
    }

    private EventHandler ModificarActionListener(AnchorPane root, StackPane fondo, BorderPane panel) {
        EventHandler handler = (t) -> {
            try {
                IIva sqlIva = new IvaImp();
                iva.setNombre(tfNombre.getText());
                iva.setPrecio(Double.parseDouble(tfPrecio.getText()));
                if (sqlIva.modificar(iva) > 0) {
                    root.getChildren().remove(fondo);
                    principal.Mensaje.successful("Iva Modificado");
                    crearTabla(panel);
                }
            } catch (Exception e) {
                principal.Mensaje.failed("No se Pudo Modificar el Iva");
            }
        };
        return handler;
    }
}


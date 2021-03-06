package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.ICliente;
import com.fact.dao.contrato.IDetalleFacturaCliente;
import com.fact.dao.contrato.IFacturaCliente;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.impl.ClienteImp;
import com.fact.dao.impl.DetalleFacturaClienteImp;
import com.fact.dao.impl.FacturaClienteImp;
import com.fact.dao.impl.ProductoImp;
import com.fact.dao.rnegocio.entidades.Cliente;
import com.fact.dao.rnegocio.entidades.DetalleFacturaCliente;
import com.fact.dao.rnegocio.entidades.FacturaCliente;
import com.fact.dao.rnegocio.entidades.Producto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class frmFactura {

    private static TableView<DetalleFacturaCliente> tabla;
    private JFXComboBox<Producto> cmbProducto = new JFXComboBox<>();
    private JFXTextField tfCantidad;
    private JFXTextField tfPrecio;
    private JFXTextField tfTotal;
    private Label lbFactura;
    private TextField jtFactura;
    private Label lbCliente;
    private JFXComboBox<Cliente> cmbCliente = new JFXComboBox<>();
    private Label lbFecha;
    private TextField jtFecha;
    private Label lbDireccion;
    private TextField jtDireccion;
    List<Producto> lisProducto = new ArrayList<>();
    List<Cliente> lisCliente = new ArrayList<>();
    List<FacturaCliente> lisFactura = new ArrayList<>();
    Producto pro = new Producto();
    IProducto ipro = new ProductoImp();
    ICliente icliente = new ClienteImp();
    FacturaCliente fac = new FacturaCliente();
    IFacturaCliente ifac = new FacturaClienteImp();

    public void panelDerecho(AnchorPane root, BorderPane layout) {
        VBox contenedor = new VBox(10);
        Label lblTitle = new Label("Detalle de la factura");//Titulo de la Ventana Label de (javafx.scene.control.Label)
        lblTitle.setAlignment(Pos.BOTTOM_CENTER);
        lblTitle.setMinHeight(50);

        //Componentes
        VBox Contendor = new VBox(10);
        try {
            lisProducto = ipro.obtener();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cmbProducto.setItems(FXCollections.observableArrayList(lisProducto));
        cmbProducto.setPromptText("Producto");
        cmbProducto.setLabelFloat(true);

        tfCantidad = new JFXTextField();
        tfCantidad.setPromptText("Cantidad");
        tfCantidad.setLabelFloat(true);

        tfPrecio = new JFXTextField();
        tfPrecio.setPromptText("Precio");
        tfPrecio.setLabelFloat(true);

        tfTotal = new JFXTextField();
        tfTotal.setPromptText("Total");
        tfTotal.setLabelFloat(true);
        tfTotal.setDisable(true);

        //Contenedor de Botones
        HBox ctnBotones = new HBox(15);
        {
            JFXButton btnAceptar = new JFXButton("Aceptar");
            btnAceptar.setOnAction((t) -> {
                InsertarActionListener();
            });
            JFXButton btnCalular = new JFXButton("Calcular");
            btnCalular.setOnAction((t) -> {
                double a, b, c;
                a = Double.parseDouble(tfPrecio.getText());
                b = Double.parseDouble(tfCantidad.getText());
                c = a * b;
                tfTotal.setText(String.valueOf(c));
                cargarTablas();
            });
            ctnBotones.getChildren().addAll(btnAceptar, btnCalular);
        }
        HBox ctnBotones1 = new HBox(15);
        {
            JFXButton btnLimpiar = new JFXButton("Limpiar");
            btnLimpiar.setOnAction((t) -> {
                tfCantidad.setText("");
                tfPrecio.setText("");
                tfTotal.setText("");
            });
            ctnBotones1.getChildren().addAll(btnLimpiar);
            ctnBotones1.setAlignment(Pos.BOTTOM_CENTER);
        }
        Contendor.getChildren().addAll(cmbProducto, tfCantidad, tfPrecio, tfTotal, ctnBotones, ctnBotones1);
        Contendor.setStyle("-fx-background-color:rgb(0,92,150);-fx-padding:5");
        Contendor.setAlignment(Pos.CENTER);
        Contendor.setSpacing(30);
        Contendor.getStyleClass().add("detalle");
        VBox.setVgrow(Contendor, Priority.ALWAYS);

        //Contenedor de Botones y Label
        VBox cntTitle = new VBox();
        cntTitle.getChildren().addAll(lblTitle, Contendor);
        cntTitle.setStyle("-fx-background-color:rgb(0,92,150);-fx-padding:5");
        cntTitle.setAlignment(Pos.CENTER);
        VBox.setVgrow(cntTitle, Priority.ALWAYS);

        //Agregado el de arriba al escenario
        contenedor.setStyle("-fx-background-color:white");
        contenedor.getChildren().addAll(cntTitle);
        contenedor.getStylesheets().addAll(this.getClass().getResource("estilos/Detalle.css").toExternalForm());
        contenedor.setMinWidth(200);
        layout.setRight(contenedor);
    }

    public void panelArriba(AnchorPane root, BorderPane layout) {
        VBox contenedor = new VBox(10);
        //Titutlo
        Label lblTitle = new Label("AUTO LUJOS 2000");//Titulo de la Ventana Label de (javafx.scene.control.Label)
        Label lblTitle1 = new Label("Todo para su Auto");
        lblTitle.setAlignment(Pos.BOTTOM_CENTER);
        lblTitle.setMinHeight(20);
        lblTitle1.setAlignment(Pos.BOTTOM_CENTER);
        lblTitle1.setMinHeight(20);
        VBox Contendor = new VBox(10);

        //Componentes
        lbFecha = new Label("Fecha:");
        jtFecha = new TextField("");
        
        try {
            lisFactura = ifac.obtener();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        lbFactura = new Label("Numero de Factura:");
        jtFactura = new TextField(String.valueOf(lisFactura.get(lisFactura.size()-1).getNumero()+1));
        jtFactura.setDisable(true);

        lbCliente = new Label("Cliente:");
        try {
            lisCliente = icliente.obtener();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cmbCliente.setItems(FXCollections.observableArrayList(lisCliente));

        lbDireccion = new Label("Direccion:");
        jtDireccion = new TextField("Av. Antonio José de Sucre y Febres Cordero");

        JFXButton btnAceptar = new JFXButton("Generar");
        jtFecha = new TextField(String.valueOf(new Date()));
        btnAceptar.setDefaultButton(true);
        HBox primero = new HBox();
        {
            primero.getChildren().addAll(lbFactura, jtFactura, lbFecha, jtFecha, btnAceptar);
        }

        HBox segundo = new HBox();
        {
            segundo.getChildren().addAll(lbCliente, cmbCliente, lbDireccion, jtDireccion);
        }
        primero.setSpacing(60);
        segundo.setSpacing(60);
        Contendor.getChildren().addAll(primero, segundo);
        Contendor.setStyle("-fx-background-color:rgb(0,92,150);-fx-padding:5");
        Contendor.setAlignment(Pos.CENTER);
        Contendor.setSpacing(30);
        Contendor.getStyleClass().add("detalle");
        VBox.setVgrow(Contendor, Priority.ALWAYS);

        //Contenedor de Botones y Label
        VBox cntTitle = new VBox();
        cntTitle.getChildren().addAll(lblTitle, lblTitle1, Contendor);
        cntTitle.setStyle("-fx-background-color:rgb(0,92,150);-fx-padding:5");
        cntTitle.setAlignment(Pos.CENTER);
        VBox.setVgrow(cntTitle, Priority.ALWAYS);

        //Agregado el de arriba al escenario
        contenedor.setStyle("-fx-background-color:white");
        contenedor.getChildren().addAll(cntTitle);
        contenedor.getStylesheets().addAll(this.getClass().getResource("estilos/Detalle.css").toExternalForm());
        contenedor.setMinWidth(200);
        layout.setTop(contenedor);
    }

    public void crearTabla(BorderPane contenedor) {
        contenedor.setCenter(Tabla());
    }

    public void cargarTablas() {
        tabla = Tabla();
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

    private static TableView<DetalleFacturaCliente> Tabla() {
        tabla = new TableView<>();

        TableColumn<DetalleFacturaCliente, Producto> colProducto = new TableColumn<>("Producto");
        colProducto.setMinWidth(100);
        colProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));

        TableColumn<DetalleFacturaCliente, Double> colCantidad = new TableColumn<>("Cantidad");
        colCantidad.setMinWidth(100);
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<DetalleFacturaCliente, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setMinWidth(100);
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<DetalleFacturaCliente, Double> colTotal = new TableColumn<>("Total");
        colTotal.setMinWidth(100);
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        tabla.setItems(getDetalleFactura());
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tabla.getColumns().addAll(colProducto, colCantidad, colPrecio, colTotal);

        return tabla;
    }

    private static ObservableList<DetalleFacturaCliente> getDetalleFactura() {
        ObservableList<DetalleFacturaCliente> lst = FXCollections.observableArrayList();
        IDetalleFacturaCliente sqlProducto = new DetalleFacturaClienteImp();
        try {
            List<DetalleFacturaCliente> productos = sqlProducto.obtener();
            if (productos.size() > 0) {
                productos.forEach((tmp) -> {
                    lst.add(tmp);
                });
            }
        } catch (Exception e) {

        }
        return lst;
    }

    private EventHandler InsertarActionListener() {
        EventHandler h = (t) -> {
            DetalleFacturaCliente producto = new DetalleFacturaCliente();
            IDetalleFacturaCliente sqlProducto = new DetalleFacturaClienteImp();

            try {

                FacturaCliente fac = new FacturaCliente();
                IFacturaCliente Ifac = new FacturaClienteImp();
                List<DetalleFacturaCliente> lst = new ArrayList<>();
                lst = sqlProducto.obtener();
                producto.setCodigo(lst.get(lst.size() - 1).getCodigo() + 1);
                producto.setProducto(cmbProducto.getSelectionModel().getSelectedItem());
                producto.setCantidad(Integer.parseInt(tfCantidad.getText()));
                producto.setPrecio(Double.parseDouble(tfPrecio.getText()));
                producto.setTotal(Double.parseDouble(tfTotal.getText()));
                producto.setFactura(ifac.obtener(Integer.parseInt(jtFactura.getText())));
                sqlProducto.insertar(producto);
            } catch (Exception e) {
            }
        };
        return h;
    }
}
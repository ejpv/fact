/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.accesoadatos.Conexion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author acer1
 */
public class frmReportes {

    private static Label lblITitulo;
    private static JasperPrint reportFilled;
    private static JasperViewer viewer;
    private static JasperReport report;
    private static Connection conn;
    private static String path;

    public void frmMostrar(AnchorPane root, BorderPane panel) {
        StackPane fondo = new StackPane();
        {
            VBox Contenedor = new VBox(25);
            {
                lblITitulo = new Label("REPORTES");
                lblITitulo.setStyle("-fx-text-fill:white;-fx-padding:5"); //Color del Texto
                HBox titulo = new HBox();
                titulo.getChildren().add(lblITitulo);
                HBox.setHgrow(titulo, Priority.ALWAYS);
                titulo.setAlignment(Pos.CENTER);
                HBox Medio = new HBox(25);
                VBox panelIz = new VBox(25);
                VBox panelDe = new VBox(25);
                
                Label reporte1 = new Label("Inventario");
                reporte1.setStyle("-fx-text-fill:white;-fx-padding:5");
                JFXButton btn1 = new JFXButton("Mostrar");

                btn1.setOnAction(btnReporte1ActionListener());

                Label reporte2 = new Label("Mayor compra de Clientes");
                reporte2.setStyle("-fx-text-fill:white;-fx-padding:5");
                JFXButton btn2 = new JFXButton("Mostrar");

                btn2.setOnAction(btnReporte2ActionListener());
                
                panelIz.getChildren().addAll(reporte1, reporte2);
                panelDe.getChildren().addAll(btn1, btn2);
                Medio.getChildren().addAll(panelIz, panelDe);
                HBox Botones = new HBox();

                JFXButton btnCancelar = new JFXButton("Cancelar");
                btnCancelar.setOnAction((t) -> {
                    root.getChildren().remove(fondo);
                });
                Botones.getChildren().addAll(btnCancelar);
                Botones.setSpacing(20);
                Botones.setAlignment(Pos.CENTER);

                Contenedor.getChildren().addAll(titulo, Medio, Botones);
                Contenedor.getStyleClass().add("panel");
                Contenedor.getStylesheets().addAll(this.getClass().getResource("estilos/Botones.css").toExternalForm());
                Contenedor.setPadding(new Insets(15));
                Contenedor.setStyle("-fx-background-color: rgb(10,20,50)");
                Contenedor.setMaxSize(380, 250);
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

    private EventHandler<ActionEvent> btnReporte1ActionListener() {
            EventHandler handler = (Event t) -> {
            Conexion con = new Conexion();
            JasperReport reporte = null;
            path = "C:\\Users\\acer1\\Documents\\Unach\\5to\\Proyecto\\fact\\Fact\\src\\com\\fact\\dao\\rnegocio\\vistas\\formularios\\reportes\\Reporte_1.jasper";
            try {
                conn = con.conectar();
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
                JasperViewer viewer = new JasperViewer(jprint, false);
                viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewer.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return handler;
    }
    
    private EventHandler<ActionEvent> btnReporte2ActionListener() {
            EventHandler handler = (Event t) -> {
            Conexion con = new Conexion();
            JasperReport reporte = null;
            path = "C:\\Users\\acer1\\Documents\\Unach\\5to\\Proyecto\\fact\\Fact\\src\\com\\fact\\dao\\rnegocio\\vistas\\formularios\\reportes\\Reporte_2.jasper";
            try {
                conn = con.conectar();
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
                JasperViewer viewer = new JasperViewer(jprint, false);
                viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewer.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return handler;
    }

}

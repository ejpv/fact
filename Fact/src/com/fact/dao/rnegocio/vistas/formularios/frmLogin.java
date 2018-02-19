/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas.formularios;

import com.fact.dao.contrato.IEmpleado;
import com.fact.dao.rnegocio.entidades.Empleado;
import com.fact.dao.impl.EmpleadoImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author acer1
 */
public class frmLogin extends Application{
    
    @Override
    public void start(Stage primarystage) throws Exception {
        AnchorPane root = new AnchorPane();
        {
            //Cuadro de texto
            JFXTextField txUsuario = new JFXTextField("ejpv"); 
            txUsuario.setPromptText("Ingrese Usuario");
            txUsuario.setLabelFloat(true);
            txUsuario.setLayoutY(175);
            AnchorPane.setBottomAnchor(txUsuario, 130.0);
            AnchorPane.setLeftAnchor(txUsuario, 25.0);
            AnchorPane.setRightAnchor(txUsuario, 25.0);
            txUsuario.setFocusColor(Color.WHITE);
            txUsuario.setStyle("-fx-background-color:rgb(10,20,50)");
            txUsuario.getStylesheets().addAll(this.getClass().getResource("estilos/Login.css").toExternalForm());
            
            
            //Cuadro de Contraseña
            JFXPasswordField pass = new JFXPasswordField(); 
            pass.setPromptText("Ingrese Contraseña");
            pass.setLabelFloat(true);
            pass.setLayoutY(175);
            AnchorPane.setBottomAnchor(pass, 80.0);
            AnchorPane.setLeftAnchor(pass, 25.0);
            AnchorPane.setRightAnchor(pass, 25.0);
            pass.setFocusColor(Color.WHITE);
            pass.setStyle("-fx-background-color:rgb(10,20,50)");
            
            //IMG
            ImageView ivCheck = new ImageView();
            ivCheck.setFitHeight(25);
            ivCheck.setFitWidth(25);
            ivCheck.setLayoutY(175);
            AnchorPane.setRightAnchor(ivCheck, 25.0);

            //Mensaje de Error
            StackPane cnrDilogo = new StackPane();
            JFXDialog dialogo = new JFXDialog();
            Label msuser = new Label("Usuario o Contraseña Incorrectos");
            dialogo.setContent(msuser);
            cnrDilogo.setLayoutY(430);
            cnrDilogo.setLayoutX(85);
            cnrDilogo.setAlignment(Pos.TOP_CENTER);

            //Botones
            JFXButton btnLogin = new JFXButton("Ingresar");
            JFXButton btnSalir = new JFXButton("Salir");
            
            //Estilo del boton
            btnSalir.setTextFill(Color.WHITE);            
            btnSalir.setStyle("-fx-background-color:rgb(10,20,50)");
            btnLogin.setTextFill(Color.WHITE);            
            btnLogin.setStyle("-fx-background-color:rgb(10,20,50)");
            
            //Posicion del Boton
            AnchorPane.setBottomAnchor(btnLogin, 25.0);
            AnchorPane.setRightAnchor(btnLogin, 75.0);
            AnchorPane.setBottomAnchor(btnSalir, 25.0 );//Vertical 0.0 es abajo
            AnchorPane.setRightAnchor(btnSalir, 225.0);//Horizontal 0.0 es derecha

            root.getChildren().addAll(txUsuario, ivCheck, cnrDilogo, btnLogin, btnSalir, pass);

            btnLogin.setOnAction((t) -> {
                IEmpleado sqleEmpleado = new EmpleadoImp();

                try {
                    Empleado user = sqleEmpleado.obtener(txUsuario.getText(),pass.getText());
                    Mensaje("Inicio de sesión","Bienvenid@ "+ user.getNombre()+ " " + user.getApellido());
                    //IFactura sqlFactura = new FacturaImp();
                    //frmPrincipal principal = new frmPrincipal();
                    //principal.setCedulaEmpleado(empleado.getCedula());
                    //principal.start();
            //        primarystage.close();
                } catch (Exception e) {
                    System.err.println("Usuario o Contraseña Incorrectos");
                    dialogo.show(cnrDilogo);
                }
            });
            btnSalir.setOnAction((t) -> {
                System.exit(0);
            });
            root.getStyleClass().add("root");
        }
        Scene scene = new Scene(root, 350, 450);
        scene.setFill(new Color(0, 0, 0, 0));
        scene.getStylesheets().addAll(this.getClass().getResource("estilos/Login.css").toExternalForm());
        primarystage.setTitle("Fact");
        primarystage.getIcons().add(new Image(getClass().getResource("../img/Icono.png").toExternalForm()));
        primarystage.setScene(scene);
        primarystage.initStyle(StageStyle.TRANSPARENT);
        
        primarystage.show();
        
    }

    private static void Mensaje(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setContentText(mensaje);
        alert.setY(540);
        alert.setX(460);
        alert.showAndWait();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
    }

    }

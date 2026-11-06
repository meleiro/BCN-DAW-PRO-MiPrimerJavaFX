package com.ejemplo.perfil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;

public class PerfilController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtEdad;

    @FXML
    private ComboBox<String> cmbEstudios;

    @FXML
    private Label lblMensaje;

    @FXML
    private void initialize(){
        cmbEstudios.getItems().addAll("Elige un estudio","DAM", "DAW", "ASIR");
    }


    @FXML
    private void mostrarResumen(){

        String nombre = txtNombre.getText();
        String email = txtMail.getText();

        if (nombre.isBlank() || email.isBlank()){
            lblMensaje.setText("Tienes que introducir nombre e email");
            return;
        }

        String estudios = cmbEstudios.getValue();

        if (estudios == "Elige un estudio")
        {
            lblMensaje.setText("Tienes que introducir algún estudio");
            return;
        }

        String textoEdad= txtEdad.getText();
        if (textoEdad.isBlank()){
            lblMensaje.setText("Tienes que introducir una edad");
            return;
        }

        try {
            int edad = Integer.parseInt(textoEdad);
        } catch (NumberFormatException e) {
            lblMensaje.setText("La edad tiene que ser un número");
            return;
        }

        String resumen = "Nombre: " + nombre + "\nEdad: " + textoEdad
                + "\nEmail: " + email + "\nEstudios: " + estudios;

        lblMensaje.setText(resumen);

        abrirVentanaResumen(nombre, email, estudios );



    }

    @FXML
    private void limpiarFormulario(){

        txtNombre.clear();
        txtEdad.clear();
        txtMail.clear();
        cmbEstudios.getSelectionModel().clearSelection();
        lblMensaje.setText("");

    }

    @FXML
    private void abrirVentanaResumen(String nombre, String email, String preferencias){

        try {
            FXMLLoader loader = new FXMLLoader(
                    MainApplication.class.getResource("resumen-view.fxml")
            );

            Scene scene = new Scene(loader.load());

            ResumenController controller =
                    loader.getController();

            controller.cargarDatos(nombre, email, preferencias);

            Stage stage = new Stage();

            stage.setTitle("Resumen del perfil de" + nombre );

            stage.setScene(scene);

            stage.show();



        } catch (IOException e){
            e.printStackTrace();
        }
    }



}

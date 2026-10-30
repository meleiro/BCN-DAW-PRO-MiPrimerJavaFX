package com.ejemplo.perfil;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;



import java.awt.*;

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
        cmbEstudios.getItems().addAll("DAM", "DAW", "ASIR");
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

        if (estudios == null)
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



    }

    @FXML
    private void limpiarFormulario(){

        txtNombre.clear();
        txtEdad.clear();
        txtMail.clear();
        cmbEstudios.getSelectionModel().clearSelection();
        lblMensaje.setText("");

    }



}

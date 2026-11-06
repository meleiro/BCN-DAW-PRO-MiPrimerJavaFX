package com.ejemplo.perfil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResumenController {
    @FXML
    private Label lblNombre;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPreferencias;

    public void cargarDatos ( String nombre, String email, String preferencias){
        lblNombre.setText("Nombre: " + nombre);
        lblEmail.setText("Email: " + email);
        lblPreferencias.setText("Preferencias: " + preferencias);

    }

    @FXML
    private void cerrarVentana(){
        Stage stage =
                (Stage) lblNombre
                        .getScene()
                        .getWindow();
        stage.close();
    }



}

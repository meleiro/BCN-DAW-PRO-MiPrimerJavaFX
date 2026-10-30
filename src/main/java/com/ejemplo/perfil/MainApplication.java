package com.ejemplo.perfil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/** Punto de partida ya preparado: el alumnado completa las vistas y controladores. */
public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

       FXMLLoader loader = new FXMLLoader(
               MainApplication.class.getResource("perfil-view.fxml")
       );

       Scene scene = new Scene( loader.load(), 500, 400);

       stage.setScene(scene);

       stage.setTitle("Gstor de Perfil - JavaFX");

       stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}

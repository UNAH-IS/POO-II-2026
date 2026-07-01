package com.unah;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void salir() {
        System.exit(0);
    }

    @FXML
    private void mostrarFormularioAlumnos() throws IOException {
        App.mostrarFormularioAlumnos();
    }

    @FXML
    private void mostrarFormularioMaestros() throws IOException {
        App.mostrarFormularioMaestros();
    }

    @FXML
    private void mostrarFormularioCarreras() throws IOException {
        App.mostrarFormularioCarreras();
    }
}

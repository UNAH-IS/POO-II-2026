package com.unah;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class PrimaryController {
    @FXML
    private TextArea contenidoArchivo;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void abrirArchivo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir archivo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt")
        );
        File archivoSeleccionado = fileChooser.showOpenDialog(null);

        System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivoSeleccionado)); 
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
                contenidoArchivo.appendText(linea + "\n");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void guardarArchivo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt")
        );
        File archivoSeleccionado = fileChooser.showSaveDialog(null);

        System.out.println("Archivo guardado: " + archivoSeleccionado.getAbsolutePath());
        try {
            FileWriter writer = new FileWriter(archivoSeleccionado);
            writer.write(contenidoArchivo.getText());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

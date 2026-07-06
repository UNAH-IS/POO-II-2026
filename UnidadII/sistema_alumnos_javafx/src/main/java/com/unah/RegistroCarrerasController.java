package com.unah;

import java.net.URL;
import java.util.ResourceBundle;

import com.unah.clases.Carrera;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class RegistroCarrerasController implements Initializable {
    @FXML private TextField txtCodigoCarrera;
    @FXML private TextField txtNombreCarrera;
    @FXML private TextField txtCantidadClases;
    @FXML private ListView<Carrera> lstCarreras;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;

    @FXML
    public void guardarCarrera() {
        Carrera carrera = new Carrera(
            txtCantidadClases.getText().isEmpty() ? 0 : Integer.parseInt(txtCantidadClases.getText()),
            txtCodigoCarrera.getText(),
            txtNombreCarrera.getText()
        );

        App.carreras.add(carrera);
        limpiarCampos();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Carrera Guardada");
        alert.setHeaderText(null);
        alert.setContentText("La carrera ha sido guardada exitosamente.");
        alert.showAndWait();
    }

    @FXML
    public void limpiarCampos() {
        txtCodigoCarrera.clear();
        txtNombreCarrera.clear();
        txtCantidadClases.clear();
        lstCarreras.getSelectionModel().clearSelection();

        btnGuardar.setDisable(false);
        btnActualizar.setDisable(true);
        btnEliminar.setDisable(true);
    }

    @FXML 
    public void eliminarCarrera() {
        Carrera carreraSeleccionada = lstCarreras.getSelectionModel().getSelectedItem();
        if (carreraSeleccionada != null) {
            Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
            mensaje.setTitle("Confirmación de Eliminación");
            mensaje.setHeaderText("¿Está seguro de que desea eliminar la carrera seleccionada?");
            mensaje.setContentText("Esta acción no se puede deshacer.");
            mensaje.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    App.carreras.remove(carreraSeleccionada);
                    limpiarCampos();
                }
            });
        }
    }

    @FXML
    public void actualizarCarrera() {
        Carrera carreraSeleccionada = lstCarreras.getSelectionModel().getSelectedItem();
        if (carreraSeleccionada != null) {
            carreraSeleccionada.setCodigoCarrera(txtCodigoCarrera.getText());
            carreraSeleccionada.setNombreCarrera(txtNombreCarrera.getText());
            carreraSeleccionada.setCantidadClases(txtCantidadClases.getText().isEmpty() ? 0 : Integer.parseInt(txtCantidadClases.getText()));
            lstCarreras.refresh();
            limpiarCampos();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Carrera Actualizada");
            alert.setHeaderText(null);
            alert.setContentText("La carrera ha sido actualizada exitosamente.");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lstCarreras.setItems(App.carreras);

        lstCarreras.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Carrera>() {

            @Override
            public void changed(ObservableValue<? extends Carrera> observable, Carrera oldValue, Carrera newValue) {
                if (newValue != null) {
                    txtCodigoCarrera.setText(newValue.getCodigoCarrera());
                    txtNombreCarrera.setText(newValue.getNombreCarrera());
                    txtCantidadClases.setText(String.valueOf(newValue.getCantidadClases()));

                    btnGuardar.setDisable(true);
                    btnActualizar.setDisable(false);
                    btnEliminar.setDisable(false);
                }
            }
            
        });
    }
}

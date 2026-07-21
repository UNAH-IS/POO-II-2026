package com.unah;

import java.io.IOException;

import com.unah.clases.Alumno;
import com.unah.clases.Carrera;
import com.unah.clases.Maestro;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static ObservableList<Carrera> carreras = FXCollections.observableArrayList();
    public static ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
    public static ObservableList<Maestro> maestros = FXCollections.observableArrayList();
    public static ObservableList<String> categoriasDocentes = FXCollections.observableArrayList();

    private static Stage formularioAlumnos;
    private static Stage formularioMaestros;
    private static Stage formularioCarreras;

    @Override
    public void start(Stage formularioPrincipal) throws IOException {
        scene = new Scene(loadFXML("main"));
        formularioPrincipal.setScene(scene);
        cargarCarreras();
        cargarCategoriasDocentes();
        alumnos = Alumno.cargarInformacionDesdeArchivo();
        formularioPrincipal.show();
    }

    public static void mostrarFormularioAlumnos() throws IOException {
        if (formularioAlumnos == null) {
            crearFormularioAlumnos();
        }
        formularioAlumnos.show();
    }

    public static void crearFormularioAlumnos() throws IOException  {
        formularioAlumnos = new Stage();
        formularioAlumnos.setTitle("Formulario de Alumnos");
        formularioAlumnos.setScene(new Scene(loadFXML("registro-alumnos")));
    }

    public static void mostrarFormularioMaestros() throws IOException {
        if (formularioMaestros == null) {
            formularioMaestros = new Stage();
            formularioMaestros.setTitle("Formulario de Maestros");
            formularioMaestros.setScene(new Scene(loadFXML("registro-maestros")));
        }
        formularioMaestros.show();
    }

    public static void mostrarFormularioCarreras() throws IOException {
        if (formularioCarreras == null) {
            formularioCarreras = new Stage();
            formularioCarreras.setTitle("Formulario de Carreras");
            formularioCarreras.setScene(new Scene(loadFXML("registro-carreras")));
        }
        formularioCarreras.show();
    }

    public void cargarCarreras() {
        carreras.add(new Carrera(50, "ISC", "Ingenieria en Sistemas Computacionales"));
        carreras.add(new Carrera(40, "IM", "Ingenieria en Mecanica"));
        carreras.add(new Carrera(30, "IE", "Ingenieria en Electronica"));
    }

    public void cargarCategoriasDocentes() {
        categoriasDocentes.add("Titular I");
        categoriasDocentes.add("Titular II");
        categoriasDocentes.add("Titular III");
        categoriasDocentes.add("Auxiliar");
        categoriasDocentes.add("Por Hora");
        categoriasDocentes.add("Horario Parcial");
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
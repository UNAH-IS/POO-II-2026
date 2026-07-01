package com.unah;

import java.io.IOException;
import java.time.LocalDate;

import com.unah.clases.Alumno;
import com.unah.clases.Carrera;

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


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("registro-alumnos"));
        stage.setScene(scene);
        cargarCarreras();
        cargarAlumnos();
        stage.show();
    }

    public void cargarCarreras() {
        carreras.add(new Carrera(50, "ISC", "Ingenieria en Sistemas Computacionales"));
        carreras.add(new Carrera(40, "IM", "Ingenieria en Mecanica"));
        carreras.add(new Carrera(30, "IE", "Ingenieria en Electronica"));
    }

    public void cargarAlumnos() {
        alumnos.add(new Alumno("Juan", "Perez", 20, carreras.get(0), "0801-1990-12345", "Masculino", "123456789", 85.5f, 30, LocalDate.of(2000, 10, 15)));
        alumnos.add(new Alumno("Maria", "Gonzalez", 22, carreras.get(1), "0801-1998-54321", "Femenino", "987654321", 90.0f, 35, LocalDate.of(2001, 5, 20)));
        alumnos.add(new Alumno("Pedro", "Lopez", 21, carreras.get(2), "0801-1995-67890", "Masculino", "456789123", 75.0f, 25, LocalDate.of(2002, 3, 10)));
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
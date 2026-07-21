package com.unah.clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.unah.App;
import com.unah.interfaces.Administrable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Alumno extends Persona implements Administrable {
    private String cuenta;
    private float promedio;
    private int clasesAprobadas;
    
    public static int contadorAlumnos = 0; //contador para llevar el número de alumnos creados

    public Alumno() {
     
    }

    public Alumno (
        String nombre, 
        String apellido, 
        int edad, 
        Carrera carrera, 
        String identidad, 
        String genero, 
        String cuenta, 
        float promedio, 
        int clasesAprobadas,
        LocalDate fechaNacimiento
    ) {
        super(nombre, apellido, edad, carrera, identidad, genero, fechaNacimiento);
        this.cuenta = cuenta;
        this.promedio = promedio;
        this.clasesAprobadas = clasesAprobadas;
    }

    //Este constructor está sobrecardo 3 veces, el constructor vacío, el constructor con todos los parámetros y este constructor con solo el nombre y apellido, esto es un ejemplo de sobrecarga de constructores
    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void mostrarNombre() {
        System.out.println(this.nombre + " " + this.apellido);
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getClasesAprobadas() {
        return clasesAprobadas;
    }

    public void setClasesAprobadas(int clasesAprobadas) {
        this.clasesAprobadas = clasesAprobadas;
    }

    @Override
    public String toString() {
        return "Cuenta: " + this.cuenta + ", " + 
               super.toString() + ", " + 
               "Promedio: " + this.promedio + ", " + 
               "Clases Aprobadas: " + this.clasesAprobadas;
    }

    @Override
    public String toCSV() {
        return this.cuenta + "," + 
               super.toCSV() + "," + 
               this.promedio + "," + 
               this.clasesAprobadas;
    }

    @Override
    public ArrayList<String> validarCampos() {
        ArrayList<String> errores = super.validarCampos();
        
        String errorCuenta = validarCampo("\\d{11}", this.cuenta, "La cuenta debe tener 11 dígitos");
        if (errorCuenta != null) {
            errores.add(errorCuenta);
        }

        String errorPromedio = validarCampo("\\d+(\\.\\d+)?", String.valueOf(this.promedio), "El promedio debe ser un número decimal");
        if (errorPromedio != null) {
            errores.add(errorPromedio);
        }

        String errorClasesAprobadas = validarCampo("\\d+", String.valueOf(this.clasesAprobadas), "Las clases aprobadas deben ser un número entero");
        if (errorClasesAprobadas != null) {
            errores.add(errorClasesAprobadas);
        }

        return errores;
    }

    @Override
    public void guardarInformacionEnArchivo() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Administrable.NOMBRE_ARCHIVO, true));
            writer.write(this.toCSV());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Alumno> cargarInformacionDesdeArchivo() {
        ObservableList<Alumno> alumnos = FXCollections.observableArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(Administrable.NOMBRE_ARCHIVO));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String partes[] = linea.split(",");

                Carrera carrera = null;
                for (Carrera c : App.carreras) {
                    if (c.getCodigoCarrera().equals(partes[4])) {
                        carrera = c;
                        break;
                    }
                }

                Alumno a = new Alumno(
                    partes[1], // nombre
                    partes[2], // apellido
                    Integer.parseInt(partes[3]), // edad
                    carrera,
                    partes[5], // identidad
                    partes[6], // genero
                    partes[0], // cuenta
                    Float.parseFloat(partes[8]), // promedio
                    Integer.parseInt(partes[9]), // clasesAprobadas
                    LocalDate.parse(partes[7]) // fechaNacimiento
                );

                alumnos.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    //Reescribir completamente el archivo con la informacion del ObservableList
    public static void actualizarInformacionEnArchivo() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Administrable.NOMBRE_ARCHIVO));
            for (Persona p : App.alumnos) {
                if (p instanceof Alumno) {
                    Alumno a = (Alumno) p; // int a = (int) b;
                    writer.write(a.toCSV());
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarInformacionEnArchivo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}

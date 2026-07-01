package com.unah.clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona {
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


}

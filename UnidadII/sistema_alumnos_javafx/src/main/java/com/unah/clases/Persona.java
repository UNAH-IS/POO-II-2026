package com.unah.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Persona {
    protected String nombre; //este sería this.nombre
    protected String apellido;
    protected int edad;
    protected Carrera carrera;
    protected String identidad;
    protected String genero;
    protected LocalDate fechaNacimiento;
    
    public Persona() {}

    public Persona(String nombre, String apellido, int edad, Carrera carrera, String identidad, String genero, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.identidad = identidad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public void setNombre(String nombre) { //set = establecer
        this.nombre = nombre;
    }

    public String getNombre() { //get = obtener
        return this.nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String validarCampo(String patron, String valor, String mensajeError) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(valor);
        boolean resultado = matcher.matches();
        return resultado ? null : mensajeError;  
    }

    public ArrayList<String> validarCampos() {
        ArrayList<String> errores = new ArrayList<String>();
        String errorNombre = validarCampo("[a-zA-Z ]+", this.nombre, "El nombre solo puede contener letras y espacios");
        if (errorNombre != null) {
            errores.add(errorNombre);
        }

        String errorApellido = validarCampo("[a-zA-Z ]+", this.apellido, "El apellido solo puede contener letras y espacios");
        if (errorApellido != null) {
            errores.add(errorApellido);
        }

        String errorEdad = validarCampo("\\d+", String.valueOf(this.edad), "La edad debe ser un número entero");
        if (errorEdad != null) {
            errores.add(errorEdad);
        }

        String errorIdentidad = validarCampo("\\d{4}-\\d{4}-\\d{5}", this.identidad, "La identidad debe tener el formato 0000-0000-00000");
        if (errorIdentidad != null) {
            errores.add(errorIdentidad);
        }

        String errorGenero = validarCampo("Masculino|Femenino", this.genero, "El género debe ser 'Masculino' o 'Femenino'");
        if (errorGenero != null) {
            errores.add(errorGenero);
        }

        if (this.fechaNacimiento == null) {
            errores.add("La fecha de nacimiento no puede estar vacía");
        }

        return errores;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ",\t" +
               "Apellido: " + this.apellido + ",\t" +
               "Edad: " + this.edad + ",\t" +
               "Carrera: " + this.carrera + ",\t" +
               "Identidad: " + this.identidad + ",\t" +
               "Genero: " + this.genero + ",\t" +
               "Fecha de Nacimiento: " + this.fechaNacimiento;
    }    
}

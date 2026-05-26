package clases;

import javax.swing.JOptionPane;

public class Alumno {
    private String nombre; //este sería this.nombre
    private String apellido;
    private int edad;
    private String carrera;
    private String identidad;
    private String genero;

    public Alumno() {
       System.out.println("Se ha creado un nuevo alumno");
    }

    public Alumno(String nombre, String apellido, int edad, String carrera, String identidad, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.identidad = identidad;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
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

    public void solicitarInformacion() {
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno");
        this.apellido = JOptionPane.showInputDialog("Ingrese el apellido del alumno");
        this.edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno"));
        this.carrera = JOptionPane.showInputDialog("Ingrese la carrera del alumno");
        this.identidad = JOptionPane.showInputDialog("Ingrese la identidad del alumno");
        this.genero = JOptionPane.showInputDialog("Ingrese el genero del alumno");
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
               "Apellido: " + this.apellido + "\n" +
               "Edad: " + this.edad + "\n" +
               "Carrera: " + this.carrera + "\n" +
               "Identidad: " + this.identidad + "\n" +
               "Genero: " + this.genero;
    }
}

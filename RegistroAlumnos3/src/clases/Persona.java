package clases;

import interfaces.Administrable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class Persona implements Administrable {
    protected String nombre; //este sería this.nombre
    protected String apellido;
    protected int edad;
    protected Carrera carrera;
    protected String identidad;
    protected String genero;
    
    public Persona() {}

    public Persona(String nombre, String apellido, int edad, Carrera carrera, String identidad, String genero) {
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

    public void solicitarInformacion(ArrayList<Carrera> carreras) {
        String tipoObjeto = "";
        if (this instanceof Alumno) { // objeto instanceof NombreClase -> devuelve true si el objeto es una instancia de la clase especificada o de una subclase de esa clase, y false en caso contrario.
            tipoObjeto = "alumno";
            System.out.println("Solicitando información del alumno...");
        } else if (this instanceof Maestro) {
            tipoObjeto = "maestro";
            System.out.println("Solicitando información del maestro...");
        } else {
            tipoObjeto = "persona";
        }

        String listaCarreras = "Seleccione una carrera:\n";
        for(int i = 0; i< carreras.size(); i++) {
            listaCarreras += i + ". " + carreras.get(i).getNombreCarrera() + "\n";
        }
        
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre del " + tipoObjeto);
        this.apellido = JOptionPane.showInputDialog("Ingrese el apellido del " + tipoObjeto);
        this.edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del " + tipoObjeto));
        this.identidad = JOptionPane.showInputDialog("Ingrese la identidad del " + tipoObjeto);
        this.genero = JOptionPane.showInputDialog("Ingrese el genero del " + tipoObjeto);
        
        int carreraSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(listaCarreras));
        this.carrera = carreras.get(carreraSeleccionada);

        System.out.println("Carrera seleccionada: " + carreraSeleccionada);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ",\t" +
               "Apellido: " + this.apellido + ",\t" +
               "Edad: " + this.edad + ",\t" +
               "Carrera: " + this.carrera + ",\t" +
               "Identidad: " + this.identidad + ",\t" +
               "Genero: " + this.genero;
    }

    public abstract void guardarInformacionEnArchivo(String nombreArchivo);
}

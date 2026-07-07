package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        int clasesAprobadas
    ) {
        super(nombre, apellido, edad, carrera, identidad, genero);
        this.cuenta = cuenta;
        this.promedio = promedio;
        this.clasesAprobadas = clasesAprobadas;
    }

    public void mostrarNombre() {
        System.out.println(this.nombre + " " + this.apellido);
    }

    public void solicitarInformacion(ArrayList<Carrera> carreras) {
        this.cuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta del alumno");
        super.solicitarInformacion(carreras);
        this.promedio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el promedio del alumno"));
        this.clasesAprobadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clases aprobadas del alumno"));
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
    
}

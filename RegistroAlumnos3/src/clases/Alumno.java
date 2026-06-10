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

    //Este constructor está sobrecardo 3 veces, el constructor vacío, el constructor con todos los parámetros y este constructor con solo el nombre y apellido, esto es un ejemplo de sobrecarga de constructores
    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void mostrarNombre() {
        System.out.println(this.nombre + " " + this.apellido);
    }

    @Override
    public void solicitarInformacion(ArrayList<Carrera> carreras) {
        do {
            this.cuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta del alumno");
        } while (!validarCampo("\\d{11}", this.cuenta, "El número de cuenta debe tener 11 dígitos")); //validar que el número de cuenta tenga 11 dígitos

        super.solicitarInformacion(carreras);
        do {
            try {
                this.promedio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el promedio del alumno"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El promedio debe ser un número decimal");
                this.promedio = -1;
            }
        } while (this.promedio < 0 || this.promedio > 100); //validar que el promedio sea un número entre 0 y 100

        do {
            try {
                this.clasesAprobadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clases aprobadas del alumno"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La cantidad de clases aprobadas debe ser un número entero");
                this.clasesAprobadas = -1;
            }
        } while (this.clasesAprobadas < 0); //validar que la cantidad de clases aprobadas sea un número entero positivo
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
    public void guardarInformacionEnArchivo(String nombreArchivo) {
        System.out.println("Guardando información del alumno en el archivo: " + nombreArchivo);
    }

    @Override
    public void cargarInformacionDesdeArchivo(String nombreArchivo) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actualizarInformacionEnArchivo(String nombreArchivo) {
        // TODO Auto-generated method stub
    }

    @Override
    public void eliminarInformacionEnArchivo(String nombreArchivo) {
        // TODO Auto-generated method stub
    }
}

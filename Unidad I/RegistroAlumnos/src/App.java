import clases.Alumno;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class App {
    public static void main(String[] args) throws Exception {
        // TipoDato arreglo[] = new TipoDato[tamaño]; //arreglo de 5 elementos del tipo TipoDato
        // ArrayList<TipoDato> lista = new ArrayList<>(); //lista dinámica del tipo TipoDato
        // <> es el operador diamante, se utiliza para indicar el tipo de dato que se va a almacenar en la lista, es conocido como Raw Type
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        //a1 es un objeto del tipo Alumno, al utilizar new se crea un espacio en 
        // memoria para almacenar los datos del alumno
        // el proceso se le conoce como instanciación, a1 es una instancia de la clase Alumno
        Alumno a1 = new Alumno(); 
        a1.solicitarInformacion();
        JOptionPane.showMessageDialog(null, a1);

        alumnos.add(a1);

        // System.out.println("Nombre: " + a1.getNombre());
        // System.out.println("Apellido: " + a1.getApellido());
        // System.out.println("Edad: " + a1.getEdad());
        // System.out.println("Carrera: " + a1.getCarrera());
        // System.out.println("Identidad: " + a1.getIdentidad());
        // System.out.println("Genero: " + a1.getGenero());

        //Alumno a2 = new Alumno("Maria", "Gomez", 22, "Medicina", "0801199805678", "Femenino");

        //System.out.println("Nombre: " + a2.getNombre());
    }
}

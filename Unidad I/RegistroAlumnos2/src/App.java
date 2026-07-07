import clases.Alumno;
import clases.Carrera;
import clases.Maestro;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class App {
    ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    ArrayList<Maestro> maestros = new ArrayList<Maestro>();
    public static ArrayList<Carrera> carreras = new ArrayList<Carrera>();

    public App() {
        //Ejemplo del modificar static en el atributo contadorAlumnos
        Alumno alumno1 = new Alumno("Erick", "García", 20, new Carrera(50, "ISC", "Ingenieria en Sistemas Computacionales"), "0801-1999-12345", "Masculino", "202610011111", 65.0f, 10);
        Alumno.contadorAlumnos = 10;
        Alumno alumno2 = new Alumno("Maria", "Lopez", 22, new Carrera(40, "IM", "Ingenieria en Mecanica"), "0801-1998-54321", "Femenino", "202610022222", 70.0f, 12);
        Alumno.contadorAlumnos = 20;
        Alumno alumno3 = new Alumno("Juan", "Perez", 21, new Carrera(30, "IE", "Ingenieria en Electronica"), "0801-2000-67890", "Masculino", "202610033333", 75.0f, 15);
        Alumno.contadorAlumnos = 100;

        System.out.println("Contador de alumnos desde alumno1: " + Alumno.contadorAlumnos);
        System.out.println("Contador de alumnos desde alumno2: " + Alumno.contadorAlumnos);
        System.out.println("Contador de alumnos desde alumno3: " + Alumno.contadorAlumnos);


        cargarCarreras();
        mostrarMenu();
    }

    public void cargarCarreras() {
        carreras.add(new Carrera(50, "ISC", "Ingenieria en Sistemas Computacionales"));
        carreras.add(new Carrera(40, "IM", "Ingenieria en Mecanica"));
        carreras.add(new Carrera(30, "IE", "Ingenieria en Electronica"));
    }

    public void mostrarMenu() {
        do {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                1. Agregar alumno
                                                2. Mostrar alumnos
                                                3. Eliminar alumno
                                                4. Agregar carrera
                                                5. Mostrar carreras
                                                6. Eliminar carrera
                                                7. Agregar maestro
                                                8. Mostrar maestros
                                                9. Salir"""));

            switch (opcion) {
                case 1:
                    agregarAlumno();
                    break;
                case 2:
                    mostrarAlumnos();
                    break;
                case 3: 
                    eliminarAlumno();
                    break;
                case 4:
                    agregarCarrera();
                    break;
                case 5:
                    mostrarCarreras();
                    break;
                case 6: 
                    eliminarCarrera();
                    break;
                case 7:
                    agregarMaestro();
                    break;
                case 8: 
                    mostrarMaestros();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        } while (true);
    }

    public void agregarAlumno() {
        Alumno alumno = new Alumno(); 
        alumno.solicitarInformacion(this.carreras);
        alumnos.add(alumno);
    }

    public String obtenerListaAlumnos() {
        String listaAlumnos = "Lista de alumnos:\n";
        for (int i = 0; i < alumnos.size(); i++) {
            listaAlumnos += i + "- " + alumnos.get(i).toString() + "\n";
        }

        return listaAlumnos;
    }

    public void mostrarAlumnos() {
        JOptionPane.showMessageDialog(null,  obtenerListaAlumnos());
    }

    public void eliminarAlumno() {
        int alumnoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog(obtenerListaAlumnos() + "Seleccione el número del alumno a eliminar:"));
        alumnos.remove(alumnoSeleccionado);
    }

    public void agregarCarrera() {
        Carrera carrera = new Carrera();
        carrera.solicitarInformacion();
        carreras.add(carrera);
    }

    public String obtenerListaCarreras() {
        String listaCarreras = "Lista de carreras:\n";
        for (int i = 0; i < carreras.size(); i++) {
            listaCarreras += i + "- " + carreras.get(i).toString() + "\n";
        }

        return listaCarreras;
    }

    public void mostrarCarreras() {
        JOptionPane.showMessageDialog(null,  obtenerListaCarreras());
    }

    public void eliminarCarrera() {
        int carreraSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(obtenerListaCarreras() + "Seleccione el número de la carrera a eliminar:"));
        carreras.remove(carreraSeleccionada);
    }

    public void agregarMaestro() {
        Maestro maestro = new Maestro(); 
        maestro.solicitarInformacion(this.carreras);
        maestros.add(maestro);
    }

    public String obtenerListaMaestros() {
        String listaMaestros = "Lista de maestros:\n";
        for (int i = 0; i < maestros.size(); i++) {
            listaMaestros += i + "- " + maestros.get(i).toString() + "\n";
        }

        return listaMaestros;
    }

    public void mostrarMaestros() {
        JOptionPane.showMessageDialog(null,  obtenerListaMaestros());
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}

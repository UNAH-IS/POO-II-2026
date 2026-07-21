import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    Usuario u1;
    Usuario u2;
    Usuario u3;

    public App() {
        u1 = new Usuario("Juan", "juan@example.com", "password123");
        u2 = new Usuario("Pedro", "pedro@example.com", "password123");
        u3 = new Usuario("Maria", "maria@example.com", "password123");

        escribirArchivoUsuarios();
        leerArchivoUsuarios();
    }

    public void escribirArchivoUsuarios() {
        //Escribir los usuarios en un archivo basado en objetos
        try {
            ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
            flujo.writeObject(u1);
            flujo.writeObject(u2);
            flujo.writeObject(u3);
            flujo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void leerArchivoUsuarios() {
        try {
            ObjectInputStream flujo = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            while (true) {
                Usuario u = (Usuario) flujo.readObject();
                System.out.println(u.getNombre());
            }
            
        } 
        catch (java.io.EOFException e) { //End of file 
            System.out.println("Fin del archivo alcanzado.");
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        new App();
    }
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public App() {
        // leerArchivo();
        escribirArchivo();
    }

    public void leerArchivo() {
        //Leer el archivo utilizando la clase BufferedReader
        try {
            BufferedReader br = new BufferedReader(new FileReader("README.md"));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void escribirArchivo() {
        //Escribir en el archivo utilizando la clase BufferedWriter
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("README.md", false));
            bw.write("Nueva línea de texto");
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}

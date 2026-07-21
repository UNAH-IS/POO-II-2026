import java.io.FileInputStream;
import java.io.FileOutputStream;

//input => Lectura de archivos con flujos basados en bytes
//output => Escribir archivos con flujos basados en bytes

public class App {
    public App() {
        // leerArchivoReadme();
        // escribirArchivo();
        leerArchivoReadmeConBuffer();
    }

    public void leerArchivoReadme() {
        try {
            //Leer archivo readme.md con flujos basados en bytes
            FileInputStream fileInputStream = new FileInputStream("Readme.md");
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                System.out.print((char) data);
            }
            fileInputStream.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void escribirArchivo() {
        try {
            //Escribir archivo con flujos basados en bytes
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            String data = "Hola, este es un ejemplo de escritura de archivos con flujos basados en bytes.";
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void leerArchivoReadmeConBuffer() {
        try {
            //Leer archivo readme.md con flujos basados en bytes y buffer
            FileInputStream fileInputStream = new FileInputStream("Readme.md");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, bytesRead));
            }
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    
    public static void main(String[] args) throws Exception {
        new App();
    }
}

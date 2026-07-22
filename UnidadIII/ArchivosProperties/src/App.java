
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class App {
    public App() {
        // Cargar el archivo de propiedades
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("config.prop");
            properties.load(inputStream);
            System.out.println("Configuración del juego:");
            System.out.println("Vidas: " + properties.getProperty("vidas"));
            System.out.println("Puntaje: " + properties.getProperty("puntaje"));
            System.out.println("Versión: " + properties.getProperty("version"));

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Escribir propiedades en un archivo
        Properties newProperties = new Properties();
        newProperties.setProperty("vidas", "3");
        newProperties.setProperty("puntaje", "20");
        newProperties.setProperty("version", "1.1");
        try {
            FileOutputStream outputStream = new FileOutputStream("config.prop");
            newProperties.store(outputStream, "Configuración del juego actualizada");
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new App();    
    }
}

import java.io.File;


//i => Input
//o => Output

public class App {
    public App() {
        //En el constructor se puede hacer referencia a un archivo o a un directorio
        File archivo = new File("data/archivo.txt"); 
        if (archivo.exists()) {
            System.out.println("El archivo existe");
            System.out.println("Es un archivo: " + archivo.isFile());
            System.out.println("Es un directorio: " + archivo.isDirectory());
            System.out.println("Se puede leer: " + archivo.canRead());
            System.out.println("Se puede escribir: " + archivo.canWrite());
            System.out.println("Tamaño: " + archivo.length() + " bytes");
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Última modificación: " + archivo.lastModified());
        } else {
            System.out.println("El archivo no existe");
            try {
                archivo.createNewFile();
                System.out.println("El archivo se ha creado");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

     
        File directorio = new File("C:/Users/erick/OneDrive/Documents/UNAH/Clases/POO/2026-II/Ejercicios");
        System.out.println("================================");
        if (directorio.exists()) {
            System.out.println("El directorio existe");
            System.out.println("Es un archivo: " + directorio.isFile());
            System.out.println("Es un directorio: " + directorio.isDirectory());
            System.out.println("Se puede leer: " + directorio.canRead());
            System.out.println("Se puede escribir: " + directorio.canWrite());
            System.out.println("Tamaño: " + directorio.length() + " bytes");
            System.out.println("Ruta absoluta: " + directorio.getAbsolutePath());
            System.out.println("Última modificación: " + directorio.lastModified());
            System.out.println("==========> Contenido del directorio:");
            File[] archivos = directorio.listFiles();
            for (File archivoEnDirectorio : archivos) {
                System.out.println("Archivo: " + archivoEnDirectorio.getName());
            }
        } else {
            System.out.println("El directorio no existe");
        }

        for (int i = 0; i < 1000; i++) {
            File archivoNuevo = new File("data/archivo" + i + ".txt");
            try {
                archivoNuevo.createNewFile();
                //System.out.println("Archivo creado: " + archivoNuevo.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}

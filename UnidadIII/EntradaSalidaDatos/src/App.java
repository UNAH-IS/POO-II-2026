import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public App() {
        // escribirArchivo();
        leerArchivo();
    }

    public void escribirArchivo() {
        //Escribir archivo utilizando DataOutputStream
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("archivo.dat"));
            dos.writeUTF("Hola mundo");
            dos.writeInt(123);
            dos.writeDouble(3.14);
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerArchivo() {
        //Leer archivo utilizando DataInputStream
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("archivo.dat"));
            String mensaje = dis.readUTF();
            int numero = dis.readInt();
            double decimal = dis.readDouble();
            dis.close();

            System.out.println("Mensaje: " + mensaje);
            System.out.println("Número: " + numero);
            System.out.println("Decimal: " + decimal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}

package principal;

public class App {
    static String mensaje = "Hola, mundo!"; // Variable de tipo cadena de texto

    public static void main(String[] args) {
        //variables:
        //tipos de datos primitivos: int, double, float, byte, boolean, char
        int numero = 10; // Variable de tipo entero
        double decimal = 3.14; // Variable de tipo decimal
        float flotante = 1.5f;
        byte byteValue = 100;
        boolean esVerdadero = true;
        char caracter = 'A';
        //tipos de datos no primitivos(Clases): String, Arrays, Clases, etc.
        String texto = "Hola, mundo!"; // Variable de tipo cadena de texto
        
        //Constantes
        final double PI = 3.14159; // Constante de tipo decimal

        if (args.length > 0 ) {
            System.out.println("Hola, " + args[0] + "!");
        } else {
            System.out.println("Hola mundo!");
        }

        int resultado = sumar(5, 3);
        System.out.println("El resultado de la suma es: " + resultado);
        System.out.println("Mensaje: " + mensaje);
    }

    public static int sumar(int a, int b) {
        return a + b;
    }
}

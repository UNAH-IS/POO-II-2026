# Programación Orientada a Objetos (POO)
### UNAH — 2026-II

---

## Tabla de Contenidos
1. [Paradigmas de Programación](#1-paradigmas-de-programación)
2. [Java vs. JavaScript](#2-java-vs-javascript)
3. [Herramientas necesarias](#3-herramientas-necesarias)
4. [Tipos de datos y variables en Java](#4-tipos-de-datos-y-variables-en-java)
5. [Funciones y métodos](#5-funciones-y-métodos)
6. [Estándares de codificación](#6-estándares-de-codificación)
7. [Clases y Objetos](#7-clases-y-objetos)
8. [Modificadores de acceso](#8-modificadores-de-acceso)
9. [Constructores](#9-constructores)
10. [Encapsulamiento — Getters y Setters](#10-encapsulamiento--getters-y-setters)
11. [Los 4 Pilares de la POO](#11-los-4-pilares-de-la-poo)
12. [Colecciones — ArrayList](#12-colecciones--arraylist)
13. [Interfaces gráficas en Java](#13-interfaces-gráficas-en-java)
14. [Control de versiones con Git](#14-control-de-versiones-con-git)
15. [Ejercicios del curso](#15-ejercicios-del-curso)

---

## 1. Paradigmas de Programación

Un **paradigma de programación** es un estilo o enfoque para diseñar y escribir programas. Los principales son:

| Paradigma | Descripción | Lenguajes |
|---|---|---|
| **Procedimental** | El programa se estructura como una secuencia de instrucciones | Pascal, C, Fortran |
| **Funcional** | Se basa en funciones matemáticas puras, sin estado mutable | Haskell, Lisp, Erlang, JavaScript |
| **Orientado a Objetos** | Se organiza en objetos que combinan datos y comportamiento | Java, C++, Python, Ruby, C#, Kotlin |
| **Lógico** | Se define QUÉ resolver, no CÓMO resolverlo | Prolog |

> **Nota:** Muchos lenguajes modernos son **multiparadigma**, como Python o JavaScript, que soportan varios estilos a la vez.

---

## 2. Java vs. JavaScript

Aunque sus nombres son similares, son lenguajes muy diferentes:

| Característica | Java | JavaScript |
|---|---|---|
| **Tipo de ejecución** | Compilado (produce bytecode para la JVM) | Interpretado (ejecutado en el navegador o Node.js) |
| **Tipado** | Fuertemente tipado | Débilmente tipado |
| **Uso principal** | Escritorio, Android, backend empresarial | Web (frontend/backend), apps móviles |

### ¿Qué significa fuertemente tipado?

En **Java**, el tipo de variable se declara explícitamente y no puede cambiar:
```java
int a = 4;
String nombre = "Juan";
double pi = 3.14;
// a = "Hola"; // ERROR — un int no puede ser String
```

En **JavaScript**, la variable se adapta al valor asignado:
```javascript
var a = 4;
var nombre = "Juan";
a = "Hola";      // válido
a = [1, 2, 3];   // también válido
```

### Otros lenguajes compilados vs. interpretados
- **Compilados:** Java, C++, C#, Swift, Kotlin, Go, Rust
- **Interpretados:** JavaScript, Python, Ruby, PHP, Dart

---

## 3. Herramientas necesarias

### 3.1 JDK (Java Development Kit)

El JDK contiene todo lo necesario para desarrollar en Java: el **compilador** (`javac`), la **Máquina Virtual de Java** (JVM) y otras utilidades.

- Descarga oficial: [oracle.com/java](https://www.oracle.com/java/)
- Alternativa gratuita: [OpenJDK](https://openjdk.org/)

**Compilar y ejecutar desde la terminal:**
```bash
# Compilar — genera un archivo .class (bytecode)
javac MiPrograma.java

# Ejecutar el bytecode en la JVM
java MiPrograma
```

### 3.2 IDE (Entorno de Desarrollo Integrado)

Un IDE facilita la escritura, depuración y organización del código. Los más populares para Java:

| IDE | Característica |
|---|---|
| **Eclipse** | Gratuito, muy usado en el ámbito académico |
| **IntelliJ IDEA** | El más popular en la industria |
| **NetBeans** | Gratuito, oficial de Apache |
| **Visual Studio Code** | Ligero, versátil con extensiones |

**Configurar VS Code para Java:**
1. Instalar la extensión **"Extension Pack for Java"**
2. Crear proyecto: `Ctrl + Shift + P` → `Java: Create Java Project`

---

## 4. Tipos de datos y variables en Java

Una **variable** es un espacio en memoria con un nombre para almacenar un valor.

### 4.1 Tipos primitivos

```java
int    numero    = 10;       // Entero
double decimal   = 3.14;     // Decimal de doble precisión
float  flotante  = 1.5f;     // Decimal de precisión simple
byte   byteVal   = 100;      // Entero pequeño (-128 a 127)
boolean esVerdad = true;     // Verdadero o falso
char   caracter  = 'A';      // Un solo carácter
```

### 4.2 Tipos no primitivos (Clases)

```java
String texto = "Hola, mundo!"; // Cadena de texto
int[]  arreglo = {1, 2, 3};    // Arreglo de enteros
```

### 4.3 Constantes

Las constantes usan la palabra clave `final` y su valor **no puede cambiar** una vez asignado:

```java
final double PI = 3.14159;
final int MAX_INTENTOS = 3;
```

> **Convención:** las constantes se escriben en **MAYÚSCULAS_CON_GUIÓN_BAJO** (SNAKE_CASE).

---

## 5. Funciones y métodos

Una **función** (o **método** dentro de una clase) es un bloque de código que realiza una tarea específica. Permite reutilizar lógica sin repetir código.

```java
// Declaración de un método
public static int sumar(int a, int b) {
    return a + b;
}

// Llamada al método
int resultado = sumar(5, 3); // resultado = 8
System.out.println("El resultado es: " + resultado);
```

**Anatomía de un método:**
```
[modificador] [tipo_retorno] [nombre]([parámetros]) {
    // cuerpo del método
    return valor; // si el tipo de retorno no es void
}
```

Si un método no devuelve ningún valor, se usa `void`:
```java
public static void saludar(String nombre) {
    System.out.println("Hola, " + nombre + "!");
}
```

---

## 6. Estándares de codificación

Seguir convenciones hace el código más legible y mantenible:

| Elemento | Convención | Ejemplo |
|---|---|---|
| **Clases** | UpperCamelCase | `MiClase`, `RegistroAlumnos` |
| **Métodos** | lowerCamelCase | `calcularPromedio()`, `getNombre()` |
| **Variables** | lowerCamelCase | `edadEstudiante`, `totalRegistros` |
| **Constantes** | UPPER_SNAKE_CASE | `MAX_ALUMNOS`, `TASA_IVA` |
| **Paquetes** | todo minúsculas | `principal`, `clases`, `modelos` |

---

## 7. Clases y Objetos

### ¿Qué es una Clase?

Una **clase** es una **plantilla o molde** que define las características (atributos) y comportamientos (métodos) de un tipo de entidad. Es, en esencia, un nuevo tipo de dato.

### ¿Qué es un Objeto?

Un **objeto** es una **instancia concreta** de una clase. Se crea usando la palabra clave `new`.

```java
// Definición de la clase
public class Computadora {
    // Atributos (características)
    String marca;
    String modelo;
    String procesador;
    int memoriaRAM;
    int almacenamiento;

    // Métodos (comportamientos)
    public void encender() {
        System.out.println("La computadora se ha encendido.");
    }

    public void apagar() {
        System.out.println("La computadora se ha apagado.");
    }

    public void ejecutarPrograma(String programa) {
        System.out.println("Ejecutando: " + programa);
    }
}
```

```java
// Crear un objeto (instancia) de la clase
Computadora miPC = new Computadora();
miPC.marca = "Dell";
miPC.memoriaRAM = 16;
miPC.encender();
```

### Más ejemplos de clases del mundo real

**Clase `Persona`:**
```java
public class Persona {
    String nombre;
    int edad;
    String genero;
    double altura;
    double peso;

    public void hablar(String mensaje) {
        System.out.println(nombre + " dice: " + mensaje);
    }

    public void comer(String comida) {
        System.out.println(nombre + " está comiendo " + comida + ".");
    }
}
```

**Otras clases sugeridas para modelar:**
- `Carro` → atributos: marca, modelo, año, color, velocidad | métodos: `acelerar()`, `frenar()`, `encender()`
- `Animal` → atributos: especie, edad, color, peso | métodos: `comer()`, `moverse()`, `emitirSonido()`
- `Libro` → atributos: título, autor, año, páginas | métodos: `abrirPagina()`, `cerrar()`

> **Clave:** Una clase es un tipo de dato. Así como `int` almacena números, `Alumno` almacena información de un alumno.

---

## 8. Modificadores de acceso

Controlan quién puede ver o usar los atributos y métodos de una clase:

| Modificador | Acceso desde |
|---|---|
| `public` | Cualquier clase, en cualquier paquete |
| `private` | Solo dentro de la misma clase |
| `protected` | Mismo paquete y subclases |
| *(sin modificador)* | Solo dentro del mismo paquete |

```java
public class Ejemplo {
    public    String nombre;    // accesible desde cualquier lado
    private   int    saldo;     // solo accesible dentro de esta clase
    protected String categoria; // accesible en el paquete y subclases
              double peso;      // accesible solo en el paquete
}
```

---

## 9. Constructores

Un **constructor** es un método especial que se ejecuta automáticamente al crear un objeto con `new`. Sirve para inicializar los atributos del objeto.

**Reglas:**
- Tiene el **mismo nombre** que la clase
- **No tiene tipo de retorno** (ni `void`)
- Si no se define ninguno, Java provee uno vacío por defecto

```java
public class Alumno {

    private String nombre;
    private int edad;

    // Constructor sin parámetros (por defecto)
    public Alumno() {
        System.out.println("Se creó un nuevo Alumno.");
    }

    // Constructor con parámetros
    public Alumno(String nombre, int edad) {
        this.nombre = nombre; // "this" hace referencia al atributo del objeto
        this.edad = edad;
    }
}

// Uso:
Alumno a1 = new Alumno();                  // llama al constructor vacío
Alumno a2 = new Alumno("María", 20);       // llama al constructor con parámetros
```

> La palabra clave **`this`** se usa para distinguir el atributo del objeto del parámetro del constructor cuando tienen el mismo nombre.

### Sobrecarga de constructores

Se pueden tener **varios constructores** con diferentes parámetros:

```java
public class Carro {
    String marca;
    String color;
    int año;

    public Carro() { }

    public Carro(String marca) {
        this.marca = marca;
    }

    public Carro(String marca, String color, int año) {
        this.marca = marca;
        this.color = color;
        this.año   = año;
    }
}
```

---

## 10. Encapsulamiento — Getters y Setters

El **encapsulamiento** consiste en declarar los atributos como `private` y exponer su acceso controlado mediante métodos públicos llamados **getters** (para leer) y **setters** (para escribir).

```java
public class Alumno {
    private String nombre;
    private String apellido;
    private int    edad;

    // Getter — obtener el valor
    public String getNombre() {
        return this.nombre;
    }

    // Setter — establecer el valor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0) { // validación antes de asignar
            this.edad = edad;
        }
    }
}
```

**Uso en el programa principal:**
```java
Alumno a = new Alumno();
a.setNombre("Carlos");
a.setEdad(21);
System.out.println(a.getNombre()); // Carlos
```

> **¿Por qué encapsular?** Protege los datos y permite agregar validaciones (como en `setEdad`) sin que el resto del programa tenga que cambiar.

---

## 11. Los 4 Pilares de la POO

| Pilar | Descripción |
|---|---|
| **Encapsulamiento** | Ocultar los detalles internos y exponer solo lo necesario mediante métodos públicos |
| **Abstracción** | Modelar solo los aspectos relevantes de una entidad, ignorando detalles innecesarios |
| **Herencia** | Una clase puede heredar atributos y métodos de otra clase (relación "es un") |
| **Polimorfismo** | Un objeto puede tomar muchas formas; métodos con el mismo nombre pueden comportarse distinto |

### Ejemplo de Herencia (concepto)
```java
// Clase padre (superclase)
public class Animal {
    public void emitirSonido() {
        System.out.println("...");
    }
}

// Clase hija (subclase) — hereda de Animal
public class Perro extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("¡Guau!");
    }
}
```

---

## 12. Colecciones — ArrayList

Un `ArrayList` es una lista **dinámica** (puede crecer o reducirse) que almacena objetos de un tipo específico.

```java
import java.util.ArrayList;

// Declaración
ArrayList<Alumno> alumnos = new ArrayList<>();

// Agregar elementos
Alumno a1 = new Alumno("Ana", "López", 19, "Ingeniería", "0801200001234", "Femenino");
alumnos.add(a1);

// Acceder a un elemento
Alumno primero = alumnos.get(0);

// Recorrer la lista
for (Alumno a : alumnos) {
    System.out.println(a.getNombre());
}

// Tamaño de la lista
System.out.println("Total: " + alumnos.size());
```

> `<>` es el **operador diamante** y define el tipo de dato que contendrá la lista (también llamado *generics*).

**Comparación con arreglos estáticos:**
```java
// Arreglo estático — tamaño fijo
Alumno[] arreglo = new Alumno[5];

// ArrayList — tamaño dinámico
ArrayList<Alumno> lista = new ArrayList<>();
```

---

## 13. Interfaces gráficas en Java

Java ofrece varios paquetes para crear ventanas y formularios:

| Paquete | Descripción |
|---|---|
| `java.awt.*` | AWT — Abstract Window Toolkit (básico, nativo del SO) |
| `javax.swing.*` | Swing — más completo, componentes propios |
| `javafx.*` | JavaFX — moderno, soporta CSS y FXML |

### JOptionPane — Diálogos rápidos con Swing

```java
import javax.swing.JOptionPane;

// Mostrar un mensaje
JOptionPane.showMessageDialog(null, "¡Hola, mundo!");

// Pedir un dato al usuario
String nombre = JOptionPane.showInputDialog("¿Cuál es tu nombre?");

// Convertir String a int
int edad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos años tienes?"));
```

---

## 14. Control de versiones con Git

**Git** (creado por Linus Torvalds) es el sistema de control de versiones más utilizado en el mundo.

### Plataformas en la nube

| Plataforma | URL |
|---|---|
| GitHub | github.com |
| GitLab | gitlab.com |
| Bitbucket | bitbucket.org |

### Comandos esenciales

```bash
# Inicializar un repositorio
git init

# Ver el estado actual
git status

# Agregar archivos al área de preparación
git add NombreArchivo.java
git add .                        # todos los archivos

# Guardar los cambios (confirmar)
git commit -m "Descripción del cambio"

# Ver las ramas existentes
git branch

# Subir cambios al repositorio remoto
git push

# Traer cambios del repositorio remoto
git pull

# Clonar un repositorio existente
git clone https://github.com/usuario/repositorio.git
```

### Ramas (Branches)

Las **ramas** permiten trabajar en diferentes versiones del proyecto de forma simultánea sin afectar la rama principal (`main`).

```bash
git branch nueva-funcionalidad     # crear rama
git checkout nueva-funcionalidad   # cambiarse a esa rama
git merge nueva-funcionalidad      # fusionar con la rama actual
```

---

## 15. Ejercicios del curso

| Proyecto | Archivo(s) | Concepto |
|---|---|---|
| **Hola Mundo (básico)** | [HolaMundo.java](HolaMundo.java) | Primer programa, `System.out.println` |
| **Hola Mundo Eclipse** | [HolaMundo.java](HolaMundoEclipse/src/principal/HolaMundo.java) | Uso de Eclipse, `JOptionPane` |
| **Hola Mundo VS Code** | [App.java](HolaMundoVSCode/HolaMundo/src/principal/App.java) | Variables, tipos de datos, métodos |
| **Registro de Alumnos** | [App.java](RegistroAlumnos/src/App.java) · [Alumno.java](RegistroAlumnos/src/clases/Alumno.java) | Clases, objetos, encapsulamiento, ArrayList, JOptionPane |

### Descripción de ejercicios

#### Hola Mundo
El programa más simple en Java. Punto de entrada de todo programa: el método `main`.
```java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
    }
}
```

#### Variables y métodos (HolaMundoVSCode)
Demuestra los tipos de datos primitivos, constantes y la definición de métodos propios:
```java
final double PI = 3.14159;
int resultado = sumar(5, 3);

public static int sumar(int a, int b) {
    return a + b;
}
```

#### Registro de Alumnos
Ejercicio completo que combina:
- Clase `Alumno` con atributos privados
- Constructores (vacío y parametrizado)
- Getters y Setters (encapsulamiento)
- Método `solicitarInformacion()` con `JOptionPane`
- `ArrayList<Alumno>` para almacenar múltiples objetos
- Instanciación con `new`

---

## Recursos recomendados

- [Documentación oficial de Java (Oracle)](https://docs.oracle.com/en/java/)
- [OpenJDK](https://openjdk.org/)
- [W3Schools Java Tutorial](https://www.w3schools.com/java/)
- [Codecademy — Learn Java](https://www.codecademy.com/learn/learn-java)

---

*Elaborado para el curso de Programación Orientada a Objetos — UNAH 2026-II*

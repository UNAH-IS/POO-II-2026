package com.unah.interfaces;

public interface Administrable {
        String NOMBRE_ARCHIVO = "informacion.txt"; // constante

        void guardarInformacionEnArchivo(String nombreArchivo);
        void cargarInformacionDesdeArchivo(String nombreArchivo);
        void actualizarInformacionEnArchivo(String nombreArchivo);
        void eliminarInformacionEnArchivo(String nombreArchivo);
}

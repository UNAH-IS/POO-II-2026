package com.unah.interfaces;

public interface Administrable {
        String NOMBRE_ARCHIVO = "alumnos.csv"; // comma separated values

        void guardarInformacionEnArchivo();
        // void actualizarInformacionEnArchivo(ObservableList<Persona> personas);
        void eliminarInformacionEnArchivo();
}

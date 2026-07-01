package com.unah.clases;

import java.time.LocalDate;

public class Maestro extends Persona {
        private double sueldo;
        private int clasesImpartidas;
        private int horasTrabajadas;
        private String categoriaDocente;

        public Maestro() {}

        public Maestro(String nombre, String apellido, int edad, Carrera carrera, String identidad, String genero, double sueldo, int clasesImpartidas, int horasTrabajadas, String categoriaDocente, LocalDate fechaNacimiento) {
            super(nombre, apellido, edad, carrera, identidad, genero, fechaNacimiento);
            this.sueldo = sueldo;
            this.clasesImpartidas = clasesImpartidas;
            this.horasTrabajadas = horasTrabajadas;
            this.categoriaDocente = categoriaDocente;
        }

        public double getSueldo() {
            return sueldo;
        }

        public void setSueldo(double sueldo) {
            this.sueldo = sueldo;
        }

        public int getClasesImpartidas() {
            return clasesImpartidas;
        }

        public void setClasesImpartidas(int clasesImpartidas) {
            this.clasesImpartidas = clasesImpartidas;
        }

        public int getHorasTrabajadas() {
            return horasTrabajadas;
        }

        public void setHorasTrabajadas(int horasTrabajadas) {
            this.horasTrabajadas = horasTrabajadas;
        }

        public String getCategoriaDocente() {
            return categoriaDocente;
        }

        public void setCategoriaDocente(String categoriaDocente) {
            this.categoriaDocente = categoriaDocente;
        }

        @Override
        public String toString() {
            return "Sueldo: " + sueldo + 
            ", Clases Impartidas: " + clasesImpartidas + 
            ", Horas Trabajadas: " + horasTrabajadas + 
            ", Categoria Docente: " + categoriaDocente +
            ", " + super.toString();
        }
}


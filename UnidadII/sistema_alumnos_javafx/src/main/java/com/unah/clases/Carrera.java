package com.unah.clases;

public class Carrera {
    private String codigoCarrera;
    private String nombreCarrera;
    private int cantidadClases;

    public Carrera() {}

    public Carrera(int cantidadClases, String codigoCarrera, String nombreCarrera) {
        this.cantidadClases = cantidadClases;
        this.codigoCarrera = codigoCarrera;
        this.nombreCarrera = nombreCarrera;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getCantidadClases() {
        return cantidadClases;
    }

    public void setCantidadClases(int cantidadClases) {
        this.cantidadClases = cantidadClases;
    }

    public String toString() {
        return  this.nombreCarrera;
    }

    public void solicitarInformacion() {
        // this.codigoCarrera = JOptionPane.showInputDialog("Ingrese el codigo de la carrera");
        // this.nombreCarrera = JOptionPane.showInputDialog("Ingrese el nombre de la carrera");
        // this.cantidadClases = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clases de la carrera"));
    }

}


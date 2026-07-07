package com.unah.clases;

import com.unah.App;

import javafx.scene.canvas.GraphicsContext;

public class Jugador {
	private int x;
	private int y;
	private String indiceImagen;
	private int velocidad;
	
	public Jugador(int x, int y, String indiceImagen, int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	public void mover(){
		if (this.x>=1100)
			this.x = -100;
		if (App.derecha)
			this.x+=velocidad;
		
		if (App.izquierda)
			this.x-=velocidad;
		
		if (App.arriba)
			this.y-=velocidad;
		
		if (App.abajo)
			this.y+=velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(App.imagenes.get(this.indiceImagen), this.x, this.y);
		
	}
	
	public void inicializarAnimaciones() {
			
	}
}


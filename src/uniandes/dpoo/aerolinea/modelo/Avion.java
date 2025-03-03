package uniandes.dpoo.aerolinea.modelo;

public class Avion {
	
private String nombre;
private Integer capacidad;

public Avion (String nombre, Integer capacidad) {
	this.nombre = nombre;
	this.capacidad = capacidad;
}

public String getNombre() {
	return this.nombre;
}

public Integer getCapacidad() {
	return this.capacidad;
}
}

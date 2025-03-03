package uniandes.dpoo.aerolinea.tiquetes;
import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.modelo.*;


public class Tiquete {
private Cliente cliente;
private String codigo;
private Integer tarifa;
private Boolean usado = false;
private Vuelo vuelo;

public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, Integer tarifa ) {
	this.codigo = codigo;
	this.vuelo = vuelo;
	this.tarifa = tarifa;
	this.cliente = clienteComprador;
}

public Boolean esUsado() {
	
	return this.usado;
}

public Cliente getCliente() {
	
	return this.cliente;
}

public String getCodigo() {
	
	return this.codigo;
}
public Integer getTarifa() {
	
	return this.tarifa;
}
public Vuelo getVuelo() {
	
	return this.vuelo;
}

public void marcarComoUsado() {
	Boolean fueUsado = this.usado;
	if (fueUsado == false) {
		this.usado = true;
		cliente.usarTiquetes(this.vuelo);
		GeneradorTiquetes.registrarTiquete(this);
	}
	
}

}

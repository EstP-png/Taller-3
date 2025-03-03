package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.*;

public abstract class CalculadoraTarifas {
	public static final Double IMPUESTO = 0.28;
	
	
	public CalculadoraTarifas() {}
	
	protected abstract Integer calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected Integer calcularValorImpuestos(Integer costoBase) {
		
		int impuestos = (int)(costoBase * IMPUESTO);
		
		return costoBase + impuestos;
		
	}
	
	protected Integer calcularDistanciaVuelo(Ruta ruta) {
		
		return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
		
		
	}
	
	public Integer calcularTarifa(Vuelo vuelo, Cliente cliente) {
		
		int valorBase = calcularCostoBase(vuelo,cliente);
		int impuestos = calcularValorImpuestos(valorBase);
		double descuento = calcularPorcentajeDescuento(cliente);
		
		return (int)((valorBase - (valorBase*descuento)) + impuestos);
		
	}
		
}

package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.*;
import uniandes.dpoo.aerolinea.modelo.cliente.*;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{

	protected Integer COSTO_POR_KM =1000;
	
public CalculadoraTarifasTemporadaAlta() {
		
	}
	
	public Integer calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		
		return COSTO_POR_KM * distancia;
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		
		return 0;
		
	}
}

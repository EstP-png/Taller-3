package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.*;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	protected Integer COSTO_POR_KM_CORPORATIVO = 900;
	protected Integer COSTO_POR_KM_NATURAL = 600;
	protected double DESCUENTO_GRANDES = 0.2;
	protected double DESCUENTO_MEDIANAS = 0.1;
	protected double DESCUENTO_PEQ = 0.02;
	
	public CalculadoraTarifasTemporadaBaja() {
		
	}


	public Integer calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		String clienteTipo = cliente.getTipoCliente();
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		if (clienteTipo == "Natural") {
			return distancia * COSTO_POR_KM_NATURAL;
			
		}else {
			
			return distancia * COSTO_POR_KM_CORPORATIVO;
			
		}
		
		
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		String clienteTipo = cliente.getTipoCliente();
		if (clienteTipo == "Corporativo") {
			ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
			int tamano = clienteCorporativo.getTamanoEmpresa();
			if (tamano == ClienteCorporativo.PEQUENA) {
				return DESCUENTO_PEQ;
			}else if(tamano == ClienteCorporativo.MEDIANA) {
				return DESCUENTO_MEDIANAS;
			}else {
				return DESCUENTO_GRANDES;
			}
				
				
			}else {
				return 0;
			}
		}
		
	}
	



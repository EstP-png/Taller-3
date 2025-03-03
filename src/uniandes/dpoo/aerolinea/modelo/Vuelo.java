package uniandes.dpoo.aerolinea.modelo;
import java.util.*;
import uniandes.dpoo.aerolinea.tiquetes.*;
import java.lang.Object;
import uniandes.dpoo.aerolinea.modelo.tarifas.*;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.*;

public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String,Tiquete> tiquetes;

	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		this.tiquetes = new HashMap<String,Tiquete>();
	}

   public String getFecha() {
        return this.fecha;
    }

    public Ruta getRuta() {
        return this.ruta;
    }

    public Avion getAvion() {
        return this.avion;
    }

    public Collection<Tiquete> getTiquetes() {
    	
    	return tiquetes.values();
    }
	
    public Integer venderTiquetes​(Cliente cliente,CalculadoraTarifas calculadora, Integer cantidad) throws VueloSobrevendidoException{
    	int tarifa = calculadora.calcularTarifa(this, cliente);
    	int valor = 0;
    	int ocupantes = this.avion.getCapacidad();
    	Tiquete tiquete;
    	if((tiquetes.size()+cantidad) > ocupantes) {
    		throw new VueloSobrevendidoException(this);
    	}
    	for(int i =0; i == cantidad;i+=1) {
    		tiquete = GeneradorTiquetes.generarTiquete(this,cliente,tarifa);
    		tiquetes.put(tiquete.getCodigo(), tiquete);
    		cliente.agregarTiquete(tiquete);
    		valor += tarifa;
    	}
    	return valor;

    }

    
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}else {
			return false;
		}
	}

}

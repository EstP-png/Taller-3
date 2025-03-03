package uniandes.dpoo.aerolinea.modelo.cliente;
import uniandes.dpoo.aerolinea.tiquetes.*;
import java.util.Iterator;
import uniandes.dpoo.aerolinea.modelo.*;
import java.util.*;

public abstract class Cliente {
	private ArrayList<Tiquete> tiquetesSinUsar;
	private ArrayList<Tiquete> tiquetesUsados;
	private String identificador;
	private static GeneradorCodigo generadorCLiente = new GeneradorCodigo();


	public Cliente() {
        this.tiquetesSinUsar = new ArrayList<Tiquete>();
        this.tiquetesUsados = new ArrayList<Tiquete>();
        this.identificador = generadorCLiente.generarCodigo();
	}
	
	public void agregarTiquete(Tiquete tiquete) {
		this.tiquetesSinUsar.add(tiquete);
		
	}
	
	public Integer calcularValorTotalTiquetes() {
		int valor = 0;
		for(Tiquete tiquete: tiquetesSinUsar) {
			valor += tiquete.getTarifa();
			
		}

		return valor;
	}
	
	
	public String getIdentificador() {
		return this.identificador;
	}
	public abstract String getTipoCliente();
	
	public void usarTiquetes(Vuelo vuelo) {
		Iterator<Tiquete> iterator = tiquetesSinUsar.iterator();
        while (iterator.hasNext()) {
            Tiquete tiquete = iterator.next();
            Vuelo vueloTiquete = tiquete.getVuelo();

            if (vueloTiquete.equals(vuelo)) {
                tiquetesUsados.add(tiquete);
                iterator.remove();
			}
		}
	
}
}

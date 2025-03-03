package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {

	public static String NATURAL = "Natural";
	public String nombre;
		
	public ClienteNatural(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getTipoCliente() {
		return NATURAL;
	}
	
}

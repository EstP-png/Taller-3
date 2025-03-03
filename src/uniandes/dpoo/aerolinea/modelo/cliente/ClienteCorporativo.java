package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
    public static String CORPORATIVO = "Corporativo";
    public static Integer GRANDE = 1;
    public static Integer MEDIANA = 2 ;
    public static Integer PEQUENA = 3;
    private String nombreEmpresa;
    private Integer tamanoEmpresa;
    
    public ClienteCorporativo(String nombreEmpreza, Integer tamanoEmpresa) {
    	super();
    	this.nombreEmpresa= nombreEmpreza;
    	this.tamanoEmpresa = tamanoEmpresa;
    }
    
    public String getNombreEmpresa() {
    	return this.nombreEmpresa;
    	
    }
    
    public Integer getTamanoEmpresa() {
    	return this.tamanoEmpresa;
    }
    
    public String getTipoCliente() {
    	return CORPORATIVO;
    }

    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
}

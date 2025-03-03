package uniandes.dpoo.aerolinea.modelo;
import java.util.Random;
import java.util.ArrayList;

public class GeneradorCodigo {
	private ArrayList<String> identificadores;
	
	public GeneradorCodigo() {
		this.identificadores = new ArrayList<String>();
	}
	
	public String generarCodigo() {
		
		Random random = new Random();

        Integer numero = (random.nextInt(99999 - 10000 + 1) + 10000);
        String codigo = Integer.toString(numero);
        

        while (identificadores.contains(codigo)) {
            numero = random.nextInt(99999 - 10000 + 1) + 10000;
            codigo = Integer.toString(numero);
        }
        
        identificadores.add(codigo);
        return codigo;
		
	}
	
	
}

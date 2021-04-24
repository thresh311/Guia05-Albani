package excepciones;

public class AlquilerNoEntregadoException extends Exception {

	public String getMessage() {
		return "El usuario tiene mas 2 dos alquieres sin devolver.";
	}
	
}

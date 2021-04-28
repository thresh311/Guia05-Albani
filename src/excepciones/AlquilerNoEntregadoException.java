package excepciones;

public class AlquilerNoEntregadoException extends Exception {

	public String getMessage() {
		return "El usuario tiene 2 alquileres sin devolver.";
	}
	
}

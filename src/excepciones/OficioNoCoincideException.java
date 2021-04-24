package excepciones;

public class OficioNoCoincideException extends Exception {

	public String getMessage() {
		return "El oficio del trabajador y del trabajo no coinciden.";
	}
	
	
	
}

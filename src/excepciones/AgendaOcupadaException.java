package excepciones;

public class AgendaOcupadaException extends Exception {

	public String getMessage() {
		return "El trabajador ya tiene un trabajo registrado en la fecha indicada.";
	}
	
}

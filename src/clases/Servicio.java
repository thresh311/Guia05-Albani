package clases;

import java.time.LocalDate;

public abstract class Servicio {

	protected Oficio oficio;
	//protected boolean urgente;
	
	
	public abstract double costo();


	public boolean esCompatible(Oficio other) {
		return this.oficio.equals(other);
	}
	
	
	
}

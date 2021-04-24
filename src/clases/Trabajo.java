package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import interfaces.Contratable;

public class Trabajo implements Contratable {

	
	protected LocalDate fechaAcordada;
	protected LocalDate fechaFinalizacion;
	protected boolean urgente;
	protected Servicio servicio;
	
	public Trabajo (Servicio servicio, boolean urgente, LocalDate fechaAcordada) {
		this.servicio = servicio;
		this.urgente = urgente;
		this.fechaAcordada = fechaAcordada;
	}
	
	public Trabajo (Servicio servicio, boolean urgente, String fechaAcordada) {
		DateTimeFormatter f1 =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.servicio = servicio;
		this.urgente = urgente;
		this.fechaAcordada = LocalDate.parse(fechaAcordada, f1);
	}
	
	public boolean finalizado () {
		return this.fechaFinalizacion != null;
	}
	
	public void registrarFinalizacion () {
		if(this.fechaFinalizacion == null)
			this.fechaFinalizacion = LocalDate.now();
	}
	
	public double costo () {
		
		if(this.urgente) return servicio.costo() * 1.5;
		
		return servicio.costo();
	}
	
	public boolean esCompatible(Oficio other) {
		return this.servicio.esCompatible(other);
	}

	public boolean coincideFecha(Trabajo other) {
		return this.fechaAcordada.equals(other.fechaAcordada);
	}

	@Override
	public boolean devuelto() {
		return true;
	}
	
}

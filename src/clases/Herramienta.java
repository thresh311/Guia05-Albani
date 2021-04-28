package clases;

import java.time.Instant;
import java.time.LocalDate;

public class Herramienta {
	
	protected String nombre;
	protected double costoPorDia;
	
	public Herramienta(String nombre, double costo) {
		this.nombre = nombre;
		this.costoPorDia = costo;
	}
	
	public double calcularCosto (long periodo) {
		return this.costoPorDia * periodo;
	}
	
	
}

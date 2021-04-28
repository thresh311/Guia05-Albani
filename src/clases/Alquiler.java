package clases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import interfaces.Contratable;

public class Alquiler implements Contratable{
	
	LocalDate fechaInicio;
	LocalDate fechaFin;
	LocalDate fechaDevolucion;
	Herramienta herramienta;
	
	public Alquiler (String fechaInicio, String fechaFin, Herramienta herramienta) {
		DateTimeFormatter f1 =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.fechaInicio = LocalDate.parse(fechaInicio, f1);
		this.fechaFin = LocalDate.parse(fechaFin, f1);
		this.herramienta = herramienta;
	}
	
	public Alquiler (LocalDate fechaInicio, LocalDate fechaFin, Herramienta herramienta) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.herramienta = herramienta;
	}
	
	public Alquiler (LocalDate fechaInicio, int duracion, Herramienta herramienta) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaInicio.plusDays(duracion);
		this.herramienta = herramienta;
	}
	
	public Alquiler (String fechaInicio, int duracion, Herramienta herramienta) {
		DateTimeFormatter f1 =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.fechaInicio = LocalDate.parse(fechaInicio, f1);
		this.fechaFin = this.fechaInicio.plusDays(duracion);
		this.herramienta = herramienta;
	}
	
	public void registrarFinalizacion () {
		if(this.fechaDevolucion == null)
			this.fechaDevolucion = LocalDate.now();
	}
	
	public double costo() {
		
		long duracion;
		
		if(fechaDevolucion == null) {
			duracion = ChronoUnit.DAYS.between(this.fechaInicio, LocalDate.now());
		} else {
			duracion = ChronoUnit.DAYS.between(this.fechaInicio, this.fechaDevolucion);
		}
		
		return herramienta.calcularCosto(duracion);
		
		
	}
	
	public boolean enMora () {
		
		if(this.fechaDevolucion == null) {
			return LocalDate.now().isAfter(this.fechaFin);
		} 
		
		return this.fechaDevolucion.isAfter(this.fechaFin);
		
	}
	
	public void setFechaDevolucion(String fecha) {
		DateTimeFormatter f1 =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.fechaDevolucion = LocalDate.parse(fecha,f1);
	}
	
	public void setFechaDevolucion(LocalDate fecha) {
		this.fechaDevolucion = fecha;
	}
	
	public boolean finalizado () {
		return this.fechaDevolucion != null;
	}

	@Override
	public boolean devuelto() {
		return this.fechaDevolucion != null;
	}
	
}

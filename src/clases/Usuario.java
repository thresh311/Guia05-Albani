package clases;

import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.AlquilerNoEntregadoException;
import interfaces.Contratable;

public class Usuario {

	ArrayList<Contratable> servicios;
	
	public void Contratar (Servicio servicio, boolean urgente, LocalDate fechaAgendada) {
		
		servicios.add(new Trabajo (servicio, urgente, fechaAgendada));	
		
	}
	
	public void Contratar (Servicio servicio, boolean urgente, String fechaAgendada) {
		
		servicios.add(new Trabajo (servicio, urgente, fechaAgendada));	
		
	}
	
	public void Contratar (Trabajo trabajo) {
		
		servicios.add(trabajo);	
		
	}
	
	public void Contratar (Alquiler alquiler) throws AlquilerNoEntregadoException {
		
		if(this.adeudaAlquileres()) {
			throw new AlquilerNoEntregadoException();
		}
		
		servicios.add(alquiler);	
		
	}
	
	public void Contratar (Herramienta herramienta, LocalDate fechaInicio, int duracion) throws AlquilerNoEntregadoException {
		
		if(this.adeudaAlquileres()) {
			throw new AlquilerNoEntregadoException();
		}
		
		servicios.add(new Alquiler (fechaInicio, duracion, herramienta));	
		
	}
	
	public void Contratar (Herramienta herramienta, String fechaInicio, int duracion) throws AlquilerNoEntregadoException {
		
		if(this.adeudaAlquileres()) {
			throw new AlquilerNoEntregadoException();
		}
		
		servicios.add(new Alquiler (fechaInicio, duracion, herramienta));	
		
	}
	
	public boolean adeudaAlquileres() {
		return servicios.stream().filter((c) -> {return !c.devuelto();}).count() > 2;
	}
	
}

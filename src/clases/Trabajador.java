package clases;

import java.util.ArrayList;

import excepciones.AgendaOcupadaException;
import excepciones.OficioNoCoincideException;

public class Trabajador {
	protected Oficio oficio;
	protected ArrayList<Trabajo> trabajos;
	protected String nombre;
	protected String email;
	protected double porcentajeComision;
	protected double costoPorHora;
	
	/*public double comision(double costo) {
		return this.porcentajeComision * costo;
	}*/
	
	public void agregarTrabajo (Trabajo trabajo) throws OficioNoCoincideException, AgendaOcupadaException {
		
		if(!trabajo.esCompatible(this.oficio)) {
			throw new OficioNoCoincideException();
		}
		
		if(this.interferenciaAgenda(trabajo)) {
			throw new AgendaOcupadaException();
		}
		
		this.trabajos.add(trabajo);
	}
	
	public boolean interferenciaAgenda (Trabajo other) {
		
		return this.trabajos.stream().anyMatch((t) -> {
			return t.coincideFecha(other);
		});
		
	}
	
}

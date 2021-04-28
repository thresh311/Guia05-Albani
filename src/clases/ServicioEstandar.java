package clases;

public class ServicioEstandar extends Servicio{
	
	protected double costoFijo;
	protected double porcentajeComision;

	public ServicioEstandar (Oficio oficio ,double costo, double porcentaje) {
		this.oficio = oficio;
		this.costoFijo = costo;
		this.porcentajeComision = porcentaje; 
	}
	
	
	@Override
	public double costo() {

		return this.costoFijo * (1 + this.porcentajeComision);		
		
	}
	
}

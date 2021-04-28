package clases;

public class ServicioPersonalizado extends Servicio{

	protected double costoPresupuesto;
	protected double costoTransporte;
	protected double costoMateriales;
	
	public ServicioPersonalizado (Oficio oficio ,double presupuesto, double transporte, double materiales) {
		this.oficio = oficio;
		this.costoPresupuesto = presupuesto;
		this.costoTransporte = transporte;
		this.costoMateriales = materiales; 
	}
	
	
	@Override
	public double costo() {
		
		double total = this.costoPresupuesto + this.costoTransporte + this.costoMateriales;
		
		return total;
	}

}

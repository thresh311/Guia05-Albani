package clases;

public class ServicioPersonalizado extends Servicio{

	protected double costoPresupuesto;
	protected double costoTransporte;
	protected double costoMateriales;
	
	@Override
	public double costo() {
		
		double total = this.costoPresupuesto + this.costoTransporte + this.costoMateriales;
		
		return total;
	}

}

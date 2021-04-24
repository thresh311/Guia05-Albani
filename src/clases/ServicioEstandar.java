package clases;

public class ServicioEstandar extends Servicio{
	
	protected double costoFijo;

	@Override
	public double costo() {

		double total = this.costoFijo; //+ this.trabajador.comision(this.costoFijo);		
		
		return total;
		
	}
	
}

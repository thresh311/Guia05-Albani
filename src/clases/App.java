package clases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import excepciones.AgendaOcupadaException;
import excepciones.AlquilerNoEntregadoException;
import excepciones.OficioNoCoincideException;

public class App {

	//Las fechas pasadas como String deberan tener formate "dd-mm-yyyyy"
	
	public static void main(String[] args) {
	
	//Descomentar el/los escenarios que desee analizar
		
	//agregarTareasTrabajador();
	
	//calcularCostoTrabajos();	
	
	//calcularCostoAlquiler();
	
	contratarUsuario();
		
	}
	
	private static void contratarUsuario() {
		
		Usuario u1 = new Usuario();
		
		Herramienta h1 = new Herramienta("Destornillador", 20);
		
		Oficio carpinteria = new Oficio("Carpinteria");
		Oficio electricidad = new Oficio ("Electricidad");
		
		ServicioPersonalizado servPer = new ServicioPersonalizado(electricidad, 1000, 200, 800);
		ServicioEstandar servEst = new ServicioEstandar(carpinteria, 1000, 0.2);
		
		//Caso Exito
		
		try {
			//Agrego dos alquileres no devueltos
			u1.contratar(h1, LocalDate.now(), 10);
			u1.contratar(h1, "15-01-2021", 10);
			System.out.println("Alquileres contratados exitosamente");
			
			//Agrego dos trabajos
			u1.contratar(servEst, false, LocalDate.now()); //No urgente
			u1.contratar(servPer, true, "15-01-2021"); //Urgente
			System.out.println("Trabajos contratados exitosamente");
			
		} catch (AlquilerNoEntregadoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//Caso Falla por Alquier No entregado
		
		try {
					
			u1.contratar(h1, "15-01-2021", 10);
			
			
		} catch (AlquilerNoEntregadoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//Devuelvo uno de los alquileres e intento de nuevo
		
		u1.getServicios().get(0).registrarFinalizacion();
		
		try {
			
			u1.contratar(h1, "15-01-2021", 10);
			System.out.println("Alquiler contratado exitosamente");
			
		} catch (AlquilerNoEntregadoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void calcularCostoAlquiler() {
		
		Herramienta h1 = new Herramienta("Destornillador", 20);
		
		
		//Alquiler no devuelto - Demorado
		Alquiler a1 = new Alquiler("14-04-2021", 10, h1);
		System.out.println("Costo Alquiler No Devuelto: " + a1.costo());
		System.out.println("Esta en demora? " + a1.enMora());
		System.out.println("Devuelto? " + a1.devuelto());
		//Alquiler  no devuelto - No Demorado
		Alquiler a2 = new Alquiler(LocalDate.now(), LocalDate.now().plusDays(10), h1);
		System.out.println("Costo Alquiler No Devuelto: " + a2.costo());
		System.out.println("Esta en demora? " + a2.enMora());
		System.out.println("Devuelto? " + a2.devuelto());
		//Alquiler Devuelto
		Alquiler a3 = new Alquiler("14-04-2021", 10, h1);
		a3.registrarFinalizacion(); //Marca que fue devuelto hoy
		System.out.println("Costo Alquiler Devuelto: " + a3.costo());
		System.out.println("Esta en demora? " + a3.enMora());
		System.out.println("Devuelto? " + a3.devuelto());
		//Fuerzo la fecha de devolucion para visualizar cambio
		a3.setFechaDevolucion(LocalDate.now().plusDays(-1)); 
		System.out.println("Costo Alquiler Devuelto: " + a3.costo());
		System.out.println("Esta en demora? " + a3.enMora());
		System.out.println("Devuelto? " + a3.devuelto());
	}

	private static void calcularCostoTrabajos() {
		
		Oficio carpinteria = new Oficio("Carpinteria");
		Oficio electricidad = new Oficio ("Electricidad");
		
		ServicioPersonalizado servPer = new ServicioPersonalizado(electricidad, 1000, 200, 800);
		ServicioEstandar servEst = new ServicioEstandar(carpinteria, 1000, 0.2);
		
		Trabajo noUrgenteEst = new Trabajo(servEst, false, "15-01-2000");
		Trabajo urgenteEst = new Trabajo(servEst, true, "15-01-2000");
		
		Trabajo urgentePer = new Trabajo(servPer, true, "15-01-2000");
		Trabajo noUrgentePer = new Trabajo(servPer, false, "15-01-2000");
		
		System.out.println("Trabajo Estandar No Urgente: " + noUrgenteEst.costo());
		System.out.println("Trabajo Estandar Urgente: " + urgenteEst.costo());
		System.out.println("Trabajo Personalizado No Urgente: " + noUrgentePer.costo());
		System.out.println("Trabajo Personalizado Urgente: " + urgentePer.costo());
	}

	public static void agregarTareasTrabajador() {
	
		Oficio carpinteria = new Oficio("Carpinteria");
		Oficio electricidad = new Oficio ("Electricidad");
		
		ServicioPersonalizado servPer = new ServicioPersonalizado(electricidad, 1000, 200, 800);
		ServicioEstandar servEst = new ServicioEstandar(carpinteria, 1000, 0.2);
		
		Trabajador electricista =  new Trabajador(electricidad,"Martin", "email@gmail.com", 0.2, 500);
		Trabajador carpintero =  new Trabajador(carpinteria,"Juan", "email@gmail.com", 0.2, 500);
		
		Trabajo noUrgenteEst = new Trabajo(servEst, false, "15-01-2000");
		Trabajo urgenteEst = new Trabajo(servEst, true, "15-01-2000");
		
		Trabajo urgentePer = new Trabajo(servPer, true, "15-01-2000");
		Trabajo noUrgentePer = new Trabajo(servPer, false, "15-01-2000");
		
		
		//Falla por Oficio
		
		try { 
			electricista.agregarTrabajo(noUrgenteEst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
		
		try { 
			carpintero.agregarTrabajo(noUrgentePer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
		
		//Falla por Agenda Ocupada
		
		try { 
			electricista.agregarTrabajo(noUrgentePer);
			electricista.agregarTrabajo(urgentePer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
		
		
		try { 
			carpintero.agregarTrabajo(noUrgenteEst);
			carpintero.agregarTrabajo(urgenteEst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
		
		
		//Caso de Exito
		carpintero =  new Trabajador(carpinteria,"Juan", "email@gmail.com", 0.2, 500);
		//Limpio la lista de trabajos
		Trabajo t3 = new Trabajo(servEst, false, "16-01-2000");
		
		try { 
			carpintero.agregarTrabajo(noUrgenteEst);
			System.out.println("Primer Trabajo Agregado con Exito");
			carpintero.agregarTrabajo(t3);
			System.out.println("Segundo Trabajo Agregado con Exito");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	}
	
}

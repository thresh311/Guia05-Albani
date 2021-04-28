package clases;

public class Oficio {
	
		protected String nombre;
		
		public Oficio (String nombre) {
			this.nombre = nombre;
		}
		
		public boolean equals(Oficio other) {
			return this.nombre.equalsIgnoreCase(other.nombre);
		}
}

package Netflix;

public class Pelicula {
	
	
	String nombre;
	Servicio servicio;
	

	public Pelicula(String nombre, Servicio servicio) {

		this.nombre = nombre;
		this.servicio = servicio;
	}

	public String getNombre() {
		return nombre;
	}

	public Servicio getServicio() {
		return servicio;
	}
	
	


}

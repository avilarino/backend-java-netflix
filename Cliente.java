package Netflix;

import java.util.ArrayList;


public class Cliente {
	private String dni;
	private String nombre;
	private int saldo;
	private ArrayList <Pelicula> peliculas = new ArrayList<>();
	private Servicio servicio;
	
	Cliente(String dni, String nombre, int saldo, Servicio servicio){
		this.peliculas = peliculas;
		this.dni = dni;
		this.nombre = nombre;
		this.saldo = saldo;
		this.servicio = servicio;
	}
	
	
	public boolean esDeudor() {
		boolean resultado = false;
		if(saldo > 0) {
			resultado = true;
		}
		return resultado;
	}
	
	
	public Servicio getServicio() {
		return servicio;
	}


	public String getDni() {
		return dni;
	}



	public ResultadoBaja verPelicula(Cliente cliente, Pelicula pelicula) {
		
		ResultadoBaja resultado = null;
		
		if(cliente.getDni().equals(null)) {
			resultado = ResultadoBaja.CLIENTE_INEXISTENTE;
		} else if (pelicula.getNombre().equals(null)) {
			resultado = ResultadoBaja.CONTENIDO_INEXISTENTE;
		} else if (cliente.esDeudor() == true) {
			resultado = ResultadoBaja.CLIENTE_DEUDOR;
		} else if (cliente.getServicio() != Servicio.PREMIUM && pelicula.getServicio() == Servicio.PREMIUM) {
			resultado = ResultadoBaja.CONTENIDO_NO_DISPONIBLE;
		} else {
			resultado = ResultadoBaja.OK;
		}
		
		return resultado;
	}
	
	
	public Pelicula buscarPelicula(String nombre) {
	
		Pelicula peliculaBuscada = null;
		int i = 0;
	
		while (i < this.peliculas.size() && peliculaBuscada == null) {
			if (this.peliculas.get(i).getNombre().equalsIgnoreCase(nombre)) {
				peliculaBuscada = this.peliculas.get(i);
			}
			i++;
		}
		return peliculaBuscada;
	
	}
	
	public boolean agregarPelicula(String nombre, Servicio servicio) {
	
	Pelicula peliculaAgregar = this.buscarPelicula(nombre);
	boolean agregada = false;
	
	if(peliculaAgregar == null) {
		
		Pelicula peliculaNueva = new Pelicula(nombre, servicio);
		this.peliculas.add(peliculaNueva);
		agregada = true;
	}
	
	return agregada;
	
}

}



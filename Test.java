package Netflix;

public class Test {

	public static void main(String[] args) {
		
		
		 Netflix netflix = new Netflix();

	  
	        netflix.agregarCliente("12345678", "Juan", 0, Servicio.STANDAR);
	        netflix.agregarCliente("87654321", "Maria", 50, Servicio.PREMIUM);
	        netflix.agregarCliente("98765432", "Pedro", -20, Servicio.STANDAR);


	        System.out.println(netflix.darDeAlta("12345678", Servicio.STANDAR)); 
	        System.out.println(netflix.darDeAlta("87654321", Servicio.PREMIUM));
	        System.out.println(netflix.darDeAlta("11111111", Servicio.STANDAR));


	        netflix.darDebaja("12345678");

	       
	        System.out.println(netflix.darDeAlta("12345678", Servicio.PREMIUM));

	      
	        Pelicula pelicula1 = new Pelicula("Pelicula 1", Servicio.STANDAR);
	        Pelicula pelicula2 = new Pelicula("Pelicula 2", Servicio.PREMIUM);

	   
	        Cliente cliente = netflix.buscarCliente("87654321");
	        System.out.println(cliente.verPelicula(cliente, pelicula1)); 
	        System.out.println(cliente.verPelicula(cliente, pelicula2));

	}

}

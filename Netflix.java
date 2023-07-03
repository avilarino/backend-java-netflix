package Netflix;

import java.util.ArrayList;

public class Netflix {

	
	ArrayList <Cliente> clientes = new ArrayList<>();
	ArrayList <Cliente> clientesBorrados = new ArrayList<>();
	
	
	Netflix(){
		this.clientes = clientes;
	}
	
	public Cliente buscarCliente(String dni) {
		
		Cliente clienteBuscado = null;
		int i = 0;
	
		while (i < this.clientes.size() && clienteBuscado == null) {
			if (this.clientes.get(i).getDni().equalsIgnoreCase(dni)) {
				clienteBuscado = this.clientes.get(i);
			}
			i++;
		}
		return clienteBuscado;
	
	}
	
	public boolean agregarCliente(String dni, String nombre, int saldo, Servicio servicio) {
		
		Cliente clienteAgregar = this.buscarCliente(dni);
		boolean agregado = false;
		
		if(clienteAgregar == null) {
			
			Cliente clienteNuevo = new Cliente(dni,nombre,saldo,servicio);
			this.clientes.add(clienteNuevo);
			agregado = true;
		}
		
		return agregado;
		

	}
	
	
	public void darDebaja(String dni) {
		Cliente clienteAEliminar = this.buscarCliente(dni);
		
		if(clienteAEliminar != null) {
			this.clientes.remove(clienteAEliminar);
			this.clientesBorrados.add(clienteAEliminar);
		}
	}

	public ResultadoAlta darDeAlta(String dni, Servicio servicio) {
		Cliente clienteDeAlta = this.buscarCliente(dni);
		ResultadoAlta resultado = ResultadoAlta.ALTA_OK;
		
		if(clienteDeAlta != null) {
			resultado = ResultadoAlta.CLIENTE_EXISTENTE;
		} else if (clientesBorrados.contains(clienteDeAlta) && clienteDeAlta.esDeudor()) {
			resultado = ResultadoAlta.CLIENTE_DEUDOR;
		} else {
			resultado = ResultadoAlta.ALTA_OK;
		}
		return resultado;
	}
	
	
	
}

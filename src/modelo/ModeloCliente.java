
package modelo;

import java.io.Serializable;

public class ModeloCliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String nombre;
	String telefono;
	
	public ModeloCliente(String id, String nombre, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public ModeloCliente() {
		super();
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return nombre + " tlf: " + telefono;
	}

	
}

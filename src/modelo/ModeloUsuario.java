
package modelo;

import java.io.Serializable;

public class ModeloUsuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombreUsuario;
	String rol;

	public ModeloUsuario(String nombreUsuario, String rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.rol = rol;

	}

	public ModeloUsuario() {
		super();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "ModeloCliente [nombreUsuario=" + nombreUsuario + ", rol=" + rol + "]";
	}
}
	
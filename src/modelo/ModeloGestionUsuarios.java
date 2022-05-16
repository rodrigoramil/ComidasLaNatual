
package modelo;

import java.io.Serializable;

public class ModeloGestionUsuarios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombreUsuario;
	String contrasena;
	String rol;

	public ModeloGestionUsuarios(String nombreUsuario, String contrasena, String rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "ModeloGestionUsuarios [nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", rol=" + rol
				+ "]";
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
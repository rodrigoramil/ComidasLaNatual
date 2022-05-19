
package modelo;

import java.io.Serializable;

public class ModeloGestionUsuarios implements Serializable{

	private static final long serialVersionUID = 1L;
	int IdUsuario;
	String nombreUsuario;
	String contrasena;
	String rol;

	public ModeloGestionUsuarios(int IdUsuario,String nombreUsuario, String rol) {
		super();
		this.IdUsuario = IdUsuario;
		this.nombreUsuario = nombreUsuario;
		this.rol = rol;
	}
	
	public ModeloGestionUsuarios(String nombreUsuario, String contrasena, String rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	
	public ModeloGestionUsuarios(int IdUsuario,String nombreUsuario, String contrasena, String rol) {
		super();
		this.IdUsuario = IdUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
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
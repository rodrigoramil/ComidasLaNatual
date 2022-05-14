
package modelo;

import java.io.Serializable;

public class ModeloRecetario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8891320620372209880L;
	
	String nombreReceta;
	String Estado;
	
	public ModeloRecetario(String nombreReceta, String estado) {
		super();
		this.nombreReceta = nombreReceta;
		Estado = estado;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}

	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "ModeloRecetario [nombreReceta=" + nombreReceta + ", Estado=" + Estado + "]";
	}
	
}
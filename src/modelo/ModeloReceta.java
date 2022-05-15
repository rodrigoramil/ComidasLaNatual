package modelo;

import java.io.Serializable;

public class ModeloReceta  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ingrediente;
	private float cantidad;
	private String elaboracion; 
	private String nombreReceta;
	/**
	 * @param ingrediente
	 * @param cantidad
	 * @param elaboracion
	 * @param nombreReceta
	 */
	public ModeloReceta(String ingrediente, float cantidad, String elaboracion, String nombreReceta) {
		super();
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
		this.elaboracion = elaboracion;
		this.nombreReceta = nombreReceta;
	}
	/**
	 * 
	 */
	public ModeloReceta() {
		super();
	}
	public String getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public String getElaboracion() {
		return elaboracion;
	}
	public void setElaboracion(String elaboracion) {
		this.elaboracion = elaboracion;
	}
	public String getNombreReceta() {
		return nombreReceta;
	}
	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}
	@Override
	public String toString() {
		return "ModeloReceta [ingrediente=" + ingrediente + ", cantidad=" + cantidad + ", elaboracion=" + elaboracion
				+ ", nombreReceta=" + nombreReceta + "]";
	}
	
}


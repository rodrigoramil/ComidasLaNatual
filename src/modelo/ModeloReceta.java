package modelo;

import java.io.Serializable;

public class ModeloReceta  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IdProducto;
	private int IdReceta;
	private float cantidad;
	private String elaboracion; 
	private String nombreReceta;

	public ModeloReceta(int idProducto, int idReceta, float cantidad, String elaboracion, String nombreReceta) {
		super();
		IdProducto = idProducto;
		IdReceta = idReceta;
		this.cantidad = cantidad;
		this.elaboracion = elaboracion;
		this.nombreReceta = nombreReceta;

	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public int getIdReceta() {
		return IdReceta;
	}

	public void setIdReceta(int idReceta) {
		IdReceta = idReceta;
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
		return "ModeloReceta [IdProducto=" + IdProducto + ", IdReceta=" + IdReceta + ", cantidad=" + cantidad
				+ ", elaboracion=" + elaboracion + ", nombreReceta=" + nombreReceta + "]";
	}
	
}
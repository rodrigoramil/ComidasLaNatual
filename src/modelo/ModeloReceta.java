package modelo;

import java.io.Serializable;

public class ModeloReceta  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idReceta;
	String nombreReceta;
	int idProducto;
	String nombreProducto;
	float cantidad;
	/**
	 * @param idReceta
	 * @param nombreReceta
	 * @param idProducto
	 * @param nombreProducto
	 * @param cantidad
	 */
	public ModeloReceta(int idReceta, String nombreReceta, int idProducto, String nombreProducto, float cantidad) {
		super();
		this.idReceta = idReceta;
		this.nombreReceta = nombreReceta;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
	}
	/**
	 * 
	 */
	public ModeloReceta() {
		super();
	}
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public String getNombreReceta() {
		return nombreReceta;
	}
	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ModeloReceta [idReceta=" + idReceta + ", nombreReceta=" + nombreReceta + ", idProducto=" + idProducto
				+ ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + "]";
	}
	
}
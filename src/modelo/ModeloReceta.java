package modelo;

import java.io.Serializable;

public class ModeloReceta  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idProducto;
	private String nombreProducto;
	private int idReceta;
	private String nombreReceta;
	private float cantidad;
	private String elaboracion;
	private float precioVenta;
	/**
	 * @param idProducto
	 * @param nombreProducto
	 * @param idReceta
	 * @param nombreReceta
	 * @param cantidad
	 * @param elaboracion
	 * @param precioVenta
	 */
	public ModeloReceta(int idProducto, String nombreProducto, int idReceta, String nombreReceta, float cantidad,
			String elaboracion, float precioVenta) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.idReceta = idReceta;
		this.nombreReceta = nombreReceta;
		this.cantidad = cantidad;
		this.elaboracion = elaboracion;
		this.precioVenta = precioVenta;
	}
	/**
	 * 
	 */
	public ModeloReceta() {
		super();
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
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	@Override
	public String toString() {
		return "ModeloReceta [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", idReceta="
				+ idReceta + ", nombreReceta=" + nombreReceta + ", cantidad=" + cantidad + ", elaboracion="
				+ elaboracion + ", precioVenta=" + precioVenta + "]";
	}
	
}
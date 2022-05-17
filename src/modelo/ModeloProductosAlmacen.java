
package modelo;

import java.io.Serializable;

public class ModeloProductosAlmacen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3971849102945419286L;
	int idProducto;
	String nombreProducto;
	float cantidad;
	/**
	 * @param idProducto
	 * @param nombreProducto
	 * @param cantidad
	 */
	public ModeloProductosAlmacen(int idProducto, String nombreProducto, float cantidad) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
	}
	/**
	 * 
	 */
	public ModeloProductosAlmacen() {
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
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ModeloProductosAlmacen [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", cantidad="
				+ cantidad + "]";
	}
	
}

	
	
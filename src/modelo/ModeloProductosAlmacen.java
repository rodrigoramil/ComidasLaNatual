
package modelo;

import java.io.Serializable;

public class ModeloProductosAlmacen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3971849102945419286L;
	String productos;
	float cantidad;

	public ModeloProductosAlmacen(String productos, float cantidad) {
		super();
		this.productos = productos;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ModeloProductosAlmacen [productos=" + productos + ", cantidad=" + cantidad + "]";
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}

	
	
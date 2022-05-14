
package modelo;

import java.io.Serializable;

public class ModeloAlmacen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1522571376895366509L;
	
	String nombreProducto;
	float cantidadActual;
	float cantidadMinima;
	float cantidadMaxima;
	public ModeloAlmacen(String nombreProducto, float cantidadActual, float cantidadMinima, float cantidadMaxima) {
		super();
		this.nombreProducto = nombreProducto;
		this.cantidadActual = cantidadActual;
		this.cantidadMinima = cantidadMinima;
		this.cantidadMaxima = cantidadMaxima;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getCantidadActual() {
		return cantidadActual;
	}
	public void setCantidadActual(float cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	public float getCantidadMinima() {
		return cantidadMinima;
	}
	public void setCantidadMinima(float cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	public float getCantidadMaxima() {
		return cantidadMaxima;
	}
	public void setCantidadMaxima(float cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}
	@Override
	public String toString() {
		return "ModeloAlmacen [nombreProducto=" + nombreProducto + ", cantidadActual=" + cantidadActual
				+ ", cantidadMinima=" + cantidadMinima + ", cantidadMaxima=" + cantidadMaxima + "]";
	}
	
}
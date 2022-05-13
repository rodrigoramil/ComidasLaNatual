
package modelo;

import java.io.Serializable;

public class ModeloAlmacen implements Serializable {

	// private static final long serialVersionUID = 1L;
	int idProducto;

	String nombreProducto;
	float cantidad;
	int idUnidadMedida;
	float cantidadMinima;
	float cantidadMaxima;

	public ModeloAlmacen(int idProducto, String nombreProducto, float cantidad, int idUnidadMedida,
			float cantidadMinima, float cantidadMaxima) {
		// super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.idUnidadMedida = idUnidadMedida;
		this.cantidadMinima = cantidadMinima;
		this.cantidadMaxima = cantidadMaxima;
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

	public int getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(int idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
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
		return "ModeloAlmacen [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", cantidad="
				+ cantidad + ", idUnidadMedida=" + idUnidadMedida + ", cantidadMinima=" + cantidadMinima
				+ ", cantidadMaxima=" + cantidadMaxima + "]";
	}

}
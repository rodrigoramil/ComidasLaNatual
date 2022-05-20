
package modelo;

import java.io.Serializable;

public class ModeloAlmacen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1522571376895366509L;
	int idProducto;
	String nombreProducto;	
	float cantidadActual;
	int unidadMedida;
	float cantidadMinima;
	float cantidadMaxima;
	int tipo;
	/**
	 * @param idProducto
	 * @param nombreProducto
	 * @param cantidadActual
	 * @param unidadMedida
	 * @param cantidadMinima
	 * @param cantidadMaxima
	 * @param tipo
	 */
	public ModeloAlmacen(int idProducto, String nombreProducto, float cantidadActual, int unidadMedida,
			float cantidadMinima, float cantidadMaxima, int tipo) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidadActual = cantidadActual;
		this.unidadMedida = unidadMedida;
		this.cantidadMinima = cantidadMinima;
		this.cantidadMaxima = cantidadMaxima;
		this.tipo = tipo;
	}
	/**
	 * 
	 */
	public ModeloAlmacen() {
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
	public float getCantidadActual() {
		return cantidadActual;
	}
	public void setCantidadActual(float cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	public int getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(int unidadMedida) {
		this.unidadMedida = unidadMedida;
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
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "ModeloAlmacen [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", cantidadActual="
				+ cantidadActual + ", unidadMedida=" + unidadMedida + ", cantidadMinima=" + cantidadMinima
				+ ", cantidadMaxima=" + cantidadMaxima + ", tipo=" + tipo + "]";
	}	
	
}

package modelo;

import java.io.Serializable;

public class ModeloAlmacen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1522571376895366509L;
	
	String nombreProducto;	
	float cantidadActual;
	int unidadMedida;
	float cantidadMinima;
	float cantidadMaxima;
	int tipo;	
	/**
	 * @param nombreProducto
	 * @param tipo
	 * @param cantidadActual
	 * @param unidadMedida
	 * @param cantidadMinima
	 * @param cantidadMaxima
	 */
	public ModeloAlmacen(String nombreProducto, float cantidadActual, int unidadMedida, float cantidadMinima, float cantidadMaxima, int tipo) {
		super();
		this.nombreProducto = nombreProducto;		
		this.cantidadActual = cantidadActual;
		this.unidadMedida = unidadMedida;
		this.cantidadMinima = cantidadMinima;
		this.cantidadMaxima = cantidadMaxima;
		this.tipo = tipo;
	}
	/**
	 * @param f 
	 * @param string 
	 * 
	 */
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
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
	@Override
	public String toString() {
		return "ModeloAlmacen [nombreProducto=" + nombreProducto + ", tipo=" + tipo + ", cantidadActual="
				+ cantidadActual + ", unidadMedida=" + unidadMedida + ", cantidadMinima=" + cantidadMinima
				+ ", cantidadMaxima=" + cantidadMaxima + "]";
	}

}
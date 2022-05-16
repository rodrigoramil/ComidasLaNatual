
package modelo;

import java.io.Serializable;

public class ModeloRecetario implements Serializable{

	private static final long serialVersionUID = -8891320620372209880L;
	
	int idReceta;
	String nombreReceta;
	float precioVenta;
	String tipo;
	String disponibilidad;	
	String elaboracion;
	/**
	 * @param idReceta
	 * @param nombreReceta
	 * @param precioVenta
	 * @param tipo
	 * @param disponibilidad
	 * @param elaboracion
	 */
	public ModeloRecetario(int idReceta, String nombreReceta, float precioVenta, String tipo, String disponibilidad,
			String elaboracion) {
		super();
		this.idReceta = idReceta;
		this.nombreReceta = nombreReceta;
		this.precioVenta = precioVenta;
		this.tipo = tipo;
		this.disponibilidad = disponibilidad;
		this.elaboracion = elaboracion;
	}
	/**
	 * 
	 */
	public ModeloRecetario() {
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
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getElaboracion() {
		return elaboracion;
	}
	public void setElaboracion(String elaboracion) {
		this.elaboracion = elaboracion;
	}
	@Override
	public String toString() {
		return "ModeloRecetario [idReceta=" + idReceta + ", nombreReceta=" + nombreReceta + ", precioVenta="
				+ precioVenta + ", tipo=" + tipo + ", disponibilidad=" + disponibilidad + ", elaboracion=" + elaboracion
				+ "]";
	}
	
}
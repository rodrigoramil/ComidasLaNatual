package modelo;

import java.io.Serializable;

public class ModeloComidaBebida implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1906510941001195986L;
	int idReceta;
	String nombreReceta;
	float precioVenta;
	String estado;
	String tipo;
	/**
	 * @param idReceta
	 * @param nombreReceta
	 * @param precioVenta
	 * @param estado
	 * @param tipo
	 */
	public ModeloComidaBebida(int idReceta, String nombreReceta, float precioVenta, String estado, String tipo) {
		super();
		this.idReceta = idReceta;
		this.nombreReceta = nombreReceta;
		this.precioVenta = precioVenta;
		this.estado = estado;
		this.tipo = tipo;
	}
	/**
	 * 
	 */
	public ModeloComidaBebida() {
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "ModeloComidaBebida [idReceta=" + idReceta + ", nombreReceta=" + nombreReceta + ", precioVenta="
				+ precioVenta + ", estado=" + estado + ", tipo=" + tipo + "]";
	}
	
}

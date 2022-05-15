package modelo;

import java.io.Serializable;

public class ModeloComidaBebida implements Serializable  {

	String nombreReceta;
	float precioVenta;
	String estado;
	/**
	 * @param nombreReceta
	 * @param precioVenta
	 * @param estado
	 */
	public ModeloComidaBebida(String nombreReceta, float precioVenta, String estado) {
		super();
		this.nombreReceta = nombreReceta;
		this.precioVenta = precioVenta;
		this.estado = estado;
	}
	/**
	 * 
	 */
	public ModeloComidaBebida() {
		super();
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
	@Override
	public String toString() {
		return "ModeloBebidaComida [nombreReceta=" + nombreReceta + ", precioVenta=" + precioVenta + ", estado="
				+ estado + "]";
	}
	
}

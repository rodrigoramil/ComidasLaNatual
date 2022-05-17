package modelo;

import java.io.Serializable;

public class ModeloPedido implements Serializable {

	private static final long serialVersionUID = -2144175894579284069L;
	
	String nombreReceta;
	float precioVenta;
	int cantidadRecetaVenta;
	String nombreCliente;
	/**
	 * @param nombreReceta
	 * @param precioVenta
	 * @param cantidadRecetaVenta
	 * @param nombreCliente
	 */
	public ModeloPedido(String nombreReceta, float precioVenta, int cantidadRecetaVenta, String nombreCliente) {
		super();
		this.nombreReceta = nombreReceta;
		this.precioVenta = precioVenta;
		this.cantidadRecetaVenta = cantidadRecetaVenta;
		this.nombreCliente = nombreCliente;
	}
	/**
	 * 
	 */
	public ModeloPedido() {
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
	public int getCantidadRecetaVenta() {
		return cantidadRecetaVenta;
	}
	public void setCantidadRecetaVenta(int cantidadRecetaVenta) {
		this.cantidadRecetaVenta = cantidadRecetaVenta;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	@Override
	public String toString() {
		return "ModeloPedido [nombreReceta=" + nombreReceta + ", precioVenta=" + precioVenta + ", cantidadRecetaVenta="
				+ cantidadRecetaVenta + ", nombreCliente=" + nombreCliente + "]";
	}
	
}

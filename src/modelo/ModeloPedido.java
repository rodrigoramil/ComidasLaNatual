package modelo;

import java.io.Serializable;

public class ModeloPedido implements Serializable {

	private static final long serialVersionUID = -2144175894579284069L;

	int idPedido;
	int idCliente;
	String nombreCliente;
	int idReceta;
	String nombreReceta;
	int cantidadRecetaVenta;
	float precioVenta;
	/**
	 * @param idPedido
	 * @param idCliente
	 * @param nombreCliente
	 * @param idReceta
	 * @param nombreReceta
	 * @param cantidadRecetaVenta
	 * @param precioVenta
	 */

	public ModeloPedido(int idPedido, int idCliente, String nombreCliente, int idReceta, String nombreReceta, int cantidadRecetaVenta, float precioVenta) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.idReceta = idReceta;
		this.nombreReceta = nombreReceta;
		this.cantidadRecetaVenta = cantidadRecetaVenta;
		this.precioVenta = precioVenta;
	}

	/**
	 * 
	 */
	public ModeloPedido() {
		super();
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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
	public int getCantidadRecetaVenta() {
		return cantidadRecetaVenta;
	}
	public void setCantidadRecetaVenta(int cantidadRecetaVenta) {
		this.cantidadRecetaVenta = cantidadRecetaVenta;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	@Override
	public String toString() {
		return "ModeloPedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", nombreCliente=" + nombreCliente
				+ ", idReceta=" + idReceta + ", nombreReceta=" + nombreReceta + ", cantidadRecetaVenta="
				+ cantidadRecetaVenta + ", precioVenta=" + precioVenta + "]";
	}
	
}

package modelo;

import java.io.Serializable;

public class ModeloPedido implements Serializable {

	private static final long serialVersionUID = -2144175894579284069L;

	int idReceta;
	String nombreReceta;
	float precioVenta;
	int cantidadRecetaVenta;
	String nombreCliente;
	int idPedido;
	int idCliente;
	/**
	 * @param idReceta
	 * @param nombreReceta
	 * @param precioVenta
	 * @param cantidadRecetaVenta
	 * @param nombreCliente
	 * @param idPedido
	 * @param idCliente
	 */
	public ModeloPedido(int idReceta, String nombreReceta, float precioVenta, int cantidadRecetaVenta,
			String nombreCliente, int idPedido, int idCliente) {
		super();
		this.idReceta = idReceta;
		this.nombreReceta = nombreReceta;
		this.precioVenta = precioVenta;
		this.cantidadRecetaVenta = cantidadRecetaVenta;
		this.nombreCliente = nombreCliente;
		this.idPedido = idPedido;
		this.idCliente = idCliente;
	}
	/**
	 * 
	 */
	public ModeloPedido() {
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
	@Override
	public String toString() {
		return "ModeloPedido [idReceta=" + idReceta + ", nombreReceta=" + nombreReceta + ", precioVenta=" + precioVenta
				+ ", cantidadRecetaVenta=" + cantidadRecetaVenta + ", nombreCliente=" + nombreCliente + ", idPedido="
				+ idPedido + ", idCliente=" + idCliente + "]";
	}
	
}

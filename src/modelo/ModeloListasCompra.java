package modelo;

import java.io.Serializable;

public class ModeloListasCompra  implements Serializable {
	private int IdCompraProductos;
	private String fechaCompra;
	private boolean compraHecha;
	/**
	 * @param idCompraProductos
	 * @param fechaCompra
	 * @param compraHecha
	 */
	public ModeloListasCompra(int idCompraProductos, String fechaCompra, boolean compraHecha) {
		super();
		IdCompraProductos = idCompraProductos;
		this.fechaCompra = fechaCompra;
		this.compraHecha = compraHecha;
	}
	/**
	 * 
	 */
	public ModeloListasCompra() {
		super();
	}
	public int getIdCompraProductos() {
		return IdCompraProductos;
	}
	public void setIdCompraProductos(int idCompraProductos) {
		IdCompraProductos = idCompraProductos;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public boolean getCompraHecha() {
		return compraHecha;
	}
	public void setCompraHecha(boolean compraHecha) {
		this.compraHecha = compraHecha;
	}
	@Override
	public String toString() {
		return "ListasCompra [IdCompraProductos=" + IdCompraProductos + ", fechaCompra=" + fechaCompra
				+ ", compraHecha=" + compraHecha + "]";
	}
	
}

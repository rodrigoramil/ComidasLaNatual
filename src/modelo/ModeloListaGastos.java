package modelo;

import java.io.Serializable;

public class ModeloListaGastos implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3864524156018777728L;
	
	private int idCompraProductos;
	private String fechaCompra;
	private boolean compraHecha;
	private float gastoCompra;
	private String nombreUsuario;
	/**
	 * @param idCompraProductos
	 * @param fechaCompra
	 * @param compraHecha
	 * @param gastoCompra
	 * @param nombreUsuario
	 */
	public ModeloListaGastos(int idCompraProductos, String fechaCompra, boolean compraHecha, float gastoCompra,	String nombreUsuario) {
		super();
		this.idCompraProductos = idCompraProductos;
		this.fechaCompra = fechaCompra;
		this.compraHecha = compraHecha;
		this.gastoCompra = gastoCompra;
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * 
	 */
	public ModeloListaGastos() {
		super();
	}
	public int getIdCompraProductos() {
		return idCompraProductos;
	}
	public void setIdCompraProductos(int idCompraProductos) {
		this.idCompraProductos = idCompraProductos;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public boolean isCompraHecha() {
		return compraHecha;
	}
	public void setCompraHecha(boolean compraHecha) {
		this.compraHecha = compraHecha;
	}
	public float getGastoCompra() {
		return gastoCompra;
	}
	public void setGastoCompra(float gastoCompra) {
		this.gastoCompra = gastoCompra;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	@Override
	public String toString() {
		return "ModeloListaGastos [idCompraProductos=" + idCompraProductos + ", fechaCompra=" + fechaCompra
				+ ", compraHecha=" + compraHecha + ", gastoCompra=" + gastoCompra + ", nombreUsuario=" + nombreUsuario
				+ "]";
	}
	
}

package modelo;

import java.io.Serializable;

public class ModeloPrepararCompra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 81027022915327052L;
	
	private String Producto;
	private float cantidadCompra;
	private float CantidadMaxima;
	/**
	 * @param producto
	 * @param cantidadCompra
	 * @param cantidadMaxima
	 */
	public ModeloPrepararCompra(String producto, float cantidadCompra, float cantidadMaxima) {
		super();
		Producto = producto;
		this.cantidadCompra = cantidadCompra;
		CantidadMaxima = cantidadMaxima;
	}
	/**
	 * 
	 */
	public ModeloPrepararCompra() {
		super();
	}
	public String getProducto() {
		return Producto;
	}
	public void setProducto(String producto) {
		Producto = producto;
	}
	public float getCantidadCompra() {
		return cantidadCompra;
	}
	public void setCantidadCompra(float cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}
	public float getCantidadMaxima() {
		return CantidadMaxima;
	}
	public void setCantidadMaxima(float cantidadMaxima) {
		CantidadMaxima = cantidadMaxima;
	}
	@Override
	public String toString() {
		return "ModeloPrepararCompra [Producto=" + Producto + ", cantidadCompra=" + cantidadCompra + ", CantidadMaxima="
				+ CantidadMaxima + "]";
	}
	
	
}

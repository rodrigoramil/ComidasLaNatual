package modelo;

import java.io.Serializable;

public class ModeloPrepararCompra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 81027022915327052L;
	
	private String Producto;
	private float cantidadActual;
	private float CantidadMaxima;
	/**
	 * @param producto
	 * @param cantidadActual
	 * @param cantidadMaxima
	 */
	public ModeloPrepararCompra(String producto, float cantidadActual, float cantidadMaxima) {
		super();
		Producto = producto;
		this.cantidadActual = cantidadActual;
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
	public float getCantidadActual() {
		return cantidadActual;
	}
	public void setCantidadActual(float cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	public float getCantidadMaxima() {
		return CantidadMaxima;
	}
	public void setCantidadMaxima(float cantidadMaxima) {
		CantidadMaxima = cantidadMaxima;
	}
	@Override
	public String toString() {
		return "ModeloPrepararCompra [Producto=" + Producto + ", cantidadActual=" + cantidadActual + ", CantidadMaxima="
				+ CantidadMaxima + "]";
	}
	
}

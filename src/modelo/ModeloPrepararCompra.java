package modelo;

import java.io.Serializable;

public class ModeloPrepararCompra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 81027022915327052L;
	
	private String Producto;
	private float cantidadCompra;
	/**
	 * @param producto
	 * @param cantidadCompra
	 */
	public ModeloPrepararCompra(String producto, float cantidadCompra) {
		super();
		Producto = producto;
		this.cantidadCompra = cantidadCompra;
	}

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

	@Override
	public String toString() {
		return "ModeloPrepararCompra [Producto=" + Producto + ", cantidadCompra=" + cantidadCompra + "]";
	}
	
}

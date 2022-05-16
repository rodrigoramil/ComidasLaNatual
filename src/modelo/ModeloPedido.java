package modelo;

import java.io.Serializable;

public class ModeloPedido implements Serializable {

	private static final long serialVersionUID = -2144175894579284069L;
	
	String comidaBebida;
	int cantidad;
	float precio;
	int IdCliente;
	public ModeloPedido(String comidaBebida, int cantidad, float precio) {
		super();
		this.comidaBebida = comidaBebida;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public ModeloPedido(String string, float f, int i, String string2) {
		super();
		this.IdCliente = IdCliente;
	}

	public String getComidaBebida() {
		return comidaBebida;
	}

	public void setComidaBebida(String comidaBebida) {
		this.comidaBebida = comidaBebida;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}

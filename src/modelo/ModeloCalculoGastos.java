package modelo;

import java.io.Serializable;
import java.sql.Date;

public class ModeloCalculoGastos implements Serializable {
	private static final long serialVersionUID = 6193645767751334541L;
	
	int IdCompraProductos;
	boolean comprahecha;
	Date fechaCompra;
	float gastoCompra;
	public ModeloCalculoGastos(int idCompraProductos, boolean comprahecha, Date fechaCompra, float gastoCompra) {
		super();
		IdCompraProductos = idCompraProductos;
		this.comprahecha = comprahecha;
		this.fechaCompra = fechaCompra;
		this.gastoCompra = gastoCompra;
	}
	public ModeloCalculoGastos(float float1) {
		// TODO Auto-generated constructor stub
	}
	public int getIdCompraProductos() {
		return IdCompraProductos;
	}
	public void setIdCompraProductos(int idCompraProductos) {
		IdCompraProductos = idCompraProductos;
	}
	public boolean isComprahecha() {
		return comprahecha;
	}
	public void setComprahecha(boolean comprahecha) {
		this.comprahecha = comprahecha;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public float getGastoCompra() {
		return gastoCompra;
	}
	public void setGastoCompra(float gastoCompra) {
		this.gastoCompra = gastoCompra;
	}

}
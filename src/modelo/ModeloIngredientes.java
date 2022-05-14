
package modelo;

import java.io.Serializable;

public class ModeloIngredientes implements Serializable{
	
	//private static final long serialVersionUID = 1L;
	int idReceta;
	

	int idProducto;
	float cantidad;
	
	public ModeloIngredientes(int idReceta, int idProducto, float cantidad) {
		//super();
		this.idReceta = idReceta;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ModeloIngredientes [idReceta=" + idReceta + ", idProducto=" + idProducto + ", cantidad=" + cantidad
				+ "]";
	}

}
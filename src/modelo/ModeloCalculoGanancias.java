package modelo;

import java.io.Serializable;
import java.sql.Date;

public class ModeloCalculoGanancias implements Serializable {
	private static final long serialVersionUID = 6193645767751334541L;
	
	int idPedido;
	String fechaPedido;
	float gananciaPedido;
	
	public ModeloCalculoGanancias(int idPedido, String fechaPedido, float gananciaPedido) {
		super();
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.gananciaPedido = gananciaPedido;
	}

	public ModeloCalculoGanancias(float gananciaPedido) {
		this.gananciaPedido = gananciaPedido;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public float getGananciaPedido() {
		return gananciaPedido;
	}

	public void setGananciaPedido(float gananciaPedido) {
		this.gananciaPedido = gananciaPedido;
	}
	
}
package modelo;

import java.io.Serializable;
import java.sql.Date;

public class ModeloCalculoGanancias implements Serializable {
	private static final long serialVersionUID = 6193645767751334541L;
	
	int idPedido;
	Date fechaPedido;
	float gananciaPedido;
	String usuario;
	/**
	 * @param idPedido
	 * @param fechaPedido
	 * @param gananciaPedido
	 * @param usuario
	 */
	public ModeloCalculoGanancias(int idPedido, Date fechaPedido, float gananciaPedido, String usuario) {
		super();
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.gananciaPedido = gananciaPedido;
		this.usuario = usuario;
	}
	/**
	 * 
	 */
	public ModeloCalculoGanancias() {
		super();
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public float getGananciaPedido() {
		return gananciaPedido;
	}
	public void setGananciaPedido(float gananciaPedido) {
		this.gananciaPedido = gananciaPedido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "ModeloCalculoGanancias [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", gananciaPedido="
				+ gananciaPedido + ", usuario=" + usuario + "]";
	}
	
}

package modelo;

import java.io.Serializable;

public class ModeloRecetario implements Serializable{
	public ModeloRecetario(int int1, String string, boolean add) {
		// TODO Auto-generated constructor stub
	}
	//private static final long serialVersionUID = 1L;
	int idTipo;
	
	String disponibilidad;
	String nombreReceta;
	float precioVenta;
	String elaboracion;
	
	
	public ModeloRecetario(int idTipo, String disponibilidad, String nombreReceta, float precioVenta, String elaboracion) {
		super();
		this.idTipo = idTipo;
		this.disponibilidad = disponibilidad;
		this.nombreReceta = nombreReceta;
		this.precioVenta = precioVenta;
		this.elaboracion = elaboracion;
		
	}
	
	public int getIdTipo() {
		return idTipo;
	}


	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}


	public String getDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	public String getNombreReceta() {
		return nombreReceta;
	}


	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}


	public float getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}


	public String getElaboracion() {
		return elaboracion;
	}


	public void setElaboracion(String elaboracion) {
		this.elaboracion = elaboracion;
	}

	@Override
	public String toString() {
		return "ModeloRecetario [idTipo=" + idTipo + ", disponibilidad=" + disponibilidad + ", nombreReceta="
				+ nombreReceta + ", precioVenta=" + precioVenta + ", elaboracion=" + elaboracion + "]";
	}


}
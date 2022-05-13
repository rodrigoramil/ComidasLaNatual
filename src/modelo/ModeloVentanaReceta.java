package modelo;

public class ModeloVentanaReceta {

	String nombreReceta;
	String nombreProducto;
	float cantidad;
	
	public ModeloVentanaReceta(String nombreReceta, String nombreProducto, float cantidad) {
		super();
		this.nombreReceta = nombreReceta;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
	}
	public ModeloVentanaReceta() {
		super();

	}
	public String getNombreReceta() {
		return nombreReceta;
	}
	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ModeloVentanaReceta [nombreReceta=" + nombreReceta + ", nombreProducto=" + nombreProducto
				+ ", cantidad=" + cantidad + "]";
	}
	
	
}

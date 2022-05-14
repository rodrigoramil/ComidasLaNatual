package modelo;

public class ModeloPRUEBA {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String receta;
	String estado;

	
	public ModeloPRUEBA(String receta, String estado) {
		super();
		this.receta = receta;
		this.estado = estado;
	
	}

	public ModeloPRUEBA() {
		super();
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ModeloReceta [receta=" + receta + ", estado=" + estado + "]";
	}

}

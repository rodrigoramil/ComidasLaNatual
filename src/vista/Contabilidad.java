package vista;

import javax.swing.JPanel;
import controlador.ControladorContabilidad;
import javax.swing.JButton;

public class Contabilidad extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5004678058994074860L;
	
	private static JPanel panelContabilidad;
	private static JButton btn_Gastos;
	private static JButton btn_volver;
	private static JButton btn_Facturacion;

	public Contabilidad() {
		super();
		inicializarComponentes();
		establecerManejador();		
	}
	
	
	public void inicializarComponentes() {
		
		panelContabilidad = VentanaPrincipal.parametrosPanel(400, 400);
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 310, 20, 70, 20);
		panelContabilidad.add(btn_volver);
		
		btn_Gastos = VentanaPrincipal.parametrosJButton("Gastos",140,120,120, 40);
		panelContabilidad.add(btn_Gastos);											
		
		btn_Facturacion = VentanaPrincipal.parametrosJButton("Facturacion",140,220,120, 40);
		panelContabilidad.add(btn_Facturacion);

		panelContabilidad.setVisible(false);

	}

	
	public void establecerManejador() {			
		ControladorContabilidad controlador = new ControladorContabilidad(this);
		btn_Gastos.addActionListener(controlador);
		btn_Facturacion.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		btn_Gastos.addMouseListener(controlador);
		btn_Facturacion.addMouseListener(controlador);
		btn_volver.addMouseListener(controlador);
		
	}


	public static JPanel getPanelContabilidad() {
		return panelContabilidad;
	}


	public static JButton getBtn_Gastos() {
		return btn_Gastos;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}


	public static JButton getBtn_Facturacion() {
		return btn_Facturacion;
	}	
	
	
	
	
	
	
}

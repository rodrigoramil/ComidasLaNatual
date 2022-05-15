package vista;

import javax.swing.JPanel;
import controlador.ControladorCliente;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Cliente extends JPanel {

	private static JPanel panelcliente;
	private static JTextField tfd_nombre;
	private static JTextField tfd_telefono;
	private static JLabel lbl_nombre;
	private static JLabel lbl_telefono;
	private static JButton btn_Aceptar;
	private static JButton btn_volver;
	public Cliente() {
		super();
		inicializarComponentes();
		establecerManejador();		
	}

	public void inicializarComponentes() {
		
		panelcliente = VentanaPrincipal.parametrosPanel(400, 400);

		lbl_nombre = VentanaPrincipal.parametrosJlabel("Nombre",15, 100, 90,30);
		lbl_nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		panelcliente.add(lbl_nombre); 												//añadimos al panel
		
		tfd_nombre = VentanaPrincipal.parametrosJTextField(120, 100, 250, 30);
		panelcliente.add(tfd_nombre);												//añadimos al panel

		lbl_telefono = VentanaPrincipal.parametrosJlabel("Telefono",15, 200, 90,30);
		lbl_telefono.setHorizontalAlignment(SwingConstants.RIGHT);
		panelcliente.add(lbl_telefono);
		
		tfd_telefono = VentanaPrincipal.parametrosJTextField(120,200,250,30);
		panelcliente.add(tfd_telefono);												//añadimos al panel
		
		btn_Aceptar = VentanaPrincipal.parametrosJButton("Aceptar",140,300,120, 40);
		panelcliente.add(btn_Aceptar);
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 310, 20, 70, 20);
		panelcliente.add(btn_volver);

		panelcliente.setVisible(false);

		

	}

	public void establecerManejador() {			
		ControladorCliente controlador = new ControladorCliente(this);
		
		btn_Aceptar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
	}

	public static JButton getBtn_Aceptar() {
		return btn_Aceptar;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static JTextField getTfd_nombre() {
		return tfd_nombre;
	}

	public static JTextField getTfd_telefono() {
		return tfd_telefono;
	}

	public static JPanel getPanelcliente() {
		return panelcliente;
	}
	
	
		
}

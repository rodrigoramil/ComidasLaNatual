package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorDetalleProducto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;


public class DetalleProducto extends JPanel {

	private static JPanel panelDetalleProducto;
	private static JTextField tfd_Nombre;
	private static JTextField tfd_Actual;
	private static JTextField tfd_Minimo;
	private static JTextField tfd_Maximo;
	private static JLabel lbl_Nombre;
	
	private static JLabel lbl_UnidadMedida;
	private static Choice tipo;	
	private static Choice unidadMedida;	
	
	private static JLabel lbl_tipo;
	private static JLabel lbl_Actual;
	private static JLabel lbl_Minimo;	
	private static JLabel lbl_Maximo;
	
	private static JButton btn_volver;
	private static JButton btn_Aceptar;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;


	public DetalleProducto() {


		panelDetalleProducto = new JPanel();
		lbl_Nombre = new JLabel("Nombre");		
		tfd_Nombre = new JTextField();
		btn_volver = new JButton("Volver");
		lbl_tipo = new JLabel("Tipo");
		tfd_Actual = new JTextField();
		lbl_Actual = new JLabel("Actual");		
		tfd_Minimo = new JTextField();
		lbl_Minimo = new JLabel("M\u00EDnimo");
		lbl_Maximo = new JLabel("M\u00E1ximo");
		tfd_Maximo = new JTextField();
		btn_Aceptar = new JButton("Aceptar");
		lbl_UnidadMedida = new JLabel("Unidad de medida");
		tipo = new Choice();
		unidadMedida = new Choice();
		
		
		establecerManejador();		
		panelDetalleProducto.setVisible(false);
	}



	public static JPanel inicializarComponentes() {
		
		panelDetalleProducto.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDetalleProducto.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelDetalleProducto.setLayout(null);


		lbl_Nombre.setBounds(10, 42, 51, 14);
		panelDetalleProducto.add(lbl_Nombre);
		
		tfd_Nombre.setBounds(71, 42, 284, 20);
		panelDetalleProducto.add(tfd_Nombre);
		tfd_Nombre.setColumns(10);
		
		btn_volver.setBounds(335, 11, 89, 23);
		panelDetalleProducto.add(btn_volver);
		
		lbl_tipo.setBounds(10, 81, 46, 14);
		panelDetalleProducto.add(lbl_tipo);
		
		tfd_Actual.setBounds(71, 127, 72, 20);
		panelDetalleProducto.add(tfd_Actual);
		tfd_Actual.setColumns(10);
		
		lbl_Actual.setBounds(10, 127, 35, 14);
		panelDetalleProducto.add(lbl_Actual);

		tfd_Minimo.setBounds(71, 167, 62, 20);
		panelDetalleProducto.add(tfd_Minimo);
		tfd_Minimo.setColumns(10);

		lbl_Minimo.setBounds(10, 165, 62, 22);
		panelDetalleProducto.add(lbl_Minimo);

		lbl_Maximo.setBounds(182, 167, 62, 22);
		panelDetalleProducto.add(lbl_Maximo);

		tfd_Maximo.setBounds(248, 167, 86, 20);
		panelDetalleProducto.add(tfd_Maximo);
		tfd_Maximo.setColumns(10);

		btn_Aceptar.setBounds(157, 212, 100, 22);
		panelDetalleProducto.add(btn_Aceptar);
		
		lbl_UnidadMedida.setBounds(200, 81, 120, 14);
		panelDetalleProducto.add(lbl_UnidadMedida);		

		unidadMedida.setBounds(330, 80, 72, 20);
		panelDetalleProducto.add(unidadMedida);		

		tipo.setBounds(71, 80, 72, 20);
		panelDetalleProducto.add(tipo);
		
		return panelDetalleProducto;
	}
	
	
	private void establecerManejador() {
		ControladorDetalleProducto controlador = new ControladorDetalleProducto(this);
		
		btn_volver.addActionListener(controlador);
		btn_Aceptar.addActionListener(controlador);	

	}
	
	
	
	
	
	
	
}

package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorGestionUsuarios;

import javax.swing.JButton;
import java.awt.Font;

public class GestionUsuarios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3656793065573268429L;
	
	private static JPanel panelGestionUsuarios;
	private static JTable table;
	private static JLabel lbl_lista_usuarios;
	private static JButton btn_nuevo;
	private static JButton btn_Modificar;
	private static JButton btn_eliminar;
	private static JButton btn_volver;

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	

	public GestionUsuarios() {
		
		panelGestionUsuarios = new JPanel();		
		lbl_lista_usuarios = new JLabel("Lista de Usuarios");		
		table = new JTable();		
		btn_nuevo = new JButton("Nuevo");		
		btn_Modificar = new JButton("Modificar");		
		btn_eliminar = new JButton("Eliminar");		
		btn_volver = new JButton("Volver");
		
		establecerManejador();		
		panelGestionUsuarios.setVisible(false);
	}


	public static JPanel inicializarComponentes() {
		
		panelGestionUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGestionUsuarios.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelGestionUsuarios.setLayout(null);

		lbl_lista_usuarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_lista_usuarios.setBounds(171, 51, 143, 14);
		panelGestionUsuarios.add(lbl_lista_usuarios);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(104, 79, 253, 128);
		panelGestionUsuarios.add(table);
		
		btn_nuevo.setBounds(33, 221, 89, 23);
		panelGestionUsuarios.add(btn_nuevo);
		
		btn_Modificar.setBounds(171, 221, 89, 23);
		panelGestionUsuarios.add(btn_Modificar);
		
		btn_eliminar.setBounds(299, 221, 89, 23);
		panelGestionUsuarios.add(btn_eliminar);
		
		btn_volver.setBounds(335, 11, 89, 23);
		panelGestionUsuarios.add(btn_volver);
		
		return panelGestionUsuarios;
	}
	
	private void establecerManejador() {
		
		ControladorGestionUsuarios controlador = new ControladorGestionUsuarios(this);
		
		table.addMouseListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_nuevo.addActionListener(controlador);
		btn_eliminar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);

		
	}


	public static JPanel getPanelGestionUsuarios() {
		return panelGestionUsuarios;
	}


	public static JTable getTable() {
		return table;
	}


	public static JButton getBtn_nuevo() {
		return btn_nuevo;
	}


	public static JButton getBtn_Modificar() {
		return btn_Modificar;
	}


	public static JButton getBtn_eliminar() {
		return btn_eliminar;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}
	
	
	
	
}

package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorRecetario;


public class Recetario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3846625552235103376L;
	
	private static JPanel panelRecetario;
	private static JTextField textField;
	private static JTable table;
	private static JButton btn_Cambiar_Estado;
	private static JButton btn_Modificar_Receta;
	private static JButton btnNewButton;
	private static JButton btn_ver_recetas;
	private static JButton btn_listadoRecetas;
	private static JButton btn_buscar;
	private static JButton btn_volver;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;


	public Recetario() {
		
		panelRecetario= new JPanel();
		textField = new JTextField();
		btn_listadoRecetas = new JButton("Lista de todas las recetas");
		btn_buscar = new JButton("Buscar");
		btn_volver = new JButton("Volver");
		table = new JTable();
		btn_ver_recetas = new JButton("Ver");
		btnNewButton = new JButton("Nuevo");
		btn_Modificar_Receta = new JButton("Modificar");
		btn_Cambiar_Estado = new JButton("Cambiar Estado");
				
		establecerManejador();
		panelRecetario.setVisible(false);
	}
	
	public static JPanel inicializarComponentes() {
		
		panelRecetario.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelRecetario.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelRecetario.setLayout(null);
		
		
		textField.setBounds(10, 45, 169, 20);
		panelRecetario.add(textField);
		textField.setColumns(10);
		
	
		btn_listadoRecetas.setBounds(10, 11, 156, 23);
		panelRecetario.add(btn_listadoRecetas);
		
	
		btn_buscar.setBounds(189, 44, 65, 23);
		panelRecetario.add(btn_buscar);
		

		btn_volver.setBounds(359, 11, 65, 23);
		panelRecetario.add(btn_volver);
		
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
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Recetas", "Estado"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 76, 384, 130);
		panelRecetario.add(table);
		
		btn_ver_recetas.setBounds(10, 227, 57, 23);
		panelRecetario.add(btn_ver_recetas);
		
		btnNewButton.setBounds(77, 227, 65, 23);
		panelRecetario.add(btnNewButton);
		
		btn_Modificar_Receta.setBounds(154, 227, 75, 23);
		panelRecetario.add(btn_Modificar_Receta);
		
		btn_Cambiar_Estado.setBounds(287, 227, 107, 23);
		panelRecetario.add(btn_Cambiar_Estado);
			
		
		return panelRecetario;	
	}
	
	public void establecerManejador() {		
		ControladorRecetario controlador = new ControladorRecetario(this);
		
		textField.addActionListener(controlador);
		btn_Cambiar_Estado.addActionListener(controlador);
		btn_Modificar_Receta.addActionListener(controlador);
		btnNewButton.addActionListener(controlador);
		btn_ver_recetas.addActionListener(controlador);
		btn_listadoRecetas.addActionListener(controlador);
		btn_buscar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		table.addMouseListener(controlador);
			
		
	}

	public static JTable getTable() {
		return table;
	}

	public static JButton getBtn_Cambiar_Estado() {
		return btn_Cambiar_Estado;
	}

	public static JButton getBtn_Modificar_Receta() {
		return btn_Modificar_Receta;
	}

	public static JButton getBtnNewButton() {
		return btnNewButton;
	}

	public static JButton getBtn_ver_recetas() {
		return btn_ver_recetas;
	}

	public static JButton getBtn_listadoRecetas() {
		return btn_listadoRecetas;
	}

	public static JButton getBtn_buscar() {
		return btn_buscar;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static JPanel getPanelRecetario() {
		return panelRecetario;
	}
	
	
	
	
	
}

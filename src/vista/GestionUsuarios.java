package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;

public class GestionUsuarios extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	

	public GestionUsuarios() {
		
		JLabel lbl_lista_usuarios = new JLabel("Lista de Usuarios");
		lbl_lista_usuarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_lista_usuarios.setBounds(171, 51, 143, 14);
		contentPane.add(lbl_lista_usuarios);
		
		table = new JTable();
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
		contentPane.add(table);
		
		JButton btn_nuevo = new JButton("Nuevo");
		btn_nuevo.setBounds(33, 221, 89, 23);
		contentPane.add(btn_nuevo);
		
		JButton btn_Modificar = new JButton("Modificar");
		btn_Modificar.setBounds(171, 221, 89, 23);
		contentPane.add(btn_Modificar);
		
		JButton btn_eliminar = new JButton("Eliminar");
		btn_eliminar.setBounds(299, 221, 89, 23);
		contentPane.add(btn_eliminar);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(335, 11, 89, 23);
		contentPane.add(btn_volver);
	}


	public static JPanel inicializarComponentes() {
		// TODO Auto-generated method stub
		return null;
	}
}

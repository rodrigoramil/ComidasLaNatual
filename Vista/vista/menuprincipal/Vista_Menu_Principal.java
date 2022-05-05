package vista.menuprincipal;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class Vista_Menu_Principal extends JFrame {


	private static final long serialVersionUID = 1L;


	public Vista_Menu_Principal() {
		setResizable(false);
		setTitle("Men\u00FA Principal");
		getContentPane().setLayout(null);
		
		JButton btn_Contabilidad = new JButton("Contabilidad");
		btn_Contabilidad.setEnabled(false);
		btn_Contabilidad.setBounds(337, 148, 91, 23);
		getContentPane().add(btn_Contabilidad);
		
		JButton btn_Ventas = new JButton("Ventas");
		btn_Ventas.setBounds(16, 148, 91, 23);
		btn_Ventas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btn_Ventas);
		
		JButton btn_Recetario = new JButton("Recetario");
		btn_Recetario.setEnabled(false);
		btn_Recetario.setBounds(123, 148, 91, 23);
		getContentPane().add(btn_Recetario);
		
		JButton btn_Almacen = new JButton("Almac\u00E9n");
		btn_Almacen.setEnabled(false);
		btn_Almacen.setBounds(230, 148, 91, 23);
		getContentPane().add(btn_Almacen);
		
		JButton btn_Gestion_Usuario = new JButton("Gesti\u00F3n de usuarios");
		btn_Gestion_Usuario.setEnabled(false);
		btn_Gestion_Usuario.setBounds(444, 148, 136, 23);
		getContentPane().add(btn_Gestion_Usuario);
		
		JButton btn_Cerrar_Sesion = new JButton("Cerrar Sesi\u00F3n");
		btn_Cerrar_Sesion.setBounds(230, 255, 97, 23);
		getContentPane().add(btn_Cerrar_Sesion);

	}

}

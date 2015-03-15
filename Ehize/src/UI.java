


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UI extends JFrame {
	private static Statement stmt;
	private JPanel contentPane;
	private static JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtMovil;
	private JTextField txtFijo;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private static JTextField txtDni;
	private static String letras;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
					
					
					GestorBD.conectar();
					stmt=GestorBD.conexion();
						//Se instancia la clase ControladorEntrada
						
						//CODIGO + BD
					
						

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		
		//PARTE VISUAL
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(60, 11, 175, 29);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(60, 51, 175, 29);
		contentPane.add(txtApellidos);
		
		txtMovil = new JTextField();
		txtMovil.setColumns(10);
		txtMovil.setBounds(60, 91, 175, 29);
		contentPane.add(txtMovil);
		
		txtFijo = new JTextField();
		txtFijo.setColumns(10);
		txtFijo.setBounds(60, 133, 175, 29);
		contentPane.add(txtFijo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(0, 11, 88, 29);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(0, 51, 88, 29);
		contentPane.add(lblApellidos);
		
		JLabel lblMovil = new JLabel("Movil");
		lblMovil.setBounds(0, 93, 88, 29);
		contentPane.add(lblMovil);
		
		JLabel lblFijo = new JLabel("Telf-Fijo");
		lblFijo.setBounds(0, 133, 88, 29);
		contentPane.add(lblFijo);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(60, 173, 175, 29);
		contentPane.add(txtDireccion);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(60, 213, 175, 29);
		contentPane.add(txtCorreo);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(0, 173, 88, 29);
		contentPane.add(lblDireccion);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(0, 213, 88, 29);
		contentPane.add(lblCorreo);
		
		
		String[] array_grupo = { "Targeta verde", "Normal", "Solo caza mayor" };
		JComboBox comboGrupo = new JComboBox(array_grupo);
		comboGrupo.setBounds(245, 11, 228, 50);
		comboGrupo.setSelectedIndex(1);
		contentPane.add(comboGrupo);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(245, 72, 228, 48);
		contentPane.add(comboBox_1);
		
		
		
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
		//	boolean bol=validarDni(txtDni.getText());
		//System.out.println(bol);
				
				
				
				
				
				
				
				txtNombre.getText();
				txtApellidos.getText();
				txtDireccion.getText();
				txtMovil.getText();
				txtFijo.getText();
				txtCorreo.getText();
				
				
				
				
				
				
				
				
				

				
				String cadena = "INSERT INTO Bazkideak VALUES ('"+txtNombre.getText()+"','"+txtApellidos.getText()+"','"+txtDireccion.getText()+"','"+	txtMovil.getText()+"','"+	txtFijo.getText()+"','"+	txtCorreo.getText()+"','"+	txtDni.getText()+"');"; //Sentencia de sql para insertar datos en la tabla 
			GestorBD.consultaActualiza(cadena); //Ejecuta la orden sql
			}
		});
		btnInsertar.setBounds(273, 357, 200, 37);
		contentPane.add(btnInsertar);
		
		JCheckBox chckbxCuotaSociedad = new JCheckBox("Cuota Sociedad");
		chckbxCuotaSociedad.setBounds(136, 301, 106, 29);
		contentPane.add(chckbxCuotaSociedad);
		
		JCheckBox checkBox = new JCheckBox("Cuota Sociedad");
		checkBox.setBounds(0, 301, 106, 29);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Cuota Sociedad");
		checkBox_1.setBounds(0, 333, 106, 29);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Cuota Sociedad");
		checkBox_2.setBounds(0, 365, 106, 29);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Cuota Sociedad");
		checkBox_3.setBounds(136, 333, 106, 29);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("Cuota Sociedad");
		checkBox_4.setBounds(136, 365, 106, 29);
		contentPane.add(checkBox_4);
		
		txtDni = new JTextField();
		txtDni.setText("Dni");
		txtDni.setBounds(245, 131, 228, 29);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		
		
		
		
		
		
		
	
	}
	
	
	


	
}

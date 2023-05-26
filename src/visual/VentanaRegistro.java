package visual;

import javax.swing.JFrame;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import swing.PanelBorder;
import swing.PanelGradiente;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class VentanaRegistro extends JFrame{
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRegistro;
	private JTextField usrLocalidad;
	private JTextField usrProvincia;
	private JTextField usrLatitud;
	private JTextField usrLongitud;

	public VentanaRegistro() {
		initialize();
	}

	public void initialize() {
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			imagen = new File("imagenes\\icono.png");
			icono = ImageIO.read(imagen);
			setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		setTitle("ConectAR");
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelGradiente1 = new swing.PanelGradiente();
		panelRegistro = new swing.PanelBorder();
	
		panelGradiente1.setColorPrimario(new Color(0, 230, 249));
        panelGradiente1.setColorSecundario(new Color(128, 0, 64));
        
        panelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        
        getContentPane().add(panelGradiente1, BorderLayout.CENTER);

        panelGradiente1.setLayer(panelRegistro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        JLabel lblRegistrar = new JLabel("Registrar");
        lblRegistrar.setBounds(0, 23, 230, 37);
        lblRegistrar.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblRegistro1 = new JLabel("Persona");
        lblRegistro1.setBounds(0, 66, 230, 24);
        lblRegistro1.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistro1.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelRegistro.setLayout(null);
        panelRegistro.add(lblRegistrar);
        panelRegistro.add(lblRegistro1);
        
        usrLocalidad = new JTextField();
        usrLocalidad.setBounds(24, 128, 181, 24);
        panelRegistro.add(usrLocalidad);
        usrLocalidad.setColumns(10);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblApellido.setBounds(25, 113, 67, 14);
        panelRegistro.add(lblApellido);
        
        usrProvincia = new JTextField();
        usrProvincia.setColumns(10);
        usrProvincia.setBounds(24, 178, 181, 24);
        panelRegistro.add(usrProvincia);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(25, 163, 67, 14);
        panelRegistro.add(lblNombre);
        
        usrLatitud = new JTextField();
        usrLatitud.setColumns(10);
        usrLatitud.setBounds(24, 228, 181, 24);
        panelRegistro.add(usrLatitud);
        
        JLabel lblRol = new JLabel("Rol");
        lblRol.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRol.setBounds(25, 213, 67, 14);
        panelRegistro.add(lblRol);
        
        usrLongitud = new JTextField();
        usrLongitud.setColumns(10);
        usrLongitud.setBounds(24, 280, 181, 24);
        panelRegistro.add(usrLongitud);

        JLabel lblCalificacion = new JLabel("Calificacion");
        lblCalificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCalificacion.setBounds(25, 257, 67, 27);
        panelRegistro.add(lblCalificacion);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setForeground(new Color(0, 0, 0));
        btnRegistrar.setBackground(Color.LIGHT_GRAY);
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnRegistrar.setBounds(115, 337, 90, 24);
        panelRegistro.add(btnRegistrar);
        
        GroupLayout gl_panelGradiente1 = new GroupLayout(panelGradiente1);
        gl_panelGradiente1.setHorizontalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(330)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelGradiente1.setVerticalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(100)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
        );
        
        panelGradiente1.setLayout(gl_panelGradiente1);

        btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnRegistrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		});
	}
}

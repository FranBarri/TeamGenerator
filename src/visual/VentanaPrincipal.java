package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import controladores.VentanaPrincipalControlador;
import controladores.VentanaRegistroControlador;
import sistema.Persona;
import swing.PanelBorder;
import swing.PanelGradiente;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRedondo;
    private static JTable tabla;
    private static DefaultTableModel modelo;
    private static int filasPorPagina = 100;
    private List<Persona> personas;

	public VentanaPrincipal() {
		initialize();
	}
	private void initialize() {
		personas = VentanaRegistroControlador.getLista();
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			imagen = new File("imagenes\\icono.png");
			icono = ImageIO.read(imagen);
			setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		setTitle("");
		setLocationRelativeTo(null);
		setResizable(false);

		panelGradiente1 = new swing.PanelGradiente();
		panelRedondo = new swing.PanelBorder();
		panelRedondo.setBounds(15, 11, 850, 430);

		panelGradiente1.setColorPrimario(new Color(0, 230, 249));
		panelGradiente1.setColorSecundario(new Color(128, 0, 64));

		panelRedondo.setBackground(new java.awt.Color(255, 255, 255));

		getContentPane().add(panelGradiente1, BorderLayout.CENTER);
		panelGradiente1.setLayout(null);

		panelGradiente1.setLayer(panelRedondo, javax.swing.JLayeredPane.DEFAULT_LAYER);
		panelGradiente1.add(panelRedondo);

		String[] columnas = {"Numero", "Apellido", "Nombre", "Rol", "Calificacion"};

		modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Aca se define si la celda es editable o no
				return false;
			}
		};
		tabla = new JTable(modelo);
		tabla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Font font = new Font("Tahoma", Font.BOLD, 12);
		tabla.getTableHeader().setFont(font);
		tabla.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 11, 830, 328);
		panelRedondo.add(scrollPane);
		
		JButton btnRegistrar = new JButton("Nueva Persona");
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.setBounds(15, 526, 150, 24);
		panelGradiente1.add(btnRegistrar);

		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipalControlador.cerrar();
				VentanaRegistroControlador.mostrar();
			}
		});
		
		actualizarTabla(personas);

	}

	public static void actualizarTabla(List<Persona> personas) {
		int fin = Math.min(filasPorPagina, personas.size());
		for (int i = 0; i < fin; i++) {
			Persona persona = personas.get(i);
			modelo.addRow(new Object[]{i, persona.getApellido(), persona.getNombre(), 
					persona.getRol(), persona.getCalificacion()});
		}
		modelo.fireTableDataChanged();
		tabla.revalidate();
		tabla.repaint();
	}
}

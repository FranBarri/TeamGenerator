package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import sistema.Persona;

import javax.swing.GroupLayout.Alignment;

import swing.PanelBorder;
import swing.PanelGradiente;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class VentanaEstadisticas extends JFrame{
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRedondo2;
	private static DefaultTableModel modelo;
	private static int filasPorPagina = 100;
	private List<Persona> personas;
	
	public VentanaEstadisticas() {
		initialize();
	}
	
	private void initialize() {
		personas = VentanaProyecto.getMejorSolucion();
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
		panelRedondo2 = new swing.PanelBorder();
	
		panelGradiente1.setColorPrimario(new Color(0, 230, 249));
        panelGradiente1.setColorSecundario(new Color(128, 0, 64));
        
        panelRedondo2.setBackground(new java.awt.Color(255, 255, 255));
        
        getContentPane().add(panelGradiente1, BorderLayout.CENTER);

        panelGradiente1.setLayer(panelRedondo2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        PanelBorder panelRedondo1 = new PanelBorder();
        panelRedondo1.setBackground(Color.WHITE);
        
		String[] columnas = {"Apellido", "Nombre", "Rol", "Incompatibilidad", "Calificacion"};

		modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Aca se define si la celda es editable o no
				return false;
			}
		};
		JTable tabla = new JTable(modelo);
		tabla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Font font = new Font("Tahoma", Font.BOLD, 12);
		tabla.getTableHeader().setFont(font);
		tabla.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 11, 368, 247);
		panelRedondo1.add(scrollPane);
        
        GroupLayout gl_panelGradiente1 = new GroupLayout(panelGradiente1);
        gl_panelGradiente1.setHorizontalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        				.addComponent(panelRedondo2, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panelRedondo1, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(486, Short.MAX_VALUE))
        );
        gl_panelGradiente1.setVerticalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panelRedondo1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(panelRedondo2, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        
        panelGradiente1.setLayout(gl_panelGradiente1);
	
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series 1", "Category 1");
        dataset.addValue(15, "Series 1", "Category 2");
        dataset.addValue(8, "Series 1", "Category 3");
        // Agregar más valores al conjunto de datos según sea necesario

        
        JFreeChart chart = ChartFactory.createBarChart(
        	    "Titulo",         // Título del gráfico
        	    "Grupos",      // Etiqueta del eje X
        	    "Mas Beneficio",         // Etiqueta del eje Y
        	    dataset,         // Conjunto de datos
        	    PlotOrientation.VERTICAL, // Orientación del gráfico
        	    true,            // Mostrar leyenda
        	    true,            // Mostrar tooltips
        	    false            // Mostrar URLs
        	);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(10, 11, 368, 247);
        // Agregar el panel de gráfico a tu interfaz de usuario
        // Por ejemplo, si estás utilizando un JFrame:
        panelRedondo2.add(chartPanel);
        
        actualizarTabla(personas);
	}
	
	public static void actualizarTabla(List<Persona> personas) {
		modelo.setRowCount(0);
		int fin = Math.min(filasPorPagina, personas.size());
		for (int i = 0; i < fin; i++) {
			Persona persona = personas.get(i);
			modelo.addRow(new Object[]{persona.getApellido(), persona.getNombre(), 
					persona.getRol(), persona.getIncompatibilidad(), persona.getCalificacion()});
		}
		modelo.fireTableDataChanged();
	}
}

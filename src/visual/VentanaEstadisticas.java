package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.GroupLayout.Alignment;

import swing.PanelBorder;
import swing.PanelGradiente;

@SuppressWarnings("serial")
public class VentanaEstadisticas extends JFrame{
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRedondo;
	
	public VentanaEstadisticas() {
		initialize();
	}
	
	private void initialize() {
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
	
		panelGradiente1.setColorPrimario(new Color(0, 230, 249));
        panelGradiente1.setColorSecundario(new Color(128, 0, 64));
        
        panelRedondo.setBackground(new java.awt.Color(255, 255, 255));
        
        getContentPane().add(panelGradiente1, BorderLayout.CENTER);

        panelGradiente1.setLayer(panelRedondo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        GroupLayout gl_panelGradiente1 = new GroupLayout(panelGradiente1);
        gl_panelGradiente1.setHorizontalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(59)
        			.addComponent(panelRedondo, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(340, Short.MAX_VALUE))
        );
        gl_panelGradiente1.setVerticalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(38)
        			.addComponent(panelRedondo, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(199, Short.MAX_VALUE))
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
        // Agregar el panel de gráfico a tu interfaz de usuario
        // Por ejemplo, si estás utilizando un JFrame:
        panelRedondo.add(chartPanel);
	}
	

}

package controladores;

import java.awt.EventQueue;

import visual.VentanaEstadisticas;

public class VentanaEstadisticasControlador {
	static VentanaEstadisticas ventanaEstadisticas;
	
	public VentanaEstadisticasControlador() {
		inicializarVentanaMapa();
	}
	
	public static void inicializarVentanaMapa() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaEstadisticas = new VentanaEstadisticas();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void cerrar() {
		ventanaEstadisticas.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaEstadisticas.setVisible(true);
	}
}

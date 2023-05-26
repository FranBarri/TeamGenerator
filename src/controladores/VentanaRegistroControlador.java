package controladores;

import java.awt.EventQueue;
import visual.VentanaRegistro;

public class VentanaRegistroControlador {
	
	public static VentanaRegistro ventanaRegistro;
	
	public VentanaRegistroControlador() {
		inicializarVentanaRegistro();
	}
	
	private static void inicializarVentanaRegistro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaRegistro = new VentanaRegistro();
					mostrar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void cerrar() {
		ventanaRegistro.setVisible(false);
	}
	public static void mostrar() {
		ventanaRegistro.setVisible(true);
	}
}

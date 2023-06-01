package controladores;

import visual.VentanaProyecto;

public class VentanaProyectoControlador {
	
	static VentanaProyecto ventanaProyecto = new VentanaProyecto();
	
	public static void cerrar() {
		ventanaProyecto.setVisible(false);
	}
	public static void mostrar() {
		ventanaProyecto.setVisible(true);
	}
}

package controladores;

import java.util.List;

import sistema.Equipo;
import sistema.Persona;
import sistema.Proceso;
import visual.VentanaEstadisticas;

public class VentanaEstadisticasControlador {
	
	static VentanaEstadisticas ventanaEstadisticas = new VentanaEstadisticas();
	
	public static void cerrar() {
		ventanaEstadisticas.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaEstadisticas.setVisible(true);
	}
	
	public static List<Persona> getMejorEquipo(Equipo equipo){
		return Proceso.generarSolucion(equipo);
	}
}

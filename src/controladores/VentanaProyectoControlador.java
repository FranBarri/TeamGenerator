package controladores;

import java.util.List;

import sistema.Equipo;
import sistema.Incompatibilidad;
import sistema.Persona;
import sistema.Proceso;
import sistema.Registrar;
import visual.VentanaProyecto;

public class VentanaProyectoControlador {
	
	static VentanaProyecto ventanaProyecto = new VentanaProyecto();
	
	public static void cerrar() {
		ventanaProyecto.setVisible(false);
	}
	public static void mostrar() {
		ventanaProyecto.setVisible(true);
	}
	
	public static Equipo generarEquipo(List<Persona> personas, List<Incompatibilidad> incompatibilidades) {
		return Proceso.generarEquipo(personas, incompatibilidades);
	}
	public static void cargarRequerimientos(Equipo equipoBase, int lideres, int arquitectos, int testers, int programadores) {
		Proceso.cargarRequerimientos(equipoBase, lideres, arquitectos, testers, programadores);
	}
	public static List<Persona> getMejorSolucion(Equipo equipoBase) {
		return Proceso.generarSolucion(equipoBase);
	}
	public static int getCantLideres() {
		return Registrar.getCantLideres();
	}
	public static int getCantArquitectos() {
		return Registrar.getCantArquitectos();
	}
	public static int getCantTesters() {
		return Registrar.getCantTesters();
	}
	public static int getCantProgramadores() {
		return Registrar.getCantProgramadores();
	}
}

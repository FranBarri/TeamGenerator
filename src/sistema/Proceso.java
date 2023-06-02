package sistema;

import java.util.List;

public class Proceso {
	
	public static Equipo generarEquipo(List<Persona> personas, List<Incompatibilidad> incompatibilidades) {
		Equipo equipoBase = new Equipo(personas, incompatibilidades);
		return equipoBase;
	}
	public static void cargarRequerimientos(Equipo equipoBase, int cantLideres, int cantArquitectos, int cantTesters, int cantProgramadores) {
		equipoBase.cargarRequerimientos(cantLideres, cantArquitectos, cantProgramadores, cantTesters);
	}
	
	//	  Equipo equipo = new Equipo();
	//    // ... (agregar personas e incompatibilidades al equipo)
	//
	public static List<Persona> generarSolucion(Equipo equipoBase){		
		BacktrackingSolver solver = new BacktrackingSolver(equipoBase);
		//
		//    // Ejecutar el algoritmo de backtracking en un hilo separado
		Thread solverThread = new Thread(solver);
		solverThread.start();
		//
		//    // ... (realizar otras tareas en la aplicación principal)
		//
		//    // Esperar a que el algoritmo de backtracking termine
		try {
			solverThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//
		//    // Obtener y mostrar la solución
		List<Persona> solucion = solver.getMejorSolucion();
		//    // ... (mostrar la solución)
		return solucion;
	}
	//
}

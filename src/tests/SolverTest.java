package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sistema.BacktrackingSolver;
import sistema.Equipo;
import sistema.Incompatibilidad;
import sistema.Persona;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class SolverTest
{
	private Persona p1,p2,p3,p4,p5,p6,p7,p8;
	private Equipo equipo;
	private BacktrackingSolver solver;

	@Before
	public void inicializar()
	{
		List<Persona> personas = new ArrayList<>();
		List<Incompatibilidad> incompatibilidades = new ArrayList<>();
		
		equipo = new Equipo(personas, incompatibilidades);
		solver = new BacktrackingSolver(equipo);
		solver.run();
	}

	@Test
	public void existeMejorSolucion()
	{
		List<Persona> mejorSolucion = solver.getMejorSolucion();
		assertNotNull(mejorSolucion);
	}

	@Test
	public void existenCalificacionesAlmacenadasTest()
	{
		List<Integer> calificaciones = BacktrackingSolver.getCalificaciones();
		assertNotEquals(calificaciones, null);
	}
}
package sistema;

import java.util.List;

public class Equipo {
	 	private int lideresProyecto;
	    private int arquitectos;
	    private int programadores;
	    private int testers;
	    private List<Persona> personas;
	    private List<Incompatibilidad> incompatibilidades;

	    
	    public Equipo() {
	    	this.lideresProyecto=1;
	    	this.arquitectos=2;
	    	this.programadores=4;
	    	this.testers=5;
	    	
	    }
	    public void cargarPersonas(List<Persona> personas) {
	        this.personas = personas;
	    }

	    public void visualizarPersonas() {
	        System.out.println("Personas disponibles:");
	        for (Persona persona : personas) {
	            System.out.println("Nombre: " + persona.getNombre() + ", Rol: " + persona.getRol() + ", Calificación: " + persona.getCalificacion());
	        }
	    }

	    public void cargarIncompatibilidades(List<Incompatibilidad> incompatibilidades) {
	        this.incompatibilidades = incompatibilidades;
	    }

	    public void visualizarIncompatibilidades() {
	        System.out.println("Incompatibilidades:");
	        for (Incompatibilidad incompatibilidad : incompatibilidades) {
	            System.out.println("Persona 1: " + incompatibilidad.getPersona1().getNombre() + ", Persona 2: " + incompatibilidad.getPersona2().getNombre());
	        }
	    }

	    public void cargarRequerimientos(int lideresProyecto, int arquitectos, int programadores, int testers) {
	        this.lideresProyecto = lideresProyecto;
	        this.arquitectos = arquitectos;
	        this.programadores = programadores;
	        this.testers = testers;
	    }

	    public void visualizarRequerimientos() {
	        System.out.println("Requerimientos del equipo:");
	        System.out.println("Líderes de proyecto: " + lideresProyecto);
	        System.out.println("Arquitectos: " + arquitectos);
	        System.out.println("Programadores: " + programadores);
	        System.out.println("Testers: " + testers);
	    }
		public int getLideresProyecto() {
			return lideresProyecto;
		}
		public void setLideresProyecto(int lideresProyecto) {
			this.lideresProyecto = lideresProyecto;
		}
		public int getArquitectos() {
			return arquitectos;
		}
		public void setArquitectos(int arquitectos) {
			this.arquitectos = arquitectos;
		}
		public int getProgramadores() {
			return programadores;
		}
		public void setProgramadores(int programadores) {
			this.programadores = programadores;
		}
		public int getTesters() {
			return testers;
		}
		public void setTesters(int testers) {
			this.testers = testers;
		}
		public List<Persona> getPersonas() {
			return personas;
		}
		public void setPersonas(List<Persona> personas) {
			this.personas = personas;
		}
		public List<Incompatibilidad> getIncompatibilidades() {
			return incompatibilidades;
		}
		public void setIncompatibilidades(List<Incompatibilidad> incompatibilidades) {
			this.incompatibilidades = incompatibilidades;
		}
}

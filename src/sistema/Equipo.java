package sistema;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	 	private int lideresProyecto;
	    private int arquitectos;
	    private int programadores;
	    private int testers;
	    private ArrayList<Persona> personas;
	    private ArrayList<Incompatibilidad> incompatibilidades;

	    
	    public Equipo() {
	    	 this.personas = new ArrayList<Persona>();
	         this.incompatibilidades = new ArrayList<Incompatibilidad>();
	    }
	    
	    public void agregarPersona(Persona persona, String apellidoIncompatible) {
	        // Verificar si la persona es incompatible con alguien que ya fue ingresado
	        for (Persona p : personas) {
	            if (p.getApellido().equals(apellidoIncompatible)) {
	                incompatibilidades.add(new Incompatibilidad(persona, p));
	            }
	        }

	        // Agregar la persona a la lista de personas
	        personas.add(persona);
	    }



	    public void cargarRequerimientos(int lideresProyecto, int arquitectos, int programadores, int testers) {
	        this.lideresProyecto = lideresProyecto;
	        this.arquitectos = arquitectos;
	        this.programadores = programadores;
	        this.testers = testers;
	    }

	    public int getRolMax(String rol) {
			//Devuelve el número máximo de personas permitidas para un rol específico.
	        switch (rol) {
	            case "líder de proyecto":
	                return getLideresProyecto();
	            case "arquitecto":
	                return getArquitectos();
	            case "programador":
	                return getProgramadores();
	            case "tester":
	                return getTesters();
	            default:
	                throw new IllegalArgumentException("Rol desconocido: " + rol);
	        }
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
		public void setPersonas(ArrayList<Persona> personas) {
			this.personas = personas;
		}
		public List<Incompatibilidad> getIncompatibilidades() {
			return incompatibilidades;
		}
		public void setIncompatibilidades(ArrayList<Incompatibilidad> incompatibilidades) {
			this.incompatibilidades = incompatibilidades;
		}
		
		
}

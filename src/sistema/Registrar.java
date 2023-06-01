package sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import gSon.GenerarGson;
import gSon.ListaPersonas;

public class Registrar {
    private static GenerarGson gsonGenerator = new GenerarGson();
    private static ListaPersonas listaPersonas = gsonGenerator.getListaDesdeJson();
    private static List<Persona> listaPers = listaPersonas.getLista();
    
	public static Persona generarPersona(String apellido, String nombre, String rol, String incompatibilidad, int calificacion) {
		Persona persona = new Persona(apellido, nombre, rol, incompatibilidad, calificacion);
		return persona;
	}
	
	public static List<Persona> registrarPersona(Persona persona) {
		listaPers.add(persona);
		return listaPers;
	}
	
	public static List<Persona> eliminarPersona(String apellido) {
	    boolean encontrada = false;
	    List<Persona> ret = new ArrayList<>();
	    for (Persona person : listaPers) {
	        if (person.getApellido().equalsIgnoreCase(apellido.trim())) {
	            encontrada = true;
	        } else {
	            ret.add(person);
	        }
	    }
	    listaPers = ret;
	    if (!encontrada && !listaPers.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "La persona no se encontró en la lista");
	        return listaPers;
	    }
	    return ret;
	}
	
//	private static boolean yaIngresada(Persona persona, List<Persona> Personas) {
//	    for (Persona person : Personas) {
//	    	if (person.getLatitud() == (local.getLatitud()) && localidad.getLongitud() == (local.getLongitud())) {
//	    		return true;
//	    	}
//	    }
//	    return false;
//	}
	
	public static void guardarJson(List<Persona> personas) {
	    ListaPersonas listaPersonas = new ListaPersonas();
	    for (Persona person : personas) {
//	        if (!yaIngresada(person, listaPersonas.getLista())) {
	            listaPersonas.agregarPersona(person.getApellido(), person.getNombre(), person.getRol(),
	            		person.getIncompatibilidad(), person.getCalificacion());                
//	        }
	    }
	    Gson gson = new Gson();
	    String json = gson.toJson(listaPersonas);
	    try (Writer writer = new FileWriter("listaPersonas.json")) {
	        writer.write(json);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println(json);
	}
	
	public static ListaPersonas getListaPersonas() {
		return listaPersonas;
	}
	public static List<Persona> getLista() {
		return listaPers;
	}
}

package sistema;

public class Persona {
	private String apellido;
	private String nombre;
	private String rol;
	private int calificacion;
	
	public Persona(String apellido, String nombre, String rol, int calificacion){
		this.apellido = apellido;
		this.nombre = nombre;
		this.rol = rol;
		this.calificacion = calificacion;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
}

package sistema;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingSolver extends Thread {
    private Equipo equipo;
    private List<Persona> solucionActual;
    private List<Persona> mejorSolucion;
    private int mejorCalificacion;

    public BacktrackingSolver(Equipo equipo) {
        this.equipo = equipo;
        this.solucionActual = new ArrayList<>();
        this.mejorSolucion = new ArrayList<>();
        this.mejorCalificacion = 0;
    }

    @Override
    public void run() {
        backtracking(0);
    }

    private void backtracking(int posicion) {
        if (posicion == equipo.getPersonas().size()) {
            if (esSolucionValida(solucionActual)) {
                int calificacionActual = calcularCalificacion(solucionActual);
                if (calificacionActual > mejorCalificacion) {
                    mejorCalificacion = calificacionActual;
                    mejorSolucion = new ArrayList<>(solucionActual);
                }
            }
        } else {
            Persona persona = equipo.getPersonas().get(posicion);
            solucionActual.add(persona);
            backtracking(posicion + 1);
            solucionActual.remove(solucionActual.size() - 1);
            backtracking(posicion + 1);
        }
    }

    private boolean esSolucionValida(List<Persona> solucion) {
        // Verificar si la solución cumple con los requerimientos de cantidad de roles
        // y si no hay incompatibilidades entre las personas seleccionadas
    	return false;
    }

    private int calcularCalificacion(List<Persona> solucion) {
        int calificacion = 0;
        for (Persona persona : solucion) {
            calificacion += persona.getCalificacion();
        }
        return calificacion;
    }

    public List<Persona> getMejorSolucion() {
        return mejorSolucion;
    }
}
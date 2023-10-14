package dgtic.core.modelo;

import java.util.Collection;
import java.util.Map;

public class EmpleadoM {
    private String nombre;
    private Integer edad;
    private Map<String, Actividades> actividad;

    public EmpleadoM() {
    }

    public EmpleadoM(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, Actividades> getActividad() {
        return actividad;
    }

    public void setActividad(Map<String, Actividades> actividad) {
        this.actividad = actividad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad + '}';
    }
}

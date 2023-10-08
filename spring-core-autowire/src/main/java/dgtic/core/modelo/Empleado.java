package dgtic.core.modelo;

import java.util.Collection;

public class Empleado {
    private String nombre;
    private Integer edad;
    private Actividades actividad;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(Actividades actividad) {
        this.actividad = actividad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Actividades getActividad() {
        return actividad;
    }

    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
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

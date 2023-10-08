package dgtic.core.modelo;

import java.util.Collection;
import java.util.Properties;

public class EmpleadoP {
    private String nombre;
    private Integer edad;
    private Properties actividad;

    public EmpleadoP() {
    }

    public EmpleadoP(String nombre) {
        this.nombre = nombre;
    }

    public Properties getActividad() {
        return actividad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setActividad(Properties actividad) {
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

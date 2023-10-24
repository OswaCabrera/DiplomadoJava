package dgtic.core.modelo;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nombre;
    private String correo;

    private List<Libro> libros = new ArrayList<>();

    public Autor() {
    }

    public Autor(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", libros=" + libros +
                '}';
    }
}

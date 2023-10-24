package dgtic.core.servicio;

import dgtic.core.modelo.Libro;

import java.util.List;

public interface LibroServicio {
    public List<Libro> findAll();
    public Libro findById(String isbn);

}

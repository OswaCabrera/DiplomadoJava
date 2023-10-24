package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Libro;

import java.util.List;

public interface LibroRepositorio {
    public List<Libro> findAll();
    public Libro findById(String isbn);
}

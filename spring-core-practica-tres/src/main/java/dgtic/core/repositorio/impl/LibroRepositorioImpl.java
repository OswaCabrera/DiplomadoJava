package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.LibroRepositorio;

import java.util.List;
import java.util.Optional;

public class LibroRepositorioImpl implements LibroRepositorio {
    @Override
    public List<Libro> findAll() {
        return BaseDeDatos.libros;
    }

    @Override
    public Libro findById(String isbn) {
        Optional<Libro> libroOptional = BaseDeDatos.libros.stream()
                .filter(l -> l.getIsbn().contains(isbn))
                .findFirst();
        Libro libro = null;
        if (libroOptional.isPresent()) {
            libro = libroOptional.orElseThrow();
        }
        return libro;
    }
}

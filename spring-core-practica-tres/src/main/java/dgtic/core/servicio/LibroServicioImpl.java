package dgtic.core.servicio;

import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.intf.AutorRepositorio;
import dgtic.core.repositorio.intf.LibroRepositorio;

import java.util.List;
import java.util.Optional;

public class LibroServicioImpl implements LibroServicio{

    private AutorRepositorio autorRepositorio;
    private LibroRepositorio libroRepositorio;

    public LibroServicioImpl( LibroRepositorio libroRepositorio) {
        super();
        //this.autorRepositorio = autorRepositorio;
        this.libroRepositorio = libroRepositorio;
    }

    @Override
    public List<Libro> findAll() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro findById(String isbn) {
        Optional<Libro> libroOptional = libroRepositorio.findAll().stream()
                .filter(l -> l.getIsbn().contains(isbn))
                .findFirst();
        Libro libro = null;
        if (libroOptional.isPresent()) {
            libro = libroOptional.orElseThrow();
        }
        return libro;
    }
}

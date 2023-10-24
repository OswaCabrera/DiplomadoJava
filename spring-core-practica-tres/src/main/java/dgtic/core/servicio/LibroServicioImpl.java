package dgtic.core.servicio;

import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.intf.AutorRepositorio;
import dgtic.core.repositorio.intf.LibroRepositorio;

import java.util.List;

public class LibroServicioImpl implements LibroServicio{

    private AutorRepositorio autorRepositorio;
    private LibroRepositorio libroRepositorio;

    public LibroServicioImpl(AutorRepositorio autorRepositorio, LibroRepositorio libroRepositorio) {
        super();
        this.autorRepositorio = autorRepositorio;
        this.libroRepositorio = libroRepositorio;
    }

    @Override
    public List<Libro> findAll() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro findById(String isbn) {
        return libroRepositorio.findById(isbn);
    }
}

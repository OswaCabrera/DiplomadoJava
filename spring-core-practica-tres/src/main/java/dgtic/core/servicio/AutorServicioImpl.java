package dgtic.core.servicio;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.intf.AutorRepositorio;
import dgtic.core.repositorio.intf.LibroRepositorio;

import java.util.List;

public class AutorServicioImpl implements AutorServicio {

    private AutorRepositorio autorRepositorio;
    private LibroRepositorio libroRepositorio;

    public AutorServicioImpl(AutorRepositorio autorRepositorio, LibroRepositorio libroRepositorio) {
        super();
        this.autorRepositorio = autorRepositorio;
        this.libroRepositorio = libroRepositorio;
    }

    @Override
    public List<Autor> findAll() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor findById(String id) {
        return autorRepositorio.findById(id);
    }
}

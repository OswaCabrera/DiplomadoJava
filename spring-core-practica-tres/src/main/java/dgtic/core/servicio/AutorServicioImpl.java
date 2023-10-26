package dgtic.core.servicio;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.intf.AutorRepositorio;
import dgtic.core.repositorio.intf.LibroRepositorio;

import java.util.List;
import java.util.Optional;

public class AutorServicioImpl implements AutorServicio {

    private AutorRepositorio autorRepositorio;
    private LibroRepositorio libroRepositorio;

    public AutorServicioImpl(AutorRepositorio autorRepositorio) {
        super();
        this.autorRepositorio = autorRepositorio;
    }

    @Override
    public List<Autor> findAll() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor findById(String id) {
        Optional<Autor> autorOptional = autorRepositorio.findAll().stream()
                .filter(a -> a.getCorreo().contains(id))
                .findFirst();
        Autor autor = null;
        if (autorOptional.isPresent()) {
            autor = autorOptional.orElseThrow();
        }
        return autor;
    }
}

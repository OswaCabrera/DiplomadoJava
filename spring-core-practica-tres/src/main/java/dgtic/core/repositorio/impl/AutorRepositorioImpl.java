package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Autor;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.AutorRepositorio;

import java.util.List;
import java.util.Optional;

public class AutorRepositorioImpl implements AutorRepositorio {
    @Override
    public List<Autor> findAll() {
        return BaseDeDatos.autores;
    }

    @Override
    public Autor findById(String correo) {
        Optional<Autor> autorOptional=BaseDeDatos.autores.stream()
                .filter(a->a.getCorreo().contains(correo))
                .findFirst();
        Autor autor=null;
        if(autorOptional.isPresent()){
            autor=autorOptional.orElseThrow();
        }
        return autor;
    }
}
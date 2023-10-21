package dgtic.core.repositorio.intf;

import dgtic.core.modelo.Autor;

import java.util.List;

public interface AutorRepositorio {
    public List<Autor> findAll();
    public void findById(String correo);
}

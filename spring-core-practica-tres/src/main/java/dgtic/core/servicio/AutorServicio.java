package dgtic.core.servicio;

import dgtic.core.modelo.Autor;

import java.util.List;

public interface AutorServicio {
    public List<Autor> findAll();
    public Autor findById(String id);
}

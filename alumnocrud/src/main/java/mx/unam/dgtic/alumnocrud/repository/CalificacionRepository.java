package mx.unam.dgtic.alumnocrud.repository;

import mx.unam.dgtic.alumnocrud.model.Calificacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalificacionRepository extends CrudRepository<Calificacion, Integer>{
    List<Calificacion> findByMateria(String materia);
}

package mx.unam.dgtic.alumnocrud.repository;

import mx.unam.dgtic.alumnocrud.model.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface ALumnoRepository extends CrudRepository<Alumno, String> {

}
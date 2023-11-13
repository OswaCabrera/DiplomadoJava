package mx.unam.dgtic.alumnocrud.repository;

import mx.unam.dgtic.alumnocrud.model.Alumno;
import mx.unam.dgtic.alumnocrud.model.Calificacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalificacionRepository extends CrudRepository<Calificacion, Integer>{
    List<Calificacion> findByMateria(String materia);
    List<Calificacion> findCalificacionByCalificacionEquals(Integer calif);
    List <Calificacion> findCalificacionByAlumnoMatricula(String matricula);
    List<Calificacion> findCalificacionByAlumnoPaterno(String paterno);
    List<Calificacion> findCalificacionByAlumnoNombreAlumno(String nombre);
    List<Calificacion> findCalificacionByAlumnoNombreAlumnoAndAlumnoPaterno(String n, String p);
}

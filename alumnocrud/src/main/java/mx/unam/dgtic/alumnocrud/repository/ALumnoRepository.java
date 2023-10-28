package mx.unam.dgtic.alumnocrud.repository;

import mx.unam.dgtic.alumnocrud.model.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public interface ALumnoRepository extends CrudRepository<Alumno, String> {
    List<Alumno> findByNombreAlumno(String nom);
    List<Alumno> findByPaterno(String pat);
    List<Alumno> findByEstatura(double estatura);
    List<Alumno> findByFnac(Date fnac);
    List<Alumno> findByNombreAlumnoEquals(String nom);
    List<Alumno> findAlumnoByNombreAlumnoNot(String nom);
    List<Alumno> findByPaternoIsNull();
    List<Alumno> findByPaternoIsNotNull();
    List<Alumno> findAlumnoByNombreAlumnoStartingWith(String prefijo);
    List<Alumno> findAlumnoByNombreAlumnoEndingWith(String posfijo);
    List<Alumno> findAlumnoByNombreAlumnoContaining(String infijo);
    List<Alumno> findAlumnoByNombreAlumnoLike(String like);
    List<Alumno> findAlumnoByEstaturaLessThan(double estatura);
    List<Alumno> findAlumnoByEstaturaLessThanEqual(double estatura);
    List<Alumno> findAlumnoByEstaturaBetween(Double init, Double stop);
    List<Alumno> findAlumnoByEstaturaIn(Collection<Double> alumnos);

    List<Alumno> findAlumnoByFnacAfter(Date fnac);
    List<Alumno> findAlumnoByFnacBefore(Date fnac);
    List<Alumno> findAlumnoByNombreAlumnoOrPaterno(String nombre, String paterno);
    List<Alumno> findAlumnoByNombreAlumnoAndPaterno(String nombre, String paterno);
    List<Alumno> findAlumnoByEstaturaOrderByEstatura(Double estatura);
    List<Alumno> findAlumnoByEstaturaOrderByFnac(Double estatura);
}
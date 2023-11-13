package mx.unam.dgtic.alumnocrud.repository;

import mx.unam.dgtic.alumnocrud.model.Alumno;
import mx.unam.dgtic.alumnocrud.model.AlumnoCalificacionDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public interface AlumnoRepository extends CrudRepository<Alumno, String> {
    List<Alumno> findAlumnoByNombreAlumno(String nom);
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
    //Named Queries
    List<Alumno> buscarAltos();

    Alumno buscarElGarrocha();
    double buscarEstaturaMaxima();
    // ligar explicitamente
    @Query(name="Alumno.buscarAltosConFecha")
    List<Alumno> buscarAltosConFecha(@Param("fecha") Date fecha);
    List<Alumno> buscarAltosConFechaDos(Double a, Date b);
    List<Alumno> buscarAltosConFechaTres(@Param("fecha") Date fecha, @Param("estatura") Double estatura);
    List<Alumno> buscarAltosMayorPromedio();

    @Query("SELECT AVG (a.estatura) FROM Alumno a")
    public double buscarEstaturaPromedio();

    @Query("select a from Alumno a where a.paterno = :paterno")
    List<Alumno> buscarTodosConApellido(String paterno);

    //
    @Query("select a, c from Alumno a join Calificacion c " +
     " on a.matricula = c.alumno.matricula  where a.nombreAlumno = :nombre and c.calificacion >= 6")
    List<Object []> buscarAlumnosConCalificacionesAprobatoria(String nombre);

    @Query(
            value = "select * from alumnos order by estatura asc",
        nativeQuery = true
    )
    List<Alumno> nativosBuscarTodos();

    @Query(
            value = "SELECT a.* FROM alumnos as a WHERE a.nombre_alumno = ? " +
                    " AND a.paterno = ?",
            nativeQuery = true
    )
    List<Alumno> nativaBuscarPorNombreYPaterno(String n, String p);

    List<Alumno> nnqBuscarAltoPromedio();

    List<Alumno> nnqBuscarAlumnoCalificacion(@Param("matricula") String matricula);


    @Query(
            value = "SELECT DISTINCT " +
                    " new mx.unam.dgtic.alumnocrud.model.AlumnoCalificacionDTO(a.nombreAlumno," +
                    "                                    a.paterno, c.materia, c.calificacion) " +
                    " FROM Alumno a, Calificacion c " +
                    " WHERE a.matricula = c.alumno.matricula"
    )
    List<AlumnoCalificacionDTO> findAlumnoCalificacionDto();
}
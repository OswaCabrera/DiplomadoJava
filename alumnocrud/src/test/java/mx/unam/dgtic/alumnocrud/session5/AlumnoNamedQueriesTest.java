package mx.unam.dgtic.alumnocrud.session5;

import mx.unam.dgtic.alumnocrud.infoTester;
import mx.unam.dgtic.alumnocrud.model.Alumno;
import mx.unam.dgtic.alumnocrud.model.Calificacion;
import mx.unam.dgtic.alumnocrud.repository.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
public class AlumnoNamedQueriesTest {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Test
    void buscarAltosTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar alumnos altos");
        alumnoRepository.buscarAltos().forEach(System.out::println);
    }

    @Test
    void buscarElGarrochaTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar el alumno más alto");
        System.out.println(alumnoRepository.buscarElGarrocha());
    }

    @Test
    void buscarEstaturaMaximaTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar la estatura máxima");
        System.out.println(alumnoRepository.buscarEstaturaMaxima());
    }

    @Test
    void buscarAltosConFechaTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar alumnos altos con fecha");
        alumnoRepository.buscarAltosConFecha(Date.valueOf("2001-01-15")).forEach(System.out::println);
    }

    @Test
    void buscarAltosConFechaDosTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar alumnos altos con fecha");
        alumnoRepository.buscarAltosConFechaDos(1.60, Date.valueOf("2001-01-15")).forEach(System.out::println);
    }

    @Test
    void buscarAltosConFechaTresTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar alumnos altos con fecha");
        alumnoRepository.buscarAltosConFechaTres(Date.valueOf("2001-01-15"), 1.60).forEach(System.out::println);
    }

    @Test
    void buscarAltosMayorPromedioTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar alumnos altos con fecha");
        alumnoRepository.buscarAltosMayorPromedio().forEach(System.out::println);
    }

    @Test
    void buscarEstaturaPromedioTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar la estatura promedio");
        System.out.println(alumnoRepository.buscarEstaturaPromedio());
    }

    @Test
    void buscarTodosPorPaternoTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar todos los alumnos por apellido paterno");
        alumnoRepository.buscarTodosConApellido("Perez").forEach(System.out::println);
    }

    @Test
    void buscarAlumnosConCalificacionesTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar todos los alumnos con calificaciones");
        List<Object[]> resultados = alumnoRepository.buscarAlumnosConCalificacionesAprobatoria("Nadia");
        //Cast the objects
        for (Object[] resultado : resultados) {
            if(resultado[0] instanceof Alumno && resultado[1] instanceof Calificacion){
                System.out.println((Alumno)resultado[0]);
                System.out.println((Calificacion)resultado[1]);
            }else
                System.out.println("Error en el tipo de objeto");

        }
    }

    @Test
    void nativosBuscarTodosTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar todos los alumnos con SQL nativo");
        alumnoRepository.nativosBuscarTodos().forEach(System.out::println);
    }

    @Test
    void nativaBuscarPorNombreYPaternoTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar todos los alumnos con SQL nativo");
        alumnoRepository.nativaBuscarPorNombreYPaterno("Nadia", "Perez").forEach(System.out::println);
    }

    @Test
    void nnqBuscarAltoPromedioTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar todos los alumnos con SQL nativo");
        alumnoRepository.nnqBuscarAltoPromedio().forEach(System.out::println);
    }

    @Test
    void buscarAlumnoCalificacionTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar todos los alumnos con SQL nativo");
        List<Alumno> res = alumnoRepository.nnqBuscarAlumnoCalificacion("2A");
        for (Alumno al: res){
            System.out.println(al);
            al.getCalificaciones().forEach(System.out::println);
        }
    }

    @Test
    void findAlumnoCalificacionDtoTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar calif con DTO");
        alumnoRepository.findAlumnoCalificacionDto().forEach(System.out::println);
    }
}

package mx.unam.dgtic.alumnocrud.sesion4;

import mx.unam.dgtic.alumnocrud.infoTester;
import mx.unam.dgtic.alumnocrud.model.Calificacion;
import mx.unam.dgtic.alumnocrud.repository.CalificacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ConsultaCalificacionesTest {

    @Autowired
    CalificacionRepository calificacionRepository;

    @Test
    void buscarCalificacionesByMateria(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar por POO");
        ArrayList<Calificacion> resultado = (ArrayList<Calificacion>) calificacionRepository.findByMateria("POO");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarCalificacionByCalificacionEquals(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar calificaciones igual a 8");
        ArrayList<Calificacion> resultado =
                (ArrayList<Calificacion>) calificacionRepository.findCalificacionByCalificacionEquals(8);
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarCalificacionByMatriculaEquals(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar calificaciones de 1A");
        ArrayList<Calificacion> resultado =
                (ArrayList<Calificacion>) calificacionRepository.findCalificacionByAlumnoMatricula("1A");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorPaternoTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar por paterno");
        ArrayList<Calificacion> cals = (ArrayList<Calificacion>) calificacionRepository.findCalificacionByAlumnoPaterno("Perez");
        cals.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreTest(){
        System.out.println("Buscar por nombre");
        ArrayList<Calificacion> cals = (ArrayList<Calificacion>) calificacionRepository.findCalificacionByAlumnoNombreAlumno("Carlos");
        cals.forEach(System.out::println);
    }

    @Test
    void buscarCalificacionByNombreYPaterno(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscar por nombre y paterno");
        ArrayList<Calificacion> cals = (ArrayList<Calificacion>) calificacionRepository. findCalificacionByAlumnoNombreAlumnoAndAlumnoPaterno("Perla", "Calles");
        cals.forEach(System.out::println);
    }
}

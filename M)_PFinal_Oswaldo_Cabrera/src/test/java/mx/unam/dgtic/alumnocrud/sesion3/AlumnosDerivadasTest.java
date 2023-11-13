package mx.unam.dgtic.alumnocrud.sesion3;

import mx.unam.dgtic.alumnocrud.repository.AlumnoRepository;
import mx.unam.dgtic.alumnocrud.infoTester;
import mx.unam.dgtic.alumnocrud.model.Alumno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;


@SpringBootTest
public class AlumnosDerivadasTest {

    @Autowired
    AlumnoRepository alumnoRepository;

     @Test
    void buscarAlumnosByNombre(){
         System.out.println(infoTester.NOMBRE);
         ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByNombreAlumno("Carlos");
         resultado.forEach(System.out::println);
     }

    @Test
    void buscarPorPaternoTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findByPaterno( "Perez");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorEstaturaTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findByEstatura(1.70);
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorFnacTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findByFnac(java.sql.Date.valueOf("2001-03-20"));
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreEqualsTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findByNombreAlumnoEquals("Carlos");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreNotTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByNombreAlumnoNot("Carlos");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorPaternoIsNullTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findByPaternoIsNull();
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorPaternoIsNotNullTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findByPaternoIsNotNull();
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreStartingWithTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByNombreAlumnoStartingWith("J");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreEndingWithTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByNombreAlumnoEndingWith("A");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreContainingTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByNombreAlumnoContaining("R");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreLikeTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByNombreAlumnoLike("__m%");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorEstaturaLessTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByEstaturaLessThan(1.60);
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorEstaturaLessEqualTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByEstaturaLessThanEqual(1.60);
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorEstaturaBetweenTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByEstaturaBetween(1.60, 1.75);
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorEstaturaInTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByEstaturaIn(java.util.List.of(1.60, 1.75));
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarLosNacidosDespuesTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByFnacAfter(java.sql.Date.valueOf("2001-01-01"));
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarLosNacidosAntesTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByFnacBefore(java.sql.Date.valueOf("2001-01-01"));
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreOrPaternoTest(){
        System.out.println(infoTester.NOMBRE);
        System.out.println("Buscando por nombre o paterno");
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByNombreAlumnoOrPaterno("Nadia", "Dominguez");
        resultado.forEach(System.out::println);
        System.out.println("Buscando por nombre y paterno");
        resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByNombreAlumnoAndPaterno("Nadia", "Dominguez");
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorEstaturaOrderByEstaturaTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByEstaturaOrderByEstatura(1.88);
        resultado.forEach(System.out::println);
    }

    @Test
    void buscarPorEstaturaOrderByFnacTest(){
        System.out.println(infoTester.NOMBRE);
        ArrayList<Alumno> resultado = (ArrayList<Alumno>) alumnoRepository.findAlumnoByEstaturaOrderByFnac(1.88);
        resultado.forEach(System.out::println);
    }

}
